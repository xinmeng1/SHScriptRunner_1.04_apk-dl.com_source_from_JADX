package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.dw.C0738a;
import com.google.android.gms.internal.hb.C1119e;

public class dr extends hb<dw> {
    final int pV;

    public dr(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.pV = i;
    }

    protected void m3582a(hi hiVar, C1119e c1119e) throws RemoteException {
        hiVar.m1207g(c1119e, this.pV, getContext().getPackageName(), new Bundle());
    }

    protected String bu() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public dw bw() {
        return (dw) super.ft();
    }

    protected dw m3583w(IBinder iBinder) {
        return C0738a.m2556y(iBinder);
    }

    protected /* synthetic */ IInterface m3584x(IBinder iBinder) {
        return m3583w(iBinder);
    }
}
