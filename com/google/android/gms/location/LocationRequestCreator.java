package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.wearable.DataEvent;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1477a(LocationRequest locationRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, locationRequest.mPriority);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequest.getVersionCode());
        C0200b.m239a(parcel, 2, locationRequest.Vl);
        C0200b.m239a(parcel, 3, locationRequest.Vm);
        C0200b.m250a(parcel, 4, locationRequest.Vn);
        C0200b.m239a(parcel, 5, locationRequest.Vb);
        C0200b.m259c(parcel, 6, locationRequest.Vo);
        C0200b.m238a(parcel, 7, locationRequest.Vp);
        C0200b.m235G(parcel, C);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        int i = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    j3 = C0199a.m214i(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
