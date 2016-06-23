package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.hm;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator<CreateFolderRequest> CREATOR;
    final MetadataBundle IE;
    final DriveId IG;
    final int xM;

    static {
        CREATOR = new C0220k();
    }

    CreateFolderRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata) {
        this.xM = versionCode;
        this.IG = (DriveId) hm.m1232f(parentDriveId);
        this.IE = (MetadataBundle) hm.m1232f(metadata);
    }

    public CreateFolderRequest(DriveId parentDriveId, MetadataBundle metadata) {
        this(1, parentDriveId, metadata);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0220k.m354a(this, dest, flags);
    }
}
