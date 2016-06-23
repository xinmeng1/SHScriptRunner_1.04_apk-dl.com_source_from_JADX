package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class jp implements Creator<jo> {
    static void m1309a(jo joVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, joVar.xM);
        C0200b.m247a(parcel, 2, joVar.jj(), false);
        C0200b.m247a(parcel, 3, joVar.getTag(), false);
        C0200b.m235G(parcel, C);
    }

    public jo bw(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
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
            return new jo(i, str2, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public jo[] cR(int i) {
        return new jo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cR(x0);
    }
}
