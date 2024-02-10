package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.n.a.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TTAppOpenAdClickListener */
public class a extends com.bytedance.sdk.openadsdk.core.b.a {
    private final com.bytedance.sdk.openadsdk.component.h.a a;

    public a(Context context, q qVar, String str, int i, com.bytedance.sdk.openadsdk.component.h.a aVar) {
        super(context, qVar, str, i);
        this.a = aVar;
    }

    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        if (view.getTag() == "open_ad_click_button_tag") {
            a("click_bar");
        } else {
            a("click_material");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(this.a.b()));
        a((Map<String, Object>) hashMap);
        super.a(view, f, f2, f3, f4, sparseArray, z);
        e.a(this.e, 9);
    }
}
