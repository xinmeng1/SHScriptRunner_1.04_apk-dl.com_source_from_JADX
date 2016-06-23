package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.l */
class C0508l<K, V> {
    final C0507a<K, V> aer;

    /* renamed from: com.google.android.gms.tagmanager.l.a */
    public interface C0507a<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: com.google.android.gms.tagmanager.l.1 */
    class C09691 implements C0507a<K, V> {
        final /* synthetic */ C0508l aes;

        C09691(C0508l c0508l) {
            this.aes = c0508l;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public C0508l() {
        this.aer = new C09691(this);
    }

    public C0506k<K, V> m1743a(int i, C0507a<K, V> c0507a) {
        if (i > 0) {
            return lj() < 12 ? new cz(i, c0507a) : new bb(i, c0507a);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int lj() {
        return VERSION.SDK_INT;
    }
}
