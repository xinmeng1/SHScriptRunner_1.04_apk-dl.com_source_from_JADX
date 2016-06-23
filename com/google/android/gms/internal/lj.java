package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class lj implements Creator<li> {
    static void m1341a(li liVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, liVar.getVersionCode());
        C0200b.m254a(parcel, 2, liVar.ake, false);
        C0200b.m255a(parcel, 3, liVar.akf, false);
        C0200b.m235G(parcel, C);
    }

    public li cf(Parcel parcel) {
        String[] strArr = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    strArr = C0199a.m195A(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    bArr = C0199a.m224s(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new li(i, strArr, bArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cf(x0);
    }

    public li[] dL(int i) {
        return new li[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dL(x0);
    }
}
