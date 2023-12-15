package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RowItemNotificationsBinding implements ViewBinding {
    public final TextView notificationDateTV;
    public final TextView notificationTV;
    private final LinearLayout rootView;

    private RowItemNotificationsBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.notificationDateTV = textView;
        this.notificationTV = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowItemNotificationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowItemNotificationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_item_notifications, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowItemNotificationsBinding bind(View view) {
        int i = R.id.notification_date_TV;
        TextView textView = (TextView) view.findViewById(R.id.notification_date_TV);
        if (textView != null) {
            i = R.id.notification_TV;
            TextView textView2 = (TextView) view.findViewById(R.id.notification_TV);
            if (textView2 != null) {
                return new RowItemNotificationsBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
