package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.u */
public class C0573u implements Creator<C1012t> {
    static void m1852a(C1012t c1012t, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c1012t.versionCode);
        C0200b.m259c(parcel, 2, c1012t.statusCode);
        C0200b.m258b(parcel, 3, c1012t.alN, false);
        C0200b.m235G(parcel, C);
    }

    public C1012t cA(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        List list = null;
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
                    list = C0199a.m207c(parcel, A, ai.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1012t(i2, i, list);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cA(x0);
    }

    public C1012t[] ej(int i) {
        return new C1012t[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ej(x0);
    }
}
