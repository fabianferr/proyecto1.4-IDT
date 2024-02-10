package com.umlaut.crowd.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umlaut.crowd.CCS;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.JsonUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class u1 extends SQLiteOpenHelper {
    /* access modifiers changed from: private */
    public static final String c = "u1";
    private static final boolean d = false;
    private static final boolean e = false;
    private static final int f = 2000000;
    private static final int g = 1500000;
    private static final String h = "insight.db";
    private static final int i = 10;
    private static final String j = "result";
    private static final String k = "CREATE TABLE result ( id INTEGER PRIMARY KEY, timestamp long, filetype TEXT, schema TEXT, result TEXT, sent INTEGER DEFAULT 0);";
    private static final String l = "DELETE FROM result; VACUUM;";
    private static final String m = "p3i";
    private static final String n = "lrf";
    /* access modifiers changed from: private */
    public final SQLiteDatabase a = getWritableDatabase();
    private Context b;

    private class a implements Runnable {
        b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public void run() {
            String str;
            String str2;
            b bVar = this.a;
            if (bVar != null) {
                long j = bVar.a;
                w2 w2Var = bVar.b;
                synchronized (u1.this) {
                    for (RBR json : this.a.c) {
                        try {
                            str = JsonUtils.toJson(w2Var, json);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            Log.e(u1.c, "InsertJsonIntoTableTask: " + e.getMessage());
                            str = null;
                        }
                        if (!(str == null || str.length() == 0 || w2Var == null)) {
                            try {
                                if (str.getBytes("UTF-8").length > u1.g) {
                                    str2 = "lrf-" + w2Var.toString() + "-" + j + "-" + Math.abs(str.hashCode());
                                    u1 u1Var = u1.this;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(u1.m);
                                    u1 u1Var2 = u1.this;
                                    sb.append(u1Var2.b(str, u1Var2.h()));
                                    u1Var.c(str2, sb.toString());
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(u1.m);
                                    u1 u1Var3 = u1.this;
                                    sb2.append(u1Var3.b(str, u1Var3.h()));
                                    str2 = sb2.toString();
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(j));
                                contentValues.put("filetype", w2Var.toString());
                                contentValues.put("result", str2);
                                u1.this.a.insert("result", (String) null, contentValues);
                            } catch (Exception e2) {
                                Log.e(u1.c, "InsertJsonIntoTableTask: " + e2.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    private class b {
        long a;
        w2 b;
        RBR[] c;

        public b(long j, w2 w2Var, RBR[] rbrArr) {
            this.a = j;
            this.b = w2Var;
            this.c = rbrArr;
        }
    }

    public u1(Context context) {
        super(context, h, (SQLiteDatabase.CursorFactory) null, 10);
        this.b = context;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071 A[SYNTHETIC, Splitter:B:21:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e A[SYNTHETIC, Splitter:B:26:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "writeResultToFile: "
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r3 = r5.b
            java.io.File r3 = r3.getFilesDir()
            r2.append(r3)
            java.lang.String r3 = "/insight/largestorage/"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0028
            r1.mkdirs()
        L_0x0028:
            r2 = 0
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ IOException -> 0x0059 }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0059 }
            r4.<init>(r1, r6)     // Catch:{ IOException -> 0x0059 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0059 }
            r3.write(r7)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r3.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x008b
        L_0x003a:
            r6 = move-exception
            java.lang.String r7 = c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            android.util.Log.e(r7, r6)
            goto L_0x008b
        L_0x0051:
            r6 = move-exception
            r2 = r3
            goto L_0x008c
        L_0x0054:
            r6 = move-exception
            r2 = r3
            goto L_0x005a
        L_0x0057:
            r6 = move-exception
            goto L_0x008c
        L_0x0059:
            r6 = move-exception
        L_0x005a:
            java.lang.String r7 = c     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r1.<init>(r0)     // Catch:{ all -> 0x0057 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0057 }
            r1.append(r6)     // Catch:{ all -> 0x0057 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0057 }
            android.util.Log.e(r7, r6)     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x008b
        L_0x0075:
            r6 = move-exception
            java.lang.String r7 = c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            android.util.Log.e(r7, r6)
        L_0x008b:
            return
        L_0x008c:
            if (r2 == 0) goto L_0x00a8
            r2.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x00a8
        L_0x0092:
            r7 = move-exception
            java.lang.String r1 = c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r1, r7)
        L_0x00a8:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.u1.c(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public String h() {
        return "unjafmysv777sk0l3";
    }

    private void j() {
        File[] listFiles;
        File file = new File(this.b.getFilesDir() + CCS.d);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    public synchronized long i() {
        return DatabaseUtils.queryNumEntries(this.a, "result");
    }

    public synchronized boolean k() {
        boolean z;
        z = false;
        try {
            if (i() > 0) {
                z = true;
            }
        } catch (Exception e2) {
            String str = c;
            Log.e(str, "hasResults: " + e2.getMessage());
        }
        return z;
    }

    public synchronized void l() {
        try {
            this.a.execSQL(l);
            j();
        } catch (SQLException e2) {
            String str = c;
            Log.e(str, "truncateResults: " + e2.getMessage());
        }
        return;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 < 10) {
            sQLiteDatabase.execSQL(k);
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(k);
    }

    public void b(w2 w2Var, RBR rbr, long j2) {
        a(j2, w2Var, new RBR[]{rbr});
    }

    /* access modifiers changed from: private */
    public String b(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bytes2 = str2.getBytes("UTF-8");
            byte[] bArr = new byte[bytes.length];
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bArr[i2] = (byte) (bytes[i2] ^ bytes2[i2 % bytes2.length]);
            }
            return Base64.encodeToString(bArr, 11);
        } catch (Exception unused) {
            return null;
        }
    }

    public synchronized void a(w2 w2Var, RBR rbr, long j2) {
        String json = JsonUtils.toJson(w2Var, rbr);
        if (json.length() > 0) {
            a(j2, w2Var, json);
        }
    }

    public void a(w2 w2Var, RBR rbr) {
        b(w2Var, rbr, TimeServer.getTimeInMillis());
    }

    public void a(w2 w2Var, RBR[] rbrArr) {
        a(TimeServer.getTimeInMillis(), w2Var, rbrArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0177 A[SYNTHETIC, Splitter:B:78:0x0177] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01a2 A[SYNTHETIC, Splitter:B:88:0x01a2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.umlaut.crowd.internal.w2 r13, com.umlaut.crowd.internal.p1 r14) {
        /*
            r12 = this;
            java.lang.String r0 = "writeResultFile: "
            monitor-enter(r12)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0233 }
            r1.<init>()     // Catch:{ all -> 0x0233 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0233 }
            r2.<init>()     // Catch:{ all -> 0x0233 }
            r3 = 0
            r4 = 1
            r5 = 0
            android.database.sqlite.SQLiteDatabase r6 = r12.a     // Catch:{ IllegalStateException -> 0x0022 }
            java.lang.String r7 = "SELECT * FROM result WHERE filetype = ?"
            java.lang.String[] r8 = new java.lang.String[r4]     // Catch:{ IllegalStateException -> 0x0022 }
            java.lang.String r9 = r13.toString()     // Catch:{ IllegalStateException -> 0x0022 }
            r8[r5] = r9     // Catch:{ IllegalStateException -> 0x0022 }
            android.database.Cursor r0 = r6.rawQuery(r7, r8)     // Catch:{ IllegalStateException -> 0x0022 }
            goto L_0x0039
        L_0x0022:
            r6 = move-exception
            java.lang.String r7 = c     // Catch:{ all -> 0x0233 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0233 }
            r8.<init>(r0)     // Catch:{ all -> 0x0233 }
            java.lang.String r0 = r6.getMessage()     // Catch:{ all -> 0x0233 }
            r8.append(r0)     // Catch:{ all -> 0x0233 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0233 }
            android.util.Log.e(r7, r0)     // Catch:{ all -> 0x0233 }
            r0 = r3
        L_0x0039:
            if (r0 == 0) goto L_0x01c9
            int r6 = r0.getCount()     // Catch:{ Exception -> 0x0158 }
            if (r6 <= 0) goto L_0x012f
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x012c }
            r6.<init>(r1)     // Catch:{ Exception -> 0x012c }
            java.lang.String r3 = "\n"
            java.lang.String r7 = "UTF-8"
            byte[] r3 = r3.getBytes(r7)     // Catch:{ Exception -> 0x0126, all -> 0x0123 }
            r6.write(r3)     // Catch:{ Exception -> 0x0126, all -> 0x0123 }
            r3 = r6
        L_0x0052:
            boolean r6 = r0.moveToNext()     // Catch:{ Exception -> 0x012c }
            if (r6 == 0) goto L_0x0121
            int r6 = r1.size()     // Catch:{ Exception -> 0x012c }
            r7 = 2000000(0x1e8480, float:2.802597E-39)
            if (r6 <= r7) goto L_0x00ab
            r3.close()     // Catch:{ Exception -> 0x012c }
            java.util.Date r6 = new java.util.Date     // Catch:{ Exception -> 0x012c }
            long r7 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()     // Catch:{ Exception -> 0x012c }
            r6.<init>(r7)     // Catch:{ Exception -> 0x012c }
            byte[] r7 = r1.toByteArray()     // Catch:{ Exception -> 0x012c }
            java.lang.String r6 = r14.a(r13, r7, r6, r5)     // Catch:{ Exception -> 0x012c }
            if (r6 == 0) goto L_0x007a
            r2.add(r6)     // Catch:{ Exception -> 0x012c }
        L_0x007a:
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x012c }
            r6.<init>()     // Catch:{ Exception -> 0x012c }
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            java.lang.String r3 = "\n"
            java.lang.String r7 = "UTF-8"
            byte[] r3 = r3.getBytes(r7)     // Catch:{ Exception -> 0x0098, all -> 0x0092 }
            r1.write(r3)     // Catch:{ Exception -> 0x0098, all -> 0x0092 }
            r3 = r1
            r1 = r6
            goto L_0x00ab
        L_0x0092:
            r13 = move-exception
            r11 = r6
            r6 = r1
            r1 = r11
            goto L_0x01a0
        L_0x0098:
            r3 = move-exception
            r7 = 1
            r11 = r3
            r3 = r1
            r1 = r6
            r6 = r11
            goto L_0x015a
        L_0x00a0:
            r13 = move-exception
            r1 = r6
            goto L_0x019f
        L_0x00a4:
            r1 = move-exception
            r7 = 1
            r11 = r6
            r6 = r1
            r1 = r11
            goto L_0x015a
        L_0x00ab:
            java.lang.String r6 = "result"
            int r6 = r0.getColumnIndexOrThrow(r6)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r7 = "lrf"
            boolean r7 = r6.startsWith(r7)     // Catch:{ Exception -> 0x0103 }
            if (r7 == 0) goto L_0x00c8
            java.lang.String r6 = r12.a((java.lang.String) r6, (boolean) r4)     // Catch:{ Exception -> 0x0103 }
            int r7 = r6.length()     // Catch:{ Exception -> 0x0103 }
            if (r7 != 0) goto L_0x00c8
            goto L_0x0052
        L_0x00c8:
            java.lang.String r7 = "p3i"
            boolean r7 = r6.startsWith(r7)     // Catch:{ Exception -> 0x0103 }
            if (r7 == 0) goto L_0x00dd
            r7 = 3
            java.lang.String r6 = r6.substring(r7)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r7 = r12.h()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r6 = r12.a((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x0103 }
        L_0x00dd:
            java.lang.String r7 = "UTF-8"
            byte[] r7 = r6.getBytes(r7)     // Catch:{ Exception -> 0x0103 }
            int r7 = r7.length     // Catch:{ Exception -> 0x0103 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103 }
            r7.<init>()     // Catch:{ Exception -> 0x0103 }
            r7.append(r6)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r6 = "\n"
            r7.append(r6)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r7 = "UTF-8"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ Exception -> 0x0103 }
            r3.write(r6)     // Catch:{ Exception -> 0x0103 }
            r3.flush()     // Catch:{ Exception -> 0x0103 }
            goto L_0x0052
        L_0x0103:
            r6 = move-exception
            java.lang.String r7 = c     // Catch:{ Exception -> 0x012c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r8.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r9 = "writeResultFile: "
            r8.append(r9)     // Catch:{ Exception -> 0x012c }
            java.lang.String r6 = r6.getMessage()     // Catch:{ Exception -> 0x012c }
            r8.append(r6)     // Catch:{ Exception -> 0x012c }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x012c }
            android.util.Log.e(r7, r6)     // Catch:{ Exception -> 0x012c }
            goto L_0x0052
        L_0x0121:
            r6 = 1
            goto L_0x0130
        L_0x0123:
            r13 = move-exception
            goto L_0x01a0
        L_0x0126:
            r3 = move-exception
            r7 = 1
            r11 = r6
            r6 = r3
            r3 = r11
            goto L_0x015a
        L_0x012c:
            r6 = move-exception
            r7 = 1
            goto L_0x015a
        L_0x012f:
            r6 = 0
        L_0x0130:
            if (r3 == 0) goto L_0x0135
            r3.close()     // Catch:{ IOException -> 0x0139 }
        L_0x0135:
            r1.close()     // Catch:{ IOException -> 0x0139 }
            goto L_0x019b
        L_0x0139:
            r3 = move-exception
            java.lang.String r7 = c     // Catch:{ all -> 0x0233 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0233 }
            r8.<init>()     // Catch:{ all -> 0x0233 }
            java.lang.String r9 = "writeResultFile: "
            r8.append(r9)     // Catch:{ all -> 0x0233 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0233 }
            r8.append(r3)     // Catch:{ all -> 0x0233 }
            java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x0233 }
            android.util.Log.e(r7, r3)     // Catch:{ all -> 0x0233 }
            goto L_0x019b
        L_0x0156:
            r13 = move-exception
            goto L_0x019f
        L_0x0158:
            r6 = move-exception
            r7 = 0
        L_0x015a:
            java.lang.String r8 = c     // Catch:{ all -> 0x0156 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0156 }
            r9.<init>()     // Catch:{ all -> 0x0156 }
            java.lang.String r10 = "writeResultFile: "
            r9.append(r10)     // Catch:{ all -> 0x0156 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0156 }
            r9.append(r6)     // Catch:{ all -> 0x0156 }
            java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0156 }
            android.util.Log.e(r8, r6)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x017a
            r3.close()     // Catch:{ IOException -> 0x017e }
        L_0x017a:
            r1.close()     // Catch:{ IOException -> 0x017e }
            goto L_0x019a
        L_0x017e:
            r3 = move-exception
            java.lang.String r6 = c     // Catch:{ all -> 0x0233 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0233 }
            r8.<init>()     // Catch:{ all -> 0x0233 }
            java.lang.String r9 = "writeResultFile: "
            r8.append(r9)     // Catch:{ all -> 0x0233 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0233 }
            r8.append(r3)     // Catch:{ all -> 0x0233 }
            java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x0233 }
            android.util.Log.e(r6, r3)     // Catch:{ all -> 0x0233 }
        L_0x019a:
            r6 = r7
        L_0x019b:
            r0.close()     // Catch:{ all -> 0x0233 }
            goto L_0x01ca
        L_0x019f:
            r6 = r3
        L_0x01a0:
            if (r6 == 0) goto L_0x01a5
            r6.close()     // Catch:{ IOException -> 0x01a9 }
        L_0x01a5:
            r1.close()     // Catch:{ IOException -> 0x01a9 }
            goto L_0x01c5
        L_0x01a9:
            r14 = move-exception
            java.lang.String r1 = c     // Catch:{ all -> 0x0233 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0233 }
            r2.<init>()     // Catch:{ all -> 0x0233 }
            java.lang.String r3 = "writeResultFile: "
            r2.append(r3)     // Catch:{ all -> 0x0233 }
            java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x0233 }
            r2.append(r14)     // Catch:{ all -> 0x0233 }
            java.lang.String r14 = r2.toString()     // Catch:{ all -> 0x0233 }
            android.util.Log.e(r1, r14)     // Catch:{ all -> 0x0233 }
        L_0x01c5:
            r0.close()     // Catch:{ all -> 0x0233 }
            throw r13     // Catch:{ all -> 0x0233 }
        L_0x01c9:
            r6 = 0
        L_0x01ca:
            if (r6 == 0) goto L_0x01e2
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x0233 }
            long r6 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()     // Catch:{ all -> 0x0233 }
            r0.<init>(r6)     // Catch:{ all -> 0x0233 }
            byte[] r1 = r1.toByteArray()     // Catch:{ all -> 0x0233 }
            java.lang.String r14 = r14.a(r13, r1, r0, r5)     // Catch:{ all -> 0x0233 }
            if (r14 == 0) goto L_0x01e2
            r2.add(r14)     // Catch:{ all -> 0x0233 }
        L_0x01e2:
            android.database.sqlite.SQLiteDatabase r14 = r12.a     // Catch:{ SQLException -> 0x01f6, IllegalStateException -> 0x01f4 }
            java.lang.String r0 = "result"
            java.lang.String r1 = "filetype = ?"
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ SQLException -> 0x01f6, IllegalStateException -> 0x01f4 }
            java.lang.String r13 = r13.toString()     // Catch:{ SQLException -> 0x01f6, IllegalStateException -> 0x01f4 }
            r3[r5] = r13     // Catch:{ SQLException -> 0x01f6, IllegalStateException -> 0x01f4 }
            r14.delete(r0, r1, r3)     // Catch:{ SQLException -> 0x01f6, IllegalStateException -> 0x01f4 }
            goto L_0x0231
        L_0x01f4:
            r13 = move-exception
            goto L_0x01f7
        L_0x01f6:
            r13 = move-exception
        L_0x01f7:
            java.lang.String r14 = c     // Catch:{ all -> 0x0233 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0233 }
            r0.<init>()     // Catch:{ all -> 0x0233 }
            java.lang.String r1 = "writeResultFile: "
            r0.append(r1)     // Catch:{ all -> 0x0233 }
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x0233 }
            r0.append(r13)     // Catch:{ all -> 0x0233 }
            java.lang.String r13 = r0.toString()     // Catch:{ all -> 0x0233 }
            android.util.Log.e(r14, r13)     // Catch:{ all -> 0x0233 }
            java.util.Iterator r13 = r2.iterator()     // Catch:{ all -> 0x0233 }
        L_0x0216:
            boolean r14 = r13.hasNext()     // Catch:{ all -> 0x0233 }
            if (r14 == 0) goto L_0x0231
            java.lang.Object r14 = r13.next()     // Catch:{ all -> 0x0233 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x0233 }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0233 }
            r0.<init>(r14)     // Catch:{ all -> 0x0233 }
            boolean r14 = r0.exists()     // Catch:{ all -> 0x0233 }
            if (r14 == 0) goto L_0x0216
            r0.delete()     // Catch:{ all -> 0x0233 }
            goto L_0x0216
        L_0x0231:
            monitor-exit(r12)
            return
        L_0x0233:
            r13 = move-exception
            monitor-exit(r12)
            goto L_0x0237
        L_0x0236:
            throw r13
        L_0x0237:
            goto L_0x0236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.u1.a(com.umlaut.crowd.internal.w2, com.umlaut.crowd.internal.p1):void");
    }

    public synchronized void a(long j2) {
        Cursor query;
        long j3 = j2 * 24 * 60 * 60 * 1000;
        try {
            String[] strArr = {"" + j3};
            query = this.a.query("result", new String[]{"result"}, "strftime('%s','now') * 1000 - timestamp > CAST(? as INTEGER)", strArr, (String) null, (String) null, (String) null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        String string = query.getString(query.getColumnIndexOrThrow("result"));
                        if (string.startsWith(n)) {
                            a(string);
                        }
                    } catch (Exception e2) {
                        String str = c;
                        Log.e(str, "truncateResultsOlderThanDays: " + e2.getMessage());
                        query.close();
                    }
                }
                query.close();
            }
            this.a.delete("result", "strftime('%s','now') * 1000 - timestamp > CAST(? as INTEGER)", strArr);
        } catch (Exception e3) {
            String str2 = c;
            Log.e(str2, "truncateResultsOlderThanDays: " + e3.getMessage());
        } catch (Throwable th) {
            query.close();
            throw th;
        }
        return;
    }

    private void a(byte[] bArr) {
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (i2 != -1) {
                i2 = gZIPInputStream.read();
                if (i2 != -1) {
                    byteArrayOutputStream.write(i2);
                }
            }
            gZIPInputStream.close();
            byteArrayOutputStream.close();
            new String(byteArrayOutputStream.toByteArray(), "UTF-8");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void a(long j2, w2 w2Var, String str) {
        if (str != null && str.length() != 0 && w2Var != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(j2));
                contentValues.put("filetype", w2Var.toString());
                contentValues.put("result", m + b(str, h()));
                this.a.insert("result", (String) null, contentValues);
            } catch (SQLException e2) {
                String str2 = c;
                Log.e(str2, "insertJsonIntoTable: " + e2.getMessage());
            }
        }
    }

    private void a(long j2, w2 w2Var, RBR[] rbrArr) {
        if (rbrArr != null && rbrArr.length != 0 && w2Var != null) {
            ThreadManager.getInstance().getIOThreadExecutor().execute(new a(new b(j2, w2Var, rbrArr)));
        }
    }

    private String a(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            byte[] decode = Base64.decode(str, 11);
            byte[] bArr = new byte[decode.length];
            for (int i2 = 0; i2 < decode.length; i2++) {
                bArr[i2] = (byte) (decode[i2] ^ bytes[i2 % bytes.length]);
            }
            return new String(bArr, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086 A[SYNTHETIC, Splitter:B:23:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b0 A[SYNTHETIC, Splitter:B:32:0x00b0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = "readResultFromFile: "
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r3 = r7.b
            java.io.File r3 = r3.getFilesDir()
            r2.append(r3)
            java.lang.String r3 = "/insight/largestorage/"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r8)
            boolean r8 = r1.exists()
            if (r8 != 0) goto L_0x0027
            java.lang.String r8 = ""
            return r8
        L_0x0027:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006b }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x006b }
            r4.<init>(r1)     // Catch:{ IOException -> 0x006b }
            r3.<init>(r4)     // Catch:{ IOException -> 0x006b }
        L_0x0037:
            java.lang.String r2 = r3.readLine()     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            if (r2 == 0) goto L_0x0046
            r8.append(r2)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            r2 = 10
            r8.append(r2)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            goto L_0x0037
        L_0x0046:
            r3.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x00a0
        L_0x004a:
            r2 = move-exception
            java.lang.String r3 = c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = r2.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r3, r0)
            goto L_0x00a0
        L_0x0061:
            r8 = move-exception
            r2 = r3
            goto L_0x00ae
        L_0x0064:
            r2 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x006c
        L_0x0069:
            r8 = move-exception
            goto L_0x00ae
        L_0x006b:
            r3 = move-exception
        L_0x006c:
            java.lang.String r4 = c     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r5.<init>()     // Catch:{ all -> 0x0069 }
            r5.append(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0069 }
            r5.append(r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0069 }
            android.util.Log.e(r4, r3)     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x00a0
            r2.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x00a0
        L_0x008a:
            r2 = move-exception
            java.lang.String r3 = c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = r2.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r3, r0)
        L_0x00a0:
            if (r9 == 0) goto L_0x00a5
            r1.delete()
        L_0x00a5:
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = com.umlaut.crowd.internal.aa.a((java.lang.String) r8)
            return r8
        L_0x00ae:
            if (r2 == 0) goto L_0x00ca
            r2.close()     // Catch:{ IOException -> 0x00b4 }
            goto L_0x00ca
        L_0x00b4:
            r9 = move-exception
            java.lang.String r1 = c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r9 = r9.getMessage()
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            android.util.Log.e(r1, r9)
        L_0x00ca:
            goto L_0x00cc
        L_0x00cb:
            throw r8
        L_0x00cc:
            goto L_0x00cb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.u1.a(java.lang.String, boolean):java.lang.String");
    }

    private boolean a(String str) {
        File file = new File(this.b.getFilesDir() + CCS.d, str);
        if (!file.exists()) {
            return true;
        }
        return file.delete();
    }
}
