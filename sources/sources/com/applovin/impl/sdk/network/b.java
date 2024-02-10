package com.applovin.impl.sdk.network;

import androidx.core.util.Consumer;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.utils.s;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

public class b {
    private static final List<String> a = Arrays.asList(new String[]{"5.0/i", "4.0/ad", "1.0/mediate"});
    /* access modifiers changed from: private */
    public final m b;
    /* access modifiers changed from: private */
    public final u c;
    private final e d;

    public static class a {
        private long a;
        private long b;

        /* access modifiers changed from: private */
        public void a(long j) {
            this.a = j;
        }

        /* access modifiers changed from: private */
        public void b(long j) {
            this.b = j;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.b$b  reason: collision with other inner class name */
    private class C0022b<T> implements Consumer<e.c> {
        private final String b;
        private final c<T> c;
        private final String d;
        private final T e;
        private final boolean f;
        private final long g;
        private final a h;
        private final c<T> i;

        private C0022b(String str, c<T> cVar, String str2, T t, boolean z, long j, a aVar, c<T> cVar2) {
            this.b = str;
            this.c = cVar;
            this.d = str2;
            this.e = t;
            this.f = z;
            this.g = j;
            this.h = aVar;
            this.i = cVar2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:52:0x012e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x012f, code lost:
            if (r2 == 0) goto L_0x0131;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0131, code lost:
            r2 = com.applovin.impl.sdk.network.b.a(r11.a, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            r12 = r12.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x013b, code lost:
            if (r12 != null) goto L_0x013d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x013f, code lost:
            if (r11.f != false) goto L_0x0141;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0141, code lost:
            r12 = com.applovin.impl.sdk.utils.m.a(r12, com.applovin.impl.sdk.network.b.a(r11.a).z());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x014f, code lost:
            r1 = com.applovin.impl.sdk.network.b.a(r11.a, r12, (java.lang.Object) r11.e);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x016e, code lost:
            r12 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x016f, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0176, code lost:
            com.applovin.impl.sdk.network.b.a(r11.a, r11.d, r11.b, r0, r11.g, r12);
            r11.i.a(-901, r12.getMessage(), null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x018d, code lost:
            com.applovin.impl.sdk.network.b.a(r11.a, r11.d, r11.b, r0, r11.g);
            r11.i.a(r11.e, -901);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x012e A[ExcHandler: all (r0v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r2 
          PHI: (r2v3 int) = (r2v0 int), (r2v7 int), (r2v7 int), (r2v7 int), (r2v7 int) binds: [B:1:0x0004, B:4:0x000a, B:41:0x00d0, B:27:0x0072, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0004] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x018d  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(com.applovin.impl.sdk.network.e.c r12) {
            /*
                r11 = this;
                java.lang.String r0 = "Unable to parse response from "
                r1 = 0
                r2 = 0
                int r2 = r12.a()     // Catch:{ MalformedURLException -> 0x016e, all -> 0x012e }
                if (r2 <= 0) goto L_0x011b
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                long r5 = r11.g     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                long r3 = r3 - r5
                r5 = 200(0xc8, float:2.8E-43)
                if (r2 < r5) goto L_0x0114
                r5 = 400(0x190, float:5.6E-43)
                if (r2 >= r5) goto L_0x0114
                com.applovin.impl.sdk.network.b$a r5 = r11.h     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                if (r5 == 0) goto L_0x0020
                r5.a(r3)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
            L_0x0020:
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r4 = r11.d     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r5 = r11.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                long r7 = r11.g     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r6 = r2
                r3.a(r4, r5, r6, r7)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r3 = r12.b()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.m r4 = r4.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                android.content.Context r4 = r4.L()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                boolean r4 = com.applovin.impl.sdk.utils.Utils.isDspDemoApp(r4)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                if (r4 == 0) goto L_0x0068
                java.lang.String r4 = ""
                if (r3 == 0) goto L_0x0046
                r5 = r3
                goto L_0x0047
            L_0x0046:
                r5 = r4
            L_0x0047:
                com.applovin.impl.sdk.network.c<T> r6 = r11.c     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                org.json.JSONObject r6 = r6.e()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                if (r6 == 0) goto L_0x0059
                com.applovin.impl.sdk.network.c<T> r4 = r11.c     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                org.json.JSONObject r4 = r4.e()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
            L_0x0059:
                com.applovin.impl.sdk.network.b r6 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.m r6 = r6.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.i r6 = r6.ag()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r7 = r11.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r6.a(r5, r7, r4)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
            L_0x0068:
                if (r3 == 0) goto L_0x010b
                boolean r4 = com.applovin.impl.sdk.u.a()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r5 = "ConnectionManager"
                if (r4 == 0) goto L_0x007b
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.u r4 = r4.c     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r4.a((java.lang.String) r5, (java.lang.String) r3)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
            L_0x007b:
                com.applovin.impl.sdk.network.b$a r4 = r11.h     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                if (r4 == 0) goto L_0x0087
                int r6 = r3.length()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                long r6 = (long) r6     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r4.b(r6)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
            L_0x0087:
                boolean r4 = r11.f     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                if (r4 == 0) goto L_0x00c0
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.m r4 = r4.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r4 = r4.z()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r4 = com.applovin.impl.sdk.utils.m.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                if (r4 != 0) goto L_0x00bf
                r6 = 2
                java.util.Map r6 = com.applovin.impl.sdk.utils.CollectionUtils.map((int) r6)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r7 = "request"
                java.lang.String r8 = r11.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r8 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r8)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r6.put(r7, r8)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r7 = "response"
                r6.put(r7, r3)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.m r3 = r3.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.sdk.AppLovinEventService r3 = r3.w()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r7 = "rdf"
                r3.trackEvent(r7, r6)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
            L_0x00bf:
                r3 = r4
            L_0x00c0:
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x00cf }
                T r6 = r11.e     // Catch:{ all -> 0x00cf }
                java.lang.Object r3 = r4.a((java.lang.String) r3, r6)     // Catch:{ all -> 0x00cf }
                com.applovin.impl.sdk.network.b$c<T> r4 = r11.i     // Catch:{ all -> 0x00cf }
                r4.a(r3, r2)     // Catch:{ all -> 0x00cf }
                goto L_0x01a0
            L_0x00cf:
                r3 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r4.<init>(r0)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.network.b r0 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r6 = r11.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r0 = r0.a((java.lang.String) r6)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r4.append(r0)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r0 = r4.toString()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                boolean r4 = com.applovin.impl.sdk.u.a()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                if (r4 == 0) goto L_0x00f3
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.u r4 = r4.c     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r4.b(r5, r0, r3)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
            L_0x00f3:
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.m r3 = r3.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.e.g r3 = r3.T()     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.e.f r4 = com.applovin.impl.sdk.e.f.k     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r3.a(r4)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.network.b$c<T> r3 = r11.i     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r4 = -800(0xfffffffffffffce0, float:NaN)
                r3.a(r4, r0, r1)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                goto L_0x01a0
            L_0x010b:
                com.applovin.impl.sdk.network.b$c<T> r0 = r11.i     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                T r3 = r11.e     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r0.a(r3, r2)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                goto L_0x01a0
            L_0x0114:
                com.applovin.impl.sdk.network.b$c<T> r0 = r11.i     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
            L_0x0116:
                r0.a(r2, r1, r1)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                goto L_0x01a0
            L_0x011b:
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r4 = r11.d     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                java.lang.String r5 = r11.b     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                long r7 = r11.g     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                r9 = 0
                r6 = r2
                r3.a((java.lang.String) r4, (java.lang.String) r5, (int) r6, (long) r7, (java.lang.Throwable) r9)     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                com.applovin.impl.sdk.network.b$c<T> r0 = r11.i     // Catch:{ MalformedURLException -> 0x012b, all -> 0x012e }
                goto L_0x0116
            L_0x012b:
                r12 = move-exception
                r0 = r2
                goto L_0x0170
            L_0x012e:
                r0 = move-exception
                if (r2 != 0) goto L_0x0137
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this
                int r2 = r2.a((java.lang.Throwable) r0)
            L_0x0137:
                java.lang.String r12 = r12.c()     // Catch:{ all -> 0x0157 }
                if (r12 == 0) goto L_0x0157
                boolean r3 = r11.f     // Catch:{ all -> 0x0157 }
                if (r3 == 0) goto L_0x014f
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x0157 }
                com.applovin.impl.sdk.m r3 = r3.b     // Catch:{ all -> 0x0157 }
                java.lang.String r3 = r3.z()     // Catch:{ all -> 0x0157 }
                java.lang.String r12 = com.applovin.impl.sdk.utils.m.a((java.lang.String) r12, (java.lang.String) r3)     // Catch:{ all -> 0x0157 }
            L_0x014f:
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x0157 }
                T r4 = r11.e     // Catch:{ all -> 0x0157 }
                java.lang.Object r1 = r3.a((java.lang.String) r12, r4)     // Catch:{ all -> 0x0157 }
            L_0x0157:
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this
                java.lang.String r4 = r11.d
                java.lang.String r5 = r11.b
                long r7 = r11.g
                r6 = r2
                r9 = r0
                r3.a((java.lang.String) r4, (java.lang.String) r5, (int) r6, (long) r7, (java.lang.Throwable) r9)
                com.applovin.impl.sdk.network.b$c<T> r12 = r11.i
                java.lang.String r0 = r0.getMessage()
                r12.a(r2, r0, r1)
                goto L_0x01a0
            L_0x016e:
                r12 = move-exception
                r0 = 0
            L_0x0170:
                T r2 = r11.e
                r10 = -901(0xfffffffffffffc7b, float:NaN)
                if (r2 == 0) goto L_0x018d
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this
                java.lang.String r4 = r11.d
                java.lang.String r5 = r11.b
                long r7 = r11.g
                r6 = r0
                r9 = r12
                r3.a((java.lang.String) r4, (java.lang.String) r5, (int) r6, (long) r7, (java.lang.Throwable) r9)
                com.applovin.impl.sdk.network.b$c<T> r0 = r11.i
                java.lang.String r12 = r12.getMessage()
                r0.a(r10, r12, r1)
                goto L_0x01a0
            L_0x018d:
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this
                java.lang.String r3 = r11.d
                java.lang.String r4 = r11.b
                long r6 = r11.g
                r5 = r0
                r2.a(r3, r4, r5, r6)
                com.applovin.impl.sdk.network.b$c<T> r12 = r11.i
                T r0 = r11.e
                r12.a(r0, r10)
            L_0x01a0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.b.C0022b.accept(com.applovin.impl.sdk.network.e$c):void");
        }
    }

    public interface c<T> {
        void a(int i, String str, T t);

        void a(T t, int i);
    }

    public b(m mVar) {
        this.b = mVar;
        this.c = mVar.A();
        e eVar = new e(mVar);
        this.d = eVar;
        eVar.a();
    }

    /* access modifiers changed from: private */
    public int a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return -1009;
        }
        if (th instanceof SocketTimeoutException) {
            return -1001;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    /* access modifiers changed from: private */
    public <T> T a(String str, T t) throws JSONException, SAXException, ClassCastException {
        if (t == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (t instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (t instanceof r) {
                return s.a(str, this.b);
            }
            if (t instanceof String) {
                return str;
            }
            if (u.a()) {
                u uVar = this.c;
                uVar.e("ConnectionManager", "Failed to process response of type '" + t.getClass().getName() + "'");
            }
        }
        return t;
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i, long j) {
        if (u.a()) {
            u uVar = this.c;
            uVar.c("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + h.f(this.b) + " to " + a(str2));
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i, long j, Throwable th) {
        if (u.a()) {
            u uVar = this.c;
            uVar.b("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + h.f(this.b) + " to " + a(str2), th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01eb A[Catch:{ all -> 0x01c8, all -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0224 A[Catch:{ all -> 0x01c8, all -> 0x0284 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void a(com.applovin.impl.sdk.network.c<T> r22, com.applovin.impl.sdk.network.b.a r23, com.applovin.impl.sdk.network.b.c<T> r24) {
        /*
            r21 = this;
            r13 = r21
            r14 = r24
            java.lang.String r1 = "Failed to gzip POST body for request "
            java.lang.String r2 = "Request to "
            java.lang.String r0 = "Sending "
            if (r22 == 0) goto L_0x02b7
            java.lang.String r3 = r22.a()
            java.lang.String r15 = r22.b()
            if (r3 == 0) goto L_0x02af
            if (r15 == 0) goto L_0x02a7
            if (r14 == 0) goto L_0x029f
            java.lang.String r4 = r3.toLowerCase()
            java.lang.String r5 = "http"
            boolean r4 = r4.startsWith(r5)
            r12 = 0
            java.lang.String r5 = "ConnectionManager"
            if (r4 != 0) goto L_0x004b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Requested postback submission to non HTTP endpoint "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = "; skipping..."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r1 = com.applovin.impl.sdk.u.a()
            if (r1 == 0) goto L_0x0045
            com.applovin.impl.sdk.u.i(r5, r0)
        L_0x0045:
            r1 = -900(0xfffffffffffffc7c, float:NaN)
            r14.a(r1, r0, r12)
            return
        L_0x004b:
            com.applovin.impl.sdk.m r4 = r13.b
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r6 = com.applovin.impl.sdk.d.b.cR
            java.lang.Object r4 = r4.a(r6)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = "https://"
            boolean r6 = r3.contains(r4)
            if (r6 != 0) goto L_0x007a
            boolean r6 = com.applovin.impl.sdk.u.a()
            if (r6 == 0) goto L_0x0074
            com.applovin.impl.sdk.m r6 = r13.b
            com.applovin.impl.sdk.u r6 = r6.A()
            java.lang.String r7 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r6.d(r5, r7)
        L_0x0074:
            java.lang.String r6 = "http://"
            java.lang.String r3 = r3.replace(r6, r4)
        L_0x007a:
            r4 = 2
            java.util.Map r4 = com.applovin.impl.sdk.utils.CollectionUtils.map((int) r4)
            boolean r7 = r22.n()
            com.applovin.impl.sdk.m r6 = r13.b
            long r8 = com.applovin.impl.sdk.utils.Utils.getServerAdjustedUnixTimestampMillis(r6)
            java.util.Map r6 = r22.c()
            if (r6 == 0) goto L_0x0099
            java.util.Map r6 = r22.c()
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x009f
        L_0x0099:
            int r6 = r22.i()
            if (r6 < 0) goto L_0x0102
        L_0x009f:
            java.util.Map r6 = r22.c()
            com.applovin.impl.sdk.m r10 = r13.b
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.d.b.dg
            java.lang.Object r10 = r10.a(r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r6 == 0) goto L_0x00c8
            int r11 = r22.i()
            if (r11 < 0) goto L_0x00c8
            int r11 = r22.i()
            if (r11 <= 0) goto L_0x00c8
            int r11 = r22.i()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r12 = "current_retry_attempt"
            r6.put(r12, r11)
        L_0x00c8:
            boolean r10 = r10.booleanValue()
            if (r7 == 0) goto L_0x00fe
            com.applovin.impl.sdk.m r11 = r13.b
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r12 = com.applovin.impl.sdk.d.b.dh
            java.lang.Object r11 = r11.a(r12)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            java.lang.String r6 = com.applovin.impl.sdk.utils.Utils.encodeUrlMap(r6, r10, r11)
            com.applovin.impl.sdk.m r10 = r13.b
            java.lang.String r10 = r10.z()
            java.lang.String r10 = com.applovin.impl.sdk.utils.m.a((java.lang.String) r6, (java.lang.String) r10, (long) r8)
            boolean r11 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r6)
            if (r11 == 0) goto L_0x00f7
            if (r10 != 0) goto L_0x00f7
            java.lang.String r11 = "query"
            r4.put(r11, r6)
        L_0x00f7:
            java.lang.String r6 = "p"
            java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.appendQueryParameter(r3, r6, r10)
            goto L_0x0102
        L_0x00fe:
            java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.appendQueryParameters(r3, r6, r10)
        L_0x0102:
            r12 = r3
            long r17 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r12)     // Catch:{ all -> 0x0284 }
            java.util.List<java.lang.String> r6 = a     // Catch:{ all -> 0x0284 }
            java.lang.Boolean r3 = com.applovin.impl.sdk.utils.StringUtils.endsWith(r3, r6)     // Catch:{ all -> 0x0284 }
            boolean r6 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0284 }
            if (r6 == 0) goto L_0x014d
            com.applovin.impl.sdk.u r6 = r13.c     // Catch:{ all -> 0x0284 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0284 }
            r10.<init>(r0)     // Catch:{ all -> 0x0284 }
            r10.append(r15)     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = " request to id=#"
            r10.append(r0)     // Catch:{ all -> 0x0284 }
            int r0 = r12.hashCode()     // Catch:{ all -> 0x0284 }
            r10.append(r0)     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = " \""
            r10.append(r0)     // Catch:{ all -> 0x0284 }
            boolean r0 = r3.booleanValue()     // Catch:{ all -> 0x0284 }
            if (r0 == 0) goto L_0x013a
            r0 = r12
            goto L_0x013e
        L_0x013a:
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r12)     // Catch:{ all -> 0x0284 }
        L_0x013e:
            r10.append(r0)     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = "\"..."
            r10.append(r0)     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x0284 }
            r6.c(r5, r0)     // Catch:{ all -> 0x0284 }
        L_0x014d:
            com.applovin.impl.sdk.network.e$b$a r0 = new com.applovin.impl.sdk.network.e$b$a     // Catch:{ all -> 0x0284 }
            r0.<init>()     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.a((java.lang.String) r12)     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.b((java.lang.String) r15)     // Catch:{ all -> 0x0284 }
            java.util.Map r3 = r22.d()     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x0284 }
            int r3 = r22.j()     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.network.e$b$a r11 = r0.a((int) r3)     // Catch:{ all -> 0x0284 }
            org.json.JSONObject r0 = r22.e()     // Catch:{ all -> 0x0284 }
            if (r0 == 0) goto L_0x022b
            if (r7 == 0) goto L_0x0194
            org.json.JSONObject r0 = r22.e()     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.m r3 = r13.b     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = r3.z()     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = com.applovin.impl.sdk.utils.m.a((java.lang.String) r0, (java.lang.String) r3, (long) r8)     // Catch:{ all -> 0x0284 }
            if (r0 != 0) goto L_0x019c
            java.lang.String r3 = "body"
            org.json.JSONObject r6 = r22.e()     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0284 }
            r4.put(r3, r6)     // Catch:{ all -> 0x0284 }
            goto L_0x019c
        L_0x0194:
            org.json.JSONObject r0 = r22.e()     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0284 }
        L_0x019c:
            r3 = r0
            boolean r0 = r22.o()     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = "UTF-8"
            if (r0 == 0) goto L_0x01e4
            if (r3 == 0) goto L_0x01e4
            int r0 = r3.length()     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.m r8 = r13.b     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.d.b<java.lang.Integer> r9 = com.applovin.impl.sdk.d.b.ew     // Catch:{ all -> 0x0284 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x0284 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0284 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0284 }
            if (r0 <= r8) goto L_0x01e4
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r6)     // Catch:{ all -> 0x01c8 }
            byte[] r0 = r3.getBytes(r0)     // Catch:{ all -> 0x01c8 }
            byte[] r0 = com.applovin.impl.sdk.utils.Utils.gzip(r0)     // Catch:{ all -> 0x01c8 }
            goto L_0x01e5
        L_0x01c8:
            r0 = move-exception
            boolean r8 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0284 }
            if (r8 == 0) goto L_0x01e4
            com.applovin.impl.sdk.u r8 = r13.c     // Catch:{ all -> 0x0284 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0284 }
            r9.<init>(r1)     // Catch:{ all -> 0x0284 }
            java.lang.String r1 = r13.a((java.lang.String) r12)     // Catch:{ all -> 0x0284 }
            r9.append(r1)     // Catch:{ all -> 0x0284 }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x0284 }
            r8.b(r5, r1, r0)     // Catch:{ all -> 0x0284 }
        L_0x01e4:
            r0 = 0
        L_0x01e5:
            boolean r1 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0284 }
            if (r1 == 0) goto L_0x0208
            com.applovin.impl.sdk.u r1 = r13.c     // Catch:{ all -> 0x0284 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0284 }
            r8.<init>(r2)     // Catch:{ all -> 0x0284 }
            java.lang.String r2 = r13.a((java.lang.String) r12)     // Catch:{ all -> 0x0284 }
            r8.append(r2)     // Catch:{ all -> 0x0284 }
            java.lang.String r2 = " is "
            r8.append(r2)     // Catch:{ all -> 0x0284 }
            r8.append(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x0284 }
            r1.b(r5, r2)     // Catch:{ all -> 0x0284 }
        L_0x0208:
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json; charset=utf-8"
            r11.a(r1, r2)     // Catch:{ all -> 0x0284 }
            boolean r1 = r22.o()     // Catch:{ all -> 0x0284 }
            if (r1 == 0) goto L_0x0222
            if (r0 == 0) goto L_0x0222
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r2 = "gzip"
            r11.a(r1, r2)     // Catch:{ all -> 0x0284 }
            r11.a((byte[]) r0)     // Catch:{ all -> 0x0284 }
            goto L_0x022b
        L_0x0222:
            if (r3 == 0) goto L_0x022b
            byte[] r0 = r3.getBytes(r6)     // Catch:{ all -> 0x0284 }
            r11.a((byte[]) r0)     // Catch:{ all -> 0x0284 }
        L_0x022b:
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0284 }
            if (r0 != 0) goto L_0x0245
            java.lang.String r0 = "request"
            java.lang.String r1 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r12)     // Catch:{ all -> 0x0284 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.m r0 = r13.b     // Catch:{ all -> 0x0284 }
            com.applovin.sdk.AppLovinEventService r0 = r0.w()     // Catch:{ all -> 0x0284 }
            java.lang.String r1 = "ref"
            r0.trackEvent(r1, r4)     // Catch:{ all -> 0x0284 }
        L_0x0245:
            com.applovin.impl.sdk.network.e r0 = r13.d     // Catch:{ all -> 0x0284 }
            com.applovin.impl.sdk.network.b$b r10 = new com.applovin.impl.sdk.network.b$b     // Catch:{ all -> 0x0284 }
            java.lang.Object r6 = r22.g()     // Catch:{ all -> 0x0284 }
            r19 = 0
            r1 = r10
            r2 = r21
            r3 = r12
            r4 = r22
            r5 = r15
            r8 = r17
            r20 = r10
            r10 = r23
            r14 = r11
            r11 = r24
            r16 = r12
            r12 = r19
            r1.<init>(r3, r4, r5, r6, r7, r8, r10, r11)     // Catch:{ all -> 0x0282 }
            r1 = r20
            com.applovin.impl.sdk.network.e$b$a r1 = r14.a((androidx.core.util.Consumer<com.applovin.impl.sdk.network.e.c>) r1)     // Catch:{ all -> 0x0282 }
            com.applovin.impl.sdk.m r2 = r13.b     // Catch:{ all -> 0x0282 }
            com.applovin.impl.sdk.f.o r2 = r2.S()     // Catch:{ all -> 0x0282 }
            java.util.concurrent.Executor r2 = r2.b()     // Catch:{ all -> 0x0282 }
            com.applovin.impl.sdk.network.e$b$a r1 = r1.a((java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0282 }
            com.applovin.impl.sdk.network.e$b r1 = r1.a()     // Catch:{ all -> 0x0282 }
            r0.a(r1)     // Catch:{ all -> 0x0282 }
            goto L_0x029e
        L_0x0282:
            r0 = move-exception
            goto L_0x0287
        L_0x0284:
            r0 = move-exception
            r16 = r12
        L_0x0287:
            r4 = 0
            r1 = r21
            r2 = r15
            r3 = r16
            r5 = r17
            r7 = r0
            r1.a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5, (java.lang.Throwable) r7)
            r1 = 0
            java.lang.String r0 = r0.getMessage()
            r2 = r24
            r3 = 0
            r2.a(r1, r0, r3)
        L_0x029e:
            return
        L_0x029f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No callback specified"
            r0.<init>(r1)
            throw r0
        L_0x02a7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No method specified"
            r0.<init>(r1)
            throw r0
        L_0x02af:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No endpoint specified"
            r0.<init>(r1)
            throw r0
        L_0x02b7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No request specified"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.b.a(com.applovin.impl.sdk.network.c, com.applovin.impl.sdk.network.b$a, com.applovin.impl.sdk.network.b$c):void");
    }
}
