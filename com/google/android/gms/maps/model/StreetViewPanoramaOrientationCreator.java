package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class StreetViewPanoramaOrientationCreator implements Creator<StreetViewPanoramaOrientation> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1523a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, streetViewPanoramaOrientation.getVersionCode());
        C0200b.m238a(parcel, 2, streetViewPanoramaOrientation.tilt);
        C0200b.m238a(parcel, 3, streetViewPanoramaOrientation.bearing);
        C0200b.m235G(parcel, C);
    }

    public StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int B = C0199a.m196B(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    f2 = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaOrientation[] newArray(int size) {
        return new StreetViewPanoramaOrientation[size];
    }
}
