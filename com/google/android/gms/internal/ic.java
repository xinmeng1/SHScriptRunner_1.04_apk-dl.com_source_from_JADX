package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.ib.C0786a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class ic implements Creator<ib> {
    static void m1258a(ib ibVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, ibVar.getVersionCode());
        C0200b.m258b(parcel, 2, ibVar.fV(), false);
        C0200b.m247a(parcel, 3, ibVar.fW(), false);
        C0200b.m235G(parcel, C);
    }

    public ib m1259J(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    arrayList = C0199a.m207c(parcel, A, C0786a.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ib(i, arrayList, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ib[] ay(int i) {
        return new ib[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1259J(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ay(x0);
    }
}
