package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0433v;
import com.google.android.gms.maps.model.internal.C0451i;
import com.google.android.gms.maps.model.internal.C0451i.C0922a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR;
    private float aax;
    private boolean aay;
    private C0451i abd;
    private TileProvider abe;
    private boolean abf;
    private final int xM;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.1 */
    class C09021 implements TileProvider {
        private final C0451i abg;
        final /* synthetic */ TileOverlayOptions abh;

        C09021(TileOverlayOptions tileOverlayOptions) {
            this.abh = tileOverlayOptions;
            this.abg = this.abh.abd;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.abg.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.2 */
    class C11602 extends C0922a {
        final /* synthetic */ TileOverlayOptions abh;
        final /* synthetic */ TileProvider abi;

        C11602(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
            this.abh = tileOverlayOptions;
            this.abi = tileProvider;
        }

        public Tile getTile(int x, int y, int zoom) {
            return this.abi.getTile(x, y, zoom);
        }
    }

    static {
        CREATOR = new TileOverlayOptionsCreator();
    }

    public TileOverlayOptions() {
        this.aay = true;
        this.abf = true;
        this.xM = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.aay = true;
        this.abf = true;
        this.xM = versionCode;
        this.abd = C0922a.bg(delegate);
        this.abe = this.abd == null ? null : new C09021(this);
        this.aay = visible;
        this.aax = zIndex;
        this.abf = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.abf = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.abf;
    }

    public TileProvider getTileProvider() {
        return this.abe;
    }

    int getVersionCode() {
        return this.xM;
    }

    public float getZIndex() {
        return this.aax;
    }

    public boolean isVisible() {
        return this.aay;
    }

    IBinder jQ() {
        return this.abd.asBinder();
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.abe = tileProvider;
        this.abd = this.abe == null ? null : new C11602(this, tileProvider);
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.aay = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0433v.jL()) {
            C0452j.m1548a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m1525a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.aax = zIndex;
        return this;
    }
}
