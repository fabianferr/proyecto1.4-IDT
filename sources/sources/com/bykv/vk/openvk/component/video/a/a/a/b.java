package com.bykv.vk.openvk.component.video.a.a.a;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.c.c;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.b.a.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

/* compiled from: MediaDownloadPlayCacheImpl */
public class b implements c {
    /* access modifiers changed from: private */
    public volatile long a = -2147483648L;
    /* access modifiers changed from: private */
    public final Object b = new Object();
    /* access modifiers changed from: private */
    public File c;
    private File d;
    /* access modifiers changed from: private */
    public long e = 0;
    /* access modifiers changed from: private */
    public volatile long f = -1;
    private volatile boolean g = false;
    /* access modifiers changed from: private */
    public volatile boolean h = false;
    /* access modifiers changed from: private */
    public RandomAccessFile i = null;
    /* access modifiers changed from: private */
    public final c j;

    public b(Context context, c cVar) {
        this.j = cVar;
        try {
            this.c = com.bykv.vk.openvk.component.video.a.e.b.b(cVar.b(), cVar.n());
            this.d = com.bykv.vk.openvk.component.video.a.e.b.c(cVar.b(), cVar.n());
            if (d()) {
                this.i = new RandomAccessFile(this.d, CampaignEx.JSON_KEY_AD_R);
            } else {
                this.i = new RandomAccessFile(this.c, "rw");
            }
            if (!d()) {
                this.e = this.c.length();
                a();
            }
        } catch (Throwable unused) {
            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", "Error using file ", cVar.m(), " as disc cache");
        }
    }

    private boolean d() {
        return this.d.exists();
    }

