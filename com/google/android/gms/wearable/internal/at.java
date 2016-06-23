package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class at implements Creator<as> {
    static void m1846a(as asVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, asVar.versionCode);
        C0200b.m259c(parcel, 2, asVar.statusCode);
        C0200b.m239a(parcel, 3, asVar.amb);
        C0200b.m258b(parcel, 4, asVar.amd, false);
        C0200b.m235G(parcel, C);
    }

    public as cK(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        long j = 0;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    list = C0199a.m207c(parcel, A, ak.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new as(i2, i, j, list);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cK(x0);
    }

    public as[] et(int i) {
        return new as[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return et(x0);
    }
}
