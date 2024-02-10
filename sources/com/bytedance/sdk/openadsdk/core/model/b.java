package com.bytedance.sdk.openadsdk.core.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.j.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdLogInfoModel */
public class b {
    public String a;
    public int b;
    public int c = 1;
    public ArrayList<Integer> d;
    public AdSlot e;

    public static void a(b bVar) {
        int b2;
        if (bVar != null && bVar.d() != null && (b2 = bVar.b()) < 0 && b2 != -8) {
            com.bytedance.sdk.openadsdk.j.b.a();
            com.bytedance.sdk.openadsdk.j.b.a("rd_client_custom_error", false, (a) new a(bVar) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TypedValues.TransitionType.S_FROM, this.a.c());
                    jSONObject.put("err_code", this.a.b());
                    jSONObject.put("server_res_str", this.a.a());
                    if (this.a.e() != null && this.a.e().size() > 0) {
                        jSONObject.put("mate_unavailable_code_list", new JSONArray(this.a.e()).toString());
                    }
                    l.b("AdLogInfoModel", "rd_client_custom_error = ", jSONObject);
                    return com.bytedance.sdk.openadsdk.j.a.b.b().a("rd_client_custom_error").a(this.a.d().getDurationSlotType()).b(jSONObject.toString());
                }
            });
        }
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(AdSlot adSlot) {
        this.e = adSlot;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.d = arrayList;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    public AdSlot d() {
        return this.e;
    }

    public ArrayList<Integer> e() {
        return this.d;
    }
}
