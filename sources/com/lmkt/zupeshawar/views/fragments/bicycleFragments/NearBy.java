package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.db.AppExecutors;
import com.lmkt.zupeshawar.db.BicyclesTB;
import com.lmkt.zupeshawar.db.DBZuApp;
import com.lmkt.zupeshawar.model.BicycleStandModel;
import com.lmkt.zupeshawar.model.Distance;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.recyclers.MapInfoAdapter;
import com.lmkt.zupeshawar.recyclers.StationsRecycler;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.NearBy;

public class NearBy extends Fragment implements View.OnClickListener, IOnBackPressed, OnMapReadyCallback, LocationListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 60000;
    static int Title = 2131886224;
    final String TAG = "Bicycle TAG";
    BicycleMenuItem activity;
    CardView card_view1;
    double latitude;
    Location location = null;
    protected LocationManager locationManager;
    double longitude;
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    RecyclerView recyclerView;
    StationsRecycler stationAdapter;

    public boolean onBackPressed() {
        return false;
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_nearby, viewGroup, false);
        this.activity = (BicycleMenuItem) getActivity();
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        this.mapFragment = supportMapFragment;
        supportMapFragment.getMapAsync(this);
        return inflate;
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
        this.stationAdapter = new StationsRecycler(new BicycleStandModel(), new Distance(), getContext());
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        RecyclerView recyclerView3 = this.recyclerView;
        recyclerView3.addItemDecoration(new DividerItemDecoration(recyclerView3.getContext(), 1));
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(this.stationAdapter);
        CardView cardView = (CardView) view.findViewById(R.id.card_view1);
        this.card_view1 = cardView;
        cardView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NearBy.this.lambda$initViews$0$NearBy(view);
            }
        });
        initToolbar();
    }

    public /* synthetic */ void lambda$initViews$0$NearBy(View view) {
        Location location2 = this.location;
        if (location2 != null) {
            this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(location2.getLatitude(), this.location.getLongitude())).zoom(17.0f).build()));
        }
    }

    private void initToolbar() {
        this.activity.mToolbar_Title.setText(Title);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng;
        this.mMap = googleMap;
        googleMap.clear();
        this.mMap.getUiSettings().setCompassEnabled(false);
        this.mMap.getUiSettings().setScrollGesturesEnabled(true);
        this.mMap.getUiSettings().setMapToolbarEnabled(false);
        this.mMap.getUiSettings().setMyLocationButtonEnabled(false);
        if (this.mMap != null) {
            if (ActivityCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.mMap.setMyLocationEnabled(true);
            } else {
                return;
            }
        }
        Location location2 = this.location;
        if (location2 != null) {
            latLng = new LatLng(location2.getLatitude(), this.location.getLongitude());
        } else {
            latLng = new LatLng(34.0151d, 71.5249d);
        }
        if (this.activity.isPermissionAvailable("android.permission.ACCESS_FINE_LOCATION")) {
            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                public final void run() {
                    NearBy.this.lambda$onMapReady$2$NearBy();
                }
            });
        }
        this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(latLng).zoom(2.0f).build()));
        this.mMap.setInfoWindowAdapter(new MapInfoAdapter(this.activity));
        this.mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            public final void onInfoWindowClick(Marker marker) {
                NearBy.this.lambda$onMapReady$3$NearBy(marker);
            }
        });
        this.mMap.setOnInfoWindowCloseListener(new GoogleMap.OnInfoWindowCloseListener() {
            public final void onInfoWindowClose(Marker marker) {
                NearBy.this.lambda$onMapReady$4$NearBy(marker);
            }
        });
    }

    public /* synthetic */ void lambda$onMapReady$2$NearBy() {
        for (BicyclesTB next : DBZuApp.getInstance(this.activity).bicycleDao().getStations()) {
            MarkerOptions markerOptions = new MarkerOptions();
            LatLng latLng = new LatLng(next.lat, next.lon);
            markerOptions.snippet(next.id + "");
            markerOptions.position(latLng);
            markerOptions.title(next.name);
            markerOptions.snippet("Location: " + next.lat + " , " + next.lon);
            markerOptions.icon(bitmapDescriptorFromVector(getActivity()));
            this.activity.runOnUiThread(new Runnable(markerOptions, next) {
                public final /* synthetic */ MarkerOptions f$1;
                public final /* synthetic */ BicyclesTB f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    NearBy.this.lambda$onMapReady$1$NearBy(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onMapReady$1$NearBy(MarkerOptions markerOptions, BicyclesTB bicyclesTB) {
        this.mMap.addMarker(markerOptions).setTag(Integer.valueOf(bicyclesTB.id));
    }

    public /* synthetic */ void lambda$onMapReady$3$NearBy(Marker marker) {
        getStationDetails(Integer.parseInt(String.valueOf(marker.getTag())));
    }

    public /* synthetic */ void lambda$onMapReady$4$NearBy(Marker marker) {
        this.recyclerView.setVisibility(8);
    }

    public void getStationDetails(int i) {
        this.activity.appAlerts.showPleaseWait(getContext());
        APIManager.getInstance().getBicycleStationDetails(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                NearBy.this.activity.appAlerts.dismiss();
                if (apiResponse.getRespCode().intValue() == 200) {
                    NearBy.this.stationAdapter.setItems(apiResponse.getData().getStationDetail(), apiResponse.getData().getDistance(), NearBy.this.location);
                    NearBy.this.stationAdapter.notifyDataSetChanged();
                    NearBy.this.recyclerView.setVisibility(0);
                    return;
                }
                NearBy.this.activity.appAlerts.showErrorDialog(NearBy.this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        NearBy.AnonymousClass1.this.lambda$onSuccess$0$NearBy$1();
                    }
                });
            }

            public /* synthetic */ void lambda$onSuccess$0$NearBy$1() {
                NearBy.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                NearBy.this.activity.appAlerts.dismiss();
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    NearBy.this.activity.appAlerts.showErrorAndLogout(NearBy.this.activity, str);
                } else {
                    NearBy.this.activity.appAlerts.showErrorDialog(NearBy.this.activity, str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            NearBy.AnonymousClass1.this.lambda$onFailure$1$NearBy$1();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$1$NearBy$1() {
                NearBy.this.activity.appAlerts.dismiss();
            }
        }, i, this.location.getLatitude(), this.location.getLongitude(), getContext());
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context) {
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_bicycle);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        drawable.draw(new Canvas(createBitmap));
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }

    public Location getCurrentLocation() {
        try {
            LocationManager locationManager2 = (LocationManager) this.activity.getSystemService(FirebaseAnalytics.Param.LOCATION);
            this.locationManager = locationManager2;
            boolean isProviderEnabled = locationManager2.isProviderEnabled("gps");
            boolean isProviderEnabled2 = this.locationManager.isProviderEnabled("network");
            if (isProviderEnabled || isProviderEnabled2) {
                if (isProviderEnabled2) {
                    if (this.activity.isPermissionAvailable("android.permission.ACCESS_FINE_LOCATION")) {
                        this.locationManager.requestLocationUpdates("network", MIN_TIME_BW_UPDATES, 10.0f, this);
                        Log.d("Network", "Network Enabled");
                        LocationManager locationManager3 = this.locationManager;
                        if (locationManager3 != null) {
                            Location lastKnownLocation = locationManager3.getLastKnownLocation("network");
                            this.location = lastKnownLocation;
                            if (lastKnownLocation != null) {
                                this.latitude = lastKnownLocation.getLatitude();
                                this.longitude = this.location.getLongitude();
                            }
                        }
                    }
                }
                if (isProviderEnabled && this.location == null && this.activity.isPermissionAvailable("android.permission.ACCESS_FINE_LOCATION")) {
                    this.locationManager.requestLocationUpdates("gps", MIN_TIME_BW_UPDATES, 10.0f, this);
                    Log.d("GPS", "GPS Enabled");
                    LocationManager locationManager4 = this.locationManager;
                    if (locationManager4 != null) {
                        Location lastKnownLocation2 = locationManager4.getLastKnownLocation("gps");
                        this.location = lastKnownLocation2;
                        if (lastKnownLocation2 != null) {
                            this.latitude = lastKnownLocation2.getLatitude();
                            this.longitude = this.location.getLongitude();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.location;
    }

    public void onResume() {
        this.mapFragment.onResume();
        if (this.activity.isPermissionAvailable("android.permission.ACCESS_FINE_LOCATION")) {
            getCurrentLocation();
        }
        super.onResume();
    }

    public void onPause() {
        this.mapFragment.onPause();
        super.onPause();
    }

    public void onDestroy() {
        this.mapFragment.onDestroy();
        super.onDestroy();
    }

    public void onLowMemory() {
        this.mapFragment.onLowMemory();
        super.onLowMemory();
    }

    public void onLocationChanged(Location location2) {
        this.location = location2;
        this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(location2.getLatitude(), location2.getLongitude())).zoom(17.0f).build()));
    }
}
