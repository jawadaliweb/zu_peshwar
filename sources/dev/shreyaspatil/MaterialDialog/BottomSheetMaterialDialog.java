package dev.shreyaspatil.MaterialDialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import dev.shreyaspatil.MaterialDialog.AbstractDialog;
import dev.shreyaspatil.MaterialDialog.model.DialogButton;
import dev.shreyaspatil.MaterialDialog.model.DialogMessage;
import dev.shreyaspatil.MaterialDialog.model.DialogTitle;

public final class BottomSheetMaterialDialog extends AbstractDialog {
    private BottomSheetMaterialDialog(final Activity activity, DialogTitle dialogTitle, DialogMessage dialogMessage, boolean z, DialogButton dialogButton, DialogButton dialogButton2, int i, String str) {
        super(activity, dialogTitle, dialogMessage, z, dialogButton, dialogButton2, i, str);
        this.mDialog = new BottomSheetDialog(activity);
        View createView = createView(activity.getLayoutInflater(), (ViewGroup) null);
        this.mDialog.setContentView(createView);
        this.mDialog.setCancelable(z);
        if (Build.VERSION.SDK_INT >= 21) {
            createView.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    float dimension = activity.getResources().getDimension(R.dimen.radiusTop);
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight() + ((int) dimension), dimension);
                }
            });
            createView.setClipToOutline(true);
        } else {
            createView.findViewById(R.id.relative_layout_dialog).setPadding(0, (int) activity.getResources().getDimension(R.dimen.paddingTop), 0, 0);
        }
        this.mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                FrameLayout frameLayout = (FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior.from(frameLayout).setState(3);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return super.createView(layoutInflater, viewGroup);
    }

    public static class Builder extends AbstractDialog.Builder<BottomSheetMaterialDialog> {
        public Builder(Activity activity) {
            super(activity);
        }

        public BottomSheetMaterialDialog build() {
            return new BottomSheetMaterialDialog(this.activity, this.title, this.message, this.isCancelable, this.positiveButton, this.negativeButton, this.animationResId, this.animationFile);
        }
    }

    static class BottomSheetDialog extends com.google.android.material.bottomsheet.BottomSheetDialog {
        BottomSheetDialog(Context context) {
            super(context, R.style.BottomSheetDialogTheme);
        }
    }
}
