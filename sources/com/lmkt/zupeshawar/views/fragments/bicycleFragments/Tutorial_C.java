package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.google.firebase.messaging.ServiceStarter;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;

public class Tutorial_C extends Fragment implements View.OnClickListener, IOnBackPressed {
    static int Title = 2131886363;
    Button Btn_Done;
    BicycleMenuItem activity;
    ImageView arrow_IV;
    View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_tutorial_c, viewGroup, false);
        this.view = inflate;
        return inflate;
    }

    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        try {
            initViews(view2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view2) throws Exception {
        initToolbar();
        Button button = (Button) view2.findViewById(R.id.Btn_Done);
        this.Btn_Done = button;
        button.setOnClickListener(this);
        this.arrow_IV = (ImageView) view2.findViewById(R.id.arrow_IV);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 100.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(800);
        translateAnimation.setRepeatCount(ServiceStarter.ERROR_UNKNOWN);
        translateAnimation.setRepeatMode(2);
        this.arrow_IV.startAnimation(translateAnimation);
    }

    private void initToolbar() {
        BicycleMenuItem bicycleMenuItem = (BicycleMenuItem) getActivity();
        this.activity = bicycleMenuItem;
        bicycleMenuItem.mToolbar_Title.setText(Title);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.Btn_Back) {
            this.activity.loadFragment(new Tutorial_B(), 0);
        } else if (id == R.id.Btn_Done) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }

    public boolean onBackPressed() {
        this.activity.loadFragment(new Tutorial_B(), 0);
        return true;
    }
}
