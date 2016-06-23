package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.internal.w */
public class C0404w implements Creator<C0826v> {
    static void m1467a(C0826v c0826v, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0826v.versionCode);
        C0200b.m250a(parcel, 2, c0826v.lb);
        C0200b.m250a(parcel, 3, c0826v.ld);
        C0200b.m235G(parcel, C);
    }

    public C0826v m1468a(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0826v(i, z2, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C0826v[] m1469b(int i) {
        return new C0826v[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1468a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1469b(x0);
    }
}
