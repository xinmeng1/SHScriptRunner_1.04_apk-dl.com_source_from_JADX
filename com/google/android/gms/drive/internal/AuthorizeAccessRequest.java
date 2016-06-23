package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR;
    final DriveId Hz;
    final long Is;
    final int xM;

    static {
        CREATOR = new C0212b();
    }

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.xM = versionCode;
        this.Is = appId;
        this.Hz = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0212b.m338a(this, dest, flags);
    }
}
