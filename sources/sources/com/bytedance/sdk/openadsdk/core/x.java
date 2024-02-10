package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.component.adexpress.b.k;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.b.c.e;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.g.b.c;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.core.settings.o;
import com.bytedance.sdk.openadsdk.g.c;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.i.f;
import com.bytedance.sdk.openadsdk.i.i;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.facebook.appevents.UserDataStore;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TTAndroidObject */
public class x implements com.bytedance.sdk.component.adexpress.d.b, x.a, com.bytedance.sdk.openadsdk.g.b {
    private static final Map<String, Boolean> h;
    private com.bytedance.sdk.openadsdk.i.b A;
    private i B;
    private boolean C = true;
    private List<q> D;
    private HashMap<String, i> E;
    private boolean F = false;
    private boolean G = false;
    private e H;
    private r I;
    /* access modifiers changed from: private */
    public String J;
    private boolean K = false;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.widget.a.a L;
    private f M;
    private boolean N;
    private boolean O;
    private Context P;
    private a Q;
    protected Map<String, Object> a;
    boolean b;
    boolean c = false;
    private WeakReference<SSWebView> d;
    private final com.bytedance.sdk.component.utils.x e;
    /* access modifiers changed from: private */
    public String f;
    private com.bytedance.sdk.openadsdk.core.widget.b g;
    private c i;
    private String j;
    private WeakReference<View> k;
    private String l;
    private int m;
    private String n;
    private int o;
    private boolean p = true;
    /* access modifiers changed from: private */
    public q q;
    private k r;
    private l s;
    private JSONObject t;
    private d u;
    private com.bytedance.sdk.openadsdk.i.a v;
    private com.bytedance.sdk.openadsdk.i.e w;
    private com.bytedance.sdk.openadsdk.i.d x;
    private JSONObject y;
    private com.bytedance.sdk.openadsdk.core.b.d z;

    /* compiled from: TTAndroidObject */
    public interface a {
        void a();
    }

