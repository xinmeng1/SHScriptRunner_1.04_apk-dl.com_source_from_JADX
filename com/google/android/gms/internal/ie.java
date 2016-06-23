package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.hy.C0785a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ie extends hy implements SafeParcelable {
    public static final C0383if CREATOR;
    private final ib Hj;
    private final Parcel Hq;
    private final int Hr;
    private int Hs;
    private int Ht;
    private final String mClassName;
    private final int xM;

    static {
        CREATOR = new C0383if();
    }

    ie(int i, Parcel parcel, ib ibVar) {
        this.xM = i;
        this.Hq = (Parcel) hm.m1232f(parcel);
        this.Hr = 2;
        this.Hj = ibVar;
        if (this.Hj == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.Hj.fW();
        }
        this.Hs = 2;
    }

    private ie(SafeParcelable safeParcelable, ib ibVar, String str) {
        this.xM = 1;
        this.Hq = Parcel.obtain();
        safeParcelable.writeToParcel(this.Hq, 0);
        this.Hr = 1;
        this.Hj = (ib) hm.m1232f(ibVar);
        this.mClassName = (String) hm.m1232f(str);
        this.Hs = 2;
    }

    public static <T extends hy & SafeParcelable> ie m2733a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new ie((SafeParcelable) t, m2739b((hy) t), canonicalName);
    }

    private static void m2734a(ib ibVar, hy hyVar) {
        Class cls = hyVar.getClass();
        if (!ibVar.m2732b(cls)) {
            HashMap fG = hyVar.fG();
            ibVar.m2731a(cls, hyVar.fG());
            for (String str : fG.keySet()) {
                C0785a c0785a = (C0785a) fG.get(str);
                Class fO = c0785a.fO();
                if (fO != null) {
                    try {
                        m2734a(ibVar, (hy) fO.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c0785a.fO().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c0785a.fO().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void m2735a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
            case DetectedActivity.TILTING /*5*/:
            case Quest.STATE_FAILED /*6*/:
                stringBuilder.append(obj);
            case DetectedActivity.WALKING /*7*/:
                stringBuilder.append("\"").append(in.aK(obj.toString())).append("\"");
            case DetectedActivity.RUNNING /*8*/:
                stringBuilder.append("\"").append(ih.m1271d((byte[]) obj)).append("\"");
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                stringBuilder.append("\"").append(ih.m1272e((byte[]) obj));
                stringBuilder.append("\"");
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                io.m1277a(stringBuilder, (HashMap) obj);
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m2736a(StringBuilder stringBuilder, C0785a<?, ?> c0785a, Parcel parcel, int i) {
        switch (c0785a.fF()) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, Integer.valueOf(C0199a.m212g(parcel, i))));
            case DataEvent.TYPE_CHANGED /*1*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, C0199a.m216k(parcel, i)));
            case DataEvent.TYPE_DELETED /*2*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, Long.valueOf(C0199a.m214i(parcel, i))));
            case DetectedActivity.STILL /*3*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, Float.valueOf(C0199a.m217l(parcel, i))));
            case DetectedActivity.UNKNOWN /*4*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, Double.valueOf(C0199a.m218m(parcel, i))));
            case DetectedActivity.TILTING /*5*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, C0199a.m219n(parcel, i)));
            case Quest.STATE_FAILED /*6*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, Boolean.valueOf(C0199a.m208c(parcel, i))));
            case DetectedActivity.WALKING /*7*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, C0199a.m220o(parcel, i)));
            case DetectedActivity.RUNNING /*8*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, C0199a.m223r(parcel, i)));
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                m2742b(stringBuilder, (C0785a) c0785a, m1251a(c0785a, m2744d(C0199a.m222q(parcel, i))));
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c0785a.fF());
        }
    }

    private void m2737a(StringBuilder stringBuilder, String str, C0785a<?, ?> c0785a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c0785a.fQ()) {
            m2736a(stringBuilder, c0785a, parcel, i);
        } else {
            m2741b(stringBuilder, c0785a, parcel, i);
        }
    }

    private void m2738a(StringBuilder stringBuilder, HashMap<String, C0785a<?, ?>> hashMap, Parcel parcel) {
        HashMap b = m2740b((HashMap) hashMap);
        stringBuilder.append('{');
        int B = C0199a.m196B(parcel);
        Object obj = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            Entry entry = (Entry) b.get(Integer.valueOf(C0199a.ar(A)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m2737a(stringBuilder, (String) entry.getKey(), (C0785a) entry.getValue(), parcel, A);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != B) {
            throw new C0198a("Overread allowed size end=" + B, parcel);
        }
        stringBuilder.append('}');
    }

    private static ib m2739b(hy hyVar) {
        ib ibVar = new ib(hyVar.getClass());
        m2734a(ibVar, hyVar);
        ibVar.fU();
        ibVar.fT();
        return ibVar;
    }

    private static HashMap<Integer, Entry<String, C0785a<?, ?>>> m2740b(HashMap<String, C0785a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C0785a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0785a) entry.getValue()).fN()), entry);
        }
        return hashMap2;
    }

    private void m2741b(StringBuilder stringBuilder, C0785a<?, ?> c0785a, Parcel parcel, int i) {
        if (c0785a.fL()) {
            stringBuilder.append("[");
            switch (c0785a.fF()) {
                case DetectedActivity.IN_VEHICLE /*0*/:
                    ig.m1266a(stringBuilder, C0199a.m226u(parcel, i));
                    break;
                case DataEvent.TYPE_CHANGED /*1*/:
                    ig.m1268a(stringBuilder, C0199a.m228w(parcel, i));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    ig.m1267a(stringBuilder, C0199a.m227v(parcel, i));
                    break;
                case DetectedActivity.STILL /*3*/:
                    ig.m1265a(stringBuilder, C0199a.m229x(parcel, i));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    ig.m1264a(stringBuilder, C0199a.m230y(parcel, i));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    ig.m1268a(stringBuilder, C0199a.m231z(parcel, i));
                    break;
                case Quest.STATE_FAILED /*6*/:
                    ig.m1270a(stringBuilder, C0199a.m225t(parcel, i));
                    break;
                case DetectedActivity.WALKING /*7*/:
                    ig.m1269a(stringBuilder, C0199a.m195A(parcel, i));
                    break;
                case DetectedActivity.RUNNING /*8*/:
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    Parcel[] D = C0199a.m199D(parcel, i);
                    int length = D.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        D[i2].setDataPosition(0);
                        m2738a(stringBuilder, c0785a.fS(), D[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c0785a.fF()) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                stringBuilder.append(C0199a.m212g(parcel, i));
            case DataEvent.TYPE_CHANGED /*1*/:
                stringBuilder.append(C0199a.m216k(parcel, i));
            case DataEvent.TYPE_DELETED /*2*/:
                stringBuilder.append(C0199a.m214i(parcel, i));
            case DetectedActivity.STILL /*3*/:
                stringBuilder.append(C0199a.m217l(parcel, i));
            case DetectedActivity.UNKNOWN /*4*/:
                stringBuilder.append(C0199a.m218m(parcel, i));
            case DetectedActivity.TILTING /*5*/:
                stringBuilder.append(C0199a.m219n(parcel, i));
            case Quest.STATE_FAILED /*6*/:
                stringBuilder.append(C0199a.m208c(parcel, i));
            case DetectedActivity.WALKING /*7*/:
                stringBuilder.append("\"").append(in.aK(C0199a.m220o(parcel, i))).append("\"");
            case DetectedActivity.RUNNING /*8*/:
                stringBuilder.append("\"").append(ih.m1271d(C0199a.m223r(parcel, i))).append("\"");
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                stringBuilder.append("\"").append(ih.m1272e(C0199a.m223r(parcel, i)));
                stringBuilder.append("\"");
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                Bundle q = C0199a.m222q(parcel, i);
                Set<String> keySet = q.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(in.aK(q.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                Parcel C = C0199a.m198C(parcel, i);
                C.setDataPosition(0);
                m2738a(stringBuilder, c0785a.fS(), C);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void m2742b(StringBuilder stringBuilder, C0785a<?, ?> c0785a, Object obj) {
        if (c0785a.fK()) {
            m2743b(stringBuilder, (C0785a) c0785a, (ArrayList) obj);
        } else {
            m2735a(stringBuilder, c0785a.fE(), obj);
        }
    }

    private void m2743b(StringBuilder stringBuilder, C0785a<?, ?> c0785a, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m2735a(stringBuilder, c0785a.fE(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> m2744d(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    protected Object aF(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean aG(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        C0383if c0383if = CREATOR;
        return 0;
    }

    public HashMap<String, C0785a<?, ?>> fG() {
        return this.Hj == null ? null : this.Hj.aJ(this.mClassName);
    }

    public Parcel fY() {
        switch (this.Hs) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                this.Ht = C0200b.m232C(this.Hq);
                C0200b.m235G(this.Hq, this.Ht);
                this.Hs = 2;
                break;
            case DataEvent.TYPE_CHANGED /*1*/:
                C0200b.m235G(this.Hq, this.Ht);
                this.Hs = 2;
                break;
        }
        return this.Hq;
    }

    ib fZ() {
        switch (this.Hr) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return null;
            case DataEvent.TYPE_CHANGED /*1*/:
                return this.Hj;
            case DataEvent.TYPE_DELETED /*2*/:
                return this.Hj;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Hr);
        }
    }

    public int getVersionCode() {
        return this.xM;
    }

    public String toString() {
        hm.m1228b(this.Hj, (Object) "Cannot convert to JSON on client side.");
        Parcel fY = fY();
        fY.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m2738a(stringBuilder, this.Hj.aJ(this.mClassName), fY);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0383if c0383if = CREATOR;
        C0383if.m1262a(this, out, flags);
    }
}
