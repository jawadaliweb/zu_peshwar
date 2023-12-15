package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ActivityNotificationBinding implements ViewBinding {
    public final ListView listview;
    public final LinearLayout noDataView;
    public final ImageView notificationIV;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private ActivityNotificationBinding(LinearLayout linearLayout, ListView listView, LinearLayout linearLayout2, ImageView imageView, Toolbar toolbar2, TextView textView) {
        this.rootView = linearLayout;
        this.listview = listView;
        this.noDataView = linearLayout2;
        this.notificationIV = imageView;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_notification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityNotificationBinding bind(View view) {
        int i = R.id.listview;
        ListView listView = (ListView) view.findViewById(R.id.listview);
        if (listView != null) {
            i = R.id.noDataView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.noDataView);
            if (linearLayout != null) {
                i = R.id.notification_IV;
                ImageView imageView = (ImageView) view.findViewById(R.id.notification_IV);
                if (imageView != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
                    if (toolbar2 != null) {
                        i = R.id.toolbar_title;
                        TextView textView = (TextView) view.findViewById(R.id.toolbar_title);
                        if (textView != null) {
                            return new ActivityNotificationBinding((LinearLayout) view, listView, linearLayout, imageView, toolbar2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
