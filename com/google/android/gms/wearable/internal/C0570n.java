package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.n */
public class C0570n implements Creator<C1185m> {
    static void m1849a(C1185m c1185m, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c1185m.xM);
        C0200b.m243a(parcel, 2, c1185m.getUri(), i, false);
        C0200b.m240a(parcel, 4, c1185m.nm(), false);
        C0200b.m251a(parcel, 5, c1185m.getData(), false);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cx(x0);
    }

    public C1185m cx(Parcel parcel) {
        byte[] bArr = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < B) {
            Bundle bundle2;
            Uri uri2;
            int g;
            byte[] bArr2;
            int A = C0199a.m194A(parcel);
            byte[] bArr3;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = C0199a.m212g(parcel, A);
                    bArr2 = bArr3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri2 = uri;
                    g = i;
                    bArr3 = bArr;
                    bundle2 = C0199a.m222q(parcel, A);
                    bArr2 = bArr3;
                    break;
                case DetectedActivity.TILTING /*5*/:
                    bArr2 = C0199a.m223r(parcel, A);
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
            }
            i = g;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == B) {
            return new C1185m(i, uri, bundle, bArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C1185m[] eg(int i) {
        return new C1185m[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eg(x0);
    }
}
