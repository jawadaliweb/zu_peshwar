package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragmentLoginBinding implements ViewBinding {
    public final MaskedEditText ETMobileNumber;
    public final CardView cardView1;
    public final TextView disclaimerTV;
    public final RelativeLayout loginContainer;
    public final ImageView logoIV;
    public final MaterialButton proceedBtn;
    private final ScrollView rootView;

    private FragmentLoginBinding(ScrollView scrollView, MaskedEditText maskedEditText, CardView cardView, TextView textView, RelativeLayout relativeLayout, ImageView imageView, MaterialButton materialButton) {
        this.rootView = scrollView;
        this.ETMobileNumber = maskedEditText;
        this.cardView1 = cardView;
        this.disclaimerTV = textView;
        this.loginContainer = relativeLayout;
        this.logoIV = imageView;
        this.proceedBtn = materialButton;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentLoginBinding bind(View view) {
        int i = R.id.ET_MobileNumber;
        MaskedEditText maskedEditText = (MaskedEditText) view.findViewById(R.id.ET_MobileNumber);
        if (maskedEditText != null) {
            i = R.id.card_view1;
            CardView cardView = (CardView) view.findViewById(R.id.card_view1);
            if (cardView != null) {
                i = R.id.disclaimer_TV;
                TextView textView = (TextView) view.findViewById(R.id.disclaimer_TV);
                if (textView != null) {
                    i = R.id.login_container;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.login_container);
                    if (relativeLayout != null) {
                        i = R.id.logoIV;
                        ImageView imageView = (ImageView) view.findViewById(R.id.logoIV);
                        if (imageView != null) {
                            i = R.id.proceed_btn;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.proceed_btn);
                            if (materialButton != null) {
                                return new FragmentLoginBinding((ScrollView) view, maskedEditText, cardView, textView, relativeLayout, imageView, materialButton);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
