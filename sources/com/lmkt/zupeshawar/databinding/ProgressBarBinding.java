package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.github.ybq.android.spinkit.SpinKitView;
import com.lmkt.zupeshawar.R;

public final class ProgressBarBinding implements ViewBinding {
    public final SpinKitView idPbar;
    public final TextView idTitle;
    private final RelativeLayout rootView;

    private ProgressBarBinding(RelativeLayout relativeLayout, SpinKitView spinKitView, TextView textView) {
        this.rootView = relativeLayout;
        this.idPbar = spinKitView;
        this.idTitle = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ProgressBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ProgressBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.progress_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ProgressBarBinding bind(View view) {
        int i = R.id.id_pbar;
        SpinKitView spinKitView = (SpinKitView) view.findViewById(R.id.id_pbar);
        if (spinKitView != null) {
            i = R.id.id_title;
            TextView textView = (TextView) view.findViewById(R.id.id_title);
            if (textView != null) {
                return new ProgressBarBinding((RelativeLayout) view, spinKitView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
