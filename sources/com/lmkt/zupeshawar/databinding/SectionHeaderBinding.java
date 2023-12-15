package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class SectionHeaderBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView sectionHeader;

    private SectionHeaderBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.sectionHeader = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SectionHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SectionHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.section_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SectionHeaderBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.section_header);
        if (textView != null) {
            return new SectionHeaderBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.section_header)));
    }
}
