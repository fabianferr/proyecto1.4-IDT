package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.b.a;
import com.mbridge.msdk.c.a.b;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.d;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SDKController */
public class c {
    private static volatile c h;
    public final int a = 1;
    public final int b = 2;
    public final int c = 3;
    public final int d = 4;
    public final int e = 5;
    public final int f = 6;
    Handler g = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            List list;
            try {
                int i = message.what;
                if (i != 2) {
                    if (i == 3) {
                        File file = (File) message.obj;
                        if (file != null) {
                            String a2 = y.a(file);
                            if (!TextUtils.isEmpty(a2)) {
                                String[] split = a2.split("====");
                                if (split.length > 0) {
                                    new p(c.this.i).a(split[0], file);
                                }
                            }
                        }
                    } else if (i == 4) {
                        String str = (String) message.obj;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (k.a().c()) {
                            k.a().a(str);
                        } else {
                            new p(c.this.i, 0).a("click_duration", str, (String) null, (Frame) null);
                        }
                    } else if (i == 5) {
                        String str2 = (String) message.obj;
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        if (k.a().c()) {
                            k.a().a(str2);
                        } else {
                            new p(c.this.i, 0).a("load_duration", str2, (String) null, (Frame) null);
                        }
                    } else if (i != 6) {
                        if (i == 9) {
                            e eVar = (e) message.obj;
                            d f = b.d().f();
                            if (f != null && f.a() && eVar != null && eVar.M() == 1) {
                                com.mbridge.msdk.foundation.same.report.b.d.a(c.this.i).a();
                            }
                            if (f != null && f.b()) {
                                com.mbridge.msdk.foundation.same.report.b.c.a();
                            }
                        }
                    } else if (message.obj != null && (message.obj instanceof String)) {
                        String str3 = (String) message.obj;
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        if (k.a().c()) {
                            k.a().a(str3);
                        } else {
                            new p(c.this.i, 0).a("device_data", str3, (String) null, (Frame) null);
                        }
                    }
                } else if ((message.obj instanceof List) && (list = (List) message.obj) != null && list.size() > 0) {
                    p pVar = new p(c.this.i, 0);
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        l lVar = (l) list.get(i2);
                        boolean z = false;
                        if (i2 == list.size() - 1) {
                            z = true;
                        }
                        pVar.a(lVar, z);
                    }
                }
            } catch (Exception e) {
                aa.d("SDKController", e.getMessage());
            }
        }
    };
    /* access modifiers changed from: private */
    public Context i;
    private String j;
    /* access modifiers changed from: private */
    public String k;
    private String l;
    private String m;
    private boolean n = false;
    private a o;
    private String p;
    private boolean q = false;
    private AtomicBoolean r = null;
    private FastKV s = null;
    private Map<String, Object> t;
    private int u;

    private c() {
    }

    public static c a() {
        if (h == null) {
            synchronized (c.class) {
                if (h == null) {
                    h = new c();
                }
            }
        }
        return h;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:92|93|94|95|98|99|(1:103)|104|(2:114|115)(2:108|(2:112|113))) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x030d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x0200 */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0230 A[Catch:{ Exception -> 0x01dd, all -> 0x0305 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x025a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0311 A[Catch:{ Exception -> 0x0339 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x031e A[Catch:{ Exception -> 0x0339 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Map r13, final android.content.Context r14) {
        /*
            r12 = this;
            java.lang.String r0 = "SDKController"
            java.lang.String r1 = ""
            if (r14 == 0) goto L_0x0373
            java.lang.String r2 = "mbridge_appid"
            boolean r3 = r13.containsKey(r2)
            if (r3 == 0) goto L_0x0016
            java.lang.Object r3 = r13.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            r12.k = r3
        L_0x0016:
            android.content.Context r3 = r14.getApplicationContext()
            r12.i = r3
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()
            android.content.Context r4 = r12.i
            r3.b((android.content.Context) r4)
            java.lang.Object r3 = r13.get(r2)     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            if (r4 != 0) goto L_0x0044
            com.mbridge.msdk.foundation.a.a.a r4 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            java.lang.String r5 = "sdk_app_id"
            r4.a((java.lang.String) r5, (java.lang.String) r3)     // Catch:{ Exception -> 0x0040, all -> 0x003b }
            goto L_0x0044
        L_0x003b:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0044
        L_0x0040:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0044:
            android.content.Context r3 = r12.i     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.foundation.same.net.o.a((android.content.Context) r3)     // Catch:{ Exception -> 0x004a }
            goto L_0x004b
        L_0x004a:
        L_0x004b:
            boolean r3 = r12.n
            r4 = 1
            if (r3 != r4) goto L_0x0059
            com.mbridge.msdk.foundation.same.report.p r13 = new com.mbridge.msdk.foundation.same.report.p
            r13.<init>(r14)
            r13.a()
            return
        L_0x0059:
            com.mbridge.msdk.foundation.tools.w.q(r14)
            if (r13 == 0) goto L_0x0354
            boolean r3 = r13.containsKey(r2)
            if (r3 == 0) goto L_0x006c
            java.lang.Object r2 = r13.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r12.k = r2
        L_0x006c:
            java.lang.String r2 = "mbridge_appkey"
            boolean r3 = r13.containsKey(r2)
            if (r3 == 0) goto L_0x007c
            java.lang.Object r2 = r13.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r12.l = r2
        L_0x007c:
            java.lang.String r2 = "mbridge_wx_appid"
            boolean r3 = r13.containsKey(r2)
            if (r3 == 0) goto L_0x008c
            java.lang.Object r2 = r13.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r12.m = r2
        L_0x008c:
            java.lang.String r2 = "applicationID"
            boolean r3 = r13.containsKey(r2)
            if (r3 == 0) goto L_0x009c
            java.lang.Object r2 = r13.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r12.p = r2
        L_0x009c:
            java.lang.String r2 = "mbridge_appstartupcarsh"
            boolean r3 = r13.containsKey(r2)
            if (r3 == 0) goto L_0x00ac
            java.lang.Object r13 = r13.get(r2)
            java.lang.String r13 = (java.lang.String) r13
            r12.j = r13
        L_0x00ac:
            r13 = 0
            com.mbridge.msdk.c.f r2 = com.mbridge.msdk.c.f.a()     // Catch:{ all -> 0x0157 }
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0157 }
            java.lang.String r3 = r3.h()     // Catch:{ all -> 0x0157 }
            com.mbridge.msdk.c.e r2 = r2.b(r3)     // Catch:{ all -> 0x0157 }
            if (r2 == 0) goto L_0x015f
            java.util.List r2 = r2.b()     // Catch:{ all -> 0x0157 }
            if (r2 == 0) goto L_0x015f
            int r3 = r2.size()     // Catch:{ all -> 0x0157 }
            if (r3 <= 0) goto L_0x015f
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0157 }
        L_0x00cf:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0157 }
            if (r3 == 0) goto L_0x015f
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0157 }
            com.mbridge.msdk.foundation.entity.a r3 = (com.mbridge.msdk.foundation.entity.a) r3     // Catch:{ all -> 0x0157 }
            int r5 = r3.a()     // Catch:{ all -> 0x0157 }
            r6 = 287(0x11f, float:4.02E-43)
            java.lang.String r7 = "loadFormSelfFilling"
            r8 = 2
            if (r5 != r6) goto L_0x011c
            java.lang.String r5 = "com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0157 }
            android.content.Context r6 = r12.i     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x00cf
            if (r5 == 0) goto L_0x00cf
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ all -> 0x0157 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r6[r13] = r9     // Catch:{ all -> 0x0157 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r6[r4] = r9     // Catch:{ all -> 0x0157 }
            java.lang.reflect.Constructor r6 = r5.getConstructor(r6)     // Catch:{ all -> 0x0157 }
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0157 }
            r8[r13] = r1     // Catch:{ all -> 0x0157 }
            java.lang.String r3 = r3.b()     // Catch:{ all -> 0x0157 }
            r8[r4] = r3     // Catch:{ all -> 0x0157 }
            java.lang.Object r3 = r6.newInstance(r8)     // Catch:{ all -> 0x0157 }
            if (r3 == 0) goto L_0x00cf
            java.lang.Class[] r6 = new java.lang.Class[r13]     // Catch:{ all -> 0x0157 }
            java.lang.reflect.Method r5 = r5.getMethod(r7, r6)     // Catch:{ all -> 0x0157 }
            java.lang.Object[] r6 = new java.lang.Object[r13]     // Catch:{ all -> 0x0157 }
            r5.invoke(r3, r6)     // Catch:{ all -> 0x0157 }
            goto L_0x00cf
        L_0x011c:
            int r5 = r3.a()     // Catch:{ all -> 0x0157 }
            r6 = 94
            if (r5 != r6) goto L_0x00cf
            java.lang.String r5 = "com.mbridge.msdk.out.MBRewardVideoHandler"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0157 }
            if (r5 == 0) goto L_0x00cf
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ all -> 0x0157 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r6[r13] = r9     // Catch:{ all -> 0x0157 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r6[r4] = r9     // Catch:{ all -> 0x0157 }
            java.lang.reflect.Constructor r6 = r5.getConstructor(r6)     // Catch:{ all -> 0x0157 }
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0157 }
            r8[r13] = r1     // Catch:{ all -> 0x0157 }
            java.lang.String r3 = r3.b()     // Catch:{ all -> 0x0157 }
            r8[r4] = r3     // Catch:{ all -> 0x0157 }
            java.lang.Object r3 = r6.newInstance(r8)     // Catch:{ all -> 0x0157 }
            if (r3 == 0) goto L_0x00cf
            java.lang.Class[] r6 = new java.lang.Class[r13]     // Catch:{ all -> 0x0157 }
            java.lang.reflect.Method r5 = r5.getMethod(r7, r6)     // Catch:{ all -> 0x0157 }
            java.lang.Object[] r6 = new java.lang.Object[r13]     // Catch:{ all -> 0x0157 }
            r5.invoke(r3, r6)     // Catch:{ all -> 0x0157 }
            goto L_0x00cf
        L_0x0157:
            r2 = move-exception
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x015f
            r2.printStackTrace()
        L_0x015f:
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r12.k
            r2.c((java.lang.String) r3)
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r12.l
            r2.e(r3)
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r12.m
            r2.d(r3)
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r12.p
            r2.b((java.lang.String) r3)
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()
            com.mbridge.msdk.foundation.controller.c$6 r3 = new com.mbridge.msdk.foundation.controller.c$6
            r3.<init>()
            android.os.Handler r5 = r12.g
            r2.a((com.mbridge.msdk.foundation.controller.b.a) r3, (android.os.Handler) r5)
            android.content.Context r2 = r12.i
            android.content.Context r2 = r2.getApplicationContext()
            com.iab.omid.library.mmadbridge.Omid.activate(r2)     // Catch:{ IllegalArgumentException -> 0x01b3 }
            boolean r3 = com.iab.omid.library.mmadbridge.Omid.isActive()     // Catch:{ IllegalArgumentException -> 0x01b3 }
            if (r3 != 0) goto L_0x01bb
            com.mbridge.msdk.foundation.same.report.p r5 = new com.mbridge.msdk.foundation.same.report.p     // Catch:{ IllegalArgumentException -> 0x01b3 }
            r5.<init>(r2, r13)     // Catch:{ IllegalArgumentException -> 0x01b3 }
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = "activate om failed"
            r5.a((java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10)     // Catch:{ IllegalArgumentException -> 0x01b3 }
            goto L_0x01bb
        L_0x01b3:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r3, r2)
        L_0x01bb:
            android.content.Context r2 = r12.i
            android.content.Context r2 = r2.getApplicationContext()
            com.mbridge.msdk.foundation.tools.FastKV r3 = r12.s     // Catch:{ all -> 0x0305 }
            java.lang.String r5 = "H+tU+FeXHM=="
            if (r3 != 0) goto L_0x01e0
            com.mbridge.msdk.foundation.tools.FastKV$Builder r3 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x01dd }
            com.mbridge.msdk.foundation.same.b.c r6 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x01dd }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.b.e.b(r6)     // Catch:{ Exception -> 0x01dd }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.u.b(r5)     // Catch:{ Exception -> 0x01dd }
            r3.<init>(r6, r7)     // Catch:{ Exception -> 0x01dd }
            com.mbridge.msdk.foundation.tools.FastKV r3 = r3.build()     // Catch:{ Exception -> 0x01dd }
            r12.s = r3     // Catch:{ Exception -> 0x01dd }
            goto L_0x01e0
        L_0x01dd:
            r3 = 0
            r12.s = r3     // Catch:{ all -> 0x0305 }
        L_0x01e0:
            com.mbridge.msdk.foundation.tools.FastKV r3 = r12.s     // Catch:{ all -> 0x0305 }
            java.lang.String r6 = "c"
            java.lang.String r7 = "b"
            java.lang.String r8 = "H+tU+Fz8"
            java.lang.String r9 = "H+tU+bfPhM=="
            if (r3 == 0) goto L_0x0272
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.u.b(r9)     // Catch:{ Exception -> 0x01ff }
            java.lang.String r13 = r3.getString(r13, r1)     // Catch:{ Exception -> 0x01ff }
            com.mbridge.msdk.foundation.tools.FastKV r2 = r12.s     // Catch:{ Exception -> 0x0200 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.u.b(r8)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r1 = r2.getString(r3, r1)     // Catch:{ Exception -> 0x0200 }
            goto L_0x0200
        L_0x01ff:
            r13 = r1
        L_0x0200:
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0305 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0305 }
            if (r2 == 0) goto L_0x0224
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x0305 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0305 }
            if (r2 == 0) goto L_0x0224
            com.mbridge.msdk.foundation.a.a.a r2 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0305 }
            java.lang.String r2 = r2.b(r7)     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.same.a.l = r2     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.a.a.a r2 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0305 }
            java.lang.String r2 = r2.b(r6)     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.same.a.m = r2     // Catch:{ all -> 0x0305 }
        L_0x0224:
            boolean r2 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0305 }
            if (r2 == 0) goto L_0x025a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0305 }
            if (r2 == 0) goto L_0x025a
            java.lang.String r13 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0305 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0305 }
            if (r13 == 0) goto L_0x0242
            java.lang.String r13 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x0305 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0305 }
            if (r13 == 0) goto L_0x0242
            goto L_0x030d
        L_0x0242:
            com.mbridge.msdk.foundation.tools.FastKV r13 = r12.s     // Catch:{ Exception -> 0x030d }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r9)     // Catch:{ Exception -> 0x030d }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x030d }
            r13.putString(r1, r2)     // Catch:{ Exception -> 0x030d }
            com.mbridge.msdk.foundation.tools.FastKV r13 = r12.s     // Catch:{ Exception -> 0x030d }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r8)     // Catch:{ Exception -> 0x030d }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x030d }
            r13.putString(r1, r2)     // Catch:{ Exception -> 0x030d }
            goto L_0x030d
        L_0x025a:
            com.mbridge.msdk.foundation.same.a.l = r13     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.same.a.m = r1     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.a.a.a r13 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0305 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0305 }
            r13.a((java.lang.String) r7, (java.lang.String) r1)     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.a.a.a r13 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0305 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x0305 }
            r13.a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ all -> 0x0305 }
            goto L_0x030d
        L_0x0272:
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.u.b(r5)     // Catch:{ all -> 0x0305 }
            android.content.SharedPreferences r13 = r2.getSharedPreferences(r3, r13)     // Catch:{ all -> 0x0305 }
            if (r13 == 0) goto L_0x0290
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.u.b(r9)     // Catch:{ all -> 0x0305 }
            java.lang.String r2 = r13.getString(r2, r1)     // Catch:{ all -> 0x0305 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.u.b(r8)     // Catch:{ all -> 0x0305 }
            java.lang.String r1 = r13.getString(r3, r1)     // Catch:{ all -> 0x0305 }
            r11 = r2
            r2 = r1
            r1 = r11
            goto L_0x0291
        L_0x0290:
            r2 = r1
        L_0x0291:
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0305 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0305 }
            if (r3 == 0) goto L_0x02b5
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x0305 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0305 }
            if (r3 == 0) goto L_0x02b5
            com.mbridge.msdk.foundation.a.a.a r3 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0305 }
            java.lang.String r3 = r3.b(r7)     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.same.a.l = r3     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.a.a.a r3 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0305 }
            java.lang.String r3 = r3.b(r6)     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.same.a.m = r3     // Catch:{ all -> 0x0305 }
        L_0x02b5:
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0305 }
            if (r3 == 0) goto L_0x02ee
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0305 }
            if (r3 == 0) goto L_0x02ee
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0305 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0305 }
            if (r1 == 0) goto L_0x02d2
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x0305 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0305 }
            if (r1 == 0) goto L_0x02d2
            goto L_0x030d
        L_0x02d2:
            if (r13 == 0) goto L_0x030d
            android.content.SharedPreferences$Editor r13 = r13.edit()     // Catch:{ all -> 0x0305 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r9)     // Catch:{ all -> 0x0305 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0305 }
            r13.putString(r1, r2)     // Catch:{ all -> 0x0305 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r8)     // Catch:{ all -> 0x0305 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x0305 }
            r13.putString(r1, r2)     // Catch:{ all -> 0x0305 }
            r13.apply()     // Catch:{ all -> 0x0305 }
            goto L_0x030d
        L_0x02ee:
            com.mbridge.msdk.foundation.same.a.l = r1     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.same.a.m = r2     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.a.a.a r13 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0305 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0305 }
            r13.a((java.lang.String) r7, (java.lang.String) r1)     // Catch:{ all -> 0x0305 }
            com.mbridge.msdk.foundation.a.a.a r13 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0305 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x0305 }
            r13.a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ all -> 0x0305 }
            goto L_0x030d
        L_0x0305:
            r13 = move-exception
            java.lang.String r1 = r13.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r1, r13)
        L_0x030d:
            boolean r13 = com.mbridge.msdk.MBridgeConstans.INIT_UA_IN     // Catch:{ Exception -> 0x0339 }
            if (r13 == 0) goto L_0x031e
            java.util.concurrent.ThreadPoolExecutor r13 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch:{ Exception -> 0x0339 }
            com.mbridge.msdk.foundation.controller.c$2 r1 = new com.mbridge.msdk.foundation.controller.c$2     // Catch:{ Exception -> 0x0339 }
            r1.<init>()     // Catch:{ Exception -> 0x0339 }
            r13.execute(r1)     // Catch:{ Exception -> 0x0339 }
            goto L_0x0341
        L_0x031e:
            android.os.Looper r13 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x0339 }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0339 }
            if (r13 != r1) goto L_0x0335
            java.util.concurrent.ThreadPoolExecutor r13 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch:{ Exception -> 0x0339 }
            com.mbridge.msdk.foundation.controller.c$3 r1 = new com.mbridge.msdk.foundation.controller.c$3     // Catch:{ Exception -> 0x0339 }
            r1.<init>()     // Catch:{ Exception -> 0x0339 }
            r13.execute(r1)     // Catch:{ Exception -> 0x0339 }
            goto L_0x0341
        L_0x0335:
            r12.d()     // Catch:{ Exception -> 0x0339 }
            goto L_0x0341
        L_0x0339:
            r13 = move-exception
            java.lang.String r13 = r13.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r0, r13)
        L_0x0341:
            com.mbridge.msdk.foundation.controller.c$4 r13 = new com.mbridge.msdk.foundation.controller.c$4
            r13.<init>()
            java.util.concurrent.ThreadPoolExecutor r0 = com.mbridge.msdk.foundation.same.f.b.b()
            r0.execute(r13)
            android.content.Context r13 = r12.i
            com.mbridge.msdk.foundation.tools.ad.a((android.content.Context) r13)
            r12.n = r4
        L_0x0354:
            com.mbridge.msdk.c.f r13 = com.mbridge.msdk.c.f.a()
            java.lang.String r0 = r12.k
            com.mbridge.msdk.c.e r13 = r13.g(r0)
            int r13 = r13.m()
            long r0 = (long) r13
            r2 = 1300(0x514, double:6.423E-321)
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0373
            android.os.Handler r13 = r12.g
            com.mbridge.msdk.foundation.controller.c$1 r2 = new com.mbridge.msdk.foundation.controller.c$1
            r2.<init>(r14)
            r13.postDelayed(r2, r0)
        L_0x0373:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.c.a(java.util.Map, android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.d.b");
            cls.getDeclaredMethod("start", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            aa.b("SDKController", th.getMessage(), th);
        }
    }

    public final void b() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[Catch:{ Exception -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b A[Catch:{ Exception -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x023e A[Catch:{ Exception -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r13 = this;
            android.content.Context r0 = r13.i
            if (r0 == 0) goto L_0x027d
            android.os.Handler r0 = r13.g
            if (r0 != 0) goto L_0x000a
            goto L_0x027d
        L_0x000a:
            com.mbridge.msdk.foundation.tools.ac r0 = com.mbridge.msdk.foundation.tools.ac.a()     // Catch:{ Exception -> 0x026f }
            java.lang.String r1 = "e_r_r_c_t_r_l"
            r2 = 0
            boolean r0 = r0.a((java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x026f }
            r1 = 5
            r3 = 1
            if (r0 == 0) goto L_0x001b
            r0 = 5
            goto L_0x001c
        L_0x001b:
            r0 = 1
        L_0x001c:
            com.mbridge.msdk.foundation.same.report.c.a.a()     // Catch:{ Exception -> 0x026f }
            android.content.Context r4 = r13.i     // Catch:{ Exception -> 0x026f }
            r5 = 0
            if (r4 != 0) goto L_0x0025
            goto L_0x0040
        L_0x0025:
            com.mbridge.msdk.foundation.db.h r6 = com.mbridge.msdk.foundation.db.h.a((android.content.Context) r4)     // Catch:{ Exception -> 0x026f }
            com.mbridge.msdk.foundation.db.n r6 = com.mbridge.msdk.foundation.db.n.a((com.mbridge.msdk.foundation.db.g) r6)     // Catch:{ Exception -> 0x026f }
            int r6 = r6.a()     // Catch:{ Exception -> 0x026f }
            if (r6 <= 0) goto L_0x0040
            com.mbridge.msdk.foundation.db.h r4 = com.mbridge.msdk.foundation.db.h.a((android.content.Context) r4)     // Catch:{ Exception -> 0x026f }
            com.mbridge.msdk.foundation.db.n r4 = com.mbridge.msdk.foundation.db.n.a((com.mbridge.msdk.foundation.db.g) r4)     // Catch:{ Exception -> 0x026f }
            java.util.List r0 = r4.a((int) r0)     // Catch:{ Exception -> 0x026f }
            goto L_0x0041
        L_0x0040:
            r0 = r5
        L_0x0041:
            if (r0 == 0) goto L_0x0059
            int r4 = r0.size()     // Catch:{ Exception -> 0x026f }
            if (r4 <= 0) goto L_0x0059
            android.os.Handler r4 = r13.g     // Catch:{ Exception -> 0x026f }
            android.os.Message r4 = r4.obtainMessage()     // Catch:{ Exception -> 0x026f }
            r6 = 2
            r4.what = r6     // Catch:{ Exception -> 0x026f }
            r4.obj = r0     // Catch:{ Exception -> 0x026f }
            android.os.Handler r0 = r13.g     // Catch:{ Exception -> 0x026f }
            r0.sendMessage(r4)     // Catch:{ Exception -> 0x026f }
        L_0x0059:
            android.content.Context r0 = r13.i     // Catch:{ Exception -> 0x026f }
            com.mbridge.msdk.foundation.db.h r0 = com.mbridge.msdk.foundation.db.h.a((android.content.Context) r0)     // Catch:{ Exception -> 0x026f }
            com.mbridge.msdk.foundation.db.e r4 = com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.g) r0)     // Catch:{ Exception -> 0x026f }
            int r6 = r4.a()     // Catch:{ Exception -> 0x026f }
            r7 = 20
            if (r6 < r7) goto L_0x0081
            java.util.List r4 = r4.a((int) r7)     // Catch:{ Exception -> 0x026f }
            java.lang.String r4 = com.mbridge.msdk.foundation.entity.d.a((java.util.List<com.mbridge.msdk.foundation.entity.d>) r4)     // Catch:{ Exception -> 0x026f }
            android.os.Message r6 = android.os.Message.obtain()     // Catch:{ Exception -> 0x026f }
            r6.obj = r4     // Catch:{ Exception -> 0x026f }
            r4 = 4
            r6.what = r4     // Catch:{ Exception -> 0x026f }
            android.os.Handler r4 = r13.g     // Catch:{ Exception -> 0x026f }
            r4.sendMessage(r6)     // Catch:{ Exception -> 0x026f }
        L_0x0081:
            com.mbridge.msdk.foundation.db.l r0 = com.mbridge.msdk.foundation.db.l.a((com.mbridge.msdk.foundation.db.g) r0)     // Catch:{ Exception -> 0x026f }
            int r4 = r0.a()     // Catch:{ Exception -> 0x026f }
            if (r4 <= r7) goto L_0x021e
            java.util.List r0 = r0.a((int) r7)     // Catch:{ Exception -> 0x026f }
            if (r0 == 0) goto L_0x0211
            int r4 = r0.size()     // Catch:{ Exception -> 0x026f }
            if (r4 <= 0) goto L_0x0211
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x026f }
            r4.<init>()     // Catch:{ Exception -> 0x026f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x026f }
        L_0x00a0:
            boolean r5 = r0.hasNext()     // Catch:{ Exception -> 0x026f }
            if (r5 == 0) goto L_0x020d
            java.lang.Object r5 = r0.next()     // Catch:{ Exception -> 0x026f }
            com.mbridge.msdk.foundation.entity.h r5 = (com.mbridge.msdk.foundation.entity.h) r5     // Catch:{ Exception -> 0x026f }
            com.mbridge.msdk.foundation.controller.authoritycontroller.a r6 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()     // Catch:{ Exception -> 0x026f }
            java.lang.String r7 = "authority_general_data"
            boolean r6 = r6.a((java.lang.String) r7)     // Catch:{ Exception -> 0x026f }
            java.lang.String r7 = "&fb="
            java.lang.String r8 = "&key=2000006"
            java.lang.String r9 = "&unit_id="
            java.lang.String r10 = "&num="
            java.lang.String r11 = "&time="
            java.lang.String r12 = "ad_source_id="
            if (r6 == 0) goto L_0x016d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r6.<init>()     // Catch:{ Exception -> 0x026f }
            r6.append(r12)     // Catch:{ Exception -> 0x026f }
            int r12 = r5.b()     // Catch:{ Exception -> 0x026f }
            r6.append(r12)     // Catch:{ Exception -> 0x026f }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r4.append(r6)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r12.<init>()     // Catch:{ Exception -> 0x026f }
            r12.append(r11)     // Catch:{ Exception -> 0x026f }
            java.lang.String r11 = r5.c()     // Catch:{ Exception -> 0x026f }
            r12.append(r11)     // Catch:{ Exception -> 0x026f }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r11)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r11.<init>()     // Catch:{ Exception -> 0x026f }
            r11.append(r10)     // Catch:{ Exception -> 0x026f }
            int r10 = r5.d()     // Catch:{ Exception -> 0x026f }
            r11.append(r10)     // Catch:{ Exception -> 0x026f }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r10)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r10.<init>()     // Catch:{ Exception -> 0x026f }
            r10.append(r9)     // Catch:{ Exception -> 0x026f }
            java.lang.String r9 = r5.e()     // Catch:{ Exception -> 0x026f }
            r10.append(r9)     // Catch:{ Exception -> 0x026f }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r9)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r8)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r8.<init>()     // Catch:{ Exception -> 0x026f }
            r8.append(r7)     // Catch:{ Exception -> 0x026f }
            int r7 = r5.f()     // Catch:{ Exception -> 0x026f }
            r8.append(r7)     // Catch:{ Exception -> 0x026f }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r7)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r7.<init>()     // Catch:{ Exception -> 0x026f }
            java.lang.String r8 = "&network_str="
            r7.append(r8)     // Catch:{ Exception -> 0x026f }
            java.lang.String r8 = r5.i()     // Catch:{ Exception -> 0x026f }
            r7.append(r8)     // Catch:{ Exception -> 0x026f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r7)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r7.<init>()     // Catch:{ Exception -> 0x026f }
            java.lang.String r8 = "&network_type="
            r7.append(r8)     // Catch:{ Exception -> 0x026f }
            int r8 = r5.h()     // Catch:{ Exception -> 0x026f }
            r7.append(r8)     // Catch:{ Exception -> 0x026f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x026f }
            r6.append(r7)     // Catch:{ Exception -> 0x026f }
            goto L_0x01e3
        L_0x016d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r6.<init>()     // Catch:{ Exception -> 0x026f }
            r6.append(r12)     // Catch:{ Exception -> 0x026f }
            int r12 = r5.b()     // Catch:{ Exception -> 0x026f }
            r6.append(r12)     // Catch:{ Exception -> 0x026f }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r4.append(r6)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r12.<init>()     // Catch:{ Exception -> 0x026f }
            r12.append(r11)     // Catch:{ Exception -> 0x026f }
            java.lang.String r11 = r5.c()     // Catch:{ Exception -> 0x026f }
            r12.append(r11)     // Catch:{ Exception -> 0x026f }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r11)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r11.<init>()     // Catch:{ Exception -> 0x026f }
            r11.append(r10)     // Catch:{ Exception -> 0x026f }
            int r10 = r5.d()     // Catch:{ Exception -> 0x026f }
            r11.append(r10)     // Catch:{ Exception -> 0x026f }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r10)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r10.<init>()     // Catch:{ Exception -> 0x026f }
            r10.append(r9)     // Catch:{ Exception -> 0x026f }
            java.lang.String r9 = r5.e()     // Catch:{ Exception -> 0x026f }
            r10.append(r9)     // Catch:{ Exception -> 0x026f }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r9)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuffer r6 = r6.append(r8)     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r8.<init>()     // Catch:{ Exception -> 0x026f }
            r8.append(r7)     // Catch:{ Exception -> 0x026f }
            int r7 = r5.f()     // Catch:{ Exception -> 0x026f }
            r8.append(r7)     // Catch:{ Exception -> 0x026f }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x026f }
            r6.append(r7)     // Catch:{ Exception -> 0x026f }
        L_0x01e3:
            int r6 = r5.a()     // Catch:{ Exception -> 0x026f }
            if (r6 != r3) goto L_0x01ee
            java.lang.String r6 = "&hb=1"
            r4.append(r6)     // Catch:{ Exception -> 0x026f }
        L_0x01ee:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r6.<init>()     // Catch:{ Exception -> 0x026f }
            java.lang.String r7 = "&timeout="
            r6.append(r7)     // Catch:{ Exception -> 0x026f }
            int r5 = r5.g()     // Catch:{ Exception -> 0x026f }
            r6.append(r5)     // Catch:{ Exception -> 0x026f }
            java.lang.String r5 = "\n"
            r6.append(r5)     // Catch:{ Exception -> 0x026f }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x026f }
            r4.append(r5)     // Catch:{ Exception -> 0x026f }
            goto L_0x00a0
        L_0x020d:
            java.lang.String r5 = r4.toString()     // Catch:{ Exception -> 0x026f }
        L_0x0211:
            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ Exception -> 0x026f }
            r0.obj = r5     // Catch:{ Exception -> 0x026f }
            r0.what = r1     // Catch:{ Exception -> 0x026f }
            android.os.Handler r1 = r13.g     // Catch:{ Exception -> 0x026f }
            r1.sendMessage(r0)     // Catch:{ Exception -> 0x026f }
        L_0x021e:
            com.mbridge.msdk.foundation.same.b.c r0 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO     // Catch:{ Exception -> 0x026f }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.b.e.b(r0)     // Catch:{ Exception -> 0x026f }
            java.lang.String r1 = "/"
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x026f }
            r3.<init>(r0)     // Catch:{ Exception -> 0x026f }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x026f }
            if (r4 == 0) goto L_0x027d
            boolean r4 = r3.isDirectory()     // Catch:{ Exception -> 0x026f }
            if (r4 == 0) goto L_0x027d
            java.lang.String[] r4 = r3.list()     // Catch:{ Exception -> 0x026f }
            int r4 = r4.length     // Catch:{ Exception -> 0x026f }
            if (r4 <= 0) goto L_0x027d
            java.lang.String[] r3 = r3.list()     // Catch:{ Exception -> 0x026f }
            int r4 = r3.length     // Catch:{ Exception -> 0x026f }
        L_0x0243:
            if (r2 >= r4) goto L_0x027d
            r5 = r3[r2]     // Catch:{ Exception -> 0x026f }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x026f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026f }
            r7.<init>()     // Catch:{ Exception -> 0x026f }
            r7.append(r0)     // Catch:{ Exception -> 0x026f }
            r7.append(r1)     // Catch:{ Exception -> 0x026f }
            r7.append(r5)     // Catch:{ Exception -> 0x026f }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x026f }
            r6.<init>(r5)     // Catch:{ Exception -> 0x026f }
            android.os.Message r5 = android.os.Message.obtain()     // Catch:{ Exception -> 0x026f }
            r5.obj = r6     // Catch:{ Exception -> 0x026f }
            r6 = 3
            r5.what = r6     // Catch:{ Exception -> 0x026f }
            android.os.Handler r6 = r13.g     // Catch:{ Exception -> 0x026f }
            r6.sendMessage(r5)     // Catch:{ Exception -> 0x026f }
            int r2 = r2 + 1
            goto L_0x0243
        L_0x026f:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x027d
            java.lang.String r1 = "SDKController"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)
        L_0x027d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.c.c():void");
    }

    public final void a(Map<String, Object> map, int i2) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            this.t = map;
            this.u = i2;
            b.d().h();
            if (map != null) {
                if (this.o == null) {
                    this.o = new a();
                }
                try {
                    Map<String, Object> map2 = this.t;
                    if (map2 != null && map2.size() > 0 && this.t.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE) && ((Integer) this.t.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue() == 0) {
                        Map<String, Object> map3 = this.t;
                        int i3 = this.u;
                        try {
                            Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.e.a");
                            Object newInstance = cls.newInstance();
                            cls.getMethod("preload", new Class[]{Map.class, Integer.TYPE}).invoke(newInstance, new Object[]{map3, Integer.valueOf(i3)});
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        if (f.a() != null) {
            f a2 = f.a();
            if (a2 != null) {
                e b2 = a2.b(str);
                if (b2 != null) {
                    MBridgeConstans.OMID_JS_SERVICE_URL = b2.ax();
                    MBridgeConstans.OMID_JS_H5_URL = b2.aw();
                    if (!TextUtils.isEmpty(b2.E())) {
                        com.mbridge.msdk.foundation.same.net.g.d.a().e = b2.E();
                        com.mbridge.msdk.foundation.same.net.g.d.a().e();
                    }
                    if (!TextUtils.isEmpty(b2.F())) {
                        com.mbridge.msdk.foundation.same.net.g.d.a().f = b2.F();
                        com.mbridge.msdk.foundation.same.net.g.d.a().f();
                    }
                } else {
                    MBridgeConstans.OMID_JS_SERVICE_URL = b.a;
                    MBridgeConstans.OMID_JS_H5_URL = b.b;
                }
            }
            if (!f.a().a(str) || !f.a().a(str, 1, (String) null)) {
                new p(cVar.i).a();
            } else {
                new g().a(cVar.i, str, cVar.l);
            }
        }
    }
}
