package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0181a.C0629a;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0304c.C1104f;
import com.google.android.gms.internal.C0304c.C1108j;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import com.google.android.gms.internal.le.C1141a;
import com.google.android.gms.tagmanager.C1167n.C0509a;
import com.google.android.gms.tagmanager.bg.C0482a;
import com.google.android.gms.tagmanager.cd.C0484a;
import com.google.android.gms.tagmanager.cq.C0492c;

/* renamed from: com.google.android.gms.tagmanager.o */
class C1168o extends C0629a<ContainerHolder> {
    private final Looper DF;
    private final TagManager aeF;
    private final C0975d aeI;
    private final cf aeJ;
    private final int aeK;
    private C0977f aeL;
    private volatile C1167n aeM;
    private volatile boolean aeN;
    private C1108j aeO;
    private String aeP;
    private C0976e aeQ;
    private C0511a aeR;
    private final ij aef;
    private final String aet;
    private long aey;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.o.a */
    interface C0511a {
        boolean m1744b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.1 */
    class C09711 implements C0509a {
        final /* synthetic */ C1168o aeS;

        C09711(C1168o c1168o) {
            this.aeS = c1168o;
        }

        public void bJ(String str) {
            this.aeS.bJ(str);
        }

        public String lo() {
            return this.aeS.lo();
        }

