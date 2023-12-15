package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RowMembershipBssBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView userDetails;
    public final TextView userStatus;

    private RowMembershipBssBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.userDetails = textView;
        this.userStatus = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowMembershipBssBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowMembershipBssBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_membership_bss, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowMembershipBssBinding bind(View view) {
        int i = R.id.userDetails;
        TextView textView = (TextView) view.findViewById(R.id.userDetails);
        if (textView != null) {
            i = R.id.userStatus;
            TextView textView2 = (TextView) view.findViewById(R.id.userStatus);
            if (textView2 != null) {
                return new RowMembershipBssBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
