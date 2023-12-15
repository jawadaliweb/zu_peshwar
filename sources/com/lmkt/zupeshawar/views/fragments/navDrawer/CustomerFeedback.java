package com.lmkt.zupeshawar.views.fragments.navDrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;

public class CustomerFeedback extends Fragment implements View.OnClickListener {
    NavigationDrawerItemsActivity activity;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_navi_customerfeedback, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        initToolbar();
    }

    private void initToolbar() {
        NavigationDrawerItemsActivity navigationDrawerItemsActivity = (NavigationDrawerItemsActivity) getActivity();
        this.activity = navigationDrawerItemsActivity;
        navigationDrawerItemsActivity.mToolbar_Title.setText(R.string.title_customerFeedback);
        this.activity.mToolbar_LeftBtn.setVisibility(8);
    }

    public void onClick(View view) {
        view.getId();
    }
}
