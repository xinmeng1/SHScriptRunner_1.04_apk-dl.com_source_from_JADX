package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.wearable.DataEvent;

public class ag implements Creator<OnContentsResponse> {
    static void m320a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, onContentsResponse.xM);
        C0200b.m243a(parcel, 2, onContentsResponse.HG, i, false);
        C0200b.m235G(parcel, C);
    }

    public OnContentsResponse ah(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    contents = (Contents) C0199a.m201a(parcel, A, Contents.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnContentsResponse(i, contents);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public OnContentsResponse[] bd(int i) {
        return new OnContentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ah(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bd(x0);
    }
}
