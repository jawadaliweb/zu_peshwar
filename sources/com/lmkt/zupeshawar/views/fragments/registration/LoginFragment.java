package com.lmkt.zupeshawar.views.fragments.registration;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.HandyUtils;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.RegistrationActivity;

public class LoginFragment extends Fragment implements IOnBackPressed, View.OnClickListener {
    String MobileNumber;
    MaskedEditText MobileNumberET;
    ImageView logoIV;
    RegistrationActivity parentActivity;
    Button proceedBtn;
    View rootView;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_login, viewGroup, false);
        this.rootView = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RegistrationActivity registrationActivity = (RegistrationActivity) requireActivity();
        this.parentActivity = registrationActivity;
        registrationActivity.hideToolBar();
        initView(this.rootView);
    }

    private void initView(View view) {
        requireActivity().overridePendingTransition(0, 0);
        view.findViewById(R.id.login_container).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.translate_scale));
        this.logoIV = (ImageView) view.findViewById(R.id.logoIV);
        Button button = (Button) view.findViewById(R.id.proceed_btn);
        this.proceedBtn = button;
        button.setOnClickListener(this);
        MaskedEditText maskedEditText = (MaskedEditText) view.findViewById(R.id.ET_MobileNumber);
        this.MobileNumberET = maskedEditText;
        maskedEditText.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        ((TextView) view.findViewById(R.id.disclaimer_TV)).setText(Html.fromHtml(getResources().getString(R.string.label_disclaimer)));
        this.MobileNumberET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return LoginFragment.this.lambda$initView$0$LoginFragment(textView, i, keyEvent);
            }
        });
        this.MobileNumberET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (LoginFragment.this.MobileNumberET.getRawText().length() >= 11) {
                    HandyUtils.hideKeyboardFrom(LoginFragment.this.requireContext(), LoginFragment.this.MobileNumberET);
                }
            }
        });
        AppUpdateManagerFactory.create(getContext());
    }

    public /* synthetic */ boolean lambda$initView$0$LoginFragment(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        HandyUtils.hideKeyboardFrom(requireContext(), this.MobileNumberET);
        return false;
    }

    private void navigateFirebaseVerification(String str) {
        if (this.parentActivity.isNetworkAvailable(requireContext())) {
            Bundle bundle = new Bundle();
            bundle.putString("MobileNumber", str);
            bundle.putString("VerificationCode", "");
            FireBasePinCodeFragment fireBasePinCodeFragment = new FireBasePinCodeFragment();
            fireBasePinCodeFragment.setArguments(bundle);
            this.parentActivity.loadFragment(fireBasePinCodeFragment, false);
            return;
        }
        this.parentActivity.showAlertDialog(getResources().getString(R.string.oflinevalue));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.proceed_btn) {
            HandyUtils.hideKeyboardFrom(requireContext(), this.proceedBtn);
            String rawText = this.MobileNumberET.getRawText();
            this.MobileNumber = rawText;
            if (rawText.isEmpty()) {
                ToastUtil.showToast(ToastUtil.ToastType.warning_icon, "Please Enter Mobile Number");
            } else if (!this.MobileNumber.matches("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$")) {
                ToastUtil.showToast(ToastUtil.ToastType.warning_icon, "Please Enter Valid Mobile Number");
                this.MobileNumberET.setText("");
            } else {
                navigateFirebaseVerification(this.MobileNumber);
            }
        }
    }
}
