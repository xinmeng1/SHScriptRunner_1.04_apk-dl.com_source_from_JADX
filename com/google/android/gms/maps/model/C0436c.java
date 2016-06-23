package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C0436c {
    static void m1529a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0200b.m241a(parcel, 2, groundOverlayOptions.jN(), false);
        C0200b.m243a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0200b.m238a(parcel, 4, groundOverlayOptions.getWidth());
        C0200b.m238a(parcel, 5, groundOverlayOptions.getHeight());
        C0200b.m243a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0200b.m238a(parcel, 7, groundOverlayOptions.getBearing());
        C0200b.m238a(parcel, 8, groundOverlayOptions.getZIndex());
        C0200b.m250a(parcel, 9, groundOverlayOptions.isVisible());
        C0200b.m238a(parcel, 10, groundOverlayOptions.getTransparency());
        C0200b.m238a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0200b.m238a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0200b.m235G(parcel, C);
    }
}
