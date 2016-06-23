package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0278a;
import com.google.android.gms.dynamic.C0281f;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.C0431t;
import com.google.android.gms.maps.internal.C0432u;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapFragment extends Fragment {
    private final C0835b ZC;
    private GoogleMap ZD;

    /* renamed from: com.google.android.gms.maps.MapFragment.a */
    static class C0834a implements LifecycleDelegate {
        private final Fragment Mj;
        private final IMapFragmentDelegate ZE;

        public C0834a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.ZE = (IMapFragmentDelegate) hm.m1232f(iMapFragmentDelegate);
            this.Mj = (Fragment) hm.m1232f(fragment);
        }

        public IMapFragmentDelegate jy() {
            return this.ZE;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.Mj.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0431t.m1504a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.ZE.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C1057e.m3259e(this.ZE.onCreateView(C1057e.m3260h(inflater), C1057e.m3260h(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.ZE.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.ZE.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.ZE.onInflate(C1057e.m3260h(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.ZE.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.ZE.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.ZE.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.ZE.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment.b */
    static class C0835b extends C0278a<C0834a> {
        private final Fragment Mj;
        protected C0281f<C0834a> ZF;
        private Activity og;

        C0835b(Fragment fragment) {
            this.Mj = fragment;
        }

        private void setActivity(Activity activity) {
            this.og = activity;
            jz();
        }

        protected void m2838a(C0281f<C0834a> c0281f) {
            this.ZF = c0281f;
            jz();
        }

        public void jz() {
            if (this.og != null && this.ZF != null && gH() == null) {
                try {
                    MapsInitializer.initialize(this.og);
                    this.ZF.m468a(new C0834a(this.Mj, C0432u.m1505H(this.og).m1491i(C1057e.m3260h(this.og))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapFragment() {
        this.ZC = new C0835b(this);
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate jy = jy();
        if (jy == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = jy.getMap();
            if (map == null) {
                return null;
            }
            if (this.ZD == null || this.ZD.jp().asBinder() != map.asBinder()) {
                this.ZD = new GoogleMap(map);
            }
            return this.ZD;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    protected IMapFragmentDelegate jy() {
        this.ZC.jz();
        return this.ZC.gH() == null ? null : ((C0834a) this.ZC.gH()).jy();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ZC.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.ZC.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.ZC.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.ZC.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.ZC.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.ZC.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.ZC.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.ZC.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.ZC.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.ZC.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.ZC.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
