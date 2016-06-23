package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0278a<T extends LifecycleDelegate> {
    private T LX;
    private Bundle LY;
    private LinkedList<C0277a> LZ;
    private final C0281f<T> Ma;

    /* renamed from: com.google.android.gms.dynamic.a.5 */
    static class C02765 implements OnClickListener {
        final /* synthetic */ int Mi;
        final /* synthetic */ Context qu;

        C02765(Context context, int i) {
            this.qu = context;
            this.Mi = i;
        }

        public void onClick(View v) {
            this.qu.startActivity(GooglePlayServicesUtil.m136c(this.qu, this.Mi));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.a */
    private interface C0277a {
        void m457b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: com.google.android.gms.dynamic.a.1 */
    class C06791 implements C0281f<T> {
        final /* synthetic */ C0278a Mb;

        C06791(C0278a c0278a) {
            this.Mb = c0278a;
        }

        public void m2153a(T t) {
            this.Mb.LX = t;
            Iterator it = this.Mb.LZ.iterator();
            while (it.hasNext()) {
                ((C0277a) it.next()).m457b(this.Mb.LX);
            }
            this.Mb.LZ.clear();
            this.Mb.LY = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.2 */
    class C06802 implements C0277a {
        final /* synthetic */ C0278a Mb;
        final /* synthetic */ Activity Mc;
        final /* synthetic */ Bundle Md;
        final /* synthetic */ Bundle Me;

        C06802(C0278a c0278a, Activity activity, Bundle bundle, Bundle bundle2) {
            this.Mb = c0278a;
            this.Mc = activity;
            this.Md = bundle;
            this.Me = bundle2;
        }

        public void m2154b(LifecycleDelegate lifecycleDelegate) {
            this.Mb.LX.onInflate(this.Mc, this.Md, this.Me);
        }

        public int getState() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.3 */
    class C06813 implements C0277a {
        final /* synthetic */ C0278a Mb;
        final /* synthetic */ Bundle Me;

        C06813(C0278a c0278a, Bundle bundle) {
            this.Mb = c0278a;
            this.Me = bundle;
        }

        public void m2155b(LifecycleDelegate lifecycleDelegate) {
            this.Mb.LX.onCreate(this.Me);
        }

        public int getState() {
            return 1;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.4 */
    class C06824 implements C0277a {
        final /* synthetic */ C0278a Mb;
        final /* synthetic */ Bundle Me;
        final /* synthetic */ FrameLayout Mf;
        final /* synthetic */ LayoutInflater Mg;
        final /* synthetic */ ViewGroup Mh;

        C06824(C0278a c0278a, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Mb = c0278a;
            this.Mf = frameLayout;
            this.Mg = layoutInflater;
            this.Mh = viewGroup;
            this.Me = bundle;
        }

        public void m2156b(LifecycleDelegate lifecycleDelegate) {
            this.Mf.removeAllViews();
            this.Mf.addView(this.Mb.LX.onCreateView(this.Mg, this.Mh, this.Me));
        }

        public int getState() {
            return 2;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.6 */
    class C06836 implements C0277a {
        final /* synthetic */ C0278a Mb;

        C06836(C0278a c0278a) {
            this.Mb = c0278a;
        }

        public void m2157b(LifecycleDelegate lifecycleDelegate) {
            this.Mb.LX.onStart();
        }

        public int getState() {
            return 4;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.7 */
    class C06847 implements C0277a {
        final /* synthetic */ C0278a Mb;

        C06847(C0278a c0278a) {
            this.Mb = c0278a;
        }

        public void m2158b(LifecycleDelegate lifecycleDelegate) {
            this.Mb.LX.onResume();
        }

        public int getState() {
            return 5;
        }
    }

    public C0278a() {
        this.Ma = new C06791(this);
    }

    private void m461a(Bundle bundle, C0277a c0277a) {
        if (this.LX != null) {
            c0277a.m457b(this.LX);
            return;
        }
        if (this.LZ == null) {
            this.LZ = new LinkedList();
        }
        this.LZ.add(c0277a);
        if (bundle != null) {
            if (this.LY == null) {
                this.LY = (Bundle) bundle.clone();
            } else {
                this.LY.putAll(bundle);
            }
        }
        m465a(this.Ma);
    }

    public static void m463b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence d = GooglePlayServicesUtil.m138d(context, isGooglePlayServicesAvailable);
        CharSequence e = GooglePlayServicesUtil.m139e(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(d);
        linearLayout.addView(textView);
        if (e != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(e);
            linearLayout.addView(button);
            button.setOnClickListener(new C02765(context, isGooglePlayServicesAvailable));
        }
    }

    private void ca(int i) {
        while (!this.LZ.isEmpty() && ((C0277a) this.LZ.getLast()).getState() >= i) {
            this.LZ.removeLast();
        }
    }

    protected void m464a(FrameLayout frameLayout) {
        C0278a.m463b(frameLayout);
    }

    protected abstract void m465a(C0281f<T> c0281f);

    public T gH() {
        return this.LX;
    }

    public void onCreate(Bundle savedInstanceState) {
        m461a(savedInstanceState, new C06813(this, savedInstanceState));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        m461a(savedInstanceState, new C06824(this, frameLayout, inflater, container, savedInstanceState));
        if (this.LX == null) {
            m464a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.LX != null) {
            this.LX.onDestroy();
        } else {
            ca(1);
        }
    }

    public void onDestroyView() {
        if (this.LX != null) {
            this.LX.onDestroyView();
        } else {
            ca(2);
        }
    }

    public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
        m461a(savedInstanceState, new C06802(this, activity, attrs, savedInstanceState));
    }

    public void onLowMemory() {
        if (this.LX != null) {
            this.LX.onLowMemory();
        }
    }

    public void onPause() {
        if (this.LX != null) {
            this.LX.onPause();
        } else {
            ca(5);
        }
    }

    public void onResume() {
        m461a(null, new C06847(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.LX != null) {
            this.LX.onSaveInstanceState(outState);
        } else if (this.LY != null) {
            outState.putAll(this.LY);
        }
    }

    public void onStart() {
        m461a(null, new C06836(this));
    }

    public void onStop() {
        if (this.LX != null) {
            this.LX.onStop();
        } else {
            ca(4);
        }
    }
}
