package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzagc {
    private static final zzagc zzb = new zzagc(true);
    final zzaio zza = new zzaie(16);
    private boolean zzc;
    private boolean zzd;

    private zzagc() {
    }

    public static zzagc zza() {
        throw null;
    }

    private static final void zzd(zzagb zzagb, Object obj) {
        boolean z;
        zzajl zzb2 = zzagb.zzb();
        byte[] bArr = zzagq.zzd;
        Objects.requireNonNull(obj);
        zzajl zzajl = zzajl.DOUBLE;
        zzajm zzajm = zzajm.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzaff) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzagm)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzahp) || (obj instanceof zzagu)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzagb.zza()), zzagb.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzagc zzagc = new zzagc();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzagc.zzc((zzagb) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzagc.zzc((zzagb) entry.getKey(), entry.getValue());
        }
        zzagc.zzd = this.zzd;
        return zzagc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzagc)) {
            return false;
        }
        return this.zza.equals(((zzagc) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry zzg = this.zza.zzg(i);
                if (zzg.getValue() instanceof zzagk) {
                    ((zzagk) zzg.getValue()).zzF();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzagb zzagb, Object obj) {
        if (!zzagb.zzc()) {
            zzd(zzagb, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzagb, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzagu) {
            this.zzd = true;
        }
        this.zza.put(zzagb, obj);
    }

    private zzagc(boolean z) {
        zzb();
        zzb();
    }
}
