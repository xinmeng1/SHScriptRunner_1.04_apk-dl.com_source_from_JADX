package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class ca<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final bv nT;

    /* renamed from: com.google.android.gms.internal.ca.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ ca nW;
        final /* synthetic */ ErrorCode nX;

        AnonymousClass10(ca caVar, ErrorCode errorCode) {
            this.nW = caVar;
            this.nX = errorCode;
        }

        public void run() {
            try {
                this.nW.nT.onAdFailedToLoad(cb.m843a(this.nX));
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.1 */
    class C03051 implements Runnable {
        final /* synthetic */ ca nW;

        C03051(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdClicked();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.2 */
    class C03062 implements Runnable {
        final /* synthetic */ ca nW;

        C03062(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdOpened();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.3 */
    class C03073 implements Runnable {
        final /* synthetic */ ca nW;

        C03073(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdLoaded();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.4 */
    class C03084 implements Runnable {
        final /* synthetic */ ca nW;

        C03084(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdClosed();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.5 */
    class C03095 implements Runnable {
        final /* synthetic */ ca nW;
        final /* synthetic */ ErrorCode nX;

        C03095(ca caVar, ErrorCode errorCode) {
            this.nW = caVar;
            this.nX = errorCode;
        }

        public void run() {
            try {
                this.nW.nT.onAdFailedToLoad(cb.m843a(this.nX));
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.6 */
    class C03106 implements Runnable {
        final /* synthetic */ ca nW;

        C03106(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdLeftApplication();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.7 */
    class C03117 implements Runnable {
        final /* synthetic */ ca nW;

        C03117(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdOpened();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.8 */
    class C03128 implements Runnable {
        final /* synthetic */ ca nW;

        C03128(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdLoaded();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ca.9 */
    class C03139 implements Runnable {
        final /* synthetic */ ca nW;

        C03139(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdClosed();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClosed.", e);
            }
        }
    }

    public ca(bv bvVar) {
        this.nT = bvVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onClick.");
        if (et.bW()) {
            try {
                this.nT.onAdClicked();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClicked.", e);
                return;
            }
        }
        eu.m1014D("onClick must be called on the main UI thread.");
        et.sv.post(new C03051(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onDismissScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdClosed();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClosed.", e);
                return;
            }
        }
        eu.m1014D("onDismissScreen must be called on the main UI thread.");
        et.sv.post(new C03084(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.m1019z("Adapter called onDismissScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdClosed();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClosed.", e);
                return;
            }
        }
        eu.m1014D("onDismissScreen must be called on the main UI thread.");
        et.sv.post(new C03139(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        eu.m1019z("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (et.bW()) {
            try {
                this.nT.onAdFailedToLoad(cb.m843a(errorCode));
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        eu.m1014D("onFailedToReceiveAd must be called on the main UI thread.");
        et.sv.post(new C03095(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        eu.m1019z("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (et.bW()) {
            try {
                this.nT.onAdFailedToLoad(cb.m843a(errorCode));
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        eu.m1014D("onFailedToReceiveAd must be called on the main UI thread.");
        et.sv.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onLeaveApplication.");
        if (et.bW()) {
            try {
                this.nT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        eu.m1014D("onLeaveApplication must be called on the main UI thread.");
        et.sv.post(new C03106(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.m1019z("Adapter called onLeaveApplication.");
        if (et.bW()) {
            try {
                this.nT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        eu.m1014D("onLeaveApplication must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            final /* synthetic */ ca nW;

            {
                this.nW = r1;
            }

            public void run() {
                try {
                    this.nW.nT.onAdLeftApplication();
                } catch (Throwable e) {
                    eu.m1017c("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onPresentScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdOpened();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdOpened.", e);
                return;
            }
        }
        eu.m1014D("onPresentScreen must be called on the main UI thread.");
        et.sv.post(new C03117(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.m1019z("Adapter called onPresentScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdOpened();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdOpened.", e);
                return;
            }
        }
        eu.m1014D("onPresentScreen must be called on the main UI thread.");
        et.sv.post(new C03062(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onReceivedAd.");
        if (et.bW()) {
            try {
                this.nT.onAdLoaded();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLoaded.", e);
                return;
            }
        }
        eu.m1014D("onReceivedAd must be called on the main UI thread.");
        et.sv.post(new C03128(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.m1019z("Adapter called onReceivedAd.");
        if (et.bW()) {
            try {
                this.nT.onAdLoaded();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLoaded.", e);
                return;
            }
        }
        eu.m1014D("onReceivedAd must be called on the main UI thread.");
        et.sv.post(new C03073(this));
    }
}
