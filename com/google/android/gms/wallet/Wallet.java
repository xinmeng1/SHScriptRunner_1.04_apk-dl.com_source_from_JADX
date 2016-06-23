package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.lf;
import com.google.android.gms.internal.lq;
import com.google.android.gms.internal.lr;
import com.google.android.gms.internal.lt;
import com.google.android.gms.internal.lu;
import com.google.android.gms.wallet.wobs.C0558r;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API;
    public static final Payments Payments;
    public static final C0558r ajZ;
    public static final lf aka;
    private static final C0177c<lr> yH;
    private static final C0176b<lr, WalletOptions> yI;

    /* renamed from: com.google.android.gms.wallet.Wallet.1 */
    static class C09851 implements C0176b<lr, WalletOptions> {
        C09851() {
        }

        public lr m3070a(Context context, Looper looper, gy gyVar, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            hm.m1230b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new lr(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, gyVar.getAccountName(), walletOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int akb;
            private int mTheme;

            public Builder() {
                this.akb = 0;
                this.mTheme = 0;
            }

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.akb = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.akb;
            this.theme = builder.mTheme;
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.a */
    public static abstract class C1228a<R extends Result> extends C1029b<R, lr> {
        public C1228a() {
            super(Wallet.yH);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.b */
    public static abstract class C1283b extends C1228a<Status> {
        protected /* synthetic */ Result m4267c(Status status) {
            return m4268d(status);
        }

        protected Status m4268d(Status status) {
            return status;
        }
    }

    static {
        yH = new C0177c();
        yI = new C09851();
        API = new Api(yI, yH, new Scope[0]);
        Payments = new lq();
        ajZ = new lu();
        aka = new lt();
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
