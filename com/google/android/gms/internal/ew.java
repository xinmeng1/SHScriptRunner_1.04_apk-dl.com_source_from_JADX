package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class ew implements Creator<ev> {
    static void m1020a(ev evVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, evVar.versionCode);
        C0200b.m247a(parcel, 2, evVar.sw, false);
        C0200b.m259c(parcel, 3, evVar.sx);
        C0200b.m259c(parcel, 4, evVar.sy);
        C0200b.m250a(parcel, 5, evVar.sz);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1021j(x0);
    }

    public ev m1021j(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ev(i3, str, i2, i, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1022q(x0);
    }

    public ev[] m1022q(int i) {
        return new ev[i];
    }
}
