package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR;
    DriveId Iu;
    final int xM;

    static {
        CREATOR = new ai();
    }

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.xM = versionCode;
        this.Iu = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Iu;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ai.m322a(this, dest, flags);
    }
}
