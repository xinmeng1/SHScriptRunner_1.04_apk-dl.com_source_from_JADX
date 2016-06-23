package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.dm.C0325a;
import com.google.android.gms.internal.dp.C0333a;
import com.google.android.gms.internal.ds.C0334a;
import com.google.android.gms.internal.ey.C0346a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import org.json.JSONException;
import org.json.JSONObject;

public class dn extends em implements C0333a, C0346a {
    private final bt kB;
    private final ex lN;
    private final Object ls;
    private final Context mContext;
    private bm nf;
    private final C0387k pA;
    private em pB;
    private du pC;
    private boolean pD;
    private bk pE;
    private bq pF;
    private final C0325a px;
    private final Object py;
    private final C0334a pz;

    /* renamed from: com.google.android.gms.internal.dn.1 */
    class C03261 implements Runnable {
        final /* synthetic */ dn pG;

        C03261(dn dnVar) {
            this.pG = dnVar;
        }

        public void run() {
            this.pG.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.dn.2 */
    class C03272 implements Runnable {
        final /* synthetic */ dn pG;
        final /* synthetic */ ef pH;

        C03272(dn dnVar, ef efVar) {
            this.pG = dnVar;
            this.pH = efVar;
        }

        public void run() {
            synchronized (this.pG.ls) {
                this.pG.px.m892a(this.pH);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.dn.3 */
    class C03283 implements Runnable {
        final /* synthetic */ dn pG;

        C03283(dn dnVar) {
            this.pG = dnVar;
        }

        public void run() {
            synchronized (this.pG.ls) {
                if (this.pG.pC.errorCode != -2) {
                    return;
                }
                this.pG.lN.cb().m1038a(this.pG);
                if (this.pG.pC.errorCode == -3) {
                    eu.m1013C("Loading URL in WebView: " + this.pG.pC.oA);
                    this.pG.lN.loadUrl(this.pG.pC.oA);
                } else {
                    eu.m1013C("Loading HTML in WebView.");
                    this.pG.lN.loadDataWithBaseURL(eo.m991v(this.pG.pC.oA), this.pG.pC.qe, "text/html", "UTF-8", null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.dn.4 */
    class C03294 implements Runnable {
        final /* synthetic */ dn pG;
        final /* synthetic */ C0332do pI;

        C03294(dn dnVar, C0332do c0332do) {
            this.pG = dnVar;
            this.pI = c0332do;
        }

        public void run() {
            synchronized (this.pG.ls) {
                if (this.pG.pC.errorCode != -2) {
                    return;
                }
                this.pG.lN.cb().m1038a(this.pG);
                this.pI.m904b(this.pG.pC);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.dn.a */
    private static final class C0330a extends Exception {
        private final int pJ;

        public C0330a(String str, int i) {
            super(str);
            this.pJ = i;
        }

        public int getErrorCode() {
            return this.pJ;
        }
    }

    public dn(Context context, C0334a c0334a, C0387k c0387k, ex exVar, bt btVar, C0325a c0325a) {
        this.py = new Object();
        this.ls = new Object();
        this.pD = false;
        this.kB = btVar;
        this.px = c0325a;
        this.lN = exVar;
        this.mContext = context;
        this.pz = c0334a;
        this.pA = c0387k;
    }

    private al m2541a(ds dsVar) throws C0330a {
        if (this.pC.qj == null) {
            throw new C0330a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.pC.qj.split("x");
        if (split.length != 2) {
            throw new C0330a("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (al alVar : dsVar.kT.mg) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = alVar.width == -1 ? (int) (((float) alVar.widthPixels) / f) : alVar.width;
                int i2 = alVar.height == -2 ? (int) (((float) alVar.heightPixels) / f) : alVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new al(alVar, dsVar.kT.mg);
                }
            }
            throw new C0330a("The ad size from the ad response was not one of the requested sizes: " + this.pC.qj, 0);
        } catch (NumberFormatException e) {
            throw new C0330a("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
        }
    }

    private void m2543a(ds dsVar, long j) throws C0330a {
        synchronized (this.py) {
            this.pE = new bk(this.mContext, dsVar, this.kB, this.nf);
        }
        this.pF = this.pE.m833a(j, 60000);
        switch (this.pF.nL) {
            case DetectedActivity.IN_VEHICLE /*0*/:
            case DataEvent.TYPE_CHANGED /*1*/:
                throw new C0330a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0330a("Unexpected mediation result: " + this.pF.nL, 0);
        }
    }

    private void bn() throws C0330a {
        if (this.pC.errorCode != -3) {
            if (TextUtils.isEmpty(this.pC.qe)) {
                throw new C0330a("No fill from ad server.", 3);
            } else if (this.pC.qg) {
                try {
                    this.nf = new bm(this.pC.qe);
                } catch (JSONException e) {
                    throw new C0330a("Could not parse mediation config: " + this.pC.qe, 0);
                }
            }
        }
    }

    private boolean m2546c(long j) throws C0330a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.ls.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0330a("Ad request cancelled.", -1);
        }
    }

    private void m2548e(long j) throws C0330a {
        et.sv.post(new C03283(this));
        m2550h(j);
    }

    private void m2549g(long j) throws C0330a {
        while (m2546c(j)) {
            if (this.pC != null) {
                synchronized (this.py) {
                    this.pB = null;
                }
                if (this.pC.errorCode != -2 && this.pC.errorCode != -3) {
                    throw new C0330a("There was a problem getting an ad response. ErrorCode: " + this.pC.errorCode, this.pC.errorCode);
                }
                return;
            }
        }
        throw new C0330a("Timed out waiting for ad response.", 2);
    }

    private void m2550h(long j) throws C0330a {
        while (m2546c(j)) {
            if (this.pD) {
                return;
            }
        }
        throw new C0330a("Timed out waiting for WebView to finish loading.", 2);
    }

    public void m2551a(du duVar) {
        synchronized (this.ls) {
            eu.m1019z("Received ad response.");
            this.pC = duVar;
            this.ls.notify();
        }
    }

    public void m2552a(ex exVar) {
        synchronized (this.ls) {
            eu.m1019z("WebView finished loading.");
            this.pD = true;
            this.ls.notify();
        }
    }

    public void bh() {
        synchronized (this.ls) {
            long j;
            al alVar;
            eu.m1019z("AdLoaderBackgroundTask started.");
            C0359g z = this.pA.m1324z();
            ds dsVar = new ds(this.pz, z.m1092b(this.mContext), z.m1088a(this.mContext));
            al alVar2 = null;
            int i = -2;
            long j2 = -1;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                em a = dp.m906a(this.mContext, dsVar, this);
                synchronized (this.py) {
                    this.pB = a;
                    if (this.pB == null) {
                        throw new C0330a("Could not start the ad request service.", 0);
                    }
                }
                m2549g(elapsedRealtime);
                j2 = SystemClock.elapsedRealtime();
                bn();
                if (dsVar.kT.mg != null) {
                    alVar2 = m2541a(dsVar);
                }
                if (this.pC.qg) {
                    m2543a(dsVar, elapsedRealtime);
                } else if (this.pC.qm) {
                    m2553f(elapsedRealtime);
                } else {
                    m2548e(elapsedRealtime);
                }
                j = j2;
                alVar = alVar2;
            } catch (C0330a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    eu.m1012B(e.getMessage());
                } else {
                    eu.m1014D(e.getMessage());
                }
                if (this.pC == null) {
                    this.pC = new du(i);
                } else {
                    this.pC = new du(i, this.pC.nx);
                }
                et.sv.post(new C03261(this));
                j = j2;
                alVar = alVar2;
            }
            if (!TextUtils.isEmpty(this.pC.qo)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.pC.qo);
                } catch (Throwable e2) {
                    eu.m1016b("Error parsing the JSON for Active View.", e2);
                }
                et.sv.post(new C03272(this, new ef(dsVar.pX, this.lN, this.pC.nt, i, this.pC.nu, this.pC.qi, this.pC.orientation, this.pC.nx, dsVar.qa, this.pC.qg, this.pF == null ? this.pF.nM : null, this.pF == null ? this.pF.nN : null, this.pF == null ? this.pF.nO : null, this.nf, this.pF == null ? this.pF.nP : null, this.pC.qh, alVar, this.pC.qf, j, this.pC.qk, this.pC.ql, r29)));
            }
            JSONObject jSONObject2 = null;
            if (this.pF == null) {
            }
            if (this.pF == null) {
            }
            if (this.pF == null) {
            }
            if (this.pF == null) {
            }
            et.sv.post(new C03272(this, new ef(dsVar.pX, this.lN, this.pC.nt, i, this.pC.nu, this.pC.qi, this.pC.orientation, this.pC.nx, dsVar.qa, this.pC.qg, this.pF == null ? this.pF.nM : null, this.pF == null ? this.pF.nN : null, this.pF == null ? this.pF.nO : null, this.nf, this.pF == null ? this.pF.nP : null, this.pC.qh, alVar, this.pC.qf, j, this.pC.qk, this.pC.ql, jSONObject2)));
        }
    }

    protected void m2553f(long j) throws C0330a {
        int i;
        int i2;
        al V = this.lN.m1025V();
        if (V.mf) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = V.widthPixels;
            i2 = V.heightPixels;
        }
        C0332do c0332do = new C0332do(this, this.lN, i, i2);
        et.sv.post(new C03294(this, c0332do));
        m2550h(j);
        if (c0332do.bq()) {
            eu.m1019z("Ad-Network indicated no fill with passback URL.");
            throw new C0330a("AdNetwork sent passback url", 3);
        } else if (!c0332do.br()) {
            throw new C0330a("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        synchronized (this.py) {
            if (this.pB != null) {
                this.pB.cancel();
            }
            this.lN.stopLoading();
            eo.m975a(this.lN);
            if (this.pE != null) {
                this.pE.cancel();
            }
        }
    }
}
