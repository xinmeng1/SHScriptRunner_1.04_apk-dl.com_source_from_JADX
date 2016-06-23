package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.ig;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.e */
public class C0551e implements Creator<C0992d> {
    static void m1789a(C0992d c0992d, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0992d.getVersionCode());
        C0200b.m247a(parcel, 2, c0992d.akP, false);
        C0200b.m247a(parcel, 3, c0992d.akQ, false);
        C0200b.m258b(parcel, 4, c0992d.akR, false);
        C0200b.m235G(parcel, C);
    }

    public C0992d cl(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        ArrayList ga = ig.ga();
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
                case DetectedActivity.UNKNOWN /*4*/:
                    ga = C0199a.m207c(parcel, A, C0991b.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0992d(i, str2, str, ga);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cl(x0);
    }

    public C0992d[] dT(int i) {
        return new C0992d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dT(x0);
    }
}
