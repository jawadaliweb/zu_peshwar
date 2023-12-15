package com.lmkt.zupeshawar.views.fragments.busFragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.HandyUtils;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.application.App;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.TravelHistory;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import com.lmkt.zupeshawar.views.fragments.busFragments.BusTravelHistory;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class BusTravelHistory extends Fragment implements View.OnClickListener, IOnBackPressed, APIManager.Callback {
    private static String TAG = "Travel History Fragment";
    EditText ET_from;
    EditText ET_to;
    private int REQUEST_PERMISSIONS_CODE_WRITE_STORAGE = 10;
    RelativeLayout RL_from;
    RelativeLayout RL_to;
    /* access modifiers changed from: private */
    public MainMenuItemActivity activity;
    /* access modifiers changed from: private */
    public Context context;
    PdfDocument document;
    File file;
    DatePickerDialog.OnDateSetListener from_DatePicker;
    MaterialButton generate_Pdf;
    LinearLayout generate_PdfView;
    Calendar myCalendar = Calendar.getInstance();
    TextView noDataTxt;
    DatePickerDialog.OnDateSetListener to_DatePicker;
    ArrayList<TravelHistory> travelHistories;
    ListView travelHistory_LV;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_tickets_travelhistory, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
            initTravelHistory_List();
            setDateListener();
            HandyUtils.hideKeyboardFrom(this.activity.getApplicationContext(), this.ET_from);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDateListener() {
        this.to_DatePicker = new DatePickerDialog.OnDateSetListener() {
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                BusTravelHistory.this.lambda$setDateListener$0$BusTravelHistory(datePicker, i, i2, i3);
            }
        };
        this.from_DatePicker = new DatePickerDialog.OnDateSetListener() {
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                BusTravelHistory.this.lambda$setDateListener$1$BusTravelHistory(datePicker, i, i2, i3);
            }
        };
    }

    public /* synthetic */ void lambda$setDateListener$0$BusTravelHistory(DatePicker datePicker, int i, int i2, int i3) {
        try {
            this.myCalendar.set(1, i);
            this.myCalendar.set(2, i2);
            this.myCalendar.set(5, i3);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            if (simpleDateFormat.parse(simpleDateFormat.format(this.myCalendar.getTime())).after(getCurrentDate())) {
                ToastUtil.showToast(ToastUtil.ToastType.warning_icon, "Invalid Date Of Birth");
                return;
            }
            this.ET_to.setText(simpleDateFormat.format(this.myCalendar.getTime()));
            String obj = this.ET_to.getText().toString();
            String obj2 = this.ET_from.getText().toString();
            if (!obj2.isEmpty()) {
                this.activity.appAlerts.showPleaseWait(this.activity);
                APIManager.getInstance().getTravelHistory(this, obj2, obj, getContext());
                return;
            }
            ToastUtil.showToast(ToastUtil.ToastType.error, "Please select both dates");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$setDateListener$1$BusTravelHistory(DatePicker datePicker, int i, int i2, int i3) {
        try {
            this.myCalendar.set(1, i);
            this.myCalendar.set(2, i2);
            this.myCalendar.set(5, i3);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            if (simpleDateFormat.parse(simpleDateFormat.format(this.myCalendar.getTime())).after(getCurrentDate())) {
                ToastUtil.showToast(ToastUtil.ToastType.warning_icon, "Invalid Date Of Birth");
                return;
            }
            this.ET_from.setText(simpleDateFormat.format(this.myCalendar.getTime()));
            String obj = this.ET_to.getText().toString();
            String obj2 = this.ET_from.getText().toString();
            if (!obj.isEmpty()) {
                this.activity.appAlerts.showPleaseWait(this.activity);
                APIManager.getInstance().getTravelHistory(this, obj2, obj, getContext());
                return;
            }
            ToastUtil.showToast(ToastUtil.ToastType.error, "Please select both dates");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ArrHistoryData {
        public String checkinStation;
        public String checkintime;
        public String checkoutStation;
        public String checkouttime;
        public String date;
        public String duration;
        public int fare;

        ArrHistoryData() {
        }
    }

    public String formateDate(String str) throws ParseException {
        return new SimpleDateFormat("MMMM dd, yyyy").format(new SimpleDateFormat("yyyy-mm-dd").parse(str));
    }

    public void downloadPDF() {
        if (this.travelHistories != null) {
            JsonParser jsonParser = new JsonParser();
            JSONObject jSONObject = new JSONObject();
            try {
                User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(App.getInstance().getApplicationContext());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject2.accumulate("name", userObject_Prefrences.getName());
                jSONObject2.put("cnic", userObject_Prefrences.getCnic());
                jSONObject2.put("mobileNo", userObject_Prefrences.getMobileNumber());
                jSONObject2.put("dob", formateDate(userObject_Prefrences.getDob()));
                JSONArray jSONArray = new JSONArray();
                Iterator<TravelHistory> it = this.travelHistories.iterator();
                while (it.hasNext()) {
                    TravelHistory next = it.next();
                    JSONObject jSONObject4 = new JSONObject();
                    new ArrHistoryData();
                    jSONObject4.accumulate("checkinStation", next.getCheckinStation());
                    jSONObject4.accumulate("checkintime", next.getCheckintime());
                    jSONObject4.accumulate("checkoutStation", next.getCheckoutStation());
                    jSONObject4.accumulate("checkouttime", next.getCheckouttime());
                    jSONObject4.accumulate("date", next.getDate());
                    jSONObject4.accumulate(TypedValues.Transition.S_DURATION, next.getDuration());
                    String fare = next.getFare();
                    Objects.requireNonNull(fare);
                    jSONObject4.accumulate("fare", fare);
                    jSONArray.put(jSONObject4);
                }
                String obj = this.ET_to.getText().toString();
                String obj2 = this.ET_from.getText().toString();
                if (!obj.isEmpty()) {
                    if (!obj2.isEmpty()) {
                        jSONObject3.put(FirebaseAnalytics.Param.START_DATE, formateDate(obj2));
                        jSONObject3.put("start_end", formateDate(obj));
                        jSONObject.put("user", jSONObject2);
                        jSONObject.put(FirebaseAnalytics.Event.SEARCH, jSONObject3);
                        jSONObject.put(CommonProperties.TYPE, "Bus Transaction History");
                        jSONObject.put("arrHistoryData", jSONArray);
                        this.activity.appAlerts.showPleaseWait(getContext());
                        APIManager.getInstance().downloadTransactionPDF(new APIManager.StreamResp() {
                            public void onSuccess(int i, InputStream inputStream) {
                                try {
                                    String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                                    new DownloadFile(inputStream, format + ".pdf").execute(new Void[0]);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            public void onFailure(int i, String str) {
                                BusTravelHistory.this.activity.appAlerts.dismiss();
                                BusTravelHistory.this.activity.appAlerts.showAlertDialog(BusTravelHistory.this.activity, str, "Alert", new AppAlertDialog.AlertDialogListener() {
                                    public final void onClicked() {
                                        BusTravelHistory.AnonymousClass1.this.lambda$onFailure$0$BusTravelHistory$1();
                                    }
                                });
                            }

                            public /* synthetic */ void lambda$onFailure$0$BusTravelHistory$1() {
                                BusTravelHistory.this.activity.appAlerts.dismiss();
                            }
                        }, (JsonObject) jsonParser.parse(jSONObject.toString()), getContext());
                    }
                }
                jSONObject3.put(FirebaseAnalytics.Param.START_DATE, "N/A");
                jSONObject3.put("start_end", "N/A");
                jSONObject.put("user", jSONObject2);
                jSONObject.put(FirebaseAnalytics.Event.SEARCH, jSONObject3);
                jSONObject.put(CommonProperties.TYPE, "Bus Transaction History");
                jSONObject.put("arrHistoryData", jSONArray);
                this.activity.appAlerts.showPleaseWait(getContext());
                APIManager.getInstance().downloadTransactionPDF(new APIManager.StreamResp() {
                    public void onSuccess(int i, InputStream inputStream) {
                        try {
                            String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                            new DownloadFile(inputStream, format + ".pdf").execute(new Void[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public void onFailure(int i, String str) {
                        BusTravelHistory.this.activity.appAlerts.dismiss();
                        BusTravelHistory.this.activity.appAlerts.showAlertDialog(BusTravelHistory.this.activity, str, "Alert", new AppAlertDialog.AlertDialogListener() {
                            public final void onClicked() {
                                BusTravelHistory.AnonymousClass1.this.lambda$onFailure$0$BusTravelHistory$1();
                            }
                        });
                    }

                    public /* synthetic */ void lambda$onFailure$0$BusTravelHistory$1() {
                        BusTravelHistory.this.activity.appAlerts.dismiss();
                    }
                }, (JsonObject) jsonParser.parse(jSONObject.toString()), getContext());
            } catch (Exception e) {
                e.printStackTrace();
                this.activity.appAlerts.dismiss();
                this.activity.appAlerts.showAlertDialog(this.activity, e.getMessage(), "Alert", new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        BusTravelHistory.this.lambda$downloadPDF$2$BusTravelHistory();
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$downloadPDF$2$BusTravelHistory() {
        this.activity.appAlerts.dismiss();
    }

    class DownloadFile extends AsyncTask<Void, Void, String> {
        File documentPath;
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
                openFileOutput = BusTravelHistory.this.context.openFileOutput(this.filePath, 0);
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
            BusTravelHistory.this.activity.appAlerts.showSuccessDialog(BusTravelHistory.this.activity, "Pdf is generated Successfully.\n", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    BusTravelHistory.DownloadFile.this.lambda$onPostExecute$0$BusTravelHistory$DownloadFile();
                }
            });
        }

        public /* synthetic */ void lambda$onPostExecute$0$BusTravelHistory$DownloadFile() {
            BusTravelHistory.this.openFile(new File(BusTravelHistory.this.context.getFilesDir(), this.filePath));
            BusTravelHistory.this.activity.appAlerts.dismiss();
        }
    }

    private Date getCurrentDate() throws Exception {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return simpleDateFormat.parse(simpleDateFormat.format(instance.getTime()));
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.travelHistory_LV = (ListView) view.findViewById(R.id.travelHistory_LV);
        this.generate_PdfView = (LinearLayout) view.findViewById(R.id.generate_PdfView);
        this.generate_Pdf = (MaterialButton) view.findViewById(R.id.generate_Pdf);
        this.noDataTxt = (TextView) view.findViewById(R.id.noDataTxt);
        this.travelHistory_LV.setVisibility(8);
        this.RL_from = (RelativeLayout) view.findViewById(R.id.RL_from);
        this.RL_to = (RelativeLayout) view.findViewById(R.id.RL_to);
        this.ET_to = (EditText) view.findViewById(R.id.ET_to);
        this.ET_from = (EditText) view.findViewById(R.id.ET_from);
        this.ET_to.setOnClickListener(this);
        this.ET_from.setOnClickListener(this);
        this.generate_Pdf.setOnClickListener(this);
    }

    private void initToolbar() {
        MainMenuItemActivity mainMenuItemActivity = (MainMenuItemActivity) getActivity();
        this.activity = mainMenuItemActivity;
        this.context = mainMenuItemActivity.getBaseContext();
        this.activity.mToolbar_Title.setText(R.string.title_travelhistory);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    private void initTravelHistory_List() {
        this.ET_to.getText().toString();
        this.ET_from.getText().toString();
        this.activity.appAlerts.showPleaseWait(this.activity);
        APIManager.getInstance().getTravelHistory(this, "", "", getContext());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Btn_Back:
                this.activity.finish();
                this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
                return;
            case R.id.ET_from:
                try {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(this.activity, this.from_DatePicker, this.myCalendar.get(1), this.myCalendar.get(2), this.myCalendar.get(5));
                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                    datePickerDialog.show();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ET_to:
                try {
                    DatePickerDialog datePickerDialog2 = new DatePickerDialog(this.activity, this.to_DatePicker, this.myCalendar.get(1), this.myCalendar.get(2), this.myCalendar.get(5));
                    datePickerDialog2.getDatePicker().setMaxDate(System.currentTimeMillis());
                    datePickerDialog2.show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.generate_Pdf:
                try {
                    downloadPDF();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            default:
                return;
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
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.REQUEST_PERMISSIONS_CODE_WRITE_STORAGE);
        return false;
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.OK()) {
            if (apiResponse.getData() == null) {
                this.noDataTxt.setVisibility(0);
                return;
            }
            this.travelHistories = apiResponse.getData().getTravelHistories();
            this.travelHistory_LV.setAdapter(new ListAdapter(this.activity, this.travelHistories));
            this.activity.runOnUiThread(new Runnable() {
                public final void run() {
                    BusTravelHistory.this.lambda$onSuccess$3$BusTravelHistory();
                }
            });
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, apiResponse.getRespMessage());
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    BusTravelHistory.this.lambda$onSuccess$4$BusTravelHistory();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSuccess$3$BusTravelHistory() {
        this.noDataTxt.setVisibility(8);
        if (this.travelHistories.size() != 0) {
            this.travelHistory_LV.setVisibility(0);
        } else {
            this.noDataTxt.setVisibility(0);
        }
    }

    public /* synthetic */ void lambda$onSuccess$4$BusTravelHistory() {
        this.activity.appAlerts.dismiss();
    }

    public void onFailure(int i, String str) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, str);
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    BusTravelHistory.this.lambda$onFailure$5$BusTravelHistory();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onFailure$5$BusTravelHistory() {
        this.activity.appAlerts.dismiss();
    }

    public class ListAdapter extends ArrayAdapter {
        LayoutInflater inflater;

        public ListAdapter(Context context, ArrayList arrayList) {
            super(context, 0, arrayList);
            this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            TravelHistory travelHistory = (TravelHistory) getItem(i);
            View inflate = this.inflater.inflate(R.layout.row_item_travel_history, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.date_TV);
            TextView textView2 = (TextView) inflate.findViewById(R.id.fare_TV);
            TextView textView3 = (TextView) inflate.findViewById(R.id.checkIn_Tv);
            TextView textView4 = (TextView) inflate.findViewById(R.id.checkOut_Tv);
            TextView textView5 = (TextView) inflate.findViewById(R.id.Duration_TV);
            TextView textView6 = (TextView) inflate.findViewById(R.id.checkInOut);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm aa");
            ((TextView) inflate.findViewById(R.id.checkinStation_TV)).setText(travelHistory.getCheckinStation());
            ((TextView) inflate.findViewById(R.id.checkoutStation_TV)).setText(travelHistory.getCheckoutStation());
            try {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm aa");
                String checkintime = travelHistory.getCheckintime();
                Objects.requireNonNull(checkintime);
                Date parse = simpleDateFormat.parse(checkintime);
                String checkouttime = travelHistory.getCheckouttime();
                Objects.requireNonNull(checkouttime);
                Date parse2 = simpleDateFormat.parse(checkouttime);
                textView3.setText(simpleDateFormat2.format(parse));
                textView4.setText(simpleDateFormat2.format(parse2));
                textView.setText(travelHistory.getDate() + " (" + simpleDateFormat2.format(parse) + " - " + simpleDateFormat2.format(parse2) + ")");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (travelHistory.getDuration().equalsIgnoreCase("na")) {
                textView5.setText("N/A");
            } else {
                textView5.setText(travelHistory.getDuration());
            }
            textView2.setText(travelHistory.getFare());
            return inflate;
        }
    }
}
