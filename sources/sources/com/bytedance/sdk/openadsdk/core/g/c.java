package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.openadsdk.core.g.b.c;
import com.bytedance.sdk.openadsdk.core.g.c.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VastResource */
public class c {
    protected int a;
    protected int b;
    protected a.C0066a c;
    protected a.b d;
    protected String e;
    protected List<com.bytedance.sdk.openadsdk.core.g.b.c> f = new ArrayList();
    protected List<com.bytedance.sdk.openadsdk.core.g.b.c> g = new ArrayList();
    protected String h;
    protected String i;
    private String j;
    private final AtomicBoolean k = new AtomicBoolean(false);
    private q l;

    public c(int i2, int i3, a.C0066a aVar, a.b bVar, String str, List<com.bytedance.sdk.openadsdk.core.g.b.c> list, List<com.bytedance.sdk.openadsdk.core.g.b.c> list2, String str2) {
        this.a = i2;
        this.b = i3;
        this.c = aVar;
        this.d = bVar;
        this.e = str;
        this.f = list;
        this.g = list2;
        this.h = str2;
        this.i = "endcard_click";
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public void a(long j2) {
        com.bytedance.sdk.openadsdk.core.g.b.c.a(this.f, (com.bytedance.sdk.openadsdk.core.g.a.a) null, j2, this.j, new c.b(this.i, this.l));
    }

    public void b(long j2) {
        if (this.k.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.core.g.b.c.b(this.g, (com.bytedance.sdk.openadsdk.core.g.a.a) null, j2, this.j);
        }
    }

    public static float a(int i2, int i3, int i4, int i5, a.b bVar, a.C0066a aVar) {
        if (i3 == 0 || i5 == 0) {
            return 0.0f;
        }
        float f2 = (float) i2;
        float f3 = (float) i4;
        return a(bVar, aVar) / ((Math.abs((f2 / ((float) i3)) - (f3 / ((float) i5))) + Math.abs((f2 - f3) / f2)) + 1.0f);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.c$1  reason: invalid class name */
    /* compiled from: VastResource */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bytedance.sdk.openadsdk.core.g.c.a$b[] r0 = com.bytedance.sdk.openadsdk.core.g.c.a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.bytedance.sdk.openadsdk.core.g.c.a$b r1 = com.bytedance.sdk.openadsdk.core.g.c.a.b.STATIC_RESOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bytedance.sdk.openadsdk.core.g.c.a$b r1 = com.bytedance.sdk.openadsdk.core.g.c.a.b.HTML_RESOURCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bytedance.sdk.openadsdk.core.g.c.a$b r1 = com.bytedance.sdk.openadsdk.core.g.c.a.b.IFRAME_RESOURCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.c.AnonymousClass1.<clinit>():void");
        }
    }

    private static float a(a.b bVar, a.C0066a aVar) {
        int i2 = AnonymousClass1.a[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return i2 != 3 ? 0.0f : 1.0f;
            }
            return 1.2f;
        } else if (a.C0066a.JAVASCRIPT.equals(aVar)) {
            return 1.0f;
        } else {
            if (a.C0066a.IMAGE.equals(aVar)) {
                return 0.8f;
            }
            return 0.0f;
        }
    }

    public String d() {
        int i2 = AnonymousClass1.a[this.d.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return this.e;
            }
            if (i2 != 3) {
                return null;
            }
            return "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.a + "\" height=\"" + this.b + "\" src=\"" + this.e + "\"></iframe>";
        } else if (this.c == a.C0066a.IMAGE) {
            return "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.e + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
        } else if (this.c != a.C0066a.JAVASCRIPT) {
            return null;
        } else {
            return "<script src=\"" + this.e + "\"></script>";
        }
    }

    public String e() {
        if (this.d == a.b.STATIC_RESOURCE && this.c == a.C0066a.IMAGE) {
            return this.e;
        }
        return null;
    }

    public String f() {
        return this.e;
    }

    public void a(String str) {
        this.j = str;
    }

    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        int optInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        String optString = jSONObject.optString("creativeType", a.C0066a.NONE.toString());
        String optString2 = jSONObject.optString("resourceType", a.b.HTML_RESOURCE.toString());
        String optString3 = jSONObject.optString("contentUrl");
        String optString4 = jSONObject.optString("clickThroughUri");
        JSONArray optJSONArray = jSONObject.optJSONArray("clickTrackers");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creativeViewTrackers");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(new c.a(optJSONArray.optString(i2)).a());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
            arrayList2.add(new c.a(optJSONArray2.optString(i3)).a());
        }
        return new c(optInt, optInt2, a.C0066a.valueOf(optString), a.b.valueOf(optString2), optString3, arrayList, arrayList2, optString4);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.a);
        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.b);
        jSONObject.put("creativeType", this.c.toString());
        jSONObject.put("resourceType", this.d.toString());
        jSONObject.put("contentUrl", this.e);
        jSONObject.put("clickThroughUri", this.h);
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.g.b.c.a(this.f));
        jSONObject.put("creativeViewTrackers", com.bytedance.sdk.openadsdk.core.g.b.c.a(this.g));
        return jSONObject;
    }

    public void a(q qVar) {
        this.l = qVar;
    }
}