        public void lq() {
            bh.m1645D("Refresh ignored: container loaded as default only.");
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.2 */
    class C09722 implements C0511a {
        final /* synthetic */ C1168o aeS;
        final /* synthetic */ boolean aeT;

        C09722(C1168o c1168o, boolean z) {
            this.aeS = c1168o;
            this.aeT = z;
        }

        public boolean m3029b(Container container) {
            return this.aeT ? container.getLastRefreshTime() + 43200000 >= this.aeS.aef.currentTimeMillis() : !container.isDefault();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.b */
    private class C0973b implements bg<C1141a> {
        final /* synthetic */ C1168o aeS;

        private C0973b(C1168o c1168o) {
            this.aeS = c1168o;
        }

        public void m3030a(C1141a c1141a) {
            C1108j c1108j;
            if (c1141a.aiH != null) {
                c1108j = c1141a.aiH;
            } else {
                C1104f c1104f = c1141a.fK;
                c1108j = new C1108j();
                c1108j.fK = c1104f;
                c1108j.fJ = null;
                c1108j.fL = c1104f.fg;
            }
            this.aeS.m3837a(c1108j, c1141a.aiG, true);
        }

        public void m3031a(C0482a c0482a) {
            if (!this.aeS.aeN) {
                this.aeS.m3847w(0);
            }
        }

        public /* synthetic */ void m3032i(Object obj) {
            m3030a((C1141a) obj);
        }

        public void lv() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.c */
    private class C0974c implements bg<C1108j> {
        final /* synthetic */ C1168o aeS;

        private C0974c(C1168o c1168o) {
            this.aeS = c1168o;
        }

        public void m3033a(C0482a c0482a) {
            if (this.aeS.aeM != null) {
                this.aeS.m1984b(this.aeS.aeM);
            } else {
                this.aeS.m1984b(this.aeS.ap(Status.Eq));
            }
            this.aeS.m3847w(3600000);
        }

        public void m3034b(C1108j c1108j) {
            synchronized (this.aeS) {
                if (c1108j.fK == null) {
                    if (this.aeS.aeO.fK == null) {
                        bh.m1642A("Current resource is null; network resource is also null");
                        this.aeS.m3847w(3600000);
                        return;
                    }
                    c1108j.fK = this.aeS.aeO.fK;
                }
                this.aeS.m3837a(c1108j, this.aeS.aef.currentTimeMillis(), false);
                bh.m1644C("setting refresh time to current time: " + this.aeS.aey);
                if (!this.aeS.lu()) {
                    this.aeS.m3836a(c1108j);
                }
            }
        }

        public /* synthetic */ void m3035i(Object obj) {
            m3034b((C1108j) obj);
        }

        public void lv() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.d */
    private class C0975d implements C0509a {
        final /* synthetic */ C1168o aeS;

        private C0975d(C1168o c1168o) {
            this.aeS = c1168o;
        }

        public void bJ(String str) {
            this.aeS.bJ(str);
        }

        public String lo() {
            return this.aeS.lo();
        }

        public void lq() {
            if (this.aeS.aeJ.m1662do()) {
                this.aeS.m3847w(0);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.e */
    interface C0976e extends Releasable {
        void m3036a(bg<C1108j> bgVar);

        void bM(String str);

        void m3037e(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.f */
    interface C0977f extends Releasable {
        void m3038a(bg<C1141a> bgVar);

        void m3039b(C1141a c1141a);

        C0492c dn(int i);

        void lw();
    }

    C1168o(Context context, TagManager tagManager, Looper looper, String str, int i, C0977f c0977f, C0976e c0976e, ij ijVar, cf cfVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.aeF = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.DF = looper;
        this.aet = str;
        this.aeK = i;
        this.aeL = c0977f;
        this.aeQ = c0976e;
        this.aeI = new C0975d();
        this.aeO = new C1108j();
        this.aef = ijVar;
        this.aeJ = cfVar;
        if (lu()) {
            bJ(cd.md().mf());
        }
    }

    public C1168o(Context context, TagManager tagManager, Looper looper, String str, int i, C0512r c0512r) {
        this(context, tagManager, looper, str, i, new cp(context, str), new co(context, str, c0512r), il.gb(), new bf(30, 900000, 5000, "refreshing", il.gb()));
    }

    private void m3834H(boolean z) {
        this.aeL.m3038a(new C0973b());
        this.aeQ.m3036a(new C0974c());
        C0492c dn = this.aeL.dn(this.aeK);
        if (dn != null) {
            this.aeM = new C1167n(this.aeF, this.DF, new Container(this.mContext, this.aeF.getDataLayer(), this.aet, 0, dn), this.aeI);
        }
        this.aeR = new C09722(this, z);
        if (lu()) {
            this.aeQ.m3037e(0, "");
        } else {
            this.aeL.lw();
        }
    }

    private synchronized void m3836a(C1108j c1108j) {
        if (this.aeL != null) {
            C1141a c1141a = new C1141a();
            c1141a.aiG = this.aey;
            c1141a.fK = new C1104f();
            c1141a.aiH = c1108j;
            this.aeL.m3039b(c1141a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m3837a(com.google.android.gms.internal.C0304c.C1108j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.aeN;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.aeM;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.aeO = r9;	 Catch:{ all -> 0x006a }
        r8.aey = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.aey;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.aef;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.m3847w(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.aeF;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.aet;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.aeM;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.aeF;	 Catch:{ all -> 0x006a }
        r3 = r8.DF;	 Catch:{ all -> 0x006a }
        r4 = r8.aeI;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.aeM = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.aeR;	 Catch:{ all -> 0x006a }
        r0 = r1.m1744b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.aeM;	 Catch:{ all -> 0x006a }
        r8.m1984b(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.aeM;	 Catch:{ all -> 0x006a }
        r1.m3833a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean lu() {
        cd md = cd.md();
        return (md.me() == C0484a.CONTAINER || md.me() == C0484a.CONTAINER_DEBUG) && this.aet.equals(md.getContainerId());
    }

    private synchronized void m3847w(long j) {
        if (this.aeQ == null) {
            bh.m1645D("Refresh requested, but no network load scheduler.");
        } else {
            this.aeQ.m3037e(j, this.aeO.fL);
        }
    }

    protected ContainerHolder ap(Status status) {
        if (this.aeM != null) {
            return this.aeM;
        }
        if (status == Status.Eq) {
            bh.m1642A("timer expired: setting result to failure");
        }
        return new C1167n(status);
    }

    synchronized void bJ(String str) {
        this.aeP = str;
        if (this.aeQ != null) {
            this.aeQ.bM(str);
        }
    }

    protected /* synthetic */ Result m3848c(Status status) {
        return ap(status);
    }

    synchronized String lo() {
        return this.aeP;
    }

    public void lr() {
        C0492c dn = this.aeL.dn(this.aeK);
        if (dn != null) {
            m1984b(new C1167n(this.aeF, this.DF, new Container(this.mContext, this.aeF.getDataLayer(), this.aet, 0, dn), new C09711(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.m1642A(str);
            m1984b(ap(new Status(10, str, null)));
        }
        this.aeQ = null;
        this.aeL = null;
    }

    public void ls() {
        m3834H(false);
    }

    public void lt() {
        m3834H(true);
    }
}
