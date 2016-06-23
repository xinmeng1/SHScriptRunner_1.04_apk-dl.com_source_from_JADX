package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.y */
public final class C0407y {
    private final C0406a lf;
    private final Runnable lg;
    private ai lh;
    private boolean li;
    private boolean lj;
    private long lk;

    /* renamed from: com.google.android.gms.internal.y.1 */
    class C04051 implements Runnable {
        private final WeakReference<C1146u> ll;
        final /* synthetic */ C1146u lm;
        final /* synthetic */ C0407y ln;

        C04051(C0407y c0407y, C1146u c1146u) {
            this.ln = c0407y;
            this.lm = c1146u;
            this.ll = new WeakReference(this.lm);
        }

        public void run() {
            this.ln.li = false;
            C1146u c1146u = (C1146u) this.ll.get();
            if (c1146u != null) {
                c1146u.m3776b(this.ln.lh);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.y.a */
    public static class C0406a {
        private final Handler mHandler;

        public C0406a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public C0407y(C1146u c1146u) {
        this(c1146u, new C0406a(et.sv));
    }

    C0407y(C1146u c1146u, C0406a c0406a) {
        this.li = false;
        this.lj = false;
        this.lk = 0;
        this.lf = c0406a;
        this.lg = new C04051(this, c1146u);
    }

    public void m1472a(ai aiVar, long j) {
        if (this.li) {
            eu.m1014D("An ad refresh is already scheduled.");
            return;
        }
        this.lh = aiVar;
        this.li = true;
        this.lk = j;
        if (!this.lj) {
            eu.m1012B("Scheduling ad refresh " + j + " milliseconds from now.");
            this.lf.postDelayed(this.lg, j);
        }
    }

    public void cancel() {
        this.li = false;
        this.lf.removeCallbacks(this.lg);
    }

    public void m1473d(ai aiVar) {
        m1472a(aiVar, 60000);
    }

    public void pause() {
        this.lj = true;
        if (this.li) {
            this.lf.removeCallbacks(this.lg);
        }
    }

    public void resume() {
        this.lj = false;
        if (this.li) {
            this.li = false;
            m1472a(this.lh, this.lk);
        }
    }
}
