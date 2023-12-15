package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragNaviMyprofileBinding implements ViewBinding {
    public final TextView DOBTV;
    public final TextView EmailTV;
    public final TextView MemberSinceTV;
    public final TextView NameTV;
    public final TextView PackageExpiryTV;
    public final TextView RefundableSecurityTV;
    public final TextView TotalBalanceTV;
    public final TextView ZuBicycleTV;
    public final TextView cardNoTV;
    public final ImageView imageView2;
    public final TextView mobileNo;
    private final LinearLayout rootView;

    private FragNaviMyprofileBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageView imageView, TextView textView10) {
        this.rootView = linearLayout;
        this.DOBTV = textView;
        this.EmailTV = textView2;
        this.MemberSinceTV = textView3;
        this.NameTV = textView4;
        this.PackageExpiryTV = textView5;
        this.RefundableSecurityTV = textView6;
        this.TotalBalanceTV = textView7;
        this.ZuBicycleTV = textView8;
        this.cardNoTV = textView9;
        this.imageView2 = imageView;
        this.mobileNo = textView10;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragNaviMyprofileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragNaviMyprofileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_myprofile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragNaviMyprofileBinding bind(View view) {
        int i = R.id.DOB_TV;
        TextView textView = (TextView) view.findViewById(R.id.DOB_TV);
        if (textView != null) {
            i = R.id.Email_TV;
            TextView textView2 = (TextView) view.findViewById(R.id.Email_TV);
            if (textView2 != null) {
                i = R.id.MemberSince_TV;
                TextView textView3 = (TextView) view.findViewById(R.id.MemberSince_TV);
                if (textView3 != null) {
                    i = R.id.Name_TV;
                    TextView textView4 = (TextView) view.findViewById(R.id.Name_TV);
                    if (textView4 != null) {
                        i = R.id.PackageExpiry_TV;
                        TextView textView5 = (TextView) view.findViewById(R.id.PackageExpiry_TV);
                        if (textView5 != null) {
                            i = R.id.RefundableSecurity_TV;
                            TextView textView6 = (TextView) view.findViewById(R.id.RefundableSecurity_TV);
                            if (textView6 != null) {
                                i = R.id.TotalBalance_TV;
                                TextView textView7 = (TextView) view.findViewById(R.id.TotalBalance_TV);
                                if (textView7 != null) {
                                    i = R.id.ZuBicycle_TV;
                                    TextView textView8 = (TextView) view.findViewById(R.id.ZuBicycle_TV);
                                    if (textView8 != null) {
                                        i = R.id.cardNo_TV;
                                        TextView textView9 = (TextView) view.findViewById(R.id.cardNo_TV);
                                        if (textView9 != null) {
                                            i = R.id.imageView2;
                                            ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
                                            if (imageView != null) {
                                                i = R.id.mobileNo;
                                                TextView textView10 = (TextView) view.findViewById(R.id.mobileNo);
                                                if (textView10 != null) {
                                                    return new FragNaviMyprofileBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, imageView, textView10);
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
