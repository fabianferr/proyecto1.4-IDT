package com.bytedance.sdk.component.f.b;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.bytedance.sdk.component.b.a.c;
import com.bytedance.sdk.component.b.a.f;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.m;
import com.bytedance.sdk.component.b.a.n;
import com.bytedance.sdk.component.f.a.a;
import com.bytedance.sdk.component.f.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: PostExecutor */
public class d extends c {
    m a = null;

    public d(j jVar) {
        super(jVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0056 A[SYNTHETIC, Splitter:B:33:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006f A[SYNTHETIC, Splitter:B:44:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] d(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "PostExecutor"
            r1 = 0
            if (r6 == 0) goto L_0x008d
            int r2 = r6.length()
            if (r2 != 0) goto L_0x000d
            goto L_0x008d
        L_0x000d:
            r2 = 0
            byte[] r2 = new byte[r2]
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            r3.<init>()     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0046 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0046 }
            java.lang.String r1 = "utf-8"
            byte[] r6 = r6.getBytes(r1)     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            r4.write(r6)     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            r4.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x002f
        L_0x0027:
            r6 = move-exception
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.utils.l.e(r0, r6)
        L_0x002f:
            byte[] r2 = r3.toByteArray()
            r3.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x006b
        L_0x0037:
            r6 = move-exception
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.utils.l.e(r0, r6)
            goto L_0x006b
        L_0x0040:
            r6 = move-exception
            r1 = r4
            goto L_0x006d
        L_0x0043:
            r6 = move-exception
            r1 = r4
            goto L_0x004d
        L_0x0046:
            r6 = move-exception
            goto L_0x004d
        L_0x0048:
            r6 = move-exception
            r3 = r1
            goto L_0x006d
        L_0x004b:
            r6 = move-exception
            r3 = r1
        L_0x004d:
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x006c }
            com.bytedance.sdk.component.utils.l.e(r0, r6)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r6 = move-exception
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.utils.l.e(r0, r6)
        L_0x0062:
            if (r3 == 0) goto L_0x006b
            byte[] r2 = r3.toByteArray()
            r3.close()     // Catch:{ IOException -> 0x0037 }
        L_0x006b:
            return r2
        L_0x006c:
            r6 = move-exception
        L_0x006d:
            if (r1 == 0) goto L_0x007b
            r1.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x007b
        L_0x0073:
            r1 = move-exception
            java.lang.String r1 = r1.toString()
            com.bytedance.sdk.component.utils.l.e(r0, r1)
        L_0x007b:
            if (r3 == 0) goto L_0x008c
            r3.toByteArray()
            r3.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x008c
        L_0x0084:
            r1 = move-exception
            java.lang.String r1 = r1.toString()
            com.bytedance.sdk.component.utils.l.e(r0, r1)
        L_0x008c:
            throw r6
        L_0x008d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.b.d.d(java.lang.String):byte[]");
    }

    public b a() {
        try {
            l.a aVar = new l.a();
            if (TextUtils.isEmpty(this.f)) {
                com.bytedance.sdk.component.f.d.d.b("PostExecutor", "execute: Url is Empty");
                return new b(false, 5000, "URL_NULL_MSG", (Map<String, String>) null, "URL_NULL_BODY", 1, 1);
            }
            aVar.a(this.f);
            if (this.a == null) {
                com.bytedance.sdk.component.f.d.d.b("PostExecutor", "RequestBody is null, content type is not support!!");
                return new b(false, 5000, "BODY_NULL_MSG", (Map<String, String>) null, "BODY_NULL_BODY", 1, 1);
            }
            a(aVar);
            aVar.a((Object) b());
            n a2 = this.c.a(aVar.a(this.a).b()).a();
            if (a2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            f g = a2.g();
            if (g != null) {
                for (int i = 0; i < g.a(); i++) {
                    hashMap.put(g.a(i), g.b(i));
                }
            }
            return new b(a2.d(), a2.c(), a2.e(), hashMap, a2.f().b(), a2.b(), a2.a());
        } catch (Throwable th) {
            return new b(false, 5001, th.getMessage(), (Map<String, String>) null, "BODY_NULL_BODY", 1, 1);
        }
    }

    public void a(final a aVar) {
        try {
            l.a aVar2 = new l.a();
            if (TextUtils.isEmpty(this.f)) {
                aVar.a((c) this, new IOException("Url is Empty"));
                return;
            }
            aVar2.a(this.f);
            if (this.a != null) {
                a(aVar2);
                aVar2.a((Object) b());
                this.c.a(aVar2.a(this.a).b()).a(new c() {
                    public void a(com.bytedance.sdk.component.b.a.b bVar, IOException iOException) {
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.a((c) d.this, iOException);
                        }
                    }

                    public void a(com.bytedance.sdk.component.b.a.b bVar, n nVar) throws IOException {
                        IOException iOException;
                        a aVar = aVar;
                        if (aVar == null) {
                            return;
                        }
                        if (nVar == null) {
                            aVar.a((c) d.this, new IOException("No response"));
                            return;
                        }
                        b bVar2 = null;
                        try {
                            HashMap hashMap = new HashMap();
                            f g = nVar.g();
                            if (g != null) {
                                for (int i = 0; i < g.a(); i++) {
                                    hashMap.put(g.a(i), g.b(i));
                                }
                            }
                            iOException = null;
                            bVar2 = new b(nVar.d(), nVar.c(), nVar.e(), hashMap, nVar.f().b(), nVar.b(), nVar.a());
                        } catch (Throwable th) {
                            iOException = new IOException(th);
                        }
                        if (bVar2 != null) {
                            aVar.a((c) d.this, bVar2);
                            return;
                        }
                        a aVar2 = aVar;
                        d dVar = d.this;
                        if (iOException == null) {
                            iOException = new IOException("Unexpected exception");
                        }
                        aVar2.a((c) dVar, iOException);
                    }
                });
            } else if (aVar != null) {
                aVar.a((c) this, new IOException("RequestBody is null, content type is not support!!"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            aVar.a((c) this, new IOException(th.getMessage()));
        }
    }

    public void a(String str, boolean z) {
        if (z) {
            a("application/json; charset=utf-8", d(str));
            b("Content-Encoding", "gzip");
            return;
        }
        c(str);
    }

    public void a(String str, byte[] bArr) {
        this.a = m.a(i.a(str), bArr);
    }

    public void a(JSONObject jSONObject) {
        this.a = m.a(i.a("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : JsonUtils.EMPTY_JSON);
    }

    public m c() {
        return this.a;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = JsonUtils.EMPTY_JSON;
        }
        this.a = m.a(i.a("application/json; charset=utf-8"), str);
    }
}
