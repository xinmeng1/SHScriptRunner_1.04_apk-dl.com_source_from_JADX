package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class StreetViewPanoramaLinkCreator implements Creator<StreetViewPanoramaLink> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1521a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, streetViewPanoramaLink.getVersionCode());
        C0200b.m247a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C0200b.m238a(parcel, 3, streetViewPanoramaLink.bearing);
        C0200b.m235G(parcel, C);
    }

    public StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
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
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaLink[] newArray(int size) {
        return new StreetViewPanoramaLink[size];
    }
}
