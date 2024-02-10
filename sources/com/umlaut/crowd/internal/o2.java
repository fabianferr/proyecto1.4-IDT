package com.umlaut.crowd.internal;

import java.nio.ByteBuffer;
import java.util.Random;

public class o2 {
    private Random a;
    private q2 b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private long h;
    private long i;
    private int j;
    private long k;
    private long l;

    class a implements q2 {
        a() {
        }

        public void a(int i, long j) {
        }

        public void a(long j) {
        }

        public void a(Throwable th) {
        }

        public void b(long j) {
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.umlaut.crowd.internal.ja[] r0 = com.umlaut.crowd.internal.ja.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.ja r1 = com.umlaut.crowd.internal.ja.TEST_FTPDOWNFILESIZE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.ja r1 = com.umlaut.crowd.internal.ja.TEST_FTPDOWNPERIOD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.ja r1 = com.umlaut.crowd.internal.ja.TEST_FTPUPFILESIZE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.ja r1 = com.umlaut.crowd.internal.ja.TEST_FTPUPPERIOD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.o2.b.<clinit>():void");
        }
    }

    public o2(na naVar) {
        this(naVar, false);
    }

    public void a(q2 q2Var) {
        if (q2Var != null) {
            this.b = q2Var;
        }
    }

    public int b() {
        return this.j;
    }

    public synchronized boolean c() {
        return this.d;
    }

    public o2(na naVar, boolean z) {
        this.a = new Random();
        this.b = new a();
        this.c = false;
        this.f = -1;
        this.g = -1;
        this.k = Long.MAX_VALUE;
        this.l = Long.MAX_VALUE;
        this.i = ((long) naVar.reportingInterval) * 1000000;
        int i2 = b.a[naVar.a().ordinal()];
        if (i2 == 1) {
            this.d = false;
            this.j = 1;
            this.l = ((la) naVar).fileSize;
            this.g = Integer.MAX_VALUE;
        } else if (i2 == 2) {
            this.d = false;
            this.j = 2;
            long j2 = ((ma) naVar).duration * 1000000;
            this.k = j2;
            this.g = ((int) (j2 / this.i)) - 1;
        } else if (i2 == 3) {
            this.d = true;
            this.j = 1;
            this.l = ((oa) naVar).fileSize;
            this.g = Integer.MAX_VALUE;
        } else if (i2 == 4) {
            this.d = true;
            this.j = 2;
            long j3 = ((pa) naVar).duration * 1000000;
            this.k = j3;
            this.g = ((int) (j3 / this.i)) - 1;
        } else {
            throw new IllegalArgumentException("Unknown testType: " + naVar);
        }
        if (z) {
            this.d = !this.d;
            this.k *= 2;
            this.e = true;
        }
    }

