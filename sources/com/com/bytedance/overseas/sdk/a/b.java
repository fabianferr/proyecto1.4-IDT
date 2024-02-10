package com.com.bytedance.overseas.sdk.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.model.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GPDownLoader */
public class b implements c {
    protected static Boolean e;
    protected c a;
    protected q b;
    protected String c;
    protected boolean d = false;
    protected final AtomicBoolean f = new AtomicBoolean(false);
    protected int g;
    private final WeakReference<Context> h;
    private boolean i = false;

    public b(Context context, q qVar, String str) {
        this.h = new WeakReference<>(context);
        this.b = qVar;
        this.a = qVar.aa();
        this.c = str;
        l.b("GPDownLoader", str, "====tag===" + str);
        if (o.a() == null) {
            o.a(context);
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(int i2) {
        this.g = i2;
    }

    public boolean a(Context context, String str, String str2) {
        return a(context, str, str2, this.c, this.b);
    }

    public static boolean a(Context context, String str, String str2, String str3, q qVar) {
        Context context2 = context;
        String str4 = str2;
        String str5 = str3;
        q qVar2 = qVar;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean bool = e;
            jSONObject.put("storeOpenType", (bool == null || !bool.booleanValue()) ? "webview" : MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        } catch (JSONException e2) {
            l.c("GPDownLoader", "gotoGooglePlayByPackageNameAndUrl json error", e2);
        }
        String replace = (TextUtils.isEmpty(str3) || !str5.contains("_landingpage")) ? str5 : str5.replace("_landingpage", "");
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context2.startActivity(intent);
                l.c("GPDownLoader", "Goto Google Play");
                l.c("GPDownLoader", "download_url is : ->" + str);
                com.bytedance.sdk.openadsdk.b.c.b(qVar2, replace, "store_open", jSONObject);
                l.b("GPDownLoader", replace, jSONObject.toString());
                return true;
            } catch (Throwable unused) {
            }
        }
        if (!(context2 == null || str4 == null || TextUtils.isEmpty(str2))) {
            l.c("GPDownLoader", "gotoGooglePlay :market://details?id=" + str4);
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                Uri parse = Uri.parse("market://details?id=" + str4);
                intent2.setData(parse);
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent2, 65536)) {
                    if (resolveInfo.activityInfo.packageName.equals("com.android.vending")) {
                        if (context.getPackageManager().getLaunchIntentForPackage("com.android.vending") != null) {
                            Intent intent3 = new Intent("android.intent.action.VIEW");
                            intent3.setData(parse);
                            intent3.setPackage("com.android.vending");
                            if (!(context2 instanceof Activity)) {
                                intent3.setFlags(268435456);
                            }
                            context2.startActivity(intent3);
                            jSONObject.put("storeOpenType", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                            com.bytedance.sdk.openadsdk.b.c.b(qVar2, replace, "store_open", jSONObject);
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                ApmHelper.reportCustomError("gotoGooglePlayByPackageNameAndUrl error", "gotoGooglePlay", th);
            }
        }
        return false;
    }

    public static void a(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details"));
        try {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                if (resolveInfo.activityInfo.packageName.equals("com.android.vending")) {
                    e = true;
                    return;
                }
            }
        } catch (Throwable unused) {
            e = false;
        }
        e = false;
    }

    /* access modifiers changed from: protected */
    public Context c() {
        WeakReference<Context> weakReference = this.h;
        return (weakReference == null || weakReference.get() == null) ? o.a() : (Context) this.h.get();
    }

    public void d() {
        if (c() != null) {
            if (b()) {
                this.f.set(true);
                this.b.c(true);
            } else if (a()) {
                this.b.c(true);
            } else if (e()) {
                this.b.c(true);
            } else if (this.b.aa() == null && this.b.P() != null) {
                z.a(c(), this.b.P(), this.b, ac.a(this.c), this.c, true);
                this.b.c(true);
            }
        }
    }

