package com.bytedance.sdk.component.adexpress.dynamic.c;

import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.dynamic.d.b;
import com.bytedance.sdk.component.utils.l;

/* compiled from: DynamicNativeParser */
public class f implements g {
    private b a;

    public void a(b bVar) {
        this.a = bVar;
    }

    public void a(final m mVar) {
        if (mVar.l() == 1) {
            l.b("DynamicNativeParser", "parse on ui thread");
            b(mVar);
            return;
        }
        com.bytedance.sdk.component.g.f.c().execute(new Runnable() {
            public void run() {
                l.b("DynamicNativeParser", "parse on non ui thread");
                f.this.b(mVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.bytedance.sdk.component.adexpress.b.m r14) {
        /*
            r13 = this;
            org.json.JSONObject r0 = r14.c()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "template_Plugin"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x0067 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0067 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "creative"
            org.json.JSONObject r1 = r0.optJSONObject(r1)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = "AdSize"
            org.json.JSONObject r3 = r0.optJSONObject(r3)     // Catch:{ Exception -> 0x0067 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0067 }
            java.lang.String r5 = "diff_template_Plugin"
            java.lang.String r0 = r0.optString(r5)     // Catch:{ Exception -> 0x0067 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0067 }
            com.bytedance.sdk.component.adexpress.dynamic.c.e r5 = new com.bytedance.sdk.component.adexpress.dynamic.c.e     // Catch:{ Exception -> 0x0067 }
            r5.<init>(r2, r1, r3, r4)     // Catch:{ Exception -> 0x0067 }
            double r6 = r14.b()     // Catch:{ Exception -> 0x0067 }
            int r8 = r14.j()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r0 = "score_exact_i18n"
            double r9 = r1.optDouble(r0)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r0 = "comment_num_i18n"
            java.lang.String r11 = r1.optString(r0)     // Catch:{ Exception -> 0x0067 }
            r12 = r14
            com.bytedance.sdk.component.adexpress.dynamic.b.h r14 = r5.a(r6, r8, r9, r11, r12)     // Catch:{ Exception -> 0x0067 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = "dynamic_creative"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ all -> 0x0061 }
            r0.<init>(r1)     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ all -> 0x0061 }
            r14.a((java.lang.String) r1)     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "material_center"
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch:{ all -> 0x0061 }
            r14.a((org.json.JSONArray) r0)     // Catch:{ all -> 0x0061 }
        L_0x0061:
            com.bytedance.sdk.component.adexpress.dynamic.d.b r0 = r13.a     // Catch:{ Exception -> 0x0067 }
            r0.a(r14)     // Catch:{ Exception -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r14 = move-exception
            r14.printStackTrace()
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.f.b(com.bytedance.sdk.component.adexpress.b.m):void");
    }
}
