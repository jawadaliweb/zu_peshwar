package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class DialogMissingPermBinding implements ViewBinding {
    public final Button btCheckPermissions;
    public final Button btGetDeniedPermissions;
    public final Button btOpenSettings;
    public final LinearLayout permissionsFragLayout;
    private final LinearLayout rootView;
    public final TextView tvDeniedPermissionsList;
    public final TextView tvGettingPermission;
    public final TextView tvNeverAskAgainPermissionsList;
    public final TextView tvRequestNeverAskAgainPermissions;
    public final TextView tvRequestPermissions;

    private DialogMissingPermBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btCheckPermissions = button;
        this.btGetDeniedPermissions = button2;
        this.btOpenSettings = button3;
        this.permissionsFragLayout = linearLayout2;
        this.tvDeniedPermissionsList = textView;
        this.tvGettingPermission = textView2;
        this.tvNeverAskAgainPermissionsList = textView3;
        this.tvRequestNeverAskAgainPermissions = textView4;
        this.tvRequestPermissions = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogMissingPermBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogMissingPermBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_missing_perm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogMissingPermBinding bind(View view) {
        int i = R.id.bt_checkPermissions;
        Button button = (Button) view.findViewById(R.id.bt_checkPermissions);
        if (button != null) {
            i = R.id.bt_getDeniedPermissions;
            Button button2 = (Button) view.findViewById(R.id.bt_getDeniedPermissions);
            if (button2 != null) {
                i = R.id.bt_openSettings;
                Button button3 = (Button) view.findViewById(R.id.bt_openSettings);
                if (button3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i = R.id.tv_deniedPermissionsList;
                    TextView textView = (TextView) view.findViewById(R.id.tv_deniedPermissionsList);
                    if (textView != null) {
                        i = R.id.tv_getting_permission;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_getting_permission);
                        if (textView2 != null) {
                            i = R.id.tv_neverAskAgainPermissionsList;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_neverAskAgainPermissionsList);
                            if (textView3 != null) {
                                i = R.id.tv_requestNeverAskAgainPermissions;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_requestNeverAskAgainPermissions);
                                if (textView4 != null) {
                                    i = R.id.tv_requestPermissions;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_requestPermissions);
                                    if (textView5 != null) {
                                        return new DialogMissingPermBinding(linearLayout, button, button2, button3, linearLayout, textView, textView2, textView3, textView4, textView5);
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
