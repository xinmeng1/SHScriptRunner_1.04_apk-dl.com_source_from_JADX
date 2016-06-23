package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.dynamic.C0280d.C0688a;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.dynamic.c */
public interface C0279c extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.c.a */
    public static abstract class C0686a extends Binder implements C0279c {

        /* renamed from: com.google.android.gms.dynamic.c.a.a */
        private static class C0685a implements C0279c {
            private IBinder kq;

            C0685a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m2159c(C0280d c0280d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    this.kq.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2160d(C0280d c0280d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    this.kq.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0280d gI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0280d ag = C0688a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0279c gJ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0279c af = C0686a.af(obtain2.readStrongBinder());
                    return af;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0280d gK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    C0280d ag = C0688a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0279c gL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    C0279c af = C0686a.af(obtain2.readStrongBinder());
                    return af;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getArguments() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getRetainInstance() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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

            public String getTag() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getTargetRequestCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getUserVisibleHint() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(11, obtain, obtain2, 0);
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

            public C0280d getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    C0280d ag = C0688a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isAdded() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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

            public boolean isDetached() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(14, obtain, obtain2, 0);
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

            public boolean isHidden() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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

            public boolean isInLayout() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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

            public boolean isRemoving() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(17, obtain, obtain2, 0);
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

            public boolean isResumed() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(18, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kq.transact(19, obtain, obtain2, 0);
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

            public void setHasOptionsMenu(boolean hasMenu) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (hasMenu) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMenuVisibility(boolean menuVisible) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (menuVisible) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRetainInstance(boolean retain) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (retain) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserVisibleHint(boolean isVisibleToUser) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (isVisibleToUser) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startActivity(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startActivityForResult(Intent intent, int requestCode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(requestCode);
                    this.kq.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0686a() {
            attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static C0279c af(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0279c)) ? new C0685a(iBinder) : (C0279c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Intent intent = null;
            boolean z = false;
            C0280d gI;
            IBinder asBinder;
            int id;
            C0279c gJ;
            boolean retainInstance;
            int i;
            switch (code) {
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    gI = gI();
                    reply.writeNoException();
                    if (gI != null) {
                        asBinder = gI.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    Bundle arguments = getArguments();
                    reply.writeNoException();
                    if (arguments != null) {
                        reply.writeInt(1);
                        arguments.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    id = getId();
                    reply.writeNoException();
                    reply.writeInt(id);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    gJ = gJ();
                    reply.writeNoException();
                    if (gJ != null) {
                        asBinder = gJ.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    gI = gK();
                    reply.writeNoException();
                    if (gI != null) {
                        asBinder = gI.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = getRetainInstance();
                    reply.writeNoException();
                    reply.writeInt(retainInstance ? 1 : 0);
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    String tag = getTag();
                    reply.writeNoException();
                    reply.writeString(tag);
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    gJ = gL();
                    reply.writeNoException();
                    if (gJ != null) {
                        asBinder = gJ.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    id = getTargetRequestCode();
                    reply.writeNoException();
                    reply.writeInt(id);
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = getUserVisibleHint();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    gI = getView();
                    reply.writeNoException();
                    if (gI != null) {
                        asBinder = gI.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isAdded();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isDetached();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isHidden();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isInLayout();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isRemoving();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isResumed();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isVisible();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    m466c(C0688a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setHasOptionsMenu(z);
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setMenuVisibility(z);
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setRetainInstance(z);
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setUserVisibleHint(z);
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(data);
                    }
                    startActivity(intent);
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(data);
                    }
                    startActivityForResult(intent, data.readInt());
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    m467d(C0688a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m466c(C0280d c0280d) throws RemoteException;

    void m467d(C0280d c0280d) throws RemoteException;

    C0280d gI() throws RemoteException;

    C0279c gJ() throws RemoteException;

    C0280d gK() throws RemoteException;

    C0279c gL() throws RemoteException;

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    C0280d getView() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;
}
