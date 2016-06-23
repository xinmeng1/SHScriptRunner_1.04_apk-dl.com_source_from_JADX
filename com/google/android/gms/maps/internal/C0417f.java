package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0446d;
import com.google.android.gms.maps.model.internal.C0446d.C0912a;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.f */
public interface C0417f extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.f.a */
    public static abstract class C0875a extends Binder implements C0417f {

        /* renamed from: com.google.android.gms.maps.internal.f.a.a */
        private static class C0874a implements C0417f {
            private IBinder kq;

            C0874a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m2855a(C0446d c0446d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    obtain.writeStrongBinder(c0446d != null ? c0446d.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void onIndoorBuildingFocused() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0875a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        }

        public static C0417f aE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0417f)) ? new C0874a(iBinder) : (C0417f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    onIndoorBuildingFocused();
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    m1495a(C0912a.ba(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1495a(C0446d c0446d) throws RemoteException;

    void onIndoorBuildingFocused() throws RemoteException;
}
