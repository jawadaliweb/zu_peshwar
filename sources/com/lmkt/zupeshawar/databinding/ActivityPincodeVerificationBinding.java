package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.mukesh.OtpView;

public final class ActivityPincodeVerificationBinding implements ViewBinding {
    public final TextView BtnResendCode;
    public final TextView TVMobileNumber;
    public final TextView btnTimer;
    public final OtpView otpView;
    public final MaterialButton proceedBtn;
    private final LinearLayout rootView;
    public final TextView tvTimer;

    private ActivityPincodeVerificationBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, OtpView otpView2, MaterialButton materialButton, TextView textView4) {
        this.rootView = linearLayout;
        this.BtnResendCode = textView;
        this.TVMobileNumber = textView2;
        this.btnTimer = textView3;
        this.otpView = otpView2;
        this.proceedBtn = materialButton;
        this.tvTimer = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPincodeVerificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPincodeVerificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_pincode_verification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPincodeVerificationBinding bind(View view) {
        int i = R.id.Btn_ResendCode;
        TextView textView = (TextView) view.findViewById(R.id.Btn_ResendCode);
        if (textView != null) {
            i = R.id.TV_MobileNumber;
            TextView textView2 = (TextView) view.findViewById(R.id.TV_MobileNumber);
            if (textView2 != null) {
                i = R.id.btn_timer;
                TextView textView3 = (TextView) view.findViewById(R.id.btn_timer);
                if (textView3 != null) {
                    i = R.id.otp_view;
                    OtpView otpView2 = (OtpView) view.findViewById(R.id.otp_view);
                    if (otpView2 != null) {
                        i = R.id.proceed_btn;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.proceed_btn);
                        if (materialButton != null) {
                            i = R.id.tvTimer;
                            TextView textView4 = (TextView) view.findViewById(R.id.tvTimer);
                            if (textView4 != null) {
                                return new ActivityPincodeVerificationBinding((LinearLayout) view, textView, textView2, textView3, otpView2, materialButton, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
