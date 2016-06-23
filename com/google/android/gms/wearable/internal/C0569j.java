package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.j */
public class C0569j implements Creator<DataItemAssetParcelable> {
    static void m1848a(DataItemAssetParcelable dataItemAssetParcelable, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, dataItemAssetParcelable.xM);
        C0200b.m247a(parcel, 2, dataItemAssetParcelable.getId(), false);
        C0200b.m247a(parcel, 3, dataItemAssetParcelable.getDataItemKey(), false);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cw(x0);
    }

    public DataItemAssetParcelable cw(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
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
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new DataItemAssetParcelable(i, str2, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public DataItemAssetParcelable[] ef(int i) {
        return new DataItemAssetParcelable[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ef(x0);
    }
}
