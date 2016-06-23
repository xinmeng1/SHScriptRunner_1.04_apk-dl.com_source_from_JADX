package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.cast.b */
public class C0172b implements Creator<CastDevice> {
    static void m116a(CastDevice castDevice, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, castDevice.getVersionCode());
        C0200b.m247a(parcel, 2, castDevice.getDeviceId(), false);
        C0200b.m247a(parcel, 3, castDevice.Ai, false);
        C0200b.m247a(parcel, 4, castDevice.getFriendlyName(), false);
        C0200b.m247a(parcel, 5, castDevice.getModelName(), false);
        C0200b.m247a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0200b.m259c(parcel, 7, castDevice.getServicePort());
        C0200b.m258b(parcel, 8, castDevice.getIcons(), false);
        C0200b.m259c(parcel, 9, castDevice.getCapabilities());
        C0200b.m235G(parcel, C);
    }

    public CastDevice[] m117P(int i) {
        return new CastDevice[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m118s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m117P(x0);
    }

    public CastDevice m118s(Parcel parcel) {
        int i = 0;
        List list = null;
        int B = C0199a.m196B(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
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
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    list = C0199a.m207c(parcel, A, WebImage.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CastDevice(i3, str5, str4, str3, str2, str, i2, list, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
