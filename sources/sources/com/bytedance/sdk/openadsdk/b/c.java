package com.bytedance.sdk.openadsdk.b;

import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.f.c.d;
import com.bytedance.sdk.component.f.c.e;
import com.bytedance.sdk.component.g.f;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.b.a;
import com.bytedance.sdk.openadsdk.core.g.b.c;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.model.i;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.video.a.b;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.m;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEventManager */
public class c {

    /* compiled from: AdEventManager */
    public static class a {
        public static void a(int i, int i2, int i3, int i4, q qVar, String str, int i5) {
            final String str2 = str;
            final q qVar2 = qVar;
            final int i6 = i;
            final int i7 = i5;
            final int i8 = i2;
            final int i9 = i3;
            final int i10 = i4;
            c.a((h) new h(d.d1699434667873dc("rdqlqwebWmomdb")) {
                public void run() {
                    try {
                        if (str2 == null) {
                            return;
                        }
                        if (!TextUtils.isEmpty(qVar2.af())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(d.d1699434667873dc("ndzw[ptk"), qVar2.P());
                            jSONObject.put(d.d1699434667873dc("cicmj`jXfhgn"), qVar2.af());
                            jSONObject.put(d.d1699434667873dc("psgokdbX{}ky~"), i6 <= 0 ? 0 : 2);
                            jSONObject.put(d.d1699434667873dc("fhpppZvfol"), i7);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(d.d1699434667873dc("cicmj`jXzly{cc}j"), i6);
                            jSONObject2.put(d.d1699434667873dc("f`koV`uh}{inOb{ad"), i8);
                            jSONObject2.put(d.d1699434667873dc("sta`avuDg|d"), i9);
                            jSONObject2.put(d.d1699434667873dc("f`koGjsi|"), i10);
                            jSONObject.put(d.d1699434667873dc("rdqlqwebW`dmc"), jSONObject2);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(d.d1699434667873dc("ae]f|qtfWmkm"), jSONObject.toString());
                            c.b(System.currentTimeMillis(), qVar2, str2, d.d1699434667873dc("l`lgmkaXxhmnSk|d`pqJrrlxsw"), jSONObject3);
                        }
                    } catch (Throwable th) {
                        Log.d(d.d1699434667873dc("TUCG*DbB~ld"), d.d1699434667873dc("Gdahk+jhkhfYi~FfdCsgq5sejvh"), th);
                    }
                }
            });
        }

        public static void a(final int i, final int i2, final q qVar) {
            c.a((h) new h(d.d1699434667873dc("rdq\\llr")) {
                public void run() {
                    try {
                        String a2 = ac.a(qVar);
                        if (a2 != null) {
                            String str = a2 + b.b1699434667886dc("_mcm`lh`xhmn");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(b.b1699434667886dc("amn\\plkb{"), i2);
                            jSONObject.put(b.b1699434667886dc("hhv\\plkb{"), i);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(b.b1699434667886dc("ae]f|qtfWmkm"), jSONObject.toString());
                            c.b(System.currentTimeMillis(), qVar, str, b.b1699434667886dc("lnabhZtb{VbbxR|ndt"), jSONObject2);
                        }
                    } catch (Throwable th) {
                        Log.d(b.b1699434667886dc("TUCG*DbB~ld"), b.b1699434667886dc("Gdahk+jhkhfYi~FfdCsgq5sejvh"), th);
                    }
                }
            });
            while (true) {
                char c = 15;
                while (true) {
                    switch (c) {
                        case 13:
                        case 14:
                            return;
                        default:
                            c = 14;
                    }
                }
            }
        }

        public static void a(long j, q qVar, String str, ILoader iLoader, String str2) {
            final String str3 = str;
            final ILoader iLoader2 = iLoader;
            final String str4 = str2;
            final q qVar2 = qVar;
            final long j2 = j;
            c.a((h) new h(d.d1699434667873dc("p`ef[lhn|")) {
                public void run() {
                    int i;
                    try {
                        if (str3 != null) {
                            int a2 = com.bytedance.sdk.openadsdk.d.b.a().a(iLoader2, str4);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(e.e1699434667871dc("usn"), qVar2.P());
                            jSONObject.put(e.e1699434667871dc("cicmj`jXfhgn"), qVar2.af());
                            String e1699434667871dc = e.e1699434667871dc("iovfvfcw|fxTyo{eb");
                            if (!TextUtils.isEmpty(qVar2.af())) {
                                if (a2 > 0) {
                                    i = 1;
                                    jSONObject.put(e1699434667871dc, i);
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(e.e1699434667871dc("rdqlqwebWje~by"), a2);
                                    jSONObject.put(e.e1699434667871dc("rdqlqwebW`dmc"), jSONObject2);
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(e.e1699434667871dc("ae]f|qtfWmkm"), jSONObject.toString());
                                    jSONObject3.put(e.e1699434667871dc("dtpbplii"), j2);
                                    c.b(System.currentTimeMillis(), qVar2, str3, e.e1699434667871dc("l`lgmkawinoTecg{"), jSONObject3);
                                }
                            }
                            i = 0;
                            jSONObject.put(e1699434667871dc, i);
                            JSONObject jSONObject22 = new JSONObject();
                            jSONObject22.put(e.e1699434667871dc("rdqlqwebWje~by"), a2);
                            jSONObject.put(e.e1699434667871dc("rdqlqwebW`dmc"), jSONObject22);
                            JSONObject jSONObject32 = new JSONObject();
                            jSONObject32.put(e.e1699434667871dc("ae]f|qtfWmkm"), jSONObject.toString());
                            jSONObject32.put(e.e1699434667871dc("dtpbplii"), j2);
                            c.b(System.currentTimeMillis(), qVar2, str3, e.e1699434667871dc("l`lgmkawinoTecg{"), jSONObject32);
                        }
                    } catch (Throwable th) {
                        Log.d(e.e1699434667871dc("TUCG*DbB~ld"), e.e1699434667871dc("Gdahk+jhkhfYi~FfdCsgq5sejvh"), th);
                    }
                }
            });
        }

        public static void a(final q qVar) {
            c.a((h) new h(d.d1699434667873dc("dnumhjgcWnohgbQ|dp`g")) {
                public void run() {
                    try {
                        String a2 = ac.a(qVar);
                        if (a2 == null) {
                            return;
                        }
                        if (!TextUtils.isEmpty(qVar.af())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(k.k1699434667889dc("usn"), qVar.P());
                            jSONObject.put(k.k1699434667889dc("cicmj`jXfhgn"), qVar.af());
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(k.k1699434667889dc("ae]f|qtfWmkm"), jSONObject.toString());
                            c.b(System.currentTimeMillis(), qVar, a2, k.k1699434667889dc("dnumhjgcWnohgbQ|dp`g"), jSONObject2);
                        }
                    } catch (Throwable th) {
                        Log.d(k.k1699434667889dc("TUCG*DbB~ld"), k.k1699434667889dc("Gdahk+bhgfdmiIjsz}@`tdc8|hiso"), th);
                    }
                }
            });
        }

