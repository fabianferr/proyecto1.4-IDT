package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.JsonReader;
import android.util.MalformedJsonException;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.common.advertisingid.AdvertisingIdResolver;
import com.startapp.sdk.jobs.JobRequest;
import com.startapp.sdk.jobs.d;
import com.startapp.sdk.triggeredlinks.AppEventsMetadata;
import com.startapp.sdk.triggeredlinks.PeriodicAppEventMetadata;
import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Sta */
public class z8 {
    public final String a;
    public final e b;
    public final Executor c;
    public final i4 d;
    public final Handler e;
    public final Map<String, Long> f;
    public final AdvertisingIdResolver g;
    public final i2<String> h;
    public final i2<TriggeredLinksMetadata> i;
    public final Runnable j = new a();

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            z8.this.b();
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public final /* synthetic */ TriggeredLinksMetadata a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ String c;

        public b(TriggeredLinksMetadata triggeredLinksMetadata, Map map, String str) {
            this.a = triggeredLinksMetadata;
            this.b = map;
            this.c = str;
        }

        public void run() {
            try {
                z8.this.b(this.a, this.b, this.c);
            } catch (Throwable th) {
                if (z8.this.a(2)) {
                    i3.a(th);
                }
            }
        }
    }

    public z8(String str, e eVar, Executor executor, i4 i4Var, AdvertisingIdResolver advertisingIdResolver, i2<String> i2Var, i2<TriggeredLinksMetadata> i2Var2) {
        this.a = str;
        this.b = eVar;
        this.c = new r7(executor);
        this.d = i4Var;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new HashMap();
        this.g = advertisingIdResolver;
        this.h = i2Var;
        this.i = i2Var2;
    }

    public final TriggeredLinksMetadata a() {
        TriggeredLinksMetadata a2 = this.i.a();
        if (a2 == null || !a2.e()) {
            return null;
        }
        return a2;
    }

    public void b() {
        String b2;
        this.e.removeCallbacks(this.j);
        int i2 = 1;
        this.d.a(JobRequest.a((Class<? extends com.startapp.sdk.jobs.b>[]) new Class[]{y8.class}));
        TriggeredLinksMetadata a2 = a();
        Map<String, PeriodicAppEventMetadata> map = null;
        AppEventsMetadata a3 = a2 != null ? a2.a() : null;
        if (a3 != null) {
            map = a3.d();
        }
        if (map != null && map.size() >= 1) {
            e.a a4 = this.b.edit();
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = Long.MAX_VALUE;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                PeriodicAppEventMetadata periodicAppEventMetadata = (PeriodicAppEventMetadata) next.getValue();
                if (!(str == null || str.length() < i2 || periodicAppEventMetadata == null || (b2 = periodicAppEventMetadata.b()) == null || b2.length() < i2)) {
                    int a5 = periodicAppEventMetadata.a();
                    int i3 = a5 < 5 ? 5 : a5;
                    long j3 = this.b.getLong(str, 0);
                    if (j3 > currentTimeMillis) {
                        a4.a(str, Long.valueOf(j3));
                        a4.a.putLong(str, j3);
                        if (j2 > j3) {
                            j2 = j3;
                        }
                    } else {
                        long j4 = (((long) i3) * 1000) + currentTimeMillis;
                        a4.a(str, Long.valueOf(j4));
                        a4.a.putLong(str, j4);
                        b9 b9Var = r0;
                        Executor executor = this.c;
                        b9 b9Var2 = new b9(this, a2, str, b2, i3);
                        executor.execute(b9Var);
                    }
                }
                i2 = 1;
            }
            a4.apply();
            if (j2 != Long.MAX_VALUE) {
                long j5 = j2 - currentTimeMillis;
                if (j5 < 5000) {
                    a(j5);
                    return;
                }
                d.a aVar = new d.a(y8.class);
                aVar.d = Long.valueOf(j5);
                aVar.b = JobRequest.Network.ANY;
                this.d.a(new d((d.a) aVar.a()));
            }
        }
    }

    public boolean a(int i2) {
        TriggeredLinksMetadata a2 = a();
        return a2 != null && (a2.b() & i2) == i2;
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.e.postDelayed(this.j, j2);
        } else {
            this.e.post(this.j);
        }
    }

    public void a(String str, int i2) {
        e.a a2 = this.b.edit();
        long currentTimeMillis = (((long) i2) * 1000) + System.currentTimeMillis();
        a2.a(str, Long.valueOf(currentTimeMillis));
        a2.a.putLong(str, currentTimeMillis);
        a2.apply();
    }

    public void a(TriggeredLinksMetadata triggeredLinksMetadata, Map<String, String> map, String str) {
        this.c.execute(new b(triggeredLinksMetadata, map, str));
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.net.URLConnection] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (r7.equals("startapp_advertising_id") == false) goto L_0x0038;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0128 A[Catch:{ all -> 0x012d }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) throws java.io.IOException, org.json.JSONException {
        /*
            r10 = this;
            android.net.Uri r14 = android.net.Uri.parse(r14)
            android.net.Uri$Builder r0 = r14.buildUpon()
            r1 = 0
            r0.query(r1)
            java.util.Set r2 = r14.getQueryParameterNames()
            java.util.Iterator r2 = r2.iterator()
        L_0x0014:
            boolean r3 = r2.hasNext()
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x008e
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0026
            goto L_0x0014
        L_0x0026:
            java.lang.String r7 = r14.getQueryParameter(r3)
            if (r7 != 0) goto L_0x002d
            goto L_0x0014
        L_0x002d:
            r7.hashCode()
            int r8 = r7.hashCode()
            r9 = -1
            switch(r8) {
                case -1089147532: goto L_0x0050;
                case 613582261: goto L_0x0044;
                case 1311708630: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            r4 = -1
            goto L_0x005b
        L_0x003a:
            java.lang.String r5 = "startapp_advertising_id"
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L_0x005b
            goto L_0x0038
        L_0x0044:
            java.lang.String r4 = "startapp_no_tracking"
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x004e
            goto L_0x0038
        L_0x004e:
            r4 = 1
            goto L_0x005b
        L_0x0050:
            java.lang.String r4 = "startapp_package_id"
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x005a
            goto L_0x0038
        L_0x005a:
            r4 = 0
        L_0x005b:
            java.lang.String r5 = "0"
            switch(r4) {
                case 0: goto L_0x0088;
                case 1: goto L_0x0078;
                case 2: goto L_0x0064;
                default: goto L_0x0060;
            }
        L_0x0060:
            r0.appendQueryParameter(r3, r7)
            goto L_0x0014
        L_0x0064:
            com.startapp.sdk.common.advertisingid.AdvertisingIdResolver r4 = r10.g
            com.startapp.u r4 = r4.a()
            java.lang.String r4 = r4.a
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x0074
            java.lang.String r4 = "00000000-0000-0000-0000-000000000000"
        L_0x0074:
            r0.appendQueryParameter(r3, r4)
            goto L_0x0014
        L_0x0078:
            com.startapp.sdk.common.advertisingid.AdvertisingIdResolver r4 = r10.g
            com.startapp.u r4 = r4.a()
            boolean r4 = r4.c
            if (r4 == 0) goto L_0x0084
            java.lang.String r5 = "1"
        L_0x0084:
            r0.appendQueryParameter(r3, r5)
            goto L_0x0014
        L_0x0088:
            java.lang.String r4 = r10.a
            r0.appendQueryParameter(r3, r4)
            goto L_0x0014
        L_0x008e:
            android.net.Uri r14 = r0.build()
            java.lang.String r14 = r14.toString()
            java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x011f }
            r0.<init>(r14)     // Catch:{ all -> 0x011f }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ all -> 0x011f }
            boolean r2 = r0 instanceof java.net.HttpURLConnection     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00de
            r2 = r0
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ all -> 0x011b }
            r2.setInstanceFollowRedirects(r5)     // Catch:{ all -> 0x011b }
            int r3 = r11.c()     // Catch:{ all -> 0x011b }
            int r3 = r3 * 1000
            r2.setReadTimeout(r3)     // Catch:{ all -> 0x011b }
            int r3 = r11.c()     // Catch:{ all -> 0x011b }
            int r3 = r3 * 1000
            r2.setConnectTimeout(r3)     // Catch:{ all -> 0x011b }
            com.startapp.i2<java.lang.String> r3 = r10.h     // Catch:{ all -> 0x011b }
            java.lang.Object r3 = r3.a()     // Catch:{ all -> 0x011b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x011b }
            if (r3 == 0) goto L_0x00d0
            int r5 = r3.length()     // Catch:{ all -> 0x011b }
            if (r5 <= 0) goto L_0x00d0
            java.lang.String r5 = "User-Agent"
            r2.setRequestProperty(r5, r3)     // Catch:{ all -> 0x011b }
        L_0x00d0:
            r2.connect()     // Catch:{ all -> 0x011b }
            int r6 = r2.getResponseCode()     // Catch:{ all -> 0x011b }
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ all -> 0x011b }
            r10.a((java.lang.String) r12, (java.lang.String) r13, (java.io.InputStream) r1)     // Catch:{ all -> 0x011b }
        L_0x00de:
            com.startapp.k9.a((java.io.Closeable) r1)
            boolean r1 = r0 instanceof java.net.HttpURLConnection     // Catch:{ all -> 0x00eb }
            if (r1 == 0) goto L_0x00ec
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x00eb }
            r0.disconnect()     // Catch:{ all -> 0x00eb }
            goto L_0x00ec
        L_0x00eb:
        L_0x00ec:
            boolean r11 = r11.f()
            if (r11 == 0) goto L_0x011a
            int r6 = r6 / 100
            if (r6 != r4) goto L_0x011a
            com.startapp.i3 r11 = new com.startapp.i3
            com.startapp.j3 r0 = com.startapp.j3.n
            r11.<init>((com.startapp.j3) r0)
            r11.d = r13
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r0 = "eventType"
            org.json.JSONObject r12 = r13.put(r0, r12)
            java.lang.String r13 = "url"
            org.json.JSONObject r12 = r12.put(r13, r14)
            java.lang.String r12 = r12.toString()
            r11.e = r12
            r11.a()
        L_0x011a:
            return
        L_0x011b:
            r11 = move-exception
            r12 = r1
            r1 = r0
            goto L_0x0121
        L_0x011f:
            r11 = move-exception
            r12 = r1
        L_0x0121:
            com.startapp.k9.a((java.io.Closeable) r12)
            boolean r12 = r1 instanceof java.net.HttpURLConnection     // Catch:{ all -> 0x012d }
            if (r12 == 0) goto L_0x012d
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x012d }
            r1.disconnect()     // Catch:{ all -> 0x012d }
        L_0x012d:
            goto L_0x012f
        L_0x012e:
            throw r11
        L_0x012f:
            goto L_0x012e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.z8.a(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
        if (r2.longValue() > android.os.SystemClock.elapsedRealtime()) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata r9, java.util.Map<java.lang.String, java.lang.String> r10, java.lang.String r11) {
        /*
            r8 = this;
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0008:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0094
            java.lang.Object r0 = r10.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            if (r1 == 0) goto L_0x0094
            int r2 = r1.length()
            r3 = 1
            if (r2 >= r3) goto L_0x002a
            goto L_0x0094
        L_0x002a:
            if (r0 == 0) goto L_0x0094
            int r2 = r0.length()
            if (r2 >= r3) goto L_0x0033
            goto L_0x0094
        L_0x0033:
            java.util.List r2 = r9.d()
            if (r2 != 0) goto L_0x003a
            goto L_0x007f
        L_0x003a:
            java.util.Iterator r2 = r2.iterator()
        L_0x003e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x007f
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.String r4 = java.lang.String.valueOf(r4)
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x003e
            java.util.Map<java.lang.String, java.lang.Long> r2 = r8.f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r5 = "-"
            r4.append(r5)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            java.lang.Object r2 = r2.get(r4)
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L_0x007f
            long r4 = r2.longValue()
            long r6 = android.os.SystemClock.elapsedRealtime()
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r3 = 0
        L_0x0080:
            if (r3 == 0) goto L_0x0083
            return
        L_0x0083:
            r8.a(r9, r11, r1, r0)     // Catch:{ all -> 0x0087 }
            goto L_0x0008
        L_0x0087:
            r0 = move-exception
            r1 = 4
            boolean r1 = r8.a((int) r1)
            if (r1 == 0) goto L_0x0008
            com.startapp.i3.a((java.lang.Throwable) r0)
            goto L_0x0008
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.z8.b(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata, java.util.Map, java.lang.String):void");
    }

    public final void a(String str, String str2, InputStream inputStream) throws IOException {
        try {
            Object b2 = m4.b(new JsonReader(new InputStreamReader(inputStream)));
            if (b2 instanceof Map) {
                Object obj = ((Map) b2).get("throttleSec");
                if (obj instanceof Number) {
                    int intValue = ((Number) obj).intValue();
                    Map<String, Long> map = this.f;
                    map.put(str2 + "-" + str, Long.valueOf((((long) intValue) * 1000) + SystemClock.elapsedRealtime()));
                }
            }
        } catch (IOException e2) {
            if (!(e2 instanceof MalformedJsonException)) {
                throw e2;
            }
        }
    }
}
