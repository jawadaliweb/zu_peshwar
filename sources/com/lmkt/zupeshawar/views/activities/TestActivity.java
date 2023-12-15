package com.lmkt.zupeshawar.views.activities;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;

public class TestActivity extends AppCompatActivity {
    AppAlertDialog appAlertDialog;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_test);
    }
}
