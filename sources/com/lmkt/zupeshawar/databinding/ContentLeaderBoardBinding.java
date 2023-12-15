package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ContentLeaderBoardBinding implements ViewBinding {
    private final NestedScrollView rootView;
    public final RecyclerView rv;

    private ContentLeaderBoardBinding(NestedScrollView nestedScrollView, RecyclerView recyclerView) {
        this.rootView = nestedScrollView;
        this.rv = recyclerView;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static ContentLeaderBoardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ContentLeaderBoardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.content_leader_board, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ContentLeaderBoardBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        if (recyclerView != null) {
            return new ContentLeaderBoardBinding((NestedScrollView) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rv)));
    }
}
