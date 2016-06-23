package com.google.android.gms.internal;

import java.util.Map;

public final class dz {
    private ex lN;
    private final Object ls;
    private int pJ;
    private String qB;
    private eb qC;
    public final bc qD;
    public final bc qE;

    /* renamed from: com.google.android.gms.internal.dz.1 */
    class C07401 implements bc {
        final /* synthetic */ dz qF;

        C07401(dz dzVar) {
            this.qF = dzVar;
        }

        public void m2558b(ex exVar, Map<String, String> map) {
            synchronized (this.qF.ls) {
                eb ebVar = new eb(map);
                eu.m1014D("Invalid " + ebVar.getType() + " request error: " + ebVar.by());
                this.qF.pJ = 1;
                this.qF.ls.notify();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.dz.2 */
    class C07412 implements bc {
        final /* synthetic */ dz qF;

        C07412(dz dzVar) {
            this.qF = dzVar;
        }

        public void m2559b(ex exVar, Map<String, String> map) {
            synchronized (this.qF.ls) {
                eb ebVar = new eb(map);
                String url = ebVar.getUrl();
                if (url == null) {
                    eu.m1014D("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    eu.m1013C("Ad request URL modified to " + url.replaceAll("%40mediation_adapters%40", el.m966a(exVar.getContext(), (String) map.get("check_adapters"), this.qF.qB)));
                }
                this.qF.qC = ebVar;
                this.qF.ls.notify();
            }
        }
    }

    public dz(String str) {
        this.ls = new Object();
        this.pJ = -2;
        this.qD = new C07401(this);
        this.qE = new C07412(this);
        this.qB = str;
    }

    public void m928b(ex exVar) {
        synchronized (this.ls) {
            this.lN = exVar;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.eb bx() {
        /*
        r3 = this;
        r1 = r3.ls;
        monitor-enter(r1);
    L_0x0003:
        r0 = r3.qC;	 Catch:{ all -> 0x001f }
        if (r0 != 0) goto L_0x001b;
    L_0x0007:
        r0 = r3.pJ;	 Catch:{ all -> 0x001f }
        r2 = -2;
        if (r0 != r2) goto L_0x001b;
    L_0x000c:
        r0 = r3.ls;	 Catch:{ InterruptedException -> 0x0012 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0012 }
        goto L_0x0003;
    L_0x0012:
        r0 = move-exception;
        r0 = "Ad request service was interrupted.";
        com.google.android.gms.internal.eu.m1014D(r0);	 Catch:{ all -> 0x001f }
        r0 = 0;
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r3.qC;	 Catch:{ all -> 0x001f }
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        goto L_0x001a;
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dz.bx():com.google.android.gms.internal.eb");
    }

    public int getErrorCode() {
        int i;
        synchronized (this.ls) {
            i = this.pJ;
        }
        return i;
    }
}
