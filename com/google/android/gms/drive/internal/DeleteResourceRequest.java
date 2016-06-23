package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class DeleteResourceRequest implements SafeParcelable {
    public static final Creator<DeleteResourceRequest> CREATOR;
    final DriveId Iu;
    final int xM;

    static {
        CREATOR = new C0222n();
    }

    DeleteResourceRequest(int versionCode, DriveId id) {
        this.xM = versionCode;
        this.Iu = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0222n.m357a(this, dest, flags);
    }
}
