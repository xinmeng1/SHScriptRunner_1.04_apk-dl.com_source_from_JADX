package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public interface gm extends IInterface {

    /* renamed from: com.google.android.gms.internal.gm.a */
    public static abstract class C0770a extends Binder implements gm {
        public C0770a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            gj gjVar = null;
            switch (code) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m1124T(data.readInt());
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    ApplicationMetadata applicationMetadata;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        applicationMetadata = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data);
                    }
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m1128a(applicationMetadata, readString, readString2, z);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m1125U(data.readInt());
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m1129a(readString3, readDouble, z);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m1135g(data.readString(), data.readString());
                    return true;
                case Quest.STATE_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m1134b(data.readString(), data.createByteArray());
                    return true;
                case DetectedActivity.WALKING /*7*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m1127W(data.readInt());
                    return true;
                case DetectedActivity.RUNNING /*8*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m1126V(data.readInt());
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m1131a(data.readString(), data.readLong(), data.readInt());
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m1130a(data.readString(), data.readLong());
                    return true;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    ge geVar;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        geVar = (ge) ge.CREATOR.createFromParcel(data);
                    }
                    m1132b(geVar);
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        gjVar = (gj) gj.CREATOR.createFromParcel(data);
                    }
                    m1133b(gjVar);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1124T(int i) throws RemoteException;

    void m1125U(int i) throws RemoteException;

    void m1126V(int i) throws RemoteException;

    void m1127W(int i) throws RemoteException;

    void m1128a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void m1129a(String str, double d, boolean z) throws RemoteException;

    void m1130a(String str, long j) throws RemoteException;

    void m1131a(String str, long j, int i) throws RemoteException;

    void m1132b(ge geVar) throws RemoteException;

    void m1133b(gj gjVar) throws RemoteException;

    void m1134b(String str, byte[] bArr) throws RemoteException;

    void m1135g(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;
}