    public boolean b() {
        d.a(this.b, this.c, 1, (JSONObject) null);
        if (this.b.ab() != null) {
            String a2 = this.b.ab().a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                ac.b a3 = ac.a(c(), intent);
                if (a3.b > 0) {
                    if (!(c() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    try {
                        HashMap hashMap = new HashMap();
                        a((Map<String, Object>) hashMap);
                        ComponentName resolveActivity = intent.resolveActivity(c().getPackageManager());
                        if (resolveActivity != null) {
                            hashMap.put("resolved_activity", resolveActivity.getPackageName() + "/" + resolveActivity.getClassName());
                        }
                        hashMap.put("matched_count", Integer.valueOf(a3.b));
                        hashMap.put("url", a2);
                        if (a3.a != null) {
                            hashMap.put("target_component", a3.a.getPackageName() + "/" + a3.a.getClassName());
                            intent.setComponent(a3.a);
                        }
                        com.bytedance.sdk.openadsdk.b.c.a(this.b, this.c, "open_url_app", (Map<String, Object>) hashMap);
                        c().startActivity(intent);
                        com.bytedance.sdk.openadsdk.b.l.a().a((Map<String, Object>) hashMap).a(this.b, this.c);
                        com.bytedance.sdk.openadsdk.b.c.a("dp_start_act_success", this.b, this.c, (Map<String, Object>) hashMap);
                        return true;
                    } catch (Throwable th) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("exception", th.getMessage());
                            jSONObject.put("intent", intent.toString());
                            jSONObject.put("can_query_install", 1);
                        } catch (Exception unused) {
                        }
                        d.a(this.b, this.c, -4, jSONObject);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("intent", intent.toString());
                        jSONObject2.put("can_query_install", 1);
                    } catch (Exception unused2) {
                    }
                    d.a(this.b, this.c, -3, jSONObject2);
                }
            } else {
                q qVar = this.b;
                d.a(qVar, this.c, -2, qVar.ab().d());
            }
            if (this.d && !this.f.get()) {
                return false;
            }
            this.d = true;
            HashMap hashMap2 = new HashMap();
            a((Map<String, Object>) hashMap2);
            com.bytedance.sdk.openadsdk.b.c.a(this.b, this.c, "open_fallback_url", (Map<String, Object>) hashMap2);
            return false;
        }
        d.a(this.b, this.c, -1, (JSONObject) null);
        return false;
    }

    private void a(Map<String, Object> map) {
        q qVar = this.b;
        boolean z = false;
        if (qVar != null && qVar.be() == 0) {
            q qVar2 = this.b;
            map.put("auto_click", Boolean.valueOf(qVar2 != null && !qVar2.c()));
        }
        q qVar3 = this.b;
        if (qVar3 != null && qVar3.be() == 0) {
            if (this.g >= 11) {
                z = true;
            }
            map.put("dpl_probability_jump", Boolean.valueOf(z));
        }
        map.put("can_query_install", 1);
    }

    public boolean e() {
        this.f.set(true);
        if (this.a == null || !a(c(), this.a.a(), this.a.c())) {
            return false;
        }
        return true;
    }

    public boolean a() {
        Intent a2;
        if (this.a == null) {
            return false;
        }
        q qVar = this.b;
        if (qVar != null && qVar.ap() == 0) {
            return false;
        }
        String c2 = this.a.c();
        if (TextUtils.isEmpty(c2) || !ac.b(c(), c2) || (a2 = ac.a(c(), c2)) == null) {
            return false;
        }
        a2.putExtra("START_ONLY_FOR_ANDROID", true);
        try {
            c().startActivity(a2);
            HashMap hashMap = new HashMap();
            a((Map<String, Object>) hashMap);
            com.bytedance.sdk.openadsdk.b.c.a(this.b, this.c, "click_open", (Map<String, Object>) hashMap);
            return true;
        } catch (Throwable th) {
            l.e("GPDownLoader", th.getMessage());
            return false;
        }
    }
}
