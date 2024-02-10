package com.bytedance.sdk.component.f.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.b;
import com.bytedance.sdk.component.b.a.c;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.b.a.l;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: DownloadExecutor */
public class a extends c {
    public File a;
    public File b;

    public a(j jVar) {
        super(jVar);
    }

    public void a(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.a = new File(str, str2);
        this.b = new File(str, str2 + ".temp");
    }

    public void a(final com.bytedance.sdk.component.f.a.a aVar) {
        File file = this.a;
        if (file != null && this.b != null) {
            final long j = 0;
            if (!file.exists() || this.a.length() == 0 || aVar == null) {
                long length = this.b.length();
                if (length >= 0) {
                    j = length;
                }
                l.a aVar2 = new l.a();
                aVar2.a((Object) b());
                b("Range", "bytes=" + j + "-");
                if (TextUtils.isEmpty(this.f)) {
                    aVar.a((c) this, new IOException("Url is Empty"));
                    return;
                }
                try {
                    aVar2.a(this.f);
                    a(aVar2);
                    this.c.a(aVar2.a().b()).a(new c() {
                        public void a(b bVar, IOException iOException) {
                            com.bytedance.sdk.component.f.a.a aVar = aVar;
                            if (aVar != null) {
                                aVar.a((c) a.this, iOException);
                            }
                            a.this.c();
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:106:0x0281 A[Catch:{ all -> 0x0297, all -> 0x029e, all -> 0x02a5 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:108:0x0288 A[SYNTHETIC, Splitter:B:108:0x0288] */
                        /* JADX WARNING: Removed duplicated region for block: B:129:0x01b7 A[EDGE_INSN: B:129:0x01b7->B:68:0x01b7 ?: BREAK  , SYNTHETIC] */
                        /* JADX WARNING: Removed duplicated region for block: B:55:0x016c A[Catch:{ all -> 0x025f }] */
                        /* JADX WARNING: Removed duplicated region for block: B:70:0x01be A[Catch:{ all -> 0x01c9 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:73:0x01cc A[Catch:{ all -> 0x01c9 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:80:0x01ea A[Catch:{ all -> 0x01c9 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:84:0x0222 A[Catch:{ all -> 0x01c9 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:90:0x0250 A[SYNTHETIC, Splitter:B:90:0x0250] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void a(com.bytedance.sdk.component.b.a.b r29, com.bytedance.sdk.component.b.a.n r30) throws java.io.IOException {
                            /*
                                r28 = this;
                                r1 = r28
                                java.lang.String r2 = "Error occured when calling tmpFile.close"
                                java.lang.String r3 = "Error occured when calling InputStream.close"
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                if (r0 == 0) goto L_0x02b1
                                java.util.HashMap r0 = new java.util.HashMap
                                r0.<init>()
                                if (r30 == 0) goto L_0x02b1
                                com.bytedance.sdk.component.b.a.f r4 = r30.g()
                                if (r4 == 0) goto L_0x002c
                                r5 = 0
                            L_0x0018:
                                int r6 = r4.a()
                                if (r5 >= r6) goto L_0x002c
                                java.lang.String r6 = r4.a(r5)
                                java.lang.String r7 = r4.b(r5)
                                r0.put(r6, r7)
                                int r5 = r5 + 1
                                goto L_0x0018
                            L_0x002c:
                                com.bytedance.sdk.component.f.b r15 = new com.bytedance.sdk.component.f.b
                                boolean r5 = r30.d()
                                int r6 = r30.c()
                                java.lang.String r7 = r30.e()
                                r9 = 0
                                long r10 = r30.b()
                                long r12 = r30.a()
                                r4 = r15
                                r8 = r0
                                r4.<init>(r5, r6, r7, r8, r9, r10, r12)
                                boolean r4 = r30.d()
                                if (r4 == 0) goto L_0x02a9
                                com.bytedance.sdk.component.b.a.o r4 = r30.f()
                                long r4 = r4.a()
                                r6 = 0
                                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                                if (r8 > 0) goto L_0x0060
                                long r4 = com.bytedance.sdk.component.f.b.a.f(r0)
                            L_0x0060:
                                boolean r8 = com.bytedance.sdk.component.f.b.a.e(r0)
                                r9 = -1
                                if (r8 == 0) goto L_0x00d3
                                long r10 = r1
                                long r4 = r4 + r10
                                java.lang.String r10 = "Content-Range"
                                java.lang.Object r10 = r0.get(r10)
                                java.lang.String r10 = (java.lang.String) r10
                                boolean r11 = android.text.TextUtils.isEmpty(r10)
                                if (r11 != 0) goto L_0x00d3
                                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                                java.lang.String r12 = "bytes "
                                r11.<init>(r12)
                                long r12 = r1
                                r11.append(r12)
                                java.lang.String r12 = "-"
                                r11.append(r12)
                                r12 = 1
                                long r12 = r4 - r12
                                r11.append(r12)
                                java.lang.String r11 = r11.toString()
                                int r12 = android.text.TextUtils.indexOf(r10, r11)
                                if (r12 != r9) goto L_0x00d3
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this
                                r0.c()
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this
                                java.io.IOException r3 = new java.io.IOException
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                java.lang.String r5 = "The Content-Range Header is invalid Assume["
                                r4.<init>(r5)
                                r4.append(r11)
                                java.lang.String r5 = "] vs Real["
                                r4.append(r5)
                                r4.append(r10)
                                java.lang.String r5 = "], please remove the temporary file ["
                                r4.append(r5)
                                com.bytedance.sdk.component.f.b.a r5 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r5 = r5.b
                                r4.append(r5)
                                java.lang.String r5 = "]."
                                r4.append(r5)
                                java.lang.String r4 = r4.toString()
                                r3.<init>(r4)
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (java.io.IOException) r3)
                                return
                            L_0x00d3:
                                r10 = r4
                                java.lang.String r4 = "Rename fail"
                                int r5 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                                if (r5 <= 0) goto L_0x0124
                                com.bytedance.sdk.component.f.b.a r5 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r5 = r5.b
                                boolean r5 = r5.exists()
                                if (r5 == 0) goto L_0x0124
                                com.bytedance.sdk.component.f.b.a r5 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r5 = r5.b
                                long r12 = r5.length()
                                int r5 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                                if (r5 != 0) goto L_0x0124
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r0 = r0.b
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r2 = r2.a
                                boolean r0 = r0.renameTo(r2)
                                if (r0 == 0) goto L_0x0117
                                com.bytedance.sdk.component.f.b.a r5 = com.bytedance.sdk.component.f.b.a.this
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                r6 = r10
                                r8 = r10
                                r10 = r0
                                r5.a(r6, r8, r10)
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r0 = r0.a
                                r15.a(r0)
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (com.bytedance.sdk.component.f.b) r15)
                                goto L_0x0123
                            L_0x0117:
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this
                                java.io.IOException r3 = new java.io.IOException
                                r3.<init>(r4)
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (java.io.IOException) r3)
                            L_0x0123:
                                return
                            L_0x0124:
                                java.io.RandomAccessFile r12 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0140 }
                                com.bytedance.sdk.component.f.b.a r13 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x0140 }
                                java.io.File r13 = r13.b     // Catch:{ all -> 0x0140 }
                                java.lang.String r5 = "rw"
                                r12.<init>(r13, r5)     // Catch:{ all -> 0x0140 }
                                if (r8 == 0) goto L_0x013a
                                r13 = r15
                                long r14 = r1     // Catch:{ all -> 0x013e }
                                r12.seek(r14)     // Catch:{ all -> 0x013e }
                                long r14 = r1     // Catch:{ all -> 0x013e }
                                goto L_0x0143
                            L_0x013a:
                                r13 = r15
                                r12.setLength(r6)     // Catch:{ all -> 0x013e }
                            L_0x013e:
                                r14 = r6
                                goto L_0x0143
                            L_0x0140:
                                r13 = r15
                                r12 = 0
                                goto L_0x013e
                            L_0x0143:
                                com.bytedance.sdk.component.b.a.o r16 = r30.f()     // Catch:{ all -> 0x0263 }
                                java.io.InputStream r5 = r16.c()     // Catch:{ all -> 0x0263 }
                                boolean r0 = com.bytedance.sdk.component.f.b.a.g(r0)     // Catch:{ all -> 0x025f }
                                if (r0 == 0) goto L_0x015b
                                boolean r0 = r5 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x025f }
                                if (r0 != 0) goto L_0x015b
                                java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x025f }
                                r0.<init>(r5)     // Catch:{ all -> 0x025f }
                                r5 = r0
                            L_0x015b:
                                r0 = 16384(0x4000, float:2.2959E-41)
                                byte[] r0 = new byte[r0]     // Catch:{ all -> 0x025f }
                                r18 = r6
                                r6 = 0
                            L_0x0162:
                                int r7 = 16384 - r6
                                int r7 = r5.read(r0, r6, r7)     // Catch:{ all -> 0x025f }
                                r16 = 1
                                if (r7 == r9) goto L_0x01b7
                                int r6 = r6 + r7
                                r23 = r10
                                long r9 = (long) r7     // Catch:{ all -> 0x025f }
                                long r9 = r18 + r9
                                r18 = 16384(0x4000, double:8.0948E-320)
                                long r18 = r9 % r18
                                r20 = 0
                                int r7 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
                                if (r7 == 0) goto L_0x018a
                                r7 = r2
                                r11 = r3
                                long r2 = r1     // Catch:{ all -> 0x01c9 }
                                long r2 = r23 - r2
                                int r18 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                                if (r18 != 0) goto L_0x0187
                                goto L_0x018c
                            L_0x0187:
                                r16 = 0
                                goto L_0x018c
                            L_0x018a:
                                r7 = r2
                                r11 = r3
                            L_0x018c:
                                if (r16 == 0) goto L_0x0198
                                r12.seek(r14)     // Catch:{ all -> 0x01c9 }
                                r2 = 0
                                r12.write(r0, r2, r6)     // Catch:{ all -> 0x01c9 }
                                long r2 = (long) r6     // Catch:{ all -> 0x01c9 }
                                long r14 = r14 + r2
                                r6 = 0
                            L_0x0198:
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                r3 = r13
                                r25 = r14
                                long r13 = r1     // Catch:{ all -> 0x01c9 }
                                long r17 = r13 + r9
                                com.bytedance.sdk.component.f.a.a r13 = r14     // Catch:{ all -> 0x01c9 }
                                r16 = r2
                                r19 = r23
                                r21 = r13
                                r16.a(r17, r19, r21)     // Catch:{ all -> 0x01c9 }
                                r13 = r3
                                r2 = r7
                                r18 = r9
                                r3 = r11
                                r10 = r23
                                r14 = r25
                                r9 = -1
                                goto L_0x0162
                            L_0x01b7:
                                r7 = r2
                                r23 = r10
                                r11 = r3
                                r3 = r13
                                if (r8 != 0) goto L_0x01cc
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.File r0 = r0.b     // Catch:{ all -> 0x01c9 }
                                long r9 = r0.length()     // Catch:{ all -> 0x01c9 }
                                r25 = r9
                                goto L_0x01ce
                            L_0x01c9:
                                r0 = move-exception
                                goto L_0x0267
                            L_0x01cc:
                                r25 = r23
                            L_0x01ce:
                                r9 = 0
                                int r0 = (r25 > r9 ? 1 : (r25 == r9 ? 0 : -1))
                                if (r0 <= 0) goto L_0x0222
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.File r0 = r0.b     // Catch:{ all -> 0x01c9 }
                                boolean r0 = r0.exists()     // Catch:{ all -> 0x01c9 }
                                if (r0 == 0) goto L_0x0222
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.File r0 = r0.b     // Catch:{ all -> 0x01c9 }
                                long r9 = r0.length()     // Catch:{ all -> 0x01c9 }
                                int r0 = (r9 > r25 ? 1 : (r9 == r25 ? 0 : -1))
                                if (r0 != 0) goto L_0x0222
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.File r0 = r0.b     // Catch:{ all -> 0x01c9 }
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.File r2 = r2.a     // Catch:{ all -> 0x01c9 }
                                boolean r0 = r0.renameTo(r2)     // Catch:{ all -> 0x01c9 }
                                if (r0 == 0) goto L_0x0215
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                com.bytedance.sdk.component.f.a.a r2 = r14     // Catch:{ all -> 0x01c9 }
                                r22 = r0
                                r23 = r25
                                r27 = r2
                                r22.a(r23, r25, r27)     // Catch:{ all -> 0x01c9 }
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.File r0 = r0.a     // Catch:{ all -> 0x01c9 }
                                r2 = r3
                                r2.a(r0)     // Catch:{ all -> 0x01c9 }
                                com.bytedance.sdk.component.f.a.a r0 = r14     // Catch:{ all -> 0x01c9 }
                                com.bytedance.sdk.component.f.b.a r3 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                r0.a((com.bytedance.sdk.component.f.b.c) r3, (com.bytedance.sdk.component.f.b) r2)     // Catch:{ all -> 0x01c9 }
                                goto L_0x024e
                            L_0x0215:
                                com.bytedance.sdk.component.f.a.a r0 = r14     // Catch:{ all -> 0x01c9 }
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x01c9 }
                                r3.<init>(r4)     // Catch:{ all -> 0x01c9 }
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (java.io.IOException) r3)     // Catch:{ all -> 0x01c9 }
                                goto L_0x024e
                            L_0x0222:
                                com.bytedance.sdk.component.f.a.a r0 = r14     // Catch:{ all -> 0x01c9 }
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x01c9 }
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c9 }
                                r4.<init>()     // Catch:{ all -> 0x01c9 }
                                java.lang.String r6 = " tempFile.length() == fileSize is"
                                r4.append(r6)     // Catch:{ all -> 0x01c9 }
                                com.bytedance.sdk.component.f.b.a r6 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01c9 }
                                java.io.File r6 = r6.b     // Catch:{ all -> 0x01c9 }
                                long r9 = r6.length()     // Catch:{ all -> 0x01c9 }
                                int r6 = (r9 > r25 ? 1 : (r9 == r25 ? 0 : -1))
                                if (r6 != 0) goto L_0x0240
                                r14 = 1
                                goto L_0x0241
                            L_0x0240:
                                r14 = 0
                            L_0x0241:
                                r4.append(r14)     // Catch:{ all -> 0x01c9 }
                                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01c9 }
                                r3.<init>(r4)     // Catch:{ all -> 0x01c9 }
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (java.io.IOException) r3)     // Catch:{ all -> 0x01c9 }
                            L_0x024e:
                                if (r5 == 0) goto L_0x0257
                                r5.close()     // Catch:{ all -> 0x0254 }
                                goto L_0x0257
                            L_0x0254:
                                com.bytedance.sdk.component.f.d.d.a(r11)
                            L_0x0257:
                                r12.close()     // Catch:{ all -> 0x025b }
                                goto L_0x02b1
                            L_0x025b:
                                com.bytedance.sdk.component.f.d.d.a(r7)
                                goto L_0x02b1
                            L_0x025f:
                                r0 = move-exception
                                r7 = r2
                                r11 = r3
                                goto L_0x0267
                            L_0x0263:
                                r0 = move-exception
                                r7 = r2
                                r11 = r3
                                r5 = 0
                            L_0x0267:
                                java.lang.String r2 = "Error occured when FileRequest.parseHttpResponse"
                                com.bytedance.sdk.component.f.d.d.a(r2)     // Catch:{ all -> 0x0297 }
                                r0.printStackTrace()     // Catch:{ all -> 0x0297 }
                                com.bytedance.sdk.component.f.a.a r2 = r14     // Catch:{ all -> 0x0297 }
                                com.bytedance.sdk.component.f.b.a r3 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x0297 }
                                java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0297 }
                                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0297 }
                                r4.<init>(r0)     // Catch:{ all -> 0x0297 }
                                r2.a((com.bytedance.sdk.component.f.b.c) r3, (java.io.IOException) r4)     // Catch:{ all -> 0x0297 }
                                if (r8 != 0) goto L_0x0286
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x0297 }
                                r0.c()     // Catch:{ all -> 0x0297 }
                            L_0x0286:
                                if (r5 == 0) goto L_0x028f
                                r5.close()     // Catch:{ all -> 0x028c }
                                goto L_0x028f
                            L_0x028c:
                                com.bytedance.sdk.component.f.d.d.a(r11)
                            L_0x028f:
                                r12.close()     // Catch:{ all -> 0x0293 }
                                goto L_0x0296
                            L_0x0293:
                                com.bytedance.sdk.component.f.d.d.a(r7)
                            L_0x0296:
                                return
                            L_0x0297:
                                r0 = move-exception
                                if (r5 == 0) goto L_0x02a1
                                r5.close()     // Catch:{ all -> 0x029e }
                                goto L_0x02a1
                            L_0x029e:
                                com.bytedance.sdk.component.f.d.d.a(r11)
                            L_0x02a1:
                                r12.close()     // Catch:{ all -> 0x02a5 }
                                goto L_0x02a8
                            L_0x02a5:
                                com.bytedance.sdk.component.f.d.d.a(r7)
                            L_0x02a8:
                                throw r0
                            L_0x02a9:
                                r2 = r15
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                com.bytedance.sdk.component.f.b.a r3 = com.bytedance.sdk.component.f.b.a.this
                                r0.a((com.bytedance.sdk.component.f.b.c) r3, (com.bytedance.sdk.component.f.b) r2)
                            L_0x02b1:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.b.a.AnonymousClass1.a(com.bytedance.sdk.component.b.a.b, com.bytedance.sdk.component.b.a.n):void");
                        }
                    });
                } catch (IllegalArgumentException unused) {
                    aVar.a((c) this, new IOException("Url is not a valid HTTP or HTTPS URL"));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.component.f.b bVar = new com.bytedance.sdk.component.f.b(true, 200, "Success", (Map<String, String>) null, (String) null, currentTimeMillis, currentTimeMillis);
                bVar.a(this.a);
                aVar.a((c) this, bVar);
            }
        } else if (aVar != null) {
            aVar.a((c) this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:124|125|(1:127)(1:128)|129|(4:131|132|133|134)|135|136|137|138|181) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:139|142|143|144|(1:146)|(4:148|149|150|151)|152|153|154|155|183) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:106|107|108|109) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:116|117|118|119) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:131|132|133|134) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:148|149|150|151) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:(4:116|117|118|119)|120|121|122|123|179) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:104|(4:106|107|108|109)|110|111|112|113|114) */
    /* JADX WARNING: Code restructure failed: missing block: B:178:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:?, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:108:0x024e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:112:0x0255 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x025f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x0267 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x0295 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:137:0x029d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:150:0x02b9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:154:0x02c1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:160:0x02cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:164:0x02d4 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0239 A[Catch:{ all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026c A[SYNTHETIC, Splitter:B:124:0x026c] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02b0 A[Catch:{ all -> 0x02c6, all -> 0x02cd, all -> 0x02d4, IOException -> 0x02d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02b5 A[SYNTHETIC, Splitter:B:148:0x02b5] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0206 A[EDGE_INSN: B:175:0x0206->B:86:0x0206 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01da A[Catch:{ all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x020b A[Catch:{ all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0215 A[Catch:{ all -> 0x02a2 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:154:0x02c1=Splitter:B:154:0x02c1, B:164:0x02d4=Splitter:B:164:0x02d4, B:112:0x0255=Splitter:B:112:0x0255, B:133:0x0295=Splitter:B:133:0x0295, B:122:0x0267=Splitter:B:122:0x0267, B:150:0x02b9=Splitter:B:150:0x02b9, B:137:0x029d=Splitter:B:137:0x029d, B:160:0x02cd=Splitter:B:160:0x02cd, B:108:0x024e=Splitter:B:108:0x024e, B:118:0x025f=Splitter:B:118:0x025f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.f.b a() {
        /*
            r28 = this;
            r1 = r28
            java.lang.String r2 = "Error occured when calling tmpFile.close"
            java.lang.String r3 = "Error occured when calling InputStream.close"
            java.io.File r0 = r1.a
            r4 = 0
            if (r0 == 0) goto L_0x02e9
            java.io.File r5 = r1.b
            if (r5 != 0) goto L_0x0011
            goto L_0x02e9
        L_0x0011:
            boolean r0 = r0.exists()
            r5 = 0
            if (r0 == 0) goto L_0x003b
            java.io.File r0 = r1.a
            long r7 = r0.length()
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x003b
            long r15 = java.lang.System.currentTimeMillis()
            com.bytedance.sdk.component.f.b r0 = new com.bytedance.sdk.component.f.b
            r8 = 1
            r9 = 200(0xc8, float:2.8E-43)
            java.lang.String r10 = "Success"
            r11 = 0
            r12 = 0
            r7 = r0
            r13 = r15
            r7.<init>(r8, r9, r10, r11, r12, r13, r15)
            java.io.File r2 = r1.a
            r0.a(r2)
            return r0
        L_0x003b:
            java.io.File r0 = r1.b
            long r7 = r0.length()
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0046
            r7 = r5
        L_0x0046:
            com.bytedance.sdk.component.b.a.l$a r0 = new com.bytedance.sdk.component.b.a.l$a
            r0.<init>()
            java.lang.String r9 = r28.b()
            r0.a((java.lang.Object) r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "bytes="
            r9.<init>(r10)
            r9.append(r7)
            java.lang.String r10 = "-"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r11 = "Range"
            r1.b(r11, r9)
            java.lang.String r9 = r1.f
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r11 = "DownloadExecutor"
            if (r9 == 0) goto L_0x007a
            java.lang.String r0 = "execute: Url is Empty"
            android.util.Log.e(r11, r0)
            return r4
        L_0x007a:
            java.lang.String r9 = r1.f     // Catch:{ IllegalArgumentException -> 0x02e1 }
            r0.a((java.lang.String) r9)     // Catch:{ IllegalArgumentException -> 0x02e1 }
            r1.a((com.bytedance.sdk.component.b.a.l.a) r0)
            com.bytedance.sdk.component.b.a.l$a r0 = r0.a()
            com.bytedance.sdk.component.b.a.l r0 = r0.b()
            com.bytedance.sdk.component.b.a.j r9 = r1.c     // Catch:{ IOException -> 0x02d8 }
            com.bytedance.sdk.component.b.a.b r0 = r9.a(r0)     // Catch:{ IOException -> 0x02d8 }
            com.bytedance.sdk.component.b.a.n r0 = r0.a()     // Catch:{ IOException -> 0x02d8 }
            if (r0 == 0) goto L_0x02df
            boolean r9 = r0.d()     // Catch:{ IOException -> 0x02d8 }
            if (r9 == 0) goto L_0x02df
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ IOException -> 0x02d8 }
            r9.<init>()     // Catch:{ IOException -> 0x02d8 }
            com.bytedance.sdk.component.b.a.f r12 = r0.g()     // Catch:{ IOException -> 0x02d8 }
            if (r12 == 0) goto L_0x00bc
            r13 = 0
        L_0x00a8:
            int r14 = r12.a()     // Catch:{ IOException -> 0x02d8 }
            if (r13 >= r14) goto L_0x00bc
            java.lang.String r14 = r12.a(r13)     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r15 = r12.b(r13)     // Catch:{ IOException -> 0x02d8 }
            r9.put(r14, r15)     // Catch:{ IOException -> 0x02d8 }
            int r13 = r13 + 1
            goto L_0x00a8
        L_0x00bc:
            com.bytedance.sdk.component.f.b r15 = new com.bytedance.sdk.component.f.b     // Catch:{ IOException -> 0x02d8 }
            boolean r13 = r0.d()     // Catch:{ IOException -> 0x02d8 }
            int r14 = r0.c()     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r17 = r0.e()     // Catch:{ IOException -> 0x02d8 }
            r18 = 0
            long r19 = r0.b()     // Catch:{ IOException -> 0x02d8 }
            long r21 = r0.a()     // Catch:{ IOException -> 0x02d8 }
            r12 = r15
            r23 = r15
            r15 = r17
            r16 = r9
            r17 = r18
            r18 = r19
            r20 = r21
            r12.<init>(r13, r14, r15, r16, r17, r18, r20)     // Catch:{ IOException -> 0x02d8 }
            com.bytedance.sdk.component.b.a.o r12 = r0.f()     // Catch:{ IOException -> 0x02d8 }
            long r12 = r12.a()     // Catch:{ IOException -> 0x02d8 }
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 > 0) goto L_0x00f4
            long r12 = f(r9)     // Catch:{ IOException -> 0x02d8 }
        L_0x00f4:
            java.io.File r14 = r1.b     // Catch:{ IOException -> 0x02d8 }
            long r14 = r14.length()     // Catch:{ IOException -> 0x02d8 }
            boolean r16 = e(r9)     // Catch:{ IOException -> 0x02d8 }
            if (r16 == 0) goto L_0x0161
            long r12 = r12 + r14
            java.lang.String r6 = "Content-Range"
            java.lang.Object r6 = r9.get(r6)     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x02d8 }
            boolean r19 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IOException -> 0x02d8 }
            if (r19 != 0) goto L_0x0161
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02d8 }
            r4.<init>()     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r5 = "bytes "
            r4.append(r5)     // Catch:{ IOException -> 0x02d8 }
            r4.append(r14)     // Catch:{ IOException -> 0x02d8 }
            r4.append(r10)     // Catch:{ IOException -> 0x02d8 }
            r14 = 1
            long r14 = r12 - r14
            r4.append(r14)     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x02d8 }
            int r5 = android.text.TextUtils.indexOf(r6, r4)     // Catch:{ IOException -> 0x02d8 }
            r10 = -1
            if (r5 != r10) goto L_0x0161
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02d8 }
            r0.<init>()     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r2 = "execute: The Content-Range Header is invalid Assume["
            r0.append(r2)     // Catch:{ IOException -> 0x02d8 }
            r0.append(r4)     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r2 = "] vs Real["
            r0.append(r2)     // Catch:{ IOException -> 0x02d8 }
            r0.append(r6)     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r2 = "], please remove the temporary file ["
            r0.append(r2)     // Catch:{ IOException -> 0x02d8 }
            java.io.File r2 = r1.b     // Catch:{ IOException -> 0x02d8 }
            r0.append(r2)     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r2 = "]."
            r0.append(r2)     // Catch:{ IOException -> 0x02d8 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x02d8 }
            com.bytedance.sdk.component.f.d.d.b(r11, r0)     // Catch:{ IOException -> 0x02d8 }
            r28.c()     // Catch:{ IOException -> 0x02d8 }
            r2 = 0
            return r2
        L_0x0161:
            r4 = 0
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0192
            java.io.File r4 = r1.b     // Catch:{ IOException -> 0x02d8 }
            boolean r4 = r4.exists()     // Catch:{ IOException -> 0x02d8 }
            if (r4 == 0) goto L_0x0192
            java.io.File r4 = r1.b     // Catch:{ IOException -> 0x02d8 }
            long r4 = r4.length()     // Catch:{ IOException -> 0x02d8 }
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x0192
            java.io.File r0 = r1.b     // Catch:{ IOException -> 0x02d8 }
            java.io.File r2 = r1.a     // Catch:{ IOException -> 0x02d8 }
            boolean r0 = r0.renameTo(r2)     // Catch:{ IOException -> 0x02d8 }
            if (r0 == 0) goto L_0x018b
            java.io.File r0 = r1.a     // Catch:{ IOException -> 0x02d8 }
            r4 = r23
            r4.a(r0)     // Catch:{ IOException -> 0x02d8 }
            return r4
        L_0x018b:
            java.lang.String r0 = "Rename fail"
            com.bytedance.sdk.component.f.d.d.b(r11, r0)     // Catch:{ IOException -> 0x02d8 }
            r2 = 0
            return r2
        L_0x0192:
            r4 = r23
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x01ac }
            java.io.File r6 = r1.b     // Catch:{ all -> 0x01ac }
            java.lang.String r10 = "rw"
            r5.<init>(r6, r10)     // Catch:{ all -> 0x01ac }
            if (r16 == 0) goto L_0x01a4
            r5.seek(r7)     // Catch:{ all -> 0x01a9 }
            r14 = r7
            goto L_0x01ae
        L_0x01a4:
            r14 = 0
            r5.setLength(r14)     // Catch:{ all -> 0x01a9 }
        L_0x01a9:
            r14 = 0
            goto L_0x01ae
        L_0x01ac:
            r5 = 0
            goto L_0x01a9
        L_0x01ae:
            com.bytedance.sdk.component.b.a.o r0 = r0.f()     // Catch:{ all -> 0x02a4 }
            java.io.InputStream r6 = r0.c()     // Catch:{ all -> 0x02a4 }
            boolean r0 = g(r9)     // Catch:{ all -> 0x02a2 }
            if (r0 == 0) goto L_0x01c6
            boolean r0 = r6 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x02a2 }
            if (r0 != 0) goto L_0x01c6
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x02a2 }
            r0.<init>(r6)     // Catch:{ all -> 0x02a2 }
            r6 = r0
        L_0x01c6:
            r0 = 16384(0x4000, float:2.2959E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x02a2 }
            r9 = 0
            r21 = 0
        L_0x01cd:
            int r10 = 16384 - r9
            int r10 = r6.read(r0, r9, r10)     // Catch:{ all -> 0x02a2 }
            r23 = 1
            r24 = r11
            r11 = -1
            if (r10 == r11) goto L_0x0206
            int r9 = r9 + r10
            r25 = r12
            long r11 = (long) r10     // Catch:{ all -> 0x02a2 }
            long r21 = r21 + r11
            r10 = 16384(0x4000, double:8.0948E-320)
            long r10 = r21 % r10
            r12 = 0
            int r27 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r27 == 0) goto L_0x01f3
            long r12 = r25 - r7
            int r10 = (r21 > r12 ? 1 : (r21 == r12 ? 0 : -1))
            if (r10 != 0) goto L_0x01f1
            goto L_0x01f3
        L_0x01f1:
            r23 = 0
        L_0x01f3:
            if (r23 == 0) goto L_0x0200
            r5.seek(r14)     // Catch:{ all -> 0x02a2 }
            r11 = 0
            r5.write(r0, r11, r9)     // Catch:{ all -> 0x02a2 }
            long r9 = (long) r9     // Catch:{ all -> 0x02a2 }
            long r14 = r14 + r9
            r9 = 0
            goto L_0x0201
        L_0x0200:
            r11 = 0
        L_0x0201:
            r11 = r24
            r12 = r25
            goto L_0x01cd
        L_0x0206:
            r25 = r12
            r11 = 0
            if (r10 == 0) goto L_0x0211
            r5.seek(r14)     // Catch:{ all -> 0x02a2 }
            r5.write(r0, r11, r9)     // Catch:{ all -> 0x02a2 }
        L_0x0211:
            r9 = 0
            if (r16 == 0) goto L_0x021d
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x021a
            goto L_0x021d
        L_0x021a:
            r12 = r25
            goto L_0x0223
        L_0x021d:
            java.io.File r0 = r1.b     // Catch:{ all -> 0x02a2 }
            long r12 = r0.length()     // Catch:{ all -> 0x02a2 }
        L_0x0223:
            int r0 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x026c
            java.io.File r0 = r1.b     // Catch:{ all -> 0x02a2 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x02a2 }
            if (r0 == 0) goto L_0x026c
            java.io.File r0 = r1.b     // Catch:{ all -> 0x02a2 }
            long r7 = r0.length()     // Catch:{ all -> 0x02a2 }
            int r0 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x026c
            java.io.File r0 = r1.b     // Catch:{ all -> 0x02a2 }
            java.io.File r7 = r1.a     // Catch:{ all -> 0x02a2 }
            boolean r0 = r0.renameTo(r7)     // Catch:{ all -> 0x02a2 }
            if (r0 == 0) goto L_0x0259
            java.io.File r0 = r1.a     // Catch:{ all -> 0x02a2 }
            r4.a(r0)     // Catch:{ all -> 0x02a2 }
            if (r6 == 0) goto L_0x0251
            r6.close()     // Catch:{ all -> 0x024e }
            goto L_0x0251
        L_0x024e:
            com.bytedance.sdk.component.f.d.d.a(r3)     // Catch:{ IOException -> 0x02d8 }
        L_0x0251:
            r5.close()     // Catch:{ all -> 0x0255 }
            goto L_0x0258
        L_0x0255:
            com.bytedance.sdk.component.f.d.d.a(r2)     // Catch:{ IOException -> 0x02d8 }
        L_0x0258:
            return r4
        L_0x0259:
            if (r6 == 0) goto L_0x0262
            r6.close()     // Catch:{ all -> 0x025f }
            goto L_0x0262
        L_0x025f:
            com.bytedance.sdk.component.f.d.d.a(r3)     // Catch:{ IOException -> 0x02d8 }
        L_0x0262:
            r5.close()     // Catch:{ all -> 0x0267 }
        L_0x0265:
            r2 = 0
            goto L_0x026b
        L_0x0267:
            com.bytedance.sdk.component.f.d.d.a(r2)     // Catch:{ IOException -> 0x02d8 }
            goto L_0x0265
        L_0x026b:
            return r2
        L_0x026c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
            r0.<init>()     // Catch:{ all -> 0x02a2 }
            java.lang.String r4 = " tempFile.length() == fileSize is"
            r0.append(r4)     // Catch:{ all -> 0x02a2 }
            java.io.File r4 = r1.b     // Catch:{ all -> 0x02a2 }
            long r7 = r4.length()     // Catch:{ all -> 0x02a2 }
            int r4 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x0282
            r15 = 1
            goto L_0x0283
        L_0x0282:
            r15 = 0
        L_0x0283:
            r0.append(r15)     // Catch:{ all -> 0x02a2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02a2 }
            r4 = r24
            com.bytedance.sdk.component.f.d.d.b(r4, r0)     // Catch:{ all -> 0x02a2 }
            if (r6 == 0) goto L_0x0298
            r6.close()     // Catch:{ all -> 0x0295 }
            goto L_0x0298
        L_0x0295:
            com.bytedance.sdk.component.f.d.d.a(r3)     // Catch:{ IOException -> 0x02d8 }
        L_0x0298:
            r5.close()     // Catch:{ all -> 0x029d }
        L_0x029b:
            r2 = 0
            goto L_0x02a1
        L_0x029d:
            com.bytedance.sdk.component.f.d.d.a(r2)     // Catch:{ IOException -> 0x02d8 }
            goto L_0x029b
        L_0x02a1:
            return r2
        L_0x02a2:
            r0 = move-exception
            goto L_0x02a6
        L_0x02a4:
            r0 = move-exception
            r6 = 0
        L_0x02a6:
            java.lang.String r4 = "Error occured when FileRequest.parseHttpResponse"
            com.bytedance.sdk.component.f.d.d.a(r4)     // Catch:{ all -> 0x02c6 }
            r0.printStackTrace()     // Catch:{ all -> 0x02c6 }
            if (r16 != 0) goto L_0x02b3
            r28.c()     // Catch:{ all -> 0x02c6 }
        L_0x02b3:
            if (r6 == 0) goto L_0x02bc
            r6.close()     // Catch:{ all -> 0x02b9 }
            goto L_0x02bc
        L_0x02b9:
            com.bytedance.sdk.component.f.d.d.a(r3)     // Catch:{ IOException -> 0x02d8 }
        L_0x02bc:
            r5.close()     // Catch:{ all -> 0x02c1 }
        L_0x02bf:
            r2 = 0
            goto L_0x02c5
        L_0x02c1:
            com.bytedance.sdk.component.f.d.d.a(r2)     // Catch:{ IOException -> 0x02d8 }
            goto L_0x02bf
        L_0x02c5:
            return r2
        L_0x02c6:
            r0 = move-exception
            if (r6 == 0) goto L_0x02d0
            r6.close()     // Catch:{ all -> 0x02cd }
            goto L_0x02d0
        L_0x02cd:
            com.bytedance.sdk.component.f.d.d.a(r3)     // Catch:{ IOException -> 0x02d8 }
        L_0x02d0:
            r5.close()     // Catch:{ all -> 0x02d4 }
            goto L_0x02d7
        L_0x02d4:
            com.bytedance.sdk.component.f.d.d.a(r2)     // Catch:{ IOException -> 0x02d8 }
        L_0x02d7:
            throw r0     // Catch:{ IOException -> 0x02d8 }
        L_0x02d8:
            r0 = move-exception
            r0.printStackTrace()
            r28.c()
        L_0x02df:
            r2 = 0
            return r2
        L_0x02e1:
            r2 = r4
            r4 = r11
            java.lang.String r0 = "execute: Url is not a valid HTTP or HTTPS URL"
            android.util.Log.e(r4, r0)
            return r2
        L_0x02e9:
            r2 = r4
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.b.a.a():com.bytedance.sdk.component.f.b");
    }

    /* access modifiers changed from: private */
    public static boolean e(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        if (str == null || !str.startsWith("bytes")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static long f(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static boolean g(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    /* access modifiers changed from: protected */
    public void a(long j, long j2, com.bytedance.sdk.component.f.a.a aVar) {
        if (aVar != null) {
            aVar.a(this, j, j2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r1 = this;
            java.io.File r0 = r1.a     // Catch:{ all -> 0x0005 }
            r0.delete()     // Catch:{ all -> 0x0005 }
        L_0x0005:
            java.io.File r0 = r1.b     // Catch:{ all -> 0x000a }
            r0.delete()     // Catch:{ all -> 0x000a }
        L_0x000a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.b.a.c():void");
    }
}
