package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0147k.C0146a;

/* renamed from: com.google.android.gms.analytics.v */
class C0618v extends C0147k<C0619w> {

    /* renamed from: com.google.android.gms.analytics.v.a */
    private static class C0617a implements C0146a<C0619w> {
        private final C0619w wi;

        public C0617a() {
            this.wi = new C0619w();
        }

        public void m1958a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.wi.wk = i;
            } else {
                aa.m40D("int configuration name not recognized:  " + str);
            }
        }

        public void m1959c(String str, String str2) {
        }

        public void m1960c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.wi.wl = z ? 1 : 0;
                return;
            }
            aa.m40D("bool configuration name not recognized:  " + str);
        }

        public /* synthetic */ C0145j cB() {
            return cX();
        }

        public C0619w cX() {
            return this.wi;
        }

        public void m1961d(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.wi.tC = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.wi.tD = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.wi.wj = str2;
            } else {
                aa.m40D("string configuration name not recognized:  " + str);
            }
        }
    }

    public C0618v(Context context) {
        super(context, new C0617a());
    }
}
