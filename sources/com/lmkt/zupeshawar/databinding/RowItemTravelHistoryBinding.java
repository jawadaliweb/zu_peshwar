package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RowItemTravelHistoryBinding implements ViewBinding {
    public final TextView DurationTV;
    public final TextView checkInOut;
    public final TextView checkInTv;
    public final TextView checkOutTv;
    public final TextView checkinStationTV;
    public final TextView checkoutStationTV;
    public final TextView dateTV;
    public final TextView fareTV;
    private final LinearLayout rootView;

    private RowItemTravelHistoryBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.DurationTV = textView;
        this.checkInOut = textView2;
        this.checkInTv = textView3;
        this.checkOutTv = textView4;
        this.checkinStationTV = textView5;
        this.checkoutStationTV = textView6;
        this.dateTV = textView7;
        this.fareTV = textView8;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowItemTravelHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowItemTravelHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_item_travel_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowItemTravelHistoryBinding bind(View view) {
        int i = R.id.Duration_TV;
        TextView textView = (TextView) view.findViewById(R.id.Duration_TV);
        if (textView != null) {
            i = R.id.checkInOut;
            TextView textView2 = (TextView) view.findViewById(R.id.checkInOut);
            if (textView2 != null) {
                i = R.id.checkIn_Tv;
                TextView textView3 = (TextView) view.findViewById(R.id.checkIn_Tv);
                if (textView3 != null) {
                    i = R.id.checkOut_Tv;
                    TextView textView4 = (TextView) view.findViewById(R.id.checkOut_Tv);
                    if (textView4 != null) {
                        i = R.id.checkinStation_TV;
                        TextView textView5 = (TextView) view.findViewById(R.id.checkinStation_TV);
                        if (textView5 != null) {
                            i = R.id.checkoutStation_TV;
                            TextView textView6 = (TextView) view.findViewById(R.id.checkoutStation_TV);
                            if (textView6 != null) {
                                i = R.id.date_TV;
                                TextView textView7 = (TextView) view.findViewById(R.id.date_TV);
                                if (textView7 != null) {
                                    i = R.id.fare_TV;
                                    TextView textView8 = (TextView) view.findViewById(R.id.fare_TV);
                                    if (textView8 != null) {
                                        return new RowItemTravelHistoryBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
