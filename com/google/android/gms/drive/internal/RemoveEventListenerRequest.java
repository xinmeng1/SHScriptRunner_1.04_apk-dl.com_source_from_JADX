package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator<RemoveEventListenerRequest> CREATOR;
    final DriveId Hz;
    final int Iq;
    final int xM;

    static {
        CREATOR = new au();
    }

    RemoveEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.xM = versionCode;
        this.Hz = driveId;
        this.Iq = eventType;
    }

    public RemoveEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        au.m334a(this, dest, flags);
    }
}
