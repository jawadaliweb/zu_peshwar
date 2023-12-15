package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ActivityZuCardRechargeBinding implements ViewBinding {
    public final ImageView BtnBack;
    public final TextView amtHeadline;
    public final TextView button;
    public final TextView button2;
    public final ConstraintLayout constraintLayout2;
    public final TextView date;
    public final EditText enteredBalance;
    public final Guideline guideline1;
    private final ConstraintLayout rootView;
    public final TextView textView;
    public final TextView textView10;
    public final TextView textView2;
    public final TextView textView6;
    public final TextView textView7;
    public final TextView textView8;
    public final TextView textView9;
    public final Toolbar toolbar;
    public final ConstraintLayout toolbarContainer;
    public final TextView toolbarTitle;
    public final TextView walletBalance;

    private ActivityZuCardRechargeBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout3, TextView textView11, EditText editText, Guideline guideline, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, Toolbar toolbar2, ConstraintLayout constraintLayout4, TextView textView19, TextView textView20) {
        this.rootView = constraintLayout;
        this.BtnBack = imageView;
        this.amtHeadline = textView3;
        this.button = textView4;
        this.button2 = textView5;
        this.constraintLayout2 = constraintLayout3;
        this.date = textView11;
        this.enteredBalance = editText;
        this.guideline1 = guideline;
        this.textView = textView12;
        this.textView10 = textView13;
        this.textView2 = textView14;
        this.textView6 = textView15;
        this.textView7 = textView16;
        this.textView8 = textView17;
        this.textView9 = textView18;
        this.toolbar = toolbar2;
        this.toolbarContainer = constraintLayout4;
        this.toolbarTitle = textView19;
        this.walletBalance = textView20;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityZuCardRechargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityZuCardRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_zu_card_recharge, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityZuCardRechargeBinding bind(View view) {
        View view2 = view;
        int i = R.id.Btn_Back;
        ImageView imageView = (ImageView) view2.findViewById(R.id.Btn_Back);
        if (imageView != null) {
            i = R.id.amt_headline;
            TextView textView3 = (TextView) view2.findViewById(R.id.amt_headline);
            if (textView3 != null) {
                i = R.id.button;
                TextView textView4 = (TextView) view2.findViewById(R.id.button);
                if (textView4 != null) {
                    i = R.id.button2;
                    TextView textView5 = (TextView) view2.findViewById(R.id.button2);
                    if (textView5 != null) {
                        i = R.id.constraintLayout2;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.constraintLayout2);
                        if (constraintLayout != null) {
                            i = R.id.date;
                            TextView textView11 = (TextView) view2.findViewById(R.id.date);
                            if (textView11 != null) {
                                i = R.id.enteredBalance;
                                EditText editText = (EditText) view2.findViewById(R.id.enteredBalance);
                                if (editText != null) {
                                    i = R.id.guideline1;
                                    Guideline guideline = (Guideline) view2.findViewById(R.id.guideline1);
                                    if (guideline != null) {
                                        i = R.id.textView;
                                        TextView textView12 = (TextView) view2.findViewById(R.id.textView);
                                        if (textView12 != null) {
                                            i = R.id.textView10;
                                            TextView textView13 = (TextView) view2.findViewById(R.id.textView10);
                                            if (textView13 != null) {
                                                i = R.id.textView2;
                                                TextView textView14 = (TextView) view2.findViewById(R.id.textView2);
                                                if (textView14 != null) {
                                                    i = R.id.textView6;
                                                    TextView textView15 = (TextView) view2.findViewById(R.id.textView6);
                                                    if (textView15 != null) {
                                                        i = R.id.textView7;
                                                        TextView textView16 = (TextView) view2.findViewById(R.id.textView7);
                                                        if (textView16 != null) {
                                                            i = R.id.textView8;
                                                            TextView textView17 = (TextView) view2.findViewById(R.id.textView8);
                                                            if (textView17 != null) {
                                                                i = R.id.textView9;
                                                                TextView textView18 = (TextView) view2.findViewById(R.id.textView9);
                                                                if (textView18 != null) {
                                                                    i = R.id.toolbar;
                                                                    Toolbar toolbar2 = (Toolbar) view2.findViewById(R.id.toolbar);
                                                                    if (toolbar2 != null) {
                                                                        i = R.id.toolbarContainer;
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view2.findViewById(R.id.toolbarContainer);
                                                                        if (constraintLayout3 != null) {
                                                                            i = R.id.toolbar_title;
                                                                            TextView textView19 = (TextView) view2.findViewById(R.id.toolbar_title);
                                                                            if (textView19 != null) {
                                                                                i = R.id.walletBalance;
                                                                                TextView textView20 = (TextView) view2.findViewById(R.id.walletBalance);
                                                                                if (textView20 != null) {
                                                                                    return new ActivityZuCardRechargeBinding((ConstraintLayout) view2, imageView, textView3, textView4, textView5, constraintLayout, textView11, editText, guideline, textView12, textView13, textView14, textView15, textView16, textView17, textView18, toolbar2, constraintLayout3, textView19, textView20);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
