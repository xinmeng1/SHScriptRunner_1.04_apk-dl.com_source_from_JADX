package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class LatLngBoundsCreator implements Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1515a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, latLngBounds.getVersionCode());
        C0200b.m243a(parcel, 2, latLngBounds.southwest, i, false);
        C0200b.m243a(parcel, 3, latLngBounds.northeast, i, false);
        C0200b.m235G(parcel, C);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < B) {
            int g;
            LatLng latLng3;
            int A = C0199a.m194A(parcel);
            LatLng latLng4;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    g = C0199a.m212g(parcel, A);
                    latLng3 = latLng4;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    latLng4 = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case DetectedActivity.STILL /*3*/:
                    latLng3 = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    latLng = latLng2;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    latLng3 = latLng;
                    latLng = latLng2;
                    g = i;
                    break;
            }
            i = g;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == B) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public LatLngBounds[] newArray(int size) {
        return new LatLngBounds[size];
    }
}
