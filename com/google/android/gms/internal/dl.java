package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.dg.C0736a;

public final class dl extends C0736a {
    private final PlayStorePurchaseListener mC;

    public dl(PlayStorePurchaseListener playStorePurchaseListener) {
        this.mC = playStorePurchaseListener;
    }

    public void m3581a(df dfVar) {
        this.mC.onInAppPurchaseFinished(new dj(dfVar));
    }

    public boolean isValidPurchase(String productId) {
        return this.mC.isValidPurchase(productId);
    }
}
