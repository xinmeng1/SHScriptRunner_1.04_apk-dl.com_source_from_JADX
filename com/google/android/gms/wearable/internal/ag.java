package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class ag implements Creator<af> {
    static void m1840a(af afVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, afVar.xM);
        C0200b.m259c(parcel, 2, afVar.getRequestId());
        C0200b.m247a(parcel, 3, afVar.getPath(), false);
        C0200b.m251a(parcel, 4, afVar.getData(), false);
        C0200b.m247a(parcel, 5, afVar.getSourceNodeId(), false);
        C0200b.m235G(parcel, C);
    }

    public af cE(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = C0199a.m196B(parcel);
        byte[] bArr = null;
        String str2 = null;
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
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    bArr = C0199a.m223r(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new af(i2, i, str2, bArr, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cE(x0);
    }

    public af[] en(int i) {
        return new af[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return en(x0);
    }
}
