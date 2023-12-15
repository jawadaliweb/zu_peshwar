package com.lmkt.zupeshawar.views.fragments.busFragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.model.AdvertImages;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import com.lmkt.zupeshawar.views.activities.ZuWalletActivity;
import com.lmkt.zupeshawar.views.adapters.BusHoursAdapter;
import com.ortiz.touchview.TouchImageView;
import java.util.ArrayList;
import me.relex.circleindicator.CircleIndicator;

public class BusServiceHours extends Fragment implements View.OnClickListener, IOnBackPressed, APIManager.Callback {
    MainMenuItemActivity activity;
    MaterialButton clickMe;
    Dialog dialog;
    TouchImageView imageView;
    CircleIndicator indicator;
    ListView listServiceHours;
    MaterialButton openDetails_btn;
    ProgressBar progress_bar;
    ViewPager viewPager;
    MaterialButton zu_wallet_Btn;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_servicehours, viewGroup, false);
        try {
            initViews(inflate);
            initServiceHours();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflate;
    }

    private void initServiceHours() {
        this.activity.appAlerts.showPleaseWait(this.activity);
        APIManager.getInstance().getServiceHours(this, getContext());
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.listServiceHours = (ListView) view.findViewById(R.id.listServiceHours);
        this.zu_wallet_Btn = (MaterialButton) view.findViewById(R.id.zu_wallet_Btn);
        this.imageView = (TouchImageView) view.findViewById(R.id.ZuMap_IV);
        this.progress_bar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.viewPager = (ViewPager) view.findViewById(R.id.SliderContainer);
        this.indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        this.zu_wallet_Btn.setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
    }

    private void initToolbar() {
        MainMenuItemActivity mainMenuItemActivity = (MainMenuItemActivity) getActivity();
        this.activity = mainMenuItemActivity;
        mainMenuItemActivity.mToolbar_Title.setText(R.string.title_servicehours);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            this.activity.onBackPressed();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        } else if (id == R.id.openDetails_btn) {
            this.activity.appAlerts.showServiceDetails(this.activity, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    BusServiceHours.this.lambda$onClick$0$BusServiceHours();
                }
            });
        } else if (id == R.id.zu_wallet_Btn) {
            this.activity.onBackPressed();
            startActivity(new Intent(getContext(), ZuWalletActivity.class));
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }

    public /* synthetic */ void lambda$onClick$0$BusServiceHours() {
        this.activity.appAlerts.dismiss();
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.OK()) {
            this.activity.appAlerts.dismiss();
            this.viewPager.setAdapter(new BusHoursAdapter(getContext(), apiResponse.getData().getAdvertImages()));
            this.indicator.setViewPager(this.viewPager);
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, apiResponse.getRespMessage());
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, apiResponse.getRespMessage());
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    BusServiceHours.this.lambda$onSuccess$1$BusServiceHours();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSuccess$1$BusServiceHours() {
        this.activity.appAlerts.dismiss();
        this.activity.onBackPressed();
    }

    public void onFailure(int i, String str) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, str);
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    BusServiceHours.this.lambda$onFailure$2$BusServiceHours();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onFailure$2$BusServiceHours() {
        this.activity.appAlerts.dismiss();
        this.activity.onBackPressed();
    }

    private class ListAdapter extends ArrayAdapter {
        ArrayList<AdvertImages> images_data;
        LayoutInflater inflater;
        int length = 0;

        public ListAdapter(Context context, ArrayList arrayList) {
            super(context, 0, arrayList);
            this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
            this.length = arrayList.size();
            this.images_data = arrayList;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = this.inflater.inflate(R.layout.row_item_service_hours, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.no_record_found);
            TouchImageView touchImageView = (TouchImageView) inflate.findViewById(R.id.images);
            if (this.length > 0) {
                textView.setVisibility(8);
                touchImageView.setVisibility(0);
            } else {
                textView.setVisibility(0);
                touchImageView.setVisibility(8);
            }
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) BusServiceHours.this.activity).load(this.images_data.get(i).getImageUrl()).placeholder((int) R.mipmap.ic_detail_)).signature(new ObjectKey(String.valueOf(System.currentTimeMillis())))).diskCacheStrategy(DiskCacheStrategy.ALL)).transition(new DrawableTransitionOptions().crossFade()).listener(new RequestListener<Drawable>() {
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                    BusServiceHours.this.progress_bar.setVisibility(8);
                    return false;
                }

                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                    BusServiceHours.this.progress_bar.setVisibility(8);
                    return false;
                }
            }).into((ImageView) touchImageView);
            return inflate;
        }
    }
}
