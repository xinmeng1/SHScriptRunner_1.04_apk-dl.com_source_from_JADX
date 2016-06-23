package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

public class an implements Creator<OnLoadRealtimeResponse> {
    static void m327a(OnLoadRealtimeResponse onLoadRealtimeResponse, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, onLoadRealtimeResponse.xM);
        C0200b.m250a(parcel, 2, onLoadRealtimeResponse.JC);
        C0200b.m235G(parcel, C);
    }

    public OnLoadRealtimeResponse ao(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnLoadRealtimeResponse(i, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public OnLoadRealtimeResponse[] bk(int i) {
        return new OnLoadRealtimeResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ao(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bk(x0);
    }
}
