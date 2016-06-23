package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.C0130a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class al implements SafeParcelable {
    public static final am CREATOR;
    public final int height;
    public final int heightPixels;
    public final String me;
    public final boolean mf;
    public final al[] mg;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    static {
        CREATOR = new am();
    }

    public al() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    al(int i, String str, int i2, int i3, boolean z, int i4, int i5, al[] alVarArr) {
        this.versionCode = i;
        this.me = str;
        this.height = i2;
        this.heightPixels = i3;
        this.mf = z;
        this.width = i4;
        this.widthPixels = i5;
        this.mg = alVarArr;
    }

    public al(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public al(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        int i3 = 0;
        AdSize adSize = adSizeArr[0];
        this.versionCode = 2;
        this.mf = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        int i4 = this.width == -1 ? 1 : 0;
        int i5 = this.height == -2 ? 1 : 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i4 != 0) {
            this.widthPixels = m2454a(displayMetrics);
            i = (int) (((float) this.widthPixels) / displayMetrics.density);
        } else {
            i2 = this.width;
            this.widthPixels = et.m1005a(displayMetrics, this.width);
            i = i2;
        }
        i2 = i5 != 0 ? m2456c(displayMetrics) : this.height;
        this.heightPixels = et.m1005a(displayMetrics, i2);
        if (i4 == 0 && i5 == 0) {
            this.me = adSize.toString();
        } else {
            this.me = i + "x" + i2 + "_as";
        }
        if (adSizeArr.length > 1) {
            this.mg = new al[adSizeArr.length];
            while (i3 < adSizeArr.length) {
                this.mg[i3] = new al(context, adSizeArr[i3]);
                i3++;
            }
            return;
        }
        this.mg = null;
    }

    public al(al alVar, al[] alVarArr) {
        this(2, alVar.me, alVar.height, alVar.heightPixels, alVar.mf, alVar.width, alVar.widthPixels, alVarArr);
    }

    public static int m2454a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int m2455b(DisplayMetrics displayMetrics) {
        return (int) (((float) m2456c(displayMetrics)) * displayMetrics.density);
    }

    private static int m2456c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public AdSize aG() {
        return C0130a.m10a(this.width, this.height, this.me);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        am.m784a(this, out, flags);
    }
}
