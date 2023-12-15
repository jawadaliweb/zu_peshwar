package cat.ereza.customactivityoncrash.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.R;
import cat.ereza.customactivityoncrash.config.CaocConfig;

public final class DefaultErrorActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedArray obtainStyledAttributes = obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            setTheme(R.style.Theme_AppCompat_Light_DarkActionBar);
        }
        obtainStyledAttributes.recycle();
        setContentView(R.layout.customactivityoncrash_default_error_activity);
        Button button = (Button) findViewById(R.id.customactivityoncrash_error_activity_restart_button);
        final CaocConfig configFromIntent = CustomActivityOnCrash.getConfigFromIntent(getIntent());
        if (configFromIntent == null) {
            finish();
            return;
        }
        if (!configFromIntent.isShowRestartButton() || configFromIntent.getRestartActivityClass() == null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CustomActivityOnCrash.closeApplication(DefaultErrorActivity.this, configFromIntent);
                }
            });
        } else {
            button.setText(R.string.customactivityoncrash_error_activity_restart_app);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CustomActivityOnCrash.restartApplication(DefaultErrorActivity.this, configFromIntent);
                }
            });
        }
        Button button2 = (Button) findViewById(R.id.customactivityoncrash_error_activity_more_info_button);
        if (configFromIntent.isShowErrorDetails()) {
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AlertDialog.Builder title = new AlertDialog.Builder(DefaultErrorActivity.this).setTitle(R.string.customactivityoncrash_error_activity_error_details_title);
                    DefaultErrorActivity defaultErrorActivity = DefaultErrorActivity.this;
                    TextView textView = (TextView) title.setMessage((CharSequence) CustomActivityOnCrash.getAllErrorDetailsFromIntent(defaultErrorActivity, defaultErrorActivity.getIntent())).setPositiveButton(R.string.customactivityoncrash_error_activity_error_details_close, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.customactivityoncrash_error_activity_error_details_copy, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DefaultErrorActivity.this.copyErrorToClipboard();
                        }
                    }).show().findViewById(16908299);
                    if (textView != null) {
                        textView.setTextSize(0, DefaultErrorActivity.this.getResources().getDimension(R.dimen.customactivityoncrash_error_activity_error_details_text_size));
                    }
                }
            });
        } else {
            button2.setVisibility(8);
        }
        Integer errorDrawable = configFromIntent.getErrorDrawable();
        ImageView imageView = (ImageView) findViewById(R.id.customactivityoncrash_error_activity_image);
        if (errorDrawable != null) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), errorDrawable.intValue(), getTheme()));
        }
    }

    /* access modifiers changed from: private */
    public void copyErrorToClipboard() {
        String allErrorDetailsFromIntent = CustomActivityOnCrash.getAllErrorDetailsFromIntent(this, getIntent());
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(getString(R.string.customactivityoncrash_error_activity_error_details_clipboard_label), allErrorDetailsFromIntent));
            Toast.makeText(this, R.string.customactivityoncrash_error_activity_error_details_copied, 0).show();
        }
    }
}
