package com.lmkt.zupeshawar.views.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.db.CategoryTB;
import java.util.List;

public class CategoryAdapter extends ArrayAdapter<CategoryTB> {
    LayoutInflater flater;
    private final Typeface font;

    public CategoryAdapter(Activity activity, int i, int i2, List<CategoryTB> list) {
        super(activity, i, i2, list);
        this.flater = activity.getLayoutInflater();
        this.font = Typeface.createFromAsset(activity.getAssets(), "fonts/psr.ttf");
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return rowview(view, i, viewGroup);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return rowview(view, i, viewGroup);
    }

    private View rowview(View view, int i, ViewGroup viewGroup) {
        if (view == null) {
            view = this.flater.inflate(R.layout.row_item_category, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        textView.setText(((CategoryTB) getItem(i)).name);
        textView.setTypeface(this.font);
        return view;
    }

    private class viewHolder {
        ImageView imageView;
        TextView txtTitle;

        private viewHolder() {
        }
    }
}
