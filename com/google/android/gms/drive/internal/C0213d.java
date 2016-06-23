package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.internal.d */
public class C0213d implements Creator<CheckResourceIdsExistRequest> {
    static void m340a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        C0200b.m248a(parcel, 2, checkResourceIdsExistRequest.go(), false);
        C0200b.m235G(parcel, C);
    }

    public CheckResourceIdsExistRequest m341T(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0199a.m197B(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CheckResourceIdsExistRequest(i, list);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CheckResourceIdsExistRequest[] aO(int i) {
        return new CheckResourceIdsExistRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m341T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aO(x0);
    }
}
