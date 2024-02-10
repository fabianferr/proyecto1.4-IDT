package com.bytedance.sdk.openadsdk.h.a;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.x;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* compiled from: OldBridgeSyncMethod */
public class e extends com.bytedance.sdk.component.a.e<JSONObject, JSONObject> {
    private final String a;
    private final x b;

    public e(String str, x xVar) {
        this.b = xVar;
        this.a = str;
    }

    public static void a(r rVar, x xVar) {
        rVar.a("appInfo", (com.bytedance.sdk.component.a.e<?, ?>) new e("appInfo", xVar));
        rVar.a("adInfo", (com.bytedance.sdk.component.a.e<?, ?>) new e("adInfo", xVar));
        rVar.a("sendLog", (com.bytedance.sdk.component.a.e<?, ?>) new e("sendLog", xVar));
        rVar.a("playable_style", (com.bytedance.sdk.component.a.e<?, ?>) new e("playable_style", xVar));
        rVar.a("getTemplateInfo", (com.bytedance.sdk.component.a.e<?, ?>) new e("getTemplateInfo", xVar));
        rVar.a("getTeMaiAds", (com.bytedance.sdk.component.a.e<?, ?>) new e("getTeMaiAds", xVar));
        rVar.a("isViewable", (com.bytedance.sdk.component.a.e<?, ?>) new e("isViewable", xVar));
        rVar.a("getScreenSize", (com.bytedance.sdk.component.a.e<?, ?>) new e("getScreenSize", xVar));
        rVar.a("getCloseButtonInfo", (com.bytedance.sdk.component.a.e<?, ?>) new e("getCloseButtonInfo", xVar));
        rVar.a("getVolume", (com.bytedance.sdk.component.a.e<?, ?>) new e("getVolume", xVar));
        rVar.a("removeLoading", (com.bytedance.sdk.component.a.e<?, ?>) new e("removeLoading", xVar));
        rVar.a("sendReward", (com.bytedance.sdk.component.a.e<?, ?>) new e("sendReward", xVar));
        rVar.a("subscribe_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new e("subscribe_app_ad", xVar));
        rVar.a("download_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new e("download_app_ad", xVar));
        rVar.a("cancel_download_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new e("cancel_download_app_ad", xVar));
        rVar.a("unsubscribe_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new e("unsubscribe_app_ad", xVar));
        rVar.a("landscape_click", (com.bytedance.sdk.component.a.e<?, ?>) new e("landscape_click", xVar));
        rVar.a("clickEvent", (com.bytedance.sdk.component.a.e<?, ?>) new e("clickEvent", xVar));
        rVar.a("renderDidFinish", (com.bytedance.sdk.component.a.e<?, ?>) new e("renderDidFinish", xVar));
        rVar.a("dynamicTrack", (com.bytedance.sdk.component.a.e<?, ?>) new e("dynamicTrack", xVar));
        rVar.a("skipVideo", (com.bytedance.sdk.component.a.e<?, ?>) new e("skipVideo", xVar));
        rVar.a("muteVideo", (com.bytedance.sdk.component.a.e<?, ?>) new e("muteVideo", xVar));
        rVar.a("changeVideoState", (com.bytedance.sdk.component.a.e<?, ?>) new e("changeVideoState", xVar));
        rVar.a("getCurrentVideoState", (com.bytedance.sdk.component.a.e<?, ?>) new e("getCurrentVideoState", xVar));
        rVar.a("send_temai_product_ids", (com.bytedance.sdk.component.a.e<?, ?>) new e("send_temai_product_ids", xVar));
        rVar.a("getMaterialMeta", (com.bytedance.sdk.component.a.e<?, ?>) new e("getMaterialMeta", xVar));
        rVar.a("endcard_load", (com.bytedance.sdk.component.a.e<?, ?>) new e("endcard_load", xVar));
        rVar.a("pauseWebView", (com.bytedance.sdk.component.a.e<?, ?>) new e("pauseWebView", xVar));
        rVar.a("pauseWebViewTimers", (com.bytedance.sdk.component.a.e<?, ?>) new e("pauseWebViewTimers", xVar));
        rVar.a("webview_time_track", (com.bytedance.sdk.component.a.e<?, ?>) new e("webview_time_track", xVar));
        rVar.a("openPrivacy", (com.bytedance.sdk.component.a.e<?, ?>) new e("openPrivacy", xVar));
        rVar.a("openAdLandPageLinks", (com.bytedance.sdk.component.a.e<?, ?>) new e("openAdLandPageLinks", xVar));
        rVar.a("getNativeSiteCustomData", (com.bytedance.sdk.component.a.e<?, ?>) new e("getNativeSiteCustomData", xVar));
        rVar.a("close", (com.bytedance.sdk.component.a.e<?, ?>) new e("close", xVar));
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        while (true) {
            char c = '^';
            char c2 = AbstractJsonLexerKt.END_OBJ;
            while (true) {
                switch (c) {
                    case '^':
                        break;
                    case '_':
                        switch (c2) {
                            case '^':
                            case '`':
                                break;
                            case '_':
                                x.b bVar = new x.b();
                                bVar.a = NotificationCompat.CATEGORY_CALL;
                                bVar.c = this.a;
                                bVar.d = jSONObject;
                                return this.b.a(bVar, 3);
                        }
                    case '`':
                        switch (c2) {
                            case '7':
                            case '8':
                            case '9':
                                continue;
                        }
                }
                c2 = '_';
                c = '_';
            }
        }
    }
}
