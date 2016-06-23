package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0283g;
import com.google.android.gms.dynamic.C0283g.C0282a;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.internal.hj.C0783a;

public final class hn extends C0283g<hj> {
    private static final hn GL;

    static {
        GL = new hn();
    }

    private hn() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m2709b(Context context, int i, int i2) throws C0282a {
        return GL.m2710c(context, i, i2);
    }

    private View m2710c(Context context, int i, int i2) throws C0282a {
        try {
            return (View) C1057e.m3259e(((hj) m469G(context)).m1219a(C1057e.m3260h(context), i, i2));
        } catch (Throwable e) {
            throw new C0282a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public hj m2711N(IBinder iBinder) {
        return C0783a.m2708M(iBinder);
    }

    public /* synthetic */ Object m2712d(IBinder iBinder) {
        return m2711N(iBinder);
    }
}
