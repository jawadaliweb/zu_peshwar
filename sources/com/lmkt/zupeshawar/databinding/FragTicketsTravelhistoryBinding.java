package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragTicketsTravelhistoryBinding implements ViewBinding {
    public final EditText ETFrom;
    public final EditText ETTo;
    public final RelativeLayout RLFrom;
    public final RelativeLayout RLTo;
    public final RelativeLayout footer;
    public final MaterialButton generatePdf;
    public final LinearLayout generatePdfView;
    public final TextView noDataTxt;
    private final RelativeLayout rootView;
    public final ListView travelHistoryLV;

    private FragTicketsTravelhistoryBinding(RelativeLayout relativeLayout, EditText editText, EditText editText2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, MaterialButton materialButton, LinearLayout linearLayout, TextView textView, ListView listView) {
        this.rootView = relativeLayout;
        this.ETFrom = editText;
        this.ETTo = editText2;
        this.RLFrom = relativeLayout2;
        this.RLTo = relativeLayout3;
        this.footer = relativeLayout4;
        this.generatePdf = materialButton;
        this.generatePdfView = linearLayout;
        this.noDataTxt = textView;
        this.travelHistoryLV = listView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragTicketsTravelhistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsTravelhistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets_travelhistory, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsTravelhistoryBinding bind(View view) {
        int i = R.id.ET_from;
        EditText editText = (EditText) view.findViewById(R.id.ET_from);
        if (editText != null) {
            i = R.id.ET_to;
            EditText editText2 = (EditText) view.findViewById(R.id.ET_to);
            if (editText2 != null) {
                i = R.id.RL_from;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.RL_from);
                if (relativeLayout != null) {
                    i = R.id.RL_to;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.RL_to);
                    if (relativeLayout2 != null) {
                        i = R.id.footer;
                        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.footer);
                        if (relativeLayout3 != null) {
                            i = R.id.generate_Pdf;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.generate_Pdf);
                            if (materialButton != null) {
                                i = R.id.generate_PdfView;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.generate_PdfView);
                                if (linearLayout != null) {
                                    i = R.id.noDataTxt;
                                    TextView textView = (TextView) view.findViewById(R.id.noDataTxt);
                                    if (textView != null) {
                                        i = R.id.travelHistory_LV;
                                        ListView listView = (ListView) view.findViewById(R.id.travelHistory_LV);
                                        if (listView != null) {
                                            return new FragTicketsTravelhistoryBinding((RelativeLayout) view, editText, editText2, relativeLayout, relativeLayout2, relativeLayout3, materialButton, linearLayout, textView, listView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
