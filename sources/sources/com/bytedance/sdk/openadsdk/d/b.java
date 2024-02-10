package com.bytedance.sdk.openadsdk.d;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.GeckoHubImp;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* compiled from: GeckoHub */
public class b {
    private static final String[] a = {"gecko-pangle-sg.byteoversea.com"};

    /* compiled from: GeckoHub */
    private static class a {
        /* access modifiers changed from: private */
        public static final b a = new b();
    }

    public static b a() {
        return a.a;
    }

    public ILoader b() {
        try {
            return GeckoHubImp.inst(o.a()).getGeckoResLoader();
        } catch (Throwable th) {
            l.c("GeckoHub", "getGeckoResLoader error", th);
            return null;
        }
    }

    private b() {
        try {
            GeckoHubImp.inst(o.a());
        } catch (Throwable th) {
            l.c("GeckoHub", "GeckoHubImp init error", th);
        }
    }

    private static String c() {
        String[] aa = o.d().aa();
        StringBuilder sb = new StringBuilder("GeckoLog:get gecko hosts from settings ");
        sb.append(aa == null ? 0 : aa.length);
        l.b("GeckoHub", sb.toString());
        if (aa == null) {
            aa = a;
        }
        String str = aa[new SecureRandom().nextInt(aa.length)];
        if (TextUtils.isEmpty(str)) {
            SecureRandom secureRandom = new SecureRandom();
            String[] strArr = a;
            str = strArr[secureRandom.nextInt(strArr.length)];
        }
        l.b("GeckoHub", "GeckoLog:random host " + str);
        return str;
    }

    public void a(final Map<String, q> map) {
        try {
            String a2 = j.a(o.a());
            if (TextUtils.isEmpty(a2)) {
                l.b("GeckoHub", "no did so don't preload");
                return;
            }
            for (q a3 : map.values()) {
                c.a.a(a3);
            }
            GeckoHubImp.setRandomHost(c());
            GeckoHubImp.inst(o.a()).preload(a2, new IStatisticMonitor() {
                public void upload(String str, JSONObject jSONObject) {
                    if ("geckosdk_update_stats".equals(str)) {
                        q qVar = (q) map.get(jSONObject.optString("channel"));
                        if (qVar != null) {
                            c.a.a(str, jSONObject, qVar);
                        }
                    } else if ("download_gecko_end".equals(str)) {
                        b.b(map, jSONObject, "");
                    }
                }
            }, map.keySet(), new a());
        } catch (Throwable th) {
            b(map, (JSONObject) null, th.toString());
            l.c("GeckoHub", "releaseGeckoResLoader error", th);
        }
    }

    /* access modifiers changed from: private */
    public static void b(Map<String, q> map, JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                jSONObject2.put("success", false);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject2.put("code", 1);
                jSONObject = jSONObject2;
            }
            for (q a2 : map.values()) {
                c.a.a(a2, jSONObject);
            }
        } catch (Throwable th) {
            l.c("GeckoHub", "upLoadStateEvent error", th);
        }
    }

    public void a(ILoader iLoader) {
        if (iLoader != null) {
            try {
                GeckoHubImp.inst(o.a()).releaseGeckoResLoader(iLoader);
            } catch (Throwable th) {
                l.c("GeckoHub", "releaseGeckoResLoader error", th);
            }
        }
    }

    public WebResourceResponseModel a(ILoader iLoader, String str, String str2) {
        if (iLoader == null) {
            return null;
        }
        try {
            return GeckoHubImp.inst(o.a()).findResAndMsg(iLoader, str, str2);
        } catch (Throwable th) {
            l.c("GeckoHub", "findRes error", th);
            return null;
        }
    }

    public int a(ILoader iLoader, String str) {
        try {
            return GeckoHubImp.inst(o.a()).getResCount(iLoader, str);
        } catch (Throwable th) {
            l.c("GeckoHub", "getResCount error", th);
            return 0;
        }
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor) {
        try {
            GeckoHubImp.setThreadPoolExecutor(threadPoolExecutor);
        } catch (Throwable th) {
            l.c("GeckoHub", "setThreadPoolExecutor error", th);
        }
    }
}
