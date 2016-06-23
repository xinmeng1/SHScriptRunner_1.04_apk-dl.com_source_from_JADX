package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.wobs.i */
public class C0553i implements Creator<C0993f> {
    static void m1791a(C0993f c0993f, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0993f.getVersionCode());
        C0200b.m247a(parcel, 2, c0993f.label, false);
        C0200b.m243a(parcel, 3, c0993f.akS, i, false);
        C0200b.m247a(parcel, 4, c0993f.type, false);
        C0200b.m243a(parcel, 5, c0993f.ajs, i, false);
        C0200b.m235G(parcel, C);
    }

    public C0993f cn(Parcel parcel) {
        C0996l c0996l = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        C0994g c0994g = null;
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
                    c0994g = (C0994g) C0199a.m201a(parcel, A, C0994g.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    c0996l = (C0996l) C0199a.m201a(parcel, A, C0996l.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0993f(i, str2, c0994g, str, c0996l);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cn(x0);
    }

    public C0993f[] dV(int i) {
        return new C0993f[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dV(x0);
    }
}
