package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.ks.C1135b;
import com.google.android.gms.internal.ks.C1135b.C1133a;
import com.google.android.gms.internal.ks.C1135b.C1134b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class kv implements Creator<C1135b> {
    static void m1332a(C1135b c1135b, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = c1135b.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, c1135b.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m243a(parcel, 2, c1135b.kO(), i, true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0200b.m243a(parcel, 3, c1135b.kP(), i, true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0200b.m259c(parcel, 4, c1135b.getLayout());
        }
        C0200b.m235G(parcel, C);
    }

    public C1135b bI(Parcel parcel) {
        C1134b c1134b = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        C1133a c1133a = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    C1133a c1133a2 = (C1133a) C0199a.m201a(parcel, A, C1133a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c1133a = c1133a2;
                    break;
                case DetectedActivity.STILL /*3*/:
                    C1134b c1134b2 = (C1134b) C0199a.m201a(parcel, A, C1134b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1134b = c1134b2;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1135b(hashSet, i2, c1133a, c1134b, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bI(x0);
    }

    public C1135b[] df(int i) {
        return new C1135b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return df(x0);
    }
}
