package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class LayDrawerMenuBinding implements ViewBinding {
    public final LinearLayout naviBtnCustomerFeedback;
    public final LinearLayout naviBtnFAQ;
    public final LinearLayout naviBtnFare;
    public final LinearLayout naviBtnHelpline;
    public final LinearLayout naviBtnInviteFriend;
    public final LinearLayout naviBtnMyProfile;
    public final LinearLayout naviBtnSetting;
    public final LinearLayout naviBtnWhatsNew;
    public final LinearLayout naviBtnYoutubeChannel;
    private final LinearLayout rootView;

    private LayDrawerMenuBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10) {
        this.rootView = linearLayout;
        this.naviBtnCustomerFeedback = linearLayout2;
        this.naviBtnFAQ = linearLayout3;
        this.naviBtnFare = linearLayout4;
        this.naviBtnHelpline = linearLayout5;
        this.naviBtnInviteFriend = linearLayout6;
        this.naviBtnMyProfile = linearLayout7;
        this.naviBtnSetting = linearLayout8;
        this.naviBtnWhatsNew = linearLayout9;
        this.naviBtnYoutubeChannel = linearLayout10;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayDrawerMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayDrawerMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.lay_drawer_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayDrawerMenuBinding bind(View view) {
        int i = R.id.naviBtn_CustomerFeedback;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.naviBtn_CustomerFeedback);
        if (linearLayout != null) {
            i = R.id.naviBtn_FAQ;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.naviBtn_FAQ);
            if (linearLayout2 != null) {
                i = R.id.naviBtn_Fare;
                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.naviBtn_Fare);
                if (linearLayout3 != null) {
                    i = R.id.naviBtn_Helpline;
                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.naviBtn_Helpline);
                    if (linearLayout4 != null) {
                        i = R.id.naviBtn_InviteFriend;
                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.naviBtn_InviteFriend);
                        if (linearLayout5 != null) {
                            i = R.id.naviBtn_MyProfile;
                            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.naviBtn_MyProfile);
                            if (linearLayout6 != null) {
                                i = R.id.naviBtn_Setting;
                                LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.naviBtn_Setting);
                                if (linearLayout7 != null) {
                                    i = R.id.naviBtn_WhatsNew;
                                    LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.naviBtn_WhatsNew);
                                    if (linearLayout8 != null) {
                                        i = R.id.naviBtn_YoutubeChannel;
                                        LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.naviBtn_YoutubeChannel);
                                        if (linearLayout9 != null) {
                                            return new LayDrawerMenuBinding((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9);
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
