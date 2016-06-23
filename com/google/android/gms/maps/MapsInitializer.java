package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.C0414c;
import com.google.android.gms.maps.internal.C0432u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static void m1482a(C0414c c0414c) {
        try {
            CameraUpdateFactory.m1480a(c0414c.jH());
            BitmapDescriptorFactory.m1510a(c0414c.jI());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static int initialize(Context context) {
        hm.m1232f(context);
        try {
            m1482a(C0432u.m1505H(context));
            return 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            return e.errorCode;
        }
    }
}
