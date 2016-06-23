package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0128R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0278a;
import com.google.android.gms.dynamic.C0281f;
import com.google.android.gms.dynamic.C1056b;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.lk;
import com.google.android.gms.internal.ll.C0811a;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private final Fragment Mj;
    private WalletFragmentOptions akk;
    private WalletFragmentInitParams akl;
    private MaskedWalletRequest akm;
    private MaskedWallet akn;
    private Boolean ako;
    private C0989b akt;
    private final C1056b aku;
    private final C0990c akv;
    private C1171a akw;
    private boolean mCreated;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.b */
    private static class C0989b implements LifecycleDelegate {
        private final lk akr;

        private C0989b(lk lkVar) {
            this.akr = lkVar;
        }

        private int getState() {
            try {
                return this.akr.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.akr.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.akr.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.akr.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.akr.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.akr.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.akr.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C1057e.m3259e(this.akr.onCreateView(C1057e.m3260h(inflater), C1057e.m3260h(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.akr.m1342a(C1057e.m3260h(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.akr.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.akr.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.akr.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.akr.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.akr.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.c */
    private class C0990c extends C0278a<C0989b> implements OnClickListener {
        final /* synthetic */ WalletFragment akz;

        private C0990c(WalletFragment walletFragment) {
            this.akz = walletFragment;
        }

        protected void m3101a(FrameLayout frameLayout) {
            View button = new Button(this.akz.Mj.getActivity());
            button.setText(C0128R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.akz.akk != null) {
                WalletFragmentStyle fragmentStyle = this.akz.akk.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.akz.Mj.getResources().getDisplayMetrics();
                    i = fragmentStyle.m3120a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.m3120a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void m3102a(C0281f<C0989b> c0281f) {
            Activity activity = this.akz.Mj.getActivity();
            if (this.akz.akt == null && this.akz.mCreated && activity != null) {
                try {
                    this.akz.akt = new C0989b(null);
                    this.akz.akk = null;
                    c0281f.m468a(this.akz.akt);
                    if (this.akz.akl != null) {
                        this.akz.akt.initialize(this.akz.akl);
                        this.akz.akl = null;
                    }
                    if (this.akz.akm != null) {
                        this.akz.akt.updateMaskedWalletRequest(this.akz.akm);
                        this.akz.akm = null;
                    }
                    if (this.akz.akn != null) {
                        this.akz.akt.updateMaskedWallet(this.akz.akn);
                        this.akz.akn = null;
                    }
                    if (this.akz.ako != null) {
                        this.akz.akt.setEnabled(this.akz.ako.booleanValue());
                        this.akz.ako = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = this.akz.Mj.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.a */
    static class C1171a extends C0811a {
        private OnStateChangedListener akx;
        private final WalletFragment aky;

        C1171a(WalletFragment walletFragment) {
            this.aky = walletFragment;
        }

        public void m3854a(int i, int i2, Bundle bundle) {
            if (this.akx != null) {
                this.akx.onStateChanged(this.aky, i, i2, bundle);
            }
        }

        public void m3855a(OnStateChangedListener onStateChangedListener) {
            this.akx = onStateChangedListener;
        }
    }

    public WalletFragment() {
        this.mCreated = false;
        this.aku = C1056b.m3256a(this);
        this.akv = new C0990c();
        this.akw = new C1171a(this);
        this.Mj = this;
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.Mj.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.akt != null ? this.akt.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.akt != null) {
            this.akt.initialize(initParams);
            this.akl = null;
        } else if (this.akl == null) {
            this.akl = initParams;
            if (this.akm != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.akn != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.akt != null) {
            this.akt.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.akl != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.akl = walletFragmentInitParams;
            }
            if (this.akm == null) {
                this.akm = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.akn == null) {
                this.akn = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.akk = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.ako = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.Mj.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.Mj.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.m3115Q(this.Mj.getActivity());
                this.akk = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.akv.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.akv.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.akk == null) {
            this.akk = WalletFragmentOptions.m3111a((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.akk);
        this.akv.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.akv.onPause();
    }

    public void onResume() {
        super.onResume();
        this.akv.onResume();
        FragmentManager fragmentManager = this.Mj.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Mj.getActivity()), this.Mj.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.akv.onSaveInstanceState(outState);
        if (this.akl != null) {
            outState.putParcelable("walletFragmentInitParams", this.akl);
            this.akl = null;
        }
        if (this.akm != null) {
            outState.putParcelable("maskedWalletRequest", this.akm);
            this.akm = null;
        }
        if (this.akn != null) {
            outState.putParcelable("maskedWallet", this.akn);
            this.akn = null;
        }
        if (this.akk != null) {
            outState.putParcelable("walletFragmentOptions", this.akk);
            this.akk = null;
        }
        if (this.ako != null) {
            outState.putBoolean("enabled", this.ako.booleanValue());
            this.ako = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.akv.onStart();
    }

    public void onStop() {
        super.onStop();
        this.akv.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.akt != null) {
            this.akt.setEnabled(enabled);
            this.ako = null;
            return;
        }
        this.ako = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.akw.m3855a(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.akt != null) {
            this.akt.updateMaskedWallet(maskedWallet);
            this.akn = null;
            return;
        }
        this.akn = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.akt != null) {
            this.akt.updateMaskedWalletRequest(request);
            this.akm = null;
            return;
        }
        this.akm = request;
    }
}
