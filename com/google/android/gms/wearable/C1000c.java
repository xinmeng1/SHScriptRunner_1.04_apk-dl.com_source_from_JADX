package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

/* renamed from: com.google.android.gms.wearable.c */
public class C1000c implements SafeParcelable {
    public static final Creator<C1000c> CREATOR;
    private final int AT;
    private final String YL;
    private final int ali;
    private final boolean alj;
    private final String mName;
    final int xM;

    static {
        CREATOR = new C0566d();
    }

    C1000c(int i, String str, String str2, int i2, int i3, boolean z) {
        this.xM = i;
        this.mName = str;
        this.YL = str2;
        this.AT = i2;
        this.ali = i3;
        this.alj = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C1000c)) {
            return false;
        }
        C1000c c1000c = (C1000c) o;
        return hk.equal(Integer.valueOf(this.xM), Integer.valueOf(c1000c.xM)) && hk.equal(this.mName, c1000c.mName) && hk.equal(this.YL, c1000c.YL) && hk.equal(Integer.valueOf(this.AT), Integer.valueOf(c1000c.AT)) && hk.equal(Integer.valueOf(this.ali), Integer.valueOf(c1000c.ali)) && hk.equal(Boolean.valueOf(this.alj), Boolean.valueOf(c1000c.alj));
    }

    public String getAddress() {
        return this.YL;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.ali;
    }

    public int getType() {
        return this.AT;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.xM), this.mName, this.YL, Integer.valueOf(this.AT), Integer.valueOf(this.ali), Boolean.valueOf(this.alj));
    }

    public boolean isEnabled() {
        return this.alj;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.YL);
        stringBuilder.append(", mType=" + this.AT);
        stringBuilder.append(", mRole=" + this.ali);
        stringBuilder.append(", mEnabled=" + this.alj);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0566d.m1805a(this, dest, flags);
    }
}
