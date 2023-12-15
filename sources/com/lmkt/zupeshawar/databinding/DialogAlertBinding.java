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

public final class DialogAlertBinding implements ViewBinding {
    public final LinearLayout BtnTripPlanner;
    public final MaterialButton btnOk;
    public final TextView headertext;
    public final TextView msg;
    private final RelativeLayout rootView;

    private DialogAlertBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, MaterialButton materialButton, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.BtnTripPlanner = linearLayout;
        this.btnOk = materialButton;
        this.headertext = textView;
        this.msg = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogAlertBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogAlertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_alert, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogAlertBinding bind(View view) {
        int i = R.id.Btn_TripPlanner;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.Btn_TripPlanner);
        if (linearLayout != null) {
            i = R.id.btn_ok;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.btn_ok);
            if (materialButton != null) {
                i = R.id.headertext;
                TextView textView = (TextView) view.findViewById(R.id.headertext);
                if (textView != null) {
                    i = R.id.msg;
                    TextView textView2 = (TextView) view.findViewById(R.id.msg);
                    if (textView2 != null) {
                        return new DialogAlertBinding((RelativeLayout) view, linearLayout, materialButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
