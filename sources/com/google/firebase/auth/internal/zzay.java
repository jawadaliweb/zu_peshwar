package com.google.firebase.auth.internal;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzay implements OnCompleteListener {
    public final /* synthetic */ GenericIdpActivity zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzay(GenericIdpActivity genericIdpActivity, String str) {
        this.zza = genericIdpActivity;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        GenericIdpActivity genericIdpActivity = this.zza;
        String str = this.zzb;
        if (genericIdpActivity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null) {
            List<ResolveInfo> queryIntentServices = genericIdpActivity.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
                intent.putExtra("com.android.browser.application_id", str);
                Log.i("GenericIdpActivity", "Opening IDP Sign In link in a browser window.");
                intent.addFlags(BasicMeasure.EXACTLY);
                intent.addFlags(268435456);
                genericIdpActivity.startActivity(intent);
                return;
            }
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            Log.i("GenericIdpActivity", "Opening IDP Sign In link in a custom chrome tab.");
            build.launchUrl(genericIdpActivity, (Uri) task.getResult());
            return;
        }
        Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
        genericIdpActivity.zze(str, (Status) null);
    }
}
