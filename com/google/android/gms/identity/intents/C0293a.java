package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C0293a implements Creator<UserAddressRequest> {
    static void m756a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, userAddressRequest.getVersionCode());
        C0200b.m258b(parcel, 2, userAddressRequest.UE, false);
        C0200b.m235G(parcel, C);
    }

    public UserAddressRequest bp(Parcel parcel) {
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
                    list = C0199a.m207c(parcel, A, CountrySpecification.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new UserAddressRequest(i, list);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public UserAddressRequest[] cC(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cC(x0);
    }
}
