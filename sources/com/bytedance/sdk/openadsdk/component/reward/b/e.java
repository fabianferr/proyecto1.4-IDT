package com.bytedance.sdk.openadsdk.component.reward.b;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.i.f;
import com.bytedance.sdk.openadsdk.j.b;
import com.bytedance.sdk.openadsdk.utils.aa;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RewardFullTypeDoubleAds */
public class e extends b implements f {
    private final r o;
    private boolean p;

    /* access modifiers changed from: protected */
    public boolean B() {
        return false;
    }

    public void a(FrameLayout frameLayout) {
    }

    public boolean e() {
        return true;
    }

    public boolean f() {
        return true;
    }

    public void g() {
    }

    public e(a aVar) {
        super(aVar);
        this.o = (r) aVar.a;
    }

    public static void a(q qVar, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_backup", Boolean.valueOf(z));
        c.a("choose_ad_start_show", qVar, str, (Map<String, Object>) hashMap);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_id", qVar.bc());
            jSONObject.put("is_backup", z);
        } catch (JSONException unused) {
        }
        b.a().a("choose_ad_start_show", jSONObject);
    }

    public void a(RewardFullBaseLayout rewardFullBaseLayout) {
        if (c.a((q) this.o)) {
            c.a(this.o, rewardFullBaseLayout);
        } else {
            super.a(rewardFullBaseLayout);
        }
    }

    public boolean b() {
        return this.p;
    }

    public void z() {
        x jsObject;
        if (!this.a.V.isFinishing()) {
            if (this.a.J.h() || this.p) {
                super.z();
                if (this.a.J.h()) {
                    A();
                    this.a.S.b();
                    return;
                }
                return;
            }
            FullRewardExpressView a = this.a.J.a();
            if (a != null && (jsObject = a.getJsObject()) != null) {
                jsObject.a((f) this);
            }
        }
    }

    public void a(int i, long j) {
        this.p = true;
        int i2 = i - 1;
        this.o.K(i2);
        c.a((q) this.o, this.a.g, i, j);
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.o.bv(), i2);
        aa.a((Runnable) new Runnable() {
            public void run() {
                e.this.z();
                e.this.A();
                e.this.a.S.b();
            }
        });
    }

    public void a(n nVar) {
        this.a.J.a().b(nVar);
    }

    public void b(boolean z) {
        if (!this.p) {
            HashMap hashMap = new HashMap();
            hashMap.put("has_focus", Boolean.valueOf(z));
            c.a("choose_ad_focus_changed", (q) this.o, this.a.g, (Map<String, Object>) hashMap);
        }
    }
}
