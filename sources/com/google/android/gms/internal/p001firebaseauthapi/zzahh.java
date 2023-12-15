package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzahh implements zzaic {
    private static final zzahn zza = new zzahf();
    private final zzahn zzb;

    public zzahh() {
        zzahn zzahn;
        zzahn[] zzahnArr = new zzahn[2];
        zzahnArr[0] = zzagf.zza();
        try {
            zzahn = (zzahn) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzahn = zza;
        }
        zzahnArr[1] = zzahn;
        zzahg zzahg = new zzahg(zzahnArr);
        byte[] bArr = zzagq.zzd;
        this.zzb = zzahg;
    }

    private static boolean zzb(zzahm zzahm) {
        return zzahm.zzc() == 1;
    }

    public final zzaib zza(Class cls) {
        zzaid.zzD(cls);
        zzahm zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzagk.class.isAssignableFrom(cls)) {
                return zzaht.zzc(zzaid.zzz(), zzaga.zzb(), zzb2.zza());
            }
            return zzaht.zzc(zzaid.zzy(), zzaga.zza(), zzb2.zza());
        } else if (zzagk.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzahs.zzl(cls, zzb2, zzahv.zzb(), zzahd.zze(), zzaid.zzz(), zzaga.zzb(), zzahl.zzb());
            }
            return zzahs.zzl(cls, zzb2, zzahv.zzb(), zzahd.zze(), zzaid.zzz(), (zzafy) null, zzahl.zzb());
        } else if (zzb(zzb2)) {
            return zzahs.zzl(cls, zzb2, zzahv.zza(), zzahd.zzd(), zzaid.zzy(), zzaga.zza(), zzahl.zza());
        } else {
            return zzahs.zzl(cls, zzb2, zzahv.zza(), zzahd.zzd(), zzaid.zzy(), (zzafy) null, zzahl.zza());
        }
    }
}
