package com.bytedance.sdk.openadsdk.component.reward.a;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.i;
import com.com.bytedance.overseas.sdk.a.c;
import org.json.JSONObject;

/* compiled from: RewardFullDownloadManager */
public class d {
    c a;
    private final q b;
    private final String c;
    private boolean d;
    private final a e;

    /* compiled from: RewardFullDownloadManager */
    public interface a {
        void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3);

        void a(String str, JSONObject jSONObject);
    }

    public d(a aVar) {
        this.e = aVar;
        this.b = aVar.a;
        this.c = aVar.g;
    }

    public void a() {
        if (!this.d) {
            this.d = true;
            d();
        }
    }

    private void d() {
        if (!b.c() && this.b.M() == 4) {
            this.a = com.com.bytedance.overseas.sdk.a.d.a(this.e.W, this.b, this.c);
        }
        if (this.a == null) {
            this.a = com.com.bytedance.overseas.sdk.a.d.a(this.e.V, this.b, this.c);
        }
    }

    public void b() {
        com.com.bytedance.overseas.sdk.a.c cVar = this.a;
        if (cVar != null) {
            cVar.d();
        }
    }

    public com.com.bytedance.overseas.sdk.a.c c() {
        return this.a;
    }

    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3, a aVar) {
        a aVar2 = aVar;
        if (this.a != null) {
            int id = view.getId();
            if (id == i.e) {
                aVar2.a("click_play_star_level", (JSONObject) null);
            } else if (id == i.d) {
                aVar2.a("click_play_star_nums", (JSONObject) null);
            } else if (id == i.c) {
                aVar2.a("click_play_source", (JSONObject) null);
            } else if (id == i.b) {
                aVar2.a("click_play_logo", (JSONObject) null);
            }
        } else {
            aVar.a(view, f, f2, f3, f4, sparseArray, i, i2, i3);
        }
    }
}
