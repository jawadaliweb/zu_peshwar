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

public final class DialogErrorBinding implements ViewBinding {
    public final LinearLayout BtnTripPlanner;
    public final MaterialButton btnOk;
    public final TextView msg;
    private final RelativeLayout rootView;

    private DialogErrorBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, MaterialButton materialButton, TextView textView) {
        this.rootView = relativeLayout;
        this.BtnTripPlanner = linearLayout;
        this.btnOk = materialButton;
        this.msg = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_error, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogErrorBinding bind(View view) {
        int i = R.id.Btn_TripPlanner;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.Btn_TripPlanner);
        if (linearLayout != null) {
            i = R.id.btn_ok;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.btn_ok);
            if (materialButton != null) {
                i = R.id.msg;
                TextView textView = (TextView) view.findViewById(R.id.msg);
                if (textView != null) {
                    return new DialogErrorBinding((RelativeLayout) view, linearLayout, materialButton, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
