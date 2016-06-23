package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR;
    private final String JL;
    private final String xG;
    final int xM;

    static {
        CREATOR = new C0569j();
    }

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.xM = versionCode;
        this.xG = id;
        this.JL = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.xM = 1;
        this.xG = (String) hm.m1232f(value.getId());
        this.JL = (String) hm.m1232f(value.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return nq();
    }

    public String getDataItemKey() {
        return this.JL;
    }

    public String getId() {
        return this.xG;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataItemAsset nq() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.xG == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.xG);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.JL);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0569j.m1848a(this, dest, flags);
    }
}
