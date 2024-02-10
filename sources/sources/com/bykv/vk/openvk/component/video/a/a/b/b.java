package com.bykv.vk.openvk.component.video.a.a.b;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.c.c;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.b.a.l;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: ReallyVideoPreload */
public class b {
    private Context a;
    /* access modifiers changed from: private */
    public c b;
    /* access modifiers changed from: private */
    public volatile boolean c = false;
    /* access modifiers changed from: private */
    public File d = null;
    private File e = null;
    private final List<a.C0036a> f = new ArrayList();
    private volatile boolean g = false;

    public b(Context context, c cVar) {
        this.a = context;
        this.b = cVar;
        this.d = com.bykv.vk.openvk.component.video.a.e.b.b(cVar.b(), cVar.n());
        this.e = com.bykv.vk.openvk.component.video.a.e.b.c(cVar.b(), cVar.n());
    }

    public void a(a.C0036a aVar) {
        if (this.g) {
            synchronized (a.C0036a.class) {
                this.f.add(aVar);
            }
            return;
        }
        this.f.add(aVar);
        if (b()) {
            com.bykv.vk.openvk.component.video.api.f.c.b("VideoPreload", "Cache file is exist");
            this.b.g(1);
            a(this.b, 200);
            c.a(this.b);
            return;
        }
        this.g = true;
        this.b.g(0);
        c();
    }

    private boolean b() {
        if (this.e.exists()) {
            return true;
        }
        if (this.b.j()) {
            return false;
        }
        if (this.d.length() >= ((long) this.b.c())) {
            return true;
        }
        if (this.b.a() <= 0 || this.d.length() < ((long) this.b.a())) {
            return false;
        }
        return true;
    }

