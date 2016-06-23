package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0464i;
import com.google.android.gms.plus.internal.C1165e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C1165e abt;

    @Deprecated
    public static class Builder {
        private final C0464i abA;
        private final ConnectionCallbacks aby;
        private final OnConnectionFailedListener abz;
        private final Context mContext;

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.aby = connectionCallbacks;
            this.abz = connectionFailedListener;
            this.abA = new C0464i(this.mContext);
        }

        public PlusClient build() {
            return new PlusClient(new C1165e(this.mContext, this.aby, this.abz, this.abA.kj()));
        }

        public Builder clearScopes() {
            this.abA.ki();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.abA.bz(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.abA.m1583f(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.abA.m1582e(scopes);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        public static final int ALPHABETICAL = 0;
        @Deprecated
        public static final int BEST = 1;
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.1 */
    class C09251 implements C0180d<LoadMomentsResult> {
        final /* synthetic */ OnMomentsLoadedListener abu;
        final /* synthetic */ PlusClient abv;

        C09251(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.abv = plusClient;
            this.abu = onMomentsLoadedListener;
        }

        public void m2890a(LoadMomentsResult loadMomentsResult) {
            this.abu.onMomentsLoaded(loadMomentsResult.getStatus().eR(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.2 */
    class C09262 implements C0180d<LoadMomentsResult> {
        final /* synthetic */ OnMomentsLoadedListener abu;
        final /* synthetic */ PlusClient abv;

        C09262(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.abv = plusClient;
            this.abu = onMomentsLoadedListener;
        }

        public void m2892a(LoadMomentsResult loadMomentsResult) {
            this.abu.onMomentsLoaded(loadMomentsResult.getStatus().eR(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.3 */
    class C09273 implements C0180d<LoadPeopleResult> {
        final /* synthetic */ PlusClient abv;
        final /* synthetic */ OnPeopleLoadedListener abw;

        C09273(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.abv = plusClient;
            this.abw = onPeopleLoadedListener;
        }

        public void m2894a(LoadPeopleResult loadPeopleResult) {
            this.abw.onPeopleLoaded(loadPeopleResult.getStatus().eR(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.4 */
    class C09284 implements C0180d<LoadPeopleResult> {
        final /* synthetic */ PlusClient abv;
        final /* synthetic */ OnPeopleLoadedListener abw;

        C09284(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.abv = plusClient;
            this.abw = onPeopleLoadedListener;
        }

        public void m2896a(LoadPeopleResult loadPeopleResult) {
            this.abw.onPeopleLoaded(loadPeopleResult.getStatus().eR(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.5 */
    class C09295 implements C0180d<LoadPeopleResult> {
        final /* synthetic */ PlusClient abv;
        final /* synthetic */ OnPeopleLoadedListener abw;

        C09295(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.abv = plusClient;
            this.abw = onPeopleLoadedListener;
        }

        public void m2898a(LoadPeopleResult loadPeopleResult) {
            this.abw.onPeopleLoaded(loadPeopleResult.getStatus().eR(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.6 */
    class C09306 implements C0180d<LoadPeopleResult> {
        final /* synthetic */ PlusClient abv;
        final /* synthetic */ OnPeopleLoadedListener abw;

        C09306(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.abv = plusClient;
            this.abw = onPeopleLoadedListener;
        }

        public void m2900a(LoadPeopleResult loadPeopleResult) {
            this.abw.onPeopleLoaded(loadPeopleResult.getStatus().eR(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.7 */
    class C09317 implements C0180d<Status> {
        final /* synthetic */ PlusClient abv;
        final /* synthetic */ OnAccessRevokedListener abx;

        C09317(PlusClient plusClient, OnAccessRevokedListener onAccessRevokedListener) {
            this.abv = plusClient;
            this.abx = onAccessRevokedListener;
        }

        public /* synthetic */ void m2902a(Object obj) {
            al((Status) obj);
        }

        public void al(Status status) {
            this.abx.onAccessRevoked(status.getStatus().eR());
        }
    }

    PlusClient(C1165e plusClientImpl) {
        this.abt = plusClientImpl;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.abt.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.abt.connect();
    }

    @Deprecated
    public void disconnect() {
        this.abt.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.abt.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.abt.getCurrentPerson();
    }

    @Deprecated
    public boolean isConnected() {
        return this.abt.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.abt.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.abt.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.abt.isConnectionFailedListenerRegistered(listener);
    }

    C1165e jS() {
        return this.abt;
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener listener) {
        this.abt.m3806k(new C09251(this, listener));
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.abt.m3801a(new C09262(this, listener), maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.abt.m3803a(new C09295(this, listener), (Collection) personIds);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener listener, String... personIds) {
        this.abt.m3805d(new C09306(this, listener), personIds);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.abt.m3799a(new C09273(this, listener), orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener listener, String pageToken) {
        this.abt.m3809r(new C09284(this, listener), pageToken);
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.abt.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.abt.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.abt.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(OnAccessRevokedListener listener) {
        this.abt.m3808m(new C09317(this, listener));
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.abt.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.abt.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.abt.m3802a(null, moment);
    }
}
