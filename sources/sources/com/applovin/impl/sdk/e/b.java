package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class b {
    public static final b A = a("wvrec", "WEB_VIEW_RENDER_ERROR_COUNT");
    public static final b B = a("wvsem", "WEB_VIEW_SSL_ERROR_MESSAGES");
    public static final b C = a("wvruc", "WEB_VIEW_RENDERER_UNRESPONSIVE_COUNT");
    private static final Set<String> F = new HashSet(32);
    public static final b a = a("sas", "AD_SOURCE");
    public static final b b = a("srt", "AD_RENDER_TIME");
    public static final b c = a("sft", "AD_FETCH_TIME");
    public static final b d = a("sfs", "AD_FETCH_SIZE");
    public static final b e = a("sadb", "AD_DOWNLOADED_BYTES");
    public static final b f = a("sacb", "AD_CACHED_BYTES");
    public static final b g = a("stdl", "TIME_TO_DISPLAY_FROM_LOAD");
    public static final b h = a("stdi", "TIME_TO_DISPLAY_FROM_INIT");
    public static final b i = a("snas", "AD_NUMBER_IN_SESSION");
    public static final b j = a("snat", "AD_NUMBER_TOTAL");
    public static final b k = a("stah", "TIME_AD_HIDDEN_FROM_SHOW");
    public static final b l = a("stas", "TIME_TO_SKIP_FROM_SHOW");
    public static final b m = a("stac", "TIME_TO_CLICK_FROM_SHOW");
    public static final b n = a("stbe", "TIME_TO_EXPAND_FROM_SHOW");
    public static final b o = a("stbc", "TIME_TO_CONTRACT_FROM_SHOW");
    public static final b p = a("suvs", "INTERSTITIAL_USED_VIDEO_STREAM");
    public static final b q = a("sugs", "AD_USED_GRAPHIC_STREAM");
    public static final b r = a("svpv", "INTERSTITIAL_VIDEO_PERCENT_VIEWED");
    public static final b s = a("stpd", "INTERSTITIAL_PAUSED_DURATION");
    public static final b t = a("shsc", "HTML_RESOURCE_CACHE_SUCCESS_COUNT");
    public static final b u = a("shfc", "HTML_RESOURCE_CACHE_FAILURE_COUNT");
    public static final b v = a("schc", "AD_CANCELLED_HTML_CACHING");
    public static final b w = a("smwm", "AD_SHOWN_IN_MULTIWINDOW_MODE");
    public static final b x = a("vssc", "VIDEO_STREAM_STALLED_COUNT");
    public static final b y = a("wvem", "WEB_VIEW_ERROR_MESSAGES");
    public static final b z = a("wvhec", "WEB_VIEW_HTTP_ERROR_COUNT");
    private final String D;
    private final String E;

    static {
        a("sisw", "IS_STREAMING_WEBKIT");
        a("surw", "UNABLE_TO_RETRIEVE_WEBKIT_HTML_STRING");
        a("surp", "UNABLE_TO_PERSIST_WEBKIT_HTML_PLACEMENT_REPLACED_STRING");
        a("swhp", "SUCCESSFULLY_PERSISTED_WEBKIT_HTML_STRING");
        a("skr", "STOREKIT_REDIRECTED");
        a("sklf", "STOREKIT_LOAD_FAILURE");
        a("skps", "STOREKIT_PRELOAD_SKIPPED");
    }

    private b(String str, String str2) {
        this.D = str;
        this.E = str2;
    }

    private static b a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Set<String> set = F;
            if (set.contains(str)) {
                throw new IllegalArgumentException("Key has already been used: " + str);
            } else if (!TextUtils.isEmpty(str2)) {
                set.add(str);
                return new b(str, str2);
            } else {
                throw new IllegalArgumentException("No debug name specified");
            }
        } else {
            throw new IllegalArgumentException("No key name specified");
        }
    }
}
