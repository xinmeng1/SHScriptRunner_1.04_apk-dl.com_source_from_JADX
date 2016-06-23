package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.C1000c;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.ab.C1002a;

public interface ad extends IInterface {

    /* renamed from: com.google.android.gms.wearable.internal.ad.a */
    public static abstract class C1006a extends Binder implements ad {

        /* renamed from: com.google.android.gms.wearable.internal.ad.a.a */
        private static class C1005a implements ad {
            private IBinder kq;

            C1005a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m3144a(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3145a(ab abVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3146a(ab abVar, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3147a(ab abVar, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3148a(ab abVar, C1000c c1000c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (c1000c != null) {
                        obtain.writeInt(1);
                        c1000c.writeToParcel(obtain, 0);
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

            public void m3149a(ab abVar, ao aoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (aoVar != null) {
                        obtain.writeInt(1);
                        aoVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3150a(ab abVar, C1007b c1007b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (c1007b != null) {
                        obtain.writeInt(1);
                        c1007b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3151a(ab abVar, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.kq.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m3152b(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3153b(ab abVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3154c(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3155c(ab abVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3156d(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3157e(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3158f(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3159g(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m3160h(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.kq.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ad by(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ad)) ? new C1005a(iBinder) : (ad) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ao aoVar = null;
            ab bw;
            Uri uri;
            switch (code) {
                case DataEvent.TYPE_DELETED /*2*/:
                    C1000c c1000c;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C1002a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        c1000c = (C1000c) C1000c.CREATOR.createFromParcel(data);
                    }
                    m1827a(bw, c1000c);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1823a(C1002a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1831b(C1002a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1833c(C1002a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    PutDataRequest putDataRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C1002a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(data);
                    }
                    m1826a(bw, putDataRequest);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C1002a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    m1824a(bw, uri);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1835d(C1002a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C1002a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    m1832b(bw, uri);
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C1002a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    m1834c(bw, uri);
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1830a(C1002a.bw(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    Asset asset;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C1002a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(data);
                    }
                    m1825a(bw, asset);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1836e(C1002a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1837f(C1002a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    C1007b c1007b;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C1002a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        c1007b = (C1007b) C1007b.CREATOR.createFromParcel(data);
                    }
                    m1829a(bw, c1007b);
                    reply.writeNoException();
                    return true;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    bw = C1002a.bw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        aoVar = (ao) ao.CREATOR.createFromParcel(data);
                    }
                    m1828a(bw, aoVar);
                    reply.writeNoException();
                    return true;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1838g(C1002a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    m1839h(C1002a.bw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1823a(ab abVar) throws RemoteException;

    void m1824a(ab abVar, Uri uri) throws RemoteException;

    void m1825a(ab abVar, Asset asset) throws RemoteException;

    void m1826a(ab abVar, PutDataRequest putDataRequest) throws RemoteException;

    void m1827a(ab abVar, C1000c c1000c) throws RemoteException;

    void m1828a(ab abVar, ao aoVar) throws RemoteException;

    void m1829a(ab abVar, C1007b c1007b) throws RemoteException;

    void m1830a(ab abVar, String str, String str2, byte[] bArr) throws RemoteException;

    void m1831b(ab abVar) throws RemoteException;

    void m1832b(ab abVar, Uri uri) throws RemoteException;

    void m1833c(ab abVar) throws RemoteException;

    void m1834c(ab abVar, Uri uri) throws RemoteException;

    void m1835d(ab abVar) throws RemoteException;

    void m1836e(ab abVar) throws RemoteException;

    void m1837f(ab abVar) throws RemoteException;

    void m1838g(ab abVar) throws RemoteException;

    void m1839h(ab abVar) throws RemoteException;
}
