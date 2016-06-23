package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.internal.if */
public class C0383if implements Creator<ie> {
    static void m1262a(ie ieVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, ieVar.getVersionCode());
        C0200b.m242a(parcel, 2, ieVar.fY(), false);
        C0200b.m243a(parcel, 3, ieVar.fZ(), i, false);
        C0200b.m235G(parcel, C);
    }

    public ie m1263L(Parcel parcel) {
        ib ibVar = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcel2 = C0199a.m198C(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    ibVar = (ib) C0199a.m201a(parcel, A, ib.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ie(i, parcel2, ibVar);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ie[] aA(int i) {
        return new ie[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1263L(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
