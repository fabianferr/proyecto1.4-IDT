package com.bytedance.sdk.openadsdk.core.g.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.g.b.a;
import com.bytedance.sdk.openadsdk.core.g.b.b;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: VastTracker */
public class c {
    /* access modifiers changed from: private */
    public static final Map<String, b> e = new ConcurrentHashMap();
    private static final AtomicBoolean f = new AtomicBoolean(false);
    private final String a;
    private C0065c b;
    private boolean c;
    private boolean d;

    /* compiled from: VastTracker */
    public static class a {
        private final String a;
        private C0065c b = C0065c.TRACKING_URL;
        private boolean c = false;

        public a(String str) {
            this.a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            r0 = 'J';
            r1 = '7';
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
            switch(r1) {
                case 55: goto L_0x000f;
                case 56: goto L_0x0026;
                case 57: goto L_0x0026;
                default: goto L_0x000e;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            r2 = r2.toCharArray();
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
            if (r0 >= r2.length) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
            r2[r0] = (char) (r2[r0] ^ r0);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
            return new java.lang.String(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String c$a1699434667851dc(java.lang.String r2) {
            /*
            L_0x0000:
                r0 = 73
                r1 = 96
            L_0x0004:
                switch(r0) {
                    case 72: goto L_0x0026;
                    case 73: goto L_0x0008;
                    case 74: goto L_0x000b;
                    default: goto L_0x0007;
                }
            L_0x0007:
                goto L_0x002b
            L_0x0008:
                switch(r1) {
                    case 94: goto L_0x0000;
                    case 95: goto L_0x0026;
                    case 96: goto L_0x0026;
                    default: goto L_0x000b;
                }
            L_0x000b:
                switch(r1) {
                    case 55: goto L_0x000f;
                    case 56: goto L_0x0026;
                    case 57: goto L_0x0026;
                    default: goto L_0x000e;
                }
            L_0x000e:
                goto L_0x0000
            L_0x000f:
                char[] r2 = r2.toCharArray()
                r0 = 0
            L_0x0014:
                int r1 = r2.length
                if (r0 >= r1) goto L_0x0020
                char r1 = r2[r0]
                r1 = r1 ^ r0
                char r1 = (char) r1
                r2[r0] = r1
                int r0 = r0 + 1
                goto L_0x0014
            L_0x0020:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
                return r0
            L_0x0026:
                r0 = 74
                r1 = 55
                goto L_0x0004
            L_0x002b:
                r0 = 72
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(java.lang.String):java.lang.String");
        }

        public a a(boolean z) {
            this.c = z;
            return this;
        }

        public c a() {
            return new c(this.a, this.b, Boolean.valueOf(this.c));
        }
    }

    /* compiled from: VastTracker */
    public static class b {
        String a;
        q b;
        float c;

        public b(String str, q qVar) {
            this(str, qVar, -1.0f);
        }

        public b(String str, q qVar, float f) {
            this.a = str;
            this.b = qVar;
            this.c = f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            r0 = 'J';
            r1 = '7';
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
            switch(r1) {
                case 55: goto L_0x000f;
                case 56: goto L_0x0026;
                case 57: goto L_0x0026;
                default: goto L_0x000e;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            r2 = r2.toCharArray();
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
            if (r0 >= r2.length) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
            r2[r0] = (char) (r2[r0] ^ r0);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
            return new java.lang.String(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String c$b1699434667869dc(java.lang.String r2) {
            /*
            L_0x0000:
                r0 = 73
                r1 = 96
            L_0x0004:
                switch(r0) {
                    case 72: goto L_0x0026;
                    case 73: goto L_0x0008;
                    case 74: goto L_0x000b;
                    default: goto L_0x0007;
                }
            L_0x0007:
                goto L_0x002b
            L_0x0008:
                switch(r1) {
                    case 94: goto L_0x0000;
                    case 95: goto L_0x0026;
                    case 96: goto L_0x0026;
                    default: goto L_0x000b;
                }
            L_0x000b:
                switch(r1) {
                    case 55: goto L_0x000f;
                    case 56: goto L_0x0026;
                    case 57: goto L_0x0026;
                    default: goto L_0x000e;
                }
            L_0x000e:
                goto L_0x0000
            L_0x000f:
                char[] r2 = r2.toCharArray()
                r0 = 0
            L_0x0014:
                int r1 = r2.length
                if (r0 >= r1) goto L_0x0020
                char r1 = r2[r0]
                r1 = r1 ^ r0
                char r1 = (char) r1
                r2[r0] = r1
                int r0 = r0 + 1
                goto L_0x0014
            L_0x0020:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
                return r0
            L_0x0026:
                r0 = 74
                r1 = 55
                goto L_0x0004
            L_0x002b:
                r0 = 72
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(java.lang.String):java.lang.String");
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.b.c$c  reason: collision with other inner class name */
    /* compiled from: VastTracker */
    enum C0065c {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    static {
        v.a((v.a) new v.a() {
            public void a(Context context, Intent intent, boolean z, int i) {
                if (i != 0 && c.e.size() > 0) {
                    c.b();
                }
            }
        }, o.a());
    }

    protected c(String str, C0065c cVar, Boolean bool) {
        this.a = str;
        this.b = cVar;
        this.c = bool.booleanValue();
    }

    public static List<String> a(List<c> list, com.bytedance.sdk.openadsdk.core.g.a.a aVar, long j, String str) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (c next : list) {
            if (next != null && (!next.e() || next.d())) {
                arrayList.add(next.c());
                next.h_();
            }
        }
        return new com.bytedance.sdk.openadsdk.core.g.c.c(arrayList).a(aVar).a(j).a(str).a();
    }

    public static List<c> a(JSONArray jSONArray) {
        return a(jSONArray, false);
    }

    public static List<c> a(JSONArray jSONArray, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(new a(optString).a(z).a());
                }
            }
        }
        return arrayList;
    }

    public static JSONArray a(List<c> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i).c());
        }
        return jSONArray;
    }

    private static void a(final String str, final b bVar, final boolean z) {
        com.bytedance.sdk.component.f.b.b c2 = com.bytedance.sdk.openadsdk.k.c.a().b().c();
        if (c2 != null) {
            c2.a(true);
            c2.a(str);
            c2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                    String str;
                    boolean z;
                    b bVar2 = bVar;
                    if (bVar2 != null && bVar2.b != null) {
                        String str2 = null;
                        if (bVar == null || !bVar.f()) {
                            if (bVar != null) {
                                str2 = bVar.a() + CertificateUtil.DELIMITER + bVar.b();
                                if (!z && (bVar.a() <= 300 || bVar.a() >= 400)) {
                                    c.e.put(str, bVar);
                                }
                            }
                            str = str2;
                            z = false;
                        } else {
                            str = null;
                            z = true;
                        }
                        c.b(z, str, ac.c(bVar.b.aS()), bVar, str, z);
                        if (bVar != null && bVar.a() == 200 && c.e.size() > 0) {
                            c.b();
                        }
                    }
                }

                public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                    b bVar = bVar;
                    if (!(bVar == null || bVar.b == null)) {
                        c.b(false, iOException != null ? iOException.getMessage() : null, ac.c(bVar.b.aS()), bVar, str, z);
                    }
                    if (!z && bVar != null) {
                        c.e.put(str, bVar);
                    }
                }
            });
        }
    }

