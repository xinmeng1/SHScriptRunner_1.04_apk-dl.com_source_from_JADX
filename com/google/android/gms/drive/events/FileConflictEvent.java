package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public final class FileConflictEvent implements SafeParcelable, DriveEvent {
    public static final Creator<FileConflictEvent> CREATOR;
    final DriveId Hz;
    final ParcelFileDescriptor Ij;
    final ParcelFileDescriptor Ik;
    final MetadataBundle Il;
    final ArrayList<String> Im;
    private boolean In;
    private boolean Io;
    private boolean Ip;
    final int xM;
    final String yQ;

    static {
        CREATOR = new C0210c();
    }

    FileConflictEvent(int versionCode, DriveId driveId, String accountName, ParcelFileDescriptor baseParcelFileDescriptor, ParcelFileDescriptor modifiedParcelFileDescriptor, MetadataBundle modifiedMetadataBundle, ArrayList<String> operationTags) {
        this.In = false;
        this.Io = false;
        this.Ip = false;
        this.xM = versionCode;
        this.Hz = driveId;
        this.yQ = accountName;
        this.Ij = baseParcelFileDescriptor;
        this.Ik = modifiedParcelFileDescriptor;
        this.Il = modifiedMetadataBundle;
        this.Im = operationTags;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Hz;
    }

    public int getType() {
        return 2;
    }

    public String toString() {
        return String.format("FileConflictEvent [id=%s]", new Object[]{this.Hz});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0210c.m273a(this, dest, flags);
    }
}
