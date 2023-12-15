package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragTicketsRechargeEasypaisaBinding implements ViewBinding {
    public final EditText AmountET;
    public final MaterialButton BtnProceed;
    public final EditText MobileET;
    public final EditText NameET;
    public final CardView cardView1;
    public final CardView cardView2;
    public final ImageView iv;
    private final LinearLayout rootView;
    public final TextView tvSecond;

    private FragTicketsRechargeEasypaisaBinding(LinearLayout linearLayout, EditText editText, MaterialButton materialButton, EditText editText2, EditText editText3, CardView cardView, CardView cardView3, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.AmountET = editText;
        this.BtnProceed = materialButton;
        this.MobileET = editText2;
        this.NameET = editText3;
        this.cardView1 = cardView;
        this.cardView2 = cardView3;
        this.iv = imageView;
        this.tvSecond = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragTicketsRechargeEasypaisaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsRechargeEasypaisaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets_recharge_easypaisa, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsRechargeEasypaisaBinding bind(View view) {
        int i = R.id.Amount_ET;
        EditText editText = (EditText) view.findViewById(R.id.Amount_ET);
        if (editText != null) {
            i = R.id.Btn_Proceed;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_Proceed);
            if (materialButton != null) {
                i = R.id.Mobile_ET;
                EditText editText2 = (EditText) view.findViewById(R.id.Mobile_ET);
                if (editText2 != null) {
                    i = R.id.Name_ET;
                    EditText editText3 = (EditText) view.findViewById(R.id.Name_ET);
                    if (editText3 != null) {
                        i = R.id.card_view1;
                        CardView cardView = (CardView) view.findViewById(R.id.card_view1);
                        if (cardView != null) {
                            i = R.id.card_view2;
                            CardView cardView3 = (CardView) view.findViewById(R.id.card_view2);
                            if (cardView3 != null) {
                                i = R.id.iv;
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv);
                                if (imageView != null) {
                                    i = R.id.tv_second;
                                    TextView textView = (TextView) view.findViewById(R.id.tv_second);
                                    if (textView != null) {
                                        return new FragTicketsRechargeEasypaisaBinding((LinearLayout) view, editText, materialButton, editText2, editText3, cardView, cardView3, imageView, textView);
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
