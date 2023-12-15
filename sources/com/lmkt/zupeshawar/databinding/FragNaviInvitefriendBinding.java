package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import java.util.Objects;

public final class FragNaviInvitefriendBinding implements ViewBinding {
    private final LinearLayout rootView;

    private FragNaviInvitefriendBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragNaviInvitefriendBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragNaviInvitefriendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_invitefriend, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragNaviInvitefriendBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new FragNaviInvitefriendBinding((LinearLayout) view);
    }
}
