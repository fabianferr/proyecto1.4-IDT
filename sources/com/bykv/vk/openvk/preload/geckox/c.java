package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.a.a.a;
import com.bykv.vk.openvk.preload.geckox.b;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.bykv.vk.openvk.preload.geckox.utils.f;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: GeckoHubUtil */
public final class c {
    private static File a;
    private static Context b;
    private static String c;
    private static final Set<String> f = new HashSet(Arrays.asList(new String[]{"js", "css", "html", "ico", "jpeg", "jpg", "png", "gif", "woff", "svg", "ttf", "woff2", "webp", "otf", "sfnt"}));
    private Map.Entry<String, JSONObject> d;
    private Map.Entry<String, JSONObject> e;

    /* compiled from: GeckoHubUtil */
    static class a {
        /* access modifiers changed from: private */
        public static c a = new c((byte) 0);
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static c a(Context context) {
        b = context;
        if (a == null) {
            a = new File(b.getCacheDir() + File.separator + "gecko");
        }
        return a.a;
    }

    public static c a() {
        return a.a;
    }

    private c() {
    }

    public static void a(String str) {
        c = str;
    }

    public static void a(String str, IStatisticMonitor iStatisticMonitor, Set<String> set, INetWork iNetWork) {
        if (!TextUtils.isEmpty(str)) {
            b.a aVar = new b.a(b);
            aVar.b = Arrays.asList(new String[]{"cca47107bfcbdb211d88f3385aeede40"});
            aVar.c = Arrays.asList(new String[]{"cca47107bfcbdb211d88f3385aeede40"});
            aVar.k = 38L;
            aVar.m = str;
            aVar.l = "9999999.0.0";
            a.C0040a aVar2 = new a.C0040a();
            aVar2.a = 20;
            com.bykv.vk.openvk.preload.geckox.a.a.b bVar = com.bykv.vk.openvk.preload.geckox.a.a.b.c;
            if (bVar == null) {
                bVar = com.bykv.vk.openvk.preload.geckox.a.a.b.a;
            }
            aVar2.b = bVar;
            aVar.j = new com.bykv.vk.openvk.preload.geckox.a.a.a(aVar2, (byte) 0);
            aVar.o = a;
            aVar.i = false;
            aVar.n = c;
            aVar.f = b.a();
            aVar.e = b.a();
            aVar.h = iStatisticMonitor;
            aVar.a = iNetWork;
            b bVar2 = new b(aVar, (byte) 0);
            List<String> list = bVar2.g;
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("access key empty");
            }
            Context context = bVar2.a;
            if (context != null) {
                f.a = context;
            }
            a aVar3 = new a(bVar2);
            HashMap hashMap = new HashMap();
            LinkedList linkedList = new LinkedList();
            for (String targetChannel : set) {
                linkedList.add(new CheckRequestBodyModel.TargetChannel(targetChannel));
            }
            hashMap.put("cca47107bfcbdb211d88f3385aeede40", linkedList);
            if (TextUtils.isEmpty("default")) {
                throw new IllegalArgumentException("groupType == null");
            } else if (!aVar3.a()) {
                throw new IllegalArgumentException("deployments keys not in local keys");
            } else if (aVar3.a(hashMap)) {
                aVar3.c.c.execute(new Runnable("default", hashMap) {
                    final /* synthetic */ String a;
                    final /* synthetic */ com.bykv.vk.openvk.preload.geckox.e.a b = null;
                    final /* synthetic */ Map c = null;
                    final /* synthetic */ Map d;

                    {
                        this.a = r2;
                        this.d = r3;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:75:0x0648  */
                    /* JADX WARNING: Removed duplicated region for block: B:85:0x069a A[Catch:{ all -> 0x069f }] */
                    /* JADX WARNING: Removed duplicated region for block: B:89:0x06a5  */
                    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r23 = this;
                            r1 = r23
                            java.lang.String r2 = "full"
                            java.lang.String r3 = "patch"
                            java.lang.String r4 = "all channel update finished"
                            java.lang.String r5 = "download_gecko_end"
                            r6 = 2
                            java.lang.Object[] r7 = new java.lang.Object[r6]
                            java.lang.String r8 = "start check update..."
                            r9 = 0
                            r7[r9] = r8
                            java.lang.String r8 = r1.a
                            r10 = 1
                            r7[r10] = r8
                            java.lang.String r8 = "gecko-debug-tag"
                            com.bykv.vk.openvk.preload.geckox.h.b.a(r8, r7)
                            com.bykv.vk.openvk.preload.geckox.a r7 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r7 = r7.c
                            com.bykv.vk.openvk.preload.geckox.a.a.a r7 = r7.i
                            if (r7 == 0) goto L_0x0042
                            com.bykv.vk.openvk.preload.geckox.a r7 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r7 = r7.c
                            com.bykv.vk.openvk.preload.geckox.a.a.a r7 = r7.i
                            com.bykv.vk.openvk.preload.geckox.a.a.b r7 = r7.b
                            com.bykv.vk.openvk.preload.geckox.a r12 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r12 = r12.c
                            com.bykv.vk.openvk.preload.geckox.a.a.a r12 = r12.i
                            com.bykv.vk.openvk.preload.geckox.a r13 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r13 = r13.c
                            java.io.File r13 = r13.p
                            com.bykv.vk.openvk.preload.geckox.a r14 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r14 = r14.c
                            java.util.List<java.lang.String> r14 = r14.g
                            r7.a(r12, r13, r14)
                            goto L_0x0043
                        L_0x0042:
                            r7 = 0
                        L_0x0043:
                            com.bykv.vk.openvk.preload.geckox.a r12 = com.bykv.vk.openvk.preload.geckox.a.this     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            com.bykv.vk.openvk.preload.geckox.b r12 = r12.c     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            r13.<init>()     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            r12.r = r13     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            com.bykv.vk.openvk.preload.geckox.e.a r12 = r1.b     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            com.bykv.vk.openvk.preload.geckox.a r13 = com.bykv.vk.openvk.preload.geckox.a.this     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            java.io.File r13 = r13.d     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            com.bykv.vk.openvk.preload.geckox.a r14 = com.bykv.vk.openvk.preload.geckox.a.this     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            com.bykv.vk.openvk.preload.geckox.b r14 = r14.c     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            com.bykv.vk.openvk.preload.geckox.a r15 = com.bykv.vk.openvk.preload.geckox.a.this     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            com.bykv.vk.openvk.preload.geckox.e.b r15 = r15.a     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            java.util.Map r11 = r1.c     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            java.util.Map r10 = r1.d     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            java.lang.String r9 = r1.a     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            r6.<init>()     // Catch:{ Exception -> 0x0619, all -> 0x060f }
                            r18 = r4
                            com.bykv.vk.openvk.preload.b.h$a r4 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x060c, all -> 0x0609 }
                            r4.<init>()     // Catch:{ Exception -> 0x060c, all -> 0x0609 }
                            r19 = r5
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.e> r5 = com.bykv.vk.openvk.preload.geckox.d.e.class
                            com.bykv.vk.openvk.preload.b.h$a r4 = r4.a(r5)     // Catch:{ Exception -> 0x0601, all -> 0x05f9 }
                            r20 = r7
                            r5 = 2
                            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r5 = 0
                            r7[r5] = r13     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            java.util.List<java.lang.String> r5 = r14.h     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r16 = 1
                            r7[r16] = r5     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.c = r7     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.e> r5 = com.bykv.vk.openvk.preload.geckox.d.e.class
                            com.bykv.vk.openvk.preload.b.b.a r5 = r15.a(r5)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.b = r5     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.h r4 = r4.a()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r6.add(r4)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.h$a r4 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.<init>()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.c> r5 = com.bykv.vk.openvk.preload.geckox.d.c.class
                            com.bykv.vk.openvk.preload.b.h$a r4 = r4.a(r5)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r5 = 5
                            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r7 = 0
                            r5[r7] = r14     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r7 = 1
                            r5[r7] = r11     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r7 = 2
                            r5[r7] = r10     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r7 = 3
                            r5[r7] = r12     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r7 = 4
                            r5[r7] = r9     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.c = r5     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.b.b r5 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r7 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r9 = new com.bykv.vk.openvk.preload.b.b.a[r7]     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.geckox.i.a$6 r7 = new com.bykv.vk.openvk.preload.geckox.i.a$6     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r7.<init>(r12, r14)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r10 = 0
                            r9[r10] = r7     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.c> r7 = com.bykv.vk.openvk.preload.geckox.d.c.class
                            com.bykv.vk.openvk.preload.b.b.a r7 = r15.a(r7)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r10 = 1
                            r9[r10] = r7     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r5.<init>(r9)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.b = r5     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.h r4 = r4.a()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r6.add(r4)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.h$a r4 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.<init>()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.f> r5 = com.bykv.vk.openvk.preload.geckox.d.f.class
                            com.bykv.vk.openvk.preload.b.h$a r4 = r4.a(r5)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r5 = 1
                            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            java.util.concurrent.Executor r5 = r14.b     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r9 = 0
                            r7[r9] = r5     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.c = r7     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.geckox.i.a$1 r5 = new com.bykv.vk.openvk.preload.geckox.i.a$1     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r5.<init>(r12, r14)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.b = r5     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.h r4 = r4.a()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r6.add(r4)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.l$b r4 = new com.bykv.vk.openvk.preload.b.l$b     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r4.<init>()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            java.lang.String r5 = "branch_zip"
                            com.bykv.vk.openvk.preload.b.l$a r5 = r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.l$b r7 = new com.bykv.vk.openvk.preload.b.l$b     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r7.<init>()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.l$a r9 = r7.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r10.<init>()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            com.bykv.vk.openvk.preload.b.h$a r11 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r11.<init>()     // Catch:{ Exception -> 0x05f6, all -> 0x05f3 }
                            r21 = r8
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.h> r8 = com.bykv.vk.openvk.preload.geckox.d.h.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r11.a(r8)     // Catch:{ Exception -> 0x05ec, all -> 0x05e5 }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05ec, all -> 0x05e5 }
                            r10.add(r8)     // Catch:{ Exception -> 0x05ec, all -> 0x05e5 }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05ec, all -> 0x05e5 }
                            r8.<init>()     // Catch:{ Exception -> 0x05ec, all -> 0x05e5 }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.c> r11 = com.bykv.vk.openvk.preload.geckox.d.b.b.c.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r11)     // Catch:{ Exception -> 0x05ec, all -> 0x05e5 }
                            r11 = 2
                            java.lang.Object[] r1 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r1[r17] = r14     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r1[r16] = r13     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.c = r1     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r1 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r22 = r6
                            com.bykv.vk.openvk.preload.b.b.a[] r6 = new com.bykv.vk.openvk.preload.b.b.a[r11]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r11 = com.bykv.vk.openvk.preload.geckox.i.a.b(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r6[r17] = r11     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.c> r11 = com.bykv.vk.openvk.preload.geckox.d.b.b.c.class
                            com.bykv.vk.openvk.preload.b.b.a r11 = r15.a(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r6[r16] = r11     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.<init>(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r1     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r1 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.add(r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r1 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.b> r6 = com.bykv.vk.openvk.preload.geckox.d.b.b.b.class
                            com.bykv.vk.openvk.preload.b.h$a r1 = r1.a(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r6 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r8]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r8 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.b> r8 = com.bykv.vk.openvk.preload.geckox.d.b.b.b.class
                            com.bykv.vk.openvk.preload.b.b.a r8 = r15.a(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.b = r6     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r1 = r1.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.add(r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r1 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.d> r6 = com.bykv.vk.openvk.preload.geckox.d.b.b.d.class
                            com.bykv.vk.openvk.preload.b.h$a r1 = r1.a(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6 = 1
                            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6 = 0
                            r8[r6] = r14     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.c = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r8 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r11 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r6 = new com.bykv.vk.openvk.preload.b.b.a[r11]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r11 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r6[r17] = r11     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.d> r11 = com.bykv.vk.openvk.preload.geckox.d.b.b.d.class
                            com.bykv.vk.openvk.preload.b.b.a r11 = r15.a(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r6[r16] = r11     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.b = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r1 = r1.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.add(r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r1 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.a> r6 = com.bykv.vk.openvk.preload.geckox.d.b.b.a.class
                            com.bykv.vk.openvk.preload.b.h$a r1 = r1.a(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r6 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r8]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r8 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.a> r8 = com.bykv.vk.openvk.preload.geckox.d.b.b.a.class
                            com.bykv.vk.openvk.preload.b.b.a r8 = r15.a(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.b = r6     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r1 = r1.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.add(r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r1 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.f> r6 = com.bykv.vk.openvk.preload.geckox.d.b.b.f.class
                            com.bykv.vk.openvk.preload.b.h$a r1 = r1.a(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r6 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r8]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r8 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.f> r8 = com.bykv.vk.openvk.preload.geckox.d.b.b.f.class
                            com.bykv.vk.openvk.preload.b.b.a r8 = r15.a(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.b = r6     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r1 = r1.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.add(r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r1 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.b.e> r6 = com.bykv.vk.openvk.preload.geckox.d.b.b.e.class
                            com.bykv.vk.openvk.preload.b.h$a r1 = r1.a(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r6 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8 = 1
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r8]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r8 = com.bykv.vk.openvk.preload.geckox.i.a.a((com.bykv.vk.openvk.preload.geckox.e.a) r12)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r8     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.b = r6     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r1 = r1.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.add(r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.a((java.util.List<com.bykv.vk.openvk.preload.b.h>) r10)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$a r1 = r7.a((java.lang.String) r2)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.g> r9 = com.bykv.vk.openvk.preload.geckox.d.g.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.a.b> r9 = com.bykv.vk.openvk.preload.geckox.d.b.a.b.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9 = 2
                            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r11 = 0
                            r10[r11] = r14     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r11 = 1
                            r10[r11] = r13     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.c = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r10 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r9]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r9 = com.bykv.vk.openvk.preload.geckox.i.a.b(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.a.b> r9 = com.bykv.vk.openvk.preload.geckox.d.b.a.b.class
                            com.bykv.vk.openvk.preload.b.b.a r9 = r15.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.a.a> r9 = com.bykv.vk.openvk.preload.geckox.d.b.a.a.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r9 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r10]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r10 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.a.a> r10 = com.bykv.vk.openvk.preload.geckox.d.b.a.a.class
                            com.bykv.vk.openvk.preload.b.b.a r10 = r15.a(r10)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.a.d> r9 = com.bykv.vk.openvk.preload.geckox.d.b.a.d.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r9 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r10]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r10 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.a.d> r10 = com.bykv.vk.openvk.preload.geckox.d.b.a.d.class
                            com.bykv.vk.openvk.preload.b.b.a r10 = r15.a(r10)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b.a.c> r9 = com.bykv.vk.openvk.preload.geckox.d.b.a.c.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r9 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10 = 1
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r10]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r10 = com.bykv.vk.openvk.preload.geckox.i.a.a((com.bykv.vk.openvk.preload.geckox.e.a) r12)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.a((java.util.List<com.bykv.vk.openvk.preload.b.h>) r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b> r1 = com.bykv.vk.openvk.preload.geckox.d.b.class
                            com.bykv.vk.openvk.preload.b.h r1 = r7.a((java.lang.Class<? extends com.bykv.vk.openvk.preload.b.l>) r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$a r1 = r5.a((com.bykv.vk.openvk.preload.b.h) r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r5 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r5.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.b.f> r6 = com.bykv.vk.openvk.preload.b.f.class
                            com.bykv.vk.openvk.preload.b.h$a r5 = r5.a(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r6 = com.bykv.vk.openvk.preload.geckox.i.a.a((com.bykv.vk.openvk.preload.geckox.b) r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r5.b = r6     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r5 = r5.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.a((com.bykv.vk.openvk.preload.b.h) r5)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.String r1 = "branch_single_file"
                            com.bykv.vk.openvk.preload.b.l$a r1 = r4.a((java.lang.String) r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$b r5 = new com.bykv.vk.openvk.preload.b.l$b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r5.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$a r6 = r5.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.h> r9 = com.bykv.vk.openvk.preload.geckox.d.h.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.c> r9 = com.bykv.vk.openvk.preload.geckox.d.a.b.c.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9 = 2
                            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r11 = 0
                            r10[r11] = r14     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r11 = 1
                            r10[r11] = r13     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.c = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r10 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r9]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r9 = com.bykv.vk.openvk.preload.geckox.i.a.b(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.c> r9 = com.bykv.vk.openvk.preload.geckox.d.a.b.c.class
                            com.bykv.vk.openvk.preload.b.b.a r9 = r15.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.b> r9 = com.bykv.vk.openvk.preload.geckox.d.a.b.b.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r9 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r10]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r10 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.b> r10 = com.bykv.vk.openvk.preload.geckox.d.a.b.b.class
                            com.bykv.vk.openvk.preload.b.b.a r10 = r15.a(r10)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.d> r9 = com.bykv.vk.openvk.preload.geckox.d.a.b.d.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9 = 1
                            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9 = 0
                            r10[r9] = r14     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.c = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r10 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r11 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r9 = new com.bykv.vk.openvk.preload.b.b.a[r11]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r11 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r9[r17] = r11     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.d> r11 = com.bykv.vk.openvk.preload.geckox.d.a.b.d.class
                            com.bykv.vk.openvk.preload.b.b.a r11 = r15.a(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r9[r16] = r11     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.<init>(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.a> r9 = com.bykv.vk.openvk.preload.geckox.d.a.b.a.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r9 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r10]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r10 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.a> r10 = com.bykv.vk.openvk.preload.geckox.d.a.b.a.class
                            com.bykv.vk.openvk.preload.b.b.a r10 = r15.a(r10)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.e> r9 = com.bykv.vk.openvk.preload.geckox.d.a.b.e.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r9 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r10]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r10 = com.bykv.vk.openvk.preload.geckox.i.a.a((com.bykv.vk.openvk.preload.geckox.e.a) r12)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r17 = 0
                            r11[r17] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.b.e> r10 = com.bykv.vk.openvk.preload.geckox.d.a.b.e.class
                            com.bykv.vk.openvk.preload.b.b.a r10 = r15.a(r10)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r16 = 1
                            r11[r16] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.a((java.util.List<com.bykv.vk.openvk.preload.b.h>) r7)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$a r6 = r5.a((java.lang.String) r2)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.g> r9 = com.bykv.vk.openvk.preload.geckox.d.g.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.a.b> r9 = com.bykv.vk.openvk.preload.geckox.d.a.a.b.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9 = 2
                            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r11 = 0
                            r10[r11] = r14     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r11 = 1
                            r10[r11] = r13     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.c = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r10 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r9]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r9 = com.bykv.vk.openvk.preload.geckox.i.a.b(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r13 = 0
                            r11[r13] = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.a.b> r9 = com.bykv.vk.openvk.preload.geckox.d.a.a.b.class
                            com.bykv.vk.openvk.preload.b.b.a r9 = r15.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r13 = 1
                            r11[r13] = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.a.a> r9 = com.bykv.vk.openvk.preload.geckox.d.a.a.a.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r9 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r10]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r10 = com.bykv.vk.openvk.preload.geckox.i.a.a(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r13 = 0
                            r11[r13] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.a.a> r10 = com.bykv.vk.openvk.preload.geckox.d.a.a.a.class
                            com.bykv.vk.openvk.preload.b.b.a r10 = r15.a(r10)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r13 = 1
                            r11[r13] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r8 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.a.c> r9 = com.bykv.vk.openvk.preload.geckox.d.a.a.c.class
                            com.bykv.vk.openvk.preload.b.h$a r8 = r8.a(r9)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.b r9 = new com.bykv.vk.openvk.preload.b.b.b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r10 = 2
                            com.bykv.vk.openvk.preload.b.b.a[] r11 = new com.bykv.vk.openvk.preload.b.b.a[r10]     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r10 = com.bykv.vk.openvk.preload.geckox.i.a.a((com.bykv.vk.openvk.preload.geckox.e.a) r12)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r13 = 0
                            r11[r13] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a.a.c> r10 = com.bykv.vk.openvk.preload.geckox.d.a.a.c.class
                            com.bykv.vk.openvk.preload.b.b.a r10 = r15.a(r10)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r13 = 1
                            r11[r13] = r10     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r9.<init>(r11)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r8.b = r9     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r8 = r8.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r7.add(r8)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r6.a((java.util.List<com.bykv.vk.openvk.preload.b.h>) r7)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b> r6 = com.bykv.vk.openvk.preload.geckox.d.b.class
                            com.bykv.vk.openvk.preload.b.h r5 = r5.a((java.lang.Class<? extends com.bykv.vk.openvk.preload.b.l>) r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$a r1 = r1.a((com.bykv.vk.openvk.preload.b.h) r5)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r5 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r5.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.b.f> r6 = com.bykv.vk.openvk.preload.b.f.class
                            com.bykv.vk.openvk.preload.b.h$a r5 = r5.a(r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r6 = com.bykv.vk.openvk.preload.geckox.i.a.a((com.bykv.vk.openvk.preload.geckox.b) r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r5.b = r6     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r5 = r5.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.a((com.bykv.vk.openvk.preload.b.h) r5)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.String r1 = "branch_myarchive_file"
                            com.bykv.vk.openvk.preload.b.l$a r1 = r4.a((java.lang.String) r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$b r5 = new com.bykv.vk.openvk.preload.b.l$b     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r5.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$a r3 = r5.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.util.List r6 = java.util.Collections.emptyList()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r3.a((java.util.List<com.bykv.vk.openvk.preload.b.h>) r6)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$a r2 = r5.a((java.lang.String) r2)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r2.a((java.util.List<com.bykv.vk.openvk.preload.b.h>) r3)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.b> r2 = com.bykv.vk.openvk.preload.geckox.d.b.class
                            com.bykv.vk.openvk.preload.b.h r2 = r5.a((java.lang.Class<? extends com.bykv.vk.openvk.preload.b.l>) r2)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.l$a r1 = r1.a((com.bykv.vk.openvk.preload.b.h) r2)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r2 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r2.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.b.f> r3 = com.bykv.vk.openvk.preload.b.f.class
                            com.bykv.vk.openvk.preload.b.h$a r2 = r2.a(r3)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.b.a r3 = com.bykv.vk.openvk.preload.geckox.i.a.a((com.bykv.vk.openvk.preload.geckox.b) r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r2.b = r3     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r2 = r2.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.a((com.bykv.vk.openvk.preload.b.h) r2)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.a> r1 = com.bykv.vk.openvk.preload.geckox.d.a.class
                            com.bykv.vk.openvk.preload.b.h r1 = r4.a((java.lang.Class<? extends com.bykv.vk.openvk.preload.b.l>) r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r2 = r22
                            r2.add(r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h$a r1 = new com.bykv.vk.openvk.preload.b.h$a     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.<init>()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            java.lang.Class<com.bykv.vk.openvk.preload.geckox.d.i> r3 = com.bykv.vk.openvk.preload.geckox.d.i.class
                            com.bykv.vk.openvk.preload.b.h$a r1 = r1.a(r3)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.geckox.i.a$2 r3 = new com.bykv.vk.openvk.preload.geckox.i.a$2     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r3.<init>(r12, r14)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1.b = r3     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            com.bykv.vk.openvk.preload.b.h r1 = r1.a()     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r2.add(r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r1 = 0
                            com.bykv.vk.openvk.preload.b.b r1 = com.bykv.vk.openvk.preload.b.c.a(r2, r1, r1)     // Catch:{ Exception -> 0x05e1, all -> 0x05dd }
                            r2 = r23
                            java.lang.String r3 = r2.a     // Catch:{ Exception -> 0x05db, all -> 0x05d9 }
                            java.lang.Object r1 = r1.a(r3)     // Catch:{ Exception -> 0x05db, all -> 0x05d9 }
                            r3 = 2
                            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x05db, all -> 0x05d9 }
                            java.lang.String r3 = "update finished"
                            r5 = 0
                            r4[r5] = r3     // Catch:{ Exception -> 0x05db, all -> 0x05d9 }
                            r3 = 1
                            r4[r3] = r1     // Catch:{ Exception -> 0x05db, all -> 0x05d9 }
                            r1 = r21
                            com.bykv.vk.openvk.preload.geckox.h.b.a(r1, r4)     // Catch:{ Exception -> 0x05d7, all -> 0x05d5 }
                            if (r20 == 0) goto L_0x05b9
                            r20.a()
                        L_0x05b9:
                            com.bykv.vk.openvk.preload.geckox.a r3 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r3 = r3.c
                            com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor r3 = r3.e
                            com.bykv.vk.openvk.preload.geckox.a r4 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r4 = r4.c
                            org.json.JSONObject r4 = r4.r
                            r5 = r19
                            r3.upload(r5, r4)
                            r3 = 1
                            java.lang.Object[] r3 = new java.lang.Object[r3]
                            r4 = 0
                            r3[r4] = r18
                            com.bykv.vk.openvk.preload.geckox.h.b.a(r1, r3)
                            goto L_0x0663
                        L_0x05d5:
                            r0 = move-exception
                            goto L_0x05fe
                        L_0x05d7:
                            r0 = move-exception
                            goto L_0x0606
                        L_0x05d9:
                            r0 = move-exception
                            goto L_0x05e7
                        L_0x05db:
                            r0 = move-exception
                            goto L_0x05ee
                        L_0x05dd:
                            r0 = move-exception
                            r2 = r23
                            goto L_0x05e7
                        L_0x05e1:
                            r0 = move-exception
                            r2 = r23
                            goto L_0x05ee
                        L_0x05e5:
                            r0 = move-exception
                            r2 = r1
                        L_0x05e7:
                            r5 = r19
                            r1 = r21
                            goto L_0x0616
                        L_0x05ec:
                            r0 = move-exception
                            r2 = r1
                        L_0x05ee:
                            r5 = r19
                            r1 = r21
                            goto L_0x0620
                        L_0x05f3:
                            r0 = move-exception
                            r2 = r1
                            goto L_0x05fd
                        L_0x05f6:
                            r0 = move-exception
                            r2 = r1
                            goto L_0x0605
                        L_0x05f9:
                            r0 = move-exception
                            r2 = r1
                            r20 = r7
                        L_0x05fd:
                            r1 = r8
                        L_0x05fe:
                            r5 = r19
                            goto L_0x0616
                        L_0x0601:
                            r0 = move-exception
                            r2 = r1
                            r20 = r7
                        L_0x0605:
                            r1 = r8
                        L_0x0606:
                            r5 = r19
                            goto L_0x0620
                        L_0x0609:
                            r0 = move-exception
                            r2 = r1
                            goto L_0x0613
                        L_0x060c:
                            r0 = move-exception
                            r2 = r1
                            goto L_0x061d
                        L_0x060f:
                            r0 = move-exception
                            r2 = r1
                            r18 = r4
                        L_0x0613:
                            r20 = r7
                            r1 = r8
                        L_0x0616:
                            r3 = r0
                            goto L_0x06a3
                        L_0x0619:
                            r0 = move-exception
                            r2 = r1
                            r18 = r4
                        L_0x061d:
                            r20 = r7
                            r1 = r8
                        L_0x0620:
                            r3 = r0
                            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0641 }
                            r4.<init>()     // Catch:{ all -> 0x0641 }
                            java.lang.String r6 = "success"
                            r7 = 0
                            r4.put(r6, r7)     // Catch:{ all -> 0x0641 }
                            java.lang.String r6 = "msg"
                            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0641 }
                            r4.put(r6, r7)     // Catch:{ all -> 0x0641 }
                            java.lang.String r6 = "code"
                            r7 = 2
                            r4.put(r6, r7)     // Catch:{ all -> 0x0641 }
                            com.bykv.vk.openvk.preload.geckox.a r6 = com.bykv.vk.openvk.preload.geckox.a.this     // Catch:{ all -> 0x0641 }
                            com.bykv.vk.openvk.preload.geckox.b r6 = r6.c     // Catch:{ all -> 0x0641 }
                            r6.r = r4     // Catch:{ all -> 0x0641 }
                        L_0x0641:
                            java.lang.String r4 = "Gecko update failed:"
                            com.bykv.vk.openvk.preload.geckox.h.b.a(r1, r4, r3)     // Catch:{ all -> 0x06a0 }
                            if (r20 == 0) goto L_0x064b
                            r20.a()
                        L_0x064b:
                            com.bykv.vk.openvk.preload.geckox.a r3 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r3 = r3.c
                            com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor r3 = r3.e
                            com.bykv.vk.openvk.preload.geckox.a r4 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r4 = r4.c
                            org.json.JSONObject r4 = r4.r
                            r3.upload(r5, r4)
                            r3 = 1
                            java.lang.Object[] r3 = new java.lang.Object[r3]
                            r4 = 0
                            r3[r4] = r18
                            com.bykv.vk.openvk.preload.geckox.h.b.a(r1, r3)
                        L_0x0663:
                            com.bykv.vk.openvk.preload.geckox.a r1 = com.bykv.vk.openvk.preload.geckox.a.this
                            java.util.ArrayList r3 = new java.util.ArrayList
                            r3.<init>()
                            com.bykv.vk.openvk.preload.geckox.b r4 = r1.c
                            java.util.List<java.lang.String> r4 = r4.g
                            r3.addAll(r4)
                            com.bykv.vk.openvk.preload.geckox.j.a.a r4 = new com.bykv.vk.openvk.preload.geckox.j.a.a
                            r4.<init>(r3)
                            com.bykv.vk.openvk.preload.geckox.c.b r3 = com.bykv.vk.openvk.preload.geckox.c.b.a()     // Catch:{ all -> 0x069f }
                            com.bykv.vk.openvk.preload.a.f r3 = r3.a     // Catch:{ all -> 0x069f }
                            java.lang.String r3 = r3.a((java.lang.Object) r4)     // Catch:{ all -> 0x069f }
                            com.bykv.vk.openvk.preload.geckox.b r4 = r1.c     // Catch:{ all -> 0x069f }
                            com.bykv.vk.openvk.preload.geckox.j.a r4 = r4.d     // Catch:{ all -> 0x069f }
                            if (r4 == 0) goto L_0x0690
                            com.bykv.vk.openvk.preload.geckox.b r4 = r1.c     // Catch:{ all -> 0x069f }
                            com.bykv.vk.openvk.preload.geckox.j.a r4 = r4.d     // Catch:{ all -> 0x069f }
                            boolean r4 = r4.a()     // Catch:{ all -> 0x069f }
                            if (r4 != 0) goto L_0x069f
                        L_0x0690:
                            java.util.Queue<java.lang.String> r4 = r1.b     // Catch:{ all -> 0x069f }
                            int r4 = r4.size()     // Catch:{ all -> 0x069f }
                            r5 = 10
                            if (r4 >= r5) goto L_0x069f
                            java.util.Queue<java.lang.String> r1 = r1.b     // Catch:{ all -> 0x069f }
                            r1.add(r3)     // Catch:{ all -> 0x069f }
                        L_0x069f:
                            return
                        L_0x06a0:
                            r0 = move-exception
                            goto L_0x0616
                        L_0x06a3:
                            if (r20 == 0) goto L_0x06a8
                            r20.a()
                        L_0x06a8:
                            com.bykv.vk.openvk.preload.geckox.a r4 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r4 = r4.c
                            com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor r4 = r4.e
                            com.bykv.vk.openvk.preload.geckox.a r6 = com.bykv.vk.openvk.preload.geckox.a.this
                            com.bykv.vk.openvk.preload.geckox.b r6 = r6.c
                            org.json.JSONObject r6 = r6.r
                            r4.upload(r5, r6)
                            r4 = 1
                            java.lang.Object[] r4 = new java.lang.Object[r4]
                            r5 = 0
                            r4[r5] = r18
                            com.bykv.vk.openvk.preload.geckox.h.b.a(r1, r4)
                            goto L_0x06c2
                        L_0x06c1:
                            throw r3
                        L_0x06c2:
                            goto L_0x06c1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.a.AnonymousClass1.run():void");
                    }
                });
            } else {
                throw new IllegalArgumentException("target keys not in deployments keys");
            }
        }
    }

    private static String b(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r6.equals(r1.getKey()) == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x00ca
            if (r7 != 0) goto L_0x0007
            goto L_0x00ca
        L_0x0007:
            java.util.Map$Entry<java.lang.String, org.json.JSONObject> r1 = r5.d     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = "cca47107bfcbdb211d88f3385aeede40"
            if (r1 == 0) goto L_0x0017
            java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x00ca }
            boolean r1 = r6.equals(r1)     // Catch:{ all -> 0x00ca }
            if (r1 != 0) goto L_0x004c
        L_0x0017:
            com.bykv.vk.openvk.preload.falconx.loader.a r1 = new com.bykv.vk.openvk.preload.falconx.loader.a     // Catch:{ all -> 0x00ca }
            android.content.Context r3 = b     // Catch:{ all -> 0x00ca }
            java.io.File r4 = a     // Catch:{ all -> 0x00ca }
            r1.<init>(r3, r2, r4)     // Catch:{ all -> 0x00ca }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r3.<init>()     // Catch:{ all -> 0x00ca }
            r3.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r4 = "/manifest.json"
            r3.append(r4)     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ca }
            java.io.InputStream r1 = r1.getInputStream(r3)     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = com.bykv.vk.openvk.preload.geckox.utils.c.a((java.io.InputStream) r1)     // Catch:{ all -> 0x00ca }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00ca }
            if (r3 == 0) goto L_0x0040
            return r0
        L_0x0040:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x00ca }
            r3.<init>(r1)     // Catch:{ all -> 0x00ca }
            java.util.AbstractMap$SimpleEntry r1 = new java.util.AbstractMap$SimpleEntry     // Catch:{ all -> 0x00ca }
            r1.<init>(r6, r3)     // Catch:{ all -> 0x00ca }
            r5.d = r1     // Catch:{ all -> 0x00ca }
        L_0x004c:
            java.util.Map$Entry<java.lang.String, org.json.JSONObject> r1 = r5.e     // Catch:{ all -> 0x00ca }
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x00ca }
            boolean r1 = r6.equals(r1)     // Catch:{ all -> 0x00ca }
            if (r1 != 0) goto L_0x008f
        L_0x005a:
            com.bykv.vk.openvk.preload.falconx.loader.a r1 = new com.bykv.vk.openvk.preload.falconx.loader.a     // Catch:{ all -> 0x00ca }
            android.content.Context r3 = b     // Catch:{ all -> 0x00ca }
            java.io.File r4 = a     // Catch:{ all -> 0x00ca }
            r1.<init>(r3, r2, r4)     // Catch:{ all -> 0x00ca }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r2.<init>()     // Catch:{ all -> 0x00ca }
            r2.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = "/md5_url_map.json"
            r2.append(r3)     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ca }
            java.io.InputStream r1 = r1.getInputStream(r2)     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = com.bykv.vk.openvk.preload.geckox.utils.c.a((java.io.InputStream) r1)     // Catch:{ all -> 0x00ca }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x0083
            return r0
        L_0x0083:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00ca }
            r2.<init>(r1)     // Catch:{ all -> 0x00ca }
            java.util.AbstractMap$SimpleEntry r1 = new java.util.AbstractMap$SimpleEntry     // Catch:{ all -> 0x00ca }
            r1.<init>(r6, r2)     // Catch:{ all -> 0x00ca }
            r5.e = r1     // Catch:{ all -> 0x00ca }
        L_0x008f:
            java.util.Map$Entry<java.lang.String, org.json.JSONObject> r6 = r5.d     // Catch:{ all -> 0x00ca }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x00ca }
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ all -> 0x00ca }
            java.util.Map$Entry<java.lang.String, org.json.JSONObject> r1 = r5.e     // Catch:{ all -> 0x00ca }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00ca }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = a((java.lang.String) r7, (org.json.JSONObject) r1)     // Catch:{ all -> 0x00ca }
            boolean r3 = r6.has(r2)     // Catch:{ all -> 0x00ca }
            if (r3 == 0) goto L_0x00b1
            org.json.JSONObject r7 = r6.getJSONObject(r2)     // Catch:{ all -> 0x00ca }
            a((org.json.JSONObject) r6, (java.lang.String) r2)     // Catch:{ all -> 0x00ca }
            return r7
        L_0x00b1:
            java.lang.String r7 = b(r7)     // Catch:{ all -> 0x00ca }
            if (r7 != 0) goto L_0x00b8
            return r0
        L_0x00b8:
            java.lang.String r7 = a((java.lang.String) r7, (org.json.JSONObject) r1)     // Catch:{ all -> 0x00ca }
            boolean r1 = r6.has(r7)     // Catch:{ all -> 0x00ca }
            if (r1 == 0) goto L_0x00ca
            org.json.JSONObject r1 = r6.getJSONObject(r7)     // Catch:{ all -> 0x00ca }
            a((org.json.JSONObject) r6, (java.lang.String) r7)     // Catch:{ all -> 0x00ca }
            return r1
        L_0x00ca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.c.a(java.lang.String, java.lang.String):org.json.JSONObject");
    }

    private static String a(String str, JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject(str).getString("md5");
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void a(JSONObject jSONObject, String str) {
        try {
            if ("once".equals(jSONObject.getJSONObject(str).optJSONObject("cacheStrategy").optString("hitStrategy"))) {
                jSONObject.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bykv.vk.openvk.preload.falconx.loader.a b() {
        try {
            return new com.bykv.vk.openvk.preload.falconx.loader.a(b, "cca47107bfcbdb211d88f3385aeede40", a);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(ILoader iLoader) {
        if (iLoader != null) {
            try {
                iLoader.release();
            } catch (Throwable unused) {
            }
        }
    }

    public final WebResourceResponseModel a(ILoader iLoader, String str, String str2) {
        String str3;
        InputStream inputStream;
        if (iLoader == null) {
            try {
                return new WebResourceResponseModel(-1, (WebResourceResponse) null);
            } catch (Throwable unused) {
                return new WebResourceResponseModel(-1, (WebResourceResponse) null);
            }
        } else {
            boolean z = false;
            if (!TextUtils.isEmpty(str2)) {
                if (!str2.matches("^https?:\\/\\/www\\.google-analytics\\.com/(?:ga|urchin|analytics)\\.js") && !str2.matches("^https?:\\/\\/www\\.googletagmanager\\.com\\/(gtag\\/js|gtm\\.js)") && !str2.matches("^https?:\\/\\/analytics\\.tiktok\\.com\\/i18n\\/pixel") && !str2.matches("https?:\\/\\/connect\\.facebook\\.net\\/(.*)\\/fbevents\\.js") && !str2.matches("https?:\\/\\/mc\\.yandex\\.ru\\/") && !str2.contains("jsonp") && !str2.contains("Callback") && !str2.contains("analytics.tiktok.com/i18n/pixel") && !str2.contains("google-analytics.com/analytics") && !str2.contains("connect.facebook.net")) {
                    if (!str2.contains("www.googletagmanager.com")) {
                        z = true;
                    }
                }
            }
            if (!z) {
                return new WebResourceResponseModel(1, (WebResourceResponse) null);
            }
            JSONObject a2 = a(str, str2);
            Set<String> set = f;
            String b2 = b(str2);
            int lastIndexOf = b2.lastIndexOf(".");
            if (lastIndexOf == -1) {
                str3 = "";
            } else {
                str3 = b2.substring(lastIndexOf + 1);
            }
            int i = set.contains(str3) ? 2 : -1;
            if (a2 == null) {
                return new WebResourceResponseModel(i, (WebResourceResponse) null);
            }
            String optString = a2.optString("fileName", (String) null);
            if (optString == null) {
                return new WebResourceResponseModel(i, (WebResourceResponse) null);
            }
            JSONObject jSONObject = a2.has("respHeader") ? a2.getJSONObject("respHeader") : null;
            if (jSONObject == null) {
                return new WebResourceResponseModel(i, (WebResourceResponse) null);
            }
            String str4 = str + File.separator + optString;
            if (!iLoader.exist(str4)) {
                inputStream = null;
            } else {
                inputStream = iLoader.getInputStream(str4);
            }
            if (inputStream == null) {
                return new WebResourceResponseModel(i, (WebResourceResponse) null);
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return new WebResourceResponseModel(i, com.bykv.vk.openvk.preload.falconx.a.a.a(inputStream, hashMap));
        }
    }

    public static int a(ILoader iLoader, String str) {
        if (iLoader == null || str == null) {
            return 0;
        }
        try {
            com.bykv.vk.openvk.preload.falconx.loader.a aVar = new com.bykv.vk.openvk.preload.falconx.loader.a(b, "cca47107bfcbdb211d88f3385aeede40", a);
            String str2 = str + File.separator;
            if (!aVar.b.get()) {
                com.bykv.vk.openvk.preload.geckox.f.b bVar = aVar.a;
                if (bVar.b.get()) {
                    throw new RuntimeException("released");
                } else if (!TextUtils.isEmpty(str2)) {
                    return bVar.a(str2.trim()).b(str2);
                } else {
                    throw new RuntimeException("relativePath empty");
                }
            } else {
                throw new RuntimeException("released!");
            }
        } catch (Throwable unused) {
            return 0;
        }
    }
}
