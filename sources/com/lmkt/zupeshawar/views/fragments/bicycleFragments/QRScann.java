package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.zxing.Result;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.views.activities.MainDashboard;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.QRScann;

public class QRScann extends BottomSheetDialogFragment {
    /* access modifiers changed from: private */
    public MainDashboard context;
    BottomSheetDialog dialog;
    private CodeScanner mCodeScanner;

    public QRScann(MainDashboard mainDashboard) {
        this.context = mainDashboard;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_qr_scan, viewGroup, false);
        CodeScanner codeScanner = new CodeScanner(requireActivity(), (CodeScannerView) inflate.findViewById(R.id.scanner_view));
        this.mCodeScanner = codeScanner;
        codeScanner.setDecodeCallback(new DecodeCallback() {
            public final void onDecoded(Result result) {
                QRScann.this.lambda$onCreateView$1$QRScann(result);
            }
        });
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$1$QRScann(Result result) {
        vibration();
        requireActivity().runOnUiThread(new Runnable(result) {
            public final /* synthetic */ Result f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                QRScann.this.lambda$onCreateView$0$QRScann(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onCreateView$0$QRScann(final Result result) {
        this.context.appAlerts.showAgreeDialog(requireContext(), "Are you sure to unlock bicycle? ", "Alert", new AppAlertDialog.AlertDialogListener() {
            public void onClicked() {
                QRScann.this.context.appAlerts.showPleaseWait(QRScann.this.getActivity());
                QRScann.this.unloadBicycle(result.getText());
            }
        });
    }

    private void vibration() {
        Vibrator vibrator = (Vibrator) requireActivity().getSystemService("vibrator");
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
        } else {
            vibrator.vibrate(500);
        }
    }

    /* access modifiers changed from: private */
    public void unloadBicycle(String str) {
        APIManager.getInstance().rentQRCode(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                if (i == ReturnCodes.Companion.OK()) {
                    QRScann.this.context.appAlerts.showSuccessDialog(QRScann.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            QRScann.AnonymousClass2.this.lambda$onSuccess$0$QRScann$2();
                        }
                    });
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    QRScann.this.context.appAlerts.showErrorAndLogout(QRScann.this.context, apiResponse.getRespMessage());
                } else {
                    QRScann.this.context.appAlerts.showErrorDialog(QRScann.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            QRScann.AnonymousClass2.this.lambda$onSuccess$1$QRScann$2();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$QRScann$2() {
                QRScann.this.context.appAlerts.dismiss();
                QRScann.this.dialog.dismiss();
            }

            public /* synthetic */ void lambda$onSuccess$1$QRScann$2() {
                QRScann.this.context.appAlerts.dismiss();
                QRScann.this.dialog.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    QRScann.this.context.appAlerts.showErrorAndLogout(QRScann.this.context, str);
                } else {
                    QRScann.this.context.appAlerts.showErrorDialog(QRScann.this.context, str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            QRScann.AnonymousClass2.this.lambda$onFailure$2$QRScann$2();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$2$QRScann$2() {
                QRScann.this.context.appAlerts.dismiss();
                QRScann.this.dialog.dismiss();
            }
        }, str, this.context.getBaseContext());
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        this.dialog = bottomSheetDialog;
        bottomSheetDialog.setOnShowListener($$Lambda$QRScann$FVV5UxqJCW_LsiglrpvBy2au5tc.INSTANCE);
        return this.dialog;
    }

    public void onResume() {
        super.onResume();
        this.mCodeScanner.startPreview();
    }

    public void onPause() {
        this.mCodeScanner.releaseResources();
        super.onPause();
    }
}
