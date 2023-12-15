package com.lmkt.zupeshawar.views.activities;

import com.google.android.gms.tasks.OnSuccessListener;

/* renamed from: com.lmkt.zupeshawar.views.activities.-$$Lambda$RegistrationActivity$hv_8e27gM78bUZc6WwRM3rATo1Y  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$RegistrationActivity$hv_8e27gM78bUZc6WwRM3rATo1Y implements OnSuccessListener {
    public static final /* synthetic */ $$Lambda$RegistrationActivity$hv_8e27gM78bUZc6WwRM3rATo1Y INSTANCE = new $$Lambda$RegistrationActivity$hv_8e27gM78bUZc6WwRM3rATo1Y();

    private /* synthetic */ $$Lambda$RegistrationActivity$hv_8e27gM78bUZc6WwRM3rATo1Y() {
    }

    public final void onSuccess(Object obj) {
        RegistrationActivity.FCM_TOKEN = (String) obj;
    }
}
