package com.applovin.impl.sdk.d;

import java.util.HashSet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class d<T> {
    public static final d<String> A = new d<>("com.applovin.sdk.mediation_provider", String.class);
    public static final d<String> B = new d<>("com.applovin.sdk.mediation.test_mode_network", String.class);
    public static final d<Boolean> C = new d<>("com.applovin.sdk.mediation.test_mode_enabled", Boolean.class);
    public static final d<String> D = new d<>("com.applovin.sdk.user_agent", String.class);
    public static final d<String> E = new d<>("com.applovin.sdk.last_os_version_user_agent_collected_for", String.class);
    public static final d<String> a = new d<>("com.applovin.sdk.impl.isFirstRun", String.class);
    public static final d<Boolean> b = new d<>("com.applovin.sdk.launched_before", Boolean.class);
    public static final d<String> c = new d<>("com.applovin.sdk.latest_installed_version", String.class);
    public static final d<Long> d = new d<>("com.applovin.sdk.install_date", Long.class);
    public static final d<String> e = new d<>("com.applovin.sdk.user_id", String.class);
    public static final d<String> f = new d<>("com.applovin.sdk.compass_id", String.class);
    public static final d<String> g = new d<>("com.applovin.sdk.compass_random_token", String.class);
    public static final d<String> h = new d<>("com.applovin.sdk.applovin_random_token", String.class);
    public static final d<String> i = new d<>("com.applovin.sdk.device_test_group", String.class);
    public static final d<String> j = new d<>("com.applovin.sdk.variables", String.class);
    public static final d<Boolean> k = new d<>("com.applovin.sdk.compliance.has_user_consent", Boolean.class);
    public static final d<Boolean> l = new d<>("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);
    public static final d<Boolean> m = new d<>("com.applovin.sdk.compliance.is_do_not_sell", Boolean.class);
    public static final d<String> n = new d<>("IABTCF_TCString", String.class);
    public static final d<?> o = new d<>("IABTCF_gdprApplies", Object.class);
    public static final d<HashSet> p = new d<>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);
    public static final d<String> q = new d<>("com.applovin.sdk.stats", String.class);
    public static final d<HashSet> r = new d<>("com.applovin.sdk.task.stats", HashSet.class);
    public static final d<String> s = new d<>("com.applovin.sdk.network_response_code_mapping", String.class);
    public static final d<String> t = new d<>("com.applovin.sdk.event_tracking.super_properties", String.class);
    public static final d<HashSet> u = new d<>("com.applovin.sdk.ad.stats", HashSet.class);
    public static final d<Integer> v = new d<>("com.applovin.sdk.last_video_position", Integer.class);
    public static final d<Boolean> w = new d<>("com.applovin.sdk.should_resume_video", Boolean.class);
    public static final d<String> x = new d<>("com.applovin.sdk.mediation.signal_providers", String.class);
    public static final d<String> y = new d<>("com.applovin.sdk.mediation.auto_init_adapters", String.class);
    public static final d<String> z = new d<>("com.applovin.sdk.persisted_data", String.class);
    private final String F;
    private final Class<T> G;

    public d(String str, Class<T> cls) {
        this.F = str;
        this.G = cls;
    }

    public String a() {
        return this.F;
    }

    public Class<T> b() {
        return this.G;
    }

    public String toString() {
        return "Key{name='" + this.F + "', type=" + this.G + AbstractJsonLexerKt.END_OBJ;
    }
}
