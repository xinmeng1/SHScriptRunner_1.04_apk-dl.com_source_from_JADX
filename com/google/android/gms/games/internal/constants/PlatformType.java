package com.google.android.gms.games.internal.constants;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public final class PlatformType {
    private PlatformType() {
    }

    public static String cm(int i) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return "ANDROID";
            case DataEvent.TYPE_CHANGED /*1*/:
                return "IOS";
            case DataEvent.TYPE_DELETED /*2*/:
                return "WEB_APP";
            default:
                throw new IllegalArgumentException("Unknown platform type: " + i);
        }
    }
}
