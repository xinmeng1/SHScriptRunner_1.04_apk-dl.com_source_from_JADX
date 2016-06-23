package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.e */
public class C0258e implements Creator<TextDeletedDetails> {
    static void m396a(TextDeletedDetails textDeletedDetails, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, textDeletedDetails.xM);
        C0200b.m259c(parcel, 2, textDeletedDetails.mIndex);
        C0200b.m259c(parcel, 3, textDeletedDetails.LL);
        C0200b.m235G(parcel, C);
    }

    public TextDeletedDetails aX(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new TextDeletedDetails(i3, i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public TextDeletedDetails[] bU(int i) {
        return new TextDeletedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bU(x0);
    }
}
