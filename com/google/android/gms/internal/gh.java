package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.gl.C0769a;
import com.google.android.gms.internal.gm.C0770a;
import com.google.android.gms.internal.hb.C1119e;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class gh extends hb<gl> {
    private static final gn BG;
    private static final Object Ca;
    private static final Object Cb;
    private double AP;
    private boolean AQ;
    private final Listener Ae;
    private ApplicationMetadata BH;
    private final CastDevice BI;
    private final gm BJ;
    private final Map<String, MessageReceivedCallback> BK;
    private final long BL;
    private String BM;
    private boolean BN;
    private boolean BO;
    private boolean BP;
    private AtomicBoolean BQ;
    private int BR;
    private final AtomicLong BS;
    private String BT;
    private String BU;
    private Bundle BV;
    private Map<Long, C0180d<Status>> BW;
    private C1118b BX;
    private C0180d<ApplicationConnectionResult> BY;
    private C0180d<Status> BZ;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.gh.1 */
    class C11161 extends C0770a {
        final /* synthetic */ gh Cc;

        /* renamed from: com.google.android.gms.internal.gh.1.1 */
        class C03601 implements Runnable {
            final /* synthetic */ int Cd;
            final /* synthetic */ C11161 Ce;

            C03601(C11161 c11161, int i) {
                this.Ce = c11161;
                this.Cd = i;
            }

            public void run() {
                if (this.Ce.Cc.Ae != null) {
                    this.Ce.Cc.Ae.onApplicationDisconnected(this.Cd);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.gh.1.2 */
        class C03612 implements Runnable {
            final /* synthetic */ C11161 Ce;
            final /* synthetic */ gj Cf;

            C03612(C11161 c11161, gj gjVar) {
                this.Ce = c11161;
                this.Cf = gjVar;
            }

            public void run() {
                this.Ce.Cc.m3631a(this.Cf);
            }
        }

        /* renamed from: com.google.android.gms.internal.gh.1.3 */
        class C03623 implements Runnable {
            final /* synthetic */ C11161 Ce;
            final /* synthetic */ ge Cg;

            C03623(C11161 c11161, ge geVar) {
                this.Ce = c11161;
                this.Cg = geVar;
            }

            public void run() {
                this.Ce.Cc.m3628a(this.Cg);
            }
        }

        /* renamed from: com.google.android.gms.internal.gh.1.4 */
        class C03634 implements Runnable {
            final /* synthetic */ C11161 Ce;
            final /* synthetic */ String Ch;
            final /* synthetic */ String zU;

            C03634(C11161 c11161, String str, String str2) {
                this.Ce = c11161;
                this.zU = str;
                this.Ch = str2;
            }

            public void run() {
                synchronized (this.Ce.Cc.BK) {
                    MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.Ce.Cc.BK.get(this.zU);
                }
                if (messageReceivedCallback != null) {
                    messageReceivedCallback.onMessageReceived(this.Ce.Cc.BI, this.zU, this.Ch);
                    return;
                }
                gh.BG.m1139b("Discarded message for unknown namespace '%s'", this.zU);
            }
        }

        C11161(gh ghVar) {
            this.Cc = ghVar;
        }

        private boolean m3611X(int i) {
            synchronized (gh.Cb) {
                if (this.Cc.BZ != null) {
                    this.Cc.BZ.m154a(new Status(i));
                    this.Cc.BZ = null;
                    return true;
                }
                return false;
            }
        }

        private void m3612b(long j, int i) {
            synchronized (this.Cc.BW) {
                C0180d c0180d = (C0180d) this.Cc.BW.remove(Long.valueOf(j));
            }
            if (c0180d != null) {
                c0180d.m154a(new Status(i));
            }
        }

        public void m3613T(int i) {
            gh.BG.m1139b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            this.Cc.BP = false;
            this.Cc.BQ.set(false);
            this.Cc.BH = null;
            if (i != 0) {
                this.Cc.an(2);
            }
        }

        public void m3614U(int i) {
            synchronized (gh.Ca) {
                if (this.Cc.BY != null) {
                    this.Cc.BY.m154a(new C1117a(new Status(i)));
                    this.Cc.BY = null;
                }
            }
        }

        public void m3615V(int i) {
            m3611X(i);
        }

        public void m3616W(int i) {
            m3611X(i);
        }

        public void m3617a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.Cc.BH = applicationMetadata;
            this.Cc.BT = applicationMetadata.getApplicationId();
            this.Cc.BU = str2;
            synchronized (gh.Ca) {
                if (this.Cc.BY != null) {
                    this.Cc.BY.m154a(new C1117a(new Status(0), applicationMetadata, str, str2, z));
                    this.Cc.BY = null;
                }
            }
        }

        public void m3618a(String str, double d, boolean z) {
            gh.BG.m1139b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void m3619a(String str, long j) {
            m3612b(j, 0);
        }

        public void m3620a(String str, long j, int i) {
            m3612b(j, i);
        }

        public void m3621b(ge geVar) {
            gh.BG.m1139b("onApplicationStatusChanged", new Object[0]);
            this.Cc.mHandler.post(new C03623(this, geVar));
        }

        public void m3622b(gj gjVar) {
            gh.BG.m1139b("onDeviceStatusChanged", new Object[0]);
            this.Cc.mHandler.post(new C03612(this, gjVar));
        }

        public void m3623b(String str, byte[] bArr) {
            gh.BG.m1139b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }

        public void m3624g(String str, String str2) {
            gh.BG.m1139b("Receive (type=text, ns=%s) %s", str, str2);
            this.Cc.mHandler.post(new C03634(this, str, str2));
        }

        public void onApplicationDisconnected(int statusCode) {
            this.Cc.BT = null;
            this.Cc.BU = null;
            m3611X(statusCode);
            if (this.Cc.Ae != null) {
                this.Cc.mHandler.post(new C03601(this, statusCode));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.gh.a */
    private static final class C1117a implements ApplicationConnectionResult {
        private final ApplicationMetadata Ci;
        private final String Cj;
        private final boolean Ck;
        private final String rR;
        private final Status yz;

        public C1117a(Status status) {
            this(status, null, null, null, false);
        }

        public C1117a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.yz = status;
            this.Ci = applicationMetadata;
            this.Cj = str;
            this.rR = str2;
            this.Ck = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.Ci;
        }

        public String getApplicationStatus() {
            return this.Cj;
        }

        public String getSessionId() {
            return this.rR;
        }

        public Status getStatus() {
            return this.yz;
        }

        public boolean getWasLaunched() {
            return this.Ck;
        }
    }

    /* renamed from: com.google.android.gms.internal.gh.b */
    private class C1118b implements OnConnectionFailedListener {
        final /* synthetic */ gh Cc;

        private C1118b(gh ghVar) {
            this.Cc = ghVar;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.Cc.ei();
        }
    }

    static {
        BG = new gn("CastClientImpl");
        Ca = new Object();
        Cb = new Object();
    }

    public gh(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
        this.BI = castDevice;
        this.Ae = listener;
        this.BL = j;
        this.mHandler = new Handler(looper);
        this.BK = new HashMap();
        this.BP = false;
        this.BR = -1;
        this.BH = null;
        this.BM = null;
        this.BQ = new AtomicBoolean(false);
        this.AP = 0.0d;
        this.AQ = false;
        this.BS = new AtomicLong(0);
        this.BW = new HashMap();
        this.BX = new C1118b();
        registerConnectionFailedListener(this.BX);
        this.BJ = new C11161(this);
    }

    private void m3628a(ge geVar) {
        boolean z;
        String ec = geVar.ec();
        if (gi.m1110a(ec, this.BM)) {
            z = false;
        } else {
            this.BM = ec;
            z = true;
        }
        BG.m1139b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.BN));
        if (this.Ae != null && (z || this.BN)) {
            this.Ae.onApplicationStatusChanged();
        }
        this.BN = false;
    }

    private void m3631a(gj gjVar) {
        boolean z;
        double eh = gjVar.eh();
        if (eh == Double.NaN || eh == this.AP) {
            z = false;
        } else {
            this.AP = eh;
            z = true;
        }
        boolean en = gjVar.en();
        if (en != this.AQ) {
            this.AQ = en;
            z = true;
        }
        BG.m1139b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.BO));
        if (this.Ae != null && (z || this.BO)) {
            this.Ae.onVolumeChanged();
        }
        int eo = gjVar.eo();
        if (eo != this.BR) {
            this.BR = eo;
            z = true;
        } else {
            z = false;
        }
        BG.m1139b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.BO));
        if (this.Ae != null && (z || this.BO)) {
            this.Ae.m97O(this.BR);
        }
        this.BO = false;
    }

    private void m3637c(C0180d<ApplicationConnectionResult> c0180d) {
        synchronized (Ca) {
            if (this.BY != null) {
                this.BY.m154a(new C1117a(new Status(CastStatusCodes.CANCELED)));
            }
            this.BY = c0180d;
        }
    }

    private void m3640e(C0180d<Status> c0180d) {
        synchronized (Cb) {
            if (this.BZ != null) {
                c0180d.m154a(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE));
                return;
            }
            this.BZ = c0180d;
        }
    }

    private void ei() {
        BG.m1139b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.BK) {
            this.BK.clear();
        }
    }

    private void ej() throws IllegalStateException {
        if (!this.BP || this.BQ.get()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    protected gl m3646G(IBinder iBinder) {
        return C0769a.m2617H(iBinder);
    }

    public void m3647a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((gl) ft()).m1117a(d, this.AP, this.AQ);
    }

    protected void m3648a(int i, IBinder iBinder, Bundle bundle) {
        BG.m1139b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            this.BP = true;
            this.BN = true;
            this.BO = true;
        } else {
            this.BP = false;
        }
        if (i == GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            this.BV = new Bundle();
            this.BV.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.m2663a(i, iBinder, bundle);
    }

    protected void m3649a(hi hiVar, C1119e c1119e) throws RemoteException {
        Bundle bundle = new Bundle();
        BG.m1139b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.BT, this.BU);
        this.BI.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.BL);
        if (this.BT != null) {
            bundle.putString("last_application_id", this.BT);
            if (this.BU != null) {
                bundle.putString("last_session_id", this.BU);
            }
        }
        hiVar.m1187a((hh) c1119e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.BJ.asBinder(), bundle);
    }

    public void m3650a(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        gi.ak(str);
        aj(str);
        if (messageReceivedCallback != null) {
            synchronized (this.BK) {
                this.BK.put(str, messageReceivedCallback);
            }
            ((gl) ft()).an(str);
        }
    }

    public void m3651a(String str, LaunchOptions launchOptions, C0180d<ApplicationConnectionResult> c0180d) throws IllegalStateException, RemoteException {
        m3637c((C0180d) c0180d);
        ((gl) ft()).m1118a(str, launchOptions);
    }

    public void m3652a(String str, C0180d<Status> c0180d) throws IllegalStateException, RemoteException {
        m3640e((C0180d) c0180d);
        ((gl) ft()).am(str);
    }

    public void m3653a(String str, String str2, C0180d<Status> c0180d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > Cast.MAX_MESSAGE_LENGTH) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            gi.ak(str);
            ej();
            long incrementAndGet = this.BS.incrementAndGet();
            ((gl) ft()).m1119a(str, str2, incrementAndGet);
            this.BW.put(Long.valueOf(incrementAndGet), c0180d);
        }
    }

    public void m3654a(String str, boolean z, C0180d<ApplicationConnectionResult> c0180d) throws IllegalStateException, RemoteException {
        m3637c((C0180d) c0180d);
        ((gl) ft()).m1122e(str, z);
    }

    public void aj(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.BK) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.BK.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((gl) ft()).ao(str);
            } catch (Throwable e) {
                BG.m1138a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void m3655b(String str, String str2, C0180d<ApplicationConnectionResult> c0180d) throws IllegalStateException, RemoteException {
        m3637c((C0180d) c0180d);
        ((gl) ft()).m1123h(str, str2);
    }

    protected String bu() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String bv() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public void m3656d(C0180d<Status> c0180d) throws IllegalStateException, RemoteException {
        m3640e((C0180d) c0180d);
        ((gl) ft()).ep();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = BG;
        r1 = "disconnect(); mDisconnecting=%b, isConnected=%b";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r6.BQ;
        r3 = r3.get();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r4] = r3;
        r3 = r6.isConnected();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r5] = r3;
        r0.m1139b(r1, r2);
        r0 = r6.BQ;
        r0 = r0.getAndSet(r5);
        if (r0 == 0) goto L_0x0034;
    L_0x002a:
        r0 = BG;
        r1 = "mDisconnecting is set, so short-circuiting";
        r2 = new java.lang.Object[r4];
        r0.m1139b(r1, r2);
    L_0x0033:
        return;
    L_0x0034:
        r6.ei();
        r0 = r6.isConnected();	 Catch:{ RemoteException -> 0x0050 }
        if (r0 != 0) goto L_0x0043;
    L_0x003d:
        r0 = r6.isConnecting();	 Catch:{ RemoteException -> 0x0050 }
        if (r0 == 0) goto L_0x004c;
    L_0x0043:
        r0 = r6.ft();	 Catch:{ RemoteException -> 0x0050 }
        r0 = (com.google.android.gms.internal.gl) r0;	 Catch:{ RemoteException -> 0x0050 }
        r0.disconnect();	 Catch:{ RemoteException -> 0x0050 }
    L_0x004c:
        super.disconnect();
        goto L_0x0033;
    L_0x0050:
        r0 = move-exception;
        r1 = BG;	 Catch:{ all -> 0x0066 }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0066 }
        r4 = 0;
        r5 = r0.getMessage();	 Catch:{ all -> 0x0066 }
        r3[r4] = r5;	 Catch:{ all -> 0x0066 }
        r1.m1138a(r0, r2, r3);	 Catch:{ all -> 0x0066 }
        super.disconnect();
        goto L_0x0033;
    L_0x0066:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gh.disconnect():void");
    }

    public Bundle ef() {
        if (this.BV == null) {
            return super.ef();
        }
        Bundle bundle = this.BV;
        this.BV = null;
        return bundle;
    }

    public void eg() throws IllegalStateException, RemoteException {
        ((gl) ft()).eg();
    }

    public double eh() throws IllegalStateException {
        ej();
        return this.AP;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        ej();
        return this.BH;
    }

    public String getApplicationStatus() throws IllegalStateException {
        ej();
        return this.BM;
    }

    public boolean isMute() throws IllegalStateException {
        ej();
        return this.AQ;
    }

    protected /* synthetic */ IInterface m3657x(IBinder iBinder) {
        return m3646G(iBinder);
    }

    public void m3658y(boolean z) throws IllegalStateException, RemoteException {
        ((gl) ft()).m1121a(z, this.AP, this.AQ);
    }
}