    private void a(ByteBuffer byteBuffer, long j2) {
        if (byteBuffer.position() != 0) {
            byteBuffer.compact();
            byte[] bArr = new byte[(j2 > ((long) byteBuffer.remaining()) ? byteBuffer.remaining() : (int) j2)];
            this.a.nextBytes(bArr);
            byteBuffer.put(bArr);
            byteBuffer.flip();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0188, code lost:
        if (r1.e != false) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x018a, code lost:
        r1.b.a((java.lang.Throwable) new java.io.IOException("Stream ended unexpectly"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0197, code lost:
        r2.a(true);
        r1.b.b(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a4, code lost:
        return;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:122:0x0202=Splitter:B:122:0x0202, B:95:0x0194=Splitter:B:95:0x0194} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.umlaut.crowd.internal.r9 r26) throws java.io.IOException {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            long r3 = r1.i
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r7 = 0
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0017
            com.umlaut.crowd.internal.r2 r0 = new com.umlaut.crowd.internal.r2
            r0.<init>(r3)
            goto L_0x001c
        L_0x0017:
            com.umlaut.crowd.internal.r2 r0 = new com.umlaut.crowd.internal.r2
            r0.<init>(r5)
        L_0x001c:
            long r3 = java.lang.System.nanoTime()
            boolean r9 = r1.d
            if (r9 == 0) goto L_0x0027
            long r9 = r1.l
            goto L_0x0028
        L_0x0027:
            r9 = r7
        L_0x0028:
            long r11 = r1.i
            long r11 = r11 + r3
            r1.h = r11
            java.nio.channels.SocketChannel r11 = r26.c()
            r12 = 0
            r11.configureBlocking(r12)
            r11 = 1
            com.umlaut.crowd.internal.b9 r13 = new com.umlaut.crowd.internal.b9     // Catch:{ IOException -> 0x0224 }
            r13.<init>()     // Catch:{ IOException -> 0x0224 }
            java.nio.ByteBuffer r14 = r26.b()     // Catch:{ all -> 0x0213 }
            int r14 = r14.capacity()     // Catch:{ all -> 0x0213 }
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocate(r14)     // Catch:{ all -> 0x0213 }
            boolean r15 = r1.d     // Catch:{ all -> 0x0213 }
            r16 = 1000000(0xf4240, double:4.940656E-318)
            r18 = 1
            if (r15 == 0) goto L_0x0056
            r15 = 5
            r2.a(r13, r15)     // Catch:{ all -> 0x0213 }
            r15 = 0
            goto L_0x0094
        L_0x0056:
            r2.a(r13, r11)     // Catch:{ all -> 0x0213 }
            r15 = 0
        L_0x005a:
            boolean r12 = r1.c     // Catch:{ all -> 0x0213 }
            if (r12 != 0) goto L_0x0094
            long r5 = r1.h     // Catch:{ all -> 0x0213 }
            long r5 = r5 - r3
            long r5 = r5 / r16
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 > 0) goto L_0x0069
            r5 = r18
        L_0x0069:
            int r15 = r13.b((long) r5)     // Catch:{ all -> 0x0213 }
            if (r15 != 0) goto L_0x0075
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L_0x005a
        L_0x0075:
            java.util.Set r5 = r13.k()     // Catch:{ all -> 0x0213 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0213 }
        L_0x007d:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0213 }
            if (r6 == 0) goto L_0x0094
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0213 }
            com.umlaut.crowd.internal.a9 r6 = (com.umlaut.crowd.internal.a9) r6     // Catch:{ all -> 0x0213 }
            boolean r6 = r6.i()     // Catch:{ all -> 0x0213 }
            if (r6 != 0) goto L_0x0090
            goto L_0x007d
        L_0x0090:
            r5.remove()     // Catch:{ all -> 0x0213 }
            goto L_0x007d
        L_0x0094:
            long r5 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0213 }
            int r12 = r1.j     // Catch:{ all -> 0x0213 }
            if (r12 != r11) goto L_0x00a6
            r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r20 = r5 + r20
            r11 = r20
            goto L_0x00a9
        L_0x00a6:
            long r11 = r1.k     // Catch:{ all -> 0x0213 }
            long r11 = r11 + r5
        L_0x00a9:
            r0.b(r5)     // Catch:{ all -> 0x0213 }
            com.umlaut.crowd.internal.q2 r5 = r1.b     // Catch:{ all -> 0x0213 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0213 }
            r5.a((long) r7)     // Catch:{ all -> 0x0213 }
        L_0x00b5:
            boolean r5 = r1.c     // Catch:{ all -> 0x0213 }
            if (r5 != 0) goto L_0x0202
            long r5 = r1.h     // Catch:{ all -> 0x0213 }
            long r5 = r5 - r3
            long r5 = r5 / r16
            r3 = 0
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x00c6
            r5 = r18
        L_0x00c6:
            if (r15 != 0) goto L_0x00cc
            int r15 = r13.b((long) r5)     // Catch:{ all -> 0x0213 }
        L_0x00cc:
            long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0213 }
            r0.c(r3)     // Catch:{ all -> 0x0213 }
            if (r15 == 0) goto L_0x01b3
            java.util.Set r6 = r13.k()     // Catch:{ all -> 0x0213 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0213 }
            r7 = 0
        L_0x00de:
            boolean r8 = r6.hasNext()     // Catch:{ all -> 0x0213 }
            if (r8 == 0) goto L_0x01b1
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0213 }
            com.umlaut.crowd.internal.a9 r8 = (com.umlaut.crowd.internal.a9) r8     // Catch:{ all -> 0x0213 }
            boolean r15 = r8.i()     // Catch:{ all -> 0x0213 }
            if (r15 != 0) goto L_0x00f4
            r6.remove()     // Catch:{ all -> 0x0213 }
            goto L_0x00de
        L_0x00f4:
            boolean r7 = r8.j()     // Catch:{ all -> 0x0213 }
            r15 = -1
            if (r7 == 0) goto L_0x0136
            boolean r7 = r1.d     // Catch:{ all -> 0x0213 }
            if (r7 == 0) goto L_0x0136
            r21 = 0
            int r7 = (r9 > r21 ? 1 : (r9 == r21 ? 0 : -1))
            if (r7 <= 0) goto L_0x0136
            r1.a(r14, r9)     // Catch:{ all -> 0x0213 }
            int r7 = r2.write(r14)     // Catch:{ all -> 0x0213 }
            if (r7 != r15) goto L_0x0131
            r8.b()     // Catch:{ all -> 0x0213 }
            com.umlaut.crowd.internal.q2 r0 = r1.b     // Catch:{ all -> 0x0213 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0213 }
            java.lang.String r4 = "Upload Stream ended unexpectly"
            r3.<init>(r4)     // Catch:{ all -> 0x0213 }
            r0.a((java.lang.Throwable) r3)     // Catch:{ all -> 0x0213 }
            java.lang.System.nanoTime()     // Catch:{ all -> 0x0213 }
            r13.close()     // Catch:{ IOException -> 0x0224 }
            r3 = 1
            r2.a(r3)
            com.umlaut.crowd.internal.q2 r0 = r1.b
            long r2 = java.lang.System.currentTimeMillis()
            r0.b(r2)
            return
        L_0x0131:
            r24 = r6
            long r5 = (long) r7
            long r9 = r9 - r5
            goto L_0x0139
        L_0x0136:
            r24 = r6
            r7 = 0
        L_0x0139:
            boolean r5 = r8.h()     // Catch:{ all -> 0x0213 }
            java.lang.String r6 = "Stream ended unexpectly"
            if (r5 == 0) goto L_0x0183
            r14.clear()     // Catch:{ IOException -> 0x0176 }
            r5 = 1
            int r15 = r2.b(r5)     // Catch:{ IOException -> 0x0176 }
            r26.e()     // Catch:{ IOException -> 0x0176 }
            r5 = -1
            if (r15 != r5) goto L_0x0170
            r8.b()     // Catch:{ IOException -> 0x0176 }
            com.umlaut.crowd.internal.q2 r0 = r1.b     // Catch:{ IOException -> 0x0176 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0176 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0176 }
            r0.a((java.lang.Throwable) r3)     // Catch:{ IOException -> 0x0176 }
            java.lang.System.nanoTime()     // Catch:{ IOException -> 0x0176 }
            r13.close()     // Catch:{ IOException -> 0x0224 }
            r3 = 1
            r2.a(r3)
            com.umlaut.crowd.internal.q2 r0 = r1.b
            long r2 = java.lang.System.currentTimeMillis()
            r0.b(r2)
            return
        L_0x0170:
            boolean r5 = r1.d     // Catch:{ IOException -> 0x0176 }
            if (r5 != 0) goto L_0x0183
            r7 = r15
            goto L_0x0183
        L_0x0176:
            r0 = move-exception
            boolean r3 = r1.d     // Catch:{ all -> 0x0213 }
            if (r3 == 0) goto L_0x0182
            int r3 = r1.j     // Catch:{ all -> 0x0213 }
            r4 = 2
            if (r3 != r4) goto L_0x0182
            goto L_0x0202
        L_0x0182:
            throw r0     // Catch:{ all -> 0x0213 }
        L_0x0183:
            r5 = -1
            if (r7 != r5) goto L_0x01a5
            boolean r0 = r1.e     // Catch:{ all -> 0x0213 }
            if (r0 != 0) goto L_0x0194
            com.umlaut.crowd.internal.q2 r0 = r1.b     // Catch:{ all -> 0x0213 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0213 }
            r3.<init>(r6)     // Catch:{ all -> 0x0213 }
            r0.a((java.lang.Throwable) r3)     // Catch:{ all -> 0x0213 }
        L_0x0194:
            r13.close()     // Catch:{ IOException -> 0x0224 }
            r3 = 1
            r2.a(r3)
            com.umlaut.crowd.internal.q2 r0 = r1.b
            long r2 = java.lang.System.currentTimeMillis()
            r0.b(r2)
            return
        L_0x01a5:
            long r5 = (long) r7
            r0.a((long) r5)     // Catch:{ all -> 0x0213 }
            r24.remove()     // Catch:{ all -> 0x0213 }
            r6 = r24
            r7 = 1
            goto L_0x00de
        L_0x01b1:
            r15 = 0
            goto L_0x01b4
        L_0x01b3:
            r7 = 0
        L_0x01b4:
            long r5 = r1.h     // Catch:{ all -> 0x0213 }
            long r5 = r3 - r5
            r21 = 0
            int r8 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
            if (r8 < 0) goto L_0x01c1
            r1.a((com.umlaut.crowd.internal.r2) r0)     // Catch:{ all -> 0x0213 }
        L_0x01c1:
            int r5 = r1.j     // Catch:{ all -> 0x0213 }
            r6 = 1
            if (r5 != r6) goto L_0x01e1
            long r5 = r0.a()     // Catch:{ all -> 0x0213 }
            long r7 = r1.l     // Catch:{ all -> 0x0213 }
            int r23 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r23 < 0) goto L_0x01fe
            r1.a((com.umlaut.crowd.internal.r2) r0)     // Catch:{ all -> 0x0213 }
            com.umlaut.crowd.internal.q2 r3 = r1.b     // Catch:{ all -> 0x0213 }
            int r4 = r1.f     // Catch:{ all -> 0x0213 }
            r5 = 1
            int r4 = r4 + r5
            long r5 = r0.b()     // Catch:{ all -> 0x0213 }
            r3.a(r4, r5)     // Catch:{ all -> 0x0213 }
            goto L_0x0202
        L_0x01e1:
            r6 = 2
            if (r5 != r6) goto L_0x01fe
            long r5 = r1.i     // Catch:{ all -> 0x0213 }
            long r5 = r5 + r11
            long r5 = r5 + r18
            long r5 = r3 - r5
            r21 = 0
            int r8 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
            if (r8 >= 0) goto L_0x01fa
            r5 = 1
            if (r7 != r5) goto L_0x00b5
            long r5 = r3 - r11
            int r7 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
            if (r7 <= 0) goto L_0x00b5
        L_0x01fa:
            r1.a((com.umlaut.crowd.internal.r2) r0)     // Catch:{ all -> 0x0213 }
            goto L_0x0202
        L_0x01fe:
            r21 = 0
            goto L_0x00b5
        L_0x0202:
            r13.close()     // Catch:{ IOException -> 0x0224 }
            r3 = 1
            r2.a(r3)
            com.umlaut.crowd.internal.q2 r0 = r1.b
            long r2 = java.lang.System.currentTimeMillis()
            r0.b(r2)
            goto L_0x0236
        L_0x0213:
            r0 = move-exception
            r3 = r0
            throw r3     // Catch:{ all -> 0x0216 }
        L_0x0216:
            r0 = move-exception
            r4 = r0
            r13.close()     // Catch:{ all -> 0x021c }
            goto L_0x0221
        L_0x021c:
            r0 = move-exception
            r5 = r0
            r3.addSuppressed(r5)     // Catch:{ IOException -> 0x0224 }
        L_0x0221:
            throw r4     // Catch:{ IOException -> 0x0224 }
        L_0x0222:
            r0 = move-exception
            goto L_0x023d
        L_0x0224:
            r0 = move-exception
            boolean r3 = r1.e     // Catch:{ all -> 0x0222 }
            if (r3 == 0) goto L_0x0237
            r3 = 1
            r2.a(r3)
            com.umlaut.crowd.internal.q2 r0 = r1.b
            long r2 = java.lang.System.currentTimeMillis()
            r0.b(r2)
        L_0x0236:
            return
        L_0x0237:
            com.umlaut.crowd.internal.q2 r3 = r1.b     // Catch:{ all -> 0x0222 }
            r3.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0222 }
            throw r0     // Catch:{ all -> 0x0222 }
        L_0x023d:
            r3 = 1
            r2.a(r3)
            com.umlaut.crowd.internal.q2 r2 = r1.b
            long r3 = java.lang.System.currentTimeMillis()
            r2.b(r3)
            goto L_0x024c
        L_0x024b:
            throw r0
        L_0x024c:
            goto L_0x024b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.o2.a(com.umlaut.crowd.internal.r9):void");
    }

    private void a(r2 r2Var) {
        int c2 = r2Var.c();
        int i2 = this.g;
        if (c2 > i2) {
            c2 = i2;
        }
        int i3 = this.f;
        while (true) {
            i3++;
            if (i3 <= c2) {
                this.b.a(i3, r2Var.a(i3));
            } else {
                this.f = c2;
                this.h += this.i;
                return;
            }
        }
    }

    public void a() {
        this.c = true;
    }
}
