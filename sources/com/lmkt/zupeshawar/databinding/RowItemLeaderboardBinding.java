package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RowItemLeaderboardBinding implements ViewBinding {
    public final TextView name;
    public final TextView no;
    public final ImageView noBackground;
    public final TextView number;
    private final LinearLayout rootView;
    public final TextView time;
    public final TextView timeLabel;

    private RowItemLeaderboardBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.name = textView;
        this.no = textView2;
        this.noBackground = imageView;
        this.number = textView3;
        this.time = textView4;
        this.timeLabel = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowItemLeaderboardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowItemLeaderboardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_item_leaderboard, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowItemLeaderboardBinding bind(View view) {
        int i = R.id.name;
        TextView textView = (TextView) view.findViewById(R.id.name);
        if (textView != null) {
            i = R.id.no;
            TextView textView2 = (TextView) view.findViewById(R.id.no);
            if (textView2 != null) {
                i = R.id.no_background;
                ImageView imageView = (ImageView) view.findViewById(R.id.no_background);
                if (imageView != null) {
                    i = R.id.number;
                    TextView textView3 = (TextView) view.findViewById(R.id.number);
                    if (textView3 != null) {
                        i = R.id.time;
                        TextView textView4 = (TextView) view.findViewById(R.id.time);
                        if (textView4 != null) {
                            i = R.id.time_label;
                            TextView textView5 = (TextView) view.findViewById(R.id.time_label);
                            if (textView5 != null) {
                                return new RowItemLeaderboardBinding((LinearLayout) view, textView, textView2, imageView, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
