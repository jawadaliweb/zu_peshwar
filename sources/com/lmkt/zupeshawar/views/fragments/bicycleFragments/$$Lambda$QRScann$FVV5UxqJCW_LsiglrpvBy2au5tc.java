package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lmkt.zupeshawar.R;

/* renamed from: com.lmkt.zupeshawar.views.fragments.bicycleFragments.-$$Lambda$QRScann$FVV5UxqJCW_LsiglrpvBy2au5tc  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$QRScann$FVV5UxqJCW_LsiglrpvBy2au5tc implements DialogInterface.OnShowListener {
    public static final /* synthetic */ $$Lambda$QRScann$FVV5UxqJCW_LsiglrpvBy2au5tc INSTANCE = new $$Lambda$QRScann$FVV5UxqJCW_LsiglrpvBy2au5tc();

    private /* synthetic */ $$Lambda$QRScann$FVV5UxqJCW_LsiglrpvBy2au5tc() {
    }

    public final void onShow(DialogInterface dialogInterface) {
        BottomSheetBehavior.from((FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
    }
}
