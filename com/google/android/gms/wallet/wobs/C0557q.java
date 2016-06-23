package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.wobs.q */
public class C0557q implements Creator<C0998p> {
    static void m1795a(C0998p c0998p, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0998p.getVersionCode());
        C0200b.m247a(parcel, 2, c0998p.akZ, false);
        C0200b.m247a(parcel, 3, c0998p.qe, false);
        C0200b.m243a(parcel, 4, c0998p.ald, i, false);
        C0200b.m243a(parcel, 5, c0998p.ale, i, false);
        C0200b.m243a(parcel, 6, c0998p.alf, i, false);
        C0200b.m235G(parcel, C);
    }

    public C0998p cr(Parcel parcel) {
        C0997n c0997n = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        C0997n c0997n2 = null;
        C0996l c0996l = null;
        String str = null;
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
                    c0996l = (C0996l) C0199a.m201a(parcel, A, C0996l.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    c0997n2 = (C0997n) C0199a.m201a(parcel, A, C0997n.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    c0997n = (C0997n) C0199a.m201a(parcel, A, C0997n.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0998p(i, str2, str, c0996l, c0997n2, c0997n);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cr(x0);
    }

    public C0998p[] dZ(int i) {
        return new C0998p[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dZ(x0);
    }
}
