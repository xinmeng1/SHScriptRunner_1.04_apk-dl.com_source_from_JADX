package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.o */
public class C0396o {
    private final C0393m jQ;
    private final SecureRandom kl;

    /* renamed from: com.google.android.gms.internal.o.a */
    public class C0395a extends Exception {
        final /* synthetic */ C0396o km;

        public C0395a(C0396o c0396o) {
            this.km = c0396o;
        }

        public C0395a(C0396o c0396o, Throwable th) {
            this.km = c0396o;
            super(th);
        }
    }

    public C0396o(C0393m c0393m, SecureRandom secureRandom) {
        this.jQ = c0393m;
        this.kl = secureRandom;
    }

    static void m1440c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m1441b(String str) throws C0395a {
        try {
            byte[] a = this.jQ.m1420a(str, false);
            if (a.length != 32) {
                throw new C0395a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C0396o.m1440c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0395a(this, e);
        }
    }

    public byte[] m1442c(byte[] bArr, String str) throws C0395a {
        if (bArr.length != 16) {
            throw new C0395a(this);
        }
        try {
            byte[] a = this.jQ.m1420a(str, false);
            if (a.length <= 16) {
                throw new C0395a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C0395a(this, e);
        } catch (Throwable e2) {
            throw new C0395a(this, e2);
        } catch (Throwable e22) {
            throw new C0395a(this, e22);
        } catch (Throwable e222) {
            throw new C0395a(this, e222);
        } catch (Throwable e2222) {
            throw new C0395a(this, e2222);
        } catch (Throwable e22222) {
            throw new C0395a(this, e22222);
        } catch (Throwable e222222) {
            throw new C0395a(this, e222222);
        }
    }
}
