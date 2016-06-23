package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class aa implements Creator<C1015z> {
    static void m1807a(C1015z c1015z, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c1015z.versionCode);
        C0200b.m259c(parcel, 2, c1015z.statusCode);
        C0200b.m243a(parcel, 3, c1015z.alQ, i, false);
        C0200b.m235G(parcel, C);
    }

    public C1015z cD(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        ai aiVar = null;
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
                    aiVar = (ai) C0199a.m201a(parcel, A, ai.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1015z(i2, i, aiVar);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cD(x0);
    }

    public C1015z[] em(int i) {
        return new C1015z[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return em(x0);
    }
}
