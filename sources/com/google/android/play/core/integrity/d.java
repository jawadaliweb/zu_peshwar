package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class d extends w {
    private String a;

    d() {
    }

    /* access modifiers changed from: package-private */
    public final w a(String str) {
        this.a = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final IntegrityTokenResponse b() {
        String str = this.a;
        if (str != null) {
            return new f(str, (e) null);
        }
        throw new IllegalStateException("Missing required properties: token");
    }
}
