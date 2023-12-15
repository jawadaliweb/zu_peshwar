package com.lmkt.zupeshawar.views.fragments.busFragments;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.model.BusArrival;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import com.lmkt.zupeshawar.views.adapters.RecyclerViewRowItemBusArrival;
import com.lmkt.zupeshawar.views.fragments.busFragments.BusArrivalsList;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.ArrayList;
import java.util.List;

public class BusArrivalsList extends Fragment implements View.OnClickListener, IOnBackPressed {
    private static final String TAG = "Bus Arrivals Fragment";
    private String Title = "";
    /* access modifiers changed from: private */
    public MainMenuItemActivity activity;
    ListView busArrivals_LV;
    RecyclerView busArrivals_RV;
    /* access modifiers changed from: private */
    public Context context;
    private String date;
    /* access modifiers changed from: private */
    public String type;

    public void onResume() {
        super.onResume();
        this.activity.date.setVisibility(0);
        String str = this.date;
        if (str != null && !TextUtils.isEmpty(str)) {
            this.activity.date.setText(this.date);
        }
    }

    public void onStop() {
        super.onStop();
        this.activity.date.setVisibility(8);
        this.activity.date.setText("");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_busarrivals_a, viewGroup, false);
        try {
            initViews(inflate);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.Title = arguments.getString("Station");
                this.date = arguments.getString("date");
                this.type = arguments.getString(CommonProperties.TYPE);
                this.activity.mToolbar_Title.setText(this.Title);
                this.activity.appAlerts.showPleaseWait(this.activity);
                if (this.type.equalsIgnoreCase("BusSchedule")) {
                    String str = this.date;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        APIManager.getInstance().getBusSchedule(new APIManager.Callback() {
                            public void onSuccess(int i, ApiResponse apiResponse) {
                                BusArrivalsList.this.activity.appAlerts.dismiss();
                                if (i == ReturnCodes.Companion.OK()) {
                                    try {
                                        ArrayList<BusArrival> busArrivals = apiResponse.getData().getBusArrivals();
                                        if (busArrivals.size() > 0) {
                                            BusArrivalsList busArrivalsList = BusArrivalsList.this;
                                            BusArrivalsList.this.busArrivals_LV.setAdapter(new ListAdapter(busArrivalsList.activity, busArrivals, BusArrivalsList.this.type));
                                            return;
                                        }
                                        BusArrivalsList.this.activity.appAlerts.showAlertDialog(BusArrivalsList.this.activity, "No Schedule Found on this Station", "Server Message", new AppAlertDialog.AlertDialogListener() {
                                            public final void onClicked() {
                                                BusArrivalsList.AnonymousClass1.this.lambda$onSuccess$0$BusArrivalsList$1();
                                            }
                                        });
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        FirebaseCrashlytics.getInstance().log(e.getLocalizedMessage());
                                    }
                                } else {
                                    BusArrivalsList.this.activity.appAlerts.showErrorDialog(BusArrivalsList.this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                                        public final void onClicked() {
                                            BusArrivalsList.AnonymousClass1.this.lambda$onSuccess$1$BusArrivalsList$1();
                                        }
                                    });
                                }
                            }

                            public /* synthetic */ void lambda$onSuccess$0$BusArrivalsList$1() {
                                BusArrivalsList.this.activity.appAlerts.dismiss();
                                BusArrivalsList.this.activity.onBackPressed();
                            }

                            public /* synthetic */ void lambda$onSuccess$1$BusArrivalsList$1() {
                                BusArrivalsList.this.activity.appAlerts.dismiss();
                                BusArrivalsList.this.activity.onBackPressed();
                            }

                            public void onFailure(int i, String str) {
                                BusArrivalsList.this.activity.appAlerts.dismiss();
                                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                                    BusArrivalsList.this.activity.appAlerts.showErrorAndLogout(BusArrivalsList.this.activity, str);
                                } else {
                                    BusArrivalsList.this.activity.appAlerts.showErrorDialog(BusArrivalsList.this.activity, str, new AppAlertDialog.AlertDialogListener() {
                                        public final void onClicked() {
                                            BusArrivalsList.AnonymousClass1.this.lambda$onFailure$2$BusArrivalsList$1();
                                        }
                                    });
                                }
                            }

                            public /* synthetic */ void lambda$onFailure$2$BusArrivalsList$1() {
                                BusArrivalsList.this.activity.appAlerts.dismiss();
                                BusArrivalsList.this.activity.onBackPressed();
                            }
                        }, this.date, arguments.getInt("stationID"), getContext());
                    }
                }
                APIManager.getInstance().getBusArrivals(new APIManager.Callback() {
                    public void onSuccess(int i, ApiResponse apiResponse) {
                        BusArrivalsList.this.activity.appAlerts.dismiss();
                        if (i == ReturnCodes.Companion.OK()) {
                            try {
                                ArrayList<BusArrival> busArrivals = apiResponse.getData().getBusArrivals();
                                if (busArrivals.size() > 0) {
                                    BusArrivalsList busArrivalsList = BusArrivalsList.this;
                                    BusArrivalsList.this.busArrivals_LV.setAdapter(new ListAdapter(busArrivalsList.activity, busArrivals, BusArrivalsList.this.type));
                                    return;
                                }
                                BusArrivalsList.this.activity.appAlerts.showAlertDialog(BusArrivalsList.this.activity, "No Schedule Found on this Station", "Server Message", new AppAlertDialog.AlertDialogListener() {
                                    public final void onClicked() {
                                        BusArrivalsList.AnonymousClass2.this.lambda$onSuccess$0$BusArrivalsList$2();
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                                FirebaseCrashlytics.getInstance().log(e.getLocalizedMessage());
                            }
                        } else {
                            BusArrivalsList.this.activity.appAlerts.showErrorDialog(BusArrivalsList.this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                                public final void onClicked() {
                                    BusArrivalsList.AnonymousClass2.this.lambda$onSuccess$1$BusArrivalsList$2();
                                }
                            });
                        }
                    }

                    public /* synthetic */ void lambda$onSuccess$0$BusArrivalsList$2() {
                        BusArrivalsList.this.activity.appAlerts.dismiss();
                        BusArrivalsList.this.activity.onBackPressed();
                    }

                    public /* synthetic */ void lambda$onSuccess$1$BusArrivalsList$2() {
                        BusArrivalsList.this.activity.appAlerts.dismiss();
                        BusArrivalsList.this.activity.onBackPressed();
                    }

                    public void onFailure(int i, String str) {
                        BusArrivalsList.this.activity.appAlerts.dismiss();
                        if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                            BusArrivalsList.this.activity.appAlerts.showErrorAndLogout(BusArrivalsList.this.activity, str);
                        } else {
                            BusArrivalsList.this.activity.appAlerts.showErrorDialog(BusArrivalsList.this.activity, str, new AppAlertDialog.AlertDialogListener() {
                                public final void onClicked() {
                                    BusArrivalsList.AnonymousClass2.this.lambda$onFailure$2$BusArrivalsList$2();
                                }
                            });
                        }
                    }

                    public /* synthetic */ void lambda$onFailure$2$BusArrivalsList$2() {
                        BusArrivalsList.this.activity.appAlerts.dismiss();
                        BusArrivalsList.this.activity.onBackPressed();
                    }
                }, arguments.getInt("stationID"), getContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflate;
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.busArrivals_LV = (ListView) view.findViewById(R.id.busArrivals_LV);
        this.busArrivals_RV = (RecyclerView) view.findViewById(R.id.busArrivals_RV);
    }

    private void initToolbar() {
        MainMenuItemActivity mainMenuItemActivity = (MainMenuItemActivity) getActivity();
        this.activity = mainMenuItemActivity;
        this.context = mainMenuItemActivity.getBaseContext();
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Btn_Back) {
            getFragmentManager().popBackStack();
        }
    }

    public boolean onBackPressed() {
        getFragmentManager().popBackStack();
        return true;
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        List<BusArrival> busArrival;

        static {
            Class<BusArrivalsList> cls = BusArrivalsList.class;
        }

        public RecyclerAdapter(List<BusArrival> list) {
            this.busArrival = list;
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(BusArrivalsList.this.context).inflate(R.layout.row_item_bus_arrivals, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            BusArrival busArrival2 = this.busArrival.get(i);
            viewHolder.arrivalTime1_RV.setAdapter(new RecyclerViewRowItemBusArrival(BusArrivalsList.this.getContext(), busArrival2.getArrivals()));
            viewHolder.arrivalTime1_RV.setLayoutManager(new GridLayoutManager(BusArrivalsList.this.getContext(), 4));
            viewHolder.routeSource_TV.setText(busArrival2.getOrigin());
            viewHolder.routeDestination_TV.setText(busArrival2.getDestination());
            viewHolder.arrivalTime1_TV.setText(busArrival2.getArrivalTimes(busArrival2.getArrivals()));
            viewHolder.route_TV.setText(busArrival2.getRoute());
            if (busArrival2.getRouteID() != null) {
                switch (busArrival2.getRouteID().intValue()) {
                    case 1:
                        viewHolder.route_IV.setImageResource(R.drawable.ic_bus_route_01);
                        viewHolder.route_TV.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_01));
                        viewHolder.view2.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_01));
                        return;
                    case 2:
                        viewHolder.route_IV.setImageResource(R.drawable.ic_bus_route_02);
                        viewHolder.route_TV.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_02));
                        viewHolder.view2.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_02));
                        return;
                    case 3:
                        viewHolder.route_IV.setImageResource(R.drawable.ic_bus_route_03);
                        viewHolder.route_TV.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_03A));
                        viewHolder.view2.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_03A));
                        return;
                    case 4:
                        viewHolder.route_IV.setImageResource(R.drawable.ic_bus_route_04);
                        viewHolder.route_TV.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_04A));
                        viewHolder.view2.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_04A));
                        return;
                    case 5:
                        viewHolder.route_IV.setImageResource(R.drawable.ic_bus_route_05);
                        viewHolder.route_TV.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_05));
                        viewHolder.view2.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_05));
                        return;
                    case 6:
                        viewHolder.route_IV.setImageResource(R.drawable.ic_bus_route_06);
                        viewHolder.route_TV.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_06));
                        viewHolder.view2.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_06));
                        return;
                    case 7:
                        viewHolder.route_IV.setImageResource(R.drawable.ic_bus_route_07);
                        viewHolder.route_TV.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_07));
                        viewHolder.view2.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_07));
                        return;
                    default:
                        viewHolder.route_IV.setImageResource(R.drawable.ic_bus_route_01);
                        viewHolder.route_TV.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_01));
                        viewHolder.view2.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_01));
                        return;
                }
            }
        }

        public int getItemCount() {
            return this.busArrival.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            RecyclerView arrivalTime1_RV;
            TextView arrivalTime1_TV;
            TextView routeDestination_TV;
            TextView routeSource_TV;
            ImageView route_IV;
            TextView route_TV;
            CardView view2;

            public ViewHolder(View view) {
                super(view);
                this.route_IV = (ImageView) view.findViewById(R.id.route_IV);
                this.route_TV = (TextView) view.findViewById(R.id.route_TV);
                this.routeSource_TV = (TextView) view.findViewById(R.id.routeSource_TV);
                this.routeDestination_TV = (TextView) view.findViewById(R.id.routeDestination_TV);
                this.arrivalTime1_TV = (TextView) view.findViewById(R.id.arrivalTime1_TV);
                this.arrivalTime1_RV = (RecyclerView) view.findViewById(R.id.arrivalTime1_rv);
                this.view2 = (CardView) view.findViewById(R.id.view2);
            }
        }
    }

    public class ListAdapter extends ArrayAdapter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        LayoutInflater inflater;
        String type;

        static {
            Class<BusArrivalsList> cls = BusArrivalsList.class;
        }

        public ListAdapter(Context context, ArrayList arrayList, String str) {
            super(context, 0, arrayList);
            this.type = str;
            this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = this.inflater.inflate(R.layout.row_item_bus_arrivals, (ViewGroup) null);
            BusArrival busArrival = (BusArrival) getItem(i);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.route_IV);
            TextView textView = (TextView) inflate.findViewById(R.id.route_TV);
            TextView textView2 = (TextView) inflate.findViewById(R.id.arrivalTime1_TV);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.arrivalTime1_rv);
            CardView cardView = (CardView) inflate.findViewById(R.id.view2);
            ((TextView) inflate.findViewById(R.id.routeSource_TV)).setText(busArrival.getOrigin());
            ((TextView) inflate.findViewById(R.id.routeDestination_TV)).setText(busArrival.getDestination());
            if (this.type.equals("BusSchedule")) {
                recyclerView.setAdapter(new RecyclerViewRowItemBusArrival(getContext(), busArrival.getArrivals()));
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
                textView2.setVisibility(8);
                recyclerView.setVisibility(0);
            } else {
                textView2.setText(busArrival.getArrivalTimes(busArrival.getArrivals()));
                recyclerView.setVisibility(8);
                textView2.setVisibility(0);
            }
            textView.setText(busArrival.getRoute());
            if (busArrival.getRouteID() == null) {
                return inflate;
            }
            switch (busArrival.getRouteID().intValue()) {
                case 1:
                    imageView.setImageResource(R.drawable.ic_bus_route_01);
                    textView.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_01));
                    cardView.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_01));
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.ic_bus_route_02);
                    textView.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_02));
                    cardView.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_02));
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.ic_bus_route_03);
                    textView.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_03A));
                    cardView.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_03A));
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.ic_bus_route_04);
                    textView.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_04A));
                    cardView.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_04A));
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.ic_bus_route_05);
                    textView.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_05));
                    cardView.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_05));
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.ic_bus_route_06);
                    textView.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_06));
                    cardView.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_06));
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.ic_bus_route_07);
                    textView.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_07));
                    cardView.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_07));
                    break;
                default:
                    imageView.setImageResource(R.drawable.ic_bus_route_01);
                    textView.setBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_01));
                    cardView.setCardBackgroundColor(BusArrivalsList.this.getResources().getColor(R.color.color_Bus_Route_01));
                    break;
            }
            return inflate;
        }
    }
}
