package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.C0181a.C0179c;
import com.google.android.gms.common.api.C0181a.C0629a;
import com.google.android.gms.common.api.PendingResult.C0178a;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends C0629a<BatchResult> {
    private boolean DA;
    private boolean DB;
    private final PendingResult<?>[] DC;
    private int Dz;
    private final Object ls;

    public static final class Builder {
        private List<PendingResult<?>> DE;
        private Looper DF;

        public Builder(GoogleApiClient googleApiClient) {
            this.DE = new ArrayList();
            this.DF = googleApiClient.getLooper();
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.DE.size());
            this.DE.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.DF, null);
        }
    }

    /* renamed from: com.google.android.gms.common.api.Batch.1 */
    class C06281 implements C0178a {
        final /* synthetic */ Batch DD;

        C06281(Batch batch) {
            this.DD = batch;
        }

        public void m1977n(Status status) {
            synchronized (this.DD.ls) {
                if (this.DD.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.DD.DB = true;
                } else if (!status.isSuccess()) {
                    this.DD.DA = true;
                }
                this.DD.Dz = this.DD.Dz - 1;
                if (this.DD.Dz == 0) {
                    if (this.DD.DB) {
                        super.cancel();
                    } else {
                        this.DD.m1984b(new BatchResult(this.DD.DA ? new Status(13) : Status.En, this.DD.DC));
                    }
                }
            }
        }
    }

    private Batch(List<PendingResult<?>> pendingResultList, Looper looper) {
        super(new C0179c(looper));
        this.ls = new Object();
        this.Dz = pendingResultList.size();
        this.DC = new PendingResult[this.Dz];
        for (int i = 0; i < pendingResultList.size(); i++) {
            PendingResult pendingResult = (PendingResult) pendingResultList.get(i);
            this.DC[i] = pendingResult;
            pendingResult.m149a(new C06281(this));
        }
    }

    public /* synthetic */ Result m3186c(Status status) {
        return createFailedResult(status);
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.DC) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.DC);
    }
}
