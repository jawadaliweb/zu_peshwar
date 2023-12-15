package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.Constants;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.model.MemberShips;
import com.lmkt.zupeshawar.model.PackageDetail;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;
import com.lmkt.zupeshawar.views.activities.ZuWalletActivity;
import com.lmkt.zupeshawar.views.adapters.Subscription;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.Membership;
import java.util.Objects;

public class Membership extends Fragment implements View.OnClickListener, IOnBackPressed {
    static int Title = 2131886221;
    Button Btn_zuWallet;
    RelativeLayout activeSubscription;
    BicycleMenuItem activity;
    MaterialButton cancel_action;
    TextView duration_TV;
    TextView memberShipValidityTv;
    PackageDetail packageDetail;
    TextView priceTv;
    Subscription subscriptionAdapter;
    RecyclerView subscriptions;

    public interface onItemClickListener {
        void setMemberShips(MemberShips memberShips);
    }

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_bicycle_membership, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void getActivationPackage() {
        APIManager.getInstance().getUserMemberShip(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                if (i == ReturnCodes.Companion.OK()) {
                    Membership.this.packageDetail = new PackageDetail();
                    Membership.this.packageDetail = apiResponse.getData().getPackageDetail();
                    if (Membership.this.packageDetail != null) {
                        Membership.this.subscriptions.setVisibility(8);
                        Membership.this.activeSubscription.setVisibility(0);
                        Membership.this.duration_TV.setText(Membership.this.packageDetail.membershipTypeString);
                        TextView textView = Membership.this.priceTv;
                        textView.setText("Rs ." + Membership.this.packageDetail.amountCharged);
                        TextView textView2 = Membership.this.memberShipValidityTv;
                        textView2.setText("Membership valid till " + Membership.this.packageDetail.activationDate + " to " + Membership.this.packageDetail.expirationDate);
                    }
                } else if (i == ReturnCodes.Companion.NOT_FOUND()) {
                    Membership.this.packageDetail = null;
                    Membership.this.subscriptions.setVisibility(0);
                    Membership.this.activeSubscription.setVisibility(8);
                    Membership.this.getPackagesList();
                }
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.activity, str);
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.activity, str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass1.this.lambda$onFailure$0$Membership$1();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$0$Membership$1() {
                Membership.this.activity.appAlerts.dismiss();
            }
        }, getContext());
    }

    public void showAlertDialog(int i, int i2, Context context, String str, String str2, boolean z) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_logout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.headertext)).setText(str2);
        ((TextView) inflate.findViewById(R.id.msg)).setText(str);
        Dialog dialog = new Dialog(context, R.style.dialogTheme);
        dialog.setContentView(inflate);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        ((MaterialButton) inflate.findViewById(R.id.Btn_Yes)).setOnClickListener(new View.OnClickListener(dialog, z, i) {
            public final /* synthetic */ Dialog f$1;
            public final /* synthetic */ boolean f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(View view) {
                Membership.this.lambda$showAlertDialog$0$Membership(this.f$1, this.f$2, this.f$3, view);
            }
        });
        ((MaterialButton) inflate.findViewById(R.id.Btn_No)).setOnClickListener(new View.OnClickListener(dialog) {
            public final /* synthetic */ Dialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$showAlertDialog$0$Membership(Dialog dialog, boolean z, int i, View view) {
        dialog.dismiss();
        this.activity.appAlerts.dismiss();
        if (z) {
            cancelSubscriptionAPICall(i);
        } else {
            activateAPICall(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void getStaticContent() {
        APIManager.getInstance().getHTMLStaticContent(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                if (i == ReturnCodes.Companion.OK()) {
                    Membership.this.activity.appAlerts.showHtml(Membership.this.requireContext(), Html.fromHtml(apiResponse.getData().getData()).toString(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass2.this.lambda$onSuccess$0$Membership$2();
                        }
                    });
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.activity, apiResponse.getRespMessage());
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass2.this.lambda$onSuccess$1$Membership$2();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$Membership$2() {
                Membership.this.activity.appAlerts.dismiss();
            }

            public /* synthetic */ void lambda$onSuccess$1$Membership$2() {
                Membership.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.activity, str);
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.activity, str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass2.this.lambda$onFailure$2$Membership$2();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$2$Membership$2() {
                Membership.this.activity.appAlerts.dismiss();
            }
        }, Constants.BSS_ACTIVATION, getContext());
    }

    /* access modifiers changed from: package-private */
    public void cancelSubscriptionAPICall(int i) {
        this.activity.appAlerts.showPleaseWait(getContext());
        APIManager.getInstance().cancelUserMemberShip(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                Membership.this.activity.appAlerts.dismiss();
                if (i == ReturnCodes.Companion.OK()) {
                    Membership.this.activity.appAlerts.showSuccessDialog(Membership.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass3.this.lambda$onSuccess$0$Membership$3();
                        }
                    });
                    Membership.this.subscriptions.setVisibility(0);
                    Membership.this.activeSubscription.setVisibility(8);
                    Membership.this.getPackagesList();
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.activity.getParent(), apiResponse.getRespMessage());
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass3.this.lambda$onSuccess$1$Membership$3();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$Membership$3() {
                Membership.this.activity.appAlerts.dismiss();
            }

            public /* synthetic */ void lambda$onSuccess$1$Membership$3() {
                Membership.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.getActivity(), str);
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.requireContext(), str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass3.this.lambda$onFailure$2$Membership$3();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$2$Membership$3() {
                Membership.this.activity.appAlerts.dismiss();
            }
        }, getContext());
    }

    /* access modifiers changed from: package-private */
    public void activateAPICall(int i) {
        this.activity.appAlerts.showPleaseWait(getContext());
        APIManager.getInstance().activateMemberShip(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                Membership.this.activity.appAlerts.dismiss();
                if (i == ReturnCodes.Companion.OK()) {
                    if (apiResponse.getData().getMemberShipVerifiedStatus()) {
                        Membership.this.activity.appAlerts.showSuccessDialog(Membership.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                            public final void onClicked() {
                                Membership.AnonymousClass4.this.lambda$onSuccess$0$Membership$4();
                            }
                        });
                        Membership.this.getActivationPackage();
                    } else if (!apiResponse.getData().getMemberShipVerifiedStatus()) {
                        Membership.this.getStaticContent();
                    }
                } else if (i == ReturnCodes.Companion.BAD_REQUEST()) {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass4.this.lambda$onSuccess$1$Membership$4();
                        }
                    });
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.activity.getParent(), apiResponse.getRespMessage());
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass4.this.lambda$onSuccess$2$Membership$4();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$Membership$4() {
                Membership.this.activity.appAlerts.dismiss();
            }

            public /* synthetic */ void lambda$onSuccess$1$Membership$4() {
                Membership.this.activity.appAlerts.dismiss();
            }

            public /* synthetic */ void lambda$onSuccess$2$Membership$4() {
                Membership.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.getActivity(), str);
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.requireContext(), str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass4.this.lambda$onFailure$3$Membership$4();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$3$Membership$4() {
                Membership.this.activity.appAlerts.dismiss();
            }
        }, i, getContext());
    }

    /* access modifiers changed from: package-private */
    public void activatePackage(int i, int i2) {
        if (Integer.parseInt(SharedPrefrencesUtil.getUserObject_Prefrences(requireContext()).getAccountBalance()) > i2) {
            showAlertDialog(i, i2, requireContext(), "Are you sure you want to activate this membership", "Alert", false);
            return;
        }
        AppAlertDialog appAlertDialog = this.activity.appAlerts;
        Context context = getContext();
        appAlertDialog.showAlertDialog(context, "You have insufficient balance in your account. Make sure you have more than Rs. " + i2 + " in your wallet.", "Alert", new AppAlertDialog.AlertDialogListener() {
            public void onClicked() {
                Membership.this.activity.appAlerts.dismiss();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void cancelSubscription(int i, int i2) {
        showAlertDialog(i, i2, requireContext(), "Are you sure you want to cancel this membership", "Alert", true);
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.subscriptions = (RecyclerView) view.findViewById(R.id.subscriptions);
        this.Btn_zuWallet = (Button) view.findViewById(R.id.Btn_zuWallet);
        this.activeSubscription = (RelativeLayout) view.findViewById(R.id.alreadySubscription);
        this.duration_TV = (TextView) view.findViewById(R.id.duration_TV);
        this.priceTv = (TextView) view.findViewById(R.id.priceTv);
        this.memberShipValidityTv = (TextView) view.findViewById(R.id.memberShipValidityTv);
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancel_action);
        this.cancel_action = materialButton;
        materialButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Membership.this.lambda$initViews$2$Membership(view);
            }
        });
        this.Btn_zuWallet.setOnClickListener(this);
        getActivationPackage();
    }

    public /* synthetic */ void lambda$initViews$2$Membership(View view) {
        cancelSubscription(Integer.parseInt(this.packageDetail.membershipType), 0);
    }

    /* access modifiers changed from: private */
    public void getPackagesList() {
        this.activity.appAlerts.showPleaseWait(this.activity);
        APIManager.getInstance().getMemberShip(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                if (i == ReturnCodes.Companion.OK()) {
                    Membership.this.activity.appAlerts.dismiss();
                    try {
                        Membership membership = Membership.this;
                        membership.subscriptionAdapter = new Subscription(membership.getContext(), apiResponse.getData().getMemberShips(), new onItemClickListener() {
                            public final void setMemberShips(MemberShips memberShips) {
                                Membership.AnonymousClass6.this.lambda$onSuccess$1$Membership$6(memberShips);
                            }
                        });
                        Membership.this.subscriptions.setLayoutManager(new LinearLayoutManager(Membership.this.getContext()));
                        Membership.this.subscriptions.setAdapter(Membership.this.subscriptionAdapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.activity.getParent(), apiResponse.getRespMessage());
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.requireContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass6.this.lambda$onSuccess$2$Membership$6();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$1$Membership$6(MemberShips memberShips) {
                Log.e("Value", memberShips.toString());
                Membership.this.activity.appAlerts.showMemberShipDialog(Membership.this.requireContext(), memberShips, new AppAlertDialog.AlertDialogListener(memberShips) {
                    public final /* synthetic */ MemberShips f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClicked() {
                        Membership.AnonymousClass6.this.lambda$onSuccess$0$Membership$6(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onSuccess$0$Membership$6(MemberShips memberShips) {
                Membership.this.activity.appAlerts.dismiss();
                Membership.this.activatePackage(memberShips.membershipId, memberShips.cost);
            }

            public /* synthetic */ void lambda$onSuccess$2$Membership$6() {
                Membership.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                    Membership.this.activity.appAlerts.showErrorAndLogout(Membership.this.getActivity(), str);
                } else {
                    Membership.this.activity.appAlerts.showErrorDialog(Membership.this.requireContext(), str, new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            Membership.AnonymousClass6.this.lambda$onFailure$3$Membership$6();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailure$3$Membership$6() {
                Membership.this.activity.appAlerts.dismiss();
            }
        }, getContext());
    }

    private void initToolbar() {
        BicycleMenuItem bicycleMenuItem = (BicycleMenuItem) getActivity();
        this.activity = bicycleMenuItem;
        bicycleMenuItem.mToolbar_Title.setText(Title);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        } else if (id == R.id.Btn_zuWallet) {
            startActivity(new Intent(this.activity, ZuWalletActivity.class));
            this.activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
        }
    }
}
