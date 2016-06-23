package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.C0283g.C0282a;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.ho;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int Dj;
    private View Dk;
    private OnClickListener Dl;
    private int mSize;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, SIZE_STANDARD);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.Dl = null;
        setStyle(SIZE_STANDARD, SIZE_STANDARD);
    }

    private void m142C(Context context) {
        if (this.Dk != null) {
            removeView(this.Dk);
        }
        try {
            this.Dk = hn.m2709b(context, this.mSize, this.Dj);
        } catch (C0282a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.Dk = m143a(context, this.mSize, this.Dj);
        }
        addView(this.Dk);
        this.Dk.setEnabled(isEnabled());
        this.Dk.setOnClickListener(this);
    }

    private static Button m143a(Context context, int i, int i2) {
        Button hoVar = new ho(context);
        hoVar.m1237a(context.getResources(), i, i2);
        return hoVar;
    }

    public void onClick(View view) {
        if (this.Dl != null && view == this.Dk) {
            this.Dl.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.Dk.setEnabled(enabled);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.Dl = listener;
        if (this.Dk != null) {
            this.Dk.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.Dj);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        boolean z = buttonSize >= 0 && buttonSize < 3;
        Object[] objArr = new Object[SIZE_WIDE];
        objArr[SIZE_STANDARD] = Integer.valueOf(buttonSize);
        hm.m1227a(z, "Unknown button size %d", objArr);
        z = colorScheme >= 0 && colorScheme < SIZE_ICON_ONLY;
        Object[] objArr2 = new Object[SIZE_WIDE];
        objArr2[SIZE_STANDARD] = Integer.valueOf(colorScheme);
        hm.m1227a(z, "Unknown color scheme %s", objArr2);
        this.mSize = buttonSize;
        this.Dj = colorScheme;
        m142C(getContext());
    }
}
