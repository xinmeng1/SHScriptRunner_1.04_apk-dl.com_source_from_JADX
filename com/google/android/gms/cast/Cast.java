package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API;
    public static final CastApi CastApi;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final C0177c<gh> yH;
    private static final C0176b<gh, CastOptions> yI;

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast.CastApi.a */
        public static final class C0623a implements CastApi {

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.1 */
            class C13071 extends C1244b {
                final /* synthetic */ String zU;
                final /* synthetic */ String zV;
                final /* synthetic */ C0623a zW;

                C13071(C0623a c0623a, String str, String str2) {
                    this.zW = c0623a;
                    this.zU = str;
                    this.zV = str2;
                    super();
                }

                protected void m4340a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3653a(this.zU, this.zV, (C0180d) this);
                    } catch (IllegalArgumentException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    } catch (IllegalStateException e2) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.2 */
            class C13082 extends C1245c {
                final /* synthetic */ C0623a zW;
                final /* synthetic */ String zX;

                C13082(C0623a c0623a, String str) {
                    this.zW = c0623a;
                    this.zX = str;
                    super();
                }

                protected void m4342a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3654a(this.zX, false, (C0180d) this);
                    } catch (IllegalStateException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.3 */
            class C13093 extends C1245c {
                final /* synthetic */ C0623a zW;
                final /* synthetic */ String zX;
                final /* synthetic */ LaunchOptions zY;

                C13093(C0623a c0623a, String str, LaunchOptions launchOptions) {
                    this.zW = c0623a;
                    this.zX = str;
                    this.zY = launchOptions;
                    super();
                }

                protected void m4344a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3651a(this.zX, this.zY, (C0180d) this);
                    } catch (IllegalStateException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.4 */
            class C13104 extends C1245c {
                final /* synthetic */ C0623a zW;
                final /* synthetic */ String zX;
                final /* synthetic */ String zZ;

                C13104(C0623a c0623a, String str, String str2) {
                    this.zW = c0623a;
                    this.zX = str;
                    this.zZ = str2;
                    super();
                }

                protected void m4346a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3655b(this.zX, this.zZ, this);
                    } catch (IllegalStateException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.5 */
            class C13115 extends C1245c {
                final /* synthetic */ C0623a zW;
                final /* synthetic */ String zX;

                C13115(C0623a c0623a, String str) {
                    this.zW = c0623a;
                    this.zX = str;
                    super();
                }

                protected void m4348a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3655b(this.zX, null, this);
                    } catch (IllegalStateException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.6 */
            class C13126 extends C1245c {
                final /* synthetic */ C0623a zW;

                C13126(C0623a c0623a) {
                    this.zW = c0623a;
                    super();
                }

                protected void m4350a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3655b(null, null, this);
                    } catch (IllegalStateException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.7 */
            class C13137 extends C1244b {
                final /* synthetic */ C0623a zW;

                C13137(C0623a c0623a) {
                    this.zW = c0623a;
                    super();
                }

                protected void m4352a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3656d((C0180d) this);
                    } catch (IllegalStateException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.8 */
            class C13148 extends C1244b {
                final /* synthetic */ C0623a zW;

                C13148(C0623a c0623a) {
                    this.zW = c0623a;
                    super();
                }

                protected void m4354a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3652a("", (C0180d) this);
                    } catch (IllegalStateException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.9 */
            class C13159 extends C1244b {
                final /* synthetic */ C0623a zW;
                final /* synthetic */ String zZ;

                C13159(C0623a c0623a, String str) {
                    this.zW = c0623a;
                    this.zZ = str;
                    super();
                }

                protected void m4356a(gh ghVar) throws RemoteException {
                    if (TextUtils.isEmpty(this.zZ)) {
                        m3904c(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try {
                        ghVar.m3652a(this.zZ, (C0180d) this);
                    } catch (IllegalStateException e) {
                        m3903N(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.m145a(Cast.yH)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.m145a(Cast.yH)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.m145a(Cast.yH)).eh();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.m145a(Cast.yH)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.m147b(new C13126(this));
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId) {
                return client.m147b(new C13115(this, applicationId));
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId, String sessionId) {
                return client.m147b(new C13104(this, applicationId, sessionId));
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId) {
                return client.m147b(new C13082(this, applicationId));
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, LaunchOptions options) {
                return client.m147b(new C13093(this, applicationId, options));
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.m147b(new C13137(this));
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((gh) client.m145a(Cast.yH)).aj(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((gh) client.m145a(Cast.yH)).eg();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, String namespace, String message) {
                return client.m147b(new C13071(this, namespace, message));
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((gh) client.m145a(Cast.yH)).m3650a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((gh) client.m145a(Cast.yH)).m3658y(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((gh) client.m145a(Cast.yH)).m3647a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.m147b(new C13148(this));
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, String sessionId) {
                return client.m147b(new C13159(this, sessionId));
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static class Listener {
        public void m97O(int i) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast.1 */
    static class C06221 implements C0176b<gh, CastOptions> {
        C06221() {
        }

        public gh m1966a(Context context, Looper looper, gy gyVar, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            hm.m1228b((Object) castOptions, (Object) "Setting the API options is required.");
            return new gh(context, looper, castOptions.Aa, (long) castOptions.Ac, castOptions.Ab, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice Aa;
        final Listener Ab;
        private final int Ac;

        public static final class Builder {
            CastDevice Ad;
            Listener Ae;
            private int Af;

            private Builder(CastDevice castDevice, Listener castListener) {
                hm.m1228b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                hm.m1228b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.Ad = castDevice;
                this.Ae = castListener;
                this.Af = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.Af |= 1;
                } else {
                    this.Af &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.Aa = builder.Ad;
            this.Ab = builder.Ae;
            this.Ac = builder.Af;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castListener, null);
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.a */
    protected static abstract class C1188a<R extends Result> extends C1029b<R, gh> {
        public C1188a() {
            super(Cast.yH);
        }

        public void m3903N(int i) {
            m1984b(m1985c(new Status(i)));
        }

        public void m3904c(int i, String str) {
            m1984b(m1985c(new Status(i, str, null)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.b */
    private static abstract class C1244b extends C1188a<Status> {
        private C1244b() {
        }

        public /* synthetic */ Result m4119c(Status status) {
            return m4120d(status);
        }

        public Status m4120d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.c */
    private static abstract class C1245c extends C1188a<ApplicationConnectionResult> {

        /* renamed from: com.google.android.gms.cast.Cast.c.1 */
        class C10251 implements ApplicationConnectionResult {
            final /* synthetic */ C1245c Ag;
            final /* synthetic */ Status yJ;

            C10251(C1245c c1245c, Status status) {
                this.Ag = c1245c;
                this.yJ = status;
            }

            public ApplicationMetadata getApplicationMetadata() {
                return null;
            }

            public String getApplicationStatus() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public boolean getWasLaunched() {
                return false;
            }
        }

        private C1245c() {
        }

        public /* synthetic */ Result m4121c(Status status) {
            return m4122j(status);
        }

        public ApplicationConnectionResult m4122j(Status status) {
            return new C10251(this, status);
        }
    }

    static {
        yH = new C0177c();
        yI = new C06221();
        API = new Api(yI, yH, new Scope[0]);
        CastApi = new C0623a();
    }

    private Cast() {
    }
}