        public static void a(final q qVar, final JSONObject jSONObject) {
            c.a((h) new h(d.d1699434667873dc("dnumhjgcWnohgbQj~u")) {
                public void run() {
                    try {
                        String a2 = ac.a(qVar);
                        if (a2 == null) {
                            return;
                        }
                        if (!TextUtils.isEmpty(qVar.af())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(c.b.c$b1699434667869dc("usn"), qVar.P());
                            jSONObject.put(c.b.c$b1699434667869dc("cicmj`jXfhgn"), qVar.af());
                            jSONObject.put(c.b.c$b1699434667869dc("d`vb"), jSONObject);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(c.b.c$b1699434667869dc("ae]f|qtfWmkm"), jSONObject.toString());
                            c.b(System.currentTimeMillis(), qVar, a2, c.b.c$b1699434667869dc("dnumhjgcWnohgbQj~u"), jSONObject2);
                        }
                    } catch (Throwable th) {
                        Log.d(c.b.c$b1699434667869dc("TUCG*DbB~ld"), c.b.c$b1699434667869dc("Gdahk+bhgfdmiIjsz}Vzq6rjkui"), th);
                    }
                }
            });
            while (true) {
                char c = 15;
                while (true) {
                    switch (c) {
                        case 13:
                        case 14:
                            return;
                        default:
                            c = 14;
                    }
                }
            }
        }

        public static void a(final String str, final JSONObject jSONObject, final q qVar) {
            c.a((h) new h(d.d1699434667873dc("rdq\\llr")) {
                public void run() {
                    try {
                        String a2 = ac.a(qVar);
                        if (a2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(d.d1699434667873dc("ae]f|qtfWmkm"), jSONObject.toString());
                            c.b(System.currentTimeMillis(), qVar, a2 + b.b1699434667886dc("_mcm`lh`xhmn"), str, jSONObject);
                        }
                    } catch (Throwable th) {
                        Log.d(d.d1699434667873dc("TUCG*DbB~ld"), d.d1699434667873dc("Gdahk+jhimO}icz/uc`|f"), th);
                    }
                }
            });
            char c = AbstractJsonLexerKt.STRING_ESC;
            while (true) {
                char c2 = 14;
                while (true) {
                    switch (c2) {
                        case 13:
                            break;
                        case 14:
                            break;
                        case 15:
                            switch (c) {
                                case '_':
                                    return;
                            }
                    }
                    c2 = 15;
                    c = '_';
                }
            }
        }
    }

    public static void a() {
        try {
            Class.forName(c.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public static void a(long j, q qVar, String str) {
        if (qVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(d.d1699434667873dc("dtpbplii"), j);
                jSONObject2.put(d.d1699434667873dc("usn"), qVar.K().l());
                jSONObject2.put(d.d1699434667873dc("su{oaZoc"), qVar.bs());
                jSONObject.put(d.d1699434667873dc("ae]f|qtfWmkm"), jSONObject2.toString());
            } catch (Exception e) {
                l.d(e.getMessage());
            }
            b(System.currentTimeMillis(), qVar, str, d.d1699434667873dc("eof`ewbXnlogeciPtd`r}zx"), jSONObject);
        }
    }

    @JProtect
    private static void a(long j, q qVar, String str, String str2) {
        b(j, qVar, str, str2, new JSONObject());
    }

    public static void a(long j, q qVar, String str, String str2, JSONObject jSONObject, g gVar, com.bytedance.sdk.openadsdk.b.b.a aVar) {
        if (qVar != null) {
            new a.C0060a(j, qVar).f(qVar.Y()).h(qVar.bc()).e(qVar.ac()).a(qVar.Z()).b(str).c(str2).a(jSONObject).a(aVar);
        }
    }

    public static void a(final h hVar) {
        if (hVar != null) {
            if (aa.e()) {
                com.bytedance.sdk.component.utils.h.a().post(new Runnable() {
                    public void run() {
                        aa.b(hVar, 10);
                    }
                });
            } else if (!aa.f()) {
                aa.b(hVar, 10);
            } else {
                hVar.run();
            }
        }
    }

    public static void a(AdSlot adSlot) {
        String codeId;
        if (adSlot == null) {
            codeId = "";
        } else if (TextUtils.isEmpty(adSlot.getBidAdm())) {
            codeId = adSlot.getCodeId();
        } else {
            return;
        }
        a(codeId);
    }

    public static void a(q qVar) {
        if (!TextUtils.isEmpty(j.a(o.a()))) {
            com.bytedance.sdk.openadsdk.b.a.d.a(com.bytedance.sdk.openadsdk.n.a.a(qVar.S(), true));
        }
    }

    public static void a(q qVar, String str) {
        if (qVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(c.a.c$a1699434667851dc("usn"), qVar.K().l());
                jSONObject2.putOpt(c.a.c$a1699434667851dc("su{oaZoc"), qVar.bs());
                jSONObject.putOpt(c.a.c$a1699434667851dc("ae]f|qtfWmkm"), jSONObject2.toString());
            } catch (Exception e) {
                l.d(e.getMessage());
            }
            c(qVar, str, c.a.c$a1699434667851dc("eof`ewbXdfkoS~znbe"), jSONObject);
        }
    }

    public static void a(q qVar, String str, int i) {
        if (qVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(c.a.c$a1699434667851dc("rdlgawYsqyo"), c.a.c$a1699434667851dc("h4"));
                jSONObject2.putOpt(c.a.c$a1699434667851dc("rdlgawYsqyoT>"), 0);
                jSONObject2.putOpt(c.a.c$a1699434667851dc("psgokdbX{}ky~"), Integer.valueOf(i));
                jSONObject.putOpt(c.a.c$a1699434667851dc("ae]f|qtfWmkm"), jSONObject2.toString());
            } catch (Exception unused) {
            }
            c(qVar, str, c.a.c$a1699434667851dc("oqgm[ptkWa?"), jSONObject);
        }
    }

    public static void a(q qVar, String str, int i, int i2, boolean z) {
        a(qVar, str, i, i2, z, "");
    }

