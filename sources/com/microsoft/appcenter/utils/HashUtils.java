package com.microsoft.appcenter.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class HashUtils {
    private static final char[] HEXADECIMAL_OUTPUT = "0123456789abcdef".toCharArray();

    HashUtils() {
    }

    public static String sha256(String str) {
        return sha256(str, "UTF-8");
    }

    static String sha256(String str, String str2) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(str.getBytes(str2));
            return encodeHex(instance.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String encodeHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & UByte.MAX_VALUE;
            int i2 = i * 2;
            char[] cArr2 = HEXADECIMAL_OUTPUT;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
