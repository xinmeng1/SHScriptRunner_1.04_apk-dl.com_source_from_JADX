package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.q */
public class C0275q implements Creator<ParcelableIndexReference> {
    static void m455a(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, parcelableIndexReference.xM);
        C0200b.m247a(parcel, 2, parcelableIndexReference.Lq, false);
        C0200b.m259c(parcel, 3, parcelableIndexReference.mIndex);
        C0200b.m250a(parcel, 4, parcelableIndexReference.Lr);
        C0200b.m235G(parcel, C);
    }

    public ParcelableIndexReference aS(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableIndexReference(i2, str, i, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableIndexReference[] bP(int i) {
        return new ParcelableIndexReference[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bP(x0);
    }
}
