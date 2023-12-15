package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.lmkt.zupeshawar.R;
import com.smarteist.autoimageslider.SliderView;

public final class ContentMainBinding implements ViewBinding {
    public final TextView TVUserBalance;
    public final TextView TVUserTitle;
    public final RelativeLayout bottomLayout;
    public final FrameLayout frameLayout;
    public final SliderView imageSlider;
    public final ViewPager pager;
    public final LinearLayout payment;
    public final ProgressBar progressSlider;
    public final MaterialButton qrScanBtn;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final LinearLayout tablayout;
    public final TabLayout tabs;
    public final MaterialButton zuWalletBtn;

    private ContentMainBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, RelativeLayout relativeLayout2, FrameLayout frameLayout2, SliderView sliderView, ViewPager viewPager, LinearLayout linearLayout, ProgressBar progressBar, MaterialButton materialButton, RelativeLayout relativeLayout3, LinearLayout linearLayout2, TabLayout tabLayout, MaterialButton materialButton2) {
        this.rootView = relativeLayout;
        this.TVUserBalance = textView;
        this.TVUserTitle = textView2;
        this.bottomLayout = relativeLayout2;
        this.frameLayout = frameLayout2;
        this.imageSlider = sliderView;
        this.pager = viewPager;
        this.payment = linearLayout;
        this.progressSlider = progressBar;
        this.qrScanBtn = materialButton;
        this.root = relativeLayout3;
        this.tablayout = linearLayout2;
        this.tabs = tabLayout;
        this.zuWalletBtn = materialButton2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ContentMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ContentMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.content_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ContentMainBinding bind(View view) {
        View view2 = view;
        int i = R.id.TV_UserBalance;
        TextView textView = (TextView) view2.findViewById(R.id.TV_UserBalance);
        if (textView != null) {
            i = R.id.TV_UserTitle;
            TextView textView2 = (TextView) view2.findViewById(R.id.TV_UserTitle);
            if (textView2 != null) {
                i = R.id.bottomLayout;
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.bottomLayout);
                if (relativeLayout != null) {
                    i = R.id.frameLayout;
                    FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.frameLayout);
                    if (frameLayout2 != null) {
                        i = R.id.imageSlider;
                        SliderView sliderView = (SliderView) view2.findViewById(R.id.imageSlider);
                        if (sliderView != null) {
                            i = R.id.pager;
                            ViewPager viewPager = (ViewPager) view2.findViewById(R.id.pager);
                            if (viewPager != null) {
                                i = R.id.payment;
                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.payment);
                                if (linearLayout != null) {
                                    i = R.id.progressSlider;
                                    ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.progressSlider);
                                    if (progressBar != null) {
                                        i = R.id.qr_scan_Btn;
                                        MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.qr_scan_Btn);
                                        if (materialButton != null) {
                                            RelativeLayout relativeLayout2 = (RelativeLayout) view2;
                                            i = R.id.tablayout;
                                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.tablayout);
                                            if (linearLayout2 != null) {
                                                i = R.id.tabs;
                                                TabLayout tabLayout = (TabLayout) view2.findViewById(R.id.tabs);
                                                if (tabLayout != null) {
                                                    i = R.id.zu_wallet_Btn;
                                                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.zu_wallet_Btn);
                                                    if (materialButton2 != null) {
                                                        return new ContentMainBinding(relativeLayout2, textView, textView2, relativeLayout, frameLayout2, sliderView, viewPager, linearLayout, progressBar, materialButton, relativeLayout2, linearLayout2, tabLayout, materialButton2);
                                                    }
                                                }
                                            }
                                        }
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
