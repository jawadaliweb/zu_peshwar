package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p001firebaseauthapi.zzaai;
import com.google.android.gms.internal.p001firebaseauthapi.zzaak;
import com.google.android.gms.internal.p001firebaseauthapi.zzaav;
import com.google.android.gms.internal.p001firebaseauthapi.zzace;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.core.ServerValues;
import com.google.firebase.inject.Provider;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class RecaptchaActivity extends FragmentActivity implements zzaak {
    private static final String zzb = "RecaptchaActivity";
    private static long zzc;
    private static final zzby zzd = zzby.zzc();
    private boolean zze = false;

    static /* synthetic */ Uri zzg(Uri uri, Task task) throws Exception {
        Uri.Builder buildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.getError() != null) {
                Log.w(zzb, "Error getting App Check token; using placeholder token instead. Error: ".concat(String.valueOf(String.valueOf(appCheckTokenResult.getError()))));
            }
            buildUpon.fragment("fac=".concat(String.valueOf(appCheckTokenResult.getToken())));
        } else {
            Log.e(zzb, "Unexpected error getting App Check token: ".concat(String.valueOf(task.getException().getMessage())));
        }
        return buildUpon.build();
    }

    private final void zzi() {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        zzd.zzd(this);
        finish();
    }

    private final void zzj(Status status) {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        int i = zzbx.zzb;
        SafeParcelableSerializer.serializeToIntentExtra(status, intent, "com.google.firebase.auth.internal.STATUS");
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        zzd.zzd(this);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
            if (currentTimeMillis - zzc < 30000) {
                Log.e(zzb, "Could not start operation - already in progress");
                return;
            }
            zzc = currentTimeMillis;
            if (bundle != null) {
                this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
                return;
            }
            return;
        }
        Log.e(zzb, "Could not do operation - unknown action: ".concat(String.valueOf(action)));
        zzi();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        if ("android.intent.action.VIEW".equals(getIntent().getAction())) {
            Intent intent = getIntent();
            if (intent.hasExtra("firebaseError")) {
                zzj(zzbx.zzb(intent.getStringExtra("firebaseError")));
            } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
                zzi();
            } else {
                String stringExtra = intent.getStringExtra("link");
                String zzc2 = zzj.zzb().zzc(getApplicationContext(), getPackageName(), intent.getStringExtra("eventId"));
                if (TextUtils.isEmpty(zzc2)) {
                    Log.e(zzb, "Failed to find registration for this event - failing to prevent session injection.");
                    zzj(zzai.zza("Failed to find registration for this reCAPTCHA event"));
                }
                if (intent.getBooleanExtra("encryptionEnabled", true)) {
                    stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zzc2).getPersistenceKey()).zzb(stringExtra);
                }
                String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
                zzc = 0;
                this.zze = false;
                Intent intent2 = new Intent();
                intent2.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent2)) {
                    SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                    edit.putString("recaptchaToken", queryParameter);
                    edit.putString("operation", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                    edit.putLong(ServerValues.NAME_OP_TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
                    edit.commit();
                } else {
                    zzd.zzd(this);
                }
                finish();
            }
        } else if (!this.zze) {
            Intent intent3 = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US);
                FirebaseApp instance = FirebaseApp.getInstance(intent3.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                new zzaai(packageName, lowerCase, intent3, instance, this).executeOnExecutor(FirebaseAuth.getInstance(instance).zzK(), new Void[0]);
            } catch (PackageManager.NameNotFoundException e) {
                String str = zzb;
                String obj = e.toString();
                Log.e(str, "Could not get package signature: " + packageName + MaskedEditText.SPACE + obj);
                zze(packageName, (Status) null);
            }
            this.zze = true;
        } else {
            zzi();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.zze);
    }

    public final Context zza() {
        return getApplicationContext();
    }

    public final Uri.Builder zzb(Intent intent, String str, String str2) {
        String str3;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        FirebaseApp instance = FirebaseApp.getInstance(stringExtra3);
        FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
        zzj.zzb().zze(getApplicationContext(), str, uuid, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String zzc2 = zzk.zza(getApplicationContext(), instance.getPersistenceKey()).zzc();
        if (TextUtils.isEmpty(zzc2)) {
            Log.e(zzb, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            zzj(zzai.zza("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        if (!TextUtils.isEmpty(instance2.getLanguageCode())) {
            str3 = instance2.getLanguageCode();
        } else {
            str3 = zzaav.zza();
        }
        return new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", str3).appendQueryParameter("eventId", uuid).appendQueryParameter("v", "X".concat(String.valueOf(stringExtra2))).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zzc2);
    }

    public final String zzc(String str) {
        return zzace.zzb(str);
    }

    public final HttpURLConnection zzd(URL url) {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException unused) {
            zza.e("Error generating connection", new Object[0]);
            return null;
        }
    }

    public final void zze(String str, Status status) {
        if (status == null) {
            zzi();
        } else {
            zzj(status);
        }
    }

    public final void zzf(Uri uri, String str, Provider provider) {
        Task<TContinuationResult> task;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) provider.get();
        if (interopAppCheckTokenProvider != null) {
            task = interopAppCheckTokenProvider.getToken(false).continueWith(new zzbg(uri));
        } else {
            task = Tasks.forResult(uri);
        }
        task.addOnCompleteListener(new zzbh(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str, Task task) {
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null) {
            List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
                intent.putExtra("com.android.browser.application_id", str);
                intent.addFlags(BasicMeasure.EXACTLY);
                intent.addFlags(268435456);
                startActivity(intent);
                return;
            }
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.addFlags(BasicMeasure.EXACTLY);
            build.intent.addFlags(268435456);
            build.launchUrl(this, (Uri) task.getResult());
            return;
        }
        Log.e(zzb, "Device cannot resolve intent for: android.intent.action.VIEW");
        zze(str, (Status) null);
    }
}
