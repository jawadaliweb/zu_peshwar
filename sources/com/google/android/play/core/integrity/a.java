package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.IntegrityTokenRequest;
import java.util.Objects;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class a extends IntegrityTokenRequest.Builder {
    private String a;
    private Long b;

    a() {
    }

    public final IntegrityTokenRequest build() {
        String str = this.a;
        if (str != null) {
            return new c(str, this.b, (b) null);
        }
        throw new IllegalStateException("Missing required properties: nonce");
    }

    public final IntegrityTokenRequest.Builder setCloudProjectNumber(long j) {
        this.b = Long.valueOf(j);
        return this;
    }

    public final IntegrityTokenRequest.Builder setNonce(String str) {
        Objects.requireNonNull(str, "Null nonce");
        this.a = str;
        return this;
    }
}
