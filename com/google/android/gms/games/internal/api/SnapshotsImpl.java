package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.CommitImpl.1 */
        class C10891 implements CommitSnapshotResult {
            final /* synthetic */ CommitImpl QQ;
            final /* synthetic */ Status yJ;

            C10891(CommitImpl commitImpl, Status status) {
                this.QQ = commitImpl;
                this.yJ = status;
            }

            public SnapshotMetadata getSnapshotMetadata() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private CommitImpl() {
        }

        public CommitSnapshotResult m4231Z(Status status) {
            return new C10891(this, status);
        }

        public /* synthetic */ Result m4232c(Status status) {
            return m4231Z(status);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.DeleteImpl.1 */
        class C10901 implements DeleteSnapshotResult {
            final /* synthetic */ DeleteImpl QR;
            final /* synthetic */ Status yJ;

            C10901(DeleteImpl deleteImpl, Status status) {
                this.QR = deleteImpl;
                this.yJ = status;
            }

            public String getSnapshotId() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private DeleteImpl() {
        }

        public DeleteSnapshotResult aa(Status status) {
            return new C10901(this, status);
        }

        public /* synthetic */ Result m4233c(Status status) {
            return aa(status);
        }
    }

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.LoadImpl.1 */
        class C10911 implements LoadSnapshotsResult {
            final /* synthetic */ LoadImpl QS;
            final /* synthetic */ Status yJ;

            C10911(LoadImpl loadImpl, Status status) {
                this.QS = loadImpl;
                this.yJ = status;
            }

            public SnapshotMetadataBuffer getSnapshots() {
                return new SnapshotMetadataBuffer(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadImpl() {
        }

        public LoadSnapshotsResult ab(Status status) {
            return new C10911(this, status);
        }

        public /* synthetic */ Result m4234c(Status status) {
            return ab(status);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.OpenImpl.1 */
        class C10921 implements OpenSnapshotResult {
            final /* synthetic */ OpenImpl QT;
            final /* synthetic */ Status yJ;

            C10921(OpenImpl openImpl, Status status) {
                this.QT = openImpl;
                this.yJ = status;
            }

            public String getConflictId() {
                return null;
            }

            public Snapshot getConflictingSnapshot() {
                return null;
            }

            public Contents getResolutionContents() {
                return null;
            }

            public Snapshot getSnapshot() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private OpenImpl() {
        }

        public OpenSnapshotResult ac(Status status) {
            return new C10921(this, status);
        }

        public /* synthetic */ Result m4235c(Status status) {
            return ac(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.1 */
    class C14021 extends LoadImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ SnapshotsImpl QI;

        C14021(SnapshotsImpl snapshotsImpl, boolean z) {
            this.QI = snapshotsImpl;
            this.Pe = z;
            super();
        }

        protected void m4594a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3424e((C0180d) this, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.2 */
    class C14032 extends OpenImpl {
        final /* synthetic */ SnapshotsImpl QI;
        final /* synthetic */ String QJ;
        final /* synthetic */ boolean QK;

        C14032(SnapshotsImpl snapshotsImpl, String str, boolean z) {
            this.QI = snapshotsImpl;
            this.QJ = str;
            this.QK = z;
            super();
        }

        protected void m4596a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3396b((C0180d) this, this.QJ, this.QK);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.3 */
    class C14043 extends CommitImpl {
        final /* synthetic */ SnapshotsImpl QI;
        final /* synthetic */ Snapshot QL;
        final /* synthetic */ SnapshotMetadataChange QM;

        C14043(SnapshotsImpl snapshotsImpl, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
            this.QI = snapshotsImpl;
            this.QL = snapshot;
            this.QM = snapshotMetadataChange;
            super();
        }

        protected void m4598a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3350a((C0180d) this, this.QL, this.QM);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.4 */
    class C14054 extends DeleteImpl {
        final /* synthetic */ SnapshotsImpl QI;
        final /* synthetic */ SnapshotMetadata QN;

        C14054(SnapshotsImpl snapshotsImpl, SnapshotMetadata snapshotMetadata) {
            this.QI = snapshotsImpl;
            this.QN = snapshotMetadata;
            super();
        }

        protected void m4600a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3439j(this, this.QN.getSnapshotId());
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.5 */
    class C14065 extends OpenImpl {
        final /* synthetic */ Contents IM;
        final /* synthetic */ SnapshotsImpl QI;
        final /* synthetic */ SnapshotMetadataChange QM;
        final /* synthetic */ String QO;
        final /* synthetic */ String QP;

        C14065(SnapshotsImpl snapshotsImpl, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, Contents contents) {
            this.QI = snapshotsImpl;
            this.QO = str;
            this.QP = str2;
            this.QM = snapshotMetadataChange;
            this.IM = contents;
            super();
        }

        protected void m4602a(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.m3364a((C0180d) this, this.QO, this.QP, this.QM, this.IM);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.6 */
    class C14076 extends LoadImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ String Ph;

        protected void m4604a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3408c((C0180d) this, this.Pg, this.Ph, this.Pe);
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient apiClient, Snapshot snapshot, SnapshotMetadataChange metadataChange) {
        return apiClient.m147b(new C14043(this, snapshot, metadataChange));
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return apiClient.m147b(new C14054(this, metadata));
    }

    public void discardAndClose(GoogleApiClient apiClient, Snapshot snapshot) {
        Games.m472c(apiClient).m3384a(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hu();
    }

    public int getMaxDataSize(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).ht();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient apiClient, String title, boolean allowAddButton, boolean allowDelete, int maxSnapshots) {
        return Games.m472c(apiClient).m3340a(title, allowAddButton, allowDelete, maxSnapshots);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle extras) {
        return (extras == null || !extras.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) extras.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m146a(new C14021(this, forceReload));
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return open(apiClient, metadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound) {
        return apiClient.m147b(new C14032(this, fileName, createIfNotFound));
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(apiClient, conflictId, metadata.getSnapshotId(), build, snapshot.getContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, Contents contents) {
        return apiClient.m147b(new C14065(this, conflictId, snapshotId, metadataChange, contents));
    }
}
