package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ae.C0298a;
import com.google.android.gms.internal.ey.C0346a;
import org.json.JSONObject;

public class af implements ae {
    private final ex lN;

    /* renamed from: com.google.android.gms.internal.af.1 */
    class C06971 implements C0346a {
        final /* synthetic */ C0298a lO;
        final /* synthetic */ af lP;

        C06971(af afVar, C0298a c0298a) {
            this.lP = afVar;
            this.lO = c0298a;
        }

        public void m2444a(ex exVar) {
            this.lO.aE();
        }
    }

    public af(Context context, ev evVar) {
        this.lN = ex.m1023a(context, new al(), false, false, null, evVar);
    }

    public void m2445a(C0298a c0298a) {
        this.lN.cb().m1038a(new C06971(this, c0298a));
    }

    public void m2446a(String str, bc bcVar) {
        this.lN.cb().m1041a(str, bcVar);
    }

    public void m2447a(String str, JSONObject jSONObject) {
        this.lN.m1030a(str, jSONObject);
    }

    public void m2448d(String str) {
        this.lN.loadUrl(str);
    }

    public void m2449e(String str) {
        this.lN.cb().m1041a(str, null);
    }

    public void pause() {
        eo.m975a(this.lN);
    }

    public void resume() {
        eo.m981b(this.lN);
    }
}
