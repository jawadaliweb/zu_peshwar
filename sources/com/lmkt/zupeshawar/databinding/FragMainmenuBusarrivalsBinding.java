package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Map.PinView;

public final class FragMainmenuBusarrivalsBinding implements ViewBinding {
    public final MaterialButton BtnZuWallet;
    public final CardView cardView;
    public final CardView cardView1;
    public final AppCompatButton date;
    public final PinView imageView;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final EditText searchStationET;
    public final RelativeLayout zuWalletBtn;

    private FragMainmenuBusarrivalsBinding(RelativeLayout relativeLayout, MaterialButton materialButton, CardView cardView2, CardView cardView3, AppCompatButton appCompatButton, PinView pinView, ProgressBar progressBar2, EditText editText, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.BtnZuWallet = materialButton;
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.date = appCompatButton;
        this.imageView = pinView;
        this.progressBar = progressBar2;
        this.searchStationET = editText;
        this.zuWalletBtn = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragMainmenuBusarrivalsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragMainmenuBusarrivalsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_busarrivals, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragMainmenuBusarrivalsBinding bind(View view) {
        int i = R.id.Btn_ZuWallet;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_ZuWallet);
        if (materialButton != null) {
            i = R.id.card_view;
            CardView cardView2 = (CardView) view.findViewById(R.id.card_view);
            if (cardView2 != null) {
                i = R.id.card_view1;
                CardView cardView3 = (CardView) view.findViewById(R.id.card_view1);
                if (cardView3 != null) {
                    i = R.id.date;
                    AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.date);
                    if (appCompatButton != null) {
                        i = R.id.imageView;
                        PinView pinView = (PinView) view.findViewById(R.id.imageView);
                        if (pinView != null) {
                            i = R.id.progress_bar;
                            ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progress_bar);
                            if (progressBar2 != null) {
                                i = R.id.searchStation_ET;
                                EditText editText = (EditText) view.findViewById(R.id.searchStation_ET);
                                if (editText != null) {
                                    i = R.id.zu_wallet_Btn;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.zu_wallet_Btn);
                                    if (relativeLayout != null) {
                                        return new FragMainmenuBusarrivalsBinding((RelativeLayout) view, materialButton, cardView2, cardView3, appCompatButton, pinView, progressBar2, editText, relativeLayout);
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
