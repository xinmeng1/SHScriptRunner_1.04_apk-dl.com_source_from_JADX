package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.C0630b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.gc.C0767a;
import com.google.android.gms.internal.hb.C1119e;

public final class ga extends hb<gc> {
    private final String yQ;

    /* renamed from: com.google.android.gms.internal.ga.b */
    private static final class C1113b implements StateDeletedResult {
        private final int yS;
        private final Status yz;

        public C1113b(Status status, int i) {
            this.yz = status;
            this.yS = i;
        }

        public int getStateKey() {
            return this.yS;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.internal.ga.d */
    private static final class C1114d extends C0630b implements StateListResult {
        private final AppStateBuffer yT;

        public C1114d(DataHolder dataHolder) {
            super(dataHolder);
            this.yT = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.yT;
        }
    }

    /* renamed from: com.google.android.gms.internal.ga.f */
    private static final class C1115f extends C0630b implements StateConflictResult, StateLoadedResult, StateResult {
        private final int yS;
        private final AppStateBuffer yT;

        public C1115f(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.yS = i;
            this.yT = new AppStateBuffer(dataHolder);
        }

        private boolean dW() {
            return this.yz.getStatusCode() == GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS;
        }

        public StateConflictResult getConflictResult() {
            return dW() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return dW() ? null : this;
        }

        public byte[] getLocalData() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.yS;
        }

        public void release() {
            this.yT.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.ga.a */
    private static final class C1206a extends fz {
        private final C0180d<StateDeletedResult> yR;

        public C1206a(C0180d<StateDeletedResult> c0180d) {
            this.yR = (C0180d) hm.m1228b((Object) c0180d, (Object) "Result holder must not be null");
        }

        public void m4061b(int i, int i2) {
            this.yR.m154a(new C1113b(new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.ga.c */
    private static final class C1207c extends fz {
        private final C0180d<StateListResult> yR;

        public C1207c(C0180d<StateListResult> c0180d) {
            this.yR = (C0180d) hm.m1228b((Object) c0180d, (Object) "Result holder must not be null");
        }

        public void m4062a(DataHolder dataHolder) {
            this.yR.m154a(new C1114d(dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ga.e */
    private static final class C1208e extends fz {
        private final C0180d<StateResult> yR;

        public C1208e(C0180d<StateResult> c0180d) {
            this.yR = (C0180d) hm.m1228b((Object) c0180d, (Object) "Result holder must not be null");
        }

        public void m4063a(int i, DataHolder dataHolder) {
            this.yR.m154a(new C1115f(i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ga.g */
    private static final class C1209g extends fz {
        private final C0180d<Status> yR;

        public C1209g(C0180d<Status> c0180d) {
            this.yR = (C0180d) hm.m1228b((Object) c0180d, (Object) "Holder must not be null");
        }

        public void dT() {
            this.yR.m154a(new Status(0));
        }
    }

    public ga(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.yQ = (String) hm.m1232f(str);
    }

    protected gc m3601D(IBinder iBinder) {
        return C0767a.m2609F(iBinder);
    }

    public void m3602a(C0180d<StateListResult> c0180d) {
        try {
            ((gc) ft()).m1097a(new C1207c(c0180d));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m3603a(C0180d<StateDeletedResult> c0180d, int i) {
        try {
            ((gc) ft()).m1102b(new C1206a(c0180d), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m3604a(C0180d<StateResult> c0180d, int i, String str, byte[] bArr) {
        try {
            ((gc) ft()).m1099a(new C1208e(c0180d), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m3605a(C0180d<StateResult> c0180d, int i, byte[] bArr) {
        if (c0180d == null) {
            gb gbVar = null;
        } else {
            Object c1208e = new C1208e(c0180d);
        }
        try {
            ((gc) ft()).m1100a(gbVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m3606a(hi hiVar, C1119e c1119e) throws RemoteException {
        hiVar.m1190a((hh) c1119e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.yQ, fs());
    }

    public void m3607b(C0180d<Status> c0180d) {
        try {
            ((gc) ft()).m1101b(new C1209g(c0180d));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m3608b(C0180d<StateResult> c0180d, int i) {
        try {
            ((gc) ft()).m1098a(new C1208e(c0180d), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m3609b(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        hm.m1226a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    protected String bu() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public int dU() {
        try {
            return ((gc) ft()).dU();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int dV() {
        try {
            return ((gc) ft()).dV();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected /* synthetic */ IInterface m3610x(IBinder iBinder) {
        return m3601D(iBinder);
    }
}
