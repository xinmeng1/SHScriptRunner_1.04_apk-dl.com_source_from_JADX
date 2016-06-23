package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C0527b implements Creator<Cart> {
    static void m1751a(Cart cart, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, cart.getVersionCode());
        C0200b.m247a(parcel, 2, cart.aiK, false);
        C0200b.m247a(parcel, 3, cart.aiL, false);
        C0200b.m258b(parcel, 4, cart.aiM, false);
        C0200b.m235G(parcel, C);
    }

    public Cart bR(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    arrayList = C0199a.m207c(parcel, A, LineItem.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bR(x0);
    }

    public Cart[] dx(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dx(x0);
    }
}
