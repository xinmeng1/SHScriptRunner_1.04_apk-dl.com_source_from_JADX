package com.google.android.gms.games.internal.constants;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public final class TimeSpan {
    private TimeSpan() {
        throw new AssertionError("Uninstantiable");
    }

    public static String cm(int i) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return "DAILY";
            case DataEvent.TYPE_CHANGED /*1*/:
                return "WEEKLY";
            case DataEvent.TYPE_DELETED /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
