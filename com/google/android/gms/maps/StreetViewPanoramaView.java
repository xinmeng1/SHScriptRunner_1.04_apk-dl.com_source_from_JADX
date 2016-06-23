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
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView extends FrameLayout {
    private StreetViewPanorama ZT;
    private final C0840a aac;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.a */
    static class C0840a extends C0278a<C0841b> {
        protected C0281f<C0841b> ZF;
        private final ViewGroup ZK;
        private final StreetViewPanoramaOptions aad;
        private final Context mContext;

        C0840a(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.ZK = viewGroup;
            this.mContext = context;
            this.aad = streetViewPanoramaOptions;
        }

        protected void m2842a(C0281f<C0841b> c0281f) {
            this.ZF = c0281f;
            jz();
        }

        public void jz() {
            if (this.ZF != null && gH() == null) {
                try {
                    this.ZF.m468a(new C0841b(this.ZK, C0432u.m1505H(this.mContext).m1488a(C1057e.m3260h(this.mContext), this.aad)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.b */
    static class C0841b implements LifecycleDelegate {
        private final ViewGroup ZH;
        private final IStreetViewPanoramaViewDelegate aae;
        private View aaf;

        public C0841b(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.aae = (IStreetViewPanoramaViewDelegate) hm.m1232f(iStreetViewPanoramaViewDelegate);
            this.ZH = (ViewGroup) hm.m1232f(viewGroup);
        }

        public IStreetViewPanoramaViewDelegate jG() {
            return this.aae;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.aae.onCreate(savedInstanceState);
                this.aaf = (View) C1057e.m3259e(this.aae.getView());
                this.ZH.removeAllViews();
                this.ZH.addView(this.aaf);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.aae.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.aae.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.aae.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.aae.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.aae.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.aac = new C0840a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.aac = new C0840a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.aac = new C0840a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions options) {
        super(context);
        this.aac = new C0840a(this, context, options);
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.ZT != null) {
            return this.ZT;
        }
        this.aac.jz();
        if (this.aac.gH() == null) {
            return null;
        }
        try {
            this.ZT = new StreetViewPanorama(((C0841b) this.aac.gH()).jG().getStreetViewPanorama());
            return this.ZT;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.aac.onCreate(savedInstanceState);
        if (this.aac.gH() == null) {
            C0840a c0840a = this.aac;
            C0278a.m463b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.aac.onDestroy();
    }

    public final void onLowMemory() {
        this.aac.onLowMemory();
    }

    public final void onPause() {
        this.aac.onPause();
    }

    public final void onResume() {
        this.aac.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.aac.onSaveInstanceState(outState);
    }
}
