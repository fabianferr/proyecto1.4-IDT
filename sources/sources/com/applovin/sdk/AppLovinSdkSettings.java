package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class AppLovinSdkSettings {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f = true;
    private String g;
    private List<String> h = Collections.emptyList();
    private List<String> i = Collections.emptyList();
    private final Map<String, String> j = CollectionUtils.map();
    private final Object k = new Object();
    private m l;
    private final Map<String, Object> localSettings = CollectionUtils.map();
    private final Map<String, String> metaData = CollectionUtils.map();

    public AppLovinSdkSettings(Context context) {
        this.a = Utils.isVerboseLoggingEnabled(context);
        this.c = true;
        this.d = true;
        this.e = true;
    }

    /* access modifiers changed from: protected */
    public void attachAppLovinSdk(m mVar) {
        this.l = mVar;
        if (StringUtils.isValidString(this.g)) {
            mVar.J().a(true);
            mVar.J().a(this.g);
            this.g = null;
        }
    }

    public Map<String, String> getExtraParameters() {
        Map<String, String> map;
        synchronized (this.k) {
            map = CollectionUtils.map(this.j);
        }
        return map;
    }

    public List<String> getInitializationAdUnitIds() {
        return this.i;
    }

    public List<String> getTestDeviceAdvertisingIds() {
        return this.h;
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.c;
    }

    public boolean isExceptionHandlerEnabled() {
        return this.d;
    }

    public boolean isLocationCollectionEnabled() {
        return this.e;
    }

    public boolean isMuted() {
        return this.b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.a;
    }

    public void setCreativeDebuggerEnabled(boolean z) {
        this.c = z;
    }

    public void setExceptionHandlerEnabled(boolean z) {
        this.d = z;
    }

    public void setExtraParameter(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str2 != null ? str2.trim() : null;
            synchronized (this.k) {
                this.j.put(str, trim);
            }
            if (!"test_mode_network".equalsIgnoreCase(str)) {
                return;
            }
            if (this.l == null) {
                this.g = trim;
            } else if (StringUtils.isValidString(trim)) {
                this.l.J().a(true);
                this.l.J().a(trim);
            } else {
                this.l.J().a(false);
                this.l.J().a((String) null);
            }
        } else if (u.a()) {
            u.i("AppLovinSdkSettings", "Failed to set extra parameter for null or empty key: " + str);
        }
    }

    public void setInitializationAdUnitIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (StringUtils.isValidString(next) && next.length() > 0) {
                    if (next.length() == 16) {
                        arrayList.add(next);
                    } else if (u.a()) {
                        u.i("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + next + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                    }
                }
            }
            this.i = arrayList;
            return;
        }
        this.i = Collections.emptyList();
    }

    public void setLocationCollectionEnabled(boolean z) {
        this.e = z;
    }

    public void setMuted(boolean z) {
        this.b = z;
    }

    public void setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(boolean z) {
        this.f = z;
    }

    public void setTestDeviceAdvertisingIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (next != null && next.length() == 36) {
                    arrayList.add(next);
                } else if (u.a()) {
                    u.i("AppLovinSdkSettings", "Unable to set test device advertising id (" + next + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
                }
            }
            this.h = arrayList;
            return;
        }
        this.h = Collections.emptyList();
    }

    public void setVerboseLogging(boolean z) {
        if (Utils.isVerboseLoggingConfigured()) {
            if (u.a()) {
                u.i("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already.");
            }
            if (Utils.isVerboseLoggingEnabled((Context) null) != z) {
                u.i("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
                return;
            }
            return;
        }
        this.a = z;
    }

    public boolean shouldFailAdDisplayIfDontKeepActivitiesIsEnabled() {
        return this.f;
    }

    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.a + ", muted=" + this.b + ", testDeviceAdvertisingIds=" + this.h.toString() + ", initializationAdUnitIds=" + this.i.toString() + ", creativeDebuggerEnabled=" + this.c + ", exceptionHandlerEnabled=" + this.d + ", locationCollectionEnabled=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
