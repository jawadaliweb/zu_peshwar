package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzagg;
import com.google.android.gms.internal.p001firebaseauthapi.zzagk;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzagk<MessageType extends zzagk<MessageType, BuilderType>, BuilderType extends zzagg<MessageType, BuilderType>> extends zzaep<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzaiw zzc = zzaiw.zzc();
    private int zzd = -1;

    protected static zzagp zzA() {
        return zzahy.zze();
    }

    protected static zzagp zzB(zzagp zzagp) {
        int size = zzagp.size();
        return zzagp.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzD(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzE(zzahp zzahp, String str, Object[] objArr) {
        return new zzahz(zzahp, str, objArr);
    }

    protected static void zzH(Class cls, zzagk zzagk) {
        zzagk.zzG();
        zzb.put(cls, zzagk);
    }

    private final int zza(zzaib zzaib) {
        if (zzaib != null) {
            return zzaib.zza(this);
        }
        return zzahx.zza().zzb(getClass()).zza(this);
    }

    private static zzagk zzb(zzagk zzagk) throws zzags {
        if (zzagk == null || zzagk.zzK()) {
            return zzagk;
        }
        zzags zza = new zzaiu(zzagk).zza();
        zza.zzh(zzagk);
        throw zza;
    }

    private static zzagk zzc(zzagk zzagk, byte[] bArr, int i, int i2, zzafx zzafx) throws zzags {
        zzagk zzw = zzagk.zzw();
        try {
            zzaib zzb2 = zzahx.zza().zzb(zzw.getClass());
            zzb2.zzi(zzw, bArr, 0, i2, new zzaes(zzafx));
            zzb2.zzf(zzw);
            return zzw;
        } catch (zzags e) {
            e = e;
            if (e.zzl()) {
                e = new zzags((IOException) e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzaiu e2) {
            zzags zza = e2.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzags) {
                throw ((zzags) e3.getCause());
            }
            zzags zzags = new zzags(e3);
            zzags.zzh(zzw);
            throw zzags;
        } catch (IndexOutOfBoundsException unused) {
            zzags zzj = zzags.zzj();
            zzj.zzh(zzw);
            throw zzj;
        }
    }

    static zzagk zzv(Class cls) {
        Map map = zzb;
        zzagk zzagk = (zzagk) map.get(cls);
        if (zzagk == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzagk = (zzagk) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzagk == null) {
            zzagk = (zzagk) ((zzagk) zzajf.zze(cls)).zzj(6, (Object) null, (Object) null);
            if (zzagk != null) {
                map.put(cls, zzagk);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzagk;
    }

    protected static zzagk zzx(zzagk zzagk, zzaff zzaff, zzafx zzafx) throws zzags {
        zzafl zzh = zzaff.zzh();
        zzagk zzw = zzagk.zzw();
        try {
            zzaib zzb2 = zzahx.zza().zzb(zzw.getClass());
            zzb2.zzh(zzw, zzafm.zzq(zzh), zzafx);
            zzb2.zzf(zzw);
            try {
                zzh.zzz(0);
                zzb(zzw);
                return zzw;
            } catch (zzags e) {
                e.zzh(zzw);
                throw e;
            }
        } catch (zzags e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzags((IOException) e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzaiu e3) {
            zzags zza = e3.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzags) {
                throw ((zzags) e4.getCause());
            }
            zzags zzags = new zzags(e4);
            zzags.zzh(zzw);
            throw zzags;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzags) {
                throw ((zzags) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzagk zzy(zzagk zzagk, InputStream inputStream, zzafx zzafx) throws zzags {
        zzafj zzafj = new zzafj(inputStream, 4096, (zzafi) null);
        zzagk zzw = zzagk.zzw();
        try {
            zzaib zzb2 = zzahx.zza().zzb(zzw.getClass());
            zzb2.zzh(zzw, zzafm.zzq(zzafj), zzafx);
            zzb2.zzf(zzw);
            zzb(zzw);
            return zzw;
        } catch (zzags e) {
            e = e;
            if (e.zzl()) {
                e = new zzags((IOException) e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzaiu e2) {
            zzags zza = e2.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzags) {
                throw ((zzags) e3.getCause());
            }
            zzags zzags = new zzags(e3);
            zzags.zzh(zzw);
            throw zzags;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzags) {
                throw ((zzags) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzagk zzz(zzagk zzagk, byte[] bArr, zzafx zzafx) throws zzags {
        zzagk zzc2 = zzc(zzagk, bArr, 0, bArr.length, zzafx);
        zzb(zzc2);
        return zzc2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzahx.zza().zzb(getClass()).zzj(this, (zzagk) obj);
    }

    public final int hashCode() {
        if (zzL()) {
            return zzr();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzr = zzr();
        this.zza = zzr;
        return zzr;
    }

    public final String toString() {
        return zzahr.zza(this, super.toString());
    }

    public final /* synthetic */ zzaho zzC() {
        return (zzagg) zzj(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzF() {
        zzahx.zza().zzb(getClass()).zzf(this);
        zzG();
    }

    /* access modifiers changed from: package-private */
    public final void zzG() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzI(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzJ(zzafs zzafs) throws IOException {
        zzahx.zza().zzb(getClass()).zzm(this, zzaft.zza(zzafs));
    }

    public final boolean zzK() {
        Boolean bool = Boolean.TRUE;
        byte byteValue = ((Byte) zzj(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzahx.zza().zzb(getClass()).zzk(this);
        zzj(2, true != zzk ? null : this, (Object) null);
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzL() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzahp zzM() {
        return (zzagk) zzj(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object zzj(int i, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzr() {
        return zzahx.zza().zzb(getClass()).zzb(this);
    }

    /* access modifiers changed from: protected */
    public final zzagg zzt() {
        return (zzagg) zzj(5, (Object) null, (Object) null);
    }

    public final zzagg zzu() {
        zzagg zzagg = (zzagg) zzj(5, (Object) null, (Object) null);
        zzagg.zzh(this);
        return zzagg;
    }

    /* access modifiers changed from: package-private */
    public final zzagk zzw() {
        return (zzagk) zzj(4, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzn(zzaib zzaib) {
        if (zzL()) {
            int zza = zza(zzaib);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zza(zzaib);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    public final int zzs() {
        int i;
        if (zzL()) {
            i = zza((zzaib) null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zza((zzaib) null);
                if (i >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
            }
        }
        return i;
    }
}
