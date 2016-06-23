package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import java.util.LinkedList;
import java.util.List;

public class cx {
    private static final Object ls;
    private static final String pr;
    private static cx pt;
    private final C0322a ps;

    /* renamed from: com.google.android.gms.internal.cx.a */
    public class C0322a extends SQLiteOpenHelper {
        final /* synthetic */ cx pu;

        public C0322a(cx cxVar, Context context, String str) {
            this.pu = cxVar;
            super(context, str, null, 4);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(cx.pr);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            eu.m1012B("Database updated from version " + oldVersion + " to version " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(db);
        }
    }

    static {
        pr = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
        ls = new Object();
    }

    private cx(Context context) {
        this.ps = new C0322a(this, context, "google_inapp_purchase.db");
    }

    public static cx m874k(Context context) {
        cx cxVar;
        synchronized (ls) {
            if (pt == null) {
                pt = new cx(context);
            }
            cxVar = pt;
        }
        return cxVar;
    }

    public cv m875a(Cursor cursor) {
        return cursor == null ? null : new cv(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void m876a(cv cvVar) {
        if (cvVar != null) {
            synchronized (ls) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                writableDatabase.delete("InAppPurchase", String.format("%s = %d", new Object[]{"purchase_id", Long.valueOf(cvVar.pl)}), null);
            }
        }
    }

    public void m877b(cv cvVar) {
        if (cvVar != null) {
            synchronized (ls) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("product_id", cvVar.pn);
                contentValues.put("developer_payload", cvVar.pm);
                contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
                cvVar.pl = writableDatabase.insert("InAppPurchase", null, contentValues);
                if (((long) getRecordCount()) > 20000) {
                    bk();
                }
            }
        }
    }

    public void bk() {
        Cursor query;
        SQLiteException e;
        synchronized (ls) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                query = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            m876a(m875a(query));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            eu.m1014D("Error remove oldest record" + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                eu.m1014D("Error remove oldest record" + e.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th2 = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        }
    }

    public List<cv> m878d(long j) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        synchronized (ls) {
            List<cv> linkedList = new LinkedList();
            if (j <= 0) {
                return linkedList;
            }
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return linkedList;
            }
            try {
                query = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", String.valueOf(j));
                try {
                    if (query.moveToFirst()) {
                        do {
                            linkedList.add(m875a(query));
                        } while (query.moveToNext());
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        eu.m1014D("Error extracing purchase info: " + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
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
                eu.m1014D("Error extracing purchase info: " + e.getMessage());
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
            return linkedList;
        }
    }

    public int getRecordCount() {
        Cursor cursor = null;
        int i = 0;
        synchronized (ls) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
            } else {
                try {
                    cursor = writableDatabase.rawQuery("select count(*) from InAppPurchase", null);
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (SQLiteException e) {
                    eu.m1014D("Error getting record count" + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.ps.getWritableDatabase();
        } catch (SQLiteException e) {
            eu.m1014D("Error opening writable conversion tracking database");
            return null;
        }
    }
}
