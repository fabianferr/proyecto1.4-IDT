package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.j;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.File;

/* compiled from: FileDownloadRequest */
public class a extends j<Void> {
    private static final String c = "a";
    private File d;
    private File e;

    public final int h() {
        return 1;
    }

    public a(File file, String str) {
        super(0, str);
        this.d = file;
        this.e = new File(file + ".tmp");
    }

    /* access modifiers changed from: protected */
    public final l<Void> a(c cVar) {
        if (d()) {
            return l.a(new com.mbridge.msdk.foundation.same.net.b.a(-2, cVar));
        }
        if (!this.e.canRead() || this.e.length() <= 0) {
            aa.b(c, "Download temporary file was invalid!");
            return l.a(new com.mbridge.msdk.foundation.same.net.b.a(4, cVar));
        } else if (this.e.renameTo(this.d)) {
            return l.a(null, cVar);
        } else {
            aa.b(c, "Can't rename the download temporary file!");
            return l.a(new com.mbridge.msdk.foundation.same.net.b.a(4, cVar));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b9 A[SYNTHETIC, Splitter:B:46:0x00b9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(com.mbridge.msdk.foundation.same.net.f.b r17, com.mbridge.msdk.foundation.same.net.c r18) throws java.io.IOException {
        /*
            r16 = this;
            r7 = r16
            java.lang.String r8 = "Error occured when calling InputStream.close"
            java.util.List r0 = r17.b()
            java.lang.String r1 = "Content-Length"
            java.lang.String r0 = com.mbridge.msdk.foundation.same.net.g.b.a(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L_0x0020
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r0 = r0.longValue()
            r9 = r0
            goto L_0x0021
        L_0x0020:
            r9 = r2
        L_0x0021:
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x002c
            java.lang.String r0 = c
            java.lang.String r1 = "Response doesn't present Content-Length!"
            com.mbridge.msdk.foundation.tools.aa.b(r0, r1)
        L_0x002c:
            r11 = 0
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x004c
            java.io.File r0 = r7.d
            long r0 = r0.length()
            int r4 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x004c
            java.io.File r0 = r7.d
            java.io.File r1 = r7.e
            r0.renameTo(r1)
            r1 = r18
            r2 = r16
            r3 = r9
            r5 = r9
            r1.a(r2, r3, r5)
            return r11
        L_0x004c:
            java.io.RandomAccessFile r12 = new java.io.RandomAccessFile
            java.io.File r0 = r7.e
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r1 = "rw"
            r12.<init>(r0, r1)
            r12.setLength(r2)
            java.io.InputStream r1 = r17.c()     // Catch:{ all -> 0x00b6 }
            java.util.List r0 = r17.b()     // Catch:{ all -> 0x00b3 }
            boolean r0 = com.mbridge.msdk.foundation.same.net.g.b.b(r0)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0075
            boolean r0 = r1 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x00b3 }
            if (r0 != 0) goto L_0x0075
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x00b3 }
            r0.<init>(r1)     // Catch:{ all -> 0x00b3 }
            r13 = r0
            goto L_0x0076
        L_0x0075:
            r13 = r1
        L_0x0076:
            r0 = 6144(0x1800, float:8.61E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00b0 }
        L_0x007a:
            int r1 = r13.read(r0)     // Catch:{ all -> 0x00b0 }
            r4 = -1
            if (r1 == r4) goto L_0x00a1
            r4 = 0
            r12.write(r0, r4, r1)     // Catch:{ all -> 0x00b0 }
            long r4 = (long) r1     // Catch:{ all -> 0x00b0 }
            long r14 = r2 + r4
            r1 = r18
            r2 = r16
            r3 = r9
            r5 = r14
            r1.a(r2, r3, r5)     // Catch:{ all -> 0x00b0 }
            boolean r1 = r16.d()     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x009d
            r1 = r18
            r1.b(r7)     // Catch:{ all -> 0x00b0 }
            goto L_0x00a1
        L_0x009d:
            r1 = r18
            r2 = r14
            goto L_0x007a
        L_0x00a1:
            if (r13 == 0) goto L_0x00ac
            r13.close()     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ac
        L_0x00a7:
            java.lang.String r0 = c
            com.mbridge.msdk.foundation.tools.aa.d(r0, r8)
        L_0x00ac:
            r12.close()
            return r11
        L_0x00b0:
            r0 = move-exception
            r11 = r13
            goto L_0x00b7
        L_0x00b3:
            r0 = move-exception
            r11 = r1
            goto L_0x00b7
        L_0x00b6:
            r0 = move-exception
        L_0x00b7:
            if (r11 == 0) goto L_0x00c2
            r11.close()     // Catch:{ Exception -> 0x00bd }
            goto L_0x00c2
        L_0x00bd:
            java.lang.String r1 = c
            com.mbridge.msdk.foundation.tools.aa.d(r1, r8)
        L_0x00c2:
            r12.close()
            goto L_0x00c7
        L_0x00c6:
            throw r0
        L_0x00c7:
            goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.e.a.a(com.mbridge.msdk.foundation.same.net.f.b, com.mbridge.msdk.foundation.same.net.c):byte[]");
    }
}
