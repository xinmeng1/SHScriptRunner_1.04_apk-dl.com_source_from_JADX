package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.hv.C0784a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class hx implements Creator<C0784a> {
    static void m1246a(C0784a c0784a, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0784a.versionCode);
        C0200b.m247a(parcel, 2, c0784a.GZ, false);
        C0200b.m259c(parcel, 3, c0784a.Ha);
        C0200b.m235G(parcel, C);
    }

    public C0784a m1247G(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
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
            return new C0784a(i2, str, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C0784a[] av(int i) {
        return new C0784a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1247G(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return av(x0);
    }
}
