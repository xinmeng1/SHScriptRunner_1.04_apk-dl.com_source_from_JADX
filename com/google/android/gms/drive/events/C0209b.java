package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.b */
public class C0209b {
    public static boolean m272a(int i, DriveId driveId) {
        return driveId != null || C0209b.aK(i);
    }

    public static boolean aK(int i) {
        return (6 & ((long) (1 << i))) != 0;
    }
}
