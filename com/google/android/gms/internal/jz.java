package com.google.android.gms.internal;

import java.util.Locale;

public class jz {
    private static final String TAG;
    private final jj<je> VJ;
    private final ka YT;
    private final Locale YU;

    static {
        TAG = jz.class.getSimpleName();
    }

    public jz(String str, jj<je> jjVar) {
        this.VJ = jjVar;
        this.YU = Locale.getDefault();
        this.YT = new ka(str, this.YU);
    }
}
