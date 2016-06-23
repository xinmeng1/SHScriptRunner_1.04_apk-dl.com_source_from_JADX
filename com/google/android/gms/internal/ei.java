package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;

public class ei {
    private final Object ls;
    private final String rR;
    private int rX;
    private long rY;
    private long rZ;
    private int sa;
    private int sb;

    public ei(String str) {
        this.ls = new Object();
        this.rX = 0;
        this.rY = -1;
        this.rZ = -1;
        this.sa = 0;
        this.sb = -1;
        this.rR = str;
    }

    public static boolean m961l(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            eu.m1012B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            eu.m1012B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            eu.m1014D("Fail to fetch AdActivity theme");
            eu.m1012B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public Bundle m962b(Context context, String str) {
        Bundle bundle;
        synchronized (this.ls) {
            bundle = new Bundle();
            bundle.putString("session_id", this.rR);
            bundle.putLong("basets", this.rZ);
            bundle.putLong("currts", this.rY);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.sb);
            bundle.putInt("pclick", this.rX);
            bundle.putInt("pimp", this.sa);
            bundle.putBoolean("support_transparent_background", m961l(context));
        }
        return bundle;
    }

    public void m963b(ai aiVar, long j) {
        synchronized (this.ls) {
            if (this.rZ == -1) {
                this.rZ = j;
                this.rY = this.rZ;
            } else {
                this.rY = j;
            }
            if (aiVar.extras == null || aiVar.extras.getInt("gw", 2) != 1) {
                this.sb++;
                return;
            }
        }
    }

    public void bB() {
        synchronized (this.ls) {
            this.sa++;
        }
    }

    public void bC() {
        synchronized (this.ls) {
            this.rX++;
        }
    }

    public long bO() {
        return this.rZ;
    }
}
