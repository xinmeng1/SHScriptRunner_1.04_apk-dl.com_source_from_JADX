package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.hy.C0785a;
import com.google.android.gms.internal.ib.C0787b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class ia implements Creator<C0787b> {
    static void m1256a(C0787b c0787b, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0787b.versionCode);
        C0200b.m247a(parcel, 2, c0787b.eM, false);
        C0200b.m243a(parcel, 3, c0787b.Hp, i, false);
        C0200b.m235G(parcel, C);
    }

    public C0787b m1257I(Parcel parcel) {
        C0785a c0785a = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    c0785a = (C0785a) C0199a.m201a(parcel, A, C0785a.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0787b(i, str, c0785a);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C0787b[] ax(int i) {
        return new C0787b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1257I(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ax(x0);
    }
}
