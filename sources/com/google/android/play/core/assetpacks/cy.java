package com.google.android.play.core.assetpacks;

final class cy {
    private final int a;
    private final String b;
    private final long c;
    private final long d;
    private final int e;

    cy() {
    }

    cy(int i, String str, long j, long j2, int i2) {
        this();
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i2;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r7.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.assetpacks.cy
            r2 = 0
            if (r1 == 0) goto L_0x0046
            com.google.android.play.core.assetpacks.cy r8 = (com.google.android.play.core.assetpacks.cy) r8
            int r1 = r7.a
            int r3 = r8.a()
            if (r1 != r3) goto L_0x0046
            java.lang.String r1 = r7.b
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = r8.b()
            if (r1 != 0) goto L_0x0046
            goto L_0x0029
        L_0x001e:
            java.lang.String r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0029
            goto L_0x0046
        L_0x0029:
            long r3 = r7.c
            long r5 = r8.c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            long r3 = r7.d
            long r5 = r8.d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            int r1 = r7.e
            int r8 = r8.e()
            if (r1 != r8) goto L_0x0046
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.cy.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = (this.a ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.c;
        long j2 = this.d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.e;
    }

    public String toString() {
        int i = this.a;
        String str = this.b;
        long j = this.c;
        long j2 = this.d;
        int i2 = this.e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
