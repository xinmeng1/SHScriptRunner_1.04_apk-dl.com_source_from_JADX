package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final C0176b<?, O> Dm;
    private final C0177c<?> Dn;
    private final ArrayList<Scope> Do;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* renamed from: com.google.android.gms.common.api.Api.a */
    public interface C0175a {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.common.api.Api.b */
    public interface C0176b<T extends C0175a, O> {
        T m144a(Context context, Looper looper, gy gyVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    /* renamed from: com.google.android.gms.common.api.Api.c */
    public static final class C0177c<C extends C0175a> {
    }

    public <C extends C0175a> Api(C0176b<C, O> clientBuilder, C0177c<C> clientKey, Scope... impliedScopes) {
        this.Dm = clientBuilder;
        this.Dn = clientKey;
        this.Do = new ArrayList(Arrays.asList(impliedScopes));
    }

    public List<Scope> eA() {
        return this.Do;
    }

    public C0177c<?> eB() {
        return this.Dn;
    }

    public C0176b<?, O> ez() {
        return this.Dm;
    }
}
