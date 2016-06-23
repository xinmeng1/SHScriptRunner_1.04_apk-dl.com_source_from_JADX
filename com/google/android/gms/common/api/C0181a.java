package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api.C0175a;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0634c.C0182a;
import com.google.android.gms.common.api.C0634c.C0184c;
import com.google.android.gms.common.api.PendingResult.C0178a;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hm;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.a */
public class C0181a {

    /* renamed from: com.google.android.gms.common.api.a.c */
    public static class C0179c<R extends Result> extends Handler {
        public C0179c() {
            this(Looper.getMainLooper());
        }

        public C0179c(Looper looper) {
            super(looper);
        }

        public void m151a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void m152a(C0629a<R> c0629a, long j) {
            sendMessageDelayed(obtainMessage(2, c0629a), j);
        }

        protected void m153b(ResultCallback<R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                C0181a.m155a(r);
                throw e;
            }
        }

        public void eH() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    Pair pair = (Pair) msg.obj;
                    m153b((ResultCallback) pair.first, (Result) pair.second);
                case DataEvent.TYPE_DELETED /*2*/:
                    ((C0629a) msg.obj).eF();
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.d */
    public interface C0180d<R> {
        void m154a(R r);
    }

    /* renamed from: com.google.android.gms.common.api.a.a */
    public static abstract class C0629a<R extends Result> implements PendingResult<R>, C0180d<R> {
        private final Object Dp;
        private C0179c<R> Dq;
        private final ArrayList<C0178a> Dr;
        private ResultCallback<R> Ds;
        private volatile R Dt;
        private volatile boolean Du;
        private boolean Dv;
        private boolean Dw;
        private hg Dx;
        private final CountDownLatch kK;

        C0629a() {
            this.Dp = new Object();
            this.kK = new CountDownLatch(1);
            this.Dr = new ArrayList();
        }

        public C0629a(Looper looper) {
            this.Dp = new Object();
            this.kK = new CountDownLatch(1);
            this.Dr = new ArrayList();
            this.Dq = new C0179c(looper);
        }

        public C0629a(C0179c<R> c0179c) {
            this.Dp = new Object();
            this.kK = new CountDownLatch(1);
            this.Dr = new ArrayList();
            this.Dq = c0179c;
        }

        private void m1979c(R r) {
            this.Dt = r;
            this.Dx = null;
            this.kK.countDown();
            Status status = this.Dt.getStatus();
            if (this.Ds != null) {
                this.Dq.eH();
                if (!this.Dv) {
                    this.Dq.m151a(this.Ds, eC());
                }
            }
            Iterator it = this.Dr.iterator();
            while (it.hasNext()) {
                ((C0178a) it.next()).m148n(status);
            }
            this.Dr.clear();
        }

        private R eC() {
            R r;
            synchronized (this.Dp) {
                hm.m1226a(!this.Du, "Result has already been consumed.");
                hm.m1226a(isReady(), "Result is not ready.");
                r = this.Dt;
                eD();
            }
            return r;
        }

        private void eE() {
            synchronized (this.Dp) {
                if (!isReady()) {
                    m1984b(m1985c(Status.Eo));
                    this.Dw = true;
                }
            }
        }

        private void eF() {
            synchronized (this.Dp) {
                if (!isReady()) {
                    m1984b(m1985c(Status.Eq));
                    this.Dw = true;
                }
            }
        }

        public final void m1980a(C0178a c0178a) {
            hm.m1226a(!this.Du, "Result has already been consumed.");
            synchronized (this.Dp) {
                if (isReady()) {
                    c0178a.m148n(this.Dt.getStatus());
                } else {
                    this.Dr.add(c0178a);
                }
            }
        }

        protected void m1981a(C0179c<R> c0179c) {
            this.Dq = c0179c;
        }

        protected final void m1982a(hg hgVar) {
            synchronized (this.Dp) {
                this.Dx = hgVar;
            }
        }

        public /* synthetic */ void m1983a(Object obj) {
            m1984b((Result) obj);
        }

