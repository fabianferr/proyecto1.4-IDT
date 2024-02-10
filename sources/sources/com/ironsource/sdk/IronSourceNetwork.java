package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.sdk.controller.g;
import com.ironsource.sdk.j.d;
import com.ironsource.sdk.j.e;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class IronSourceNetwork {
    private static e a;
    private static d b;
    private static JSONObject c;

    private static synchronized void a() {
        synchronized (IronSourceNetwork.class) {
            if (a == null) {
                throw new NullPointerException("Call initSDK first");
            }
        }
    }

    public static synchronized void applyConsentInfo(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            e eVar = a;
            if (eVar != null) {
                if (jSONObject != null) {
                    eVar.a(jSONObject);
                }
            }
        }
    }

    public static synchronized void destroyAd(b bVar) {
        synchronized (IronSourceNetwork.class) {
            a();
            a.a(bVar);
        }
    }

    public static synchronized g getControllerManager() {
        g a2;
        synchronized (IronSourceNetwork.class) {
            a2 = a.a();
        }
        return a2;
    }

    public static d getInitListener() {
        return b;
    }

    public static synchronized void getOfferWallCredits(e eVar) {
        synchronized (IronSourceNetwork.class) {
            a();
            a.a(eVar);
        }
    }

    public static synchronized JSONObject getRawToken(Context context) {
        JSONObject b2;
        synchronized (IronSourceNetwork.class) {
            b2 = com.ironsource.sdk.service.d.a().b(context);
        }
        return b2;
    }

    public static synchronized String getToken(Context context) {
        String a2;
        synchronized (IronSourceNetwork.class) {
            a2 = com.ironsource.sdk.service.d.a().a(context);
        }
        return a2;
    }

    public static String getVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static synchronized void initOfferWall(Map<String, String> map, e eVar) {
        synchronized (IronSourceNetwork.class) {
            a();
            a.a(map, eVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00be, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void initSDK(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            java.lang.Class<com.ironsource.sdk.IronSourceNetwork> r0 = com.ironsource.sdk.IronSourceNetwork.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00bf }
            if (r1 == 0) goto L_0x0012
            java.lang.String r6 = "IronSourceNetwork"
            java.lang.String r7 = "applicationKey is NULL"
            com.ironsource.sdk.utils.Logger.e(r6, r7)     // Catch:{ all -> 0x00bf }
            monitor-exit(r0)
            return
        L_0x0012:
            com.ironsource.sdk.e r1 = a     // Catch:{ all -> 0x00bf }
            if (r1 != 0) goto L_0x00bd
            com.ironsource.sdk.utils.SDKUtils.setInitSDKParams(r9)     // Catch:{ all -> 0x00bf }
            org.json.JSONObject r1 = com.ironsource.sdk.utils.SDKUtils.getNetworkConfiguration()     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = "events"
            org.json.JSONObject r1 = r1.optJSONObject(r2)     // Catch:{ Exception -> 0x009a }
            if (r1 == 0) goto L_0x00b2
            com.ironsource.a.a$a r2 = new com.ironsource.a.a$a     // Catch:{ Exception -> 0x009a }
            java.lang.String r3 = "endpoint"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ Exception -> 0x009a }
            r2.<init>(r3)     // Catch:{ Exception -> 0x009a }
            java.lang.String r3 = "GET"
            r2.c = r3     // Catch:{ Exception -> 0x009a }
            java.lang.String r3 = "enabled"
            boolean r1 = r1.optBoolean(r3)     // Catch:{ Exception -> 0x009a }
            r2.b = r1     // Catch:{ Exception -> 0x009a }
            com.ironsource.sdk.a.e r1 = new com.ironsource.sdk.a.e     // Catch:{ Exception -> 0x009a }
            r1.<init>()     // Catch:{ Exception -> 0x009a }
            r2.d = r1     // Catch:{ Exception -> 0x009a }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x009a }
            r1.<init>()     // Catch:{ Exception -> 0x009a }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ Exception -> 0x009a }
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json"
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x009a }
            r1.add(r3)     // Catch:{ Exception -> 0x009a }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ Exception -> 0x009a }
            java.lang.String r4 = "charset"
            java.lang.String r5 = "utf-8"
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x009a }
            r1.add(r3)     // Catch:{ Exception -> 0x009a }
            java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> r3 = r2.f     // Catch:{ Exception -> 0x009a }
            r3.addAll(r1)     // Catch:{ Exception -> 0x009a }
            r1 = 0
            r2.e = r1     // Catch:{ Exception -> 0x009a }
            com.ironsource.a.a r3 = new com.ironsource.a.a     // Catch:{ Exception -> 0x009a }
            r3.<init>(r2)     // Catch:{ Exception -> 0x009a }
            boolean r2 = r3.b     // Catch:{ Exception -> 0x009a }
            if (r2 == 0) goto L_0x00b2
            com.ironsource.sdk.a.d$a r2 = new com.ironsource.sdk.a.d$a     // Catch:{ Exception -> 0x009a }
            r2.<init>()     // Catch:{ Exception -> 0x009a }
            if (r9 == 0) goto L_0x008b
            java.lang.String r4 = "sessionid"
            boolean r4 = r9.containsKey(r4)     // Catch:{ Exception -> 0x009a }
            if (r4 == 0) goto L_0x008b
            java.lang.String r4 = "sessionid"
            java.lang.Object r9 = r9.get(r4)     // Catch:{ Exception -> 0x009a }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x009a }
            r2.a = r9     // Catch:{ Exception -> 0x009a }
        L_0x008b:
            r2.c = r6     // Catch:{ Exception -> 0x009a }
            r2.d = r8     // Catch:{ Exception -> 0x009a }
            r2.b = r7     // Catch:{ Exception -> 0x009a }
            com.ironsource.sdk.a.d r9 = new com.ironsource.sdk.a.d     // Catch:{ Exception -> 0x009a }
            r9.<init>(r2, r1)     // Catch:{ Exception -> 0x009a }
            com.ironsource.sdk.a.f.a((com.ironsource.a.a) r3, (com.ironsource.sdk.a.d) r9)     // Catch:{ Exception -> 0x009a }
            goto L_0x00b2
        L_0x009a:
            r9 = move-exception
            java.lang.String r1 = "IronSourceNetwork"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = "Failed to init event tracker: "
            r2.<init>(r3)     // Catch:{ all -> 0x00bf }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00bf }
            r2.append(r9)     // Catch:{ all -> 0x00bf }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00bf }
            com.ironsource.sdk.utils.Logger.e(r1, r9)     // Catch:{ all -> 0x00bf }
        L_0x00b2:
            com.ironsource.sdk.e r6 = com.ironsource.sdk.d.b.a((java.lang.String) r7, (java.lang.String) r8, (android.content.Context) r6)     // Catch:{ all -> 0x00bf }
            a = r6     // Catch:{ all -> 0x00bf }
            org.json.JSONObject r6 = c     // Catch:{ all -> 0x00bf }
            applyConsentInfo(r6)     // Catch:{ all -> 0x00bf }
        L_0x00bd:
            monitor-exit(r0)
            return
        L_0x00bf:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.IronSourceNetwork.initSDK(android.content.Context, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static synchronized boolean isAdAvailableForInstance(b bVar) {
        synchronized (IronSourceNetwork.class) {
            e eVar = a;
            if (eVar == null) {
                return false;
            }
            boolean b2 = eVar.b(bVar);
            return b2;
        }
    }

    public static synchronized void loadAd(b bVar, Map<String, String> map) {
        synchronized (IronSourceNetwork.class) {
            a();
            a.a(bVar, map);
        }
    }

    public static synchronized void loadAdView(Activity activity, b bVar, Map<String, String> map) {
        synchronized (IronSourceNetwork.class) {
            a();
            a.a(activity, bVar, map);
        }
    }

    public static void onPause(Activity activity) {
        e eVar = a;
        if (eVar != null) {
            eVar.b(activity);
        }
    }

    public static void onResume(Activity activity) {
        e eVar = a;
        if (eVar != null) {
            eVar.c(activity);
        }
    }

    public static synchronized void release(Activity activity) {
        synchronized (IronSourceNetwork.class) {
            e eVar = a;
            if (eVar != null) {
                eVar.a(activity);
            }
        }
    }

    public static synchronized void setInitListener(d dVar) {
        synchronized (IronSourceNetwork.class) {
            b = dVar;
        }
    }

    public static synchronized void showAd(Activity activity, b bVar, Map<String, String> map) {
        synchronized (IronSourceNetwork.class) {
            a();
            a.b(activity, bVar, map);
        }
    }

    public static synchronized void showOfferWall(Activity activity, Map<String, String> map) {
        synchronized (IronSourceNetwork.class) {
            a();
            a.a(activity, map);
        }
    }

    public static synchronized void updateConsentInfo(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            c = jSONObject;
            applyConsentInfo(jSONObject);
        }
    }

    public static synchronized void updateMetadata(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            com.ironsource.sdk.service.d a2 = com.ironsource.sdk.service.d.a();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a2.a("metadata_" + next, jSONObject.opt(next));
            }
        }
    }
}
