package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public interface ac extends IInterface {

    /* renamed from: com.google.android.gms.wearable.internal.ac.a */
    public static abstract class C1004a extends Binder implements ac {

        /* renamed from: com.google.android.gms.wearable.internal.ac.a.a */
        private static class C1003a implements ac {
            private IBinder kq;

            C1003a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m3140Y(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3141a(af afVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (afVar != null) {
                        obtain.writeInt(1);
                        afVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3142a(ai aiVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (aiVar != null) {
                        obtain.writeInt(1);
                        aiVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m3143b(ai aiVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (aiVar != null) {
                        obtain.writeInt(1);
                        aiVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C1004a() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public static ac bx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ac)) ? new C1003a(iBinder) : (ac) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ai aiVar = null;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    DataHolder x;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    m1819Y(x);
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    af afVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        afVar = (af) af.CREATOR.createFromParcel(data);
                    }
                    m1820a(afVar);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        aiVar = (ai) ai.CREATOR.createFromParcel(data);
                    }
                    m1821a(aiVar);
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        aiVar = (ai) ai.CREATOR.createFromParcel(data);
                    }
                    m1822b(aiVar);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1819Y(DataHolder dataHolder) throws RemoteException;

    void m1820a(af afVar) throws RemoteException;

    void m1821a(ai aiVar) throws RemoteException;

    void m1822b(ai aiVar) throws RemoteException;
}
