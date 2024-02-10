package com.ironsource.mediationsdk.utils;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/ironsource/mediationsdk/utils/ApplicationGeneralSettings;", "", "config", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getConfig", "()Lorg/json/JSONObject;", "externalArmEventsUrl", "", "getExternalArmEventsUrl", "()Ljava/lang/String;", "isExternalArmEventsEnabled", "", "()Z", "shouldReuseAdvId", "getShouldReuseAdvId", "shouldUseAppSet", "getShouldUseAppSet", "shouldUseSharedThreadPool", "getShouldUseSharedThreadPool", "userAgentExpirationThresholdInHours", "", "getUserAgentExpirationThresholdInHours", "()I", "component1", "copy", "equals", "other", "hashCode", "toString", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {
    public final boolean a;
    public final String b;
    private final JSONObject c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final boolean g;

    public b(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        this.c = jSONObject;
        this.a = jSONObject.optBoolean("isExternalArmEventsEnabled", true);
        String optString = jSONObject.optString("externalArmEventsUrl", "https://outcome-arm-ext-med-ext.sonic-us.supersonicads.com/aemData");
        Intrinsics.checkNotNullExpressionValue(optString, "config.optString(EXTERNA…AL_EVENTS_IMPRESSION_URL)");
        this.b = optString;
        this.d = jSONObject.optBoolean(CmcdConfiguration.KEY_SESSION_ID, true);
        this.e = jSONObject.optBoolean("radvid", false);
        this.f = jSONObject.optInt("uaeh", 0);
        this.g = jSONObject.optBoolean("sharedThreadPool", false);
    }

    public final boolean a() {
        return this.d;
    }

    public final boolean b() {
        return this.e;
    }

    public final int c() {
        return this.f;
    }

    public final boolean d() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && Intrinsics.areEqual((Object) this.c, (Object) ((b) obj).c);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return "ApplicationGeneralSettings(config=" + this.c + ')';
    }
}
