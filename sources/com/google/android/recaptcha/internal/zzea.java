package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
class zzea extends zzeb {
    final zzdw zzb;
    @CheckForNull
    final Character zzc;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzea(com.google.android.recaptcha.internal.zzdw r4, @javax.annotation.CheckForNull java.lang.Character r5) {
        /*
            r3 = this;
            r3.<init>()
            r3.zzb = r4
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x0017
            r5.charValue()
            r2 = 61
            boolean r4 = r4.zzd(r2)
            if (r4 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r4 = 0
            goto L_0x0018
        L_0x0017:
            r4 = 1
        L_0x0018:
            if (r4 == 0) goto L_0x001d
            r3.zzc = r5
            return
        L_0x001d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r5
            java.lang.String r5 = "Padding character %s was already in alphabet"
            java.lang.String r5 = com.google.android.recaptcha.internal.zzdl.zza(r5, r1)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzea.<init>(com.google.android.recaptcha.internal.zzdw, java.lang.Character):void");
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzea) {
            zzea zzea = (zzea) obj;
            if (this.zzb.equals(zzea.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzea.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch == null || !ch.equals(ch2)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zzb.hashCode();
        Character ch = this.zzc;
        if (ch == null) {
            i = 0;
        } else {
            i = ch.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzdi.zzd(0, i2, bArr.length);
        while (i3 < i2) {
            zzf(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        zzdw zzdw = this.zzb;
        return zzdw.zzc * zzed.zza(i, zzdw.zzd, RoundingMode.CEILING);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzdi.zzd(i, i + i2, bArr.length);
        int i3 = 0;
        zzdi.zza(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & UByte.MAX_VALUE))) << 8;
        }
        int i5 = ((i2 + 1) * 8) - this.zzb.zzb;
        while (i3 < i2 * 8) {
            zzdw zzdw = this.zzb;
            appendable.append(zzdw.zza(zzdw.zza & ((int) (j >>> (i5 - i3)))));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    zzea(String str, String str2, @CheckForNull Character ch) {
        this(new zzdw(str, str2.toCharArray()), ch);
    }

    /* access modifiers changed from: package-private */
    public final CharSequence zze(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0 || charSequence.charAt(length) != '=') {
            }
            length--;
            break;
        } while (charSequence.charAt(length) != '=');
        return charSequence.subSequence(0, length + 1);
    }

    /* access modifiers changed from: package-private */
    public int zza(byte[] bArr, CharSequence charSequence) throws zzdz {
        zzdw zzdw;
        Objects.requireNonNull(bArr);
        CharSequence zze = zze(charSequence);
        if (this.zzb.zzc(zze.length())) {
            int i = 0;
            int i2 = 0;
            while (i < zze.length()) {
                long j = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    zzdw = this.zzb;
                    if (i3 >= zzdw.zzc) {
                        break;
                    }
                    j <<= zzdw.zzb;
                    if (i + i3 < zze.length()) {
                        j |= (long) this.zzb.zzb(zze.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = zzdw.zzd;
                int i6 = i5 * 8;
                int i7 = i4 * zzdw.zzb;
                int i8 = (i5 - 1) * 8;
                while (i8 >= i6 - i7) {
                    bArr[i2] = (byte) ((int) ((j >>> i8) & 255));
                    i8 -= 8;
                    i2++;
                }
                i += this.zzb.zzc;
            }
            return i2;
        }
        throw new zzdz("Invalid input length " + zze.length());
    }
}
