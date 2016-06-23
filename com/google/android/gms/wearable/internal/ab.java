package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public interface ab extends IInterface {

    /* renamed from: com.google.android.gms.wearable.internal.ab.a */
    public static abstract class C1002a extends Binder implements ab {

        /* renamed from: com.google.android.gms.wearable.internal.ab.a.a */
        private static class C1001a implements ab {
            private IBinder kq;

            C1001a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m3129Z(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3130a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3131a(am amVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (amVar != null) {
                        obtain.writeInt(1);
                        amVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3132a(aq aqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (aqVar != null) {
                        obtain.writeInt(1);
                        aqVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3133a(as asVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (asVar != null) {
                        obtain.writeInt(1);
                        asVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3134a(C1010p c1010p) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1010p != null) {
                        obtain.writeInt(1);
                        c1010p.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3135a(C1011r c1011r) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1011r != null) {
                        obtain.writeInt(1);
                        c1011r.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3136a(C1012t c1012t) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1012t != null) {
                        obtain.writeInt(1);
                        c1012t.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3137a(C1013v c1013v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1013v != null) {
                        obtain.writeInt(1);
                        c1013v.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3138a(C1014x c1014x) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1014x != null) {
                        obtain.writeInt(1);
                        c1014x.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3139a(C1015z c1015z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1015z != null) {
                        obtain.writeInt(1);
                        c1015z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public C1002a() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        public static ab bw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ab)) ? new C1001a(iBinder) : (ab) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            as asVar = null;
            switch (code) {
                case DataEvent.TYPE_DELETED /*2*/:
                    C1011r c1011r;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1011r = (C1011r) C1011r.CREATOR.createFromParcel(data);
                    }
                    m1814a(c1011r);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    am amVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        amVar = (am) am.CREATOR.createFromParcel(data);
                    }
                    m1810a(amVar);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    C1013v c1013v;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1013v = (C1013v) C1013v.CREATOR.createFromParcel(data);
                    }
                    m1816a(c1013v);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    DataHolder x;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    m1808Z(x);
                    reply.writeNoException();
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    C1010p c1010p;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1010p = (C1010p) C1010p.CREATOR.createFromParcel(data);
                    }
                    m1813a(c1010p);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    aq aqVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        aqVar = (aq) aq.CREATOR.createFromParcel(data);
                    }
                    m1811a(aqVar);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    C1014x c1014x;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1014x = (C1014x) C1014x.CREATOR.createFromParcel(data);
                    }
                    m1817a(c1014x);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    C1015z c1015z;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1015z = (C1015z) C1015z.CREATOR.createFromParcel(data);
                    }
                    m1818a(c1015z);
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    C1012t c1012t;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1012t = (C1012t) C1012t.CREATOR.createFromParcel(data);
                    }
                    m1815a(c1012t);
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    Status createFromParcel;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(data);
                    }
                    m1809a(createFromParcel);
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        asVar = (as) as.CREATOR.createFromParcel(data);
                    }
                    m1812a(asVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1808Z(DataHolder dataHolder) throws RemoteException;

    void m1809a(Status status) throws RemoteException;

    void m1810a(am amVar) throws RemoteException;

    void m1811a(aq aqVar) throws RemoteException;

    void m1812a(as asVar) throws RemoteException;

    void m1813a(C1010p c1010p) throws RemoteException;

    void m1814a(C1011r c1011r) throws RemoteException;

    void m1815a(C1012t c1012t) throws RemoteException;

    void m1816a(C1013v c1013v) throws RemoteException;

    void m1817a(C1014x c1014x) throws RemoteException;

    void m1818a(C1015z c1015z) throws RemoteException;
}
