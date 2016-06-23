package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.C0280d;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.internal.bu.C0717a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class bz<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0717a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> nU;
    private final NETWORK_EXTRAS nV;

    public bz(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.nU = mediationAdapter;
        this.nV = network_extras;
    }

    private SERVER_PARAMETERS m3499b(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                eu.m1017c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.nU.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void m3500a(C0280d c0280d, ai aiVar, String str, bv bvVar) throws RemoteException {
        m3501a(c0280d, aiVar, str, null, bvVar);
    }

    public void m3501a(C0280d c0280d, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
        if (this.nU instanceof MediationInterstitialAdapter) {
            eu.m1019z("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nU).requestInterstitialAd(new ca(bvVar), (Activity) C1057e.m3259e(c0280d), m3499b(str, aiVar.lW, str2), cb.m845e(aiVar), this.nV);
            } catch (Throwable th) {
                eu.m1017c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.m1014D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m3502a(C0280d c0280d, al alVar, ai aiVar, String str, bv bvVar) throws RemoteException {
        m3503a(c0280d, alVar, aiVar, str, null, bvVar);
    }

    public void m3503a(C0280d c0280d, al alVar, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
        if (this.nU instanceof MediationBannerAdapter) {
            eu.m1019z("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.nU).requestBannerAd(new ca(bvVar), (Activity) C1057e.m3259e(c0280d), m3499b(str, aiVar.lW, str2), cb.m844b(alVar), cb.m845e(aiVar), this.nV);
            } catch (Throwable th) {
                eu.m1017c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.m1014D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.nU.destroy();
        } catch (Throwable th) {
            eu.m1017c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0280d getView() throws RemoteException {
        if (this.nU instanceof MediationBannerAdapter) {
            try {
                return C1057e.m3260h(((MediationBannerAdapter) this.nU).getBannerView());
            } catch (Throwable th) {
                eu.m1017c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.m1014D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.nU instanceof MediationInterstitialAdapter) {
            eu.m1019z("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nU).showInterstitial();
            } catch (Throwable th) {
                eu.m1017c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.m1014D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
