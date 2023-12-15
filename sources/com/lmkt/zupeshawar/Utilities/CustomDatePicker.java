package com.lmkt.zupeshawar.Utilities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.presenter.CustomDatePickerListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CustomDatePicker implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    AppCompatButton _button;
    /* access modifiers changed from: private */
    public final Context _context;
    private int _day;
    EditText _editText;
    private int _month;
    TextInputEditText _textInputEditText;
    TextView _textView;
    private int _year;
    CustomDatePickerListener customDatePickerListener;
    int datePickerThemeResId = R.style.MyDatePickerDialogTheme;

    public CustomDatePicker(Context context, TextView textView, CustomDatePickerListener customDatePickerListener2) {
        Activity activity = (Activity) context;
        this._textView = textView;
        textView.setOnClickListener(this);
        this._context = context;
        this.customDatePickerListener = customDatePickerListener2;
    }

    public CustomDatePicker(Context context, AppCompatButton appCompatButton, CustomDatePickerListener customDatePickerListener2) {
        Activity activity = (Activity) context;
        this._button = appCompatButton;
        appCompatButton.setOnClickListener(this);
        this._context = context;
        this.customDatePickerListener = customDatePickerListener2;
    }

    public CustomDatePicker(Context context, EditText editText, CustomDatePickerListener customDatePickerListener2) {
        Activity activity = (Activity) context;
        this._editText = editText;
        editText.setOnClickListener(this);
        this._context = context;
        this.customDatePickerListener = customDatePickerListener2;
    }

    public CustomDatePicker(Context context, TextInputEditText textInputEditText, CustomDatePickerListener customDatePickerListener2) {
        Activity activity = (Activity) context;
        this._textInputEditText = textInputEditText;
        textInputEditText.setOnClickListener(this);
        this._context = context;
        this.customDatePickerListener = customDatePickerListener2;
    }

    public static String getCurrentDate() {
        try {
            return new SimpleDateFormat("MM-dd-yyyy").format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this._year = i;
        this._month = i2;
        this._day = i3;
        updateDisplay();
    }

    public void onClick(View view) {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        final DatePickerDialog datePickerDialog = new DatePickerDialog(this._context, this.datePickerThemeResId, this, instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setSpinnersShown(true);
        datePickerDialog.getDatePicker().setCalendarViewShown(false);
        datePickerDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                int color = ContextCompat.getColor(CustomDatePicker.this._context, 17170444);
                int color2 = ContextCompat.getColor(CustomDatePicker.this._context, 17170444);
                datePickerDialog.getButton(-1).setTextColor(color);
                datePickerDialog.getButton(-2).setTextColor(color2);
            }
        });
        TextView textView = this._textView;
        if (textView != null && textView.getText().toString() != null && !this._textView.getText().toString().equals("") && this._textView.getText().toString().contains("/")) {
            String[] split = this._textView.getText().toString().trim().split("/");
            if (split.length == 3) {
                instance.set(Integer.parseInt(split[2]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[0]));
            }
            datePickerDialog = new DatePickerDialog(this._context, this, instance.get(1), instance.get(2), instance.get(5));
        }
        EditText editText = this._editText;
        if (editText != null && editText.getText().toString() != null && !this._editText.getText().toString().equals("") && this._editText.getText().toString().contains("/")) {
            String[] split2 = this._editText.getText().toString().trim().split("/");
            if (split2.length == 3) {
                instance.set(Integer.parseInt(split2[2]), Integer.parseInt(split2[1]) - 1, Integer.parseInt(split2[0]));
            }
            datePickerDialog = new DatePickerDialog(this._context, this, instance.get(1), instance.get(2), instance.get(5));
        }
        TextInputEditText textInputEditText = this._textInputEditText;
        if (textInputEditText != null && textInputEditText.getText().toString() != null && !this._textInputEditText.getText().toString().equals("") && this._textInputEditText.getText().toString().contains("/")) {
            String[] split3 = this._textInputEditText.getText().toString().trim().split("/");
            if (split3.length == 3) {
                instance.set(Integer.parseInt(split3[2]), Integer.parseInt(split3[1]) - 1, Integer.parseInt(split3[0]));
            }
            datePickerDialog = new DatePickerDialog(this._context, this, instance.get(1), instance.get(2), instance.get(5));
        }
        AppCompatButton appCompatButton = this._button;
        if (appCompatButton != null && appCompatButton.getText().toString() != null && !this._button.getText().toString().equals("") && this._button.getText().toString().contains("/")) {
            String[] split4 = this._button.getText().toString().trim().split("/");
            if (split4.length == 3) {
                instance.set(Integer.parseInt(split4[2]), Integer.parseInt(split4[1]) - 1, Integer.parseInt(split4[0]));
            }
            datePickerDialog = new DatePickerDialog(this._context, this, instance.get(1), instance.get(2), instance.get(5));
        }
        datePickerDialog.show();
    }

    private void updateDisplay() {
        Object obj;
        Object obj2;
        int i = this._year;
        int i2 = this._month + 1;
        int i3 = this._day;
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            obj = "0" + i2;
        } else {
            obj = Integer.valueOf(i2);
        }
        sb.append(obj);
        sb.append("-");
        if (i3 < 10) {
            obj2 = "0" + i3;
        } else {
            obj2 = Integer.valueOf(i3);
        }
        sb.append(obj2);
        sb.append("-");
        sb.append(i);
        String sb2 = sb.toString();
        TextView textView = this._textView;
        if (textView != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            textView.setText(sb3);
        }
        EditText editText = this._editText;
        if (editText != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            editText.setText(sb4);
        }
        TextInputEditText textInputEditText = this._textInputEditText;
        if (textInputEditText != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            textInputEditText.setText(sb5);
        }
        AppCompatButton appCompatButton = this._button;
        if (appCompatButton != null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sb2);
            appCompatButton.setText(sb6);
        }
        this.customDatePickerListener.onDateChangeListener(sb2);
    }
}