    public static void a(List<c> list, com.bytedance.sdk.openadsdk.core.g.a.a aVar, long j, String str, b bVar) {
        a(a(list, aVar, j, str), bVar);
    }

    public static void a(List<String> list, b bVar) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                a(str, bVar, false);
            }
        }
    }

    public static List<b> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new b.a(optJSONObject.optString("content"), (float) optJSONObject.optDouble("trackingFraction", 0.0d)).a());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static void b() {
        if (f.compareAndSet(false, true)) {
            Map<String, b> map = e;
            HashSet<Map.Entry> hashSet = new HashSet<>(map.entrySet());
            map.clear();
            for (Map.Entry entry : hashSet) {
                if (entry != null) {
                    a((String) entry.getKey(), (b) entry.getValue(), true);
                }
            }
            f.set(false);
        }
    }

    public static void b(List<c> list, com.bytedance.sdk.openadsdk.core.g.a.a aVar, long j, String str) {
        a(list, aVar, j, str, (b) null);
    }

    /* access modifiers changed from: private */
    public static void b(boolean z, String str, String str2, b bVar, String str3, boolean z2) {
        final b bVar2 = bVar;
        final boolean z3 = z;
        final String str4 = str;
        final String str5 = str3;
        final boolean z4 = z2;
        final String str6 = str2;
        com.bytedance.sdk.openadsdk.b.c.a((h) new h("dsp_track_link_result") {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", bVar2.a);
                    jSONObject.put("success", z3);
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject.put("description", str4);
                    }
                    jSONObject.put("url", str5);
                    if (bVar2.c >= 0.0f) {
                        double round = (double) Math.round(bVar2.c * 100.0f);
                        Double.isNaN(round);
                        jSONObject.put("progress", round / 100.0d);
                    }
                    if (z4) {
                        jSONObject.put("retry", true);
                    }
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.b.c.b(bVar2.b, str6, "dsp_track_link_result", jSONObject);
            }
        });
    }

    public static List<a> c(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new a.C0064a(optJSONObject.optString("content"), optJSONObject.optLong("trackingMilliseconds", 0)).a());
                }
            }
        }
        return arrayList;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public void h_() {
        this.d = true;
    }
}
