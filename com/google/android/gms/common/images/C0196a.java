package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gw.C0371a;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public abstract class C0196a {
    final C0195a Fm;
    protected int Fn;
    protected int Fo;
    private boolean Fp;
    private boolean Fq;
    protected int Fr;

    /* renamed from: com.google.android.gms.common.images.a.a */
    static final class C0195a {
        public final Uri uri;

        public C0195a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0195a) {
                return this == obj ? true : hk.equal(((C0195a) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return hk.hashCode(this.uri);
        }
    }

    /* renamed from: com.google.android.gms.common.images.a.b */
    public static final class C0639b extends C0196a {
        private WeakReference<ImageView> Fs;

        public C0639b(ImageView imageView, int i) {
            super(null, i);
            gx.m1160c(imageView);
            this.Fs = new WeakReference(imageView);
        }

        public C0639b(ImageView imageView, Uri uri) {
            super(uri, 0);
            gx.m1160c(imageView);
            this.Fs = new WeakReference(imageView);
        }

        private void m2024a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof gv)) {
                int fi = ((gv) imageView).fi();
                if (this.Fo != 0 && fi == this.Fo) {
                    return;
                }
            }
            boolean b = m191b(z, z2);
            Drawable a = b ? m186a(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(a);
            if (imageView instanceof gv) {
                gv gvVar = (gv) imageView;
                gvVar.m1157g(z3 ? this.Fm.uri : null);
                gvVar.al(obj != null ? this.Fo : 0);
            }
            if (b) {
                ((gt) a).startTransition(250);
            }
        }

        protected void m2025a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.Fs.get();
            if (imageView != null) {
                m2024a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0639b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.Fs.get();
            ImageView imageView2 = (ImageView) ((C0639b) obj).Fs.get();
            boolean z = (imageView2 == null || imageView == null || !hk.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.common.images.a.c */
    public static final class C0640c extends C0196a {
        private WeakReference<OnImageLoadedListener> Ft;

        public C0640c(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            gx.m1160c(onImageLoadedListener);
            this.Ft = new WeakReference(onImageLoadedListener);
        }

        protected void m2026a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ft.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.Fm.uri, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0640c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0640c c0640c = (C0640c) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ft.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) c0640c.Ft.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && hk.equal(onImageLoadedListener2, onImageLoadedListener) && hk.equal(c0640c.Fm, this.Fm);
            return z;
        }

        public int hashCode() {
            return hk.hashCode(this.Fm);
        }
    }

    public C0196a(Uri uri, int i) {
        this.Fn = 0;
        this.Fo = 0;
        this.Fp = true;
        this.Fq = false;
        this.Fm = new C0195a(uri);
        this.Fo = i;
    }

    private Drawable m184a(Context context, gw gwVar, int i) {
        Resources resources = context.getResources();
        if (this.Fr <= 0) {
            return resources.getDrawable(i);
        }
        C0371a c0371a = new C0371a(i, this.Fr);
        Drawable drawable = (Drawable) gwVar.get(c0371a);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.Fr & 1) != 0) {
            drawable = m185a(resources, drawable);
        }
        gwVar.put(c0371a, drawable);
        return drawable;
    }

    protected Drawable m185a(Resources resources, Drawable drawable) {
        return gu.m1155a(resources, drawable);
    }

    protected gt m186a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof gt) {
            drawable = ((gt) drawable).fg();
        }
        return new gt(drawable, drawable2);
    }

    void m187a(Context context, Bitmap bitmap, boolean z) {
        gx.m1160c(bitmap);
        if ((this.Fr & 1) != 0) {
            bitmap = gu.m1153a(bitmap);
        }
        m190a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void m188a(Context context, gw gwVar) {
        Drawable drawable = null;
        if (this.Fn != 0) {
            drawable = m184a(context, gwVar, this.Fn);
        }
        m190a(drawable, false, true, false);
    }

    void m189a(Context context, gw gwVar, boolean z) {
        Drawable drawable = null;
        if (this.Fo != 0) {
            drawable = m184a(context, gwVar, this.Fo);
        }
        m190a(drawable, z, false, false);
    }

    protected abstract void m190a(Drawable drawable, boolean z, boolean z2, boolean z3);

    public void aj(int i) {
        this.Fo = i;
    }

    protected boolean m191b(boolean z, boolean z2) {
        return this.Fp && !z2 && (!z || this.Fq);
    }
}
