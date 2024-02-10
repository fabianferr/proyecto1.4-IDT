package com.bytedance.sdk.component.e.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.i;
import java.util.List;
import org.json.JSONObject;

/* compiled from: DBHelper */
class b {
    private C0052b a;
    private Context b;

    b(Context context) {
        try {
            this.b = context.getApplicationContext();
            if (this.a == null) {
                this.a = new C0052b();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: com.bytedance.sdk.component.e.a.a.a.b$b  reason: collision with other inner class name */
    /* compiled from: DBHelper */
    public class C0052b {
        private volatile SQLiteDatabase b = null;

        public C0052b() {
        }

        private void a() {
            try {
                if (this.b == null || !this.b.isOpen()) {
                    synchronized (this) {
                        if (this.b == null || !this.b.isOpen()) {
                            this.b = i.e().b().a(i.e().d());
                            this.b.setLockingEnabled(false);
                            c.a("---------------DB CREATE  SUCCESS------------");
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (b()) {
                    throw th;
                }
            }
        }

        public void a(String str) throws SQLException {
            try {
                a();
                this.b.execSQL(str);
            } catch (Throwable th) {
                if (b()) {
                    throw th;
                }
            }
        }

        public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                a();
                return this.b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                a aVar = new a();
                if (!b()) {
                    return aVar;
                }
                throw th;
            }
        }

        public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                a();
                return this.b.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!b()) {
                    return 0;
                }
                throw e;
            }
        }

        public long a(String str, String str2, ContentValues contentValues) {
            try {
                a();
                return this.b.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (!b()) {
                    return -1;
                }
                throw e;
            }
        }

        public synchronized void a(String str, String str2, List<com.bytedance.sdk.component.e.a.d.a> list) {
            SQLiteDatabase sQLiteDatabase;
            try {
                a();
                this.b.beginTransaction();
                ContentValues contentValues = new ContentValues();
                for (int i = 0; i < list.size(); i++) {
                    com.bytedance.sdk.component.e.a.d.a aVar = list.get(i);
                    if (aVar != null) {
                        JSONObject g = aVar.g();
                        if (g != null) {
                            contentValues.put("id", aVar.c());
                            String b2 = i.e().m().b(g.toString());
                            if (!TextUtils.isEmpty(b2)) {
                                contentValues.put("value", b2);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", 0);
                                contentValues.put("encrypt", 1);
                                this.b.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                }
                this.b.setTransactionSuccessful();
                c.b("DBHelper", str + " insert list size=" + list.size());
                if (this.b != null) {
                    sQLiteDatabase = this.b;
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e) {
                c.b("DBHelper", str + " insert list error=" + list.size());
                e.printStackTrace();
                if (b()) {
                    throw e;
                } else if (this.b != null) {
                    sQLiteDatabase = this.b;
                }
            } catch (Throwable th) {
                if (this.b != null) {
                    this.b.endTransaction();
                }
                throw th;
            }
        }

        public int a(String str, String str2, String[] strArr) {
            try {
                a();
                return this.b.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!b()) {
                    return 0;
                }
                throw e;
            }
        }

        private boolean b() {
            SQLiteDatabase sQLiteDatabase = this.b;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    public C0052b a() {
        return this.a;
    }

    /* compiled from: DBHelper */
    private class a extends AbstractCursor {
        public String[] getColumnNames() {
            return new String[0];
        }

        public int getCount() {
            return 0;
        }

        public double getDouble(int i) {
            return 0.0d;
        }

        public float getFloat(int i) {
            return 0.0f;
        }

        public int getInt(int i) {
            return 0;
        }

        public long getLong(int i) {
            return 0;
        }

        public short getShort(int i) {
            return 0;
        }

        public String getString(int i) {
            return null;
        }

        public boolean isNull(int i) {
            return true;
        }

        private a() {
        }
    }
}
