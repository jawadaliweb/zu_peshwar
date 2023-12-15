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

public final class FragTicketsRechargeJazzcashBinding implements ViewBinding {
    public final MaterialButton BtnProceed;
    public final EditText ETAmount;
    public final EditText ETCNIC;
    public final EditText MobileET;
    public final EditText NameET;
    public final CardView cardView1;
    public final CardView cardView2;
    public final CardView cardView3;
    public final ImageView iv;
    private final LinearLayout rootView;
    public final TextView tvSecond;

    private FragTicketsRechargeJazzcashBinding(LinearLayout linearLayout, MaterialButton materialButton, EditText editText, EditText editText2, EditText editText3, EditText editText4, CardView cardView, CardView cardView4, CardView cardView5, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.BtnProceed = materialButton;
        this.ETAmount = editText;
        this.ETCNIC = editText2;
        this.MobileET = editText3;
        this.NameET = editText4;
        this.cardView1 = cardView;
        this.cardView2 = cardView4;
        this.cardView3 = cardView5;
        this.iv = imageView;
        this.tvSecond = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragTicketsRechargeJazzcashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsRechargeJazzcashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets_recharge_jazzcash, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsRechargeJazzcashBinding bind(View view) {
        int i = R.id.Btn_Proceed;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_Proceed);
        if (materialButton != null) {
            i = R.id.ET_Amount;
            EditText editText = (EditText) view.findViewById(R.id.ET_Amount);
            if (editText != null) {
                i = R.id.ET_CNIC;
                EditText editText2 = (EditText) view.findViewById(R.id.ET_CNIC);
                if (editText2 != null) {
                    i = R.id.Mobile_ET;
                    EditText editText3 = (EditText) view.findViewById(R.id.Mobile_ET);
                    if (editText3 != null) {
                        i = R.id.Name_ET;
                        EditText editText4 = (EditText) view.findViewById(R.id.Name_ET);
                        if (editText4 != null) {
                            i = R.id.card_view1;
                            CardView cardView = (CardView) view.findViewById(R.id.card_view1);
                            if (cardView != null) {
                                i = R.id.card_view2;
                                CardView cardView4 = (CardView) view.findViewById(R.id.card_view2);
                                if (cardView4 != null) {
                                    i = R.id.card_view3;
                                    CardView cardView5 = (CardView) view.findViewById(R.id.card_view3);
                                    if (cardView5 != null) {
                                        i = R.id.iv;
                                        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
                                        if (imageView != null) {
                                            i = R.id.tv_second;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_second);
                                            if (textView != null) {
                                                return new FragTicketsRechargeJazzcashBinding((LinearLayout) view, materialButton, editText, editText2, editText3, editText4, cardView, cardView4, cardView5, imageView, textView);
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
