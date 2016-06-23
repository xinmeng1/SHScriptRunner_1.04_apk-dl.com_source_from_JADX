package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.GeofenceStatusCodes;

public interface IRoomService extends IInterface {

    public static abstract class Stub extends Binder implements IRoomService {

        private static class Proxy implements IRoomService {
            private IBinder kq;

            public void m2410G(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(1008, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2411a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException {
                IBinder iBinder2 = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeStrongBinder(iBinder);
                    if (iRoomServiceCallbacks != null) {
                        iBinder2 = iRoomServiceCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    this.kq.transact(GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2412a(DataHolder dataHolder, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(1006, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2413a(byte[] bArr, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(1009, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2414a(byte[] bArr, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(1010, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void be(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.kq.transact(1013, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bf(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.kq.transact(1014, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2415c(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kq.transact(1004, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void hF() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kq.transact(GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void hG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kq.transact(1003, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void hH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kq.transact(1005, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void hI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kq.transact(1007, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2416r(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(1011, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2417s(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(1012, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m707a(data.readStrongBinder(), com.google.android.gms.games.internal.IRoomServiceCallbacks.Stub.am(data.readStrongBinder()));
                    return true;
                case GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS /*1002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    hF();
                    return true;
                case 1003:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    hG();
                    return true;
                case 1004:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m711c(data.readString(), data.readString(), data.readString());
                    return true;
                case 1005:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    hH();
                    return true;
                case 1006:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    DataHolder x = data.readInt() != 0 ? DataHolder.CREATOR.m166x(data) : null;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m708a(x, z);
                    return true;
                case 1007:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    hI();
                    return true;
                case 1008:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m706G(z);
                    return true;
                case 1009:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m709a(data.createByteArray(), data.readString(), data.readInt());
                    return true;
                case 1010:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m710a(data.createByteArray(), data.createStringArray());
                    return true;
                case 1011:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m712r(data.readString(), data.readInt());
                    return true;
                case 1012:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m713s(data.readString(), data.readInt());
                    return true;
                case 1013:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    be(data.readString());
                    return true;
                case 1014:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    bf(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IRoomService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m706G(boolean z) throws RemoteException;

    void m707a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException;

    void m708a(DataHolder dataHolder, boolean z) throws RemoteException;

    void m709a(byte[] bArr, String str, int i) throws RemoteException;

    void m710a(byte[] bArr, String[] strArr) throws RemoteException;

    void be(String str) throws RemoteException;

    void bf(String str) throws RemoteException;

    void m711c(String str, String str2, String str3) throws RemoteException;

    void hF() throws RemoteException;

    void hG() throws RemoteException;

    void hH() throws RemoteException;

    void hI() throws RemoteException;

    void m712r(String str, int i) throws RemoteException;

    void m713s(String str, int i) throws RemoteException;
}
