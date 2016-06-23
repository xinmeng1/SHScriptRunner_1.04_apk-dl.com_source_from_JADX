package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0441h {
    static void m1534a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, polylineOptions.getVersionCode());
        C0200b.m258b(parcel, 2, polylineOptions.getPoints(), false);
        C0200b.m238a(parcel, 3, polylineOptions.getWidth());
        C0200b.m259c(parcel, 4, polylineOptions.getColor());
        C0200b.m238a(parcel, 5, polylineOptions.getZIndex());
        C0200b.m250a(parcel, 6, polylineOptions.isVisible());
        C0200b.m250a(parcel, 7, polylineOptions.isGeodesic());
        C0200b.m235G(parcel, C);
    }
}
