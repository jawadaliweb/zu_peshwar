package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragTicketsRechargehistoryBinding implements ViewBinding {
    public final RelativeLayout footer;
    public final MaterialButton generatePdf;
    public final LinearLayout generatePdfView;
    public final ListView listview;
    public final TextView noDataTxt;
    private final RelativeLayout rootView;

    private FragTicketsRechargehistoryBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, MaterialButton materialButton, LinearLayout linearLayout, ListView listView, TextView textView) {
        this.rootView = relativeLayout;
        this.footer = relativeLayout2;
        this.generatePdf = materialButton;
        this.generatePdfView = linearLayout;
        this.listview = listView;
        this.noDataTxt = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragTicketsRechargehistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsRechargehistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets_rechargehistory, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsRechargehistoryBinding bind(View view) {
        int i = R.id.footer;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.footer);
        if (relativeLayout != null) {
            i = R.id.generate_Pdf;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.generate_Pdf);
            if (materialButton != null) {
                i = R.id.generate_PdfView;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.generate_PdfView);
                if (linearLayout != null) {
                    i = R.id.listview;
                    ListView listView = (ListView) view.findViewById(R.id.listview);
                    if (listView != null) {
                        i = R.id.noDataTxt;
                        TextView textView = (TextView) view.findViewById(R.id.noDataTxt);
                        if (textView != null) {
                            return new FragTicketsRechargehistoryBinding((RelativeLayout) view, relativeLayout, materialButton, linearLayout, listView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
