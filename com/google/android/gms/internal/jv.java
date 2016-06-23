package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class jv implements Creator<ju> {
    static void m1312a(ju juVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, juVar.getName(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, juVar.xM);
        C0200b.m243a(parcel, 2, juVar.jk(), i, false);
        C0200b.m247a(parcel, 3, juVar.getAddress(), false);
        C0200b.m258b(parcel, 4, juVar.jl(), false);
        C0200b.m247a(parcel, 5, juVar.getPhoneNumber(), false);
        C0200b.m247a(parcel, 6, juVar.jm(), false);
        C0200b.m235G(parcel, C);
    }

    public ju bz(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str2 = null;
        List list = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    list = C0199a.m207c(parcel, A, js.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ju(i, str4, latLng, str3, list, str2, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ju[] cU(int i) {
        return new ju[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cU(x0);
    }
}
