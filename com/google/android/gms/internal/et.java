package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class et {
    public static final Handler sv;

    static {
        sv = new Handler(Looper.getMainLooper());
    }

    public static int m1004a(Context context, int i) {
        return m1005a(context.getResources().getDisplayMetrics(), i);
    }

    public static int m1005a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public static void m1006a(ViewGroup viewGroup, al alVar, String str) {
        m1007a(viewGroup, alVar, str, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    private static void m1007a(ViewGroup viewGroup, al alVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m1004a(context, 3);
            frameLayout.addView(textView, new LayoutParams(alVar.widthPixels - a, alVar.heightPixels - a, 17));
            viewGroup.addView(frameLayout, alVar.widthPixels, alVar.heightPixels);
        }
    }

    public static void m1008a(ViewGroup viewGroup, al alVar, String str, String str2) {
        eu.m1014D(str2);
        m1007a(viewGroup, alVar, str, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
    }

    public static boolean bV() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean bW() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String m1009r(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || bV()) {
            string = "emulator";
        }
        return m1010y(string);
    }

    public static String m1010y(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }
}
