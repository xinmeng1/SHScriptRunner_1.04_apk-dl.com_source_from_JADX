package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class CircleOptionsCreator implements Creator<CircleOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1512a(CircleOptions circleOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, circleOptions.getVersionCode());
        C0200b.m243a(parcel, 2, circleOptions.getCenter(), i, false);
        C0200b.m237a(parcel, 3, circleOptions.getRadius());
        C0200b.m238a(parcel, 4, circleOptions.getStrokeWidth());
        C0200b.m259c(parcel, 5, circleOptions.getStrokeColor());
        C0200b.m259c(parcel, 6, circleOptions.getFillColor());
        C0200b.m238a(parcel, 7, circleOptions.getZIndex());
        C0200b.m250a(parcel, 8, circleOptions.isVisible());
        C0200b.m235G(parcel, C);
    }

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int B = C0199a.m196B(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    d = C0199a.m218m(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f2 = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
