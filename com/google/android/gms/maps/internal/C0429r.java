package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.r */
public interface C0429r extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.r.a */
    public static abstract class C0899a extends Binder implements C0429r {

        /* renamed from: com.google.android.gms.maps.internal.r.a.a */
        private static class C0898a implements C0429r {
            private IBinder kq;

            C0898a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation orientation) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                    if (orientation != null) {
                        obtain.writeInt(1);
                        orientation.writeToParcel(obtain, 0);
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
        }

        public C0899a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
        }

        public static C0429r aQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0429r)) ? new C0898a(iBinder) : (C0429r) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                    onStreetViewPanoramaClick(data.readInt() != 0 ? StreetViewPanoramaOrientation.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;
}
