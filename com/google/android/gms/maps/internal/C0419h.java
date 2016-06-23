package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0280d;
import com.google.android.gms.dynamic.C0280d.C0688a;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.h */
public interface C0419h extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.h.a */
    public static abstract class C0879a extends Binder implements C0419h {

        /* renamed from: com.google.android.gms.maps.internal.h.a.a */
        private static class C0878a implements C0419h {
            private IBinder kq;

            C0878a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m2857k(C0280d c0280d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0419h aG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0419h)) ? new C0878a(iBinder) : (C0419h) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    m1497k(C0688a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1497k(C0280d c0280d) throws RemoteException;
}
