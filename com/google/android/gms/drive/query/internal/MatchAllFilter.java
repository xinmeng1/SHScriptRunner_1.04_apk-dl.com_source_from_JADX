package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class MatchAllFilter implements SafeParcelable, Filter {
    public static final C0246i CREATOR;
    final int xM;

    static {
        CREATOR = new C0246i();
    }

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.xM = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0246i.m381a(this, out, flags);
    }
}
