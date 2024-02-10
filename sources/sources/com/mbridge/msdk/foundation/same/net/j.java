package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.f.b;
import com.mbridge.msdk.foundation.same.net.f.c;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Request */
public abstract class j<T> implements Comparable<j<T>> {
    private static final String c = "j";
    protected ConcurrentHashMap<String, String> a;
    protected e<T> b;
    private final int d;
    private final String e;
    private final boolean f;
    private Integer g;
    private k h;
    private boolean i;
    private m j;
    private int k;

    /* access modifiers changed from: protected */
    public abstract l<T> a(c cVar);

    public byte[] f() {
        return null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        j jVar = (j) obj;
        int h2 = h();
        int h3 = jVar.h();
        return h2 == h3 ? this.g.intValue() - jVar.g.intValue() : h3 - h2;
    }

    public j(int i2, String str, e<T> eVar) {
        this.a = new ConcurrentHashMap<>();
        this.i = false;
        this.k = 2;
        this.e = str;
        this.d = i2;
        this.b = eVar;
        this.f = false;
        this.j = new b();
    }

    public j(int i2, String str, e<T> eVar, boolean z) {
        this.a = new ConcurrentHashMap<>();
        this.i = false;
        this.k = 2;
        this.e = str;
        this.d = i2;
        this.b = eVar;
        this.f = z;
        this.j = new b();
    }

    public j(int i2, String str) {
        this.a = new ConcurrentHashMap<>();
        this.b = null;
        this.i = false;
        this.k = 2;
        this.e = str;
        this.d = i2;
        this.f = false;
        this.j = new b();
    }

    public final int a() {
        return this.d;
    }

    public final void a(e<T> eVar) {
        this.b = eVar;
    }

    public final j<?> a(m mVar) {
        this.j = mVar;
        return this;
    }

    public final void a(String str) {
        k kVar = this.h;
        if (kVar != null) {
            kVar.b(this);
        }
    }

    public final j<?> a(k kVar) {
        this.h = kVar;
        return this;
    }

    public final j<?> a(int i2) {
        this.g = Integer.valueOf(i2);
        return this;
    }

    public final String b() {
        return this.e;
    }

    public final void c() {
        this.i = true;
    }

    public final boolean d() {
        return this.i;
    }

    public final Map<String, String> e() {
        return this.a;
    }

    public final void g() {
        a("Charset", "UTF-8");
        if (this.f) {
            a("Connection", "keep-alive");
        } else {
            a("Connection", "close");
        }
    }

    public byte[] a(b bVar, c cVar) throws IOException, a {
        return bVar.c() != null ? a(bVar) : new byte[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0066 A[SYNTHETIC, Splitter:B:39:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006e A[Catch:{ IOException -> 0x006a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(com.mbridge.msdk.foundation.same.net.f.b r6) throws java.io.IOException, com.mbridge.msdk.foundation.same.net.b.a {
        /*
            r5 = this;
            r0 = 0
            java.io.InputStream r1 = r6.c()     // Catch:{ all -> 0x0062 }
            boolean r2 = r1 instanceof java.io.ByteArrayInputStream     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x001d
            java.util.List r6 = r6.b()     // Catch:{ all -> 0x005d }
            boolean r6 = com.mbridge.msdk.foundation.same.net.g.b.b(r6)     // Catch:{ all -> 0x005d }
            if (r6 == 0) goto L_0x001d
            boolean r6 = r1 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x005d }
            if (r6 != 0) goto L_0x001d
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x005d }
            r6.<init>(r1)     // Catch:{ all -> 0x005d }
            r1 = r6
        L_0x001d:
            if (r1 == 0) goto L_0x0056
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x005d }
            r6.<init>()     // Catch:{ all -> 0x005d }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0051 }
        L_0x0028:
            int r2 = r1.read(r0)     // Catch:{ all -> 0x0051 }
            r3 = -1
            if (r2 == r3) goto L_0x0034
            r3 = 0
            r6.write(r0, r3, r2)     // Catch:{ all -> 0x0051 }
            goto L_0x0028
        L_0x0034:
            r6.flush()     // Catch:{ all -> 0x0051 }
            byte[] r0 = r6.toByteArray()     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0043
        L_0x0041:
            r6 = move-exception
            goto L_0x0047
        L_0x0043:
            r6.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0050
        L_0x0047:
            java.lang.String r1 = c
            java.lang.String r6 = r6.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r1, r6)
        L_0x0050:
            return r0
        L_0x0051:
            r0 = move-exception
            r4 = r1
            r1 = r6
            r6 = r0
            goto L_0x0060
        L_0x0056:
            com.mbridge.msdk.foundation.same.net.b.a r6 = new com.mbridge.msdk.foundation.same.net.b.a     // Catch:{ all -> 0x005d }
            r2 = 7
            r6.<init>(r2, r0)     // Catch:{ all -> 0x005d }
            throw r6     // Catch:{ all -> 0x005d }
        L_0x005d:
            r6 = move-exception
            r4 = r1
            r1 = r0
        L_0x0060:
            r0 = r4
            goto L_0x0064
        L_0x0062:
            r6 = move-exception
            r1 = r0
        L_0x0064:
            if (r0 == 0) goto L_0x006c
            r0.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006c
        L_0x006a:
            r0 = move-exception
            goto L_0x0072
        L_0x006c:
            if (r1 == 0) goto L_0x007b
            r1.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x007b
        L_0x0072:
            java.lang.String r1 = c
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)
        L_0x007b:
            goto L_0x007d
        L_0x007c:
            throw r6
        L_0x007d:
            goto L_0x007c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.j.a(com.mbridge.msdk.foundation.same.net.f.b):byte[]");
    }

    public int h() {
        return this.k;
    }

    public final void b(int i2) {
        if (i2 >= 1 && i2 <= 4) {
            this.k = i2;
        }
    }

    public final int i() {
        try {
            return this.j.b();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int j() {
        try {
            return this.j.c();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int k() {
        try {
            return this.j.d();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int l() {
        try {
            return this.j.e();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int m() {
        try {
            return this.j.f();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final m n() {
        return this.j;
    }

    public final void a(l<T> lVar) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.onSuccess(lVar);
        }
    }

    public final void a(a aVar) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.onError(aVar);
        }
    }

    public final void o() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.onCancel();
        }
    }

    public final void p() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.onPreExecute();
        }
    }

    public final void q() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.onFinish();
        }
    }

    public final void r() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.onRetry();
        }
    }

    public final void s() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.onNetworking();
        }
    }

    public final void a(long j2, long j3) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.onProgressChange(j2, j3);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.i ? "[X] " : "[ ] ");
        sb.append(this.e);
        sb.append(" ");
        sb.append(h());
        sb.append(" ");
        sb.append(this.g);
        return sb.toString();
    }

    public final void a(String str, String str2) {
        this.a.remove(str);
        this.a.put(str, str2);
    }
}
