package com.lmkt.zupeshawar.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.Details;

public class CustomListAdapter extends BaseAdapter {
    Context c;
    Details[] model;

    public long getItemId(int i) {
        return (long) i;
    }

    public CustomListAdapter(Context context, Details[] detailsArr) {
        this.c = context;
        this.model = detailsArr;
    }

    public int getCount() {
        return this.model.length;
    }

    public Details getItem(int i) {
        return this.model[i];
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.c).inflate(R.layout.row_membership_bss, viewGroup, false);
        }
        String str = this.model[i].duration;
        int i2 = this.model[i].cost;
        ((TextView) view.findViewById(R.id.userDetails)).setText(str);
        ((TextView) view.findViewById(R.id.userStatus)).setText(i2 + "");
        return view;
    }
}
