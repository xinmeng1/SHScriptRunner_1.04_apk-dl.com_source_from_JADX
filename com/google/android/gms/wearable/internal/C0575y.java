package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.y */
public class C0575y implements Creator<C1014x> {
    static void m1854a(C1014x c1014x, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c1014x.versionCode);
        C0200b.m259c(parcel, 2, c1014x.statusCode);
        C0200b.m243a(parcel, 3, c1014x.alP, i, false);
        C0200b.m235G(parcel, C);
    }

    public C1014x cC(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) C0199a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1014x(i2, i, parcelFileDescriptor);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cC(x0);
    }

    public C1014x[] el(int i) {
        return new C1014x[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return el(x0);
    }
}
