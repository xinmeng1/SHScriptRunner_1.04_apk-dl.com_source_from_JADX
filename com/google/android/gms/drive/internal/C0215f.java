package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.f */
public class C0215f implements Creator<CloseContentsRequest> {
    static void m344a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, closeContentsRequest.xM);
        C0200b.m243a(parcel, 2, closeContentsRequest.Iw, i, false);
        C0200b.m244a(parcel, 3, closeContentsRequest.Iz, false);
        C0200b.m235G(parcel, C);
    }

    public CloseContentsRequest m345V(Parcel parcel) {
        Boolean bool = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < B) {
            Contents contents2;
            int g;
            Boolean bool2;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = C0199a.m212g(parcel, A);
                    bool2 = bool3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    Contents contents3 = (Contents) C0199a.m201a(parcel, A, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    bool2 = C0199a.m209d(parcel, A);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == B) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CloseContentsRequest[] aQ(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m345V(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
