package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class fd implements Parcelable {
    @Deprecated
    public static final Creator<fd> CREATOR;
    private String mValue;
    private String xG;
    private String xH;

    /* renamed from: com.google.android.gms.internal.fd.1 */
    static class C03571 implements Creator<fd> {
        C03571() {
        }

        @Deprecated
        public fd[] m1054C(int i) {
            return new fd[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m1055k(x0);
        }

        @Deprecated
        public fd m1055k(Parcel parcel) {
            return new fd(parcel);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m1054C(x0);
        }
    }

    static {
        CREATOR = new C03571();
    }

    @Deprecated
    fd(Parcel parcel) {
        readFromParcel(parcel);
    }

    public fd(String str, String str2, String str3) {
        this.xG = str;
        this.xH = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.xG = in.readString();
        this.xH = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.xG;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.xG);
        out.writeString(this.xH);
        out.writeString(this.mValue);
    }
}
