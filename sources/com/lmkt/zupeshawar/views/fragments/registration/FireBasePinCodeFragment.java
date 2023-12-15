package com.lmkt.zupeshawar.views.fragments.registration;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.BaseActivity;
import com.lmkt.zupeshawar.views.activities.RegistrationActivity;
import com.mukesh.OtpView;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class FireBasePinCodeFragment extends Fragment implements View.OnClickListener, IOnBackPressed {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "FB_PhoneAuth";
    String DisplayMobileNumber;
    String MobileNumber;
    private TextView MobileNumberTv;
    /* access modifiers changed from: private */
    public TextView ResendCodeBtn;
    String VerificationCode;
    CountDownTimer cTimer = null;
    /* access modifiers changed from: private */
    public TextView counterTimer;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            Log.d(FireBasePinCodeFragment.TAG, "onVerificationCompleted:" + phoneAuthCredential);
            FireBasePinCodeFragment.this.otpView.setText("******");
            FireBasePinCodeFragment.this.parentActivity.showDialog();
            ToastUtil.showToast(ToastUtil.ToastType.success, "OTP Auto-retrieval Successful");
            try {
                FireBasePinCodeFragment.this.makeApiCall();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onVerificationFailed(FirebaseException firebaseException) {
            Log.w(FireBasePinCodeFragment.TAG, "onVerificationFailed", firebaseException);
            if (firebaseException instanceof FirebaseAuthInvalidCredentialsException) {
                ToastUtil.showToast(ToastUtil.ToastType.error, "Invalid OTP Code.");
            } else if (firebaseException instanceof FirebaseTooManyRequestsException) {
                ToastUtil.showToast(ToastUtil.ToastType.error, "OTP Quota exceeded.");
            } else {
                ToastUtil.ToastType toastType = ToastUtil.ToastType.error;
                ToastUtil.showToast(toastType, "Unable to send OTP\nPlease check your network connection\n" + firebaseException.getLocalizedMessage());
            }
        }

        public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            Log.d(FireBasePinCodeFragment.TAG, "onCodeSent:" + str);
            ToastUtil.showToast(ToastUtil.ToastType.error, "Code Sent");
            String unused = FireBasePinCodeFragment.this.mVerificationId = str;
            PhoneAuthProvider.ForceResendingToken unused2 = FireBasePinCodeFragment.this.mResendToken = forceResendingToken;
        }
    };
    /* access modifiers changed from: private */
    public PhoneAuthProvider.ForceResendingToken mResendToken;
    /* access modifiers changed from: private */
    public String mVerificationId;
    /* access modifiers changed from: private */
    public OtpView otpView;
    RegistrationActivity parentActivity;
    private Button proceedBtn;
    View rootView;
    /* access modifiers changed from: private */
    public String verificationCode = "";

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_pincode_verification, viewGroup, false);
        this.rootView = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(this.rootView);
    }

    private void initView(View view) {
        RegistrationActivity registrationActivity = (RegistrationActivity) getActivity();
        this.parentActivity = registrationActivity;
        registrationActivity.setToolBar("Verification");
        this.mAuth = FirebaseAuth.getInstance();
        this.MobileNumberTv = (TextView) view.findViewById(R.id.TV_MobileNumber);
        this.counterTimer = (TextView) view.findViewById(R.id.tvTimer);
        this.otpView = (OtpView) view.findViewById(R.id.otp_view);
        Button button = (Button) view.findViewById(R.id.proceed_btn);
        this.proceedBtn = button;
        button.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.Btn_ResendCode);
        this.ResendCodeBtn = textView;
        textView.setOnClickListener(this);
        startTimer();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.DisplayMobileNumber = arguments.getString("MobileNumber");
            this.MobileNumber = arguments.getString("MobileNumber");
            this.VerificationCode = arguments.getString("VerificationCode");
        }
        this.MobileNumberTv.setText(formatMobileNumber(this.DisplayMobileNumber));
        this.MobileNumber = "+92" + this.MobileNumber.substring(1);
        if (BaseActivity.otpService == 1) {
            startPhoneNumberVerification(this.MobileNumber);
        } else {
            sendOTP();
        }
        this.otpView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (FireBasePinCodeFragment.this.otpView.getText().toString().length() == FireBasePinCodeFragment.this.otpView.getItemCount()) {
                    FireBasePinCodeFragment.hideKeyboard(FireBasePinCodeFragment.this.parentActivity);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void startTimer() {
        AnonymousClass2 r0 = new CountDownTimer(30000, 1000) {
            public void onTick(long j) {
                FireBasePinCodeFragment.this.ResendCodeBtn.setTextColor(Color.parseColor("#808080"));
                FireBasePinCodeFragment.this.ResendCodeBtn.setClickable(false);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
                if (seconds < 10) {
                    TextView access$200 = FireBasePinCodeFragment.this.counterTimer;
                    access$200.setText("Retry in 00:0" + String.valueOf(seconds));
                    return;
                }
                TextView access$2002 = FireBasePinCodeFragment.this.counterTimer;
                access$2002.setText("Retry in 00:" + String.valueOf(seconds));
            }

            public void onFinish() {
                FireBasePinCodeFragment.this.counterTimer.setVisibility(8);
                FireBasePinCodeFragment.this.ResendCodeBtn.setClickable(true);
                FireBasePinCodeFragment.this.ResendCodeBtn.setTextColor(Color.parseColor("#00A550"));
            }
        };
        this.cTimer = r0;
        r0.start();
    }

    /* access modifiers changed from: package-private */
    public void cancelTimer() {
        CountDownTimer countDownTimer = this.cTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void sendOTP() {
        startTimer();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mobileNo", this.MobileNumber.replace("+", ""));
            APIManager.getInstance().sendOTP(new APIManager.Callback() {
                public void onSuccess(int i, ApiResponse apiResponse) {
                    if (apiResponse.getData() != null) {
                        String unused = FireBasePinCodeFragment.this.verificationCode = apiResponse.getData().getVerificationCode();
                    }
                    if (apiResponse.getRespMessage().equals("OTP Quota exceeded")) {
                        FireBasePinCodeFragment.this.cancelTimer();
                        FireBasePinCodeFragment.this.counterTimer.setVisibility(8);
                        FireBasePinCodeFragment.this.ResendCodeBtn.setTextColor(Color.parseColor("#808080"));
                        FireBasePinCodeFragment.this.ResendCodeBtn.setClickable(false);
                    }
                    ToastUtil.showToast(ToastUtil.ToastType.error, apiResponse.getRespMessage());
                }

                public void onFailure(int i, String str) {
                    ToastUtil.showToast(ToastUtil.ToastType.error, "Failed");
                }
            }, "getOtpNew", (JsonObject) new JsonParser().parse(jSONObject.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String formatMobileNumber(String str) {
        return "+92 " + str.substring(1);
    }

    private void startPhoneNumberVerification(String str) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(str, 60, TimeUnit.SECONDS, requireActivity(), this.mCallbacks);
    }

    private void resendVerificationCode(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(str, 60, TimeUnit.SECONDS, this.parentActivity, this.mCallbacks, forceResendingToken);
    }

    private void verifyPhoneNumberWithCode(String str, String str2) {
        signInWithPhoneAuthCredential(PhoneAuthProvider.getCredential(str, str2));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.Btn_ResendCode) {
            if (id == R.id.proceed_btn) {
                String obj = this.otpView.getText().toString();
                if (obj.length() < 6) {
                    ToastUtil.showToast(ToastUtil.ToastType.error, "Incomplete Code");
                    this.otpView.setText("");
                    return;
                }
                try {
                    this.parentActivity.showDialog();
                    if (BaseActivity.otpService == 1) {
                        verifyPhoneNumberWithCode(this.mVerificationId, obj);
                    } else if (this.verificationCode.equals(obj)) {
                        makeApiCall();
                    } else {
                        this.parentActivity.hideDialog();
                        ToastUtil.showToast(ToastUtil.ToastType.error, "Invalid Code");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    this.parentActivity.hideDialog();
                    RegistrationActivity registrationActivity = this.parentActivity;
                    registrationActivity.showErrorDialog("Error while Verifing OTP \n" + e);
                }
            }
        } else if (BaseActivity.otpService == 1) {
            resendVerificationCode(this.MobileNumber, this.mResendToken);
        } else {
            sendOTP();
            this.counterTimer.setVisibility(0);
            this.ResendCodeBtn.setClickable(false);
        }
    }

    /* access modifiers changed from: private */
    public void makeApiCall() throws Exception {
        APIManager.getInstance().getUser(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                FireBasePinCodeFragment.this.parentActivity.hideDialog();
                if (i == ReturnCodes.Companion.OK()) {
                    int userStatus = apiResponse.getData().getUserStatus();
                    User user = apiResponse.getData().getUser();
                    Bundle bundle = new Bundle();
                    bundle.putString("Mobilenumber", FireBasePinCodeFragment.this.DisplayMobileNumber);
                    bundle.putSerializable("user", user);
                    bundle.putInt("userStatus", userStatus);
                    RegistrationFragment registrationFragment = new RegistrationFragment();
                    registrationFragment.setArguments(bundle);
                    FireBasePinCodeFragment.this.parentActivity.loadFragment(registrationFragment, false);
                    return;
                }
                FireBasePinCodeFragment.this.parentActivity.showErrorDialog(apiResponse.getRespMessage());
            }

            public void onFailure(int i, String str) {
                FireBasePinCodeFragment.this.parentActivity.showErrorDialog(str);
            }
        }, this.DisplayMobileNumber);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        this.mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener((Activity) requireActivity(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                FireBasePinCodeFragment.this.lambda$signInWithPhoneAuthCredential$0$FireBasePinCodeFragment(task);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithPhoneAuthCredential$0$FireBasePinCodeFragment(Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "signInWithCredential:success");
            ToastUtil.showToast(ToastUtil.ToastType.success, "OTP Verified Successfully");
            try {
                makeApiCall();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.parentActivity.hideDialog();
            Log.w(TAG, "signInWithCredential:failure", task.getException());
            ToastUtil.showToast(ToastUtil.ToastType.error, "Invalid Code");
        }
    }
}
