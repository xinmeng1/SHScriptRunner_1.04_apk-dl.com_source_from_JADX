package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.lo.C0817a;
import com.google.android.gms.internal.lp.C0819a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wallet.C0986d;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wearable.DataEvent;

public interface lm extends IInterface {

    /* renamed from: com.google.android.gms.internal.lm.a */
    public static abstract class C0813a extends Binder implements lm {

        /* renamed from: com.google.android.gms.internal.lm.a.a */
        private static class C0812a implements lm {
            private IBinder kq;

            C0812a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m2793a(Bundle bundle, lp lpVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lpVar != null) {
                        iBinder = lpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2794a(lg lgVar, Bundle bundle, lp lpVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (lgVar != null) {
                        obtain.writeInt(1);
                        lgVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lpVar != null) {
                        iBinder = lpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2795a(FullWalletRequest fullWalletRequest, Bundle bundle, lp lpVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lpVar != null) {
                        iBinder = lpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2796a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, lo loVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (loVar != null) {
                        iBinder = loVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2797a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, lp lpVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lpVar != null) {
                        iBinder = lpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2798a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2799a(C0986d c0986d, Bundle bundle, lp lpVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (c0986d != null) {
                        obtain.writeInt(1);
                        c0986d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lpVar != null) {
                        iBinder = lpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2800a(String str, String str2, Bundle bundle, lp lpVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lpVar != null) {
                        iBinder = lpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void m2801o(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static lm bq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof lm)) ? new C0812a(iBinder) : (lm) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1348a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0819a.bt(data.readStrongBinder()));
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1346a(data.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0819a.bt(data.readStrongBinder()));
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1351a(data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0819a.bt(data.readStrongBinder()));
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1349a(data.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1344a(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0819a.bt(data.readStrongBinder()));
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1350a(data.readInt() != 0 ? (C0986d) C0986d.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0819a.bt(data.readStrongBinder()));
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1347a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0817a.bs(data.readStrongBinder()));
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1345a(data.readInt() != 0 ? (lg) lg.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0819a.bt(data.readStrongBinder()));
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m1352o(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1344a(Bundle bundle, lp lpVar) throws RemoteException;

    void m1345a(lg lgVar, Bundle bundle, lp lpVar) throws RemoteException;

    void m1346a(FullWalletRequest fullWalletRequest, Bundle bundle, lp lpVar) throws RemoteException;

    void m1347a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, lo loVar) throws RemoteException;

    void m1348a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, lp lpVar) throws RemoteException;

    void m1349a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    void m1350a(C0986d c0986d, Bundle bundle, lp lpVar) throws RemoteException;

    void m1351a(String str, String str2, Bundle bundle, lp lpVar) throws RemoteException;

    void m1352o(Bundle bundle) throws RemoteException;
}