        public final R await() {
            boolean z = true;
            hm.m1226a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
            if (this.Du) {
                z = false;
            }
            hm.m1226a(z, "Result has already been consumed");
            try {
                this.kK.await();
            } catch (InterruptedException e) {
                eE();
            }
            hm.m1226a(isReady(), "Result is not ready.");
            return eC();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = true;
            boolean z2 = time <= 0 || Looper.myLooper() != Looper.getMainLooper();
            hm.m1226a(z2, "await must not be called on the UI thread when time is greater than zero.");
            if (this.Du) {
                z = false;
            }
            hm.m1226a(z, "Result has already been consumed.");
            try {
                if (!this.kK.await(time, units)) {
                    eF();
                }
            } catch (InterruptedException e) {
                eE();
            }
            hm.m1226a(isReady(), "Result is not ready.");
            return eC();
        }

        public final void m1984b(R r) {
            boolean z = true;
            synchronized (this.Dp) {
                if (this.Dw || this.Dv) {
                    C0181a.m155a(r);
                    return;
                }
                hm.m1226a(!isReady(), "Results have already been set");
                if (this.Du) {
                    z = false;
                }
                hm.m1226a(z, "Result has already been consumed");
                m1979c((Result) r);
            }
        }

        protected abstract R m1985c(Status status);

        public void cancel() {
            synchronized (this.Dp) {
                if (this.Dv || this.Du) {
                    return;
                }
                if (this.Dx != null) {
                    try {
                        this.Dx.cancel();
                    } catch (RemoteException e) {
                    }
                }
                C0181a.m155a(this.Dt);
                this.Ds = null;
                this.Dv = true;
                m1979c(m1985c(Status.Er));
            }
        }

        protected void eD() {
            this.Du = true;
            this.Dt = null;
            this.Ds = null;
        }

        public boolean isCanceled() {
            boolean z;
            synchronized (this.Dp) {
                z = this.Dv;
            }
            return z;
        }

        public final boolean isReady() {
            return this.kK.getCount() == 0;
        }

        public final void setResultCallback(ResultCallback<R> callback) {
            hm.m1226a(!this.Du, "Result has already been consumed.");
            synchronized (this.Dp) {
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.Dq.m151a((ResultCallback) callback, eC());
                } else {
                    this.Ds = callback;
                }
            }
        }

        public final void setResultCallback(ResultCallback<R> callback, long time, TimeUnit units) {
            hm.m1226a(!this.Du, "Result has already been consumed.");
            synchronized (this.Dp) {
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.Dq.m151a((ResultCallback) callback, eC());
                } else {
                    this.Ds = callback;
                    this.Dq.m152a(this, units.toMillis(time));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.b */
    public static abstract class C1029b<R extends Result, A extends C0175a> extends C0629a<R> implements C0184c<A> {
        private final C0177c<A> Dn;
        private C0182a Dy;

        protected C1029b(C0177c<A> c0177c) {
            this.Dn = (C0177c) hm.m1232f(c0177c);
        }

        private void m3187a(RemoteException remoteException) {
            m3191m(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void m3188a(A a) throws RemoteException;

        public void m3189a(C0182a c0182a) {
            this.Dy = c0182a;
        }

        public final void m3190b(A a) throws DeadObjectException {
            m1981a(new C0179c(a.getLooper()));
            try {
                m3188a((C0175a) a);
            } catch (RemoteException e) {
                m3187a(e);
                throw e;
            } catch (RemoteException e2) {
                m3187a(e2);
            }
        }

        public final C0177c<A> eB() {
            return this.Dn;
        }

        protected void eD() {
            super.eD();
            if (this.Dy != null) {
                this.Dy.m156b(this);
                this.Dy = null;
            }
        }

        public int eG() {
            return 0;
        }

        public final void m3191m(Status status) {
            hm.m1230b(!status.isSuccess(), (Object) "Failed result must not be success");
            m1984b(m1985c(status));
        }
    }

    static void m155a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("GoogleApi", "Unable to release " + result, e);
            }
        }
    }
}
