package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import com.ortiz.touchview.TouchImageView;

public final class RowItemServiceHoursBinding implements ViewBinding {
    public final TouchImageView images;
    public final TextView noRecordFound;
    private final RelativeLayout rootView;

    private RowItemServiceHoursBinding(RelativeLayout relativeLayout, TouchImageView touchImageView, TextView textView) {
        this.rootView = relativeLayout;
        this.images = touchImageView;
        this.noRecordFound = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RowItemServiceHoursBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowItemServiceHoursBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_item_service_hours, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowItemServiceHoursBinding bind(View view) {
        int i = R.id.images;
        TouchImageView touchImageView = (TouchImageView) view.findViewById(R.id.images);
        if (touchImageView != null) {
            i = R.id.no_record_found;
            TextView textView = (TextView) view.findViewById(R.id.no_record_found);
            if (textView != null) {
                return new RowItemServiceHoursBinding((RelativeLayout) view, touchImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
