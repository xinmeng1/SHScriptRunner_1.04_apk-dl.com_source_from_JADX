package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0278a;
import com.google.android.gms.dynamic.C0281f;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.C0432u;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
    private GoogleMap ZD;
    private final C0837b ZG;

    /* renamed from: com.google.android.gms.maps.MapView.a */
    static class C0836a implements LifecycleDelegate {
        private final ViewGroup ZH;
        private final IMapViewDelegate ZI;
        private View ZJ;

        public C0836a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.ZI = (IMapViewDelegate) hm.m1232f(iMapViewDelegate);
            this.ZH = (ViewGroup) hm.m1232f(viewGroup);
        }

        public IMapViewDelegate jA() {
            return this.ZI;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.ZI.onCreate(savedInstanceState);
                this.ZJ = (View) C1057e.m3259e(this.ZI.getView());
                this.ZH.removeAllViews();
                this.ZH.addView(this.ZJ);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.ZI.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.ZI.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.ZI.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.ZI.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.ZI.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView.b */
    static class C0837b extends C0278a<C0836a> {
        protected C0281f<C0836a> ZF;
        private final ViewGroup ZK;
        private final GoogleMapOptions ZL;
        private final Context mContext;

        C0837b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.ZK = viewGroup;
            this.mContext = context;
            this.ZL = googleMapOptions;
        }

        protected void m2839a(C0281f<C0836a> c0281f) {
            this.ZF = c0281f;
            jz();
        }

        public void jz() {
            if (this.ZF != null && gH() == null) {
                try {
                    this.ZF.m468a(new C0836a(this.ZK, C0432u.m1505H(this.mContext).m1487a(C1057e.m3260h(this.mContext), this.ZL)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.ZG = new C0837b(this, context, null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ZG = new C0837b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.ZG = new C0837b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.ZG = new C0837b(this, context, options);
    }

    public final GoogleMap getMap() {
        if (this.ZD != null) {
            return this.ZD;
        }
        this.ZG.jz();
        if (this.ZG.gH() == null) {
            return null;
        }
        try {
            this.ZD = new GoogleMap(((C0836a) this.ZG.gH()).jA().getMap());
            return this.ZD;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.ZG.onCreate(savedInstanceState);
        if (this.ZG.gH() == null) {
            C0837b c0837b = this.ZG;
            C0278a.m463b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.ZG.onDestroy();
    }

    public final void onLowMemory() {
        this.ZG.onLowMemory();
    }

    public final void onPause() {
        this.ZG.onPause();
    }

    public final void onResume() {
        this.ZG.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.ZG.onSaveInstanceState(outState);
    }
}
