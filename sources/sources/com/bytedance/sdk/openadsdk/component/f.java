package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.component.d.h;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.s;
import com.bytedance.sdk.openadsdk.core.model.v;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.j;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TTAppOpenAdCacheManager */
public class f {
    private static volatile f a;
    private final com.bytedance.sdk.openadsdk.a.b b;
    private final p<com.bytedance.sdk.openadsdk.b.a> c;
    private final Context d;
    private final Map<String, AtomicInteger> e = new ConcurrentHashMap();

    /* compiled from: TTAppOpenAdCacheManager */
    public interface b {
        void a();

        void a(com.bytedance.sdk.openadsdk.k.a.b bVar);
    }

    /* compiled from: TTAppOpenAdCacheManager */
    interface c {
        void a();

        void a(int i, String str);
    }

    /* compiled from: TTAppOpenAdCacheManager */
    public interface d {
        void a();

        void a(Bitmap bitmap);
    }

    private f(Context context) {
        if (context != null) {
            this.d = context.getApplicationContext();
        } else {
            this.d = o.a();
        }
        this.b = new com.bytedance.sdk.openadsdk.a.b(10, 8, true);
        this.c = o.c();
    }

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    public static void a(q qVar, d dVar) {
        a(qVar, dVar, 0);
    }

    public static void a(q qVar, final d dVar, final int i) {
        String j = qVar.K().j();
        if (!TextUtils.isEmpty(j)) {
            com.bytedance.sdk.openadsdk.f.d.a(j).a(qVar.K().c()).b(qVar.K().b()).d(ad.d(o.a())).c(ad.c(o.a())).a(u.BITMAP).a((h) new h() {
                public Bitmap a(Bitmap bitmap) {
                    if (i <= 0) {
                        return bitmap;
                    }
                    return com.bytedance.sdk.component.adexpress.c.a.a(o.a(), bitmap, i);
                }
            }).a((com.bytedance.sdk.component.d.o) new com.bytedance.sdk.openadsdk.f.b(qVar, j, new com.bytedance.sdk.component.d.o<Bitmap>() {
                public void a(k<Bitmap> kVar) {
                    if (kVar == null || kVar.b() == null || kVar.c() == null) {
                        d dVar = dVar;
                        if (dVar != null) {
                            dVar.a();
                            return;
                        }
                        return;
                    }
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a(kVar.b());
                    }
                }

                public void a(int i, String str, Throwable th) {
                    d dVar = dVar;
                    if (dVar != null) {
                        dVar.a();
                    }
                }
            }));
        }
    }

    public void a(final AdSlot adSlot) {
        if (adSlot != null && TextUtils.isEmpty(adSlot.getBidAdm())) {
            AtomicInteger atomicInteger = this.e.get(adSlot.getCodeId());
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(0);
            }
            l.a("TTAppOpenAdCacheManager", "local Requesting:", atomicInteger);
            int c2 = atomicInteger.get() + c(adSlot);
            if (c2 >= 1) {
                l.a("TTAppOpenAdCacheManager", Integer.valueOf(c2), ",The number of preloads exceeds the limit ", 1);
                return;
            }
            atomicInteger.incrementAndGet();
            this.e.put(adSlot.getCodeId(), atomicInteger);
            final v vVar = new v();
            vVar.a(ab.a());
            s sVar = new s();
            sVar.h = vVar;
            sVar.d = 2;
            sVar.f = 2;
            this.c.a(adSlot, sVar, 3, (p.a) new p.a() {
                public void a(int i, String str) {
                    l.b("TTAppOpenAdCacheManager", "cache Load App OpenAd From Network fail");
                    f.this.b(adSlot);
                }

                public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                    l.b("TTAppOpenAdCacheManager", "cache Load App Open Ad From Network success");
                    if (aVar == null || aVar.c() == null || aVar.c().size() == 0) {
                        l.b("TTAppOpenAdCacheManager", "material is null");
                        bVar.a(-3);
                        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                        return;
                    }
                    q qVar = aVar.c().get(0);
                    if (qVar != null && qVar.br()) {
                        com.bytedance.sdk.openadsdk.component.e.a aVar2 = new com.bytedance.sdk.openadsdk.component.e.a(qVar.aZ(), qVar);
                        f.this.a(aVar2);
                        com.bytedance.sdk.openadsdk.component.d.a.a(aVar2.b(), 1, vVar);
                        f.this.b(adSlot);
                    } else if (q.c(qVar)) {
                        f.this.a(qVar, adSlot, vVar);
                    } else {
                        f.this.b(qVar, adSlot, vVar);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(AdSlot adSlot) {
        AtomicInteger atomicInteger = this.e.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        } else {
            atomicInteger.decrementAndGet();
        }
        this.e.put(adSlot.getCodeId(), atomicInteger);
    }

    /* access modifiers changed from: private */
    public void a(q qVar, AdSlot adSlot, v vVar) {
        final int aZ = qVar.aZ();
        final q qVar2 = qVar;
        final v vVar2 = vVar;
        final AdSlot adSlot2 = adSlot;
        a(qVar, adSlot, vVar, (c) new c() {
            public void a() {
                com.bytedance.sdk.openadsdk.component.e.a aVar = new com.bytedance.sdk.openadsdk.component.e.a(aZ, qVar2);
                f.this.a(aVar);
                com.bytedance.sdk.openadsdk.component.d.a.a(aVar.b(), 1, vVar2);
                f.this.b(adSlot2);
            }

            public void a(int i, String str) {
                f.this.b(adSlot2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(q qVar, AdSlot adSlot, v vVar) {
        final int aZ = qVar.aZ();
        final q qVar2 = qVar;
        final v vVar2 = vVar;
        final AdSlot adSlot2 = adSlot;
        a(qVar, vVar, (b) new b() {
            public void a(com.bytedance.sdk.openadsdk.k.a.b bVar) {
                com.bytedance.sdk.openadsdk.component.e.a aVar = new com.bytedance.sdk.openadsdk.component.e.a(aZ, qVar2);
                f.this.a(aVar);
                com.bytedance.sdk.openadsdk.component.d.a.a(aVar.b(), 1, vVar2);
                f.this.b(adSlot2);
            }

            public void a() {
                f.this.b(adSlot2);
            }
        });
    }

    public void a(q qVar, AdSlot adSlot, v vVar, c cVar) {
        q qVar2 = qVar;
        v vVar2 = vVar;
        ab a2 = ab.a();
        int aZ = qVar.aZ();
        com.bykv.vk.openvk.component.video.api.c.b K = qVar.K();
        String k = K.k();
        String n = K.n();
        if (TextUtils.isEmpty(n)) {
            n = e.a(k);
        }
        final File a3 = com.bytedance.sdk.openadsdk.component.g.a.a(n);
        if (a3.exists()) {
            l.b("TTAppOpenAdCacheManager", "The video cache exists locally, use the cache directly");
            com.bytedance.sdk.openadsdk.component.g.a.a(a3);
            a(aZ);
            long c2 = a2.c();
            if (vVar2 != null) {
                vVar2.a(c2);
                vVar2.a(1);
            }
            cVar.a();
            a(qVar2, (d) null);
        } else if (!o.d().y(String.valueOf(aZ)) || com.bytedance.sdk.component.utils.o.d(o.a())) {
            c cVar2 = cVar;
            com.bytedance.sdk.openadsdk.core.video.a.b a4 = q.a(a3.getParent(), qVar2);
            a4.a("material_meta", qVar2);
            a4.a("ad_slot", adSlot);
            final int i = aZ;
            final ab abVar = a2;
            final q qVar3 = qVar;
            AnonymousClass6 r14 = r0;
            final v vVar3 = vVar;
            com.bytedance.sdk.openadsdk.core.video.a.b bVar = a4;
            final c cVar3 = cVar;
            AnonymousClass6 r0 = new a.C0036a() {
                public void b(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                }

                public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                    l.b("TTAppOpenAdCacheManager", "Video file caching success");
                    f.this.a(i);
                    long c2 = abVar.c();
                    com.bytedance.sdk.openadsdk.component.d.a.b(qVar3, c2, true);
                    v vVar = vVar3;
                    if (vVar != null) {
                        vVar.a(c2);
                        vVar3.a(2);
                    }
                    cVar3.a();
                    f.a(qVar3, (d) null);
                }

                public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i, String str) {
                    l.b("TTAppOpenAdCacheManager", "Video file caching failed");
                    long c2 = abVar.c();
                    com.bytedance.sdk.openadsdk.component.d.a.b(qVar3, c2, false);
                    v vVar = vVar3;
                    if (vVar != null) {
                        vVar.a(c2);
                    }
                    cVar3.a(i, str);
                    try {
                        if (a3.exists() && a3.isFile()) {
                            com.bytedance.sdk.component.utils.f.c(a3);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            com.bytedance.sdk.openadsdk.core.video.d.a.a(bVar, r14);
            if (Build.VERSION.SDK_INT < 23) {
                a(new File(com.bykv.vk.openvk.component.video.api.c.a().getCacheDir(), "proxy_cache"));
                a(aZ);
                long c3 = a2.c();
                com.bytedance.sdk.openadsdk.component.d.a.b(qVar2, c3, true);
                if (vVar2 != null) {
                    vVar2.a(c3);
                    vVar2.a(2);
                }
                cVar.a();
                a(qVar2, (d) null);
            }
        } else {
            cVar.a(100, "OnlyWifi");
        }
    }

    public void a(q qVar, v vVar, b bVar) {
        final ab a2 = ab.a();
        final int aZ = qVar.aZ();
        n nVar = qVar.Q().get(0);
        String g = nVar.g();
        String a3 = nVar.a();
        int b2 = nVar.b();
        int c2 = nVar.c();
        File b3 = com.bytedance.sdk.openadsdk.component.g.a.b(TextUtils.isEmpty(g) ? e.a(a3) : g);
        if (a(a3, g)) {
            l.b("TTAppOpenAdCacheManager", "The image cache exists locally, directly use the cache");
            c(aZ);
            long c3 = a2.c();
            if (vVar != null) {
                vVar.a(c3);
                vVar.a(1);
            }
            bVar.a((com.bytedance.sdk.openadsdk.k.a.b) null);
            return;
        }
        com.bytedance.sdk.openadsdk.k.a aVar = new com.bytedance.sdk.openadsdk.k.a(a3, nVar.g());
        final q qVar2 = qVar;
        final v vVar2 = vVar;
        final b bVar2 = bVar;
        j.a(aVar, b2, c2, new j.a() {
            public void a(com.bytedance.sdk.openadsdk.k.a.b bVar) {
                if (bVar.d()) {
                    l.b("TTAppOpenAdCacheManager", "Image loaded successfully");
                    f.this.c(aZ);
                    long c2 = a2.c();
                    com.bytedance.sdk.openadsdk.component.d.a.a(qVar2, c2, true);
                    v vVar = vVar2;
                    if (vVar != null) {
                        vVar.a(c2);
                        vVar2.a(2);
                    }
                    bVar2.a(bVar);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.d.a.a(qVar2, a2.c(), false);
                bVar2.a();
            }

            public void a() {
                l.b("TTAppOpenAdCacheManager", "Image loading failed");
                com.bytedance.sdk.openadsdk.component.d.a.a(qVar2, a2.c(), false);
                bVar2.a();
            }

            public void b() {
                l.b("TTAppOpenAdCacheManager", "Image caching success");
            }
        }, b3.getParent());
    }

    public void a(int i) {
        com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "video_has_cached" + i, (Boolean) true);
    }

    public boolean b(int i) {
        return com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "video_has_cached" + i, false);
    }

    public void c(int i) {
        com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "image_has_cached" + i, (Boolean) true);
    }

    public boolean d(int i) {
        return com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "image_has_cached" + i, false);
    }

    public void a(com.bytedance.sdk.openadsdk.component.e.a aVar) {
        if (aVar.b() != null) {
            long ag = aVar.b().ag();
            com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "material_expiration_time" + aVar.a(), Long.valueOf(ag));
            b(aVar);
        }
    }

    public q e(int i) {
        long a2 = com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "material_expiration_time" + i, -1);
        q f = f(i);
        if (System.currentTimeMillis() / 1000 < a2 && f != null) {
            return f;
        }
        if (f == null && a2 == -1) {
            return null;
        }
        g(i);
        if (f == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.component.d.a.a(f);
        return null;
    }

    public q f(int i) {
        String str;
        String b2 = com.bytedance.sdk.openadsdk.multipro.d.d.b("tt_openad_materialMeta", "material" + i, (String) null);
        if (!TextUtils.isEmpty(b2)) {
            try {
                str = com.bytedance.sdk.component.utils.a.c(new JSONObject(b2).optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
            } catch (JSONException e2) {
                l.e("TTAppOpenAdCacheManager", e2.getMessage());
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    q a2 = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(str));
                    if (a2 != null) {
                        return a2;
                    }
                } catch (JSONException e3) {
                    l.e("TTAppOpenAdCacheManager", e3.getMessage());
                }
            }
        }
        return null;
    }

    private void b(com.bytedance.sdk.openadsdk.component.e.a aVar) {
        aa.a(new a(aVar), 5);
    }

    public String a(q qVar) {
        if (!(qVar == null || qVar.K() == null || TextUtils.isEmpty(qVar.K().k()))) {
            String k = qVar.K().k();
            String n = qVar.K().n();
            if (TextUtils.isEmpty(n)) {
                n = e.a(k);
            }
            File a2 = com.bytedance.sdk.openadsdk.component.g.a.a(n);
            if (a2.exists() && a2.isFile()) {
                return a2.getAbsolutePath();
            }
        }
        return null;
    }

    public boolean b(q qVar) {
        if (qVar == null || qVar.Q() == null || qVar.Q().size() == 0 || TextUtils.isEmpty(qVar.Q().get(0).a())) {
            return false;
        }
        n nVar = qVar.Q().get(0);
        return a(nVar.a(), nVar.g());
    }

    public boolean a(String str, String str2) {
        boolean z;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = e.a(str);
            }
            File b2 = com.bytedance.sdk.openadsdk.component.g.a.b(str2);
            InputStream a2 = com.bytedance.sdk.openadsdk.f.d.a(str, str2);
            if (a2 != null) {
                try {
                    a2.close();
                } catch (IOException e2) {
                    l.e("TTAppOpenAdCacheManager", e2.getMessage());
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (com.bytedance.sdk.openadsdk.f.d.a(str, str2, b2.getParent())) {
                    return true;
                }
                if (new File(b2.getPath() + ".0").exists()) {
                    return true;
                }
            }
            return z;
        } catch (Exception e3) {
            l.e("TTAppOpenAdCacheManager", e3.getMessage());
            return false;
        }
    }

    public void a(File file) {
        try {
            this.b.a(file);
        } catch (IOException e2) {
            l.c("TTAppOpenAdCacheManager", "trimFileCache fail", e2);
        }
    }

    public void g(int i) {
        com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad_materialMeta", "material" + i);
        com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "material_expiration_time" + i);
        com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "video_has_cached" + i);
        com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "image_has_cached" + i);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(1:26)(4:12|(5:14|15|16|21|17)|20|27)) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000a */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r4 = this;
            java.lang.String r0 = "tt_openad_materialMeta"
            com.bytedance.sdk.openadsdk.multipro.d.d.a(r0)     // Catch:{ all -> 0x000a }
            java.lang.String r0 = "tt_openad"
            com.bytedance.sdk.openadsdk.multipro.d.d.a(r0)     // Catch:{ all -> 0x000a }
        L_0x000a:
            android.content.Context r0 = r4.d     // Catch:{ all -> 0x0035 }
            java.io.File r0 = r0.getCacheDir()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0035
            boolean r1 = r0.exists()     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0035
            boolean r1 = r0.isDirectory()     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0035
            com.bytedance.sdk.openadsdk.component.f$8 r1 = new com.bytedance.sdk.openadsdk.component.f$8     // Catch:{ all -> 0x0035 }
            r1.<init>()     // Catch:{ all -> 0x0035 }
            java.io.File[] r0 = r0.listFiles(r1)     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0035
            int r1 = r0.length     // Catch:{ all -> 0x0035 }
            r2 = 0
        L_0x002b:
            if (r2 >= r1) goto L_0x0035
            r3 = r0[r2]     // Catch:{ all -> 0x0035 }
            com.bytedance.sdk.component.utils.f.c(r3)     // Catch:{ all -> 0x0032 }
        L_0x0032:
            int r2 = r2 + 1
            goto L_0x002b
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.f.a():void");
    }

    public String b() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            return name + "/openad_image_cache/";
        }
        return name + "//openad_image_cache/";
    }

    private int c(AdSlot adSlot) {
        long a2 = com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad", "material_expiration_time" + adSlot.getCodeId(), -1);
        Object[] objArr = new Object[2];
        objArr[0] = "local cache number : ";
        objArr[1] = Integer.valueOf(a2 == -1 ? 0 : 1);
        l.a("TTAppOpenAdCacheManager", objArr);
        if (a2 == -1) {
            return 0;
        }
        return 1;
    }

    /* compiled from: TTAppOpenAdCacheManager */
    private class a extends com.bytedance.sdk.component.g.h {
        private final com.bytedance.sdk.openadsdk.component.e.a b;

        public a(com.bytedance.sdk.openadsdk.component.e.a aVar) {
            super("App Open Ad Write Cache");
            this.b = aVar;
        }

        public void run() {
            try {
                String jSONObject = com.bytedance.sdk.component.utils.a.a(this.b.b().ao()).toString();
                com.bytedance.sdk.openadsdk.multipro.d.d.a("tt_openad_materialMeta", "material" + this.b.a(), jSONObject);
            } catch (Throwable unused) {
            }
        }
    }
}
