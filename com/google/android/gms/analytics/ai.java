package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0147k.C0146a;

class ai extends C0147k<aj> {

    /* renamed from: com.google.android.gms.analytics.ai.a */
    private static class C0607a implements C0146a<aj> {
        private final aj xw;

        public C0607a() {
            this.xw = new aj();
        }

        public void m1896a(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.xw.xz = i;
            } else {
                aa.m40D("int configuration name not recognized:  " + str);
            }
        }

        public void m1897c(String str, String str2) {
            this.xw.xD.put(str, str2);
        }

        public void m1898c(String str, boolean z) {
            int i = 1;
            aj ajVar;
            if ("ga_autoActivityTracking".equals(str)) {
                ajVar = this.xw;
                if (!z) {
                    i = 0;
                }
                ajVar.xA = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                ajVar = this.xw;
                if (!z) {
                    i = 0;
                }
                ajVar.xB = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                ajVar = this.xw;
                if (!z) {
                    i = 0;
                }
                ajVar.xC = i;
            } else {
                aa.m40D("bool configuration name not recognized:  " + str);
            }
        }

        public /* synthetic */ C0145j cB() {
            return dD();
        }

        public void m1899d(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.xw.xx = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.xw.xy = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    aa.m37A("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                aa.m40D("string configuration name not recognized:  " + str);
            }
        }

        public aj dD() {
            return this.xw;
        }
    }

    public ai(Context context) {
        super(context, new C0607a());
    }
}
