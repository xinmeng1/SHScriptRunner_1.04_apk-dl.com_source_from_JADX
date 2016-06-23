package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0437d {
    static void m1530a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, latLngBounds.getVersionCode());
        C0200b.m243a(parcel, 2, latLngBounds.southwest, i, false);
        C0200b.m243a(parcel, 3, latLngBounds.northeast, i, false);
        C0200b.m235G(parcel, C);
    }
}
