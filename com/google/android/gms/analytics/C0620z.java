package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.z */
class C0620z implements ad {
    private final long wE;
    private final int wF;
    private double wG;
    private long wH;
    private final Object wI;
    private final String wJ;

    public C0620z(int i, long j, String str) {
        this.wI = new Object();
        this.wF = i;
        this.wG = (double) this.wF;
        this.wE = j;
        this.wJ = str;
    }

    public C0620z(String str) {
        this(60, 2000, str);
    }

    public boolean m1962do() {
        boolean z;
        synchronized (this.wI) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.wG < ((double) this.wF)) {
                double d = ((double) (currentTimeMillis - this.wH)) / ((double) this.wE);
                if (d > 0.0d) {
                    this.wG = Math.min((double) this.wF, d + this.wG);
                }
            }
            this.wH = currentTimeMillis;
            if (this.wG >= 1.0d) {
                this.wG -= 1.0d;
                z = true;
            } else {
                aa.m40D("Excessive " + this.wJ + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
