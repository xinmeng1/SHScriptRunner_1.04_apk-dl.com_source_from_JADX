package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.regex.Pattern;

public final class ii {
    private static Pattern Hu;

    static {
        Hu = null;
    }

    public static boolean m1273F(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int aB(int i) {
        return i / GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE;
    }

    public static int aC(int i) {
        return (i % GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE) / 100;
    }

    public static boolean aD(int i) {
        return aC(i) == 3;
    }
}
