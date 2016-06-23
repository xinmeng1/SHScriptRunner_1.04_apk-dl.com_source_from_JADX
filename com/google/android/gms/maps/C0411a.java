package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.a */
public class C0411a {
    static void m1484a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, googleMapOptions.getVersionCode());
        C0200b.m236a(parcel, 2, googleMapOptions.jq());
        C0200b.m236a(parcel, 3, googleMapOptions.jr());
        C0200b.m259c(parcel, 4, googleMapOptions.getMapType());
        C0200b.m243a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0200b.m236a(parcel, 6, googleMapOptions.js());
        C0200b.m236a(parcel, 7, googleMapOptions.jt());
        C0200b.m236a(parcel, 8, googleMapOptions.ju());
        C0200b.m236a(parcel, 9, googleMapOptions.jv());
        C0200b.m236a(parcel, 10, googleMapOptions.jw());
        C0200b.m236a(parcel, 11, googleMapOptions.jx());
        C0200b.m235G(parcel, C);
    }
}
