package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0200b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0442i {
    static void m1535a(Tile tile, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, tile.getVersionCode());
        C0200b.m259c(parcel, 2, tile.width);
        C0200b.m259c(parcel, 3, tile.height);
        C0200b.m251a(parcel, 4, tile.data, false);
        C0200b.m235G(parcel, C);
    }
}
