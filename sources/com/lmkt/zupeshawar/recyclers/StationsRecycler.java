package com.lmkt.zupeshawar.recyclers;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.BicycleStandModel;
import com.lmkt.zupeshawar.model.Distance;

public class StationsRecycler extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private Distance distance;
    private Location location;
    private BicycleStandModel station;

    public int getItemCount() {
        return 1;
    }

    public StationsRecycler(BicycleStandModel bicycleStandModel, Distance distance2, Context context2) {
        this.station = bicycleStandModel;
        this.distance = distance2;
        this.context = context2;
    }

    public void setItems(BicycleStandModel bicycleStandModel, Distance distance2, Location location2) {
        this.distance = distance2;
        this.station = bicycleStandModel;
        this.location = location2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bicycle_stand, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.stationName.setText(this.station.name);
        TextView textView = viewHolder.totalBicycle;
        textView.setText(this.station.rentCount + " cycles");
        TextView textView2 = viewHolder.standsAvailable;
        textView2.setText(this.station.restoreCount + " spaces");
        viewHolder.distance.setText(this.distance.distance);
        viewHolder.time.setText(this.distance.time);
        viewHolder.direction.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                StationsRecycler.this.lambda$onBindViewHolder$0$StationsRecycler(view);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$onBindViewHolder$0$StationsRecycler(android.view.View r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "http://maps.google.com/maps?saddr="
            r4.append(r0)
            android.location.Location r0 = r3.location
            double r0 = r0.getLatitude()
            r4.append(r0)
            java.lang.String r0 = ","
            r4.append(r0)
            android.location.Location r1 = r3.location
            double r1 = r1.getLongitude()
            r4.append(r1)
            java.lang.String r1 = "&daddr="
            r4.append(r1)
            com.lmkt.zupeshawar.model.BicycleStandModel r1 = r3.station
            double r1 = r1.lat
            r4.append(r1)
            r4.append(r0)
            com.lmkt.zupeshawar.model.BicycleStandModel r0 = r3.station
            double r0 = r0.lon
            r4.append(r0)
            java.lang.String r0 = "&dirflg=w"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            android.content.Intent r0 = new android.content.Intent
            android.net.Uri r1 = android.net.Uri.parse(r4)
            java.lang.String r2 = "android.intent.action.VIEW"
            r0.<init>(r2, r1)
            java.lang.String r1 = "com.google.android.apps.maps"
            r0.setPackage(r1)
            android.content.Context r1 = r3.context     // Catch:{ ActivityNotFoundException -> 0x0056 }
            r1.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0056 }
            goto L_0x0071
        L_0x0056:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x0065 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ ActivityNotFoundException -> 0x0065 }
            r0.<init>(r2, r4)     // Catch:{ ActivityNotFoundException -> 0x0065 }
            android.content.Context r4 = r3.context     // Catch:{ ActivityNotFoundException -> 0x0065 }
            r4.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0065 }
            goto L_0x0071
        L_0x0065:
            android.content.Context r4 = r3.context
            r0 = 1
            java.lang.String r1 = "Please install a maps application"
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r1, r0)
            r4.show()
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.recyclers.StationsRecycler.lambda$onBindViewHolder$0$StationsRecycler(android.view.View):void");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public MaterialButton direction;
        public TextView distance;
        public TextView standsAvailable;
        public TextView stationName;
        public TextView time;
        public TextView totalBicycle;

        public ViewHolder(View view) {
            super(view);
            this.stationName = (TextView) view.findViewById(R.id.stationName);
            this.totalBicycle = (TextView) view.findViewById(R.id.totalBicycle);
            this.standsAvailable = (TextView) view.findViewById(R.id.standsAvailable);
            this.distance = (TextView) view.findViewById(R.id.distance);
            this.direction = (MaterialButton) view.findViewById(R.id.direction);
            this.time = (TextView) view.findViewById(R.id.time);
        }
    }
}
