package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragNaviSettingBinding implements ViewBinding {
    public final SwitchCompat changeLanSW;
    public final MaterialButton logoutBtn;
    public final SwitchCompat notificationSwitch;
    public final MaterialButton privacyPolicy;
    private final RelativeLayout rootView;
    public final TextView termsAndCondition;
    public final MaterialButton termsAndConditionBtm;
    public final TextView title;

    private FragNaviSettingBinding(RelativeLayout relativeLayout, SwitchCompat switchCompat, MaterialButton materialButton, SwitchCompat switchCompat2, MaterialButton materialButton2, TextView textView, MaterialButton materialButton3, TextView textView2) {
        this.rootView = relativeLayout;
        this.changeLanSW = switchCompat;
        this.logoutBtn = materialButton;
        this.notificationSwitch = switchCompat2;
        this.privacyPolicy = materialButton2;
        this.termsAndCondition = textView;
        this.termsAndConditionBtm = materialButton3;
        this.title = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragNaviSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragNaviSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragNaviSettingBinding bind(View view) {
        int i = R.id.changeLan_SW;
        SwitchCompat switchCompat = (SwitchCompat) view.findViewById(R.id.changeLan_SW);
        if (switchCompat != null) {
            i = R.id.logout_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.logout_btn);
            if (materialButton != null) {
                i = R.id.notificationSwitch;
                SwitchCompat switchCompat2 = (SwitchCompat) view.findViewById(R.id.notificationSwitch);
                if (switchCompat2 != null) {
                    i = R.id.privacyPolicy;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.privacyPolicy);
                    if (materialButton2 != null) {
                        i = R.id.termsAndCondition;
                        TextView textView = (TextView) view.findViewById(R.id.termsAndCondition);
                        if (textView != null) {
                            i = R.id.termsAndConditionBtm;
                            MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.termsAndConditionBtm);
                            if (materialButton3 != null) {
                                i = R.id.title;
                                TextView textView2 = (TextView) view.findViewById(R.id.title);
                                if (textView2 != null) {
                                    return new FragNaviSettingBinding((RelativeLayout) view, switchCompat, materialButton, switchCompat2, materialButton2, textView, materialButton3, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
