package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class gk implements Creator<gj> {
    static void m1114a(gj gjVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, gjVar.getVersionCode());
        C0200b.m237a(parcel, 2, gjVar.eh());
        C0200b.m250a(parcel, 3, gjVar.en());
        C0200b.m259c(parcel, 4, gjVar.eo());
        C0200b.m235G(parcel, C);
    }

    public gj[] m1115Y(int i) {
        return new gj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1116v(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1115Y(x0);
    }

    public gj m1116v(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        double d = 0.0d;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    d = C0199a.m218m(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new gj(i2, d, z, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
