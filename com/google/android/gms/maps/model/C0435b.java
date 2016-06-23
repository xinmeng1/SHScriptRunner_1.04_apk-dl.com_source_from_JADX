package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0435b {
    static void m1528a(CircleOptions circleOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, circleOptions.getVersionCode());
        C0200b.m243a(parcel, 2, circleOptions.getCenter(), i, false);
        C0200b.m237a(parcel, 3, circleOptions.getRadius());
        C0200b.m238a(parcel, 4, circleOptions.getStrokeWidth());
        C0200b.m259c(parcel, 5, circleOptions.getStrokeColor());
        C0200b.m259c(parcel, 6, circleOptions.getFillColor());
        C0200b.m238a(parcel, 7, circleOptions.getZIndex());
        C0200b.m250a(parcel, 8, circleOptions.isVisible());
        C0200b.m235G(parcel, C);
    }
}
