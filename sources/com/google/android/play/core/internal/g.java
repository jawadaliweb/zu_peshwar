package com.google.android.play.core.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

final class g extends h {
    private final byte[] a;

    public g(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.a;
    }
}
