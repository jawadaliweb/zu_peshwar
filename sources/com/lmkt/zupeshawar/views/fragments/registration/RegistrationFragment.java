package com.lmkt.zupeshawar.views.fragments.registration;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.HandyUtils;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.model.dataModels._Models;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.BaseActivity;
import com.lmkt.zupeshawar.views.activities.MainDashboard;
import com.lmkt.zupeshawar.views.activities.RegistrationActivity;
import com.lmkt.zupeshawar.views.adapters.CustomSpinnerAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONObject;

public class RegistrationFragment extends Fragment implements View.OnClickListener, APIManager.Callback, IOnBackPressed {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    String TAG = "Registration Activity";
    MaskedEditText cnicET;
    DatePickerDialog.OnDateSetListener dobPicker;
    TextView dobTv;
    EditText emailAddressET;
    String[] gender = {"Gender (optinal)", "Male", "Female", "Other"};
    Spinner genderSpinner;
    TextView hintCnicTV;
    private String mobileNumber;
    Calendar myCalendar = Calendar.getInstance();
    EditText nameET;
    RegistrationActivity parentActivity;
    Button proceedBtn;
    View rootView;
    private User user;
    private int userStatus = -1;

    public boolean onBackPressed() {
        return false;
    }

    public static boolean isValidEmail(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.registration_fragment, viewGroup, false);
        this.rootView = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initViews(this.rootView);
        setListeners();
    }

    public void initViews(View view) {
        RegistrationActivity registrationActivity = (RegistrationActivity) getActivity();
        this.parentActivity = registrationActivity;
        registrationActivity.hideToolBar();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mobileNumber = arguments.getString("Mobilenumber");
            this.userStatus = arguments.getInt("userStatus");
            this.user = (User) arguments.getSerializable("user");
            Log.d(this.TAG, "check user");
        }
        Button button = (Button) view.findViewById(R.id.Btn_Proceed);
        this.proceedBtn = button;
        button.setOnClickListener(this);
        this.genderSpinner = (Spinner) view.findViewById(R.id.SP_Gender);
        this.genderSpinner.setAdapter(new CustomSpinnerAdapter(requireContext(), this.gender));
        this.cnicET = (MaskedEditText) view.findViewById(R.id.ET_CNIC);
        this.emailAddressET = (EditText) view.findViewById(R.id.ET_EmailAddress);
        TextView textView = (TextView) view.findViewById(R.id.TV_DOB);
        this.dobTv = textView;
        textView.setOnClickListener(this);
        this.nameET = (EditText) view.findViewById(R.id.ET_Name);
        this.hintCnicTV = (TextView) view.findViewById(R.id.cnicHint_TV);
        HandyUtils.hideKeyboardFrom(getContext(), this.proceedBtn);
        if (this.userStatus == 1) {
            this.hintCnicTV.setVisibility(8);
            this.nameET.setText(this.user.getName());
            this.dobTv.setText(this.user.getDob());
            this.emailAddressET.setText(this.user.getEmail());
            this.cnicET.setText(this.user.getCnic());
            if (this.user.getGender().equalsIgnoreCase("Male")) {
                this.genderSpinner.setSelection(1);
            } else if (this.user.getGender().equalsIgnoreCase("Female")) {
                this.genderSpinner.setSelection(2);
            } else {
                this.genderSpinner.setSelection(0);
            }
        }
    }

    private Date getCurrentDate() throws Exception {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return simpleDateFormat.parse(simpleDateFormat.format(instance.getTime()));
    }

    public void setListeners() {
        this.dobPicker = new DatePickerDialog.OnDateSetListener() {
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                RegistrationFragment.this.lambda$setListeners$0$RegistrationFragment(datePicker, i, i2, i3);
            }
        };
        this.cnicET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() > 0) {
                    RegistrationFragment.this.hintCnicTV.setVisibility(8);
                } else if (charSequence.length() == 0) {
                    RegistrationFragment.this.hintCnicTV.setVisibility(0);
                }
            }
        });
    }

    public /* synthetic */ void lambda$setListeners$0$RegistrationFragment(DatePicker datePicker, int i, int i2, int i3) {
        try {
            this.myCalendar.set(1, i);
            this.myCalendar.set(2, i2);
            this.myCalendar.set(5, i3);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            if (simpleDateFormat.parse(simpleDateFormat.format(this.myCalendar.getTime())).after(getCurrentDate())) {
                ToastUtil.showToast(ToastUtil.ToastType.warning_icon, "Invalid Date Of Birth");
            } else {
                this.dobTv.setText(simpleDateFormat.format(this.myCalendar.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateForm() throws Exception {
        if (this.nameET.getText().toString().isEmpty()) {
            ToastUtil.showToast(ToastUtil.ToastType.warning, "Please enter your name");
            return false;
        } else if (this.dobTv.getText().toString().isEmpty()) {
            ToastUtil.showToast(ToastUtil.ToastType.warning, "Please enter date of birth");
            return false;
        } else if (!this.emailAddressET.getText().toString().isEmpty() && !isValidEmail(this.emailAddressET.getText().toString())) {
            ToastUtil.showToast(ToastUtil.ToastType.warning, "Please enter valid email address");
            return false;
        } else if (this.cnicET.getRawText().length() != 13) {
            ToastUtil.showToast(ToastUtil.ToastType.warning, "Please enter valid CNIC");
            return false;
        } else if (this.genderSpinner.getSelectedItemPosition() == 0) {
            ToastUtil.showToast(ToastUtil.ToastType.warning, "Please select gender");
            return false;
        } else {
            if (this.user == null) {
                this.user = new User();
            }
            this.user.setName(this.nameET.getText().toString().toUpperCase());
            this.user.setDob(this.dobTv.getText().toString());
            this.user.setCnic(this.cnicET.getText().toString());
            this.user.setMobileNumber(this.mobileNumber);
            this.user.setEmail(this.emailAddressET.getText().toString());
            this.user.setGender(this.genderSpinner.getSelectedItem().toString());
            this.user.setDeviceType(_Models.DEVICE_TYPE);
            this.user.setFcmToken(BaseActivity.FCM_TOKEN);
            this.user.setImei(HandyUtils.getMacAddress(getContext()));
            return true;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Proceed) {
            try {
                if (validateForm()) {
                    this.parentActivity.showDialog();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", this.user.getName()).put("mobileNumber", this.user.getMobileNumber()).put("imei", this.user.getImei()).put("gender", this.user.getGender()).put("fcmToken", this.user.getFcmToken()).put("email", this.user.getEmail()).put("dob", this.user.getDob()).put("deviceType", this.user.getDeviceType()).put("cnic", this.user.getCnic());
                    APIManager.getInstance().registerUser(this, (JsonObject) new JsonParser().parse(jSONObject.toString()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.parentActivity.showErrorDialog(e.getLocalizedMessage());
            }
        } else if (id == R.id.TV_DOB) {
            DatePickerDialog datePickerDialog = null;
            if (this.dobTv.getText().equals("")) {
                datePickerDialog = new DatePickerDialog(requireContext(), this.dobPicker, this.myCalendar.get(1), this.myCalendar.get(2), this.myCalendar.get(5));
            } else {
                try {
                    this.myCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(this.dobTv.getText().toString()));
                    datePickerDialog = new DatePickerDialog(requireContext(), this.dobPicker, this.myCalendar.get(1), this.myCalendar.get(2), this.myCalendar.get(5));
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void startMainDashboardActivity() {
        Intent intent = new Intent(getContext(), MainDashboard.class);
        intent.addFlags(335544320);
        startActivity(intent);
        this.parentActivity.popFragments();
        this.parentActivity.finish();
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        this.parentActivity.hideDialog();
        if (i == ReturnCodes.Companion.OK()) {
            User userDetails = apiResponse.getData().getUserDetails();
            if (userDetails != null) {
                userDetails.setTokenDetails(apiResponse.getData().getTokenDetails());
                String imei = userDetails.getTokenDetails().getPayload().getImei();
                Objects.requireNonNull(imei);
                userDetails.setImei(imei);
                userDetails.setLogged_In(true);
                SharedPrefrencesUtil.saveUserObject_Prefrences(userDetails, requireContext());
                startMainDashboardActivity();
                return;
            }
            return;
        }
        this.parentActivity.showErrorDialog(apiResponse.getRespMessage());
    }

    public void onFailure(int i, String str) {
        this.parentActivity.showErrorDialog(str);
    }
}
