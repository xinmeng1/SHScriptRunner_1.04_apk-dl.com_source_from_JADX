package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

public class da {
    public static boolean m886a(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2, 0))) {
                return true;
            }
            eu.m1011A("Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            eu.m1011A("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            eu.m1011A("Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            eu.m1011A("Signature exception.");
            return false;
        }
    }

    public static boolean m887b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return m886a(m888r(str), str2, str3);
        }
        eu.m1011A("Purchase verification failed: missing data.");
        return false;
    }

    public static PublicKey m888r(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            eu.m1011A("Invalid key specification.");
            throw new IllegalArgumentException(e2);
        }
    }
}
