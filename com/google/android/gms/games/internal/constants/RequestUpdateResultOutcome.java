package com.google.android.gms.games.internal.constants;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public final class RequestUpdateResultOutcome {
    private RequestUpdateResultOutcome() {
    }

    public static boolean isValid(int outcome) {
        switch (outcome) {
            case DetectedActivity.IN_VEHICLE /*0*/:
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
            case DetectedActivity.STILL /*3*/:
                return true;
            default:
                return false;
        }
    }
}
