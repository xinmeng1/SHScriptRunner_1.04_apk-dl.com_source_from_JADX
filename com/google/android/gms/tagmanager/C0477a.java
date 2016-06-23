package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C0477a {
    private static C0477a aeh;
    private static Object tq;
    private volatile long aec;
    private volatile long aed;
    private volatile long aee;
    private final ij aef;
    private C0476a aeg;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread sf;
    private volatile Info ts;

    /* renamed from: com.google.android.gms.tagmanager.a.2 */
    class C04752 implements Runnable {
        final /* synthetic */ C0477a aei;

        C04752(C0477a c0477a) {
            this.aei = c0477a;
        }

        public void run() {
            this.aei.le();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.a.a */
    public interface C0476a {
        Info lg();
    }

    /* renamed from: com.google.android.gms.tagmanager.a.1 */
    class C09501 implements C0476a {
        final /* synthetic */ C0477a aei;

        C09501(C0477a c0477a) {
            this.aei = c0477a;
        }

        public Info lg() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.aei.mContext);
            } catch (IllegalStateException e) {
                bh.m1645D("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                bh.m1645D("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                bh.m1645D("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                bh.m1645D("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                bh.m1645D("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    static {
        tq = new Object();
    }

    private C0477a(Context context) {
        this(context, null, il.gb());
    }

    C0477a(Context context, C0476a c0476a, ij ijVar) {
        this.aec = 900000;
        this.aed = 30000;
        this.mClosed = false;
        this.aeg = new C09501(this);
        this.aef = ijVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (c0476a != null) {
            this.aeg = c0476a;
        }
        this.sf = new Thread(new C04752(this));
    }

    static C0477a m1617M(Context context) {
        if (aeh == null) {
            synchronized (tq) {
                if (aeh == null) {
                    aeh = new C0477a(context);
                    aeh.start();
                }
            }
        }
        return aeh;
    }

    private void le() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.ts = this.aeg.lg();
                Thread.sleep(this.aec);
            } catch (InterruptedException e) {
                bh.m1643B("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void lf() {
        if (this.aef.currentTimeMillis() - this.aee >= this.aed) {
            interrupt();
            this.aee = this.aef.currentTimeMillis();
        }
    }

    void interrupt() {
        this.sf.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        lf();
        return this.ts == null ? true : this.ts.isLimitAdTrackingEnabled();
    }

    public String ld() {
        lf();
        return this.ts == null ? null : this.ts.getId();
    }

    void start() {
        this.sf.start();
    }
}
