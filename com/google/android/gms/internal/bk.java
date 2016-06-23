package com.google.android.gms.internal;

import android.content.Context;

public final class bk {
    private final bt kB;
    private final Object ls;
    private final Context mContext;
    private final ds ne;
    private final bm nf;
    private boolean ng;
    private bp nh;

    /* renamed from: com.google.android.gms.internal.bk.1 */
    class C03011 implements Runnable {
        final /* synthetic */ bq ni;
        final /* synthetic */ bk nj;

        C03011(bk bkVar, bq bqVar) {
            this.nj = bkVar;
            this.ni = bqVar;
        }

        public void run() {
            try {
                this.ni.nN.destroy();
            } catch (Throwable e) {
                eu.m1017c("Could not destroy mediation adapter.", e);
            }
        }
    }

    public bk(Context context, ds dsVar, bt btVar, bm bmVar) {
        this.ls = new Object();
        this.ng = false;
        this.mContext = context;
        this.ne = dsVar;
        this.kB = btVar;
        this.nf = bmVar;
    }

    public bq m833a(long j, long j2) {
        eu.m1019z("Starting mediation.");
        for (bl blVar : this.nf.nr) {
            eu.m1012B("Trying mediation network: " + blVar.nl);
            for (String str : blVar.nm) {
                synchronized (this.ls) {
                    if (this.ng) {
                        bq bqVar = new bq(-1);
                        return bqVar;
                    }
                    this.nh = new bp(this.mContext, str, this.kB, this.nf, blVar, this.ne.pX, this.ne.kT, this.ne.kQ);
                    bqVar = this.nh.m2496b(j, j2);
                    if (bqVar.nL == 0) {
                        eu.m1019z("Adapter succeeded.");
                        return bqVar;
                    } else if (bqVar.nN != null) {
                        et.sv.post(new C03011(this, bqVar));
                    }
                }
            }
        }
        return new bq(1);
    }

    public void cancel() {
        synchronized (this.ls) {
            this.ng = true;
            if (this.nh != null) {
                this.nh.cancel();
            }
        }
    }
}
