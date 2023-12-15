package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class DialogBssMembershipBinding implements ViewBinding {
    public final MaterialButton BtnZuWallet;
    public final LinearLayout close;
    public final TextView costTv;
    public final LinearLayout cycleImg;
    public final TextView durationTV;
    public final RelativeLayout footer;
    public final ListView listShowJSONData;
    public final TextView membershipTv;
    private final RelativeLayout rootView;
    public final LinearLayout sectionHeader;
    public final TextView userDetails;
    public final TextView userStatus;

    private DialogBssMembershipBinding(RelativeLayout relativeLayout, MaterialButton materialButton, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, RelativeLayout relativeLayout2, ListView listView, TextView textView3, LinearLayout linearLayout3, TextView textView4, TextView textView5) {
        this.rootView = relativeLayout;
        this.BtnZuWallet = materialButton;
        this.close = linearLayout;
        this.costTv = textView;
        this.cycleImg = linearLayout2;
        this.durationTV = textView2;
        this.footer = relativeLayout2;
        this.listShowJSONData = listView;
        this.membershipTv = textView3;
        this.sectionHeader = linearLayout3;
        this.userDetails = textView4;
        this.userStatus = textView5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogBssMembershipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogBssMembershipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_bss_membership, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBssMembershipBinding bind(View view) {
        int i = R.id.Btn_zuWallet;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_zuWallet);
        if (materialButton != null) {
            i = R.id.close;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.close);
            if (linearLayout != null) {
                i = R.id.costTv;
                TextView textView = (TextView) view.findViewById(R.id.costTv);
                if (textView != null) {
                    i = R.id.cycleImg;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.cycleImg);
                    if (linearLayout2 != null) {
                        i = R.id.duration_TV;
                        TextView textView2 = (TextView) view.findViewById(R.id.duration_TV);
                        if (textView2 != null) {
                            i = R.id.footer;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.footer);
                            if (relativeLayout != null) {
                                i = R.id.listShowJSONData;
                                ListView listView = (ListView) view.findViewById(R.id.listShowJSONData);
                                if (listView != null) {
                                    i = R.id.membershipTv;
                                    TextView textView3 = (TextView) view.findViewById(R.id.membershipTv);
                                    if (textView3 != null) {
                                        i = R.id.section_header;
                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.section_header);
                                        if (linearLayout3 != null) {
                                            i = R.id.userDetails;
                                            TextView textView4 = (TextView) view.findViewById(R.id.userDetails);
                                            if (textView4 != null) {
                                                i = R.id.userStatus;
                                                TextView textView5 = (TextView) view.findViewById(R.id.userStatus);
                                                if (textView5 != null) {
                                                    return new DialogBssMembershipBinding((RelativeLayout) view, materialButton, linearLayout, textView, linearLayout2, textView2, relativeLayout, listView, textView3, linearLayout3, textView4, textView5);
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
