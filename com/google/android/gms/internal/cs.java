package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.List;

public class cs extends em implements ServiceConnection {
    private final Object ls;
    private Context mContext;
    private boolean oW;
    private dg oX;
    private cr oY;
    private cx oZ;
    private List<cv> pa;
    private cz pb;

    /* renamed from: com.google.android.gms.internal.cs.1 */
    class C03211 implements Runnable {
        final /* synthetic */ cv pc;
        final /* synthetic */ Intent pd;
        final /* synthetic */ cs pe;

        C03211(cs csVar, cv cvVar, Intent intent) {
            this.pe = csVar;
            this.pc = cvVar;
            this.pd = intent;
        }

        public void run() {
            try {
                if (this.pe.pb.m885a(this.pc.pm, -1, this.pd)) {
                    this.pe.oX.m891a(new cw(this.pe.mContext, this.pc.pn, true, -1, this.pd, this.pc));
                } else {
                    this.pe.oX.m891a(new cw(this.pe.mContext, this.pc.pn, false, -1, this.pd, this.pc));
                }
            } catch (RemoteException e) {
                eu.m1014D("Fail to verify and dispatch pending transaction");
            }
        }
    }

    public cs(Context context, dg dgVar, cz czVar) {
        this.ls = new Object();
        this.oW = false;
        this.pa = null;
        this.mContext = context;
        this.oX = dgVar;
        this.pb = czVar;
        this.oY = new cr(context);
        this.oZ = cx.m874k(this.mContext);
        this.pa = this.oZ.m878d(10);
    }

    private void m2522a(cv cvVar, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        et.sv.post(new C03211(this, cvVar, intent));
    }

    private void m2524b(long j) {
        do {
            if (!m2526c(j)) {
                eu.m1014D("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.oW);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bi() {
        /*
        r12 = this;
        r0 = r12.pa;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = r12.pa;
        r1 = r0.iterator();
    L_0x0014:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r1.next();
        r0 = (com.google.android.gms.internal.cv) r0;
        r2 = r0.pn;
        r6.put(r2, r0);
        goto L_0x0014;
    L_0x0026:
        r0 = 0;
    L_0x0027:
        r1 = r12.oY;
        r2 = r12.mContext;
        r2 = r2.getPackageName();
        r0 = r1.m872b(r2, r0);
        if (r0 != 0) goto L_0x0055;
    L_0x0035:
        r0 = r6.keySet();
        r1 = r0.iterator();
    L_0x003d:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0008;
    L_0x0043:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r12.oZ;
        r0 = r6.get(r0);
        r0 = (com.google.android.gms.internal.cv) r0;
        r2.m876a(r0);
        goto L_0x003d;
    L_0x0055:
        r1 = com.google.android.gms.internal.cy.m879a(r0);
        if (r1 != 0) goto L_0x0035;
    L_0x005b:
        r1 = "INAPP_PURCHASE_ITEM_LIST";
        r7 = r0.getStringArrayList(r1);
        r1 = "INAPP_PURCHASE_DATA_LIST";
        r8 = r0.getStringArrayList(r1);
        r1 = "INAPP_DATA_SIGNATURE_LIST";
        r9 = r0.getStringArrayList(r1);
        r1 = "INAPP_CONTINUATION_TOKEN";
        r5 = r0.getString(r1);
        r0 = 0;
        r4 = r0;
    L_0x0075:
        r0 = r7.size();
        if (r4 >= r0) goto L_0x00b3;
    L_0x007b:
        r0 = r7.get(r4);
        r0 = r6.containsKey(r0);
        if (r0 == 0) goto L_0x00af;
    L_0x0085:
        r0 = r7.get(r4);
        r0 = (java.lang.String) r0;
        r1 = r8.get(r4);
        r1 = (java.lang.String) r1;
        r2 = r9.get(r4);
        r2 = (java.lang.String) r2;
        r3 = r6.get(r0);
        r3 = (com.google.android.gms.internal.cv) r3;
        r10 = com.google.android.gms.internal.cy.m883p(r1);
        r11 = r3.pm;
        r10 = r11.equals(r10);
        if (r10 == 0) goto L_0x00af;
    L_0x00a9:
        r12.m2522a(r3, r1, r2);
        r6.remove(r0);
    L_0x00af:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0075;
    L_0x00b3:
        if (r5 == 0) goto L_0x0035;
    L_0x00b5:
        r0 = r6.isEmpty();
        if (r0 != 0) goto L_0x0035;
    L_0x00bb:
        r0 = r5;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cs.bi():void");
    }

    private boolean m2526c(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.ls.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            eu.m1014D("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void bh() {
        synchronized (this.ls) {
            Context context = this.mContext;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context context2 = this.mContext;
            context.bindService(intent, this, 1);
            m2524b(SystemClock.elapsedRealtime());
            this.mContext.unbindService(this);
            this.oY.destroy();
        }
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.ls) {
            this.oY.m873o(service);
            bi();
            this.oW = true;
            this.ls.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        eu.m1012B("In-app billing service disconnected.");
        this.oY.destroy();
    }

    public void onStop() {
        synchronized (this.ls) {
            this.mContext.unbindService(this);
            this.oY.destroy();
        }
    }
}
