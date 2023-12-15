package com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.EstimatedFare;
import com.lmkt.zupeshawar.model.routeModels.GetRoutesMainModel;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import java.util.ArrayList;

public class TripPlannerDetail extends Fragment implements View.OnClickListener, APIManager.Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ListView Fares_LV;
    EditText From_ET;
    EditText To_ET;
    ArrayList<EstimatedFare> fares;
    String fromStation;
    String toStationName;

    public void onClick(View view) {
    }

    public void onFailure(int i, String str) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_triplist, viewGroup, false);
        initView(inflate);
        initToolbar();
        return inflate;
    }

    private void initView(View view) {
        Bundle arguments = getArguments();
        this.From_ET = (EditText) view.findViewById(R.id.From_ET);
        EditText editText = (EditText) view.findViewById(R.id.To_ET);
        this.To_ET = editText;
        editText.setOnClickListener(this);
        this.From_ET.setOnClickListener(this);
        this.Fares_LV = (ListView) view.findViewById(R.id.Fares_LV);
        this.fromStation = arguments.getString("fromstation", "");
        this.toStationName = arguments.getString("tostation", "");
        this.From_ET.setText(this.fromStation);
        this.To_ET.setText(this.toStationName);
        APIManager.getInstance().getFareEstimation(this, arguments.getInt("fromstationId"), arguments.getInt("tostationId"), requireContext());
        this.Fares_LV.setAdapter(new ListAdapter(getContext(), (ArrayList) arguments.getSerializable(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)));
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        if (apiResponse.getRespCode().intValue() == 200 || apiResponse.getRespCode().intValue() == 201) {
            this.fares = apiResponse.getData().getEstimatedFares();
        }
    }

    private void initToolbar() {
        MainMenuItemActivity mainMenuItemActivity = (MainMenuItemActivity) getActivity();
        mainMenuItemActivity.mToolbar_Title.setText(R.string.title_plantrip);
        mainMenuItemActivity.mToolbar_BackBtn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TripPlannerDetail.this.lambda$initToolbar$0$TripPlannerDetail(view);
            }
        });
    }

    public /* synthetic */ void lambda$initToolbar$0$TripPlannerDetail(View view) {
        getActivity().getSupportFragmentManager().popBackStack("TripPlanner", 1);
    }

    public String convertSeconds(int i) {
        String str;
        String str2;
        int i2 = i % 60;
        int i3 = i / 60;
        int i4 = i3 % 60;
        int i5 = i3 / 60;
        if (i4 < 10) {
            str = "0" + i4;
        } else {
            str = Integer.toString(i4);
        }
        if (i5 < 10) {
            str2 = "0" + i5;
        } else {
            str2 = Integer.toString(i5);
        }
        return str2 + com.microsoft.appcenter.Constants.COMMON_SCHEMA_PREFIX_SEPARATOR + str;
    }

    public class ListAdapter extends ArrayAdapter {
        LayoutInflater inflater;

        public ListAdapter(Context context, ArrayList<GetRoutesMainModel> arrayList) {
            super(context, 0, arrayList);
            this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x013c, code lost:
            if (r7.equals("5") == false) goto L_0x00a0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
            /*
                r6 = this;
                java.lang.Object r7 = r6.getItem(r7)
                com.lmkt.zupeshawar.model.routeModels.GetRoutesMainModel r7 = (com.lmkt.zupeshawar.model.routeModels.GetRoutesMainModel) r7
                android.view.LayoutInflater r8 = r6.inflater
                r9 = 2131558539(0x7f0d008b, float:1.8742397E38)
                r0 = 0
                android.view.View r8 = r8.inflate(r9, r0)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.-$$Lambda$TripPlannerDetail$ListAdapter$TQ_dtQbH8uaPRO8XqcijFYnHtF8 r9 = new com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.-$$Lambda$TripPlannerDetail$ListAdapter$TQ_dtQbH8uaPRO8XqcijFYnHtF8
                r9.<init>(r7)
                r8.setOnClickListener(r9)
                r9 = 2131362460(0x7f0a029c, float:1.8344701E38)
                android.view.View r9 = r8.findViewById(r9)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                r0 = 2131362461(0x7f0a029d, float:1.8344703E38)
                android.view.View r0 = r8.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r1 = 2131362622(0x7f0a033e, float:1.834503E38)
                android.view.View r1 = r8.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r2 = 2131362166(0x7f0a0176, float:1.8344105E38)
                android.view.View r2 = r8.findViewById(r2)
                android.widget.TextView r2 = (android.widget.TextView) r2
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                int r4 = r7.getTotalStops()
                r3.append(r4)
                java.lang.String r4 = " Stops"
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r1.setText(r3)
                java.lang.String r1 = r7.getEstimatedTravelTime()
                int r1 = java.lang.Integer.parseInt(r1)
                r3 = 2
                if (r1 >= r3) goto L_0x0062
                java.lang.String r1 = " Min"
                goto L_0x0064
            L_0x0062:
                java.lang.String r1 = " Mins"
            L_0x0064:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Est. time "
                r4.append(r5)
                java.lang.String r5 = r7.getEstimatedTravelTime()
                r4.append(r5)
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                r2.setText(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r1 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.Context r1 = r1.requireContext()
                java.util.List r7 = r7.getRoute()
                r2 = 0
                java.lang.Object r7 = r7.get(r2)
                java.lang.String r7 = (java.lang.String) r7
                java.util.Objects.requireNonNull(r7)
                java.lang.String r7 = (java.lang.String) r7
                r7.hashCode()
                r4 = -1
                int r5 = r7.hashCode()
                switch(r5) {
                    case 49: goto L_0x014c;
                    case 50: goto L_0x0140;
                    case 53: goto L_0x0136;
                    case 54: goto L_0x012a;
                    case 55: goto L_0x011e;
                    case 56: goto L_0x0113;
                    case 57: goto L_0x0108;
                    case 1567: goto L_0x00fd;
                    case 1568: goto L_0x00f1;
                    case 1569: goto L_0x00e4;
                    case 1572: goto L_0x00d7;
                    case 1646: goto L_0x00ca;
                    case 1647: goto L_0x00bd;
                    case 1677: goto L_0x00b0;
                    case 1678: goto L_0x00a3;
                    default: goto L_0x00a0;
                }
            L_0x00a0:
                r3 = -1
                goto L_0x0157
            L_0x00a3:
                java.lang.String r2 = "4B"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x00ac
                goto L_0x00a0
            L_0x00ac:
                r3 = 14
                goto L_0x0157
            L_0x00b0:
                java.lang.String r2 = "4A"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x00b9
                goto L_0x00a0
            L_0x00b9:
                r3 = 13
                goto L_0x0157
            L_0x00bd:
                java.lang.String r2 = "3B"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x00c6
                goto L_0x00a0
            L_0x00c6:
                r3 = 12
                goto L_0x0157
            L_0x00ca:
                java.lang.String r2 = "3A"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x00d3
                goto L_0x00a0
            L_0x00d3:
                r3 = 11
                goto L_0x0157
            L_0x00d7:
                java.lang.String r2 = "15"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x00e0
                goto L_0x00a0
            L_0x00e0:
                r3 = 10
                goto L_0x0157
            L_0x00e4:
                java.lang.String r2 = "12"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x00ed
                goto L_0x00a0
            L_0x00ed:
                r3 = 9
                goto L_0x0157
            L_0x00f1:
                java.lang.String r2 = "11"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x00fa
                goto L_0x00a0
            L_0x00fa:
                r3 = 8
                goto L_0x0157
            L_0x00fd:
                java.lang.String r2 = "10"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x0106
                goto L_0x00a0
            L_0x0106:
                r3 = 7
                goto L_0x0157
            L_0x0108:
                java.lang.String r2 = "9"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x0111
                goto L_0x00a0
            L_0x0111:
                r3 = 6
                goto L_0x0157
            L_0x0113:
                java.lang.String r2 = "8"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x011c
                goto L_0x00a0
            L_0x011c:
                r3 = 5
                goto L_0x0157
            L_0x011e:
                java.lang.String r2 = "7"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x0128
                goto L_0x00a0
            L_0x0128:
                r3 = 4
                goto L_0x0157
            L_0x012a:
                java.lang.String r2 = "6"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x0134
                goto L_0x00a0
            L_0x0134:
                r3 = 3
                goto L_0x0157
            L_0x0136:
                java.lang.String r2 = "5"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x0157
                goto L_0x00a0
            L_0x0140:
                java.lang.String r2 = "2"
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x014a
                goto L_0x00a0
            L_0x014a:
                r3 = 1
                goto L_0x0157
            L_0x014c:
                java.lang.String r3 = "1"
                boolean r7 = r7.equals(r3)
                if (r7 != 0) goto L_0x0156
                goto L_0x00a0
            L_0x0156:
                r3 = 0
            L_0x0157:
                r7 = 2131230900(0x7f0800b4, float:1.8077866E38)
                switch(r3) {
                    case 0: goto L_0x032a;
                    case 1: goto L_0x030a;
                    case 2: goto L_0x02ea;
                    case 3: goto L_0x02ca;
                    case 4: goto L_0x02a9;
                    case 5: goto L_0x0288;
                    case 6: goto L_0x0267;
                    case 7: goto L_0x0246;
                    case 8: goto L_0x0225;
                    case 9: goto L_0x0204;
                    case 10: goto L_0x01e3;
                    case 11: goto L_0x01c2;
                    case 12: goto L_0x01a1;
                    case 13: goto L_0x0180;
                    case 14: goto L_0x015f;
                    default: goto L_0x015d;
                }
            L_0x015d:
                goto L_0x0349
            L_0x015f:
                r9.setImageResource(r7)
                r7 = 2131099718(0x7f060046, float:1.7811797E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Direct Route 04B"
                r0.setText(r7)
                goto L_0x0349
            L_0x0180:
                r9.setImageResource(r7)
                r7 = 2131099717(0x7f060045, float:1.7811795E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Direct Route 04A"
                r0.setText(r7)
                goto L_0x0349
            L_0x01a1:
                r9.setImageResource(r7)
                r7 = 2131099716(0x7f060044, float:1.7811793E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Direct Route 03B"
                r0.setText(r7)
                goto L_0x0349
            L_0x01c2:
                r9.setImageResource(r7)
                r7 = 2131099715(0x7f060043, float:1.7811791E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Direct Route 03A"
                r0.setText(r7)
                goto L_0x0349
            L_0x01e3:
                r9.setImageResource(r7)
                r7 = 2131099727(0x7f06004f, float:1.7811815E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Super Express Route 15"
                r0.setText(r7)
                goto L_0x0349
            L_0x0204:
                r9.setImageResource(r7)
                r7 = 2131099726(0x7f06004e, float:1.7811813E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Express Route 12"
                r0.setText(r7)
                goto L_0x0349
            L_0x0225:
                r9.setImageResource(r7)
                r7 = 2131099725(0x7f06004d, float:1.7811811E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Direct Route 11"
                r0.setText(r7)
                goto L_0x0349
            L_0x0246:
                r9.setImageResource(r7)
                r7 = 2131099724(0x7f06004c, float:1.781181E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Express Route 10"
                r0.setText(r7)
                goto L_0x0349
            L_0x0267:
                r9.setImageResource(r7)
                r7 = 2131099723(0x7f06004b, float:1.7811807E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Express Route 09"
                r0.setText(r7)
                goto L_0x0349
            L_0x0288:
                r9.setImageResource(r7)
                r7 = 2131099722(0x7f06004a, float:1.7811805E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "BRT Stopping Route 08"
                r0.setText(r7)
                goto L_0x0349
            L_0x02a9:
                r9.setImageResource(r7)
                r7 = 2131099721(0x7f060049, float:1.7811803E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Direct Route 07"
                r0.setText(r7)
                goto L_0x0349
            L_0x02ca:
                r9.setImageResource(r7)
                r7 = 2131099720(0x7f060048, float:1.7811801E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Direct Route 06"
                r0.setText(r7)
                goto L_0x0349
            L_0x02ea:
                r9.setImageResource(r7)
                r7 = 2131099719(0x7f060047, float:1.78118E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "Direct Route 05"
                r0.setText(r7)
                goto L_0x0349
            L_0x030a:
                r9.setImageResource(r7)
                r7 = 2131099714(0x7f060042, float:1.781179E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "BRT Stopping Route 02"
                r0.setText(r7)
                goto L_0x0349
            L_0x032a:
                r9.setImageResource(r7)
                r7 = 2131099713(0x7f060041, float:1.7811787E38)
                int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
                r9.setColorFilter(r1)
                com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail r9 = com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.this
                android.content.res.Resources r9 = r9.getResources()
                int r7 = r9.getColor(r7)
                r0.setBackgroundColor(r7)
                java.lang.String r7 = "BRT Xpress Route 01"
                r0.setText(r7)
            L_0x0349:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlannerDetail.ListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        public /* synthetic */ void lambda$getView$0$TripPlannerDetail$ListAdapter(GetRoutesMainModel getRoutesMainModel, View view) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, getRoutesMainModel);
            bundle.putSerializable("fare", TripPlannerDetail.this.fares);
            bundle.putString("fromstation", TripPlannerDetail.this.fromStation);
            bundle.putString("tostation", TripPlannerDetail.this.toStationName);
            String str = Integer.parseInt(getRoutesMainModel.getEstimatedTravelTime()) < 2 ? " Min" : " Mins";
            bundle.putString("estTime", getRoutesMainModel.getEstimatedTravelTime() + str);
            bundle.putString(FirebaseAnalytics.Param.PRICE, "-");
            TripPlannerSheet tripPlannerSheet = new TripPlannerSheet();
            tripPlannerSheet.setArguments(bundle);
            FragmentTransaction beginTransaction = TripPlannerDetail.this.requireActivity().getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.frame, tripPlannerSheet);
            beginTransaction.addToBackStack("TripPlannerDetail");
            beginTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
            beginTransaction.commit();
        }
    }
}
