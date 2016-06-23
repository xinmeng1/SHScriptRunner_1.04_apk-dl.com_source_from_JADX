package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class ar implements Creator<aq> {
    static void m1845a(aq aqVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, aqVar.versionCode);
        C0200b.m259c(parcel, 2, aqVar.statusCode);
        C0200b.m259c(parcel, 3, aqVar.amc);
        C0200b.m235G(parcel, C);
    }

    public aq cJ(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new aq(i3, i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cJ(x0);
    }

    public aq[] es(int i) {
        return new aq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return es(x0);
    }
}
