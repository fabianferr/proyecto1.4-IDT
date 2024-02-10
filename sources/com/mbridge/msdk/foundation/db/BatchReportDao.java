package com.mbridge.msdk.foundation.db;

import android.content.Context;
import com.mbridge.msdk.foundation.same.report.BatchReportMessage;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

public class BatchReportDao extends a<BatchReportMessage> implements NoProGuard, Serializable {
    private static volatile BatchReportDao instance;

    protected BatchReportDao(g gVar) {
        super(gVar);
    }

    public static BatchReportDao getInstance(g gVar) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                if (instance == null) {
                    instance = new BatchReportDao(gVar);
                }
            }
        }
        return instance;
    }

    public static BatchReportDao getInstance(Context context) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                if (instance == null) {
                    instance = new BatchReportDao(h.a(context));
                }
            }
        }
        return instance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addReportMessage(java.lang.String r6, int r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.database.sqlite.SQLiteDatabase r0 = r5.getWritableDatabase()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x0063
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0063
            boolean r1 = r0.isReadOnly()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0014
            goto L_0x0063
        L_0x0014:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ Exception -> 0x005d }
            r1.<init>()     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = "report_message"
            r1.put(r2, r6)     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = "time"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005d }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x005d }
            r1.put(r6, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = "uuid"
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x005d }
            java.lang.String r3 = "-"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ Exception -> 0x005d }
            r1.put(r6, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = "report_state"
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x005d }
            r1.put(r6, r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = "type"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x005d }
            r1.put(r6, r7)     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = "batch_report"
            r7 = 0
            r0.insert(r6, r7, r1)     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0065 }
        L_0x0061:
            monitor-exit(r5)
            return
        L_0x0063:
            monitor-exit(r5)
            return
        L_0x0065:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.BatchReportDao.addReportMessage(java.lang.String, int):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:23|(0)|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|(2:(3:17|15|14)|44)|(2:21|22)|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00af, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b5, code lost:
        if (r5 != null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bc, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0088 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ba */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7 A[SYNTHETIC, Splitter:B:35:0x00b7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.ArrayList<com.mbridge.msdk.foundation.same.report.BatchReportMessage> getBatchReportMessages(long r10, int r12) {
        /*
            r9 = this;
            java.lang.String r0 = " ORDER BY time ASC "
            java.lang.String r1 = " = "
            java.lang.String r2 = " AND report_state = 0 AND type"
            java.lang.String r3 = "SELECT * FROM batch_report WHERE time <= "
            monitor-enter(r9)
            android.database.sqlite.SQLiteDatabase r4 = r9.getWritableDatabase()     // Catch:{ all -> 0x00bd }
            r5 = 0
            if (r4 == 0) goto L_0x00bb
            boolean r6 = r4.isOpen()     // Catch:{ all -> 0x00bd }
            if (r6 == 0) goto L_0x00bb
            boolean r6 = r4.isReadOnly()     // Catch:{ all -> 0x00bd }
            if (r6 == 0) goto L_0x001e
            goto L_0x00bb
        L_0x001e:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00bd }
            r6.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r7.<init>(r3)     // Catch:{ all -> 0x00bd }
            r7.append(r10)     // Catch:{ all -> 0x00bd }
            r7.append(r2)     // Catch:{ all -> 0x00bd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r2.<init>(r1)     // Catch:{ all -> 0x00bd }
            r2.append(r12)     // Catch:{ all -> 0x00bd }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x00bd }
            r7.append(r12)     // Catch:{ all -> 0x00bd }
            r7.append(r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r12 = r7.toString()     // Catch:{ Exception -> 0x0084 }
            android.database.Cursor r12 = r4.rawQuery(r12, r5)     // Catch:{ Exception -> 0x0084 }
            if (r12 == 0) goto L_0x007c
        L_0x004a:
            boolean r0 = r12.moveToNext()     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            if (r0 == 0) goto L_0x007c
            com.mbridge.msdk.foundation.same.report.BatchReportMessage r0 = new com.mbridge.msdk.foundation.same.report.BatchReportMessage     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            java.lang.String r1 = "uuid"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            java.lang.String r2 = "report_message"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            java.lang.String r3 = "time"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            long r7 = r12.getLong(r3)     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            r0.<init>(r1, r2, r7)     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            r6.add(r0)     // Catch:{ Exception -> 0x0084, all -> 0x0079 }
            goto L_0x004a
        L_0x0079:
            r10 = move-exception
            r5 = r12
            goto L_0x00b5
        L_0x007c:
            if (r12 == 0) goto L_0x0088
            r12.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x0088
        L_0x0082:
            r10 = move-exception
            goto L_0x00b5
        L_0x0084:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x0082 }
        L_0x0088:
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ Exception -> 0x00af }
            r12.<init>()     // Catch:{ Exception -> 0x00af }
            java.lang.String r0 = "report_state"
            r1 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00af }
            r12.put(r0, r1)     // Catch:{ Exception -> 0x00af }
            java.lang.String r0 = "batch_report"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r1.<init>()     // Catch:{ Exception -> 0x00af }
            java.lang.String r2 = "time <= "
            r1.append(r2)     // Catch:{ Exception -> 0x00af }
            r1.append(r10)     // Catch:{ Exception -> 0x00af }
            java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x00af }
            r4.update(r0, r12, r10, r5)     // Catch:{ Exception -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x00bd }
        L_0x00b3:
            monitor-exit(r9)
            return r6
        L_0x00b5:
            if (r5 == 0) goto L_0x00ba
            r5.close()     // Catch:{ Exception -> 0x00ba }
        L_0x00ba:
            throw r10     // Catch:{ all -> 0x00bd }
        L_0x00bb:
            monitor-exit(r9)
            return r5
        L_0x00bd:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x00c1
        L_0x00c0:
            throw r10
        L_0x00c1:
            goto L_0x00c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.BatchReportDao.getBatchReportMessages(long, int):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateMessagesReportState(java.util.ArrayList<com.mbridge.msdk.foundation.same.report.BatchReportMessage> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0069
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0069
            boolean r1 = r0.isReadOnly()     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0014
            goto L_0x0069
        L_0x0014:
            if (r7 == 0) goto L_0x0067
            int r1 = r7.size()     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0067
            if (r0 != 0) goto L_0x001f
            goto L_0x0067
        L_0x001f:
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x006b }
        L_0x0023:
            boolean r1 = r7.hasNext()     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0065
            java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x006b }
            com.mbridge.msdk.foundation.same.report.BatchReportMessage r1 = (com.mbridge.msdk.foundation.same.report.BatchReportMessage) r1     // Catch:{ all -> 0x006b }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x0060 }
            r2.<init>()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = "report_state"
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0060 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = "batch_report"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0060 }
            r4.<init>()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r5 = "uuid = '"
            r4.append(r5)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r1 = r1.getUuid()     // Catch:{ Exception -> 0x0060 }
            r4.append(r1)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r1 = "'"
            r4.append(r1)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0060 }
            r4 = 0
            r0.update(r3, r2, r1, r4)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0023
        L_0x0060:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x006b }
            goto L_0x0023
        L_0x0065:
            monitor-exit(r6)
            return
        L_0x0067:
            monitor-exit(r6)
            return
        L_0x0069:
            monitor-exit(r6)
            return
        L_0x006b:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x006f
        L_0x006e:
            throw r7
        L_0x006f:
            goto L_0x006e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.BatchReportDao.updateMessagesReportState(java.util.ArrayList):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void deleteBatchReportMessagesByTimestamp(long r4) {
        /*
            r3 = this;
            java.lang.String r0 = "delete from batch_report where time <= "
            monitor-enter(r3)
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x002c
            boolean r2 = r1.isOpen()     // Catch:{ all -> 0x002e }
            if (r2 == 0) goto L_0x002c
            boolean r2 = r1.isReadOnly()     // Catch:{ all -> 0x002e }
            if (r2 == 0) goto L_0x0016
            goto L_0x002c
        L_0x0016:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r2.<init>(r0)     // Catch:{ all -> 0x002e }
            r2.append(r4)     // Catch:{ all -> 0x002e }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0026 }
            r1.execSQL(r4)     // Catch:{ Exception -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x002e }
        L_0x002a:
            monitor-exit(r3)
            return
        L_0x002c:
            monitor-exit(r3)
            return
        L_0x002e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.BatchReportDao.deleteBatchReportMessagesByTimestamp(long):void");
    }
}
