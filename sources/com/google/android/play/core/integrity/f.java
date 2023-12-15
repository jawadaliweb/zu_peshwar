package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class f extends IntegrityTokenResponse {
    private final String a;

    /* synthetic */ f(String str, e eVar) {
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenResponse) {
            return this.a.equals(((IntegrityTokenResponse) obj).token());
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String str = this.a;
        return "IntegrityTokenResponse{token=" + str + "}";
    }

    public final String token() {
        return this.a;
    }
}
