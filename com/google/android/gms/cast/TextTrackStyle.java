package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.ip;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject AA;
    private int BA;
    private int BB;
    private float Bs;
    private int Bt;
    private int Bu;
    private int Bv;
    private int Bw;
    private int Bx;
    private int By;
    private String Bz;
    private int td;

    public TextTrackStyle() {
        clear();
    }

    private int ah(String str) {
        int i = WINDOW_TYPE_NONE;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(WINDOW_TYPE_NORMAL, FONT_STYLE_BOLD_ITALIC), 16), Integer.parseInt(str.substring(FONT_STYLE_BOLD_ITALIC, FONT_FAMILY_CURSIVE), 16), Integer.parseInt(str.substring(FONT_FAMILY_CURSIVE, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private void clear() {
        this.Bs = DEFAULT_FONT_SCALE;
        this.Bt = WINDOW_TYPE_NONE;
        this.td = WINDOW_TYPE_NONE;
        this.Bu = WINDOW_TYPE_UNSPECIFIED;
        this.Bv = WINDOW_TYPE_NONE;
        this.Bw = WINDOW_TYPE_UNSPECIFIED;
        this.Bx = WINDOW_TYPE_NONE;
        this.By = WINDOW_TYPE_NONE;
        this.Bz = null;
        this.BA = WINDOW_TYPE_UNSPECIFIED;
        this.BB = WINDOW_TYPE_UNSPECIFIED;
        this.AA = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!ip.gi()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case WINDOW_TYPE_NORMAL /*1*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NORMAL);
                break;
            case WINDOW_TYPE_ROUNDED /*2*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_ROUNDED);
                break;
            default:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NONE);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NORMAL);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(FONT_STYLE_BOLD_ITALIC);
            } else if (isBold) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NORMAL);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NONE);
            }
        }
        return textTrackStyle;
    }

    private String m111o(int i) {
        Object[] objArr = new Object[FONT_FAMILY_CASUAL];
        objArr[WINDOW_TYPE_NONE] = Integer.valueOf(Color.red(i));
        objArr[WINDOW_TYPE_NORMAL] = Integer.valueOf(Color.green(i));
        objArr[WINDOW_TYPE_ROUNDED] = Integer.valueOf(Color.blue(i));
        objArr[FONT_STYLE_BOLD_ITALIC] = Integer.valueOf(Color.alpha(i));
        return String.format("#%02X%02X%02X%02X", objArr);
    }

    public void m112b(JSONObject jSONObject) throws JSONException {
        String string;
        clear();
        this.Bs = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.Bt = ah(jSONObject.optString("foregroundColor"));
        this.td = ah(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.Bu = WINDOW_TYPE_NONE;
            } else if ("OUTLINE".equals(string)) {
                this.Bu = WINDOW_TYPE_NORMAL;
            } else if ("DROP_SHADOW".equals(string)) {
                this.Bu = WINDOW_TYPE_ROUNDED;
            } else if ("RAISED".equals(string)) {
                this.Bu = FONT_STYLE_BOLD_ITALIC;
            } else if ("DEPRESSED".equals(string)) {
                this.Bu = FONT_FAMILY_CASUAL;
            }
        }
        this.Bv = ah(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.Bw = WINDOW_TYPE_NONE;
            } else if ("NORMAL".equals(string)) {
                this.Bw = WINDOW_TYPE_NORMAL;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.Bw = WINDOW_TYPE_ROUNDED;
            }
        }
        this.Bx = ah(jSONObject.optString("windowColor"));
        if (this.Bw == WINDOW_TYPE_ROUNDED) {
            this.By = jSONObject.optInt("windowRoundedCornerRadius", WINDOW_TYPE_NONE);
        }
        this.Bz = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.BA = WINDOW_TYPE_NONE;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.BA = WINDOW_TYPE_NORMAL;
            } else if ("SERIF".equals(string)) {
                this.BA = WINDOW_TYPE_ROUNDED;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.BA = FONT_STYLE_BOLD_ITALIC;
            } else if ("CASUAL".equals(string)) {
                this.BA = FONT_FAMILY_CASUAL;
            } else if ("CURSIVE".equals(string)) {
                this.BA = FONT_FAMILY_CURSIVE;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.BA = FONT_FAMILY_SMALL_CAPITALS;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.BB = WINDOW_TYPE_NONE;
            } else if ("BOLD".equals(string)) {
                this.BB = WINDOW_TYPE_NORMAL;
            } else if ("ITALIC".equals(string)) {
                this.BB = WINDOW_TYPE_ROUNDED;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.BB = FONT_STYLE_BOLD_ITALIC;
            }
        }
        this.AA = jSONObject.optJSONObject("customData");
    }

    public JSONObject dZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.Bs);
            if (this.Bt != 0) {
                jSONObject.put("foregroundColor", m111o(this.Bt));
            }
            if (this.td != 0) {
                jSONObject.put("backgroundColor", m111o(this.td));
            }
            switch (this.Bu) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.Bv != 0) {
                jSONObject.put("edgeColor", m111o(this.Bv));
            }
            switch (this.Bw) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("windowType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.Bx != 0) {
                jSONObject.put("windowColor", m111o(this.Bx));
            }
            if (this.Bw == WINDOW_TYPE_ROUNDED) {
                jSONObject.put("windowRoundedCornerRadius", this.By);
            }
            if (this.Bz != null) {
                jSONObject.put("fontFamily", this.Bz);
            }
            switch (this.BA) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case FONT_FAMILY_CURSIVE /*5*/:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case FONT_FAMILY_SMALL_CAPITALS /*6*/:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.BB) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.AA != null) {
                jSONObject.put("customData", this.AA);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.AA == null ? WINDOW_TYPE_NORMAL : false) != (textTrackStyle.AA == null ? WINDOW_TYPE_NORMAL : false)) {
            return false;
        }
        if (this.AA != null && textTrackStyle.AA != null && !in.m1276d(this.AA, textTrackStyle.AA)) {
            return false;
        }
        if (!(this.Bs == textTrackStyle.Bs && this.Bt == textTrackStyle.Bt && this.td == textTrackStyle.td && this.Bu == textTrackStyle.Bu && this.Bv == textTrackStyle.Bv && this.Bw == textTrackStyle.Bw && this.By == textTrackStyle.By && gi.m1110a(this.Bz, textTrackStyle.Bz) && this.BA == textTrackStyle.BA && this.BB == textTrackStyle.BB)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.td;
    }

    public JSONObject getCustomData() {
        return this.AA;
    }

    public int getEdgeColor() {
        return this.Bv;
    }

    public int getEdgeType() {
        return this.Bu;
    }

    public String getFontFamily() {
        return this.Bz;
    }

    public int getFontGenericFamily() {
        return this.BA;
    }

    public float getFontScale() {
        return this.Bs;
    }

    public int getFontStyle() {
        return this.BB;
    }

    public int getForegroundColor() {
        return this.Bt;
    }

    public int getWindowColor() {
        return this.Bx;
    }

    public int getWindowCornerRadius() {
        return this.By;
    }

    public int getWindowType() {
        return this.Bw;
    }

    public int hashCode() {
        return hk.hashCode(Float.valueOf(this.Bs), Integer.valueOf(this.Bt), Integer.valueOf(this.td), Integer.valueOf(this.Bu), Integer.valueOf(this.Bv), Integer.valueOf(this.Bw), Integer.valueOf(this.Bx), Integer.valueOf(this.By), this.Bz, Integer.valueOf(this.BA), Integer.valueOf(this.BB), this.AA);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.td = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.AA = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.Bv = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > FONT_FAMILY_CASUAL) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.Bu = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.Bz = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > FONT_FAMILY_SMALL_CAPITALS) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.BA = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.Bs = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > FONT_STYLE_BOLD_ITALIC) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.BB = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.Bt = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.Bx = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.By = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > WINDOW_TYPE_ROUNDED) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.Bw = windowType;
    }
}
