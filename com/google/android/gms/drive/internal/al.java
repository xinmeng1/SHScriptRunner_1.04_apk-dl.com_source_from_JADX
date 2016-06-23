package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

public class al implements Creator<OnListParentsResponse> {
    static void m325a(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, onListParentsResponse.xM);
        C0200b.m243a(parcel, 2, onListParentsResponse.JB, i, false);
        C0200b.m235G(parcel, C);
    }

    public OnListParentsResponse am(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    dataHolder = (DataHolder) C0199a.m201a(parcel, A, DataHolder.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public OnListParentsResponse[] bi(int i) {
        return new OnListParentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return am(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bi(x0);
    }
}
