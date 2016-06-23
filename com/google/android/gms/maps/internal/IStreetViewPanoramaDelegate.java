package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.dynamic.C0280d;
import com.google.android.gms.dynamic.C0280d.C0688a;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.internal.C0427p.C0895a;
import com.google.android.gms.maps.internal.C0428q.C0897a;
import com.google.android.gms.maps.internal.C0429r.C0899a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.wearable.DataEvent;

public interface IStreetViewPanoramaDelegate extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate.a */
    public static abstract class C0859a extends Binder implements IStreetViewPanoramaDelegate {

        /* renamed from: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate.a.a */
        private static class C0858a implements IStreetViewPanoramaDelegate {
            private IBinder kq;

            C0858a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void animateTo(StreetViewPanoramaCamera camera, long duration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (camera != null) {
                        obtain.writeInt(1);
                        camera.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(duration);
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

            public void enablePanning(boolean enablePanning) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enablePanning) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableStreetNames(boolean enableStreetNames) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enableStreetNames) {
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

            public void enableUserNavigation(boolean enableUserNavigation) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enableUserNavigation) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableZoom(boolean enableZoom) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (!enableZoom) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.kq.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    StreetViewPanoramaCamera createFromParcel = obtain2.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.kq.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    StreetViewPanoramaLocation createFromParcel = obtain2.readInt() != 0 ? StreetViewPanoramaLocation.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isPanningGesturesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isStreetNamesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isUserNavigationEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isZoomGesturesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0280d orientationToPoint(StreetViewPanoramaOrientation orientation) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (orientation != null) {
                        obtain.writeInt(1);
                        orientation.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    C0280d ag = C0688a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaOrientation pointToOrientation(C0280d point) throws RemoteException {
                StreetViewPanoramaOrientation streetViewPanoramaOrientation = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(point != null ? point.asBinder() : null);
                    this.kq.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        streetViewPanoramaOrientation = StreetViewPanoramaOrientation.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return streetViewPanoramaOrientation;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaCameraChangeListener(C0427p listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.kq.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaChangeListener(C0428q listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.kq.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaClickListener(C0429r listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.kq.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPosition(LatLng position) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (position != null) {
                        obtain.writeInt(1);
                        position.writeToParcel(obtain, 0);
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

            public void setPositionWithID(String panoId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeString(panoId);
                    this.kq.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPositionWithRadius(LatLng position, int radius) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (position != null) {
                        obtain.writeInt(1);
                        position.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(radius);
                    this.kq.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IStreetViewPanoramaDelegate aT(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStreetViewPanoramaDelegate)) ? new C0858a(iBinder) : (IStreetViewPanoramaDelegate) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            int i = 0;
            boolean z;
            boolean isZoomGesturesEnabled;
            LatLng createFromParcel;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    enableZoom(z);
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    enablePanning(z);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    enableUserNavigation(z);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    enableStreetNames(z);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    isZoomGesturesEnabled = isZoomGesturesEnabled();
                    reply.writeNoException();
                    if (isZoomGesturesEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    isZoomGesturesEnabled = isPanningGesturesEnabled();
                    reply.writeNoException();
                    if (isZoomGesturesEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    isZoomGesturesEnabled = isUserNavigationEnabled();
                    reply.writeNoException();
                    if (isZoomGesturesEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    isZoomGesturesEnabled = isStreetNamesEnabled();
                    reply.writeNoException();
                    if (isZoomGesturesEnabled) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    animateTo(data.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.createFromParcel(data) : null, data.readLong());
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaCamera panoramaCamera = getPanoramaCamera();
                    reply.writeNoException();
                    if (panoramaCamera != null) {
                        reply.writeInt(1);
                        panoramaCamera.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    setPositionWithID(data.readString());
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        createFromParcel = LatLng.CREATOR.createFromParcel(data);
                    }
                    setPosition(createFromParcel);
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (data.readInt() != 0) {
                        createFromParcel = LatLng.CREATOR.createFromParcel(data);
                    }
                    setPositionWithRadius(createFromParcel, data.readInt());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaLocation streetViewPanoramaLocation = getStreetViewPanoramaLocation();
                    reply.writeNoException();
                    if (streetViewPanoramaLocation != null) {
                        reply.writeInt(1);
                        streetViewPanoramaLocation.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    setOnStreetViewPanoramaChangeListener(C0897a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    setOnStreetViewPanoramaCameraChangeListener(C0895a.aO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    setOnStreetViewPanoramaClickListener(C0899a.aQ(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaOrientation pointToOrientation = pointToOrientation(C0688a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    if (pointToOrientation != null) {
                        reply.writeInt(1);
                        pointToOrientation.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    C0280d orientationToPoint = orientationToPoint(data.readInt() != 0 ? StreetViewPanoramaOrientation.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (orientationToPoint != null) {
                        iBinder = orientationToPoint.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) throws RemoteException;

    void enablePanning(boolean z) throws RemoteException;

    void enableStreetNames(boolean z) throws RemoteException;

    void enableUserNavigation(boolean z) throws RemoteException;

    void enableZoom(boolean z) throws RemoteException;

    StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

    StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

    boolean isPanningGesturesEnabled() throws RemoteException;

    boolean isStreetNamesEnabled() throws RemoteException;

    boolean isUserNavigationEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    C0280d orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    StreetViewPanoramaOrientation pointToOrientation(C0280d c0280d) throws RemoteException;

    void setOnStreetViewPanoramaCameraChangeListener(C0427p c0427p) throws RemoteException;

    void setOnStreetViewPanoramaChangeListener(C0428q c0428q) throws RemoteException;

    void setOnStreetViewPanoramaClickListener(C0429r c0429r) throws RemoteException;

    void setPosition(LatLng latLng) throws RemoteException;

    void setPositionWithID(String str) throws RemoteException;

    void setPositionWithRadius(LatLng latLng, int i) throws RemoteException;
}
