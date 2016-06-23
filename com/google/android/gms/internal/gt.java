package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.wearable.DataEvent;

public final class gt extends Drawable implements Callback {
    private int FA;
    private int FB;
    private boolean FC;
    private C0369b FD;
    private Drawable FE;
    private Drawable FF;
    private boolean FG;
    private boolean FH;
    private boolean FI;
    private int FJ;
    private boolean Fp;
    private int Fv;
    private long Fw;
    private int Fx;
    private int Fy;
    private int Fz;

    /* renamed from: com.google.android.gms.internal.gt.a */
    private static final class C0368a extends Drawable {
        private static final C0368a FK;
        private static final C0367a FL;

        /* renamed from: com.google.android.gms.internal.gt.a.a */
        private static final class C0367a extends ConstantState {
            private C0367a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return C0368a.FK;
            }
        }

        static {
            FK = new C0368a();
            FL = new C0367a();
        }

        private C0368a() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return FL;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* renamed from: com.google.android.gms.internal.gt.b */
    static final class C0369b extends ConstantState {
        int FM;
        int FN;

        C0369b(C0369b c0369b) {
            if (c0369b != null) {
                this.FM = c0369b.FM;
                this.FN = c0369b.FN;
            }
        }

        public int getChangingConfigurations() {
            return this.FM;
        }

        public Drawable newDrawable() {
            return new gt(this);
        }
    }

    public gt(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = C0368a.FK;
        }
        this.FE = drawable;
        drawable.setCallback(this);
        C0369b c0369b = this.FD;
        c0369b.FN |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = C0368a.FK;
        }
        this.FF = drawable2;
        drawable2.setCallback(this);
        c0369b = this.FD;
        c0369b.FN |= drawable2.getChangingConfigurations();
    }

    gt(C0369b c0369b) {
        this.Fv = 0;
        this.Fz = MotionEventCompat.ACTION_MASK;
        this.FB = 0;
        this.Fp = true;
        this.FD = new C0369b(c0369b);
    }

    public boolean canConstantState() {
        if (!this.FG) {
            boolean z = (this.FE.getConstantState() == null || this.FF.getConstantState() == null) ? false : true;
            this.FH = z;
            this.FG = true;
        }
        return this.FH;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.Fv) {
            case DataEvent.TYPE_CHANGED /*1*/:
                this.Fw = SystemClock.uptimeMillis();
                this.Fv = 2;
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                if (this.Fw >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.Fw)) / ((float) this.FA);
                    if (uptimeMillis < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.Fv = 0;
                    }
                    float min = Math.min(uptimeMillis, TextTrackStyle.DEFAULT_FONT_SCALE);
                    this.FB = (int) ((min * ((float) (this.Fy - this.Fx))) + ((float) this.Fx));
                    break;
                }
                break;
        }
        i2 = i;
        i = this.FB;
        boolean z = this.Fp;
        Drawable drawable = this.FE;
        Drawable drawable2 = this.FF;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.Fz) {
                drawable2.setAlpha(this.Fz);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.Fz - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.Fz);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.Fz);
        }
        invalidateSelf();
    }

    public Drawable fg() {
        return this.FF;
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.FD.FM) | this.FD.FN;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.FD.FM = getChangingConfigurations();
        return this.FD;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.FE.getIntrinsicHeight(), this.FF.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.FE.getIntrinsicWidth(), this.FF.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.FI) {
            this.FJ = Drawable.resolveOpacity(this.FE.getOpacity(), this.FF.getOpacity());
            this.FI = true;
        }
        return this.FJ;
    }

    public void invalidateDrawable(Drawable who) {
        if (ip.gc()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.FC && super.mutate() == this) {
            if (canConstantState()) {
                this.FE.mutate();
                this.FF.mutate();
                this.FC = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected void onBoundsChange(Rect bounds) {
        this.FE.setBounds(bounds);
        this.FF.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (ip.gc()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, what, when);
            }
        }
    }

    public void setAlpha(int alpha) {
        if (this.FB == this.Fz) {
            this.FB = alpha;
        }
        this.Fz = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.FE.setColorFilter(cf);
        this.FF.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.Fx = 0;
        this.Fy = this.Fz;
        this.FB = 0;
        this.FA = durationMillis;
        this.Fv = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (ip.gc()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, what);
            }
        }
    }
}
