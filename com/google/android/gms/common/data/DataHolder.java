package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final C0189f CREATOR;
    private static final C0185a EO;
    private final int CT;
    private final String[] EG;
    Bundle EH;
    private final CursorWindow[] EI;
    private final Bundle EJ;
    int[] EK;
    int EL;
    private Object EM;
    private boolean EN;
    boolean mClosed;
    private final int xM;

    /* renamed from: com.google.android.gms.common.data.DataHolder.a */
    public static class C0185a {
        private final String[] EG;
        private final ArrayList<HashMap<String, Object>> EP;
        private final String EQ;
        private final HashMap<Object, Integer> ER;
        private boolean ES;
        private String ET;

        private C0185a(String[] strArr, String str) {
            this.EG = (String[]) hm.m1232f(strArr);
            this.EP = new ArrayList();
            this.EQ = str;
            this.ER = new HashMap();
            this.ES = false;
            this.ET = null;
        }
    }

    /* renamed from: com.google.android.gms.common.data.DataHolder.1 */
    static class C06351 extends C0185a {
        C06351(String[] strArr, String str) {
            super(str, null);
        }
    }

    static {
        CREATOR = new C0189f();
        EO = new C06351(new String[0], null);
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.EN = true;
        this.xM = versionCode;
        this.EG = columns;
        this.EI = windows;
        this.CT = statusCode;
        this.EJ = metadata;
    }

    private DataHolder(C0185a builder, int statusCode, Bundle metadata) {
        this(builder.EG, m2006a(builder, -1), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.EN = true;
        this.xM = 1;
        this.EG = (String[]) hm.m1232f(columns);
        this.EI = (CursorWindow[]) hm.m1232f(windows);
        this.CT = statusCode;
        this.EJ = metadata;
        eW();
    }

    public static DataHolder m2005a(int i, Bundle bundle) {
        return new DataHolder(EO, i, bundle);
    }

    private static CursorWindow[] m2006a(C0185a c0185a, int i) {
        int size;
        int i2 = 0;
        if (c0185a.EG.length == 0) {
            return new CursorWindow[0];
        }
        List b = (i < 0 || i >= c0185a.EP.size()) ? c0185a.EP : c0185a.EP.subList(0, i);
        int size2 = b.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(c0185a.EG.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            int i5;
            int i6;
            CursorWindow cursorWindow2;
            if (cursorWindow.allocRow()) {
                i5 = i4;
            } else {
                Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                cursorWindow = new CursorWindow(false);
                cursorWindow.setStartPosition(i3);
                cursorWindow.setNumColumns(c0185a.EG.length);
                arrayList.add(cursorWindow);
                if (cursorWindow.allocRow()) {
                    i5 = 0;
                } else {
                    Log.e("DataHolder", "Unable to allocate row to hold data.");
                    arrayList.remove(cursorWindow);
                    return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                }
            }
            Map map = (Map) b.get(i3);
            boolean z = true;
            for (int i7 = 0; i7 < c0185a.EG.length && z; i7++) {
                String str = c0185a.EG[i7];
                Object obj = map.get(str);
                if (obj == null) {
                    z = cursorWindow.putNull(i5, i7);
                } else if (obj instanceof String) {
                    z = cursorWindow.putString((String) obj, i5, i7);
                } else if (obj instanceof Long) {
                    z = cursorWindow.putLong(((Long) obj).longValue(), i5, i7);
                } else if (obj instanceof Integer) {
                    z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i5, i7);
                } else if (obj instanceof Boolean) {
                    z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i5, i7);
                } else if (obj instanceof byte[]) {
                    z = cursorWindow.putBlob((byte[]) obj, i5, i7);
                } else if (obj instanceof Double) {
                    z = cursorWindow.putDouble(((Double) obj).doubleValue(), i5, i7);
                } else if (obj instanceof Float) {
                    z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i5, i7);
                } else {
                    throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                }
            }
            if (z) {
                i6 = i5 + 1;
                i4 = i3;
                cursorWindow2 = cursorWindow;
            } else {
                try {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setNumColumns(c0185a.EG.length);
                    arrayList.add(cursorWindow3);
                    i4 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 0;
                } catch (RuntimeException e) {
                    RuntimeException runtimeException = e;
                    size = arrayList.size();
                    while (i2 < size) {
                        ((CursorWindow) arrayList.get(i2)).close();
                        i2++;
                    }
                    throw runtimeException;
                }
            }
            cursorWindow = cursorWindow2;
            i3 = i4 + 1;
            i4 = i6;
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder af(int i) {
        return m2005a(i, null);
    }

    private void m2007e(String str, int i) {
        if (this.EH == null || !this.EH.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.EL) {
            throw new CursorIndexOutOfBoundsException(i, this.EL);
        }
    }

    public long m2008a(String str, int i, int i2) {
        m2007e(str, i);
        return this.EI[i2].getLong(i, this.EH.getInt(str));
    }

    public void m2009a(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m2007e(str, i);
        this.EI[i2].copyStringToBuffer(i, this.EH.getInt(str), charArrayBuffer);
    }

    public int ae(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.EL;
        hm.m1224A(z);
        while (i2 < this.EK.length) {
            if (i < this.EK[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.EK.length ? i2 - 1 : i2;
    }

    public boolean av(String str) {
        return this.EH.containsKey(str);
    }

    public int m2010b(String str, int i, int i2) {
        m2007e(str, i);
        return this.EI[i2].getInt(i, this.EH.getInt(str));
    }

    public void m2011b(Object obj) {
        this.EM = obj;
    }

    public String m2012c(String str, int i, int i2) {
        m2007e(str, i);
        return this.EI[i2].getString(i, this.EH.getInt(str));
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.EI) {
                    close.close();
                }
            }
        }
    }

    public boolean m2013d(String str, int i, int i2) {
        m2007e(str, i);
        return Long.valueOf(this.EI[i2].getLong(i, this.EH.getInt(str))).longValue() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public float m2014e(String str, int i, int i2) {
        m2007e(str, i);
        return this.EI[i2].getFloat(i, this.EH.getInt(str));
    }

    public Bundle eU() {
        return this.EJ;
    }

    public void eW() {
        int i;
        int i2 = 0;
        this.EH = new Bundle();
        for (i = 0; i < this.EG.length; i++) {
            this.EH.putInt(this.EG[i], i);
        }
        this.EK = new int[this.EI.length];
        i = 0;
        while (i2 < this.EI.length) {
            this.EK[i2] = i;
            i += this.EI[i2].getNumRows() - (i - this.EI[i2].getStartPosition());
            i2++;
        }
        this.EL = i;
    }

    String[] eX() {
        return this.EG;
    }

    CursorWindow[] eY() {
        return this.EI;
    }

    public byte[] m2015f(String str, int i, int i2) {
        m2007e(str, i);
        return this.EI[i2].getBlob(i, this.EH.getInt(str));
    }

    protected void finalize() throws Throwable {
        try {
            if (this.EN && this.EI.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + (this.EM == null ? "internal object: " + toString() : this.EM.toString()) + ")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public Uri m2016g(String str, int i, int i2) {
        String c = m2012c(str, i, i2);
        return c == null ? null : Uri.parse(c);
    }

    public int getCount() {
        return this.EL;
    }

    public int getStatusCode() {
        return this.CT;
    }

    int getVersionCode() {
        return this.xM;
    }

    public boolean m2017h(String str, int i, int i2) {
        m2007e(str, i);
        return this.EI[i2].isNull(i, this.EH.getInt(str));
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0189f.m165a(this, dest, flags);
    }
}
