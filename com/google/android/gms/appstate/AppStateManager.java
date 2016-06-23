package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0175a;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;

public final class AppStateManager {
    public static final Api<NoOptions> API;
    public static final Scope SCOPE_APP_STATE;
    static final C0177c<ga> yH;
    private static final C0176b<ga, NoOptions> yI;

    /* renamed from: com.google.android.gms.appstate.AppStateManager.1 */
    static class C06211 implements C0176b<ga, NoOptions> {
        C06211() {
        }

        public /* synthetic */ C0175a m1963a(Context context, Looper looper, gy gyVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1964b(context, looper, gyVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public ga m1964b(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ga(context, looper, connectionCallbacks, onConnectionFailedListener, gyVar.fj(), (String[]) gyVar.fl().toArray(new String[0]));
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.2 */
    static class C10202 implements StateResult {
        final /* synthetic */ Status yJ;

        C10202(Status status) {
            this.yJ = status;
        }

        public StateConflictResult getConflictResult() {
            return null;
        }

        public StateLoadedResult getLoadedResult() {
            return null;
        }

        public Status getStatus() {
            return this.yJ;
        }

        public void release() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.a */
    public static abstract class C1187a<R extends Result> extends C1029b<R, ga> {
        public C1187a() {
            super(AppStateManager.yH);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.b */
    private static abstract class C1240b extends C1187a<StateDeletedResult> {
        private C1240b() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.c */
    private static abstract class C1241c extends C1187a<StateListResult> {

        /* renamed from: com.google.android.gms.appstate.AppStateManager.c.1 */
        class C10221 implements StateListResult {
            final /* synthetic */ Status yJ;
            final /* synthetic */ C1241c yP;

            C10221(C1241c c1241c, Status status) {
                this.yP = c1241c;
                this.yJ = status;
            }

            public AppStateBuffer getStateBuffer() {
                return new AppStateBuffer(null);
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private C1241c() {
        }

        public /* synthetic */ Result m4113c(Status status) {
            return m4114h(status);
        }

        public StateListResult m4114h(Status status) {
            return new C10221(this, status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.d */
    private static abstract class C1242d extends C1187a<Status> {
        private C1242d() {
        }

        public /* synthetic */ Result m4115c(Status status) {
            return m4116d(status);
        }

        public Status m4116d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.e */
    private static abstract class C1243e extends C1187a<StateResult> {
        private C1243e() {
        }

        public /* synthetic */ Result m4117c(Status status) {
            return m4118i(status);
        }

        public StateResult m4118i(Status status) {
            return AppStateManager.m90e(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.3 */
    static class C13003 extends C1243e {
        final /* synthetic */ int yK;
        final /* synthetic */ byte[] yL;

        C13003(int i, byte[] bArr) {
            this.yK = i;
            this.yL = bArr;
            super();
        }

        protected void m4324a(ga gaVar) {
            gaVar.m3605a(null, this.yK, this.yL);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.4 */
    static class C13014 extends C1243e {
        final /* synthetic */ int yK;
        final /* synthetic */ byte[] yL;

        C13014(int i, byte[] bArr) {
            this.yK = i;
            this.yL = bArr;
            super();
        }

        protected void m4326a(ga gaVar) {
            gaVar.m3605a(this, this.yK, this.yL);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.5 */
    static class C13025 extends C1240b {
        final /* synthetic */ int yK;

        /* renamed from: com.google.android.gms.appstate.AppStateManager.5.1 */
        class C10211 implements StateDeletedResult {
            final /* synthetic */ Status yJ;
            final /* synthetic */ C13025 yM;

            C10211(C13025 c13025, Status status) {
                this.yM = c13025;
                this.yJ = status;
            }

            public int getStateKey() {
                return this.yM.yK;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        C13025(int i) {
            this.yK = i;
            super();
        }

        protected void m4328a(ga gaVar) {
            gaVar.m3603a((C0180d) this, this.yK);
        }

        public /* synthetic */ Result m4329c(Status status) {
            return m4330g(status);
        }

        public StateDeletedResult m4330g(Status status) {
            return new C10211(this, status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.6 */
    static class C13036 extends C1243e {
        final /* synthetic */ int yK;

        C13036(int i) {
            this.yK = i;
            super();
        }

        protected void m4332a(ga gaVar) {
            gaVar.m3608b(this, this.yK);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.7 */
    static class C13047 extends C1241c {
        C13047() {
            super();
        }

        protected void m4334a(ga gaVar) {
            gaVar.m3602a(this);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.8 */
    static class C13058 extends C1243e {
        final /* synthetic */ int yK;
        final /* synthetic */ String yN;
        final /* synthetic */ byte[] yO;

        C13058(int i, String str, byte[] bArr) {
            this.yK = i;
            this.yN = str;
            this.yO = bArr;
            super();
        }

        protected void m4336a(ga gaVar) {
            gaVar.m3604a(this, this.yK, this.yN, this.yO);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.9 */
    static class C13069 extends C1242d {
        C13069() {
            super();
        }

        protected void m4338a(ga gaVar) {
            gaVar.m3607b((C0180d) this);
        }
    }

    static {
        yH = new C0177c();
        yI = new C06211();
        SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
        API = new Api(yI, yH, SCOPE_APP_STATE);
    }

    private AppStateManager() {
    }

    public static ga m89a(GoogleApiClient googleApiClient) {
        boolean z = true;
        hm.m1230b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.m1226a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        ga gaVar = (ga) googleApiClient.m145a(yH);
        if (gaVar == null) {
            z = false;
        }
        hm.m1226a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gaVar;
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.m147b(new C13025(stateKey));
    }

    private static StateResult m90e(Status status) {
        return new C10202(status);
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m89a(googleApiClient).dV();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m89a(googleApiClient).dU();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.m146a(new C13047());
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.m146a(new C13036(stateKey));
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, int stateKey, String resolvedVersion, byte[] resolvedData) {
        return googleApiClient.m147b(new C13058(stateKey, resolvedVersion, resolvedData));
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.m147b(new C13069());
    }

    public static void update(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        googleApiClient.m147b(new C13003(stateKey, data));
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        return googleApiClient.m147b(new C13014(stateKey, data));
    }
}
