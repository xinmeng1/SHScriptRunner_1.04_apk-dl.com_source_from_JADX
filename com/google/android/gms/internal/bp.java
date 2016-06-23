package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.internal.bq.C0303a;

public final class bp implements C0303a {
    private final bt kB;
    private final ai lh;
    private final Object ls;
    private final Context mContext;
    private final String nC;
    private final long nD;
    private final bl nE;
    private final al nF;
    private final ev nG;
    private bu nH;
    private int nI;

    /* renamed from: com.google.android.gms.internal.bp.1 */
    class C03021 implements Runnable {
        final /* synthetic */ bo nJ;
        final /* synthetic */ bp nK;

        C03021(bp bpVar, bo boVar) {
            this.nK = bpVar;
            this.nJ = boVar;
        }

        public void run() {
            synchronized (this.nK.ls) {
                if (this.nK.nI != -2) {
                    return;
                }
                this.nK.nH = this.nK.aP();
                if (this.nK.nH == null) {
                    this.nK.m2497g(4);
                    return;
                }
                this.nJ.m3490a(this.nK);
                this.nK.m2489a(this.nJ);
            }
        }
    }

    public bp(Context context, String str, bt btVar, bm bmVar, bl blVar, ai aiVar, al alVar, ev evVar) {
        this.ls = new Object();
        this.nI = -2;
        this.mContext = context;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.nC = m2492b(blVar);
        } else {
            this.nC = str;
        }
        this.kB = btVar;
        this.nD = bmVar.ns != -1 ? bmVar.ns : 10000;
        this.nE = blVar;
        this.lh = aiVar;
        this.nF = alVar;
        this.nG = evVar;
    }

    private void m2488a(long j, long j2, long j3, long j4) {
        while (this.nI == -2) {
            m2493b(j, j2, j3, j4);
        }
    }

    private void m2489a(bo boVar) {
        try {
            if (this.nG.sy < 4100000) {
                if (this.nF.mf) {
                    this.nH.m839a(C1057e.m3260h(this.mContext), this.lh, this.nE.nq, boVar);
                } else {
                    this.nH.m841a(C1057e.m3260h(this.mContext), this.nF, this.lh, this.nE.nq, (bv) boVar);
                }
            } else if (this.nF.mf) {
                this.nH.m840a(C1057e.m3260h(this.mContext), this.lh, this.nE.nq, this.nE.nk, (bv) boVar);
            } else {
                this.nH.m842a(C1057e.m3260h(this.mContext), this.nF, this.lh, this.nE.nq, this.nE.nk, boVar);
            }
        } catch (Throwable e) {
            eu.m1017c("Could not request ad from mediation adapter.", e);
            m2497g(5);
        }
    }

    private bu aP() {
        eu.m1012B("Instantiating mediation adapter: " + this.nC);
        try {
            return this.kB.m838m(this.nC);
        } catch (Throwable e) {
            eu.m1015a("Could not instantiate mediation adapter: " + this.nC, e);
            return null;
        }
    }

    private String m2492b(bl blVar) {
        try {
            if (!TextUtils.isEmpty(blVar.no)) {
                if (CustomEvent.class.isAssignableFrom(Class.forName(blVar.no, false, bp.class.getClassLoader()))) {
                    return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
                }
            }
        } catch (ClassNotFoundException e) {
            eu.m1014D("Could not create custom event adapter.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void m2493b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            eu.m1012B("Timed out waiting for adapter.");
            this.nI = 3;
            return;
        }
        try {
            this.ls.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.nI = -1;
        }
    }

    public bq m2496b(long j, long j2) {
        bq bqVar;
        synchronized (this.ls) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            bo boVar = new bo();
            et.sv.post(new C03021(this, boVar));
            m2488a(elapsedRealtime, this.nD, j, j2);
            bqVar = new bq(this.nE, this.nH, this.nC, boVar, this.nI);
        }
        return bqVar;
    }

    public void cancel() {
        synchronized (this.ls) {
            try {
                if (this.nH != null) {
                    this.nH.destroy();
                }
            } catch (Throwable e) {
                eu.m1017c("Could not destroy mediation adapter.", e);
            }
            this.nI = -1;
            this.ls.notify();
        }
    }

    public void m2497g(int i) {
        synchronized (this.ls) {
            this.nI = i;
            this.ls.notify();
        }
    }
}
