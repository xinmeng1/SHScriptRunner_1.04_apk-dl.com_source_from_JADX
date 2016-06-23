package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR;
    public static final Operator La;
    public static final Operator Lb;
    public static final Operator Lc;
    public static final Operator Ld;
    public static final Operator Le;
    public static final Operator Lf;
    public static final Operator Lg;
    public static final Operator Lh;
    public static final Operator Li;
    final String mTag;
    final int xM;

    static {
        CREATOR = new C0248k();
        La = new Operator("=");
        Lb = new Operator("<");
        Lc = new Operator("<=");
        Ld = new Operator(">");
        Le = new Operator(">=");
        Lf = new Operator("and");
        Lg = new Operator("or");
        Lh = new Operator("not");
        Li = new Operator("contains");
    }

    Operator(int versionCode, String tag) {
        this.xM = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0248k.m383a(this, out, flags);
    }
}
