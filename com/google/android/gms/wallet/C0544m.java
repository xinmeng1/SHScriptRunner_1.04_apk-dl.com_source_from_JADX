package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.m */
public class C0544m implements Creator<NotifyTransactionStatusRequest> {
    static void m1784a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, notifyTransactionStatusRequest.xM);
        C0200b.m247a(parcel, 2, notifyTransactionStatusRequest.aiQ, false);
        C0200b.m259c(parcel, 3, notifyTransactionStatusRequest.status);
        C0200b.m247a(parcel, 4, notifyTransactionStatusRequest.ajR, false);
        C0200b.m235G(parcel, C);
    }

    public NotifyTransactionStatusRequest cb(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cb(x0);
    }

    public NotifyTransactionStatusRequest[] dH(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dH(x0);
    }
}
