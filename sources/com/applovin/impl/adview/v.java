package com.applovin.impl.adview;

import android.webkit.WebSettings;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;

public final class v {
    private JSONObject a;

    public v(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public Integer a() {
        int i;
        String string = JsonUtils.getString(this.a, "mixed_content_mode", (String) null);
        if (StringUtils.isValidString(string)) {
            if ("always_allow".equalsIgnoreCase(string)) {
                i = 0;
            } else if ("never_allow".equalsIgnoreCase(string)) {
                i = 1;
            } else if ("compatibility_mode".equalsIgnoreCase(string)) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public WebSettings.PluginState b() {
        String string = JsonUtils.getString(this.a, "plugin_state", (String) null);
        if (StringUtils.isValidString(string)) {
            if (DebugKt.DEBUG_PROPERTY_VALUE_ON.equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(string)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Boolean c() {
        return JsonUtils.getBoolean(this.a, "allow_file_access", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean d() {
        return JsonUtils.getBoolean(this.a, "load_with_overview_mode", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean e() {
        return JsonUtils.getBoolean(this.a, "use_wide_view_port", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean f() {
        return JsonUtils.getBoolean(this.a, "allow_content_access", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean g() {
        return JsonUtils.getBoolean(this.a, "use_built_in_zoom_controls", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean h() {
        return JsonUtils.getBoolean(this.a, "display_zoom_controls", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean i() {
        return JsonUtils.getBoolean(this.a, "save_form_data", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean j() {
        return JsonUtils.getBoolean(this.a, "geolocation_enabled", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean k() {
        return JsonUtils.getBoolean(this.a, "need_initial_focus", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean l() {
        return JsonUtils.getBoolean(this.a, "allow_file_access_from_file_urls", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean m() {
        return JsonUtils.getBoolean(this.a, "allow_universal_access_from_file_urls", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean n() {
        return JsonUtils.getBoolean(this.a, "offscreen_pre_raster", (Boolean) null);
    }
}
