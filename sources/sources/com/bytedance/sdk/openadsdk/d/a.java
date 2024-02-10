package com.bytedance.sdk.openadsdk.d;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bytedance.sdk.component.b.a.e;
import com.bytedance.sdk.component.b.a.f;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.m;
import com.bytedance.sdk.component.b.a.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultNetWork */
public class a implements INetWork {
    protected j a = new j.a().a(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).a();
    protected j b = new j.a().a(10, TimeUnit.SECONDS).b(30, TimeUnit.SECONDS).c(30, TimeUnit.SECONDS).a();

    public Response doGet(String str) throws Exception {
        n a2 = this.a.a(new l.a().a().a(str).b()).a();
        return new Response(a(a2.g()), a2.c() == 200 ? a2.f().b() : null, a2.c(), a2.e());
    }

    public Response doPost(String str, List<Pair<String, String>> list) throws Exception {
        e.a aVar = new e.a();
        if (list != null) {
            for (Pair next : list) {
                aVar.a((String) next.first, (String) next.second);
            }
        }
        n a2 = this.a.a(new l.a().a(str).a((m) aVar.a()).b()).a();
        return new Response(a(a2.g()), a2.c() == 200 ? a2.f().b() : null, a2.c(), a2.e());
    }

    public Response doPost(String str, String str2) throws Exception {
        n a2 = this.a.a(new l.a().a(str).a(m.a(i.a("application/json; charset=utf-8"), str2)).b()).a();
        return new Response(a(a2.g()), a2.c() == 200 ? a2.f().b() : null, a2.c(), a2.e());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        r2 = null;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r6 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0002] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadFile(java.lang.String r6, long r7, com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream r9) throws java.lang.Exception {
        /*
            r5 = this;
            r7 = 0
            r8 = 0
            com.bytedance.sdk.component.b.a.l$a r0 = new com.bytedance.sdk.component.b.a.l$a     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            r0.<init>()     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            com.bytedance.sdk.component.b.a.l$a r0 = r0.a()     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            com.bytedance.sdk.component.b.a.l$a r0 = r0.a((java.lang.String) r6)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            com.bytedance.sdk.component.b.a.l r0 = r0.b()     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            com.bytedance.sdk.component.b.a.j r1 = r5.b     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            com.bytedance.sdk.component.b.a.b r0 = r1.a(r0)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            com.bytedance.sdk.component.b.a.n r0 = r0.a()     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            int r1 = r0.c()     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0043, all -> 0x0048 }
            com.bytedance.sdk.component.b.a.o r0 = r0.f()     // Catch:{ Exception -> 0x0043, all -> 0x0048 }
            java.io.InputStream r0 = r0.c()     // Catch:{ Exception -> 0x0043, all -> 0x0048 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0043, all -> 0x0048 }
            r7 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r7]     // Catch:{ Exception -> 0x0041 }
        L_0x0032:
            int r3 = r2.read(r0, r8, r7)     // Catch:{ Exception -> 0x0041 }
            r4 = -1
            if (r3 == r4) goto L_0x003d
            r9.write(r0, r8, r3)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0032
        L_0x003d:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close((java.io.Closeable) r2)
            return
        L_0x0041:
            r7 = move-exception
            goto L_0x0046
        L_0x0043:
            r8 = move-exception
            r2 = r7
            r7 = r8
        L_0x0046:
            r8 = r1
            goto L_0x004d
        L_0x0048:
            r6 = move-exception
            goto L_0x007a
        L_0x004a:
            r9 = move-exception
            r2 = r7
            r7 = r9
        L_0x004d:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch:{ all -> 0x0078 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
            r0.<init>()     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "downloadFile failed, code: "
            r0.append(r1)     // Catch:{ all -> 0x0078 }
            r0.append(r8)     // Catch:{ all -> 0x0078 }
            java.lang.String r8 = ", url:"
            r0.append(r8)     // Catch:{ all -> 0x0078 }
            r0.append(r6)     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = ", caused by:"
            r0.append(r6)     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = r7.getMessage()     // Catch:{ all -> 0x0078 }
            r0.append(r6)     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0078 }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x0078 }
            throw r9     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r6 = move-exception
            r7 = r2
        L_0x007a:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close((java.io.Closeable) r7)
            goto L_0x007f
        L_0x007e:
            throw r6
        L_0x007f:
            goto L_0x007e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.d.a.downloadFile(java.lang.String, long, com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream):void");
    }

    private Map<String, String> a(f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < fVar.a(); i++) {
            hashMap.put(fVar.a(i), fVar.b(i));
        }
        return hashMap;
    }
}
