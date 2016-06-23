package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.e */
class C0742e implements C0393m {
    C0742e() {
    }

    public String m2560a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    public byte[] m2561a(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }
}
