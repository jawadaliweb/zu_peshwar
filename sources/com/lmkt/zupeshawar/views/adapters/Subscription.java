package com.lmkt.zupeshawar.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.MemberShips;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.Membership;
import java.util.ArrayList;

public class Subscription extends RecyclerView.Adapter<ViewHolder> {
    private Membership.onItemClickListener listener;
    private LayoutInflater mInflater;
    private ArrayList<MemberShips> model;
    private View view;

    public Subscription(Context context, ArrayList<MemberShips> arrayList, Membership.onItemClickListener onitemclicklistener) {
        this.mInflater = LayoutInflater.from(context);
        this.listener = onitemclicklistener;
        this.model = arrayList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mInflater.inflate(R.layout.row_item_bicycle_subscription, viewGroup, false);
        this.view = inflate;
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MemberShips memberShips = this.model.get(i);
        viewHolder.duration_TV.setText(memberShips.membershipTitle);
        TextView textView = viewHolder.priceTv;
        textView.setText("Rs." + memberShips.cost);
        viewHolder.memberShipValidityTv.setText(memberShips.description);
        viewHolder.viewCard.setOnClickListener(new View.OnClickListener(memberShips) {
            public final /* synthetic */ MemberShips f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Subscription.this.lambda$onBindViewHolder$0$Subscription(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$Subscription(MemberShips memberShips, View view2) {
        this.listener.setMemberShips(memberShips);
    }

    public int getItemCount() {
        return this.model.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView duration_TV;
        public TextView memberShipValidityTv;
        public TextView priceTv;
        public RelativeLayout viewCard;

        public ViewHolder(View view) {
            super(view);
            this.duration_TV = (TextView) view.findViewById(R.id.duration_TV);
            this.priceTv = (TextView) view.findViewById(R.id.priceTv);
            this.memberShipValidityTv = (TextView) view.findViewById(R.id.memberShipValidityTv);
            this.viewCard = (RelativeLayout) view.findViewById(R.id.viewCard);
        }
    }
}
