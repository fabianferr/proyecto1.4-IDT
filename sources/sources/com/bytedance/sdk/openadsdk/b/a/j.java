package com.bytedance.sdk.openadsdk.b.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.b.b;
import com.bytedance.sdk.component.e.a.b.c;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.a;
import com.bytedance.sdk.openadsdk.b.e;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.settings.k;
import com.bytedance.sdk.openadsdk.j.c.b;
import com.bytedance.sdk.openadsdk.utils.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OverSeaEventUploadImpl */
public class j implements c {
    public p<a> a;
    private final c b = new c();

    public void a(List<com.bytedance.sdk.component.e.a.d.a> list, b bVar) {
        com.bytedance.sdk.component.e.a.d.a aVar;
        if (list != null && !list.isEmpty() && (aVar = list.get(0)) != null) {
            byte d = aVar.d();
            final ArrayList arrayList = new ArrayList();
            if (d == 0) {
                final List<com.bytedance.sdk.component.e.a.d.a> list2 = list;
                final b bVar2 = bVar;
                aa.b(new h("upload_ad_event") {
                    public void run() {
                        Iterator it;
                        try {
                            it = j.this.d(list2).entrySet().iterator();
                        } catch (Throwable th) {
                            l.e("OverSeaEventUploadImp", th.getMessage());
                            it = null;
                        }
                        if (it == null) {
                            b bVar = bVar2;
                            if (bVar != null) {
                                bVar.a(arrayList);
                                return;
                            }
                            return;
                        }
                        while (it.hasNext()) {
                            try {
                                a.a(a.d);
                                List<com.bytedance.sdk.component.e.a.d.a> list = (List) ((Map.Entry) it.next()).getValue();
                                ArrayList arrayList = new ArrayList();
                                for (com.bytedance.sdk.component.e.a.d.a aVar : list) {
                                    arrayList.add(new a(aVar.c(), aVar.g()));
                                }
                                e a2 = j.this.a(arrayList);
                                if (!(bVar2 == null || a2 == null)) {
                                    boolean z = a2.d;
                                    if (j.this.a((List<a>) arrayList, a2)) {
                                        z = true;
                                    }
                                    arrayList.add(new com.bytedance.sdk.component.e.a.b.c.a(new com.bytedance.sdk.component.e.a.b.c.b(a2.a, a2.b, a2.c, z, ""), list));
                                    if (a2.b == 200) {
                                        a.a(a.d, true);
                                    } else if (z) {
                                        a.a(a.d, false);
                                    }
                                }
                            } catch (Throwable th2) {
                                l.e("OverSeaEventUploadImp", th2.getMessage());
                            }
                        }
                        b bVar2 = bVar2;
                        if (bVar2 != null) {
                            bVar2.a(arrayList);
                        }
                    }
                }, 10);
            } else if (d == 1) {
                final ArrayList arrayList2 = new ArrayList();
                for (com.bytedance.sdk.component.e.a.d.a next : list) {
                    arrayList2.add(new b.a(next.c(), next.g()));
                }
                a.a(a.e);
                if (arrayList2.size() > 0) {
                    final com.bytedance.sdk.component.e.a.b.b bVar3 = bVar;
                    final List<com.bytedance.sdk.component.e.a.d.a> list3 = list;
                    aa.b(new h("upload_stats_event") {
                        public void run() {
                            e b2 = j.this.b(arrayList2);
                            if (bVar3 != null && b2 != null) {
                                arrayList.add(new com.bytedance.sdk.component.e.a.b.c.a(new com.bytedance.sdk.component.e.a.b.c.b(b2.a, b2.b, b2.c, b2.d, ""), list3));
                                bVar3.a(arrayList);
                                if (b2.b == 200) {
                                    a.a(a.e, true);
                                } else if (b2.d) {
                                    a.a(a.e, false);
                                }
                            }
                        }
                    }, 5);
                }
            }
        }
    }

    private boolean c(List<a> list) {
        JSONObject c;
        if (list == null || list.size() == 0 || (c = list.get(0).c()) == null) {
            return true;
        }
        return TextUtils.isEmpty(c.optString("app_log_url"));
    }

    /* access modifiers changed from: private */
    public boolean a(List<a> list, e eVar) {
        if (!c(list) && eVar.b >= 400 && eVar.b < 500) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public HashMap<String, List<com.bytedance.sdk.component.e.a.d.a>> d(List<com.bytedance.sdk.component.e.a.d.a> list) {
        HashMap<String, List<com.bytedance.sdk.component.e.a.d.a>> hashMap = new HashMap<>();
        new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.sdk.component.e.a.d.a aVar = list.get(i);
            JSONObject g = aVar.g();
            if (g != null) {
                String optString = g.optString("app_log_url");
                List list2 = hashMap.get(optString);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(optString, list2);
                }
                list2.add(aVar);
            }
        }
        return hashMap;
    }

    public e a(List<a> list) {
        if (this.a == null) {
            this.a = o.c();
        }
        if (this.a == null) {
            return null;
        }
        int af = com.bytedance.sdk.openadsdk.core.settings.o.ai().af();
        if (3 == af) {
            return this.a.a(this.b.a(this.b.a(list, false), System.currentTimeMillis(), this.b.a(), true), this.b.a(list), true);
        } else if (2 == af) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject a2 = this.b.a();
            JSONObject jSONObject = a2;
            this.a.a(this.b.a(this.b.a(list, true), currentTimeMillis, jSONObject, true), this.b.a(list), true);
            return this.a.a(this.b.a(this.b.b(list), currentTimeMillis, jSONObject, false), this.b.a(list), false);
        } else {
            return this.a.a(this.b.a(list, System.currentTimeMillis(), this.b.a(), false), this.b.a(list), false);
        }
    }

    public e b(List<b.a> list) {
        if (this.a == null) {
            this.a = o.c();
        }
        if (list == null || list.size() == 0 || !k.a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : list) {
                jSONArray.put(aVar.b);
            }
            jSONObject.put("stats_list", jSONArray);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.e.a(String.valueOf(currentTimeMillis).concat("stats_list")));
        } catch (Exception unused) {
        }
        return this.a.a(jSONObject);
    }
}
