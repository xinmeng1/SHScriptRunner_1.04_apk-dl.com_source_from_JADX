package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1519a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, polylineOptions.getVersionCode());
        C0200b.m258b(parcel, 2, polylineOptions.getPoints(), false);
        C0200b.m238a(parcel, 3, polylineOptions.getWidth());
        C0200b.m259c(parcel, 4, polylineOptions.getColor());
        C0200b.m238a(parcel, 5, polylineOptions.getZIndex());
        C0200b.m250a(parcel, 6, polylineOptions.isVisible());
        C0200b.m250a(parcel, 7, polylineOptions.isGeodesic());
        C0200b.m235G(parcel, C);
    }

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int B = C0199a.m196B(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0199a.m207c(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    f2 = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
