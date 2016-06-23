package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
    private static as afI;
    private final LinkedBlockingQueue<Runnable> afH;
    private volatile at afJ;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean uL;

    /* renamed from: com.google.android.gms.tagmanager.as.1 */
    class C04781 implements Runnable {
        final /* synthetic */ ar afK;
        final /* synthetic */ long afL;
        final /* synthetic */ String afM;
        final /* synthetic */ as afN;

        C04781(as asVar, ar arVar, long j, String str) {
            this.afN = asVar;
            this.afK = arVar;
            this.afL = j;
            this.afM = str;
        }

        public void run() {
            if (this.afN.afJ == null) {
                cx mQ = cx.mQ();
                mQ.m3010a(this.afN.mContext, this.afK);
                this.afN.afJ = mQ.mR();
            }
            this.afN.afJ.m1631f(this.afL, this.afM);
        }
    }

    private as(Context context) {
        super("GAThread");
        this.afH = new LinkedBlockingQueue();
        this.uL = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static as m2945P(Context context) {
        if (afI == null) {
            afI = new as(context);
        }
        return afI;
    }

    private String m2948a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void m2950a(Runnable runnable) {
        this.afH.add(runnable);
    }

    void m2951b(String str, long j) {
        m2950a(new C04781(this, this, j, str));
    }

    public void bU(String str) {
        m2951b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.afH.take();
                if (!this.uL) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bh.m1643B(e.toString());
            } catch (Throwable th) {
                bh.m1642A("Error on GAThread: " + m2948a(th));
                bh.m1642A("Google Analytics is shutting down.");
                this.uL = true;
            }
        }
    }
}
