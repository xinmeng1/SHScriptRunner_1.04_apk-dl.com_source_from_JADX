package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.C0427p.C0895a;
import com.google.android.gms.maps.internal.C0428q.C0897a;
import com.google.android.gms.maps.internal.C0429r.C0899a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate ZN;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanorama.1 */
    class C11571 extends C0897a {
        final /* synthetic */ OnStreetViewPanoramaChangeListener ZO;
        final /* synthetic */ StreetViewPanorama ZP;

        C11571(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
            this.ZP = streetViewPanorama;
            this.ZO = onStreetViewPanoramaChangeListener;
        }

        public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) {
            this.ZO.onStreetViewPanoramaChange(location);
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanorama.2 */
    class C11582 extends C0895a {
        final /* synthetic */ StreetViewPanorama ZP;
        final /* synthetic */ OnStreetViewPanoramaCameraChangeListener ZQ;

        C11582(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
            this.ZP = streetViewPanorama;
            this.ZQ = onStreetViewPanoramaCameraChangeListener;
        }

        public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera camera) {
            this.ZQ.onStreetViewPanoramaCameraChange(camera);
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanorama.3 */
    class C11593 extends C0899a {
        final /* synthetic */ StreetViewPanorama ZP;
        final /* synthetic */ OnStreetViewPanoramaClickListener ZR;

        C11593(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
            this.ZP = streetViewPanorama;
            this.ZR = onStreetViewPanoramaClickListener;
        }

        public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation orientation) {
            this.ZR.onStreetViewPanoramaClick(orientation);
        }
    }

    protected StreetViewPanorama(IStreetViewPanoramaDelegate sv) {
        this.ZN = (IStreetViewPanoramaDelegate) hm.m1232f(sv);
    }

    public void animateTo(StreetViewPanoramaCamera camera, long duration) {
        try {
            this.ZN.animateTo(camera, duration);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.ZN.getStreetViewPanoramaLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.ZN.getPanoramaCamera();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.ZN.isPanningGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.ZN.isStreetNamesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.ZN.isUserNavigationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.ZN.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IStreetViewPanoramaDelegate jB() {
        return this.ZN;
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation orientation) {
        try {
            return (Point) C1057e.m3259e(this.ZN.orientationToPoint(orientation));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.ZN.pointToOrientation(C1057e.m3260h(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.ZN.setOnStreetViewPanoramaCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.ZN.setOnStreetViewPanoramaCameraChangeListener(new C11582(this, listener));
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener listener) {
        if (listener == null) {
            try {
                this.ZN.setOnStreetViewPanoramaChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.ZN.setOnStreetViewPanoramaChangeListener(new C11571(this, listener));
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener listener) {
        if (listener == null) {
            try {
                this.ZN.setOnStreetViewPanoramaClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.ZN.setOnStreetViewPanoramaClickListener(new C11593(this, listener));
    }

    public void setPanningGesturesEnabled(boolean enablePanning) {
        try {
            this.ZN.enablePanning(enablePanning);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position) {
        try {
            this.ZN.setPosition(position);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position, int radius) {
        try {
            this.ZN.setPositionWithRadius(position, radius);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(String panoId) {
        try {
            this.ZN.setPositionWithID(panoId);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStreetNamesEnabled(boolean enableStreetNames) {
        try {
            this.ZN.enableStreetNames(enableStreetNames);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setUserNavigationEnabled(boolean enableUserNavigation) {
        try {
            this.ZN.enableUserNavigation(enableUserNavigation);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean enableZoom) {
        try {
            this.ZN.enableZoom(enableZoom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
