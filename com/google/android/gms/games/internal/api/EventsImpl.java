package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.1 */
        class C10621 implements LoadEventsResult {
            final /* synthetic */ LoadImpl Pr;
            final /* synthetic */ Status yJ;

            C10621(LoadImpl loadImpl, Status status) {
                this.Pr = loadImpl;
                this.yJ = status;
            }

            public EventBuffer getEvents() {
                return new EventBuffer(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadImpl() {
        }

        public LoadEventsResult m4170A(Status status) {
            return new C10621(this, status);
        }

        public /* synthetic */ Result m4171c(Status status) {
            return m4170A(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.1 */
        class C06911 implements Result {
            final /* synthetic */ UpdateImpl Ps;
            final /* synthetic */ Status yJ;

            C06911(UpdateImpl updateImpl, Status status) {
                this.Ps = updateImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private UpdateImpl() {
        }

        public Result m4172c(Status status) {
            return new C06911(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.1 */
    class C13511 extends LoadImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String[] Pn;
        final /* synthetic */ EventsImpl Po;

        C13511(EventsImpl eventsImpl, boolean z, String[] strArr) {
            this.Po = eventsImpl;
            this.Pe = z;
            this.Pn = strArr;
            super();
        }

        public void m4434a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3375a((C0180d) this, this.Pe, this.Pn);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.2 */
    class C13522 extends LoadImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ EventsImpl Po;

        C13522(EventsImpl eventsImpl, boolean z) {
            this.Po = eventsImpl;
            this.Pe = z;
            super();
        }

        public void m4436a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3419d((C0180d) this, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.3 */
    class C13533 extends UpdateImpl {
        final /* synthetic */ EventsImpl Po;
        final /* synthetic */ String Pp;
        final /* synthetic */ int Pq;

        C13533(EventsImpl eventsImpl, String str, int i) {
            this.Po = eventsImpl;
            this.Pp = str;
            this.Pq = i;
            super();
        }

        public void m4438a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3443l(this.Pp, this.Pq);
        }
    }

    public void increment(GoogleApiClient apiClient, String eventId, int incrementAmount) {
        GamesClientImpl d = Games.m473d(apiClient);
        if (d.isConnected()) {
            d.m3443l(eventId, incrementAmount);
        } else {
            apiClient.m147b(new C13533(this, eventId, incrementAmount));
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m146a(new C13522(this, forceReload));
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, boolean forceReload, String... eventIds) {
        return apiClient.m146a(new C13511(this, forceReload, eventIds));
    }
}
