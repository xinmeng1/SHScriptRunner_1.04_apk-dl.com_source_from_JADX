package com.google.android.gms.internal;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.h */
public abstract class C0772h implements C0359g {
    protected MotionEvent jO;
    protected DisplayMetrics jP;
    protected C0393m jQ;
    private C0394n jR;

    protected C0772h(Context context, C0393m c0393m, C0394n c0394n) {
        this.jQ = c0393m;
        this.jR = c0394n;
        try {
            this.jP = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.jP = new DisplayMetrics();
            this.jP.density = TextTrackStyle.DEFAULT_FONT_SCALE;
        }
    }

    private String m2634a(Context context, String str, boolean z, boolean z2) {
        try {
            byte[] u;
            synchronized (this) {
                m2635t();
                if (z) {
                    m2648e(context);
                } else if (z2) {
                    m2647d(context);
                } else {
                    m2646c(context);
                }
                u = m2636u();
            }
            return u.length == 0 ? Integer.toString(5) : m2639a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void m2635t() {
        this.jR.reset();
    }

    private byte[] m2636u() throws IOException {
        return this.jR.m1437A();
    }

    public String m2637a(Context context) {
        return m2634a(context, null, false, false);
    }

    public String m2638a(Context context, String str) {
        return m2634a(context, str, true, false);
    }

    String m2639a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            m2635t();
            m2641a(20, 1);
            bArr = m2636u();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        new C0356f().m1051a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m2644a(str, bArr3);
        }
        return this.jQ.m1419a(bArr3, true);
    }

    public void m2640a(int i, int i2, int i3) {
        if (this.jO != null) {
            this.jO.recycle();
        }
        this.jO = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.jP.density, ((float) i2) * this.jP.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void m2641a(int i, long j) throws IOException {
        this.jR.m1438b(i, j);
    }

    protected void m2642a(int i, String str) throws IOException {
        this.jR.m1439b(i, str);
    }

    public void m2643a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.jO != null) {
                this.jO.recycle();
            }
            this.jO = MotionEvent.obtain(motionEvent);
        }
    }

    void m2644a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new lx(str.getBytes("UTF-8")).m1368o(bArr);
    }

    public String m2645b(Context context) {
        return m2634a(context, null, false, true);
    }

    protected abstract void m2646c(Context context);

    protected abstract void m2647d(Context context);

    protected abstract void m2648e(Context context);
}
