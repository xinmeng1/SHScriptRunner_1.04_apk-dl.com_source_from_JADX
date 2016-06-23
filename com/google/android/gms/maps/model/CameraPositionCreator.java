package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class CameraPositionCreator implements Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1511a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, cameraPosition.getVersionCode());
        C0200b.m243a(parcel, 2, cameraPosition.target, i, false);
        C0200b.m238a(parcel, 3, cameraPosition.zoom);
        C0200b.m238a(parcel, 4, cameraPosition.tilt);
        C0200b.m238a(parcel, 5, cameraPosition.bearing);
        C0200b.m235G(parcel, C);
    }

    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int B = C0199a.m196B(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    f3 = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f2 = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CameraPosition[] newArray(int size) {
        return new CameraPosition[size];
    }
}
