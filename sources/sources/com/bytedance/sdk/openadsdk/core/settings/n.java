package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.d;
import com.bytedance.sdk.openadsdk.utils.aa;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* compiled from: SettingsPropRepository */
public abstract class n implements d {
    private final ConcurrentHashMap<String, Object> c = new ConcurrentHashMap<>();
    private final Object d = new Object();
    private final Object e = new Object();
    private final CountDownLatch f = new CountDownLatch(1);
    /* access modifiers changed from: private */
    public Properties g = new Properties();
    private volatile boolean h = false;
    private final String i;

    public n(String str) {
        this.i = str;
        aa.b(new h("SetL_" + str) {
            public void run() {
                n.this.a(false);
            }
        });
    }

    public String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        d();
        return this.g.getProperty(str, str2);
    }

    private void d() {
        while (!this.h) {
            try {
                this.f.await();
            } catch (InterruptedException e2) {
                l.c("SdkSettings.Prop", "awaitLoadedLocked: ", e2);
            }
        }
    }

    public int a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        d();
        try {
            return Integer.parseInt(this.g.getProperty(str, String.valueOf(i2)));
        } catch (NumberFormatException e2) {
            l.c("SdkSettings.Prop", "", e2);
            return i2;
        }
    }

    public long a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        d();
        try {
            return Long.parseLong(this.g.getProperty(str, String.valueOf(j)));
        } catch (NumberFormatException e2) {
            l.c("SdkSettings.Prop", "", e2);
            return j;
        }
    }

    public float a(String str, float f2) {
        if (TextUtils.isEmpty(str)) {
            return f2;
        }
        d();
        try {
            return Float.parseFloat(this.g.getProperty(str, String.valueOf(f2)));
        } catch (NumberFormatException e2) {
            l.c("SdkSettings.Prop", "", e2);
            return f2;
        }
    }

    public boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        d();
        try {
            return Boolean.parseBoolean(this.g.getProperty(str, String.valueOf(z)));
        } catch (Exception e2) {
            l.c("SdkSettings.Prop", "", e2);
            return z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080 A[SYNTHETIC, Splitter:B:32:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088 A[Catch:{ Exception -> 0x0102 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r10) {
        /*
            r9 = this;
            java.lang.String r0 = "items from "
            java.lang.Object r1 = r9.d
            monitor-enter(r1)
            boolean r2 = r9.h     // Catch:{ all -> 0x010f }
            if (r2 == 0) goto L_0x0014
            if (r10 != 0) goto L_0x0014
            java.lang.String r10 = "SdkSettings.Prop"
            java.lang.String r0 = "reload: already loaded, ignore"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x010f }
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            return
        L_0x0014:
            java.io.File r10 = r9.e()     // Catch:{ all -> 0x010f }
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010f }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0091
            java.util.Properties r2 = new java.util.Properties     // Catch:{ all -> 0x010f }
            r2.<init>()     // Catch:{ all -> 0x010f }
            r5 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0076 }
            r6.<init>(r10)     // Catch:{ Exception -> 0x0076 }
            r2.load(r6)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r5 = "SdkSettings.Prop"
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r8 = "reload: find"
            r7[r3] = r8     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            int r3 = r2.size()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            r7[r4] = r3     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r10 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            r3.append(r10)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r10 = r3.toString()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            r0 = 2
            r7[r0] = r10     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            com.bytedance.sdk.component.utils.l.a((java.lang.String) r5, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            boolean r10 = r2.isEmpty()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            if (r10 != 0) goto L_0x0064
            r9.g = r2     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r10 = r9.c     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            r10.clear()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
        L_0x0064:
            com.bytedance.sdk.openadsdk.utils.h.a(r6)     // Catch:{ all -> 0x010f }
            java.lang.Object r10 = r9.d     // Catch:{ all -> 0x010f }
        L_0x0069:
            r10.notifyAll()     // Catch:{ all -> 0x010f }
            goto L_0x0106
        L_0x006e:
            r10 = move-exception
            r5 = r6
            goto L_0x0086
        L_0x0071:
            r10 = move-exception
            r5 = r6
            goto L_0x0077
        L_0x0074:
            r10 = move-exception
            goto L_0x0086
        L_0x0076:
            r10 = move-exception
        L_0x0077:
            java.lang.String r0 = "SdkSettings.Prop"
            java.lang.String r2 = "reload: "
            com.bytedance.sdk.component.utils.l.c(r0, r2, r10)     // Catch:{ all -> 0x0074 }
            if (r5 == 0) goto L_0x0083
            com.bytedance.sdk.openadsdk.utils.h.a(r5)     // Catch:{ all -> 0x010f }
        L_0x0083:
            java.lang.Object r10 = r9.d     // Catch:{ all -> 0x010f }
            goto L_0x0069
        L_0x0086:
            if (r5 == 0) goto L_0x008b
            com.bytedance.sdk.openadsdk.utils.h.a(r5)     // Catch:{ all -> 0x010f }
        L_0x008b:
            java.lang.Object r0 = r9.d     // Catch:{ all -> 0x010f }
            r0.notifyAll()     // Catch:{ all -> 0x010f }
            throw r10     // Catch:{ all -> 0x010f }
        L_0x0091:
            android.content.Context r10 = com.bytedance.sdk.openadsdk.core.o.a()     // Catch:{ all -> 0x010f }
            boolean r10 = com.bytedance.sdk.component.utils.q.a(r10)     // Catch:{ all -> 0x010f }
            if (r10 == 0) goto L_0x0106
            java.lang.String r10 = "tt_sdk_settings.prop"
            java.lang.String r0 = r9.i     // Catch:{ all -> 0x010f }
            boolean r10 = r10.equals(r0)     // Catch:{ all -> 0x010f }
            if (r10 == 0) goto L_0x0106
            android.content.Context r10 = com.bytedance.sdk.openadsdk.core.o.a()     // Catch:{ Exception -> 0x0102 }
            java.lang.String r0 = "tt_sdk_settings"
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r0, r3)     // Catch:{ Exception -> 0x0102 }
            java.util.Map r0 = r10.getAll()     // Catch:{ Exception -> 0x0102 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0102 }
            if (r0 != 0) goto L_0x0106
            com.bytedance.sdk.openadsdk.core.settings.d$a r0 = r9.a()     // Catch:{ Exception -> 0x0102 }
            java.util.Map r2 = r10.getAll()     // Catch:{ Exception -> 0x0102 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x0102 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0102 }
        L_0x00c9:
            boolean r5 = r2.hasNext()     // Catch:{ Exception -> 0x0102 }
            if (r5 == 0) goto L_0x00f1
            java.lang.Object r5 = r2.next()     // Catch:{ Exception -> 0x0102 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ Exception -> 0x0102 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ Exception -> 0x0102 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0102 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x0102 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0102 }
            if (r7 != 0) goto L_0x00c9
            if (r5 != 0) goto L_0x00e8
            goto L_0x00c9
        L_0x00e8:
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0102 }
            r0.a((java.lang.String) r6, (java.lang.String) r3)     // Catch:{ Exception -> 0x0102 }
            r3 = 1
            goto L_0x00c9
        L_0x00f1:
            if (r3 == 0) goto L_0x00f6
            r0.a()     // Catch:{ Exception -> 0x0102 }
        L_0x00f6:
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ Exception -> 0x0102 }
            android.content.SharedPreferences$Editor r10 = r10.clear()     // Catch:{ Exception -> 0x0102 }
            r10.commit()     // Catch:{ Exception -> 0x0102 }
            goto L_0x0106
        L_0x0102:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x010f }
        L_0x0106:
            r9.h = r4     // Catch:{ all -> 0x010f }
            java.util.concurrent.CountDownLatch r10 = r9.f     // Catch:{ all -> 0x010f }
            r10.countDown()     // Catch:{ all -> 0x010f }
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            return
        L_0x010f:
            r10 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            goto L_0x0113
        L_0x0112:
            throw r10
        L_0x0113:
            goto L_0x0112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.n.a(boolean):void");
    }

    private File e() {
        return new File(o.a().getFilesDir(), this.i);
    }

    public d.a a() {
        return new a();
    }

    public <T> T a(String str, T t, d.b<T> bVar) {
        T b;
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        if (this.c.containsKey(str)) {
            try {
                return this.c.get(str);
            } catch (Exception e2) {
                l.c("SdkSettings.Prop", "", e2);
                return t;
            }
        } else {
            d();
            String property = this.g.getProperty(str, (String) null);
            if (property == null || bVar == null || (b = bVar.b(property)) == null) {
                return t;
            }
            this.c.put(str, b);
            return b;
        }
    }

    public boolean b() {
        return this.h;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[SYNTHETIC, Splitter:B:21:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[SYNTHETIC, Splitter:B:27:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.Properties r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.e
            monitor-enter(r0)
            java.io.File r1 = r6.e()     // Catch:{ all -> 0x004d }
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0035 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            r7.store(r3, r2)     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            java.lang.String r7 = "SdkSettings.Prop"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            java.lang.String r4 = "saveToLocal: save to"
            r5 = 0
            r2[r5] = r4     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            r4 = 1
            r2[r4] = r1     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            java.lang.String r1 = "success"
            r4 = 2
            r2[r4] = r1     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            com.bytedance.sdk.component.utils.l.a((java.lang.String) r7, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            com.bytedance.sdk.openadsdk.utils.h.a(r3)     // Catch:{ all -> 0x004d }
            goto L_0x0042
        L_0x002d:
            r7 = move-exception
            r2 = r3
            goto L_0x0047
        L_0x0030:
            r7 = move-exception
            r2 = r3
            goto L_0x0036
        L_0x0033:
            r7 = move-exception
            goto L_0x0047
        L_0x0035:
            r7 = move-exception
        L_0x0036:
            java.lang.String r1 = "SdkSettings.Prop"
            java.lang.String r3 = "saveToLocal: "
            com.bytedance.sdk.component.utils.l.c(r1, r3, r7)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0042
            com.bytedance.sdk.openadsdk.utils.h.a(r2)     // Catch:{ all -> 0x004d }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            com.bytedance.sdk.openadsdk.core.settings.o.ak()
            return
        L_0x0047:
            if (r2 == 0) goto L_0x004c
            com.bytedance.sdk.openadsdk.utils.h.a(r2)     // Catch:{ all -> 0x004d }
        L_0x004c:
            throw r7     // Catch:{ all -> 0x004d }
        L_0x004d:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.n.a(java.util.Properties):void");
    }

    /* compiled from: SettingsPropRepository */
    public class a implements d.a {
        private final Map<String, Object> b = new HashMap();
        private final Object c = new Object();

        public a() {
        }

        public void a() {
            Object obj;
            boolean z = false;
            l.a("SdkSettings.Prop", "commit: ", this.b);
            Properties properties = new Properties();
            synchronized (this.c) {
                properties.putAll(n.this.g);
                for (Map.Entry next : this.b.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value != this) {
                        if (value != null) {
                            if (!properties.containsKey(str) || (obj = properties.get(str)) == null || !obj.equals(value)) {
                                properties.put(str, String.valueOf(value));
                                z = true;
                            }
                        }
                    }
                    if (properties.containsKey(str)) {
                        properties.remove(str);
                        z = true;
                    }
                }
                this.b.clear();
                if (z) {
                    n.this.a(properties);
                    Properties unused = n.this.g = properties;
                }
            }
        }

        public d.a a(String str, String str2) {
            synchronized (this.c) {
                this.b.put(str, str2);
            }
            return this;
        }

        public d.a a(String str, int i) {
            synchronized (this.c) {
                this.b.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public d.a a(String str, long j) {
            synchronized (this.c) {
                this.b.put(str, Long.valueOf(j));
            }
            return this;
        }

        public d.a a(String str) {
            synchronized (this.c) {
                this.b.put(str, this);
            }
            return this;
        }

        public d.a a(String str, float f) {
            synchronized (this.c) {
                this.b.put(str, Float.valueOf(f));
            }
            return this;
        }

        public d.a a(String str, boolean z) {
            synchronized (this.c) {
                this.b.put(str, Boolean.valueOf(z));
            }
            return this;
        }
    }

    public void c() {
        File e2 = e();
        if (e2.exists()) {
            e2.delete();
        }
    }
}
