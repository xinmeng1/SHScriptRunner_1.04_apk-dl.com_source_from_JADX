package com.google.android.gms.games.internal.constants;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public final class MatchResult {
    public static boolean isValid(int result) {
        switch (result) {
            case DetectedActivity.IN_VEHICLE /*0*/:
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
            case DetectedActivity.TILTING /*5*/:
                return true;
            default:
                return false;
        }
    }
}
