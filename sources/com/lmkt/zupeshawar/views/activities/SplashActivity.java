package com.lmkt.zupeshawar.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.model.User;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class SplashActivity extends AppCompatActivity {
    private boolean isFromFirebase = false;
    /* access modifiers changed from: private */
    public ImageView logoIV;
    User user;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_splash);
        AppCenter.start(getApplication(), "3c6369d0-556a-410c-9c00-ae18015ecd92", Analytics.class, Crashes.class);
        this.user = SharedPrefrencesUtil.getUserObject_Prefrences(this);
        if (getIntent().getExtras() != null) {
            this.isFromFirebase = getIntent().getExtras().getBoolean("isFromFirebase");
        }
        this.logoIV = (ImageView) findViewById(R.id.logoIV);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.hold);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.translate_scale);
        this.logoIV.startAnimation(loadAnimation);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SplashActivity.this.logoIV.clearAnimation();
                if (SplashActivity.this.user == null || !SplashActivity.this.user.isLogged_In()) {
                    SplashActivity.this.startUserResgistration();
                } else {
                    SplashActivity.this.startMainDashboard();
                }
            }
        });
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SplashActivity.this.logoIV.clearAnimation();
                SplashActivity.this.logoIV.startAnimation(loadAnimation2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void startUserResgistration() {
        startActivity(new Intent(this, RegistrationActivity.class));
        finish();
    }

    /* access modifiers changed from: private */
    public void startMainDashboard() {
        Intent intent = new Intent(this, MainDashboard.class);
        intent.putExtra("isFromFirebase", true);
        startActivity(intent);
        finish();
    }
}
