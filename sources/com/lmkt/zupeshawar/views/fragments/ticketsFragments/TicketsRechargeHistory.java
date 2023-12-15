package com.lmkt.zupeshawar.views.fragments.ticketsFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.Helper;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.application.App;
import com.lmkt.zupeshawar.model.RechargeHistory;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.TicketsMenuItemActivity;
import com.lmkt.zupeshawar.views.fragments.ticketsFragments.TicketsRechargeHistory;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class TicketsRechargeHistory extends Fragment implements View.OnClickListener, IOnBackPressed, APIManager.Callback {
    private static String TAG = "Recharge History";
    private int REQUEST_PERMISSIONS_CODE_WRITE_STORAGE = 10;
    TicketsMenuItemActivity activity;
    Context context;
    File file;
    MaterialButton generate_Pdf;
    TextView noDataTxt;
    ArrayList<RechargeHistory> rechargeHistory;
    ListView rechargeHistory_LV;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_tickets_rechargehistory, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
            init_RechargeHistory_List();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init_RechargeHistory_List() {
        this.activity.appAlerts.showPleaseWait(this.activity);
        APIManager.getInstance().getRechargeHistory(this, getContext());
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.rechargeHistory_LV = (ListView) view.findViewById(R.id.listview);
        this.noDataTxt = (TextView) view.findViewById(R.id.noDataTxt);
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.generate_Pdf);
        this.generate_Pdf = materialButton;
        materialButton.setOnClickListener(this);
    }

    private void initToolbar() {
        TicketsMenuItemActivity ticketsMenuItemActivity = (TicketsMenuItemActivity) getActivity();
        this.activity = ticketsMenuItemActivity;
        this.context = ticketsMenuItemActivity.getBaseContext();
        this.activity.mToolbar_Title.setText(R.string.title_rechargehistory);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        } else if (id == R.id.generate_Pdf) {
            try {
                downloadPDF();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String formateDate(String str) throws ParseException {
        return new SimpleDateFormat("MMMM dd, yyyy").format(new SimpleDateFormat("yyyy-mm-dd").parse(str));
    }

    class ArrHistoryData {
        public String mobileAccount;
        public String source;
        public String transactionDate;
        public String userID;

        ArrHistoryData() {
        }
    }

    public File generatePDF() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file2 = new File(absolutePath + "/ZuPeshawar");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public void downloadPDF() {
        if (this.rechargeHistory != null) {
            JsonParser jsonParser = new JsonParser();
            JSONObject jSONObject = new JSONObject();
            try {
                User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(App.getInstance().getApplicationContext());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject2.accumulate("name", userObject_Prefrences.getName());
                jSONObject2.put("cnic", userObject_Prefrences.getCnic());
                jSONObject2.put("mobileNo", userObject_Prefrences.getMobileNumber());
                jSONObject2.put("dob", "2014-07-10");
                JSONArray jSONArray = new JSONArray();
                Iterator<RechargeHistory> it = this.rechargeHistory.iterator();
                while (it.hasNext()) {
                    RechargeHistory next = it.next();
                    JSONObject jSONObject4 = new JSONObject();
                    new ArrHistoryData();
                    jSONObject4.accumulate("amount", next.getAmount());
                    jSONObject4.accumulate("source", "4");
                    jSONObject4.accumulate("mobileAccount", next.getMobileAccount());
                    jSONObject4.accumulate("transactionDate", next.getTransactionDate());
                    jSONObject4.accumulate("userID", "d421f6f8-6171-4905-8300-0080eccb081f");
                    jSONArray.put(jSONObject4);
                }
                jSONObject3.put(FirebaseAnalytics.Param.START_DATE, "N/A");
                jSONObject3.put("start_end", "N/A");
                jSONObject.put("user", jSONObject2);
                jSONObject.put(FirebaseAnalytics.Event.SEARCH, jSONObject3);
                jSONObject.put(CommonProperties.TYPE, "Recharge History");
                jSONObject.put("arrHistoryData", jSONArray);
                this.activity.appAlerts.showPleaseWait(getContext());
                APIManager.getInstance().downloadRechargePDF(new APIManager.StreamResp() {
                    public void onSuccess(int i, InputStream inputStream) {
                        TicketsRechargeHistory ticketsRechargeHistory = TicketsRechargeHistory.this;
                        ticketsRechargeHistory.file = ticketsRechargeHistory.generatePDF();
                        try {
                            String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                            new DownloadFile(inputStream, format + ".pdf").execute(new Void[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public void onFailure(int i, String str) {
                        TicketsRechargeHistory.this.activity.appAlerts.dismiss();
                        TicketsRechargeHistory.this.activity.appAlerts.showAlertDialog(TicketsRechargeHistory.this.activity, str, "Alert", new AppAlertDialog.AlertDialogListener() {
                            public final void onClicked() {
                                TicketsRechargeHistory.AnonymousClass1.this.lambda$onFailure$0$TicketsRechargeHistory$1();
                            }
                        });
                    }

                    public /* synthetic */ void lambda$onFailure$0$TicketsRechargeHistory$1() {
                        TicketsRechargeHistory.this.activity.appAlerts.dismiss();
                    }
                }, (JsonObject) jsonParser.parse(jSONObject.toString()), getContext());
            } catch (Exception e) {
                e.printStackTrace();
                this.activity.appAlerts.dismiss();
                this.activity.appAlerts.showAlertDialog(this.activity, e.getMessage(), "Alert", new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        TicketsRechargeHistory.this.lambda$downloadPDF$0$TicketsRechargeHistory();
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$downloadPDF$0$TicketsRechargeHistory() {
        this.activity.appAlerts.dismiss();
    }

    class DownloadFile extends AsyncTask<Void, Void, String> {
        String filePath;
        InputStream stream;

        DownloadFile(InputStream inputStream, String str) {
            this.stream = inputStream;
            this.filePath = str;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(Void... voidArr) {
            FileOutputStream openFileOutput;
            try {
                openFileOutput = TicketsRechargeHistory.this.context.openFileOutput(this.filePath, 0);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = this.stream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    openFileOutput.write(bArr, 0, read);
                }
                openFileOutput.flush();
                if (openFileOutput == null) {
                    return "Executed";
                }
                openFileOutput.close();
                return "Executed";
            } catch (Exception e) {
                e.printStackTrace();
                return "Executed";
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            TicketsRechargeHistory.this.activity.appAlerts.showSuccessDialog(TicketsRechargeHistory.this.activity, "Pdf is generated Successfully.\n", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    TicketsRechargeHistory.DownloadFile.this.lambda$onPostExecute$0$TicketsRechargeHistory$DownloadFile();
                }
            });
        }

        public /* synthetic */ void lambda$onPostExecute$0$TicketsRechargeHistory$DownloadFile() {
            TicketsRechargeHistory.this.openFile(new File(TicketsRechargeHistory.this.context.getFilesDir(), this.filePath));
            TicketsRechargeHistory.this.activity.appAlerts.dismiss();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == this.REQUEST_PERMISSIONS_CODE_WRITE_STORAGE && strArr[0].equals("android.permission.WRITE_EXTERNAL_STORAGE") && iArr[0] == 0) {
            try {
                downloadPDF();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void openFile(File file2) {
        Context context2 = this.context;
        Uri uriForFile = FileProvider.getUriForFile(context2, this.context.getApplicationContext().getPackageName() + ".provider", file2);
        Intent intent = new Intent("android.intent.action.VIEW");
        if (file2.toString().contains(".doc") || file2.toString().contains(".docx")) {
            intent.setDataAndType(uriForFile, "application/msword");
        } else if (file2.toString().contains(".pdf")) {
            intent.setDataAndType(uriForFile, "application/pdf");
        } else if (file2.toString().contains(".ppt") || file2.toString().contains(".pptx")) {
            intent.setDataAndType(uriForFile, "application/vnd.ms-powerpoint");
        }
        intent.addFlags(268435456);
        intent.addFlags(1);
        this.context.startActivity(intent);
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.OK()) {
            if (apiResponse.getData() != null) {
                this.rechargeHistory = apiResponse.getData().getRechargeHistoryList();
                this.rechargeHistory_LV.setAdapter(new ListAdapter(this.activity, new Helper().get_TransactionHistory(this.rechargeHistory)));
                this.activity.runOnUiThread(new Runnable() {
                    public final void run() {
                        TicketsRechargeHistory.this.lambda$onSuccess$1$TicketsRechargeHistory();
                    }
                });
                return;
            }
            this.activity.runOnUiThread(new Runnable(apiResponse) {
                public final /* synthetic */ ApiResponse f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    TicketsRechargeHistory.this.lambda$onSuccess$2$TicketsRechargeHistory(this.f$1);
                }
            });
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, apiResponse.getRespMessage());
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    TicketsRechargeHistory.this.lambda$onSuccess$3$TicketsRechargeHistory();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSuccess$1$TicketsRechargeHistory() {
        this.noDataTxt.setVisibility(8);
        this.rechargeHistory_LV.setVisibility(0);
    }

    public /* synthetic */ void lambda$onSuccess$2$TicketsRechargeHistory(ApiResponse apiResponse) {
        this.noDataTxt.setVisibility(0);
        this.rechargeHistory_LV.setVisibility(8);
        this.noDataTxt.setText(apiResponse.getRespMessage());
    }

    public /* synthetic */ void lambda$onSuccess$3$TicketsRechargeHistory() {
        this.activity.appAlerts.dismiss();
    }

    public void onFailure(int i, String str) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, str);
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    TicketsRechargeHistory.this.lambda$onFailure$4$TicketsRechargeHistory();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onFailure$4$TicketsRechargeHistory() {
        this.activity.appAlerts.dismiss();
        this.activity.onBackPressed();
    }

    public class ListAdapter extends ArrayAdapter {
        LayoutInflater inflater;

        public ListAdapter(Context context, ArrayList arrayList) {
            super(context, 0, arrayList);
            this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e6, code lost:
            if (r6.equals("1") == false) goto L_0x00bd;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
            /*
                r5 = this;
                java.lang.Object r6 = r5.getItem(r6)
                com.lmkt.zupeshawar.model.RechargeHistory r6 = (com.lmkt.zupeshawar.model.RechargeHistory) r6
                java.lang.Boolean r7 = r6.isSectionHeader()
                boolean r7 = r7.booleanValue()
                r8 = 0
                r0 = 0
                if (r7 == 0) goto L_0x005e
                android.view.LayoutInflater r7 = r5.inflater
                r1 = 2131558625(0x7f0d00e1, float:1.8742571E38)
                android.view.View r7 = r7.inflate(r1, r0)
                r7.setClickable(r8)
                r8 = 2131362493(0x7f0a02bd, float:1.8344768E38)
                android.view.View r8 = r7.findViewById(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                java.lang.String r6 = r6.getTransactionDate()
                java.lang.String r0 = "yyyy-MM-dd"
                java.lang.String r1 = "d MMM yyyy"
                java.lang.String r6 = r5.formattedDateFromString(r0, r1, r6)
                java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
                r0.<init>(r1)
                java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x0052 }
                long r0 = r0.getTime()     // Catch:{ ParseException -> 0x0052 }
                boolean r0 = android.text.format.DateUtils.isToday(r0)     // Catch:{ ParseException -> 0x0052 }
                if (r0 == 0) goto L_0x004d
                java.lang.String r6 = "Today"
                r8.setText(r6)     // Catch:{ ParseException -> 0x0052 }
                goto L_0x011c
            L_0x004d:
                r8.setText(r6)     // Catch:{ ParseException -> 0x0052 }
                goto L_0x011c
            L_0x0052:
                r6 = move-exception
                java.lang.String r6 = r6.getLocalizedMessage()
                java.lang.String r8 = "Exception"
                android.util.Log.v(r8, r6)
                goto L_0x011c
            L_0x005e:
                android.view.LayoutInflater r7 = r5.inflater
                r1 = 2131558620(0x7f0d00dc, float:1.874256E38)
                android.view.View r7 = r7.inflate(r1, r0)
                r0 = 2131362439(0x7f0a0287, float:1.8344659E38)
                android.view.View r0 = r7.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r1 = 2131362441(0x7f0a0289, float:1.8344663E38)
                android.view.View r1 = r7.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r2 = 2131362438(0x7f0a0286, float:1.8344657E38)
                android.view.View r2 = r7.findViewById(r2)
                android.widget.TextView r2 = (android.widget.TextView) r2
                r3 = 2131362440(0x7f0a0288, float:1.834466E38)
                android.view.View r3 = r7.findViewById(r3)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                java.lang.String r4 = r6.getTransactionDate()
                java.lang.String r4 = r5.getTransactionTime(r4)
                r1.setText(r4)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "Rs. "
                r1.append(r4)
                java.lang.String r4 = r6.getAmount()
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r2.setText(r1)
                java.lang.String r6 = r6.getSource()
                r6.hashCode()
                r1 = -1
                int r2 = r6.hashCode()
                switch(r2) {
                    case 49: goto L_0x00e0;
                    case 50: goto L_0x00d5;
                    case 51: goto L_0x00bd;
                    case 52: goto L_0x00ca;
                    case 53: goto L_0x00bd;
                    case 54: goto L_0x00bf;
                    default: goto L_0x00bd;
                }
            L_0x00bd:
                r8 = -1
                goto L_0x00e9
            L_0x00bf:
                java.lang.String r8 = "6"
                boolean r6 = r6.equals(r8)
                if (r6 != 0) goto L_0x00c8
                goto L_0x00bd
            L_0x00c8:
                r8 = 3
                goto L_0x00e9
            L_0x00ca:
                java.lang.String r8 = "4"
                boolean r6 = r6.equals(r8)
                if (r6 != 0) goto L_0x00d3
                goto L_0x00bd
            L_0x00d3:
                r8 = 2
                goto L_0x00e9
            L_0x00d5:
                java.lang.String r8 = "2"
                boolean r6 = r6.equals(r8)
                if (r6 != 0) goto L_0x00de
                goto L_0x00bd
            L_0x00de:
                r8 = 1
                goto L_0x00e9
            L_0x00e0:
                java.lang.String r2 = "1"
                boolean r6 = r6.equals(r2)
                if (r6 != 0) goto L_0x00e9
                goto L_0x00bd
            L_0x00e9:
                switch(r8) {
                    case 0: goto L_0x0111;
                    case 1: goto L_0x0105;
                    case 2: goto L_0x00f9;
                    case 3: goto L_0x00ed;
                    default: goto L_0x00ec;
                }
            L_0x00ec:
                goto L_0x011c
            L_0x00ed:
                java.lang.String r6 = "Ubl Omni"
                r0.setText(r6)
                r6 = 2131230998(0x7f080116, float:1.8078065E38)
                r3.setImageResource(r6)
                goto L_0x011c
            L_0x00f9:
                java.lang.String r6 = "Zu Card"
                r0.setText(r6)
                r6 = 2131231079(0x7f080167, float:1.8078229E38)
                r3.setImageResource(r6)
                goto L_0x011c
            L_0x0105:
                java.lang.String r6 = "Jazz Cash"
                r0.setText(r6)
                r6 = 2131230945(0x7f0800e1, float:1.8077957E38)
                r3.setImageResource(r6)
                goto L_0x011c
            L_0x0111:
                java.lang.String r6 = "Easy Paisa"
                r0.setText(r6)
                r6 = 2131230931(0x7f0800d3, float:1.8077929E38)
                r3.setImageResource(r6)
            L_0x011c:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.views.fragments.ticketsFragments.TicketsRechargeHistory.ListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        private String getTransactionTime(String str) {
            String[] split = str.split(MaskedEditText.SPACE);
            return split[1] + MaskedEditText.SPACE + split[2];
        }

        private String formattedDateFromString(String str, String str2, String str3) {
            if (str.equals("")) {
                str = "yyyy-MM-dd hh:mm:ss";
            }
            if (str2.equals("")) {
                str2 = "EEEE d 'de' MMMM 'del' yyyy";
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            try {
                return new SimpleDateFormat(str2, Locale.getDefault()).format(simpleDateFormat.parse(str3));
            } catch (Exception e) {
                Log.e("formattedDateFromString", "Exception in formateDateFromstring(): " + e.getMessage());
                return "";
            }
        }
    }
}
