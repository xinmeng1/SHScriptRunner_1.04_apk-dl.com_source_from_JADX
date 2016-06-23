package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.a */
public class C0231a implements Creator<AppVisibleCustomProperties> {
    static void m367a(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, appVisibleCustomProperties.xM);
        C0200b.m258b(parcel, 2, appVisibleCustomProperties.JO, false);
        C0200b.m235G(parcel, C);
    }

    public AppVisibleCustomProperties aA(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    collection = C0199a.m207c(parcel, A, CustomProperty.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public AppVisibleCustomProperties[] bw(int i) {
        return new AppVisibleCustomProperties[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bw(x0);
    }
}
