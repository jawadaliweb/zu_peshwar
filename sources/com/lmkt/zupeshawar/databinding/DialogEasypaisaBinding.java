package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class DialogEasypaisaBinding implements ViewBinding {
    public final TextView instruct;
    public final TextView labelInst;
    public final TextView labelPoint;
    private final RelativeLayout rootView;

    private DialogEasypaisaBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.instruct = textView;
        this.labelInst = textView2;
        this.labelPoint = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogEasypaisaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogEasypaisaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_easypaisa, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogEasypaisaBinding bind(View view) {
        int i = R.id.instruct;
        TextView textView = (TextView) view.findViewById(R.id.instruct);
        if (textView != null) {
            i = R.id.labelInst;
            TextView textView2 = (TextView) view.findViewById(R.id.labelInst);
            if (textView2 != null) {
                i = R.id.label_point;
                TextView textView3 = (TextView) view.findViewById(R.id.label_point);
                if (textView3 != null) {
                    return new DialogEasypaisaBinding((RelativeLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
