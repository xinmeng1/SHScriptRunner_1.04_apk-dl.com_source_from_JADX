package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.g */
public interface C0265g extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.g.a */
    public static abstract class C0662a extends Binder implements C0265g {

        /* renamed from: com.google.android.gms.drive.realtime.internal.g.a.a */
        private static class C0661a implements C0265g {
            private IBinder kq;

            C0661a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m2099a(DataHolder dataHolder, ParcelableEventList parcelableEventList) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelableEventList != null) {
                        obtain.writeInt(1);
                        parcelableEventList.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

            public void m2100o(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
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
        }

        public static C0265g m2101W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0265g)) ? new C0661a(iBinder) : (C0265g) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Status status = null;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
                    m404a(data.readInt() != 0 ? DataHolder.CREATOR.m166x(data) : null, data.readInt() != 0 ? (ParcelableEventList) ParcelableEventList.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
                    if (data.readInt() != 0) {
                        status = Status.CREATOR.createFromParcel(data);
                    }
                    m405o(status);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m404a(DataHolder dataHolder, ParcelableEventList parcelableEventList) throws RemoteException;

    void m405o(Status status) throws RemoteException;
}
