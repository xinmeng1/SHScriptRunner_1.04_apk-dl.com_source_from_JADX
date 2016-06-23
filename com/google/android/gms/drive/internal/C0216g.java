package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.g */
public class C0216g implements Creator<CreateContentsRequest> {
    static void m346a(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, createContentsRequest.xM);
        C0200b.m235G(parcel, C);
    }

    public CreateContentsRequest m347W(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CreateContentsRequest(i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CreateContentsRequest[] aR(int i) {
        return new CreateContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m347W(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aR(x0);
    }
}
