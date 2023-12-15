package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.lmkt.zupeshawar.R;

public final class FragMainmenuTriplistBinding implements ViewBinding {
    public final ListView FaresLV;
    public final EditText FromET;
    public final TextInputLayout FromETInput;
    public final ImageView IVFlip;
    public final EditText ToET;
    public final TextInputLayout ToETInput;
    public final LinearLayout header;
    private final RelativeLayout rootView;

    private FragMainmenuTriplistBinding(RelativeLayout relativeLayout, ListView listView, EditText editText, TextInputLayout textInputLayout, ImageView imageView, EditText editText2, TextInputLayout textInputLayout2, LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.FaresLV = listView;
        this.FromET = editText;
        this.FromETInput = textInputLayout;
        this.IVFlip = imageView;
        this.ToET = editText2;
        this.ToETInput = textInputLayout2;
        this.header = linearLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragMainmenuTriplistBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragMainmenuTriplistBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_triplist, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragMainmenuTriplistBinding bind(View view) {
        int i = R.id.Fares_LV;
        ListView listView = (ListView) view.findViewById(R.id.Fares_LV);
        if (listView != null) {
            i = R.id.From_ET;
            EditText editText = (EditText) view.findViewById(R.id.From_ET);
            if (editText != null) {
                i = R.id.From_ET_Input;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.From_ET_Input);
                if (textInputLayout != null) {
                    i = R.id.IV_flip;
                    ImageView imageView = (ImageView) view.findViewById(R.id.IV_flip);
                    if (imageView != null) {
                        i = R.id.To_ET;
                        EditText editText2 = (EditText) view.findViewById(R.id.To_ET);
                        if (editText2 != null) {
                            i = R.id.To_ET_Input;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.To_ET_Input);
                            if (textInputLayout2 != null) {
                                i = R.id.header;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.header);
                                if (linearLayout != null) {
                                    return new FragMainmenuTriplistBinding((RelativeLayout) view, listView, editText, textInputLayout, imageView, editText2, textInputLayout2, linearLayout);
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