    public void a() {
        j.a aVar;
        if (com.bykv.vk.openvk.component.video.api.c.d() != null) {
            aVar = com.bykv.vk.openvk.component.video.api.c.d().b();
        } else {
            aVar = new j.a("v_cache");
        }
        aVar.a((long) this.j.p(), TimeUnit.MILLISECONDS).b((long) this.j.q(), TimeUnit.MILLISECONDS).c((long) this.j.r(), TimeUnit.MILLISECONDS);
        j a2 = aVar.a();
        com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", "RANGE, bytes=", Long.valueOf(this.e), " file hash=", this.j.n());
        l.a aVar2 = new l.a();
        a2.a(aVar2.a("RANGE", "bytes=" + this.e + "-").a(this.j.m()).a().b()).a(new com.bytedance.sdk.component.b.a.c() {
            public void a(com.bytedance.sdk.component.b.a.b bVar, IOException iOException) {
                boolean unused = b.this.h = false;
                long unused2 = b.this.a = -1;
            }

            /* JADX WARNING: Removed duplicated region for block: B:113:0x0157 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x012d A[Catch:{ all -> 0x01bd }] */
            /* JADX WARNING: Removed duplicated region for block: B:79:0x0215 A[SYNTHETIC, Splitter:B:79:0x0215] */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x021d A[Catch:{ all -> 0x0219 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0222 A[Catch:{ all -> 0x0219 }] */
            /* JADX WARNING: Removed duplicated region for block: B:91:0x0241 A[Catch:{ all -> 0x0219 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.component.b.a.b r25, com.bytedance.sdk.component.b.a.n r26) throws java.io.IOException {
                /*
                    r24 = this;
                    r1 = r24
                    r2 = 0
                    if (r26 == 0) goto L_0x0285
                    r3 = 0
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0200 }
                    boolean r4 = r26.d()     // Catch:{ all -> 0x0200 }
                    boolean unused = r0.h = r4     // Catch:{ all -> 0x0200 }
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0200 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0200 }
                    if (r0 == 0) goto L_0x01bf
                    com.bytedance.sdk.component.b.a.o r4 = r26.f()     // Catch:{ all -> 0x0200 }
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    boolean r0 = r0.h     // Catch:{ all -> 0x01bd }
                    if (r0 == 0) goto L_0x0039
                    if (r4 == 0) goto L_0x0039
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r5 = r4.a()     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r7 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r7 = r7.e     // Catch:{ all -> 0x01bd }
                    long r5 = r5 + r7
                    long unused = r0.a = r5     // Catch:{ all -> 0x01bd }
                    java.io.InputStream r3 = r4.c()     // Catch:{ all -> 0x01bd }
                L_0x0039:
                    if (r3 != 0) goto L_0x0073
                    if (r3 == 0) goto L_0x0043
                    r3.close()     // Catch:{ all -> 0x0041 }
                    goto L_0x0043
                L_0x0041:
                    r0 = move-exception
                    goto L_0x006f
                L_0x0043:
                    if (r4 == 0) goto L_0x0048
                    r4.close()     // Catch:{ all -> 0x0041 }
                L_0x0048:
                    if (r26 == 0) goto L_0x004d
                    r26.close()     // Catch:{ all -> 0x0041 }
                L_0x004d:
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0041 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0041 }
                    if (r0 == 0) goto L_0x0072
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0041 }
                    java.io.File r0 = r0.c     // Catch:{ all -> 0x0041 }
                    long r2 = r0.length()     // Catch:{ all -> 0x0041 }
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0041 }
                    long r4 = r0.a     // Catch:{ all -> 0x0041 }
                    int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r0 != 0) goto L_0x0072
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0041 }
                    r0.f()     // Catch:{ all -> 0x0041 }
                    goto L_0x0072
                L_0x006f:
                    r0.printStackTrace()
                L_0x0072:
                    return
                L_0x0073:
                    r0 = 8192(0x2000, float:1.14794E-41)
                    byte[] r0 = new byte[r0]     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r5 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r5 = r5.e     // Catch:{ all -> 0x01bd }
                    r7 = 0
                    r10 = r7
                    r9 = 0
                L_0x0081:
                    int r12 = 8192 - r9
                    int r12 = r3.read(r0, r9, r12)     // Catch:{ all -> 0x01bd }
                    r13 = -1
                    r15 = 8
                    r16 = 7
                    r17 = 6
                    r18 = 5
                    r19 = 4
                    r20 = 3
                    r21 = 2
                    r14 = 10
                    r22 = 1
                    if (r12 == r13) goto L_0x015b
                    int r9 = r9 + r12
                    long r12 = (long) r12     // Catch:{ all -> 0x01bd }
                    long r10 = r10 + r12
                    r12 = 8192(0x2000, double:4.0474E-320)
                    long r12 = r10 % r12
                    int r23 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
                    if (r23 == 0) goto L_0x00bb
                    com.bykv.vk.openvk.component.video.a.a.a.b r12 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r12 = r12.a     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r7 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r7 = r7.e     // Catch:{ all -> 0x01bd }
                    long r12 = r12 - r7
                    int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                    if (r7 != 0) goto L_0x00b9
                    goto L_0x00bb
                L_0x00b9:
                    r7 = 0
                    goto L_0x00bc
                L_0x00bb:
                    r7 = 1
                L_0x00bc:
                    java.lang.String r8 = "CSJ_MediaDLPlay"
                    r12 = 14
                    java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = "Write segment,execAppend ="
                    r12[r2] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.Boolean r13 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x01bd }
                    r12[r22] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = " offset="
                    r12[r21] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.Integer r13 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x01bd }
                    r12[r20] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = " totalLength = "
                    r12[r19] = r13     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r13 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r19 = r13.a     // Catch:{ all -> 0x01bd }
                    java.lang.Long r13 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x01bd }
                    r12[r18] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = " saveSize ="
                    r12[r17] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01bd }
                    r12[r16] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = " startSaved="
                    r12[r15] = r13     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r13 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r15 = r13.e     // Catch:{ all -> 0x01bd }
                    java.lang.Long r13 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x01bd }
                    r15 = 9
                    r12[r15] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = " fileHash="
                    r12[r14] = r13     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r13 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.api.c.c r13 = r13.j     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = r13.n()     // Catch:{ all -> 0x01bd }
                    r14 = 11
                    r12[r14] = r13     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = " url="
                    r14 = 12
                    r12[r14] = r13     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r13 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.api.c.c r13 = r13.j     // Catch:{ all -> 0x01bd }
                    java.lang.String r13 = r13.m()     // Catch:{ all -> 0x01bd }
                    r14 = 13
                    r12[r14] = r13     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r8, (java.lang.Object[]) r12)     // Catch:{ all -> 0x01bd }
                    if (r7 == 0) goto L_0x0157
                    com.bykv.vk.openvk.component.video.a.a.a.b r7 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    java.lang.Object r7 = r7.b     // Catch:{ all -> 0x01bd }
                    monitor-enter(r7)     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r8 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0154 }
                    java.io.RandomAccessFile r8 = r8.i     // Catch:{ all -> 0x0154 }
                    java.lang.Long r12 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0154 }
                    int r12 = r12.intValue()     // Catch:{ all -> 0x0154 }
                    com.bykv.vk.openvk.component.video.a.a.a.b r13 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0154 }
                    com.bykv.vk.openvk.component.video.api.c.c r13 = r13.j     // Catch:{ all -> 0x0154 }
                    java.lang.String r13 = r13.n()     // Catch:{ all -> 0x0154 }
                    com.bykv.vk.openvk.component.video.a.e.b.a(r8, r0, r12, r9, r13)     // Catch:{ all -> 0x0154 }
                    monitor-exit(r7)     // Catch:{ all -> 0x0154 }
                    long r7 = (long) r9     // Catch:{ all -> 0x0154 }
                    long r5 = r5 + r7
                    r9 = 0
                    goto L_0x0157
                L_0x0154:
                    r0 = move-exception
                    monitor-exit(r7)     // Catch:{ all -> 0x0154 }
                    throw r0     // Catch:{ all -> 0x01bd }
                L_0x0157:
                    r7 = 0
                    goto L_0x0081
                L_0x015b:
                    java.lang.String r0 = "CSJ_MediaDLPlay"
                    java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x01bd }
                    java.lang.String r6 = "Write segment,Write over, startIndex ="
                    r5[r2] = r6     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r6 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r6 = r6.e     // Catch:{ all -> 0x01bd }
                    java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01bd }
                    r5[r22] = r6     // Catch:{ all -> 0x01bd }
                    java.lang.String r6 = " totalLength = "
                    r5[r21] = r6     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r6 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r6 = r6.a     // Catch:{ all -> 0x01bd }
                    java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01bd }
                    r5[r20] = r6     // Catch:{ all -> 0x01bd }
                    java.lang.String r6 = " saveSize = "
                    r5[r19] = r6     // Catch:{ all -> 0x01bd }
                    java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01bd }
                    r5[r18] = r6     // Catch:{ all -> 0x01bd }
                    java.lang.String r6 = " writeEndSegment ="
                    r5[r17] = r6     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r6 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r6 = r6.a     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r8 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    long r8 = r8.e     // Catch:{ all -> 0x01bd }
                    long r6 = r6 - r8
                    int r8 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                    if (r8 != 0) goto L_0x019f
                    goto L_0x01a1
                L_0x019f:
                    r22 = 0
                L_0x01a1:
                    java.lang.Boolean r6 = java.lang.Boolean.valueOf(r22)     // Catch:{ all -> 0x01bd }
                    r5[r16] = r6     // Catch:{ all -> 0x01bd }
                    java.lang.String r6 = " url="
                    r5[r15] = r6     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.a.a.a.b r6 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.api.c.c r6 = r6.j     // Catch:{ all -> 0x01bd }
                    java.lang.String r6 = r6.m()     // Catch:{ all -> 0x01bd }
                    r7 = 9
                    r5[r7] = r6     // Catch:{ all -> 0x01bd }
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r0, (java.lang.Object[]) r5)     // Catch:{ all -> 0x01bd }
                    goto L_0x01ce
                L_0x01bd:
                    r0 = move-exception
                    goto L_0x0202
                L_0x01bf:
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0200 }
                    boolean unused = r0.h = r2     // Catch:{ all -> 0x0200 }
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0200 }
                    long r4 = r0.f     // Catch:{ all -> 0x0200 }
                    long unused = r0.a = r4     // Catch:{ all -> 0x0200 }
                    r4 = r3
                L_0x01ce:
                    if (r3 == 0) goto L_0x01d3
                    r3.close()     // Catch:{ all -> 0x0219 }
                L_0x01d3:
                    if (r4 == 0) goto L_0x01d8
                    r4.close()     // Catch:{ all -> 0x0219 }
                L_0x01d8:
                    if (r26 == 0) goto L_0x01dd
                    r26.close()     // Catch:{ all -> 0x0219 }
                L_0x01dd:
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0219 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0219 }
                    if (r0 == 0) goto L_0x0293
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0219 }
                    java.io.File r0 = r0.c     // Catch:{ all -> 0x0219 }
                    long r2 = r0.length()     // Catch:{ all -> 0x0219 }
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0219 }
                    long r4 = r0.a     // Catch:{ all -> 0x0219 }
                    int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r0 != 0) goto L_0x0293
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0219 }
                    r0.f()     // Catch:{ all -> 0x0219 }
                    goto L_0x0293
                L_0x0200:
                    r0 = move-exception
                    r4 = r3
                L_0x0202:
                    com.bykv.vk.openvk.component.video.a.a.a.b r5 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x024b }
                    boolean unused = r5.h = r2     // Catch:{ all -> 0x024b }
                    com.bykv.vk.openvk.component.video.a.a.a.b r2 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x024b }
                    long r5 = r2.f     // Catch:{ all -> 0x024b }
                    long unused = r2.a = r5     // Catch:{ all -> 0x024b }
                    r0.printStackTrace()     // Catch:{ all -> 0x024b }
                    if (r3 == 0) goto L_0x021b
                    r3.close()     // Catch:{ all -> 0x0219 }
                    goto L_0x021b
                L_0x0219:
                    r0 = move-exception
                    goto L_0x0247
                L_0x021b:
                    if (r4 == 0) goto L_0x0220
                    r4.close()     // Catch:{ all -> 0x0219 }
                L_0x0220:
                    if (r26 == 0) goto L_0x0225
                    r26.close()     // Catch:{ all -> 0x0219 }
                L_0x0225:
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0219 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0219 }
                    if (r0 == 0) goto L_0x0293
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0219 }
                    java.io.File r0 = r0.c     // Catch:{ all -> 0x0219 }
                    long r2 = r0.length()     // Catch:{ all -> 0x0219 }
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0219 }
                    long r4 = r0.a     // Catch:{ all -> 0x0219 }
                    int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r0 != 0) goto L_0x0293
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0219 }
                    r0.f()     // Catch:{ all -> 0x0219 }
                    goto L_0x0293
                L_0x0247:
                    r0.printStackTrace()
                    goto L_0x0293
                L_0x024b:
                    r0 = move-exception
                    r2 = r0
                    if (r3 == 0) goto L_0x0255
                    r3.close()     // Catch:{ all -> 0x0253 }
                    goto L_0x0255
                L_0x0253:
                    r0 = move-exception
                    goto L_0x0281
                L_0x0255:
                    if (r4 == 0) goto L_0x025a
                    r4.close()     // Catch:{ all -> 0x0253 }
                L_0x025a:
                    if (r26 == 0) goto L_0x025f
                    r26.close()     // Catch:{ all -> 0x0253 }
                L_0x025f:
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0253 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0253 }
                    if (r0 == 0) goto L_0x0284
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0253 }
                    java.io.File r0 = r0.c     // Catch:{ all -> 0x0253 }
                    long r3 = r0.length()     // Catch:{ all -> 0x0253 }
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0253 }
                    long r5 = r0.a     // Catch:{ all -> 0x0253 }
                    int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r0 != 0) goto L_0x0284
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this     // Catch:{ all -> 0x0253 }
                    r0.f()     // Catch:{ all -> 0x0253 }
                    goto L_0x0284
                L_0x0281:
                    r0.printStackTrace()
                L_0x0284:
                    throw r2
                L_0x0285:
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this
                    boolean unused = r0.h = r2
                    com.bykv.vk.openvk.component.video.a.a.a.b r0 = com.bykv.vk.openvk.component.video.a.a.a.b.this
                    long r2 = r0.f
                    long unused = r0.a = r2
                L_0x0293:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.a.a.b.AnonymousClass1.a(com.bytedance.sdk.component.b.a.b, com.bytedance.sdk.component.b.a.n):void");
            }
        });
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        long j3 = j2;
        try {
            if (j3 == this.a) {
                return -1;
            }
            int i4 = 0;
            int i5 = 0;
            while (!this.g) {
                synchronized (this.b) {
                    long e2 = e();
                    if (j3 < e2) {
                        com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", "read:  read " + j3 + " success");
                        this.i.seek(j3);
                        i5 = this.i.read(bArr, i2, i3);
                    } else {
                        byte[] bArr2 = bArr;
                        int i6 = i2;
                        int i7 = i3;
                        com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", "read: wait at ", Long.valueOf(j2), "  file size = ", Long.valueOf(e2));
                        i4 += 33;
                        this.b.wait(33);
                    }
                }
                if (i5 > 0) {
                    return i5;
                }
                if (i4 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    public void b() {
        try {
            if (!this.g) {
                this.i.close();
            }
            File file = this.c;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.d;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.g = true;
        return;
    }

    private long e() {
        if (d()) {
            return this.d.length();
        }
        return this.c.length();
    }

    /* access modifiers changed from: private */
    public void f() throws IOException {
        synchronized (this.b) {
            if (d()) {
                com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", "complete: isCompleted ", this.j.m(), this.j.n());
                return;
            }
            try {
                if (this.c.renameTo(this.d)) {
                    RandomAccessFile randomAccessFile = this.i;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    this.i = new RandomAccessFile(this.d, "rw");
                    com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", "complete: rename ", this.j.n(), this.j.m());
                    return;
                }
                throw new IOException("Error renaming file " + this.c + " to " + this.d + " for completion!");
            } catch (Throwable th) {
                th.printStackTrace();
                com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", th.getMessage());
            }
        }
    }

    public long c() throws IOException {
        if (d()) {
            this.a = this.d.length();
        } else {
            synchronized (this.b) {
                int i2 = 0;
                do {
                    if (this.a == -2147483648L) {
                        try {
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", "totalLength: wait");
                            i2 += 15;
                            this.b.wait(5);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i2 <= 20000);
                return -1;
            }
        }
        com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.a));
        return this.a;
    }
}
