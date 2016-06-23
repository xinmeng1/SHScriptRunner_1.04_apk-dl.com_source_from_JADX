package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class ah implements Creator<OnDownloadProgressResponse> {
    static void m321a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, onDownloadProgressResponse.xM);
        C0200b.m239a(parcel, 2, onDownloadProgressResponse.Jw);
        C0200b.m239a(parcel, 3, onDownloadProgressResponse.Jx);
        C0200b.m235G(parcel, C);
    }

    public OnDownloadProgressResponse ai(Parcel parcel) {
        long j = 0;
        int B = C0199a.m196B(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public OnDownloadProgressResponse[] be(int i) {
        return new OnDownloadProgressResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ai(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return be(x0);
    }
}
