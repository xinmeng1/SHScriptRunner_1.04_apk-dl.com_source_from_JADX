package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jk implements SafeParcelable {
    public static final jl CREATOR;
    private final int Va;
    private final int Wa;
    private final jm Wb;
    private final int xM;

    static {
        CREATOR = new jl();
    }

    jk(int i, int i2, int i3, jm jmVar) {
        this.xM = i;
        this.Va = i2;
        this.Wa = i3;
        this.Wb = jmVar;
    }

    public int describeContents() {
        jl jlVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof jk)) {
            return false;
        }
        jk jkVar = (jk) object;
        return this.Va == jkVar.Va && this.Wa == jkVar.Wa && this.Wb.equals(jkVar.Wb);
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.Va), Integer.valueOf(this.Wa));
    }

    public int jc() {
        return this.Va;
    }

    public int je() {
        return this.Wa;
    }

    public jm jf() {
        return this.Wb;
    }

    public String toString() {
        return hk.m1221e(this).m1220a("transitionTypes", Integer.valueOf(this.Va)).m1220a("loiteringTimeMillis", Integer.valueOf(this.Wa)).m1220a("placeFilter", this.Wb).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        jl jlVar = CREATOR;
        jl.m1307a(this, parcel, flags);
    }
}
