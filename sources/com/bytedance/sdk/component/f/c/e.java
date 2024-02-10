package com.bytedance.sdk.component.f.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.f.d.b;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TNCManager */
public class e {
    Handler a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 10000) {
                e.this.b(message.arg1 != 0);
            }
        }
    };
    private long b = 0;
    private a c;
    private boolean d;
    private b e;
    private boolean f = false;
    private Context g;
    private d h;
    private int i = 0;
    private long j = 19700101000L;
    private int k = 0;
    private HashMap<String, Integer> l = new HashMap<>();
    private HashMap<String, Integer> m = new HashMap<>();
    private int n = 0;
    private HashMap<String, Integer> o = new HashMap<>();
    private HashMap<String, Integer> p = new HashMap<>();
    private boolean q = true;
    private Map<String, Integer> r = new HashMap();
    private int s;

    private e() {
    }

    public e(int i2) {
        this.s = i2;
    }

    private String a(l lVar) {
        if (lVar == null || lVar.b() == null || lVar.b().a() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(lVar.b().a().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bytedance.sdk.component.b.a.n r12, java.lang.String r13) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = r11.q
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            java.lang.String r0 = "tnc-cmd"
            r1 = 0
            java.lang.String r12 = r12.a(r0, r1)
            r0 = r12
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "TNCManager"
            if (r0 == 0) goto L_0x002c
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "handleTncProbe, no probeProto, "
            r12.<init>(r0)
        L_0x0021:
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.bytedance.sdk.component.f.d.b.b(r1, r12)
            return
        L_0x002c:
            java.lang.String r0 = "@"
            java.lang.String[] r12 = r12.split(r0)
            if (r12 == 0) goto L_0x00fd
            int r2 = r12.length
            r3 = 2
            if (r2 == r3) goto L_0x003a
            goto L_0x00fd
        L_0x003a:
            r2 = 1
            r3 = 0
            r5 = 0
            r6 = r12[r5]     // Catch:{ all -> 0x004d }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ all -> 0x004d }
            r12 = r12[r2]     // Catch:{ all -> 0x004b }
            long r7 = java.lang.Long.parseLong(r12)     // Catch:{ all -> 0x004b }
            goto L_0x0064
        L_0x004b:
            r12 = move-exception
            goto L_0x004f
        L_0x004d:
            r12 = move-exception
            r6 = 0
        L_0x004f:
            r12.printStackTrace()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r7 = "handleTncProbe, probeProto except, "
            r12.<init>(r7)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.bytedance.sdk.component.f.d.b.b(r1, r12)
            r7 = r3
        L_0x0064:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r9 = "handleTncProbe, local: "
            r12.<init>(r9)
            int r9 = r11.i
            r12.append(r9)
            r12.append(r0)
            long r9 = r11.j
            r12.append(r9)
            java.lang.String r9 = " svr: "
            r12.append(r9)
            r12.append(r6)
            r12.append(r0)
            r12.append(r7)
            java.lang.String r0 = " "
            r12.append(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.bytedance.sdk.component.f.d.b.b(r1, r12)
            long r9 = r11.j
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 > 0) goto L_0x009c
            return
        L_0x009c:
            r11.i = r6
            r11.j = r7
            android.content.Context r12 = r11.g
            java.lang.String r9 = r11.a()
            android.content.SharedPreferences r12 = r12.getSharedPreferences(r9, r5)
            android.content.SharedPreferences$Editor r12 = r12.edit()
            java.lang.String r5 = "tnc_probe_cmd"
            android.content.SharedPreferences$Editor r12 = r12.putInt(r5, r6)
            java.lang.String r5 = "tnc_probe_version"
            android.content.SharedPreferences$Editor r12 = r12.putLong(r5, r7)
            r12.apply()
            int r12 = r11.i
            r5 = 10000(0x2710, float:1.4013E-41)
            if (r12 != r5) goto L_0x00fc
            com.bytedance.sdk.component.f.c.c r12 = r11.f()
            if (r12 != 0) goto L_0x00ca
            return
        L_0x00ca:
            java.util.Random r5 = new java.util.Random
            long r6 = java.lang.System.currentTimeMillis()
            r5.<init>(r6)
            int r6 = r12.l
            if (r6 <= 0) goto L_0x00e2
            int r12 = r12.l
            int r12 = r5.nextInt(r12)
            long r3 = (long) r12
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
        L_0x00e2:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r5 = "handleTncProbe, updateConfig delay: "
            r12.<init>(r5)
            r12.append(r3)
            r12.append(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.bytedance.sdk.component.f.d.b.b(r1, r12)
            r11.a((boolean) r2, (long) r3)
        L_0x00fc:
            return
        L_0x00fd:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "handleTncProbe, probeProto err, "
            r12.<init>(r0)
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.a(com.bytedance.sdk.component.b.a.n, java.lang.String):void");
    }

    private void a(boolean z, long j2) {
        if (!this.a.hasMessages(10000)) {
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.what = 10000;
            obtainMessage.arg1 = z ? 1 : 0;
            if (j2 > 0) {
                this.a.sendMessageDelayed(obtainMessage, j2);
            } else {
                this.a.sendMessage(obtainMessage);
            }
        }
    }

    private boolean a(int i2) {
        return i2 >= 200 && i2 < 400;
    }

    private void b(String str) {
        Map<String, String> g2;
        if (TextUtils.isEmpty(str) || (g2 = g()) == null || !g2.containsValue(str)) {
            return;
        }
        if (this.r.get(str) == null) {
            this.r.put(str, 1);
            return;
        }
        this.r.put(str, Integer.valueOf(this.r.get(str).intValue() + 1));
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        c f2 = f();
        if (f2 != null) {
            b.b("TNCManager", "doUpdateRemote, " + z);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.b + (((long) f2.k) * 1000) <= elapsedRealtime) {
                this.b = elapsedRealtime;
                g.a().a(this.s, this.g).c();
                return;
            }
            b.b("TNCManager", "doUpdateRemote, time limit");
        }
    }

    private boolean b(int i2) {
        if (i2 < 100 || i2 >= 1000) {
            return true;
        }
        c f2 = f();
        if (f2 == null || TextUtils.isEmpty(f2.m)) {
            return false;
        }
        String str = f2.m;
        StringBuilder sb = new StringBuilder("");
        sb.append(i2);
        return str.contains(sb.toString());
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && this.r.containsKey(str)) {
            this.r.put(str, 0);
        }
    }

    private boolean d(String str) {
        Map<String, String> g2 = g();
        if (g2 == null) {
            return false;
        }
        String str2 = g2.get(str);
        if (TextUtils.isEmpty(str2) || this.r.get(str2) == null || this.r.get(str2).intValue() < 3) {
            return false;
        }
        b.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
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
    public static java.lang.String e1699434667871dc(java.lang.String r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.e1699434667871dc(java.lang.String):java.lang.String");
    }

    private void i() {
        SharedPreferences sharedPreferences = this.g.getSharedPreferences(a(), 0);
        this.i = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.j = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void j() {
        b.b("TNCManager", "resetTNCControlState");
        this.k = 0;
        this.l.clear();
        this.m.clear();
        this.n = 0;
        this.o.clear();
        this.p.clear();
    }

    public String a() {
        return "ttnet_tnc_config" + this.s;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00f2
            java.lang.String r0 = "/network/get_network"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto L_0x00f2
            java.lang.String r0 = "/get_domains/v4"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto L_0x00f2
            java.lang.String r0 = "/ies/speed"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x0029
            goto L_0x00f2
        L_0x0029:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x003a }
            r1.<init>(r7)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r1.getProtocol()     // Catch:{ all -> 0x003a }
            java.lang.String r0 = r1.getHost()     // Catch:{ all -> 0x0038 }
            goto L_0x003f
        L_0x0038:
            r1 = move-exception
            goto L_0x003c
        L_0x003a:
            r1 = move-exception
            r2 = r0
        L_0x003c:
            r1.printStackTrace()
        L_0x003f:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00f2
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00f2
        L_0x0058:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0063
            goto L_0x00f2
        L_0x0063:
            boolean r1 = r6.d(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L_0x007d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "handleHostMapping, TNC host faild num over limit: "
            r1.<init>(r2)
        L_0x0072:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0079:
            com.bytedance.sdk.component.f.d.b.b(r3, r0)
            return r7
        L_0x007d:
            java.util.Map r1 = r6.g()
            if (r1 == 0) goto L_0x00ea
            boolean r4 = r1.containsKey(r0)
            if (r4 != 0) goto L_0x008a
            goto L_0x00ea
        L_0x008a:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x009a
            return r7
        L_0x009a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "handleHostMapping, match, origin: "
            r4.<init>(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.bytedance.sdk.component.f.d.b.b(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "://"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            boolean r2 = r7.startsWith(r0)
            if (r2 == 0) goto L_0x00db
            java.lang.String r7 = r7.replaceFirst(r0, r1)
        L_0x00db:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "handleHostMapping, target: "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            goto L_0x0079
        L_0x00ea:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "handleHostMapping, nomatch: "
            r1.<init>(r2)
            goto L_0x0072
        L_0x00f2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.a(java.lang.String):java.lang.String");
    }

    public synchronized void a(Context context, boolean z) {
        if (!this.f) {
            this.g = context;
            this.q = z;
            this.h = new d(context, z, this.s);
            if (z) {
                i();
            }
            b.b("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.i + " probeVersion: " + this.j);
            this.c = g.a().a(this.s, this.g);
            this.f = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0190, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0195, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bytedance.sdk.component.b.a.l r10, com.bytedance.sdk.component.b.a.n r11) {
        /*
            r9 = this;
            java.lang.String r0 = "onResponse, url doUpdate: "
            java.lang.String r1 = "onResponse, url matched: "
            java.lang.String r2 = "onResponse, url: "
            monitor-enter(r9)
            if (r10 == 0) goto L_0x0194
            if (r11 != 0) goto L_0x000d
            goto L_0x0194
        L_0x000d:
            boolean r3 = r9.q     // Catch:{ all -> 0x0191 }
            if (r3 != 0) goto L_0x0013
            monitor-exit(r9)
            return
        L_0x0013:
            android.content.Context r3 = r9.g     // Catch:{ all -> 0x0191 }
            boolean r3 = com.bytedance.sdk.component.f.d.e.a(r3)     // Catch:{ all -> 0x0191 }
            if (r3 != 0) goto L_0x001d
            monitor-exit(r9)
            return
        L_0x001d:
            com.bytedance.sdk.component.b.a.g r3 = r10.b()     // Catch:{ Exception -> 0x0026 }
            java.net.URL r3 = r3.a()     // Catch:{ Exception -> 0x0026 }
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            if (r3 != 0) goto L_0x002b
            monitor-exit(r9)
            return
        L_0x002b:
            java.lang.String r4 = r3.getProtocol()     // Catch:{ all -> 0x0191 }
            java.lang.String r5 = r3.getHost()     // Catch:{ all -> 0x0191 }
            java.lang.String r3 = r3.getPath()     // Catch:{ all -> 0x0191 }
            java.lang.String r10 = r9.a((com.bytedance.sdk.component.b.a.l) r10)     // Catch:{ all -> 0x0191 }
            int r6 = r11.c()     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = "http"
            boolean r7 = r7.equals(r4)     // Catch:{ all -> 0x0191 }
            if (r7 != 0) goto L_0x0051
            java.lang.String r7 = "https"
            boolean r7 = r7.equals(r4)     // Catch:{ all -> 0x0191 }
            if (r7 != 0) goto L_0x0051
            monitor-exit(r9)
            return
        L_0x0051:
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0191 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0191 }
            if (r7 == 0) goto L_0x005c
            monitor-exit(r9)
            return
        L_0x005c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0191 }
            r7.<init>(r2)     // Catch:{ all -> 0x0191 }
            java.lang.String r2 = "TNCManager"
            r7.append(r4)     // Catch:{ all -> 0x0191 }
            java.lang.String r8 = "://"
            r7.append(r8)     // Catch:{ all -> 0x0191 }
            r7.append(r5)     // Catch:{ all -> 0x0191 }
            java.lang.String r8 = "#"
            r7.append(r8)     // Catch:{ all -> 0x0191 }
            r7.append(r10)     // Catch:{ all -> 0x0191 }
            java.lang.String r8 = "#"
            r7.append(r8)     // Catch:{ all -> 0x0191 }
            r7.append(r6)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0191 }
            com.bytedance.sdk.component.f.d.b.b(r2, r7)     // Catch:{ all -> 0x0191 }
            com.bytedance.sdk.component.f.c.c r2 = r9.f()     // Catch:{ all -> 0x0191 }
            if (r2 == 0) goto L_0x0092
            boolean r7 = r2.b     // Catch:{ all -> 0x0191 }
            if (r7 == 0) goto L_0x0092
            r9.a((com.bytedance.sdk.component.b.a.n) r11, (java.lang.String) r5)     // Catch:{ all -> 0x0191 }
        L_0x0092:
            if (r2 != 0) goto L_0x0096
            monitor-exit(r9)
            return
        L_0x0096:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0191 }
            r11.<init>(r1)     // Catch:{ all -> 0x0191 }
            java.lang.String r1 = "TNCManager"
            r11.append(r4)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = "://"
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            r11.append(r5)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = "#"
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            r11.append(r10)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = "#"
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            r11.append(r6)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = " "
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            int r7 = r9.k     // Catch:{ all -> 0x0191 }
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = "#"
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r9.l     // Catch:{ all -> 0x0191 }
            int r7 = r7.size()     // Catch:{ all -> 0x0191 }
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = "#"
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r9.m     // Catch:{ all -> 0x0191 }
            int r7 = r7.size()     // Catch:{ all -> 0x0191 }
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = " "
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            int r7 = r9.n     // Catch:{ all -> 0x0191 }
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = "#"
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r9.o     // Catch:{ all -> 0x0191 }
            int r7 = r7.size()     // Catch:{ all -> 0x0191 }
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = "#"
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r9.p     // Catch:{ all -> 0x0191 }
            int r7 = r7.size()     // Catch:{ all -> 0x0191 }
            r11.append(r7)     // Catch:{ all -> 0x0191 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0191 }
            com.bytedance.sdk.component.f.d.b.b(r1, r11)     // Catch:{ all -> 0x0191 }
            if (r6 <= 0) goto L_0x018f
            boolean r11 = r9.a((int) r6)     // Catch:{ all -> 0x0191 }
            if (r11 == 0) goto L_0x0122
            int r10 = r9.k     // Catch:{ all -> 0x0191 }
            if (r10 > 0) goto L_0x011b
            int r10 = r9.n     // Catch:{ all -> 0x0191 }
            if (r10 <= 0) goto L_0x011e
        L_0x011b:
            r9.j()     // Catch:{ all -> 0x0191 }
        L_0x011e:
            r9.c(r5)     // Catch:{ all -> 0x0191 }
            goto L_0x018f
        L_0x0122:
            boolean r11 = r9.b((int) r6)     // Catch:{ all -> 0x0191 }
            if (r11 != 0) goto L_0x018f
            int r11 = r9.n     // Catch:{ all -> 0x0191 }
            int r11 = r11 + 1
            r9.n = r11     // Catch:{ all -> 0x0191 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r11 = r9.o     // Catch:{ all -> 0x0191 }
            r1 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0191 }
            r11.put(r3, r7)     // Catch:{ all -> 0x0191 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r11 = r9.p     // Catch:{ all -> 0x0191 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0191 }
            r11.put(r10, r3)     // Catch:{ all -> 0x0191 }
            int r11 = r9.n     // Catch:{ all -> 0x0191 }
            int r3 = r2.h     // Catch:{ all -> 0x0191 }
            if (r11 < r3) goto L_0x018c
            java.util.HashMap<java.lang.String, java.lang.Integer> r11 = r9.o     // Catch:{ all -> 0x0191 }
            int r11 = r11.size()     // Catch:{ all -> 0x0191 }
            int r3 = r2.i     // Catch:{ all -> 0x0191 }
            if (r11 < r3) goto L_0x018c
            java.util.HashMap<java.lang.String, java.lang.Integer> r11 = r9.p     // Catch:{ all -> 0x0191 }
            int r11 = r11.size()     // Catch:{ all -> 0x0191 }
            int r2 = r2.j     // Catch:{ all -> 0x0191 }
            if (r11 < r2) goto L_0x018c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0191 }
            r11.<init>(r0)     // Catch:{ all -> 0x0191 }
            java.lang.String r0 = "TNCManager"
            r11.append(r4)     // Catch:{ all -> 0x0191 }
            java.lang.String r2 = "://"
            r11.append(r2)     // Catch:{ all -> 0x0191 }
            r11.append(r5)     // Catch:{ all -> 0x0191 }
            java.lang.String r2 = "#"
            r11.append(r2)     // Catch:{ all -> 0x0191 }
            r11.append(r10)     // Catch:{ all -> 0x0191 }
            java.lang.String r10 = "#"
            r11.append(r10)     // Catch:{ all -> 0x0191 }
            r11.append(r6)     // Catch:{ all -> 0x0191 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0191 }
            com.bytedance.sdk.component.f.d.b.b(r0, r10)     // Catch:{ all -> 0x0191 }
            r10 = 0
            r9.a((boolean) r1, (long) r10)     // Catch:{ all -> 0x0191 }
            r9.j()     // Catch:{ all -> 0x0191 }
        L_0x018c:
            r9.b((java.lang.String) r5)     // Catch:{ all -> 0x0191 }
        L_0x018f:
            monitor-exit(r9)
            return
        L_0x0191:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x0194:
            monitor-exit(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.a(com.bytedance.sdk.component.b.a.l, com.bytedance.sdk.component.b.a.n):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bytedance.sdk.component.b.a.l r8, java.lang.Exception r9) {
        /*
            r7 = this;
            java.lang.String r0 = "onError, url doUpate: "
            java.lang.String r1 = "onError, url matched: "
            monitor-enter(r7)
            if (r8 == 0) goto L_0x012a
            com.bytedance.sdk.component.b.a.g r2 = r8.b()     // Catch:{ all -> 0x0127 }
            if (r2 == 0) goto L_0x012a
            if (r9 != 0) goto L_0x0011
            goto L_0x012a
        L_0x0011:
            boolean r9 = r7.q     // Catch:{ all -> 0x0127 }
            if (r9 != 0) goto L_0x0017
            monitor-exit(r7)
            return
        L_0x0017:
            android.content.Context r9 = r7.g     // Catch:{ all -> 0x0127 }
            boolean r9 = com.bytedance.sdk.component.f.d.e.a(r9)     // Catch:{ all -> 0x0127 }
            if (r9 != 0) goto L_0x0021
            monitor-exit(r7)
            return
        L_0x0021:
            com.bytedance.sdk.component.b.a.g r9 = r8.b()     // Catch:{ Exception -> 0x002a }
            java.net.URL r9 = r9.a()     // Catch:{ Exception -> 0x002a }
            goto L_0x002b
        L_0x002a:
            r9 = 0
        L_0x002b:
            if (r9 != 0) goto L_0x002f
            monitor-exit(r7)
            return
        L_0x002f:
            java.lang.String r2 = r9.getProtocol()     // Catch:{ all -> 0x0127 }
            java.lang.String r3 = r9.getHost()     // Catch:{ all -> 0x0127 }
            java.lang.String r9 = r9.getPath()     // Catch:{ all -> 0x0127 }
            java.lang.String r8 = r7.a((com.bytedance.sdk.component.b.a.l) r8)     // Catch:{ all -> 0x0127 }
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0127 }
            if (r4 != 0) goto L_0x0051
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0127 }
            if (r4 != 0) goto L_0x0051
            monitor-exit(r7)
            return
        L_0x0051:
            com.bytedance.sdk.component.f.c.c r4 = r7.f()     // Catch:{ all -> 0x0127 }
            if (r4 != 0) goto L_0x0059
            monitor-exit(r7)
            return
        L_0x0059:
            java.lang.String r5 = "TNCManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r6.<init>(r1)     // Catch:{ all -> 0x0127 }
            r6.append(r2)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = "://"
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            r6.append(r3)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = "#"
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            r6.append(r8)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = "# "
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            int r1 = r7.k     // Catch:{ all -> 0x0127 }
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = "#"
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r7.l     // Catch:{ all -> 0x0127 }
            int r1 = r1.size()     // Catch:{ all -> 0x0127 }
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = "#"
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r7.m     // Catch:{ all -> 0x0127 }
            int r1 = r1.size()     // Catch:{ all -> 0x0127 }
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = " "
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            int r1 = r7.n     // Catch:{ all -> 0x0127 }
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = "#"
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r7.o     // Catch:{ all -> 0x0127 }
            int r1 = r1.size()     // Catch:{ all -> 0x0127 }
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = "#"
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r7.p     // Catch:{ all -> 0x0127 }
            int r1 = r1.size()     // Catch:{ all -> 0x0127 }
            r6.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0127 }
            com.bytedance.sdk.component.f.d.b.b(r5, r1)     // Catch:{ all -> 0x0127 }
            int r1 = r7.k     // Catch:{ all -> 0x0127 }
            int r1 = r1 + 1
            r7.k = r1     // Catch:{ all -> 0x0127 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r7.l     // Catch:{ all -> 0x0127 }
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0127 }
            r1.put(r9, r6)     // Catch:{ all -> 0x0127 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.m     // Catch:{ all -> 0x0127 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0127 }
            r9.put(r8, r1)     // Catch:{ all -> 0x0127 }
            int r9 = r7.k     // Catch:{ all -> 0x0127 }
            int r1 = r4.e     // Catch:{ all -> 0x0127 }
            if (r9 < r1) goto L_0x0122
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.l     // Catch:{ all -> 0x0127 }
            int r9 = r9.size()     // Catch:{ all -> 0x0127 }
            int r1 = r4.f     // Catch:{ all -> 0x0127 }
            if (r9 < r1) goto L_0x0122
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r7.m     // Catch:{ all -> 0x0127 }
            int r9 = r9.size()     // Catch:{ all -> 0x0127 }
            int r1 = r4.g     // Catch:{ all -> 0x0127 }
            if (r9 < r1) goto L_0x0122
            java.lang.String r9 = "TNCManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r1.<init>(r0)     // Catch:{ all -> 0x0127 }
            r1.append(r2)     // Catch:{ all -> 0x0127 }
            java.lang.String r0 = "://"
            r1.append(r0)     // Catch:{ all -> 0x0127 }
            r1.append(r3)     // Catch:{ all -> 0x0127 }
            java.lang.String r0 = "#"
            r1.append(r0)     // Catch:{ all -> 0x0127 }
            r1.append(r8)     // Catch:{ all -> 0x0127 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0127 }
            com.bytedance.sdk.component.f.d.b.b(r9, r8)     // Catch:{ all -> 0x0127 }
            r8 = 0
            r7.a((boolean) r5, (long) r8)     // Catch:{ all -> 0x0127 }
            r7.j()     // Catch:{ all -> 0x0127 }
        L_0x0122:
            r7.b((java.lang.String) r3)     // Catch:{ all -> 0x0127 }
            monitor-exit(r7)
            return
        L_0x0127:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x012a:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.e.a(com.bytedance.sdk.component.b.a.l, java.lang.Exception):void");
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public a b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public b d() {
        return this.e;
    }

    public void e() {
        this.r.clear();
    }

    public c f() {
        d dVar = this.h;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public Map<String, String> g() {
        c f2 = f();
        if (f2 != null) {
            return f2.d;
        }
        return null;
    }

    public d h() {
        return this.h;
    }
}
