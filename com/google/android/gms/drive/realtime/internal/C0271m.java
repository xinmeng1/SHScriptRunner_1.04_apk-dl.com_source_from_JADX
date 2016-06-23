package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.C0251c.C0654a;
import com.google.android.gms.drive.realtime.internal.C0252d.C0656a;
import com.google.android.gms.drive.realtime.internal.C0253e.C0658a;
import com.google.android.gms.drive.realtime.internal.C0264f.C0660a;
import com.google.android.gms.drive.realtime.internal.C0265g.C0662a;
import com.google.android.gms.drive.realtime.internal.C0266h.C0664a;
import com.google.android.gms.drive.realtime.internal.C0267i.C0666a;
import com.google.android.gms.drive.realtime.internal.C0268j.C0668a;
import com.google.android.gms.drive.realtime.internal.C0269k.C0670a;
import com.google.android.gms.drive.realtime.internal.C0270l.C0672a;
import com.google.android.gms.drive.realtime.internal.C0272n.C0676a;
import com.google.android.gms.drive.realtime.internal.C0273o.C0678a;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.m */
public interface C0271m extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.m.a */
    public static abstract class C0674a extends Binder implements C0271m {

        /* renamed from: com.google.android.gms.drive.realtime.internal.m.a.a */
        private static class C0673a implements C0271m {
            private IBinder kq;

            C0673a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void m2112a(int i, C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2113a(BeginCompoundOperationRequest beginCompoundOperationRequest, C0273o c0273o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0273o != null ? c0273o.asBinder() : null);
                    this.kq.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2114a(EndCompoundOperationRequest endCompoundOperationRequest, C0273o c0273o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0273o != null ? c0273o.asBinder() : null);
                    this.kq.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2115a(ParcelableIndexReference parcelableIndexReference, C0272n c0272n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0272n != null ? c0272n.asBinder() : null);
                    this.kq.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2116a(C0251c c0251c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0251c != null ? c0251c.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2117a(C0252d c0252d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    this.kq.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2118a(C0253e c0253e) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0253e != null ? c0253e.asBinder() : null);
                    this.kq.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2119a(C0266h c0266h) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0266h != null ? c0266h.asBinder() : null);
                    this.kq.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2120a(C0267i c0267i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0267i != null ? c0267i.asBinder() : null);
                    this.kq.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2121a(C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2122a(C0270l c0270l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0270l != null ? c0270l.asBinder() : null);
                    this.kq.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2123a(C0273o c0273o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0273o != null ? c0273o.asBinder() : null);
                    this.kq.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2124a(String str, int i, int i2, C0265g c0265g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0265g != null ? c0265g.asBinder() : null);
                    this.kq.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2125a(String str, int i, int i2, C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2126a(String str, int i, DataHolder dataHolder, C0265g c0265g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0265g != null ? c0265g.asBinder() : null);
                    this.kq.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2127a(String str, int i, DataHolder dataHolder, C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2128a(String str, int i, C0273o c0273o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c0273o != null ? c0273o.asBinder() : null);
                    this.kq.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2129a(String str, int i, String str2, int i2, C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2130a(String str, int i, String str2, C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2131a(String str, DataHolder dataHolder, C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2132a(String str, C0264f c0264f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0264f != null ? c0264f.asBinder() : null);
                    this.kq.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2133a(String str, C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2134a(String str, C0269k c0269k) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0269k != null ? c0269k.asBinder() : null);
                    this.kq.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2135a(String str, C0270l c0270l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0270l != null ? c0270l.asBinder() : null);
                    this.kq.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2136a(String str, C0272n c0272n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0272n != null ? c0272n.asBinder() : null);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2137a(String str, C0273o c0273o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0273o != null ? c0273o.asBinder() : null);
                    this.kq.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2138a(String str, String str2, C0264f c0264f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0264f != null ? c0264f.asBinder() : null);
                    this.kq.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2139a(String str, String str2, C0265g c0265g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0265g != null ? c0265g.asBinder() : null);
                    this.kq.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2140a(String str, String str2, C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
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

            public void m2141b(C0251c c0251c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0251c != null ? c0251c.asBinder() : null);
                    this.kq.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2142b(C0268j c0268j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0268j != null ? c0268j.asBinder() : null);
                    this.kq.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2143b(C0273o c0273o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0273o != null ? c0273o.asBinder() : null);
                    this.kq.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2144b(String str, C0264f c0264f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0264f != null ? c0264f.asBinder() : null);
                    this.kq.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2145b(String str, C0270l c0270l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0270l != null ? c0270l.asBinder() : null);
                    this.kq.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2146b(String str, C0272n c0272n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0272n != null ? c0272n.asBinder() : null);
                    this.kq.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2147b(String str, C0273o c0273o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0273o != null ? c0273o.asBinder() : null);
                    this.kq.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2148c(C0251c c0251c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0251c != null ? c0251c.asBinder() : null);
                    this.kq.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2149c(String str, C0270l c0270l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0270l != null ? c0270l.asBinder() : null);
                    this.kq.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2150d(C0251c c0251c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0251c != null ? c0251c.asBinder() : null);
                    this.kq.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0271m ac(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0271m)) ? new C0673a(iBinder) : (C0271m) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelableIndexReference parcelableIndexReference = null;
            String readString;
            DataHolder x;
            int readInt;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m437a(data.readString(), C0676a.ad(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m417a(C0654a.m2089S(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m424a(C0678a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m439a(data.readString(), data.readString(), C0660a.m2098V(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m436a(data.readString(), C0672a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    m432a(readString, x, C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m434a(data.readString(), C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m446b(data.readString(), C0672a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m447b(data.readString(), C0676a.ad(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m431a(data.readString(), data.readInt(), data.readString(), C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m426a(data.readString(), data.readInt(), data.readInt(), C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m441a(data.readString(), data.readString(), C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m445b(data.readString(), C0660a.m2098V(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m450c(data.readString(), C0672a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    m428a(readString, readInt, x, C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        x = DataHolder.CREATOR.m166x(data);
                    }
                    m427a(readString, readInt, x, C0662a.m2101W(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m425a(data.readString(), data.readInt(), data.readInt(), C0662a.m2101W(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    BeginCompoundOperationRequest beginCompoundOperationRequest;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        beginCompoundOperationRequest = (BeginCompoundOperationRequest) BeginCompoundOperationRequest.CREATOR.createFromParcel(data);
                    }
                    m414a(beginCompoundOperationRequest, C0678a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    EndCompoundOperationRequest endCompoundOperationRequest;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        endCompoundOperationRequest = (EndCompoundOperationRequest) EndCompoundOperationRequest.CREATOR.createFromParcel(data);
                    }
                    m415a(endCompoundOperationRequest, C0678a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m433a(data.readString(), C0660a.m2098V(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m440a(data.readString(), data.readString(), C0662a.m2101W(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m422a(C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m443b(C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m449c(C0654a.m2089S(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m451d(C0654a.m2089S(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        parcelableIndexReference = (ParcelableIndexReference) ParcelableIndexReference.CREATOR.createFromParcel(data);
                    }
                    m416a(parcelableIndexReference, C0676a.ad(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m435a(data.readString(), C0670a.aa(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m429a(data.readString(), data.readInt(), C0678a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m423a(C0672a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m413a(data.readInt(), C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m419a(C0658a.m2095U(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m418a(C0656a.m2092T(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m442b(C0654a.m2089S(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m421a(C0666a.m2105Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m444b(C0678a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 36:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m420a(C0664a.m2103X(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m430a(data.readString(), data.readInt(), data.readString(), data.readInt(), C0668a.m2108Z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 38:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m438a(data.readString(), C0678a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 39:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    m448b(data.readString(), C0678a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m413a(int i, C0268j c0268j) throws RemoteException;

    void m414a(BeginCompoundOperationRequest beginCompoundOperationRequest, C0273o c0273o) throws RemoteException;

    void m415a(EndCompoundOperationRequest endCompoundOperationRequest, C0273o c0273o) throws RemoteException;

    void m416a(ParcelableIndexReference parcelableIndexReference, C0272n c0272n) throws RemoteException;

    void m417a(C0251c c0251c) throws RemoteException;

    void m418a(C0252d c0252d) throws RemoteException;

    void m419a(C0253e c0253e) throws RemoteException;

    void m420a(C0266h c0266h) throws RemoteException;

    void m421a(C0267i c0267i) throws RemoteException;

    void m422a(C0268j c0268j) throws RemoteException;

    void m423a(C0270l c0270l) throws RemoteException;

    void m424a(C0273o c0273o) throws RemoteException;

    void m425a(String str, int i, int i2, C0265g c0265g) throws RemoteException;

    void m426a(String str, int i, int i2, C0268j c0268j) throws RemoteException;

    void m427a(String str, int i, DataHolder dataHolder, C0265g c0265g) throws RemoteException;

    void m428a(String str, int i, DataHolder dataHolder, C0268j c0268j) throws RemoteException;

    void m429a(String str, int i, C0273o c0273o) throws RemoteException;

    void m430a(String str, int i, String str2, int i2, C0268j c0268j) throws RemoteException;

    void m431a(String str, int i, String str2, C0268j c0268j) throws RemoteException;

    void m432a(String str, DataHolder dataHolder, C0268j c0268j) throws RemoteException;

    void m433a(String str, C0264f c0264f) throws RemoteException;

    void m434a(String str, C0268j c0268j) throws RemoteException;

    void m435a(String str, C0269k c0269k) throws RemoteException;

    void m436a(String str, C0270l c0270l) throws RemoteException;

    void m437a(String str, C0272n c0272n) throws RemoteException;

    void m438a(String str, C0273o c0273o) throws RemoteException;

    void m439a(String str, String str2, C0264f c0264f) throws RemoteException;

    void m440a(String str, String str2, C0265g c0265g) throws RemoteException;

    void m441a(String str, String str2, C0268j c0268j) throws RemoteException;

    void m442b(C0251c c0251c) throws RemoteException;

    void m443b(C0268j c0268j) throws RemoteException;

    void m444b(C0273o c0273o) throws RemoteException;

    void m445b(String str, C0264f c0264f) throws RemoteException;

    void m446b(String str, C0270l c0270l) throws RemoteException;

    void m447b(String str, C0272n c0272n) throws RemoteException;

    void m448b(String str, C0273o c0273o) throws RemoteException;

    void m449c(C0251c c0251c) throws RemoteException;

    void m450c(String str, C0270l c0270l) throws RemoteException;

    void m451d(C0251c c0251c) throws RemoteException;
}
