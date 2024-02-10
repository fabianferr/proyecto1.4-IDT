package com.mbridge.msdk.foundation.db;

import com.mbridge.msdk.foundation.entity.g;

/* compiled from: FrequenceDao */
public final class k extends a<g> {
    private static k a;

    private k(g gVar) {
        super(gVar);
    }

    public static synchronized k a(g gVar) {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                a = new k(gVar);
            }
            kVar = a;
        }
        return kVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r0 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r0 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long[] a() {
        /*
            r7 = this;
            java.lang.String r0 = "SELECT id FROM frequence WHERE fc_a<impression_count"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r7.getReadableDatabase()     // Catch:{ Exception -> 0x0046, all -> 0x003c }
            android.database.Cursor r0 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x0046, all -> 0x003c }
            if (r0 == 0) goto L_0x0039
            int r2 = r0.getCount()     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
            if (r2 <= 0) goto L_0x0039
            int r2 = r0.getCount()     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
            long[] r2 = new long[r2]     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
            r3 = 0
        L_0x001a:
            boolean r4 = r0.moveToNext()     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            java.lang.String r4 = "id"
            int r4 = r0.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
            long r4 = r0.getLong(r4)     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
            r2[r3] = r4     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
            int r3 = r3 + 1
            goto L_0x001a
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()
        L_0x0034:
            return r2
        L_0x0035:
            r1 = move-exception
            goto L_0x0040
        L_0x0037:
            goto L_0x0048
        L_0x0039:
            if (r0 == 0) goto L_0x004d
            goto L_0x004a
        L_0x003c:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0040:
            if (r0 == 0) goto L_0x0045
            r0.close()
        L_0x0045:
            throw r1
        L_0x0046:
            r0 = r1
        L_0x0048:
            if (r0 == 0) goto L_0x004d
        L_0x004a:
            r0.close()
        L_0x004d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.a():long[]");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b() {
        /*
            r5 = this;
            java.lang.String r0 = "ts<"
            monitor-enter(r5)
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            r3 = 86400000(0x5265c00, double:4.2687272E-316)
            long r1 = r1 - r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            r3.append(r1)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            android.database.sqlite.SQLiteDatabase r1 = r5.getWritableDatabase()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            if (r1 == 0) goto L_0x002c
            android.database.sqlite.SQLiteDatabase r1 = r5.getWritableDatabase()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.lang.String r2 = "frequence"
            r3 = 0
            r1.delete(r2, r0, r3)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x002c:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.b():void");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized boolean a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "SELECT id FROM frequence WHERE id='"
            monitor-enter(r5)
            r1 = 0
            r2 = 0
            monitor-enter(r6)     // Catch:{ Exception -> 0x004e, all -> 0x0045 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r3.<init>(r0)     // Catch:{ all -> 0x0038 }
            r3.append(r6)     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = "'"
            r3.append(r0)     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r3 = r5.getReadableDatabase()     // Catch:{ all -> 0x0038 }
            android.database.Cursor r0 = r3.rawQuery(r0, r2)     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0030
            int r2 = r0.getCount()     // Catch:{ all -> 0x0043 }
            if (r2 <= 0) goto L_0x0030
            monitor-exit(r6)     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x002d
            r0.close()     // Catch:{ all -> 0x004c }
        L_0x002d:
            monitor-exit(r5)
            r6 = 1
            return r6
        L_0x0030:
            monitor-exit(r6)     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ all -> 0x004c }
        L_0x0036:
            monitor-exit(r5)
            return r1
        L_0x0038:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L_0x003c:
            monitor-exit(r6)     // Catch:{ all -> 0x0043 }
            throw r2     // Catch:{ Exception -> 0x0041, all -> 0x003e }
        L_0x003e:
            r6 = move-exception
            r2 = r0
            goto L_0x0046
        L_0x0041:
            r2 = r0
            goto L_0x004e
        L_0x0043:
            r2 = move-exception
            goto L_0x003c
        L_0x0045:
            r6 = move-exception
        L_0x0046:
            if (r2 == 0) goto L_0x004b
            r2.close()     // Catch:{ all -> 0x004c }
        L_0x004b:
            throw r6     // Catch:{ all -> 0x004c }
        L_0x004c:
            r6 = move-exception
            goto L_0x0054
        L_0x004e:
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ all -> 0x004c }
            goto L_0x0056
        L_0x0054:
            monitor-exit(r5)
            throw r6
        L_0x0056:
            monitor-exit(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.a(java.lang.String):boolean");
    }

    public final synchronized void b(String str) {
        if (a(str)) {
            String str2 = "UPDATE frequence Set impression_count=impression_count+1 WHERE id=" + str;
            if (getReadableDatabase() != null) {
                getReadableDatabase().execSQL(str2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007a, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long b(com.mbridge.msdk.foundation.entity.g r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = -1
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "id"
            java.lang.String r4 = r7.a()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "fc_a"
            int r4 = r7.b()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "fc_b"
            int r4 = r7.c()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "ts"
            long r4 = r7.f()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "impression_count"
            int r4 = r7.d()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "click_count"
            int r4 = r7.e()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "ts"
            long r4 = r7.f()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.put(r3, r7)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            android.database.sqlite.SQLiteDatabase r7 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r7 != 0) goto L_0x0069
            monitor-exit(r6)
            return r0
        L_0x0069:
            android.database.sqlite.SQLiteDatabase r7 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r3 = "frequence"
            r4 = 0
            long r0 = r7.insert(r3, r4, r2)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            monitor-exit(r6)
            return r0
        L_0x0076:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x0079:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.b(com.mbridge.msdk.foundation.entity.g):long");
    }

    public final synchronized void a(g gVar) {
        if (!a(gVar.a())) {
            b(gVar);
        }
    }
}
