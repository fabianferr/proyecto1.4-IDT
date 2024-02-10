package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: FullScreenVideoCache */
class d {
    private static volatile d a;
    private final Context b;
    private final m c;
    private final Map<q, Long> d = Collections.synchronizedMap(new HashMap());

    /* compiled from: FullScreenVideoCache */
    interface a<T> {
        void a(boolean z, T t);
    }

    public void a(String str) {
        this.c.d(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|(1:4)(1:5)|(1:7)(1:8)|9|(1:11)(1:12)|13|(2:19|(3:21|(3:23|24|49)(2:25|(2:27|50)(2:28|48))|29))|31|32|(1:57)(4:40|(5:42|43|44|52|45)|51|58)) */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x008b */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa A[Catch:{ all -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r1 = "sp_full_screen_video"
            boolean r1 = com.bytedance.sdk.openadsdk.core.h.e((java.lang.String) r1)     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x000b
            r1 = 1
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            if (r1 == 0) goto L_0x0011
            java.lang.String r2 = "files"
            goto L_0x0013
        L_0x0011:
            java.lang.String r2 = "shared_prefs"
        L_0x0013:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x008b }
            r4 = 24
            if (r3 < r4) goto L_0x0025
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x008b }
            android.content.Context r5 = r10.b     // Catch:{ all -> 0x008b }
            java.io.File r5 = r5.getDataDir()     // Catch:{ all -> 0x008b }
            r3.<init>(r5, r2)     // Catch:{ all -> 0x008b }
            goto L_0x003b
        L_0x0025:
            android.content.Context r3 = r10.b     // Catch:{ all -> 0x008b }
            java.lang.String r5 = "1"
            java.io.File r3 = r3.getDatabasePath(r5)     // Catch:{ all -> 0x008b }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x008b }
            java.io.File r3 = r3.getParentFile()     // Catch:{ all -> 0x008b }
            java.io.File r3 = r3.getParentFile()     // Catch:{ all -> 0x008b }
            r5.<init>(r3, r2)     // Catch:{ all -> 0x008b }
            r3 = r5
        L_0x003b:
            boolean r2 = r3.exists()     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x008b
            boolean r2 = r3.isDirectory()     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x008b
            com.bytedance.sdk.openadsdk.component.reward.d$1 r2 = new com.bytedance.sdk.openadsdk.component.reward.d$1     // Catch:{ all -> 0x008b }
            r2.<init>()     // Catch:{ all -> 0x008b }
            java.io.File[] r2 = r3.listFiles(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x008b
            int r3 = r2.length     // Catch:{ all -> 0x008b }
            r5 = 0
        L_0x0054:
            if (r5 >= r3) goto L_0x008b
            r6 = r2[r5]     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x005e
            com.bytedance.sdk.component.utils.f.c(r6)     // Catch:{ all -> 0x0088 }
            goto L_0x0088
        L_0x005e:
            java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x0088 }
            java.lang.String r8 = ".xml"
            java.lang.String r9 = ""
            java.lang.String r7 = r7.replace(r8, r9)     // Catch:{ all -> 0x0088 }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0088 }
            if (r8 < r4) goto L_0x0074
            android.content.Context r6 = r10.b     // Catch:{ all -> 0x0088 }
            r6.deleteSharedPreferences(r7)     // Catch:{ all -> 0x0088 }
            goto L_0x0088
        L_0x0074:
            android.content.Context r8 = r10.b     // Catch:{ all -> 0x0088 }
            android.content.SharedPreferences r7 = r8.getSharedPreferences(r7, r0)     // Catch:{ all -> 0x0088 }
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch:{ all -> 0x0088 }
            android.content.SharedPreferences$Editor r7 = r7.clear()     // Catch:{ all -> 0x0088 }
            r7.apply()     // Catch:{ all -> 0x0088 }
            com.bytedance.sdk.component.utils.f.c(r6)     // Catch:{ all -> 0x0088 }
        L_0x0088:
            int r5 = r5 + 1
            goto L_0x0054
        L_0x008b:
            android.content.Context r1 = r10.b     // Catch:{ all -> 0x00b5 }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x00b5
            boolean r2 = r1.exists()     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00b5
            boolean r2 = r1.isDirectory()     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00b5
            com.bytedance.sdk.openadsdk.component.reward.d$2 r2 = new com.bytedance.sdk.openadsdk.component.reward.d$2     // Catch:{ all -> 0x00b5 }
            r2.<init>()     // Catch:{ all -> 0x00b5 }
            java.io.File[] r1 = r1.listFiles(r2)     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x00b5
            int r2 = r1.length     // Catch:{ all -> 0x00b5 }
        L_0x00ab:
            if (r0 >= r2) goto L_0x00b5
            r3 = r1[r0]     // Catch:{ all -> 0x00b5 }
            com.bytedance.sdk.component.utils.f.c(r3)     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            int r0 = r0 + 1
            goto L_0x00ab
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.d.a():void");
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.a aVar) {
        if (aVar != null) {
            try {
                this.c.a(adSlot.getCodeId(), aVar.k().toString());
            } catch (Throwable unused) {
            }
        }
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private d(Context context) {
        this.b = context == null ? o.a() : context.getApplicationContext();
        this.c = new m("sp_full_screen_video");
    }

    public String a(q qVar) {
        if (qVar == null || qVar.K() == null || TextUtils.isEmpty(qVar.K().k())) {
            return null;
        }
        return a(qVar.K().k(), qVar.K().n(), qVar.aK());
    }

    public String a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = e.a(str);
        }
        File a2 = a(str2, i);
        if (a2 == null || !a2.exists() || !a2.isFile() || a2.length() <= 0) {
            return null;
        }
        return a2.getAbsolutePath();
    }

    public com.bytedance.sdk.openadsdk.core.model.a b(String str) {
        com.bytedance.sdk.openadsdk.core.model.a aVar;
        long b2 = this.c.b(str);
        boolean c2 = this.c.c(str);
        if ((System.currentTimeMillis() - b2 < 10500000) && !c2) {
            try {
                String a2 = this.c.a(str);
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (jSONObject.has("creatives")) {
                        aVar = com.bytedance.sdk.openadsdk.core.model.a.b(jSONObject);
                    } else {
                        q a3 = b.a(jSONObject);
                        com.bytedance.sdk.openadsdk.core.model.a aVar2 = new com.bytedance.sdk.openadsdk.core.model.a();
                        aVar2.a(a3);
                        aVar = aVar2;
                    }
                    if (aVar != null) {
                        if (aVar.d()) {
                            Iterator<q> it = aVar.c().iterator();
                            while (it.hasNext()) {
                                if (!b(it.next())) {
                                    it.remove();
                                }
                            }
                            if (aVar.d()) {
                                return aVar;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private boolean b(q qVar) {
        if (qVar == null) {
            return false;
        }
        if (t.k(qVar)) {
            return true;
        }
        com.bykv.vk.openvk.component.video.api.c.b K = qVar.K();
        if (K == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return !TextUtils.isEmpty(a(K.k(), K.n(), qVar.aK()));
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(boolean z, q qVar, long j, String str) {
        long j2;
        Long remove = this.d.remove(qVar);
        if (remove == null) {
            j2 = 0;
        } else {
            j2 = SystemClock.elapsedRealtime() - remove.longValue();
        }
        String str2 = z ? "load_video_success" : "load_video_error";
        if (z || str == null) {
            str = null;
        }
        c.b(qVar, "fullscreen_interstitial_ad", str2, ac.a(z, qVar, j2, j, str));
    }

    public void a(final q qVar, final a<Object> aVar) {
        this.d.put(qVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (qVar.K() == null || TextUtils.isEmpty(qVar.K().k())) {
            if (aVar != null) {
                aVar.a(false, null);
            }
            a(false, qVar, -1, (String) null);
            return;
        }
        String k = qVar.K().k();
        File a2 = a(qVar.K().n(), qVar.aK());
        com.bytedance.sdk.component.f.b.a d2 = com.bytedance.sdk.openadsdk.k.c.a().b().d();
        d2.a(k);
        d2.a(a2.getParent(), a2.getName());
        d2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
            public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                if (!bVar.f() || bVar.e() == null || !bVar.e().exists()) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(false, null);
                    }
                    l.c("FullScreenVideoCache", "onResponse: FullScreenVideo preload Fail ");
                    d.this.a(false, qVar, (long) bVar.a(), bVar.b());
                    return;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(true, null);
                }
                l.c("FullScreenVideoCache", "onResponse: FullScreenVideo preload success ");
                d.this.a(true, qVar, (long) bVar.a(), bVar.b());
            }

            public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(false, null);
                }
                l.c("FullScreenVideoCache", "onFailure: FullScreenVideo preload fail ");
                d.this.a(false, qVar, -2, iOException.getMessage());
            }
        });
    }

    private File a(String str, int i) {
        return new File(CacheDirFactory.getICacheDir(i).a(), str);
    }
}
