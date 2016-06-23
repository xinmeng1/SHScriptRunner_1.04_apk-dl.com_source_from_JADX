package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0608c.C0138b;
import com.google.android.gms.analytics.C0608c.C0139c;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.fd;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.s */
class C0615s implements ag, C0138b, C0139c {
    private final Context mContext;
    private C0140d tU;
    private final C0142f tV;
    private boolean tX;
    private volatile long uh;
    private volatile C0156a ui;
    private volatile C0136b uj;
    private C0140d uk;
    private final GoogleAnalytics ul;
    private final Queue<C0159d> um;
    private volatile int un;
    private volatile Timer uo;
    private volatile Timer up;
    private volatile Timer uq;
    private boolean ur;
    private boolean us;
    private boolean ut;
    private C0144i uu;
    private long uv;

    /* renamed from: com.google.android.gms.analytics.s.2 */
    class C01542 implements Runnable {
        final /* synthetic */ C0615s uw;

        C01542(C0615s c0615s) {
            this.uw = c0615s;
        }

        public void run() {
            this.uw.cM();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.3 */
    static /* synthetic */ class C01553 {
        static final /* synthetic */ int[] ux;

        static {
            ux = new int[C0156a.values().length];
            try {
                ux[C0156a.CONNECTED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ux[C0156a.CONNECTED_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ux[C0156a.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ux[C0156a.PENDING_CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                ux[C0156a.PENDING_DISCONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                ux[C0156a.DISCONNECTED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.a */
    private enum C0156a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.s.b */
    private class C0157b extends TimerTask {
        final /* synthetic */ C0615s uw;

        private C0157b(C0615s c0615s) {
            this.uw = c0615s;
        }

        public void run() {
            if (this.uw.ui == C0156a.CONNECTED_SERVICE && this.uw.um.isEmpty() && this.uw.uh + this.uw.uv < this.uw.uu.currentTimeMillis()) {
                aa.m39C("Disconnecting due to inactivity");
                this.uw.bs();
                return;
            }
            this.uw.uq.schedule(new C0157b(this.uw), this.uw.uv);
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.c */
    private class C0158c extends TimerTask {
        final /* synthetic */ C0615s uw;

        private C0158c(C0615s c0615s) {
            this.uw = c0615s;
        }

        public void run() {
            if (this.uw.ui == C0156a.CONNECTING) {
                this.uw.cO();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.d */
    private static class C0159d {
        private final Map<String, String> uG;
        private final long uH;
        private final String uI;
        private final List<fd> uJ;

        public C0159d(Map<String, String> map, long j, String str, List<fd> list) {
            this.uG = map;
            this.uH = j;
            this.uI = str;
            this.uJ = list;
        }

        public Map<String, String> cR() {
            return this.uG;
        }

        public long cS() {
            return this.uH;
        }

        public List<fd> cT() {
            return this.uJ;
        }

        public String getPath() {
            return this.uI;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.uI);
            if (this.uG != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.uG.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.e */
    private class C0160e extends TimerTask {
        final /* synthetic */ C0615s uw;

        private C0160e(C0615s c0615s) {
            this.uw = c0615s;
        }

        public void run() {
            this.uw.cP();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.1 */
    class C06141 implements C0144i {
        final /* synthetic */ C0615s uw;

        C06141(C0615s c0615s) {
            this.uw = c0615s;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    C0615s(Context context, C0142f c0142f) {
        this(context, c0142f, null, GoogleAnalytics.getInstance(context));
    }

    C0615s(Context context, C0142f c0142f, C0140d c0140d, GoogleAnalytics googleAnalytics) {
        this.um = new ConcurrentLinkedQueue();
        this.uv = 300000;
        this.uk = c0140d;
        this.mContext = context;
        this.tV = c0142f;
        this.ul = googleAnalytics;
        this.uu = new C06141(this);
        this.un = 0;
        this.ui = C0156a.DISCONNECTED;
    }

    private Timer m1926a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void bs() {
        if (this.uj != null && this.ui == C0156a.CONNECTED_SERVICE) {
            this.ui = C0156a.PENDING_DISCONNECT;
            this.uj.disconnect();
        }
    }

    private void cK() {
        this.uo = m1926a(this.uo);
        this.up = m1926a(this.up);
        this.uq = m1926a(this.uq);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void cM() {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r3 = r8.tV;	 Catch:{ all -> 0x0074 }
        r3 = r3.getThread();	 Catch:{ all -> 0x0074 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0021;
    L_0x0011:
        r2 = r8.tV;	 Catch:{ all -> 0x0074 }
        r2 = r2.ct();	 Catch:{ all -> 0x0074 }
        r3 = new com.google.android.gms.analytics.s$2;	 Catch:{ all -> 0x0074 }
        r3.<init>(r8);	 Catch:{ all -> 0x0074 }
        r2.add(r3);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r8);
        return;
    L_0x0021:
        r2 = r8.ur;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x0028;
    L_0x0025:
        r8.cl();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r2 = com.google.android.gms.analytics.C0615s.C01553.ux;	 Catch:{ all -> 0x0074 }
        r3 = r8.ui;	 Catch:{ all -> 0x0074 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0074 }
        r2 = r2[r3];	 Catch:{ all -> 0x0074 }
        switch(r2) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r2 = r8.um;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0077;
    L_0x003e:
        r2 = r8.um;	 Catch:{ all -> 0x0074 }
        r2 = r2.poll();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.android.gms.analytics.C0615s.C0159d) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to store  ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m39C(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.tU;	 Catch:{ all -> 0x0074 }
        r3 = r7.cR();	 Catch:{ all -> 0x0074 }
        r4 = r7.cS();	 Catch:{ all -> 0x0074 }
        r6 = r7.getPath();	 Catch:{ all -> 0x0074 }
        r7 = r7.cT();	 Catch:{ all -> 0x0074 }
        r2.m57a(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x0077:
        r2 = r8.tX;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x001f;
    L_0x007b:
        r8.cN();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r2 = r8.um;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00d0;
    L_0x0087:
        r2 = r8.um;	 Catch:{ all -> 0x0074 }
        r2 = r2.peek();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.android.gms.analytics.C0615s.C0159d) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to service   ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m39C(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.ul;	 Catch:{ all -> 0x0074 }
        r2 = r2.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00ca;
    L_0x00af:
        r2 = r8.uj;	 Catch:{ all -> 0x0074 }
        r3 = r7.cR();	 Catch:{ all -> 0x0074 }
        r4 = r7.cS();	 Catch:{ all -> 0x0074 }
        r6 = r7.getPath();	 Catch:{ all -> 0x0074 }
        r7 = r7.cT();	 Catch:{ all -> 0x0074 }
        r2.m55a(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r2 = r8.um;	 Catch:{ all -> 0x0074 }
        r2.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r2 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.aa.m39C(r2);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r2 = r8.uu;	 Catch:{ all -> 0x0074 }
        r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0074 }
        r8.uh = r2;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r2 = "Need to reconnect";
        com.google.android.gms.analytics.aa.m39C(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.um;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x001f;
    L_0x00e7:
        r8.cP();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.s.cM():void");
    }

    private void cN() {
        this.tU.cq();
        this.tX = false;
    }

    private synchronized void cO() {
        if (this.ui != C0156a.CONNECTED_LOCAL) {
            cK();
            aa.m39C("falling back to local store");
            if (this.uk != null) {
                this.tU = this.uk;
            } else {
                C0613r cE = C0613r.cE();
                cE.m1923a(this.mContext, this.tV);
                this.tU = cE.cH();
            }
            this.ui = C0156a.CONNECTED_LOCAL;
            cM();
        }
    }

    private synchronized void cP() {
        if (this.ut || this.uj == null || this.ui == C0156a.CONNECTED_LOCAL) {
            aa.m40D("client not initialized.");
            cO();
        } else {
            try {
                this.un++;
                m1926a(this.up);
                this.ui = C0156a.CONNECTING;
                this.up = new Timer("Failed Connect");
                this.up.schedule(new C0158c(), 3000);
                aa.m39C("connecting to Analytics service");
                this.uj.connect();
            } catch (SecurityException e) {
                aa.m40D("security exception on connectToService");
                cO();
            }
        }
    }

    private void cQ() {
        this.uo = m1926a(this.uo);
        this.uo = new Timer("Service Reconnect");
        this.uo.schedule(new C0160e(), 5000);
    }

    public synchronized void m1937a(int i, Intent intent) {
        this.ui = C0156a.PENDING_CONNECTION;
        if (this.un < 2) {
            aa.m40D("Service unavailable (code=" + i + "), will retry.");
            cQ();
        } else {
            aa.m40D("Service unavailable (code=" + i + "), using local store.");
            cO();
        }
    }

    public void m1938b(Map<String, String> map, long j, String str, List<fd> list) {
        aa.m39C("putHit called");
        this.um.add(new C0159d(map, j, str, list));
        cM();
    }

    public void cL() {
        if (this.uj == null) {
            this.uj = new C0608c(this.mContext, this, this);
            cP();
        }
    }

    public void cl() {
        aa.m39C("clearHits called");
        this.um.clear();
        switch (C01553.ux[this.ui.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                this.tU.m58l(0);
                this.ur = false;
            case DataEvent.TYPE_DELETED /*2*/:
                this.uj.cl();
                this.ur = false;
            default:
                this.ur = true;
        }
    }

    public void cq() {
        switch (C01553.ux[this.ui.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                cN();
            case DataEvent.TYPE_DELETED /*2*/:
            default:
                this.tX = true;
        }
    }

    public synchronized void cs() {
        if (!this.ut) {
            aa.m39C("setForceLocalDispatch called.");
            this.ut = true;
            switch (C01553.ux[this.ui.ordinal()]) {
                case DataEvent.TYPE_CHANGED /*1*/:
                case DetectedActivity.UNKNOWN /*4*/:
                case DetectedActivity.TILTING /*5*/:
                case Quest.STATE_FAILED /*6*/:
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bs();
                    break;
                case DetectedActivity.STILL /*3*/:
                    this.us = true;
                    break;
                default:
                    break;
            }
        }
    }

    public synchronized void onConnected() {
        this.up = m1926a(this.up);
        this.un = 0;
        aa.m39C("Connected to service");
        this.ui = C0156a.CONNECTED_SERVICE;
        if (this.us) {
            bs();
            this.us = false;
        } else {
            cM();
            this.uq = m1926a(this.uq);
            this.uq = new Timer("disconnect check");
            this.uq.schedule(new C0157b(), this.uv);
        }
    }

    public synchronized void onDisconnected() {
        if (this.ui == C0156a.PENDING_DISCONNECT) {
            aa.m39C("Disconnected from service");
            cK();
            this.ui = C0156a.DISCONNECTED;
        } else {
            aa.m39C("Unexpected disconnect.");
            this.ui = C0156a.PENDING_CONNECTION;
            if (this.un < 2) {
                cQ();
            } else {
                cO();
            }
        }
    }
}
