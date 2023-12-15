package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragTicketsRechargeCreditdebitBinding implements ViewBinding {
    public final MaterialButton BtnProceed;
    public final EditText ETName;
    public final CardView cardView1;
    public final CardView cardView2;
    public final ImageView iv;
    private final RelativeLayout rootView;

    private FragTicketsRechargeCreditdebitBinding(RelativeLayout relativeLayout, MaterialButton materialButton, EditText editText, CardView cardView, CardView cardView3, ImageView imageView) {
        this.rootView = relativeLayout;
        this.BtnProceed = materialButton;
        this.ETName = editText;
        this.cardView1 = cardView;
        this.cardView2 = cardView3;
        this.iv = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragTicketsRechargeCreditdebitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsRechargeCreditdebitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets_recharge_creditdebit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsRechargeCreditdebitBinding bind(View view) {
        int i = R.id.Btn_Proceed;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_Proceed);
        if (materialButton != null) {
            i = R.id.ET_Name;
            EditText editText = (EditText) view.findViewById(R.id.ET_Name);
            if (editText != null) {
                i = R.id.card_view1;
                CardView cardView = (CardView) view.findViewById(R.id.card_view1);
                if (cardView != null) {
                    i = R.id.card_view2;
                    CardView cardView3 = (CardView) view.findViewById(R.id.card_view2);
                    if (cardView3 != null) {
                        i = R.id.iv;
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
                        if (imageView != null) {
                            return new FragTicketsRechargeCreditdebitBinding((RelativeLayout) view, materialButton, editText, cardView, cardView3, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
