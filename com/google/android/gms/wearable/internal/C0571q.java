package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.q */
public class C0571q implements Creator<C1010p> {
    static void m1850a(C1010p c1010p, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c1010p.versionCode);
        C0200b.m259c(parcel, 2, c1010p.statusCode);
        C0200b.m259c(parcel, 3, c1010p.alL);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cy(x0);
    }

    public C1010p cy(Parcel parcel) {
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
            return new C1010p(i3, i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C1010p[] eh(int i) {
        return new C1010p[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eh(x0);
    }
}
