package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0434a {
    static void m1527a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, cameraPosition.getVersionCode());
        C0200b.m243a(parcel, 2, cameraPosition.target, i, false);
        C0200b.m238a(parcel, 3, cameraPosition.zoom);
        C0200b.m238a(parcel, 4, cameraPosition.tilt);
        C0200b.m238a(parcel, 5, cameraPosition.bearing);
        C0200b.m235G(parcel, C);
    }
}
