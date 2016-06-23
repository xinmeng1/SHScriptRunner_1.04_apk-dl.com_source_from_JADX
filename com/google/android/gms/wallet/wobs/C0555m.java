package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.wobs.m */
public class C0555m implements Creator<C0996l> {
    static void m1793a(C0996l c0996l, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0996l.getVersionCode());
        C0200b.m239a(parcel, 2, c0996l.ala);
        C0200b.m239a(parcel, 3, c0996l.alb);
        C0200b.m235G(parcel, C);
    }

    public C0996l cp(Parcel parcel) {
        long j = 0;
        int B = C0199a.m196B(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0996l(i, j2, j);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cp(x0);
    }

    public C0996l[] dX(int i) {
        return new C0996l[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dX(x0);
    }
}
