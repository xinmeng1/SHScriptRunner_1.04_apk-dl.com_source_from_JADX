package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.identity.intents.model.a */
public class C0294a implements Creator<CountrySpecification> {
    static void m757a(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, countrySpecification.getVersionCode());
        C0200b.m247a(parcel, 2, countrySpecification.rf, false);
        C0200b.m235G(parcel, C);
    }

    public CountrySpecification bq(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CountrySpecification(i, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CountrySpecification[] cD(int i) {
        return new CountrySpecification[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cD(x0);
    }
}
