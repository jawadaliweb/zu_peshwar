package com.lmkt.zupeshawar.views.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Constants;
import com.lmkt.zupeshawar.views.fragments.navDrawer.CustomerFeedback;
import com.lmkt.zupeshawar.views.fragments.navDrawer.MyProfile;
import com.lmkt.zupeshawar.views.fragments.navDrawer.NavFQA;
import com.lmkt.zupeshawar.views.fragments.navDrawer.NavFare;
import com.lmkt.zupeshawar.views.fragments.navDrawer.NavHelpline;
import com.lmkt.zupeshawar.views.fragments.navDrawer.Settings;
import com.lmkt.zupeshawar.views.fragments.navDrawer.YoutubeChannel;
import com.lmkt.zupeshawar.views.fragments.ticketsFragments.WhatsNew;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.ingestion.models.CommonProperties;

public class NavigationDrawerItemsActivity extends BaseActivity {
    FrameLayout frame;
    public ImageView mToolbar_LeftBtn;
    public TextView mToolbar_Title;
    public Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_navigationdraweritems);
        try {
            initViews();
            init_Toolbar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame, fragment);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        beginTransaction.commit();
    }

    public void initViews() {
        this.frame = (FrameLayout) findViewById(R.id.frame);
        String stringExtra = getIntent().getStringExtra(CommonProperties.TYPE);
        stringExtra.hashCode();
        char c = 65535;
        switch (stringExtra.hashCode()) {
            case -1206184832:
                if (stringExtra.equals("youtubechannel")) {
                    c = 0;
                    break;
                }
                break;
            case -789055819:
                if (stringExtra.equals("helpline")) {
                    c = 1;
                    break;
                }
                break;
            case -299848349:
                if (stringExtra.equals("customerfeedback")) {
                    c = 2;
                    break;
                }
                break;
            case 101142:
                if (stringExtra.equals(Constants.FAQS)) {
                    c = 3;
                    break;
                }
                break;
            case 3135534:
                if (stringExtra.equals("fare")) {
                    c = 4;
                    break;
                }
                break;
            case 673186429:
                if (stringExtra.equals("myprofile")) {
                    c = 5;
                    break;
                }
                break;
            case 829492967:
                if (stringExtra.equals("invitefriend")) {
                    c = 6;
                    break;
                }
                break;
            case 1309302844:
                if (stringExtra.equals("whatNew")) {
                    c = 7;
                    break;
                }
                break;
            case 1985941072:
                if (stringExtra.equals("setting")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/channel/UCYNvRxzsiYslKiNii-MetmA"));
                intent.addFlags(268435456);
                intent.setPackage("com.google.android.youtube");
                if (getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                    startActivity(intent);
                    return;
                } else {
                    loadFragment(new YoutubeChannel());
                    return;
                }
            case 1:
                loadFragment(new NavHelpline());
                return;
            case 2:
                loadFragment(new CustomerFeedback());
                return;
            case 3:
                loadFragment(new NavFQA());
                return;
            case 4:
                loadFragment(new NavFare());
                return;
            case 5:
                loadFragment(new MyProfile());
                return;
            case 6:
                onBackPressed();
                Intent intent2 = new Intent("android.intent.action.SEND");
                String string = getResources().getString(R.string.txt_appshare);
                intent2.setType(ErrorAttachmentLog.CONTENT_TYPE_TEXT_PLAIN);
                intent2.putExtra("android.intent.extra.SUBJECT", "Share Zu App");
                intent2.putExtra("android.intent.extra.TEXT", string);
                startActivity(Intent.createChooser(intent2, "Share Using"));
                return;
            case 7:
                loadFragment(new WhatsNew());
                return;
            case 8:
                loadFragment(new Settings());
                return;
            default:
                return;
        }
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
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        return true;
    }
}
