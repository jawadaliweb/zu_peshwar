package com.google.android.recaptcha.internal;

import androidx.core.view.PointerIconCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzl {
    public static final zzk zza = new zzk((DefaultConstructorMarker) null);
    public static final zzl zzb = new zzl(9999);
    public static final zzl zzc = new zzl(1000);
    public static final zzl zzd = new zzl(1001);
    public static final zzl zze = new zzl(PointerIconCompat.TYPE_HAND);
    public static final zzl zzf = new zzl(PointerIconCompat.TYPE_HELP);
    public static final zzl zzg = new zzl(PointerIconCompat.TYPE_WAIT);
    public static final zzl zzh = new zzl(WebSocketProtocol.CLOSE_NO_STATUS_CODE);
    public static final zzl zzi = new zzl(PointerIconCompat.TYPE_CELL);
    public static final zzl zzj = new zzl(PointerIconCompat.TYPE_CROSSHAIR);
    public static final zzl zzk = new zzl(PointerIconCompat.TYPE_TEXT);
    public static final zzl zzl = new zzl(PointerIconCompat.TYPE_VERTICAL_TEXT);
    public static final zzl zzm = new zzl(PointerIconCompat.TYPE_ALIAS);
    private final int zzn;

    private zzl(int i) {
        this.zzn = i;
    }

    public final int zza() {
        return this.zzn;
    }
}
