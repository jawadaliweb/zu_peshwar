package dev.shreyaspatil.MaterialDialog;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import dev.shreyaspatil.MaterialDialog.AbstractDialog;
import dev.shreyaspatil.MaterialDialog.model.DialogButton;
import dev.shreyaspatil.MaterialDialog.model.DialogMessage;
import dev.shreyaspatil.MaterialDialog.model.DialogTitle;

public final class MaterialDialog extends AbstractDialog {
    private MaterialDialog(Activity activity, DialogTitle dialogTitle, DialogMessage dialogMessage, boolean z, DialogButton dialogButton, DialogButton dialogButton2, int i, String str) {
        super(activity, dialogTitle, dialogMessage, z, dialogButton, dialogButton2, i, str);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(createView(activity.getLayoutInflater(), (ViewGroup) null));
        builder.setCancelable(z);
        this.mDialog = builder.create();
    }

    public static class Builder extends AbstractDialog.Builder<MaterialDialog> {
        public Builder(Activity activity) {
            super(activity);
        }

        public MaterialDialog build() {
            return new MaterialDialog(this.activity, this.title, this.message, this.isCancelable, this.positiveButton, this.negativeButton, this.animationResId, this.animationFile);
        }
    }
}
