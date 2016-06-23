package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class fq implements Creator<fp> {
    static void m1075a(fp fpVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, fpVar.name, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fpVar.xM);
        C0200b.m247a(parcel, 2, fpVar.yb, false);
        C0200b.m250a(parcel, 3, fpVar.yc);
        C0200b.m259c(parcel, 4, fpVar.weight);
        C0200b.m250a(parcel, 5, fpVar.yd);
        C0200b.m247a(parcel, 6, fpVar.ye, false);
        C0200b.m253a(parcel, 7, fpVar.yf, i, false);
        C0200b.m252a(parcel, 8, fpVar.yg, false);
        C0200b.m247a(parcel, 11, fpVar.yh, false);
        C0200b.m235G(parcel, C);
    }

    public fp[] m1076J(int i) {
        return new fp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1077p(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1076J(x0);
    }

    public fp m1077p(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 1;
        int[] iArr = null;
        fm[] fmVarArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    fmVarArr = (fm[]) C0199a.m206b(parcel, A, fm.CREATOR);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    iArr = C0199a.m226u(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new fp(i2, str4, str3, z2, i, z, str2, fmVarArr, iArr, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
