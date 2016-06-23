package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR;
    final int LF;
    final int LG;
    final String LP;
    final int LQ;
    final int mIndex;
    final int xM;

    static {
        CREATOR = new C0262i();
    }

    ValuesRemovedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedToId, int movedToIndex) {
        this.xM = versionCode;
        this.mIndex = index;
        this.LF = valueIndex;
        this.LG = valueCount;
        this.LP = movedToId;
        this.LQ = movedToIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0262i.m400a(this, dest, flags);
    }
}
