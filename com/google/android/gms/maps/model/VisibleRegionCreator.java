package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1526a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, visibleRegion.getVersionCode());
        C0200b.m243a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0200b.m243a(parcel, 3, visibleRegion.nearRight, i, false);
        C0200b.m243a(parcel, 4, visibleRegion.farLeft, i, false);
        C0200b.m243a(parcel, 5, visibleRegion.farRight, i, false);
        C0200b.m243a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0200b.m235G(parcel, C);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng4 = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    latLng3 = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    latLng2 = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    latLng = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    latLngBounds = (LatLngBounds) C0199a.m201a(parcel, A, LatLngBounds.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
