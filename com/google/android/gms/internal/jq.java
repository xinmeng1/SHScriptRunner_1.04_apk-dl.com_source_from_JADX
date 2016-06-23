package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class jq implements SafeParcelable {
    public static final jr CREATOR;
    static final long Wm;
    private final long Vl;
    private final jm Wn;
    private final int mPriority;
    final int xM;

    static {
        CREATOR = new jr();
        Wm = TimeUnit.HOURS.toMillis(1);
    }

    public jq(int i, jm jmVar, long j, int i2) {
        this.xM = i;
        this.Wn = jmVar;
        this.Vl = j;
        this.mPriority = i2;
    }

    public int describeContents() {
        jr jrVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof jq)) {
            return false;
        }
        jq jqVar = (jq) object;
        return hk.equal(this.Wn, jqVar.Wn) && this.Vl == jqVar.Vl && this.mPriority == jqVar.mPriority;
    }

    public long getInterval() {
        return this.Vl;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return hk.hashCode(this.Wn, Long.valueOf(this.Vl), Integer.valueOf(this.mPriority));
    }

    public jm jf() {
        return this.Wn;
    }

    public String toString() {
        return hk.m1221e(this).m1220a("filter", this.Wn).m1220a("interval", Long.valueOf(this.Vl)).m1220a("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        jr jrVar = CREATOR;
        jr.m1310a(this, parcel, flags);
    }
}
