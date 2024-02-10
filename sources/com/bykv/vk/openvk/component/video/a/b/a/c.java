package com.bykv.vk.openvk.component.video.a.b.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.a.b.d;
import com.bykv.vk.openvk.component.video.a.b.e;
import com.bytedance.sdk.component.g.f;
import com.bytedance.sdk.component.g.h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: DiskLruCache */
public class c extends a {
    public final File a;
    private final LinkedHashMap<String, File> b = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock c;
    private final ReentrantReadWriteLock.ReadLock d;
    private final ReentrantReadWriteLock.WriteLock e;
    private final Set<a> f;
    /* access modifiers changed from: private */
    public volatile long g;
    private volatile float h;
    private final b i;
    private final Runnable j;
    private final Handler k;

    /* compiled from: DiskLruCache */
    public interface a {
        void a(String str);

        void a(Set<String> set);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f.add(aVar);
        }
    }

    public c(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.e = reentrantReadWriteLock.writeLock();
        this.f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.g = 104857600;
        this.h = 0.5f;
        this.i = new b();
        this.j = new Runnable() {
            public void run() {
                f.b((h) new h("cleanupCmd", 1) {
                    public void run() {
                        c.this.b(c.this.g);
                    }
                });
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            if (file == null) {
                str = " dir null";
            } else {
                str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
            }
            throw new IOException("dir error!  " + str);
        }
        this.a = file;
        f.b((h) new h("DiskLruCache", 5) {
            public void run() {
                c.this.b();
            }
        });
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public void b() {
        this.e.lock();
        try {
            File[] listFiles = this.a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() {
                    /* renamed from: a */
                    public int compare(File file, File file2) {
                        long longValue = ((Long) hashMap.get(file)).longValue() - ((Long) hashMap.get(file2)).longValue();
                        if (longValue < 0) {
                            return -1;
                        }
                        return longValue > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.b.put(a(file2), file2);
                }
            }
            this.e.unlock();
            c();
        } catch (Throwable th) {
            this.e.unlock();
            throw th;
        }
    }

    public void a(long j2) {
        this.g = j2;
        c();
    }

    private void c() {
        this.k.removeCallbacks(this.j);
        this.k.postDelayed(this.j, 10000);
    }

    public void a() {
        d.c().d();
        Context a2 = e.a();
        if (a2 != null) {
            com.bykv.vk.openvk.component.video.a.b.b.c.a(a2).a(0);
        }
        this.k.removeCallbacks(this.j);
        f.b((h) new h("clear", 1) {
            public void run() {
                c.this.b(0);
            }
        });
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.a(str);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.b(str);
        }
    }

    public File c(String str) {
        this.d.lock();
        File file = this.b.get(str);
        this.d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.a, str);
        this.e.lock();
        this.b.put(str, file2);
        this.e.unlock();
        for (a a2 : this.f) {
            a2.a(str);
        }
        c();
        return file2;
    }

    public File d(String str) {
        if (!this.d.tryLock()) {
            return null;
        }
        File file = this.b.get(str);
        this.d.unlock();
        return file;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e4 A[LOOP:3: B:42:0x00de->B:44:0x00e4, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(long r13) {
        /*
            r12 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r12.e
            r1.lock()
            r1 = 0
            java.util.LinkedHashMap<java.lang.String, java.io.File> r2 = r12.b     // Catch:{ all -> 0x00ce }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x00ce }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00ce }
            r3 = 0
        L_0x0017:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x00ce }
            if (r5 == 0) goto L_0x002f
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x00ce }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x00ce }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x00ce }
            java.io.File r5 = (java.io.File) r5     // Catch:{ all -> 0x00ce }
            long r5 = r5.length()     // Catch:{ all -> 0x00ce }
            long r3 = r3 + r5
            goto L_0x0017
        L_0x002f:
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 > 0) goto L_0x0039
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r13 = r12.e
            r13.unlock()
            return
        L_0x0039:
            float r13 = (float) r13
            float r14 = r12.h     // Catch:{ all -> 0x00ce }
            float r13 = r13 * r14
            long r13 = (long) r13     // Catch:{ all -> 0x00ce }
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x00ce }
            r2.<init>()     // Catch:{ all -> 0x00ce }
            java.util.LinkedHashMap<java.lang.String, java.io.File> r1 = r12.b     // Catch:{ all -> 0x00cb }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x00cb }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00cb }
        L_0x004e:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x00cb }
            if (r5 == 0) goto L_0x00af
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x00cb }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x00cb }
            java.lang.Object r6 = r5.getValue()     // Catch:{ all -> 0x00cb }
            java.io.File r6 = (java.io.File) r6     // Catch:{ all -> 0x00cb }
            if (r6 == 0) goto L_0x00a4
            boolean r7 = r6.exists()     // Catch:{ all -> 0x00cb }
            if (r7 == 0) goto L_0x00a4
            com.bykv.vk.openvk.component.video.a.b.a.c$b r7 = r12.i     // Catch:{ all -> 0x00cb }
            java.lang.String r8 = r12.a((java.io.File) r6)     // Catch:{ all -> 0x00cb }
            boolean r7 = r7.c(r8)     // Catch:{ all -> 0x00cb }
            if (r7 != 0) goto L_0x00ab
            long r7 = r6.length()     // Catch:{ all -> 0x00cb }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00cb }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r10.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r11 = r6.getAbsolutePath()     // Catch:{ all -> 0x00cb }
            r10.append(r11)     // Catch:{ all -> 0x00cb }
            java.lang.String r11 = "-tmp"
            r10.append(r11)     // Catch:{ all -> 0x00cb }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00cb }
            r9.<init>(r10)     // Catch:{ all -> 0x00cb }
            boolean r6 = r6.renameTo(r9)     // Catch:{ all -> 0x00cb }
            if (r6 == 0) goto L_0x00ab
            r0.add(r9)     // Catch:{ all -> 0x00cb }
            long r3 = r3 - r7
            java.lang.Object r5 = r5.getKey()     // Catch:{ all -> 0x00cb }
            r2.add(r5)     // Catch:{ all -> 0x00cb }
            goto L_0x00ab
        L_0x00a4:
            java.lang.Object r5 = r5.getKey()     // Catch:{ all -> 0x00cb }
            r2.add(r5)     // Catch:{ all -> 0x00cb }
        L_0x00ab:
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 > 0) goto L_0x004e
        L_0x00af:
            java.util.Iterator r13 = r2.iterator()     // Catch:{ all -> 0x00cb }
        L_0x00b3:
            boolean r14 = r13.hasNext()     // Catch:{ all -> 0x00cb }
            if (r14 == 0) goto L_0x00c5
            java.lang.Object r14 = r13.next()     // Catch:{ all -> 0x00cb }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x00cb }
            java.util.LinkedHashMap<java.lang.String, java.io.File> r1 = r12.b     // Catch:{ all -> 0x00cb }
            r1.remove(r14)     // Catch:{ all -> 0x00cb }
            goto L_0x00b3
        L_0x00c5:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r13 = r12.e
            r13.unlock()
            goto L_0x00d8
        L_0x00cb:
            r13 = move-exception
            r1 = r2
            goto L_0x00cf
        L_0x00ce:
            r13 = move-exception
        L_0x00cf:
            r13.printStackTrace()     // Catch:{ all -> 0x00fa }
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r13 = r12.e
            r13.unlock()
            r2 = r1
        L_0x00d8:
            java.util.Set<com.bykv.vk.openvk.component.video.a.b.a.c$a> r13 = r12.f
            java.util.Iterator r13 = r13.iterator()
        L_0x00de:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x00ee
            java.lang.Object r14 = r13.next()
            com.bykv.vk.openvk.component.video.a.b.a.c$a r14 = (com.bykv.vk.openvk.component.video.a.b.a.c.a) r14
            r14.a((java.util.Set<java.lang.String>) r2)
            goto L_0x00de
        L_0x00ee:
            com.bykv.vk.openvk.component.video.a.b.a.c$5 r13 = new com.bykv.vk.openvk.component.video.a.b.a.c$5
            java.lang.String r14 = "trimSize"
            r1 = 1
            r13.<init>(r14, r1, r0)
            com.bytedance.sdk.component.g.f.b((com.bytedance.sdk.component.g.h) r13)
            return
        L_0x00fa:
            r13 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r14 = r12.e
            r14.unlock()
            goto L_0x0102
        L_0x0101:
            throw r13
        L_0x0102:
            goto L_0x0101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.b.a.c.b(long):void");
    }

    private String a(File file) {
        return file.getName();
    }

    /* compiled from: DiskLruCache */
    private static final class b {
        private final Map<String, Integer> a;

        private b() {
            this.a = new HashMap();
        }

        /* access modifiers changed from: package-private */
        public synchronized void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.a.get(str);
                if (num == null) {
                    this.a.put(str, 1);
                } else {
                    this.a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.a.remove(str);
                } else {
                    this.a.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.a.containsKey(str);
        }
    }
}
