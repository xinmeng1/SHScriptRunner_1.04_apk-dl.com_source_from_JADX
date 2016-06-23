package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGamesSignInService extends IInterface {

    public static abstract class Stub extends Binder implements IGamesSignInService {

        private static class Proxy implements IGamesSignInService {
            private IBinder kq;

            public void m2402a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2403a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kq.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2404a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2405a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    this.kq.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m2406b(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kq.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2407b(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String bc(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    this.kq.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String bd(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    this.kq.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m2408f(String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2409o(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInService");
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String bc;
            switch (code) {
                case 5001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    bc = bc(data.readString());
                    reply.writeNoException();
                    reply.writeString(bc);
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    bc = bd(data.readString());
                    reply.writeNoException();
                    reply.writeString(bc);
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    m701a(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.ak(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    m700a(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.ak(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    m699a(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.ak(data.readStrongBinder()), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    m698a(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.ak(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    m702b(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.ak(data.readStrongBinder()), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    m703b(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.ak(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    bc = m704f(data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    reply.writeString(bc);
                    return true;
                case 9001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    m705o(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesSignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m698a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2) throws RemoteException;

    void m699a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) throws RemoteException;

    void m700a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr) throws RemoteException;

    void m701a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr, String str3) throws RemoteException;

    void m702b(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) throws RemoteException;

    void m703b(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr) throws RemoteException;

    String bc(String str) throws RemoteException;

    String bd(String str) throws RemoteException;

    String m704f(String str, boolean z) throws RemoteException;

    void m705o(String str, String str2) throws RemoteException;
}
