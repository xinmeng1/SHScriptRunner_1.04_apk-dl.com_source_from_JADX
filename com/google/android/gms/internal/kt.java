package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.ks.C1132a;
import com.google.android.gms.internal.ks.C1135b;
import com.google.android.gms.internal.ks.C1136c;
import com.google.android.gms.internal.ks.C1137d;
import com.google.android.gms.internal.ks.C1138f;
import com.google.android.gms.internal.ks.C1139g;
import com.google.android.gms.internal.ks.C1140h;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class kt implements Creator<ks> {
    static void m1330a(ks ksVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = ksVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, ksVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m247a(parcel, 2, ksVar.getAboutMe(), true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0200b.m243a(parcel, 3, ksVar.kF(), i, true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0200b.m247a(parcel, 4, ksVar.getBirthday(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0200b.m247a(parcel, 5, ksVar.getBraggingRights(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0200b.m259c(parcel, 6, ksVar.getCircledByCount());
        }
        if (kk.contains(Integer.valueOf(7))) {
            C0200b.m243a(parcel, 7, ksVar.kG(), i, true);
        }
        if (kk.contains(Integer.valueOf(8))) {
            C0200b.m247a(parcel, 8, ksVar.getCurrentLocation(), true);
        }
        if (kk.contains(Integer.valueOf(9))) {
            C0200b.m247a(parcel, 9, ksVar.getDisplayName(), true);
        }
        if (kk.contains(Integer.valueOf(12))) {
            C0200b.m259c(parcel, 12, ksVar.getGender());
        }
        if (kk.contains(Integer.valueOf(14))) {
            C0200b.m247a(parcel, 14, ksVar.getId(), true);
        }
        if (kk.contains(Integer.valueOf(15))) {
            C0200b.m243a(parcel, 15, ksVar.kH(), i, true);
        }
        if (kk.contains(Integer.valueOf(16))) {
            C0200b.m250a(parcel, 16, ksVar.isPlusUser());
        }
        if (kk.contains(Integer.valueOf(19))) {
            C0200b.m243a(parcel, 19, ksVar.kI(), i, true);
        }
        if (kk.contains(Integer.valueOf(18))) {
            C0200b.m247a(parcel, 18, ksVar.getLanguage(), true);
        }
        if (kk.contains(Integer.valueOf(21))) {
            C0200b.m259c(parcel, 21, ksVar.getObjectType());
        }
        if (kk.contains(Integer.valueOf(20))) {
            C0200b.m247a(parcel, 20, ksVar.getNickname(), true);
        }
        if (kk.contains(Integer.valueOf(23))) {
            C0200b.m258b(parcel, 23, ksVar.kK(), true);
        }
        if (kk.contains(Integer.valueOf(22))) {
            C0200b.m258b(parcel, 22, ksVar.kJ(), true);
        }
        if (kk.contains(Integer.valueOf(25))) {
            C0200b.m259c(parcel, 25, ksVar.getRelationshipStatus());
        }
        if (kk.contains(Integer.valueOf(24))) {
            C0200b.m259c(parcel, 24, ksVar.getPlusOneCount());
        }
        if (kk.contains(Integer.valueOf(27))) {
            C0200b.m247a(parcel, 27, ksVar.getUrl(), true);
        }
        if (kk.contains(Integer.valueOf(26))) {
            C0200b.m247a(parcel, 26, ksVar.getTagline(), true);
        }
        if (kk.contains(Integer.valueOf(29))) {
            C0200b.m250a(parcel, 29, ksVar.isVerified());
        }
        if (kk.contains(Integer.valueOf(28))) {
            C0200b.m258b(parcel, 28, ksVar.kL(), true);
        }
        C0200b.m235G(parcel, C);
    }

    public ks bG(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C1132a c1132a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C1135b c1135b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C1136c c1136c = null;
        boolean z = false;
        String str7 = null;
        C1137d c1137d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    C1132a c1132a2 = (C1132a) C0199a.m201a(parcel, A, C1132a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1132a = c1132a2;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str2 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i2 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case DetectedActivity.WALKING /*7*/:
                    C1135b c1135b2 = (C1135b) C0199a.m201a(parcel, A, C1135b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c1135b = c1135b2;
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str4 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str5 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    i3 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str6 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    C1136c c1136c2 = (C1136c) C0199a.m201a(parcel, A, C1136c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c1136c = c1136c2;
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    z = C0199a.m208c(parcel, A);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    str7 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    C1137d c1137d2 = (C1137d) C0199a.m201a(parcel, A, C1137d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c1137d = c1137d2;
                    break;
                case 20:
                    str8 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = C0199a.m207c(parcel, A, C1138f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = C0199a.m207c(parcel, A, C1139g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = C0199a.m207c(parcel, A, C1140h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = C0199a.m208c(parcel, A);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ks(hashSet, i, str, c1132a, str2, str3, i2, c1135b, str4, str5, i3, str6, c1136c, z, str7, c1137d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bG(x0);
    }

    public ks[] dd(int i) {
        return new ks[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dd(x0);
    }
}
