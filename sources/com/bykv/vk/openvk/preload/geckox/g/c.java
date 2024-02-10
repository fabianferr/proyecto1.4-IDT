package com.bykv.vk.openvk.preload.geckox.g;

import android.os.Process;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: UsingLock */
public final class c {
    private static final Map<String, Pair<FileLock, AtomicLong>> a = new HashMap();

    public static void a(String str) throws Exception {
        Map<String, Pair<FileLock, AtomicLong>> map = a;
        synchronized (map) {
            Pair pair = map.get(str);
            if (pair == null) {
                Pair pair2 = new Pair(FileLock.a(str, Process.myPid()), new AtomicLong(0));
                map.put(str, pair2);
                pair = pair2;
            }
            ((AtomicLong) pair.second).incrementAndGet();
        }
    }

    public static void b(String str) throws Exception {
        Map<String, Pair<FileLock, AtomicLong>> map = a;
        synchronized (map) {
            Pair pair = map.get(str);
            if (pair != null) {
                long decrementAndGet = ((AtomicLong) pair.second).decrementAndGet();
                if (decrementAndGet < 0) {
                    throw new RuntimeException("using.lock count illegal");
                } else if (decrementAndGet == 0) {
                    ((FileLock) pair.first).a();
                    map.remove(str);
                }
            } else {
                throw new RuntimeException("using.lock illegal state");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.lang.String r7) throws java.lang.Exception {
        /*
            java.util.Map<java.lang.String, android.util.Pair<com.bykv.vk.openvk.preload.geckox.utils.FileLock, java.util.concurrent.atomic.AtomicLong>> r0 = a
            monitor-enter(r0)
            com.bykv.vk.openvk.preload.geckox.utils.FileLock r1 = com.bykv.vk.openvk.preload.geckox.utils.FileLock.b(r7)     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x000b:
            java.lang.Object r2 = r0.get(r7)     // Catch:{ all -> 0x006a }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x006a }
            java.util.concurrent.atomic.AtomicLong r2 = (java.util.concurrent.atomic.AtomicLong) r2     // Catch:{ all -> 0x006a }
            long r2 = r2.get()     // Catch:{ all -> 0x006a }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x002d
            r1.a()     // Catch:{ all -> 0x006a }
            int r1 = android.os.Process.myPid()     // Catch:{ all -> 0x006a }
            com.bykv.vk.openvk.preload.geckox.utils.FileLock.a(r7, r1)     // Catch:{ all -> 0x006a }
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x002d:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x006a }
            r2.<init>(r7)     // Catch:{ all -> 0x006a }
            java.io.File r7 = r2.getParentFile()     // Catch:{ all -> 0x006a }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x006a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r3.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r4 = r7.getAbsolutePath()     // Catch:{ all -> 0x006a }
            r3.append(r4)     // Catch:{ all -> 0x006a }
            java.lang.String r4 = "--pending-delete"
            r3.append(r4)     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006a }
            r2.<init>(r3)     // Catch:{ all -> 0x006a }
            boolean r7 = r7.renameTo(r2)     // Catch:{ all -> 0x006a }
            if (r7 == 0) goto L_0x0068
            r1.a()     // Catch:{ all -> 0x006a }
            r1.b()     // Catch:{ all -> 0x006a }
            com.bykv.vk.openvk.preload.geckox.utils.e r7 = com.bykv.vk.openvk.preload.geckox.utils.e.a()     // Catch:{ all -> 0x006a }
            com.bykv.vk.openvk.preload.geckox.g.c$1 r1 = new com.bykv.vk.openvk.preload.geckox.g.c$1     // Catch:{ all -> 0x006a }
            r1.<init>(r2)     // Catch:{ all -> 0x006a }
            r7.execute(r1)     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x006a:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.g.c.c(java.lang.String):void");
    }
}
