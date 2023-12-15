package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;

public final class ActivitySearchStationsBinding implements ViewBinding {
    public final FrameLayout BtnBack;
    public final CardView BtnMembership;
    public final IndexFastScrollRecyclerView mainSearchRV;
    public final LinearLayout recentSearchLayout;
    public final IndexFastScrollRecyclerView recentSearchRV;
    private final LinearLayout rootView;
    public final EditText searchET;

    private ActivitySearchStationsBinding(LinearLayout linearLayout, FrameLayout frameLayout, CardView cardView, IndexFastScrollRecyclerView indexFastScrollRecyclerView, LinearLayout linearLayout2, IndexFastScrollRecyclerView indexFastScrollRecyclerView2, EditText editText) {
        this.rootView = linearLayout;
        this.BtnBack = frameLayout;
        this.BtnMembership = cardView;
        this.mainSearchRV = indexFastScrollRecyclerView;
        this.recentSearchLayout = linearLayout2;
        this.recentSearchRV = indexFastScrollRecyclerView2;
        this.searchET = editText;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySearchStationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySearchStationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_search_stations, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySearchStationsBinding bind(View view) {
        int i = R.id.Btn_Back;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.Btn_Back);
        if (frameLayout != null) {
            i = R.id.Btn_Membership;
            CardView cardView = (CardView) view.findViewById(R.id.Btn_Membership);
            if (cardView != null) {
                i = R.id.mainSearch_RV;
                IndexFastScrollRecyclerView indexFastScrollRecyclerView = (IndexFastScrollRecyclerView) view.findViewById(R.id.mainSearch_RV);
                if (indexFastScrollRecyclerView != null) {
                    i = R.id.recentSearchLayout;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.recentSearchLayout);
                    if (linearLayout != null) {
                        i = R.id.recentSearch_RV;
                        IndexFastScrollRecyclerView indexFastScrollRecyclerView2 = (IndexFastScrollRecyclerView) view.findViewById(R.id.recentSearch_RV);
                        if (indexFastScrollRecyclerView2 != null) {
                            i = R.id.search_ET;
                            EditText editText = (EditText) view.findViewById(R.id.search_ET);
                            if (editText != null) {
                                return new ActivitySearchStationsBinding((LinearLayout) view, frameLayout, cardView, indexFastScrollRecyclerView, linearLayout, indexFastScrollRecyclerView2, editText);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
