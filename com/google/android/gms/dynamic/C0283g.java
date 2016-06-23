package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hm;

/* renamed from: com.google.android.gms.dynamic.g */
public abstract class C0283g<T> {
    private final String Ml;
    private T Mm;

    /* renamed from: com.google.android.gms.dynamic.g.a */
    public static class C0282a extends Exception {
        public C0282a(String str) {
            super(str);
        }

        public C0282a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0283g(String str) {
        this.Ml = str;
    }

    protected final T m469G(Context context) throws C0282a {
        if (this.Mm == null) {
            hm.m1232f(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0282a("Could not get remote context.");
            }
            try {
                this.Mm = m470d((IBinder) remoteContext.getClassLoader().loadClass(this.Ml).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0282a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0282a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0282a("Could not access creator.");
            }
        }
        return this.Mm;
    }

    protected abstract T m470d(IBinder iBinder);
}
