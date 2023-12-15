package com.lmkt.zupeshawar.views.fragments.busFragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.CustomDatePicker;
import com.lmkt.zupeshawar.Utilities.Map.PinView;
import com.lmkt.zupeshawar.Utilities.Map.subscaleview.ImageSource;
import com.lmkt.zupeshawar.Utilities.Map.subscaleview.SubsamplingScaleImageView;
import com.lmkt.zupeshawar.model.Route.StationModel;
import com.lmkt.zupeshawar.model.Route.StopType;
import com.lmkt.zupeshawar.presenter.CustomDatePickerListener;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import com.lmkt.zupeshawar.views.activities.StationSearchActivity;
import com.lmkt.zupeshawar.views.activities.ZuWalletActivity;
import com.lmkt.zupeshawar.views.fragments.busFragments.BusArrivals;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import es.dmoral.toasty.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.compress.archivers.tar.TarConstants;

public class BusArrivals extends Fragment implements View.OnClickListener, IOnBackPressed, SubsamplingScaleImageView.OnImageEventListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String EXTRA_KEY_TEST = "testKey";
    public static final int REQUEST_CODE = 11;
    public static final int RESULT_CODE = 12;
    private static final String TAG = "Bus Arrivals Fragment";
    MaterialButton Btn_ZuWallet;
    /* access modifiers changed from: private */
    public MainMenuItemActivity activity;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public AppCompatButton date;
    private GestureDetector gestureDetector;
    /* access modifiers changed from: private */
    public PinView imageView;
    private final boolean isHebrew = false;
    private ProgressBar mProgressBar;
    int requestcode = 100;
    private EditText searchStation_ET;
    ArrayList<StationModel> stationModels = new ArrayList<>();
    /* access modifiers changed from: private */
    public String type;

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
        return layoutInflater.inflate(R.layout.frag_mainmenu_busarrivals, viewGroup, false);
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
        EditText editText = (EditText) view.findViewById(R.id.searchStation_ET);
        this.searchStation_ET = editText;
        editText.setOnClickListener(this);
        this.Btn_ZuWallet = (MaterialButton) view.findViewById(R.id.Btn_ZuWallet);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.date = (AppCompatButton) view.findViewById(R.id.date);
        if (this.type.equals("BusSchedule")) {
            view.findViewById(R.id.card_view).setVisibility(0);
            this.date.setVisibility(0);
            this.date.setText(CustomDatePicker.getCurrentDate());
            new CustomDatePicker(getContext(), this.date, (CustomDatePickerListener) new CustomDatePickerListener() {
                public void onDateChangeListener(String str) {
                }
            });
        } else {
            this.date.setVisibility(8);
            view.findViewById(R.id.card_view).setVisibility(8);
        }
        this.mProgressBar.bringToFront();
        fillStationArray();
        PinView pinView = (PinView) view.findViewById(R.id.imageView);
        this.imageView = pinView;
        pinView.setMinimumScaleType(1);
        this.imageView.setMaxScale(2.0f);
        this.imageView.setZoomEnabled(true);
        this.imageView.setImage(ImageSource.resource(R.drawable.map));
        this.imageView.setOnImageEventListener(this);
        this.imageView.setVisibility(0);
        this.imageView.bringToFront();
        this.activity.appAlerts.showPleaseWait(this.activity);
        this.Btn_ZuWallet.setOnClickListener(this);
        this.gestureDetector = new GestureDetector(this.context, new GestureDetector.SimpleOnGestureListener() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<BusArrivals> cls = BusArrivals.class;
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (BusArrivals.this.imageView.isReady()) {
                    PointF viewToSourceCoord = BusArrivals.this.imageView.viewToSourceCoord(motionEvent.getX(), motionEvent.getY());
                    boolean contains = new Rect(BusArrivals.this.imageView.getLeft(), BusArrivals.this.imageView.getTop(), BusArrivals.this.imageView.getRight(), BusArrivals.this.imageView.getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY());
                    Log.d("Points", "" + viewToSourceCoord.x + " : " + viewToSourceCoord.y);
                    if (contains) {
                        Iterator<StationModel> it = BusArrivals.this.stationModels.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            StationModel next = it.next();
                            if (next.getPosition().contains((float) ((int) viewToSourceCoord.x), (float) ((int) viewToSourceCoord.y))) {
                                BusArrivals.this.activity.runOnUiThread(new Runnable(next) {
                                    public final /* synthetic */ StationModel f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final void run() {
                                        BusArrivals.AnonymousClass2.this.lambda$onSingleTapUp$0$BusArrivals$2(this.f$1);
                                    }
                                });
                                break;
                            }
                        }
                    } else {
                        Toast.makeText(BusArrivals.this.context, "Please long click on Map to add marker ", 0).show();
                    }
                } else {
                    Toast.makeText(BusArrivals.this.context, "Loading Map Please wait", 0).show();
                }
                return super.onSingleTapUp(motionEvent);
            }

            public /* synthetic */ void lambda$onSingleTapUp$0$BusArrivals$2(StationModel stationModel) {
                Log.d("ClickedOn:   ", stationModel.getName() + "   " + stationModel.getStationID());
                if (BusArrivals.this.type.equals("BusSchedule")) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Station", stationModel.getName());
                    bundle.putInt("stationID", stationModel.getStationID());
                    bundle.putString("date", BusArrivals.this.date.getText().toString());
                    bundle.putString(CommonProperties.TYPE, BusArrivals.this.type);
                    BusArrivalsList busArrivalsList = new BusArrivalsList();
                    busArrivalsList.setArguments(bundle);
                    BusArrivals.this.activity.loadFragment(busArrivalsList, 1);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("Station", stationModel.getName());
                bundle2.putInt("stationID", stationModel.getStationID());
                bundle2.putString(CommonProperties.TYPE, BusArrivals.this.type);
                BusArrivalsList busArrivalsList2 = new BusArrivalsList();
                busArrivalsList2.setArguments(bundle2);
                BusArrivals.this.activity.loadFragment(busArrivalsList2, 1);
            }
        });
        this.imageView.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BusArrivals.this.lambda$initViews$0$BusArrivals(view, motionEvent);
            }
        });
    }

    public /* synthetic */ boolean lambda$initViews$0$BusArrivals(View view, MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent);
    }

    private void initToolbar() {
        MainMenuItemActivity mainMenuItemActivity = (MainMenuItemActivity) getActivity();
        this.activity = mainMenuItemActivity;
        this.context = mainMenuItemActivity.getBaseContext();
        if (this.type.equals("BusSchedule")) {
            this.activity.mToolbar_Title.setText(R.string.label_busschedulePolicy);
        } else {
            this.activity.mToolbar_Title.setText(R.string.title_busarrivals);
        }
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        } else if (id == R.id.Btn_ZuWallet) {
            this.activity.onBackPressed();
            startActivity(new Intent(getContext(), ZuWalletActivity.class));
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        } else if (id == R.id.searchStation_ET) {
            startActivityForResult(new Intent(getActivity(), StationSearchActivity.class), 11);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11 && i2 == -1) {
            String stringExtra = intent.getStringExtra("stationName");
            String stringExtra2 = intent.getStringExtra("stationId");
            Bundle bundle = new Bundle();
            if (this.type.equals("BusSchedule")) {
                bundle.putString("date", this.date.getText().toString());
            }
            bundle.putString(CommonProperties.TYPE, this.type);
            bundle.putString("Station", stringExtra);
            bundle.putInt("stationID", Integer.parseInt(stringExtra2));
            BusArrivalsList busArrivalsList = new BusArrivalsList();
            busArrivalsList.setArguments(bundle);
            this.activity.loadFragment(busArrivalsList, 1);
        }
    }

    public ArrayList<StationModel> fillStationArray() {
        RectF rectF = new RectF();
        rectF.left = 86.0f;
        rectF.top = 2164.0f;
        rectF.right = 166.0f;
        rectF.bottom = 2224.0f;
        ArrayList<StationModel> arrayList = this.stationModels;
        Float valueOf = Float.valueOf(0.0f);
        arrayList.add(new StationModel("Phase 7 Terminal", rectF, valueOf, StopType.DIRECT_ROUTE_STOP, 158));
        RectF rectF2 = new RectF();
        rectF2.left = 330.0f;
        rectF2.top = 2140.0f;
        rectF2.right = 450.0f;
        rectF2.bottom = 2220.0f;
        Float f = valueOf;
        this.stationModels.add(new StationModel("Bungash Market", rectF2, f, StopType.DIRECT_ROUTE_STOP, 159));
        RectF rectF3 = new RectF();
        rectF3.left = 205.0f;
        rectF3.top = 2145.0f;
        rectF3.right = 325.0f;
        rectF3.bottom = 2225.0f;
        this.stationModels.add(new StationModel("Sector F10", rectF3, f, StopType.DIRECT_ROUTE_STOP, 15801));
        RectF rectF4 = new RectF();
        rectF4.left = 630.0f;
        rectF4.top = 1595.0f;
        rectF4.right = 750.0f;
        rectF4.bottom = 1675.0f;
        this.stationModels.add(new StationModel("Qurtaba Uni", rectF4, f, StopType.DIRECT_ROUTE_STOP, 187));
        RectF rectF5 = new RectF();
        rectF5.left = 525.0f;
        rectF5.top = 1636.0f;
        rectF5.right = 645.0f;
        rectF5.bottom = 1716.0f;
        this.stationModels.add(new StationModel("Hayatabad Police Station", rectF5, f, StopType.DIRECT_ROUTE_STOP, 186));
        RectF rectF6 = new RectF();
        rectF6.left = 405.0f;
        rectF6.top = 1635.0f;
        rectF6.right = 525.0f;
        rectF6.bottom = 1715.0f;
        ArrayList<StationModel> arrayList2 = this.stationModels;
        StationModel stationModel = r9;
        StationModel stationModel2 = new StationModel("Khybar Park", rectF6, f, StopType.DIRECT_ROUTE_STOP, 185);
        arrayList2.add(stationModel);
        RectF rectF7 = new RectF();
        rectF7.left = 320.0f;
        rectF7.top = 1680.0f;
        rectF7.right = 440.0f;
        rectF7.bottom = 1760.0f;
        ArrayList<StationModel> arrayList3 = this.stationModels;
        StationModel stationModel3 = r9;
        StationModel stationModel4 = new StationModel("Shama Market", rectF7, f, StopType.DIRECT_ROUTE_STOP, 184);
        arrayList3.add(stationModel3);
        RectF rectF8 = new RectF();
        rectF8.left = 325.0f;
        rectF8.top = 1740.0f;
        rectF8.right = 445.0f;
        rectF8.bottom = 1820.0f;
        this.stationModels.add(new StationModel("Phase 1", rectF8, f, StopType.DIRECT_ROUTE_STOP, 183));
        RectF rectF9 = new RectF();
        rectF9.left = 816.0f;
        rectF9.top = 1845.0f;
        rectF9.right = 936.0f;
        rectF9.bottom = 1925.0f;
        ArrayList<StationModel> arrayList4 = this.stationModels;
        StationModel stationModel5 = r9;
        StationModel stationModel6 = new StationModel("Atwar Bazar", rectF9, f, StopType.DIRECT_ROUTE_STOP, 182);
        arrayList4.add(stationModel5);
        RectF rectF10 = new RectF();
        rectF10.left = 815.0f;
        rectF10.top = 1935.0f;
        rectF10.right = 935.0f;
        rectF10.bottom = 2015.0f;
        ArrayList<StationModel> arrayList5 = this.stationModels;
        StationModel stationModel7 = r9;
        StationModel stationModel8 = new StationModel("Turangzai Market", rectF10, f, StopType.DIRECT_ROUTE_STOP, 181);
        arrayList5.add(stationModel7);
        RectF rectF11 = new RectF();
        rectF11.left = 815.0f;
        rectF11.top = 2060.0f;
        rectF11.right = 935.0f;
        rectF11.bottom = 2140.0f;
        this.stationModels.add(new StationModel("Shalman Park Phase 2", rectF11, f, StopType.DIRECT_ROUTE_STOP, 180));
        RectF rectF12 = new RectF();
        rectF12.left = 630.0f;
        rectF12.top = 2214.0f;
        rectF12.right = 750.0f;
        rectF12.bottom = 2294.0f;
        this.stationModels.add(new StationModel("Sher Shah", rectF12, f, StopType.DIRECT_ROUTE_STOP, 179));
        RectF rectF13 = new RectF();
        rectF13.left = 445.0f;
        rectF13.top = 2158.0f;
        rectF13.right = 565.0f;
        rectF13.bottom = 2218.0f;
        this.stationModels.add(new StationModel("Gol Chowk", rectF13, f, StopType.DIRECT_ROUTE_STOP, TarConstants.CHKSUM_OFFSET));
        RectF rectF14 = new RectF();
        rectF14.left = 430.0f;
        rectF14.top = 2000.0f;
        rectF14.right = 550.0f;
        rectF14.bottom = 2080.0f;
        this.stationModels.add(new StationModel("Phase 7 Chowk", rectF14, f, StopType.DIRECT_ROUTE_STOP, 160));
        RectF rectF15 = new RectF();
        rectF15.left = 430.0f;
        rectF15.top = 1890.0f;
        rectF15.right = 550.0f;
        rectF15.bottom = 1970.0f;
        this.stationModels.add(new StationModel("Deans Height", rectF15, f, StopType.DIRECT_ROUTE_STOP, 161));
        RectF rectF16 = new RectF();
        rectF16.left = 290.0f;
        rectF16.top = 1752.0f;
        rectF16.right = 410.0f;
        rectF16.bottom = 1832.0f;
        this.stationModels.add(new StationModel("Shamali Market", rectF16, f, StopType.DIRECT_ROUTE_STOP, 164));
        RectF rectF17 = new RectF();
        rectF17.left = 292.0f;
        rectF17.top = 1678.0f;
        rectF17.right = 412.0f;
        rectF17.bottom = 1758.0f;
        ArrayList<StationModel> arrayList6 = this.stationModels;
        StationModel stationModel9 = r9;
        StationModel stationModel10 = new StationModel("Fast University", rectF17, f, StopType.DIRECT_ROUTE_STOP, 165);
        arrayList6.add(stationModel9);
        RectF rectF18 = new RectF();
        rectF18.left = 290.0f;
        rectF18.top = 1592.0f;
        rectF18.right = 410.0f;
        rectF18.bottom = 1672.0f;
        this.stationModels.add(new StationModel("Industrial Estate", rectF18, f, StopType.DIRECT_ROUTE_STOP, 166));
        RectF rectF19 = new RectF();
        rectF19.left = 285.0f;
        rectF19.top = 1506.0f;
        rectF19.right = 405.0f;
        rectF19.bottom = 1586.0f;
        this.stationModels.add(new StationModel("Fort", rectF19, f, StopType.DIRECT_ROUTE_STOP, 167));
        RectF rectF20 = new RectF();
        rectF20.left = 290.0f;
        rectF20.top = 1415.0f;
        rectF20.right = 410.0f;
        rectF20.bottom = 1495.0f;
        ArrayList<StationModel> arrayList7 = this.stationModels;
        StationModel stationModel11 = r9;
        StationModel stationModel12 = new StationModel("TEVTA", rectF20, f, StopType.DIRECT_ROUTE_STOP, 168);
        arrayList7.add(stationModel11);
        RectF rectF21 = new RectF();
        rectF21.left = 290.0f;
        rectF21.top = 1335.0f;
        rectF21.right = 410.0f;
        rectF21.bottom = 1415.0f;
        this.stationModels.add(new StationModel("Karkhano Chowk", rectF21, f, StopType.DIRECT_ROUTE_STOP, 16801));
        RectF rectF22 = new RectF();
        rectF22.left = 104.0f;
        rectF22.top = 2092.0f;
        rectF22.right = 184.0f;
        rectF22.bottom = 2172.0f;
        this.stationModels.add(new StationModel("IMSciences", rectF22, f, StopType.DIRECT_ROUTE_STOP, 169));
        RectF rectF23 = new RectF();
        rectF23.left = 104.0f;
        rectF23.top = 2023.0f;
        rectF23.right = 184.0f;
        rectF23.bottom = 2103.0f;
        this.stationModels.add(new StationModel("Football Ground", rectF23, f, StopType.DIRECT_ROUTE_STOP, 16901));
        RectF rectF24 = new RectF();
        rectF24.left = 105.0f;
        rectF24.top = 1955.0f;
        rectF24.right = 185.0f;
        rectF24.bottom = 2035.0f;
        this.stationModels.add(new StationModel("Madrassa", rectF24, f, StopType.DIRECT_ROUTE_STOP, 170));
        RectF rectF25 = new RectF();
        rectF25.left = 147.0f;
        rectF25.top = 1905.0f;
        rectF25.right = 227.0f;
        rectF25.bottom = 1985.0f;
        this.stationModels.add(new StationModel("Judicial Complex", rectF25, f, StopType.DIRECT_ROUTE_STOP, 171));
        RectF rectF26 = new RectF();
        rectF26.left = 212.0f;
        rectF26.top = 1903.0f;
        rectF26.right = 292.0f;
        rectF26.bottom = 1983.0f;
        this.stationModels.add(new StationModel("Haji Camp", rectF26, f, StopType.DIRECT_ROUTE_STOP, 172));
        RectF rectF27 = new RectF();
        rectF27.left = 240.0f;
        rectF27.top = 1874.0f;
        rectF27.right = 320.0f;
        rectF27.bottom = 1934.0f;
        this.stationModels.add(new StationModel("Rehman Baba Market", rectF27, f, StopType.DIRECT_ROUTE_STOP, 173));
        RectF rectF28 = new RectF();
        rectF28.left = 257.0f;
        rectF28.top = 1800.0f;
        rectF28.right = 337.0f;
        rectF28.bottom = 1860.0f;
        this.stationModels.add(new StationModel("Malik Saad Market", rectF28, f, StopType.DIRECT_ROUTE_STOP, 174));
        RectF rectF29 = new RectF();
        rectF29.left = 615.0f;
        rectF29.top = 2328.0f;
        rectF29.right = 735.0f;
        rectF29.bottom = 2408.0f;
        this.stationModels.add(new StationModel("Phase 6 Terminal", rectF29, f, StopType.DIRECT_ROUTE_STOP, 146));
        RectF rectF30 = new RectF();
        rectF30.left = 448.0f;
        rectF30.top = 2230.0f;
        rectF30.right = 568.0f;
        rectF30.bottom = 2300.0f;
        this.stationModels.add(new StationModel("Nawab Market", rectF30, f, StopType.DIRECT_ROUTE_STOP, 147));
        RectF rectF31 = new RectF();
        rectF31.left = 580.0f;
        rectF31.top = 2146.0f;
        rectF31.right = 700.0f;
        rectF31.bottom = 2226.0f;
        this.stationModels.add(new StationModel("CECOS University", rectF31, f, StopType.DIRECT_ROUTE_STOP, 149));
        RectF rectF32 = new RectF();
        rectF32.left = 374.0f;
        rectF32.top = 1800.0f;
        rectF32.right = 454.0f;
        rectF32.bottom = 1880.0f;
        this.stationModels.add(new StationModel("Lalazar", rectF32, f, StopType.DIRECT_ROUTE_TRANSFER_STATION, 163));
        RectF rectF33 = new RectF();
        rectF33.left = 426.0f;
        rectF33.top = 1794.0f;
        rectF33.right = 586.0f;
        rectF33.bottom = 1894.0f;
        this.stationModels.add(new StationModel("Zarghuni Masjid", rectF33, f, StopType.DIRECT_ROUTE_TRANSFER_STATION, 162));
        RectF rectF34 = new RectF();
        rectF34.left = 530.0f;
        rectF34.top = 1765.0f;
        rectF34.right = 610.0f;
        rectF34.bottom = 1805.0f;
        this.stationModels.add(new StationModel("Itwar Bazar", rectF34, f, StopType.DIRECT_ROUTE_STOP, 175));
        RectF rectF35 = new RectF();
        rectF35.left = 630.0f;
        rectF35.top = 1710.0f;
        rectF35.right = 710.0f;
        rectF35.bottom = 1750.0f;
        ArrayList<StationModel> arrayList8 = this.stationModels;
        StationModel stationModel13 = r9;
        StationModel stationModel14 = new StationModel("Iqra University", rectF35, f, StopType.DIRECT_ROUTE_STOP, 176);
        arrayList8.add(stationModel13);
        RectF rectF36 = new RectF();
        rectF36.left = 693.0f;
        rectF36.top = 1631.0f;
        rectF36.right = 773.0f;
        rectF36.bottom = 1711.0f;
        this.stationModels.add(new StationModel("Bagh-e-Naran", rectF36, f, StopType.DIRECT_ROUTE_STOP, 177));
        RectF rectF37 = new RectF();
        rectF37.left = 292.0f;
        rectF37.top = 1232.0f;
        rectF37.right = 412.0f;
        rectF37.bottom = 1352.0f;
        this.stationModels.add(new StationModel("Karkhano Market", rectF37, f, StopType.TRANSFER_STATION, 31));
        RectF rectF38 = new RectF();
        rectF38.left = 484.0f;
        rectF38.top = 1317.0f;
        rectF38.right = 604.0f;
        rectF38.bottom = 1437.0f;
        this.stationModels.add(new StationModel("Hospital Chowk", rectF38, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 30));
        RectF rectF39 = new RectF();
        rectF39.left = 507.0f;
        rectF39.top = 1414.0f;
        rectF39.right = 627.0f;
        rectF39.bottom = 1494.0f;
        this.stationModels.add(new StationModel("PDA", rectF39, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 29));
        RectF rectF40 = new RectF();
        rectF40.left = 510.0f;
        rectF40.top = 1491.0f;
        rectF40.right = 630.0f;
        rectF40.bottom = 1571.0f;
        this.stationModels.add(new StationModel("Tatara Park", rectF40, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 28));
        RectF rectF41 = new RectF();
        rectF41.left = 684.0f;
        rectF41.top = 2138.0f;
        rectF41.right = 804.0f;
        rectF41.bottom = 2218.0f;
        this.stationModels.add(new StationModel("Government College", rectF41, f, StopType.DIRECT_ROUTE_STOP, 150));
        RectF rectF42 = new RectF();
        rectF42.left = 786.0f;
        rectF42.top = 2151.0f;
        rectF42.right = 906.0f;
        rectF42.bottom = 2231.0f;
        this.stationModels.add(new StationModel("Shalman Park", rectF42, f, StopType.DIRECT_ROUTE_STOP, 151));
        RectF rectF43 = new RectF();
        rectF43.left = 870.0f;
        rectF43.top = 1967.0f;
        rectF43.right = 990.0f;
        rectF43.bottom = 2047.0f;
        this.stationModels.add(new StationModel("Achini", rectF43, f, StopType.DIRECT_ROUTE_STOP, 152));
        RectF rectF44 = new RectF();
        rectF44.left = 880.0f;
        rectF44.top = 1793.0f;
        rectF44.right = 1000.0f;
        rectF44.bottom = 1873.0f;
        this.stationModels.add(new StationModel("Itwar Bazar", rectF44, f, StopType.DIRECT_ROUTE_STOP, 153));
        RectF rectF45 = new RectF();
        rectF45.left = 861.0f;
        rectF45.top = 1715.0f;
        rectF45.right = 981.0f;
        rectF45.bottom = 1795.0f;
        this.stationModels.add(new StationModel("Ring Road Bridge", rectF45, f, StopType.DIRECT_ROUTE_STOP, 154));
        RectF rectF46 = new RectF();
        rectF46.left = 862.0f;
        rectF46.top = 1651.0f;
        rectF46.right = 982.0f;
        rectF46.bottom = 1731.0f;
        this.stationModels.add(new StationModel("Yousafzai Market", rectF46, f, StopType.DIRECT_ROUTE_STOP, TarConstants.PREFIXLEN));
        RectF rectF47 = new RectF();
        rectF47.left = 882.0f;
        rectF47.top = 1590.0f;
        rectF47.right = 1002.0f;
        rectF47.bottom = 1670.0f;
        this.stationModels.add(new StationModel("Basharat Market", rectF47, f, StopType.DIRECT_ROUTE_STOP, 156));
        RectF rectF48 = new RectF();
        rectF48.left = 900.0f;
        rectF48.top = 1535.0f;
        rectF48.right = 1000.0f;
        rectF48.bottom = 1615.0f;
        this.stationModels.add(new StationModel("Bakht Khan Market", rectF48, f, StopType.DIRECT_ROUTE_STOP, 157));
        RectF rectF49 = new RectF();
        rectF49.left = 848.0f;
        rectF49.top = 1498.0f;
        rectF49.right = 928.0f;
        rectF49.bottom = 1598.0f;
        this.stationModels.add(new StationModel("Hayatabad Phase 3", rectF49, f, StopType.TRANSFER_STATION, 27));
        RectF rectF50 = new RectF();
        rectF50.left = 792.0f;
        rectF50.top = 1447.0f;
        rectF50.right = 872.0f;
        rectF50.bottom = 1527.0f;
        this.stationModels.add(new StationModel("Bab-e-Peshawar", rectF50, f, StopType.TRANSFER_STATION, 26));
        RectF rectF51 = new RectF();
        rectF51.left = 784.0f;
        rectF51.top = 1330.0f;
        rectF51.right = 924.0f;
        rectF51.bottom = 1450.0f;
        this.stationModels.add(new StationModel("Mall of Hayatabad", rectF51, f, StopType.TRANSFER_STATION, 25));
        RectF rectF52 = new RectF();
        rectF52.left = 987.0f;
        rectF52.top = 1391.0f;
        rectF52.right = 1107.0f;
        rectF52.bottom = 1511.0f;
        this.stationModels.add(new StationModel("Board Bazar", rectF52, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 24));
        RectF rectF53 = new RectF();
        rectF53.left = 1075.0f;
        rectF53.top = 1336.0f;
        rectF53.right = 1195.0f;
        rectF53.bottom = 1496.0f;
        this.stationModels.add(new StationModel("Islamia College", rectF53, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 23));
        RectF rectF54 = new RectF();
        rectF54.left = 1176.0f;
        rectF54.top = 1395.0f;
        rectF54.right = 1296.0f;
        rectF54.bottom = 1555.0f;
        this.stationModels.add(new StationModel("University of Peshawar", rectF54, f, StopType.TRANSFER_STATION, 22));
        RectF rectF55 = new RectF();
        rectF55.left = 1275.0f;
        rectF55.top = 1378.0f;
        rectF55.right = 1395.0f;
        rectF55.bottom = 1458.0f;
        this.stationModels.add(new StationModel("University Town", rectF55, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 21));
        RectF rectF56 = new RectF();
        rectF56.left = 1375.0f;
        rectF56.top = 1385.0f;
        rectF56.right = 1495.0f;
        rectF56.bottom = 1505.0f;
        this.stationModels.add(new StationModel("Abdara Road", rectF56, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 20));
        RectF rectF57 = new RectF();
        rectF57.left = 1480.0f;
        rectF57.top = 1375.0f;
        rectF57.right = 1600.0f;
        rectF57.bottom = 1455.0f;
        this.stationModels.add(new StationModel("Tehkal Bala", rectF57, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 19));
        RectF rectF58 = new RectF();
        rectF58.left = 1576.0f;
        rectF58.top = 1412.0f;
        rectF58.right = 1696.0f;
        rectF58.bottom = 1532.0f;
        this.stationModels.add(new StationModel("Tehkal Payyan", rectF58, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 18));
        RectF rectF59 = new RectF();
        rectF59.left = 1719.0f;
        rectF59.top = 1465.0f;
        rectF59.right = 1839.0f;
        rectF59.bottom = 1625.0f;
        this.stationModels.add(new StationModel("Mall Road", rectF59, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 16));
        RectF rectF60 = new RectF();
        rectF60.left = 1830.0f;
        rectF60.top = 1357.0f;
        rectF60.right = 1970.0f;
        rectF60.bottom = 1457.0f;
        this.stationModels.add(new StationModel("Saddar Bazar", rectF60, f, StopType.TRANSFER_STATION, 15));
        RectF rectF61 = new RectF();
        rectF61.left = 1950.0f;
        rectF61.top = 1394.0f;
        rectF61.right = 2070.0f;
        rectF61.bottom = 1474.0f;
        this.stationModels.add(new StationModel("FC Chowk", rectF61, f, StopType.TRANSFER_STATION, 14));
        RectF rectF62 = new RectF();
        rectF62.left = 2010.0f;
        rectF62.top = 1340.0f;
        rectF62.right = 2130.0f;
        rectF62.bottom = 1420.0f;
        this.stationModels.add(new StationModel("Railway Station", rectF62, f, StopType.TRANSFER_STATION, 13));
        RectF rectF63 = new RectF();
        rectF63.left = 2055.0f;
        rectF63.top = 1268.0f;
        rectF63.right = 2175.0f;
        rectF63.bottom = 1348.0f;
        this.stationModels.add(new StationModel("Dabgari Gardens", rectF63, f, StopType.TRANSFER_STATION, 12));
        RectF rectF64 = new RectF();
        rectF64.left = 2155.0f;
        rectF64.top = 1259.0f;
        rectF64.right = 2275.0f;
        rectF64.bottom = 1339.0f;
        this.stationModels.add(new StationModel("Shoba Bazar", rectF64, f, StopType.TRANSFER_STATION, 11));
        RectF rectF65 = new RectF();
        rectF65.left = 2167.0f;
        rectF65.top = 1144.0f;
        rectF65.right = 2287.0f;
        rectF65.bottom = 1224.0f;
        this.stationModels.add(new StationModel("Khyber Bazar", rectF65, f, StopType.TRANSFER_STATION, 10));
        RectF rectF66 = new RectF();
        rectF66.left = 2290.0f;
        rectF66.top = 1840.0f;
        rectF66.right = 2410.0f;
        rectF66.bottom = 2000.0f;
        this.stationModels.add(new StationModel("Malik Saad Shaheed", rectF66, f, StopType.TRANSFER_STATION, 9));
        RectF rectF67 = new RectF();
        rectF67.left = 1448.0f;
        rectF67.top = 1816.0f;
        rectF67.right = 1528.0f;
        rectF67.bottom = 1856.0f;
        this.stationModels.add(new StationModel("Pishtakhara Chowk", rectF67, f, StopType.DIRECT_ROUTE_STOP, 124));
        RectF rectF68 = new RectF();
        rectF68.left = 1490.0f;
        rectF68.top = 1784.0f;
        rectF68.right = 1570.0f;
        rectF68.bottom = 2044.0f;
        this.stationModels.add(new StationModel("Pishtakhara Thana", rectF68, f, StopType.DIRECT_ROUTE_STOP, 123));
        RectF rectF69 = new RectF();
        rectF69.left = 1532.0f;
        rectF69.top = 1751.0f;
        rectF69.right = 1612.0f;
        rectF69.bottom = 1791.0f;
        this.stationModels.add(new StationModel("Custom Chowk", rectF69, f, StopType.DIRECT_ROUTE_STOP, 122));
        RectF rectF70 = new RectF();
        rectF70.left = 1575.0f;
        rectF70.top = 1716.0f;
        rectF70.right = 1655.0f;
        rectF70.bottom = 1756.0f;
        this.stationModels.add(new StationModel("Rashakai", rectF70, f, StopType.DIRECT_ROUTE_STOP, 121));
        RectF rectF71 = new RectF();
        rectF71.left = 1618.0f;
        rectF71.top = 1681.0f;
        rectF71.right = 1698.0f;
        rectF71.bottom = 1721.0f;
        this.stationModels.add(new StationModel("Bara Gate", rectF71, f, StopType.DIRECT_ROUTE_STOP, 120));
        RectF rectF72 = new RectF();
        rectF72.left = 1659.0f;
        rectF72.top = 1645.0f;
        rectF72.right = 1739.0f;
        rectF72.bottom = 1685.0f;
        this.stationModels.add(new StationModel("Swatu Pattak", rectF72, f, StopType.DIRECT_ROUTE_STOP, 118));
        RectF rectF73 = new RectF();
        rectF73.left = 1704.0f;
        rectF73.top = 1613.0f;
        rectF73.right = 1784.0f;
        rectF73.bottom = 1653.0f;
        this.stationModels.add(new StationModel("Khyber Super Market", rectF73, f, StopType.DIRECT_ROUTE_STOP, 117));
        RectF rectF74 = new RectF();
        rectF74.left = 1750.0f;
        rectF74.top = 1574.0f;
        rectF74.right = 1830.0f;
        rectF74.bottom = 1614.0f;
        this.stationModels.add(new StationModel("Stadium Chowk", rectF74, f, StopType.DIRECT_ROUTE_STOP, 116));
        RectF rectF75 = new RectF();
        rectF75.left = 2050.0f;
        rectF75.top = 1866.0f;
        rectF75.right = 2170.0f;
        rectF75.bottom = 1946.0f;
        this.stationModels.add(new StationModel("Kohat Adda", rectF75, f, StopType.DIRECT_ROUTE_STOP, 125));
        RectF rectF76 = new RectF();
        rectF76.left = 2069.0f;
        rectF76.top = 1814.0f;
        rectF76.right = 2189.0f;
        rectF76.bottom = 1894.0f;
        this.stationModels.add(new StationModel("Gulshan Rehman Colony", rectF76, f, StopType.DIRECT_ROUTE_STOP, 126));
        RectF rectF77 = new RectF();
        rectF77.left = 2052.0f;
        rectF77.top = 1762.0f;
        rectF77.right = 2172.0f;
        rectF77.bottom = 1842.0f;
        this.stationModels.add(new StationModel("Garhi Qamar Din", rectF77, f, StopType.DIRECT_ROUTE_STOP, 127));
        RectF rectF78 = new RectF();
        rectF78.left = 2068.0f;
        rectF78.top = 1713.0f;
        rectF78.right = 2188.0f;
        rectF78.bottom = 1793.0f;
        this.stationModels.add(new StationModel("Landi Arbab", rectF78, f, StopType.DIRECT_ROUTE_STOP, 128));
        RectF rectF79 = new RectF();
        rectF79.left = 2053.0f;
        rectF79.top = 1661.0f;
        rectF79.right = 2173.0f;
        rectF79.bottom = 1741.0f;
        this.stationModels.add(new StationModel("Technical College", rectF79, f, StopType.DIRECT_ROUTE_STOP, 129));
        RectF rectF80 = new RectF();
        rectF80.left = 2070.0f;
        rectF80.top = 1610.0f;
        rectF80.right = 2190.0f;
        rectF80.bottom = 1690.0f;
        this.stationModels.add(new StationModel("Civil Colony", rectF80, f, StopType.DIRECT_ROUTE_STOP, 130));
        RectF rectF81 = new RectF();
        rectF81.left = 2051.0f;
        rectF81.top = 1561.0f;
        rectF81.right = 2171.0f;
        rectF81.bottom = 1641.0f;
        this.stationModels.add(new StationModel("Bhana Marri", rectF81, f, StopType.DIRECT_ROUTE_STOP, TarConstants.PREFIXLEN_XSTAR));
        RectF rectF82 = new RectF();
        rectF82.left = 2070.0f;
        rectF82.top = 1510.0f;
        rectF82.right = 2190.0f;
        rectF82.bottom = 1590.0f;
        this.stationModels.add(new StationModel("Civil Quarters", rectF82, f, StopType.DIRECT_ROUTE_STOP, 132));
        RectF rectF83 = new RectF();
        rectF83.left = 2072.0f;
        rectF83.top = 1455.0f;
        rectF83.right = 2192.0f;
        rectF83.bottom = 1535.0f;
        this.stationModels.add(new StationModel("Shaheed Saqib Ghani School", rectF83, f, StopType.DIRECT_ROUTE_STOP, 133));
        RectF rectF84 = new RectF();
        rectF84.left = 2386.0f;
        rectF84.top = 251.0f;
        rectF84.right = 2466.0f;
        rectF84.bottom = 291.0f;
        this.stationModels.add(new StationModel("Shah Alam Pul", rectF84, f, StopType.DIRECT_ROUTE_STOP, 145));
        RectF rectF85 = new RectF();
        rectF85.left = 2402.0f;
        rectF85.top = 288.0f;
        rectF85.right = 2482.0f;
        rectF85.bottom = 328.0f;
        this.stationModels.add(new StationModel("Wahid Garhi", rectF85, f, StopType.DIRECT_ROUTE_STOP, 144));
        RectF rectF86 = new RectF();
        rectF86.left = 2407.0f;
        rectF86.top = 320.0f;
        rectF86.right = 2487.0f;
        rectF86.bottom = 360.0f;
        this.stationModels.add(new StationModel("Toda", rectF86, f, StopType.DIRECT_ROUTE_STOP, 14301));
        RectF rectF87 = new RectF();
        rectF87.left = 2387.0f;
        rectF87.top = 350.0f;
        rectF87.right = 2447.0f;
        rectF87.bottom = 390.0f;
        this.stationModels.add(new StationModel("Khazana", rectF87, f, StopType.DIRECT_ROUTE_STOP, 143));
        RectF rectF88 = new RectF();
        rectF88.left = 2327.0f;
        rectF88.top = 373.0f;
        rectF88.right = 2407.0f;
        rectF88.bottom = 413.0f;
        this.stationModels.add(new StationModel("Faqir Abad", rectF88, f, StopType.DIRECT_ROUTE_STOP, 14201));
        RectF rectF89 = new RectF();
        rectF89.left = 2273.0f;
        rectF89.top = 386.0f;
        rectF89.right = 2393.0f;
        rectF89.bottom = 466.0f;
        this.stationModels.add(new StationModel("Sewan", rectF89, f, StopType.DIRECT_ROUTE_STOP, BuildConfig.VERSION_CODE));
        RectF rectF90 = new RectF();
        rectF90.left = 2288.0f;
        rectF90.top = 428.0f;
        rectF90.right = 2408.0f;
        rectF90.bottom = 508.0f;
        this.stationModels.add(new StationModel("Sugar Mill", rectF90, f, StopType.DIRECT_ROUTE_STOP, 141));
        RectF rectF91 = new RectF();
        rectF91.left = 2292.0f;
        rectF91.top = 471.0f;
        rectF91.right = 2412.0f;
        rectF91.bottom = 551.0f;
        ArrayList<StationModel> arrayList9 = this.stationModels;
        StationModel stationModel15 = r9;
        StationModel stationModel16 = new StationModel("Nasapa Bala", rectF91, f, StopType.DIRECT_ROUTE_STOP, 14001);
        arrayList9.add(stationModel15);
        RectF rectF92 = new RectF();
        rectF92.left = 2289.0f;
        rectF92.top = 513.0f;
        rectF92.right = 2409.0f;
        rectF92.bottom = 593.0f;
        this.stationModels.add(new StationModel("Nasapa", rectF92, f, StopType.DIRECT_ROUTE_STOP, 140));
        RectF rectF93 = new RectF();
        rectF93.left = 2290.0f;
        rectF93.top = 555.0f;
        rectF93.right = 2410.0f;
        rectF93.bottom = 635.0f;
        this.stationModels.add(new StationModel("Muslim Abad", rectF93, f, StopType.DIRECT_ROUTE_STOP, 13901));
        RectF rectF94 = new RectF();
        rectF94.left = 2271.0f;
        rectF94.top = 596.0f;
        rectF94.right = 2391.0f;
        rectF94.bottom = 676.0f;
        this.stationModels.add(new StationModel("Bakhshu Pul", rectF94, f, StopType.DIRECT_ROUTE_STOP, 139));
        RectF rectF95 = new RectF();
        rectF95.left = 2288.0f;
        rectF95.top = 636.0f;
        rectF95.right = 2408.0f;
        rectF95.bottom = 716.0f;
        this.stationModels.add(new StationModel("Ibrahim Abad", rectF95, f, StopType.DIRECT_ROUTE_STOP, 138));
        RectF rectF96 = new RectF();
        rectF96.left = 2290.0f;
        rectF96.top = 676.0f;
        rectF96.right = 2410.0f;
        rectF96.bottom = 756.0f;
        this.stationModels.add(new StationModel("Habib Abad", rectF96, f, StopType.DIRECT_ROUTE_STOP, 13701));
        RectF rectF97 = new RectF();
        rectF97.left = 2290.0f;
        rectF97.top = 719.0f;
        rectF97.right = 2410.0f;
        rectF97.bottom = 799.0f;
        this.stationModels.add(new StationModel("Shero Jhangi", rectF97, f, StopType.DIRECT_ROUTE_STOP, 137));
        RectF rectF98 = new RectF();
        rectF98.left = 2273.0f;
        rectF98.top = 758.0f;
        rectF98.right = 2393.0f;
        rectF98.bottom = 838.0f;
        this.stationModels.add(new StationModel("Landey Sarrak", rectF98, f, StopType.DIRECT_ROUTE_STOP, 136));
        RectF rectF99 = new RectF();
        rectF99.left = 2290.0f;
        rectF99.top = 798.0f;
        rectF99.right = 2410.0f;
        rectF99.bottom = 878.0f;
        this.stationModels.add(new StationModel("Nishat Mill", rectF99, f, StopType.DIRECT_ROUTE_STOP, 135));
        RectF rectF100 = new RectF();
        rectF100.left = 2292.0f;
        rectF100.top = 837.0f;
        rectF100.right = 2412.0f;
        rectF100.bottom = 917.0f;
        this.stationModels.add(new StationModel("Budhni Pul", rectF100, f, StopType.DIRECT_ROUTE_STOP, 134));
        RectF rectF101 = new RectF();
        rectF101.left = 2280.0f;
        rectF101.top = 882.0f;
        rectF101.right = 2400.0f;
        rectF101.bottom = 962.0f;
        this.stationModels.add(new StationModel("Shaheed Tehseen Chowk", rectF101, f, StopType.DIRECT_ROUTE_TRANSFER_STATION, 110));
        RectF rectF102 = new RectF();
        rectF102.left = 2280.0f;
        rectF102.top = 918.0f;
        rectF102.right = 2400.0f;
        rectF102.bottom = 998.0f;
        this.stationModels.add(new StationModel("Charsadda Adda", rectF102, f, StopType.DIRECT_ROUTE_TRANSFER_STATION, 111));
        RectF rectF103 = new RectF();
        rectF103.left = 2290.0f;
        rectF103.top = 957.0f;
        rectF103.right = 2410.0f;
        rectF103.bottom = 1037.0f;
        this.stationModels.add(new StationModel("Eid Ghani", rectF103, f, StopType.DIRECT_ROUTE_TRANSFER_STATION, 112));
        RectF rectF104 = new RectF();
        rectF104.left = 2290.0f;
        rectF104.top = 995.0f;
        rectF104.right = 2410.0f;
        rectF104.bottom = 1075.0f;
        this.stationModels.add(new StationModel("Shahi Bagh", rectF104, f, StopType.DIRECT_ROUTE_TRANSFER_STATION, 113));
        RectF rectF105 = new RectF();
        rectF105.left = 2281.0f;
        rectF105.top = 1037.0f;
        rectF105.right = 2401.0f;
        rectF105.bottom = 1117.0f;
        this.stationModels.add(new StationModel("Bacha Khan Chowk", rectF105, f, StopType.DIRECT_ROUTE_TRANSFER_STATION, 114));
        RectF rectF106 = new RectF();
        rectF106.left = 2471.0f;
        rectF106.top = 789.0f;
        rectF106.right = 2591.0f;
        rectF106.bottom = 869.0f;
        this.stationModels.add(new StationModel("Patang Chowk", rectF106, f, StopType.DIRECT_ROUTE_STOP, 109));
        RectF rectF107 = new RectF();
        rectF107.left = 2570.0f;
        rectF107.top = 795.0f;
        rectF107.right = 2690.0f;
        rectF107.bottom = 875.0f;
        this.stationModels.add(new StationModel("Abasyan University", rectF107, f, StopType.DIRECT_ROUTE_STOP, 108));
        RectF rectF108 = new RectF();
        rectF108.left = 2311.0f;
        rectF108.top = 796.0f;
        rectF108.right = 2431.0f;
        rectF108.bottom = 876.0f;
        this.stationModels.add(new StationModel("Wazir Colony", rectF108, f, StopType.DIRECT_ROUTE_STOP, 107));
        RectF rectF109 = new RectF();
        rectF109.left = 2772.0f;
        rectF109.top = 794.0f;
        rectF109.right = 2892.0f;
        rectF109.bottom = 874.0f;
        this.stationModels.add(new StationModel("MMC Hospital", rectF109, f, StopType.DIRECT_ROUTE_STOP, 106));
        RectF rectF110 = new RectF();
        rectF110.left = 2870.0f;
        rectF110.top = 794.0f;
        rectF110.right = 2990.0f;
        rectF110.bottom = 874.0f;
        this.stationModels.add(new StationModel("Kabotar Chowk", rectF110, f, StopType.DIRECT_ROUTE_STOP, 105));
        RectF rectF111 = new RectF();
        rectF111.left = 2940.0f;
        rectF111.top = 816.0f;
        rectF111.right = 3060.0f;
        rectF111.bottom = 896.0f;
        this.stationModels.add(new StationModel("Pahari Pura", rectF111, f, StopType.DIRECT_ROUTE_STOP, 104));
        RectF rectF112 = new RectF();
        rectF112.left = 2979.0f;
        rectF112.top = 857.0f;
        rectF112.right = 3099.0f;
        rectF112.bottom = 937.0f;
        this.stationModels.add(new StationModel("Kambo Adda", rectF112, f, StopType.DIRECT_ROUTE_STOP, 103));
        RectF rectF113 = new RectF();
        rectF113.left = 2993.0f;
        rectF113.top = 951.0f;
        rectF113.right = 3113.0f;
        rectF113.bottom = 1031.0f;
        this.stationModels.add(new StationModel("Motorway Bridge", rectF113, f, StopType.DIRECT_ROUTE_STOP, 102));
        RectF rectF114 = new RectF();
        rectF114.left = 2992.0f;
        rectF114.top = 1051.0f;
        rectF114.right = 3112.0f;
        rectF114.bottom = 1131.0f;
        this.stationModels.add(new StationModel("Pir Zakori Bridge", rectF114, f, StopType.DIRECT_ROUTE_STOP, 101));
        RectF rectF115 = new RectF();
        rectF115.left = 2410.0f;
        rectF115.top = 1108.0f;
        rectF115.right = 2530.0f;
        rectF115.bottom = 1228.0f;
        this.stationModels.add(new StationModel("Hashtnagri", rectF115, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 8));
        RectF rectF116 = new RectF();
        rectF116.left = 2540.0f;
        rectF116.top = 1130.0f;
        rectF116.right = 2660.0f;
        rectF116.bottom = 1250.0f;
        this.stationModels.add(new StationModel("Gulbahar Chowk", rectF116, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 7));
        RectF rectF117 = new RectF();
        rectF117.left = 2666.0f;
        rectF117.top = 1079.0f;
        rectF117.right = 2786.0f;
        rectF117.bottom = 1199.0f;
        this.stationModels.add(new StationModel("Lahore Adda", rectF117, f, StopType.TRANSFER_STATION, 6));
        RectF rectF118 = new RectF();
        rectF118.left = 2790.0f;
        rectF118.top = 1119.0f;
        rectF118.right = 2910.0f;
        rectF118.bottom = 1199.0f;
        this.stationModels.add(new StationModel("Old Haji Camp", rectF118, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 5));
        RectF rectF119 = new RectF();
        rectF119.left = 2910.0f;
        rectF119.top = 1123.0f;
        rectF119.right = 3030.0f;
        rectF119.bottom = 1203.0f;
        this.stationModels.add(new StationModel("Faisal Colony", rectF119, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 4));
        RectF rectF120 = new RectF();
        rectF120.left = 3027.0f;
        rectF120.top = 1148.0f;
        rectF120.right = 3147.0f;
        rectF120.bottom = 1228.0f;
        this.stationModels.add(new StationModel("Goverment Primary School", rectF120, f, StopType.BRT_STOPPING_ROUTE_SYSTEM, 100));
        RectF rectF121 = new RectF();
        rectF121.left = 3099.0f;
        rectF121.top = 1097.0f;
        rectF121.right = 3219.0f;
        rectF121.bottom = 1217.0f;
        this.stationModels.add(new StationModel("Chughal Pur", rectF121, f, StopType.TRANSFER_STATION, 3));
        RectF rectF122 = new RectF();
        rectF122.left = 3181.0f;
        rectF122.top = 1106.0f;
        rectF122.right = 3301.0f;
        rectF122.bottom = 1226.0f;
        this.stationModels.add(new StationModel("Sardar Garhi", rectF122, f, StopType.TRANSFER_STATION, 2));
        RectF rectF123 = new RectF();
        rectF123.left = 3273.0f;
        rectF123.top = 1063.0f;
        rectF123.right = 3393.0f;
        rectF123.bottom = 1183.0f;
        this.stationModels.add(new StationModel("Chamkani", rectF123, f, StopType.TRANSFER_STATION, 1));
        return this.stationModels;
    }

    public void onReady() {
        this.activity.appAlerts.dismiss();
        PointF viewToSourceCoord = this.imageView.viewToSourceCoord(this.imageView.getCenter());
        this.imageView.doubleTapZoom(viewToSourceCoord, viewToSourceCoord);
    }

    public void setType(String str) {
        this.type = str;
    }
}
