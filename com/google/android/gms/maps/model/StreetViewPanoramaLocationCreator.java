package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class StreetViewPanoramaLocationCreator implements Creator<StreetViewPanoramaLocation> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1522a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        C0200b.m253a(parcel, 2, streetViewPanoramaLocation.links, i, false);
        C0200b.m243a(parcel, 3, streetViewPanoramaLocation.position, i, false);
        C0200b.m247a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C0200b.m235G(parcel, C);
    }

    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < B) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int g;
            String str2;
            int A = C0199a.m194A(parcel);
            String str3;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = C0199a.m212g(parcel, A);
                    str2 = str3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) C0199a.m206b(parcel, A, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    str3 = str;
                    latLng2 = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str2 = C0199a.m220o(parcel, A);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
            }
            i = g;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == B) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaLocation[] newArray(int size) {
        return new StreetViewPanoramaLocation[size];
    }
}
