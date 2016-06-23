package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.c */
public class C0568c implements Creator<C1007b> {
    static void m1847a(C1007b c1007b, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c1007b.xM);
        C0200b.m241a(parcel, 2, c1007b.no(), false);
        C0200b.m253a(parcel, 3, c1007b.alA, i, false);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cv(x0);
    }

    public C1007b cv(Parcel parcel) {
        IntentFilter[] intentFilterArr = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iBinder = C0199a.m221p(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    intentFilterArr = (IntentFilter[]) C0199a.m206b(parcel, A, IntentFilter.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1007b(i, iBinder, intentFilterArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C1007b[] ee(int i) {
        return new C1007b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ee(x0);
    }
}
