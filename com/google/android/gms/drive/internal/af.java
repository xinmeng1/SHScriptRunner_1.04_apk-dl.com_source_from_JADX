package com.google.android.gms.drive.internal;

import android.support.v4.media.TransportMediator;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.internal.ly;
import com.google.android.gms.internal.lz;
import com.google.android.gms.internal.ma;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.me;
import com.google.android.gms.location.DetectedActivity;
import java.io.IOException;

public final class af extends ma<af> {
    public String Jt;
    public long Ju;
    public long Jv;
    public int versionCode;

    public af() {
        gs();
    }

    public static af m3200g(byte[] bArr) throws md {
        return (af) me.m1425a(new af(), bArr);
    }

    public void m3201a(lz lzVar) throws IOException {
        lzVar.m1414p(1, this.versionCode);
        lzVar.m1408b(2, this.Jt);
        lzVar.m1410c(3, this.Ju);
        lzVar.m1410c(4, this.Jv);
        super.m2812a(lzVar);
    }

    public /* synthetic */ me m3202b(ly lyVar) throws IOException {
        return m3204m(lyVar);
    }

    protected int m3203c() {
        return (((super.m2814c() + lz.m1393r(1, this.versionCode)) + lz.m1391h(2, this.Jt)) + lz.m1389e(3, this.Ju)) + lz.m1389e(4, this.Jv);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof af)) {
            return false;
        }
        af afVar = (af) o;
        if (this.versionCode != afVar.versionCode) {
            return false;
        }
        if (this.Jt == null) {
            if (afVar.Jt != null) {
                return false;
            }
        } else if (!this.Jt.equals(afVar.Jt)) {
            return false;
        }
        if (this.Ju != afVar.Ju || this.Jv != afVar.Jv) {
            return false;
        }
        if (this.amX == null || this.amX.isEmpty()) {
            return afVar.amX == null || afVar.amX.isEmpty();
        } else {
            return this.amX.equals(afVar.amX);
        }
    }

    public af gs() {
        this.versionCode = 1;
        this.Jt = "";
        this.Ju = -1;
        this.Jv = -1;
        this.amX = null;
        this.anb = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.Jt == null ? 0 : this.Jt.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.Ju ^ (this.Ju >>> 32)))) * 31) + ((int) (this.Jv ^ (this.Jv >>> 32)))) * 31;
        if (!(this.amX == null || this.amX.isEmpty())) {
            i = this.amX.hashCode();
        }
        return hashCode + i;
    }

    public af m3204m(ly lyVar) throws IOException {
        while (true) {
            int nB = lyVar.nB();
            switch (nB) {
                case DetectedActivity.IN_VEHICLE /*0*/:
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    this.versionCode = lyVar.nE();
                    continue;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    this.Jt = lyVar.readString();
                    continue;
                case 24:
                    this.Ju = lyVar.nH();
                    continue;
                case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                    this.Jv = lyVar.nH();
                    continue;
                default:
                    if (!m2813a(lyVar, nB)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
