package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.kl;
import com.google.android.gms.internal.km;
import com.google.android.gms.plus.internal.C0943h;
import com.google.android.gms.plus.internal.C1165e;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API;
    public static final Account AccountApi;
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    public static final C0457b abp;
    public static final C0456a abq;
    public static final C0177c<C1165e> yH;
    static final C0176b<C1165e, PlusOptions> yI;

    /* renamed from: com.google.android.gms.plus.Plus.1 */
    static class C09241 implements C0176b<C1165e, PlusOptions> {
        C09241() {
        }

        public C1165e m2889a(Context context, Looper looper, gy gyVar, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new C1165e(context, looper, connectionCallbacks, onConnectionFailedListener, new C0943h(gyVar.fj(), gyVar.fm(), (String[]) plusOptions.abs.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }

        public int getPriority() {
            return 2;
        }
    }

    public static final class PlusOptions implements Optional {
        final String abr;
        final Set<String> abs;

        public static final class Builder {
            String abr;
            final Set<String> abs;

            public Builder() {
                this.abs = new HashSet();
            }

            public Builder addActivityTypes(String... activityTypes) {
                hm.m1228b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.abs.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.abr = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.abr = null;
            this.abs = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.abr = builder.abr;
            this.abs = builder.abs;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus.a */
    public static abstract class C1222a<R extends Result> extends C1029b<R, C1165e> {
        public C1222a() {
            super(Plus.yH);
        }
    }

    static {
        yH = new C0177c();
        yI = new C09241();
        API = new Api(yI, yH, new Scope[0]);
        SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
        SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
        MomentsApi = new kl();
        PeopleApi = new km();
        AccountApi = new ki();
        abp = new kk();
        abq = new kj();
    }

    private Plus() {
    }

    public static C1165e m1550a(GoogleApiClient googleApiClient, C0177c<C1165e> c0177c) {
        boolean z = true;
        hm.m1230b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.m1226a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1165e c1165e = (C1165e) googleApiClient.m145a((C0177c) c0177c);
        if (c1165e == null) {
            z = false;
        }
        hm.m1226a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c1165e;
    }
}
