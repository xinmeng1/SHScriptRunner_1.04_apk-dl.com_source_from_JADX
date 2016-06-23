package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.C1283b;

public class lq implements Payments {

    /* renamed from: com.google.android.gms.internal.lq.1 */
    class C14421 extends C1283b {
        final /* synthetic */ int UD;
        final /* synthetic */ lq akG;

        C14421(lq lqVar, int i) {
            this.akG = lqVar;
            this.UD = i;
        }

        protected void m4679a(lr lrVar) {
            lrVar.dQ(this.UD);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.lq.2 */
    class C14432 extends C1283b {
        final /* synthetic */ int UD;
        final /* synthetic */ lq akG;
        final /* synthetic */ MaskedWalletRequest akH;

        C14432(lq lqVar, MaskedWalletRequest maskedWalletRequest, int i) {
            this.akG = lqVar;
            this.akH = maskedWalletRequest;
            this.UD = i;
        }

        protected void m4681a(lr lrVar) {
            lrVar.m3734a(this.akH, this.UD);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.lq.3 */
    class C14443 extends C1283b {
        final /* synthetic */ int UD;
        final /* synthetic */ lq akG;
        final /* synthetic */ FullWalletRequest akI;

        C14443(lq lqVar, FullWalletRequest fullWalletRequest, int i) {
            this.akG = lqVar;
            this.akI = fullWalletRequest;
            this.UD = i;
        }

        protected void m4683a(lr lrVar) {
            lrVar.m3733a(this.akI, this.UD);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.lq.4 */
    class C14454 extends C1283b {
        final /* synthetic */ int UD;
        final /* synthetic */ lq akG;
        final /* synthetic */ String akJ;
        final /* synthetic */ String akK;

        C14454(lq lqVar, String str, String str2, int i) {
            this.akG = lqVar;
            this.akJ = str;
            this.akK = str2;
            this.UD = i;
        }

        protected void m4685a(lr lrVar) {
            lrVar.m3736d(this.akJ, this.akK, this.UD);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.lq.5 */
    class C14465 extends C1283b {
        final /* synthetic */ lq akG;
        final /* synthetic */ NotifyTransactionStatusRequest akL;

        C14465(lq lqVar, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.akG = lqVar;
            this.akL = notifyTransactionStatusRequest;
        }

        protected void m4687a(lr lrVar) {
            lrVar.m3735a(this.akL);
            m1984b(Status.En);
        }
    }

    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        googleApiClient.m146a(new C14454(this, googleTransactionId, merchantTransactionId, requestCode));
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        googleApiClient.m146a(new C14421(this, requestCode));
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        googleApiClient.m146a(new C14443(this, request, requestCode));
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        googleApiClient.m146a(new C14432(this, request, requestCode));
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        googleApiClient.m146a(new C14465(this, request));
    }
}
