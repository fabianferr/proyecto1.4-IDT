package com.mbridge.msdk.foundation.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.out.Campaign;

/* compiled from: VideoDao */
public final class p extends a<Campaign> {
    private static p a;

    private p(g gVar) {
        super(gVar);
    }

    public static synchronized p a(g gVar) {
        p pVar;
        synchronized (p.class) {
            if (a == null) {
                a = new p(gVar);
            }
            pVar = a;
        }
        return pVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.mbridge.msdk.foundation.entity.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.mbridge.msdk.foundation.entity.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.mbridge.msdk.foundation.entity.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:29|(2:44|45)|46|47) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0095, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0097, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0098, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00bb */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b0 A[SYNTHETIC, Splitter:B:36:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b8 A[SYNTHETIC, Splitter:B:44:0x00b8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.mbridge.msdk.foundation.entity.m a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "SELECT * FROM video WHERE video_url = '"
            monitor-enter(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00bc }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r5)
            return r2
        L_0x000c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a3 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00a3 }
            r1.append(r6)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r6 = "'"
            r1.append(r6)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x00a3 }
            android.database.sqlite.SQLiteDatabase r0 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x00a3 }
            android.database.Cursor r6 = r0.rawQuery(r6, r2)     // Catch:{ Exception -> 0x00a3 }
            if (r6 == 0) goto L_0x009b
            int r0 = r6.getCount()     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
            if (r0 <= 0) goto L_0x009b
            com.mbridge.msdk.foundation.entity.m r0 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
            r0.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
        L_0x0032:
            boolean r1 = r6.moveToNext()     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            if (r1 == 0) goto L_0x0090
            java.lang.String r1 = "video_url"
            int r1 = r6.getColumnIndex(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            java.lang.String r1 = r6.getString(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            r0.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            java.lang.String r1 = "video_state"
            int r1 = r6.getColumnIndex(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            int r1 = r6.getInt(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            r0.b((int) r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            java.lang.String r1 = "pregeress_size"
            int r1 = r6.getColumnIndex(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            long r1 = r6.getLong(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            r0.b((long) r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            java.lang.String r1 = "total_size"
            int r1 = r6.getColumnIndex(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            int r1 = r6.getInt(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            r0.a((int) r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            java.lang.String r1 = "video_path"
            int r1 = r6.getColumnIndex(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            java.lang.String r1 = r6.getString(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            r0.b((java.lang.String) r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            java.lang.String r1 = "video_download_start"
            int r1 = r6.getColumnIndex(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            long r1 = r6.getLong(r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r0.a((long) r1)     // Catch:{ Exception -> 0x0092, all -> 0x0094 }
            goto L_0x0032
        L_0x0090:
            r2 = r0
            goto L_0x009b
        L_0x0092:
            r1 = move-exception
            goto L_0x0099
        L_0x0094:
            r0 = move-exception
            r2 = r6
            goto L_0x00b6
        L_0x0097:
            r1 = move-exception
            r0 = r2
        L_0x0099:
            r2 = r6
            goto L_0x00a5
        L_0x009b:
            if (r6 == 0) goto L_0x00b4
            r6.close()     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00b4
        L_0x00a1:
            r0 = move-exception
            goto L_0x00b6
        L_0x00a3:
            r1 = move-exception
            r0 = r2
        L_0x00a5:
            java.lang.String r6 = "VideoDao"
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch:{ all -> 0x00a1 }
            com.mbridge.msdk.foundation.tools.aa.d(r6, r1)     // Catch:{ all -> 0x00a1 }
            if (r2 == 0) goto L_0x00b3
            r2.close()     // Catch:{ Exception -> 0x00b3 }
        L_0x00b3:
            r2 = r0
        L_0x00b4:
            monitor-exit(r5)
            return r2
        L_0x00b6:
            if (r2 == 0) goto L_0x00bb
            r2.close()     // Catch:{ Exception -> 0x00bb }
        L_0x00bb:
            throw r0     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x00c0
        L_0x00bf:
            throw r6
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.a(java.lang.String):com.mbridge.msdk.foundation.entity.m");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.mbridge.msdk.foundation.entity.m, java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|(2:23|24)|25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009e, code lost:
        if (r2 != 0) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ac, code lost:
        if (r2 == 0) goto L_0x00af;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00aa */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.mbridge.msdk.foundation.entity.m a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r7 = "SELECT * FROM video"
            java.lang.String r0 = " WHERE video_url = '"
            monitor-enter(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00b1 }
            r2 = 0
            if (r1 == 0) goto L_0x000e
            monitor-exit(r5)
            return r2
        L_0x000e:
            com.mbridge.msdk.foundation.entity.m r1 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ all -> 0x00b1 }
            r1.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r3.<init>(r0)     // Catch:{ all -> 0x00b1 }
            r3.append(r6)     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = "'"
            r3.append(r6)     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r0.<init>(r7)     // Catch:{ all -> 0x00b1 }
            r0.append(r6)     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x00b1 }
            android.database.sqlite.SQLiteDatabase r7 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            android.database.Cursor r2 = r7.rawQuery(r6, r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            if (r2 == 0) goto L_0x009e
            int r6 = r2.getCount()     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            if (r6 <= 0) goto L_0x009e
        L_0x0040:
            boolean r6 = r2.moveToNext()     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            if (r6 == 0) goto L_0x009e
            java.lang.String r6 = "video_url"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            r1.a((java.lang.String) r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            java.lang.String r6 = "video_state"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            int r6 = r2.getInt(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            r1.b((int) r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            java.lang.String r6 = "pregeress_size"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            long r6 = r2.getLong(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            r1.b((long) r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            java.lang.String r6 = "total_size"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            int r6 = r2.getInt(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            r1.a((int) r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            java.lang.String r6 = "video_path"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            r1.b((java.lang.String) r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            java.lang.String r6 = "video_download_start"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            long r6 = r2.getLong(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r3
            r1.a((long) r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a4 }
            goto L_0x0040
        L_0x009e:
            if (r2 == 0) goto L_0x00af
        L_0x00a0:
            r2.close()     // Catch:{ Exception -> 0x00af }
            goto L_0x00af
        L_0x00a4:
            r6 = move-exception
            if (r2 == 0) goto L_0x00aa
            r2.close()     // Catch:{ Exception -> 0x00aa }
        L_0x00aa:
            throw r6     // Catch:{ all -> 0x00b1 }
        L_0x00ab:
            if (r2 == 0) goto L_0x00af
            goto L_0x00a0
        L_0x00af:
            monitor-exit(r5)
            return r1
        L_0x00b1:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x00b5
        L_0x00b4:
            throw r6
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.a(java.lang.String, java.lang.String):com.mbridge.msdk.foundation.entity.m");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "video_url = '"
            monitor-enter(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            r1.append(r4)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.lang.String r4 = "'"
            r1.append(r4)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r3)
            return
        L_0x001d:
            android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.lang.String r1 = "video"
            r2 = 0
            r0.delete(r1, r4, r2)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x002c:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.b(java.lang.String):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r6, long r7) {
        /*
            r5 = this;
            java.lang.String r0 = "video_url = '"
            monitor-enter(r5)
            r1 = 0
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r1.<init>()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            java.lang.String r2 = "video_download_start"
            r3 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r3
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r1.put(r2, r7)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            java.lang.String r7 = ""
            boolean r7 = r5.b((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            if (r7 == 0) goto L_0x0046
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r7.append(r6)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            java.lang.String r6 = "'"
            r7.append(r6)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            android.database.sqlite.SQLiteDatabase r7 = r5.getWritableDatabase()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            java.lang.String r8 = "video"
            r0 = 0
            r7.update(r8, r1, r6, r0)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            goto L_0x0046
        L_0x0043:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0046:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.a(java.lang.String, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0181, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(com.mbridge.msdk.foundation.entity.CampaignEx r10, long r11, java.lang.String r13, int r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            if (r10 != 0) goto L_0x0007
            monitor-exit(r9)
            return r0
        L_0x0007:
            r2 = -1
            android.database.sqlite.SQLiteDatabase r4 = r9.getWritableDatabase()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            if (r4 != 0) goto L_0x0011
            monitor-exit(r9)
            return r2
        L_0x0011:
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.<init>()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "unitid"
            java.lang.String r6 = r10.getCampaignUnitId()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "id"
            java.lang.String r6 = r10.getId()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "package_name"
            java.lang.String r6 = r10.getPackageName()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "app_name"
            java.lang.String r6 = r10.getAppName()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "app_desc"
            java.lang.String r6 = r10.getAppDesc()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "app_size"
            java.lang.String r6 = r10.getSize()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "image_size"
            java.lang.String r6 = r10.getImageSize()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "icon_url"
            java.lang.String r6 = r10.getIconUrl()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "image_url"
            java.lang.String r6 = r10.getImageUrl()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "impression_url"
            java.lang.String r6 = r10.getImpressionURL()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "notice_url"
            java.lang.String r6 = r10.getNoticeUrl()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "download_url"
            java.lang.String r6 = r10.getClickURL()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "only_impression"
            java.lang.String r6 = r10.getOnlyImpressionURL()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "ts"
            long r6 = r10.getTimestamp()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "template"
            int r6 = r10.getTemplate()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "click_mode"
            java.lang.String r6 = r10.getClick_mode()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "landing_type"
            java.lang.String r6 = r10.getLandingType()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "link_type"
            int r6 = r10.getLinkType()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "star"
            double r6 = r10.getRating()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "cti"
            int r6 = r10.getClickInterval()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "level"
            int r6 = r10.getCacheLevel()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "adSource"
            int r6 = r10.getType()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "ad_call"
            java.lang.String r6 = r10.getAdCall()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "fc_a"
            int r6 = r10.getFca()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "ad_url_list"
            java.lang.String r6 = r10.getAd_url_list()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "video_url"
            java.lang.String r6 = r10.getVideoUrlEncode()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r5 = "total_size"
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r5, r11)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r11 = "video_state"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r11, r12)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r11 = "video_download_start"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            java.lang.Long r12 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r11, r12)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r11 = "ad_bid_token"
            java.lang.String r12 = r10.getBidToken()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            r4.put(r11, r12)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            boolean r11 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            if (r11 != 0) goto L_0x015f
            java.lang.String r11 = "video_path"
            r4.put(r11, r13)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
        L_0x015f:
            java.lang.String r11 = r10.getVideoUrlEncode()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r10 = r10.getId()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            boolean r10 = r9.b((java.lang.String) r11, (java.lang.String) r10)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            if (r10 == 0) goto L_0x016f
            monitor-exit(r9)
            return r0
        L_0x016f:
            android.database.sqlite.SQLiteDatabase r10 = r9.getWritableDatabase()     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            java.lang.String r11 = "video"
            r12 = 0
            long r10 = r10.insert(r11, r12, r4)     // Catch:{ Exception -> 0x0180, all -> 0x017d }
            monitor-exit(r9)
            return r10
        L_0x017d:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x0180:
            monitor-exit(r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.a(com.mbridge.msdk.foundation.entity.CampaignEx, long, java.lang.String, int):long");
    }

    private synchronized boolean b(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = "SELECT id FROM video WHERE video_url = '" + str + "'";
        } else {
            str3 = "SELECT id FROM video WHERE video_url = '" + str + "' AND id = " + str2;
        }
        Cursor rawQuery = getReadableDatabase().rawQuery(str3, (String[]) null);
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
        } else if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return true;
        return false;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized long a(java.lang.String r5, long r6, int r8) {
        /*
            r4 = this;
            java.lang.String r0 = "video_url = '"
            monitor-enter(r4)
            r1 = -1
            android.database.sqlite.SQLiteDatabase r2 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r2 != 0) goto L_0x000e
            long r5 = (long) r1
            monitor-exit(r4)
            return r5
        L_0x000e:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r2.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r3 = "pregeress_size"
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r2.put(r3, r6)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r6 = "video_state"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r2.put(r6, r7)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r6 = ""
            boolean r6 = r4.b((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r6 == 0) goto L_0x0059
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r6.append(r5)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r5 = "'"
            r6.append(r5)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.Object r6 = new java.lang.Object     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r6.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            monitor-enter(r6)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            android.database.sqlite.SQLiteDatabase r7 = r4.getWritableDatabase()     // Catch:{ all -> 0x0053 }
            java.lang.String r8 = "video"
            r0 = 0
            int r1 = r7.update(r8, r2, r5, r0)     // Catch:{ all -> 0x0053 }
            monitor-exit(r6)     // Catch:{ all -> 0x0053 }
            goto L_0x0059
        L_0x0053:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0053 }
            throw r5     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        L_0x0056:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0059:
            long r5 = (long) r1
            monitor-exit(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.a(java.lang.String, long, int):long");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized long b(java.lang.String r5, long r6) {
        /*
            r4 = this;
            java.lang.String r0 = "video_url = '"
            monitor-enter(r4)
            r1 = -1
            android.database.sqlite.SQLiteDatabase r2 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            if (r2 != 0) goto L_0x000e
            long r5 = (long) r1
            monitor-exit(r4)
            return r5
        L_0x000e:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r2.<init>()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r3 = "total_size"
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r2.put(r3, r6)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r6 = ""
            boolean r6 = r4.b((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            if (r6 == 0) goto L_0x0050
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r6.append(r5)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r5 = "'"
            r6.append(r5)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.Object r6 = new java.lang.Object     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r6.<init>()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            monitor-enter(r6)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            android.database.sqlite.SQLiteDatabase r7 = r4.getWritableDatabase()     // Catch:{ all -> 0x004a }
            java.lang.String r0 = "video"
            r3 = 0
            int r1 = r7.update(r0, r2, r5, r3)     // Catch:{ all -> 0x004a }
            monitor-exit(r6)     // Catch:{ all -> 0x004a }
            goto L_0x0050
        L_0x004a:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004a }
            throw r5     // Catch:{ Exception -> 0x0050, all -> 0x004d }
        L_0x004d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0050:
            long r5 = (long) r1
            monitor-exit(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.b(java.lang.String, long):long");
    }
}
