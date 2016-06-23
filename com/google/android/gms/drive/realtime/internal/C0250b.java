package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.b */
public class C0250b implements Creator<EndCompoundOperationRequest> {
    static void m385a(EndCompoundOperationRequest endCompoundOperationRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, endCompoundOperationRequest.xM);
        C0200b.m235G(parcel, C);
    }

    public EndCompoundOperationRequest aQ(Parcel parcel) {
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
            return new EndCompoundOperationRequest(i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public EndCompoundOperationRequest[] bM(int i) {
        return new EndCompoundOperationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bM(x0);
    }
}
