package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestSummariesImpl.1 */
        class C10851 implements LoadRequestSummariesResult {
            final /* synthetic */ LoadRequestSummariesImpl QE;
            final /* synthetic */ Status yJ;

            C10851(LoadRequestSummariesImpl loadRequestSummariesImpl, Status status) {
                this.QE = loadRequestSummariesImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadRequestSummariesImpl() {
        }

        public LoadRequestSummariesResult m4223V(Status status) {
            return new C10851(this, status);
        }

        public /* synthetic */ Result m4224c(Status status) {
            return m4223V(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestsImpl.1 */
        class C10861 implements LoadRequestsResult {
            final /* synthetic */ LoadRequestsImpl QF;
            final /* synthetic */ Status yJ;

            C10861(LoadRequestsImpl loadRequestsImpl, Status status) {
                this.QF = loadRequestsImpl;
                this.yJ = status;
            }

            public GameRequestBuffer getRequests(int type) {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadRequestsImpl() {
        }

        public LoadRequestsResult m4225W(Status status) {
            return new C10861(this, status);
        }

        public /* synthetic */ Result m4226c(Status status) {
            return m4225W(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.SendRequestImpl.1 */
        class C10871 implements SendRequestResult {
            final /* synthetic */ SendRequestImpl QG;
            final /* synthetic */ Status yJ;

            C10871(SendRequestImpl sendRequestImpl, Status status) {
                this.QG = sendRequestImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private SendRequestImpl() {
        }

        public SendRequestResult m4227X(Status status) {
            return new C10871(this, status);
        }

        public /* synthetic */ Result m4228c(Status status) {
            return m4227X(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.UpdateRequestsImpl.1 */
        class C10881 implements UpdateRequestsResult {
            final /* synthetic */ UpdateRequestsImpl QH;
            final /* synthetic */ Status yJ;

            C10881(UpdateRequestsImpl updateRequestsImpl, Status status) {
                this.QH = updateRequestsImpl;
                this.yJ = status;
            }

            public Set<String> getRequestIds() {
                return null;
            }

            public int getRequestOutcome(String requestId) {
                throw new IllegalArgumentException("Unknown request ID " + requestId);
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private UpdateRequestsImpl() {
        }

        public UpdateRequestsResult m4229Y(Status status) {
            return new C10881(this, status);
        }

        public /* synthetic */ Result m4230c(Status status) {
            return m4229Y(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.1 */
    class C13941 extends UpdateRequestsImpl {
        final /* synthetic */ String[] Qw;
        final /* synthetic */ RequestsImpl Qx;

        C13941(RequestsImpl requestsImpl, String[] strArr) {
            this.Qx = requestsImpl;
            this.Qw = strArr;
            super();
        }

        protected void m4578a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3399b((C0180d) this, this.Qw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.2 */
    class C13952 extends UpdateRequestsImpl {
        final /* synthetic */ String[] Qw;
        final /* synthetic */ RequestsImpl Qx;

        C13952(RequestsImpl requestsImpl, String[] strArr) {
            this.Qx = requestsImpl;
            this.Qw = strArr;
            super();
        }

        protected void m4580a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3411c((C0180d) this, this.Qw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.3 */
    class C13963 extends LoadRequestsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ RequestsImpl Qx;
        final /* synthetic */ int Qy;
        final /* synthetic */ int Qz;

        C13963(RequestsImpl requestsImpl, int i, int i2, int i3) {
            this.Qx = requestsImpl;
            this.Qy = i;
            this.Qz = i2;
            this.PE = i3;
            super();
        }

        protected void m4582a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3344a((C0180d) this, this.Qy, this.Qz, this.PE);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.4 */
    class C13974 extends SendRequestImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] QA;
        final /* synthetic */ int QB;
        final /* synthetic */ byte[] QC;
        final /* synthetic */ int QD;

        protected void m4584a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3372a((C0180d) this, this.Ph, this.QA, this.QB, this.QC, this.QD);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.5 */
    class C13985 extends SendRequestImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] QA;
        final /* synthetic */ int QB;
        final /* synthetic */ byte[] QC;
        final /* synthetic */ int QD;

        protected void m4586a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3372a((C0180d) this, this.Ph, this.QA, this.QB, this.QC, this.QD);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.6 */
    class C13996 extends UpdateRequestsImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String Qs;
        final /* synthetic */ String[] Qw;

        protected void m4588a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3368a((C0180d) this, this.Ph, this.Qs, this.Qw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.7 */
    class C14007 extends LoadRequestsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ String Ph;
        final /* synthetic */ String Qs;
        final /* synthetic */ int Qy;
        final /* synthetic */ int Qz;

        protected void m4590a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3361a((C0180d) this, this.Ph, this.Qs, this.Qy, this.Qz, this.PE);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.8 */
    class C14018 extends LoadRequestSummariesImpl {
        final /* synthetic */ String Qs;
        final /* synthetic */ int Qz;

        protected void m4592a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3428f(this, this.Qs, this.Qz);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.m147b(new C13941(this, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.m147b(new C13952(this, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hq();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hs();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hr();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.m472c(apiClient).m3338a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        return apiClient.m146a(new C13963(this, requestDirection, types, sortOrder));
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.m472c(apiClient).m3383a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.m472c(apiClient).hk();
    }
}
