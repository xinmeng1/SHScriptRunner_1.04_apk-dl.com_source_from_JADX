package com.google.android.gms.analytics;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.analytics.x */
class C0167x {
    private String wv;
    private final long ww;
    private final long wx;
    private String wy;

    C0167x(String str, long j, long j2) {
        this.wy = "https:";
        this.wv = str;
        this.ww = j;
        this.wx = j2;
    }

    void m85Q(String str) {
        this.wv = str;
    }

    void m86R(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.wy = "http:";
        }
    }

    String dk() {
        return this.wv;
    }

    long dl() {
        return this.ww;
    }

    long dm() {
        return this.wx;
    }

    String dn() {
        return this.wy;
    }
}
