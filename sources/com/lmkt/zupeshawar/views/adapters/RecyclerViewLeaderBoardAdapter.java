package com.lmkt.zupeshawar.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.LeaderBoardModel;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewLeaderBoardAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<LeaderBoardModel> list = new ArrayList();

    public RecyclerViewLeaderBoardAdapter(Context context2) {
        this.context = context2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.row_item_leaderboard, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        LeaderBoardModel leaderBoardModel = this.list.get(i);
        if (i == 0 || i == 1) {
            viewHolder.noBackground.setImageResource(R.drawable.button_shape_green_rounded);
        } else {
            viewHolder.noBackground.setImageResource(R.drawable.button_shape_grey_rounded);
        }
        TextView textView = viewHolder.no;
        textView.setText((i + 2) + "");
        viewHolder.name.setText(leaderBoardModel.getName());
        viewHolder.number.setText(leaderBoardModel.getMobileNumber());
        TextView textView2 = viewHolder.time;
        textView2.setText(leaderBoardModel.getUsage() + "");
    }

    public void updateList(List<LeaderBoardModel> list2) {
        this.list.clear();
        this.list.addAll(list2);
        this.list.remove(0);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView no;
        ImageView noBackground;
        TextView number;
        TextView time;
        TextView timetitle;

        public ViewHolder(View view) {
            super(view);
            this.no = (TextView) view.findViewById(R.id.no);
            this.name = (TextView) view.findViewById(R.id.name);
            this.number = (TextView) view.findViewById(R.id.number);
            this.time = (TextView) view.findViewById(R.id.time);
            this.timetitle = (TextView) view.findViewById(R.id.time_label);
            this.noBackground = (ImageView) view.findViewById(R.id.no_background);
        }
    }
}
