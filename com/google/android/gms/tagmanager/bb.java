package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C0508l.C0507a;

class bb<K, V> implements C0506k<K, V> {
    private LruCache<K, V> agc;

    /* renamed from: com.google.android.gms.tagmanager.bb.1 */
    class C04811 extends LruCache<K, V> {
        final /* synthetic */ C0507a agd;
        final /* synthetic */ bb age;

        C04811(bb bbVar, int i, C0507a c0507a) {
            this.age = bbVar;
            this.agd = c0507a;
            super(i);
        }

        protected int sizeOf(K key, V value) {
            return this.agd.sizeOf(key, value);
        }
    }

    bb(int i, C0507a<K, V> c0507a) {
        this.agc = new C04811(this, i, c0507a);
    }

    public void m2962e(K k, V v) {
        this.agc.put(k, v);
    }

    public V get(K key) {
        return this.agc.get(key);
    }
}
