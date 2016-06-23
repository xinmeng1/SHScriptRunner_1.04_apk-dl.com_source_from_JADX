package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.as.C0705a;

public final class an extends C0705a {
    private final AppEventListener mh;

    public an(AppEventListener appEventListener) {
        this.mh = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.mh.onAppEvent(name, info);
    }
}
