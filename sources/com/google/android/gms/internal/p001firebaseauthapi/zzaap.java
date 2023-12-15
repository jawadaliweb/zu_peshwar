package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaap  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaap {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzaap";

    private zzaap() {
    }

    public static Object zza(String str, Type type) throws zzyi {
        if (type == String.class) {
            try {
                zzach zzach = new zzach();
                zzach.zzb(str);
                if (zzach.zzd()) {
                    return zzach.zzc();
                }
                throw new zzyi("No error message: " + str);
            } catch (Exception e) {
                throw new zzyi("Json conversion failed! ".concat(String.valueOf(e.getMessage())), e);
            }
        } else if (type == Void.class) {
            return null;
        } else {
            try {
                try {
                    return ((zzaar) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0])).zza(str);
                } catch (Exception e2) {
                    throw new zzyi("Json conversion failed! ".concat(String.valueOf(e2.getMessage())), e2);
                }
            } catch (Exception e3) {
                throw new zzyi("Instantiation of JsonResponse failed! ".concat(type.toString()), e3);
            }
        }
    }
}
