package com.bykv.vk.openvk.component.video.a.b;

import android.util.Log;
import com.bykv.vk.openvk.component.video.a.b.c.d;
import com.bykv.vk.openvk.component.video.a.b.h;
import com.bykv.vk.openvk.component.video.a.b.i;
import com.bykv.vk.openvk.component.video.a.b.l;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* compiled from: ProxyTask */
class g extends a {
    private final Socket m;
    private final c n;
    /* access modifiers changed from: private */
    public final d o;
    private volatile b p;
    private volatile boolean q = true;

    /* compiled from: ProxyTask */
    public interface c {
        void a(g gVar);

        void b(g gVar);
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
    }

    g(a aVar) {
        super(aVar.a, aVar.b);
        this.m = aVar.c;
        this.n = aVar.d;
        this.o = d.c();
    }

    private b h() {
        try {
            this.i = i.a(this.m.getInputStream());
            OutputStream outputStream = this.m.getOutputStream();
            com.bykv.vk.openvk.component.video.a.b.a.a aVar = this.i.c.a == 1 ? e.a : e.b;
            if (aVar == null) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.a = aVar;
            this.g = this.i.c.b;
            this.h = this.i.c.c;
            this.j = new l(this.i.c.g);
            this.f = this.i.b;
            if (e.c) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.i.toString());
            }
            return new b(outputStream, this.i.c.d);
        } catch (IOException e) {
            com.bykv.vk.openvk.component.video.a.c.a.a(this.m);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
            a(this.a == null ? null : Boolean.valueOf(g()), this.g, e);
            return null;
        } catch (i.d e2) {
            com.bykv.vk.openvk.component.video.a.c.a.a(this.m);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            a(this.a == null ? null : Boolean.valueOf(g()), this.g, e2);
            return null;
        }
    }

    public void run() {
        com.bykv.vk.openvk.component.video.a.b.b.a a2;
        b h = h();
        if (h != null) {
            c cVar = this.n;
            if (cVar != null) {
                cVar.a(this);
            }
            this.a.a(this.h);
            if (e.h != 0 && ((a2 = this.b.a(this.h, this.i.c.a)) == null || this.a.c(this.h).length() < ((long) a2.c))) {
                this.o.a(g(), this.h);
            }
            try {
                a(h);
            } catch (com.bykv.vk.openvk.component.video.a.b.c.a e) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
                }
            } catch (Throwable th) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
                }
            }
            this.a.b(this.h);
            this.o.a(g(), (String) null);
            a();
            com.bykv.vk.openvk.component.video.a.c.a.a(this.m);
            c cVar2 = this.n;
            if (cVar2 != null) {
                cVar2.b(this);
            }
        }
    }

    private boolean a(b bVar) throws com.bykv.vk.openvk.component.video.a.b.c.a {
        while (this.j.a()) {
            e();
            l.a b2 = this.j.b();
            try {
                a(bVar, b2);
                return true;
            } catch (com.bykv.vk.openvk.component.video.a.b.c.c e) {
                b2.a();
                a(Boolean.valueOf(g()), this.g, e);
            } catch (IOException e2) {
                if (e2 instanceof SocketTimeoutException) {
                    b2.b();
                }
                if (!b()) {
                    a(Boolean.valueOf(g()), this.g, e2);
                } else if (e.c) {
                    if ("Canceled".equalsIgnoreCase(e2.getMessage())) {
                        Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                    } else {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                    }
                }
            } catch (d e3) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                return true;
            } catch (h.a e4) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                }
                this.q = false;
                a(Boolean.valueOf(g()), this.g, e4);
            } catch (com.bykv.vk.openvk.component.video.a.b.c.b e5) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
                return false;
            } catch (Exception e6) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                }
            }
        }
        return false;
    }

    private void a(b bVar, l.a aVar) throws d, IOException, h.a, com.bykv.vk.openvk.component.video.a.b.c.a, com.bykv.vk.openvk.component.video.a.b.c.b {
        if ("HEAD".equalsIgnoreCase(this.i.a.a)) {
            b(bVar, aVar);
        } else {
            c(bVar, aVar);
        }
    }

    private void b(b bVar, l.a aVar) throws IOException, d {
        byte[] a2 = a(this.b.a(this.h, this.i.c.a), bVar, aVar);
        if (a2 != null) {
            bVar.a(a2, 0, a2.length);
        }
    }

    private void c(b bVar, l.a aVar) throws h.a, d, IOException, com.bykv.vk.openvk.component.video.a.b.c.a, com.bykv.vk.openvk.component.video.a.b.c.b {
        int i;
        if (this.q) {
            File c2 = this.a.c(this.h);
            long length = c2.length();
            com.bykv.vk.openvk.component.video.a.b.b.a a2 = this.b.a(this.h, this.i.c.a);
            int b2 = bVar.b();
            long j = length - ((long) b2);
            int i2 = (int) j;
            if (a2 == null) {
                i = -1;
            } else {
                i = a2.c;
            }
            if (length > ((long) bVar.b())) {
                if (e.c) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + j);
                }
                a(true, i2, i, (int) length, b2);
                a(a2, c2, bVar, aVar);
                return;
            }
            a(false, i2, i, (int) length, b2);
        } else {
            a(false, 0, 0, 0, bVar.b());
        }
        d(bVar, aVar);
    }

    private byte[] a(com.bykv.vk.openvk.component.video.a.b.b.a aVar, b bVar, l.a aVar2) throws IOException {
        if (aVar != null) {
            if (e.c) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bykv.vk.openvk.component.video.a.c.a.a(aVar, bVar.b()).getBytes(com.bykv.vk.openvk.component.video.a.c.a.a);
        }
        com.bykv.vk.openvk.component.video.a.b.e.a a2 = a(aVar2, 0, -1, "HEAD");
        if (a2 == null) {
            return null;
        }
        try {
            String a3 = com.bykv.vk.openvk.component.video.a.c.a.a(a2, false, false);
            if (a3 == null) {
                com.bykv.vk.openvk.component.video.a.b.b.a a4 = com.bykv.vk.openvk.component.video.a.c.a.a(a2, this.b, this.h, this.i.c.a);
                if (e.c) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                return com.bykv.vk.openvk.component.video.a.c.a.a(a4, bVar.b()).getBytes(com.bykv.vk.openvk.component.video.a.c.a.a);
            }
            throw new com.bykv.vk.openvk.component.video.a.b.c.c(a3 + ", rawKey: " + this.g + ", url: " + aVar2);
        } finally {
            com.bykv.vk.openvk.component.video.a.c.a.a((Closeable) a2.d());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ca A[SYNTHETIC, Splitter:B:92:0x01ca] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bykv.vk.openvk.component.video.a.b.b.a r8, java.io.File r9, com.bykv.vk.openvk.component.video.a.b.g.b r10, com.bykv.vk.openvk.component.video.a.b.l.a r11) throws java.io.IOException, com.bykv.vk.openvk.component.video.a.b.c.d, com.bykv.vk.openvk.component.video.a.b.h.a, com.bykv.vk.openvk.component.video.a.b.c.a, com.bykv.vk.openvk.component.video.a.b.c.b {
        /*
            r7 = this;
            boolean r0 = r10.a()
            r1 = 0
            if (r0 != 0) goto L_0x0015
            byte[] r0 = r7.a(r8, r10, r11)
            r7.e()
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            int r2 = r0.length
            r10.a(r0, r1, r2)
        L_0x0015:
            r0 = 0
            if (r8 != 0) goto L_0x0065
            com.bykv.vk.openvk.component.video.a.b.b.c r8 = r7.b
            java.lang.String r2 = r7.h
            com.bykv.vk.openvk.component.video.a.b.i r3 = r7.i
            com.bykv.vk.openvk.component.video.a.b.i$a r3 = r3.c
            int r3 = r3.a
            com.bykv.vk.openvk.component.video.a.b.b.a r8 = r8.a((java.lang.String) r2, (int) r3)
            if (r8 != 0) goto L_0x0065
            boolean r8 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r8 == 0) goto L_0x0033
            java.lang.String r8 = "TAG_PROXY_ProxyTask"
            java.lang.String r2 = "failed to get video header info from db"
            android.util.Log.e(r8, r2)
        L_0x0033:
            r7.a(r0, r10, r11)
            com.bykv.vk.openvk.component.video.a.b.b.c r8 = r7.b
            java.lang.String r2 = r7.h
            com.bykv.vk.openvk.component.video.a.b.i r3 = r7.i
            com.bykv.vk.openvk.component.video.a.b.i$a r3 = r3.c
            int r3 = r3.a
            com.bykv.vk.openvk.component.video.a.b.b.a r8 = r8.a((java.lang.String) r2, (int) r3)
            if (r8 == 0) goto L_0x0047
            goto L_0x0065
        L_0x0047:
            com.bykv.vk.openvk.component.video.a.b.c.c r8 = new com.bykv.vk.openvk.component.video.a.b.c.c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "failed to get header, rawKey: "
            r9.<init>(r10)
            java.lang.String r10 = r7.g
            r9.append(r10)
            java.lang.String r10 = ", url: "
            r9.append(r10)
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0065:
            long r2 = r9.length()
            int r4 = r8.c
            long r4 = (long) r4
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00e1
            com.bykv.vk.openvk.component.video.a.b.b r2 = r7.p
            if (r2 == 0) goto L_0x0080
            boolean r3 = r2.b()
            if (r3 != 0) goto L_0x0080
            boolean r2 = r2.d()
            if (r2 == 0) goto L_0x00e1
        L_0x0080:
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = new com.bykv.vk.openvk.component.video.a.b.b$a
            r2.<init>()
            com.bykv.vk.openvk.component.video.a.b.a.a r3 = r7.a
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.a.a) r3)
            com.bykv.vk.openvk.component.video.a.b.b.c r3 = r7.b
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.b.c) r3)
            java.lang.String r3 = r7.g
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((java.lang.String) r3)
            java.lang.String r3 = r7.h
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.b(r3)
            com.bykv.vk.openvk.component.video.a.b.l r3 = new com.bykv.vk.openvk.component.video.a.b.l
            java.lang.String r4 = r11.a
            r3.<init>((java.lang.String) r4)
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.l) r3)
            java.util.List r3 = r7.f
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((java.util.List<com.bykv.vk.openvk.component.video.a.b.i.b>) r3)
            com.bykv.vk.openvk.component.video.a.b.i r3 = r7.i
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.i) r3)
            com.bykv.vk.openvk.component.video.a.b.g$1 r3 = new com.bykv.vk.openvk.component.video.a.b.g$1
            r3.<init>()
            com.bykv.vk.openvk.component.video.a.b.b$a r2 = r2.a((com.bykv.vk.openvk.component.video.a.b.b.C0030b) r3)
            com.bykv.vk.openvk.component.video.a.b.b r2 = r2.a()
            r7.p = r2
            com.bytedance.sdk.component.g.g r3 = new com.bytedance.sdk.component.g.g
            r4 = 10
            r5 = 1
            r3.<init>(r2, r0, r4, r5)
            com.bykv.vk.openvk.component.video.a.b.g$2 r2 = new com.bykv.vk.openvk.component.video.a.b.g$2
            java.lang.String r4 = "processCacheNetWorkConcurrent"
            r2.<init>(r4, r3)
            com.bytedance.sdk.component.g.f.b((com.bytedance.sdk.component.g.h) r2)
            boolean r2 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r2 == 0) goto L_0x00e2
            java.lang.String r2 = "TAG_PROXY_ProxyTask"
            java.lang.String r4 = "fire download in process cache task"
            android.util.Log.e(r2, r4)
            goto L_0x00e2
        L_0x00e1:
            r3 = r0
        L_0x00e2:
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r2]
            com.bykv.vk.openvk.component.video.a.b.h r4 = new com.bykv.vk.openvk.component.video.a.b.h     // Catch:{ all -> 0x01c2 }
            java.lang.String r5 = "r"
            r4.<init>(r9, r5)     // Catch:{ all -> 0x01c2 }
            int r9 = r10.b()     // Catch:{ all -> 0x01bf }
            long r5 = (long) r9     // Catch:{ all -> 0x01bf }
            r4.a((long) r5)     // Catch:{ all -> 0x01bf }
            com.bykv.vk.openvk.component.video.a.b.i r9 = r7.i     // Catch:{ all -> 0x01bf }
            com.bykv.vk.openvk.component.video.a.b.i$a r9 = r9.c     // Catch:{ all -> 0x01bf }
            int r9 = r9.e     // Catch:{ all -> 0x01bf }
            if (r9 <= 0) goto L_0x010a
            int r8 = r8.c     // Catch:{ all -> 0x01bf }
            com.bykv.vk.openvk.component.video.a.b.i r9 = r7.i     // Catch:{ all -> 0x01bf }
            com.bykv.vk.openvk.component.video.a.b.i$a r9 = r9.c     // Catch:{ all -> 0x01bf }
            int r9 = r9.e     // Catch:{ all -> 0x01bf }
            int r8 = java.lang.Math.min(r8, r9)     // Catch:{ all -> 0x01bf }
            goto L_0x010c
        L_0x010a:
            int r8 = r8.c     // Catch:{ all -> 0x01bf }
        L_0x010c:
            int r9 = r10.b()     // Catch:{ all -> 0x01bf }
            if (r9 >= r8) goto L_0x0188
            r7.e()     // Catch:{ all -> 0x01bf }
            int r9 = r4.a((byte[]) r2)     // Catch:{ all -> 0x01bf }
            if (r9 > 0) goto L_0x0181
            com.bykv.vk.openvk.component.video.a.b.b r9 = r7.p     // Catch:{ all -> 0x01bf }
            if (r9 == 0) goto L_0x012e
            com.bykv.vk.openvk.component.video.a.b.c.b r0 = r9.i()     // Catch:{ all -> 0x01bf }
            if (r0 != 0) goto L_0x012d
            com.bykv.vk.openvk.component.video.a.b.h$a r0 = r9.h()     // Catch:{ all -> 0x01bf }
            if (r0 != 0) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            throw r0     // Catch:{ all -> 0x01bf }
        L_0x012d:
            throw r0     // Catch:{ all -> 0x01bf }
        L_0x012e:
            if (r9 == 0) goto L_0x0155
            boolean r0 = r9.b()     // Catch:{ all -> 0x01bf }
            if (r0 != 0) goto L_0x0155
            boolean r0 = r9.d()     // Catch:{ all -> 0x01bf }
            if (r0 == 0) goto L_0x013d
            goto L_0x0155
        L_0x013d:
            r7.e()     // Catch:{ all -> 0x01bf }
            java.lang.Object r0 = r9.m     // Catch:{ all -> 0x01bf }
            monitor-enter(r0)     // Catch:{ all -> 0x01bf }
            java.lang.Object r9 = r9.m     // Catch:{ InterruptedException -> 0x014d }
            r5 = 1000(0x3e8, double:4.94E-321)
            r9.wait(r5)     // Catch:{ InterruptedException -> 0x014d }
            goto L_0x0151
        L_0x014b:
            r8 = move-exception
            goto L_0x0153
        L_0x014d:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x014b }
        L_0x0151:
            monitor-exit(r0)     // Catch:{ all -> 0x014b }
            goto L_0x0184
        L_0x0153:
            monitor-exit(r0)     // Catch:{ all -> 0x014b }
            throw r8     // Catch:{ all -> 0x01bf }
        L_0x0155:
            boolean r8 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01bf }
            if (r8 == 0) goto L_0x0160
            java.lang.String r8 = "TAG_PROXY_ProxyTask"
            java.lang.String r9 = "download task has finished!!!"
            android.util.Log.e(r8, r9)     // Catch:{ all -> 0x01bf }
        L_0x0160:
            com.bykv.vk.openvk.component.video.a.b.c.c r8 = new com.bykv.vk.openvk.component.video.a.b.c.c     // Catch:{ all -> 0x01bf }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bf }
            r9.<init>()     // Catch:{ all -> 0x01bf }
            java.lang.String r10 = "illegal state download task has finished, rawKey: "
            r9.append(r10)     // Catch:{ all -> 0x01bf }
            java.lang.String r10 = r7.g     // Catch:{ all -> 0x01bf }
            r9.append(r10)     // Catch:{ all -> 0x01bf }
            java.lang.String r10 = ", url: "
            r9.append(r10)     // Catch:{ all -> 0x01bf }
            r9.append(r11)     // Catch:{ all -> 0x01bf }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01bf }
            r8.<init>(r9)     // Catch:{ all -> 0x01bf }
            throw r8     // Catch:{ all -> 0x01bf }
        L_0x0181:
            r10.b(r2, r1, r9)     // Catch:{ all -> 0x01bf }
        L_0x0184:
            r7.e()     // Catch:{ all -> 0x01bf }
            goto L_0x010c
        L_0x0188:
            boolean r9 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01bf }
            if (r9 == 0) goto L_0x01ae
            java.lang.String r9 = "TAG_PROXY_ProxyTask"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bf }
            r11.<init>()     // Catch:{ all -> 0x01bf }
            java.lang.String r0 = "read cache file complete: "
            r11.append(r0)     // Catch:{ all -> 0x01bf }
            int r10 = r10.b()     // Catch:{ all -> 0x01bf }
            r11.append(r10)     // Catch:{ all -> 0x01bf }
            java.lang.String r10 = ", "
            r11.append(r10)     // Catch:{ all -> 0x01bf }
            r11.append(r8)     // Catch:{ all -> 0x01bf }
            java.lang.String r8 = r11.toString()     // Catch:{ all -> 0x01bf }
            android.util.Log.i(r9, r8)     // Catch:{ all -> 0x01bf }
        L_0x01ae:
            r7.c()     // Catch:{ all -> 0x01bf }
            r4.a()
            if (r3 == 0) goto L_0x01be
            r3.get()     // Catch:{ all -> 0x01ba }
            goto L_0x01be
        L_0x01ba:
            r8 = move-exception
            r8.printStackTrace()
        L_0x01be:
            return
        L_0x01bf:
            r8 = move-exception
            r0 = r4
            goto L_0x01c3
        L_0x01c2:
            r8 = move-exception
        L_0x01c3:
            if (r0 == 0) goto L_0x01c8
            r0.a()
        L_0x01c8:
            if (r3 == 0) goto L_0x01d2
            r3.get()     // Catch:{ all -> 0x01ce }
            goto L_0x01d2
        L_0x01ce:
            r9 = move-exception
            r9.printStackTrace()
        L_0x01d2:
            goto L_0x01d4
        L_0x01d3:
            throw r8
        L_0x01d4:
            goto L_0x01d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.b.g.a(com.bykv.vk.openvk.component.video.a.b.b.a, java.io.File, com.bykv.vk.openvk.component.video.a.b.g$b, com.bykv.vk.openvk.component.video.a.b.l$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b0 A[EDGE_INSN: B:113:0x01b0->B:85:0x01b0 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0108 A[Catch:{ all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0159 A[Catch:{ all -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015b A[Catch:{ all -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016c A[Catch:{ all -> 0x017c, all -> 0x01d8, all -> 0x019f }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b4 A[Catch:{ all -> 0x017c, all -> 0x01d8, all -> 0x019f }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.bykv.vk.openvk.component.video.a.b.g.b r17, com.bykv.vk.openvk.component.video.a.b.l.a r18) throws com.bykv.vk.openvk.component.video.a.b.c.d, java.io.IOException, com.bykv.vk.openvk.component.video.a.b.c.a, com.bykv.vk.openvk.component.video.a.b.c.b {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r0 = r18
            java.lang.String r3 = "can write to cache file in network task, cache file size: "
            java.lang.String r4 = "can't write to cache file in network task, cache file size: "
            java.lang.String r5 = "Content-Length not match, old: "
            java.lang.String r6 = "Content-Length not match, old length: "
            r16.i()
            long r7 = android.os.SystemClock.elapsedRealtime()
            int r9 = r17.b()
            com.bykv.vk.openvk.component.video.a.b.i r10 = r1.i
            com.bykv.vk.openvk.component.video.a.b.i$a r10 = r10.c
            int r10 = r10.e
            java.lang.String r11 = "GET"
            com.bykv.vk.openvk.component.video.a.b.e.a r10 = r1.a(r0, r9, r10, r11)
            if (r10 != 0) goto L_0x0028
            return
        L_0x0028:
            r11 = 1
            r13 = 0
            java.lang.String r11 = com.bykv.vk.openvk.component.video.a.c.a.a(r10, r13, r11)     // Catch:{ all -> 0x0205 }
            java.lang.String r14 = ", rawKey: "
            if (r11 != 0) goto L_0x01e0
            com.bykv.vk.openvk.component.video.a.b.b.c r11 = r1.b     // Catch:{ all -> 0x0205 }
            java.lang.String r15 = r1.h     // Catch:{ all -> 0x0205 }
            int r12 = r16.f()     // Catch:{ all -> 0x0205 }
            com.bykv.vk.openvk.component.video.a.b.b.a r11 = r11.a((java.lang.String) r15, (int) r12)     // Catch:{ all -> 0x0205 }
            int r12 = com.bykv.vk.openvk.component.video.a.c.a.a((com.bykv.vk.openvk.component.video.a.b.e.a) r10)     // Catch:{ all -> 0x0205 }
            java.lang.String r15 = "TAG_PROXY_ProxyTask"
            if (r11 == 0) goto L_0x00a7
            int r13 = r11.c     // Catch:{ all -> 0x0203 }
            if (r13 == r12) goto L_0x00a7
            boolean r2 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x0203 }
            if (r2 == 0) goto L_0x0071
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0203 }
            r2.<init>(r5)     // Catch:{ all -> 0x0203 }
            int r3 = r11.c     // Catch:{ all -> 0x0203 }
            r2.append(r3)     // Catch:{ all -> 0x0203 }
            java.lang.String r3 = ", "
            r2.append(r3)     // Catch:{ all -> 0x0203 }
            r2.append(r12)     // Catch:{ all -> 0x0203 }
            java.lang.String r3 = ", key: "
            r2.append(r3)     // Catch:{ all -> 0x0203 }
            java.lang.String r3 = r1.h     // Catch:{ all -> 0x0203 }
            r2.append(r3)     // Catch:{ all -> 0x0203 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0203 }
            android.util.Log.e(r15, r2)     // Catch:{ all -> 0x0203 }
        L_0x0071:
            com.bykv.vk.openvk.component.video.a.b.c.b r2 = new com.bykv.vk.openvk.component.video.a.b.c.b     // Catch:{ all -> 0x0203 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0203 }
            r3.<init>(r6)     // Catch:{ all -> 0x0203 }
            int r4 = r11.c     // Catch:{ all -> 0x0203 }
            r3.append(r4)     // Catch:{ all -> 0x0203 }
            java.lang.String r4 = ", new length: "
            r3.append(r4)     // Catch:{ all -> 0x0203 }
            r3.append(r12)     // Catch:{ all -> 0x0203 }
            r3.append(r14)     // Catch:{ all -> 0x0203 }
            java.lang.String r4 = r1.g     // Catch:{ all -> 0x0203 }
            r3.append(r4)     // Catch:{ all -> 0x0203 }
            java.lang.String r4 = ", currentUrl: "
            r3.append(r4)     // Catch:{ all -> 0x0203 }
            r3.append(r0)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = ", previousInfo: "
            r3.append(r0)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = r11.e     // Catch:{ all -> 0x0203 }
            r3.append(r0)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0203 }
            r2.<init>(r0)     // Catch:{ all -> 0x0203 }
            throw r2     // Catch:{ all -> 0x0203 }
        L_0x00a7:
            boolean r0 = r17.a()     // Catch:{ all -> 0x0205 }
            if (r0 != 0) goto L_0x00bf
            java.lang.String r0 = com.bykv.vk.openvk.component.video.a.c.a.a((com.bykv.vk.openvk.component.video.a.b.e.a) r10, (int) r9)     // Catch:{ all -> 0x0203 }
            r16.e()     // Catch:{ all -> 0x0203 }
            java.nio.charset.Charset r5 = com.bykv.vk.openvk.component.video.a.c.a.a     // Catch:{ all -> 0x0203 }
            byte[] r0 = r0.getBytes(r5)     // Catch:{ all -> 0x0203 }
            int r5 = r0.length     // Catch:{ all -> 0x0203 }
            r6 = 0
            r2.a(r0, r6, r5)     // Catch:{ all -> 0x0203 }
        L_0x00bf:
            r16.e()     // Catch:{ all -> 0x0205 }
            com.bykv.vk.openvk.component.video.a.b.a.a r0 = r1.a     // Catch:{ all -> 0x0205 }
            java.lang.String r5 = r1.h     // Catch:{ all -> 0x0205 }
            java.io.File r5 = r0.d(r5)     // Catch:{ all -> 0x0205 }
            boolean r0 = r1.q     // Catch:{ all -> 0x0205 }
            java.lang.String r6 = ", from: "
            if (r0 == 0) goto L_0x0129
            if (r5 == 0) goto L_0x0129
            long r11 = r5.length()     // Catch:{ all -> 0x0203 }
            int r0 = r17.b()     // Catch:{ all -> 0x0203 }
            long r13 = (long) r0     // Catch:{ all -> 0x0203 }
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x0129
            com.bykv.vk.openvk.component.video.a.b.b.c r0 = r1.b     // Catch:{ all -> 0x0203 }
            java.lang.String r4 = r1.h     // Catch:{ all -> 0x0203 }
            com.bykv.vk.openvk.component.video.a.b.i r9 = r1.i     // Catch:{ all -> 0x0203 }
            com.bykv.vk.openvk.component.video.a.b.i$a r9 = r9.c     // Catch:{ all -> 0x0203 }
            int r9 = r9.a     // Catch:{ all -> 0x0203 }
            com.bykv.vk.openvk.component.video.a.c.a.a(r10, r0, r4, r9)     // Catch:{ all -> 0x0203 }
            com.bykv.vk.openvk.component.video.a.b.h r4 = new com.bykv.vk.openvk.component.video.a.b.h     // Catch:{ a -> 0x00fe }
            java.lang.String r0 = "rwd"
            r4.<init>(r5, r0)     // Catch:{ a -> 0x00fe }
            int r0 = r17.b()     // Catch:{ a -> 0x00fc }
            long r11 = (long) r0     // Catch:{ a -> 0x00fc }
            r4.a((long) r11)     // Catch:{ a -> 0x00fc }
            goto L_0x0104
        L_0x00fc:
            r0 = move-exception
            goto L_0x0100
        L_0x00fe:
            r0 = move-exception
            r4 = 0
        L_0x0100:
            r0.printStackTrace()     // Catch:{ all -> 0x0126 }
            r4 = 0
        L_0x0104:
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x0126 }
            if (r0 == 0) goto L_0x014b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r0.<init>(r3)     // Catch:{ all -> 0x0126 }
            long r11 = r5.length()     // Catch:{ all -> 0x0126 }
            r0.append(r11)     // Catch:{ all -> 0x0126 }
            r0.append(r6)     // Catch:{ all -> 0x0126 }
            int r3 = r17.b()     // Catch:{ all -> 0x0126 }
            r0.append(r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0126 }
            android.util.Log.i(r15, r0)     // Catch:{ all -> 0x0126 }
            goto L_0x014b
        L_0x0126:
            r0 = move-exception
            goto L_0x01de
        L_0x0129:
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x0205 }
            if (r0 == 0) goto L_0x014a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0203 }
            r0.<init>(r4)     // Catch:{ all -> 0x0203 }
            long r3 = r5.length()     // Catch:{ all -> 0x0203 }
            r0.append(r3)     // Catch:{ all -> 0x0203 }
            r0.append(r6)     // Catch:{ all -> 0x0203 }
            int r3 = r17.b()     // Catch:{ all -> 0x0203 }
            r0.append(r3)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0203 }
            android.util.Log.w(r15, r0)     // Catch:{ all -> 0x0203 }
        L_0x014a:
            r4 = 0
        L_0x014b:
            com.bykv.vk.openvk.component.video.a.b.b.c r0 = r1.b     // Catch:{ all -> 0x01dc }
            java.lang.String r3 = r1.h     // Catch:{ all -> 0x01dc }
            int r5 = r16.f()     // Catch:{ all -> 0x01dc }
            com.bykv.vk.openvk.component.video.a.b.b.a r0 = r0.a((java.lang.String) r3, (int) r5)     // Catch:{ all -> 0x01dc }
            if (r0 != 0) goto L_0x015b
            r6 = 0
            goto L_0x015d
        L_0x015b:
            int r6 = r0.c     // Catch:{ all -> 0x01dc }
        L_0x015d:
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r3 = new byte[r0]     // Catch:{ all -> 0x01dc }
            java.io.InputStream r5 = r10.d()     // Catch:{ all -> 0x01dc }
            r9 = 0
        L_0x0166:
            int r0 = r5.read(r3)     // Catch:{ all -> 0x01d8 }
            if (r0 < 0) goto L_0x01b0
            r16.e()     // Catch:{ all -> 0x01d8 }
            if (r0 <= 0) goto L_0x01ab
            r12 = 0
            r2.b(r3, r12, r0)     // Catch:{ all -> 0x01d8 }
            int r9 = r9 + r0
            if (r4 == 0) goto L_0x01a3
            r4.a(r3, r12, r0)     // Catch:{ all -> 0x017c }
            goto L_0x01a3
        L_0x017c:
            r0 = move-exception
            r11 = r0
            r4.a()     // Catch:{ all -> 0x01d8 }
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x019f }
            if (r0 == 0) goto L_0x019d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x019f }
            r0.<init>()     // Catch:{ all -> 0x019f }
            java.lang.String r4 = "append to cache file error in network task!!! "
            r0.append(r4)     // Catch:{ all -> 0x019f }
            java.lang.String r4 = android.util.Log.getStackTraceString(r11)     // Catch:{ all -> 0x019f }
            r0.append(r4)     // Catch:{ all -> 0x019f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x019f }
            android.util.Log.e(r15, r0)     // Catch:{ all -> 0x019f }
        L_0x019d:
            r4 = 0
            goto L_0x01a3
        L_0x019f:
            r0 = move-exception
            r13 = r9
            r12 = 0
            goto L_0x0209
        L_0x01a3:
            int r0 = r17.b()     // Catch:{ all -> 0x01d8 }
            r1.a(r6, r0)     // Catch:{ all -> 0x01d8 }
            goto L_0x01ac
        L_0x01ab:
            r12 = 0
        L_0x01ac:
            r16.e()     // Catch:{ all -> 0x01d8 }
            goto L_0x0166
        L_0x01b0:
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01d8 }
            if (r0 == 0) goto L_0x01b9
            java.lang.String r0 = "read from net complete!"
            android.util.Log.i(r15, r0)     // Catch:{ all -> 0x01d8 }
        L_0x01b9:
            r16.c()     // Catch:{ all -> 0x01d8 }
            java.io.InputStream r0 = r10.d()
            com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r0)
            if (r4 == 0) goto L_0x01c8
            r4.a()
        L_0x01c8:
            java.util.concurrent.atomic.AtomicInteger r0 = r1.c
            r0.addAndGet(r9)
            java.util.concurrent.atomic.AtomicLong r0 = r1.d
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2 - r7
            r0.addAndGet(r2)
            return
        L_0x01d8:
            r0 = move-exception
            r12 = r4
            r13 = r9
            goto L_0x0209
        L_0x01dc:
            r0 = move-exception
            r12 = 0
        L_0x01de:
            r12 = r4
            goto L_0x0208
        L_0x01e0:
            r12 = 0
            com.bykv.vk.openvk.component.video.a.b.c.c r2 = new com.bykv.vk.openvk.component.video.a.b.c.c     // Catch:{ all -> 0x0203 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0203 }
            r3.<init>()     // Catch:{ all -> 0x0203 }
            r3.append(r11)     // Catch:{ all -> 0x0203 }
            r3.append(r14)     // Catch:{ all -> 0x0203 }
            java.lang.String r4 = r1.g     // Catch:{ all -> 0x0203 }
            r3.append(r4)     // Catch:{ all -> 0x0203 }
            java.lang.String r4 = ", url: "
            r3.append(r4)     // Catch:{ all -> 0x0203 }
            r3.append(r0)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0203 }
            r2.<init>(r0)     // Catch:{ all -> 0x0203 }
            throw r2     // Catch:{ all -> 0x0203 }
        L_0x0203:
            r0 = move-exception
            goto L_0x0207
        L_0x0205:
            r0 = move-exception
            r12 = 0
        L_0x0207:
            r12 = 0
        L_0x0208:
            r13 = 0
        L_0x0209:
            java.io.InputStream r2 = r10.d()
            com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r2)
            if (r12 == 0) goto L_0x0215
            r12.a()
        L_0x0215:
            java.util.concurrent.atomic.AtomicInteger r2 = r1.c
            r2.addAndGet(r13)
            java.util.concurrent.atomic.AtomicLong r2 = r1.d
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r3 = r3 - r7
            r2.addAndGet(r3)
            goto L_0x0226
        L_0x0225:
            throw r0
        L_0x0226:
            goto L_0x0225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.b.g.d(com.bykv.vk.openvk.component.video.a.b.g$b, com.bykv.vk.openvk.component.video.a.b.l$a):void");
    }

    public void a() {
        super.a();
        i();
    }

    private void i() {
        b bVar = this.p;
        this.p = null;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* compiled from: ProxyTask */
    private static class b {
        private final OutputStream a;
        private int b;
        private boolean c;

        b(OutputStream outputStream, int i) {
            this.a = outputStream;
            this.b = i;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void a(byte[] bArr, int i, int i2) throws d {
            if (!this.c) {
                try {
                    this.a.write(bArr, i, i2);
                    this.c = true;
                } catch (IOException e) {
                    throw new d(e);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(byte[] bArr, int i, int i2) throws d {
            try {
                this.a.write(bArr, i, i2);
                this.b += i2;
            } catch (IOException e) {
                throw new d(e);
            }
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.b;
        }
    }

    /* compiled from: ProxyTask */
    static final class a {
        com.bykv.vk.openvk.component.video.a.b.a.a a;
        com.bykv.vk.openvk.component.video.a.b.b.c b;
        Socket c;
        c d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public a a(com.bykv.vk.openvk.component.video.a.b.b.c cVar) {
            if (cVar != null) {
                this.b = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* access modifiers changed from: package-private */
        public a a(Socket socket) {
            if (socket != null) {
                this.c = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        /* access modifiers changed from: package-private */
        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public g a() {
            if (this.b != null && this.c != null) {
                return new g(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
