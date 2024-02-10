package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.g.a.a.e;
import com.bytedance.sdk.openadsdk.core.g.a.b;
import com.bytedance.sdk.openadsdk.core.model.c;
import com.bytedance.sdk.openadsdk.core.model.d;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.s;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdInfoFactory */
public class b {
    private static int a(com.bykv.vk.openvk.component.video.api.c.b bVar, boolean z) {
        if (bVar == null) {
            return 413;
        }
        if (TextUtils.isEmpty(bVar.k())) {
            return 414;
        }
        return (z || !TextUtils.isEmpty(bVar.j())) ? 200 : 415;
    }

    private static int a(c cVar) {
        if (cVar == null) {
            return 407;
        }
        return TextUtils.isEmpty(cVar.a()) ? 408 : 200;
    }

    private static int a(j jVar) {
        if (jVar == null) {
            return 200;
        }
        if (TextUtils.isEmpty(jVar.a())) {
            return 403;
        }
        if (TextUtils.isEmpty(jVar.b())) {
            return 404;
        }
        return (jVar.c() == 1 || jVar.c() == 2) ? 200 : 405;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c1, code lost:
        if (r0 != 50) goto L_0x00dd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.bytedance.sdk.openadsdk.core.model.q r6) {
        /*
            r0 = 401(0x191, float:5.62E-43)
            if (r6 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r1 = r6.Y()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00de
            java.lang.String r1 = r6.Y()
            int r1 = r1.length()
            r2 = 1
            if (r1 > r2) goto L_0x001e
            goto L_0x00de
        L_0x001e:
            int r1 = r6.be()
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != 0) goto L_0x0031
            com.bytedance.sdk.openadsdk.core.model.j r1 = r6.ab()
            int r1 = a((com.bytedance.sdk.openadsdk.core.model.j) r1)
            if (r1 == r2) goto L_0x0033
            return r1
        L_0x0031:
            r1 = 200(0xc8, float:2.8E-43)
        L_0x0033:
            boolean r3 = r6.av()
            if (r3 == 0) goto L_0x0076
            int r3 = r6.aT()
            if (r3 >= 0) goto L_0x0052
            com.bytedance.sdk.openadsdk.AdSlot r3 = r6.D()
            if (r3 == 0) goto L_0x004e
            com.bytedance.sdk.openadsdk.AdSlot r3 = r6.D()
            int r3 = r3.getDurationSlotType()
            goto L_0x0052
        L_0x004e:
            int r3 = r6.aS()
        L_0x0052:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.utils.ac.c((int) r3)
            boolean r4 = r6.bd()
            if (r4 == 0) goto L_0x005e
            java.lang.String r3 = "fullscreen_interstitial_ad"
        L_0x005e:
            java.lang.String r4 = r6.aw()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 0
            if (r4 == 0) goto L_0x0071
            java.lang.String r1 = "load_html_fail"
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r6, (java.lang.String) r3, (java.lang.String) r1, (org.json.JSONObject) r5)
            return r0
        L_0x0071:
            java.lang.String r0 = "load_html_success"
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r6, (java.lang.String) r3, (java.lang.String) r0, (org.json.JSONObject) r5)
        L_0x0076:
            int r0 = r6.M()
            r3 = 4
            r4 = 3
            r5 = 2
            if (r0 == r5) goto L_0x008f
            if (r0 == r4) goto L_0x008f
            if (r0 == r3) goto L_0x0084
            goto L_0x00a4
        L_0x0084:
            com.bytedance.sdk.openadsdk.core.model.c r0 = r6.aa()
            int r1 = a((com.bytedance.sdk.openadsdk.core.model.c) r0)
            if (r1 == r2) goto L_0x00a4
            return r1
        L_0x008f:
            boolean r0 = b((com.bytedance.sdk.openadsdk.core.model.q) r6)
            if (r0 == 0) goto L_0x00a4
            java.lang.String r0 = r6.P()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00a4
            r6 = 406(0x196, float:5.69E-43)
            return r6
        L_0x00a4:
            boolean r0 = r6.at()
            if (r0 != 0) goto L_0x00dd
            int r0 = r6.ad()
            if (r0 == r5) goto L_0x00d3
            if (r0 == r4) goto L_0x00d3
            if (r0 == r3) goto L_0x00d3
            r3 = 5
            if (r0 == r3) goto L_0x00c4
            r3 = 15
            if (r0 == r3) goto L_0x00c4
            r3 = 16
            if (r0 == r3) goto L_0x00d3
            r3 = 50
            if (r0 == r3) goto L_0x00c4
            goto L_0x00dd
        L_0x00c4:
            com.bykv.vk.openvk.component.video.api.c.b r0 = r6.K()
            boolean r6 = r6.at()
            int r1 = a((com.bykv.vk.openvk.component.video.api.c.b) r0, (boolean) r6)
            if (r1 == r2) goto L_0x00dd
            return r1
        L_0x00d3:
            java.util.List r6 = r6.Q()
            int r1 = a((java.util.List<com.bytedance.sdk.openadsdk.core.model.n>) r6)
            if (r1 == r2) goto L_0x00dd
        L_0x00dd:
            return r1
        L_0x00de:
            r6 = 402(0x192, float:5.63E-43)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.a(com.bytedance.sdk.openadsdk.core.model.q):int");
    }

    private static int a(List<n> list) {
        if (list == null) {
            return 409;
        }
        if (list.size() <= 0) {
            return 410;
        }
        for (n next : list) {
            if (next == null) {
                return 411;
            }
            if (TextUtils.isEmpty(next.a())) {
                return 412;
            }
        }
        return 200;
    }

    private static Pair<a, b.a> a(String str, int i, int i2) {
        int i3;
        int i4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 == 1 || i2 == 5) {
            i3 = 0;
            i4 = 0;
        } else {
            i3 = ad.c(o.a());
            i4 = ad.d(o.a());
            if (i == 2) {
                int i5 = i4;
                i4 = i3;
                i3 = i5;
            }
        }
        e eVar = new e(o.a(), i3, i4);
        return new Pair<>(eVar.a(str, (List<com.bytedance.sdk.openadsdk.core.g.b.c>) new ArrayList()), eVar.f);
    }

    public static Pair<com.bytedance.sdk.openadsdk.core.model.a, ArrayList<Integer>> a(JSONObject jSONObject, AdSlot adSlot, s sVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.a aVar = new com.bytedance.sdk.openadsdk.core.model.a();
            aVar.a(jSONObject.optString("request_id"));
            aVar.a(jSONObject.optInt("ret"));
            aVar.b(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
            String optString = jSONObject.optString("gdid_encrypted");
            if (jSONObject.has("choose_ui_data")) {
                aVar.a(jSONObject.optJSONObject("choose_ui_data"));
                aVar.a(true);
            }
            String optString2 = jSONObject.optString("auction_price");
            if (aVar.b() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                while (i < optJSONArray.length()) {
                    q a = a(optJSONArray.optJSONObject(i), adSlot, sVar);
                    int a2 = a(a);
                    if (a2 != 200) {
                        arrayList.add(Integer.valueOf(a2));
                    } else {
                        a.i(optString2);
                        if (!TextUtils.isEmpty(optString)) {
                            a.y(optString);
                        }
                        aVar.a(a);
                    }
                    i++;
                }
                i = length;
            }
            a(i, aVar, (ArrayList<Integer>) arrayList, bVar);
            return new Pair<>(aVar, arrayList);
        } catch (Throwable th) {
            l.e("AdInfoFactory", th.getMessage());
            return null;
        }
    }

    private static com.bykv.vk.openvk.component.video.api.c.b a(JSONObject jSONObject, q qVar) {
        if (jSONObject == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.c.b bVar = new com.bykv.vk.openvk.component.video.api.c.b();
        bVar.b(jSONObject.optInt("cover_height"));
        bVar.c(jSONObject.optInt("cover_width"));
        bVar.a(jSONObject.optString("resolution"));
        bVar.a(jSONObject.optLong("size"));
        double optDouble = jSONObject.optDouble("video_duration", 0.0d);
        bVar.a(optDouble);
        int i = 1;
        int optInt = jSONObject.optInt("replay_time", 1);
        if (optDouble > 15.0d || qVar.u() == 1 || !q.c(qVar)) {
            optInt = 1;
        }
        bVar.j(optInt);
        bVar.b(jSONObject.optString("cover_url"));
        bVar.c(jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL));
        bVar.d(jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD));
        bVar.e(jSONObject.optString("playable_download_url"));
        bVar.f(jSONObject.optString("file_hash"));
        bVar.h(jSONObject.optInt("if_playable_loading_show", 0));
        bVar.i(jSONObject.optInt("remove_loading_page_type", 0));
        bVar.a(jSONObject.optInt("fallback_endcard_judge", 0));
        bVar.e(jSONObject.optInt("video_preload_size", 307200));
        bVar.f(jSONObject.optInt("reward_video_cached_type", 0));
        bVar.g(jSONObject.optInt("execute_cached_type", 0));
        if (jSONObject.optDouble("endcard_render", 0.0d) != 1.0d) {
            i = 0;
        }
        bVar.d(i);
        return bVar;
    }

    public static q a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return a(jSONObject, (AdSlot) null, (s) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0568, code lost:
        if (r13.optBoolean("is_html", false) != false) goto L_0x056c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x04b1  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x050c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0559  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0579  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0598  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x05a1  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x05d7  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x05dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x05dd  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x039a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x03d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.bytedance.sdk.openadsdk.core.model.q a(org.json.JSONObject r13, com.bytedance.sdk.openadsdk.AdSlot r14, com.bytedance.sdk.openadsdk.core.model.s r15) {
        /*
            r0 = 0
            if (r13 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.bytedance.sdk.openadsdk.core.model.q r7 = com.bytedance.sdk.openadsdk.core.model.q.b()
            java.lang.String r1 = "interaction_type"
            int r1 = r13.optInt(r1)
            r7.r((int) r1)
            java.lang.String r1 = "target_url"
            java.lang.String r1 = r13.optString(r1)
            r7.l((java.lang.String) r1)
            java.lang.String r1 = "ad_id"
            java.lang.String r1 = r13.optString(r1)
            r7.q((java.lang.String) r1)
            java.lang.String r1 = "app_log_url"
            java.lang.String r1 = r13.optString(r1)
            r7.r((java.lang.String) r1)
            java.lang.String r1 = "source"
            java.lang.String r1 = r13.optString(r1)
            r7.k((java.lang.String) r1)
            java.lang.String r1 = "dislike_control"
            r8 = 0
            int r1 = r13.optInt(r1, r8)
            r7.v((int) r1)
            java.lang.String r1 = "play_bar_show_time"
            r2 = -200(0xffffffffffffff38, float:NaN)
            int r1 = r13.optInt(r1, r2)
            r7.m((int) r1)
            java.lang.String r1 = "gecko_id"
            java.lang.String r1 = r13.optString(r1)
            r7.t((java.lang.String) r1)
            java.lang.String r1 = "set_click_type"
            boolean r2 = r13.has(r1)
            if (r2 == 0) goto L_0x0075
            org.json.JSONObject r1 = r13.optJSONObject(r1)
            java.lang.String r2 = "cta"
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = r1.optDouble(r2, r3)
            r7.b((double) r2)
            java.lang.String r2 = "other"
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r1 = r1.optDouble(r2, r3)
            r7.a((double) r1)
        L_0x0075:
            java.lang.String r1 = "extension"
            org.json.JSONObject r1 = r13.optJSONObject(r1)
            r7.d((org.json.JSONObject) r1)
            java.lang.String r1 = "icon"
            org.json.JSONObject r1 = r13.optJSONObject(r1)
            java.lang.String r2 = "screenshot"
            boolean r2 = r13.optBoolean(r2, r8)
            r7.d((boolean) r2)
            java.lang.String r2 = "play_bar_style"
            int r2 = r13.optInt(r2, r8)
            r7.k((int) r2)
            java.lang.String r2 = "market_url"
            java.lang.String r9 = ""
            java.lang.String r2 = r13.optString(r2, r9)
            r7.u((java.lang.String) r2)
            java.lang.String r2 = "video_adaptation"
            int r2 = r13.optInt(r2, r8)
            r7.i((int) r2)
            java.lang.String r2 = "feed_video_opentype"
            int r2 = r13.optInt(r2, r8)
            r7.f((int) r2)
            java.lang.String r2 = "session_params"
            org.json.JSONObject r2 = r13.optJSONObject(r2)
            r7.b((org.json.JSONObject) r2)
            java.lang.String r2 = "auction_price"
            java.lang.String r2 = r13.optString(r2, r9)
            r7.i((java.lang.String) r2)
            java.lang.String r2 = "mrc_report"
            int r2 = r13.optInt(r2, r8)
            r7.A(r2)
            java.lang.String r2 = "isMrcReportFinish"
            boolean r2 = r13.optBoolean(r2, r8)
            if (r2 == 0) goto L_0x00d9
            r7.aA()
        L_0x00d9:
            java.lang.String r2 = "render"
            org.json.JSONObject r2 = r13.optJSONObject(r2)
            r10 = 100
            r11 = 1
            if (r2 == 0) goto L_0x0108
            java.lang.String r3 = "render_sequence"
            int r3 = r2.optInt(r3, r8)
            r7.g((int) r3)
            java.lang.String r3 = "backup_render_control"
            int r3 = r2.optInt(r3, r11)
            r7.h((int) r3)
            java.lang.String r3 = "reserve_time"
            int r3 = r2.optInt(r3, r10)
            r7.B(r3)
            java.lang.String r3 = "render_thread"
            int r2 = r2.optInt(r3, r8)
            r7.C(r2)
        L_0x0108:
            if (r15 == 0) goto L_0x010d
            int r15 = r15.f
            goto L_0x010e
        L_0x010d:
            r15 = 1
        L_0x010e:
            java.lang.String r2 = "render_control"
            int r15 = r13.optInt(r2, r15)
            r7.d((int) r15)
            java.lang.String r15 = "width"
            java.lang.String r2 = "height"
            java.lang.String r3 = "url"
            if (r1 == 0) goto L_0x013c
            com.bytedance.sdk.openadsdk.core.model.n r4 = new com.bytedance.sdk.openadsdk.core.model.n
            r4.<init>()
            java.lang.String r5 = r1.optString(r3)
            r4.a((java.lang.String) r5)
            int r5 = r1.optInt(r2)
            r4.b((int) r5)
            int r1 = r1.optInt(r15)
            r4.a((int) r1)
            r7.a((com.bytedance.sdk.openadsdk.core.model.n) r4)
        L_0x013c:
            java.lang.String r1 = "reward_data"
            org.json.JSONObject r1 = r13.optJSONObject(r1)
            if (r1 == 0) goto L_0x0156
            java.lang.String r4 = "reward_amount"
            int r4 = r1.optInt(r4, r8)
            r7.c((int) r4)
            java.lang.String r4 = "reward_name"
            java.lang.String r1 = r1.optString(r4, r9)
            r7.g((java.lang.String) r1)
        L_0x0156:
            java.lang.String r1 = "cover_image"
            org.json.JSONObject r1 = r13.optJSONObject(r1)
            if (r1 == 0) goto L_0x017b
            com.bytedance.sdk.openadsdk.core.model.n r4 = new com.bytedance.sdk.openadsdk.core.model.n
            r4.<init>()
            java.lang.String r5 = r1.optString(r3)
            r4.a((java.lang.String) r5)
            int r5 = r1.optInt(r2)
            r4.b((int) r5)
            int r1 = r1.optInt(r15)
            r4.a((int) r1)
            r7.b((com.bytedance.sdk.openadsdk.core.model.n) r4)
        L_0x017b:
            java.lang.String r1 = "image"
            org.json.JSONArray r1 = r13.optJSONArray(r1)
            if (r1 == 0) goto L_0x01c0
            r4 = 0
        L_0x0184:
            int r5 = r1.length()
            if (r4 >= r5) goto L_0x01c0
            com.bytedance.sdk.openadsdk.core.model.n r5 = new com.bytedance.sdk.openadsdk.core.model.n
            r5.<init>()
            org.json.JSONObject r6 = r1.optJSONObject(r4)
            java.lang.String r12 = r6.optString(r3)
            r5.a((java.lang.String) r12)
            int r12 = r6.optInt(r2)
            r5.b((int) r12)
            int r12 = r6.optInt(r15)
            r5.a((int) r12)
            java.lang.String r12 = "image_preview"
            boolean r12 = r6.optBoolean(r12)
            r5.a((boolean) r12)
            java.lang.String r12 = "image_key"
            java.lang.String r6 = r6.optString(r12)
            r5.b((java.lang.String) r6)
            r7.c((com.bytedance.sdk.openadsdk.core.model.n) r5)
            int r4 = r4 + 1
            goto L_0x0184
        L_0x01c0:
            java.lang.String r15 = "show_url"
            org.json.JSONArray r15 = r13.optJSONArray(r15)
            if (r15 == 0) goto L_0x01dd
            r1 = 0
        L_0x01c9:
            int r2 = r15.length()
            if (r1 >= r2) goto L_0x01dd
            java.util.List r2 = r7.S()
            java.lang.String r4 = r15.optString(r1)
            r2.add(r4)
            int r1 = r1 + 1
            goto L_0x01c9
        L_0x01dd:
            java.lang.String r15 = "click_url"
            org.json.JSONArray r15 = r13.optJSONArray(r15)
            if (r15 == 0) goto L_0x01fa
            r1 = 0
        L_0x01e6:
            int r2 = r15.length()
            if (r1 >= r2) goto L_0x01fa
            java.util.List r2 = r7.T()
            java.lang.String r4 = r15.optString(r1)
            r2.add(r4)
            int r1 = r1 + 1
            goto L_0x01e6
        L_0x01fa:
            java.lang.String r15 = "play_start"
            org.json.JSONArray r15 = r13.optJSONArray(r15)
            if (r15 == 0) goto L_0x0217
            r1 = 0
        L_0x0203:
            int r2 = r15.length()
            if (r1 >= r2) goto L_0x0217
            java.util.List r2 = r7.U()
            java.lang.String r4 = r15.optString(r1)
            r2.add(r4)
            int r1 = r1 + 1
            goto L_0x0203
        L_0x0217:
            java.lang.String r15 = "click_area"
            org.json.JSONObject r15 = r13.optJSONObject(r15)
            if (r15 == 0) goto L_0x0257
            com.bytedance.sdk.openadsdk.core.model.h r1 = new com.bytedance.sdk.openadsdk.core.model.h
            r1.<init>()
            java.lang.String r2 = "click_upper_content_area"
            boolean r2 = r15.optBoolean(r2, r11)
            r1.a = r2
            java.lang.String r2 = "click_upper_non_content_area"
            boolean r2 = r15.optBoolean(r2, r11)
            r1.b = r2
            java.lang.String r2 = "click_lower_content_area"
            boolean r2 = r15.optBoolean(r2, r11)
            r1.c = r2
            java.lang.String r2 = "click_lower_non_content_area"
            boolean r2 = r15.optBoolean(r2, r11)
            r1.d = r2
            java.lang.String r2 = "click_button_area"
            boolean r2 = r15.optBoolean(r2, r11)
            r1.e = r2
            java.lang.String r2 = "click_video_area"
            boolean r15 = r15.optBoolean(r2, r11)
            r1.f = r15
            r7.a((com.bytedance.sdk.openadsdk.core.model.h) r1)
        L_0x0257:
            java.lang.String r15 = "adslot"
            org.json.JSONObject r15 = r13.optJSONObject(r15)
            if (r15 == 0) goto L_0x0267
            com.bytedance.sdk.openadsdk.AdSlot r15 = c(r15)
            r7.a((com.bytedance.sdk.openadsdk.AdSlot) r15)
            goto L_0x026a
        L_0x0267:
            r7.a((com.bytedance.sdk.openadsdk.AdSlot) r14)
        L_0x026a:
            if (r14 == 0) goto L_0x0283
            java.util.Map r14 = r14.getRequestExtraMap()
            if (r14 == 0) goto L_0x028c
            java.lang.String r15 = "admob_watermark"
            boolean r1 = r14.containsKey(r15)
            if (r1 == 0) goto L_0x028c
            java.lang.Object r14 = r14.get(r15)
            java.lang.String r14 = java.lang.String.valueOf(r14)
            goto L_0x0289
        L_0x0283:
            java.lang.String r14 = "identificationOverlayContent"
            java.lang.String r14 = r13.optString(r14)
        L_0x0289:
            r7.z((java.lang.String) r14)
        L_0x028c:
            java.lang.String r14 = "intercept_flag"
            int r14 = r13.optInt(r14, r8)
            r7.l((int) r14)
            java.lang.String r14 = "phone_num"
            java.lang.String r14 = r13.optString(r14)
            r7.m((java.lang.String) r14)
            java.lang.String r14 = "title"
            java.lang.String r14 = r13.optString(r14)
            r7.n((java.lang.String) r14)
            java.lang.String r14 = "description"
            java.lang.String r14 = r13.optString(r14)
            r7.o((java.lang.String) r14)
            java.lang.String r14 = "button_text"
            java.lang.String r14 = r13.optString(r14)
            r7.p((java.lang.String) r14)
            java.lang.String r14 = "ad_logo"
            int r14 = r13.optInt(r14, r11)
            r7.j((int) r14)
            java.lang.String r14 = "ext"
            java.lang.String r14 = r13.optString(r14)
            r7.s((java.lang.String) r14)
            java.lang.String r14 = "cover_click_area"
            int r15 = r13.optInt(r14, r8)
            r7.p((int) r15)
            java.lang.String r15 = "image_mode"
            int r15 = r13.optInt(r15)
            r7.s((int) r15)
            java.lang.String r15 = "orientation"
            int r15 = r13.optInt(r15, r11)
            r7.u((int) r15)
            java.lang.String r15 = "aspect_ratio"
            r1 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r1 = r13.optDouble(r15, r1)
            float r15 = (float) r1
            r7.a((float) r15)
            int r14 = r13.optInt(r14, r8)
            r7.p((int) r14)
            java.lang.String r14 = "app"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            java.lang.String r15 = "deep_link"
            org.json.JSONObject r15 = r13.optJSONObject(r15)
            com.bytedance.sdk.openadsdk.core.model.c r14 = e(r14)
            r7.a((com.bytedance.sdk.openadsdk.core.model.c) r14)
            java.lang.String r14 = "interaction_method_params"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            com.bytedance.sdk.openadsdk.core.model.p r14 = f(r14)
            r7.a((com.bytedance.sdk.openadsdk.core.model.p) r14)
            com.bytedance.sdk.openadsdk.core.model.j r14 = h(r15)
            r7.a((com.bytedance.sdk.openadsdk.core.model.j) r14)
            com.bytedance.sdk.openadsdk.core.model.t r14 = new com.bytedance.sdk.openadsdk.core.model.t
            r14.<init>(r13)
            r7.a((com.bytedance.sdk.openadsdk.core.model.t) r14)
            java.lang.String r14 = "filter_words"
            org.json.JSONArray r14 = r13.optJSONArray(r14)
            if (r14 == 0) goto L_0x034d
            r15 = 0
        L_0x0331:
            int r1 = r14.length()
            if (r15 >= r1) goto L_0x034d
            org.json.JSONObject r1 = r14.optJSONObject(r15)
            com.bytedance.sdk.openadsdk.FilterWord r1 = d(r1)
            if (r1 == 0) goto L_0x034a
            boolean r2 = r1.isValid()
            if (r2 == 0) goto L_0x034a
            r7.a((com.bytedance.sdk.openadsdk.FilterWord) r1)
        L_0x034a:
            int r15 = r15 + 1
            goto L_0x0331
        L_0x034d:
            java.lang.String r14 = "count_down"
            int r14 = r13.optInt(r14)
            r7.t((int) r14)
            java.lang.String r14 = "expiration_time"
            long r14 = r13.optLong(r14)
            r7.b((long) r14)
            java.lang.String r14 = "video_encode_type"
            int r14 = r13.optInt(r14, r8)
            r7.G(r14)
            r7.F(r8)
            java.lang.String r14 = "video"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            if (r14 == 0) goto L_0x037b
            com.bykv.vk.openvk.component.video.api.c.b r14 = a((org.json.JSONObject) r14, (com.bytedance.sdk.openadsdk.core.model.q) r7)
            r7.b((com.bykv.vk.openvk.component.video.api.c.b) r14)
            goto L_0x037c
        L_0x037b:
            r14 = r0
        L_0x037c:
            java.lang.String r15 = "h265_video"
            org.json.JSONObject r15 = r13.optJSONObject(r15)
            if (r15 == 0) goto L_0x038c
            com.bykv.vk.openvk.component.video.api.c.b r15 = a((org.json.JSONObject) r15, (com.bytedance.sdk.openadsdk.core.model.q) r7)
            r7.c((com.bykv.vk.openvk.component.video.api.c.b) r15)
            goto L_0x038d
        L_0x038c:
            r15 = r0
        L_0x038d:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x03d5
            int r1 = r7.aL()
            if (r1 != 0) goto L_0x039a
            goto L_0x03d5
        L_0x039a:
            if (r15 == 0) goto L_0x03cb
            if (r14 == 0) goto L_0x03cb
            java.lang.String r1 = r15.l()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x03b1
            java.lang.String r1 = r14.l()
            r15.d((java.lang.String) r1)
        L_0x03b1:
            java.lang.String r1 = r15.m()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x03c4
            java.lang.String r1 = r14.m()
            r15.e((java.lang.String) r1)
        L_0x03c4:
            int r1 = r14.d()
            r15.d((int) r1)
        L_0x03cb:
            if (r15 == 0) goto L_0x03d1
            r7.a((com.bykv.vk.openvk.component.video.api.c.b) r15)
            goto L_0x03db
        L_0x03d1:
            r7.a((com.bykv.vk.openvk.component.video.api.c.b) r14)
            goto L_0x03db
        L_0x03d5:
            r7.a((com.bykv.vk.openvk.component.video.api.c.b) r14)
            r7.G(r8)
        L_0x03db:
            java.lang.String r14 = "download_conf"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            if (r14 == 0) goto L_0x03ea
            com.bytedance.sdk.openadsdk.core.model.k r14 = g(r14)
            r7.a((com.bytedance.sdk.openadsdk.core.model.k) r14)
        L_0x03ea:
            java.lang.String r14 = "media_ext"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            java.util.Map r14 = i(r14)
            r7.a((java.util.Map<java.lang.String, java.lang.Object>) r14)
            java.lang.String r14 = "tpl_info"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            if (r14 == 0) goto L_0x0485
            com.bytedance.sdk.openadsdk.core.model.q$a r15 = new com.bytedance.sdk.openadsdk.core.model.q$a
            r15.<init>()
            java.lang.String r1 = "id"
            java.lang.String r1 = r14.optString(r1)
            r15.b(r1)
            java.lang.String r1 = "md5"
            java.lang.String r1 = r14.optString(r1)
            r15.c(r1)
            java.lang.String r1 = r14.optString(r3)
            r15.d(r1)
            java.lang.String r1 = "data"
            java.lang.String r1 = r14.optString(r1)
            r15.e(r1)
            java.lang.String r1 = "diff_data"
            java.lang.String r1 = r14.optString(r1)
            r15.f(r1)
            java.lang.String r1 = "dynamic_creative"
            java.lang.String r1 = r14.optString(r1)
            r15.g(r1)
            java.lang.String r2 = "version"
            java.lang.String r2 = r14.optString(r2)
            r15.a((java.lang.String) r2)
            java.lang.String r2 = "media_view"
            java.lang.String r14 = r14.optString(r2)
            r15.h(r14)
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0475 }
            r14.<init>()     // Catch:{ JSONException -> 0x0475 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0475 }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0475 }
            java.lang.String r1 = "tag_ids"
            org.json.JSONArray r1 = r2.optJSONArray(r1)     // Catch:{ JSONException -> 0x0475 }
            if (r1 == 0) goto L_0x0471
            r2 = 0
        L_0x045d:
            int r3 = r1.length()     // Catch:{ JSONException -> 0x0475 }
            if (r2 >= r3) goto L_0x0471
            int r3 = r1.optInt(r2)     // Catch:{ JSONException -> 0x0475 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x0475 }
            r14.add(r3)     // Catch:{ JSONException -> 0x0475 }
            int r2 = r2 + 1
            goto L_0x045d
        L_0x0471:
            r15.a((java.util.List<java.lang.Integer>) r14)     // Catch:{ JSONException -> 0x0475 }
            goto L_0x0482
        L_0x0475:
            r14 = move-exception
            r1 = r14
            org.json.JSONException r1 = (org.json.JSONException) r1
            java.lang.String r14 = r14.getMessage()
            java.lang.String r1 = "AdInfoFactory"
            com.bytedance.sdk.component.utils.l.e(r1, r14)
        L_0x0482:
            r7.a((com.bytedance.sdk.openadsdk.core.model.q.a) r15)
        L_0x0485:
            java.lang.String r14 = "creative_extra"
            java.lang.String r14 = r13.optString(r14)
            r7.j((java.lang.String) r14)
            java.lang.String r14 = "if_block_lp"
            int r14 = r13.optInt(r14, r8)
            r7.e((int) r14)
            java.lang.String r14 = "cache_sort"
            int r14 = r13.optInt(r14, r11)
            r7.n((int) r14)
            java.lang.String r14 = "if_sp_cache"
            int r14 = r13.optInt(r14, r8)
            r7.o((int) r14)
            java.lang.String r14 = "splash_control"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            if (r14 == 0) goto L_0x04b8
            com.bytedance.sdk.openadsdk.core.model.d r14 = b((org.json.JSONObject) r14)
            r7.a((com.bytedance.sdk.openadsdk.core.model.d) r14)
        L_0x04b8:
            java.lang.String r14 = "is_package_open"
            int r14 = r13.optInt(r14, r11)
            r7.w((int) r14)
            java.lang.String r14 = "ad_info"
            java.lang.String r14 = r13.optString(r14, r0)
            r7.h((java.lang.String) r14)
            java.lang.String r14 = "ua_policy"
            r15 = 2
            int r14 = r13.optInt(r14, r15)
            r7.q((int) r14)
            java.lang.String r14 = "playable_duration_time"
            r1 = 20
            int r14 = r13.optInt(r14, r1)
            r7.x((int) r14)
            java.lang.String r14 = "playable_endcard_close_time"
            r1 = -1
            int r14 = r13.optInt(r14, r1)
            r7.y((int) r14)
            java.lang.String r14 = "endcard_close_time"
            int r14 = r13.optInt(r14, r1)
            r7.z((int) r14)
            java.lang.String r14 = "interaction_method"
            int r14 = r13.optInt(r14)
            r7.a((int) r14)
            java.lang.String r14 = "dsp_html"
            java.lang.String r14 = r13.optString(r14)
            r7.v((java.lang.String) r14)
            java.lang.String r14 = "loading_page"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            if (r14 == 0) goto L_0x054b
            java.lang.String r1 = "loading_landingpage_type"
            int r1 = r14.optInt(r1, r8)
            r7.D(r1)
            java.lang.String r1 = "landingpage_text"
            org.json.JSONArray r14 = r14.optJSONArray(r1)
            if (r14 == 0) goto L_0x054b
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
        L_0x0523:
            int r3 = r14.length()
            if (r2 >= r3) goto L_0x053c
            java.lang.String r3 = r14.optString(r2)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0539
            r1.add(r3)
        L_0x0539:
            int r2 = r2 + 1
            goto L_0x0523
        L_0x053c:
            int r14 = r1.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            java.lang.Object[] r14 = r1.toArray(r14)
            java.lang.String[] r14 = (java.lang.String[]) r14
            r7.a((java.lang.String[]) r14)
        L_0x054b:
            java.lang.String r14 = "dsp_material_type"
            int r14 = r13.optInt(r14, r8)
            r1 = 3
            if (r14 < 0) goto L_0x0556
            if (r14 <= r1) goto L_0x0557
        L_0x0556:
            r14 = 0
        L_0x0557:
            if (r14 != 0) goto L_0x056b
            java.lang.String r2 = "is_vast"
            boolean r2 = r13.optBoolean(r2, r8)
            if (r2 == 0) goto L_0x0562
            r14 = 1
        L_0x0562:
            java.lang.String r2 = "is_html"
            boolean r2 = r13.optBoolean(r2, r8)
            if (r2 == 0) goto L_0x056b
            goto L_0x056c
        L_0x056b:
            r15 = r14
        L_0x056c:
            r7.I(r15)
            if (r15 == r11) goto L_0x0573
            if (r15 != r1) goto L_0x05e0
        L_0x0573:
            int r14 = r7.aT()
            if (r14 >= 0) goto L_0x058c
            com.bytedance.sdk.openadsdk.AdSlot r14 = r7.D()
            if (r14 == 0) goto L_0x0588
            com.bytedance.sdk.openadsdk.AdSlot r14 = r7.D()
            int r14 = r14.getDurationSlotType()
            goto L_0x058c
        L_0x0588:
            int r14 = r7.aS()
        L_0x058c:
            java.lang.String r15 = com.bytedance.sdk.openadsdk.utils.ac.c((int) r14)
            java.lang.String r1 = "vast_json"
            boolean r2 = r13.has(r1)
            if (r2 == 0) goto L_0x05a1
            org.json.JSONObject r14 = r13.optJSONObject(r1)
            com.bytedance.sdk.openadsdk.core.g.a r14 = com.bytedance.sdk.openadsdk.core.g.a.a((org.json.JSONObject) r14)
            goto L_0x05d5
        L_0x05a1:
            java.lang.String r1 = "dsp_vast"
            java.lang.String r1 = r13.optString(r1)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x05b4
            a((com.bytedance.sdk.openadsdk.core.model.q) r7, (java.lang.String) r15)
            return r0
        L_0x05b4:
            long r4 = java.lang.System.currentTimeMillis()
            int r2 = r7.ak()
            android.util.Pair r14 = a((java.lang.String) r1, (int) r2, (int) r14)
            if (r14 == 0) goto L_0x05cd
            java.lang.Object r1 = r14.first
            com.bytedance.sdk.openadsdk.core.g.a r1 = (com.bytedance.sdk.openadsdk.core.g.a) r1
            java.lang.Object r14 = r14.second
            com.bytedance.sdk.openadsdk.core.g.a.b$a r14 = (com.bytedance.sdk.openadsdk.core.g.a.b.a) r14
            r6 = r14
            r14 = r1
            goto L_0x05cf
        L_0x05cd:
            r14 = r0
            r6 = r14
        L_0x05cf:
            r1 = r7
            r2 = r15
            r3 = r14
            a(r1, r2, r3, r4, r6)
        L_0x05d5:
            if (r14 == 0) goto L_0x05da
            r14.f(r15)
        L_0x05da:
            if (r14 != 0) goto L_0x05dd
            return r0
        L_0x05dd:
            a((com.bytedance.sdk.openadsdk.core.g.a) r14, (com.bytedance.sdk.openadsdk.core.model.q) r7)
        L_0x05e0:
            java.lang.String r14 = "deep_link_appname"
            java.lang.String r14 = r13.optString(r14, r9)
            r7.w((java.lang.String) r14)
            java.lang.String r14 = "landing_page_download_clicktype"
            int r14 = r13.optInt(r14, r11)
            r7.H(r14)
            java.lang.String r14 = "dsp_style"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            if (r14 == 0) goto L_0x0602
            com.bytedance.sdk.openadsdk.core.model.l r15 = new com.bytedance.sdk.openadsdk.core.model.l
            r15.<init>(r14)
            r7.a((com.bytedance.sdk.openadsdk.core.model.l) r15)
        L_0x0602:
            java.lang.String r14 = "dsp_adchoices"
            org.json.JSONObject r14 = r13.optJSONObject(r14)
            if (r14 == 0) goto L_0x061c
            java.lang.String r15 = "adchoices_icon"
            java.lang.String r15 = r14.optString(r15, r9)
            r7.e((java.lang.String) r15)
            java.lang.String r15 = "adchoices_url"
            java.lang.String r14 = r14.optString(r15, r9)
            r7.f((java.lang.String) r14)
        L_0x061c:
            java.lang.String r14 = "gdid_encrypted"
            java.lang.String r14 = r13.optString(r14)
            r15 = r14
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x062e
            r7.y((java.lang.String) r14)
        L_0x062e:
            java.lang.String r14 = "jump_probability"
            int r13 = r13.optInt(r14, r8)
            if (r13 < 0) goto L_0x063a
            if (r13 <= r10) goto L_0x0639
            goto L_0x063a
        L_0x0639:
            r8 = r13
        L_0x063a:
            r7.J(r8)
            r7.bt()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.a(org.json.JSONObject, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.s):com.bytedance.sdk.openadsdk.core.model.q");
    }

    private static void a(int i, com.bytedance.sdk.openadsdk.core.model.a aVar, ArrayList<Integer> arrayList, com.bytedance.sdk.openadsdk.core.model.b bVar) {
        if (aVar != null && i >= 2) {
            final int size = i - (aVar.c() != null ? aVar.c().size() : 0);
            final boolean z = aVar.g() && aVar.h() == null;
            if (size > 0 || z) {
                com.bytedance.sdk.openadsdk.j.b.a();
                final com.bytedance.sdk.openadsdk.core.model.a aVar2 = aVar;
                final ArrayList<Integer> arrayList2 = arrayList;
                final com.bytedance.sdk.openadsdk.core.model.b bVar2 = bVar;
                com.bytedance.sdk.openadsdk.j.b.a("choose_ad_parsing_error", false, (com.bytedance.sdk.openadsdk.j.a) new com.bytedance.sdk.openadsdk.j.a() {
                    public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("req_id", aVar2.a());
                        jSONObject.put("material_error", size);
                        jSONObject.put("choose_ui_error", z ? 1 : 0);
                        ArrayList arrayList = arrayList2;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            jSONObject.put("mate_unavailable_code_list", new JSONArray(arrayList2).toString());
                        }
                        com.bytedance.sdk.openadsdk.core.model.b bVar = bVar2;
                        if (bVar != null) {
                            jSONObject.put("server_res_str", bVar.a());
                        }
                        return com.bytedance.sdk.openadsdk.j.a.b.b().a("choose_ad_parsing_error").b(jSONObject.toString());
                    }
                });
            }
        }
    }

    private static void a(a aVar, q qVar) {
        aVar.a(qVar);
        int M = qVar.M();
        if (!(M == 2 || M == 3)) {
            qVar.r(2);
        }
        qVar.d(1);
        qVar.a(aVar);
        if (!TextUtils.isEmpty(aVar.d())) {
            qVar.n(aVar.d());
        }
        if (!TextUtils.isEmpty(aVar.e())) {
            qVar.o(aVar.e());
        }
        qVar.l(aVar.f());
        qVar.a((c) null);
        com.bykv.vk.openvk.component.video.api.c.b K = qVar.K();
        if (K == null) {
            K = new com.bykv.vk.openvk.component.video.api.c.b();
        }
        K.c(aVar.g());
        K.a(aVar.h());
        K.f((String) null);
        K.b((String) null);
        K.d((String) null);
        qVar.a(K);
        if (aVar.b() != null && !TextUtils.isEmpty(aVar.b().e())) {
            n nVar = new n();
            nVar.a(aVar.b().e());
            nVar.a(aVar.b().b());
            nVar.b(aVar.b().c());
            qVar.a(nVar);
        } else if (qVar.N() == null) {
            n nVar2 = new n();
            nVar2.a("https://sf16-fe-tos-sg.i18n-pglstatp.com/obj/ad-pattern-sg/static/images/2023620white.jpeg");
            nVar2.a(98);
            nVar2.b(98);
            qVar.a(nVar2);
        }
    }

    private static void a(q qVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason_code", -1);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1);
            com.bytedance.sdk.openadsdk.b.c.b(qVar, str, "load_vast_fail", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static void a(q qVar, String str, a aVar, long j, b.a aVar2) {
        final a aVar3 = aVar;
        final long j2 = j;
        final b.a aVar4 = aVar2;
        final q qVar2 = qVar;
        final String str2 = str;
        com.bytedance.sdk.openadsdk.b.c.a((h) new h("vast_parser") {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x009c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r9 = this;
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ab }
                    r0.<init>()     // Catch:{ Exception -> 0x00ab }
                    com.bytedance.sdk.openadsdk.core.g.a r1 = r2     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r2 = "reason_code"
                    java.lang.String r3 = "load_vast_fail"
                    java.lang.String r4 = "error_code"
                    if (r1 == 0) goto L_0x005d
                    java.lang.String r1 = r1.i()     // Catch:{ Exception -> 0x00ab }
                    boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00ab }
                    if (r1 != 0) goto L_0x0055
                    com.bytedance.sdk.openadsdk.core.g.a r1 = r2     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r1 = r1.f()     // Catch:{ Exception -> 0x00ab }
                    boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00ab }
                    if (r1 != 0) goto L_0x0055
                    com.bytedance.sdk.openadsdk.core.g.a r1 = r2     // Catch:{ Exception -> 0x00ab }
                    double r5 = r1.h()     // Catch:{ Exception -> 0x00ab }
                    r7 = 0
                    int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r1 > 0) goto L_0x0032
                    goto L_0x0055
                L_0x0032:
                    java.lang.String r1 = "duration"
                    long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ab }
                    long r5 = r3     // Catch:{ Exception -> 0x00ab }
                    long r2 = r2 - r5
                    r0.put(r1, r2)     // Catch:{ Exception -> 0x00ab }
                    com.bytedance.sdk.openadsdk.core.g.a.b$a r1 = r5     // Catch:{ Exception -> 0x00ab }
                    if (r1 == 0) goto L_0x0052
                    java.lang.String r2 = "wrapper_count"
                    int r1 = r1.b     // Catch:{ Exception -> 0x00ab }
                    r0.put(r2, r1)     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r1 = "impression_links_null"
                    com.bytedance.sdk.openadsdk.core.g.a.b$a r2 = r5     // Catch:{ Exception -> 0x00ab }
                    boolean r2 = r2.c     // Catch:{ Exception -> 0x00ab }
                    r0.put(r1, r2)     // Catch:{ Exception -> 0x00ab }
                L_0x0052:
                    java.lang.String r3 = "load_vast_success"
                    goto L_0x006a
                L_0x0055:
                    r1 = -3
                    r0.put(r2, r1)     // Catch:{ Exception -> 0x00ab }
                    r0.put(r4, r1)     // Catch:{ Exception -> 0x00ab }
                    goto L_0x006a
                L_0x005d:
                    r1 = -2
                    r0.put(r2, r1)     // Catch:{ Exception -> 0x00ab }
                    com.bytedance.sdk.openadsdk.core.g.a.b$a r1 = r5     // Catch:{ Exception -> 0x00ab }
                    if (r1 == 0) goto L_0x006a
                    int r1 = r1.a     // Catch:{ Exception -> 0x00ab }
                    r0.put(r4, r1)     // Catch:{ Exception -> 0x00ab }
                L_0x006a:
                    com.bytedance.sdk.openadsdk.core.model.q r1 = r6     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r2 = r7     // Catch:{ Exception -> 0x00ab }
                    com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r1, (java.lang.String) r2, (java.lang.String) r3, (org.json.JSONObject) r0)     // Catch:{ Exception -> 0x00ab }
                    com.bytedance.sdk.openadsdk.core.g.a r0 = r2     // Catch:{ Exception -> 0x00ab }
                    if (r0 == 0) goto L_0x00ab
                    com.bytedance.sdk.openadsdk.core.g.b r0 = r0.b()     // Catch:{ Exception -> 0x00ab }
                    if (r0 == 0) goto L_0x00ab
                    com.bytedance.sdk.openadsdk.core.g.a r0 = r2     // Catch:{ Exception -> 0x00ab }
                    com.bytedance.sdk.openadsdk.core.g.b r0 = r0.b()     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r0 = r0.f()     // Catch:{ Exception -> 0x00ab }
                    boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ab }
                    if (r0 == 0) goto L_0x00ab
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ab }
                    r0.<init>()     // Catch:{ Exception -> 0x00ab }
                    r1 = 1000(0x3e8, float:1.401E-42)
                    r0.put(r4, r1)     // Catch:{ all -> 0x009c }
                    java.lang.String r1 = "description"
                    java.lang.String r2 = "1000:Image url is null"
                    r0.put(r1, r2)     // Catch:{ all -> 0x009c }
                L_0x009c:
                    com.bytedance.sdk.openadsdk.core.model.q r1 = r6     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r2 = r7     // Catch:{ Exception -> 0x00ab }
                    java.lang.String r3 = "load_vast_icon_fail"
                    com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r1, (java.lang.String) r2, (java.lang.String) r3, (org.json.JSONObject) r0)     // Catch:{ Exception -> 0x00ab }
                    com.bytedance.sdk.openadsdk.core.g.a r0 = r2     // Catch:{ Exception -> 0x00ab }
                    r1 = 0
                    r0.a((com.bytedance.sdk.openadsdk.core.g.b) r1)     // Catch:{ Exception -> 0x00ab }
                L_0x00ab:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.AnonymousClass2.run():void");
            }
        });
    }

    private static d b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("splash_clickarea", 2);
        int optInt2 = jSONObject.optInt("splash_layout_id", 1);
        long j = 0;
        long optLong = jSONObject.optLong("load_wait_time", 0);
        if (optLong >= 0) {
            j = optLong;
        }
        d dVar = new d();
        dVar.a(optInt);
        dVar.b(optInt2);
        dVar.a(j);
        return dVar;
    }

    private static boolean b(q qVar) {
        return !qVar.at() && !qVar.av();
    }

    private static AdSlot c(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            return null;
        }
        String optString = jSONObject2.optString("mCodeId", "");
        int optInt = jSONObject2.optInt("mImgAcceptedWidth", 0);
        int optInt2 = jSONObject2.optInt("mImgAcceptedHeight", 0);
        int optInt3 = jSONObject2.optInt("mAdCount", 6);
        boolean optBoolean = jSONObject2.optBoolean("mSupportDeepLink", true);
        String optString2 = jSONObject2.optString("mRewardName", "");
        int optInt4 = jSONObject2.optInt("mRewardAmount", 0);
        String optString3 = jSONObject2.optString("mMediaExtra", "");
        String optString4 = jSONObject2.optString("mUserID", "");
        jSONObject2.optInt("mOrientation", 2);
        int optInt5 = jSONObject2.optInt("mNativeAdType", 0);
        boolean optBoolean2 = jSONObject2.optBoolean("mIsAutoPlay", false);
        boolean optBoolean3 = jSONObject2.optBoolean("mIsExpressAd", false);
        String optString5 = jSONObject2.optString("mBidAdm", "");
        return new AdSlot.Builder().setCodeId(optString).setImageAcceptedSize(optInt, optInt2).setExpressViewAcceptedSize((float) jSONObject2.optDouble("mExpressViewAcceptedWidth", 0.0d), (float) jSONObject2.optDouble("mExpressViewAcceptedHeight", 0.0d)).setAdCount(optInt3).setSupportDeepLink(optBoolean).setRewardName(optString2).setRewardAmount(optInt4).setMediaExtra(optString3).setUserID(optString4).setNativeAdType(optInt5).setIsAutoPlay(optBoolean2).isExpressAd(optBoolean3).withBid(optString5).setDurationSlotType(jSONObject2.optInt("mDurationSlotType", 0)).build();
    }

    private static FilterWord d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FilterWord d = d(optJSONArray.optJSONObject(i));
                    if (d != null && d.isValid()) {
                        filterWord.addOption(d);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static c e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(jSONObject.optString(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        cVar.c(jSONObject.optString(CampaignEx.JSON_KEY_PACKAGE_NAME));
        cVar.a(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
        cVar.a(jSONObject.optDouble(FirebaseAnalytics.Param.SCORE, -1.0d));
        cVar.a(jSONObject.optInt("comment_num", -1));
        cVar.b(jSONObject.optInt(CampaignEx.JSON_KEY_APP_SIZE, 0));
        return cVar;
    }

    private static p f(JSONObject jSONObject) {
        p pVar = new p();
        if (jSONObject == null) {
            pVar.a(10);
            pVar.b(20);
            pVar.a("");
            return pVar;
        }
        pVar.a(jSONObject.optLong("onlylp_loading_maxtime", 10));
        pVar.b(jSONObject.optLong("straight_lp_showtime", 20));
        pVar.a(jSONObject.optString("loading_text", ""));
        return pVar;
    }

    private static k g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        k kVar = new k();
        kVar.a(jSONObject.optInt("if_send_click", 0));
        return kVar;
    }

    private static j h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        jVar.a(jSONObject.optString("deeplink_url"));
        jVar.b(jSONObject.optString("fallback_url"));
        jVar.a(jSONObject.optInt("fallback_type"));
        return jVar;
    }

    private static Map<String, Object> i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }
}
