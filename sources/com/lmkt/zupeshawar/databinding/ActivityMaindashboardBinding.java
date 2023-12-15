package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.navigation.NavigationView;
import com.lmkt.zupeshawar.R;

public final class ActivityMaindashboardBinding implements ViewBinding {
    public final DrawerLayout drawerLayout;
    public final NavHeaderMainBinding navHeaderLay;
    public final NavigationView navView;
    private final DrawerLayout rootView;

    private ActivityMaindashboardBinding(DrawerLayout drawerLayout2, DrawerLayout drawerLayout3, NavHeaderMainBinding navHeaderMainBinding, NavigationView navigationView) {
        this.rootView = drawerLayout2;
        this.drawerLayout = drawerLayout3;
        this.navHeaderLay = navHeaderMainBinding;
        this.navView = navigationView;
    }

    public DrawerLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMaindashboardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMaindashboardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_maindashboard, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMaindashboardBinding bind(View view) {
        DrawerLayout drawerLayout2 = (DrawerLayout) view;
        int i = R.id.nav_header_lay;
        View findViewById = view.findViewById(R.id.nav_header_lay);
        if (findViewById != null) {
            NavHeaderMainBinding bind = NavHeaderMainBinding.bind(findViewById);
            NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
            if (navigationView != null) {
                return new ActivityMaindashboardBinding(drawerLayout2, drawerLayout2, bind, navigationView);
            }
            i = R.id.nav_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
