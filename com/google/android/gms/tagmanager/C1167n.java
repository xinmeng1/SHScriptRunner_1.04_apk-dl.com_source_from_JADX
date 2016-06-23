package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.tagmanager.n */
class C1167n implements ContainerHolder {
    private final Looper DF;
    private boolean Ip;
    private Container aeB;
    private Container aeC;
    private C0510b aeD;
    private C0509a aeE;
    private TagManager aeF;
    private Status yz;

    /* renamed from: com.google.android.gms.tagmanager.n.a */
    public interface C0509a {
        void bJ(String str);

        String lo();

        void lq();
    }

    /* renamed from: com.google.android.gms.tagmanager.n.b */
    private class C0510b extends Handler {
        private final ContainerAvailableListener aeG;
        final /* synthetic */ C1167n aeH;

        public C0510b(C1167n c1167n, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.aeH = c1167n;
            super(looper);
            this.aeG = containerAvailableListener;
        }

        public void bK(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void bL(String str) {
            this.aeG.onContainerAvailable(this.aeH, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    bL((String) msg.obj);
                default:
                    bh.m1642A("Don't know how to handle this message.");
            }
        }
    }

    public C1167n(Status status) {
        this.yz = status;
        this.DF = null;
    }

    public C1167n(TagManager tagManager, Looper looper, Container container, C0509a c0509a) {
        this.aeF = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.DF = looper;
        this.aeB = container;
        this.aeE = c0509a;
        this.yz = Status.En;
        tagManager.m1614a(this);
    }

    private void lp() {
        if (this.aeD != null) {
            this.aeD.bK(this.aeC.lm());
        }
    }

    public synchronized void m3833a(Container container) {
        if (!this.Ip) {
            if (container == null) {
                bh.m1642A("Unexpected null container.");
            } else {
                this.aeC = container;
                lp();
            }
        }
    }

    public synchronized void bH(String str) {
        if (!this.Ip) {
            this.aeB.bH(str);
        }
    }

    void bJ(String str) {
        if (this.Ip) {
            bh.m1642A("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.aeE.bJ(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.Ip) {
                bh.m1642A("ContainerHolder is released.");
            } else {
                if (this.aeC != null) {
                    this.aeB = this.aeC;
                    this.aeC = null;
                }
                container = this.aeB;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.Ip) {
            return this.aeB.getContainerId();
        }
        bh.m1642A("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.yz;
    }

    String lo() {
        if (!this.Ip) {
            return this.aeE.lo();
        }
        bh.m1642A("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.Ip) {
            bh.m1642A("Refreshing a released ContainerHolder.");
        } else {
            this.aeE.lq();
        }
    }

    public synchronized void release() {
        if (this.Ip) {
            bh.m1642A("Releasing a released ContainerHolder.");
        } else {
            this.Ip = true;
            this.aeF.m1615b(this);
            this.aeB.release();
            this.aeB = null;
            this.aeC = null;
            this.aeE = null;
            this.aeD = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.Ip) {
            bh.m1642A("ContainerHolder is released.");
        } else if (listener == null) {
            this.aeD = null;
        } else {
            this.aeD = new C0510b(this, listener, this.DF);
            if (this.aeC != null) {
                lp();
            }
        }
    }
}
