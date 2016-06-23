package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.et;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView f60i;
    private InterstitialAd f61j;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.a */
    private static final class C0601a extends AdListener {
        private final AdMobAdapter f53k;
        private final MediationBannerListener f54l;

        public C0601a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f53k = adMobAdapter;
            this.f54l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f54l.onAdClosed(this.f53k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f54l.onAdFailedToLoad(this.f53k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f54l.onAdLeftApplication(this.f53k);
        }

        public void onAdLoaded() {
            this.f54l.onAdLoaded(this.f53k);
        }

        public void onAdOpened() {
            this.f54l.onAdClicked(this.f53k);
            this.f54l.onAdOpened(this.f53k);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.b */
    private static final class C0602b extends AdListener {
        private final AdMobAdapter f55k;
        private final MediationInterstitialListener f56m;

        public C0602b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f55k = adMobAdapter;
            this.f56m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f56m.onAdClosed(this.f55k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f56m.onAdFailedToLoad(this.f55k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f56m.onAdLeftApplication(this.f55k);
        }

        public void onAdLoaded() {
            this.f56m.onAdLoaded(this.f55k);
        }

        public void onAdOpened() {
            this.f56m.onAdOpened(this.f55k);
        }
    }

    private static AdRequest m3166a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(et.m1009r(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.f60i;
    }

    public void onDestroy() {
        if (this.f60i != null) {
            this.f60i.destroy();
            this.f60i = null;
        }
        if (this.f61j != null) {
            this.f61j = null;
        }
    }

    public void onPause() {
        if (this.f60i != null) {
            this.f60i.pause();
        }
    }

    public void onResume() {
        if (this.f60i != null) {
            this.f60i.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f60i = new AdView(context);
        this.f60i.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f60i.setAdUnitId(serverParameters.getString("pubid"));
        this.f60i.setAdListener(new C0601a(this, bannerListener));
        this.f60i.loadAd(m3166a(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f61j = new InterstitialAd(context);
        this.f61j.setAdUnitId(serverParameters.getString("pubid"));
        this.f61j.setAdListener(new C0602b(this, interstitialListener));
        this.f61j.loadAd(m3166a(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f61j.show();
    }
}
