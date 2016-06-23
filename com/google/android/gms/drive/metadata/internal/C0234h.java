package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public class C0234h implements Creator<MetadataBundle> {
    static void m370a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, metadataBundle.xM);
        C0200b.m240a(parcel, 2, metadataBundle.JS, false);
        C0200b.m235G(parcel, C);
    }

    public MetadataBundle aC(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bundle = C0199a.m222q(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public MetadataBundle[] by(int i) {
        return new MetadataBundle[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return by(x0);
    }
}
