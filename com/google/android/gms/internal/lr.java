package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hb.C1119e;
import com.google.android.gms.internal.lm.C0813a;
import com.google.android.gms.internal.lp.C0819a;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

public class lr extends hb<lm> {
    private final int akb;
    private final int mTheme;
    private final Activity og;
    private final String yQ;

    /* renamed from: com.google.android.gms.internal.lr.a */
    private static class C1142a extends C0819a {
        private C1142a() {
        }

        public void m3725a(int i, FullWallet fullWallet, Bundle bundle) {
        }

        public void m3726a(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        public void m3727a(int i, boolean z, Bundle bundle) {
        }

        public void m3728a(Status status, li liVar, Bundle bundle) {
        }

        public void m3729i(int i, Bundle bundle) {
        }
    }

    /* renamed from: com.google.android.gms.internal.lr.b */
    final class C1219b extends C1142a {
        private final int FW;
        final /* synthetic */ lr akM;

        public C1219b(lr lrVar, int i) {
            this.akM = lrVar;
            super();
            this.FW = i;
        }

        public void m4079a(int i, FullWallet fullWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.akM.og, this.FW);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.akM.og.createPendingResult(this.FW, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void m4080a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.akM.og, this.FW);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.akM.og.createPendingResult(this.FW, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void m4081a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = this.akM.og.createPendingResult(this.FW, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void m4082i(int i, Bundle bundle) {
            hm.m1228b((Object) bundle, (Object) "Bundle should not be null");
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.akM.og, this.FW);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent createPendingResult = this.akM.og.createPendingResult(this.FW, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public lr(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.og = activity;
        this.akb = i;
        this.yQ = str;
        this.mTheme = i2;
    }

    public static Bundle m3730a(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    private Bundle ni() {
        return m3730a(this.akb, this.og.getPackageName(), this.yQ, this.mTheme);
    }

    protected void m3732a(hi hiVar, C1119e c1119e) throws RemoteException {
        hiVar.m1184a(c1119e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public void m3733a(FullWalletRequest fullWalletRequest, int i) {
        lp c1219b = new C1219b(this, i);
        try {
            ((lm) ft()).m1346a(fullWalletRequest, ni(), c1219b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            c1219b.m4079a(8, null, Bundle.EMPTY);
        }
    }

    public void m3734a(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle ni = ni();
        lp c1219b = new C1219b(this, i);
        try {
            ((lm) ft()).m1348a(maskedWalletRequest, ni, c1219b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            c1219b.m4080a(8, null, Bundle.EMPTY);
        }
    }

    public void m3735a(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((lm) ft()).m1349a(notifyTransactionStatusRequest, ni());
        } catch (RemoteException e) {
        }
    }

    protected lm bu(IBinder iBinder) {
        return C0813a.bq(iBinder);
    }

    protected String bu() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String bv() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void m3736d(String str, String str2, int i) {
        Bundle ni = ni();
        Object c1219b = new C1219b(this, i);
        try {
            ((lm) ft()).m1351a(str, str2, ni, c1219b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            c1219b.m4080a(8, null, Bundle.EMPTY);
        }
    }

    public void dQ(int i) {
        Bundle ni = ni();
        lp c1219b = new C1219b(this, i);
        try {
            ((lm) ft()).m1344a(ni, c1219b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            c1219b.m4081a(8, false, Bundle.EMPTY);
        }
    }

    protected /* synthetic */ IInterface m3737x(IBinder iBinder) {
        return bu(iBinder);
    }
}
