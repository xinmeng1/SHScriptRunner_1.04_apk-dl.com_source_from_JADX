package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0439f {
    static void m1532a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, markerOptions.getVersionCode());
        C0200b.m243a(parcel, 2, markerOptions.getPosition(), i, false);
        C0200b.m247a(parcel, 3, markerOptions.getTitle(), false);
        C0200b.m247a(parcel, 4, markerOptions.getSnippet(), false);
        C0200b.m241a(parcel, 5, markerOptions.jO(), false);
        C0200b.m238a(parcel, 6, markerOptions.getAnchorU());
        C0200b.m238a(parcel, 7, markerOptions.getAnchorV());
        C0200b.m250a(parcel, 8, markerOptions.isDraggable());
        C0200b.m250a(parcel, 9, markerOptions.isVisible());
        C0200b.m235G(parcel, C);
    }
}
