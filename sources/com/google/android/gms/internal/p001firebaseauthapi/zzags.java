package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzags  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class zzags extends IOException {
    private zzahp zza = null;
    private boolean zzb;

    public zzags(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzagr zza() {
        return new zzagr("Protocol message tag had invalid wire type.");
    }

    static zzags zzb() {
        return new zzags("Protocol message end-group tag did not match expected tag.");
    }

    static zzags zzc() {
        return new zzags("Protocol message contained an invalid tag (zero).");
    }

    static zzags zzd() {
        return new zzags("Protocol message had invalid UTF-8.");
    }

    static zzags zze() {
        return new zzags("CodedInputStream encountered a malformed varint.");
    }

    static zzags zzf() {
        return new zzags("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzags zzg() {
        return new zzags("Failed to parse the message.");
    }

    static zzags zzi() {
        return new zzags("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzags zzj() {
        return new zzags("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzags zzh(zzahp zzahp) {
        this.zza = zzahp;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl() {
        return this.zzb;
    }

    public zzags(String str) {
        super(str);
    }
}
