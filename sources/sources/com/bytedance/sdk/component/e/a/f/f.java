package com.bytedance.sdk.component.e.a.f;

import android.content.ContentValues;
import android.content.Context;
import com.bytedance.sdk.component.e.a.a.a.c;

/* compiled from: TrackRetryRepertoryImpl */
public class f implements e {
    private Context a;

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, retry INTEGER default 0)";
    }

    public f(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0051, code lost:
        if (r1 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (r1 != null) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.bytedance.sdk.component.e.a.f.d> a() {
        /*
            r9 = this;
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            android.content.Context r1 = r9.a
            java.lang.String r2 = "trackurl"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.e.a.a.a.c.a(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 == 0) goto L_0x0069
        L_0x0015:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = "id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "url"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "replaceholder"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ all -> 0x0057 }
            int r4 = r1.getInt(r4)     // Catch:{ all -> 0x0057 }
            if (r4 <= 0) goto L_0x003d
            r4 = 1
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            java.lang.String r5 = "retry"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ all -> 0x0057 }
            int r5 = r1.getInt(r5)     // Catch:{ all -> 0x0057 }
            com.bytedance.sdk.component.e.a.f.d r6 = new com.bytedance.sdk.component.e.a.f.d     // Catch:{ all -> 0x0057 }
            r6.<init>(r2, r3, r4, r5)     // Catch:{ all -> 0x0057 }
            r0.add(r6)     // Catch:{ all -> 0x0057 }
            goto L_0x0015
        L_0x0051:
            if (r1 == 0) goto L_0x0069
        L_0x0053:
            r1.close()
            goto L_0x0069
        L_0x0057:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ all -> 0x005f }
            r1 = 0
            goto L_0x0066
        L_0x005f:
            r0 = move-exception
            if (r1 == 0) goto L_0x0065
            r1.close()
        L_0x0065:
            throw r0
        L_0x0066:
            if (r1 == 0) goto L_0x0069
            goto L_0x0053
        L_0x0069:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.f.f.a():java.util.List");
    }

    public void a(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dVar.a());
        contentValues.put("url", dVar.b());
        contentValues.put("replaceholder", Integer.valueOf(dVar.c() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(dVar.d()));
        c.a(this.a, "trackurl", contentValues);
    }

    public void b(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dVar.a());
        contentValues.put("url", dVar.b());
        contentValues.put("replaceholder", Integer.valueOf(dVar.c() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(dVar.d()));
        c.a(this.a, "trackurl", contentValues, "id=?", new String[]{dVar.a()});
    }

    public void c(d dVar) {
        c.a(this.a, "trackurl", "id=?", new String[]{dVar.a()});
    }
}
