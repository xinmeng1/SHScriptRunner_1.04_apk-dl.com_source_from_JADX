package com.google.android.gms.internal;

import com.google.android.gms.internal.bq.C0303a;
import com.google.android.gms.internal.bv.C0719a;

public final class bo extends C0719a {
    private final Object ls;
    private C0303a nA;
    private bn nB;

    public bo() {
        this.ls = new Object();
    }

    public void m3489a(bn bnVar) {
        synchronized (this.ls) {
            this.nB = bnVar;
        }
    }

    public void m3490a(C0303a c0303a) {
        synchronized (this.ls) {
            this.nA = c0303a;
        }
    }

    public void onAdClicked() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ab();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ac();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.ls) {
            if (this.nA != null) {
                this.nA.m835g(error == 3 ? 1 : 2);
                this.nA = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ad();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.ls) {
            if (this.nA != null) {
                this.nA.m835g(0);
                this.nA = null;
                return;
            }
            if (this.nB != null) {
                this.nB.af();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ae();
            }
        }
    }
}
