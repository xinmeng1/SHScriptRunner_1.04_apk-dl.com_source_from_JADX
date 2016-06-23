package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.C0175a;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.C0376b;
import com.google.android.gms.internal.hm;
import com.google.android.gms.wearable.DataEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.c */
final class C0634c implements GoogleApiClient {
    private final Looper DF;
    private final Lock DQ;
    private final Condition DR;
    private final hc DS;
    private final Fragment DT;
    final Queue<C0184c<?>> DU;
    private ConnectionResult DV;
    private int DW;
    private int DX;
    private int DY;
    private boolean DZ;
    private final C0182a Dy;
    private int Ea;
    private long Eb;
    final Handler Ec;
    private final Bundle Ed;
    private final Map<C0177c<?>, C0175a> Ee;
    private final List<String> Ef;
    private boolean Eg;
    final Set<C0184c<?>> Eh;
    final ConnectionCallbacks Ei;
    private final C0376b Ej;

    /* renamed from: com.google.android.gms.common.api.c.a */
    interface C0182a {
        void m156b(C0184c<?> c0184c);
    }

    /* renamed from: com.google.android.gms.common.api.c.b */
    class C0183b extends Handler {
        final /* synthetic */ C0634c Ek;

        C0183b(C0634c c0634c, Looper looper) {
            this.Ek = c0634c;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                this.Ek.DQ.lock();
                try {
                    if (!(this.Ek.isConnected() || this.Ek.isConnecting())) {
                        this.Ek.connect();
                    }
                    this.Ek.DQ.unlock();
                } catch (Throwable th) {
                    this.Ek.DQ.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.c */
    interface C0184c<A extends C0175a> {
        void m157a(C0182a c0182a);

        void m158b(A a) throws DeadObjectException;

        void cancel();

        C0177c<A> eB();

        int eG();

        void m159m(Status status);
    }

    /* renamed from: com.google.android.gms.common.api.c.1 */
    class C06311 implements C0182a {
        final /* synthetic */ C0634c Ek;

        C06311(C0634c c0634c) {
            this.Ek = c0634c;
        }

        public void m1986b(C0184c<?> c0184c) {
            this.Ek.Eh.remove(c0184c);
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.2 */
    class C06322 implements ConnectionCallbacks {
        final /* synthetic */ C0634c Ek;

        C06322(C0634c c0634c) {
            this.Ek = c0634c;
        }

        public void onConnected(Bundle connectionHint) {
            this.Ek.DQ.lock();
            try {
                if (this.Ek.DX == 1) {
                    if (connectionHint != null) {
                        this.Ek.Ed.putAll(connectionHint);
                    }
                    this.Ek.eK();
                }
                this.Ek.DQ.unlock();
            } catch (Throwable th) {
                this.Ek.DQ.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.Ek.DQ.lock();
            try {
                this.Ek.aa(cause);
                switch (cause) {
                    case DataEvent.TYPE_CHANGED /*1*/:
                        if (!this.Ek.eM()) {
                            this.Ek.DY = 2;
                            this.Ek.Ec.sendMessageDelayed(this.Ek.Ec.obtainMessage(1), this.Ek.Eb);
                            break;
                        }
                        this.Ek.DQ.unlock();
                        return;
                    case DataEvent.TYPE_DELETED /*2*/:
                        this.Ek.connect();
                        break;
                }
                this.Ek.DQ.unlock();
            } catch (Throwable th) {
                this.Ek.DQ.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.3 */
    class C06333 implements C0376b {
        final /* synthetic */ C0634c Ek;

        C06333(C0634c c0634c) {
            this.Ek = c0634c;
        }

        public boolean eO() {
            return this.Ek.Eg;
        }

        public Bundle ef() {
            return null;
        }

        public boolean isConnected() {
            return this.Ek.isConnected();
        }
    }

    /* renamed from: com.google.android.gms.common.api.c.4 */
    class C10304 implements OnConnectionFailedListener {
        final /* synthetic */ C0634c Ek;
        final /* synthetic */ C0176b El;

        C10304(C0634c c0634c, C0176b c0176b) {
            this.Ek = c0634c;
            this.El = c0176b;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.Ek.DQ.lock();
            try {
                if (this.Ek.DV == null || this.El.getPriority() < this.Ek.DW) {
                    this.Ek.DV = result;
                    this.Ek.DW = this.El.getPriority();
                }
                this.Ek.eK();
            } finally {
                this.Ek.DQ.unlock();
            }
        }
    }

    public C0634c(Context context, Looper looper, gy gyVar, Map<Api<?>, ApiOptions> map, Fragment fragment, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2) {
        this.DQ = new ReentrantLock();
        this.DR = this.DQ.newCondition();
        this.DU = new LinkedList();
        this.DX = 4;
        this.DY = 0;
        this.DZ = false;
        this.Eb = 5000;
        this.Ed = new Bundle();
        this.Ee = new HashMap();
        this.Eh = Collections.newSetFromMap(new ConcurrentHashMap());
        this.Dy = new C06311(this);
        this.Ei = new C06322(this);
        this.Ej = new C06333(this);
        this.DS = new hc(context, looper, this.Ej);
        this.DT = fragment;
        this.DF = looper;
        this.Ec = new C0183b(this, looper);
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.DS.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.DS.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            C0176b ez = api.ez();
            Object obj = map.get(api);
            this.Ee.put(api.eB(), C0634c.m1988a(ez, obj, context, looper, gyVar, this.Ei, new C10304(this, ez)));
        }
        this.Ef = Collections.unmodifiableList(gyVar.fl());
    }

    private static <C extends C0175a, O> C m1988a(C0176b<C, O> c0176b, Object obj, Context context, Looper looper, gy gyVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return c0176b.m144a(context, looper, gyVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private <A extends C0175a> void m1990a(C0184c<A> c0184c) throws DeadObjectException {
        boolean z = true;
        this.DQ.lock();
        try {
            boolean z2 = isConnected() || eM();
            hm.m1226a(z2, "GoogleApiClient is not connected yet.");
            if (c0184c.eB() == null) {
                z = false;
            }
            hm.m1230b(z, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.Eh.add(c0184c);
            c0184c.m157a(this.Dy);
            if (eM()) {
                c0184c.m159m(new Status(8));
                return;
            }
            c0184c.m158b(m2002a(c0184c.eB()));
            this.DQ.unlock();
        } finally {
            this.DQ.unlock();
        }
    }

    private void aa(int i) {
        this.DQ.lock();
        try {
            if (this.DX != 3) {
                if (i == -1) {
                    Iterator it;
                    C0184c c0184c;
                    if (isConnecting()) {
                        it = this.DU.iterator();
                        while (it.hasNext()) {
                            c0184c = (C0184c) it.next();
                            if (c0184c.eG() != 1) {
                                c0184c.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.DU.clear();
                    }
                    for (C0184c c0184c2 : this.Eh) {
                        c0184c2.cancel();
                    }
                    this.Eh.clear();
                    if (this.DV == null && !this.DU.isEmpty()) {
                        this.DZ = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.DX = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.DV = null;
                    }
                    this.DR.signalAll();
                }
                this.Eg = false;
                for (C0175a c0175a : this.Ee.values()) {
                    if (c0175a.isConnected()) {
                        c0175a.disconnect();
                    }
                }
                this.Eg = true;
                this.DX = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.DS.ao(i);
                    }
                    this.Eg = false;
                }
            }
            this.DQ.unlock();
        } finally {
            this.DQ.unlock();
        }
    }

    private void eK() {
        this.DQ.lock();
        try {
            this.Ea--;
            if (this.Ea == 0) {
                if (this.DV != null) {
                    this.DZ = false;
                    aa(3);
                    if (eM()) {
                        this.DY--;
                    }
                    if (eM()) {
                        this.Ec.sendMessageDelayed(this.Ec.obtainMessage(1), this.Eb);
                    } else {
                        this.DS.m1164a(this.DV);
                    }
                    this.Eg = false;
                } else {
                    this.DX = 2;
                    eN();
                    this.DR.signalAll();
                    eL();
                    if (this.DZ) {
                        this.DZ = false;
                        aa(-1);
                    } else {
                        this.DS.m1165c(this.Ed.isEmpty() ? null : this.Ed);
                    }
                }
            }
            this.DQ.unlock();
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    private void eL() {
        boolean z = isConnected() || eM();
        hm.m1226a(z, "GoogleApiClient is not connected yet.");
        this.DQ.lock();
        while (!this.DU.isEmpty()) {
            try {
                m1990a((C0184c) this.DU.remove());
            } catch (Throwable e) {
                Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
            } catch (Throwable th) {
                this.DQ.unlock();
            }
        }
        this.DQ.unlock();
    }

    private boolean eM() {
        this.DQ.lock();
        try {
            boolean z = this.DY != 0;
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    private void eN() {
        this.DQ.lock();
        try {
            this.DY = 0;
            this.Ec.removeMessages(1);
        } finally {
            this.DQ.unlock();
        }
    }

    public <C extends C0175a> C m2002a(C0177c<C> c0177c) {
        Object obj = (C0175a) this.Ee.get(c0177c);
        hm.m1228b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends C0175a, T extends C1029b<? extends Result, A>> T m2003a(T t) {
        this.DQ.lock();
        try {
            if (isConnected()) {
                m2004b((C1029b) t);
            } else {
                this.DU.add(t);
            }
            this.DQ.unlock();
            return t;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public <A extends C0175a, T extends C1029b<? extends Result, A>> T m2004b(T t) {
        boolean z = isConnected() || eM();
        hm.m1226a(z, "GoogleApiClient is not connected yet.");
        eL();
        try {
            m1990a((C0184c) t);
        } catch (DeadObjectException e) {
            aa(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        hm.m1226a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.DQ.lock();
        try {
            connect();
            while (isConnecting()) {
                this.DR.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.CS;
            } else if (this.DV != null) {
                connectionResult = this.DV;
                this.DQ.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.DQ.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.DQ.unlock();
        }
        return connectionResult;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        hm.m1226a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.DQ.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.DR.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.CS;
                this.DQ.unlock();
            } else if (this.DV != null) {
                connectionResult = this.DV;
                this.DQ.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.DQ.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.DQ.unlock();
        }
        return connectionResult;
    }

    public void connect() {
        this.DQ.lock();
        try {
            this.DZ = false;
            if (isConnected() || isConnecting()) {
                this.DQ.unlock();
                return;
            }
            this.Eg = true;
            this.DV = null;
            this.DX = 1;
            this.Ed.clear();
            this.Ea = this.Ee.size();
            for (C0175a connect : this.Ee.values()) {
                connect.connect();
            }
            this.DQ.unlock();
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public void disconnect() {
        eN();
        aa(-1);
    }

    public Looper getLooper() {
        return this.DF;
    }

    public boolean isConnected() {
        this.DQ.lock();
        try {
            boolean z = this.DX == 2;
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public boolean isConnecting() {
        boolean z = true;
        this.DQ.lock();
        try {
            if (this.DX != 1) {
                z = false;
            }
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.DS.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.DS.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.DS.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.DS.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage() {
        hm.m1226a(this.DT != null, "Called stopAutoManage but automatic lifecycle management is not enabled.");
        if (this.DT.getActivity() != null) {
            this.DT.getActivity().getSupportFragmentManager().beginTransaction().remove(this.DT).commit();
            disconnect();
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.DS.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.DS.unregisterConnectionFailedListener(listener);
    }
}
