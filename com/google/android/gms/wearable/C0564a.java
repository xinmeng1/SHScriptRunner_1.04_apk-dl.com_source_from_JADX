package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wearable.a */
public class C0564a implements Creator<Asset> {
    static void m1804a(Asset asset, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, asset.xM);
        C0200b.m251a(parcel, 2, asset.getData(), false);
        C0200b.m247a(parcel, 3, asset.getDigest(), false);
        C0200b.m243a(parcel, 4, asset.alh, i, false);
        C0200b.m243a(parcel, 5, asset.uri, i, false);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cs(x0);
    }

    public Asset cs(Parcel parcel) {
        Uri uri = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bArr = C0199a.m223r(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0199a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public Asset[] ea(int i) {
        return new Asset[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ea(x0);
    }
}
