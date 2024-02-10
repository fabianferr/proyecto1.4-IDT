package com.bytedance.sdk.openadsdk.component.reward.a;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.component.reward.a.d;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.model.i;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RewardFullReportManager */
public class h {
    /* access modifiers changed from: private */
    public final a a;
    private final View.OnClickListener b;
    private final e c;

    public h(a aVar) {
        this.a = aVar;
        this.c = new e(aVar.V, aVar.a, aVar.g, aVar.f ? 7 : 5) {
            public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3, boolean z) {
                View view2 = view;
                StringBuilder sb = new StringBuilder("onRewardBarClick , x = ");
                float f5 = f;
                sb.append(f);
                l.b("TTAD.RFReportManager", sb.toString());
                if (h.this.a.a.at() && view2 != null) {
                    Object tag = view.getTag(570425345);
                    if (tag instanceof String) {
                        a((String) tag);
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(h.this.a.G.g()));
                if (h.this.a.u.get()) {
                    hashMap.put("click_scence", 2);
                } else if (t.k(h.this.a.a)) {
                    hashMap.put("click_scence", 3);
                } else {
                    hashMap.put("click_scence", 1);
                }
                a((Map<String, Object>) hashMap);
                h.this.a.V.onRewardBarClick(view);
                if (view.getId() == i.bf && t.k(h.this.a.a)) {
                    JSONObject jSONObject = new JSONObject();
                    if (h.this.a.a.K() != null) {
                        try {
                            jSONObject.put("playable_url", h.this.a.a.K().l());
                        } catch (JSONException e) {
                            l.c("TTAD.RFReportManager", "onRewardBarClick json error", e);
                        }
                    }
                    com.bytedance.sdk.openadsdk.b.c.b(h.this.a.a, h.this.a.g, "click_playable_download_button_loading", jSONObject);
                }
                h.this.a.H.a(view, f, f2, f3, f4, sparseArray, i, i2, i3, new d.a() {
                    public void a(String str, JSONObject jSONObject) {
                        h.this.a(str, jSONObject);
                    }

                    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3) {
                        h.this.a(view, f, f2, f3, f4, sparseArray, i, i2, i3);
                    }
                });
                com.bytedance.sdk.openadsdk.n.a.e.a(h.this.a.a, 9);
            }
        };
        this.b = new b(aVar.V, aVar.a, aVar.g, aVar.f ? 7 : 5) {
            public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                try {
                    h.this.a(view, f, f2, f3, f4, sparseArray, this.B, this.z, this.A);
                } catch (Exception e) {
                    l.e("TTAD.RFReportManager", "onClickReport error :" + e.getMessage());
                }
                com.bytedance.sdk.openadsdk.n.a.e.a(h.this.a.a, 9);
            }
        };
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        q qVar = this.a.a;
        if ((qVar instanceof r) && ((r) qVar).bz()) {
            try {
                jSONObject.put("choose_one_ad_real_show", true);
            } catch (JSONException e) {
                l.c("TTAD.RFReportManager", "reportShow json error", e);
            }
        }
        if (!this.a.x.get() || !o.c(qVar)) {
            this.a.x.set(true);
            com.bytedance.sdk.openadsdk.b.c.a(qVar, this.a.g, jSONObject);
            if (this.a.V instanceof com.bytedance.sdk.openadsdk.core.video.c.b) {
                this.a.V.g();
            }
            com.bytedance.sdk.openadsdk.n.a.e.a(this.a.V.findViewById(16908290), qVar, -1);
        }
    }

    public void b() {
        boolean z;
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.a.V.p() || this.a.J == null) {
                z = false;
            } else {
                jSONObject.put("dynamic_show_type", this.a.J.i());
                z = true;
            }
            q qVar = this.a.a;
            if ((qVar instanceof r) && ((r) qVar).bz()) {
                jSONObject.put("choose_one_ad_real_show", true);
            }
            View findViewById = this.a.V.findViewById(16908290);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, findViewById.getWidth());
                jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, findViewById.getHeight());
                jSONObject2.put("alpha", (double) findViewById.getAlpha());
            } catch (Throwable unused) {
            }
            jSONObject.put("root_view", jSONObject2.toString());
            this.a.x.set(true);
            com.bytedance.sdk.openadsdk.b.c.a(qVar, this.a.g, jSONObject);
            if (this.a.V instanceof com.bytedance.sdk.openadsdk.core.video.c.b) {
                this.a.V.g();
            }
            com.bytedance.sdk.openadsdk.n.a.e.a(this.a.V.findViewById(16908290), qVar, z ? this.a.J.i() : -1);
        } catch (JSONException e) {
            l.c("TTAD.RFReportManager", "reportShowWhenBindVideoAd error", e);
        }
    }

    public void a(final Map<String, Object> map) {
        this.a.x.set(true);
        final View findViewById = this.a.V.findViewById(16908290);
        if (findViewById == null) {
            findViewById = this.a.V.getWindow().getDecorView();
        }
        findViewById.post(new Runnable() {
            public void run() {
                Map map;
                JSONObject jSONObject;
                boolean z = true;
                if (!h.this.a.y.getAndSet(true)) {
                    q qVar = h.this.a.a;
                    JSONObject jSONObject2 = null;
                    try {
                        if (map != null) {
                            jSONObject = new JSONObject(map);
                        } else {
                            jSONObject = new JSONObject();
                        }
                        jSONObject2 = jSONObject;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, findViewById.getWidth());
                        jSONObject3.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, findViewById.getHeight());
                        jSONObject3.put("alpha", (double) findViewById.getAlpha());
                        jSONObject2.put("root_view", jSONObject3.toString());
                        if ((qVar instanceof r) && ((r) qVar).bz()) {
                            jSONObject2.put("choose_one_ad_real_show", true);
                        }
                    } catch (Throwable th) {
                        l.c("TTAD.RFReportManager", "run: ", th);
                    }
                    com.bytedance.sdk.openadsdk.b.c.a(qVar, h.this.a.g, jSONObject2);
                    if (h.this.a.V instanceof com.bytedance.sdk.openadsdk.core.video.c.b) {
                        h.this.a.V.g();
                    }
                    if (h.this.a.J == null || (map = map) == null || !map.containsKey("dynamic_show_type")) {
                        z = false;
                    }
                    com.bytedance.sdk.openadsdk.n.a.e.a(h.this.a.V.findViewById(16908290), qVar, z ? h.this.a.J.i() : -1);
                }
            }
        });
    }

    public void a(boolean z) {
        if (this.a.a != null) {
            com.bytedance.sdk.openadsdk.j.a.b e = com.bytedance.sdk.openadsdk.j.a.b.b().a(z ? 7 : 8).c(String.valueOf(this.a.a.aZ())).e(this.a.a.bc());
            e.b(this.a.Q.t()).f(this.a.Q.u());
            e.g(this.a.a.ac()).d(this.a.a.Y());
            com.bytedance.sdk.openadsdk.j.b.a().c(e);
        }
    }

    public e c() {
        this.c.a(this.a.V.findViewById(16908290));
        this.c.b(this.a.V.findViewById(520093713));
        if (this.a.H.c() != null) {
            this.c.a(this.a.H.c());
        }
        this.a.I.a(this.c);
        this.c.a((a.C0061a) new a.C0061a() {
            public long getVideoProgress() {
                return h.this.a.G.g();
            }
        });
        com.bytedance.sdk.openadsdk.component.reward.view.e eVar = this.a.T;
        e eVar2 = this.c;
        eVar.a(eVar2, eVar2, this.b);
        this.a.S.a(this.c);
        return this.c;
    }

    public View.OnClickListener d() {
        return this.b;
    }

    public e e() {
        return this.c;
    }

    public void b(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            if (z || !aVar.x.get() || this.a.r <= 0) {
                this.a.r = SystemClock.elapsedRealtime();
            } else {
                com.bytedance.sdk.openadsdk.b.c.a(String.valueOf(SystemClock.elapsedRealtime() - this.a.r), this.a.a, this.a.V.a, this.a.G.a());
                this.a.r = 0;
            }
            com.bytedance.sdk.openadsdk.n.a.e.a(this.a.a, z ? 4 : 8);
        }
    }

    public void f() {
        JSONObject jSONObject = new JSONObject();
        if (t.k(this.a.a)) {
            this.a.I.a(jSONObject);
        }
        int i = 1;
        if (this.a.u.get()) {
            if (!this.a.Q.c()) {
                i = this.a.Q.d() ? 2 : 0;
            }
            try {
                jSONObject.put("endcard_content", i);
            } catch (JSONException unused) {
            }
        } else {
            jSONObject.put("endCardNotShow", 1);
        }
        com.bytedance.sdk.openadsdk.b.c.b(this.a.a, this.a.V.a, "click_close", jSONObject);
    }

    /* access modifiers changed from: private */
    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3) {
        if (view != null) {
            TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
            if (view.getId() == i.e) {
                a("click_play_star_level", (JSONObject) null);
            } else if (view.getId() == i.d || view.getId() == i.g) {
                a("click_play_star_nums", (JSONObject) null);
            } else if (view.getId() == i.c) {
                a("click_play_source", (JSONObject) null);
            } else if (view.getId() == i.b) {
                a("click_play_logo", (JSONObject) null);
            } else if (view.getId() == i.l || view.getId() == i.aq || view.getId() == i.p) {
                a("click_start_play_bar", h());
            } else if (view.getId() == 520093705) {
                a("click_start_play", h());
            } else if (view.getId() == i.k) {
                a("click_video", h());
            } else if (view.getId() == 520093707 || view.getId() == i.h) {
                a("fallback_endcard_click", h());
            }
            b(view, f, f2, f3, f4, sparseArray, i, i2, i3);
        }
    }

    private void b(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3) {
        if (g() && this.a.a != null && view != null) {
            TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
            int id = view.getId();
            if (id == i.e || id == i.d || id == i.c || id == i.b || id == i.l || id == i.aq || id == i.p || id == 520093705 || id == i.k || id == 520093707 || id == i.g) {
                int g = ad.g(com.bytedance.sdk.openadsdk.core.o.a());
                com.bytedance.sdk.openadsdk.core.model.i a2 = new i.a().f(f).e(f2).d(f3).c(f4).b(System.currentTimeMillis()).a(0).b(ad.a(this.a.T.k())).a(ad.a((View) null)).c(ad.c(this.a.T.k())).d(ad.c((View) null)).d(i2).e(i3).f(i).a(sparseArray).b(com.bytedance.sdk.openadsdk.core.h.b().a() ? 1 : 2).c(g).a(ad.e(com.bytedance.sdk.openadsdk.core.o.a())).b(ad.f(com.bytedance.sdk.openadsdk.core.o.a())).a();
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(this.a.G.g()));
                com.bytedance.sdk.openadsdk.b.c.a("click_other", this.a.a, a2, this.a.g, true, (Map<String, Object>) hashMap, -1);
            }
        }
    }

    private boolean g() {
        if (this.a.a != null && this.a.a.J() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        q qVar = this.a.a;
        String str2 = this.a.g;
        if (!this.a.f) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.b.c.a(qVar, str2, str, jSONObject);
    }

    private JSONObject h() {
        try {
            long p = this.a.G.p();
            int q = this.a.G.q();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", p);
                jSONObject.put("percent", q);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void c(boolean z) {
        a aVar = this.a;
        if (aVar != null && z && aVar.a.bj() && !this.a.a.bo()) {
            this.a.a.f(true);
            com.bytedance.sdk.openadsdk.b.c.a(this.a.a, this.a.g, this.a.a.bk());
        }
    }
}
