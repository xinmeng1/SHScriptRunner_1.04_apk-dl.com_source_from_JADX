package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C0648p;
import com.google.android.gms.drive.internal.C0649t;
import com.google.android.gms.drive.internal.C0651w;
import com.google.android.gms.drive.internal.C1042r;
import com.google.android.gms.internal.gy;
import java.util.List;

public final class Drive {
    public static final Api<NoOptions> API;
    public static final DriveApi DriveApi;
    public static final Scope HH;
    public static final Scope HI;
    public static final Api<C1189b> HJ;
    public static final C0203b HK;
    public static final C0205d HL;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;
    public static final C0177c<C1042r> yH;

    /* renamed from: com.google.android.gms.drive.Drive.a */
    public static abstract class C0641a<O extends ApiOptions> implements C0176b<C1042r, O> {
        protected abstract Bundle m2027a(O o);

        public C1042r m2029a(Context context, Looper looper, gy gyVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List fl = gyVar.fl();
            return new C1042r(context, looper, gyVar, connectionCallbacks, onConnectionFailedListener, (String[]) fl.toArray(new String[fl.size()]), m2027a(o));
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.1 */
    static class C10341 extends C0641a<NoOptions> {
        C10341() {
        }

        protected Bundle m3194a(NoOptions noOptions) {
            return new Bundle();
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.2 */
    static class C10352 extends C0641a<C1189b> {
        C10352() {
        }

        protected Bundle m3197a(C1189b c1189b) {
            return c1189b == null ? new Bundle() : c1189b.gj();
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.b */
    public static class C1189b implements Optional {
        private final Bundle HM;

        private C1189b() {
            this(new Bundle());
        }

        private C1189b(Bundle bundle) {
            this.HM = bundle;
        }

        public Bundle gj() {
            return this.HM;
        }
    }

    static {
        yH = new C0177c();
        SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
        SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
        HH = new Scope("https://www.googleapis.com/auth/drive");
        HI = new Scope("https://www.googleapis.com/auth/drive.apps");
        API = new Api(new C10341(), yH, new Scope[0]);
        HJ = new Api(new C10352(), yH, new Scope[0]);
        DriveApi = new C0648p();
        HK = new C0649t();
        HL = new C0651w();
    }

    private Drive() {
    }
}
