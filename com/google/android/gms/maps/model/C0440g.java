package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0440g {
    static void m1533a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, polygonOptions.getVersionCode());
        C0200b.m258b(parcel, 2, polygonOptions.getPoints(), false);
        C0200b.m260c(parcel, 3, polygonOptions.jP(), false);
        C0200b.m238a(parcel, 4, polygonOptions.getStrokeWidth());
        C0200b.m259c(parcel, 5, polygonOptions.getStrokeColor());
        C0200b.m259c(parcel, 6, polygonOptions.getFillColor());
        C0200b.m238a(parcel, 7, polygonOptions.getZIndex());
        C0200b.m250a(parcel, 8, polygonOptions.isVisible());
        C0200b.m250a(parcel, 9, polygonOptions.isGeodesic());
        C0200b.m235G(parcel, C);
    }
}
