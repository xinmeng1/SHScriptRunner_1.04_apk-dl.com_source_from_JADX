package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.dp.C0333a;

public abstract class dq extends em {
    private final ds ne;
    private final C0333a pT;

    /* renamed from: com.google.android.gms.internal.dq.a */
    public static final class C1110a extends dq {
        private final Context mContext;

        public C1110a(Context context, ds dsVar, C0333a c0333a) {
            super(dsVar, c0333a);
            this.mContext = context;
        }

        public void bs() {
        }

        public dw bt() {
            return dx.m3587a(this.mContext, new ay(), new bj(), new ee());
        }
    }

    /* renamed from: com.google.android.gms.internal.dq.b */
    public static final class C1111b extends dq implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object ls;
        private final C0333a pT;
        private final dr pU;

        public C1111b(Context context, ds dsVar, C0333a c0333a) {
            super(dsVar, c0333a);
            this.ls = new Object();
            this.pT = c0333a;
            this.pU = new dr(context, this, this, dsVar.kQ.sy);
            this.pU.connect();
        }

        public void bs() {
            synchronized (this.ls) {
                if (this.pU.isConnected() || this.pU.isConnecting()) {
                    this.pU.disconnect();
                }
            }
        }

        public dw bt() {
            dw bw;
            synchronized (this.ls) {
                try {
                    bw = this.pU.bw();
                } catch (IllegalStateException e) {
                    bw = null;
                }
            }
            return bw;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.pT.m905a(new du(0));
        }

        public void onDisconnected() {
            eu.m1019z("Disconnected from remote ad request service.");
        }
    }

    public dq(ds dsVar, C0333a c0333a) {
        this.ne = dsVar;
        this.pT = c0333a;
    }

    private static du m2554a(dw dwVar, ds dsVar) {
        du duVar = null;
        try {
            duVar = dwVar.m915b(dsVar);
        } catch (Throwable e) {
            eu.m1017c("Could not fetch ad response from ad request service.", e);
        } catch (Throwable e2) {
            eu.m1017c("Could not fetch ad response from ad request service due to an Exception.", e2);
        } catch (Throwable e22) {
            eu.m1017c("Could not fetch ad response from ad request service due to an Exception.", e22);
        }
        return duVar;
    }

    public final void bh() {
        try {
            du duVar;
            dw bt = bt();
            if (bt == null) {
                duVar = new du(0);
            } else {
                duVar = m2554a(bt, this.ne);
                if (duVar == null) {
                    duVar = new du(0);
                }
            }
            bs();
            this.pT.m905a(duVar);
        } catch (Throwable th) {
            bs();
        }
    }

    public abstract void bs();

    public abstract dw bt();

    public final void onStop() {
        bs();
    }
}
