package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0438e {
    static void m1531a(LatLng latLng, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, latLng.getVersionCode());
        C0200b.m237a(parcel, 2, latLng.latitude);
        C0200b.m237a(parcel, 3, latLng.longitude);
        C0200b.m235G(parcel, C);
    }
}
