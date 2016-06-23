package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class cd implements Creator<ce> {
    static void m848a(ce ceVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, ceVar.versionCode);
        C0200b.m247a(parcel, 2, ceVar.oa, false);
        C0200b.m247a(parcel, 3, ceVar.ob, false);
        C0200b.m247a(parcel, 4, ceVar.mimeType, false);
        C0200b.m247a(parcel, 5, ceVar.packageName, false);
        C0200b.m247a(parcel, 6, ceVar.oc, false);
        C0200b.m247a(parcel, 7, ceVar.od, false);
        C0200b.m247a(parcel, 8, ceVar.oe, false);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m849e(x0);
    }

    public ce m849e(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str7 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str6 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ce(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ce[] m850i(int i) {
        return new ce[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m850i(x0);
    }
}
