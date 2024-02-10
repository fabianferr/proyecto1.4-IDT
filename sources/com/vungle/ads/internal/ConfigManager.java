package com.vungle.ads.internal;

import android.net.Uri;
import android.util.Log;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.internal.model.CleverCache;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.model.Placement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0004J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\rJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u0004J\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\rJ\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010'\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\rJ\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u0006\u0010*\u001a\u00020\rJ\r\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b,R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/vungle/ads/internal/ConfigManager;", "", "()V", "TAG", "", "config", "Lcom/vungle/ads/internal/model/ConfigPayload;", "endpoints", "Lcom/vungle/ads/internal/model/ConfigPayload$Endpoints;", "placements", "", "Lcom/vungle/ads/internal/model/Placement;", "adLoadOptimizationEnabled", "", "getAdsEndpoint", "getCleverCacheDiskPercentage", "", "getCleverCacheDiskSize", "", "getConfigExtension", "getErrorLoggingEndpoint", "getGDPRButtonAccept", "getGDPRButtonDeny", "getGDPRConsentMessage", "getGDPRConsentMessageVersion", "getGDPRConsentTitle", "getGDPRIsCountryDataProtected", "getLogLevel", "getMetricsEnabled", "getMetricsEndpoint", "getMraidEndpoint", "getMraidJsVersion", "getPlacement", "id", "getRiEndpoint", "getSessionTimeoutInSecond", "heartbeatEnabled", "initWithConfig", "", "isCleverCacheEnabled", "isReportIncentivizedEnabled", "omEnabled", "shouldDisableAdId", "validateEndpoints", "validateEndpoints$vungle_ads_release", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigManager.kt */
public final class ConfigManager {
    public static final ConfigManager INSTANCE = new ConfigManager();
    public static final String TAG = "ConfigManager";
    private static ConfigPayload config;
    private static ConfigPayload.Endpoints endpoints;
    private static List<Placement> placements;

    private ConfigManager() {
    }

    public final void initWithConfig(ConfigPayload configPayload) {
        Intrinsics.checkNotNullParameter(configPayload, "config");
        config = configPayload;
        endpoints = configPayload.getEndpoints();
        placements = configPayload.getPlacements();
    }

    public final List<Placement> placements() {
        return placements;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.vungle.ads.internal.model.Placement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.vungle.ads.internal.model.Placement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.vungle.ads.internal.model.Placement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.vungle.ads.internal.model.Placement} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.vungle.ads.internal.model.Placement getPlacement(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List<com.vungle.ads.internal.model.Placement> r0 = placements
            r1 = 0
            if (r0 == 0) goto L_0x002a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0028
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.vungle.ads.internal.model.Placement r3 = (com.vungle.ads.internal.model.Placement) r3
            java.lang.String r3 = r3.getReferenceId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0010
            r1 = r2
        L_0x0028:
            com.vungle.ads.internal.model.Placement r1 = (com.vungle.ads.internal.model.Placement) r1
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getPlacement(java.lang.String):com.vungle.ads.internal.model.Placement");
    }

    public final String getAdsEndpoint() {
        ConfigPayload.Endpoints endpoints2 = endpoints;
        if (endpoints2 != null) {
            return endpoints2.getAdsEndpoint();
        }
        return null;
    }

    public final String getRiEndpoint() {
        ConfigPayload.Endpoints endpoints2 = endpoints;
        if (endpoints2 != null) {
            return endpoints2.getRiEndpoint();
        }
        return null;
    }

    public final String getMraidEndpoint() {
        ConfigPayload.Endpoints endpoints2 = endpoints;
        if (endpoints2 != null) {
            return endpoints2.getMraidEndpoint();
        }
        return null;
    }

    public final String getMraidJsVersion() {
        String mraidEndpoint = getMraidEndpoint();
        if (mraidEndpoint != null) {
            String str = "mraid_" + Uri.parse(mraidEndpoint).getLastPathSegment();
            return str == null ? "mraid_1" : str;
        }
    }

