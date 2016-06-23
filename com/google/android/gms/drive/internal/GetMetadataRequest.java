package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator<GetMetadataRequest> CREATOR;
    final DriveId Iu;
    final int xM;

    static {
        CREATOR = new C0227z();
    }

    GetMetadataRequest(int versionCode, DriveId id) {
        this.xM = versionCode;
        this.Iu = id;
    }

    public GetMetadataRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0227z.m361a(this, dest, flags);
    }
}
