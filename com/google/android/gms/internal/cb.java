package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.C0130a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.Date;
import java.util.HashSet;

public final class cb {

    /* renamed from: com.google.android.gms.internal.cb.1 */
    static /* synthetic */ class C03141 {
        static final /* synthetic */ int[] nY;
        static final /* synthetic */ int[] nZ;

        static {
            nZ = new int[ErrorCode.values().length];
            try {
                nZ[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nZ[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nZ[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nZ[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            nY = new int[Gender.values().length];
            try {
                nY[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                nY[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                nY[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m843a(ErrorCode errorCode) {
        switch (C03141.nZ[errorCode.ordinal()]) {
            case DataEvent.TYPE_DELETED /*2*/:
                return 1;
            case DetectedActivity.STILL /*3*/:
                return 2;
            case DetectedActivity.UNKNOWN /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize m844b(al alVar) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < adSizeArr.length) {
            if (adSizeArr[i].getWidth() == alVar.width && adSizeArr[i].getHeight() == alVar.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(C0130a.m10a(alVar.width, alVar.height, alVar.me));
    }

    public static MediationAdRequest m845e(ai aiVar) {
        return new MediationAdRequest(new Date(aiVar.lS), m846h(aiVar.lT), aiVar.lU != null ? new HashSet(aiVar.lU) : null, aiVar.lV, aiVar.ma);
    }

    public static Gender m846h(int i) {
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return Gender.MALE;
            case DataEvent.TYPE_DELETED /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
