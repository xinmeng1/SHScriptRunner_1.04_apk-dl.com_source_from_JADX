package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0280d;
import com.google.android.gms.dynamic.C0280d.C0688a;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C0847a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C0853a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C0855a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.C0861a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.C0863a;
import com.google.android.gms.maps.model.internal.C0443a;
import com.google.android.gms.maps.model.internal.C0443a.C0906a;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.c */
public interface C0414c extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.c.a */
    public static abstract class C0869a extends Binder implements C0414c {

        /* renamed from: com.google.android.gms.maps.internal.c.a.a */
        private static class C0868a implements C0414c {
            private IBinder kq;

            C0868a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IMapViewDelegate m2847a(C0280d c0280d, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate aC = C0855a.aC(obtain2.readStrongBinder());
                    return aC;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaViewDelegate m2848a(C0280d c0280d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaViewDelegate aV = C0863a.aV(obtain2.readStrongBinder());
                    return aV;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2849a(C0280d c0280d, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    obtain.writeInt(i);
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m2850h(C0280d c0280d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate m2851i(C0280d c0280d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate aB = C0853a.aB(obtain2.readStrongBinder());
                    return aB;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaFragmentDelegate m2852j(C0280d c0280d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaFragmentDelegate aU = C0861a.aU(obtain2.readStrongBinder());
                    return aU;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate jH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate av = C0847a.av(obtain2.readStrongBinder());
                    return av;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0443a jI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0443a aX = C0906a.aX(obtain2.readStrongBinder());
                    return aX;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0414c ax(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0414c)) ? new C0868a(iBinder) : (C0414c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m1490h(C0688a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate i = m1491i(C0688a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    if (i != null) {
                        iBinder = i.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = m1487a(C0688a.ag(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate jH = jH();
                    reply.writeNoException();
                    if (jH != null) {
                        iBinder = jH.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C0443a jI = jI();
                    reply.writeNoException();
                    if (jI != null) {
                        iBinder = jI.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m1489a(C0688a.ag(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate a2 = m1488a(C0688a.ag(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate j = m1492j(C0688a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    if (j != null) {
                        iBinder = j.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate m1487a(C0280d c0280d, GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaViewDelegate m1488a(C0280d c0280d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void m1489a(C0280d c0280d, int i) throws RemoteException;

    void m1490h(C0280d c0280d) throws RemoteException;

    IMapFragmentDelegate m1491i(C0280d c0280d) throws RemoteException;

    IStreetViewPanoramaFragmentDelegate m1492j(C0280d c0280d) throws RemoteException;

    ICameraUpdateFactoryDelegate jH() throws RemoteException;

    C0443a jI() throws RemoteException;
}
