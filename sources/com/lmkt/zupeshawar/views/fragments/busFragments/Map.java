package com.lmkt.zupeshawar.views.fragments.busFragments;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Map.PinView;
import com.lmkt.zupeshawar.Utilities.Map.subscaleview.ImageSource;
import com.lmkt.zupeshawar.Utilities.Map.subscaleview.SubsamplingScaleImageView;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import com.ortiz.touchview.TouchImageView;

public class Map extends Fragment implements View.OnClickListener, IOnBackPressed, SubsamplingScaleImageView.OnImageEventListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    TouchImageView ZuMap_IV;
    MainMenuItemActivity activity;
    private PinView imageView;
    private ProgressBar mProgressBar;
    private float mScaleFactor = 1.0f;
    private ScaleGestureDetector mScaleGestureDetector;

    public boolean onBackPressed() {
        return false;
    }

    public void onImageLoadError(Exception exc) {
    }

    public void onImageLoaded() {
    }

    public void onPreviewLoadError(Exception exc) {
    }

    public void onPreviewReleased() {
    }

    public void onTileLoadError(Exception exc) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_mainmenu_map, viewGroup, false);
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
        this.ZuMap_IV = (TouchImageView) view.findViewById(R.id.ZuMap_IV);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.mProgressBar = progressBar;
        progressBar.bringToFront();
        PinView pinView = (PinView) view.findViewById(R.id.imageView);
        this.imageView = pinView;
        pinView.setMinimumScaleType(1);
        this.imageView.setZoomEnabled(true);
        this.imageView.setImage(ImageSource.resource(R.drawable.map));
        this.imageView.setOnImageEventListener(this);
        this.imageView.setVisibility(0);
        this.imageView.bringToFront();
        this.activity.appAlerts.showPleaseWait(this.activity);
    }

    private void initToolbar() {
        MainMenuItemActivity mainMenuItemActivity = (MainMenuItemActivity) getActivity();
        this.activity = mainMenuItemActivity;
        mainMenuItemActivity.mToolbar_Title.setText(R.string.title_zumap);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }

    public void onReady() {
        this.activity.appAlerts.dismiss();
        PointF viewToSourceCoord = this.imageView.viewToSourceCoord(this.imageView.getCenter());
        this.imageView.doubleTapZoom(viewToSourceCoord, viewToSourceCoord);
    }
}
