package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import com.google.android.gms.tagmanager.DataLayer.C0468a;
import com.google.android.gms.tagmanager.DataLayer.C0471c;
import com.google.android.gms.tagmanager.DataLayer.C0471c.C0470a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.v */
class C0981v implements C0471c {
    private static final String afj;
    private ij aef;
    private final Executor afk;
    private C0518a afl;
    private int afm;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.v.1 */
    class C05151 implements Runnable {
        final /* synthetic */ List afn;
        final /* synthetic */ long afo;
        final /* synthetic */ C0981v afp;

        C05151(C0981v c0981v, List list, long j) {
            this.afp = c0981v;
            this.afn = list;
            this.afo = j;
        }

        public void run() {
            this.afp.m3048b(this.afn, this.afo);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.2 */
    class C05162 implements Runnable {
        final /* synthetic */ C0981v afp;
        final /* synthetic */ C0470a afq;

        C05162(C0981v c0981v, C0470a c0470a) {
            this.afp = c0981v;
            this.afq = c0470a;
        }

        public void run() {
            this.afq.m1593d(this.afp.lC());
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.3 */
    class C05173 implements Runnable {
        final /* synthetic */ C0981v afp;
        final /* synthetic */ String afr;

        C05173(C0981v c0981v, String str) {
            this.afp = c0981v;
            this.afr = str;
        }

        public void run() {
            this.afp.bQ(this.afr);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.a */
    class C0518a extends SQLiteOpenHelper {
        final /* synthetic */ C0981v afp;

        C0518a(C0981v c0981v, Context context, String str) {
            this.afp = c0981v;
            super(context, str, null, 1);
        }

        private void m1746a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m1747a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        bh.m1645D("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                bh.m1645D("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.afp.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase db) {
            ak.m1628N(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m1747a("datalayer", db)) {
                m1746a(db);
            } else {
                db.execSQL(C0981v.afj);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.b */
    private static class C0519b {
        final String JL;
        final byte[] afs;

        C0519b(String str, byte[] bArr) {
            this.JL = str;
            this.afs = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.JL + " serialized hash = " + Arrays.hashCode(this.afs);
        }
    }

    static {
        afj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    }

    public C0981v(Context context) {
        this(context, il.gb(), "google_tagmanager.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS, Executors.newSingleThreadExecutor());
    }

    C0981v(Context context, ij ijVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.aef = ijVar;
        this.afm = i;
        this.afk = executor;
        this.afl = new C0518a(this, this.mContext, str);
    }

    private SQLiteDatabase m3043S(String str) {
        try {
            return this.afl.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m1645D(str);
            return null;
        }
    }

    private synchronized void m3048b(List<C0519b> list, long j) {
        try {
            long currentTimeMillis = this.aef.currentTimeMillis();
            m3056x(currentTimeMillis);
            m3050do(list.size());
            m3049c(list, currentTimeMillis + j);
            lF();
        } catch (Throwable th) {
            lF();
        }
    }

    private void bQ(String str) {
        SQLiteDatabase S = m3043S("Error opening database for clearKeysWithPrefix.");
        if (S != null) {
            try {
                bh.m1644C("Cleared " + S.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.m1645D("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                lF();
            }
        }
    }

    private void m3049c(List<C0519b> list, long j) {
        SQLiteDatabase S = m3043S("Error opening database for writeEntryToDatabase.");
        if (S != null) {
            for (C0519b c0519b : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", c0519b.JL);
                contentValues.put("value", c0519b.afs);
                S.insert("datalayer", null, contentValues);
            }
        }
    }

    private void m3050do(int i) {
        int lE = (lE() - this.afm) + i;
        if (lE > 0) {
            List dp = dp(lE);
            bh.m1643B("DataLayer store full, deleting " + dp.size() + " entries to make room.");
            m3053g((String[]) dp.toArray(new String[0]));
        }
    }

    private List<String> dp(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m1645D("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase S = m3043S("Error opening database for peekEntryIds.");
        if (S == null) {
            return arrayList;
        }
        try {
            query = S.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    bh.m1645D("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            bh.m1645D("Error in peekEntries fetching entryIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private List<C0468a> m3051e(List<C0519b> list) {
        List<C0468a> arrayList = new ArrayList();
        for (C0519b c0519b : list) {
            arrayList.add(new C0468a(c0519b.JL, m3054j(c0519b.afs)));
        }
        return arrayList;
    }

    private List<C0519b> m3052f(List<C0468a> list) {
        List<C0519b> arrayList = new ArrayList();
        for (C0468a c0468a : list) {
            arrayList.add(new C0519b(c0468a.JL, m3055j(c0468a.afh)));
        }
        return arrayList;
    }

    private void m3053g(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase S = m3043S("Error opening database for deleteEntries.");
            if (S != null) {
                try {
                    S.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.m1645D("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private Object m3054j(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private byte[] m3055j(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List<C0468a> lC() {
        try {
            m3056x(this.aef.currentTimeMillis());
            List<C0468a> e = m3051e(lD());
            return e;
        } finally {
            lF();
        }
    }

    private List<C0519b> lD() {
        SQLiteDatabase S = m3043S("Error opening database for loadSerialized.");
        List<C0519b> arrayList = new ArrayList();
        if (S == null) {
            return arrayList;
        }
        Cursor query = S.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C0519b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int lE() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase S = m3043S("Error opening database for getNumStoredEntries.");
        if (S != null) {
            try {
                cursor = S.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m1645D("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void lF() {
        try {
            this.afl.close();
        } catch (SQLiteException e) {
        }
    }

    private void m3056x(long j) {
        SQLiteDatabase S = m3043S("Error opening database for deleteOlderThan.");
        if (S != null) {
            try {
                bh.m1644C("Deleted " + S.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.m1645D("Error deleting old entries.");
            }
        }
    }

    public void m3057a(C0470a c0470a) {
        this.afk.execute(new C05162(this, c0470a));
    }

    public void m3058a(List<C0468a> list, long j) {
        this.afk.execute(new C05151(this, m3052f(list), j));
    }

    public void bP(String str) {
        this.afk.execute(new C05173(this, str));
    }
}
