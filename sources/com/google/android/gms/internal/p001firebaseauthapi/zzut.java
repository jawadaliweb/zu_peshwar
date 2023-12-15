package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzut  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzut {
    public static int zza(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (zzjx.zza(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    public static BigInteger zzb(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigInteger2;
        BigInteger zza = zzjx.zza(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(zza);
        if (zza.signum() == 1) {
            BigInteger mod2 = mod.mod(zza);
            if (mod2.equals(BigInteger.ZERO)) {
                bigInteger2 = BigInteger.ZERO;
            } else {
                BigInteger bigInteger3 = null;
                if (!zza.testBit(0) || !zza.testBit(1)) {
                    if (zza.testBit(0) && !zza.testBit(1)) {
                        BigInteger bigInteger4 = BigInteger.ONE;
                        BigInteger shiftRight = zza.subtract(BigInteger.ONE).shiftRight(1);
                        int i = 0;
                        while (true) {
                            BigInteger mod3 = bigInteger4.multiply(bigInteger4).subtract(mod2).mod(zza);
                            if (mod3.equals(BigInteger.ZERO)) {
                                bigInteger2 = bigInteger4;
                                break;
                            }
                            BigInteger modPow = mod3.modPow(shiftRight, zza);
                            if (modPow.add(BigInteger.ONE).equals(zza)) {
                                BigInteger shiftRight2 = zza.add(BigInteger.ONE).shiftRight(1);
                                BigInteger bigInteger5 = BigInteger.ONE;
                                BigInteger bigInteger6 = bigInteger4;
                                for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                    BigInteger multiply = bigInteger6.multiply(bigInteger5);
                                    BigInteger mod4 = bigInteger6.multiply(bigInteger6).add(bigInteger5.multiply(bigInteger5).mod(zza).multiply(mod3)).mod(zza);
                                    BigInteger mod5 = multiply.add(multiply).mod(zza);
                                    if (shiftRight2.testBit(bitLength)) {
                                        BigInteger mod6 = mod4.multiply(bigInteger4).add(mod5.multiply(mod3)).mod(zza);
                                        bigInteger5 = bigInteger4.multiply(mod5).add(mod4).mod(zza);
                                        bigInteger6 = mod6;
                                    } else {
                                        BigInteger bigInteger7 = mod5;
                                        bigInteger6 = mod4;
                                        bigInteger5 = bigInteger7;
                                    }
                                }
                                bigInteger3 = bigInteger6;
                            } else if (modPow.equals(BigInteger.ONE)) {
                                bigInteger4 = bigInteger4.add(BigInteger.ONE);
                                i++;
                                if (i == 128 && !zza.isProbablePrime(80)) {
                                    throw new InvalidAlgorithmParameterException("p is not prime");
                                }
                            } else {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        }
                    }
                } else {
                    bigInteger3 = mod2.modPow(zza.add(BigInteger.ONE).shiftRight(2), zza);
                }
                if (bigInteger3 == null || bigInteger3.multiply(bigInteger3).mod(zza).compareTo(mod2) == 0) {
                    bigInteger2 = bigInteger3;
                } else {
                    throw new GeneralSecurityException("Could not find a modular square root");
                }
            }
            return z != bigInteger2.testBit(0) ? zza.subtract(bigInteger2).mod(zza) : bigInteger2;
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static KeyPair zzc(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzvc.zzf.zza("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    public static void zzd(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        zze(eCPublicKey, eCPrivateKey);
        zzjx.zzb(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    static void zze(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            ECParameterSpec params = eCPublicKey.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            ECParameterSpec eCParameterSpec = zzjx.zza;
            if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] zzf(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        zze(eCPublicKey, eCPrivateKey);
        ECPoint w = eCPublicKey.getW();
        zzjx.zzb(w, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = ((KeyFactory) zzvc.zzg.zza("EC")).generatePublic(new ECPublicKeySpec(w, eCPrivateKey.getParams()));
        KeyAgreement keyAgreement = (KeyAgreement) zzvc.zze.zza("ECDH");
        keyAgreement.init(eCPrivateKey);
        try {
            keyAgreement.doPhase(generatePublic, true);
            byte[] generateSecret = keyAgreement.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, generateSecret);
            if (bigInteger.signum() == -1 || bigInteger.compareTo(zzjx.zza(curve)) >= 0) {
                throw new GeneralSecurityException("shared secret is out of range");
            }
            zzb(bigInteger, true, curve);
            return generateSecret;
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public static ECPrivateKey zzg(int i, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) ((KeyFactory) zzvc.zzg.zza("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), zzi(i)));
    }

    public static ECPublicKey zzh(ECParameterSpec eCParameterSpec, int i, byte[] bArr) throws GeneralSecurityException {
        ECPoint eCPoint;
        EllipticCurve curve = eCParameterSpec.getCurve();
        int zza = zza(curve);
        int i2 = i - 1;
        boolean z = false;
        if (i2 == 0) {
            int length = bArr.length;
            if (length != zza + zza + 1) {
                throw new GeneralSecurityException("invalid point size");
            } else if (bArr[0] == 4) {
                int i3 = zza + 1;
                eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i3)), new BigInteger(1, Arrays.copyOfRange(bArr, i3, length)));
                zzjx.zzb(eCPoint, curve);
            } else {
                throw new GeneralSecurityException("invalid point format");
            }
        } else if (i2 != 2) {
            BigInteger zza2 = zzjx.zza(curve);
            int length2 = bArr.length;
            if (length2 == zza + 1) {
                byte b = bArr[0];
                if (b != 2) {
                    if (b == 3) {
                        z = true;
                    } else {
                        throw new GeneralSecurityException("invalid format");
                    }
                }
                BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, length2));
                if (bigInteger.signum() == -1 || bigInteger.compareTo(zza2) >= 0) {
                    throw new GeneralSecurityException("x is out of range");
                }
                eCPoint = new ECPoint(bigInteger, zzb(bigInteger, z, curve));
            } else {
                throw new GeneralSecurityException("compressed point has wrong length");
            }
        } else {
            int length3 = bArr.length;
            if (length3 == zza + zza) {
                eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, zza)), new BigInteger(1, Arrays.copyOfRange(bArr, zza, length3)));
                zzjx.zzb(eCPoint, curve);
            } else {
                throw new GeneralSecurityException("invalid point size");
            }
        }
        return (ECPublicKey) ((KeyFactory) zzvc.zzg.zza("EC")).generatePublic(new ECPublicKeySpec(eCPoint, eCParameterSpec));
    }

    public static ECParameterSpec zzi(int i) throws NoSuchAlgorithmException {
        int i2 = i - 1;
        if (i2 == 0) {
            return zzjx.zza;
        }
        if (i2 != 1) {
            return zzjx.zzc;
        }
        return zzjx.zzb;
    }
}
