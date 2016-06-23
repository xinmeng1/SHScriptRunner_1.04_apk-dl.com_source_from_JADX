package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public final class TurnBasedMatchTurnStatus {
    public static String cm(int i) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return "TURN_STATUS_INVITED";
            case DataEvent.TYPE_CHANGED /*1*/:
                return "TURN_STATUS_MY_TURN";
            case DataEvent.TYPE_DELETED /*2*/:
                return "TURN_STATUS_THEIR_TURN";
            case DetectedActivity.STILL /*3*/:
                return "TURN_STATUS_COMPLETE";
            default:
                GamesLog.m483k("MatchTurnStatus", "Unknown match turn status: " + i);
                return "TURN_STATUS_UNKNOWN";
        }
    }
}
