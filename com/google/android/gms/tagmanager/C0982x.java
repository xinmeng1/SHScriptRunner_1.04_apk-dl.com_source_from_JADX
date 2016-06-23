package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C0982x implements bi {
    private int tN;

    C0982x() {
        this.tN = 5;
    }

    public void m3059A(String str) {
        if (this.tN <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void m3060B(String str) {
        if (this.tN <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void m3061C(String str) {
        if (this.tN <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void m3062D(String str) {
        if (this.tN <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void m3063b(String str, Throwable th) {
        if (this.tN <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void m3064c(String str, Throwable th) {
        if (this.tN <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(int logLevel) {
        this.tN = logLevel;
    }

    public void m3065z(String str) {
        if (this.tN <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }
}
