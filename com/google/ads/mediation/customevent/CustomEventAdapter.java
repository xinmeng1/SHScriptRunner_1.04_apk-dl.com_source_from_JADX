package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.eu;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f67n;
    private CustomEventBanner f68o;
    private CustomEventInterstitial f69p;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C1016a implements CustomEventBannerListener {
        private final CustomEventAdapter f62q;
        private final MediationBannerListener f63r;

        public C1016a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f62q = customEventAdapter;
            this.f63r = mediationBannerListener;
        }

        public void onClick() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f63r.onClick(this.f62q);
        }

        public void onDismissScreen() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f63r.onDismissScreen(this.f62q);
        }

        public void onFailedToReceiveAd() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f63r.onFailedToReceiveAd(this.f62q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f63r.onLeaveApplication(this.f62q);
        }

        public void onPresentScreen() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f63r.onPresentScreen(this.f62q);
        }

        public void onReceivedAd(View view) {
            eu.m1019z("Custom event adapter called onReceivedAd.");
            this.f62q.m3168a(view);
            this.f63r.onReceivedAd(this.f62q);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    private class C1017b implements CustomEventInterstitialListener {
        private final CustomEventAdapter f64q;
        private final MediationInterstitialListener f65s;
        final /* synthetic */ CustomEventAdapter f66t;

        public C1017b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f66t = customEventAdapter;
            this.f64q = customEventAdapter2;
            this.f65s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            eu.m1019z("Custom event adapter called onDismissScreen.");
            this.f65s.onDismissScreen(this.f64q);
        }

        public void onFailedToReceiveAd() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f65s.onFailedToReceiveAd(this.f64q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            eu.m1019z("Custom event adapter called onLeaveApplication.");
            this.f65s.onLeaveApplication(this.f64q);
        }

        public void onPresentScreen() {
            eu.m1019z("Custom event adapter called onPresentScreen.");
            this.f65s.onPresentScreen(this.f64q);
        }

        public void onReceivedAd() {
            eu.m1019z("Custom event adapter called onReceivedAd.");
            this.f65s.onReceivedAd(this.f66t);
        }
    }

    private static <T> T m3167a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            eu.m1014D("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m3168a(View view) {
        this.f67n = view;
    }

    public void destroy() {
        if (this.f68o != null) {
            this.f68o.destroy();
        }
        if (this.f69p != null) {
            this.f69p.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f67n;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f68o = (CustomEventBanner) m3167a(serverParameters.className);
        if (this.f68o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f68o.requestBannerAd(new C1016a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f69p = (CustomEventInterstitial) m3167a(serverParameters.className);
        if (this.f69p == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f69p.requestInterstitialAd(new C1017b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f69p.showInterstitial();
    }
}
