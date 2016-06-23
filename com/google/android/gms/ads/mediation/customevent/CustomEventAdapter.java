package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.eu;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private View f72n;
    private CustomEventBanner sW;
    private CustomEventInterstitial sX;

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C1018a implements CustomEventBannerListener {
        private final MediationBannerListener f70l;
        private final CustomEventAdapter sY;

        public C1018a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.sY = customEventAdapter;
            this.f70l = mediationBannerListener;
        }

        public void onAdClicked() {
            eu.m1019z("Custom event adapter called onAdClicked.");
            this.f70l.onAdClicked(this.sY);
        }

        public void onAdClosed() {
            eu.m1019z("Custom event adapter called onAdClosed.");
            this.f70l.onAdClosed(this.sY);
        }

        public void onAdFailedToLoad(int errorCode) {
            eu.m1019z("Custom event adapter called onAdFailedToLoad.");
            this.f70l.onAdFailedToLoad(this.sY, errorCode);
        }

        public void onAdLeftApplication() {
            eu.m1019z("Custom event adapter called onAdLeftApplication.");
            this.f70l.onAdLeftApplication(this.sY);
        }

        public void onAdLoaded(View view) {
            eu.m1019z("Custom event adapter called onAdLoaded.");
            this.sY.m3171a(view);
            this.f70l.onAdLoaded(this.sY);
        }

        public void onAdOpened() {
            eu.m1019z("Custom event adapter called onAdOpened.");
            this.f70l.onAdOpened(this.sY);
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.b */
    private class C1019b implements CustomEventInterstitialListener {
        private final MediationInterstitialListener f71m;
        private final CustomEventAdapter sY;
        final /* synthetic */ CustomEventAdapter sZ;

        public C1019b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.sZ = customEventAdapter;
            this.sY = customEventAdapter2;
            this.f71m = mediationInterstitialListener;
        }

        public void onAdClicked() {
            eu.m1019z("Custom event adapter called onAdClicked.");
            this.f71m.onAdClicked(this.sY);
        }

        public void onAdClosed() {
            eu.m1019z("Custom event adapter called onAdClosed.");
            this.f71m.onAdClosed(this.sY);
        }

        public void onAdFailedToLoad(int errorCode) {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f71m.onAdFailedToLoad(this.sY, errorCode);
        }

        public void onAdLeftApplication() {
            eu.m1019z("Custom event adapter called onAdLeftApplication.");
            this.f71m.onAdLeftApplication(this.sY);
        }

        public void onAdLoaded() {
            eu.m1019z("Custom event adapter called onReceivedAd.");
            this.f71m.onAdLoaded(this.sZ);
        }

        public void onAdOpened() {
            eu.m1019z("Custom event adapter called onAdOpened.");
            this.f71m.onAdOpened(this.sY);
        }
    }

    private static <T> T m3170a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            eu.m1014D("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m3171a(View view) {
        this.f72n = view;
    }

    public View getBannerView() {
        return this.f72n;
    }

    public void onDestroy() {
        if (this.sW != null) {
            this.sW.onDestroy();
        }
        if (this.sX != null) {
            this.sX.onDestroy();
        }
    }

    public void onPause() {
        if (this.sW != null) {
            this.sW.onPause();
        }
        if (this.sX != null) {
            this.sX.onPause();
        }
    }

    public void onResume() {
        if (this.sW != null) {
            this.sW.onResume();
        }
        if (this.sX != null) {
            this.sX.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.sW = (CustomEventBanner) m3170a(serverParameters.getString("class_name"));
        if (this.sW == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.sW.requestBannerAd(context, new C1018a(this, listener), serverParameters.getString("parameter"), adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.sX = (CustomEventInterstitial) m3170a(serverParameters.getString("class_name"));
        if (this.sX == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.sX.requestInterstitialAd(context, new C1019b(this, this, listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void showInterstitial() {
        this.sX.showInterstitial();
    }
}
