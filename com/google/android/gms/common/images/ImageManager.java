package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0196a.C0195a;
import com.google.android.gms.common.images.C0196a.C0639b;
import com.google.android.gms.common.images.C0196a.C0640c;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hq;
import com.google.android.gms.internal.ip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object EX;
    private static HashSet<Uri> EY;
    private static ImageManager EZ;
    private static ImageManager Fa;
    private final ExecutorService Fb;
    private final C0638b Fc;
    private final gw Fd;
    private final Map<C0196a, ImageReceiver> Fe;
    private final Map<Uri, ImageReceiver> Ff;
    private final Map<Uri, Long> Fg;
    private final Context mContext;
    private final Handler mHandler;

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList<C0196a> Fh;
        final /* synthetic */ ImageManager Fi;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.Fi = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.Fh = new ArrayList();
        }

        public void m168b(C0196a c0196a) {
            gx.ay("ImageReceiver.addImageRequest() must be called in the main thread");
            this.Fh.add(c0196a);
        }

        public void m169c(C0196a c0196a) {
            gx.ay("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.Fh.remove(c0196a);
        }

        public void ff() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.Fi.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.Fi.Fb.execute(new C0191c(this.Fi, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.a */
    private static final class C0190a {
        static int m170a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.c */
    private final class C0191c implements Runnable {
        final /* synthetic */ ImageManager Fi;
        private final ParcelFileDescriptor Fj;
        private final Uri mUri;

        public C0191c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.Fi = imageManager;
            this.mUri = uri;
            this.Fj = parcelFileDescriptor;
        }

        public void run() {
            gx.az("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.Fj != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.Fj.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.Fj.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.Fi.mHandler.post(new C0194f(this.Fi, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.d */
    private final class C0192d implements Runnable {
        final /* synthetic */ ImageManager Fi;
        private final C0196a Fk;

        public C0192d(ImageManager imageManager, C0196a c0196a) {
            this.Fi = imageManager;
            this.Fk = c0196a;
        }

        public void run() {
            gx.ay("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.Fi.Fe.get(this.Fk);
            if (imageReceiver != null) {
                this.Fi.Fe.remove(this.Fk);
                imageReceiver.m169c(this.Fk);
            }
            C0195a c0195a = this.Fk.Fm;
            if (c0195a.uri == null) {
                this.Fk.m189a(this.Fi.mContext, this.Fi.Fd, true);
                return;
            }
            Bitmap a = this.Fi.m173a(c0195a);
            if (a != null) {
                this.Fk.m187a(this.Fi.mContext, a, true);
                return;
            }
            Long l = (Long) this.Fi.Fg.get(c0195a.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.Fk.m189a(this.Fi.mContext, this.Fi.Fd, true);
                    return;
                }
                this.Fi.Fg.remove(c0195a.uri);
            }
            this.Fk.m188a(this.Fi.mContext, this.Fi.Fd);
            imageReceiver = (ImageReceiver) this.Fi.Ff.get(c0195a.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.Fi, c0195a.uri);
                this.Fi.Ff.put(c0195a.uri, imageReceiver);
            }
            imageReceiver.m168b(this.Fk);
            if (!(this.Fk instanceof C0640c)) {
                this.Fi.Fe.put(this.Fk, imageReceiver);
            }
            synchronized (ImageManager.EX) {
                if (!ImageManager.EY.contains(c0195a.uri)) {
                    ImageManager.EY.add(c0195a.uri);
                    imageReceiver.ff();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.e */
    private static final class C0193e implements ComponentCallbacks2 {
        private final C0638b Fc;

        public C0193e(C0638b c0638b) {
            this.Fc = c0638b;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Fc.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Fc.evictAll();
            } else if (level >= 20) {
                this.Fc.trimToSize(this.Fc.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.f */
    private final class C0194f implements Runnable {
        final /* synthetic */ ImageManager Fi;
        private boolean Fl;
        private final CountDownLatch kK;
        private final Bitmap mBitmap;
        private final Uri mUri;

        public C0194f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.Fi = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.Fl = z;
            this.kK = countDownLatch;
        }

        private void m171a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.Fh;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0196a c0196a = (C0196a) a.get(i);
                if (z) {
                    c0196a.m187a(this.Fi.mContext, this.mBitmap, false);
                } else {
                    this.Fi.Fg.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    c0196a.m189a(this.Fi.mContext, this.Fi.Fd, false);
                }
                if (!(c0196a instanceof C0640c)) {
                    this.Fi.Fe.remove(c0196a);
                }
            }
        }

        public void run() {
            gx.ay("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.Fi.Fc != null) {
                if (this.Fl) {
                    this.Fi.Fc.evictAll();
                    System.gc();
                    this.Fl = false;
                    this.Fi.mHandler.post(this);
                    return;
                } else if (z) {
                    this.Fi.Fc.put(new C0195a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.Fi.Ff.remove(this.mUri);
            if (imageReceiver != null) {
                m171a(imageReceiver, z);
            }
            this.kK.countDown();
            synchronized (ImageManager.EX) {
                ImageManager.EY.remove(this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.b */
    private static final class C0638b extends hq<C0195a, Bitmap> {
        public C0638b(Context context) {
            super(C0638b.m2020D(context));
        }

        private static int m2020D(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !ip.gc()) ? activityManager.getMemoryClass() : C0190a.m170a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected int m2021a(C0195a c0195a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void m2022a(boolean z, C0195a c0195a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0195a, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            m2022a(x0, (C0195a) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2021a((C0195a) x0, (Bitmap) x1);
        }
    }

    static {
        EX = new Object();
        EY = new HashSet();
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Fb = Executors.newFixedThreadPool(4);
        if (withMemoryCache) {
            this.Fc = new C0638b(this.mContext);
            if (ip.gf()) {
                fc();
            }
        } else {
            this.Fc = null;
        }
        this.Fd = new gw();
        this.Fe = new HashMap();
        this.Ff = new HashMap();
        this.Fg = new HashMap();
    }

    private Bitmap m173a(C0195a c0195a) {
        return this.Fc == null ? null : (Bitmap) this.Fc.get(c0195a);
    }

    public static ImageManager m174a(Context context, boolean z) {
        if (z) {
            if (Fa == null) {
                Fa = new ImageManager(context, true);
            }
            return Fa;
        }
        if (EZ == null) {
            EZ = new ImageManager(context, false);
        }
        return EZ;
    }

    public static ImageManager create(Context context) {
        return m174a(context, false);
    }

    private void fc() {
        this.mContext.registerComponentCallbacks(new C0193e(this.Fc));
    }

    public void m183a(C0196a c0196a) {
        gx.ay("ImageManager.loadImage() must be called in the main thread");
        new C0192d(this, c0196a).run();
    }

    public void loadImage(ImageView imageView, int resId) {
        m183a(new C0639b(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        m183a(new C0639b(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0196a c0639b = new C0639b(imageView, uri);
        c0639b.aj(defaultResId);
        m183a(c0639b);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        m183a(new C0640c(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0196a c0640c = new C0640c(listener, uri);
        c0640c.aj(defaultResId);
        m183a(c0640c);
    }
}
