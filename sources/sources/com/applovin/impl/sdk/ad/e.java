package com.applovin.impl.sdk.ad;

import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import com.applovin.impl.adview.i;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.aa;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public abstract class e extends AppLovinAdImpl {
    private final List<Uri> a = CollectionUtils.synchronizedList();
    private final AtomicBoolean b = new AtomicBoolean();
    private final AtomicBoolean c = new AtomicBoolean();
    private final AtomicReference<com.applovin.impl.sdk.c.c> d = new AtomicReference<>();
    private List<com.applovin.impl.sdk.e.a> e;
    private List<com.applovin.impl.sdk.e.a> f;
    private List<com.applovin.impl.sdk.e.a> g;
    private List<com.applovin.impl.sdk.e.a> h;
    private c i;

    public enum a {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    public enum b {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        private c() {
            this.a = AppLovinSdkUtils.dpToPx(e.this.sdk.L(), e.this.Y());
            this.b = AppLovinSdkUtils.dpToPx(e.this.sdk.L(), e.this.Z());
            this.c = AppLovinSdkUtils.dpToPx(e.this.sdk.L(), e.this.aa());
            this.d = AppLovinSdkUtils.dpToPx(e.this.sdk.L(), ((Integer) e.this.sdk.a(com.applovin.impl.sdk.d.b.bH)).intValue());
            this.e = AppLovinSdkUtils.dpToPx(e.this.sdk.L(), ((Integer) e.this.sdk.a(com.applovin.impl.sdk.d.b.bG)).intValue());
        }
    }

    public enum d {
        RESIZE_ASPECT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public e(JSONObject jSONObject, JSONObject jSONObject2, b bVar, m mVar) {
        super(jSONObject, jSONObject2, bVar, mVar);
    }

    private i.a b(boolean z) {
        return z ? i.a.WHITE_ON_TRANSPARENT : i.a.WHITE_ON_BLACK;
    }

    private String b(PointF pointF, boolean z) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", (String) null);
        Map<String, String> c2 = c(pointF, z);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, c2);
        }
        return null;
    }

    private List<Integer> b() {
        return getIntegerListFromAdObject("multi_close_style", (List<Integer>) null);
    }

    private String c() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace(Utils.MACRO_CLCODE, getClCode());
        }
        return null;
    }

    private Map<String, String> c(PointF pointF, boolean z) {
        Point a2 = g.a(this.sdk.L());
        Map<String, String> map = CollectionUtils.map(6);
        map.put(Utils.MACRO_CLCODE, getClCode());
        map.put(Utils.MACRO_CLICK_X, String.valueOf(pointF.x));
        map.put(Utils.MACRO_CLICK_Y, String.valueOf(pointF.y));
        map.put(Utils.MACRO_SCREEN_WIDTH, String.valueOf(a2.x));
        map.put(Utils.MACRO_SCREEN_HEIGHT, String.valueOf(a2.y));
        map.put(Utils.MACRO_IS_VIDEO_CLICK, String.valueOf(z));
        return map;
    }

    public boolean A() {
        return getBooleanFromAdObject("html_resources_cached", false);
    }

    public List<Uri> B() {
        return this.a;
    }

    public String C() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("video_button_properties", (JSONObject) null);
        return jsonObjectFromAdObject != null ? JsonUtils.getString(jsonObjectFromAdObject, "video_button_html", "") : "";
    }

    public s D() {
        return new s(getJsonObjectFromAdObject("video_button_properties", (JSONObject) null), this.sdk);
    }

    public boolean E() {
        return getBooleanFromAdObject("video_clickable", false);
    }

    public boolean F() {
        return getBooleanFromAdObject("lock_current_orientation", false);
    }

    public a G() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return a.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return a.DO_NOT_DISMISS;
            }
        }
        return a.UNSPECIFIED;
    }

    public List<String> H() {
        String stringFromAdObject = getStringFromAdObject("required_html_resources", (String) null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    public List<String> I() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", (String) null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : this.sdk.b(com.applovin.impl.sdk.d.b.br);
    }

    public boolean J() {
        return getBooleanFromAdObject("sruifwvc", false);
    }

    public boolean K() {
        return getBooleanFromAdObject("require_interaction_for_click", false);
    }

    public String L() {
        return getStringFromAdObject("cache_prefix", (String) null);
    }

    public boolean M() {
        return getBooleanFromAdObject("sscomt", false);
    }

    public String N() {
        return getStringFromFullResponse("event_id", (String) null);
    }

    public boolean O() {
        return getBooleanFromAdObject("progress_bar_enabled", false);
    }

    public int P() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    public int Q() {
        int videoCompletionPercent;
        synchronized (this.adObjectLock) {
            videoCompletionPercent = Utils.getVideoCompletionPercent(this.adObject);
        }
        return videoCompletionPercent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        return 90;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int R() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.adObjectLock
            monitor-enter(r0)
            org.json.JSONObject r1 = r4.adObject     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "graphic_completion_percent"
            r3 = -1
            int r1 = com.applovin.impl.sdk.utils.JsonUtils.getInt(r1, r2, r3)     // Catch:{ all -> 0x0018 }
            if (r1 < 0) goto L_0x0014
            r2 = 100
            if (r1 > r2) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            r0 = 90
            return r0
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.ad.e.R():int");
    }

    public int S() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    public int T() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    public boolean U() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", false);
    }

    public boolean V() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", false);
    }

    public boolean W() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", false);
    }

    public c X() {
        if (this.i == null) {
            this.i = new c();
        }
        return this.i;
    }

    public int Y() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.a(com.applovin.impl.sdk.d.b.ck)).intValue());
    }

    public int Z() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.a(com.applovin.impl.sdk.d.b.cl)).intValue());
    }

    /* access modifiers changed from: protected */
    public i.a a(int i2) {
        return i2 == 1 ? i.a.WHITE_ON_TRANSPARENT : i2 == 2 ? i.a.INVISIBLE : i2 == 3 ? i.a.TRANSPARENT_SKIP : i.a.WHITE_ON_BLACK;
    }

    public List<com.applovin.impl.sdk.e.a> a(PointF pointF) {
        List<com.applovin.impl.sdk.e.a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("video_click_tracking_urls", this.adObject, c(pointF, true), (String) null, au(), z(), this.sdk);
        }
        return postbacks.isEmpty() ? a(pointF, true) : postbacks;
    }

    public List<com.applovin.impl.sdk.e.a> a(PointF pointF, boolean z) {
        List<com.applovin.impl.sdk.e.a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("click_tracking_urls", this.adObject, c(pointF, z), b(pointF, z), au(), z(), this.sdk);
        }
        return postbacks;
    }

    public abstract void a();

    public void a(com.applovin.impl.sdk.c.c cVar) {
        this.d.set(cVar);
    }

    public void a(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("html_resources_cached", z);
            }
        } catch (Throwable unused) {
        }
    }

    public List<String> aA() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    public List<String> aB() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", (String) null));
    }

    public Uri aC() {
        String stringFromAdObject = getStringFromAdObject("mute_image", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public Uri aD() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean aE() {
        return this.c.get();
    }

    public void aF() {
        this.c.set(true);
    }

    public com.applovin.impl.sdk.c.c aG() {
        return this.d.getAndSet((Object) null);
    }

    public boolean aH() {
        String str = this.sdk.p().getExtraParameters().get(AppLovinSdkExtraParameterKey.SHOULD_USE_EXOPLAYER);
        return StringUtils.isValidString(str) ? Boolean.parseBoolean(str) : getBooleanFromAdObject("suep", false);
    }

    public boolean aI() {
        return getBooleanFromAdObject("rwvbv", false);
    }

    public boolean aJ() {
        return getBooleanFromAdObject("upiosp", false);
    }

    public boolean aK() {
        return getBooleanFromAdObject("web_video", false);
    }

    public d aL() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", (String) null);
        return ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(stringFromAdObject) ? d.TOP : "bottom".equals(stringFromAdObject) ? d.BOTTOM : "left".equals(stringFromAdObject) ? d.LEFT : "right".equals(stringFromAdObject) ? d.RIGHT : d.RESIZE_ASPECT;
    }

    public int aa() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.a(com.applovin.impl.sdk.d.b.cj)).intValue());
    }

    public boolean ab() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.a(com.applovin.impl.sdk.d.b.ci));
    }

    public boolean ac() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.a(com.applovin.impl.sdk.d.b.cp));
    }

    public long ad() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1;
    }

    public int ae() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    public boolean af() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", true);
    }

    public AtomicBoolean ag() {
        return this.b;
    }

    public boolean ah() {
        return getBooleanFromAdObject("show_nia", false);
    }

    public String ai() {
        return getStringFromAdObject("nia_title", "");
    }

    public String aj() {
        return getStringFromAdObject("nia_message", "");
    }

    public String ak() {
        return getStringFromAdObject("nia_button_title", "");
    }

    public boolean al() {
        return getBooleanFromAdObject("avoms", false);
    }

    public boolean am() {
        return getBooleanFromAdObject("show_rewarded_interstitial_overlay_alert", Boolean.valueOf(AppLovinAdType.AUTO_INCENTIVIZED == getType()));
    }

    public String an() {
        return getStringFromAdObject("text_rewarded_inter_alert_title", "Watch a video to earn a reward!");
    }

    public String ao() {
        return getStringFromAdObject("text_rewarded_inter_alert_body", "");
    }

    public String ap() {
        return getStringFromAdObject("text_rewarded_inter_alert_ok_action", "OK!");
    }

    public List<com.applovin.impl.sdk.e.a> aq() {
        List<com.applovin.impl.sdk.e.a> postbacks;
        List<com.applovin.impl.sdk.e.a> list = this.e;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("video_end_urls", this.adObject, getClCode(), c(), this.sdk);
            this.e = postbacks;
        }
        return postbacks;
    }

    public List<com.applovin.impl.sdk.e.a> ar() {
        List<com.applovin.impl.sdk.e.a> postbacks;
        List<com.applovin.impl.sdk.e.a> list = this.f;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("ad_closed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f = postbacks;
        }
        return postbacks;
    }

    public List<com.applovin.impl.sdk.e.a> as() {
        List<com.applovin.impl.sdk.e.a> postbacks;
        List<com.applovin.impl.sdk.e.a> list = this.g;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("app_killed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.g = postbacks;
        }
        return postbacks;
    }

    public List<com.applovin.impl.sdk.e.a> at() {
        List<com.applovin.impl.sdk.e.a> postbacks;
        List<com.applovin.impl.sdk.e.a> list = this.h;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("imp_urls", this.adObject, getClCode(), (Map<String, String>) null, (String) null, au(), z(), this.sdk);
            this.h = postbacks;
        }
        return postbacks;
    }

    public Map<String, String> au() {
        Map<String, String> map = CollectionUtils.map();
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", false)) {
            map.put("User-Agent", aa.a());
        }
        return map;
    }

    public boolean av() {
        return getBooleanFromAdObject("playback_requires_user_action", true);
    }

    public String aw() {
        String stringFromAdObject = getStringFromAdObject("base_url", "/");
        if (AbstractJsonLexerKt.NULL.equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    public boolean ax() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", false);
    }

    public v ay() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", (JSONObject) null);
        if (jsonObjectFromAdObject != null) {
            return new v(jsonObjectFromAdObject);
        }
        return null;
    }

    public int az() {
        return getIntFromAdObject("whalt", Utils.isBML(getSize()) ? 1 : ((Boolean) this.sdk.a(com.applovin.impl.sdk.d.b.eO)).booleanValue() ? 0 : -1);
    }

    public void b(Uri uri) {
        this.a.add(uri);
    }

    public void c(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putObject(this.adObject, "mute_image", uri);
        }
    }

    public abstract String d();

    public void d(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putObject(this.adObject, "unmute_image", uri);
        }
    }

    public boolean f() {
        if (!u.a()) {
            return false;
        }
        this.sdk.A().e("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", (String) null);
    }

    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", (String) null);
    }

    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        return Collections.emptyList();
    }

    public Uri h() {
        if (!u.a()) {
            return null;
        }
        this.sdk.A().e("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    public abstract boolean isOpenMeasurementEnabled();

    public Uri j() {
        if (!u.a()) {
            return null;
        }
        this.sdk.A().e("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
    }

    public Uri k() {
        if (!u.a()) {
            return null;
        }
        this.sdk.A().e("DirectAd", "Attempting to invoke getVideoClickDestinationUri() from base ad class");
        return null;
    }

    public abstract com.applovin.impl.sdk.b.b o();

    public b p() {
        String upperCase = getStringFromAdObject("ad_target", b.DEFAULT.toString()).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? b.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? b.ACTIVITY_LANDSCAPE : b.DEFAULT;
    }

    public boolean q() {
        return getBooleanFromAdObject("iopmsdc", false);
    }

    public long r() {
        return getLongFromAdObject("close_delay", 0);
    }

    public long s() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5));
    }

    public long t() {
        List<Integer> u = u();
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", (u == null || u.size() <= 0) ? 0 : (long) u.get(0).intValue());
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0;
        }
        return longFromAdObject;
    }

    public List<Integer> u() {
        return getIntegerListFromAdObject("multi_close_delay_graphic", (List<Integer>) null);
    }

    public i.a v() {
        List<Integer> b2 = b();
        int intFromAdObject = getIntFromAdObject("close_style", (b2 == null || b2.size() <= 0) ? -1 : b2.get(0).intValue());
        return intFromAdObject == -1 ? b(hasVideoUrl()) : a(intFromAdObject);
    }

    public List<i.a> w() {
        List<Integer> b2 = b();
        if (b2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(b2.size());
        for (Integer intValue : b2) {
            arrayList.add(a(intValue.intValue()));
        }
        return arrayList;
    }

    public i.a x() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? v() : a(intFromAdObject);
    }

    public boolean y() {
        return getBooleanFromAdObject("dismiss_on_skip", false);
    }

    public boolean z() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", false);
    }
}
