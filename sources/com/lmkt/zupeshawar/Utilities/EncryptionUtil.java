package com.lmkt.zupeshawar.Utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class EncryptionUtil {
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    public static String calculateHMAC256(String str, String str2, String str3) throws Exception {
        byte[] bytes = str.getBytes("UTF-8");
        String calculateMD5 = calculateMD5(str3);
        byte[] bytes2 = (str2 + calculateMD5).getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, HMAC_SHA256_ALGORITHM);
        Mac instance = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        instance.init(secretKeySpec);
        return new String(Base64.encodeBase64(instance.doFinal(bytes2)));
    }

    private static String calculateMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        instance.update(str.getBytes());
        return new String(Base64.encodeBase64(instance.digest()));
    }
}
