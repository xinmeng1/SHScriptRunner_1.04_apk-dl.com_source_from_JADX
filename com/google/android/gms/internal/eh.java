package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class eh {
    private static final eh rP;
    public static final String rQ;
    private final Object ls;
    public final String rR;
    private final ei rS;
    private BigInteger rT;
    private final HashSet<eg> rU;
    private final HashMap<String, ek> rV;
    private boolean rW;

    static {
        rP = new eh();
        rQ = rP.rR;
    }

    private eh() {
        this.ls = new Object();
        this.rT = BigInteger.ONE;
        this.rU = new HashSet();
        this.rV = new HashMap();
        this.rW = false;
        this.rR = eo.bT();
        this.rS = new ei(this.rR);
    }

    public static Bundle m955a(Context context, ej ejVar, String str) {
        return rP.m959b(context, ejVar, str);
    }

    public static void m956b(HashSet<eg> hashSet) {
        rP.m960c(hashSet);
    }

    public static eh bH() {
        return rP;
    }

    public static String bI() {
        return rP.bJ();
    }

    public static ei bK() {
        return rP.bL();
    }

    public static boolean bM() {
        return rP.bN();
    }

    public void m957a(eg egVar) {
        synchronized (this.ls) {
            this.rU.add(egVar);
        }
    }

    public void m958a(String str, ek ekVar) {
        synchronized (this.ls) {
            this.rV.put(str, ekVar);
        }
    }

    public Bundle m959b(Context context, ej ejVar, String str) {
        Bundle bundle;
        synchronized (this.ls) {
            bundle = new Bundle();
            bundle.putBundle("app", this.rS.m962b(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.rV.keySet()) {
                bundle2.putBundle(str2, ((ek) this.rV.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.rU.iterator();
            while (it.hasNext()) {
                arrayList.add(((eg) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            ejVar.m964a(this.rU);
            this.rU.clear();
        }
        return bundle;
    }

    public String bJ() {
        String bigInteger;
        synchronized (this.ls) {
            bigInteger = this.rT.toString();
            this.rT = this.rT.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public ei bL() {
        ei eiVar;
        synchronized (this.ls) {
            eiVar = this.rS;
        }
        return eiVar;
    }

    public boolean bN() {
        boolean z;
        synchronized (this.ls) {
            z = this.rW;
            this.rW = true;
        }
        return z;
    }

    public void m960c(HashSet<eg> hashSet) {
        synchronized (this.ls) {
            this.rU.addAll(hashSet);
        }
    }
}
