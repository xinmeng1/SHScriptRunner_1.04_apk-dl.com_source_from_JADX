package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wearable.DataEvent;

public class am implements Creator<OnMetadataResponse> {
    static void m326a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, onMetadataResponse.xM);
        C0200b.m243a(parcel, 2, onMetadataResponse.IE, i, false);
        C0200b.m235G(parcel, C);
    }

    public OnMetadataResponse an(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    metadataBundle = (MetadataBundle) C0199a.m201a(parcel, A, MetadataBundle.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public OnMetadataResponse[] bj(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return an(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bj(x0);
    }
}
