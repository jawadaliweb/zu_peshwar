package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class RegistrationFragmentBinding implements ViewBinding {
    public final MaterialButton BtnProceed;
    public final MaskedEditText ETCNIC;
    public final EditText ETEmailAddress;
    public final EditText ETName;
    public final Spinner SPGender;
    public final TextView TVDOB;
    public final CardView cardView1;
    public final CardView cardView2;
    public final CardView cardView3;
    public final CardView cardView4;
    public final CardView cardView5;
    public final TextView cnicHintTV;
    public final ImageView logoIV;
    private final ConstraintLayout rootView;

    private RegistrationFragmentBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, MaskedEditText maskedEditText, EditText editText, EditText editText2, Spinner spinner, TextView textView, CardView cardView, CardView cardView6, CardView cardView7, CardView cardView8, CardView cardView9, TextView textView2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.BtnProceed = materialButton;
        this.ETCNIC = maskedEditText;
        this.ETEmailAddress = editText;
        this.ETName = editText2;
        this.SPGender = spinner;
        this.TVDOB = textView;
        this.cardView1 = cardView;
        this.cardView2 = cardView6;
        this.cardView3 = cardView7;
        this.cardView4 = cardView8;
        this.cardView5 = cardView9;
        this.cnicHintTV = textView2;
        this.logoIV = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RegistrationFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RegistrationFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.registration_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegistrationFragmentBinding bind(View view) {
        View view2 = view;
        int i = R.id.Btn_Proceed;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.Btn_Proceed);
        if (materialButton != null) {
            i = R.id.ET_CNIC;
            MaskedEditText maskedEditText = (MaskedEditText) view2.findViewById(R.id.ET_CNIC);
            if (maskedEditText != null) {
                i = R.id.ET_EmailAddress;
                EditText editText = (EditText) view2.findViewById(R.id.ET_EmailAddress);
                if (editText != null) {
                    i = R.id.ET_Name;
                    EditText editText2 = (EditText) view2.findViewById(R.id.ET_Name);
                    if (editText2 != null) {
                        i = R.id.SP_Gender;
                        Spinner spinner = (Spinner) view2.findViewById(R.id.SP_Gender);
                        if (spinner != null) {
                            i = R.id.TV_DOB;
                            TextView textView = (TextView) view2.findViewById(R.id.TV_DOB);
                            if (textView != null) {
                                i = R.id.card_view1;
                                CardView cardView = (CardView) view2.findViewById(R.id.card_view1);
                                if (cardView != null) {
                                    i = R.id.card_view2;
                                    CardView cardView6 = (CardView) view2.findViewById(R.id.card_view2);
                                    if (cardView6 != null) {
                                        i = R.id.card_view3;
                                        CardView cardView7 = (CardView) view2.findViewById(R.id.card_view3);
                                        if (cardView7 != null) {
                                            i = R.id.card_view4;
                                            CardView cardView8 = (CardView) view2.findViewById(R.id.card_view4);
                                            if (cardView8 != null) {
                                                i = R.id.card_view5;
                                                CardView cardView9 = (CardView) view2.findViewById(R.id.card_view5);
                                                if (cardView9 != null) {
                                                    i = R.id.cnicHint_TV;
                                                    TextView textView2 = (TextView) view2.findViewById(R.id.cnicHint_TV);
                                                    if (textView2 != null) {
                                                        i = R.id.logoIV;
                                                        ImageView imageView = (ImageView) view2.findViewById(R.id.logoIV);
                                                        if (imageView != null) {
                                                            return new RegistrationFragmentBinding((ConstraintLayout) view2, materialButton, maskedEditText, editText, editText2, spinner, textView, cardView, cardView6, cardView7, cardView8, cardView9, textView2, imageView);
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
