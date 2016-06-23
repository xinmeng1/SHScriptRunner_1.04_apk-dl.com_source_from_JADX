package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.common.data.b */
public class C0186b implements Creator<C0636a> {
    static void m162a(C0636a c0636a, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0636a.xM);
        C0200b.m243a(parcel, 2, c0636a.Ew, i, false);
        C0200b.m259c(parcel, 3, c0636a.AT);
        C0200b.m235G(parcel, C);
    }

    public C0636a[] ab(int i) {
        return new C0636a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m163w(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ab(x0);
    }

    public C0636a m163w(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int g;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = C0199a.m212g(parcel, A);
                    A = i3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) C0199a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    A = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    A = C0199a.m212g(parcel, A);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    A = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
            }
            i2 = g;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new C0636a(i2, parcelFileDescriptor, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
