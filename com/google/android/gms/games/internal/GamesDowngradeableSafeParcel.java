package com.google.android.gms.games.internal;

import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.im;

public abstract class GamesDowngradeableSafeParcel extends ha {
    protected static boolean m3452c(Integer num) {
        return num == null ? false : im.aE(num.intValue());
    }
}
