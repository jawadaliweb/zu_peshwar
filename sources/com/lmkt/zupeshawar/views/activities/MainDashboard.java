package com.lmkt.zupeshawar.views.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Constants;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.db.AppExecutors;
import com.lmkt.zupeshawar.db.BicyclesTB;
import com.lmkt.zupeshawar.db.DBZuApp;
import com.lmkt.zupeshawar.model.AccountBalance;
import com.lmkt.zupeshawar.model.AdvertImages;
import com.lmkt.zupeshawar.model.BicycleStandModel;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.TokenDetails;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.views.activities.MainDashboard;
import com.lmkt.zupeshawar.views.adapters.ImageSliderAdapter;
import com.lmkt.zupeshawar.views.adapters.ViewPagerAdapter;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.QRScann;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;
import ru.nikartm.support.ImageBadgeView;

public class MainDashboard extends BaseActivity implements View.OnClickListener, APIManager.Callback {
    private static final int ZUBarCode = 1021;
    public static MainDashboard instance = null;
    public static final String receiveTAG = "com.lmkt.notification";
    public TextView TV_UserBalance;
    private TextView TV_UserTitle;
    private int UPDATE_REQUEST_CODE = 200;
    private int UPDATE_REQUEST_CODE_FAILED = 100;
    /* access modifiers changed from: private */
    public ImageSliderAdapter adapter;
    private long mLastClickTime = 0;
    /* access modifiers changed from: private */
    public TabLayout mTabLayout;
    TextView mTitle;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private LinearLayout navBtn_CustomerFeedback;
    private LinearLayout navBtn_FAQ;
    private LinearLayout navBtn_Fare;
    private LinearLayout navBtn_Helpline;
    private LinearLayout navBtn_InviteFriend;
    private LinearLayout navBtn_MyProfile;
    private LinearLayout navBtn_YoutubeChannel;
    private LinearLayout naviBtn_WhatsNew;
    ImageBadgeView notificationIV;
    Button qr_scan_Btn;
    private NotificationReceiver receiver;
    SliderView sliderView;
    Toolbar toolbar;
    private AppUpdateManager updateManager;
    User user;
    Button zu_wallet_Btn;

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_maindashboard);
        instance = this;
        initViews();
        initToolBar();
        initDrawer();
        initImageSlider();
        initViewPager();
        checkUpdate();
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(this);
        this.user = userObject_Prefrences;
        if (userObject_Prefrences != null && userObject_Prefrences.isLogged_In()) {
            String name = this.user.getName();
            TextView textView = this.TV_UserTitle;
            textView.setText("Welcome, " + name);
            try {
                String format = String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(this.user.getAccountBalance()))});
                TextView textView2 = this.TV_UserBalance;
                textView2.setText("RS " + format);
            } catch (Exception unused) {
                TextView textView3 = this.TV_UserBalance;
                textView3.setText("RS " + this.user.getAccountBalance());
            }
        }
        if (getIntent().getExtras() != null && getIntent().getExtras().getBoolean("isFromFirebase")) {
            checkUserBalance();
        }
    }

    private void checkUpdate() {
        AppUpdateManager create = AppUpdateManagerFactory.create(getBaseContext());
        this.updateManager = create;
        create.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() {
            public final void onSuccess(Object obj) {
                MainDashboard.this.lambda$checkUpdate$0$MainDashboard((AppUpdateInfo) obj);
            }
        });
    }

    public /* synthetic */ void lambda$checkUpdate$0$MainDashboard(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(0)) {
            startUpdateFlow(appUpdateInfo);
        }
    }

    private void startUpdateFlow(AppUpdateInfo appUpdateInfo) {
        try {
            this.updateManager.startUpdateFlowForResult(appUpdateInfo, 1, (Activity) this, this.UPDATE_REQUEST_CODE);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    private void initViews() {
        this.TV_UserBalance = (TextView) findViewById(R.id.TV_UserBalance);
        this.TV_UserTitle = (TextView) findViewById(R.id.TV_UserTitle);
    }

    private void initToolBar() {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        toolbar2.setTitle((CharSequence) "");
        this.mTitle = (TextView) this.toolbar.findViewById(R.id.toolbar_title);
        this.notificationIV = (ImageBadgeView) this.toolbar.findViewById(R.id.notification_IV);
        this.mTitle.setText(R.string.app_name);
        setSupportActionBar(this.toolbar);
        this.notificationIV.setOnClickListener(this);
    }

    private void initDrawer() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        this.navBtn_InviteFriend = (LinearLayout) findViewById(R.id.naviBtn_InviteFriend);
        this.navBtn_CustomerFeedback = (LinearLayout) findViewById(R.id.naviBtn_CustomerFeedback);
        this.navBtn_YoutubeChannel = (LinearLayout) findViewById(R.id.naviBtn_YoutubeChannel);
        this.navBtn_Helpline = (LinearLayout) findViewById(R.id.naviBtn_Helpline);
        this.navBtn_FAQ = (LinearLayout) findViewById(R.id.naviBtn_FAQ);
        this.navBtn_Fare = (LinearLayout) findViewById(R.id.naviBtn_Fare);
        this.navBtn_MyProfile = (LinearLayout) findViewById(R.id.naviBtn_MyProfile);
        this.naviBtn_WhatsNew = (LinearLayout) findViewById(R.id.naviBtn_WhatsNew);
        ((LinearLayout) findViewById(R.id.naviBtn_Setting)).setOnClickListener(this);
        this.navBtn_InviteFriend.setOnClickListener(this);
        this.navBtn_CustomerFeedback.setOnClickListener(this);
        this.navBtn_YoutubeChannel.setOnClickListener(this);
        this.navBtn_Helpline.setOnClickListener(this);
        this.navBtn_FAQ.setOnClickListener(this);
        this.navBtn_Fare.setOnClickListener(this);
        this.navBtn_MyProfile.setOnClickListener(this);
        this.naviBtn_WhatsNew.setOnClickListener(this);
    }

    private static void updateUserBalance(AccountBalance accountBalance, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        String accountBalance2 = accountBalance.getAccountBalance();
        Objects.requireNonNull(accountBalance2);
        userObject_Prefrences.setAccountBalance(accountBalance2);
        String lastUpdatedOn = accountBalance.getLastUpdatedOn();
        Objects.requireNonNull(lastUpdatedOn);
        userObject_Prefrences.setAccountBalanceasOn(lastUpdatedOn);
        SharedPrefrencesUtil.saveUserObject_Prefrences(userObject_Prefrences, context);
    }

    private void initViewPager() {
        Button button = (Button) findViewById(R.id.qr_scan_Btn);
        this.qr_scan_Btn = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.zu_wallet_Btn);
        this.zu_wallet_Btn = button2;
        button2.setOnClickListener(this);
        this.mViewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        this.mViewPagerAdapter = viewPagerAdapter;
        this.mViewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        this.mTabLayout = tabLayout;
        tabLayout.addTab(tabLayout.newTab());
        TabLayout tabLayout2 = this.mTabLayout;
        tabLayout2.addTab(tabLayout2.newTab());
        TabLayout tabLayout3 = this.mTabLayout;
        tabLayout3.addTab(tabLayout3.newTab());
        this.mTabLayout.setTabMode(1);
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.mTabLayout.setTabTextColors(getResources().getColor(R.color.txt_color_Lightgrey), getResources().getColor(R.color.colorBlack));
        this.mTabLayout.setScrollPosition(2, 0.0f, true);
        this.mTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1) {
                    MainDashboard.this.mTabLayout.setSelectedTabIndicatorColor(MainDashboard.this.getResources().getColor(R.color.colorRed));
                    MainDashboard.this.zu_wallet_Btn.setVisibility(8);
                    MainDashboard.this.qr_scan_Btn.setVisibility(0);
                    return;
                }
                MainDashboard.this.mTabLayout.setSelectedTabIndicatorColor(MainDashboard.this.getResources().getColor(R.color.colorGreen));
                MainDashboard.this.zu_wallet_Btn.setVisibility(0);
                MainDashboard.this.qr_scan_Btn.setVisibility(8);
            }
        });
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            drawerLayout.closeDrawer((int) GravityCompat.START);
            return;
        }
        super.onBackPressed();
        finishAffinity();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void onClick(View view) {
        int id = view.getId();
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (id == R.id.notification_IV) {
            startActivity(new Intent(this, NotificationActivity.class));
            overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
        } else if (id != R.id.qr_scan_Btn) {
            if (id != R.id.zu_wallet_Btn) {
                switch (id) {
                    case R.id.naviBtn_CustomerFeedback:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        loadNavigationDrawerItems("customerfeedback");
                        return;
                    case R.id.naviBtn_FAQ:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        loadNavigationDrawerItems(Constants.FAQS);
                        return;
                    case R.id.naviBtn_Fare:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        loadNavigationDrawerItems("fare");
                        return;
                    case R.id.naviBtn_Helpline:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        loadNavigationDrawerItems("helpline");
                        return;
                    case R.id.naviBtn_InviteFriend:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        loadNavigationDrawerItems("invitefriend");
                        return;
                    case R.id.naviBtn_MyProfile:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        loadNavigationDrawerItems("myprofile");
                        return;
                    case R.id.naviBtn_Setting:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        loadNavigationDrawerItems("setting");
                        return;
                    case R.id.naviBtn_WhatsNew:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        loadNavigationDrawerItems("whatNew");
                        return;
                    case R.id.naviBtn_YoutubeChannel:
                        drawerLayout.closeDrawer((int) GravityCompat.START);
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/@transpeshawar")));
                        return;
                    default:
                        return;
                }
            } else if (SystemClock.elapsedRealtime() - this.mLastClickTime >= 1000) {
                this.mLastClickTime = SystemClock.elapsedRealtime();
                startActivityForResult(new Intent(this, ZuWalletActivity.class), 1021);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
            }
        } else if (SystemClock.elapsedRealtime() - this.mLastClickTime >= 1000) {
            this.mLastClickTime = SystemClock.elapsedRealtime();
            new QRScann(this).show(getSupportFragmentManager(), "Dialog");
        }
    }

    private void loadNavigationDrawerItems(String str) {
        Intent intent = new Intent(this, NavigationDrawerItemsActivity.class);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1206184832:
                if (str.equals("youtubechannel")) {
                    c = 0;
                    break;
                }
                break;
            case -789055819:
                if (str.equals("helpline")) {
                    c = 1;
                    break;
                }
                break;
            case -299848349:
                if (str.equals("customerfeedback")) {
                    c = 2;
                    break;
                }
                break;
            case 101142:
                if (str.equals(Constants.FAQS)) {
                    c = 3;
                    break;
                }
                break;
            case 3135534:
                if (str.equals("fare")) {
                    c = 4;
                    break;
                }
                break;
            case 673186429:
                if (str.equals("myprofile")) {
                    c = 5;
                    break;
                }
                break;
            case 829492967:
                if (str.equals("invitefriend")) {
                    c = 6;
                    break;
                }
                break;
            case 1309302844:
                if (str.equals("whatNew")) {
                    c = 7;
                    break;
                }
                break;
            case 1985941072:
                if (str.equals("setting")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                intent.putExtra(CommonProperties.TYPE, "youtubechannel");
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_left, R.anim.stay);
                return;
            case 1:
                intent.putExtra(CommonProperties.TYPE, "helpline");
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case 2:
                intent.putExtra(CommonProperties.TYPE, "customerfeedback");
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case 3:
                intent.putExtra(CommonProperties.TYPE, Constants.FAQS);
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case 4:
                intent.putExtra(CommonProperties.TYPE, "fare");
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case 5:
                intent.putExtra(CommonProperties.TYPE, "myprofile");
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case 6:
                intent.putExtra(CommonProperties.TYPE, "invitefriend");
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case 7:
                intent.putExtra(CommonProperties.TYPE, "whatNew");
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case 8:
                intent.putExtra(CommonProperties.TYPE, "setting");
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        isPermissionAvailable("android.permission.ACCESS_FINE_LOCATION");
        isPermissionAvailable("android.permission.CAMERA");
        this.receiver = new NotificationReceiver();
        String accountBalance = SharedPrefrencesUtil.getUserObject_Prefrences(this).getAccountBalance();
        try {
            String format = String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(accountBalance))});
            TextView textView = this.TV_UserBalance;
            textView.setText("RS " + format);
        } catch (Exception unused) {
            TextView textView2 = this.TV_UserBalance;
            textView2.setText("RS " + accountBalance);
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(receiveTAG);
        registerReceiver(this.receiver, intentFilter);
        this.notificationIV.setBadgeValue(SharedPrefrencesUtil.getInt(Constants.NOTIFICATION_COUNT, this));
        try {
            checkUserBalance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void checkUserBalance() {
        String userID = this.user.getUserID();
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(this);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        APIManager.getInstance().getUserAccountBalance(this, sb.toString(), userID);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        try {
            NotificationReceiver notificationReceiver = this.receiver;
            if (notificationReceiver != null) {
                unregisterReceiver(notificationReceiver);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void initImageSlider() {
        SliderView sliderView2 = (SliderView) findViewById(R.id.imageSlider);
        this.sliderView = sliderView2;
        sliderView2.setIndicatorAnimation(IndicatorAnimationType.SWAP);
        this.sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        this.sliderView.setAutoCycleDirection(2);
        this.sliderView.setIndicatorSelectedColor(-1);
        this.sliderView.setIndicatorUnselectedColor(-7829368);
        this.sliderView.setScrollTimeInSec(4);
        this.sliderView.startAutoCycle();
        String string = SharedPrefrencesUtil.getString(Constants.IMAGE_CACHED, this);
        if (!string.isEmpty()) {
            Type type = new TypeToken<ArrayList<AdvertImages>>() {
            }.getType();
            if (this.adapter == null) {
                if (new Gson().fromJson(string, type) == null) {
                    this.adapter = new ImageSliderAdapter(this, new ArrayList());
                } else {
                    this.adapter = new ImageSliderAdapter(this, (ArrayList) new Gson().fromJson(string, type));
                }
                this.sliderView.setSliderAdapter(this.adapter);
                this.adapter.notifyDataSetChanged();
            }
        } else if (this.adapter == null) {
            ImageSliderAdapter imageSliderAdapter = new ImageSliderAdapter(this, new ArrayList());
            this.adapter = imageSliderAdapter;
            this.sliderView.setSliderAdapter(imageSliderAdapter);
            this.adapter.notifyDataSetChanged();
        }
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(getApplicationContext());
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        APIManager.getInstance().getAdvertImages(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                ArrayList<AdvertImages> advertImages = apiResponse.getData().getAdvertImages();
                if (advertImages == null || advertImages.size() == 0) {
                    String string = SharedPrefrencesUtil.getString(Constants.IMAGE_CACHED, MainDashboard.this);
                    if (!string.isEmpty()) {
                        Type type = new TypeToken<ArrayList<AdvertImages>>() {
                        }.getType();
                        if (new Gson().fromJson(string, type) != null) {
                            MainDashboard.this.adapter.setAdvertImages((ArrayList) new Gson().fromJson(string, type));
                        } else {
                            MainDashboard.this.adapter.setAdvertImages(new ArrayList());
                        }
                        MainDashboard.this.sliderView.setSliderAdapter(MainDashboard.this.adapter);
                        MainDashboard.this.adapter.notifyDataSetChanged();
                    }
                } else {
                    SharedPrefrencesUtil.saveString(Constants.IMAGE_CACHED, new Gson().toJson((Object) apiResponse.getData().getAdvertImages()), MainDashboard.this);
                    MainDashboard.this.adapter.setAdvertImages(advertImages);
                    MainDashboard.this.sliderView.setSliderAdapter(MainDashboard.this.adapter);
                    MainDashboard.this.adapter.notifyDataSetChanged();
                }
                MainDashboard.this.getCoordinate();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    MainDashboard.this.appAlerts.showErrorAndLogout(MainDashboard.this, str);
                    return;
                }
                String string = SharedPrefrencesUtil.getString(Constants.IMAGE_CACHED, MainDashboard.this);
                if (!string.isEmpty()) {
                    Type type = new TypeToken<ArrayList<AdvertImages>>() {
                    }.getType();
                    if (new Gson().fromJson(string, type) != null) {
                        MainDashboard.this.adapter.setAdvertImages((ArrayList) new Gson().fromJson(string, type));
                    } else {
                        MainDashboard.this.adapter.setAdvertImages(new ArrayList());
                    }
                    MainDashboard.this.sliderView.setSliderAdapter(MainDashboard.this.adapter);
                    MainDashboard.this.adapter.notifyDataSetChanged();
                }
            }
        }, sb.toString());
    }

    public void onFailure(int i, String str) {
        FirebaseCrashlytics.getInstance().log(str);
    }

    public void getCoordinate() {
        APIManager.getInstance().getBicycleStation(new APIManager.Callback() {
            public void onFailure(int i, String str) {
            }

            public void onSuccess(int i, ApiResponse apiResponse) {
                AppExecutors.getInstance().diskIO().execute(new Runnable(apiResponse) {
                    public final /* synthetic */ ApiResponse f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MainDashboard.AnonymousClass4.this.lambda$onSuccess$0$MainDashboard$4(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onSuccess$0$MainDashboard$4(ApiResponse apiResponse) {
                try {
                    if (apiResponse.getRespCode().intValue() == 200) {
                        ArrayList<BicycleStandModel> bicycleStations = apiResponse.getData().getBicycleStations();
                        for (int i = 0; i < bicycleStations.size(); i++) {
                            BicyclesTB bicyclesTB = new BicyclesTB();
                            bicyclesTB.id = bicycleStations.get(i).id;
                            bicyclesTB.lat = bicycleStations.get(i).lat;
                            bicyclesTB.lon = bicycleStations.get(i).lon;
                            bicyclesTB.name = bicycleStations.get(i).name;
                            bicyclesTB.rentCount = bicycleStations.get(i).rentCount;
                            bicyclesTB.restoreCount = bicycleStations.get(i).restoreCount;
                            DBZuApp.getInstance(MainDashboard.this.getApplicationContext()).bicycleDao().insertStation(bicyclesTB);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }, this);
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        if (i == ReturnCodes.Companion.OK()) {
            AccountBalance accountBalance = new AccountBalance();
            if (apiResponse.getData().getAccountBalance() != null) {
                accountBalance.setAccountBalance(apiResponse.getData().getAccountBalance());
            }
            if (apiResponse.getData().getUserID() != null) {
                accountBalance.setUserID(apiResponse.getData().getUserID());
            }
            if (apiResponse.getData().getLastUpdatedOn() != null) {
                accountBalance.setLastUpdatedOn(apiResponse.getData().getLastUpdatedOn());
            }
            runOnUiThread(new Runnable(apiResponse, accountBalance) {
                public final /* synthetic */ ApiResponse f$1;
                public final /* synthetic */ AccountBalance f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    MainDashboard.this.lambda$onSuccess$1$MainDashboard(this.f$1, this.f$2);
                }
            });
            if (apiResponse.getData().getAccountBalance() != null) {
                updateUserBalance(accountBalance, this);
            } else {
                checkUserBalance();
            }
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.appAlerts.showErrorAndLogout(this, apiResponse.getRespMessage());
        }
    }

    public /* synthetic */ void lambda$onSuccess$1$MainDashboard(ApiResponse apiResponse, AccountBalance accountBalance) {
        if (apiResponse.getData().getAccountBalance() != null) {
            String accountBalance2 = accountBalance.getAccountBalance();
            try {
                String format = String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(accountBalance2))});
                TextView textView = this.TV_UserBalance;
                textView.setText("RS " + format);
            } catch (Exception unused) {
                TextView textView2 = this.TV_UserBalance;
                textView2.setText("RS " + accountBalance2);
            }
        }
    }

    public class NotificationReceiver extends BroadcastReceiver {
        public NotificationReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Objects.requireNonNull(action);
            if (action.equals(MainDashboard.receiveTAG)) {
                MainDashboard.this.checkUserBalance();
                MainDashboard.this.runOnUiThread(new Runnable(context) {
                    public final /* synthetic */ Context f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MainDashboard.NotificationReceiver.this.lambda$onReceive$0$MainDashboard$NotificationReceiver(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onReceive$0$MainDashboard$NotificationReceiver(Context context) {
            MainDashboard.this.notificationIV.setBadgeValue(SharedPrefrencesUtil.getInt(Constants.NOTIFICATION_COUNT, context));
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1021) {
            checkUserBalance();
        }
        if (i == this.UPDATE_REQUEST_CODE && i2 != -1) {
            if (i2 == 0) {
                Log.d("Data", "its cancelled");
            } else if (i2 == 1) {
                Log.d("Update", "Failed");
            }
        }
    }
}
