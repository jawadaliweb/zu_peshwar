package org.apache.commons.compress.archivers.jar;

import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

public class JarArchiveEntry extends ZipArchiveEntry {
    private final Certificate[] certificates = null;
    private final Attributes manifestAttributes = null;

    public JarArchiveEntry(ZipEntry zipEntry) throws ZipException {
        super(zipEntry);
    }

    public JarArchiveEntry(String str) {
        super(str);
    }

    public JarArchiveEntry(ZipArchiveEntry zipArchiveEntry) throws ZipException {
        super(zipArchiveEntry);
    }

    public JarArchiveEntry(JarEntry jarEntry) throws ZipException {
        super((ZipEntry) jarEntry);
    }

    @Deprecated
    public Attributes getManifestAttributes() {
        return this.manifestAttributes;
    }

    @Deprecated
    public Certificate[] getCertificates() {
        Certificate[] certificateArr = this.certificates;
        if (certificateArr == null) {
            return null;
        }
        int length = certificateArr.length;
        Certificate[] certificateArr2 = new Certificate[length];
        System.arraycopy(certificateArr, 0, certificateArr2, 0, length);
        return certificateArr2;
    }
}
