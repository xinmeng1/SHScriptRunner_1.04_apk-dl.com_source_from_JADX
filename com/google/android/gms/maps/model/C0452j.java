package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0452j {
    static void m1548a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0200b.m241a(parcel, 2, tileOverlayOptions.jQ(), false);
        C0200b.m250a(parcel, 3, tileOverlayOptions.isVisible());
        C0200b.m238a(parcel, 4, tileOverlayOptions.getZIndex());
        C0200b.m235G(parcel, C);
    }
}
