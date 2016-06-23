package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.C1121i.C0382a;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.j */
public class C1217j extends C1121i {

    /* renamed from: com.google.android.gms.internal.j.a */
    class C0384a {
        private String kd;
        private boolean ke;
        final /* synthetic */ C1217j kf;

        public C0384a(C1217j c1217j, String str, boolean z) {
            this.kf = c1217j;
            this.kd = str;
            this.ke = z;
        }

        public String getId() {
            return this.kd;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.ke;
        }
    }

    protected C1217j(Context context, C0393m c0393m, C0394n c0394n) {
        super(context, c0393m, c0394n);
    }

    public static C1217j m4072a(String str, Context context) {
        C0393m c0742e = new C0742e();
        C1121i.m3662a(str, context, c0742e);
        return new C1217j(context, c0742e, new C0820p(239));
    }

    protected void m4073c(Context context) {
        super.m3672c(context);
        try {
            C0384a i = m4075i(context);
            m2641a(28, i.isLimitAdTrackingEnabled() ? 1 : 0);
            String id = i.getId();
            if (id != null) {
                m2641a(26, 5);
                m2642a(24, id);
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            try {
                m2642a(24, C1121i.m3665f(context));
            } catch (IOException e2) {
            } catch (C0382a e3) {
            }
        }
    }

    protected void m4074d(Context context) {
        long j = 1;
        super.m3672c(context);
        try {
            m2642a(24, C1121i.m3665f(context));
        } catch (C0382a e) {
        }
        try {
            C0384a i = m4075i(context);
            try {
                if (!i.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                m2641a(28, j);
                String id = i.getId();
                if (id != null) {
                    m2642a(30, id);
                }
            } catch (IOException e2) {
            }
        } catch (GooglePlayServicesNotAvailableException e3) {
        } catch (IOException e4) {
            m2641a(28, 1);
        }
    }

    C0384a m4075i(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.jQ.m1419a(bArr, true);
            }
            return new C0384a(this, str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
