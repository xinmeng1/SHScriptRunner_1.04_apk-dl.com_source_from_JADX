package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C0373b;
import com.google.android.gms.internal.hb.C0773c;
import com.google.android.gms.internal.hb.C0774d;
import com.google.android.gms.internal.hb.C1119e;
import com.google.android.gms.internal.hb.C1120g;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.ie;
import com.google.android.gms.internal.kp;
import com.google.android.gms.internal.ks;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0460d.C0940a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C1165e extends hb<C0460d> {
    private Person abJ;
    private final C0943h abK;

    /* renamed from: com.google.android.gms.plus.internal.e.d */
    final class C0941d extends C0373b<C0180d<Status>> {
        final /* synthetic */ C1165e abM;
        private final Status yz;

        public C0941d(C1165e c1165e, C0180d<Status> c0180d, Status status) {
            this.abM = c1165e;
            super(c1165e, c0180d);
            this.yz = status;
        }

        protected /* synthetic */ void m2928d(Object obj) {
            m2929n((C0180d) obj);
        }

        protected void fu() {
        }

        protected void m2929n(C0180d<Status> c0180d) {
            if (c0180d != null) {
                c0180d.m154a(this.yz);
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.h */
    final class C0942h extends C0373b<C0180d<Status>> {
        final /* synthetic */ C1165e abM;
        private final Status yz;

        public C0942h(C1165e c1165e, C0180d<Status> c0180d, Status status) {
            this.abM = c1165e;
            super(c1165e, c0180d);
            this.yz = status;
        }

        protected /* synthetic */ void m2930d(Object obj) {
            m2931n((C0180d) obj);
        }

        protected void fu() {
        }

        protected void m2931n(C0180d<Status> c0180d) {
            this.abM.disconnect();
            if (c0180d != null) {
                c0180d.m154a(this.yz);
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.c */
    final class C1163c extends C0774d<C0180d<LoadMomentsResult>> implements LoadMomentsResult {
        private final String HS;
        final /* synthetic */ C1165e abM;
        private final String abN;
        private MomentBuffer abO;
        private final Status yz;

        public C1163c(C1165e c1165e, C0180d<LoadMomentsResult> c0180d, Status status, DataHolder dataHolder, String str, String str2) {
            this.abM = c1165e;
            super(c1165e, c0180d, dataHolder);
            this.yz = status;
            this.HS = str;
            this.abN = str2;
        }

        protected void m3795a(C0180d<LoadMomentsResult> c0180d, DataHolder dataHolder) {
            this.abO = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            c0180d.m154a(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.abO;
        }

        public String getNextPageToken() {
            return this.HS;
        }

        public Status getStatus() {
            return this.yz;
        }

        public String getUpdated() {
            return this.abN;
        }

        public void release() {
            if (this.abO != null) {
                this.abO.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.f */
    final class C1164f extends C0774d<C0180d<LoadPeopleResult>> implements LoadPeopleResult {
        private final String HS;
        final /* synthetic */ C1165e abM;
        private PersonBuffer abP;
        private final Status yz;

        public C1164f(C1165e c1165e, C0180d<LoadPeopleResult> c0180d, Status status, DataHolder dataHolder, String str) {
            this.abM = c1165e;
            super(c1165e, c0180d, dataHolder);
            this.yz = status;
            this.HS = str;
        }

        protected void m3797a(C0180d<LoadPeopleResult> c0180d, DataHolder dataHolder) {
            this.abP = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            c0180d.m154a(this);
        }

        public String getNextPageToken() {
            return this.HS;
        }

        public PersonBuffer getPersonBuffer() {
            return this.abP;
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            if (this.abP != null) {
                this.abP.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.a */
    final class C1223a extends C1162a {
        private final C0180d<Status> abL;
        final /* synthetic */ C1165e abM;

        public C1223a(C1165e c1165e, C0180d<Status> c0180d) {
            this.abM = c1165e;
            this.abL = c0180d;
        }

        public void am(Status status) {
            this.abM.m2664a(new C0941d(this.abM, this.abL, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.b */
    final class C1224b extends C1162a {
        private final C0180d<LoadMomentsResult> abL;
        final /* synthetic */ C1165e abM;

        public C1224b(C1165e c1165e, C0180d<LoadMomentsResult> c0180d) {
            this.abM = c1165e;
            this.abL = c0180d;
        }

        public void m4083a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.eU() != null ? (PendingIntent) dataHolder.eU().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.abM.m2664a(new C1163c(this.abM, this.abL, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.e */
    final class C1225e extends C1162a {
        private final C0180d<LoadPeopleResult> abL;
        final /* synthetic */ C1165e abM;

        public C1225e(C1165e c1165e, C0180d<LoadPeopleResult> c0180d) {
            this.abM = c1165e;
            this.abL = c0180d;
        }

        public void m4084a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.eU() != null ? (PendingIntent) dataHolder.eU().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.abM.m2664a(new C1164f(this.abM, this.abL, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.g */
    final class C1226g extends C1162a {
        private final C0180d<Status> abL;
        final /* synthetic */ C1165e abM;

        public C1226g(C1165e c1165e, C0180d<Status> c0180d) {
            this.abM = c1165e;
            this.abL = c0180d;
        }

        public void m4085h(int i, Bundle bundle) {
            this.abM.m2664a(new C0942h(this.abM, this.abL, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    public C1165e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C0943h c0943h) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, c0943h.jZ());
        this.abK = c0943h;
    }

    @Deprecated
    public C1165e(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, C0943h c0943h) {
        this(context, context.getMainLooper(), new C0773c(connectionCallbacks), new C1120g(onConnectionFailedListener), c0943h);
    }

    public hg m3799a(C0180d<LoadPeopleResult> c0180d, int i, String str) {
        cn();
        Object c1225e = new C1225e(this, c0180d);
        try {
            return ((C0460d) ft()).m1564a(c1225e, 1, i, -1, str);
        } catch (RemoteException e) {
            c1225e.m4084a(DataHolder.af(8), null);
            return null;
        }
    }

    protected void m3800a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.abJ = ks.m3717i(bundle.getByteArray("loaded_person"));
        }
        super.m2663a(i, iBinder, bundle);
    }

    public void m3801a(C0180d<LoadMomentsResult> c0180d, int i, String str, Uri uri, String str2, String str3) {
        cn();
        Object c1224b = c0180d != null ? new C1224b(this, c0180d) : null;
        try {
            ((C0460d) ft()).m1567a(c1224b, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            c1224b.m4083a(DataHolder.af(8), null, null);
        }
    }

    public void m3802a(C0180d<Status> c0180d, Moment moment) {
        cn();
        C0458b c1223a = c0180d != null ? new C1223a(this, c0180d) : null;
        try {
            ((C0460d) ft()).m1569a(c1223a, ie.m2733a((kp) moment));
        } catch (Throwable e) {
            if (c1223a == null) {
                throw new IllegalStateException(e);
            }
            c1223a.am(new Status(8, null, null));
        }
    }

    public void m3803a(C0180d<LoadPeopleResult> c0180d, Collection<String> collection) {
        cn();
        C0458b c1225e = new C1225e(this, c0180d);
        try {
            ((C0460d) ft()).m1572a(c1225e, new ArrayList(collection));
        } catch (RemoteException e) {
            c1225e.m4084a(DataHolder.af(8), null);
        }
    }

    protected void m3804a(hi hiVar, C1119e c1119e) throws RemoteException {
        Bundle kh = this.abK.kh();
        kh.putStringArray(GoogleAuthUtil.KEY_REQUEST_VISIBLE_ACTIVITIES, this.abK.ka());
        hiVar.m1192a(c1119e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.abK.kd(), this.abK.kc(), fs(), this.abK.getAccountName(), kh);
    }

    protected C0460d bn(IBinder iBinder) {
        return C0940a.bm(iBinder);
    }

    protected String bu() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public boolean by(String str) {
        return Arrays.asList(fs()).contains(str);
    }

    public void clearDefaultAccount() {
        cn();
        try {
            this.abJ = null;
            ((C0460d) ft()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m3805d(C0180d<LoadPeopleResult> c0180d, String[] strArr) {
        m3803a((C0180d) c0180d, Arrays.asList(strArr));
    }

    public String getAccountName() {
        cn();
        try {
            return ((C0460d) ft()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        cn();
        return this.abJ;
    }

    public void m3806k(C0180d<LoadMomentsResult> c0180d) {
        m3801a(c0180d, 20, null, null, null, "me");
    }

    public void m3807l(C0180d<LoadPeopleResult> c0180d) {
        cn();
        Object c1225e = new C1225e(this, c0180d);
        try {
            ((C0460d) ft()).m1564a(c1225e, 2, 1, -1, null);
        } catch (RemoteException e) {
            c1225e.m4084a(DataHolder.af(8), null);
        }
    }

    public void m3808m(C0180d<Status> c0180d) {
        cn();
        clearDefaultAccount();
        Object c1226g = new C1226g(this, c0180d);
        try {
            ((C0460d) ft()).m1574b(c1226g);
        } catch (RemoteException e) {
            c1226g.m4085h(8, null);
        }
    }

    public hg m3809r(C0180d<LoadPeopleResult> c0180d, String str) {
        return m3799a((C0180d) c0180d, 0, str);
    }

    public void removeMoment(String momentId) {
        cn();
        try {
            ((C0460d) ft()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected /* synthetic */ IInterface m3810x(IBinder iBinder) {
        return bn(iBinder);
    }
}