    private void c() {
        j.a aVar;
        if (com.bykv.vk.openvk.component.video.api.c.d() != null) {
            aVar = com.bykv.vk.openvk.component.video.api.c.d().b();
        } else {
            aVar = new j.a("v_preload");
        }
        aVar.a((long) this.b.p(), TimeUnit.MILLISECONDS).b((long) this.b.q(), TimeUnit.MILLISECONDS).c((long) this.b.r(), TimeUnit.MILLISECONDS);
        j a2 = aVar.a();
        l.a aVar2 = new l.a();
        final long length = this.d.length();
        int c2 = this.b.c();
        boolean j = this.b.j();
        int a3 = this.b.a();
        if (a3 > 0) {
            if (((long) a3) >= this.b.i()) {
                j = true;
            } else {
                c2 = a3;
            }
        }
        if (j) {
            aVar2.a("RANGE", "bytes=" + length + "-").a(this.b.m()).a().b();
        } else {
            aVar2.a("RANGE", "bytes=" + length + "-" + c2).a(this.b.m()).a().b();
        }
        a2.a(aVar2.b()).a(new com.bytedance.sdk.component.b.a.c() {
            public void a(com.bytedance.sdk.component.b.a.b bVar, IOException iOException) {
                b bVar2 = b.this;
                bVar2.a(bVar2.b, 601, iOException.getMessage());
                c.a(b.this.b);
            }

            /* JADX WARNING: Removed duplicated region for block: B:102:0x0195 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x017d A[Catch:{ all -> 0x01cc }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x0262 A[Catch:{ all -> 0x02ac }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.component.b.a.b r24, com.bytedance.sdk.component.b.a.n r25) throws java.io.IOException {
                /*
                    r23 = this;
                    r1 = r23
                    r2 = r25
                    long r3 = r2
                    r6 = 3
                    java.lang.String r7 = " Preload size="
                    r8 = 2
                    java.lang.String r9 = "Pre finally "
                    r10 = 4
                    java.lang.String r11 = "VideoPreload"
                    r12 = 1
                    r13 = 0
                    r14 = 0
                    if (r2 == 0) goto L_0x01eb
                    boolean r0 = r25.d()     // Catch:{ all -> 0x01e5 }
                    if (r0 != 0) goto L_0x0076
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x006e }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r0.b     // Catch:{ all -> 0x006e }
                    int r4 = r25.c()     // Catch:{ all -> 0x006e }
                    java.lang.String r15 = r25.e()     // Catch:{ all -> 0x006e }
                    r0.a((com.bykv.vk.openvk.component.video.api.c.c) r3, (int) r4, (java.lang.String) r15)     // Catch:{ all -> 0x006e }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r14)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r14)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r14)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    java.lang.Object[] r0 = new java.lang.Object[r10]
                    r0[r13] = r9
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.m()
                    r0[r12] = r2
                    r0[r8] = r7
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.c()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r0[r6] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r11, (java.lang.Object[]) r0)
                L_0x0064:
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r0 = r0.b
                    com.bykv.vk.openvk.component.video.a.a.b.c.a(r0)
                    return
                L_0x006e:
                    r0 = move-exception
                    r3 = r11
                    r4 = r14
                    r6 = r4
                L_0x0072:
                    r5 = 601(0x259, float:8.42E-43)
                    goto L_0x0252
                L_0x0076:
                    com.bytedance.sdk.component.b.a.o r15 = r25.f()     // Catch:{ all -> 0x01e5 }
                    com.bytedance.sdk.component.b.a.o r15 = r25.f()     // Catch:{ all -> 0x01dd }
                    r16 = 0
                    if (r0 == 0) goto L_0x0099
                    if (r15 == 0) goto L_0x0099
                    long r5 = r2     // Catch:{ all -> 0x0094 }
                    long r18 = r15.a()     // Catch:{ all -> 0x0094 }
                    long r5 = r5 + r18
                    java.io.InputStream r0 = r15.c()     // Catch:{ all -> 0x0094 }
                    r18 = r5
                    r5 = r0
                    goto L_0x009c
                L_0x0094:
                    r0 = move-exception
                    r3 = r11
                    r4 = r14
                    r6 = r4
                    goto L_0x00ef
                L_0x0099:
                    r5 = r14
                    r18 = r16
                L_0x009c:
                    if (r5 != 0) goto L_0x00f1
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x00eb }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r0.b     // Catch:{ all -> 0x00eb }
                    int r4 = r25.c()     // Catch:{ all -> 0x00eb }
                    java.lang.String r6 = r25.e()     // Catch:{ all -> 0x00eb }
                    r0.a((com.bykv.vk.openvk.component.video.api.c.c) r3, (int) r4, (java.lang.String) r6)     // Catch:{ all -> 0x00eb }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r14)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r5)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r15)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    java.lang.Object[] r0 = new java.lang.Object[r10]
                    r0[r13] = r9
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.m()
                    r0[r12] = r2
                    r0[r8] = r7
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.c()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r3 = 3
                    r0[r3] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r11, (java.lang.Object[]) r0)
                    goto L_0x0064
                L_0x00eb:
                    r0 = move-exception
                    r4 = r5
                    r3 = r11
                    r6 = r14
                L_0x00ef:
                    r14 = r15
                    goto L_0x0072
                L_0x00f1:
                    java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ all -> 0x01d8 }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01d8 }
                    java.io.File r0 = r0.d     // Catch:{ all -> 0x01d8 }
                    java.lang.String r14 = "rw"
                    r6.<init>(r0, r14)     // Catch:{ all -> 0x01d8 }
                    r0 = 8192(0x2000, float:1.14794E-41)
                    byte[] r0 = new byte[r0]     // Catch:{ all -> 0x01d3 }
                    r20 = r16
                    r14 = 0
                L_0x0105:
                    int r8 = 8192 - r14
                    int r8 = r5.read(r0, r14, r8)     // Catch:{ all -> 0x01d3 }
                    r12 = -1
                    if (r8 == r12) goto L_0x019c
                    com.bykv.vk.openvk.component.video.a.a.b.b r12 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01d3 }
                    boolean r12 = r12.c     // Catch:{ all -> 0x01d3 }
                    if (r12 == 0) goto L_0x0161
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01d3 }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r0.b     // Catch:{ all -> 0x01d3 }
                    int r4 = r25.c()     // Catch:{ all -> 0x01d3 }
                    r0.b(r3, r4)     // Catch:{ all -> 0x01d3 }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r6)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r5)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r15)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    java.lang.Object[] r0 = new java.lang.Object[r10]
                    r0[r13] = r9
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.m()
                    r3 = 1
                    r0[r3] = r2
                    r2 = 2
                    r0[r2] = r7
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.c()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r3 = 3
                    r0[r3] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r11, (java.lang.Object[]) r0)
                    goto L_0x0064
                L_0x0161:
                    int r14 = r14 + r8
                    r22 = r11
                    long r10 = (long) r8
                    long r20 = r20 + r10
                    r10 = 8192(0x2000, double:4.0474E-320)
                    long r10 = r20 % r10
                    int r8 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
                    if (r8 == 0) goto L_0x017a
                    long r10 = r2     // Catch:{ all -> 0x01cc }
                    long r10 = r18 - r10
                    int r8 = (r20 > r10 ? 1 : (r20 == r10 ? 0 : -1))
                    if (r8 != 0) goto L_0x0178
                    goto L_0x017a
                L_0x0178:
                    r8 = 0
                    goto L_0x017b
                L_0x017a:
                    r8 = 1
                L_0x017b:
                    if (r8 == 0) goto L_0x0195
                    java.lang.Long r8 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x01cc }
                    int r8 = r8.intValue()     // Catch:{ all -> 0x01cc }
                    com.bykv.vk.openvk.component.video.a.a.b.b r10 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01cc }
                    com.bykv.vk.openvk.component.video.api.c.c r10 = r10.b     // Catch:{ all -> 0x01cc }
                    java.lang.String r10 = r10.n()     // Catch:{ all -> 0x01cc }
                    com.bykv.vk.openvk.component.video.a.e.b.a(r6, r0, r8, r14, r10)     // Catch:{ all -> 0x01cc }
                    long r10 = (long) r14     // Catch:{ all -> 0x01cc }
                    long r3 = r3 + r10
                    r14 = 0
                L_0x0195:
                    r11 = r22
                    r8 = 2
                    r10 = 4
                    r12 = 1
                    goto L_0x0105
                L_0x019c:
                    r22 = r11
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01cc }
                    com.bykv.vk.openvk.component.video.api.c.c r0 = r0.b     // Catch:{ all -> 0x01cc }
                    boolean r0 = r0.j()     // Catch:{ all -> 0x01cc }
                    if (r0 == 0) goto L_0x01bd
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01cc }
                    java.io.File r0 = r0.d     // Catch:{ all -> 0x01cc }
                    long r3 = r0.length()     // Catch:{ all -> 0x01cc }
                    int r0 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x01bd
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01cc }
                    r0.e()     // Catch:{ all -> 0x01cc }
                L_0x01bd:
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01cc }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r0.b     // Catch:{ all -> 0x01cc }
                    int r4 = r25.c()     // Catch:{ all -> 0x01cc }
                    r0.a((com.bykv.vk.openvk.component.video.api.c.c) r3, (int) r4)     // Catch:{ all -> 0x01cc }
                    r14 = r6
                    goto L_0x01fd
                L_0x01cc:
                    r0 = move-exception
                    r4 = r5
                    r14 = r15
                    r3 = r22
                    goto L_0x0072
                L_0x01d3:
                    r0 = move-exception
                    r4 = r5
                    r3 = r11
                    goto L_0x00ef
                L_0x01d8:
                    r0 = move-exception
                    r4 = r5
                    r3 = r11
                    r14 = r15
                    goto L_0x01e1
                L_0x01dd:
                    r0 = move-exception
                    r3 = r11
                    r14 = r15
                    r4 = 0
                L_0x01e1:
                    r5 = 601(0x259, float:8.42E-43)
                    r6 = 0
                    goto L_0x0252
                L_0x01e5:
                    r0 = move-exception
                    r3 = r11
                    r4 = 0
                    r5 = 601(0x259, float:8.42E-43)
                    goto L_0x0250
                L_0x01eb:
                    r22 = r11
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x024a }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r0.b     // Catch:{ all -> 0x024a }
                    java.lang.String r4 = "Network link failed."
                    r5 = 601(0x259, float:8.42E-43)
                    r0.a((com.bykv.vk.openvk.component.video.api.c.c) r3, (int) r5, (java.lang.String) r4)     // Catch:{ all -> 0x0246 }
                    r5 = 0
                    r14 = 0
                    r15 = 0
                L_0x01fd:
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r14)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r5)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r15)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    r2 = 4
                    java.lang.Object[] r0 = new java.lang.Object[r2]
                    r0[r13] = r9
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.m()
                    r3 = 1
                    r0[r3] = r2
                    r2 = 2
                    r0[r2] = r7
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.c()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r3 = 3
                    r0[r3] = r2
                    r3 = r22
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r3, (java.lang.Object[]) r0)
                L_0x023c:
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r0 = r0.b
                    com.bykv.vk.openvk.component.video.a.a.b.c.a(r0)
                    goto L_0x02ab
                L_0x0246:
                    r0 = move-exception
                    r3 = r22
                    goto L_0x024f
                L_0x024a:
                    r0 = move-exception
                    r3 = r22
                    r5 = 601(0x259, float:8.42E-43)
                L_0x024f:
                    r4 = 0
                L_0x0250:
                    r6 = 0
                    r14 = 0
                L_0x0252:
                    r0.printStackTrace()     // Catch:{ all -> 0x02ac }
                    com.bykv.vk.openvk.component.video.a.a.b.b r8 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x02ac }
                    r8.d()     // Catch:{ all -> 0x02ac }
                    com.bykv.vk.openvk.component.video.a.a.b.b r8 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x02ac }
                    com.bykv.vk.openvk.component.video.api.c.c r10 = r8.b     // Catch:{ all -> 0x02ac }
                    if (r2 == 0) goto L_0x0266
                    int r5 = r25.c()     // Catch:{ all -> 0x02ac }
                L_0x0266:
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02ac }
                    r8.a((com.bykv.vk.openvk.component.video.api.c.c) r10, (int) r5, (java.lang.String) r0)     // Catch:{ all -> 0x02ac }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r6)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r4)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r14)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    r2 = 4
                    java.lang.Object[] r0 = new java.lang.Object[r2]
                    r0[r13] = r9
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.m()
                    r4 = 1
                    r0[r4] = r2
                    r2 = 2
                    r0[r2] = r7
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.c()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r4 = 3
                    r0[r4] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r3, (java.lang.Object[]) r0)
                    goto L_0x023c
                L_0x02ab:
                    return
                L_0x02ac:
                    r0 = move-exception
                    com.bykv.vk.openvk.component.video.a.a.b.b r5 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r5.a((java.io.Closeable) r6)
                    com.bykv.vk.openvk.component.video.a.a.b.b r5 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r5.a((java.io.Closeable) r4)
                    com.bykv.vk.openvk.component.video.a.a.b.b r4 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r4.a((java.io.Closeable) r14)
                    com.bykv.vk.openvk.component.video.a.a.b.b r4 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r4.a((java.io.Closeable) r2)
                    r2 = 4
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r2[r13] = r9
                    com.bykv.vk.openvk.component.video.a.a.b.b r4 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r4 = r4.b
                    java.lang.String r4 = r4.m()
                    r5 = 1
                    r2[r5] = r4
                    r4 = 2
                    r2[r4] = r7
                    com.bykv.vk.openvk.component.video.a.a.b.b r4 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r4 = r4.b
                    int r4 = r4.c()
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r5 = 3
                    r2[r5] = r4
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r3, (java.lang.Object[]) r2)
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    com.bykv.vk.openvk.component.video.a.a.b.c.a(r2)
                    goto L_0x02f5
                L_0x02f4:
                    throw r0
                L_0x02f5:
                    goto L_0x02f4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.a.b.b.AnonymousClass1.a(com.bytedance.sdk.component.b.a.b, com.bytedance.sdk.component.b.a.n):void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public c a() {
        return this.b;
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* access modifiers changed from: private */
    public void a(c cVar, int i) {
        synchronized (a.C0036a.class) {
            for (a.C0036a next : this.f) {
                if (next != null) {
                    next.a(cVar, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(c cVar, int i, String str) {
        synchronized (a.C0036a.class) {
            for (a.C0036a next : this.f) {
                if (next != null) {
                    next.a(cVar, i, str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(c cVar, int i) {
        synchronized (a.C0036a.class) {
            for (a.C0036a next : this.f) {
                if (next != null) {
                    next.b(cVar, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            this.e.delete();
            this.d.delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            if (!this.d.renameTo(this.e)) {
                throw new IOException("Error renaming file " + this.d + " to " + this.e + " for completion!");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.bykv.vk.openvk.component.video.api.f.c.b("VideoPreload", th.getMessage());
        }
    }
}
