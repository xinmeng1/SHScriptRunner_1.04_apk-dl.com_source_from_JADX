package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.et;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER;
    public static final AdSize FULL_BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER;
    public static final AdSize LEADERBOARD;
    public static final AdSize MEDIUM_RECTANGLE;
    public static final AdSize SMART_BANNER;
    public static final AdSize WIDE_SKYSCRAPER;
    private final int ku;
    private final int kv;
    private final String kw;

    static {
        BANNER = new AdSize(320, 50, "320x50_mb");
        FULL_BANNER = new AdSize(468, 60, "468x60_as");
        LARGE_BANNER = new AdSize(320, 100, "320x100_as");
        LEADERBOARD = new AdSize(728, 90, "728x90_as");
        MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
        WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
        SMART_BANNER = new AdSize(FULL_WIDTH, AUTO_HEIGHT, "smart_banner");
    }

    public AdSize(int width, int height) {
        this(width, height, (width == FULL_WIDTH ? "FULL" : String.valueOf(width)) + "x" + (height == AUTO_HEIGHT ? "AUTO" : String.valueOf(height)) + "_as");
    }

    AdSize(int width, int height, String formatString) {
        if (width < 0 && width != FULL_WIDTH) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + width);
        } else if (height >= 0 || height == AUTO_HEIGHT) {
            this.ku = width;
            this.kv = height;
            this.kw = formatString;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + height);
        }
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        return this.ku == adSize.ku && this.kv == adSize.kv && this.kw.equals(adSize.kw);
    }

    public int getHeight() {
        return this.kv;
    }

    public int getHeightInPixels(Context context) {
        return this.kv == AUTO_HEIGHT ? al.m2455b(context.getResources().getDisplayMetrics()) : et.m1004a(context, this.kv);
    }

    public int getWidth() {
        return this.ku;
    }

    public int getWidthInPixels(Context context) {
        return this.ku == FULL_WIDTH ? al.m2454a(context.getResources().getDisplayMetrics()) : et.m1004a(context, this.ku);
    }

    public int hashCode() {
        return this.kw.hashCode();
    }

    public boolean isAutoHeight() {
        return this.kv == AUTO_HEIGHT;
    }

    public boolean isFullWidth() {
        return this.ku == FULL_WIDTH;
    }

    public String toString() {
        return this.kw;
    }
}
