package com.bykv.vk.openvk.component.video.a.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.a.b.c.c;
import com.bykv.vk.openvk.component.video.a.b.h;
import com.bykv.vk.openvk.component.video.a.b.i;
import com.bykv.vk.openvk.component.video.a.b.l;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* compiled from: DownloadTask */
class b extends a {
    final Object m = this;
    final Object n;
    private final int o;
    private final C0030b p;
    private volatile h.a q;
    private volatile com.bykv.vk.openvk.component.video.a.b.c.b r;

    /* renamed from: com.bykv.vk.openvk.component.video.a.b.b$b  reason: collision with other inner class name */
    /* compiled from: DownloadTask */
    public interface C0030b {
        void a(b bVar);
    }

    b(a aVar) {
        super(aVar.d, aVar.e);
        this.o = aVar.g;
        this.p = aVar.i;
        this.g = aVar.a;
        this.h = aVar.b;
        this.f = aVar.f;
        this.j = aVar.c;
        this.i = aVar.h;
        this.n = aVar.j;
    }

    public void run() {
        this.a.a(this.h);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (com.bykv.vk.openvk.component.video.a.b.c.a unused) {
        }
        this.d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.a.b(this.h);
        C0030b bVar = this.p;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public h.a h() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public com.bykv.vk.openvk.component.video.a.b.c.b i() {
        return this.r;
    }

    private boolean j() throws com.bykv.vk.openvk.component.video.a.b.c.a {
        while (this.j.a()) {
            e();
            l.a b = this.j.b();
            try {
                a(b);
                return true;
            } catch (c e) {
                b.a();
                a(Boolean.valueOf(g()), this.g, e);
            } catch (IOException e2) {
                if (e2 instanceof SocketTimeoutException) {
                    b.b();
                }
                if (!b()) {
                    a(Boolean.valueOf(g()), this.g, e2);
                }
            } catch (h.a e3) {
                this.q = e3;
                a(Boolean.valueOf(g()), this.g, e3);
                return false;
            } catch (com.bykv.vk.openvk.component.video.a.b.c.b e4) {
                this.r = e4;
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c5, code lost:
        if (com.bykv.vk.openvk.component.video.a.b.e.c == false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c7, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ce, code lost:
        com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r11.d());
        r4.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d8, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3 A[Catch:{ all -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e0 A[SYNTHETIC, Splitter:B:92:0x01e0] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x020f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bykv.vk.openvk.component.video.a.b.l.a r17) throws java.io.IOException, com.bykv.vk.openvk.component.video.a.b.h.a, com.bykv.vk.openvk.component.video.a.b.c.a, com.bykv.vk.openvk.component.video.a.b.c.b {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.String r2 = "preload start from: "
            java.lang.String r3 = "Content-Length not match, old: "
            java.lang.String r4 = "Content-Length not match, old length: "
            com.bykv.vk.openvk.component.video.a.b.a.a r5 = r1.a
            java.lang.String r6 = r1.h
            java.io.File r5 = r5.c(r6)
            long r6 = r5.length()
            int r8 = r1.o
            if (r8 <= 0) goto L_0x004b
            long r8 = (long) r8
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x004b
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "no necessary to download for "
            r2.<init>(r3)
            java.lang.String r3 = r1.h
            r2.append(r3)
            java.lang.String r3 = ", cache file size: "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = ", max: "
            r2.append(r3)
            int r3 = r1.o
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r0, r2)
        L_0x004a:
            return
        L_0x004b:
            int r8 = r16.f()
            com.bykv.vk.openvk.component.video.a.b.b.c r9 = r1.b
            java.lang.String r10 = r1.h
            com.bykv.vk.openvk.component.video.a.b.b.a r9 = r9.a((java.lang.String) r10, (int) r8)
            if (r9 == 0) goto L_0x007a
            int r10 = r9.c
            long r10 = (long) r10
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x007a
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x0079
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "file download complete, key: "
            r2.<init>(r3)
            java.lang.String r3 = r1.h
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r0, r2)
        L_0x0079:
            return
        L_0x007a:
            r16.e()
            int r10 = (int) r6
            int r11 = r1.o
            java.lang.String r12 = "GET"
            com.bykv.vk.openvk.component.video.a.b.e.a r11 = r1.a(r0, r10, r11, r12)
            if (r11 != 0) goto L_0x0089
            return
        L_0x0089:
            r12 = 1
            r13 = 0
            r16.e()     // Catch:{ all -> 0x0204 }
            com.bykv.vk.openvk.component.video.a.b.i r14 = r1.i     // Catch:{ all -> 0x0204 }
            r15 = 0
            if (r14 != 0) goto L_0x009c
            boolean r14 = com.bykv.vk.openvk.component.video.a.b.e.e     // Catch:{ all -> 0x0099 }
            if (r14 == 0) goto L_0x009c
            r14 = 1
            goto L_0x009d
        L_0x0099:
            r0 = move-exception
            goto L_0x0206
        L_0x009c:
            r14 = 0
        L_0x009d:
            java.lang.String r14 = com.bykv.vk.openvk.component.video.a.c.a.a(r11, r14, r12)     // Catch:{ all -> 0x0204 }
            if (r14 != 0) goto L_0x01e0
            int r14 = com.bykv.vk.openvk.component.video.a.c.a.a((com.bykv.vk.openvk.component.video.a.b.e.a) r11)     // Catch:{ all -> 0x0204 }
            if (r9 == 0) goto L_0x010e
            int r12 = r9.c     // Catch:{ all -> 0x0204 }
            if (r12 == r14) goto L_0x010e
            boolean r2 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x00d6
            java.lang.String r2 = "TAG_PROXY_DownloadTask"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
            r5.<init>(r3)     // Catch:{ all -> 0x0204 }
            int r3 = r9.c     // Catch:{ all -> 0x0204 }
            r5.append(r3)     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = ", "
            r5.append(r3)     // Catch:{ all -> 0x0204 }
            r5.append(r14)     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = ", key: "
            r5.append(r3)     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = r1.h     // Catch:{ all -> 0x0204 }
            r5.append(r3)     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0204 }
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0204 }
        L_0x00d6:
            com.bykv.vk.openvk.component.video.a.b.c.b r2 = new com.bykv.vk.openvk.component.video.a.b.c.b     // Catch:{ all -> 0x0204 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
            r3.<init>(r4)     // Catch:{ all -> 0x0204 }
            int r4 = r9.c     // Catch:{ all -> 0x0204 }
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = ", new length: "
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            r3.append(r14)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = ", rawKey: "
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = r1.g     // Catch:{ all -> 0x0204 }
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = ", currentUrl: "
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            r3.append(r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = ", previousInfo: "
            r3.append(r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = r9.e     // Catch:{ all -> 0x0204 }
            r3.append(r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0204 }
            r2.<init>(r0)     // Catch:{ all -> 0x0204 }
            throw r2     // Catch:{ all -> 0x0204 }
        L_0x010e:
            com.bykv.vk.openvk.component.video.a.b.b.c r0 = r1.b     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = r1.h     // Catch:{ all -> 0x0204 }
            com.bykv.vk.openvk.component.video.a.c.a.a(r11, r0, r3, r8)     // Catch:{ all -> 0x0204 }
            com.bykv.vk.openvk.component.video.a.b.b.c r0 = r1.b     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = r1.h     // Catch:{ all -> 0x0204 }
            com.bykv.vk.openvk.component.video.a.b.b.a r0 = r0.a((java.lang.String) r3, (int) r8)     // Catch:{ all -> 0x0204 }
            if (r0 != 0) goto L_0x0121
            r0 = 0
            goto L_0x0123
        L_0x0121:
            int r0 = r0.c     // Catch:{ all -> 0x0204 }
        L_0x0123:
            java.io.InputStream r3 = r11.d()     // Catch:{ all -> 0x0204 }
            com.bykv.vk.openvk.component.video.a.b.h r4 = new com.bykv.vk.openvk.component.video.a.b.h     // Catch:{ all -> 0x0204 }
            boolean r8 = com.bykv.vk.openvk.component.video.a.b.e.d     // Catch:{ all -> 0x0204 }
            if (r8 == 0) goto L_0x0130
            java.lang.String r8 = "rwd"
            goto L_0x0132
        L_0x0130:
            java.lang.String r8 = "rw"
        L_0x0132:
            r4.<init>(r5, r8)     // Catch:{ all -> 0x0204 }
            r4.a((long) r6)     // Catch:{ all -> 0x01dd }
            boolean r5 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01dd }
            if (r5 == 0) goto L_0x014d
            java.lang.String r5 = "TAG_PROXY_DownloadTask"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dd }
            r8.<init>(r2)     // Catch:{ all -> 0x01dd }
            r8.append(r6)     // Catch:{ all -> 0x01dd }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x01dd }
            android.util.Log.i(r5, r2)     // Catch:{ all -> 0x01dd }
        L_0x014d:
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x01dd }
        L_0x0151:
            int r5 = r3.read(r2)     // Catch:{ all -> 0x01dd }
            if (r5 < 0) goto L_0x01c0
            r16.e()     // Catch:{ all -> 0x01dd }
            if (r5 <= 0) goto L_0x0179
            r4.a(r2, r15, r5)     // Catch:{ all -> 0x01dd }
            int r10 = r10 + r5
            com.bykv.vk.openvk.component.video.a.b.i r6 = r1.i     // Catch:{ all -> 0x01dd }
            if (r6 == 0) goto L_0x0171
            java.lang.Object r6 = r1.m     // Catch:{ all -> 0x01dd }
            monitor-enter(r6)     // Catch:{ all -> 0x01dd }
            java.lang.Object r7 = r1.m     // Catch:{ all -> 0x016e }
            r7.notifyAll()     // Catch:{ all -> 0x016e }
            monitor-exit(r6)     // Catch:{ all -> 0x016e }
            goto L_0x0171
        L_0x016e:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x016e }
            throw r0     // Catch:{ all -> 0x01dd }
        L_0x0171:
            java.util.concurrent.atomic.AtomicInteger r6 = r1.c     // Catch:{ all -> 0x01dd }
            r6.addAndGet(r5)     // Catch:{ all -> 0x01dd }
            r1.a(r0, r10)     // Catch:{ all -> 0x01dd }
        L_0x0179:
            int r5 = r1.o     // Catch:{ all -> 0x01dd }
            if (r5 <= 0) goto L_0x01bc
            if (r10 < r5) goto L_0x01bc
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01dd }
            if (r0 == 0) goto L_0x01a3
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dd }
            r2.<init>()     // Catch:{ all -> 0x01dd }
            java.lang.String r3 = "download, more data received, currentCacheFileSize: "
            r2.append(r3)     // Catch:{ all -> 0x01dd }
            r2.append(r10)     // Catch:{ all -> 0x01dd }
            java.lang.String r3 = ", max: "
            r2.append(r3)     // Catch:{ all -> 0x01dd }
            int r3 = r1.o     // Catch:{ all -> 0x01dd }
            r2.append(r3)     // Catch:{ all -> 0x01dd }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01dd }
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x01dd }
        L_0x01a3:
            java.io.InputStream r0 = r11.d()
            com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r0)
            r4.a()
            r16.a()
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x01bb
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            java.lang.String r2 = "cancel call"
            android.util.Log.w(r0, r2)
        L_0x01bb:
            return
        L_0x01bc:
            r16.e()     // Catch:{ all -> 0x01dd }
            goto L_0x0151
        L_0x01c0:
            r16.c()     // Catch:{ all -> 0x01d9 }
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01d9 }
            if (r0 == 0) goto L_0x01ce
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            java.lang.String r2 = "download succeed, no need to cancel call"
            android.util.Log.i(r0, r2)     // Catch:{ all -> 0x01d9 }
        L_0x01ce:
            java.io.InputStream r0 = r11.d()
            com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r0)
            r4.a()
            return
        L_0x01d9:
            r0 = move-exception
            r13 = r4
            r12 = 0
            goto L_0x0206
        L_0x01dd:
            r0 = move-exception
            r13 = r4
            goto L_0x0205
        L_0x01e0:
            com.bykv.vk.openvk.component.video.a.b.c.c r2 = new com.bykv.vk.openvk.component.video.a.b.c.c     // Catch:{ all -> 0x0204 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
            r3.<init>()     // Catch:{ all -> 0x0204 }
            r3.append(r14)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = ", rawKey: "
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = r1.g     // Catch:{ all -> 0x0204 }
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = ", url: "
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            r3.append(r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0204 }
            r2.<init>(r0)     // Catch:{ all -> 0x0204 }
            throw r2     // Catch:{ all -> 0x0204 }
        L_0x0204:
            r0 = move-exception
        L_0x0205:
            r12 = 1
        L_0x0206:
            java.io.InputStream r2 = r11.d()
            com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r2)
            if (r13 == 0) goto L_0x0212
            r13.a()
        L_0x0212:
            if (r12 == 0) goto L_0x0222
            r16.a()
            boolean r2 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r2 == 0) goto L_0x0222
            java.lang.String r2 = "TAG_PROXY_DownloadTask"
            java.lang.String r3 = "cancel call"
            android.util.Log.w(r2, r3)
        L_0x0222:
            goto L_0x0224
        L_0x0223:
            throw r0
        L_0x0224:
            goto L_0x0223
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.b.b.a(com.bykv.vk.openvk.component.video.a.b.l$a):void");
    }

    /* compiled from: DownloadTask */
    static final class a {
        String a;
        String b;
        l c;
        com.bykv.vk.openvk.component.video.a.b.a.a d;
        com.bykv.vk.openvk.component.video.a.b.b.c e;
        List<i.b> f;
        int g;
        i h;
        C0030b i;
        Object j;

        a() {
        }

        /* access modifiers changed from: package-private */
        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
                return this;
            }
            throw new IllegalArgumentException("rawKey == null");
        }

        /* access modifiers changed from: package-private */
        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        /* access modifiers changed from: package-private */
        public a a(l lVar) {
            if (lVar != null) {
                this.c = lVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        /* access modifiers changed from: package-private */
        public a a(com.bykv.vk.openvk.component.video.a.b.a.a aVar) {
            if (aVar != null) {
                this.d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        /* access modifiers changed from: package-private */
        public a a(com.bykv.vk.openvk.component.video.a.b.b.c cVar) {
            if (cVar != null) {
                this.e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* access modifiers changed from: package-private */
        public a a(List<i.b> list) {
            this.f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(int i2) {
            this.g = i2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(C0030b bVar) {
            this.i = bVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(i iVar) {
            this.h = iVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(Object obj) {
            this.j = obj;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b a() {
            if (this.d != null && this.e != null && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && this.c != null) {
                return new b(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
