package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0280d;
import com.google.android.gms.dynamic.C0280d.C0688a;
import com.google.android.gms.internal.bt.C0715a;
import com.google.android.gms.wearable.DataEvent;

public interface ar extends IInterface {

    /* renamed from: com.google.android.gms.internal.ar.a */
    public static abstract class C0703a extends Binder implements ar {

        /* renamed from: com.google.android.gms.internal.ar.a.a */
        private static class C0702a implements ar {
            private IBinder kq;

            C0702a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder m2467a(C0280d c0280d, al alVar, String str, bt btVar, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    if (alVar != null) {
                        obtain.writeInt(1);
                        alVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (btVar != null) {
                        iBinder = btVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public static ar m2468g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ar)) ? new C0702a(iBinder) : (ar) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = m797a(C0688a.ag(data.readStrongBinder()), data.readInt() != 0 ? al.CREATOR.m785c(data) : null, data.readString(), C0715a.m2499i(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IBinder m797a(C0280d c0280d, al alVar, String str, bt btVar, int i) throws RemoteException;
}
