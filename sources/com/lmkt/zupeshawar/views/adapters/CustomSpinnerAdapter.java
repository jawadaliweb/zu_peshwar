package com.lmkt.zupeshawar.views.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.lmkt.zupeshawar.R;

public class CustomSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {
    Context context;
    Typeface font;
    String[] listItems;

    public long getItemId(int i) {
        return (long) i;
    }

    public CustomSpinnerAdapter(Context context2, String[] strArr) {
        this.listItems = strArr;
        this.context = context2;
        this.font = Typeface.createFromAsset(context2.getAssets(), "fonts/psr.ttf");
    }

    public int getCount() {
        return this.listItems.length;
    }

    public String getItem(int i) {
        return this.listItems[i];
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) View.inflate(this.context, R.layout.item_spinner, (ViewGroup) null).findViewById(R.id.main);
        textView.setTypeface(this.font);
        textView.setText(this.listItems[i]);
        return textView;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(this.context, R.layout.item_spinner, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.main);
        textView.setTypeface(this.font);
        textView.setText(this.listItems[i]);
        return inflate;
    }
}
