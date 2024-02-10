package com.bytedance.sdk.openadsdk.component.a;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.component.h.a;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenAdExpressView;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.com.bytedance.overseas.sdk.a.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TTAppOpenAdClickManager */
public class b {
    public static a a(q qVar, Activity activity, a aVar) {
        a aVar2 = new a(activity.getApplicationContext(), qVar, "open_ad", 4, aVar);
        aVar2.a(activity.findViewById(16908290));
        aVar2.b(activity.findViewById(520093713));
        a(activity.getApplicationContext(), qVar, (com.bytedance.sdk.openadsdk.core.b.b) aVar2);
        a(aVar2, qVar);
        return aVar2;
    }

    public static g a(q qVar, Activity activity, a aVar, PAGAppOpenAdExpressView pAGAppOpenAdExpressView) {
        final a aVar2 = aVar;
        AnonymousClass1 r0 = new g(activity.getApplicationContext(), qVar, "open_ad", 4) {
            public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(aVar2.b()));
                a((Map<String, Object>) hashMap);
                super.a(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        r0.a((View) pAGAppOpenAdExpressView);
        a(activity.getApplicationContext(), qVar, (com.bytedance.sdk.openadsdk.core.b.b) r0);
        a(r0, qVar);
        return r0;
    }

    public static f b(q qVar, Activity activity, a aVar, PAGAppOpenAdExpressView pAGAppOpenAdExpressView) {
        final a aVar2 = aVar;
        AnonymousClass2 r0 = new f(activity.getApplicationContext(), qVar, "open_ad", 4) {
            public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(aVar2.b()));
                a((Map<String, Object>) hashMap);
                super.a(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        r0.a((View) pAGAppOpenAdExpressView);
        a(activity.getApplicationContext(), qVar, (com.bytedance.sdk.openadsdk.core.b.b) r0);
        a(r0, qVar);
        return r0;
    }

    public static void a(com.bytedance.sdk.openadsdk.core.b.b bVar, q qVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("click_area", Integer.valueOf(qVar.k()));
        hashMap.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
        hashMap.put("click_scence", Integer.valueOf(t.k(qVar) ? 3 : 1));
        bVar.a((Map<String, Object>) hashMap);
    }

    private static void a(Context context, q qVar, com.bytedance.sdk.openadsdk.core.b.b bVar) {
        if (qVar != null && qVar.M() == 4) {
            bVar.a(d.a(context, qVar, "open_ad"));
        }
    }
}
