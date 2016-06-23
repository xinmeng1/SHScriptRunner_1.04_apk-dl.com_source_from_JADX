package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0280d;
import com.google.android.gms.dynamic.C0280d.C0688a;
import com.google.android.gms.wearable.DataEvent;

public interface hj extends IInterface {

    /* renamed from: com.google.android.gms.internal.hj.a */
    public static abstract class C0783a extends Binder implements hj {

        /* renamed from: com.google.android.gms.internal.hj.a.a */
        private static class C0782a implements hj {
            private IBinder kq;

            C0782a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public C0280d m2707a(C0280d c0280d, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0280d ag = C0688a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public static hj m2708M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hj)) ? new C0782a(iBinder) : (hj) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0280d a = m1219a(C0688a.ag(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0280d m1219a(C0280d c0280d, int i, int i2) throws RemoteException;
}
