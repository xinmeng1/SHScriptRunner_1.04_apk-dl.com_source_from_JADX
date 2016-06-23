package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.g */
public class C0260g implements Creator<ValueChangedDetails> {
    static void m398a(ValueChangedDetails valueChangedDetails, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, valueChangedDetails.xM);
        C0200b.m259c(parcel, 2, valueChangedDetails.LM);
        C0200b.m235G(parcel, C);
    }

    public ValueChangedDetails aZ(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ValueChangedDetails(i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ValueChangedDetails[] bW(int i) {
        return new ValueChangedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bW(x0);
    }
}
