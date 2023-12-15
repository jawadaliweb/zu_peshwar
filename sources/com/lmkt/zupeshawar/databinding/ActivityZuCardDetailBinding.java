package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ActivityZuCardDetailBinding implements ViewBinding {
    public final ImageView BtnBack;
    public final TextView balance;
    public final TextView button;
    public final TextView button2;
    public final ConstraintLayout constraintLayout;
    public final TextView date;
    public final Guideline guideline1;
    public final ImageView imageView3;
    public final ScrollView mainContainer;
    private final ConstraintLayout rootView;
    public final ConstraintLayout subMainContainer;
    public final TextView textView;
    public final TextView textView2;
    public final TextView textView3;
    public final TextView textView4;
    public final TextView textView5;
    public final Toolbar toolbar;
    public final ConstraintLayout toolbarContainer;
    public final TextView toolbarTitle;

    private ActivityZuCardDetailBinding(ConstraintLayout constraintLayout2, ImageView imageView, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout3, TextView textView9, Guideline guideline, ImageView imageView2, ScrollView scrollView, ConstraintLayout constraintLayout4, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, Toolbar toolbar2, ConstraintLayout constraintLayout5, TextView textView15) {
        this.rootView = constraintLayout2;
        this.BtnBack = imageView;
        this.balance = textView6;
        this.button = textView7;
        this.button2 = textView8;
        this.constraintLayout = constraintLayout3;
        this.date = textView9;
        this.guideline1 = guideline;
        this.imageView3 = imageView2;
        this.mainContainer = scrollView;
        this.subMainContainer = constraintLayout4;
        this.textView = textView10;
        this.textView2 = textView11;
        this.textView3 = textView12;
        this.textView4 = textView13;
        this.textView5 = textView14;
        this.toolbar = toolbar2;
        this.toolbarContainer = constraintLayout5;
        this.toolbarTitle = textView15;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityZuCardDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityZuCardDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_zu_card_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityZuCardDetailBinding bind(View view) {
        View view2 = view;
        int i = R.id.Btn_Back;
        ImageView imageView = (ImageView) view2.findViewById(R.id.Btn_Back);
        if (imageView != null) {
            i = R.id.balance;
            TextView textView6 = (TextView) view2.findViewById(R.id.balance);
            if (textView6 != null) {
                i = R.id.button;
                TextView textView7 = (TextView) view2.findViewById(R.id.button);
                if (textView7 != null) {
                    i = R.id.button2;
                    TextView textView8 = (TextView) view2.findViewById(R.id.button2);
                    if (textView8 != null) {
                        i = R.id.constraintLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.constraintLayout);
                        if (constraintLayout2 != null) {
                            i = R.id.date;
                            TextView textView9 = (TextView) view2.findViewById(R.id.date);
                            if (textView9 != null) {
                                i = R.id.guideline1;
                                Guideline guideline = (Guideline) view2.findViewById(R.id.guideline1);
                                if (guideline != null) {
                                    i = R.id.imageView3;
                                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.imageView3);
                                    if (imageView2 != null) {
                                        i = R.id.mainContainer;
                                        ScrollView scrollView = (ScrollView) view2.findViewById(R.id.mainContainer);
                                        if (scrollView != null) {
                                            i = R.id.subMainContainer;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view2.findViewById(R.id.subMainContainer);
                                            if (constraintLayout3 != null) {
                                                i = R.id.textView;
                                                TextView textView10 = (TextView) view2.findViewById(R.id.textView);
                                                if (textView10 != null) {
                                                    i = R.id.textView2;
                                                    TextView textView11 = (TextView) view2.findViewById(R.id.textView2);
                                                    if (textView11 != null) {
                                                        i = R.id.textView3;
                                                        TextView textView12 = (TextView) view2.findViewById(R.id.textView3);
                                                        if (textView12 != null) {
                                                            i = R.id.textView4;
                                                            TextView textView13 = (TextView) view2.findViewById(R.id.textView4);
                                                            if (textView13 != null) {
                                                                i = R.id.textView5;
                                                                TextView textView14 = (TextView) view2.findViewById(R.id.textView5);
                                                                if (textView14 != null) {
                                                                    i = R.id.toolbar;
                                                                    Toolbar toolbar2 = (Toolbar) view2.findViewById(R.id.toolbar);
                                                                    if (toolbar2 != null) {
                                                                        i = R.id.toolbarContainer;
                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view2.findViewById(R.id.toolbarContainer);
                                                                        if (constraintLayout4 != null) {
                                                                            i = R.id.toolbar_title;
                                                                            TextView textView15 = (TextView) view2.findViewById(R.id.toolbar_title);
                                                                            if (textView15 != null) {
                                                                                return new ActivityZuCardDetailBinding((ConstraintLayout) view2, imageView, textView6, textView7, textView8, constraintLayout2, textView9, guideline, imageView2, scrollView, constraintLayout3, textView10, textView11, textView12, textView13, textView14, toolbar2, constraintLayout4, textView15);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
