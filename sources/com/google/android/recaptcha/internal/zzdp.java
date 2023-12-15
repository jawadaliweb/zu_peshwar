package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public abstract class zzdp implements Iterable {
    private final zzde zza = zzde.zza();

    protected zzdp() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z = true;
        for (Object append : this) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(append);
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
