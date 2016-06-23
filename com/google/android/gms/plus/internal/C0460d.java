package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hg.C0777a;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.ie;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.internal.C0458b.C0936a;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.d */
public interface C0460d extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.d.a */
    public static abstract class C0940a extends Binder implements C0460d {

        /* renamed from: com.google.android.gms.plus.internal.d.a.a */
        private static class C0939a implements C0460d {
            private IBinder kq;

            C0939a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public hg m2913a(C0458b c0458b, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.kq.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    hg J = C0777a.m2668J(obtain2.readStrongBinder());
                    return J;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2914a(ie ieVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (ieVar != null) {
                        obtain.writeInt(1);
                        ieVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2915a(C0458b c0458b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2916a(C0458b c0458b, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kq.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2917a(C0458b c0458b, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void m2918a(C0458b c0458b, ie ieVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    if (ieVar != null) {
                        obtain.writeInt(1);
                        ieVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2919a(C0458b c0458b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2920a(C0458b c0458b, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2921a(C0458b c0458b, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeStringList(list);
                    this.kq.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2922a(String str, hr hrVar, hr hrVar2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    if (hrVar != null) {
                        obtain.writeInt(1);
                        hrVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hrVar2 != null) {
                        obtain.writeInt(1);
                        hrVar2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m2923b(C0458b c0458b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    this.kq.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2924b(C0458b c0458b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2925c(C0458b c0458b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2926d(C0458b c0458b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2927e(C0458b c0458b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0458b != null ? c0458b.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String jU() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean jV() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(42, obtain, obtain2, 0);
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

            public String jW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kq.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.kq.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0460d bm(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0460d)) ? new C0939a(iBinder) : (C0460d) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            hr hrVar = null;
            String accountName;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1570a(C0936a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1571a(C0936a.bk(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1575b(C0936a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1565a(data.readInt() != 0 ? ie.CREATOR.m1263L(data) : null);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    clearDefaultAccount();
                    reply.writeNoException();
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1566a(C0936a.bk(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1568a(C0936a.bk(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1567a(C0936a.bk(data.readStrongBinder()), data.readInt(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    hg a = m1564a(C0936a.bk(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        asBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    removeMoment(data.readString());
                    reply.writeNoException();
                    return true;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1576c(C0936a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1574b(C0936a.bk(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1572a(C0936a.bk(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1577d(C0936a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = jU();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean jV = jV();
                    reply.writeNoException();
                    reply.writeInt(jV ? 1 : 0);
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = jW();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 44:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1578e(C0936a.bk(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 45:
                    ie L;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    C0458b bk = C0936a.bk(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        L = ie.CREATOR.m1263L(data);
                    }
                    m1569a(bk, L);
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    String readString = data.readString();
                    hr D = data.readInt() != 0 ? hr.CREATOR.m1241D(data) : null;
                    if (data.readInt() != 0) {
                        hrVar = hr.CREATOR.m1241D(data);
                    }
                    m1573a(readString, D, hrVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    hg m1564a(C0458b c0458b, int i, int i2, int i3, String str) throws RemoteException;

    void m1565a(ie ieVar) throws RemoteException;

    void m1566a(C0458b c0458b) throws RemoteException;

    void m1567a(C0458b c0458b, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    void m1568a(C0458b c0458b, Uri uri, Bundle bundle) throws RemoteException;

    void m1569a(C0458b c0458b, ie ieVar) throws RemoteException;

    void m1570a(C0458b c0458b, String str) throws RemoteException;

    void m1571a(C0458b c0458b, String str, String str2) throws RemoteException;

    void m1572a(C0458b c0458b, List<String> list) throws RemoteException;

    void m1573a(String str, hr hrVar, hr hrVar2) throws RemoteException;

    void m1574b(C0458b c0458b) throws RemoteException;

    void m1575b(C0458b c0458b, String str) throws RemoteException;

    void m1576c(C0458b c0458b, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    void m1577d(C0458b c0458b, String str) throws RemoteException;

    void m1578e(C0458b c0458b, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    String jU() throws RemoteException;

    boolean jV() throws RemoteException;

    String jW() throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
