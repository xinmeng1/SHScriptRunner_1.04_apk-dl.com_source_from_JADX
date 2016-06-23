package com.google.android.gms.maps.model.internal;

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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.internal.f */
public interface C0448f extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.f.a */
    public static abstract class C0916a extends Binder implements C0448f {

        /* renamed from: com.google.android.gms.maps.model.internal.f.a.a */
        private static class C0915a implements C0448f {
            private IBinder kq;

            C0915a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public float getAlpha() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LatLng getPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    LatLng createFromParcel = obtain2.readInt() != 0 ? LatLng.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getRotation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSnippet() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getTitle() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m2882h(C0448f c0448f) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeStrongBinder(c0448f != null ? c0448f.asBinder() : null);
                    this.kq.transact(16, obtain, obtain2, 0);
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

            public int hashCodeRemote() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void hideInfoWindow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isDraggable() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(10, obtain, obtain2, 0);
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

            public boolean isFlat() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(21, obtain, obtain2, 0);
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

            public boolean isInfoWindowShown() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(13, obtain, obtain2, 0);
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

            public boolean isVisible() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(15, obtain, obtain2, 0);
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

            public void m2883m(C0280d c0280d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    this.kq.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void remove() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAlpha(float alpha) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeFloat(alpha);
                    this.kq.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAnchor(float anchorU, float anchorV) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeFloat(anchorU);
                    obtain.writeFloat(anchorV);
                    this.kq.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDraggable(boolean draggable) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (draggable) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setFlat(boolean flat) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (flat) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setInfoWindowAnchor(float anchorU, float anchorV) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeFloat(anchorU);
                    obtain.writeFloat(anchorV);
                    this.kq.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPosition(LatLng latlng) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (latlng != null) {
                        obtain.writeInt(1);
                        latlng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRotation(float rotation) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeFloat(rotation);
                    this.kq.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSnippet(String snippet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeString(snippet);
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTitle(String title) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeString(title);
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setVisible(boolean visible) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (visible) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInfoWindow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.kq.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0448f bc(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0448f)) ? new C0915a(iBinder) : (C0448f) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            String id;
            boolean z;
            boolean isDraggable;
            float rotation;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    remove();
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    id = getId();
                    reply.writeNoException();
                    reply.writeString(id);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    setPosition(data.readInt() != 0 ? LatLng.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    LatLng position = getPosition();
                    reply.writeNoException();
                    if (position != null) {
                        reply.writeInt(1);
                        position.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    setTitle(data.readString());
                    reply.writeNoException();
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    id = getTitle();
                    reply.writeNoException();
                    reply.writeString(id);
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    setSnippet(data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    id = getSnippet();
                    reply.writeNoException();
                    reply.writeString(id);
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setDraggable(z);
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    isDraggable = isDraggable();
                    reply.writeNoException();
                    if (isDraggable) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    showInfoWindow();
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    hideInfoWindow();
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    isDraggable = isInfoWindowShown();
                    reply.writeNoException();
                    if (isDraggable) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setVisible(z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    isDraggable = isVisible();
                    reply.writeNoException();
                    if (isDraggable) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    isDraggable = m1544h(C0916a.bc(data.readStrongBinder()));
                    reply.writeNoException();
                    if (isDraggable) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    i = hashCodeRemote();
                    reply.writeNoException();
                    reply.writeInt(i);
                    return true;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    m1545m(C0688a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    setAnchor(data.readFloat(), data.readFloat());
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setFlat(z);
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    isDraggable = isFlat();
                    reply.writeNoException();
                    if (isDraggable) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    setRotation(data.readFloat());
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    rotation = getRotation();
                    reply.writeNoException();
                    reply.writeFloat(rotation);
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    setInfoWindowAnchor(data.readFloat(), data.readFloat());
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    setAlpha(data.readFloat());
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    rotation = getAlpha();
                    reply.writeNoException();
                    reply.writeFloat(rotation);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    float getAlpha() throws RemoteException;

    String getId() throws RemoteException;

    LatLng getPosition() throws RemoteException;

    float getRotation() throws RemoteException;

    String getSnippet() throws RemoteException;

    String getTitle() throws RemoteException;

    boolean m1544h(C0448f c0448f) throws RemoteException;

    int hashCodeRemote() throws RemoteException;

    void hideInfoWindow() throws RemoteException;

    boolean isDraggable() throws RemoteException;

    boolean isFlat() throws RemoteException;

    boolean isInfoWindowShown() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void m1545m(C0280d c0280d) throws RemoteException;

    void remove() throws RemoteException;

    void setAlpha(float f) throws RemoteException;

    void setAnchor(float f, float f2) throws RemoteException;

    void setDraggable(boolean z) throws RemoteException;

    void setFlat(boolean z) throws RemoteException;

    void setInfoWindowAnchor(float f, float f2) throws RemoteException;

    void setPosition(LatLng latLng) throws RemoteException;

    void setRotation(float f) throws RemoteException;

    void setSnippet(String str) throws RemoteException;

    void setTitle(String str) throws RemoteException;

    void setVisible(boolean z) throws RemoteException;

    void showInfoWindow() throws RemoteException;
}
