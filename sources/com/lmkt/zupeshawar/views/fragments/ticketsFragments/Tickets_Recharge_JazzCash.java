package com.lmkt.zupeshawar.views.fragments.ticketsFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lmkt.zupeshawar.BuildConfig;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.EncryptionUtil;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.application.App;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.TopUpDetails;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.TicketsMenuItemActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class Tickets_Recharge_JazzCash extends Fragment implements View.OnClickListener, IOnBackPressed, APIManager.Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    EditText Amount_ET;
    Button Btn_Proceed;
    EditText Mobile_ET;
    EditText Name_ET;
    TicketsMenuItemActivity activity;
    EditText cnicET;
    private String sign;
    TopUpDetails topupDetails = new TopUpDetails();
    private User user;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_tickets_recharge_jazzcash, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            this.user = SharedPrefrencesUtil.getUserObject_Prefrences(App.getInstance().getApplicationContext());
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        EditText editText = (EditText) view.findViewById(R.id.Name_ET);
        this.Name_ET = editText;
        editText.setText(this.user.getName());
        EditText editText2 = (EditText) view.findViewById(R.id.Mobile_ET);
        this.Mobile_ET = editText2;
        editText2.setText(this.user.getMobileNumber());
        this.Amount_ET = (EditText) view.findViewById(R.id.ET_Amount);
        this.cnicET = (EditText) view.findViewById(R.id.ET_CNIC);
        Button button = (Button) view.findViewById(R.id.Btn_Proceed);
        this.Btn_Proceed = button;
        button.setOnClickListener(this);
    }

    private void initToolbar() {
        TicketsMenuItemActivity ticketsMenuItemActivity = (TicketsMenuItemActivity) getActivity();
        this.activity = ticketsMenuItemActivity;
        ticketsMenuItemActivity.mToolbar_Title.setText(R.string.title_JCtopup);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    private boolean validate() {
        if (this.Name_ET.getText().toString().isEmpty()) {
            ToastUtil.showToast(ToastUtil.ToastType.warning, "Please Enter your Name");
            return false;
        }
        String obj = this.Mobile_ET.getText().toString();
        if (obj.isEmpty()) {
            ToastUtil.showToast(ToastUtil.ToastType.warning_icon, "Please Enter Mobile Number");
            return false;
        } else if (!obj.matches("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$")) {
            ToastUtil.showToast(ToastUtil.ToastType.warning_icon, "Please Enter Valid Mobile Number");
            this.Mobile_ET.setText("");
            return false;
        } else if (this.Amount_ET.getText().toString().isEmpty()) {
            ToastUtil.showToast(ToastUtil.ToastType.warning, "Please Enter Amount");
            return false;
        } else if (this.cnicET.getText().toString().length() < 6) {
            ToastUtil.showToast(ToastUtil.ToastType.warning, "Please Enter Last 6 digit of CNIC");
            return false;
        } else {
            this.topupDetails.setMobileAccount(this.Mobile_ET.getText().toString());
            this.topupDetails.setAmount(this.Amount_ET.getText().toString());
            if (this.user.getEmail().isEmpty()) {
                this.topupDetails.setEmail("androiduser@transpeshawer.com");
            } else {
                this.topupDetails.setEmail(this.user.getEmail());
            }
            this.topupDetails.setPaymentSource(2);
            return true;
        }
    }

    private JSONObject createJsonRequest() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("MobileAccount", this.topupDetails.getMobileAccount());
            jSONObject2.put("Amount", this.topupDetails.getAmount());
            jSONObject2.put("PaymentSource", this.topupDetails.getPaymentSource());
            jSONObject2.put("Email", this.topupDetails.getEmail());
            jSONObject2.put("cnic", this.cnicET.getText().toString());
            this.sign = EncryptionUtil.calculateHMAC256(BuildConfig.APIKey, BuildConfig.AppID, this.topupDetails.toString());
            jSONObject.put("AppID", BuildConfig.AppID).put("Sign", this.sign).put("topupRequestBodyVM", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            this.activity.loadFragment(new Recharge(), 0);
        } else if (id == R.id.Btn_Proceed && validate()) {
            try {
                this.topupDetails.setCNIC(this.cnicET.getText().toString());
                JSONObject createJsonRequest = createJsonRequest();
                this.activity.appAlerts.showEasyPaisaDialog(this.activity, false);
                if (this.topupDetails.getAmount().length() < 5) {
                    APIManager.getInstance().addTopUp(this, (JsonObject) new JsonParser().parse(createJsonRequest.toString()), this.sign, getContext());
                    return;
                }
                ToastUtil.showToast(ToastUtil.ToastType.error, "Please Enter Amount in 4 Digits");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.OK()) {
            if (apiResponse.getRespCode().intValue() == ReturnCodes.Companion.BAD_REQUEST()) {
                this.activity.appAlerts.showAlertDialog(this.activity, apiResponse.getRespMessage(), "Server Message", new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        Tickets_Recharge_JazzCash.this.lambda$onSuccess$0$Tickets_Recharge_JazzCash();
                    }
                });
            } else if (apiResponse.getData() != null) {
                SharedPrefrencesUtil.updateUserBalance(this.activity, apiResponse.getData().getTopUpDetails().getUpdatedbalance());
                this.activity.appAlerts.showSuccessDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        Tickets_Recharge_JazzCash.this.lambda$onSuccess$1$Tickets_Recharge_JazzCash();
                    }
                });
            } else {
                this.activity.appAlerts.showSuccessDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        Tickets_Recharge_JazzCash.this.lambda$onSuccess$2$Tickets_Recharge_JazzCash();
                    }
                });
            }
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, apiResponse.getRespMessage());
        } else if (i == ReturnCodes.Companion.BAD_REQUEST()) {
            this.activity.appAlerts.showAlertDialog(this.activity, apiResponse.getRespMessage(), "Server Message", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    Tickets_Recharge_JazzCash.this.lambda$onSuccess$3$Tickets_Recharge_JazzCash();
                }
            });
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    Tickets_Recharge_JazzCash.this.lambda$onSuccess$4$Tickets_Recharge_JazzCash();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSuccess$0$Tickets_Recharge_JazzCash() {
        this.activity.appAlerts.dismiss();
    }

    public /* synthetic */ void lambda$onSuccess$1$Tickets_Recharge_JazzCash() {
        this.activity.appAlerts.dismiss();
        this.activity.finish();
    }

    public /* synthetic */ void lambda$onSuccess$2$Tickets_Recharge_JazzCash() {
        this.activity.appAlerts.dismiss();
        this.activity.finish();
    }

    public /* synthetic */ void lambda$onSuccess$3$Tickets_Recharge_JazzCash() {
        this.activity.appAlerts.dismiss();
    }

    public /* synthetic */ void lambda$onSuccess$4$Tickets_Recharge_JazzCash() {
        this.activity.appAlerts.dismiss();
    }

    public void onFailure(int i, String str) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, str);
        } else if (i == ReturnCodes.Companion.BAD_REQUEST()) {
            AppAlertDialog appAlertDialog = this.activity.appAlerts;
            TicketsMenuItemActivity ticketsMenuItemActivity = this.activity;
            appAlertDialog.showAlertDialog(ticketsMenuItemActivity, str + "\n Recharge between Rs.50 to Rs.5000", "Server Message", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    Tickets_Recharge_JazzCash.this.lambda$onFailure$5$Tickets_Recharge_JazzCash();
                }
            });
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    Tickets_Recharge_JazzCash.this.lambda$onFailure$6$Tickets_Recharge_JazzCash();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onFailure$5$Tickets_Recharge_JazzCash() {
        this.activity.appAlerts.dismiss();
    }

    public /* synthetic */ void lambda$onFailure$6$Tickets_Recharge_JazzCash() {
        this.activity.appAlerts.dismiss();
    }

    public boolean onBackPressed() {
        this.activity.loadFragment(new Recharge(), 0);
        return true;
    }
}
