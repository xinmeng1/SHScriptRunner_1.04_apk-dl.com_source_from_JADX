package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.C1000c;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.s */
public class C0572s implements Creator<C1011r> {
    static void m1851a(C1011r c1011r, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c1011r.versionCode);
        C0200b.m259c(parcel, 2, c1011r.statusCode);
        C0200b.m243a(parcel, 3, c1011r.alM, i, false);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cz(x0);
    }

    public C1011r cz(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        C1000c c1000c = null;
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
                    c1000c = (C1000c) C0199a.m201a(parcel, A, C1000c.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1011r(i2, i, c1000c);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C1011r[] ei(int i) {
        return new C1011r[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ei(x0);
    }
}
