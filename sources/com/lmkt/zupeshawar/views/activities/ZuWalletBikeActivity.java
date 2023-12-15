package com.lmkt.zupeshawar.views.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.lmkt.zupeshawar.R;

public class ZuWalletBikeActivity extends AppCompatActivity {
    private static String Title = "Zu Wallet Bike";
    TextView Balance_TV;
    public ImageView mToolbar_LeftBtn;
    public TextView mToolbar_Title;
    public Toolbar toolbar;

    public void applyOverrideConfiguration(Configuration configuration) {
        if (configuration != null) {
            int i = configuration.uiMode;
            configuration.setTo(getBaseContext().getResources().getConfiguration());
            configuration.uiMode = i;
        }
        super.applyOverrideConfiguration(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_qr_scan);
        try {
            initViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initViews() throws Exception {
        init_Toolbar();
    }

    private void init_Toolbar() throws Exception {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.toolbar.setTitle((CharSequence) "");
        this.mToolbar_Title = (TextView) this.toolbar.findViewById(R.id.toolbar_title);
        this.mToolbar_LeftBtn = (ImageView) this.toolbar.findViewById(R.id.notification_IV);
        setSupportActionBar(this.toolbar);
        this.mToolbar_Title.setText(Title);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
        return true;
    }
}
