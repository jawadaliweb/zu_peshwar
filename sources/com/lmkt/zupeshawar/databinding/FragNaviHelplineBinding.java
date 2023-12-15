package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragNaviHelplineBinding implements ViewBinding {
    public final CardView BtnMakePhoneCall;
    public final CardView BtnSendEmail;
    public final MaterialButton BtnSendTicket;
    public final EditText ETDetails;
    public final RadioButton RBComplaint;
    public final RadioButton RBSuggestion;
    public final RadioGroup RGTicketType;
    public final ConstraintLayout attachmentsLayout;
    public final Spinner category;
    private final LinearLayout rootView;
    public final RecyclerView rvImages;
    public final Spinner subCategory;

    private FragNaviHelplineBinding(LinearLayout linearLayout, CardView cardView, CardView cardView2, MaterialButton materialButton, EditText editText, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, ConstraintLayout constraintLayout, Spinner spinner, RecyclerView recyclerView, Spinner spinner2) {
        this.rootView = linearLayout;
        this.BtnMakePhoneCall = cardView;
        this.BtnSendEmail = cardView2;
        this.BtnSendTicket = materialButton;
        this.ETDetails = editText;
        this.RBComplaint = radioButton;
        this.RBSuggestion = radioButton2;
        this.RGTicketType = radioGroup;
        this.attachmentsLayout = constraintLayout;
        this.category = spinner;
        this.rvImages = recyclerView;
        this.subCategory = spinner2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragNaviHelplineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragNaviHelplineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_helpline, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragNaviHelplineBinding bind(View view) {
        int i = R.id.Btn_MakePhoneCall;
        CardView cardView = (CardView) view.findViewById(R.id.Btn_MakePhoneCall);
        if (cardView != null) {
            i = R.id.Btn_SendEmail;
            CardView cardView2 = (CardView) view.findViewById(R.id.Btn_SendEmail);
            if (cardView2 != null) {
                i = R.id.Btn_SendTicket;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_SendTicket);
                if (materialButton != null) {
                    i = R.id.ET_Details;
                    EditText editText = (EditText) view.findViewById(R.id.ET_Details);
                    if (editText != null) {
                        i = R.id.RB_Complaint;
                        RadioButton radioButton = (RadioButton) view.findViewById(R.id.RB_Complaint);
                        if (radioButton != null) {
                            i = R.id.RB_Suggestion;
                            RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.RB_Suggestion);
                            if (radioButton2 != null) {
                                i = R.id.RG_TicketType;
                                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.RG_TicketType);
                                if (radioGroup != null) {
                                    i = R.id.attachmentsLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.attachmentsLayout);
                                    if (constraintLayout != null) {
                                        i = R.id.category;
                                        Spinner spinner = (Spinner) view.findViewById(R.id.category);
                                        if (spinner != null) {
                                            i = R.id.rvImages;
                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvImages);
                                            if (recyclerView != null) {
                                                i = R.id.subCategory;
                                                Spinner spinner2 = (Spinner) view.findViewById(R.id.subCategory);
                                                if (spinner2 != null) {
                                                    return new FragNaviHelplineBinding((LinearLayout) view, cardView, cardView2, materialButton, editText, radioButton, radioButton2, radioGroup, constraintLayout, spinner, recyclerView, spinner2);
                                                }
                                            }
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
