package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RowItemRechargeHistoryBinding implements ViewBinding {
    public final TextView rechargeAmountTV;
    public final TextView rechargeNameTV;
    public final ImageView rechargeSourceIV;
    public final TextView rechargeTimeTV;
    private final LinearLayout rootView;

    private RowItemRechargeHistoryBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, TextView textView3) {
        this.rootView = linearLayout;
        this.rechargeAmountTV = textView;
        this.rechargeNameTV = textView2;
        this.rechargeSourceIV = imageView;
        this.rechargeTimeTV = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowItemRechargeHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowItemRechargeHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_item_recharge_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowItemRechargeHistoryBinding bind(View view) {
        int i = R.id.rechargeAmount_TV;
        TextView textView = (TextView) view.findViewById(R.id.rechargeAmount_TV);
        if (textView != null) {
            i = R.id.rechargeName_TV;
            TextView textView2 = (TextView) view.findViewById(R.id.rechargeName_TV);
            if (textView2 != null) {
                i = R.id.rechargeSource_IV;
                ImageView imageView = (ImageView) view.findViewById(R.id.rechargeSource_IV);
                if (imageView != null) {
                    i = R.id.rechargeTime_TV;
                    TextView textView3 = (TextView) view.findViewById(R.id.rechargeTime_TV);
                    if (textView3 != null) {
                        return new RowItemRechargeHistoryBinding((LinearLayout) view, textView, textView2, imageView, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
