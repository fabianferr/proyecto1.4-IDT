package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper implements IDatabaseHelper {
    /* access modifiers changed from: private */
    public volatile SQLiteDatabase database;
    /* access modifiers changed from: private */
    public final IDatabaseOpenHelper databaseOpenHelper;
    private final Handler handler;
    /* access modifiers changed from: private */
    public final String tableName = GlobalComponent.getInstance().getDatabaseTableName();

    public DatabaseHelper(Context context, Handler handler2, IDatabaseOpenHelper iDatabaseOpenHelper) {
        this.handler = handler2;
        this.databaseOpenHelper = iDatabaseOpenHelper;
    }

    public void find(final String str, final String str2, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x008d A[Catch:{ all -> 0x009d }] */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x0092  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00a7  */
            /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    java.lang.String r0 = "' AND director_path = '"
                    java.lang.String r1 = " WHERE download_id = '"
                    java.lang.String r2 = "SELECT * FROM "
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r3 = r3.database
                    boolean r3 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r3)
                    if (r3 == 0) goto L_0x001f
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r4 = r3.databaseOpenHelper
                    android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()
                    android.database.sqlite.SQLiteDatabase unused = r3.database = r4
                L_0x001f:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r3 = r3.database
                    boolean r3 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r3)
                    r4 = 0
                    if (r3 != 0) goto L_0x00ab
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r3 = r3.database
                    boolean r3 = r3.isOpen()
                    if (r3 != 0) goto L_0x003a
                    goto L_0x00ab
                L_0x003a:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    r3.<init>(r2)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    java.lang.String r2 = r2.tableName     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    r3.append(r2)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    r3.append(r1)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    r3.append(r1)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    r3.append(r0)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    java.lang.String r0 = r4     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    r3.append(r0)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    java.lang.String r0 = "'"
                    r3.append(r0)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.database     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    android.database.Cursor r0 = r1.rawQuery(r0, r4)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
                    if (r0 == 0) goto L_0x007a
                    boolean r1 = r0.moveToFirst()     // Catch:{ Exception -> 0x0078 }
                    if (r1 == 0) goto L_0x007a
                    com.mbridge.msdk.foundation.download.database.DownloadModel r4 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r0)     // Catch:{ Exception -> 0x0078 }
                    goto L_0x007a
                L_0x0078:
                    r1 = move-exception
                    goto L_0x0089
                L_0x007a:
                    if (r0 == 0) goto L_0x007f
                    r0.close()
                L_0x007f:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x009c
                    goto L_0x0099
                L_0x0084:
                    r1 = move-exception
                    r0 = r4
                    goto L_0x009e
                L_0x0087:
                    r1 = move-exception
                    r0 = r4
                L_0x0089:
                    boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x009d }
                    if (r2 == 0) goto L_0x0090
                    r1.printStackTrace()     // Catch:{ all -> 0x009d }
                L_0x0090:
                    if (r0 == 0) goto L_0x0095
                    r0.close()
                L_0x0095:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x009c
                L_0x0099:
                    r0.onDatabase(r4)
                L_0x009c:
                    return
                L_0x009d:
                    r1 = move-exception
                L_0x009e:
                    if (r0 == 0) goto L_0x00a3
                    r0.close()
                L_0x00a3:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x00aa
                    r0.onDatabase(r4)
                L_0x00aa:
                    throw r1
                L_0x00ab:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
                    if (r0 == 0) goto L_0x00b8
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    r0.onDatabase(r4)
                L_0x00b8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass1.run():void");
            }
        });
    }

    public void findByDownloadUrl(final String str, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0083 A[Catch:{ all -> 0x0093 }] */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0096  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
            /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    java.lang.String r0 = " WHERE download_url = '"
                    java.lang.String r1 = "SELECT * FROM "
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = r2.database
                    boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)
                    if (r2 == 0) goto L_0x001d
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r3 = r2.databaseOpenHelper
                    android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()
                    android.database.sqlite.SQLiteDatabase unused = r2.database = r3
                L_0x001d:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = r2.database
                    boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)
                    r3 = 0
                    if (r2 != 0) goto L_0x00a1
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = r2.database
                    boolean r2 = r2.isOpen()
                    if (r2 != 0) goto L_0x0038
                    goto L_0x00a1
                L_0x0038:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    r2.<init>(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    java.lang.String r1 = r1.tableName     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    r2.append(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    r2.append(r0)     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    r2.append(r0)     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    java.lang.String r0 = "'"
                    r2.append(r0)     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    android.database.sqlite.SQLiteDatabase r1 = r1.database     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    android.database.Cursor r0 = r1.rawQuery(r0, r3)     // Catch:{ Exception -> 0x007d, all -> 0x007a }
                    if (r0 == 0) goto L_0x0070
                    boolean r1 = r0.moveToFirst()     // Catch:{ Exception -> 0x006e }
                    if (r1 == 0) goto L_0x0070
                    com.mbridge.msdk.foundation.download.database.DownloadModel r3 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r0)     // Catch:{ Exception -> 0x006e }
                    goto L_0x0070
                L_0x006e:
                    r1 = move-exception
                    goto L_0x007f
                L_0x0070:
                    if (r0 == 0) goto L_0x0075
                    r0.close()
                L_0x0075:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto L_0x0092
                    goto L_0x008f
                L_0x007a:
                    r1 = move-exception
                    r0 = r3
                    goto L_0x0094
                L_0x007d:
                    r1 = move-exception
                    r0 = r3
                L_0x007f:
                    boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0093 }
                    if (r2 == 0) goto L_0x0086
                    r1.printStackTrace()     // Catch:{ all -> 0x0093 }
                L_0x0086:
                    if (r0 == 0) goto L_0x008b
                    r0.close()
                L_0x008b:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto L_0x0092
                L_0x008f:
                    r0.onDatabase(r3)
                L_0x0092:
                    return
                L_0x0093:
                    r1 = move-exception
                L_0x0094:
                    if (r0 == 0) goto L_0x0099
                    r0.close()
                L_0x0099:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    if (r0 == 0) goto L_0x00a0
                    r0.onDatabase(r3)
                L_0x00a0:
                    throw r1
                L_0x00a1:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
                    if (r0 == 0) goto L_0x00ae
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r4
                    r0.onDatabase(r3)
                L_0x00ae:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass2.run():void");
            }
        });
    }

    public void insert(final DownloadModel downloadModel) {
        this.handler.postAtFrontOfQueue(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        DatabaseHelper.this.database.beginTransaction();
                        DatabaseHelper.this.database.insert(DatabaseHelper.this.tableName, (String) null, DownloadModel.create(downloadModel));
                        DatabaseHelper.this.database.setTransactionSuccessful();
                        DatabaseHelper.this.database.endTransaction();
                        return;
                    } catch (Exception e) {
                        try {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                            DatabaseHelper.this.database.endTransaction();
                            return;
                        } catch (Throwable th) {
                            aa.d(IDatabaseHelper.TAG, th.getMessage());
                        }
                    } catch (Throwable th2) {
                        aa.d(IDatabaseHelper.TAG, th2.getMessage());
                        return;
                    }
                } else {
                    return;
                }
                throw th;
            }
        });
    }

    public void update(final DownloadModel downloadModel, final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{downloadModel.getDownloadId(), str});
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void updateProgress(final String str, final String str2, final DownloadModel downloadModel) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{str, str2});
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void remove(final String str, final String str2) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        SQLiteDatabase access$000 = DatabaseHelper.this.database;
                        access$000.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE download_id = '" + str + "' AND director_path = '" + str2 + "'");
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void remove(final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        SQLiteDatabase access$000 = DatabaseHelper.this.database;
                        access$000.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE download_id = '" + str + "'");
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
        if (r3 == 0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (r3 != 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
        return r2;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.mbridge.msdk.foundation.download.database.DownloadModel> getUnwantedModels(long r7) {
        /*
            r6 = this;
            java.lang.String r0 = " WHERE last_modified_time <= "
            java.lang.String r1 = "SELECT * FROM "
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r6.database     // Catch:{ Exception -> 0x0065 }
            boolean r4 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r4)     // Catch:{ Exception -> 0x0065 }
            if (r4 == 0) goto L_0x001a
            com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r4 = r6.databaseOpenHelper     // Catch:{ Exception -> 0x0065 }
            android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0065 }
            r6.database = r4     // Catch:{ Exception -> 0x0065 }
        L_0x001a:
            android.database.sqlite.SQLiteDatabase r4 = r6.database     // Catch:{ Exception -> 0x0065 }
            boolean r4 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r4)     // Catch:{ Exception -> 0x0065 }
            if (r4 != 0) goto L_0x0062
            android.database.sqlite.SQLiteDatabase r4 = r6.database     // Catch:{ Exception -> 0x0065 }
            boolean r4 = r4.isOpen()     // Catch:{ Exception -> 0x0065 }
            if (r4 != 0) goto L_0x002b
            goto L_0x0062
        L_0x002b:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0065 }
            long r4 = r4 - r7
            android.database.sqlite.SQLiteDatabase r7 = r6.database     // Catch:{ Exception -> 0x0065 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0065 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r1 = r6.tableName     // Catch:{ Exception -> 0x0065 }
            r8.append(r1)     // Catch:{ Exception -> 0x0065 }
            r8.append(r0)     // Catch:{ Exception -> 0x0065 }
            r8.append(r4)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0065 }
            android.database.Cursor r3 = r7.rawQuery(r8, r3)     // Catch:{ Exception -> 0x0065 }
            if (r3 == 0) goto L_0x005f
            boolean r7 = r3.moveToFirst()     // Catch:{ Exception -> 0x0065 }
            if (r7 == 0) goto L_0x005f
        L_0x0052:
            com.mbridge.msdk.foundation.download.database.DownloadModel r7 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r3)     // Catch:{ Exception -> 0x0065 }
            r2.add(r7)     // Catch:{ Exception -> 0x0065 }
            boolean r7 = r3.moveToNext()     // Catch:{ Exception -> 0x0065 }
            if (r7 != 0) goto L_0x0052
        L_0x005f:
            if (r3 == 0) goto L_0x0072
            goto L_0x006f
        L_0x0062:
            return r2
        L_0x0063:
            r7 = move-exception
            goto L_0x0073
        L_0x0065:
            r7 = move-exception
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0063 }
            if (r8 == 0) goto L_0x006d
            r7.printStackTrace()     // Catch:{ all -> 0x0063 }
        L_0x006d:
            if (r3 == 0) goto L_0x0072
        L_0x006f:
            r3.close()
        L_0x0072:
            return r2
        L_0x0073:
            if (r3 == 0) goto L_0x0078
            r3.close()
        L_0x0078:
            goto L_0x007a
        L_0x0079:
            throw r7
        L_0x007a:
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.getUnwantedModels(long):java.util.List");
    }

    public void updateUnzipResource(final String str, String str2, long j) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(DownloadModel.DOWNLOAD_ID, str);
                        SQLiteDatabase access$000 = DatabaseHelper.this.database;
                        String access$200 = DatabaseHelper.this.tableName;
                        access$000.update(access$200, contentValues, "download_id = '" + str + "'", (String[]) null);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public Cursor rawQuery(String str, String[] strArr) {
        try {
            if (Objects.isNull(this.database)) {
                this.database = this.databaseOpenHelper.getWritableDatabase();
            }
            if (!Objects.isNull(this.database)) {
                if (this.database.isOpen()) {
                    this.database.beginTransaction();
                    Cursor rawQuery = this.database.rawQuery(str, strArr);
                    this.database.setTransactionSuccessful();
                    try {
                        this.database.endTransaction();
                    } catch (Throwable th) {
                        if (MBridgeConstans.DEBUG) {
                            th.printStackTrace();
                        }
                    }
                    return rawQuery;
                }
            }
            try {
                this.database.endTransaction();
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
            return null;
        } catch (Exception e) {
            try {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                this.database.endTransaction();
            } catch (Throwable th3) {
                if (MBridgeConstans.DEBUG) {
                    th3.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            if (MBridgeConstans.DEBUG) {
                th4.printStackTrace();
            }
        }
        throw th;
        return null;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    public List<DownloadModel> findAll() {
        ArrayList arrayList = new ArrayList();
        ? r2 = 0;
        try {
            if (Objects.isNull(this.database)) {
                this.database = this.databaseOpenHelper.getWritableDatabase();
            }
            if (!Objects.isNull(this.database)) {
                if (this.database.isOpen()) {
                    Cursor rawQuery = rawQuery("SELECT * FROM " + this.tableName, r2);
                    if (rawQuery != null) {
                        while (rawQuery.moveToNext()) {
                            arrayList.add(DownloadModel.create(rawQuery));
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return arrayList;
        } catch (Throwable unused) {
            if (r2 != 0) {
                r2.close();
            }
            return arrayList;
        }
    }

    public void clear() {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(DatabaseHelper.this.database) && DatabaseHelper.this.database.isOpen()) {
                    try {
                        DatabaseHelper.this.database.beginTransaction();
                        DatabaseHelper.this.database.delete(DatabaseHelper.this.tableName, (String) null, (String[]) null);
                        DatabaseHelper.this.database.setTransactionSuccessful();
                        DatabaseHelper.this.database.endTransaction();
                        return;
                    } catch (Exception e) {
                        try {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                            DatabaseHelper.this.database.endTransaction();
                            return;
                        } catch (Throwable th) {
                            aa.d(IDatabaseHelper.TAG, th.getMessage());
                        }
                    } catch (Throwable th2) {
                        aa.d(IDatabaseHelper.TAG, th2.getMessage());
                        return;
                    }
                } else {
                    return;
                }
                throw th;
            }
        });
    }
}
