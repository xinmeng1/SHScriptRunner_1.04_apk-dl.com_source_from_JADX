package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

public interface IGamesCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGamesCallbacks {

        private static class Proxy implements IGamesCallbacks {
            private IBinder kq;

            Proxy(IBinder remote) {
                this.kq = remote;
            }

            public void m2188A(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2189B(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2190C(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2191D(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2192E(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2193F(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2194G(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2195H(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2196I(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2197J(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2198K(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2199L(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2200M(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2201N(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2202O(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2203P(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2204a(int i, String str, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2205a(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dataHolder2 != null) {
                        obtain.writeInt(1);
                        dataHolder2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2206a(DataHolder dataHolder, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2207a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents2 != null) {
                        obtain.writeInt(1);
                        contents2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents3 != null) {
                        obtain.writeInt(1);
                        contents3.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2208a(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m2209b(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.kq.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2210b(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2211b(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2212c(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2213c(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2214c(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void cd(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.kq.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ce(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.kq.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2215d(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2216d(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.kq.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2217d(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2218d(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void dT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.kq.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2219e(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2220e(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.kq.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2221e(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2222e(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2223f(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2224f(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.kq.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2225f(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2226f(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2227g(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.kq.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2228g(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2229h(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2230i(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2231j(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2232k(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2233l(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2234m(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2235n(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2236o(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onInvitationRemoved(String invitationId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(invitationId);
                    this.kq.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLeftRoom(int statusCode, String roomId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(roomId);
                    this.kq.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.kq.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.kq.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealTimeMessageReceived(RealTimeMessage message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestRemoved(String requestId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(requestId);
                    this.kq.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onTurnBasedMatchRemoved(String matchId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(matchId);
                    this.kq.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2237p(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesStatusCodes.STATUS_QUEST_NOT_STARTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2238q(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(8004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2239r(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(8005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2240s(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2241t(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2242u(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2243v(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2244w(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2245x(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2246y(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2247z(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
        }

        public static IGamesCallbacks ai(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesCallbacks)) ? new Proxy(iBinder) : (IGamesCallbacks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DataHolder dataHolder = null;
            switch (code) {
                case 5001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m512d(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m509c(data.readInt() != 0 ? DataHolder.CREATOR.m166x(data) : null);
                    reply.writeNoException();
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m516e(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m517e(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    DataHolder x = data.readInt() != 0 ? DataHolder.CREATOR.m166x(data) : null;
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m501a(x, dataHolder);
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m521f(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m524g(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m525h(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m526i(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m527j(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m528k(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    dT();
                    reply.writeNoException();
                    return true;
                case 5017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m530m(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m538u(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m539v(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onLeftRoom(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m540w(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m541x(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m542y(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m543z(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m484A(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m504a(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m507b(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m510c(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5029:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m514d(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m518e(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m522f(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5032:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onRealTimeMessageReceived(data.readInt() != 0 ? (RealTimeMessage) RealTimeMessage.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5033:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m505b(data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5034:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m500a(data.readInt(), data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5035:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m486C(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5036:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    cd(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5037:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m531n(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5038:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m485B(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5039:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m487D(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5040:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    ce(data.readInt());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /*6001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onP2PConnected(data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /*6002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onP2PDisconnected(data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED /*8001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m488E(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE /*8002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m506b(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_QUEST_NOT_STARTED /*8003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m533p(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m534q(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m535r(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m536s(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m520f(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m537t(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onTurnBasedMatchRemoved(data.readString());
                    reply.writeNoException();
                    return true;
                case 8010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onInvitationRemoved(data.readString());
                    reply.writeNoException();
                    return true;
                case 9001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m529l(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED /*10001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m532o(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onRequestRemoved(data.readString());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m489F(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m490G(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LEFT_ROOM /*10005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m508c(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /*10006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m491H(dataHolder);
                    reply.writeNoException();
                    return true;
                case 11001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m511d(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m492I(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m515e(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m502a(data.readInt() != 0 ? DataHolder.CREATOR.m166x(data) : null, data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m493J(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m494K(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m495L(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m498O(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m513d(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m523g(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 12013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m499P(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m496M(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m519f(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m166x(data);
                    }
                    m497N(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12017:
                    Contents contents;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    DataHolder x2 = data.readInt() != 0 ? DataHolder.CREATOR.m166x(data) : null;
                    String readString = data.readString();
                    Contents contents2 = data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null;
                    Contents contents3 = data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        contents = (Contents) Contents.CREATOR.createFromParcel(data);
                    }
                    m503a(x2, readString, contents2, contents3, contents);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m484A(DataHolder dataHolder) throws RemoteException;

    void m485B(DataHolder dataHolder) throws RemoteException;

    void m486C(DataHolder dataHolder) throws RemoteException;

    void m487D(DataHolder dataHolder) throws RemoteException;

    void m488E(DataHolder dataHolder) throws RemoteException;

    void m489F(DataHolder dataHolder) throws RemoteException;

    void m490G(DataHolder dataHolder) throws RemoteException;

    void m491H(DataHolder dataHolder) throws RemoteException;

    void m492I(DataHolder dataHolder) throws RemoteException;

    void m493J(DataHolder dataHolder) throws RemoteException;

    void m494K(DataHolder dataHolder) throws RemoteException;

    void m495L(DataHolder dataHolder) throws RemoteException;

    void m496M(DataHolder dataHolder) throws RemoteException;

    void m497N(DataHolder dataHolder) throws RemoteException;

    void m498O(DataHolder dataHolder) throws RemoteException;

    void m499P(DataHolder dataHolder) throws RemoteException;

    void m500a(int i, String str, boolean z) throws RemoteException;

    void m501a(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException;

    void m502a(DataHolder dataHolder, Contents contents) throws RemoteException;

    void m503a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException;

    void m504a(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void m505b(int i, int i2, String str) throws RemoteException;

    void m506b(int i, Bundle bundle) throws RemoteException;

    void m507b(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void m508c(int i, Bundle bundle) throws RemoteException;

    void m509c(DataHolder dataHolder) throws RemoteException;

    void m510c(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void cd(int i) throws RemoteException;

    void ce(int i) throws RemoteException;

    void m511d(int i, Bundle bundle) throws RemoteException;

    void m512d(int i, String str) throws RemoteException;

    void m513d(DataHolder dataHolder) throws RemoteException;

    void m514d(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void dT() throws RemoteException;

    void m515e(int i, Bundle bundle) throws RemoteException;

    void m516e(int i, String str) throws RemoteException;

    void m517e(DataHolder dataHolder) throws RemoteException;

    void m518e(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void m519f(int i, Bundle bundle) throws RemoteException;

    void m520f(int i, String str) throws RemoteException;

    void m521f(DataHolder dataHolder) throws RemoteException;

    void m522f(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void m523g(int i, String str) throws RemoteException;

    void m524g(DataHolder dataHolder) throws RemoteException;

    void m525h(DataHolder dataHolder) throws RemoteException;

    void m526i(DataHolder dataHolder) throws RemoteException;

    void m527j(DataHolder dataHolder) throws RemoteException;

    void m528k(DataHolder dataHolder) throws RemoteException;

    void m529l(DataHolder dataHolder) throws RemoteException;

    void m530m(DataHolder dataHolder) throws RemoteException;

    void m531n(DataHolder dataHolder) throws RemoteException;

    void m532o(DataHolder dataHolder) throws RemoteException;

    void onInvitationRemoved(String str) throws RemoteException;

    void onLeftRoom(int i, String str) throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException;

    void onRequestRemoved(String str) throws RemoteException;

    void onTurnBasedMatchRemoved(String str) throws RemoteException;

    void m533p(DataHolder dataHolder) throws RemoteException;

    void m534q(DataHolder dataHolder) throws RemoteException;

    void m535r(DataHolder dataHolder) throws RemoteException;

    void m536s(DataHolder dataHolder) throws RemoteException;

    void m537t(DataHolder dataHolder) throws RemoteException;

    void m538u(DataHolder dataHolder) throws RemoteException;

    void m539v(DataHolder dataHolder) throws RemoteException;

    void m540w(DataHolder dataHolder) throws RemoteException;

    void m541x(DataHolder dataHolder) throws RemoteException;

    void m542y(DataHolder dataHolder) throws RemoteException;

    void m543z(DataHolder dataHolder) throws RemoteException;
}
