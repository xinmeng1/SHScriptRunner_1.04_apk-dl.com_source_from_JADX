package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.DataEvent;

public interface dw extends IInterface {

    /* renamed from: com.google.android.gms.internal.dw.a */
    public static abstract class C0738a extends Binder implements dw {

        /* renamed from: com.google.android.gms.internal.dw.a.a */
        private static class C0737a implements dw {
            private IBinder kq;

            C0737a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public du m2555b(ds dsVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (dsVar != null) {
                        obtain.writeInt(1);
                        dsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    du i = obtain2.readInt() != 0 ? du.CREATOR.m913i(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return i;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0738a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static dw m2556y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof dw)) ? new C0737a(iBinder) : (dw) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    du b = m915b(data.readInt() != 0 ? ds.CREATOR.m910h(data) : null);
                    reply.writeNoException();
                    if (b != null) {
                        reply.writeInt(1);
                        b.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    du m915b(ds dsVar) throws RemoteException;
}
