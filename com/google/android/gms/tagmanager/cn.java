package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C0304c.C1108j;
import com.google.android.gms.tagmanager.bg.C0482a;
import com.google.android.gms.tagmanager.cd.C0484a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class cn implements Runnable {
    private volatile String aeP;
    private final String aet;
    private final bm agL;
    private final String agM;
    private bg<C1108j> agN;
    private volatile C0512r agO;
    private volatile String agP;
    private final Context mContext;

    cn(Context context, String str, bm bmVar, C0512r c0512r) {
        this.mContext = context;
        this.agL = bmVar;
        this.aet = str;
        this.agO = c0512r;
        this.agM = "/r?id=" + str;
        this.aeP = this.agM;
        this.agP = null;
    }

    public cn(Context context, String str, C0512r c0512r) {
        this(context, str, new bm(), c0512r);
    }

    private boolean mg() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m1644C("...no network connectivity");
        return false;
    }

    private void mh() {
        if (mg()) {
            bh.m1644C("Start loading resource from network ...");
            String mi = mi();
            bl lR = this.agL.lR();
            try {
                InputStream bV = lR.bV(mi);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cq.m1685b(bV, byteArrayOutputStream);
                    C1108j b = C1108j.m3555b(byteArrayOutputStream.toByteArray());
                    bh.m1644C("Successfully loaded supplemented resource: " + b);
                    if (b.fK == null && b.fJ.length == 0) {
                        bh.m1644C("No change for container: " + this.aet);
                    }
                    this.agN.m1641i(b);
                    bh.m1644C("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.m1647c("Error when parsing downloaded resources from url: " + mi + " " + e.getMessage(), e);
                    this.agN.m1640a(C0482a.SERVER_ERROR);
                    lR.close();
                }
            } catch (FileNotFoundException e2) {
                bh.m1645D("No data is retrieved from the given url: " + mi + ". Make sure container_id: " + this.aet + " is correct.");
                this.agN.m1640a(C0482a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.m1647c("Error when loading resources from url: " + mi + " " + e3.getMessage(), e3);
                this.agN.m1640a(C0482a.IO_ERROR);
            } finally {
                lR.close();
            }
        } else {
            this.agN.m1640a(C0482a.NOT_AVAILABLE);
        }
    }

    void m1667a(bg<C1108j> bgVar) {
        this.agN = bgVar;
    }

    void bM(String str) {
        if (str == null) {
            this.aeP = this.agM;
            return;
        }
        bh.m1648z("Setting CTFE URL path: " + str);
        this.aeP = str;
    }

    void cb(String str) {
        bh.m1648z("Setting previous container version: " + str);
        this.agP = str;
    }

    String mi() {
        String str = this.agO.lx() + this.aeP + "&v=a65833898";
        if (!(this.agP == null || this.agP.trim().equals(""))) {
            str = str + "&pv=" + this.agP;
        }
        return cd.md().me().equals(C0484a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.agN == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.agN.lv();
        mh();
    }
}
