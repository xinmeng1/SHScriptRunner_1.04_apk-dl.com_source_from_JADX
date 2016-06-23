package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cx extends cw {
    private static cx ahU;
    private static final Object tT;
    private Context ahK;
    private at ahL;
    private volatile ar ahM;
    private int ahN;
    private boolean ahO;
    private boolean ahP;
    private boolean ahQ;
    private au ahR;
    private bn ahS;
    private boolean ahT;
    private boolean connected;
    private Handler handler;

    /* renamed from: com.google.android.gms.tagmanager.cx.2 */
    class C05002 implements Callback {
        final /* synthetic */ cx ahV;

        C05002(cx cxVar) {
            this.ahV = cxVar;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && cx.tT.equals(msg.obj)) {
                this.ahV.cq();
                if (this.ahV.ahN > 0 && !this.ahV.ahT) {
                    this.ahV.handler.sendMessageDelayed(this.ahV.handler.obtainMessage(1, cx.tT), (long) this.ahV.ahN);
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cx.3 */
    class C05013 implements Runnable {
        final /* synthetic */ cx ahV;

        C05013(cx cxVar) {
            this.ahV = cxVar;
        }

        public void run() {
            this.ahV.ahL.cq();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cx.1 */
    class C09611 implements au {
        final /* synthetic */ cx ahV;

        C09611(cx cxVar) {
            this.ahV = cxVar;
        }

        public void m3004s(boolean z) {
            this.ahV.m3011a(z, this.ahV.connected);
        }
    }

    static {
        tT = new Object();
    }

    private cx() {
        this.ahN = 1800000;
        this.ahO = true;
        this.ahP = false;
        this.connected = true;
        this.ahQ = true;
        this.ahR = new C09611(this);
        this.ahT = false;
    }

    private void cF() {
        this.ahS = new bn(this);
        this.ahS.m1657v(this.ahK);
    }

    private void cG() {
        this.handler = new Handler(this.ahK.getMainLooper(), new C05002(this));
        if (this.ahN > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, tT), (long) this.ahN);
        }
    }

    public static cx mQ() {
        if (ahU == null) {
            ahU = new cx();
        }
        return ahU;
    }

    synchronized void m3010a(Context context, ar arVar) {
        if (this.ahK == null) {
            this.ahK = context.getApplicationContext();
            if (this.ahM == null) {
                this.ahM = arVar;
            }
        }
    }

    synchronized void m3011a(boolean z, boolean z2) {
        if (!(this.ahT == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.ahN > 0) {
                    this.handler.removeMessages(1, tT);
                }
            }
            if (!z && z2 && this.ahN > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, tT), (long) this.ahN);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bh.m1644C(append.append(str).toString());
            this.ahT = z;
            this.connected = z2;
        }
    }

    synchronized void cI() {
        if (!this.ahT && this.connected && this.ahN > 0) {
            this.handler.removeMessages(1, tT);
            this.handler.sendMessage(this.handler.obtainMessage(1, tT));
        }
    }

    public synchronized void cq() {
        if (this.ahP) {
            this.ahM.m1630a(new C05013(this));
        } else {
            bh.m1644C("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.ahO = true;
        }
    }

    synchronized at mR() {
        if (this.ahL == null) {
            if (this.ahK == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.ahL = new ca(this.ahR, this.ahK);
        }
        if (this.handler == null) {
            cG();
        }
        this.ahP = true;
        if (this.ahO) {
            cq();
            this.ahO = false;
        }
        if (this.ahS == null && this.ahQ) {
            cF();
        }
        return this.ahL;
    }

    synchronized void m3012t(boolean z) {
        m3011a(this.ahT, z);
    }
}
