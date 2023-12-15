package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.Constants;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.BaseActivity;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.SecurityDeposit;
import java.util.Objects;

public class SecurityDeposit extends Fragment implements View.OnClickListener, IOnBackPressed {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int Title = 2131886445;
    MaterialButton Btn_Proceed;
    BicycleMenuItem activity;
    CheckBox agreeTerms;
    RelativeLayout alreadySubscription;
    TextView deposit_detail;
    RelativeLayout noSubscription;
    TextView priceTv;
    MaterialButton refundDeposit;
    TextView subscriptionDateTV;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_bicycle_secuirty, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    public void getRefundPolicy() {
        APIManager.getInstance().getDepositedSecurityStatus(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                if (i == ReturnCodes.Companion.OK()) {
                    SecurityDeposit.this.noSubscription.setVisibility(8);
                    SecurityDeposit.this.alreadySubscription.setVisibility(0);
                    SecurityDeposit.this.subscriptionDateTV.setText(apiResponse.getData().getDepositDate());
                    TextView textView = SecurityDeposit.this.priceTv;
                    textView.setText("RS. " + apiResponse.getData().getSubscriptionAmount());
                } else if (i == ReturnCodes.Companion.BAD_REQUEST()) {
                    SecurityDeposit.this.noSubscription.setVisibility(0);
                    SecurityDeposit.this.alreadySubscription.setVisibility(8);
                    SecurityDeposit.this.getStaticContent();
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    SecurityDeposit.this.activity.appAlerts.showErrorAndLogout(SecurityDeposit.this.activity, apiResponse.getRespMessage());
                } else {
                    SecurityDeposit.this.activity.appAlerts.showErrorDialog(SecurityDeposit.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass1.this.lambda$onSuccess$0$SecurityDeposit$1();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$SecurityDeposit$1() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    SecurityDeposit.this.activity.appAlerts.showErrorAndLogout(SecurityDeposit.this.activity.getParent(), str);
                } else {
                    SecurityDeposit.this.activity.appAlerts.showErrorDialog(SecurityDeposit.this.requireContext(), str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass1.this.lambda$onFailure$1$SecurityDeposit$1();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$1$SecurityDeposit$1() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }
        }, getContext());
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.Btn_Proceed = (MaterialButton) view.findViewById(R.id.Btn_Proceed);
        this.refundDeposit = (MaterialButton) view.findViewById(R.id.cancel_action);
        TextView textView = (TextView) view.findViewById(R.id.priceTv);
        this.priceTv = textView;
        textView.setText("Rs. " + BaseActivity.bbsSecurity);
        this.subscriptionDateTV = (TextView) view.findViewById(R.id.subscriptionDateTV);
        this.alreadySubscription = (RelativeLayout) view.findViewById(R.id.alreadySubscription);
        this.deposit_detail = (TextView) view.findViewById(R.id.desposit_detail);
        this.noSubscription = (RelativeLayout) view.findViewById(R.id.noSubscription);
        this.agreeTerms = (CheckBox) view.findViewById(R.id.agreeTerms);
        this.Btn_Proceed.setOnClickListener(this);
        this.refundDeposit.setOnClickListener(this);
        this.agreeTerms.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SecurityDeposit.this.isChecked(view);
            }
        });
        this.deposit_detail.setText(Html.fromHtml(getString(R.string.txt_dummy_long)));
        getRefundPolicy();
    }

    public void isChecked(View view) {
        this.Btn_Proceed.setEnabled(this.agreeTerms.isChecked());
    }

    private void initToolbar() {
        BicycleMenuItem bicycleMenuItem = (BicycleMenuItem) getActivity();
        this.activity = bicycleMenuItem;
        bicycleMenuItem.mToolbar_Title.setText(Title);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void showAlertDialog(Context context, String str, String str2, boolean z) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_logout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.headertext)).setText(str2);
        ((TextView) inflate.findViewById(R.id.msg)).setText(str);
        Dialog dialog = new Dialog(context, R.style.dialogTheme);
        dialog.setContentView(inflate);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        ((MaterialButton) inflate.findViewById(R.id.Btn_Yes)).setOnClickListener(new View.OnClickListener(dialog, z) {
            public final /* synthetic */ Dialog f$1;
            public final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                SecurityDeposit.this.lambda$showAlertDialog$1$SecurityDeposit(this.f$1, this.f$2, view);
            }
        });
        ((MaterialButton) inflate.findViewById(R.id.Btn_No)).setOnClickListener(new View.OnClickListener(dialog) {
            public final /* synthetic */ Dialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$showAlertDialog$1$SecurityDeposit(Dialog dialog, boolean z, View view) {
        dialog.dismiss();
        this.activity.appAlerts.dismiss();
        if (z) {
            refundAPI();
        } else if (Integer.parseInt(SharedPrefrencesUtil.getUserObject_Prefrences(requireContext()).getAccountBalance()) > BaseActivity.bbsSecurity) {
            depositAPI();
        } else {
            AppAlertDialog appAlertDialog = this.activity.appAlerts;
            Context context = getContext();
            appAlertDialog.showAlertDialog(context, "You have insufficient balance in your account. Make sure you have more than Rs. " + BaseActivity.bbsSecurity + " in your wallet.", "Info", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    SecurityDeposit.this.lambda$showAlertDialog$0$SecurityDeposit();
                }
            });
        }
    }

    public /* synthetic */ void lambda$showAlertDialog$0$SecurityDeposit() {
        this.activity.appAlerts.dismiss();
    }

    /* access modifiers changed from: package-private */
    public void getStaticContent() {
        APIManager.getInstance().getHTMLStaticContent(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                if (i == ReturnCodes.Companion.OK()) {
                    SecurityDeposit.this.activity.appAlerts.showHtml(SecurityDeposit.this.requireContext(), Html.fromHtml(apiResponse.getData().getData()).toString(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass2.this.lambda$onSuccess$0$SecurityDeposit$2();
                        }
                    });
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    SecurityDeposit.this.activity.appAlerts.showErrorAndLogout(SecurityDeposit.this.activity, apiResponse.getRespMessage());
                } else {
                    SecurityDeposit.this.activity.appAlerts.showErrorDialog(SecurityDeposit.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass2.this.lambda$onSuccess$1$SecurityDeposit$2();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$SecurityDeposit$2() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }

            public /* synthetic */ void lambda$onSuccess$1$SecurityDeposit$2() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    SecurityDeposit.this.activity.appAlerts.showErrorAndLogout(SecurityDeposit.this.activity, str);
                } else {
                    SecurityDeposit.this.activity.appAlerts.showErrorDialog(SecurityDeposit.this.activity, str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass2.this.lambda$onFailure$2$SecurityDeposit$2();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$2$SecurityDeposit$2() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }
        }, Constants.BSS_ACTIVATION, getContext());
    }

    private void depositAPI() {
        this.activity.appAlerts.showPleaseWait(getContext());
        APIManager.getInstance().depositSecurity(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                if (i == ReturnCodes.Companion.OK()) {
                    if (apiResponse.getData().getMemberShipVerifiedStatus()) {
                        SecurityDeposit.this.activity.appAlerts.showSuccessDialog(SecurityDeposit.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                            public final void onClicked() {
                                SecurityDeposit.AnonymousClass3.this.lambda$onSuccess$0$SecurityDeposit$3();
                            }
                        });
                        SecurityDeposit.this.getRefundPolicy();
                    } else if (!apiResponse.getData().getMemberShipVerifiedStatus()) {
                        SecurityDeposit.this.getStaticContent();
                    }
                } else if (i == ReturnCodes.Companion.BAD_REQUEST()) {
                    SecurityDeposit.this.noSubscription.setVisibility(0);
                    SecurityDeposit.this.alreadySubscription.setVisibility(8);
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    SecurityDeposit.this.activity.appAlerts.showErrorAndLogout(SecurityDeposit.this.activity, apiResponse.getRespMessage());
                } else {
                    SecurityDeposit.this.activity.appAlerts.showErrorDialog(SecurityDeposit.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass3.this.lambda$onSuccess$1$SecurityDeposit$3();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$SecurityDeposit$3() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }

            public /* synthetic */ void lambda$onSuccess$1$SecurityDeposit$3() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    SecurityDeposit.this.activity.appAlerts.showErrorAndLogout(SecurityDeposit.this.activity.getParent(), str);
                } else {
                    SecurityDeposit.this.activity.appAlerts.showErrorDialog(SecurityDeposit.this.requireContext(), str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass3.this.lambda$onFailure$2$SecurityDeposit$3();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$2$SecurityDeposit$3() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }
        }, getContext());
    }

    private void refundAPI() {
        this.activity.appAlerts.showPleaseWait(getContext());
        APIManager.getInstance().refundSecurity(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                SecurityDeposit.this.activity.appAlerts.dismiss();
                if (i == ReturnCodes.Companion.OK()) {
                    SecurityDeposit.this.activity.appAlerts.showSuccessDialog(SecurityDeposit.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass4.this.lambda$onSuccess$0$SecurityDeposit$4();
                        }
                    });
                    SecurityDeposit.this.getRefundPolicy();
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    SecurityDeposit.this.activity.appAlerts.showErrorAndLogout(SecurityDeposit.this.activity, apiResponse.getRespMessage());
                } else {
                    SecurityDeposit.this.activity.appAlerts.showErrorDialog(SecurityDeposit.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass4.this.lambda$onSuccess$1$SecurityDeposit$4();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$SecurityDeposit$4() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }

            public /* synthetic */ void lambda$onSuccess$1$SecurityDeposit$4() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    SecurityDeposit.this.activity.appAlerts.showErrorAndLogout(SecurityDeposit.this.activity.getParent(), str);
                } else {
                    SecurityDeposit.this.activity.appAlerts.showErrorDialog(SecurityDeposit.this.requireContext(), str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            SecurityDeposit.AnonymousClass4.this.lambda$onFailure$2$SecurityDeposit$4();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$2$SecurityDeposit$4() {
                SecurityDeposit.this.activity.appAlerts.dismiss();
            }
        }, getContext());
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        } else if (id == R.id.Btn_Proceed) {
            if (this.agreeTerms.isChecked()) {
                Context requireContext = requireContext();
                showAlertDialog(requireContext, "Are you sure to deposit Rs. " + BaseActivity.bbsSecurity + "/- as security?", "Alert", false);
                return;
            }
            ToastUtil.showToast(ToastUtil.ToastType.warning_icon, "Agree with terms and conditions to proceed");
        } else if (id == R.id.cancel_action) {
            showAlertDialog(requireContext(), "Are you sure to refund your security?", "Alert", true);
        }
    }
}
