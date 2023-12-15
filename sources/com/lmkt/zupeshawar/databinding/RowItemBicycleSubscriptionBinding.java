package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RowItemBicycleSubscriptionBinding implements ViewBinding {
    public final LinearLayout cycleImg;
    public final TextView durationTV;
    public final LinearLayout memberShipValidity;
    public final TextView memberShipValidityTv;
    public final TextView membershipTv;
    public final TextView priceTv;
    private final CardView rootView;
    public final RelativeLayout viewCard;

    private RowItemBicycleSubscriptionBinding(CardView cardView, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, RelativeLayout relativeLayout) {
        this.rootView = cardView;
        this.cycleImg = linearLayout;
        this.durationTV = textView;
        this.memberShipValidity = linearLayout2;
        this.memberShipValidityTv = textView2;
        this.membershipTv = textView3;
        this.priceTv = textView4;
        this.viewCard = relativeLayout;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static RowItemBicycleSubscriptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowItemBicycleSubscriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_item_bicycle_subscription, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowItemBicycleSubscriptionBinding bind(View view) {
        int i = R.id.cycleImg;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.cycleImg);
        if (linearLayout != null) {
            i = R.id.duration_TV;
            TextView textView = (TextView) view.findViewById(R.id.duration_TV);
            if (textView != null) {
                i = R.id.memberShipValidity;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.memberShipValidity);
                if (linearLayout2 != null) {
                    i = R.id.memberShipValidityTv;
                    TextView textView2 = (TextView) view.findViewById(R.id.memberShipValidityTv);
                    if (textView2 != null) {
                        i = R.id.membershipTv;
                        TextView textView3 = (TextView) view.findViewById(R.id.membershipTv);
                        if (textView3 != null) {
                            i = R.id.priceTv;
                            TextView textView4 = (TextView) view.findViewById(R.id.priceTv);
                            if (textView4 != null) {
                                i = R.id.viewCard;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.viewCard);
                                if (relativeLayout != null) {
                                    return new RowItemBicycleSubscriptionBinding((CardView) view, linearLayout, textView, linearLayout2, textView2, textView3, textView4, relativeLayout);
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
