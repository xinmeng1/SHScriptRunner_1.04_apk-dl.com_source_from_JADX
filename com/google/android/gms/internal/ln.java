package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0279c;
import com.google.android.gms.dynamic.C0279c.C0686a;
import com.google.android.gms.dynamic.C0280d;
import com.google.android.gms.dynamic.C0280d.C0688a;
import com.google.android.gms.internal.lk.C0809a;
import com.google.android.gms.internal.ll.C0811a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wearable.DataEvent;

public interface ln extends IInterface {

    /* renamed from: com.google.android.gms.internal.ln.a */
    public static abstract class C0815a extends Binder implements ln {

        /* renamed from: com.google.android.gms.internal.ln.a.a */
        private static class C0814a implements ln {
            private IBinder kq;

            C0814a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public lk m2802a(C0280d c0280d, C0279c c0279c, WalletFragmentOptions walletFragmentOptions, ll llVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(c0280d != null ? c0280d.asBinder() : null);
                    obtain.writeStrongBinder(c0279c != null ? c0279c.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (llVar != null) {
                        iBinder = llVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    lk bo = C0809a.bo(obtain2.readStrongBinder());
                    return bo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public static ln br(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ln)) ? new C0814a(iBinder) : (ln) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    lk a = m1353a(C0688a.ag(data.readStrongBinder()), C0686a.af(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, C0811a.bp(data.readStrongBinder()));
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    lk m1353a(C0280d c0280d, C0279c c0279c, WalletFragmentOptions walletFragmentOptions, ll llVar) throws RemoteException;
}
