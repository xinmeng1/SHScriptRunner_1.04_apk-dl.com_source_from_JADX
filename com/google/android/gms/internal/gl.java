package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public interface gl extends IInterface {

    /* renamed from: com.google.android.gms.internal.gl.a */
    public static abstract class C0769a extends Binder implements gl {

        /* renamed from: com.google.android.gms.internal.gl.a.a */
        private static class C0768a implements gl {
            private IBinder kq;

            C0768a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m2610a(double d, double d2, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2611a(String str, LaunchOptions launchOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    if (launchOptions != null) {
                        obtain.writeInt(1);
                        launchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2612a(String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.kq.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2613a(String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.kq.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2614a(boolean z, double d, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeDouble(d);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void am(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.kq.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void an(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.kq.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void ao(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.kq.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.kq.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2615e(String str, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void eg() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.kq.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void ep() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.kq.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2616h(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static gl m2617H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof gl)) ? new C0768a(iBinder) : (gl) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    disconnect();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m1122e(readString, z);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m1123h(data.readString(), data.readString());
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    ep();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    am(data.readString());
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    eg();
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m1117a(data.readDouble(), data.readDouble(), data.readInt() != 0);
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    boolean z2 = data.readInt() != 0;
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m1121a(z2, readDouble, z);
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m1119a(data.readString(), data.readString(), data.readLong());
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m1120a(data.readString(), data.createByteArray(), data.readLong());
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    an(data.readString());
                    return true;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    ao(data.readString());
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    m1118a(data.readString(), data.readInt() != 0 ? (LaunchOptions) LaunchOptions.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1117a(double d, double d2, boolean z) throws RemoteException;

    void m1118a(String str, LaunchOptions launchOptions) throws RemoteException;

    void m1119a(String str, String str2, long j) throws RemoteException;

    void m1120a(String str, byte[] bArr, long j) throws RemoteException;

    void m1121a(boolean z, double d, boolean z2) throws RemoteException;

    void am(String str) throws RemoteException;

    void an(String str) throws RemoteException;

    void ao(String str) throws RemoteException;

    void disconnect() throws RemoteException;

    void m1122e(String str, boolean z) throws RemoteException;

    void eg() throws RemoteException;

    void ep() throws RemoteException;

    void m1123h(String str, String str2) throws RemoteException;
}
