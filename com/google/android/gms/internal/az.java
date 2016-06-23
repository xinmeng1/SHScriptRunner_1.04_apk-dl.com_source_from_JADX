package com.google.android.gms.internal;

import java.util.Map;

public final class az implements bc {
    private final ba mS;

    public az(ba baVar) {
        this.mS = baVar;
    }

    public void m2470b(ex exVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            eu.m1014D("App event with no name parameter.");
        } else {
            this.mS.onAppEvent(str, (String) map.get("info"));
        }
    }
}
