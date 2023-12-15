package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p001firebaseauthapi.zzaai;
import com.google.android.gms.internal.p001firebaseauthapi.zzaaj;
import com.google.android.gms.internal.p001firebaseauthapi.zzaak;
import com.google.android.gms.internal.p001firebaseauthapi.zzace;
import com.google.android.gms.internal.p001firebaseauthapi.zzaec;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.core.ServerValues;
import com.google.firebase.inject.Provider;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class GenericIdpActivity extends FragmentActivity implements zzaak {
    public static final /* synthetic */ int zzb = 0;
    private static long zzc;
    private static final zzby zzd = zzby.zzc();
    private boolean zze = false;

    private final void zzh() {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzd.zzf(this, zzai.zza("WEB_CONTEXT_CANCELED"));
        } else {
            zzd.zzd(this);
        }
        finish();
    }

    private final void zzi(Status status) {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        int i = zzbx.zzb;
        SafeParcelableSerializer.serializeToIntentExtra(status, intent, "com.google.firebase.auth.internal.STATUS");
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzd.zzf(getApplicationContext(), status);
        } else {
            zzd.zzd(this);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
            if (currentTimeMillis - zzc < 30000) {
                Log.e("GenericIdpActivity", "Could not start operation - already in progress");
                return;
            }
            zzc = currentTimeMillis;
            if (bundle != null) {
                this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
                return;
            }
            return;
        }
        Log.e("GenericIdpActivity", "Could not do operation - unknown action: ".concat(String.valueOf(action)));
        zzh();
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
                zzi(zzbx.zzb(intent.getStringExtra("firebaseError")));
            } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
                zzh();
            } else {
                String stringExtra = intent.getStringExtra("link");
                String stringExtra2 = intent.getStringExtra("eventId");
                String packageName = getPackageName();
                boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
                zzi zza = zzj.zzb().zza(this, packageName, stringExtra2);
                if (zza == null) {
                    zzh();
                }
                if (booleanExtra) {
                    stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zza.zza()).getPersistenceKey()).zzb(stringExtra);
                }
                zzaec zzaec = new zzaec(zza, stringExtra);
                String zze2 = zza.zze();
                String zzb2 = zza.zzb();
                zzaec.zzf(zze2);
                if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(zzb2) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(zzb2) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(zzb2)) {
                    zzc = 0;
                    this.zze = false;
                    Intent intent2 = new Intent();
                    SafeParcelableSerializer.serializeToIntentExtra(zzaec, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                    intent2.putExtra("com.google.firebase.auth.internal.OPERATION", zzb2);
                    intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                    if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent2)) {
                        SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                        edit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzaec));
                        edit.putString("operation", zzb2);
                        edit.putString("tenantId", zze2);
                        edit.putLong(ServerValues.NAME_OP_TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
                        edit.commit();
                    } else {
                        zzd.zzd(this);
                    }
                    finish();
                    return;
                }
                Log.e("GenericIdpActivity", "unsupported operation: ".concat(zzb2));
                zzh();
            }
        } else if (!this.zze) {
            String packageName2 = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName2)).toLowerCase(Locale.US);
                FirebaseApp instance = FirebaseApp.getInstance(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
                if (!zzace.zzg(instance)) {
                    new zzaai(packageName2, lowerCase, getIntent(), instance, this).executeOnExecutor(instance2.zzK(), new Void[0]);
                } else {
                    zzf(zzg(Uri.parse(zzace.zza(instance.getOptions().getApiKey())).buildUpon(), getIntent(), packageName2, lowerCase).build(), packageName2, instance2.zzD());
                }
            } catch (PackageManager.NameNotFoundException e) {
                String obj = e.toString();
                Log.e("GenericIdpActivity", "Could not get package signature: " + packageName2 + MaskedEditText.SPACE + obj);
                zze(packageName2, (Status) null);
            }
            this.zze = true;
        } else {
            zzh();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zze);
    }

    public final Context zza() {
        return getApplicationContext();
    }

    public final Uri.Builder zzb(Intent intent, String str, String str2) {
        return zzg(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    public final String zzc(String str) {
        return zzace.zzb(str);
    }

    public final HttpURLConnection zzd(URL url) {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    public final void zze(String str, Status status) {
        if (status == null) {
            zzh();
        } else {
            zzi(status);
        }
    }

    public final void zzf(Uri uri, String str, Provider provider) {
        Task<TContinuationResult> task;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) provider.get();
        if (interopAppCheckTokenProvider != null) {
            task = interopAppCheckTokenProvider.getToken(false).continueWith(new zzaz(uri));
        } else {
            task = Tasks.forResult(uri);
        }
        task.addOnCompleteListener(new zzay(this, str));
    }

    public final Uri.Builder zzg(Uri.Builder builder, Intent intent, String str, String str2) {
        String str3;
        Uri.Builder builder2 = builder;
        Intent intent2 = intent;
        String stringExtra = intent2.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent2.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent2.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent2.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent2.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        Bundle bundleExtra = intent2.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS");
        if (bundleExtra == null) {
            str3 = null;
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str4 : bundleExtra.keySet()) {
                    String string = bundleExtra.getString(str4);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(str4, string);
                    }
                }
            } catch (JSONException unused) {
                Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
            }
            str3 = jSONObject.toString();
        }
        String uuid = UUID.randomUUID().toString();
        String zza = zzaaj.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent2.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String str5 = uuid;
        String str6 = zza;
        String str7 = uuid;
        String str8 = action;
        String str9 = str3;
        String str10 = stringExtra2;
        String str11 = stringExtra2;
        String str12 = "GenericIdpActivity";
        String str13 = join;
        zzj.zzb().zzd(getApplicationContext(), str, str5, zza, str8, str10, stringExtra3, stringExtra4);
        String zzc2 = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(stringExtra4).getPersistenceKey()).zzc();
        if (TextUtils.isEmpty(zzc2)) {
            Log.e(str12, "Could not generate an encryption key for Generic IDP - cancelling flow.");
            zzi(zzai.zza("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        }
        String str14 = str6;
        if (str14 == null) {
            return null;
        }
        builder2.appendQueryParameter("eid", "p").appendQueryParameter("v", "X".concat(String.valueOf(stringExtra5))).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", str11).appendQueryParameter("sessionId", str14).appendQueryParameter("eventId", str7).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zzc2);
        if (!TextUtils.isEmpty(str13)) {
            builder2.appendQueryParameter("scopes", str13);
        }
        if (!TextUtils.isEmpty(str9)) {
            builder2.appendQueryParameter("customParameters", str9);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            builder2.appendQueryParameter("tid", stringExtra3);
        }
        return builder2;
    }
}
