package com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.i */
public class C0464i {
    private String[] abV;
    private String abW;
    private String abX;
    private String abY;
    private PlusCommonExtras aca;
    private final ArrayList<String> acb;
    private String[] acc;
    private String yQ;

    public C0464i(Context context) {
        this.acb = new ArrayList();
        this.abX = context.getPackageName();
        this.abW = context.getPackageName();
        this.aca = new PlusCommonExtras();
        this.acb.add(Scopes.PLUS_LOGIN);
    }

    public C0464i bz(String str) {
        this.yQ = str;
        return this;
    }

    public C0464i m1582e(String... strArr) {
        this.acb.clear();
        this.acb.addAll(Arrays.asList(strArr));
        return this;
    }

    public C0464i m1583f(String... strArr) {
        this.acc = strArr;
        return this;
    }

    public C0464i ki() {
        this.acb.clear();
        return this;
    }

    public C0943h kj() {
        if (this.yQ == null) {
            this.yQ = "<<default account>>";
        }
        return new C0943h(this.yQ, (String[]) this.acb.toArray(new String[this.acb.size()]), this.acc, this.abV, this.abW, this.abX, this.abY, this.aca);
    }
}
