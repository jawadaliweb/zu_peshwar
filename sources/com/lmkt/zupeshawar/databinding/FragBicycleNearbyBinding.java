package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragBicycleNearbyBinding implements ViewBinding {
    public final MaterialButton BtnZuWallet;
    public final CardView cardView;
    public final CardView cardView1;
    public final RelativeLayout qrScanBtn;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final EditText searchStationET;

    private FragBicycleNearbyBinding(RelativeLayout relativeLayout, MaterialButton materialButton, CardView cardView2, CardView cardView3, RelativeLayout relativeLayout2, RecyclerView recyclerView2, EditText editText) {
        this.rootView = relativeLayout;
        this.BtnZuWallet = materialButton;
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.qrScanBtn = relativeLayout2;
        this.recyclerView = recyclerView2;
        this.searchStationET = editText;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragBicycleNearbyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragBicycleNearbyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_nearby, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragBicycleNearbyBinding bind(View view) {
        int i = R.id.Btn_ZuWallet;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_ZuWallet);
        if (materialButton != null) {
            i = R.id.cardView;
            CardView cardView2 = (CardView) view.findViewById(R.id.cardView);
            if (cardView2 != null) {
                i = R.id.card_view1;
                CardView cardView3 = (CardView) view.findViewById(R.id.card_view1);
                if (cardView3 != null) {
                    i = R.id.qr_scan_Btn;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qr_scan_Btn);
                    if (relativeLayout != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView);
                        if (recyclerView2 != null) {
                            i = R.id.searchStation_ET;
                            EditText editText = (EditText) view.findViewById(R.id.searchStation_ET);
                            if (editText != null) {
                                return new FragBicycleNearbyBinding((RelativeLayout) view, materialButton, cardView2, cardView3, relativeLayout, recyclerView2, editText);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
