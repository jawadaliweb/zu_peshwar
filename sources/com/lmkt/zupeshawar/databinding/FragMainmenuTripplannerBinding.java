package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Map.PinView;

public final class FragMainmenuTripplannerBinding implements ViewBinding {
    public final MaterialButton BtnZuWallet;
    public final EditText FromET;
    public final TextInputLayout FromETInput;
    public final ImageView IVFlip;
    public final EditText ToET;
    public final TextInputLayout ToETInput;
    public final PinView imageView;
    public final RadioButton list;
    public final ImageView logo;
    public final RadioButton map;
    public final ProgressBar progressBar;
    public final RadioGroup radiogroup;
    public final RelativeLayout relativeLayout;
    public final RelativeLayout relativeLayout2;
    private final CoordinatorLayout rootView;

    private FragMainmenuTripplannerBinding(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, EditText editText, TextInputLayout textInputLayout, ImageView imageView2, EditText editText2, TextInputLayout textInputLayout2, PinView pinView, RadioButton radioButton, ImageView imageView3, RadioButton radioButton2, ProgressBar progressBar2, RadioGroup radioGroup, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4) {
        this.rootView = coordinatorLayout;
        this.BtnZuWallet = materialButton;
        this.FromET = editText;
        this.FromETInput = textInputLayout;
        this.IVFlip = imageView2;
        this.ToET = editText2;
        this.ToETInput = textInputLayout2;
        this.imageView = pinView;
        this.list = radioButton;
        this.logo = imageView3;
        this.map = radioButton2;
        this.progressBar = progressBar2;
        this.radiogroup = radioGroup;
        this.relativeLayout = relativeLayout3;
        this.relativeLayout2 = relativeLayout4;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static FragMainmenuTripplannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragMainmenuTripplannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_tripplanner, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragMainmenuTripplannerBinding bind(View view) {
        View view2 = view;
        int i = R.id.Btn_ZuWallet;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.Btn_ZuWallet);
        if (materialButton != null) {
            i = R.id.From_ET;
            EditText editText = (EditText) view2.findViewById(R.id.From_ET);
            if (editText != null) {
                i = R.id.From_ET_Input;
                TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(R.id.From_ET_Input);
                if (textInputLayout != null) {
                    i = R.id.IV_flip;
                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.IV_flip);
                    if (imageView2 != null) {
                        i = R.id.To_ET;
                        EditText editText2 = (EditText) view2.findViewById(R.id.To_ET);
                        if (editText2 != null) {
                            i = R.id.To_ET_Input;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view2.findViewById(R.id.To_ET_Input);
                            if (textInputLayout2 != null) {
                                i = R.id.imageView;
                                PinView pinView = (PinView) view2.findViewById(R.id.imageView);
                                if (pinView != null) {
                                    i = R.id.list;
                                    RadioButton radioButton = (RadioButton) view2.findViewById(R.id.list);
                                    if (radioButton != null) {
                                        i = R.id.logo;
                                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.logo);
                                        if (imageView3 != null) {
                                            i = R.id.map;
                                            RadioButton radioButton2 = (RadioButton) view2.findViewById(R.id.map);
                                            if (radioButton2 != null) {
                                                i = R.id.progress_bar;
                                                ProgressBar progressBar2 = (ProgressBar) view2.findViewById(R.id.progress_bar);
                                                if (progressBar2 != null) {
                                                    i = R.id.radiogroup;
                                                    RadioGroup radioGroup = (RadioGroup) view2.findViewById(R.id.radiogroup);
                                                    if (radioGroup != null) {
                                                        i = R.id.relativeLayout;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.relativeLayout);
                                                        if (relativeLayout3 != null) {
                                                            i = R.id.relativeLayout2;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) view2.findViewById(R.id.relativeLayout2);
                                                            if (relativeLayout4 != null) {
                                                                return new FragMainmenuTripplannerBinding((CoordinatorLayout) view2, materialButton, editText, textInputLayout, imageView2, editText2, textInputLayout2, pinView, radioButton, imageView3, radioButton2, progressBar2, radioGroup, relativeLayout3, relativeLayout4);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
