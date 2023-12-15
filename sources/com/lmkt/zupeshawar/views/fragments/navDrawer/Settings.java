package com.lmkt.zupeshawar.views.fragments.navDrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import com.franmontiel.localechanger.utils.ActivityRecreationHelper;
import com.google.android.material.button.MaterialButton;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.Utilities.TypefaceUtil;
import com.lmkt.zupeshawar.application.App;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.views.activities.MainDashboard;
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class Settings extends Fragment implements View.OnClickListener {
    static String Title = "Setting";
    NavigationDrawerItemsActivity activity;
    SwitchCompat changeLan_SW;
    MaterialButton logout_btn;
    SwitchCompat notificationSwitch;
    MaterialButton privacyPolicy;
    MaterialButton termsAndConditionBtm;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_navi_setting, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            this.activity = (NavigationDrawerItemsActivity) getActivity();
            initViews(view);
            initListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.changeLan_SW = (SwitchCompat) view.findViewById(R.id.changeLan_SW);
        this.notificationSwitch = (SwitchCompat) view.findViewById(R.id.notificationSwitch);
        this.logout_btn = (MaterialButton) view.findViewById(R.id.logout_btn);
        this.termsAndConditionBtm = (MaterialButton) view.findViewById(R.id.termsAndConditionBtm);
        this.privacyPolicy = (MaterialButton) view.findViewById(R.id.privacyPolicy);
        this.logout_btn.setOnClickListener(this);
        this.termsAndConditionBtm.setOnClickListener(this);
        this.privacyPolicy.setOnClickListener(this);
        if (SharedPrefrencesUtil.getBoolean("Is_Urdu_Lan", this.activity)) {
            this.changeLan_SW.setChecked(true);
        } else {
            this.changeLan_SW.setChecked(false);
        }
        if (SharedPrefrencesUtil.getBoolean("Is_notify", this.activity)) {
            this.notificationSwitch.setChecked(true);
        } else {
            this.notificationSwitch.setChecked(false);
        }
    }

    private void initListener() throws Exception {
        this.changeLan_SW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Settings.this.lambda$initListener$0$Settings(compoundButton, z);
            }
        });
        this.notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Settings.this.lambda$initListener$1$Settings(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$Settings(CompoundButton compoundButton, boolean z) {
        if (z) {
            SharedPrefrencesUtil.saveBoolean("Is_Urdu_Lan", true, this.activity);
            setLocale("ur");
            compoundButton.setChecked(true);
            return;
        }
        SharedPrefrencesUtil.saveBoolean("Is_Urdu_Lan", false, this.activity);
        setLocale("en");
        compoundButton.setChecked(false);
    }

    public /* synthetic */ void lambda$initListener$1$Settings(CompoundButton compoundButton, boolean z) {
        if (z) {
            SharedPrefrencesUtil.saveBoolean("Is_notify", true, this.activity);
        } else {
            SharedPrefrencesUtil.saveBoolean("Is_notify", false, this.activity);
            SharedPrefrencesUtil.saveBoolean("Is_Urdu_Lan", false, this.activity);
        }
        if (z) {
            try {
                notifyAPI(false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            notifyAPI(true);
        }
    }

    public static void setLocale(String str) {
        ActivityRecreationHelper.recreate(MainDashboard.instance, true);
        if (str.equals("ur")) {
            TypefaceUtil.overrideFont(App.getInstance(), "SERIF", "fonts/urdu_regular.ttf");
        } else {
            TypefaceUtil.overrideFont(App.getInstance(), "SERIF", "fonts/psr.ttf");
        }
    }

    public void notifyAPI(boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("DisableNotification", z);
        APIManager.getInstance().notificationOnOff(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                Log.e("Error/Success", apiResponse.getRespMessage());
            }

            public void onFailure(int i, String str) {
                Log.e("Hello", str);
            }
        }, (JsonObject) new JsonParser().parse(jSONObject.toString()), this.activity.getApplicationContext());
    }

    private void initToolbar() {
        this.activity.mToolbar_Title.setText(Title);
        this.activity.mToolbar_LeftBtn.setVisibility(8);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.logout_btn) {
            this.activity.appAlerts.showLogout(this.activity);
        } else if (id == R.id.privacyPolicy) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://transpeshawar.pk/about/privacy-policy/")));
        } else if (id == R.id.termsAndConditionBtm) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://transpeshawar.pk/terms-conditions/")));
        }
    }
}
