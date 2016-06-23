package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C0166u.C0165a;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.analytics.r */
class C0613r extends af {
    private static final Object tT;
    private static C0613r uf;
    private Context mContext;
    private Handler mHandler;
    private C0140d tU;
    private volatile C0142f tV;
    private int tW;
    private boolean tX;
    private boolean tY;
    private String tZ;
    private boolean ua;
    private boolean ub;
    private C0141e uc;
    private C0152q ud;
    private boolean ue;

    /* renamed from: com.google.android.gms.analytics.r.2 */
    class C01532 implements Callback {
        final /* synthetic */ C0613r ug;

        C01532(C0613r c0613r) {
            this.ug = c0613r;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && C0613r.tT.equals(msg.obj)) {
                C0166u.cU().m84u(true);
                this.ug.dispatchLocalHits();
                C0166u.cU().m84u(false);
                if (this.ug.tW > 0 && !this.ug.ue) {
                    this.ug.mHandler.sendMessageDelayed(this.ug.mHandler.obtainMessage(1, C0613r.tT), (long) (this.ug.tW * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.analytics.r.1 */
    class C06121 implements C0141e {
        final /* synthetic */ C0613r ug;

        C06121(C0613r c0613r) {
            this.ug = c0613r;
        }

        public void m1918s(boolean z) {
            this.ug.m1924a(z, this.ug.ua);
        }
    }

    static {
        tT = new Object();
    }

    private C0613r() {
        this.tW = 1800;
        this.tX = true;
        this.ua = true;
        this.ub = true;
        this.uc = new C06121(this);
        this.ue = false;
    }

    public static C0613r cE() {
        if (uf == null) {
            uf = new C0613r();
        }
        return uf;
    }

    private void cF() {
        this.ud = new C0152q(this);
        this.ud.m82v(this.mContext);
    }

    private void cG() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C01532(this));
        if (this.tW > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (this.tW * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
        }
    }

    synchronized void m1923a(Context context, C0142f c0142f) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.tV == null) {
                this.tV = c0142f;
                if (this.tX) {
                    dispatchLocalHits();
                    this.tX = false;
                }
                if (this.tY) {
                    cs();
                    this.tY = false;
                }
            }
        }
    }

    synchronized void m1924a(boolean z, boolean z2) {
        if (!(this.ue == z && this.ua == z2)) {
            if (z || !z2) {
                if (this.tW > 0) {
                    this.mHandler.removeMessages(1, tT);
                }
            }
            if (!z && z2 && this.tW > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (this.tW * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            aa.m39C(append.append(str).toString());
            this.ue = z;
            this.ua = z2;
        }
    }

    synchronized C0140d cH() {
        if (this.tU == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.tU = new ac(this.uc, this.mContext);
            if (this.tZ != null) {
                this.tU.cr().m69M(this.tZ);
                this.tZ = null;
            }
        }
        if (this.mHandler == null) {
            cG();
        }
        if (this.ud == null && this.ub) {
            cF();
        }
        return this.tU;
    }

    synchronized void cI() {
        if (!this.ue && this.ua && this.tW > 0) {
            this.mHandler.removeMessages(1, tT);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, tT));
        }
    }

    void cs() {
        if (this.tV == null) {
            aa.m39C("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.tY = true;
            return;
        }
        C0166u.cU().m83a(C0165a.SET_FORCE_LOCAL_DISPATCH);
        this.tV.cs();
    }

    synchronized void dispatchLocalHits() {
        if (this.tV == null) {
            aa.m39C("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.tX = true;
        } else {
            C0166u.cU().m83a(C0165a.DISPATCH);
            this.tV.cq();
        }
    }

    synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            aa.m39C("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.tW = dispatchPeriodInSeconds;
        } else {
            C0166u.cU().m83a(C0165a.SET_DISPATCH_PERIOD);
            if (!this.ue && this.ua && this.tW > 0) {
                this.mHandler.removeMessages(1, tT);
            }
            this.tW = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.ue && this.ua) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (dispatchPeriodInSeconds * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
        }
    }

    synchronized void m1925t(boolean z) {
        m1924a(this.ue, z);
    }
}
