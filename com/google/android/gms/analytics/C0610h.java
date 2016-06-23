package com.google.android.gms.analytics;

import android.content.Context;
import android.support.v4.media.TransportMediator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.h */
class C0610h implements C0148m {
    private static C0610h tH;
    private static final Object tq;
    private final Context mContext;
    private String tI;
    private boolean tJ;
    private final Object tK;

    /* renamed from: com.google.android.gms.analytics.h.1 */
    class C01431 extends Thread {
        final /* synthetic */ C0610h tL;

        C01431(C0610h c0610h, String str) {
            this.tL = c0610h;
            super(str);
        }

        public void run() {
            synchronized (this.tL.tK) {
                this.tL.tI = this.tL.cA();
                this.tL.tJ = true;
                this.tL.tK.notifyAll();
            }
        }
    }

    static {
        tq = new Object();
    }

    protected C0610h(Context context) {
        this.tJ = false;
        this.tK = new Object();
        this.mContext = context;
        cz();
    }

    private boolean m1911K(String str) {
        try {
            aa.m39C("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            aa.m37A("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            aa.m37A("Error writing to clientId file.");
            return false;
        }
    }

    public static C0610h cv() {
        C0610h c0610h;
        synchronized (tq) {
            c0610h = tH;
        }
        return c0610h;
    }

    private String cx() {
        if (!this.tJ) {
            synchronized (this.tK) {
                if (!this.tJ) {
                    aa.m39C("Waiting for clientId to load");
                    do {
                        try {
                            this.tK.wait();
                        } catch (InterruptedException e) {
                            aa.m37A("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.tJ);
                }
            }
        }
        aa.m39C("Loaded clientId");
        return this.tI;
    }

    private void cz() {
        new C01431(this, "client_id_fetcher").start();
    }

    public static void m1915u(Context context) {
        synchronized (tq) {
            if (tH == null) {
                tH = new C0610h(context);
            }
        }
    }

    public boolean m1916J(String str) {
        return "&cid".equals(str);
    }

    String cA() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[TransportMediator.FLAG_KEY_MEDIA_NEXT];
            int read = openFileInput.read(bArr, 0, TransportMediator.FLAG_KEY_MEDIA_NEXT);
            if (openFileInput.available() > 0) {
                aa.m37A("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                aa.m37A("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    aa.m39C("Loaded client id from disk.");
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    aa.m37A("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            aa.m37A("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? cy() : str;
    }

    String cw() {
        String str;
        synchronized (this.tK) {
            this.tI = cy();
            str = this.tI;
        }
        return str;
    }

    protected String cy() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !m1911K(toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    public String getValue(String field) {
        return "&cid".equals(field) ? cx() : null;
    }
}
