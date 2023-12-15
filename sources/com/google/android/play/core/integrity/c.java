package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class c extends IntegrityTokenRequest {
    private final String a;
    private final Long b;

    /* synthetic */ c(String str, Long l, b bVar) {
        this.a = str;
        this.b = l;
    }

    public final Long cloudProjectNumber() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.play.core.integrity.IntegrityTokenRequest
            r2 = 0
            if (r1 == 0) goto L_0x002e
            com.google.android.play.core.integrity.IntegrityTokenRequest r5 = (com.google.android.play.core.integrity.IntegrityTokenRequest) r5
            java.lang.String r1 = r4.a
            java.lang.String r3 = r5.nonce()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002e
            java.lang.Long r1 = r4.b
            if (r1 != 0) goto L_0x0022
            java.lang.Long r5 = r5.cloudProjectNumber()
            if (r5 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0022:
            java.lang.Long r5 = r5.cloudProjectNumber()
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            return r0
        L_0x002e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.integrity.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        int hashCode = this.a.hashCode() ^ 1000003;
        Long l = this.b;
        if (l == null) {
            i = 0;
        } else {
            i = l.hashCode();
        }
        return (hashCode * 1000003) ^ i;
    }

    public final String nonce() {
        return this.a;
    }

    public final String toString() {
        String str = this.a;
        Long l = this.b;
        return "IntegrityTokenRequest{nonce=" + str + ", cloudProjectNumber=" + l + "}";
    }
}
