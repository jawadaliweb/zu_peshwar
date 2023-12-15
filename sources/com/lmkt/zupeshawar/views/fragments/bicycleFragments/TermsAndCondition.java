package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;
import com.lmkt.zupeshawar.views.adapters.TermsAndConditionImageSliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;

public class TermsAndCondition extends Fragment implements View.OnClickListener {
    private static final String TAG = "TermsAndCondition";
    BicycleMenuItem activity;
    private TermsAndConditionImageSliderAdapter adapter = null;
    ProgressBar progress_bar;
    SliderView sliderView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_terms_and_conditions, viewGroup, false);
        try {
            initViews(inflate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflate;
    }

    private void initImageSlider() {
        this.sliderView.setIndicatorAnimation(IndicatorAnimationType.SLIDE);
        this.sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        this.sliderView.setIndicatorSelectedColor(-1);
        this.sliderView.setIndicatorUnselectedColor(-7829368);
        this.sliderView.setScrollTimeInSec(4);
        ArrayList arrayList = new ArrayList();
        if (SharedPrefrencesUtil.getBoolean("Is_Urdu_Lan", this.activity)) {
            arrayList.add("Zu_Bicycle_Reg_Urdu.jpg");
            arrayList.add("Zu_Bicycle_Fare_Urdu.jpeg");
            arrayList.add("Zu_Bicycle_CoC_Urdu.jpg");
        } else {
            arrayList.add("Zu_Bicycle_Reg_Eng.jpg");
            arrayList.add("Zu_Bicycle_Fare_Eng.jpeg");
            arrayList.add("Zu_Bicycle_CoC_Eng.jpg");
        }
        TermsAndConditionImageSliderAdapter termsAndConditionImageSliderAdapter = new TermsAndConditionImageSliderAdapter(this.activity, arrayList);
        this.adapter = termsAndConditionImageSliderAdapter;
        this.sliderView.setSliderAdapter(termsAndConditionImageSliderAdapter);
        this.adapter.notifyDataSetChanged();
        this.sliderView.setCurrentPageListener(new SliderView.OnSliderPageListener() {
            public void onSliderPageChanged(int i) {
                if (i == 0) {
                    TermsAndCondition.this.activity.mToolbar_Title.setText(TermsAndCondition.this.getResources().getString(R.string.label_Bicycle_reg));
                } else if (i == 1) {
                    TermsAndCondition.this.activity.mToolbar_Title.setText(TermsAndCondition.this.getResources().getString(R.string.label_Bicycle_fare));
                } else if (i != 2) {
                    TermsAndCondition.this.activity.mToolbar_Title.setText(TermsAndCondition.this.getResources().getString(R.string.label_Bicycle_reg));
                } else {
                    TermsAndCondition.this.activity.mToolbar_Title.setText(TermsAndCondition.this.getResources().getString(R.string.label_Bicycle_coc));
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.sliderView = (SliderView) view.findViewById(R.id.imageSlider);
        this.progress_bar = (ProgressBar) view.findViewById(R.id.progress_bar);
        initImageSlider();
    }

    private void initToolbar() {
        BicycleMenuItem bicycleMenuItem = (BicycleMenuItem) getActivity();
        this.activity = bicycleMenuItem;
        bicycleMenuItem.mToolbar_Title.setText(R.string.label_Bicycle_reg);
        this.activity.mToolbar_BackBtn.setVisibility(0);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }
}
