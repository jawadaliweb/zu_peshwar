package com.google.android.gms.internal.p001firebaseauthapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzajn extends ThreadLocal {
    zzajn() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }
}
