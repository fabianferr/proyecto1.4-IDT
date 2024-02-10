package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class f {
    public static final f a = a("ad_req");
    public static final f b = a("ad_imp");
    public static final f c = a("max_ad_imp");
    public static final f d = a("ad_session_start");
    public static final f e = a("ad_imp_session");
    public static final f f = a("max_ad_imp_session");
    public static final f g = a("cached_files_expired");
    public static final f h = a("cache_drop_count");
    public static final f i = a("sdk_reset_state_count", true);
    public static final f j = a("ad_response_process_failures", true);
    public static final f k = a("response_process_failures", true);
    public static final f l = a("incent_failed_to_display_count", true);
    public static final f m = a("app_paused_and_resumed");
    public static final f n = a("ad_rendered_with_mismatched_sdk_key", true);
    public static final f o = a("ad_shown_outside_app_count");
    public static final f p = a("med_ad_req");
    public static final f q = a("med_ad_response_process_failures", true);
    public static final f r = a("med_waterfall_ad_no_fill", true);
    public static final f s = a("med_waterfall_ad_adapter_load_failed", true);
    public static final f t = a("med_waterfall_ad_invalid_response", true);
    private static final Set<String> u = new HashSet(32);
    private static final Set<f> w = new HashSet(16);
    private final String v;

    static {
        a("fullscreen_ad_nil_vc_count");
        a("applovin_bundle_missing");
    }

    private f(String str) {
        this.v = str;
    }

    private static f a(String str) {
        return a(str, false);
    }

    private static f a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            Set<String> set = u;
            if (!set.contains(str)) {
                set.add(str);
                f fVar = new f(str);
                if (z) {
                    w.add(fVar);
                }
                return fVar;
            }
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
        throw new IllegalArgumentException("No key name specified");
    }

    public static Set<f> b() {
        return w;
    }

    public String a() {
        return this.v;
    }
}
