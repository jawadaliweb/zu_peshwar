package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.lmkt.zupeshawar.R;

public final class FragmentLeaderBoardBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final TextView name;
    public final TextView number;
    private final CoordinatorLayout rootView;
    public final TabLayout tabs;
    public final TextView time;
    public final TextView timeLabel;
    public final CollapsingToolbarLayout toolbarLayout;
    public final LinearLayout toplayout;

    private FragmentLeaderBoardBinding(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, TextView textView, TextView textView2, TabLayout tabLayout, TextView textView3, TextView textView4, CollapsingToolbarLayout collapsingToolbarLayout, LinearLayout linearLayout) {
        this.rootView = coordinatorLayout;
        this.appBar = appBarLayout;
        this.name = textView;
        this.number = textView2;
        this.tabs = tabLayout;
        this.time = textView3;
        this.timeLabel = textView4;
        this.toolbarLayout = collapsingToolbarLayout;
        this.toplayout = linearLayout;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLeaderBoardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentLeaderBoardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_leader_board, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentLeaderBoardBinding bind(View view) {
        int i = R.id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar);
        if (appBarLayout != null) {
            i = R.id.name;
            TextView textView = (TextView) view.findViewById(R.id.name);
            if (textView != null) {
                i = R.id.number;
                TextView textView2 = (TextView) view.findViewById(R.id.number);
                if (textView2 != null) {
                    i = R.id.tabs;
                    TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
                    if (tabLayout != null) {
                        i = R.id.time;
                        TextView textView3 = (TextView) view.findViewById(R.id.time);
                        if (textView3 != null) {
                            i = R.id.time_label;
                            TextView textView4 = (TextView) view.findViewById(R.id.time_label);
                            if (textView4 != null) {
                                i = R.id.toolbar_layout;
                                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.toolbar_layout);
                                if (collapsingToolbarLayout != null) {
                                    i = R.id.toplayout;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.toplayout);
                                    if (linearLayout != null) {
                                        return new FragmentLeaderBoardBinding((CoordinatorLayout) view, appBarLayout, textView, textView2, tabLayout, textView3, textView4, collapsingToolbarLayout, linearLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