    public final String getGDPRConsentMessage() {
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (gdpr = configPayload.getGdpr()) == null) {
            return null;
        }
        return gdpr.getConsentMessage();
    }

    public final String getGDPRConsentTitle() {
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (gdpr = configPayload.getGdpr()) == null) {
            return null;
        }
        return gdpr.getConsentTitle();
    }

    public final String getGDPRButtonAccept() {
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (gdpr = configPayload.getGdpr()) == null) {
            return null;
        }
        return gdpr.getButtonAccept();
    }

    public final String getGDPRButtonDeny() {
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (gdpr = configPayload.getGdpr()) == null) {
            return null;
        }
        return gdpr.getButtonDeny();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.getGdpr()).getConsentMessageVersion();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getGDPRConsentMessageVersion() {
        /*
            r1 = this;
            com.vungle.ads.internal.model.ConfigPayload r0 = config
            if (r0 == 0) goto L_0x0010
            com.vungle.ads.internal.model.ConfigPayload$GDPRSettings r0 = r0.getGdpr()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getConsentMessageVersion()
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            java.lang.String r0 = ""
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getGDPRConsentMessageVersion():java.lang.String");
    }

    public final boolean getGDPRIsCountryDataProtected() {
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (gdpr = configPayload.getGdpr()) == null) {
            return false;
        }
        return gdpr.isCountryDataProtected();
    }

    public final boolean shouldDisableAdId() {
        Boolean disableAdId;
        ConfigPayload configPayload = config;
        if (configPayload == null || (disableAdId = configPayload.getDisableAdId()) == null) {
            return true;
        }
        return disableAdId.booleanValue();
    }

    public final boolean adLoadOptimizationEnabled() {
        ConfigPayload.LoadOptimizationSettings isAdDownloadOptEnabled;
        ConfigPayload configPayload = config;
        if (configPayload == null || (isAdDownloadOptEnabled = configPayload.isAdDownloadOptEnabled()) == null) {
            return false;
        }
        return isAdDownloadOptEnabled.getEnabled();
    }

    public final boolean isReportIncentivizedEnabled() {
        ConfigPayload.ReportIncentivizedSettings isReportIncentivizedEnabled;
        ConfigPayload configPayload = config;
        if (configPayload == null || (isReportIncentivizedEnabled = configPayload.isReportIncentivizedEnabled()) == null) {
            return false;
        }
        return isReportIncentivizedEnabled.getEnabled();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getConfigExtension();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getConfigExtension() {
        /*
            r1 = this;
            com.vungle.ads.internal.model.ConfigPayload r0 = config
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getConfigExtension()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getConfigExtension():java.lang.String");
    }

    public final boolean omEnabled() {
        ConfigPayload.ViewabilitySettings viewability;
        ConfigPayload configPayload = config;
        if (configPayload == null || (viewability = configPayload.getViewability()) == null) {
            return false;
        }
        return viewability.getOm();
    }

    public final boolean heartbeatEnabled() {
        ConfigPayload.Template template;
        ConfigPayload configPayload = config;
        if (configPayload == null || (template = configPayload.getTemplate()) == null) {
            return false;
        }
        return template.getHeartbeatEnabled();
    }

    public final String getMetricsEndpoint() {
        ConfigPayload.Endpoints endpoints2 = endpoints;
        if (endpoints2 != null) {
            return endpoints2.getMetricsEndpoint();
        }
        return null;
    }

    public final String getErrorLoggingEndpoint() {
        ConfigPayload.Endpoints endpoints2 = endpoints;
        if (endpoints2 != null) {
            return endpoints2.getErrorLogsEndpoint();
        }
        return null;
    }

    public final boolean getMetricsEnabled() {
        ConfigPayload.LogMetricsSettings logMetricsSettings;
        ConfigPayload configPayload = config;
        if (configPayload == null || (logMetricsSettings = configPayload.getLogMetricsSettings()) == null) {
            return false;
        }
        return logMetricsSettings.getMetricsEnabled();
    }

    public final int getLogLevel() {
        ConfigPayload.LogMetricsSettings logMetricsSettings;
        ConfigPayload configPayload = config;
        if (configPayload == null || (logMetricsSettings = configPayload.getLogMetricsSettings()) == null) {
            return AnalyticsClient.LogLevel.ERROR_LOG_LEVEL_ERROR.getLevel();
        }
        return logMetricsSettings.getErrorLogLevel();
    }

    public final int getSessionTimeoutInSecond() {
        ConfigPayload.Session session;
        ConfigPayload configPayload = config;
        if (configPayload == null || (session = configPayload.getSession()) == null) {
            return 900;
        }
        return session.getTimeout();
    }

    public final boolean validateEndpoints$vungle_ads_release() {
        boolean z;
        ConfigPayload.Endpoints endpoints2 = endpoints;
        String str = null;
        CharSequence adsEndpoint = endpoints2 != null ? endpoints2.getAdsEndpoint() : null;
        boolean z2 = false;
        if (adsEndpoint == null || adsEndpoint.length() == 0) {
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 122, "The ads endpoint was not provided in the config.", (String) null, (String) null, (String) null, 28, (Object) null);
            z = false;
        } else {
            z = true;
        }
        ConfigPayload.Endpoints endpoints3 = endpoints;
        CharSequence riEndpoint = endpoints3 != null ? endpoints3.getRiEndpoint() : null;
        if (riEndpoint == null || riEndpoint.length() == 0) {
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 123, "The ri endpoint was not provided in the config.", (String) null, (String) null, (String) null, 28, (Object) null);
        }
        ConfigPayload.Endpoints endpoints4 = endpoints;
        CharSequence mraidEndpoint = endpoints4 != null ? endpoints4.getMraidEndpoint() : null;
        if (mraidEndpoint == null || mraidEndpoint.length() == 0) {
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 130, "The mraid endpoint was not provided in the config.", (String) null, (String) null, (String) null, 28, (Object) null);
            z = false;
        }
        ConfigPayload.Endpoints endpoints5 = endpoints;
        CharSequence metricsEndpoint = endpoints5 != null ? endpoints5.getMetricsEndpoint() : null;
        if (metricsEndpoint == null || metricsEndpoint.length() == 0) {
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 125, "The metrics endpoint was not provided in the config.", (String) null, (String) null, (String) null, 28, (Object) null);
        }
        ConfigPayload.Endpoints endpoints6 = endpoints;
        if (endpoints6 != null) {
            str = endpoints6.getErrorLogsEndpoint();
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            z2 = true;
        }
        if (z2) {
            Log.e(TAG, "The error logging endpoint was not provided in the config.");
        }
        return z;
    }

    public final boolean isCleverCacheEnabled() {
        CleverCache cleverCache;
        Boolean enabled;
        ConfigPayload configPayload = config;
        if (configPayload == null || (cleverCache = configPayload.getCleverCache()) == null || (enabled = cleverCache.getEnabled()) == null) {
            return false;
        }
        return enabled.booleanValue();
    }

    public final long getCleverCacheDiskSize() {
        CleverCache cleverCache;
        Long diskSize;
        ConfigPayload configPayload = config;
        if (configPayload == null || (cleverCache = configPayload.getCleverCache()) == null || (diskSize = cleverCache.getDiskSize()) == null) {
            return 1048576000;
        }
        long j = (long) 1024;
        return diskSize.longValue() * j * j;
    }

    public final int getCleverCacheDiskPercentage() {
        CleverCache cleverCache;
        Integer diskPercentage;
        ConfigPayload configPayload = config;
        if (configPayload == null || (cleverCache = configPayload.getCleverCache()) == null || (diskPercentage = cleverCache.getDiskPercentage()) == null) {
            return 3;
        }
        return diskPercentage.intValue();
    }
}
