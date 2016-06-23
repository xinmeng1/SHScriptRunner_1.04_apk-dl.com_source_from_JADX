package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.dc.C0728a;

public final class dh extends C0728a {
    private final InAppPurchaseListener mB;

    public dh(InAppPurchaseListener inAppPurchaseListener) {
        this.mB = inAppPurchaseListener;
    }

    public void m3580a(db dbVar) {
        this.mB.onInAppPurchaseRequested(new dk(dbVar));
    }
}
