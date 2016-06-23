package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C0453k {
    static void m1549a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, visibleRegion.getVersionCode());
        C0200b.m243a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0200b.m243a(parcel, 3, visibleRegion.nearRight, i, false);
        C0200b.m243a(parcel, 4, visibleRegion.farLeft, i, false);
        C0200b.m243a(parcel, 5, visibleRegion.farRight, i, false);
        C0200b.m243a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0200b.m235G(parcel, C);
    }
}
