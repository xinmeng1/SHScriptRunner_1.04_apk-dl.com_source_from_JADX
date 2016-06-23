package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
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
import com.google.android.gms.internal.iw;

public final class Address {
    public static final Api<AddressOptions> API;
    static final C0177c<iw> yH;
    private static final C0176b<iw, AddressOptions> yI;

    /* renamed from: com.google.android.gms.identity.intents.Address.1 */
    static class C06921 implements C0176b<iw, AddressOptions> {
        C06921() {
        }

        public iw m2436a(Context context, Looper looper, gy gyVar, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            hm.m1230b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new iw((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, gyVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.a */
    private static abstract class C1202a extends C1029b<Status, iw> {
        public C1202a() {
            super(Address.yH);
        }

        public /* synthetic */ Result m4054c(Status status) {
            return m4055d(status);
        }

        public Status m4055d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.2 */
    static class C12632 extends C1202a {
        final /* synthetic */ UserAddressRequest UC;
        final /* synthetic */ int UD;

        C12632(UserAddressRequest userAddressRequest, int i) {
            this.UC = userAddressRequest;
            this.UD = i;
        }

        protected void m4244a(iw iwVar) throws RemoteException {
            iwVar.m3684a(this.UC, this.UD);
            m1984b(Status.En);
        }
    }

    static {
        yH = new C0177c();
        yI = new C06921();
        API = new Api(yI, yH, new Scope[0]);
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest request, int requestCode) {
        googleApiClient.m146a(new C12632(request, requestCode));
    }
}
