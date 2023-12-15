package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class DialogLogoutBinding implements ViewBinding {
    public final MaterialButton BtnNo;
    public final LinearLayout BtnTripPlanner;
    public final MaterialButton BtnYes;
    public final TextView headertext;
    public final TextView msg;
    private final RelativeLayout rootView;

    private DialogLogoutBinding(RelativeLayout relativeLayout, MaterialButton materialButton, LinearLayout linearLayout, MaterialButton materialButton2, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.BtnNo = materialButton;
        this.BtnTripPlanner = linearLayout;
        this.BtnYes = materialButton2;
        this.headertext = textView;
        this.msg = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogLogoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogLogoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_logout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogLogoutBinding bind(View view) {
        int i = R.id.Btn_No;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_No);
        if (materialButton != null) {
            i = R.id.Btn_TripPlanner;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.Btn_TripPlanner);
            if (linearLayout != null) {
                i = R.id.Btn_Yes;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.Btn_Yes);
                if (materialButton2 != null) {
                    i = R.id.headertext;
                    TextView textView = (TextView) view.findViewById(R.id.headertext);
                    if (textView != null) {
                        i = R.id.msg;
                        TextView textView2 = (TextView) view.findViewById(R.id.msg);
                        if (textView2 != null) {
                            return new DialogLogoutBinding((RelativeLayout) view, materialButton, linearLayout, materialButton2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
