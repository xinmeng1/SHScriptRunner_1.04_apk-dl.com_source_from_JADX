package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR;
    final int Hy;
    final DriveId Iu;
    final int xM;

    static {
        CREATOR = new ar();
    }

    OpenContentsRequest(int versionCode, DriveId id, int mode) {
        this.xM = versionCode;
        this.Iu = id;
        this.Hy = mode;
    }

    public OpenContentsRequest(DriveId id, int mode) {
        this(1, id, mode);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ar.m331a(this, dest, flags);
    }
}
