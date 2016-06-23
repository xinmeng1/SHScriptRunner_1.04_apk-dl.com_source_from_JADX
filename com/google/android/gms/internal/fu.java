package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.fv.C0762a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public interface fu extends IInterface {

    /* renamed from: com.google.android.gms.internal.fu.a */
    public static abstract class C0760a extends Binder implements fu {

        /* renamed from: com.google.android.gms.internal.fu.a.a */
        private static class C0759a implements fu {
            private IBinder kq;

            C0759a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m2586a(fv fvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(fvVar != null ? fvVar.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2587a(fv fvVar, String str, fr[] frVarArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(fvVar != null ? fvVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedArray(frVarArr, 0);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2588a(fv fvVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(fvVar != null ? fvVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m2589b(fv fvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(fvVar != null ? fvVar.asBinder() : null);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static fu m2590A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof fu)) ? new C0759a(iBinder) : (fu) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    m1082a(C0762a.m2594B(data.readStrongBinder()), data.readString(), (fr[]) data.createTypedArray(fr.CREATOR));
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    m1081a(C0762a.m2594B(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    m1084b(C0762a.m2594B(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    m1083a(C0762a.m2594B(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1081a(fv fvVar) throws RemoteException;

    void m1082a(fv fvVar, String str, fr[] frVarArr) throws RemoteException;

    void m1083a(fv fvVar, boolean z) throws RemoteException;

    void m1084b(fv fvVar) throws RemoteException;
}
