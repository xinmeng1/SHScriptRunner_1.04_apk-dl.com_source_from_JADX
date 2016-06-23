package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Creator<ValuesSetDetails> CREATOR;
    final int LF;
    final int LG;
    final int mIndex;
    final int xM;

    static {
        CREATOR = new C0263j();
    }

    ValuesSetDetails(int versionCode, int index, int valueIndex, int valueCount) {
        this.xM = versionCode;
        this.mIndex = index;
        this.LF = valueIndex;
        this.LG = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0263j.m401a(this, dest, flags);
    }
}
