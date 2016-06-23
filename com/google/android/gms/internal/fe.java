package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;
import java.util.Map;

public interface fe extends IInterface {

    /* renamed from: com.google.android.gms.internal.fe.a */
    public static abstract class C0756a extends Binder implements fe {

        /* renamed from: com.google.android.gms.internal.fe.a.a */
        private static class C0755a implements fe {
            private IBinder kq;

            C0755a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m2576a(Map map, long j, String str, List<fd> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    obtain.writeMap(map);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void cl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static fe m2577z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof fe)) ? new C0755a(iBinder) : (fe) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    m1056a(data.readHashMap(getClass().getClassLoader()), data.readLong(), data.readString(), data.createTypedArrayList(fd.CREATOR));
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    cl();
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    String version = getVersion();
                    reply.writeNoException();
                    reply.writeString(version);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1056a(Map map, long j, String str, List<fd> list) throws RemoteException;

    void cl() throws RemoteException;

    String getVersion() throws RemoteException;
}
