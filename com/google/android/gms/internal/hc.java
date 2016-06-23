package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class hc {
    private final C0376b Gp;
    private final ArrayList<ConnectionCallbacks> Gq;
    final ArrayList<ConnectionCallbacks> Gr;
    private boolean Gs;
    private final ArrayList<OnConnectionFailedListener> Gt;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.hc.a */
    final class C0375a extends Handler {
        final /* synthetic */ hc Gu;

        public C0375a(hc hcVar, Looper looper) {
            this.Gu = hcVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                synchronized (this.Gu.Gq) {
                    if (this.Gu.Gp.eO() && this.Gu.Gp.isConnected() && this.Gu.Gq.contains(msg.obj)) {
                        ((ConnectionCallbacks) msg.obj).onConnected(this.Gu.Gp.ef());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    /* renamed from: com.google.android.gms.internal.hc.b */
    public interface C0376b {
        boolean eO();

        Bundle ef();

        boolean isConnected();
    }

    public hc(Context context, Looper looper, C0376b c0376b) {
        this.Gq = new ArrayList();
        this.Gr = new ArrayList();
        this.Gs = false;
        this.Gt = new ArrayList();
        this.Gp = c0376b;
        this.mHandler = new C0375a(this, looper);
    }

    public void m1164a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.Gt) {
            Iterator it = new ArrayList(this.Gt).iterator();
            while (it.hasNext()) {
                OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                if (!this.Gp.eO()) {
                    return;
                } else if (this.Gt.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    public void ao(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.Gq) {
            this.Gs = true;
            Iterator it = new ArrayList(this.Gq).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.Gp.eO()) {
                    break;
                } else if (this.Gq.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.Gs = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1165c(android.os.Bundle r6) {
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        r3 = r5.Gq;
        monitor-enter(r3);
        r2 = r5.Gs;	 Catch:{ all -> 0x0062 }
        if (r2 != 0) goto L_0x0052;
    L_0x0009:
        r2 = r0;
    L_0x000a:
        com.google.android.gms.internal.hm.m1224A(r2);	 Catch:{ all -> 0x0062 }
        r2 = r5.mHandler;	 Catch:{ all -> 0x0062 }
        r4 = 1;
        r2.removeMessages(r4);	 Catch:{ all -> 0x0062 }
        r2 = 1;
        r5.Gs = r2;	 Catch:{ all -> 0x0062 }
        r2 = r5.Gr;	 Catch:{ all -> 0x0062 }
        r2 = r2.size();	 Catch:{ all -> 0x0062 }
        if (r2 != 0) goto L_0x0054;
    L_0x001e:
        com.google.android.gms.internal.hm.m1224A(r0);	 Catch:{ all -> 0x0062 }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0062 }
        r1 = r5.Gq;	 Catch:{ all -> 0x0062 }
        r0.<init>(r1);	 Catch:{ all -> 0x0062 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0062 }
    L_0x002c:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0048;
    L_0x0032:
        r0 = r1.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) r0;	 Catch:{ all -> 0x0062 }
        r2 = r5.Gp;	 Catch:{ all -> 0x0062 }
        r2 = r2.eO();	 Catch:{ all -> 0x0062 }
        if (r2 == 0) goto L_0x0048;
    L_0x0040:
        r2 = r5.Gp;	 Catch:{ all -> 0x0062 }
        r2 = r2.isConnected();	 Catch:{ all -> 0x0062 }
        if (r2 != 0) goto L_0x0056;
    L_0x0048:
        r0 = r5.Gr;	 Catch:{ all -> 0x0062 }
        r0.clear();	 Catch:{ all -> 0x0062 }
        r0 = 0;
        r5.Gs = r0;	 Catch:{ all -> 0x0062 }
        monitor-exit(r3);	 Catch:{ all -> 0x0062 }
        return;
    L_0x0052:
        r2 = r1;
        goto L_0x000a;
    L_0x0054:
        r0 = r1;
        goto L_0x001e;
    L_0x0056:
        r2 = r5.Gr;	 Catch:{ all -> 0x0062 }
        r2 = r2.contains(r0);	 Catch:{ all -> 0x0062 }
        if (r2 != 0) goto L_0x002c;
    L_0x005e:
        r0.onConnected(r6);	 Catch:{ all -> 0x0062 }
        goto L_0x002c;
    L_0x0062:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0062 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.hc.c(android.os.Bundle):void");
    }

    protected void cp() {
        synchronized (this.Gq) {
            m1165c(this.Gp.ef());
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        hm.m1232f(listener);
        synchronized (this.Gq) {
            contains = this.Gq.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        hm.m1232f(listener);
        synchronized (this.Gt) {
            contains = this.Gt.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        hm.m1232f(listener);
        synchronized (this.Gq) {
            if (this.Gq.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.Gq.add(listener);
            }
        }
        if (this.Gp.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        hm.m1232f(listener);
        synchronized (this.Gt) {
            if (this.Gt.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.Gt.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        hm.m1232f(listener);
        synchronized (this.Gq) {
            if (this.Gq != null) {
                if (!this.Gq.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.Gs) {
                    this.Gr.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        hm.m1232f(listener);
        synchronized (this.Gt) {
            if (!(this.Gt == null || this.Gt.remove(listener))) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }
}
