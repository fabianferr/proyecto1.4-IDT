package com.umlaut.crowd.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class xa extends Thread {
    private za a = null;
    private a[] b;
    private boolean c = false;
    private boolean d = false;
    private Random e = new Random();
    private int f = 0;
    private long g = -1;
    private long h = -1;
    private b9 i;
    private ByteBuffer j;
    private boolean k;
    private long l;
    private long m = -1;
    private long n = 0;
    private long o = 0;
    private byte[] p;
    private int q = 0;
    private final int r = 10000;

    class a extends q6<r9, ea> {
        a() {
        }
    }

    public xa(boolean z) {
        this.k = z;
    }

    private void g() throws IOException {
        a[] aVarArr;
        V v;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            aVarArr = this.b;
            if (i2 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i2];
            ((r9) aVar.a).c().socket().setTcpNoDelay(true);
            int capacity = ((r9) aVar.a).b().capacity();
            if (i3 < capacity) {
                i3 = capacity;
            }
            ((r9) aVar.a).c().configureBlocking(false);
            long j2 = this.g;
            if (j2 > 0) {
                v = new ea(j2);
            } else {
                v = new ea(Long.MAX_VALUE);
            }
            aVar.b = v;
            if (this.k) {
                ((r9) aVar.a).a(this.i, 5, aVar);
            } else {
                ((r9) aVar.a).a(this.i, 1, aVar);
            }
            i2++;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i3 * aVarArr.length);
        this.j = allocate;
        this.p = new byte[allocate.capacity()];
        this.q = 0;
        this.j.limit(0);
        if (this.k) {
            for (int i4 = 0; i4 < this.b.length; i4++) {
                b();
                long write = (long) ((r9) this.b[i4].a).write(this.j);
                ((ea) this.b[i4].b).a(0, write);
                this.n += write;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01c8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x019a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x019d, code lost:
        if (r1.k != false) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a0, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01c1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0177 A[Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1, IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0186 A[SYNTHETIC, Splitter:B:83:0x0186] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c1 A[ExcHandler: ClosedSelectorException (e java.nio.channels.ClosedSelectorException), PHI: r7 r10 
      PHI: (r7v9 int) = (r7v1 int), (r7v10 int), (r7v10 int), (r7v10 int), (r7v10 int), (r7v10 int), (r7v10 int) binds: [B:19:0x0072, B:45:0x00cb, B:57:0x010e, B:86:0x019b, B:73:0x0162, B:83:0x0186, B:84:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v7 long) = (r10v2 long), (r10v2 long), (r10v9 long), (r10v9 long), (r10v9 long), (r10v9 long), (r10v9 long) binds: [B:19:0x0072, B:45:0x00cb, B:57:0x010e, B:86:0x019b, B:73:0x0162, B:83:0x0186, B:84:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:19:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() throws java.io.IOException {
        /*
            r30 = this;
            r1 = r30
            long r2 = java.lang.System.nanoTime()
            com.umlaut.crowd.internal.za r0 = r1.a
            if (r0 == 0) goto L_0x0011
            long r4 = java.lang.System.currentTimeMillis()
            r0.a((long) r4)
        L_0x0011:
            com.umlaut.crowd.internal.b9 r0 = r1.i
            java.util.Set r0 = r0.h()
            java.util.Iterator r0 = r0.iterator()
        L_0x001b:
            boolean r4 = r0.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x0036
            java.lang.Object r4 = r0.next()
            com.umlaut.crowd.internal.a9 r4 = (com.umlaut.crowd.internal.a9) r4
            java.lang.Object r4 = r4.a()
            com.umlaut.crowd.internal.xa$a r4 = (com.umlaut.crowd.internal.xa.a) r4
            V r4 = r4.b
            com.umlaut.crowd.internal.ea r4 = (com.umlaut.crowd.internal.ea) r4
            r4.a((long) r2, (boolean) r5)
            goto L_0x001b
        L_0x0036:
            long r6 = r1.l
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x0040
            r6 = 10000(0x2710, double:4.9407E-320)
        L_0x0040:
            long r10 = r1.h
            r12 = 1
            r14 = 2
            r16 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x0054
            long r10 = r6 * r16
            long r10 = r10 * r16
            long r10 = r10 + r2
            r18 = r6
            goto L_0x0065
        L_0x0054:
            boolean r0 = r1.k
            if (r0 == 0) goto L_0x0062
            long r10 = r10 * r14
            long r10 = r10 + r2
            r18 = r6
            long r5 = r1.g
            long r10 = r10 + r5
            long r10 = r10 + r12
            goto L_0x0065
        L_0x0062:
            r18 = r6
            long r10 = r10 + r2
        L_0x0065:
            long r5 = r1.g
            long r5 = r5 * r14
            long r5 = r5 + r2
            long r14 = java.lang.System.nanoTime()
            r7 = -1
            r20 = 0
        L_0x0071:
            r4 = 1
            boolean r12 = r1.d     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r12 != 0) goto L_0x01cd
            long r12 = r1.h     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            int r21 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r21 <= 0) goto L_0x0089
            long r12 = r10 - r14
            r14 = 1000000(0xf4240, double:4.940656E-318)
            long r12 = r12 / r14
            int r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r14 > 0) goto L_0x008b
            r12 = 1
            goto L_0x008b
        L_0x0089:
            r12 = r18
        L_0x008b:
            com.umlaut.crowd.internal.b9 r14 = r1.i     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            int r12 = r14.b((long) r12)     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            long r14 = java.lang.System.nanoTime()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            com.umlaut.crowd.internal.za r13 = r1.a     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r13 == 0) goto L_0x00c9
            long r21 = r14 - r5
            int r13 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
            if (r13 <= 0) goto L_0x00c9
            long r5 = r14 - r2
            long r8 = r1.g     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            long r5 = r5 / r8
            int r6 = (int) r5
            int r6 = r6 - r4
        L_0x00a6:
            int r5 = r7 + 1
            r28 = r7
            r7 = r5
            r5 = r28
            if (r7 >= r6) goto L_0x00b3
            r1.a((int) r7)     // Catch:{ IOException -> 0x00c5, ClosedSelectorException -> 0x00c1 }
            goto L_0x00a6
        L_0x00b3:
            long r6 = r1.g     // Catch:{ IOException -> 0x00c5, ClosedSelectorException -> 0x00c1 }
            int r8 = r5 + 1
            long r8 = (long) r8
            long r6 = r6 * r8
            long r6 = r6 + r2
            r28 = r6
            r7 = r5
            r5 = r28
            goto L_0x00c9
        L_0x00c1:
            r0 = move-exception
            r7 = r5
            goto L_0x01c2
        L_0x00c5:
            r0 = move-exception
            r7 = r5
            goto L_0x01c9
        L_0x00c9:
            if (r12 == 0) goto L_0x01a8
            long r8 = r1.h     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            r12 = 0
            int r23 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r23 > 0) goto L_0x00d9
            long r8 = r18 * r16
            long r8 = r8 * r16
            long r10 = r14 + r8
        L_0x00d9:
            com.umlaut.crowd.internal.b9 r8 = r1.i     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            java.util.Set r8 = r8.k()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
        L_0x00e3:
            boolean r9 = r8.hasNext()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r9 == 0) goto L_0x01a8
            java.lang.Object r9 = r8.next()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            com.umlaut.crowd.internal.a9 r9 = (com.umlaut.crowd.internal.a9) r9     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            boolean r12 = r9.i()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r12 != 0) goto L_0x00fb
        L_0x00f5:
            r24 = r2
            r26 = r5
            goto L_0x01a1
        L_0x00fb:
            java.lang.Object r12 = r9.a()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            com.umlaut.crowd.internal.xa$a r12 = (com.umlaut.crowd.internal.xa.a) r12     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            V r13 = r12.b     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            com.umlaut.crowd.internal.ea r13 = (com.umlaut.crowd.internal.ea) r13     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            r8.remove()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            boolean r23 = r9.i()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r23 == 0) goto L_0x00f5
            boolean r23 = r9.h()     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            if (r23 == 0) goto L_0x015e
            T r0 = r12.a     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            com.umlaut.crowd.internal.r9 r0 = (com.umlaut.crowd.internal.r9) r0     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            int r0 = r0.b(r4)     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            T r4 = r12.a     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            com.umlaut.crowd.internal.r9 r4 = (com.umlaut.crowd.internal.r9) r4     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            r4.e()     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            r4 = -1
            if (r0 != r4) goto L_0x013a
            r9.b()     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            com.umlaut.crowd.internal.b9 r0 = r1.i     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            java.util.Set r0 = r0.h()     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            int r0 = r0.size()     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            if (r0 != 0) goto L_0x015e
            r4 = 1
            r1.d = r4     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            goto L_0x01cd
        L_0x013a:
            boolean r4 = r1.k     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            if (r4 != 0) goto L_0x015e
            r24 = r2
            long r2 = (long) r0     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            r13.a((long) r14, (long) r2)     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            r26 = r5
            long r4 = r1.o     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            long r4 = r4 + r2
            r1.o = r4     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            long r2 = r1.h     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            r21 = 0
            int r0 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r0 > 0) goto L_0x0162
            long r2 = r1.m     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0162
            r2 = 1
            r1.d = r2     // Catch:{ IOException -> 0x019a, ClosedSelectorException -> 0x01c1 }
            goto L_0x01cd
        L_0x015e:
            r24 = r2
            r26 = r5
        L_0x0162:
            boolean r0 = r9.j()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r0 == 0) goto L_0x01a1
            boolean r0 = r1.k     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r0 == 0) goto L_0x01a1
            r30.b()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            java.nio.ByteBuffer r0 = r1.j     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            boolean r0 = r0.hasRemaining()     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r0 != 0) goto L_0x0186
            r2 = 1
            r9.a((int) r2)     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            int r0 = r20 + 1
            com.umlaut.crowd.internal.xa$a[] r2 = r1.b     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            int r2 = r2.length     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r0 != r2) goto L_0x0183
            goto L_0x01cd
        L_0x0183:
            r20 = r0
            goto L_0x01a1
        L_0x0186:
            T r0 = r12.a     // Catch:{ IOException -> 0x01a1, ClosedSelectorException -> 0x01c1 }
            com.umlaut.crowd.internal.r9 r0 = (com.umlaut.crowd.internal.r9) r0     // Catch:{ IOException -> 0x01a1, ClosedSelectorException -> 0x01c1 }
            java.nio.ByteBuffer r2 = r1.j     // Catch:{ IOException -> 0x01a1, ClosedSelectorException -> 0x01c1 }
            int r0 = r0.write(r2)     // Catch:{ IOException -> 0x01a1, ClosedSelectorException -> 0x01c1 }
            long r2 = (long) r0     // Catch:{ IOException -> 0x01a1, ClosedSelectorException -> 0x01c1 }
            r13.a((long) r14, (long) r2)     // Catch:{ IOException -> 0x01a1, ClosedSelectorException -> 0x01c1 }
            long r4 = r1.n     // Catch:{ IOException -> 0x01a1, ClosedSelectorException -> 0x01c1 }
            long r4 = r4 + r2
            r1.n = r4     // Catch:{ IOException -> 0x01a1, ClosedSelectorException -> 0x01c1 }
            goto L_0x01a1
        L_0x019a:
            r0 = move-exception
            boolean r2 = r1.k     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
            if (r2 == 0) goto L_0x01a0
            goto L_0x01cd
        L_0x01a0:
            throw r0     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
        L_0x01a1:
            r2 = r24
            r5 = r26
            r4 = 1
            goto L_0x00e3
        L_0x01a8:
            r24 = r2
            r26 = r5
            long r2 = r14 - r10
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b7
            r2 = 1
            r1.d = r2     // Catch:{ IOException -> 0x01c8, ClosedSelectorException -> 0x01c1 }
        L_0x01b7:
            r2 = r24
            r5 = r26
            r8 = 0
            r12 = 1
            goto L_0x0071
        L_0x01c1:
            r0 = move-exception
        L_0x01c2:
            boolean r2 = r1.d
            if (r2 == 0) goto L_0x01c7
            goto L_0x01cd
        L_0x01c7:
            throw r0
        L_0x01c8:
            r0 = move-exception
        L_0x01c9:
            boolean r2 = r1.k
            if (r2 == 0) goto L_0x0280
        L_0x01cd:
            com.umlaut.crowd.internal.za r0 = r1.a
            if (r0 == 0) goto L_0x0202
            com.umlaut.crowd.internal.xa$a[] r0 = r1.b
            int r2 = r0.length
            r3 = r7
            r5 = 0
        L_0x01d6:
            if (r5 >= r2) goto L_0x01ef
            r4 = r0[r5]
            V r6 = r4.b
            com.umlaut.crowd.internal.ea r6 = (com.umlaut.crowd.internal.ea) r6
            int r6 = r6.b()
            if (r3 >= r6) goto L_0x01ec
            V r3 = r4.b
            com.umlaut.crowd.internal.ea r3 = (com.umlaut.crowd.internal.ea) r3
            int r3 = r3.b()
        L_0x01ec:
            int r5 = r5 + 1
            goto L_0x01d6
        L_0x01ef:
            r4 = 1
            int r7 = r7 + r4
        L_0x01f1:
            if (r7 > r3) goto L_0x01f9
            r1.a((int) r7)
            int r7 = r7 + 1
            goto L_0x01f1
        L_0x01f9:
            com.umlaut.crowd.internal.za r0 = r1.a
            long r2 = java.lang.System.currentTimeMillis()
            r0.b(r2)
        L_0x0202:
            long r2 = java.lang.System.nanoTime()
            boolean r0 = r1.k
            r4 = -1
            if (r0 != 0) goto L_0x0222
            long r6 = r1.h
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0222
            long r2 = r2 - r10
            r6 = 0
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x021a
            goto L_0x0222
        L_0x021a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Cannot get data from server"
            r0.<init>(r2)
            throw r0
        L_0x0222:
            java.lang.String r2 = " / "
            if (r0 != 0) goto L_0x0251
            long r6 = r1.m
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0251
            long r8 = r1.o
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0233
            goto L_0x0251
        L_0x0233:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Cannot get all data from server: received "
            r3.<init>(r4)
            long r4 = r1.o
            r3.append(r4)
            r3.append(r2)
            long r4 = r1.m
            r3.append(r4)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x0251:
            r3 = 1
            if (r0 != r3) goto L_0x027f
            long r6 = r1.m
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x027f
            long r3 = r1.n
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0261
            goto L_0x027f
        L_0x0261:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Cannot send all data from server: send "
            r3.<init>(r4)
            long r4 = r1.n
            r3.append(r4)
            r3.append(r2)
            long r4 = r1.m
            r3.append(r4)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x027f:
            return
        L_0x0280:
            goto L_0x0282
        L_0x0281:
            throw r0
        L_0x0282:
            goto L_0x0281
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.xa.i():void");
    }

    private void l() throws IOException, TimeoutException {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.l;
        long j3 = j2 <= 0 ? Long.MAX_VALUE : currentTimeMillis + j2;
        while (!this.d) {
            if (this.i.b(j3 - System.currentTimeMillis()) != 0) {
                Iterator<a9> it = this.i.k().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                }
                return;
            } else if (j3 < System.currentTimeMillis()) {
                throw new TimeoutException("Connection timeout");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(com.umlaut.crowd.internal.r9 r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.umlaut.crowd.internal.xa$a[] r0 = r3.b     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0020
            int r1 = r3.f     // Catch:{ all -> 0x0023 }
            int r2 = r0.length     // Catch:{ all -> 0x0023 }
            if (r1 < r2) goto L_0x000b
            goto L_0x0020
        L_0x000b:
            com.umlaut.crowd.internal.xa$a r2 = new com.umlaut.crowd.internal.xa$a     // Catch:{ all -> 0x0023 }
            r2.<init>()     // Catch:{ all -> 0x0023 }
            r0[r1] = r2     // Catch:{ all -> 0x0023 }
            com.umlaut.crowd.internal.xa$a[] r0 = r3.b     // Catch:{ all -> 0x0023 }
            int r1 = r3.f     // Catch:{ all -> 0x0023 }
            r0 = r0[r1]     // Catch:{ all -> 0x0023 }
            r0.a = r4     // Catch:{ all -> 0x0023 }
            r4 = 1
            int r1 = r1 + r4
            r3.f = r1     // Catch:{ all -> 0x0023 }
            monitor-exit(r3)
            return r4
        L_0x0020:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x0023:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.xa.a(com.umlaut.crowd.internal.r9):boolean");
    }

    public void b(long j2) {
        this.m = j2;
    }

    public void c(long j2) {
        this.l = j2;
    }

    public synchronized long d() {
        return this.m;
    }

    public za e() {
        return this.a;
    }

    public long f() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        a();
        super.finalize();
    }

    public boolean h() {
        return this.c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean j() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.umlaut.crowd.internal.xa$a[] r0 = r4.b     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            int r0 = r0.length     // Catch:{ all -> 0x001d }
            if (r0 <= 0) goto L_0x001b
            r0 = 0
        L_0x000a:
            com.umlaut.crowd.internal.xa$a[] r2 = r4.b     // Catch:{ all -> 0x001d }
            int r3 = r2.length     // Catch:{ all -> 0x001d }
            if (r0 >= r3) goto L_0x0018
            r2 = r2[r0]     // Catch:{ all -> 0x001d }
            if (r2 != 0) goto L_0x0015
            monitor-exit(r4)
            return r1
        L_0x0015:
            int r0 = r0 + 1
            goto L_0x000a
        L_0x0018:
            monitor-exit(r4)
            r0 = 1
            return r0
        L_0x001b:
            monitor-exit(r4)
            return r1
        L_0x001d:
            r0 = move-exception
            monitor-exit(r4)
            goto L_0x0021
        L_0x0020:
            throw r0
        L_0x0021:
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.xa.j():boolean");
    }

    public void k() {
        this.d = true;
        try {
            this.i.close();
        } catch (Exception unused) {
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void run() {
        /*
            r6 = this;
            r0 = 1
            r6.c = r0
            r0 = 0
            r1 = 0
            com.umlaut.crowd.internal.b9 r2 = new com.umlaut.crowd.internal.b9     // Catch:{ Exception -> 0x004f }
            r2.<init>()     // Catch:{ Exception -> 0x004f }
            r6.i = r2     // Catch:{ all -> 0x0041 }
            r6.g()     // Catch:{ all -> 0x0041 }
            r6.l()     // Catch:{ all -> 0x0041 }
            r6.i()     // Catch:{ all -> 0x0041 }
            r2.close()     // Catch:{ Exception -> 0x004f }
            com.umlaut.crowd.internal.xa$a[] r2 = r6.b
            if (r2 == 0) goto L_0x007e
            r2 = 0
        L_0x001d:
            com.umlaut.crowd.internal.xa$a[] r3 = r6.b
            int r4 = r3.length
            if (r2 >= r4) goto L_0x007e
            r3 = r3[r2]
            if (r3 == 0) goto L_0x003a
            T r3 = r3.a
            if (r3 == 0) goto L_0x003a
            com.umlaut.crowd.internal.r9 r3 = (com.umlaut.crowd.internal.r9) r3
            r3.f()
            com.umlaut.crowd.internal.xa$a[] r3 = r6.b     // Catch:{ IOException -> 0x003a }
            r3 = r3[r2]     // Catch:{ IOException -> 0x003a }
            T r3 = r3.a     // Catch:{ IOException -> 0x003a }
            com.umlaut.crowd.internal.r9 r3 = (com.umlaut.crowd.internal.r9) r3     // Catch:{ IOException -> 0x003a }
            r3.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            com.umlaut.crowd.internal.xa$a[] r3 = r6.b
            r3[r2] = r0
            int r2 = r2 + 1
            goto L_0x001d
        L_0x0041:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r4 = move-exception
            r2.close()     // Catch:{ all -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r2 = move-exception
            r3.addSuppressed(r2)     // Catch:{ Exception -> 0x004f }
        L_0x004c:
            throw r4     // Catch:{ Exception -> 0x004f }
        L_0x004d:
            r2 = move-exception
            goto L_0x0083
        L_0x004f:
            r2 = move-exception
            com.umlaut.crowd.internal.za r3 = r6.a     // Catch:{ all -> 0x004d }
            r3.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x004d }
            com.umlaut.crowd.internal.xa$a[] r2 = r6.b
            if (r2 == 0) goto L_0x007e
            r2 = 0
        L_0x005a:
            com.umlaut.crowd.internal.xa$a[] r3 = r6.b
            int r4 = r3.length
            if (r2 >= r4) goto L_0x007e
            r3 = r3[r2]
            if (r3 == 0) goto L_0x0077
            T r3 = r3.a
            if (r3 == 0) goto L_0x0077
            com.umlaut.crowd.internal.r9 r3 = (com.umlaut.crowd.internal.r9) r3
            r3.f()
            com.umlaut.crowd.internal.xa$a[] r3 = r6.b     // Catch:{ IOException -> 0x0077 }
            r3 = r3[r2]     // Catch:{ IOException -> 0x0077 }
            T r3 = r3.a     // Catch:{ IOException -> 0x0077 }
            com.umlaut.crowd.internal.r9 r3 = (com.umlaut.crowd.internal.r9) r3     // Catch:{ IOException -> 0x0077 }
            r3.close()     // Catch:{ IOException -> 0x0077 }
        L_0x0077:
            com.umlaut.crowd.internal.xa$a[] r3 = r6.b
            r3[r2] = r0
            int r2 = r2 + 1
            goto L_0x005a
        L_0x007e:
            r6.c = r1
            r6.i = r0
            return
        L_0x0083:
            com.umlaut.crowd.internal.xa$a[] r3 = r6.b
            if (r3 == 0) goto L_0x00ac
            r3 = 0
        L_0x0088:
            com.umlaut.crowd.internal.xa$a[] r4 = r6.b
            int r5 = r4.length
            if (r3 >= r5) goto L_0x00ac
            r4 = r4[r3]
            if (r4 == 0) goto L_0x00a5
            T r4 = r4.a
            if (r4 == 0) goto L_0x00a5
            com.umlaut.crowd.internal.r9 r4 = (com.umlaut.crowd.internal.r9) r4
            r4.f()
            com.umlaut.crowd.internal.xa$a[] r4 = r6.b     // Catch:{ IOException -> 0x00a5 }
            r4 = r4[r3]     // Catch:{ IOException -> 0x00a5 }
            T r4 = r4.a     // Catch:{ IOException -> 0x00a5 }
            com.umlaut.crowd.internal.r9 r4 = (com.umlaut.crowd.internal.r9) r4     // Catch:{ IOException -> 0x00a5 }
            r4.close()     // Catch:{ IOException -> 0x00a5 }
        L_0x00a5:
            com.umlaut.crowd.internal.xa$a[] r4 = r6.b
            r4[r3] = r0
            int r3 = r3 + 1
            goto L_0x0088
        L_0x00ac:
            r6.c = r1
            r6.i = r0
            goto L_0x00b2
        L_0x00b1:
            throw r2
        L_0x00b2:
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.xa.run():void");
    }

    public synchronized void b(int i2) {
        if (!this.c) {
            this.b = new a[i2];
        }
    }

    public synchronized long c() {
        return this.h / 1000000;
    }

    private void b() {
        long j2 = this.m;
        long j3 = j2 == -1 ? Long.MAX_VALUE : j2 - this.n;
        int capacity = j3 > ((long) this.j.capacity()) ? this.j.capacity() : (int) j3;
        if (capacity > 0) {
            this.j.compact();
            if (this.j.position() < capacity) {
                int position = capacity - this.j.position();
                int i2 = this.q;
                if (i2 < position) {
                    if (i2 > 0) {
                        ByteBuffer byteBuffer = this.j;
                        byte[] bArr = this.p;
                        byteBuffer.put(bArr, bArr.length - i2, i2);
                        position -= this.q;
                    }
                    this.e.nextBytes(this.p);
                    byte[] bArr2 = this.p;
                    this.q = bArr2.length - position;
                    this.j.put(bArr2, 0, position);
                } else {
                    ByteBuffer byteBuffer2 = this.j;
                    byte[] bArr3 = this.p;
                    byteBuffer2.put(bArr3, bArr3.length - i2, position);
                    this.q -= position;
                }
            }
            this.j.flip();
        }
    }

    public synchronized void a(long j2) {
        this.h = j2 * 1000000;
    }

    private void a(int i2) {
        long j2 = 0;
        for (a aVar : this.b) {
            j2 += ((ea) aVar.b).b(i2);
        }
        this.a.a(i2, j2);
    }

    public void a(za zaVar) {
        if (!this.c) {
            this.a = zaVar;
            this.g = zaVar.a() * 1000000;
        }
    }

    public void a() {
        this.d = true;
        b9 b9Var = this.i;
        if (b9Var != null) {
            b9Var.g().wakeup();
        }
        try {
            join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.b;
            if (i2 < aVarArr.length) {
                a aVar = aVarArr[i2];
                if (aVar != null && ((r9) aVar.a).isOpen()) {
                    try {
                        ((r9) this.b[i2].a).close();
                        this.b[i2] = null;
                    } catch (IOException e3) {
                        this.a.a((Throwable) e3);
                    }
                }
                i2++;
            } else {
                return;
            }
        }
    }
}
