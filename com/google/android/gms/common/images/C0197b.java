package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.common.images.b */
public class C0197b implements Creator<WebImage> {
    static void m192a(WebImage webImage, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, webImage.getVersionCode());
        C0200b.m243a(parcel, 2, webImage.getUrl(), i, false);
        C0200b.m259c(parcel, 3, webImage.getWidth());
        C0200b.m259c(parcel, 4, webImage.getHeight());
        C0200b.m235G(parcel, C);
    }

    public WebImage[] ak(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m193y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ak(x0);
    }

    public WebImage m193y(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            Uri uri2;
            int g;
            int A = C0199a.m194A(parcel);
            int i4;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = C0199a.m212g(parcel, A);
                    A = i4;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    A = i;
                    i = i4;
                    break;
                case DetectedActivity.STILL /*3*/:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = C0199a.m212g(parcel, A);
                    A = i4;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    A = C0199a.m212g(parcel, A);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    A = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
