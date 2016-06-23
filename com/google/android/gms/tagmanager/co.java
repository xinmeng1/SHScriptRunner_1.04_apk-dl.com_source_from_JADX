package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0304c.C1108j;
import com.google.android.gms.tagmanager.C1168o.C0976e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class co implements C0976e {
    private String aeP;
    private final String aet;
    private bg<C1108j> agN;
    private C0512r agO;
    private final ScheduledExecutorService agQ;
    private final C0485a agR;
    private ScheduledFuture<?> agS;
    private boolean mClosed;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.co.a */
    interface C0485a {
        cn m1668a(C0512r c0512r);
    }

    /* renamed from: com.google.android.gms.tagmanager.co.b */
    interface C0486b {
        ScheduledExecutorService mk();
    }

    /* renamed from: com.google.android.gms.tagmanager.co.1 */
    class C09551 implements C0486b {
        final /* synthetic */ co agT;

        C09551(co coVar) {
            this.agT = coVar;
        }

        public ScheduledExecutorService mk() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.co.2 */
    class C09562 implements C0485a {
        final /* synthetic */ co agT;

        C09562(co coVar) {
            this.agT = coVar;
        }

        public cn m2996a(C0512r c0512r) {
            return new cn(this.agT.mContext, this.agT.aet, c0512r);
        }
    }

    public co(Context context, String str, C0512r c0512r) {
        this(context, str, c0512r, null, null);
    }

    co(Context context, String str, C0512r c0512r, C0486b c0486b, C0485a c0485a) {
        this.agO = c0512r;
        this.mContext = context;
        this.aet = str;
        if (c0486b == null) {
            c0486b = new C09551(this);
        }
        this.agQ = c0486b.mk();
        if (c0485a == null) {
            this.agR = new C09562(this);
        } else {
            this.agR = c0485a;
        }
    }

    private cn cc(String str) {
        cn a = this.agR.m1668a(this.agO);
        a.m1667a(this.agN);
        a.bM(this.aeP);
        a.cb(str);
        return a;
    }

    private synchronized void mj() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void m3815a(bg<C1108j> bgVar) {
        mj();
        this.agN = bgVar;
    }

    public synchronized void bM(String str) {
        mj();
        this.aeP = str;
    }

    public synchronized void m3816e(long j, String str) {
        bh.m1644C("loadAfterDelay: containerId=" + this.aet + " delay=" + j);
        mj();
        if (this.agN == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.agS != null) {
            this.agS.cancel(false);
        }
        this.agS = this.agQ.schedule(cc(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        mj();
        if (this.agS != null) {
            this.agS.cancel(false);
        }
        this.agQ.shutdown();
        this.mClosed = true;
    }
}
