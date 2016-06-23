package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.C0636a;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChange> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m750a(SnapshotMetadataChange snapshotMetadataChange, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, snapshotMetadataChange.getDescription(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotMetadataChange.getVersionCode());
        C0200b.m246a(parcel, 2, snapshotMetadataChange.getPlayedTimeMillis(), false);
        C0200b.m243a(parcel, 4, snapshotMetadataChange.getCoverImageUri(), i, false);
        C0200b.m243a(parcel, 5, snapshotMetadataChange.iN(), i, false);
        C0200b.m235G(parcel, C);
    }

    public SnapshotMetadataChange createFromParcel(Parcel parcel) {
        Uri uri = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        C0636a c0636a = null;
        Long l = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    l = C0199a.m215j(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    c0636a = (C0636a) C0199a.m201a(parcel, A, C0636a.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new SnapshotMetadataChange(i, str, l, c0636a, uri);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotMetadataChange[] newArray(int size) {
        return new SnapshotMetadataChange[size];
    }
}
