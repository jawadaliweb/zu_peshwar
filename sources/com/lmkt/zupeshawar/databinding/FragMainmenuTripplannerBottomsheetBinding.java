package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Map.PinView;

public final class FragMainmenuTripplannerBottomsheetBinding implements ViewBinding {
    public final EditText FromET;
    public final TextInputLayout FromETInput;
    public final ImageView IVFlip;
    public final EditText ToET;
    public final TextInputLayout ToETInput;
    public final PinView imageView;
    public final ProgressBar progressBar;
    private final CoordinatorLayout rootView;

    private FragMainmenuTripplannerBottomsheetBinding(CoordinatorLayout coordinatorLayout, EditText editText, TextInputLayout textInputLayout, ImageView imageView2, EditText editText2, TextInputLayout textInputLayout2, PinView pinView, ProgressBar progressBar2) {
        this.rootView = coordinatorLayout;
        this.FromET = editText;
        this.FromETInput = textInputLayout;
        this.IVFlip = imageView2;
        this.ToET = editText2;
        this.ToETInput = textInputLayout2;
        this.imageView = pinView;
        this.progressBar = progressBar2;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static FragMainmenuTripplannerBottomsheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragMainmenuTripplannerBottomsheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_tripplanner_bottomsheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragMainmenuTripplannerBottomsheetBinding bind(View view) {
        int i = R.id.From_ET;
        EditText editText = (EditText) view.findViewById(R.id.From_ET);
        if (editText != null) {
            i = R.id.From_ET_Input;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.From_ET_Input);
            if (textInputLayout != null) {
                i = R.id.IV_flip;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.IV_flip);
                if (imageView2 != null) {
                    i = R.id.To_ET;
                    EditText editText2 = (EditText) view.findViewById(R.id.To_ET);
                    if (editText2 != null) {
                        i = R.id.To_ET_Input;
                        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.To_ET_Input);
                        if (textInputLayout2 != null) {
                            i = R.id.imageView;
                            PinView pinView = (PinView) view.findViewById(R.id.imageView);
                            if (pinView != null) {
                                i = R.id.progress_bar;
                                ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progress_bar);
                                if (progressBar2 != null) {
                                    return new FragMainmenuTripplannerBottomsheetBinding((CoordinatorLayout) view, editText, textInputLayout, imageView2, editText2, textInputLayout2, pinView, progressBar2);
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
