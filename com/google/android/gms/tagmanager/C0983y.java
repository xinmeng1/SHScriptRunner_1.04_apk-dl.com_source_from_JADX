package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.y */
class C0983y implements aq {
    private static C0983y afu;
    private static final Object tq;
    private cf aeJ;
    private String afv;
    private String afw;
    private ar afx;

    static {
        tq = new Object();
    }

    private C0983y(Context context) {
        this(as.m2945P(context), new cv());
    }

    C0983y(ar arVar, cf cfVar) {
        this.afx = arVar;
        this.aeJ = cfVar;
    }

    public static aq m3066N(Context context) {
        aq aqVar;
        synchronized (tq) {
            if (afu == null) {
                afu = new C0983y(context);
            }
            aqVar = afu;
        }
        return aqVar;
    }

    public boolean bR(String str) {
        if (this.aeJ.m1662do()) {
            if (!(this.afv == null || this.afw == null)) {
                try {
                    str = this.afv + "?" + this.afw + "=" + URLEncoder.encode(str, "UTF-8");
                    bh.m1644C("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bh.m1647c("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.afx.bU(str);
            return true;
        }
        bh.m1645D("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
