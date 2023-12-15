package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ActivityTestBinding implements ViewBinding {
    public final Button btn1;
    public final Button btn2;
    public final Button btn3;
    public final Button btn4;
    public final LinearLayout layout;
    private final LinearLayout rootView;

    private ActivityTestBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.btn1 = button;
        this.btn2 = button2;
        this.btn3 = button3;
        this.btn4 = button4;
        this.layout = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_test, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTestBinding bind(View view) {
        int i = R.id.btn1;
        Button button = (Button) view.findViewById(R.id.btn1);
        if (button != null) {
            i = R.id.btn2;
            Button button2 = (Button) view.findViewById(R.id.btn2);
            if (button2 != null) {
                i = R.id.btn3;
                Button button3 = (Button) view.findViewById(R.id.btn3);
                if (button3 != null) {
                    i = R.id.btn4;
                    Button button4 = (Button) view.findViewById(R.id.btn4);
                    if (button4 != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        return new ActivityTestBinding(linearLayout, button, button2, button3, button4, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
