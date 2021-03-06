package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class an implements Creator<am> {
    static void m1843a(am amVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, amVar.versionCode);
        C0200b.m259c(parcel, 2, amVar.statusCode);
        C0200b.m243a(parcel, 3, amVar.alO, i, false);
        C0200b.m235G(parcel, C);
    }

    public am cH(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        C1185m c1185m = null;
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
                    c1185m = (C1185m) C0199a.m201a(parcel, A, C1185m.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new am(i2, i, c1185m);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cH(x0);
    }

    public am[] eq(int i) {
        return new am[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eq(x0);
    }
}
