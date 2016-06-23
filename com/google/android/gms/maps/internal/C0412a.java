package com.google.android.gms.maps.internal;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.a */
public final class C0412a {
    public static Boolean m1485a(byte b) {
        switch (b) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return Boolean.FALSE;
            case DataEvent.TYPE_CHANGED /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte m1486c(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
