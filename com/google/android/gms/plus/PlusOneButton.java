package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hp;
import com.google.android.gms.plus.internal.C0463g;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private View abB;
    private int abC;
    private int abD;
    private OnPlusOneClickListener abE;
    private int mSize;
    private String qY;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener abF;
        final /* synthetic */ PlusOneButton abG;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener proxy) {
            this.abG = plusOneButton;
            this.abF = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.abG.abB.getTag();
            if (this.abF != null) {
                this.abF.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.abG.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.abG.abD);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.abC = getAnnotation(context, attrs);
        this.abD = DEFAULT_ACTIVITY_REQUEST_CODE;
        m1551C(getContext());
        if (!isInEditMode()) {
        }
    }

    private void m1551C(Context context) {
        if (this.abB != null) {
            removeView(this.abB);
        }
        this.abB = C0463g.m1581a(context, this.mSize, this.abC, this.qY, this.abD);
        setOnPlusOneClickListener(this.abE);
        addView(this.abB);
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = hp.m1238a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(a)) {
            return SIZE_TALL;
        }
        return !"NONE".equalsIgnoreCase(a) ? SIZE_MEDIUM : SIZE_SMALL;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = hp.m1238a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(a)) {
            return SIZE_SMALL;
        }
        if ("MEDIUM".equalsIgnoreCase(a)) {
            return SIZE_MEDIUM;
        }
        return "TALL".equalsIgnoreCase(a) ? SIZE_TALL : SIZE_STANDARD;
    }

    public void initialize(String url, int activityRequestCode) {
        hm.m1226a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.qY = url;
        this.abD = activityRequestCode;
        m1551C(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.qY = url;
        this.abD = SIZE_SMALL;
        m1551C(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.abB.layout(SIZE_SMALL, SIZE_SMALL, right - left, bottom - top);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.abB;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.abC = annotation;
        m1551C(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.abE = listener;
        this.abB.setOnClickListener(new DefaultOnPlusOneClickListener(this, listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        m1551C(getContext());
    }
}
