package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import ru.nikartm.support.ImageBadgeView;

public final class AppBarMainBinding implements ViewBinding {
    public final ImageBadgeView notificationIV;
    private final CoordinatorLayout rootView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private AppBarMainBinding(CoordinatorLayout coordinatorLayout, ImageBadgeView imageBadgeView, Toolbar toolbar2, TextView textView) {
        this.rootView = coordinatorLayout;
        this.notificationIV = imageBadgeView;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static AppBarMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AppBarMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.app_bar_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AppBarMainBinding bind(View view) {
        int i = R.id.notification_IV;
        ImageBadgeView imageBadgeView = (ImageBadgeView) view.findViewById(R.id.notification_IV);
        if (imageBadgeView != null) {
            i = R.id.toolbar;
            Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
            if (toolbar2 != null) {
                i = R.id.toolbar_title;
                TextView textView = (TextView) view.findViewById(R.id.toolbar_title);
                if (textView != null) {
                    return new AppBarMainBinding((CoordinatorLayout) view, imageBadgeView, toolbar2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