    /* compiled from: TTAndroidObject */
    public static class b {
        public String a;
        public String b;
        public String c;
        public JSONObject d;
        public int e;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        h = concurrentHashMap;
        concurrentHashMap.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("lne\\asci|"), Boolean.TRUE);
        concurrentHashMap.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("pskueqc"), Boolean.TRUE);
        concurrentHashMap.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("dhqseqeoWdoxlij"), Boolean.TRUE);
        concurrentHashMap.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("ctqwkhYb~ld"), Boolean.TRUE);
        concurrentHashMap.put(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("lne\\asci|V|8"), Boolean.TRUE);
    }

    public x(Context context) {
        this.P = context;
        this.e = new com.bytedance.sdk.component.utils.x(Looper.getMainLooper(), this);
    }

    private void a(final b bVar, final JSONObject jSONObject) {
        if (bVar != null) {
            try {
                a(bVar.d, (com.bytedance.sdk.openadsdk.i.c) new com.bytedance.sdk.openadsdk.i.c() {
                });
            } catch (Exception unused) {
            }
        }
    }

    private void a(String str, boolean z2) {
        if (this.H != null && !TextUtils.isEmpty(str)) {
            if (z2) {
                this.H.a(str);
            } else {
                this.H.b(str);
            }
        }
    }

    @JProtect
    private void a(JSONObject jSONObject, int i2) throws Exception {
        String d1699434667873dc;
        String str;
        JSONArray jSONArray = new JSONArray();
        for (String put : q()) {
            jSONArray.put(put);
        }
        jSONObject.put(j.j1699434667891dc("aqrMehc"), com.bytedance.sdk.openadsdk.common.a.a());
        jSONObject.put(j.j1699434667891dc("iolfvDvwFhgn"), com.bytedance.sdk.openadsdk.common.a.e());
        jSONObject.put(j.j1699434667891dc("ahf"), com.bytedance.sdk.openadsdk.common.a.b());
        jSONObject.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("seiF`lrngg"), com.bytedance.sdk.openadsdk.common.a.c());
        jSONObject.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("aqrUawungg"), com.bytedance.sdk.openadsdk.common.a.d());
        jSONObject.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("ndvW}uc"), com.bytedance.sdk.openadsdk.common.a.f());
        jSONObject.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("strskwrKaz~"), jSONArray);
        jSONObject.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("ddtjg`Oc"), com.bytedance.sdk.openadsdk.common.a.a(o.a()));
        if (DeviceUtils.a(o.a())) {
            d1699434667873dc = com.bytedance.sdk.component.f.c.d.d1699434667873dc("ddtjg`Ywdh~mcc");
            str = "AofqklbXXhn";
        } else {
            d1699434667873dc = com.bytedance.sdk.component.f.c.d.d1699434667873dc("ddtjg`Ywdh~mcc");
            str = "Aofqklb";
        }
        jSONObject.put(d1699434667873dc, com.bytedance.sdk.component.f.c.d.d1699434667873dc(str));
        jSONObject.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("ddtjg`Ysqyo"), Build.VERSION.RELEASE);
    }

    private static void a(JSONObject jSONObject, q qVar) throws Exception {
        String Y = qVar.Y();
        if (!TextUtils.isEmpty(Y)) {
            jSONObject.put(com.bytedance.sdk.component.f.c.e.e1699434667871dc("chf"), Y);
        }
        String ac = qVar.ac();
        if (!TextUtils.isEmpty(ac)) {
            jSONObject.put(com.bytedance.sdk.component.f.c.e.e1699434667871dc("lne\\a}rui"), ac);
        }
        String bb = qVar.bb();
        if (!TextUtils.isEmpty(bb)) {
            jSONObject.put(com.bytedance.sdk.component.f.c.e.e1699434667871dc("dnumhjgcW|xg"), bb);
        }
        jSONObject.put(com.bytedance.sdk.component.f.c.e.e1699434667871dc(UserDataStore.DATE_OF_BIRTH), TextUtils.isEmpty(o.d().M()) ? o.d().M() : com.bytedance.sdk.component.f.c.e.e1699434667871dc("SF"));
        jSONObject.put(com.bytedance.sdk.component.f.c.e.e1699434667871dc("l`ldqdab"), ac.h(o.a()));
        jSONObject.put(com.bytedance.sdk.component.f.c.e.e1699434667871dc("irPWH"), o.ai().ae());
    }

    @JProtect
    private boolean a(String str, int i2, m mVar) {
        HashMap<String, i> hashMap;
        i iVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.E) == null || (iVar = hashMap.get(str)) == null) {
            return false;
        }
        iVar.a(i2, mVar);
        return true;
    }

    public static JSONArray b(List<q> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            jSONArray.put(list.get(i2).ao());
        }
        return jSONArray;
    }

    private void b(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(c.a.c$a1699434667851dc("_^opcZr~xl"), c.a.c$a1699434667851dc("c`nofdel"));
            jSONObject2.put(c.a.c$a1699434667851dc("_^abhidfkbUbh"), str);
            if (jSONObject != null) {
                jSONObject2.put(c.a.c$a1699434667851dc("_^rbvdkt"), jSONObject);
            }
            q(jSONObject2);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ int c(x xVar) {
        int i2 = xVar.o;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        break;
                }
                c3 = AbstractJsonLexerKt.END_LIST;
                c2 = AbstractJsonLexerKt.END_LIST;
            }
            while (true) {
                switch (c3) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = AbstractJsonLexerKt.BEGIN_LIST;
                }
            }
        }
        return i2;
    }

    private void c(String str, JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(p.p1699434667886dc("_^opcZr~xl"), p.p1699434667886dc("ewgmp"));
                jSONObject2.put(p.p1699434667886dc("_^guakrXam"), str);
                if (jSONObject != null) {
                    jSONObject2.put(p.p1699434667886dc("_^rbvdkt"), jSONObject);
                }
                q(jSONObject2);
            }
        } catch (Exception unused) {
        }
    }

    private void e(JSONObject jSONObject) throws Exception {
        if (this.N) {
            q qVar = this.q;
            if ((qVar instanceof com.bytedance.sdk.openadsdk.core.model.r) && ((com.bytedance.sdk.openadsdk.core.model.r) qVar).bw()) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put(p.p1699434667886dc("aeKmbju"), jSONArray);
                for (q a2 : ((com.bytedance.sdk.openadsdk.core.model.r) this.q).by()) {
                    JSONObject jSONObject2 = new JSONObject();
                    a(jSONObject2, a2);
                    jSONArray.put(jSONObject2);
                }
                return;
            }
        }
        a(jSONObject, this.q);
    }

    private void f(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(t.d(this.q))) {
            jSONObject.put(j.j1699434667891dc("pmczegjbWz~r`h"), t.d(this.q));
        }
    }

    private void g(JSONObject jSONObject) {
        e eVar;
        if (jSONObject != null && (eVar = this.H) != null) {
            eVar.b(jSONObject);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:4|5|6|(1:8)|9|10|(1:24)(2:12|(2:14|25)(2:15|23))|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0067 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0071 A[Catch:{ Exception -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "TUCG*DhczfcoCodjse"
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x008e }
            r2 = 2
            byte[] r2 = android.util.Base64.decode(r9, r2)     // Catch:{ Exception -> 0x008e }
            r1.<init>(r2)     // Catch:{ Exception -> 0x008e }
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r0)     // Catch:{ Exception -> 0x008e }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x008e }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x008e }
            r2.<init>(r1)     // Catch:{ Exception -> 0x008e }
            int r1 = r2.length()     // Catch:{ Exception -> 0x008e }
            r3 = 0
        L_0x001d:
            if (r3 >= r1) goto L_0x00bf
            com.bytedance.sdk.openadsdk.core.x$b r4 = new com.bytedance.sdk.openadsdk.core.x$b     // Catch:{ Exception -> 0x008e }
            r4.<init>()     // Catch:{ Exception -> 0x008e }
            org.json.JSONObject r5 = r2.optJSONObject(r3)     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x0067
            java.lang.String r6 = "_^opcZr~xl"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r6)     // Catch:{ all -> 0x0067 }
            r7 = 0
            java.lang.String r6 = r5.optString(r6, r7)     // Catch:{ all -> 0x0067 }
            r4.a = r6     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = "_^abhidfkbUbh"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r6)     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = r5.optString(r6, r7)     // Catch:{ all -> 0x0067 }
            r4.b = r6     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = "ftl`"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r6)     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = r5.optString(r6)     // Catch:{ all -> 0x0067 }
            r4.c = r6     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = "p`pbiv"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r6)     // Catch:{ all -> 0x0067 }
            org.json.JSONObject r6 = r5.optJSONObject(r6)     // Catch:{ all -> 0x0067 }
            r4.d = r6     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = "JRQGO"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r6)     // Catch:{ all -> 0x0067 }
            int r5 = r5.optInt(r6)     // Catch:{ all -> 0x0067 }
            r4.e = r5     // Catch:{ all -> 0x0067 }
        L_0x0067:
            java.lang.String r5 = r4.a     // Catch:{ Exception -> 0x008e }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x008e }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x008e }
            if (r5 != 0) goto L_0x008b
            java.lang.String r5 = r4.c     // Catch:{ Exception -> 0x008e }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x008e }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x008e }
            if (r5 == 0) goto L_0x007c
            goto L_0x008b
        L_0x007c:
            com.bytedance.sdk.component.utils.x r5 = r8.e     // Catch:{ Exception -> 0x008e }
            r6 = 11
            android.os.Message r5 = r5.obtainMessage(r6)     // Catch:{ Exception -> 0x008e }
            r5.obj = r4     // Catch:{ Exception -> 0x008e }
            com.bytedance.sdk.component.utils.x r4 = r8.e     // Catch:{ Exception -> 0x008e }
            r4.sendMessage(r5)     // Catch:{ Exception -> 0x008e }
        L_0x008b:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x008e:
            boolean r1 = com.bytedance.sdk.component.utils.l.a()
            if (r1 == 0) goto L_0x00b2
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "f`koaa&sg)zj~~k/zbpa}qqr8ti|<lkzUD\u0002"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r2)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.bytedance.sdk.component.utils.l.d((java.lang.String) r0, (java.lang.String) r9)
            goto L_0x00bf
        L_0x00b2:
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r0)
            java.lang.String r0 = "f`koaa&sg)zj~~k/zbpa}qqr8ti|<lkzUD"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r0)
            com.bytedance.sdk.component.utils.l.d((java.lang.String) r9, (java.lang.String) r0)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.h(java.lang.String):void");
    }

    private void h(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.i.b bVar = this.A;
        if (bVar != null && jSONObject != null) {
            bVar.a(jSONObject.optBoolean(c.b.c$b1699434667869dc("irPfjacu[|i"), false), jSONObject.optInt(c.b.c$b1699434667869dc("cnff"), -1), jSONObject.optString(c.b.c$b1699434667869dc("mre"), ""));
        }
    }

    /* access modifiers changed from: private */
    public void i(JSONObject jSONObject) {
        if (this.s != null && jSONObject != null) {
            try {
                this.s.a(jSONObject.optBoolean(com.bytedance.sdk.component.f.c.e.e1699434667871dc("mtvf"), false));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean i(String str) {
        if (!TextUtils.isEmpty(str) && com.bytedance.sdk.component.f.c.d.d1699434667873dc("cmk`oZis`lx").equals(str)) {
            return j();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public String j(String str) {
        return this.A != null ? ac.a(this.m) : this.r == null ? ac.b(this.m) : str;
    }

    /* access modifiers changed from: private */
    public void j(JSONObject jSONObject) {
        if (this.s != null && jSONObject != null) {
            try {
                this.s.a(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("sucwaQwm"), -1));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        r0 = r1.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "bxvf`dhdm3%$"
            java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)
            boolean r0 = r3.startsWith(r0)
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            java.lang.String r0 = "bxvf`dhdm3%$hd}qeq{Kxsdkx}~3"
            java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)
            java.lang.String r1 = "bxvf`dhdm3%$|gyqew<gpbe}jowh2"
            java.lang.String r1 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r1)
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x0032
            android.webkit.WebView r3 = r2.o()     // Catch:{ Exception -> 0x0064 }
            if (r3 == 0) goto L_0x0064
            java.lang.String r0 = "j`tbwftnx}0_cxzfq~X@Vgs|4Dzxj|HpWFQ@\u000e\u000e"
            java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)     // Catch:{ Exception -> 0x0064 }
            com.bytedance.sdk.component.utils.k.a(r3, r0)     // Catch:{ Exception -> 0x0064 }
            goto L_0x0064
        L_0x0032:
            boolean r0 = r3.startsWith(r1)     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x0064
            int r0 = r1.length()     // Catch:{ Exception -> 0x0064 }
            r1 = 38
            int r1 = r3.indexOf(r1, r0)     // Catch:{ Exception -> 0x0064 }
            if (r1 > 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.String r0 = r3.substring(r0, r1)     // Catch:{ Exception -> 0x0064 }
            int r1 = r1 + 1
            java.lang.String r3 = r3.substring(r1)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r1 = "SBGMAZ@B\\JBZYH[J"
            java.lang.String r1 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r1)     // Catch:{ Exception -> 0x0064 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x0064
            int r0 = r3.length()     // Catch:{ Exception -> 0x0064 }
            if (r0 <= 0) goto L_0x0064
            r2.h((java.lang.String) r3)     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.k(java.lang.String):void");
    }

    private boolean k(JSONObject jSONObject) {
        l lVar = this.s;
        if (!(lVar == null || jSONObject == null)) {
            double c2 = (double) lVar.c();
            int d2 = this.s.d();
            try {
                String b1699434667886dc = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("ctpqakrSado");
                Double.isNaN(c2);
                jSONObject.put(b1699434667886dc, c2 / 1000.0d);
                jSONObject.put(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("sucwa"), d2);
                char c3 = 'I';
                while (true) {
                    switch (c3) {
                        case 'H':
                            return true;
                        default:
                            c3 = 'H';
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0121 A[SYNTHETIC] */
    @com.bytedance.JProtect
    private void l(org.json.JSONObject r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            com.bytedance.sdk.component.adexpress.b.k r2 = r0.r
            if (r2 == 0) goto L_0x0139
            if (r1 != 0) goto L_0x000c
            goto L_0x0139
        L_0x000c:
            com.bytedance.sdk.component.adexpress.b.n r2 = new com.bytedance.sdk.component.adexpress.b.n
            r2.<init>()
            r3 = 1
            r2.a((int) r3)
            java.lang.String r4 = "irPfjacu[|i"
            java.lang.String r4 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r4)     // Catch:{ Exception -> 0x0128 }
            boolean r4 = r1.optBoolean(r4)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r5 = "AeQj~`"
            java.lang.String r5 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r5)     // Catch:{ Exception -> 0x0128 }
            org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r6 = "hdkdlq"
            java.lang.String r7 = "whfwl"
            if (r5 == 0) goto L_0x0041
            java.lang.String r8 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r7)     // Catch:{ Exception -> 0x0128 }
            double r8 = r5.optDouble(r8)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r10 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r6)     // Catch:{ Exception -> 0x0128 }
            double r10 = r5.optDouble(r10)     // Catch:{ Exception -> 0x0128 }
            goto L_0x0044
        L_0x0041:
            r8 = 0
            r10 = r8
        L_0x0044:
            java.lang.String r5 = "vhffkLhag"
            java.lang.String r5 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r5)     // Catch:{ Exception -> 0x0128 }
            org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x0128 }
            if (r5 == 0) goto L_0x00ce
            java.lang.String r12 = "x"
            java.lang.String r12 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r12)     // Catch:{ Exception -> 0x00c9 }
            double r12 = r5.optDouble(r12)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r14 = "y"
            java.lang.String r14 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r14)     // Catch:{ Exception -> 0x00c9 }
            double r14 = r5.optDouble(r14)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r7 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r7)     // Catch:{ Exception -> 0x00c9 }
            r16 = r4
            double r3 = r5.optDouble(r7)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r6 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r6)     // Catch:{ Exception -> 0x00c9 }
            double r6 = r5.optDouble(r6)     // Catch:{ Exception -> 0x00c9 }
            boolean r17 = r0.m(r5)     // Catch:{ Exception -> 0x00c9 }
            if (r17 == 0) goto L_0x00ba
            java.lang.String r17 = "bnpgawTfl`xXb~Cuwf"
            java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r17)     // Catch:{ Exception -> 0x00c9 }
            r17 = r10
            double r10 = r5.optDouble(r0)     // Catch:{ Exception -> 0x00c9 }
            float r0 = (float) r10     // Catch:{ Exception -> 0x00c9 }
            r2.a((float) r0)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r0 = "bnpgawTfl`xXb~]yvzg"
            java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)     // Catch:{ Exception -> 0x00c9 }
            double r10 = r5.optDouble(r0)     // Catch:{ Exception -> 0x00c9 }
            float r0 = (float) r10     // Catch:{ Exception -> 0x00c9 }
            r2.b((float) r0)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r0 = "bnpgawTfl`xNbz{|^vra"
            java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)     // Catch:{ Exception -> 0x00c9 }
            double r10 = r5.optDouble(r0)     // Catch:{ Exception -> 0x00c9 }
            float r0 = (float) r10     // Catch:{ Exception -> 0x00c9 }
            r2.c((float) r0)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r0 = "bnpgawTfl`xNbz{|@zs}b"
            java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)     // Catch:{ Exception -> 0x00c9 }
            double r10 = r5.optDouble(r0)     // Catch:{ Exception -> 0x00c9 }
            float r0 = (float) r10     // Catch:{ Exception -> 0x00c9 }
            r2.d((float) r0)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00bc
        L_0x00ba:
            r17 = r10
        L_0x00bc:
            r2.c((double) r12)     // Catch:{ Exception -> 0x00c9 }
            r2.d((double) r14)     // Catch:{ Exception -> 0x00c9 }
            r2.e(r3)     // Catch:{ Exception -> 0x00c9 }
            r2.f(r6)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00d2
        L_0x00c9:
            r1 = 101(0x65, float:1.42E-43)
            r0 = r19
            goto L_0x012a
        L_0x00ce:
            r16 = r4
            r17 = r10
        L_0x00d2:
            java.lang.String r0 = "mdqpebc"
            java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)     // Catch:{ Exception -> 0x0126 }
            r3 = 101(0x65, float:1.42E-43)
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.a(r3)     // Catch:{ Exception -> 0x0126 }
            java.lang.String r0 = r1.optString(r0, r4)     // Catch:{ Exception -> 0x0126 }
            java.lang.String r4 = "cnff"
            java.lang.String r4 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r4)     // Catch:{ Exception -> 0x0126 }
            int r1 = r1.optInt(r4, r3)     // Catch:{ Exception -> 0x0126 }
            r3 = r16
            r2.a((boolean) r3)     // Catch:{ Exception -> 0x0126 }
            r2.a((double) r8)     // Catch:{ Exception -> 0x0126 }
            r8 = r17
            r2.b((double) r8)     // Catch:{ Exception -> 0x0126 }
            r2.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0126 }
            r2.b((int) r1)     // Catch:{ Exception -> 0x0126 }
            r0 = r19
            com.bytedance.sdk.component.adexpress.b.k r1 = r0.r     // Catch:{ Exception -> 0x0128 }
            r1.a(r2)     // Catch:{ Exception -> 0x0128 }
            if (r5 == 0) goto L_0x0139
            com.bytedance.sdk.openadsdk.i.f r1 = r0.M     // Catch:{ Exception -> 0x0128 }
            if (r1 == 0) goto L_0x0110
            r1.a(r2)     // Catch:{ Exception -> 0x0128 }
            goto L_0x011b
        L_0x0110:
            r1 = 90
        L_0x0112:
            r2 = 40
        L_0x0114:
            switch(r2) {
                case 40: goto L_0x011e;
                case 41: goto L_0x0121;
                case 42: goto L_0x0118;
                default: goto L_0x0117;
            }
        L_0x0117:
            goto L_0x0121
        L_0x0118:
            switch(r1) {
                case 70: goto L_0x0121;
                case 71: goto L_0x0139;
                case 72: goto L_0x0139;
                default: goto L_0x011b;
            }
        L_0x011b:
            r1 = 89
            goto L_0x0112
        L_0x011e:
            switch(r1) {
                case 89: goto L_0x0121;
                case 90: goto L_0x0139;
                case 91: goto L_0x0121;
                default: goto L_0x0121;
            }
        L_0x0121:
            r2 = 42
            r1 = 71
            goto L_0x0114
        L_0x0126:
            r0 = r19
        L_0x0128:
            r1 = 101(0x65, float:1.42E-43)
        L_0x012a:
            r2.b((int) r1)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r1)
            r2.a((java.lang.String) r1)
            com.bytedance.sdk.component.adexpress.b.k r1 = r0.r
            r1.a(r2)
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.l(org.json.JSONObject):void");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    private boolean m(org.json.JSONObject r5) {
        /*
            r4 = this;
            java.lang.String r0 = "bnpgawTfl`xXb~Cuwf"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r0)
            boolean r0 = r5.has(r0)
            r1 = 0
            r2 = 56
            r3 = 60
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "bnpgawTfl`xNbz{|^vra"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r0)
            boolean r0 = r5.has(r0)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "bnpgawTfl`xXb~]yvzg"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r0)
            boolean r0 = r5.has(r0)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "bnpgawTfl`xNbz{|@zs}b"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r0)
            boolean r5 = r5.has(r0)
            goto L_0x0043
        L_0x0034:
            r5 = 0
        L_0x0035:
            r0 = 41
        L_0x0037:
            switch(r0) {
                case 40: goto L_0x003b;
                case 41: goto L_0x0055;
                case 42: goto L_0x0035;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0035
        L_0x003b:
            switch(r3) {
                case 81: goto L_0x003f;
                case 82: goto L_0x0049;
                case 83: goto L_0x0047;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0055
        L_0x003f:
            switch(r2) {
                case 29: goto L_0x0047;
                case 30: goto L_0x0047;
                case 31: goto L_0x0043;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x0049
        L_0x0043:
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x004d
        L_0x0047:
            r1 = r5
            goto L_0x0055
        L_0x0049:
            switch(r2) {
                case 39: goto L_0x004d;
                case 40: goto L_0x0034;
                case 41: goto L_0x0055;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x0052
        L_0x004d:
            r0 = 40
            r3 = 83
            goto L_0x0037
        L_0x0052:
            r2 = 39
            goto L_0x0049
        L_0x0055:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.m(org.json.JSONObject):boolean");
    }

    private void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.bytedance.sdk.component.utils.l.b(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("TUCG*DhczfcoCodjse"), com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("TUCm`winlFhainz/xp|wxpdSaw{vu~JmABI"));
            try {
                Uri parse = Uri.parse(jSONObject.optString(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("tsc`oAgsi")));
                if (com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("bxvf`dhdm").equals(parse.getScheme().toLowerCase())) {
                    com.bytedance.sdk.openadsdk.utils.l.a(parse, this);
                    char c2 = '(';
                    while (true) {
                        switch (c2) {
                            case ')':
                                return;
                            default:
                                c2 = ')';
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private WebView o() {
        WeakReference<SSWebView> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return ((SSWebView) this.d.get()).getWebView();
    }

    private void o(JSONObject jSONObject) {
        if (jSONObject != null && this.u != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(j.j1699434667891dc("tdobmUthl|iEi}"));
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    this.u.a(false, (JSONArray) null);
                    return;
                }
                this.u.a(true, optJSONArray);
                char c2 = '\'';
                while (true) {
                    switch (c2) {
                        case '&':
                            return;
                        default:
                            c2 = Typography.amp;
                    }
                }
            } catch (Exception unused) {
                this.u.a(false, (JSONArray) null);
            }
        }
    }

    @JProtect
    private JSONObject p() {
        try {
            View view = (View) this.k.get();
            View view2 = (View) this.d.get();
            if (view != null) {
                if (view2 != null) {
                    int[] b2 = ad.b(view);
                    int[] b3 = ad.b(view2);
                    if (b2 != null) {
                        if (b3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(c.b.c$b1699434667869dc("x"), ad.c(o.a(), (float) (b2[0] - b3[0])));
                            jSONObject.put(c.b.c$b1699434667869dc("y"), ad.c(o.a(), (float) (b2[1] - b3[1])));
                            jSONObject.put(c.b.c$b1699434667869dc("w"), ad.c(o.a(), (float) view.getWidth()));
                            jSONObject.put(c.b.c$b1699434667869dc(CmcdHeadersFactory.STREAMING_FORMAT_HLS), ad.c(o.a(), (float) view.getHeight()));
                            jSONObject.put(c.b.c$b1699434667869dc("irG{mvr"), true);
                            return jSONObject;
                        }
                    }
                    com.bytedance.sdk.component.utils.l.e(c.b.c$b1699434667869dc("TUCG*DhczfcoCodjse"), c.b.c$b1699434667869dc("sdv@hjubJ|~ccGav~2vfgye8iuhuiwpN\u0001MQ\u0004RCE~@O\\|B]FDX]]\u0014\\E\u0017VLVW"));
                    return null;
                }
            }
            com.bytedance.sdk.component.utils.l.e(c.b.c$b1699434667869dc("TUCG*DhczfcoCodjse"), c.b.c$b1699434667869dc("sdv@hjubJ|~ccGav~2vfgye8zvtox\\jTUMM\u0004LU\u0007F\\FG"));
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.a(c.b.c$b1699434667869dc("TUCG*DhczfcoCodjse"), c.b.c$b1699434667869dc("sdv@hjubJ|~ccGav~2vfgye"), th);
            return null;
        }
    }

    private boolean p(JSONObject jSONObject) {
        try {
            jSONObject.put(com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc("csgbplpb{"), b(this.D));
            while (true) {
                char c2 = '_';
                char c3 = '_';
                while (true) {
                    switch (c2) {
                        case '^':
                            if (c3 != '\'') {
                                break;
                            } else {
                                continue;
                            }
                        case '_':
                            switch (c3) {
                                case '^':
                                case '`':
                                    continue;
                                case '_':
                                    break;
                            }
                        case '`':
                            break;
                    }
                    switch (c3) {
                        case '7':
                        case '8':
                        case '9':
                            break;
                    }
                    c2 = '^';
                    c3 = AbstractJsonLexerKt.END_OBJ;
                }
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    private List<String> q() {
        return Arrays.asList(new String[]{com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc("aqrJjci"), com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc("aeKmbj"), com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc("gdvWahvki}oBbka"), com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc("gdvWaHgnImy")});
    }

    private void q(JSONObject jSONObject) {
        WebView o2;
        if (jSONObject != null && (o2 = o()) != null) {
            String str = p.p1699434667886dc("j`tbwftnx}0_cxzfq~X@Vgs|4Dt|p{LDoFWVG@MoXDAyAZDXS\\\u001c") + jSONObject + p.p1699434667886dc(")");
            com.bytedance.sdk.component.utils.k.a(o2, str);
            if (com.bytedance.sdk.component.utils.l.a()) {
                com.bytedance.sdk.component.utils.l.a(p.p1699434667886dc("TUCG*DhczfcoCodjse"), p.p1699434667886dc("jr]nwb&") + str);
            }
        }
    }

    /* access modifiers changed from: private */
    public JSONObject r(JSONObject jSONObject) {
        if (this.a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString(com.bytedance.sdk.component.f.c.d.d1699434667873dc("ae]f|qtfWmkm"), (String) null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                for (Map.Entry next : this.a.entrySet()) {
                    jSONObject2.put((String) next.getKey(), next.getValue());
                }
                jSONObject.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("ae]f|qtfWmkm"), jSONObject2.toString());
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.l.d(e2.toString());
            }
        }
        return jSONObject;
    }

    private void r() {
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
    }

    private void s() {
        i iVar = this.B;
        if (iVar != null) {
            iVar.b();
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.a();
            char c2 = AbstractJsonLexerKt.STRING_ESC;
            while (true) {
                char c3 = 14;
                while (true) {
                    switch (c3) {
                        case 13:
                            break;
                        case 14:
                            break;
                        case 15:
                            switch (c2) {
                                case '_':
                                    return;
                            }
                    }
                    c3 = 15;
                    c2 = '_';
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        switch(r1) {
            case 29: goto L_0x0035;
            case 30: goto L_0x0022;
            case 31: goto L_0x0028;
            default: goto L_0x0034;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        r1 = 30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        switch(r0) {
            case 52: goto L_0x0022;
            case 53: goto L_0x0031;
            case 54: goto L_0x002c;
            default: goto L_0x002b;
        };
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u() {
        /*
            r4 = this;
            android.content.Context r0 = r4.P
            r1 = 55
            if (r0 == 0) goto L_0x0021
            com.bytedance.sdk.openadsdk.core.settings.e r0 = com.bytedance.sdk.openadsdk.core.o.d()
            java.lang.String r0 = r0.J()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            android.content.Context r0 = r4.P
            com.bytedance.sdk.openadsdk.core.model.q r2 = r4.q
            java.lang.String r3 = r4.J
            com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.a(r0, r2, r3)
            goto L_0x002c
        L_0x0021:
            r0 = 0
        L_0x0022:
            r2 = 72
        L_0x0024:
            switch(r2) {
                case 72: goto L_0x003e;
                case 73: goto L_0x0039;
                case 74: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x0022
        L_0x0028:
            switch(r0) {
                case 52: goto L_0x0022;
                case 53: goto L_0x0031;
                case 54: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x003e
        L_0x002c:
            r2 = 73
            r0 = 16
            goto L_0x0024
        L_0x0031:
            switch(r1) {
                case 29: goto L_0x0035;
                case 30: goto L_0x0022;
                case 31: goto L_0x0028;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0036
        L_0x0035:
            return
        L_0x0036:
            r1 = 30
            goto L_0x0031
        L_0x0039:
            r2 = 57
            if (r0 > r2) goto L_0x003e
            goto L_0x0022
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.u():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c1 A[Catch:{ Exception -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2 A[Catch:{ Exception -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d1 A[Catch:{ Exception -> 0x00e2 }] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject v() {
        /*
            r10 = this;
        L_0x0000:
            r0 = 11
        L_0x0002:
            switch(r0) {
                case 10: goto L_0x000b;
                case 11: goto L_0x0008;
                case 12: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            goto L_0x0006
        L_0x0008:
            r0 = 10
            goto L_0x0002
        L_0x000b:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.bytedance.sdk.openadsdk.core.settings.e r1 = com.bytedance.sdk.openadsdk.core.o.d()
            if (r1 != 0) goto L_0x0017
            return r0
        L_0x0017:
            com.bytedance.sdk.openadsdk.core.model.q r1 = r10.q     // Catch:{ Exception -> 0x00e2 }
            r2 = 0
            if (r1 == 0) goto L_0x0021
            int r1 = r1.aZ()     // Catch:{ Exception -> 0x00e2 }
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            com.bytedance.sdk.openadsdk.core.model.q r3 = r10.q     // Catch:{ Exception -> 0x00e2 }
            if (r3 == 0) goto L_0x002b
            int r3 = r3.aS()     // Catch:{ Exception -> 0x00e2 }
            goto L_0x002c
        L_0x002b:
            r3 = 0
        L_0x002c:
            com.bytedance.sdk.openadsdk.core.settings.e r4 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00e2 }
            int r4 = r4.j(r5)     // Catch:{ Exception -> 0x00e2 }
            com.bytedance.sdk.openadsdk.core.settings.e r5 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00e2 }
            int r5 = r5.q(r6)     // Catch:{ Exception -> 0x00e2 }
            com.bytedance.sdk.openadsdk.core.settings.e r6 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00e2 }
            boolean r6 = r6.f(r7)     // Catch:{ Exception -> 0x00e2 }
            com.bytedance.sdk.openadsdk.core.model.q r7 = r10.q     // Catch:{ Exception -> 0x00e2 }
            boolean r7 = com.bytedance.sdk.openadsdk.core.model.q.c((com.bytedance.sdk.openadsdk.core.model.q) r7)     // Catch:{ Exception -> 0x00e2 }
            r8 = 1
            if (r7 != 0) goto L_0x0069
            com.bytedance.sdk.openadsdk.core.settings.e r7 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r9 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00e2 }
            int r7 = r7.l(r9)     // Catch:{ Exception -> 0x00e2 }
            if (r7 != r8) goto L_0x0069
            r7 = 1
            goto L_0x006a
        L_0x0069:
            r7 = 0
        L_0x006a:
            r9 = 7
            if (r3 == r9) goto L_0x007f
            r9 = 8
            if (r3 != r9) goto L_0x0072
            goto L_0x007f
        L_0x0072:
            com.bytedance.sdk.openadsdk.core.settings.e r3 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00e2 }
            boolean r1 = r3.c((java.lang.String) r1)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x008b
        L_0x007f:
            com.bytedance.sdk.openadsdk.core.settings.e r3 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00e2 }
            boolean r1 = r3.p(r1)     // Catch:{ Exception -> 0x00e2 }
        L_0x008b:
            java.lang.String r3 = "vnk`aZehf}xd`"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r3)     // Catch:{ Exception -> 0x00e2 }
            r0.put(r3, r1)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "rw]polvX|`gn"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r1)     // Catch:{ Exception -> 0x00e2 }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "fw]polvX{ae|"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r1)     // Catch:{ Exception -> 0x00e2 }
            r0.put(r1, r6)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "iw]polvX|`gn"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r1)     // Catch:{ Exception -> 0x00e2 }
            r0.put(r1, r5)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "simt[aotd`an"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r1)     // Catch:{ Exception -> 0x00e2 }
            com.bytedance.sdk.openadsdk.core.model.q r3 = r10.q     // Catch:{ Exception -> 0x00e2 }
            if (r3 == 0) goto L_0x00c2
            boolean r3 = r3.an()     // Catch:{ Exception -> 0x00e2 }
            if (r3 == 0) goto L_0x00c2
            goto L_0x00c3
        L_0x00c2:
            r8 = 0
        L_0x00c3:
            r0.put(r1, r8)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "vhffkZgciy~jxdaa"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r1)     // Catch:{ Exception -> 0x00e2 }
            com.bytedance.sdk.openadsdk.core.model.q r3 = r10.q     // Catch:{ Exception -> 0x00e2 }
            if (r3 == 0) goto L_0x00d5
            int r2 = r3.A()     // Catch:{ Exception -> 0x00e2 }
        L_0x00d5:
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "sjks[fnffnoTxbQl|~av"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r1)     // Catch:{ Exception -> 0x00e2 }
            r0.put(r1, r7)     // Catch:{ Exception -> 0x00e2 }
        L_0x00e2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.v():org.json.JSONObject");
    }

    private boolean w() {
        q qVar = this.q;
        if (qVar == null || qVar.aj() == null || t.b(this.q) || this.F || this.q.aj().optInt(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("p`pfjqYsqyo")) != 2) {
            return false;
        }
        int aS = this.q.aS();
        if (aS != 8 && aS != 7) {
            return false;
        }
        this.F = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x() {
        /*
            r2 = this;
            com.bytedance.sdk.openadsdk.g.c r0 = r2.i
            if (r0 != 0) goto L_0x000d
            com.bytedance.sdk.openadsdk.core.model.q r0 = r2.q
            com.bytedance.sdk.openadsdk.g.a r0 = com.bytedance.sdk.openadsdk.g.a.a((com.bytedance.sdk.openadsdk.g.b) r2, (com.bytedance.sdk.openadsdk.core.model.q) r0)
            r2.i = r0
            goto L_0x0021
        L_0x000d:
            r0 = 95
            r1 = 95
        L_0x0011:
            switch(r0) {
                case 94: goto L_0x001e;
                case 95: goto L_0x0015;
                case 96: goto L_0x001a;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0021
        L_0x0015:
            switch(r1) {
                case 94: goto L_0x000d;
                case 95: goto L_0x0019;
                case 96: goto L_0x000d;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x001a
        L_0x0019:
            return
        L_0x001a:
            switch(r1) {
                case 55: goto L_0x000d;
                case 56: goto L_0x0021;
                case 57: goto L_0x000d;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x000d
        L_0x001e:
            r0 = 39
            goto L_0x000d
        L_0x0021:
            r0 = 94
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.x():void");
    }

    public r a() {
        return this.I;
    }

    public x a(int i2) {
        this.o = i2;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        switch(r1) {
            case 91: goto L_0x001c;
            case 92: goto L_0x0000;
            case 93: goto L_0x001c;
            default: goto L_0x001b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = kotlinx.serialization.json.internal.AbstractJsonLexerKt.BEGIN_LIST;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.x a(android.view.View r3) {
        /*
            r2 = this;
        L_0x0000:
            r0 = 93
            r1 = 93
        L_0x0004:
            switch(r0) {
                case 92: goto L_0x000c;
                case 93: goto L_0x0018;
                case 94: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0000
        L_0x0008:
            r0 = 4
            if (r1 > r0) goto L_0x0010
            goto L_0x0000
        L_0x000c:
            switch(r1) {
                case 21: goto L_0x0000;
                case 22: goto L_0x0010;
                case 23: goto L_0x001c;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0018
        L_0x0010:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.k = r0
            return r2
        L_0x0018:
            switch(r1) {
                case 91: goto L_0x001c;
                case 92: goto L_0x0000;
                case 93: goto L_0x001c;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0021
        L_0x001c:
            r0 = 94
            r1 = 75
            goto L_0x0004
        L_0x0021:
            r1 = 91
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.a(android.view.View):com.bytedance.sdk.openadsdk.core.x");
    }

    public x a(k kVar) {
        this.r = kVar;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        switch(r1) {
            case 52: goto L_0x0003;
            case 53: goto L_0x000d;
            case 54: goto L_0x0080;
            default: goto L_0x000c;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        switch(r0) {
            case 29: goto L_0x0080;
            case 30: goto L_0x0003;
            case 31: goto L_0x0009;
            default: goto L_0x0010;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r0 = 30;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.x a(com.bytedance.sdk.component.widget.SSWebView r4) {
        /*
            r3 = this;
            r0 = 55
            r1 = 0
        L_0x0003:
            r2 = 72
        L_0x0005:
            switch(r2) {
                case 72: goto L_0x0080;
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
                case 54: goto L_0x0080;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0013
        L_0x000d:
            switch(r0) {
                case 29: goto L_0x0080;
                case 30: goto L_0x0003;
                case 31: goto L_0x0009;
                default: goto L_0x0010;
            }
        L_0x0010:
            r0 = 30
            goto L_0x000d
        L_0x0013:
            android.webkit.WebView r0 = r4.getWebView()
            if (r0 != 0) goto L_0x001a
            return r3
        L_0x001a:
            android.webkit.WebView r0 = r4.getWebView()     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.component.a.j r0 = com.bytedance.sdk.component.a.r.a(r0)     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.openadsdk.h.a r1 = new com.bytedance.sdk.openadsdk.h.a     // Catch:{ Exception -> 0x007f }
            r1.<init>()     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.component.a.j r0 = r0.a((com.bytedance.sdk.component.a.a) r1)     // Catch:{ Exception -> 0x007f }
            java.lang.String r1 = "TnwwmdiM[Kxbhjk"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r1)     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.component.a.j r0 = r0.a((java.lang.String) r1)     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.openadsdk.core.x$1 r1 = new com.bytedance.sdk.openadsdk.core.x$1     // Catch:{ Exception -> 0x007f }
            r1.<init>()     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.component.a.j r0 = r0.a((com.bytedance.sdk.component.a.l) r1)     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.openadsdk.core.h r1 = com.bytedance.sdk.openadsdk.core.h.b()     // Catch:{ Exception -> 0x007f }
            boolean r1 = r1.q()     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.component.a.j r0 = r0.a((boolean) r1)     // Catch:{ Exception -> 0x007f }
            r1 = 1
            com.bytedance.sdk.component.a.j r0 = r0.b(r1)     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.component.a.j r0 = r0.a()     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.component.a.r r0 = r0.b()     // Catch:{ Exception -> 0x007f }
            r3.I = r0     // Catch:{ Exception -> 0x007f }
            com.bytedance.sdk.openadsdk.h.a.e.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.x) r3)
            com.bytedance.sdk.component.a.r r0 = r3.I
            com.bytedance.sdk.openadsdk.h.a.a.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.x) r3)
            com.bytedance.sdk.component.a.r r0 = r3.I
            com.bytedance.sdk.openadsdk.h.a.b.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.x) r3)
            com.bytedance.sdk.component.a.r r0 = r3.I
            com.bytedance.sdk.openadsdk.h.a.c.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.x) r3)
            com.bytedance.sdk.component.a.r r0 = r3.I
            com.bytedance.sdk.openadsdk.h.a.d.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.x) r3)
            com.bytedance.sdk.component.a.r r0 = r3.I
            com.bytedance.sdk.openadsdk.h.a.f.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.x) r3)
            com.bytedance.sdk.component.a.r r0 = r3.I
            com.bytedance.sdk.openadsdk.h.a.h.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.x) r3)
            com.bytedance.sdk.component.a.r r0 = r3.I
            com.bytedance.sdk.openadsdk.h.a.g.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.component.widget.SSWebView) r4)
        L_0x007f:
            return r3
        L_0x0080:
            r2 = 73
            r1 = 16
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.a(com.bytedance.sdk.component.widget.SSWebView):com.bytedance.sdk.openadsdk.core.x");
    }

    public x a(e eVar) {
        this.H = eVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.core.b.d dVar) {
        this.z = dVar;
        return this;
    }

    public x a(q qVar) {
        this.q = qVar;
        return this;
    }

    public x a(l lVar) {
        this.s = lVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.core.widget.a.a aVar) {
        this.L = aVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.core.widget.b bVar) {
        this.g = bVar;
        return this;
    }

    public x a(d dVar) {
        this.u = dVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.i.a aVar) {
        this.v = aVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.i.b bVar) {
        this.A = bVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.i.d dVar) {
        this.x = dVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.i.e eVar) {
        this.w = eVar;
        return this;
    }

    public x a(f fVar) {
        this.M = fVar;
        return this;
    }

    public x a(i iVar) {
        this.B = iVar;
        return this;
    }

    public x a(List<q> list) {
        this.D = list;
        return this;
    }

    public x a(Map<String, Object> map) {
        this.a = map;
        return this;
    }

    public x a(JSONObject jSONObject) {
        this.t = jSONObject;
        return this;
    }

    public x a(boolean z2) {
        this.b = z2;
        return this;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x041b, code lost:
        if (r4 != null) goto L_0x044f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x044d, code lost:
        if (r4 != null) goto L_0x044f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x044f, code lost:
        r3 = r4;
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject a(com.bytedance.sdk.openadsdk.core.x.b r23, int r24) throws java.lang.Exception {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.String r3 = "c`no"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r3)
            java.lang.String r4 = r1.a
            boolean r3 = r3.equals(r4)
            r4 = 0
            if (r3 != 0) goto L_0x0016
            return r4
        L_0x0016:
            com.bytedance.sdk.openadsdk.core.h r3 = com.bytedance.sdk.openadsdk.core.h.b()
            boolean r3 = r3.q()
            java.lang.String r5 = "TUCG*DhczfcoCodjse"
            if (r3 == 0) goto L_0x004c
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "[KQA)WCVU)|n~~g`~+"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = " lgwljb="
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            r6.append(r7)
            java.lang.String r7 = r1.c
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r3, r6)
        L_0x004c:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r6 = r1.c
            int r7 = r6.hashCode()
            r8 = 3
            java.lang.String r9 = "oqgmTwoqijs"
            r10 = 0
            r11 = -1
            r12 = 1
            switch(r7) {
                case -2036781162: goto L_0x0275;
                case -1423303823: goto L_0x0267;
                case -1330994877: goto L_0x0258;
                case -1169135450: goto L_0x0249;
                case -1023873614: goto L_0x023a;
                case -844321441: goto L_0x022a;
                case -800853518: goto L_0x021b;
                case -794273169: goto L_0x020c;
                case -715147645: goto L_0x01fd;
                case -511324706: goto L_0x01ef;
                case -489318846: goto L_0x01df;
                case -278382602: goto L_0x01cf;
                case -173752734: goto L_0x01c0;
                case 27837080: goto L_0x01b0;
                case 94756344: goto L_0x01a0;
                case 105049135: goto L_0x018f;
                case 399543522: goto L_0x017f;
                case 402955465: goto L_0x0170;
                case 425443791: goto L_0x0160;
                case 442647767: goto L_0x0150;
                case 571273292: goto L_0x0140;
                case 650209982: goto L_0x0131;
                case 672928467: goto L_0x0121;
                case 711635577: goto L_0x0111;
                case 885131792: goto L_0x0101;
                case 1107374321: goto L_0x00f1;
                case 1151744482: goto L_0x00e1;
                case 1237100796: goto L_0x00d1;
                case 1532142616: goto L_0x00c1;
                case 1634511418: goto L_0x00b1;
                case 1713585602: goto L_0x00a1;
                case 1731806400: goto L_0x0092;
                case 1979895452: goto L_0x0083;
                case 2086000188: goto L_0x0072;
                case 2105008900: goto L_0x0062;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x0285
        L_0x0062:
            java.lang.String r7 = "l`lgwfgwmVigene"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 16
            goto L_0x0286
        L_0x0072:
            java.lang.String r7 = "sjksRlbbg"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 20
            goto L_0x0286
        L_0x0083:
            java.lang.String r7 = "sdlgHja"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 2
            goto L_0x0286
        L_0x0092:
            java.lang.String r7 = "pmczegjbWz~r`h"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 3
            goto L_0x0286
        L_0x00a1:
            java.lang.String r7 = "gdvMaqqhzbNjxl"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 26
            goto L_0x0286
        L_0x00b1:
            java.lang.String r7 = "eof`ewbXdfko"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 27
            goto L_0x0286
        L_0x00c1:
            java.lang.String r7 = "rdolr`Jhimcek"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 10
            goto L_0x0286
        L_0x00d1:
            java.lang.String r7 = "rdlgawBnlOcee~f"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 18
            goto L_0x0286
        L_0x00e1:
            java.lang.String r7 = "mtvfRlbbg"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 21
            goto L_0x0286
        L_0x00f1:
            java.lang.String r7 = "p`wpaRce^`o|Xdcjbb"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 29
            goto L_0x0286
        L_0x0101:
            java.lang.String r7 = "gdvUkisjm"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 9
            goto L_0x0286
        L_0x0111:
            java.lang.String r7 = "gdv@qwtbf}\\bhha\\dpfv"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 23
            goto L_0x0286
        L_0x0121:
            java.lang.String r7 = "c`l`aiYcg~dgcljPqabLuq"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 14
            goto L_0x0286
        L_0x0131:
            java.lang.String r7 = "gdvWahvki}oBbka"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 4
            goto L_0x0286
        L_0x0140:
            java.lang.String r7 = "dxlbileSzhi`"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 19
            goto L_0x0286
        L_0x0150:
            java.lang.String r7 = "sdlgV`qfzm"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 11
            goto L_0x0286
        L_0x0160:
            java.lang.String r7 = "gdvMeqoqmZciN{|d~Wuaw"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 33
            goto L_0x0286
        L_0x0170:
            java.lang.String r7 = "irTjargedl"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 6
            goto L_0x0286
        L_0x017f:
            java.lang.String r7 = "gdv@hjubJ|~ccGav~"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 8
            goto L_0x0286
        L_0x018f:
            java.lang.String r7 = "uoqvfveuakoTm}~Pqu"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 15
            goto L_0x0286
        L_0x01a0:
            java.lang.String r7 = "cmmpa"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 34
            goto L_0x0286
        L_0x01b0:
            java.lang.String r7 = "dnumhjgcWhz{Slj"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 13
            goto L_0x0286
        L_0x01c0:
            java.lang.String r7 = "gdvWaHgnImy"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 5
            goto L_0x0286
        L_0x01cf:
            java.lang.String r7 = "sdlg[qcji`U{~bjzseMzpf"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 24
            goto L_0x0286
        L_0x01df:
            java.lang.String r7 = "gdvNeqcuahfFiyo"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 25
            goto L_0x0286
        L_0x01ef:
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r9)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 31
            goto L_0x0286
        L_0x01fd:
            java.lang.String r7 = "gdvPgwcbfZcqi"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 7
            goto L_0x0286
        L_0x020c:
            java.lang.String r7 = "aqrJjci"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 0
            goto L_0x0286
        L_0x021b:
            java.lang.String r7 = "cmk`o@pbf}"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 17
            goto L_0x0286
        L_0x022a:
            java.lang.String r7 = "wd`um`qX|`gnSy|nsz"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 30
            goto L_0x0286
        L_0x023a:
            java.lang.String r7 = "oqgmEaJffmZjkhBf~za"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 32
            goto L_0x0286
        L_0x0249:
            java.lang.String r7 = "cicmc`PnlleXxlzj"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 22
            goto L_0x0286
        L_0x0258:
            java.lang.String r7 = "p`wpaRce^`o|"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 28
            goto L_0x0286
        L_0x0267:
            java.lang.String r7 = "aeKmbj"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 1
            goto L_0x0286
        L_0x0275:
            java.lang.String r7 = "st`pgwoemVk{|Rok"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r7)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0285
            r6 = 12
            goto L_0x0286
        L_0x0285:
            r6 = -1
        L_0x0286:
            switch(r6) {
                case 0: goto L_0x0517;
                case 1: goto L_0x0513;
                case 2: goto L_0x0481;
                case 3: goto L_0x047c;
                case 4: goto L_0x0452;
                case 5: goto L_0x044b;
                case 6: goto L_0x0441;
                case 7: goto L_0x041e;
                case 8: goto L_0x0417;
                case 9: goto L_0x03d7;
                case 10: goto L_0x03ce;
                case 11: goto L_0x03c3;
                case 12: goto L_0x0397;
                case 13: goto L_0x0368;
                case 14: goto L_0x035d;
                case 15: goto L_0x0352;
                case 16: goto L_0x0345;
                case 17: goto L_0x033e;
                case 18: goto L_0x0337;
                case 19: goto L_0x0330;
                case 20: goto L_0x032b;
                case 21: goto L_0x0324;
                case 22: goto L_0x031d;
                case 23: goto L_0x0318;
                case 24: goto L_0x0311;
                case 25: goto L_0x030c;
                case 26: goto L_0x0307;
                case 27: goto L_0x0300;
                case 28: goto L_0x02fb;
                case 29: goto L_0x02f6;
                case 30: goto L_0x02ef;
                case 31: goto L_0x02df;
                case 32: goto L_0x02cb;
                case 33: goto L_0x029d;
                case 34: goto L_0x028b;
                default: goto L_0x0289;
            }
        L_0x0289:
            goto L_0x051c
        L_0x028b:
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r5)
            java.lang.String r6 = "MDVKKAYDDFYN"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r6)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r6)
            r22.f()
            goto L_0x051c
        L_0x029d:
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r5)
            java.lang.String r6 = "MDVKKAY@M]UEMYGYUNAZ@PITMJNTQBZ^t`"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r6)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r6)
            com.bytedance.sdk.openadsdk.core.model.q r4 = r0.q
            if (r4 == 0) goto L_0x051c
            java.lang.String r4 = r4.F()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x051c
            java.lang.String r4 = "d`vb"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r4)
            com.bytedance.sdk.openadsdk.core.model.q r6 = r0.q
            java.lang.String r6 = r6.F()
            r3.put(r4, r6)
            goto L_0x051c
        L_0x02cb:
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r5)
            java.lang.String r6 = "MDVKKAYHXLDTC]KAOPVLXTXSHX]^CQWQkr"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r6)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r6)
            org.json.JSONObject r4 = r1.d
            r0.b((org.json.JSONObject) r4)
            goto L_0x051c
        L_0x02df:
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r5)
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r9)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r6)
            r22.u()
            goto L_0x051c
        L_0x02ef:
            org.json.JSONObject r4 = r1.d
            r0.g((org.json.JSONObject) r4)
            goto L_0x051c
        L_0x02f6:
            r22.s()
            goto L_0x051c
        L_0x02fb:
            r22.r()
            goto L_0x051c
        L_0x0300:
            org.json.JSONObject r4 = r1.d
            r0.h((org.json.JSONObject) r4)
            goto L_0x051c
        L_0x0307:
            r0.a((com.bytedance.sdk.openadsdk.core.x.b) r1, (org.json.JSONObject) r3)
            goto L_0x051c
        L_0x030c:
            r0.p(r3)
            goto L_0x051c
        L_0x0311:
            org.json.JSONObject r4 = r1.d
            r0.o(r4)
            goto L_0x051c
        L_0x0318:
            r0.k((org.json.JSONObject) r3)
            goto L_0x051c
        L_0x031d:
            org.json.JSONObject r4 = r1.d
            r0.j((org.json.JSONObject) r4)
            goto L_0x051c
        L_0x0324:
            org.json.JSONObject r4 = r1.d
            r0.i((org.json.JSONObject) r4)
            goto L_0x051c
        L_0x032b:
            r22.t()
            goto L_0x051c
        L_0x0330:
            org.json.JSONObject r4 = r1.d
            r0.n(r4)
            goto L_0x051c
        L_0x0337:
            org.json.JSONObject r4 = r1.d
            r0.l(r4)
            goto L_0x051c
        L_0x033e:
            org.json.JSONObject r4 = r1.d
            r0.c((org.json.JSONObject) r4)
            goto L_0x051c
        L_0x0345:
            android.content.Context r4 = r0.P
            boolean r6 = r4 instanceof com.bytedance.sdk.openadsdk.core.video.c.b
            if (r6 == 0) goto L_0x051c
            com.bytedance.sdk.openadsdk.core.video.c.b r4 = (com.bytedance.sdk.openadsdk.core.video.c.b) r4
            r4.r()
            goto L_0x051c
        L_0x0352:
            com.bytedance.sdk.openadsdk.g.c r4 = r0.i
            if (r4 == 0) goto L_0x051c
            org.json.JSONObject r6 = r1.d
            r4.a(r6)
            goto L_0x051c
        L_0x035d:
            com.bytedance.sdk.openadsdk.g.c r4 = r0.i
            if (r4 == 0) goto L_0x051c
            org.json.JSONObject r6 = r1.d
            r4.b(r6)
            goto L_0x051c
        L_0x0368:
            r0.K = r12
            com.bytedance.sdk.openadsdk.core.model.q r6 = r0.q
            java.lang.String r7 = r0.J
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r6, (java.lang.String) r7, (int) r12, (org.json.JSONObject) r4)
            com.bytedance.sdk.openadsdk.core.b.d r6 = r0.z
            if (r6 == 0) goto L_0x037c
            boolean r4 = r0.C
            r6.a(r4)
            goto L_0x051c
        L_0x037c:
            com.bytedance.sdk.openadsdk.g.c r6 = r0.i
            if (r6 == 0) goto L_0x038d
            android.content.Context r7 = r0.P
            if (r7 == 0) goto L_0x038d
            org.json.JSONObject r4 = r1.d
            java.lang.String r8 = r0.J
            r6.a(r7, r4, r8)
            goto L_0x051c
        L_0x038d:
            com.bytedance.sdk.openadsdk.core.model.q r6 = r0.q
            java.lang.String r7 = r0.J
            r8 = -2
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r6, (java.lang.String) r7, (int) r8, (org.json.JSONObject) r4)
            goto L_0x051c
        L_0x0397:
            r22.x()
            com.bytedance.sdk.openadsdk.core.model.q r6 = r0.q
            java.lang.String r7 = r0.J
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r6, (java.lang.String) r7, (int) r10, (org.json.JSONObject) r4)
            android.content.Context r14 = r0.P
            if (r14 == 0) goto L_0x03ba
            com.bytedance.sdk.openadsdk.g.c r13 = r0.i
            org.json.JSONObject r15 = r1.d
            java.lang.String r4 = r0.l
            int r6 = r0.m
            boolean r7 = r0.p
            r16 = r4
            r17 = r6
            r18 = r7
            r13.a(r14, r15, r16, r17, r18)
            goto L_0x051c
        L_0x03ba:
            com.bytedance.sdk.openadsdk.core.model.q r6 = r0.q
            java.lang.String r7 = r0.J
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r6, (java.lang.String) r7, (int) r11, (org.json.JSONObject) r4)
            goto L_0x051c
        L_0x03c3:
            r0.c = r12
            com.bytedance.sdk.openadsdk.i.e r4 = r0.w
            if (r4 == 0) goto L_0x051c
            r4.a()
            goto L_0x051c
        L_0x03ce:
            com.bytedance.sdk.openadsdk.i.d r4 = r0.x
            if (r4 == 0) goto L_0x051c
            r4.a()
            goto L_0x051c
        L_0x03d7:
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.o.a()
            java.lang.String r6 = "atfjk"
            java.lang.String r6 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r6)
            java.lang.Object r4 = r4.getSystemService(r6)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L_0x0409
            int r11 = r4.getStreamVolume(r8)
            java.lang.String r4 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Mtqjg%phd|gn,301.1Sfp|yZyw{|yo32\u001eBWQV@HS~FF^AH\u0013"
            java.lang.String r7 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r7)
            r6.append(r7)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r6)
        L_0x0409:
            if (r11 > 0) goto L_0x040c
            r10 = 1
        L_0x040c:
            java.lang.String r4 = "eof`ewbXe|~n"
            java.lang.String r4 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r4)
            r3.put(r4, r10)
            goto L_0x051c
        L_0x0417:
            org.json.JSONObject r4 = r22.p()
            if (r4 == 0) goto L_0x051c
            goto L_0x044f
        L_0x041e:
            com.bytedance.sdk.openadsdk.i.a r4 = r0.v
            if (r4 == 0) goto L_0x051c
            int r4 = r4.b()
            com.bytedance.sdk.openadsdk.i.a r6 = r0.v
            int r6 = r6.a()
            java.lang.String r7 = "whfwl"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            r3.put(r7, r4)
            java.lang.String r4 = "hdkdlq"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r4)
        L_0x043c:
            r3.put(r4, r6)
            goto L_0x051c
        L_0x0441:
            java.lang.String r4 = "vhgtWqgs}z"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r4)
            boolean r6 = r0.G
            goto L_0x043c
        L_0x044b:
            org.json.JSONObject r4 = r0.y
            if (r4 == 0) goto L_0x051c
        L_0x044f:
            r3 = r4
            goto L_0x051c
        L_0x0452:
            org.json.JSONObject r3 = r0.t
            if (r3 == 0) goto L_0x0478
            java.lang.String r4 = "sdvwmka"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r4)
            org.json.JSONObject r6 = r22.v()
            r3.put(r4, r6)
            com.bytedance.sdk.openadsdk.core.model.q r3 = r0.q
            if (r3 == 0) goto L_0x0478
            org.json.JSONObject r3 = r0.t
            java.lang.String r4 = "eyvfjvohf"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r4)
            com.bytedance.sdk.openadsdk.core.model.q r6 = r0.q
            org.json.JSONObject r6 = r6.ay()
            r3.put(r4, r6)
        L_0x0478:
            org.json.JSONObject r3 = r0.t
            goto L_0x051c
        L_0x047c:
            r0.f((org.json.JSONObject) r3)
            goto L_0x051c
        L_0x0481:
            org.json.JSONObject r4 = r1.d
            if (r4 == 0) goto L_0x051c
            java.lang.String r6 = "eyvIwjh"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r6)
            org.json.JSONObject r6 = r4.getJSONObject(r6)
            if (r6 == 0) goto L_0x051c
            java.lang.String r7 = "c`vfcjt~"
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            boolean r8 = r6.has(r8)
            if (r8 == 0) goto L_0x051c
            java.lang.String r8 = "t`e"
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r8)
            boolean r9 = r6.has(r9)
            if (r9 == 0) goto L_0x051c
            java.lang.String r9 = "l``fh"
            java.lang.String r10 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r9)
            boolean r10 = r6.has(r10)
            if (r10 == 0) goto L_0x051c
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r7)
            java.lang.String r14 = r6.getString(r7)
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r8)
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r9)
            java.lang.String r8 = r6.getString(r8)
            java.lang.String r9 = "v`nva"
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r9)
            long r17 = r4.getLong(r9)
            java.lang.String r9 = "eyvUeisb"
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r9)
            long r19 = r4.getLong(r9)
            java.lang.String r4 = "u`]skiodq"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r4)     // Catch:{ Exception -> 0x04f4 }
            int r9 = r0.o     // Catch:{ Exception -> 0x04f4 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x04f4 }
            r6.putOpt(r4, r9)     // Catch:{ Exception -> 0x04f4 }
            goto L_0x04f5
        L_0x04f4:
        L_0x04f5:
            java.lang.String r4 = "cmk`o"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r4)
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0505
            org.json.JSONObject r6 = r0.r(r6)
        L_0x0505:
            r21 = r6
            java.lang.String r15 = r0.j((java.lang.String) r7)
            com.bytedance.sdk.openadsdk.core.model.q r13 = r0.q
            r16 = r8
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (long) r17, (long) r19, (org.json.JSONObject) r21)
            goto L_0x051c
        L_0x0513:
            r0.e((org.json.JSONObject) r3)
            goto L_0x051c
        L_0x0517:
            int r4 = r1.e
            r0.a((org.json.JSONObject) r3, (int) r4)
        L_0x051c:
            if (r2 != r12) goto L_0x055f
            java.lang.String r4 = r1.b
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x055f
            java.lang.String r1 = r1.b
            r0.b((java.lang.String) r1, (org.json.JSONObject) r3)
            com.bytedance.sdk.openadsdk.core.h r1 = com.bytedance.sdk.openadsdk.core.h.b()
            boolean r1 = r1.q()
            if (r1 == 0) goto L_0x055f
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r5)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "[KQA)WUWU)|n~~g`~+"
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r5)
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " ecwe8"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r2)
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            android.util.Log.d(r1, r2)
        L_0x055f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.a(com.bytedance.sdk.openadsdk.core.x$b, int):org.json.JSONObject");
    }

    public void a(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof b)) {
            try {
                a((b) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    public void a(a aVar) {
        this.Q = aVar;
    }

    public void a(String str) {
    }

    public void a(String str, JSONObject jSONObject) {
        c(str, jSONObject);
    }

    @JProtect
    public void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.i.c cVar) {
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                return;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        break;
                }
                c3 = AbstractJsonLexerKt.END_LIST;
                c2 = AbstractJsonLexerKt.END_LIST;
            }
            while (true) {
                switch (c3) {
                    case '[':
                    case '\\':
                    case ']':
                        return;
                    default:
                        c3 = AbstractJsonLexerKt.BEGIN_LIST;
                }
            }
        }
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!com.bytedance.sdk.component.f.c.d.d1699434667873dc("bxvf`dhdm").equals(uri.getScheme())) {
                return false;
            }
            return h.containsKey(uri.getHost());
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            e(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public x b(int i2) {
        this.m = i2;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        switch(r1) {
            case 91: goto L_0x001c;
            case 92: goto L_0x0000;
            case 93: goto L_0x001c;
            default: goto L_0x001b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = kotlinx.serialization.json.internal.AbstractJsonLexerKt.BEGIN_LIST;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.x b(com.bytedance.sdk.component.widget.SSWebView r3) {
        /*
            r2 = this;
        L_0x0000:
            r0 = 93
            r1 = 93
        L_0x0004:
            switch(r0) {
                case 92: goto L_0x000c;
                case 93: goto L_0x0018;
                case 94: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0000
        L_0x0008:
            r0 = 4
            if (r1 > r0) goto L_0x0010
            goto L_0x0000
        L_0x000c:
            switch(r1) {
                case 21: goto L_0x0000;
                case 22: goto L_0x0010;
                case 23: goto L_0x001c;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0018
        L_0x0010:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.d = r0
            return r2
        L_0x0018:
            switch(r1) {
                case 91: goto L_0x001c;
                case 92: goto L_0x0000;
                case 93: goto L_0x001c;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0021
        L_0x001c:
            r0 = 94
            r1 = 75
            goto L_0x0004
        L_0x0021:
            r1 = 91
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.b(com.bytedance.sdk.component.widget.SSWebView):com.bytedance.sdk.openadsdk.core.x");
    }

    public x b(boolean z2) {
        this.G = z2;
        return this;
    }

    public void b() {
        r rVar = this.I;
        if (rVar != null) {
            rVar.a();
            this.I = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007a, code lost:
        switch(r1) {
            case 94: goto L_0x0083;
            case 95: goto L_0x0083;
            case 96: goto L_0x007e;
            default: goto L_0x007d;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        if (r5 == ')') goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        r1 = '_';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(final android.net.Uri r5) {
        /*
            r4 = this;
            java.lang.String r0 = "TUCG*DhczfcoCodjse"
            java.lang.String r1 = r5.getHost()     // Catch:{ Exception -> 0x008d }
            java.lang.String r2 = "lne\\asci|"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r2)     // Catch:{ Exception -> 0x008d }
            boolean r2 = r2.equals(r1)     // Catch:{ Exception -> 0x008d }
            r3 = 95
            if (r2 != 0) goto L_0x005c
            java.lang.String r2 = "ctqwkhYb~ld"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r2)     // Catch:{ Exception -> 0x008d }
            boolean r2 = r2.equals(r1)     // Catch:{ Exception -> 0x008d }
            if (r2 != 0) goto L_0x005c
            java.lang.String r2 = "lne\\asci|V|8"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r2)     // Catch:{ Exception -> 0x008d }
            boolean r2 = r2.equals(r1)     // Catch:{ Exception -> 0x008d }
            if (r2 == 0) goto L_0x002d
            goto L_0x005c
        L_0x002d:
            java.lang.String r2 = "pskueqc"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r2)     // Catch:{ Exception -> 0x008d }
            boolean r2 = r2.equals(r1)     // Catch:{ Exception -> 0x008d }
            if (r2 != 0) goto L_0x0054
            java.lang.String r2 = "dhqseqeoWdoxlij"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r2)     // Catch:{ Exception -> 0x008d }
            boolean r1 = r2.equals(r1)     // Catch:{ Exception -> 0x008d }
            if (r1 == 0) goto L_0x0046
            goto L_0x0054
        L_0x0046:
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r0)     // Catch:{ Exception -> 0x008d }
            java.lang.String r1 = "h`lghwSnz3*ecy.bqeq{4fu}t{;trmk"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r1)     // Catch:{ Exception -> 0x008d }
            com.bytedance.sdk.component.utils.l.d((java.lang.String) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x008d }
            goto L_0x009b
        L_0x0054:
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x008d }
            r4.k((java.lang.String) r5)     // Catch:{ Exception -> 0x008d }
            goto L_0x0083
        L_0x005c:
            com.bytedance.sdk.openadsdk.core.x$9 r1 = new com.bytedance.sdk.openadsdk.core.x$9     // Catch:{ Exception -> 0x008d }
            java.lang.String r2 = "lne\\asci|VbjbibjEc{"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r2)     // Catch:{ Exception -> 0x008d }
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x008d }
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.component.g.h) r1)     // Catch:{ Exception -> 0x008d }
            r5 = 95
        L_0x006c:
            r0 = 84
            r1 = 83
        L_0x0070:
            switch(r0) {
                case 84: goto L_0x0074;
                case 85: goto L_0x007a;
                case 86: goto L_0x006c;
                default: goto L_0x0073;
            }
        L_0x0073:
            goto L_0x006c
        L_0x0074:
            switch(r1) {
                case 82: goto L_0x009b;
                case 83: goto L_0x009b;
                case 84: goto L_0x0078;
                default: goto L_0x0077;
            }
        L_0x0077:
            goto L_0x007a
        L_0x0078:
            goto L_0x0078
        L_0x007a:
            switch(r1) {
                case 94: goto L_0x0083;
                case 95: goto L_0x0083;
                case 96: goto L_0x007e;
                default: goto L_0x007d;
            }
        L_0x007d:
            goto L_0x008a
        L_0x007e:
            r0 = 41
            if (r5 == r0) goto L_0x007e
            goto L_0x009b
        L_0x0083:
            r0 = 85
            r1 = 96
            r5 = 40
            goto L_0x0070
        L_0x008a:
            r1 = 95
            goto L_0x007a
        L_0x008d:
            r5 = move-exception
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r0)
            java.lang.String r1 = "h`lgh`Sua)osoh~{y~|)4"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r1)
            com.bytedance.sdk.component.utils.l.b(r0, r1, r5)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.b(android.net.Uri):void");
    }

    public void b(String str) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(org.json.JSONObject r11) {
        /*
            r10 = this;
            java.lang.String r0 = "l`lgmkaT|pfn"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r0)
            int r0 = r11.optInt(r0)
            java.lang.String r1 = "usn"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)
            java.lang.String r3 = r11.optString(r1)
            java.lang.String r1 = "f`nofdelW|xg"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)
            java.lang.String r1 = r11.optString(r1)
            android.content.Context r2 = r10.P
            boolean r2 = r2 instanceof android.app.Activity
            java.lang.String r4 = "ir]bgqoqa}s"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r4)     // Catch:{ JSONException -> 0x002d }
            r11.put(r4, r2)     // Catch:{ JSONException -> 0x002d }
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            com.bytedance.sdk.openadsdk.core.model.q r4 = r10.q
            java.lang.String r5 = r10.J
            r8 = 1
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r4, (java.lang.String) r5, (int) r8, (org.json.JSONObject) r11)
            r11 = r3
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x0040
            return
        L_0x0040:
            r11 = 2
            r9 = 0
            if (r0 != 0) goto L_0x005e
            android.webkit.WebView r0 = r10.o()
            if (r0 == 0) goto L_0x0055
            r0.loadUrl(r3)
        L_0x004d:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r10.q
            java.lang.String r1 = r10.J
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r0, (java.lang.String) r1, (int) r11, (org.json.JSONObject) r9)
            goto L_0x00a8
        L_0x0055:
            com.bytedance.sdk.openadsdk.core.model.q r11 = r10.q
            java.lang.String r0 = r10.J
            r1 = -1
        L_0x005a:
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r11, (java.lang.String) r0, (int) r1, (org.json.JSONObject) r9)
            goto L_0x00a8
        L_0x005e:
            if (r0 != r8) goto L_0x006e
            if (r2 == 0) goto L_0x00a8
            android.content.Context r11 = r10.P
            android.app.Activity r11 = (android.app.Activity) r11
            com.bytedance.sdk.openadsdk.core.model.q r0 = r10.q
            java.lang.String r1 = r10.J
            com.bytedance.sdk.openadsdk.utils.p.a(r11, r3, r0, r1)
            goto L_0x00a8
        L_0x006e:
            if (r0 != r11) goto L_0x008c
            if (r2 == 0) goto L_0x00a8
            android.content.Context r11 = r10.P
            android.app.Activity r11 = (android.app.Activity) r11
            com.bytedance.sdk.openadsdk.core.model.q r0 = r10.q
            java.lang.String r2 = r10.J
            boolean r11 = com.bytedance.sdk.openadsdk.utils.p.b(r11, r3, r0, r2)
            if (r11 != 0) goto L_0x00a8
            android.content.Context r11 = r10.P
            android.app.Activity r11 = (android.app.Activity) r11
            com.bytedance.sdk.openadsdk.core.model.q r0 = r10.q
            java.lang.String r2 = r10.J
            com.bytedance.sdk.openadsdk.utils.p.a(r11, r1, r0, r2)
            goto L_0x00a8
        L_0x008c:
            r11 = 3
            if (r0 != r11) goto L_0x00a7
            if (r2 == 0) goto L_0x00a8
            android.content.Context r2 = r10.P
            com.bytedance.sdk.openadsdk.core.model.q r4 = r10.q
            int r5 = r10.m
            java.lang.String r6 = r10.J
            r7 = 0
            boolean r0 = com.bytedance.sdk.openadsdk.core.z.b(r2, r3, r4, r5, r6, r7)
            if (r0 == 0) goto L_0x00a1
            goto L_0x004d
        L_0x00a1:
            com.bytedance.sdk.openadsdk.core.model.q r11 = r10.q
            java.lang.String r0 = r10.J
            r1 = -2
            goto L_0x005a
        L_0x00a7:
            r8 = 0
        L_0x00a8:
            com.bytedance.sdk.openadsdk.core.widget.b r11 = r10.g
            if (r11 == 0) goto L_0x00b1
            if (r8 == 0) goto L_0x00b1
            r11.a()
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.b(org.json.JSONObject):void");
    }

    public q c() {
        return this.q;
    }

    public x c(String str) {
        this.f = str;
        return this;
    }

    public x c(boolean z2) {
        this.C = z2;
        return this;
    }

    public void c(int i2) {
        l lVar = this.s;
        if (lVar != null) {
            lVar.b(i2);
        }
    }

    public void c(JSONObject jSONObject) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        String str;
        double d8;
        double d9;
        JSONObject jSONObject2;
        double d10;
        JSONObject jSONObject3 = jSONObject;
        if (jSONObject3 != null) {
            com.bytedance.sdk.component.utils.l.b(com.bytedance.sdk.component.f.c.d.d1699434667873dc("TUCG*DhczfcoCodjse"), com.bytedance.sdk.component.f.c.d.d1699434667873dc("TUCm`winlFhainz/xp|wxpU{qzq^jxpk"));
            try {
                String optString = jSONObject3.optString(com.bytedance.sdk.component.f.c.d.d1699434667873dc("aeKg"));
                int optInt = jSONObject3.optInt(com.bytedance.sdk.component.f.c.d.d1699434667873dc("asgbP|vb"), 1);
                String optString2 = jSONObject3.optString(com.bytedance.sdk.component.f.c.d.d1699434667873dc("cmk`oDtbi]s{i"));
                JSONObject optJSONObject = jSONObject3.optJSONObject(com.bytedance.sdk.component.f.c.d.d1699434667873dc("cmk`oLhag"));
                double d11 = 0.0d;
                if (optJSONObject != null) {
                    double optDouble = optJSONObject.optDouble(c.a.c$a1699434667851dc("dnum[}"), 0.0d);
                    d8 = optJSONObject.optDouble(c.a.c$a1699434667851dc("dnum[|"), 0.0d);
                    double optDouble2 = optJSONObject.optDouble(c.a.c$a1699434667851dc("uq]{"), 0.0d);
                    double optDouble3 = optJSONObject.optDouble(c.a.c$a1699434667851dc("uq]z"), 0.0d);
                    double optDouble4 = optJSONObject.optDouble(c.a.c$a1699434667851dc("dnum[qojm"), 0.0d);
                    double optDouble5 = optJSONObject.optDouble(c.a.c$a1699434667851dc("uq]wmhc"), 0.0d);
                    double optDouble6 = optJSONObject.optDouble(c.a.c$a1699434667851dc("btvwkkY"), 0.0d);
                    double optDouble7 = optJSONObject.optDouble(c.a.c$a1699434667851dc("btvwkkY~"), 0.0d);
                    double optDouble8 = optJSONObject.optDouble(c.a.c$a1699434667851dc("btvwkkYpam~c"), 0.0d);
                    double optDouble9 = optJSONObject.optDouble(c.a.c$a1699434667851dc("btvwkkYom`mcx"), 0.0d);
                    jSONObject2 = optJSONObject.optJSONObject(c.a.c$a1699434667851dc("rdawMk`h"));
                    d2 = optDouble9;
                    d11 = optDouble;
                    d9 = optDouble2;
                    d7 = optDouble4;
                    d6 = optDouble5;
                    d5 = optDouble6;
                    d4 = optDouble7;
                    d3 = optDouble8;
                    str = optString;
                    d10 = optDouble3;
                } else {
                    str = optString;
                    d10 = 0.0d;
                    d9 = 0.0d;
                    d8 = 0.0d;
                    d7 = 0.0d;
                    d6 = 0.0d;
                    d5 = 0.0d;
                    d4 = 0.0d;
                    d3 = 0.0d;
                    d2 = 0.0d;
                    jSONObject2 = null;
                }
                m a2 = new m.a().d((float) d11).c((float) d8).b((float) d9).a((float) d10).b((long) d7).a((long) d6).c((int) d5).d((int) d4).e((int) d3).f((int) d2).a(optString2).a((SparseArray<c.a>) null).a(true).b(optInt).a(jSONObject2).a(jSONObject3.optInt(c.a.c$a1699434667851dc("cmk`oDtbiJkija}i"), -1)).a();
                k kVar = this.r;
                if (kVar != null) {
                    kVar.a((View) null, optInt, a2);
                }
                a(str, optInt, a2);
                while (true) {
                    char c2 = 8;
                    while (true) {
                        if (c2 == 7) {
                            return;
                        }
                        if (c2 == 8 || c2 != 9) {
                            c2 = 7;
                        }
                    }
                }
            } catch (Exception unused) {
                k kVar2 = this.r;
                if (kVar2 != null) {
                    kVar2.a((View) null, -1, (com.bytedance.sdk.component.adexpress.c) null);
                }
            }
        }
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            aa.a((Runnable) new Runnable() {
                public void run() {
                    x.this.j(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void chooseAdResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(c.a.c$a1699434667851dc("vhffkZeogfyn"));
            long optLong = jSONObject.optLong(c.a.c$a1699434667851dc("vhffkZeogfynSi{}qe{|z"));
            f fVar = this.M;
            if (fVar != null) {
                fVar.a(optInt, optLong);
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            aa.a((Runnable) new Runnable() {
                public void run() {
                    x.this.c(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    public x d(String str) {
        this.j = str;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
        switch(r0) {
            case 52: goto L_0x0027;
            case 53: goto L_0x0031;
            case 54: goto L_0x003c;
            default: goto L_0x0030;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0031, code lost:
        switch(r5) {
            case 29: goto L_0x0041;
            case 30: goto L_0x0027;
            case 31: goto L_0x002d;
            default: goto L_0x0034;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
        r5 = 30;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(org.json.JSONObject r5) {
        /*
            r4 = this;
            com.bytedance.sdk.openadsdk.core.model.q r5 = com.bytedance.sdk.openadsdk.core.b.a((org.json.JSONObject) r5)
            if (r5 == 0) goto L_0x0041
            com.bytedance.sdk.openadsdk.core.b.a r0 = new com.bytedance.sdk.openadsdk.core.b.a
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.o.a()
            java.lang.String r2 = r4.J
            int r3 = r4.m
            r0.<init>(r1, r5, r2, r3)
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.o.a()
            java.lang.String r2 = r4.J
            com.com.bytedance.overseas.sdk.a.c r5 = com.com.bytedance.overseas.sdk.a.d.a(r1, r5, r2)
            r0.a((com.com.bytedance.overseas.sdk.a.c) r5)
            r5 = 0
            r0.onClick(r5)
            r5 = 55
            r0 = 0
        L_0x0027:
            r1 = 72
        L_0x0029:
            switch(r1) {
                case 72: goto L_0x003c;
                case 73: goto L_0x0037;
                case 74: goto L_0x002d;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x0027
        L_0x002d:
            switch(r0) {
                case 52: goto L_0x0027;
                case 53: goto L_0x0031;
                case 54: goto L_0x003c;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x003c
        L_0x0031:
            switch(r5) {
                case 29: goto L_0x0041;
                case 30: goto L_0x0027;
                case 31: goto L_0x002d;
                default: goto L_0x0034;
            }
        L_0x0034:
            r5 = 30
            goto L_0x0031
        L_0x0037:
            r1 = 57
            if (r0 > r1) goto L_0x003c
            goto L_0x0041
        L_0x003c:
            r1 = 73
            r0 = 16
            goto L_0x0029
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.d(org.json.JSONObject):void");
    }

    public void d(boolean z2) {
        this.c = z2;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023 A[LOOP:0: B:5:0x000e->B:12:0x0023, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x000a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0012 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0015 A[SYNTHETIC] */
    public boolean d() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.core.model.q r0 = r3.q
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.v()
            goto L_0x0019
        L_0x0009:
            r0 = 0
        L_0x000a:
            r1 = 74
            r2 = 55
        L_0x000e:
            switch(r1) {
                case 72: goto L_0x000a;
                case 73: goto L_0x0012;
                case 74: goto L_0x0015;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0023
        L_0x0012:
            switch(r2) {
                case 94: goto L_0x001e;
                case 95: goto L_0x000a;
                case 96: goto L_0x000a;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r2) {
                case 55: goto L_0x001d;
                case 56: goto L_0x0019;
                case 57: goto L_0x000a;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x001e
        L_0x0019:
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x001e
        L_0x001d:
            return r0
        L_0x001e:
            r1 = 73
            r2 = 96
            goto L_0x000e
        L_0x0023:
            r1 = 72
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.d():boolean");
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            n(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public x e(String str) {
        this.l = str;
        return this;
    }

    public void e(boolean z2) {
        this.N = z2;
    }

    public boolean e() {
        boolean z2 = this.c;
        while (true) {
            char c2 = AbstractJsonLexerKt.END_LIST;
            char c3 = AbstractJsonLexerKt.END_LIST;
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        if (c3 > 4) {
                            break;
                        } else {
                            continue;
                        }
                }
                while (true) {
                    switch (c3) {
                        case '[':
                        case ']':
                            break;
                        case '\\':
                            break;
                        default:
                            c3 = AbstractJsonLexerKt.BEGIN_LIST;
                    }
                }
                c2 = '^';
                c3 = 'K';
            }
        }
        return z2;
    }

    public x f(String str) {
        this.n = str;
        return this;
    }

    public void f() {
        com.bytedance.sdk.openadsdk.i.b bVar;
        if (!this.O || (bVar = this.A) == null) {
            Context context = this.P;
            if ((context instanceof Activity) && com.bytedance.sdk.openadsdk.utils.p.a((Activity) context)) {
                ((Activity) this.P).finish();
                return;
            }
            return;
        }
        bVar.a();
    }

    public void f(boolean z2) {
        this.O = z2;
    }

    public void g() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.b();
            char c2 = AbstractJsonLexerKt.STRING_ESC;
            while (true) {
                char c3 = 14;
                while (true) {
                    switch (c3) {
                        case 13:
                            break;
                        case 14:
                            break;
                        case 15:
                            switch (c2) {
                                case '_':
                                    return;
                            }
                    }
                    c3 = 15;
                    c2 = '_';
                }
            }
        }
    }

    public void g(String str) {
        this.J = str;
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        k(jSONObject);
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        a(p.p1699434667886dc("gdvWahvki}oBbka"), true);
        try {
            JSONObject jSONObject = this.t;
            if (jSONObject != null) {
                jSONObject.put(p.p1699434667886dc("sdvwmka"), v());
                if (this.q != null) {
                    this.t.put(p.p1699434667886dc("eyvfjvohf"), this.q.ay());
                }
            }
            a(p.p1699434667886dc("gdvWahvki}oBbka"), false);
            return this.t.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0009 A[LOOP:0: B:1:0x0009->B:13:0x0009, LOOP_END, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x001e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A[SYNTHETIC] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r2 = this;
            com.bytedance.sdk.openadsdk.core.x$8 r0 = new com.bytedance.sdk.openadsdk.core.x$8
            r0.<init>()
            r1 = 0
            r2.a((org.json.JSONObject) r1, (com.bytedance.sdk.openadsdk.i.c) r0)
        L_0x0009:
            r0 = 94
            r1 = 75
        L_0x000d:
            switch(r0) {
                case 92: goto L_0x0013;
                case 93: goto L_0x0016;
                case 94: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x001e
        L_0x0011:
            r0 = 4
            goto L_0x001e
        L_0x0013:
            switch(r1) {
                case 21: goto L_0x001e;
                case 22: goto L_0x001e;
                case 23: goto L_0x001e;
                default: goto L_0x0016;
            }
        L_0x0016:
            switch(r1) {
                case 91: goto L_0x0009;
                case 92: goto L_0x001e;
                case 93: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x001b
        L_0x001a:
            return
        L_0x001b:
            r1 = 91
            goto L_0x0016
        L_0x001e:
            r1 = 93
            r0 = 93
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.h():void");
    }

    public boolean i() {
        boolean z2 = this.K;
        while (true) {
            char c2 = AbstractJsonLexerKt.END_LIST;
            char c3 = AbstractJsonLexerKt.END_LIST;
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        if (c3 > 4) {
                            break;
                        } else {
                            continue;
                        }
                }
                while (true) {
                    switch (c3) {
                        case '[':
                        case ']':
                            break;
                        case '\\':
                            break;
                        default:
                            c3 = AbstractJsonLexerKt.BEGIN_LIST;
                    }
                }
                c2 = '^';
                c3 = 'K';
            }
        }
        return z2;
    }

    @JavascriptInterface
    public void initRenderFinish() {
        com.bytedance.sdk.component.utils.l.b(p.p1699434667886dc("TUCG*DhczfcoCodjse"), p.p1699434667886dc("iokwV`hcm{Lbbd}g"));
        aa.a((Runnable) new Runnable() {
            public void run() {
                if (x.this.L != null) {
                    x.this.L.a();
                }
            }
        });
        while (true) {
            char c2 = 15;
            while (true) {
                switch (c2) {
                    case 13:
                    case 14:
                        return;
                    default:
                        c2 = 14;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        q qVar = this.q;
        return qVar != null && qVar.J() == 1;
    }

    public void k() {
        com.bytedance.sdk.openadsdk.g.c cVar = this.i;
        if (cVar != null) {
            cVar.a();
        }
        if (w()) {
            h();
        }
    }

    public void l() {
        com.bytedance.sdk.openadsdk.g.c cVar = this.i;
        if (cVar != null) {
            cVar.b();
            char c2 = AbstractJsonLexerKt.STRING_ESC;
            while (true) {
                char c3 = 14;
                while (true) {
                    switch (c3) {
                        case 13:
                            break;
                        case 14:
                            break;
                        case 15:
                            switch (c2) {
                                case '_':
                                    return;
                            }
                    }
                    c3 = 15;
                    c2 = '_';
                }
            }
        }
    }

    public void m() {
        com.bytedance.sdk.openadsdk.g.c cVar = this.i;
        if (cVar != null) {
            cVar.c();
        }
        this.P = null;
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            aa.a((Runnable) new Runnable() {
                public void run() {
                    x.this.i(jSONObject);
                }
            });
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.l.e(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("TUCG*DhczfcoCodjse"), "");
        }
    }

    public void n() {
        a aVar = this.Q;
        if (aVar != null) {
            aVar.a();
            while (true) {
                char c2 = 15;
                while (true) {
                    switch (c2) {
                        case 13:
                        case 14:
                            return;
                        default:
                            c2 = 14;
                    }
                }
            }
        }
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            l(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        aa.a((Runnable) new Runnable() {
            public void run() {
                x.this.t();
            }
        });
    }
}
