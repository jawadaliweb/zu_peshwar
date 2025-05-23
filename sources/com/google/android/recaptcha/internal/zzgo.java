package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzgi;
import com.google.android.recaptcha.internal.zzgo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public abstract class zzgo<MessageType extends zzgo<MessageType, BuilderType>, BuilderType extends zzgi<MessageType, BuilderType>> extends zzei<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzjg zzc = zzjg.zzc();
    private int zzd = -1;

    protected static void zzC(Class cls, zzgo zzgo) {
        zzgo.zzB();
        zzb.put(cls, zzgo);
    }

    protected static final boolean zzE(zzgo zzgo, boolean z) {
        byte byteValue = ((Byte) zzgo.zzh(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzih.zza().zzb(zzgo.getClass()).zzl(zzgo);
        if (z) {
            zzgo.zzh(2, true != zzl ? null : zzgo, (Object) null);
        }
        return zzl;
    }

    private final int zzf(zzil zzil) {
        if (zzil != null) {
            return zzil.zza(this);
        }
        return zzih.zza().zzb(getClass()).zza(this);
    }

    private static zzgo zzg(zzgo zzgo) throws zzgy {
        if (zzgo == null || zzgo.zzo()) {
            return zzgo;
        }
        zzgy zza = new zzje(zzgo).zza();
        zza.zzh(zzgo);
        throw zza;
    }

    private static zzgo zzi(zzgo zzgo, byte[] bArr, int i, int i2, zzfz zzfz) throws zzgy {
        zzgo zzs = zzgo.zzs();
        try {
            zzil zzb2 = zzih.zza().zzb(zzs.getClass());
            zzb2.zzi(zzs, bArr, 0, i2, new zzem(zzfz));
            zzb2.zzf(zzs);
            return zzs;
        } catch (zzgy e) {
            e = e;
            if (e.zzl()) {
                e = new zzgy((IOException) e);
            }
            e.zzh(zzs);
            throw e;
        } catch (zzje e2) {
            zzgy zza = e2.zza();
            zza.zzh(zzs);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgy) {
                throw ((zzgy) e3.getCause());
            }
            zzgy zzgy = new zzgy(e3);
            zzgy.zzh(zzs);
            throw zzgy;
        } catch (IndexOutOfBoundsException unused) {
            zzgy zzj = zzgy.zzj();
            zzj.zzh(zzs);
            throw zzj;
        }
    }

    public static zzgm zzq(zzhy zzhy, Object obj, zzhy zzhy2, zzgr zzgr, int i, zzjv zzjv, Class cls) {
        return new zzgm(zzhy, "", (zzhy) null, new zzgl((zzgr) null, i, zzjv, false, false), cls);
    }

    static zzgo zzr(Class cls) {
        Map map = zzb;
        zzgo zzgo = (zzgo) map.get(cls);
        if (zzgo == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgo = (zzgo) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgo == null) {
            zzgo = (zzgo) ((zzgo) zzjp.zze(cls)).zzh(6, (Object) null, (Object) null);
            if (zzgo != null) {
                map.put(cls, zzgo);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzgo;
    }

    protected static zzgo zzt(zzgo zzgo, InputStream inputStream) throws zzgy {
        zzff zzff;
        int i = zzff.zzd;
        if (inputStream == null) {
            byte[] bArr = zzgw.zzd;
            int length = bArr.length;
            zzff = zzff.zzH(bArr, 0, 0, false);
        } else {
            zzff = new zzfd(inputStream, 4096, (zzfc) null);
        }
        zzfz zzfz = zzfz.zza;
        zzgo zzs = zzgo.zzs();
        try {
            zzil zzb2 = zzih.zza().zzb(zzs.getClass());
            zzb2.zzh(zzs, zzfg.zzq(zzff), zzfz);
            zzb2.zzf(zzs);
            zzg(zzs);
            return zzs;
        } catch (zzgy e) {
            e = e;
            if (e.zzl()) {
                e = new zzgy((IOException) e);
            }
            e.zzh(zzs);
            throw e;
        } catch (zzje e2) {
            zzgy zza = e2.zza();
            zza.zzh(zzs);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgy) {
                throw ((zzgy) e3.getCause());
            }
            zzgy zzgy = new zzgy(e3);
            zzgy.zzh(zzs);
            throw zzgy;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgy) {
                throw ((zzgy) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzgo zzu(zzgo zzgo, byte[] bArr) throws zzgy {
        zzgo zzi = zzi(zzgo, bArr, 0, bArr.length, zzfz.zza);
        zzg(zzi);
        return zzi;
    }

    protected static zzgt zzv() {
        return zzgp.zzf();
    }

    protected static zzgv zzw() {
        return zzii.zze();
    }

    protected static zzgv zzx(zzgv zzgv) {
        int size = zzgv.size();
        return zzgv.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzy(Method method, Object obj, Object... objArr) {
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

    protected static Object zzz(zzhy zzhy, String str, Object[] objArr) {
        return new zzij(zzhy, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzih.zza().zzb(getClass()).zzk(this, (zzgo) obj);
    }

    public final int hashCode() {
        if (zzF()) {
            return zzm();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzm = zzm();
        this.zza = zzm;
        return zzm;
    }

    public final String toString() {
        return zzia.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public final void zzA() {
        zzih.zza().zzb(getClass()).zzf(this);
        zzB();
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzD(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzF() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzhx zzV() {
        return (zzgi) zzh(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzhx zzW() {
        zzgi zzgi = (zzgi) zzh(5, (Object) null, (Object) null);
        zzgi.zzg(this);
        return zzgi;
    }

    public final /* synthetic */ zzhy zzX() {
        return (zzgo) zzh(6, (Object) null, (Object) null);
    }

    public final void zze(zzfk zzfk) throws IOException {
        zzih.zza().zzb(getClass()).zzj(this, zzfl.zza(zzfk));
    }

    /* access modifiers changed from: protected */
    public abstract Object zzh(int i, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzm() {
        return zzih.zza().zzb(getClass()).zzb(this);
    }

    public final boolean zzo() {
        Boolean bool = Boolean.TRUE;
        return zzE(this, true);
    }

    /* access modifiers changed from: protected */
    public final zzgi zzp() {
        return (zzgi) zzh(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final zzgo zzs() {
        return (zzgo) zzh(4, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzil zzil) {
        if (zzF()) {
            int zzf = zzf(zzil);
            if (zzf >= 0) {
                return zzf;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzf);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zzf2 = zzf(zzil);
        if (zzf2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzf2;
            return zzf2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzf2);
    }

    public final int zzn() {
        int i;
        if (zzF()) {
            i = zzf((zzil) null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zzf((zzil) null);
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
