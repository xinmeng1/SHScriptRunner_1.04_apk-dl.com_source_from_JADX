package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.i */
public class C0540i implements Creator<LineItem> {
    static void m1780a(LineItem lineItem, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, lineItem.getVersionCode());
        C0200b.m247a(parcel, 2, lineItem.description, false);
        C0200b.m247a(parcel, 3, lineItem.aje, false);
        C0200b.m247a(parcel, 4, lineItem.ajf, false);
        C0200b.m247a(parcel, 5, lineItem.aiK, false);
        C0200b.m259c(parcel, 6, lineItem.ajg);
        C0200b.m247a(parcel, 7, lineItem.aiL, false);
        C0200b.m235G(parcel, C);
    }

    public LineItem bX(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = C0199a.m196B(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bX(x0);
    }

    public LineItem[] dD(int i) {
        return new LineItem[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dD(x0);
    }
}