    public static void a(q qVar, String str, int i, int i2, boolean z, String str2) {
        if (qVar != null && qVar.M() == 2) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("cnwmp"), i);
                jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("iovfvfcw|fx"), i2);
                jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("sta`avu"), z);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("eyaftqohfVgxk"), str2);
                }
                if (i2 == 2 || i2 == 5) {
                    jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("mdvb"), qVar.ao().toString());
                }
                jSONObject.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("ae]f|qtfWmkm"), jSONObject2.toString());
            } catch (Exception unused) {
            }
            b(System.currentTimeMillis(), qVar, str, com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("oqgm[gthzoy"), jSONObject);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        r1 = 'J';
        r2 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        switch(r2) {
            case 55: goto L_0x0012;
            case 56: goto L_0x0051;
            case 57: goto L_0x0051;
            default: goto L_0x0011;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r8 = new org.json.JSONObject();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r1 = new org.json.JSONObject();
        r1.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("vhffkZeogfyn"), r11);
        r1.put(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("vhffkZeogfynSi{}qe{|z"), r12);
        r8.put(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("ae]f|qtfWmkm"), r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        com.bytedance.sdk.component.utils.l.d(r11.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.bytedance.sdk.openadsdk.core.model.q r9, java.lang.String r10, int r11, long r12) {
        /*
            java.lang.String r0 = "vhffkZeogfyn"
        L_0x0003:
            r1 = 73
            r2 = 96
        L_0x0007:
            switch(r1) {
                case 72: goto L_0x0051;
                case 73: goto L_0x000b;
                case 74: goto L_0x000e;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0056
        L_0x000b:
            switch(r2) {
                case 94: goto L_0x0003;
                case 95: goto L_0x0051;
                case 96: goto L_0x0051;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r2) {
                case 55: goto L_0x0012;
                case 56: goto L_0x0051;
                case 57: goto L_0x0051;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0003
        L_0x0012:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x003b }
            r1.<init>()     // Catch:{ all -> 0x003b }
            java.lang.String r2 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)     // Catch:{ all -> 0x003b }
            r1.put(r2, r11)     // Catch:{ all -> 0x003b }
            java.lang.String r11 = "vhffkZeogfynSi{}qe{|z"
            java.lang.String r11 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r11)     // Catch:{ all -> 0x003b }
            r1.put(r11, r12)     // Catch:{ all -> 0x003b }
            java.lang.String r11 = "ae]f|qtfWmkm"
            java.lang.String r11 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r11)     // Catch:{ all -> 0x003b }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x003b }
            r8.put(r11, r12)     // Catch:{ all -> 0x003b }
            goto L_0x0043
        L_0x003b:
            r11 = move-exception
            java.lang.String r11 = r11.toString()
            com.bytedance.sdk.component.utils.l.d(r11)
        L_0x0043:
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r0)
            r5 = r9
            r6 = r10
            b((long) r3, (com.bytedance.sdk.openadsdk.core.model.q) r5, (java.lang.String) r6, (java.lang.String) r7, (org.json.JSONObject) r8)
            return
        L_0x0051:
            r1 = 74
            r2 = 55
            goto L_0x0007
        L_0x0056:
            r1 = 72
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.b.c.a(com.bytedance.sdk.openadsdk.core.model.q, java.lang.String, int, long):void");
    }

    public static void a(q qVar, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(d.d1699434667873dc("txrf"), i);
        } catch (JSONException unused) {
        }
        b(qVar, str, d.d1699434667873dc("oqgm[dbXdhdoS}ohuN~zz~e"), jSONObject);
    }

    public static void a(q qVar, String str, long j) {
        if (qVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(p.p1699434667886dc("usn"), qVar.K().l());
                jSONObject2.putOpt(p.p1699434667886dc("su{oaZoc"), qVar.bs());
                jSONObject.putOpt(p.p1699434667886dc("ae]f|qtfWmkm"), jSONObject2.toString());
                jSONObject.put(p.p1699434667886dc("dtpbplii"), j);
            } catch (Exception e) {
                l.d(e.getMessage());
            }
            c(qVar, str, p.p1699434667886dc("eof`ewbXdfkoSkgaybz"), jSONObject);
        }
    }

    public static void a(q qVar, String str, long j, int i, int i2) {
        if (qVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(i.i1699434667884dc("rdlgawYsqyo"), i.i1699434667884dc("h4"));
                jSONObject2.putOpt(i.i1699434667884dc("rdlgawYsqyoT>"), 0);
                jSONObject2.putOpt(i.i1699434667884dc("iovfvdesafdTahzgu"), Integer.valueOf(qVar.p()));
                jSONObject2.put(i.i1699434667884dc("fhpppZvfol"), i2);
                if (i >= 0) {
                    jSONObject2.putOpt(b.b1699434667886dc("psgokdbX{}ky~"), Integer.valueOf(i));
                }
                jSONObject.putOpt(i.i1699434667884dc("ae]f|qtfWmkm"), jSONObject2.toString());
                jSONObject.put(i.i1699434667884dc("dtpbplii"), Math.min(j, 600000));
            } catch (Exception unused) {
            }
            c(qVar, str, b.b1699434667886dc("lncg"), jSONObject);
        }
    }

    public static void a(q qVar, String str, long j, int i, String str2) {
        char c = 'I';
        while (true) {
            switch (c) {
                case 'H':
                    if (qVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.putOpt(p.p1699434667886dc("usn"), qVar.K().l());
                            jSONObject2.putOpt(p.p1699434667886dc("su{oaZoc"), qVar.bs());
                            jSONObject2.put(i.i1699434667884dc("esplvZehll"), i);
                            jSONObject2.put(i.i1699434667884dc("esplvZkto"), str2);
                            jSONObject.putOpt(i.i1699434667884dc("ae]f|qtfWmkm"), jSONObject2.toString());
                            jSONObject.put(i.i1699434667884dc("dtpbplii"), j);
                        } catch (Exception e) {
                            l.d(e.getMessage());
                        }
                        c(qVar, str, i.i1699434667884dc("eof`ewbXdfkoSkof|"), jSONObject);
                        return;
                    }
                    return;
                default:
                    c = 'H';
            }
        }
    }

    public static void a(q qVar, String str, long j, JSONObject jSONObject) {
        if (qVar != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final long j2 = j;
            final JSONObject jSONObject2 = jSONObject;
            final q qVar2 = qVar;
            final String str2 = str;
            a((h) new h(e.e1699434667871dc("ooCstJvbfHn")) {
                /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
                    switch(r1) {
                        case 52: goto L_0x0003;
                        case 53: goto L_0x000d;
                        case 54: goto L_0x006d;
                        default: goto L_0x000c;
                    };
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
                    switch(r0) {
                        case 29: goto L_0x0003;
                        case 30: goto L_0x0003;
                        case 31: goto L_0x0009;
                        default: goto L_0x0010;
                    };
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
                    r0 = 30;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                        r0 = 55
                        r1 = 0
                    L_0x0003:
                        r2 = 72
                    L_0x0005:
                        switch(r2) {
                            case 72: goto L_0x006d;
                            case 73: goto L_0x0013;
                            case 74: goto L_0x0009;
                            default: goto L_0x0008;
                        }
                    L_0x0008:
                        goto L_0x0003
                    L_0x0009:
                        switch(r1) {
                            case 52: goto L_0x0003;
                            case 53: goto L_0x000d;
                            case 54: goto L_0x006d;
                            default: goto L_0x000c;
                        }
                    L_0x000c:
                        goto L_0x0013
                    L_0x000d:
                        switch(r0) {
                            case 29: goto L_0x0003;
                            case 30: goto L_0x0003;
                            case 31: goto L_0x0009;
                            default: goto L_0x0010;
                        }
                    L_0x0010:
                        r0 = 30
                        goto L_0x000d
                    L_0x0013:
                        org.json.JSONObject r7 = new org.json.JSONObject
                        r7.<init>()
                        long r0 = r2     // Catch:{ Exception -> 0x004d }
                        r2 = -1
                        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                        if (r4 == 0) goto L_0x002b
                        java.lang.String r0 = "dtpbplii"
                        java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r0)     // Catch:{ Exception -> 0x004d }
                        long r1 = r2     // Catch:{ Exception -> 0x004d }
                        r7.put(r0, r1)     // Catch:{ Exception -> 0x004d }
                    L_0x002b:
                        org.json.JSONObject r0 = r4     // Catch:{ Exception -> 0x004d }
                        java.lang.String r1 = "ae]f|qtfWmkm"
                        if (r0 == 0) goto L_0x003f
                        java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r1)     // Catch:{ Exception -> 0x004d }
                        org.json.JSONObject r1 = r4     // Catch:{ Exception -> 0x004d }
                        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x004d }
                    L_0x003b:
                        r7.put(r0, r1)     // Catch:{ Exception -> 0x004d }
                        goto L_0x005b
                    L_0x003f:
                        java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r1)     // Catch:{ Exception -> 0x004d }
                        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x004d }
                        r1.<init>()     // Catch:{ Exception -> 0x004d }
                        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x004d }
                        goto L_0x003b
                    L_0x004d:
                        r0 = move-exception
                        java.lang.String r1 = "TUCG*DbB~ld"
                        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r1)
                        java.lang.String r0 = r0.getMessage()
                        com.bytedance.sdk.component.utils.l.e(r1, r0)
                    L_0x005b:
                        long r2 = r5
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r7
                        java.lang.String r0 = "oqgm[db"
                        java.lang.String r5 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)
                        java.lang.String r6 = r8
                        r8 = 0
                        r9 = 0
                        com.bytedance.sdk.openadsdk.b.c.a((long) r2, (com.bytedance.sdk.openadsdk.core.model.q) r4, (java.lang.String) r5, (java.lang.String) r6, (org.json.JSONObject) r7, (com.bytedance.sdk.openadsdk.b.g) r8, (com.bytedance.sdk.openadsdk.b.b.a) r9)
                        return
                    L_0x006d:
                        r2 = 73
                        r1 = 16
                        goto L_0x0005
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.b.c.AnonymousClass3.run():void");
                }
            });
        }
    }

    public static void a(q qVar, String str, long j, boolean z) {
        final q qVar2 = qVar;
        final boolean z2 = z;
        final long j2 = j;
        final String str2 = str;
        a((h) new h(e.e1699434667871dc("ooNsHjgcagm")) {
            public void run() {
                if (qVar2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put(e.e1699434667871dc("ig]otZjhimcekR}zsrw`g"), z2 ? 1 : 2);
                        jSONObject2.put(e.e1699434667871dc("ae]f|qtfWmkm"), jSONObject.toString());
                        jSONObject2.put(e.e1699434667871dc("dtpbplii"), j2);
                    } catch (Throwable th) {
                        l.d(th.toString());
                    }
                    c.b(System.currentTimeMillis(), qVar2, str2, b.b1699434667886dc("lq]okdbnfn"), jSONObject2);
                }
            }
        });
    }

    public static void a(q qVar, String str, ab abVar) {
        if (qVar != null) {
            final long c = abVar.c();
            final ab abVar2 = abVar;
            final String str2 = str;
            final q qVar2 = qVar;
            a((h) new h(e.e1699434667871dc("ae@bgnUog~^bah\\j`~`g")) {
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("cmk`oZusipUe`k"), c);
                        jSONObject.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("cmk`oZrnel"), abVar2.a);
                        if (str2.equals(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("oqgm[db"))) {
                            jSONObject.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("ir]jgjhXggfr"), qVar2.br() ? 1 : 0);
                        }
                        jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("ae]f|qtfWmkm"), jSONObject.toString());
                    } catch (Throwable unused) {
                    }
                    c.b(System.currentTimeMillis(), qVar2, str2, com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("sucz[asui}cdb"), jSONObject2);
                }
            });
        }
    }

    public static void a(q qVar, String str, String str2) {
        if (qVar != null) {
            a(System.currentTimeMillis(), qVar, str, str2);
        }
    }

    public static void a(q qVar, String str, String str2, long j, int i, JSONObject jSONObject, g gVar) {
        if (qVar != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(b.b1699434667886dc("dtpbplii"), j);
                jSONObject2.put(b.b1699434667886dc("pdp`akr"), i);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if ((b.b1699434667886dc("fdgg[gtbib").equals(str2) || b.b1699434667886dc("fdgg[jpbz").equals(str2)) && gVar != null) {
                    gVar.a(jSONObject);
                }
                jSONObject2.put(b.b1699434667886dc("ae]f|qtfWmkm"), jSONObject.toString());
            } catch (Throwable unused) {
            }
            b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
        }
    }

    public static void a(q qVar, String str, String str2, long j, JSONObject jSONObject) {
        char c = AbstractJsonLexerKt.STRING_ESC;
        while (true) {
            char c2 = 14;
            while (true) {
                switch (c2) {
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        switch (c) {
                            case '_':
                                if (qVar != null && jSONObject != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.put(p.p1699434667886dc("dtpbplii"), j);
                                        jSONObject2.put(p.p1699434667886dc("ae]f|qtfWmkm"), jSONObject.toString());
                                    } catch (Exception e) {
                                        l.e(p.p1699434667886dc("TUCG*DbB~ld"), e.getMessage());
                                    }
                                    b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
                                    return;
                                }
                                return;
                        }
                }
                c2 = 15;
                c = '_';
            }
        }
    }

    @JProtect
    public static void a(q qVar, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (qVar != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final JSONObject jSONObject2 = jSONObject;
            final String str4 = str3;
            final String str5 = str2;
            final q qVar2 = qVar;
            final String str6 = str;
            final long j3 = j;
            final long j4 = j2;
            a((h) new h(e.e1699434667871dc("sdlgNvGcMoex")) {
                public void run() {
                    q qVar;
                    while (true) {
                        char c2 = 20;
                        while (true) {
                            switch (c2) {
                                case 18:
                                case 19:
                                    if (jSONObject2 != null) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            String optString = jSONObject2.optString(c.b.c$b1699434667869dc("ae]f|qtfWmkm"), (String) null);
                                            if (optString != null) {
                                                jSONObject = new JSONObject(optString);
                                            }
                                            if (!c.b.c$b1699434667869dc("cmk`o").equals(str4)) {
                                                jSONObject.put(c.b.c$b1699434667869dc("ddtjg`"), DeviceUtils.d(o.a()).toString());
                                            }
                                            jSONObject2.put(c.b.c$b1699434667869dc("ae]f|qtfWmkm"), jSONObject.toString());
                                            jSONObject2.put(c.b.c$b1699434667869dc("t`e"), str5);
                                            if (c.b.c$b1699434667869dc("cmk`o").equals(str4)) {
                                                r.c(qVar2);
                                                String optString2 = jSONObject2.optString(c.b.c$b1699434667869dc("lne\\a}rui"));
                                                double currentTimeMillis = (double) (System.currentTimeMillis() / 1000);
                                                double b2 = q.b(optString2);
                                                Double.isNaN(currentTimeMillis);
                                                float floatValue = Double.valueOf(currentTimeMillis - b2).floatValue();
                                                JSONObject jSONObject2 = jSONObject2;
                                                String c$b1699434667869dc = c.b.c$b1699434667869dc("simt[qojm");
                                                if (floatValue <= 0.0f) {
                                                    floatValue = 0.0f;
                                                }
                                                jSONObject2.putOpt(c$b1699434667869dc, Float.valueOf(floatValue));
                                                if (!TextUtils.isEmpty(j.a(o.a())) && (qVar = qVar2) != null) {
                                                    com.bytedance.sdk.openadsdk.b.a.d.a(com.bytedance.sdk.openadsdk.n.a.a(qVar.T(), true));
                                                }
                                            }
                                        } catch (Exception unused) {
                                        }
                                    }
                                    new a.C0060a(currentTimeMillis, qVar2).d(str6).b(str5).c(str4).f(String.valueOf(j3)).g(String.valueOf(j4)).a(qVar2.Z()).a(jSONObject2).h(qVar2.bc()).a((com.bytedance.sdk.openadsdk.b.b.a) null);
                                    return;
                                default:
                                    c2 = 19;
                            }
                        }
                    }
                }
            });
        }
    }

    public static void a(q qVar, String str, String str2, Map<String, Object> map) {
        if (qVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (map != null) {
                    for (Map.Entry next : map.entrySet()) {
                        jSONObject2.put((String) next.getKey(), next.getValue());
                    }
                }
                jSONObject2.put(k.k1699434667889dc("dq]`v`gsaoTxt~j"), qVar.be());
                jSONObject.put(k.k1699434667889dc("ae]f|qtfWmkm"), jSONObject2.toString());
            } catch (Exception unused) {
            }
            b(System.currentTimeMillis(), qVar, str, str2, jSONObject);
        }
    }

    public static void a(q qVar, String str, String str2, JSONObject jSONObject) {
        if (qVar != null) {
            if (jSONObject != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("ae]f|qtfWmkm"), jSONObject.toString());
                    if (jSONObject.has(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("dtpbplii"))) {
                        jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("dtpbplii"), jSONObject.get(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("dtpbplii")));
                    }
                } catch (Exception e) {
                    l.e(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("TUCG*DbB~ld"), e.getMessage());
                }
                b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
            } else {
                a(System.currentTimeMillis(), qVar, str, str2);
            }
            if (com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("cmk`o").equals(str2)) {
                r.c(qVar);
            }
        }
    }

    public static void a(q qVar, String str, String str2, JSONObject jSONObject, long j) {
        while (true) {
            char c = '^';
            char c2 = AbstractJsonLexerKt.END_OBJ;
            while (true) {
                switch (c) {
                    case '^':
                        break;
                    case '_':
                        switch (c2) {
                            case '^':
                            case '`':
                                break;
                            case '_':
                                break;
                        }
                    case '`':
                        break;
                }
                switch (c2) {
                    case '7':
                    case '9':
                        break;
                    case '8':
                        break;
                }
                c2 = '_';
                c = '_';
            }
        }
        if (qVar != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                try {
                    jSONObject2.put(k.k1699434667889dc("ae]f|qtfWmkm"), jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            jSONObject2.put(k.k1699434667889dc("dtpbplii"), j);
            b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
        }
    }

    @JProtect
    public static void a(q qVar, String str, JSONObject jSONObject) {
        if (qVar != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final q qVar2 = qVar;
            final JSONObject jSONObject2 = jSONObject;
            final String str2 = str;
            a((h) new h(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ooQkkr")) {
                public void run() {
                    JSONObject jSONObject;
                    Object obj;
                    try {
                        r.b(qVar2);
                        jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = jSONObject2;
                            if (jSONObject2 != null) {
                                jSONObject2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("iovfvdesafdTahzgu"), qVar2.p());
                                jSONObject2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("rdco[lhsm{khxdaaO|wg|zr"), qVar2.o());
                                jSONObject2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("vhffkZulayUyi~{cd"), o.d().l(String.valueOf(qVar2.aZ())));
                                jSONObject.put(d.d1699434667873dc("ae]f|qtfWmkm"), jSONObject2.toString());
                            } else {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("iovfvdesafdTahzgu"), qVar2.p());
                                jSONObject3.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("rdco[lhsm{khxdaaO|wg|zr"), qVar2.o());
                                jSONObject3.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("vhffkZulayUyi~{cd"), o.d().l(String.valueOf(qVar2.aZ())));
                                jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ae]f|qtfWmkm"), jSONObject3.toString());
                            }
                            jSONObject.putOpt(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("lne\\a}rui"), qVar2.ac());
                            double currentTimeMillis = (double) (System.currentTimeMillis() / 1000);
                            double ba = qVar2.ba();
                            Double.isNaN(currentTimeMillis);
                            float floatValue = Double.valueOf(currentTimeMillis - ba).floatValue();
                            String j1699434667891dc = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("simt[qojm");
                            if (floatValue <= 0.0f) {
                                floatValue = 0.0f;
                            }
                            jSONObject.putOpt(j1699434667891dc, Float.valueOf(floatValue));
                            jSONObject.putOpt(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("u`]skiodq"), Integer.valueOf(qVar2.H()));
                            String z = qVar2.z();
                            if (!TextUtils.isEmpty(z)) {
                                if (!TextUtils.isEmpty(z)) {
                                    try {
                                        jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("tufptZvuajo"), Math.round(Float.parseFloat(z) * 100000.0f));
                                    } catch (Throwable th) {
                                        jSONObject.put(d.d1699434667873dc("tufptZvuajo"), 0);
                                        l.e(d.d1699434667873dc("TUCG*DbB~ld"), th.getMessage());
                                    }
                                }
                            }
                            if (qVar2.ai() != null) {
                                try {
                                    Object obj2 = qVar2.ai().get(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("sei\\flbcagmTxt~j"));
                                    if (!(obj2 == null || Integer.parseInt(obj2.toString()) != 2 || (obj = qVar2.ai().get(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("psk`a"))) == null)) {
                                        jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("tufptZvuajo"), Math.round(Double.parseDouble(obj.toString()) * 100000.0d));
                                    }
                                } catch (Throwable th2) {
                                    l.c(d.d1699434667873dc("TUCG*DbB~ld"), d.d1699434667873dc("cmkfjq&eamnbbj.bxqv4pdewk ;"), th2);
                                }
                            }
                            k.a(qVar2, str2);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        jSONObject = null;
                    }
                    new a.C0060a(currentTimeMillis, qVar2).b(str2).c(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("simt")).f(qVar2.Y()).a(qVar2.Z()).a(jSONObject).h(qVar2.bc()).a((com.bytedance.sdk.openadsdk.b.b.a) null);
                    if (!qVar2.az()) {
                        if (qVar2.bd()) {
                            com.bytedance.sdk.openadsdk.core.g.b.c.a(qVar2.S(), new c.b(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("simt[ptk{"), qVar2));
                        } else {
                            c.a(qVar2);
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.e.c.b();
                }
            });
        }
    }

    public static void a(q qVar, String str, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        final q qVar2 = qVar;
        final boolean z5 = z;
        final boolean z6 = z2;
        final boolean z7 = z3;
        final boolean z8 = z4;
        final int i2 = i;
        final String str2 = str;
        a((h) new h(d.d1699434667873dc("sucqpZuog~Unbimnbu")) {
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0077, code lost:
                switch(r0) {
                    case 39: goto L_0x007d;
                    case 40: goto L_0x007d;
                    case 41: goto L_0x007d;
                    default: goto L_0x007a;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x007a, code lost:
                r0 = '\'';
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    r0 = 56
                    r1 = 60
                L_0x0004:
                    r2 = 41
                L_0x0006:
                    switch(r2) {
                        case 40: goto L_0x000a;
                        case 41: goto L_0x007d;
                        case 42: goto L_0x0004;
                        default: goto L_0x0009;
                    }
                L_0x0009:
                    goto L_0x0004
                L_0x000a:
                    switch(r1) {
                        case 81: goto L_0x000e;
                        case 82: goto L_0x0077;
                        case 83: goto L_0x0012;
                        default: goto L_0x000d;
                    }
                L_0x000d:
                    goto L_0x007d
                L_0x000e:
                    switch(r0) {
                        case 29: goto L_0x0012;
                        case 30: goto L_0x0012;
                        case 31: goto L_0x007d;
                        default: goto L_0x0011;
                    }
                L_0x0011:
                    goto L_0x0077
                L_0x0012:
                    com.bytedance.sdk.openadsdk.core.model.q r0 = r2
                    if (r0 != 0) goto L_0x0017
                    return
                L_0x0017:
                    org.json.JSONObject r6 = new org.json.JSONObject
                    r6.<init>()
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0065 }
                    r0.<init>()     // Catch:{ all -> 0x0065 }
                    java.lang.String r1 = "irQhmu"
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)     // Catch:{ all -> 0x0065 }
                    boolean r2 = r3     // Catch:{ all -> 0x0065 }
                    r0.put(r1, r2)     // Catch:{ all -> 0x0065 }
                    java.lang.String r1 = "fnp`a"
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)     // Catch:{ all -> 0x0065 }
                    boolean r2 = r4     // Catch:{ all -> 0x0065 }
                    r0.put(r1, r2)     // Catch:{ all -> 0x0065 }
                    java.lang.String r1 = "irDqkhJffmcek]ohu"
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)     // Catch:{ all -> 0x0065 }
                    boolean r2 = r5     // Catch:{ all -> 0x0065 }
                    r0.put(r1, r2)     // Catch:{ all -> 0x0065 }
                    java.lang.String r1 = "fhljwmoio"
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)     // Catch:{ all -> 0x0065 }
                    boolean r2 = r6     // Catch:{ all -> 0x0065 }
                    r0.put(r1, r2)     // Catch:{ all -> 0x0065 }
                    java.lang.String r1 = "fsmn"
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)     // Catch:{ all -> 0x0065 }
                    int r2 = r7     // Catch:{ all -> 0x0065 }
                    r0.put(r1, r2)     // Catch:{ all -> 0x0065 }
                    java.lang.String r1 = "ae]f|qtfWmkm"
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)     // Catch:{ all -> 0x0065 }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0065 }
                    r6.put(r1, r0)     // Catch:{ all -> 0x0065 }
                L_0x0065:
                    long r1 = java.lang.System.currentTimeMillis()
                    com.bytedance.sdk.openadsdk.core.model.q r3 = r2
                    java.lang.String r4 = r8
                    java.lang.String r0 = "sucqpZuog~Unbimnbu"
                    java.lang.String r5 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r0)
                    com.bytedance.sdk.openadsdk.b.c.b((long) r1, (com.bytedance.sdk.openadsdk.core.model.q) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6)
                    return
                L_0x0077:
                    switch(r0) {
                        case 39: goto L_0x007d;
                        case 40: goto L_0x007d;
                        case 41: goto L_0x007d;
                        default: goto L_0x007a;
                    }
                L_0x007a:
                    r0 = 39
                    goto L_0x0077
                L_0x007d:
                    r2 = 40
                    r1 = 83
                    goto L_0x0006
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.b.c.AnonymousClass7.run():void");
            }
        });
    }

    public static void a(final String str) {
        final long currentTimeMillis = System.currentTimeMillis();
        a((h) new h(e.e1699434667871dc("sdlgHdus[ae|Mi")) {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(d.d1699434667873dc("smmw"), str);
                    jSONObject.put(d.d1699434667873dc("ae]f|qtfWmkm"), jSONObject2.toString());
                    long currentTimeMillis = System.currentTimeMillis() - m.d();
                    if (currentTimeMillis > 600000 || currentTimeMillis < 0) {
                        m.e();
                        return;
                    }
                    jSONObject.put(d.d1699434667873dc("dtpbplii"), currentTimeMillis);
                    q a2 = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(m.b()));
                    if (a2 != null) {
                        c.a(currentTimeMillis, a2, m.c(), c.b.c$b1699434667869dc("ndzw[iiflVymy}"), jSONObject, (g) null, (com.bytedance.sdk.openadsdk.b.b.a) null);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void a(String str, long j) {
        com.bytedance.sdk.openadsdk.core.d.c.a(str, j);
    }

    @JProtect
    public static void a(String str, q qVar, i iVar, String str2, boolean z, Map<String, Object> map, int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        final q qVar2 = qVar;
        final i iVar2 = iVar;
        final boolean z2 = z;
        final int i2 = i;
        final Map<String, Object> map2 = map;
        final String str3 = str2;
        final String str4 = str;
        a((h) new h(e.e1699434667871dc("ooAomfm")) {
            public void run() {
                while (true) {
                    char c2 = 11;
                    char c3 = '|';
                    while (true) {
                        if (c3 >= 26) {
                            switch (c2) {
                                case 10:
                                case 12:
                                    if (qVar2 != null) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            i iVar = iVar2;
                                            if (iVar != null) {
                                                JSONObject a2 = iVar.a();
                                                a2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ir]ueioc"), z2);
                                                int i = i2;
                                                if (i >= 1 && i <= 2) {
                                                    a2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("urgq[gcoicd~Rzv`t"), i2);
                                                }
                                                Map map = map2;
                                                if (map != null) {
                                                    if (map.containsKey(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("dtpbplii"))) {
                                                        jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("dtpbplii"), map2.get(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("dtpbplii")));
                                                    }
                                                    for (Map.Entry entry : map2.entrySet()) {
                                                        if (!com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("dtpbplii").equals(entry.getKey())) {
                                                            a2.put((String) entry.getKey(), entry.getValue());
                                                        }
                                                    }
                                                }
                                                a2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("iovfvdesafdTahzgu"), qVar2.p());
                                                if (str3.equals(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("oqgm[db"))) {
                                                    a2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ir]jgjhXggfr"), qVar2.br() ? 1 : 0);
                                                }
                                                jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ae]f|qtfWmkm"), a2.toString());
                                            }
                                            jSONObject.putOpt(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("lne\\a}rui"), qVar2.ac());
                                            double currentTimeMillis = (double) (System.currentTimeMillis() / 1000);
                                            double ba = qVar2.ba();
                                            Double.isNaN(currentTimeMillis);
                                            float floatValue = Double.valueOf(currentTimeMillis - ba).floatValue();
                                            String j1699434667891dc = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("simt[qojm");
                                            if (floatValue <= 0.0f) {
                                                floatValue = 0.0f;
                                            }
                                            jSONObject.putOpt(j1699434667891dc, Float.valueOf(floatValue));
                                            jSONObject.putOpt(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("u`]skiodq"), Integer.valueOf(qVar2.H()));
                                        } catch (Exception unused) {
                                        }
                                        new a.C0060a(currentTimeMillis, qVar2).b(str3).c(str4).f(qVar2.Y()).a(qVar2.Z()).a(jSONObject).h(qVar2.bc()).a((com.bytedance.sdk.openadsdk.b.b.a) null);
                                        if (!TextUtils.isEmpty(j.a(o.a())) && com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("cmk`o").equals(str4)) {
                                            com.bytedance.sdk.openadsdk.b.a.d.a(com.bytedance.sdk.openadsdk.n.a.a(qVar2.T(), true));
                                        }
                                        if (com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("cmk`o").equals(str4)) {
                                            r.c(qVar2);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                            }
                        }
                        c3 = '-';
                        c2 = 12;
                    }
                }
            }
        });
        while (true) {
            char c = 'J';
            char c2 = '7';
            while (true) {
                switch (c) {
                    case 'H':
                    case 'I':
                        switch (c2) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                return;
                        }
                    case 'J':
                        switch (c2) {
                            case '9':
                                return;
                        }
                    default:
                        c = 'H';
                        break;
                }
                c = 'I';
                c2 = '`';
            }
        }
    }

    @JProtect
    public static void a(String str, q qVar, String str2, g gVar) {
        if (qVar != null && gVar != null && gVar.a()) {
            final long currentTimeMillis = System.currentTimeMillis();
            final String str3 = str;
            final g gVar2 = gVar;
            final String str4 = str2;
            final q qVar2 = qVar;
            a((h) new h(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("aeQkkrRnelXn|b|{")) {
                public void run() {
                    while (true) {
                        char c2 = '`';
                        while (true) {
                            switch (c2) {
                                case '^':
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(d.d1699434667873dc("dtpbplii"), str3);
                                        g gVar = gVar2;
                                        if (!(gVar == null || gVar.b() == null)) {
                                            JSONObject b2 = gVar2.b();
                                            if (str4.equals(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("oqgm[db"))) {
                                                b2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ir]jgjhXggfr"), qVar2.br() ? 1 : 0);
                                            }
                                            jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ae]f|qtfWmkm"), b2.toString());
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    c.b(currentTimeMillis, qVar2, str4, d.d1699434667873dc("ae]pljqX|`gn"), jSONObject);
                                    return;
                                case '`':
                                    c2 = '^';
                            }
                        }
                    }
                }
            });
        }
    }

    public static void a(String str, q qVar, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry next : map.entrySet()) {
                    jSONObject2.put((String) next.getKey(), next.getValue());
                }
                jSONObject.put(d.d1699434667873dc("ae]f|qtfWmkm"), jSONObject2.toString());
            } catch (Exception unused) {
            }
        }
        b(System.currentTimeMillis(), qVar, str2, str, jSONObject);
    }

    public static void b() {
        f.b((h) new h(e.e1699434667871dc("simtBdokDfm")) {
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.j.b.a().a(c.a.c$a1699434667851dc("simt[cgndVfdk"), new JSONObject());
                } catch (Throwable th) {
                    l.e(c.a.c$a1699434667851dc("TUCG*DbB~ld"), th.getMessage());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    @JProtect
    public static void b(long j, q qVar, String str, String str2, JSONObject jSONObject) {
        if (qVar != null) {
            final JSONObject jSONObject2 = jSONObject;
            final q qVar2 = qVar;
            final long j2 = j;
            final String str3 = str;
            final String str4 = str2;
            a((h) new h(i.i1699434667884dc("sdlgAsci|")) {
                public void run() {
                    char c2 = 'I';
                    while (true) {
                        switch (c2) {
                            case 'H':
                                try {
                                    JSONObject jSONObject = jSONObject2;
                                    if (jSONObject != null) {
                                        jSONObject.putOpt(e.e1699434667871dc("lne\\a}rui"), qVar2.ac());
                                        jSONObject2.putOpt(e.e1699434667871dc("u`]skiodq"), Integer.valueOf(qVar2.H()));
                                    } else {
                                        l.c(p.p1699434667886dc("TUCG*DbB~ld"), p.p1699434667886dc("cbp#hja+(eelShv{bp2zg5szhmc"));
                                    }
                                } catch (Exception unused) {
                                }
                                new a.C0060a(j2, qVar2).b(str3).c(str4).f(qVar2.Y()).a(qVar2.Z()).a(jSONObject2).h(qVar2.bc()).a((com.bytedance.sdk.openadsdk.b.b.a) null);
                                return;
                            default:
                                c2 = 'H';
                        }
                    }
                }
            });
        }
    }

    public static void b(final q qVar, final String str) {
        a((h) new h(e.e1699434667871dc("phawqwcDd`i`")) {
            public void run() {
                if (qVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ae]phjrX|pzn"), qVar.D().getNativeAdType());
                        jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("iovfvdesafdTahzgu"), qVar.p());
                        jSONObject2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ae]f|qtfWmkm"), jSONObject.toString());
                    } catch (Throwable th) {
                        l.d(th.toString());
                    }
                    c.b(System.currentTimeMillis(), qVar, str, com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("phawqwcXkechg"), jSONObject2);
                }
            }
        });
        while (true) {
            char c = 15;
            while (true) {
                switch (c) {
                    case 13:
                    case 14:
                        return;
                    default:
                        c = 14;
                }
            }
        }
    }

    public static void b(q qVar, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(d.d1699434667873dc("txrf"), i);
        } catch (JSONException unused) {
        }
        b(qVar, str, d.d1699434667873dc("dnumhjgcWhz{SljPdcsp"), jSONObject);
    }

    public static void b(q qVar, String str, long j) {
        if (qVar != null) {
            final long j2 = j;
            final q qVar2 = qVar;
            final String str2 = str;
            a((h) new h(e.e1699434667871dc("aeAomfmT`f}_e`k]ua}a`")) {
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("vhffkZekajaThx|ndx}}Kaz}"), j2);
                        jSONObject2.put(com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("ae]f|qtfWmkm"), jSONObject.toString());
                    } catch (Throwable unused) {
                    }
                    long j = j2;
                    if (j > 0 && j < 200000) {
                        c.b(System.currentTimeMillis(), qVar2, str2, com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc("vhffkZekajaThx|ndx}}"), jSONObject2);
                    }
                }
            });
        }
    }

    @JProtect
    public static void b(q qVar, String str, ab abVar) {
        if (qVar != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final long c = abVar.c();
            final String str2 = str;
            final q qVar2 = qVar;
            a((h) new h(p.p1699434667886dc("sdlgHjgcL|xjxdaa")) {
                /* JADX WARNING: Can't fix incorrect switch cases order */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r7 = this;
                        com.bytedance.sdk.openadsdk.core.settings.e r0 = com.bytedance.sdk.openadsdk.core.o.d()
                        boolean r0 = r0.W()
                        if (r0 != 0) goto L_0x000b
                        return
                    L_0x000b:
                        org.json.JSONObject r6 = new org.json.JSONObject
                        r6.<init>()
                        java.lang.String r0 = "dtpbplii"
                        java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r0)     // Catch:{ all -> 0x001c }
                        long r1 = r2     // Catch:{ all -> 0x001c }
                        r6.put(r0, r1)     // Catch:{ all -> 0x001c }
                        goto L_0x002a
                    L_0x001c:
                        r0 = move-exception
                        java.lang.String r1 = "TUCG*DbB~ld"
                        java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r1)
                        java.lang.String r0 = r0.getMessage()
                        com.bytedance.sdk.component.utils.l.e(r1, r0)
                    L_0x002a:
                        java.lang.String r0 = r4
                        int r1 = r0.hashCode()
                        r2 = 4
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        switch(r1) {
                            case -1695837674: goto L_0x0070;
                            case -1364000502: goto L_0x0062;
                            case -764631662: goto L_0x0054;
                            case -712491894: goto L_0x0046;
                            case 1844104722: goto L_0x0038;
                            default: goto L_0x0037;
                        }
                    L_0x0037:
                        goto L_0x007e
                    L_0x0038:
                        java.lang.String r1 = "iovfvdesafd"
                        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r1)
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x007e
                        r0 = 1
                        goto L_0x007f
                    L_0x0046:
                        java.lang.String r1 = "el`f``bXim"
                        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r1)
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x007e
                        r0 = 2
                        goto L_0x007f
                    L_0x0054:
                        java.lang.String r1 = "ftnowftbmgUbbyk}ce{g}tzHy}"
                        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r1)
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x007e
                        r0 = 4
                        goto L_0x007f
                    L_0x0062:
                        java.lang.String r1 = "rdubvaccWcoib"
                        java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r1)
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x007e
                        r0 = 3
                        goto L_0x007f
                    L_0x0070:
                        java.lang.String r1 = "b`lmawYfl"
                        java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r1)
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x007e
                        r0 = 0
                        goto L_0x007f
                    L_0x007e:
                        r0 = -1
                    L_0x007f:
                        if (r0 == 0) goto L_0x0099
                        if (r0 == r5) goto L_0x0096
                        if (r0 == r4) goto L_0x0093
                        if (r0 == r3) goto L_0x0090
                        if (r0 == r2) goto L_0x008d
                        java.lang.String r0 = ""
                    L_0x008b:
                        r5 = r0
                        goto L_0x00a0
                    L_0x008d:
                        java.lang.String r0 = "ftnowftbmgUbbyk}ce{g}tzHy}Ews|zkILG"
                        goto L_0x009b
                    L_0x0090:
                        java.lang.String r0 = "rdubvaccWcoibQcpvg}xs"
                        goto L_0x009b
                    L_0x0093:
                        java.lang.String r0 = "el`f``bXimUgclj{y|w"
                        goto L_0x009b
                    L_0x0096:
                        java.lang.String r0 = "iovfvdesafdT`bokdxv"
                        goto L_0x009b
                    L_0x0099:
                        java.lang.String r0 = "b`lmawYflVfdmizf}t"
                    L_0x009b:
                        java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r0)
                        goto L_0x008b
                    L_0x00a0:
                        long r1 = r5
                        com.bytedance.sdk.openadsdk.core.model.q r3 = r7
                        java.lang.String r4 = r4
                        com.bytedance.sdk.openadsdk.b.c.b((long) r1, (com.bytedance.sdk.openadsdk.core.model.q) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.b.c.AnonymousClass15.run():void");
                }
            });
        }
    }

    public static void b(q qVar, String str, String str2) {
        char c = AbstractJsonLexerKt.STRING_ESC;
        while (true) {
            char c2 = 14;
            while (true) {
                switch (c2) {
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        switch (c) {
                            case '_':
                                if (qVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.putOpt(d.d1699434667873dc("esplvZkto"), str2);
                                        jSONObject.putOpt(d.d1699434667873dc("ae]f|qtfWmkm"), jSONObject2.toString());
                                    } catch (Exception unused) {
                                    }
                                    b(System.currentTimeMillis(), qVar, str, d.d1699434667873dc("simt[`tug{"), jSONObject);
                                    return;
                                }
                                return;
                        }
                }
                c2 = 15;
                c = '_';
            }
        }
    }

    public static void b(q qVar, String str, String str2, JSONObject jSONObject) {
        if (qVar != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                try {
                    jSONObject2.put(c.a.c$a1699434667851dc("ae]f|qtfWmkm"), jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
        }
    }

    public static void b(q qVar, String str, String str2, JSONObject jSONObject, long j) {
        if (qVar != null && jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(p.p1699434667886dc("ae]f|qtfWmkm"), jSONObject.toString());
                jSONObject2.put(p.p1699434667886dc("dtpbplii"), j);
            } catch (Throwable unused) {
            }
            b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
        }
    }

    public static void b(q qVar, String str, JSONObject jSONObject) {
        if (qVar != null) {
            a(qVar, str, -1, jSONObject);
        }
    }

    public static void c(q qVar, String str) {
        if (qVar != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("rdtfmfcX|z"), System.currentTimeMillis());
                if (str.equals(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("oqgm[db"))) {
                    jSONObject2.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("ir]jgjhXggfr"), qVar.br() ? 1 : 0);
                }
                jSONObject.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("ae]f|qtfWmkm"), jSONObject2.toString());
            } catch (Exception unused) {
            }
            b(System.currentTimeMillis(), qVar, str, com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("bhfgmkaXzline{k"), jSONObject);
        }
    }

    public static void c(q qVar, String str, long j) {
        if (qVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("dtpbplii"), j);
            } catch (Exception unused) {
            }
            b(System.currentTimeMillis(), qVar, str, com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("bhfgmkaXdfko"), jSONObject);
        }
    }

    @JProtect
    public static void c(q qVar, String str, String str2, JSONObject jSONObject) {
        if (qVar != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            b(System.currentTimeMillis(), qVar, str, str2, jSONObject);
        }
    }
}
