package com.lmkt.zupeshawar.Utilities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.lmkt.zupeshawar.BuildConfig;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.model.MemberShips;
import com.lmkt.zupeshawar.views.adapters.CustomListAdapter;
import com.ortiz.touchview.TouchImageView;
import java.util.Objects;

public class AppAlertDialog {
    Button Btn_No;
    Button Btn_OK;
    Button Btn_Yes;
    private Activity activity;
    private Context context;
    Dialog dialog;
    KProgressHUD mDialog;

    public interface AlertDialogListener {
        void onClicked();
    }

    public AppAlertDialog(Context context2) {
        this.context = context2;
        this.activity = (Activity) context2;
    }

    public void showPleaseWait(Context context2) {
        KProgressHUD dimAmount = KProgressHUD.create(context2).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("Please wait").setCancellable(false).setAnimationSpeed(2).setDimAmount(0.5f);
        this.mDialog = dimAmount;
        dimAmount.show();
    }

    public void dismiss() {
        KProgressHUD kProgressHUD = this.mDialog;
        if (kProgressHUD != null && kProgressHUD.isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        Dialog dialog2 = this.dialog;
        if (dialog2 != null && dialog2.isShowing()) {
            this.dialog.dismiss();
            this.dialog = null;
        }
    }

    public void showSuccessDialog(Context context2, String str, AlertDialogListener alertDialogListener) {
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.dialog_success, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.msg)).setText(str);
        Button button = (Button) inflate.findViewById(R.id.btn_ok);
        this.Btn_OK = button;
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppAlertDialog.AlertDialogListener.this.onClicked();
            }
        });
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(context2, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showAlertDialog(Context context2, String str, String str2, AlertDialogListener alertDialogListener) {
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.dialog_alert, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.headertext)).setText(str2);
        ((TextView) inflate.findViewById(R.id.msg)).setText(str);
        Button button = (Button) inflate.findViewById(R.id.btn_ok);
        this.Btn_OK = button;
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppAlertDialog.AlertDialogListener.this.onClicked();
            }
        });
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(context2, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showEasyPaisaDialog(Context context2, Boolean bool) {
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.dialog_easypaisa, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.label_point);
        if (bool.booleanValue()) {
            textView.setText(R.string.bulleted_list);
        } else {
            textView.setText(R.string.bulleted_list_jazz);
        }
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(context2, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showErrorDialog(Context context2, String str, AlertDialogListener alertDialogListener) {
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.dialog_error, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.msg)).setText(str);
        FirebaseCrashlytics.getInstance().log(str);
        Button button = (Button) inflate.findViewById(R.id.btn_ok);
        this.Btn_OK = button;
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppAlertDialog.AlertDialogListener.this.onClicked();
            }
        });
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(context2, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showMemberShipDialog(Context context2, MemberShips memberShips, AlertDialogListener alertDialogListener) {
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.dialog_bss_membership, (ViewGroup) null);
        ((ListView) inflate.findViewById(R.id.listShowJSONData)).setAdapter(new CustomListAdapter(context2, memberShips.details));
        ((TextView) inflate.findViewById(R.id.costTv)).setText("Rs. " + memberShips.cost);
        ((TextView) inflate.findViewById(R.id.duration_TV)).setText(memberShips.membershipTitle);
        ((LinearLayout) inflate.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppAlertDialog.this.lambda$showMemberShipDialog$3$AppAlertDialog(view);
            }
        });
        ((MaterialButton) inflate.findViewById(R.id.Btn_zuWallet)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppAlertDialog.AlertDialogListener.this.onClicked();
            }
        });
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(context2, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$showMemberShipDialog$3$AppAlertDialog(View view) {
        dismiss();
    }

    public void showErrorAndLogout(Activity activity2, String str) {
        View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.dialog_error, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.msg)).setText(str);
        Button button = (Button) inflate.findViewById(R.id.btn_ok);
        this.Btn_OK = button;
        button.setOnClickListener(new View.OnClickListener(activity2) {
            public final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AppAlertDialog.this.lambda$showErrorAndLogout$5$AppAlertDialog(this.f$1, view);
            }
        });
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(this.context, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$showErrorAndLogout$5$AppAlertDialog(Activity activity2, View view) {
        SharedPrefrencesUtil.clearPrefrences(activity2);
        activity2.finishAffinity();
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.cancel();
        }
    }

    public void showLogout(Activity activity2) {
        View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.dialog_logout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.msg)).setText("Are you sure you want to logout.");
        this.Btn_Yes = (Button) inflate.findViewById(R.id.Btn_Yes);
        this.Btn_No = (Button) inflate.findViewById(R.id.Btn_No);
        this.Btn_Yes.setOnClickListener(new View.OnClickListener(activity2) {
            public final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AppAlertDialog.this.lambda$showLogout$6$AppAlertDialog(this.f$1, view);
            }
        });
        this.Btn_No.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppAlertDialog.this.lambda$showLogout$7$AppAlertDialog(view);
            }
        });
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(this.context, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$showLogout$6$AppAlertDialog(Activity activity2, View view) {
        SharedPrefrencesUtil.clearPrefrences(activity2);
        activity2.finishAffinity();
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.cancel();
        }
    }

    public /* synthetic */ void lambda$showLogout$7$AppAlertDialog(View view) {
        this.dialog.cancel();
        this.dialog = null;
    }

    public void showServiceDetails(Activity activity2, AlertDialogListener alertDialogListener) {
        View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.dialog_service, (ViewGroup) null);
        final TouchImageView touchImageView = (TouchImageView) inflate.findViewById(R.id.ZuMap_IV);
        final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        progressBar.bringToFront();
        progressBar.setVisibility(0);
        RequestManager with = Glide.with(activity2);
        ((RequestBuilder) ((RequestBuilder) with.load(BuildConfig.baseURLLivePWR + "Common/GetImage?filename=DetailedSchedule.jpeg").listener(new RequestListener<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                progressBar.setVisibility(8);
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                progressBar.setVisibility(8);
                touchImageView.setVisibility(0);
                return false;
            }
        }).signature(new ObjectKey(String.valueOf(System.currentTimeMillis())))).diskCacheStrategy(DiskCacheStrategy.NONE)).into((ImageView) touchImageView);
        Button button = (Button) inflate.findViewById(R.id.Btn_ZuWallet);
        this.Btn_OK = button;
        button.setOnClickListener(new View.OnClickListener(activity2, alertDialogListener) {
            public final /* synthetic */ Activity f$1;
            public final /* synthetic */ AppAlertDialog.AlertDialogListener f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                AppAlertDialog.this.lambda$showServiceDetails$8$AppAlertDialog(this.f$1, this.f$2, view);
            }
        });
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(this.context, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$showServiceDetails$8$AppAlertDialog(Activity activity2, AlertDialogListener alertDialogListener, View view) {
        if (this.dialog != null) {
            activity2.onBackPressed();
            alertDialogListener.onClicked();
        }
    }

    public void showAgreeDialog(Context context2, String str, String str2, AlertDialogListener alertDialogListener) {
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.dialog_logout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.headertext)).setText(str2);
        ((TextView) inflate.findViewById(R.id.msg)).setText(str);
        Dialog dialog2 = new Dialog(context2, R.style.dialogTheme);
        dialog2.setContentView(inflate);
        dialog2.setCancelable(false);
        Window window = dialog2.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        ((MaterialButton) inflate.findViewById(R.id.Btn_Yes)).setOnClickListener(new View.OnClickListener(dialog2) {
            public final /* synthetic */ Dialog f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AppAlertDialog.lambda$showAgreeDialog$9(AppAlertDialog.AlertDialogListener.this, this.f$1, view);
            }
        });
        ((MaterialButton) inflate.findViewById(R.id.Btn_No)).setOnClickListener(new View.OnClickListener(dialog2) {
            public final /* synthetic */ Dialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
        try {
            if (dialog2.isShowing()) {
                dialog2.dismiss();
            }
            dialog2.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$showAgreeDialog$9(AlertDialogListener alertDialogListener, Dialog dialog2, View view) {
        alertDialogListener.onClicked();
        dialog2.dismiss();
    }

    public void showHtml(Context context2, String str, AlertDialogListener alertDialogListener) {
        View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.dialog_webview, (ViewGroup) null);
        ((WebView) inflate.findViewById(R.id.myWebView)).loadDataWithBaseURL((String) null, str, "text/html", "utf-8", (String) null);
        ((LinearLayout) inflate.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppAlertDialog.AlertDialogListener.this.onClicked();
            }
        });
        if (this.dialog == null) {
            Dialog dialog2 = new Dialog(context2, R.style.dialogTheme);
            this.dialog = dialog2;
            dialog2.setContentView(inflate);
            this.dialog.setCancelable(false);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            try {
                Dialog dialog3 = this.dialog;
                if (dialog3 == null) {
                    return;
                }
                if (dialog3.isShowing()) {
                    this.dialog.dismiss();
                    this.dialog.show();
                    return;
                }
                this.dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
