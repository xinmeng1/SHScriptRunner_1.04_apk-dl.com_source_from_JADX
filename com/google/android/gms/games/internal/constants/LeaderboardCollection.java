package com.google.android.gms.games.internal.constants;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public final class LeaderboardCollection {
    private LeaderboardCollection() {
    }

    public static String cm(int i) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return "PUBLIC";
            case DataEvent.TYPE_CHANGED /*1*/:
                return "SOCIAL";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
