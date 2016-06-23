package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class LatLngCreator implements Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1516a(LatLng latLng, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, latLng.getVersionCode());
        C0200b.m237a(parcel, 2, latLng.latitude);
        C0200b.m237a(parcel, 3, latLng.longitude);
        C0200b.m235G(parcel, C);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int B = C0199a.m196B(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    d2 = C0199a.m218m(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    d = C0199a.m218m(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LatLng(i, d2, d);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
