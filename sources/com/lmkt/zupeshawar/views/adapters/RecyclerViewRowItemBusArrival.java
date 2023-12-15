package com.lmkt.zupeshawar.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewRowItemBusArrival extends RecyclerView.Adapter<ViewHolder> {
    List<String> busArrivals;
    Context context;

    public RecyclerViewRowItemBusArrival(Context context2, ArrayList<String> arrayList) {
        this.context = context2;
        this.busArrivals = arrayList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.recycler_view_row_item_bus_arrivals, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(this.busArrivals.get(i));
    }

    public int getItemCount() {
        return this.busArrivals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public ViewHolder(View view) {
            super(view);
            this.tv = (TextView) view.findViewById(R.id.arrivalTime1_TV);
        }
    }
}
