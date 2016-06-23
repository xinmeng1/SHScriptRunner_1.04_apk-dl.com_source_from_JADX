package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.hm;

public class CustomProperty implements SafeParcelable {
    public static final Creator<CustomProperty> CREATOR;
    final CustomPropertyKey JQ;
    final String mValue;
    final int xM;

    static {
        CREATOR = new C0232c();
    }

    CustomProperty(int versionCode, CustomPropertyKey key, String value) {
        this.xM = versionCode;
        hm.m1228b((Object) key, (Object) "key");
        this.JQ = key;
        this.mValue = value;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0232c.m368a(this, dest, flags);
    }
}
