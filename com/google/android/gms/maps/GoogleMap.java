package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0280d;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C0413b.C0867a;
import com.google.android.gms.maps.internal.C0415d.C0871a;
import com.google.android.gms.maps.internal.C0416e.C0873a;
import com.google.android.gms.maps.internal.C0417f.C0875a;
import com.google.android.gms.maps.internal.C0418g.C0877a;
import com.google.android.gms.maps.internal.C0419h;
import com.google.android.gms.maps.internal.C0420i.C0881a;
import com.google.android.gms.maps.internal.C0421j.C0883a;
import com.google.android.gms.maps.internal.C0422k.C0885a;
import com.google.android.gms.maps.internal.C0423l.C0887a;
import com.google.android.gms.maps.internal.C0424m.C0889a;
import com.google.android.gms.maps.internal.C0425n.C0891a;
import com.google.android.gms.maps.internal.C0426o.C0893a;
import com.google.android.gms.maps.internal.C0430s.C0901a;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C0851a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C0445c;
import com.google.android.gms.maps.model.internal.C0446d;
import com.google.android.gms.maps.model.internal.C0448f;
import com.google.android.gms.maps.model.internal.C0450h;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate YZ;
    private UiSettings Za;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends C0887a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnMarkerClickListener Zn;

        AnonymousClass10(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.Zc = googleMap;
            this.Zn = onMarkerClickListener;
        }

        public boolean m3778a(C0448f c0448f) {
            return this.Zn.onMarkerClick(new Marker(c0448f));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends C0889a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnMarkerDragListener Zo;

        AnonymousClass11(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.Zc = googleMap;
            this.Zo = onMarkerDragListener;
        }

        public void m3779b(C0448f c0448f) {
            this.Zo.onMarkerDragStart(new Marker(c0448f));
        }

        public void m3780c(C0448f c0448f) {
            this.Zo.onMarkerDragEnd(new Marker(c0448f));
        }

        public void m3781d(C0448f c0448f) {
            this.Zo.onMarkerDrag(new Marker(c0448f));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends C0877a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnInfoWindowClickListener Zp;

        AnonymousClass12(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.Zc = googleMap;
            this.Zp = onInfoWindowClickListener;
        }

        public void m3782e(C0448f c0448f) {
            this.Zp.onInfoWindowClick(new Marker(c0448f));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.13 */
    class AnonymousClass13 extends C0871a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ InfoWindowAdapter Zq;

        AnonymousClass13(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.Zc = googleMap;
            this.Zq = infoWindowAdapter;
        }

        public C0280d m3783f(C0448f c0448f) {
            return C1057e.m3260h(this.Zq.getInfoWindow(new Marker(c0448f)));
        }

        public C0280d m3784g(C0448f c0448f) {
            return C1057e.m3260h(this.Zq.getInfoContents(new Marker(c0448f)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C11471 extends C0875a {
        final /* synthetic */ OnIndoorStateChangeListener Zb;
        final /* synthetic */ GoogleMap Zc;

        C11471(GoogleMap googleMap, OnIndoorStateChangeListener onIndoorStateChangeListener) {
            this.Zc = googleMap;
            this.Zb = onIndoorStateChangeListener;
        }

        public void m3785a(C0446d c0446d) {
            this.Zb.onIndoorLevelActivated(new IndoorBuilding(c0446d));
        }

        public void onIndoorBuildingFocused() {
            this.Zb.onIndoorBuildingFocused();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C11482 extends C0893a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnMyLocationChangeListener Zd;

        C11482(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.Zc = googleMap;
            this.Zd = onMyLocationChangeListener;
        }

        public void m3786f(C0280d c0280d) {
            this.Zd.onMyLocationChange((Location) C1057e.m3259e(c0280d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C11493 extends C0891a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnMyLocationButtonClickListener Ze;

        C11493(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.Zc = googleMap;
            this.Ze = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            return this.Ze.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C11504 extends C0883a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnMapLoadedCallback Zf;

        C11504(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.Zc = googleMap;
            this.Zf = onMapLoadedCallback;
        }

        public void onMapLoaded() throws RemoteException {
            this.Zf.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C11515 extends C0901a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ SnapshotReadyCallback Zg;

        C11515(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.Zc = googleMap;
            this.Zg = snapshotReadyCallback;
        }

        public void m3787g(C0280d c0280d) throws RemoteException {
            this.Zg.onSnapshotReady((Bitmap) C1057e.m3259e(c0280d));
        }

        public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
            this.Zg.onSnapshotReady(snapshot);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C11526 extends C0851a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ LocationSource Zh;

        /* renamed from: com.google.android.gms.maps.GoogleMap.6.1 */
        class C08331 implements OnLocationChangedListener {
            final /* synthetic */ C0419h Zi;
            final /* synthetic */ C11526 Zj;

            C08331(C11526 c11526, C0419h c0419h) {
                this.Zj = c11526;
                this.Zi = c0419h;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.Zi.m1497k(C1057e.m3260h(location));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C11526(GoogleMap googleMap, LocationSource locationSource) {
            this.Zc = googleMap;
            this.Zh = locationSource;
        }

        public void activate(C0419h listener) {
            this.Zh.activate(new C08331(this, listener));
        }

        public void deactivate() {
            this.Zh.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C11537 extends C0873a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnCameraChangeListener Zk;

        C11537(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.Zc = googleMap;
            this.Zk = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition position) {
            this.Zk.onCameraChange(position);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C11548 extends C0881a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnMapClickListener Zl;

        C11548(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.Zc = googleMap;
            this.Zl = onMapClickListener;
        }

        public void onMapClick(LatLng point) {
            this.Zl.onMapClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C11559 extends C0885a {
        final /* synthetic */ GoogleMap Zc;
        final /* synthetic */ OnMapLongClickListener Zm;

        C11559(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.Zc = googleMap;
            this.Zm = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng point) {
            this.Zm.onMapLongClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.a */
    private static final class C1156a extends C0867a {
        private final CancelableCallback Zr;

        C1156a(CancelableCallback cancelableCallback) {
            this.Zr = cancelableCallback;
        }

        public void onCancel() {
            this.Zr.onCancel();
        }

        public void onFinish() {
            this.Zr.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.YZ = (IGoogleMapDelegate) hm.m1232f(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.YZ.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C0445c addGroundOverlay = this.YZ.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C0448f addMarker = this.YZ.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.YZ.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.YZ.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C0450h addTileOverlay = this.YZ.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.YZ.animateCamera(update.jn());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.YZ.animateCameraWithDurationAndCallback(update.jn(), durationMs, callback == null ? null : new C1156a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.YZ.animateCameraWithCallback(update.jn(), callback == null ? null : new C1156a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.YZ.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.YZ.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            C0446d focusedBuilding = this.YZ.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.YZ.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.YZ.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.YZ.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.YZ.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.YZ.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.Za == null) {
                this.Za = new UiSettings(this.YZ.getUiSettings());
            }
            return this.Za;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.YZ.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.YZ.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.YZ.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.YZ.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate jp() {
        return this.YZ;
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.YZ.moveCamera(update.jn());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.YZ.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.YZ.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.YZ.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setInfoWindowAdapter(new AnonymousClass13(this, adapter));
    }

    public final void setLocationSource(LocationSource source) {
        if (source == null) {
            try {
                this.YZ.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setLocationSource(new C11526(this, source));
    }

    public final void setMapType(int type) {
        try {
            this.YZ.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.YZ.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnCameraChangeListener(new C11537(this, listener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnIndoorStateChangeListener(new C11471(this, listener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnInfoWindowClickListener(new AnonymousClass12(this, listener));
    }

    public final void setOnMapClickListener(OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMapClickListener(new C11548(this, listener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.YZ.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMapLoadedCallback(new C11504(this, callback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMapLongClickListener(new C11559(this, listener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMarkerClickListener(new AnonymousClass10(this, listener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMarkerDragListener(new AnonymousClass11(this, listener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMyLocationButtonClickListener(new C11493(this, listener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMyLocationChangeListener(new C11482(this, listener));
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.YZ.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.YZ.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.YZ.snapshot(new C11515(this, callback), (C1057e) (bitmap != null ? C1057e.m3260h(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.YZ.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
