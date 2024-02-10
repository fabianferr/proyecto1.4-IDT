package com.vungle.ads.internal.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\b\u0018\u0000 m2\u00020\u0001:\rlmnopqrstuvwxBË\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%B¿\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010&J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010R\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0016HÆ\u0003JÈ\u0001\u0010_\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"HÆ\u0001¢\u0006\u0002\u0010`J\u0013\u0010a\u001a\u00020\u00182\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\u0003HÖ\u0001J\t\u0010d\u001a\u00020\u001aHÖ\u0001J!\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kHÇ\u0001R\u001e\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010(\u001a\u0004\b.\u0010/R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010(\u001a\u0004\b1\u00102R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u0010\n\u0002\u00106\u0012\u0004\b3\u0010(\u001a\u0004\b4\u00105R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010(\u001a\u0004\b\u0013\u0010<R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010(\u001a\u0004\b\u0015\u0010>R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010(\u001a\u0004\b@\u0010AR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010(\u001a\u0004\bC\u0010DR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010(\u001a\u0004\bH\u0010IR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010(\u001a\u0004\bK\u0010LR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010(\u001a\u0004\bN\u0010O¨\u0006y"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload;", "", "seen1", "", "endpoints", "Lcom/vungle/ads/internal/model/ConfigPayload$Endpoints;", "placements", "", "Lcom/vungle/ads/internal/model/Placement;", "config", "Lcom/vungle/ads/internal/model/ConfigPayload$ConfigSettings;", "gdpr", "Lcom/vungle/ads/internal/model/ConfigPayload$GDPRSettings;", "loggingEnabled", "Lcom/vungle/ads/internal/model/ConfigPayload$LoggingSettings;", "crashReport", "Lcom/vungle/ads/internal/model/ConfigPayload$CrashReportSettings;", "viewability", "Lcom/vungle/ads/internal/model/ConfigPayload$ViewabilitySettings;", "isAdDownloadOptEnabled", "Lcom/vungle/ads/internal/model/ConfigPayload$LoadOptimizationSettings;", "isReportIncentivizedEnabled", "Lcom/vungle/ads/internal/model/ConfigPayload$ReportIncentivizedSettings;", "disableAdId", "", "configExtension", "", "template", "Lcom/vungle/ads/internal/model/ConfigPayload$Template;", "logMetricsSettings", "Lcom/vungle/ads/internal/model/ConfigPayload$LogMetricsSettings;", "session", "Lcom/vungle/ads/internal/model/ConfigPayload$Session;", "cleverCache", "Lcom/vungle/ads/internal/model/CleverCache;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/vungle/ads/internal/model/ConfigPayload$Endpoints;Ljava/util/List;Lcom/vungle/ads/internal/model/ConfigPayload$ConfigSettings;Lcom/vungle/ads/internal/model/ConfigPayload$GDPRSettings;Lcom/vungle/ads/internal/model/ConfigPayload$LoggingSettings;Lcom/vungle/ads/internal/model/ConfigPayload$CrashReportSettings;Lcom/vungle/ads/internal/model/ConfigPayload$ViewabilitySettings;Lcom/vungle/ads/internal/model/ConfigPayload$LoadOptimizationSettings;Lcom/vungle/ads/internal/model/ConfigPayload$ReportIncentivizedSettings;Ljava/lang/Boolean;Ljava/lang/String;Lcom/vungle/ads/internal/model/ConfigPayload$Template;Lcom/vungle/ads/internal/model/ConfigPayload$LogMetricsSettings;Lcom/vungle/ads/internal/model/ConfigPayload$Session;Lcom/vungle/ads/internal/model/CleverCache;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/vungle/ads/internal/model/ConfigPayload$Endpoints;Ljava/util/List;Lcom/vungle/ads/internal/model/ConfigPayload$ConfigSettings;Lcom/vungle/ads/internal/model/ConfigPayload$GDPRSettings;Lcom/vungle/ads/internal/model/ConfigPayload$LoggingSettings;Lcom/vungle/ads/internal/model/ConfigPayload$CrashReportSettings;Lcom/vungle/ads/internal/model/ConfigPayload$ViewabilitySettings;Lcom/vungle/ads/internal/model/ConfigPayload$LoadOptimizationSettings;Lcom/vungle/ads/internal/model/ConfigPayload$ReportIncentivizedSettings;Ljava/lang/Boolean;Ljava/lang/String;Lcom/vungle/ads/internal/model/ConfigPayload$Template;Lcom/vungle/ads/internal/model/ConfigPayload$LogMetricsSettings;Lcom/vungle/ads/internal/model/ConfigPayload$Session;Lcom/vungle/ads/internal/model/CleverCache;)V", "getCleverCache$annotations", "()V", "getCleverCache", "()Lcom/vungle/ads/internal/model/CleverCache;", "getConfig", "()Lcom/vungle/ads/internal/model/ConfigPayload$ConfigSettings;", "getConfigExtension$annotations", "getConfigExtension", "()Ljava/lang/String;", "getCrashReport$annotations", "getCrashReport", "()Lcom/vungle/ads/internal/model/ConfigPayload$CrashReportSettings;", "getDisableAdId$annotations", "getDisableAdId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEndpoints", "()Lcom/vungle/ads/internal/model/ConfigPayload$Endpoints;", "getGdpr", "()Lcom/vungle/ads/internal/model/ConfigPayload$GDPRSettings;", "isAdDownloadOptEnabled$annotations", "()Lcom/vungle/ads/internal/model/ConfigPayload$LoadOptimizationSettings;", "isReportIncentivizedEnabled$annotations", "()Lcom/vungle/ads/internal/model/ConfigPayload$ReportIncentivizedSettings;", "getLogMetricsSettings$annotations", "getLogMetricsSettings", "()Lcom/vungle/ads/internal/model/ConfigPayload$LogMetricsSettings;", "getLoggingEnabled$annotations", "getLoggingEnabled", "()Lcom/vungle/ads/internal/model/ConfigPayload$LoggingSettings;", "getPlacements", "()Ljava/util/List;", "getSession$annotations", "getSession", "()Lcom/vungle/ads/internal/model/ConfigPayload$Session;", "getTemplate$annotations", "getTemplate", "()Lcom/vungle/ads/internal/model/ConfigPayload$Template;", "getViewability$annotations", "getViewability", "()Lcom/vungle/ads/internal/model/ConfigPayload$ViewabilitySettings;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/vungle/ads/internal/model/ConfigPayload$Endpoints;Ljava/util/List;Lcom/vungle/ads/internal/model/ConfigPayload$ConfigSettings;Lcom/vungle/ads/internal/model/ConfigPayload$GDPRSettings;Lcom/vungle/ads/internal/model/ConfigPayload$LoggingSettings;Lcom/vungle/ads/internal/model/ConfigPayload$CrashReportSettings;Lcom/vungle/ads/internal/model/ConfigPayload$ViewabilitySettings;Lcom/vungle/ads/internal/model/ConfigPayload$LoadOptimizationSettings;Lcom/vungle/ads/internal/model/ConfigPayload$ReportIncentivizedSettings;Ljava/lang/Boolean;Ljava/lang/String;Lcom/vungle/ads/internal/model/ConfigPayload$Template;Lcom/vungle/ads/internal/model/ConfigPayload$LogMetricsSettings;Lcom/vungle/ads/internal/model/ConfigPayload$Session;Lcom/vungle/ads/internal/model/CleverCache;)Lcom/vungle/ads/internal/model/ConfigPayload;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "ConfigSettings", "CrashReportSettings", "Endpoints", "GDPRSettings", "LoadOptimizationSettings", "LogMetricsSettings", "LoggingSettings", "ReportIncentivizedSettings", "Session", "Template", "ViewabilitySettings", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: ConfigPayload.kt */
public final class ConfigPayload {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CleverCache cleverCache;
    private final ConfigSettings config;
    private final String configExtension;
    private final CrashReportSettings crashReport;
    private final Boolean disableAdId;
    private final Endpoints endpoints;
    private final GDPRSettings gdpr;
    private final LoadOptimizationSettings isAdDownloadOptEnabled;
    private final ReportIncentivizedSettings isReportIncentivizedEnabled;
    private final LogMetricsSettings logMetricsSettings;
    private final LoggingSettings loggingEnabled;
    private final List<Placement> placements;
    private final Session session;
    private final Template template;
    private final ViewabilitySettings viewability;

    public ConfigPayload() {
        this((Endpoints) null, (List) null, (ConfigSettings) null, (GDPRSettings) null, (LoggingSettings) null, (CrashReportSettings) null, (ViewabilitySettings) null, (LoadOptimizationSettings) null, (ReportIncentivizedSettings) null, (Boolean) null, (String) null, (Template) null, (LogMetricsSettings) null, (Session) null, (CleverCache) null, 32767, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ConfigPayload copy$default(ConfigPayload configPayload, Endpoints endpoints2, List list, ConfigSettings configSettings, GDPRSettings gDPRSettings, LoggingSettings loggingSettings, CrashReportSettings crashReportSettings, ViewabilitySettings viewabilitySettings, LoadOptimizationSettings loadOptimizationSettings, ReportIncentivizedSettings reportIncentivizedSettings, Boolean bool, String str, Template template2, LogMetricsSettings logMetricsSettings2, Session session2, CleverCache cleverCache2, int i, Object obj) {
        ConfigPayload configPayload2 = configPayload;
        int i2 = i;
        return configPayload.copy((i2 & 1) != 0 ? configPayload2.endpoints : endpoints2, (i2 & 2) != 0 ? configPayload2.placements : list, (i2 & 4) != 0 ? configPayload2.config : configSettings, (i2 & 8) != 0 ? configPayload2.gdpr : gDPRSettings, (i2 & 16) != 0 ? configPayload2.loggingEnabled : loggingSettings, (i2 & 32) != 0 ? configPayload2.crashReport : crashReportSettings, (i2 & 64) != 0 ? configPayload2.viewability : viewabilitySettings, (i2 & 128) != 0 ? configPayload2.isAdDownloadOptEnabled : loadOptimizationSettings, (i2 & 256) != 0 ? configPayload2.isReportIncentivizedEnabled : reportIncentivizedSettings, (i2 & 512) != 0 ? configPayload2.disableAdId : bool, (i2 & 1024) != 0 ? configPayload2.configExtension : str, (i2 & 2048) != 0 ? configPayload2.template : template2, (i2 & 4096) != 0 ? configPayload2.logMetricsSettings : logMetricsSettings2, (i2 & 8192) != 0 ? configPayload2.session : session2, (i2 & 16384) != 0 ? configPayload2.cleverCache : cleverCache2);
    }

    @SerialName("reuse_assets")
    public static /* synthetic */ void getCleverCache$annotations() {
    }

    @SerialName("config_extension")
    public static /* synthetic */ void getConfigExtension$annotations() {
    }

    @SerialName("crash_report")
    public static /* synthetic */ void getCrashReport$annotations() {
    }

    @SerialName("disable_ad_id")
    public static /* synthetic */ void getDisableAdId$annotations() {
    }

    @SerialName("log_metrics")
    public static /* synthetic */ void getLogMetricsSettings$annotations() {
    }

    @SerialName("logging")
    public static /* synthetic */ void getLoggingEnabled$annotations() {
    }

    @SerialName("session")
    public static /* synthetic */ void getSession$annotations() {
    }

    @SerialName("template")
    public static /* synthetic */ void getTemplate$annotations() {
    }

    @SerialName("viewability")
    public static /* synthetic */ void getViewability$annotations() {
    }

    @SerialName("ad_load_optimization")
    public static /* synthetic */ void isAdDownloadOptEnabled$annotations() {
    }

    @SerialName("ri")
    public static /* synthetic */ void isReportIncentivizedEnabled$annotations() {
    }

    public final Endpoints component1() {
        return this.endpoints;
    }

    public final Boolean component10() {
        return this.disableAdId;
    }

    public final String component11() {
        return this.configExtension;
    }

    public final Template component12() {
        return this.template;
    }

    public final LogMetricsSettings component13() {
        return this.logMetricsSettings;
    }

    public final Session component14() {
        return this.session;
    }

    public final CleverCache component15() {
        return this.cleverCache;
    }

    public final List<Placement> component2() {
        return this.placements;
    }

    public final ConfigSettings component3() {
        return this.config;
    }

    public final GDPRSettings component4() {
        return this.gdpr;
    }

    public final LoggingSettings component5() {
        return this.loggingEnabled;
    }

    public final CrashReportSettings component6() {
        return this.crashReport;
    }

    public final ViewabilitySettings component7() {
        return this.viewability;
    }

    public final LoadOptimizationSettings component8() {
        return this.isAdDownloadOptEnabled;
    }

    public final ReportIncentivizedSettings component9() {
        return this.isReportIncentivizedEnabled;
    }

    public final ConfigPayload copy(Endpoints endpoints2, List<Placement> list, ConfigSettings configSettings, GDPRSettings gDPRSettings, LoggingSettings loggingSettings, CrashReportSettings crashReportSettings, ViewabilitySettings viewabilitySettings, LoadOptimizationSettings loadOptimizationSettings, ReportIncentivizedSettings reportIncentivizedSettings, Boolean bool, String str, Template template2, LogMetricsSettings logMetricsSettings2, Session session2, CleverCache cleverCache2) {
        return new ConfigPayload(endpoints2, list, configSettings, gDPRSettings, loggingSettings, crashReportSettings, viewabilitySettings, loadOptimizationSettings, reportIncentivizedSettings, bool, str, template2, logMetricsSettings2, session2, cleverCache2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigPayload)) {
            return false;
        }
        ConfigPayload configPayload = (ConfigPayload) obj;
        return Intrinsics.areEqual((Object) this.endpoints, (Object) configPayload.endpoints) && Intrinsics.areEqual((Object) this.placements, (Object) configPayload.placements) && Intrinsics.areEqual((Object) this.config, (Object) configPayload.config) && Intrinsics.areEqual((Object) this.gdpr, (Object) configPayload.gdpr) && Intrinsics.areEqual((Object) this.loggingEnabled, (Object) configPayload.loggingEnabled) && Intrinsics.areEqual((Object) this.crashReport, (Object) configPayload.crashReport) && Intrinsics.areEqual((Object) this.viewability, (Object) configPayload.viewability) && Intrinsics.areEqual((Object) this.isAdDownloadOptEnabled, (Object) configPayload.isAdDownloadOptEnabled) && Intrinsics.areEqual((Object) this.isReportIncentivizedEnabled, (Object) configPayload.isReportIncentivizedEnabled) && Intrinsics.areEqual((Object) this.disableAdId, (Object) configPayload.disableAdId) && Intrinsics.areEqual((Object) this.configExtension, (Object) configPayload.configExtension) && Intrinsics.areEqual((Object) this.template, (Object) configPayload.template) && Intrinsics.areEqual((Object) this.logMetricsSettings, (Object) configPayload.logMetricsSettings) && Intrinsics.areEqual((Object) this.session, (Object) configPayload.session) && Intrinsics.areEqual((Object) this.cleverCache, (Object) configPayload.cleverCache);
    }

    public int hashCode() {
        Endpoints endpoints2 = this.endpoints;
        int i = 0;
        int hashCode = (endpoints2 == null ? 0 : endpoints2.hashCode()) * 31;
        List<Placement> list = this.placements;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        ConfigSettings configSettings = this.config;
        int hashCode3 = (hashCode2 + (configSettings == null ? 0 : configSettings.hashCode())) * 31;
        GDPRSettings gDPRSettings = this.gdpr;
        int hashCode4 = (hashCode3 + (gDPRSettings == null ? 0 : gDPRSettings.hashCode())) * 31;
        LoggingSettings loggingSettings = this.loggingEnabled;
        int hashCode5 = (hashCode4 + (loggingSettings == null ? 0 : loggingSettings.hashCode())) * 31;
        CrashReportSettings crashReportSettings = this.crashReport;
        int hashCode6 = (hashCode5 + (crashReportSettings == null ? 0 : crashReportSettings.hashCode())) * 31;
        ViewabilitySettings viewabilitySettings = this.viewability;
        int hashCode7 = (hashCode6 + (viewabilitySettings == null ? 0 : viewabilitySettings.hashCode())) * 31;
        LoadOptimizationSettings loadOptimizationSettings = this.isAdDownloadOptEnabled;
        int hashCode8 = (hashCode7 + (loadOptimizationSettings == null ? 0 : loadOptimizationSettings.hashCode())) * 31;
        ReportIncentivizedSettings reportIncentivizedSettings = this.isReportIncentivizedEnabled;
        int hashCode9 = (hashCode8 + (reportIncentivizedSettings == null ? 0 : reportIncentivizedSettings.hashCode())) * 31;
        Boolean bool = this.disableAdId;
        int hashCode10 = (hashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.configExtension;
        int hashCode11 = (hashCode10 + (str == null ? 0 : str.hashCode())) * 31;
        Template template2 = this.template;
        int hashCode12 = (hashCode11 + (template2 == null ? 0 : template2.hashCode())) * 31;
        LogMetricsSettings logMetricsSettings2 = this.logMetricsSettings;
        int hashCode13 = (hashCode12 + (logMetricsSettings2 == null ? 0 : logMetricsSettings2.hashCode())) * 31;
        Session session2 = this.session;
        int hashCode14 = (hashCode13 + (session2 == null ? 0 : session2.hashCode())) * 31;
        CleverCache cleverCache2 = this.cleverCache;
        if (cleverCache2 != null) {
            i = cleverCache2.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        return "ConfigPayload(endpoints=" + this.endpoints + ", placements=" + this.placements + ", config=" + this.config + ", gdpr=" + this.gdpr + ", loggingEnabled=" + this.loggingEnabled + ", crashReport=" + this.crashReport + ", viewability=" + this.viewability + ", isAdDownloadOptEnabled=" + this.isAdDownloadOptEnabled + ", isReportIncentivizedEnabled=" + this.isReportIncentivizedEnabled + ", disableAdId=" + this.disableAdId + ", configExtension=" + this.configExtension + ", template=" + this.template + ", logMetricsSettings=" + this.logMetricsSettings + ", session=" + this.session + ", cleverCache=" + this.cleverCache + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConfigPayload.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConfigPayload> serializer() {
            return ConfigPayload$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ConfigPayload(int i, Endpoints endpoints2, List list, ConfigSettings configSettings, GDPRSettings gDPRSettings, @SerialName("logging") LoggingSettings loggingSettings, @SerialName("crash_report") CrashReportSettings crashReportSettings, @SerialName("viewability") ViewabilitySettings viewabilitySettings, @SerialName("ad_load_optimization") LoadOptimizationSettings loadOptimizationSettings, @SerialName("ri") ReportIncentivizedSettings reportIncentivizedSettings, @SerialName("disable_ad_id") Boolean bool, @SerialName("config_extension") String str, @SerialName("template") Template template2, @SerialName("log_metrics") LogMetricsSettings logMetricsSettings2, @SerialName("session") Session session2, @SerialName("reuse_assets") CleverCache cleverCache2, SerializationConstructorMarker serializationConstructorMarker) {
        boolean z;
        int i2 = i;
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, ConfigPayload$$serializer.INSTANCE.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.endpoints = null;
        } else {
            this.endpoints = endpoints2;
        }
        if ((i2 & 2) == 0) {
            this.placements = null;
        } else {
            this.placements = list;
        }
        if ((i2 & 4) == 0) {
            this.config = null;
        } else {
            this.config = configSettings;
        }
        if ((i2 & 8) == 0) {
            this.gdpr = null;
        } else {
            this.gdpr = gDPRSettings;
        }
        if ((i2 & 16) == 0) {
            this.loggingEnabled = null;
        } else {
            this.loggingEnabled = loggingSettings;
        }
        if ((i2 & 32) == 0) {
            this.crashReport = null;
        } else {
            this.crashReport = crashReportSettings;
        }
        if ((i2 & 64) == 0) {
            this.viewability = null;
        } else {
            this.viewability = viewabilitySettings;
        }
        if ((i2 & 128) == 0) {
            this.isAdDownloadOptEnabled = null;
        } else {
            this.isAdDownloadOptEnabled = loadOptimizationSettings;
        }
        if ((i2 & 256) == 0) {
            this.isReportIncentivizedEnabled = null;
        } else {
            this.isReportIncentivizedEnabled = reportIncentivizedSettings;
        }
        if ((i2 & 512) == 0) {
            z = true;
        } else {
            z = bool;
        }
        this.disableAdId = z;
        if ((i2 & 1024) == 0) {
            this.configExtension = null;
        } else {
            this.configExtension = str;
        }
        if ((i2 & 2048) == 0) {
            this.template = null;
        } else {
            this.template = template2;
        }
        if ((i2 & 4096) == 0) {
            this.logMetricsSettings = null;
        } else {
            this.logMetricsSettings = logMetricsSettings2;
        }
        if ((i2 & 8192) == 0) {
            this.session = null;
        } else {
            this.session = session2;
        }
        if ((i2 & 16384) == 0) {
            this.cleverCache = null;
        } else {
            this.cleverCache = cleverCache2;
        }
    }

    public ConfigPayload(Endpoints endpoints2, List<Placement> list, ConfigSettings configSettings, GDPRSettings gDPRSettings, LoggingSettings loggingSettings, CrashReportSettings crashReportSettings, ViewabilitySettings viewabilitySettings, LoadOptimizationSettings loadOptimizationSettings, ReportIncentivizedSettings reportIncentivizedSettings, Boolean bool, String str, Template template2, LogMetricsSettings logMetricsSettings2, Session session2, CleverCache cleverCache2) {
        this.endpoints = endpoints2;
        this.placements = list;
        this.config = configSettings;
        this.gdpr = gDPRSettings;
        this.loggingEnabled = loggingSettings;
        this.crashReport = crashReportSettings;
        this.viewability = viewabilitySettings;
        this.isAdDownloadOptEnabled = loadOptimizationSettings;
        this.isReportIncentivizedEnabled = reportIncentivizedSettings;
        this.disableAdId = bool;
        this.configExtension = str;
        this.template = template2;
        this.logMetricsSettings = logMetricsSettings2;
        this.session = session2;
        this.cleverCache = cleverCache2;
    }

    @JvmStatic
    public static final void write$Self(ConfigPayload configPayload, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(configPayload, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z2 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || configPayload.endpoints != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, ConfigPayload$Endpoints$$serializer.INSTANCE, configPayload.endpoints);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || configPayload.placements != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, new ArrayListSerializer(Placement$$serializer.INSTANCE), configPayload.placements);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || configPayload.config != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, ConfigPayload$ConfigSettings$$serializer.INSTANCE, configPayload.config);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || configPayload.gdpr != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, ConfigPayload$GDPRSettings$$serializer.INSTANCE, configPayload.gdpr);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || configPayload.loggingEnabled != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, ConfigPayload$LoggingSettings$$serializer.INSTANCE, configPayload.loggingEnabled);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || configPayload.crashReport != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, ConfigPayload$CrashReportSettings$$serializer.INSTANCE, configPayload.crashReport);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || configPayload.viewability != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, ConfigPayload$ViewabilitySettings$$serializer.INSTANCE, configPayload.viewability);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || configPayload.isAdDownloadOptEnabled != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, ConfigPayload$LoadOptimizationSettings$$serializer.INSTANCE, configPayload.isAdDownloadOptEnabled);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || configPayload.isReportIncentivizedEnabled != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, ConfigPayload$ReportIncentivizedSettings$$serializer.INSTANCE, configPayload.isReportIncentivizedEnabled);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) && Intrinsics.areEqual((Object) configPayload.disableAdId, (Object) true)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, BooleanSerializer.INSTANCE, configPayload.disableAdId);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) || configPayload.configExtension != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, configPayload.configExtension);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) || configPayload.template != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 11, ConfigPayload$Template$$serializer.INSTANCE, configPayload.template);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 12) || configPayload.logMetricsSettings != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 12, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE, configPayload.logMetricsSettings);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) || configPayload.session != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 13, ConfigPayload$Session$$serializer.INSTANCE, configPayload.session);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 14) || configPayload.cleverCache != null) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 14, CleverCache$$serializer.INSTANCE, configPayload.cleverCache);
        }
    }

    public final Endpoints getEndpoints() {
        return this.endpoints;
    }

    public final List<Placement> getPlacements() {
        return this.placements;
    }

    public final ConfigSettings getConfig() {
        return this.config;
    }

    public final GDPRSettings getGdpr() {
        return this.gdpr;
    }

    public final LoggingSettings getLoggingEnabled() {
        return this.loggingEnabled;
    }

    public final CrashReportSettings getCrashReport() {
        return this.crashReport;
    }

    public final ViewabilitySettings getViewability() {
        return this.viewability;
    }

    public final LoadOptimizationSettings isAdDownloadOptEnabled() {
        return this.isAdDownloadOptEnabled;
    }

    public final ReportIncentivizedSettings isReportIncentivizedEnabled() {
        return this.isReportIncentivizedEnabled;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConfigPayload(com.vungle.ads.internal.model.ConfigPayload.Endpoints r17, java.util.List r18, com.vungle.ads.internal.model.ConfigPayload.ConfigSettings r19, com.vungle.ads.internal.model.ConfigPayload.GDPRSettings r20, com.vungle.ads.internal.model.ConfigPayload.LoggingSettings r21, com.vungle.ads.internal.model.ConfigPayload.CrashReportSettings r22, com.vungle.ads.internal.model.ConfigPayload.ViewabilitySettings r23, com.vungle.ads.internal.model.ConfigPayload.LoadOptimizationSettings r24, com.vungle.ads.internal.model.ConfigPayload.ReportIncentivizedSettings r25, java.lang.Boolean r26, java.lang.String r27, com.vungle.ads.internal.model.ConfigPayload.Template r28, com.vungle.ads.internal.model.ConfigPayload.LogMetricsSettings r29, com.vungle.ads.internal.model.ConfigPayload.Session r30, com.vungle.ads.internal.model.CleverCache r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0055
            r11 = 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            goto L_0x0057
        L_0x0055:
            r11 = r26
        L_0x0057:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005d
            r12 = r2
            goto L_0x005f
        L_0x005d:
            r12 = r27
        L_0x005f:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0065
            r13 = r2
            goto L_0x0067
        L_0x0065:
            r13 = r28
        L_0x0067:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006d
            r14 = r2
            goto L_0x006f
        L_0x006d:
            r14 = r29
        L_0x006f:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0075
            r15 = r2
            goto L_0x0077
        L_0x0075:
            r15 = r30
        L_0x0077:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r2 = r31
        L_0x007e:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload.<init>(com.vungle.ads.internal.model.ConfigPayload$Endpoints, java.util.List, com.vungle.ads.internal.model.ConfigPayload$ConfigSettings, com.vungle.ads.internal.model.ConfigPayload$GDPRSettings, com.vungle.ads.internal.model.ConfigPayload$LoggingSettings, com.vungle.ads.internal.model.ConfigPayload$CrashReportSettings, com.vungle.ads.internal.model.ConfigPayload$ViewabilitySettings, com.vungle.ads.internal.model.ConfigPayload$LoadOptimizationSettings, com.vungle.ads.internal.model.ConfigPayload$ReportIncentivizedSettings, java.lang.Boolean, java.lang.String, com.vungle.ads.internal.model.ConfigPayload$Template, com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings, com.vungle.ads.internal.model.ConfigPayload$Session, com.vungle.ads.internal.model.CleverCache, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean getDisableAdId() {
        return this.disableAdId;
    }

    public final String getConfigExtension() {
        return this.configExtension;
    }

    public final Template getTemplate() {
        return this.template;
    }

    public final LogMetricsSettings getLogMetricsSettings() {
        return this.logMetricsSettings;
    }

    public final Session getSession() {
        return this.session;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u0001:\u0002,-BU\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fBA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J!\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÇ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006."}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$Endpoints;", "", "seen1", "", "adsEndpoint", "", "riEndpoint", "mraidEndpoint", "metricsEndpoint", "errorLogsEndpoint", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdsEndpoint$annotations", "()V", "getAdsEndpoint", "()Ljava/lang/String;", "getErrorLogsEndpoint$annotations", "getErrorLogsEndpoint", "getMetricsEndpoint$annotations", "getMetricsEndpoint", "getMraidEndpoint$annotations", "getMraidEndpoint", "getRiEndpoint$annotations", "getRiEndpoint", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class Endpoints {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String adsEndpoint;
        private final String errorLogsEndpoint;
        private final String metricsEndpoint;
        private final String mraidEndpoint;
        private final String riEndpoint;

        public Endpoints() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Endpoints copy$default(Endpoints endpoints, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = endpoints.adsEndpoint;
            }
            if ((i & 2) != 0) {
                str2 = endpoints.riEndpoint;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = endpoints.mraidEndpoint;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = endpoints.metricsEndpoint;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = endpoints.errorLogsEndpoint;
            }
            return endpoints.copy(str, str6, str7, str8, str5);
        }

        @SerialName("ads")
        public static /* synthetic */ void getAdsEndpoint$annotations() {
        }

        @SerialName("error_logs")
        public static /* synthetic */ void getErrorLogsEndpoint$annotations() {
        }

        @SerialName("metrics")
        public static /* synthetic */ void getMetricsEndpoint$annotations() {
        }

        @SerialName("mraid_js")
        public static /* synthetic */ void getMraidEndpoint$annotations() {
        }

        @SerialName("ri")
        public static /* synthetic */ void getRiEndpoint$annotations() {
        }

        public final String component1() {
            return this.adsEndpoint;
        }

        public final String component2() {
            return this.riEndpoint;
        }

        public final String component3() {
            return this.mraidEndpoint;
        }

        public final String component4() {
            return this.metricsEndpoint;
        }

        public final String component5() {
            return this.errorLogsEndpoint;
        }

        public final Endpoints copy(String str, String str2, String str3, String str4, String str5) {
            return new Endpoints(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Endpoints)) {
                return false;
            }
            Endpoints endpoints = (Endpoints) obj;
            return Intrinsics.areEqual((Object) this.adsEndpoint, (Object) endpoints.adsEndpoint) && Intrinsics.areEqual((Object) this.riEndpoint, (Object) endpoints.riEndpoint) && Intrinsics.areEqual((Object) this.mraidEndpoint, (Object) endpoints.mraidEndpoint) && Intrinsics.areEqual((Object) this.metricsEndpoint, (Object) endpoints.metricsEndpoint) && Intrinsics.areEqual((Object) this.errorLogsEndpoint, (Object) endpoints.errorLogsEndpoint);
        }

        public int hashCode() {
            String str = this.adsEndpoint;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.riEndpoint;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.mraidEndpoint;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.metricsEndpoint;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.errorLogsEndpoint;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "Endpoints(adsEndpoint=" + this.adsEndpoint + ", riEndpoint=" + this.riEndpoint + ", mraidEndpoint=" + this.mraidEndpoint + ", metricsEndpoint=" + this.metricsEndpoint + ", errorLogsEndpoint=" + this.errorLogsEndpoint + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$Endpoints$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$Endpoints;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Endpoints> serializer() {
                return ConfigPayload$Endpoints$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Endpoints(int i, @SerialName("ads") String str, @SerialName("ri") String str2, @SerialName("mraid_js") String str3, @SerialName("metrics") String str4, @SerialName("error_logs") String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, ConfigPayload$Endpoints$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.adsEndpoint = null;
            } else {
                this.adsEndpoint = str;
            }
            if ((i & 2) == 0) {
                this.riEndpoint = null;
            } else {
                this.riEndpoint = str2;
            }
            if ((i & 4) == 0) {
                this.mraidEndpoint = null;
            } else {
                this.mraidEndpoint = str3;
            }
            if ((i & 8) == 0) {
                this.metricsEndpoint = null;
            } else {
                this.metricsEndpoint = str4;
            }
            if ((i & 16) == 0) {
                this.errorLogsEndpoint = null;
            } else {
                this.errorLogsEndpoint = str5;
            }
        }

        public Endpoints(String str, String str2, String str3, String str4, String str5) {
            this.adsEndpoint = str;
            this.riEndpoint = str2;
            this.mraidEndpoint = str3;
            this.metricsEndpoint = str4;
            this.errorLogsEndpoint = str5;
        }

        @JvmStatic
        public static final void write$Self(Endpoints endpoints, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(endpoints, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || endpoints.adsEndpoint != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, endpoints.adsEndpoint);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || endpoints.riEndpoint != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, endpoints.riEndpoint);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || endpoints.mraidEndpoint != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, endpoints.mraidEndpoint);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || endpoints.metricsEndpoint != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, endpoints.metricsEndpoint);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || endpoints.errorLogsEndpoint != null) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, endpoints.errorLogsEndpoint);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Endpoints(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
            /*
                r4 = this;
                r11 = r10 & 1
                r0 = 0
                if (r11 == 0) goto L_0x0007
                r11 = r0
                goto L_0x0008
            L_0x0007:
                r11 = r5
            L_0x0008:
                r5 = r10 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r10 & 4
                if (r5 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r7
            L_0x0016:
                r5 = r10 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r10 & 16
                if (r5 == 0) goto L_0x0023
                r10 = r0
                goto L_0x0024
            L_0x0023:
                r10 = r9
            L_0x0024:
                r5 = r4
                r6 = r11
                r7 = r1
                r8 = r2
                r9 = r3
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload.Endpoints.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getAdsEndpoint() {
            return this.adsEndpoint;
        }

        public final String getRiEndpoint() {
            return this.riEndpoint;
        }

        public final String getMraidEndpoint() {
            return this.mraidEndpoint;
        }

        public final String getMetricsEndpoint() {
            return this.metricsEndpoint;
        }

        public final String getErrorLogsEndpoint() {
            return this.errorLogsEndpoint;
        }
    }

    public final CleverCache getCleverCache() {
        return this.cleverCache;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$ConfigSettings;", "", "seen1", "", "refreshTime", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(I)V", "getRefreshTime$annotations", "()V", "getRefreshTime", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class ConfigSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int refreshTime;

        public static /* synthetic */ ConfigSettings copy$default(ConfigSettings configSettings, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = configSettings.refreshTime;
            }
            return configSettings.copy(i);
        }

        @SerialName("refresh_time")
        public static /* synthetic */ void getRefreshTime$annotations() {
        }

        public final int component1() {
            return this.refreshTime;
        }

        public final ConfigSettings copy(int i) {
            return new ConfigSettings(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConfigSettings) && this.refreshTime == ((ConfigSettings) obj).refreshTime;
        }

        public int hashCode() {
            return this.refreshTime;
        }

        public String toString() {
            return "ConfigSettings(refreshTime=" + this.refreshTime + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$ConfigSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$ConfigSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ConfigSettings> serializer() {
                return ConfigPayload$ConfigSettings$$serializer.INSTANCE;
            }
        }

        public ConfigSettings(int i) {
            this.refreshTime = i;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ConfigSettings(int i, @SerialName("refresh_time") int i2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ConfigPayload$ConfigSettings$$serializer.INSTANCE.getDescriptor());
            }
            this.refreshTime = i2;
        }

        @JvmStatic
        public static final void write$Self(ConfigSettings configSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(configSettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeIntElement(serialDescriptor, 0, configSettings.refreshTime);
        }

        public final int getRefreshTime() {
            return this.refreshTime;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 12\u00020\u0001:\u000201B_\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001J!\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÇ\u0001R\u001c\u0010\n\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u0004\u0010\u001d¨\u00062"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$GDPRSettings;", "", "seen1", "", "isCountryDataProtected", "", "consentTitle", "", "consentMessage", "consentMessageVersion", "buttonAccept", "buttonDeny", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonAccept$annotations", "()V", "getButtonAccept", "()Ljava/lang/String;", "getButtonDeny$annotations", "getButtonDeny", "getConsentMessage$annotations", "getConsentMessage", "getConsentMessageVersion$annotations", "getConsentMessageVersion", "getConsentTitle$annotations", "getConsentTitle", "isCountryDataProtected$annotations", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class GDPRSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String buttonAccept;
        private final String buttonDeny;
        private final String consentMessage;
        private final String consentMessageVersion;
        private final String consentTitle;
        private final boolean isCountryDataProtected;

        public static /* synthetic */ GDPRSettings copy$default(GDPRSettings gDPRSettings, boolean z, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                z = gDPRSettings.isCountryDataProtected;
            }
            if ((i & 2) != 0) {
                str = gDPRSettings.consentTitle;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = gDPRSettings.consentMessage;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = gDPRSettings.consentMessageVersion;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = gDPRSettings.buttonAccept;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = gDPRSettings.buttonDeny;
            }
            return gDPRSettings.copy(z, str6, str7, str8, str9, str5);
        }

        @SerialName("button_accept")
        public static /* synthetic */ void getButtonAccept$annotations() {
        }

        @SerialName("button_deny")
        public static /* synthetic */ void getButtonDeny$annotations() {
        }

        @SerialName("consent_message")
        public static /* synthetic */ void getConsentMessage$annotations() {
        }

        @SerialName("consent_message_version")
        public static /* synthetic */ void getConsentMessageVersion$annotations() {
        }

        @SerialName("consent_title")
        public static /* synthetic */ void getConsentTitle$annotations() {
        }

        @SerialName("is_country_data_protected")
        public static /* synthetic */ void isCountryDataProtected$annotations() {
        }

        public final boolean component1() {
            return this.isCountryDataProtected;
        }

        public final String component2() {
            return this.consentTitle;
        }

        public final String component3() {
            return this.consentMessage;
        }

        public final String component4() {
            return this.consentMessageVersion;
        }

        public final String component5() {
            return this.buttonAccept;
        }

        public final String component6() {
            return this.buttonDeny;
        }

        public final GDPRSettings copy(boolean z, String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "consentTitle");
            Intrinsics.checkNotNullParameter(str2, "consentMessage");
            Intrinsics.checkNotNullParameter(str3, "consentMessageVersion");
            Intrinsics.checkNotNullParameter(str4, "buttonAccept");
            Intrinsics.checkNotNullParameter(str5, "buttonDeny");
            return new GDPRSettings(z, str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GDPRSettings)) {
                return false;
            }
            GDPRSettings gDPRSettings = (GDPRSettings) obj;
            return this.isCountryDataProtected == gDPRSettings.isCountryDataProtected && Intrinsics.areEqual((Object) this.consentTitle, (Object) gDPRSettings.consentTitle) && Intrinsics.areEqual((Object) this.consentMessage, (Object) gDPRSettings.consentMessage) && Intrinsics.areEqual((Object) this.consentMessageVersion, (Object) gDPRSettings.consentMessageVersion) && Intrinsics.areEqual((Object) this.buttonAccept, (Object) gDPRSettings.buttonAccept) && Intrinsics.areEqual((Object) this.buttonDeny, (Object) gDPRSettings.buttonDeny);
        }

        public int hashCode() {
            boolean z = this.isCountryDataProtected;
            if (z) {
                z = true;
            }
            return ((((((((((z ? 1 : 0) * true) + this.consentTitle.hashCode()) * 31) + this.consentMessage.hashCode()) * 31) + this.consentMessageVersion.hashCode()) * 31) + this.buttonAccept.hashCode()) * 31) + this.buttonDeny.hashCode();
        }

        public String toString() {
            return "GDPRSettings(isCountryDataProtected=" + this.isCountryDataProtected + ", consentTitle=" + this.consentTitle + ", consentMessage=" + this.consentMessage + ", consentMessageVersion=" + this.consentMessageVersion + ", buttonAccept=" + this.buttonAccept + ", buttonDeny=" + this.buttonDeny + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$GDPRSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$GDPRSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<GDPRSettings> serializer() {
                return ConfigPayload$GDPRSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ GDPRSettings(int i, @SerialName("is_country_data_protected") boolean z, @SerialName("consent_title") String str, @SerialName("consent_message") String str2, @SerialName("consent_message_version") String str3, @SerialName("button_accept") String str4, @SerialName("button_deny") String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i, 63, ConfigPayload$GDPRSettings$$serializer.INSTANCE.getDescriptor());
            }
            this.isCountryDataProtected = z;
            this.consentTitle = str;
            this.consentMessage = str2;
            this.consentMessageVersion = str3;
            this.buttonAccept = str4;
            this.buttonDeny = str5;
        }

        public GDPRSettings(boolean z, String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "consentTitle");
            Intrinsics.checkNotNullParameter(str2, "consentMessage");
            Intrinsics.checkNotNullParameter(str3, "consentMessageVersion");
            Intrinsics.checkNotNullParameter(str4, "buttonAccept");
            Intrinsics.checkNotNullParameter(str5, "buttonDeny");
            this.isCountryDataProtected = z;
            this.consentTitle = str;
            this.consentMessage = str2;
            this.consentMessageVersion = str3;
            this.buttonAccept = str4;
            this.buttonDeny = str5;
        }

        @JvmStatic
        public static final void write$Self(GDPRSettings gDPRSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(gDPRSettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeBooleanElement(serialDescriptor, 0, gDPRSettings.isCountryDataProtected);
            compositeEncoder.encodeStringElement(serialDescriptor, 1, gDPRSettings.consentTitle);
            compositeEncoder.encodeStringElement(serialDescriptor, 2, gDPRSettings.consentMessage);
            compositeEncoder.encodeStringElement(serialDescriptor, 3, gDPRSettings.consentMessageVersion);
            compositeEncoder.encodeStringElement(serialDescriptor, 4, gDPRSettings.buttonAccept);
            compositeEncoder.encodeStringElement(serialDescriptor, 5, gDPRSettings.buttonDeny);
        }

        public final boolean isCountryDataProtected() {
            return this.isCountryDataProtected;
        }

        public final String getConsentTitle() {
            return this.consentTitle;
        }

        public final String getConsentMessage() {
            return this.consentMessage;
        }

        public final String getConsentMessageVersion() {
            return this.consentMessageVersion;
        }

        public final String getButtonAccept() {
            return this.buttonAccept;
        }

        public final String getButtonDeny() {
            return this.buttonDeny;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$LoggingSettings;", "", "seen1", "", "enabled", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class LoggingSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean enabled;

        public LoggingSettings() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ LoggingSettings copy$default(LoggingSettings loggingSettings, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = loggingSettings.enabled;
            }
            return loggingSettings.copy(z);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final LoggingSettings copy(boolean z) {
            return new LoggingSettings(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoggingSettings) && this.enabled == ((LoggingSettings) obj).enabled;
        }

        public int hashCode() {
            boolean z = this.enabled;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "LoggingSettings(enabled=" + this.enabled + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$LoggingSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$LoggingSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LoggingSettings> serializer() {
                return ConfigPayload$LoggingSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ LoggingSettings(int i, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, ConfigPayload$LoggingSettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.enabled = false;
            } else {
                this.enabled = z;
            }
        }

        public LoggingSettings(boolean z) {
            this.enabled = z;
        }

        @JvmStatic
        public static final void write$Self(LoggingSettings loggingSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(loggingSettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z = true;
            if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && !loggingSettings.enabled) {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeBooleanElement(serialDescriptor, 0, loggingSettings.enabled);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LoggingSettings(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getEnabled() {
            return this.enabled;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$CrashReportSettings;", "", "seen1", "", "enabled", "", "maxSendAmount", "collectFilter", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZILjava/lang/String;)V", "getCollectFilter$annotations", "()V", "getCollectFilter", "()Ljava/lang/String;", "getEnabled", "()Z", "getMaxSendAmount$annotations", "getMaxSendAmount", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class CrashReportSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String collectFilter;
        private final boolean enabled;
        private final int maxSendAmount;

        public static /* synthetic */ CrashReportSettings copy$default(CrashReportSettings crashReportSettings, boolean z, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = crashReportSettings.enabled;
            }
            if ((i2 & 2) != 0) {
                i = crashReportSettings.maxSendAmount;
            }
            if ((i2 & 4) != 0) {
                str = crashReportSettings.collectFilter;
            }
            return crashReportSettings.copy(z, i, str);
        }

        @SerialName("collect_filter")
        public static /* synthetic */ void getCollectFilter$annotations() {
        }

        @SerialName("max_send_amount")
        public static /* synthetic */ void getMaxSendAmount$annotations() {
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final int component2() {
            return this.maxSendAmount;
        }

        public final String component3() {
            return this.collectFilter;
        }

        public final CrashReportSettings copy(boolean z, int i, String str) {
            Intrinsics.checkNotNullParameter(str, "collectFilter");
            return new CrashReportSettings(z, i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CrashReportSettings)) {
                return false;
            }
            CrashReportSettings crashReportSettings = (CrashReportSettings) obj;
            return this.enabled == crashReportSettings.enabled && this.maxSendAmount == crashReportSettings.maxSendAmount && Intrinsics.areEqual((Object) this.collectFilter, (Object) crashReportSettings.collectFilter);
        }

        public int hashCode() {
            boolean z = this.enabled;
            if (z) {
                z = true;
            }
            return ((((z ? 1 : 0) * true) + this.maxSendAmount) * 31) + this.collectFilter.hashCode();
        }

        public String toString() {
            return "CrashReportSettings(enabled=" + this.enabled + ", maxSendAmount=" + this.maxSendAmount + ", collectFilter=" + this.collectFilter + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$CrashReportSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$CrashReportSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CrashReportSettings> serializer() {
                return ConfigPayload$CrashReportSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CrashReportSettings(int i, boolean z, @SerialName("max_send_amount") int i2, @SerialName("collect_filter") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (6 != (i & 6)) {
                PluginExceptionsKt.throwMissingFieldException(i, 6, ConfigPayload$CrashReportSettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.enabled = false;
            } else {
                this.enabled = z;
            }
            this.maxSendAmount = i2;
            this.collectFilter = str;
        }

        public CrashReportSettings(boolean z, int i, String str) {
            Intrinsics.checkNotNullParameter(str, "collectFilter");
            this.enabled = z;
            this.maxSendAmount = i;
            this.collectFilter = str;
        }

        @JvmStatic
        public static final void write$Self(CrashReportSettings crashReportSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(crashReportSettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || crashReportSettings.enabled) {
                compositeEncoder.encodeBooleanElement(serialDescriptor, 0, crashReportSettings.enabled);
            }
            compositeEncoder.encodeIntElement(serialDescriptor, 1, crashReportSettings.maxSendAmount);
            compositeEncoder.encodeStringElement(serialDescriptor, 2, crashReportSettings.collectFilter);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CrashReportSettings(boolean z, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z, i, str);
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final int getMaxSendAmount() {
            return this.maxSendAmount;
        }

        public final String getCollectFilter() {
            return this.collectFilter;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$ViewabilitySettings;", "", "seen1", "", "om", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Z)V", "getOm", "()Z", "component1", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class ViewabilitySettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean om;

        public static /* synthetic */ ViewabilitySettings copy$default(ViewabilitySettings viewabilitySettings, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = viewabilitySettings.om;
            }
            return viewabilitySettings.copy(z);
        }

        public final boolean component1() {
            return this.om;
        }

        public final ViewabilitySettings copy(boolean z) {
            return new ViewabilitySettings(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ViewabilitySettings) && this.om == ((ViewabilitySettings) obj).om;
        }

        public int hashCode() {
            boolean z = this.om;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ViewabilitySettings(om=" + this.om + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$ViewabilitySettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$ViewabilitySettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ViewabilitySettings> serializer() {
                return ConfigPayload$ViewabilitySettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ViewabilitySettings(int i, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ConfigPayload$ViewabilitySettings$$serializer.INSTANCE.getDescriptor());
            }
            this.om = z;
        }

        public ViewabilitySettings(boolean z) {
            this.om = z;
        }

        @JvmStatic
        public static final void write$Self(ViewabilitySettings viewabilitySettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(viewabilitySettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeBooleanElement(serialDescriptor, 0, viewabilitySettings.om);
        }

        public final boolean getOm() {
            return this.om;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$LoadOptimizationSettings;", "", "seen1", "", "enabled", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class LoadOptimizationSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean enabled;

        public static /* synthetic */ LoadOptimizationSettings copy$default(LoadOptimizationSettings loadOptimizationSettings, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = loadOptimizationSettings.enabled;
            }
            return loadOptimizationSettings.copy(z);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final LoadOptimizationSettings copy(boolean z) {
            return new LoadOptimizationSettings(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadOptimizationSettings) && this.enabled == ((LoadOptimizationSettings) obj).enabled;
        }

        public int hashCode() {
            boolean z = this.enabled;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "LoadOptimizationSettings(enabled=" + this.enabled + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$LoadOptimizationSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$LoadOptimizationSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LoadOptimizationSettings> serializer() {
                return ConfigPayload$LoadOptimizationSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ LoadOptimizationSettings(int i, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ConfigPayload$LoadOptimizationSettings$$serializer.INSTANCE.getDescriptor());
            }
            this.enabled = z;
        }

        public LoadOptimizationSettings(boolean z) {
            this.enabled = z;
        }

        @JvmStatic
        public static final void write$Self(LoadOptimizationSettings loadOptimizationSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(loadOptimizationSettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeBooleanElement(serialDescriptor, 0, loadOptimizationSettings.enabled);
        }

        public final boolean getEnabled() {
            return this.enabled;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$ReportIncentivizedSettings;", "", "seen1", "", "enabled", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class ReportIncentivizedSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean enabled;

        public static /* synthetic */ ReportIncentivizedSettings copy$default(ReportIncentivizedSettings reportIncentivizedSettings, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = reportIncentivizedSettings.enabled;
            }
            return reportIncentivizedSettings.copy(z);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final ReportIncentivizedSettings copy(boolean z) {
            return new ReportIncentivizedSettings(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReportIncentivizedSettings) && this.enabled == ((ReportIncentivizedSettings) obj).enabled;
        }

        public int hashCode() {
            boolean z = this.enabled;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ReportIncentivizedSettings(enabled=" + this.enabled + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$ReportIncentivizedSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$ReportIncentivizedSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ReportIncentivizedSettings> serializer() {
                return ConfigPayload$ReportIncentivizedSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ReportIncentivizedSettings(int i, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ConfigPayload$ReportIncentivizedSettings$$serializer.INSTANCE.getDescriptor());
            }
            this.enabled = z;
        }

        public ReportIncentivizedSettings(boolean z) {
            this.enabled = z;
        }

        @JvmStatic
        public static final void write$Self(ReportIncentivizedSettings reportIncentivizedSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(reportIncentivizedSettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeBooleanElement(serialDescriptor, 0, reportIncentivizedSettings.enabled);
        }

        public final boolean getEnabled() {
            return this.enabled;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$Template;", "", "seen1", "", "heartbeatEnabled", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Z)V", "getHeartbeatEnabled$annotations", "()V", "getHeartbeatEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class Template {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean heartbeatEnabled;

        public static /* synthetic */ Template copy$default(Template template, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = template.heartbeatEnabled;
            }
            return template.copy(z);
        }

        @SerialName("heartbeat_check_enabled")
        public static /* synthetic */ void getHeartbeatEnabled$annotations() {
        }

        public final boolean component1() {
            return this.heartbeatEnabled;
        }

        public final Template copy(boolean z) {
            return new Template(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Template) && this.heartbeatEnabled == ((Template) obj).heartbeatEnabled;
        }

        public int hashCode() {
            boolean z = this.heartbeatEnabled;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "Template(heartbeatEnabled=" + this.heartbeatEnabled + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$Template$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$Template;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Template> serializer() {
                return ConfigPayload$Template$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Template(int i, @SerialName("heartbeat_check_enabled") boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ConfigPayload$Template$$serializer.INSTANCE.getDescriptor());
            }
            this.heartbeatEnabled = z;
        }

        public Template(boolean z) {
            this.heartbeatEnabled = z;
        }

        @JvmStatic
        public static final void write$Self(Template template, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(template, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeBooleanElement(serialDescriptor, 0, template.heartbeatEnabled);
        }

        public final boolean getHeartbeatEnabled() {
            return this.heartbeatEnabled;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$LogMetricsSettings;", "", "seen1", "", "errorLogLevel", "metricsEnabled", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(IZ)V", "getErrorLogLevel$annotations", "()V", "getErrorLogLevel", "()I", "getMetricsEnabled$annotations", "getMetricsEnabled", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class LogMetricsSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int errorLogLevel;
        private final boolean metricsEnabled;

        public static /* synthetic */ LogMetricsSettings copy$default(LogMetricsSettings logMetricsSettings, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = logMetricsSettings.errorLogLevel;
            }
            if ((i2 & 2) != 0) {
                z = logMetricsSettings.metricsEnabled;
            }
            return logMetricsSettings.copy(i, z);
        }

        @SerialName("error_log_level")
        public static /* synthetic */ void getErrorLogLevel$annotations() {
        }

        @SerialName("metrics_is_enabled")
        public static /* synthetic */ void getMetricsEnabled$annotations() {
        }

        public final int component1() {
            return this.errorLogLevel;
        }

        public final boolean component2() {
            return this.metricsEnabled;
        }

        public final LogMetricsSettings copy(int i, boolean z) {
            return new LogMetricsSettings(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LogMetricsSettings)) {
                return false;
            }
            LogMetricsSettings logMetricsSettings = (LogMetricsSettings) obj;
            return this.errorLogLevel == logMetricsSettings.errorLogLevel && this.metricsEnabled == logMetricsSettings.metricsEnabled;
        }

        public int hashCode() {
            int i = this.errorLogLevel * 31;
            boolean z = this.metricsEnabled;
            if (z) {
                z = true;
            }
            return i + (z ? 1 : 0);
        }

        public String toString() {
            return "LogMetricsSettings(errorLogLevel=" + this.errorLogLevel + ", metricsEnabled=" + this.metricsEnabled + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$LogMetricsSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$LogMetricsSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LogMetricsSettings> serializer() {
                return ConfigPayload$LogMetricsSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ LogMetricsSettings(int i, @SerialName("error_log_level") int i2, @SerialName("metrics_is_enabled") boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE.getDescriptor());
            }
            this.errorLogLevel = i2;
            this.metricsEnabled = z;
        }

        public LogMetricsSettings(int i, boolean z) {
            this.errorLogLevel = i;
            this.metricsEnabled = z;
        }

        @JvmStatic
        public static final void write$Self(LogMetricsSettings logMetricsSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(logMetricsSettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeIntElement(serialDescriptor, 0, logMetricsSettings.errorLogLevel);
            compositeEncoder.encodeBooleanElement(serialDescriptor, 1, logMetricsSettings.metricsEnabled);
        }

        public final int getErrorLogLevel() {
            return this.errorLogLevel;
        }

        public final boolean getMetricsEnabled() {
            return this.metricsEnabled;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0012¨\u0006'"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$Session;", "", "seen1", "", "enabled", "", "limit", "timeout", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZII)V", "getEnabled$annotations", "()V", "getEnabled", "()Z", "getLimit$annotations", "getLimit", "()I", "getTimeout$annotations", "getTimeout", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: ConfigPayload.kt */
    public static final class Session {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean enabled;
        private final int limit;
        private final int timeout;

        public static /* synthetic */ Session copy$default(Session session, boolean z, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z = session.enabled;
            }
            if ((i3 & 2) != 0) {
                i = session.limit;
            }
            if ((i3 & 4) != 0) {
                i2 = session.timeout;
            }
            return session.copy(z, i, i2);
        }

        @SerialName("enabled")
        public static /* synthetic */ void getEnabled$annotations() {
        }

        @SerialName("limit")
        public static /* synthetic */ void getLimit$annotations() {
        }

        @SerialName("timeout")
        public static /* synthetic */ void getTimeout$annotations() {
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final int component2() {
            return this.limit;
        }

        public final int component3() {
            return this.timeout;
        }

        public final Session copy(boolean z, int i, int i2) {
            return new Session(z, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Session)) {
                return false;
            }
            Session session = (Session) obj;
            return this.enabled == session.enabled && this.limit == session.limit && this.timeout == session.timeout;
        }

        public int hashCode() {
            boolean z = this.enabled;
            if (z) {
                z = true;
            }
            return ((((z ? 1 : 0) * true) + this.limit) * 31) + this.timeout;
        }

        public String toString() {
            return "Session(enabled=" + this.enabled + ", limit=" + this.limit + ", timeout=" + this.timeout + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$Session$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload$Session;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ConfigPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Session> serializer() {
                return ConfigPayload$Session$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Session(int i, @SerialName("enabled") boolean z, @SerialName("limit") int i2, @SerialName("timeout") int i3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, ConfigPayload$Session$$serializer.INSTANCE.getDescriptor());
            }
            this.enabled = z;
            this.limit = i2;
            this.timeout = i3;
        }

        public Session(boolean z, int i, int i2) {
            this.enabled = z;
            this.limit = i;
            this.timeout = i2;
        }

        @JvmStatic
        public static final void write$Self(Session session, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(session, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeBooleanElement(serialDescriptor, 0, session.enabled);
            compositeEncoder.encodeIntElement(serialDescriptor, 1, session.limit);
            compositeEncoder.encodeIntElement(serialDescriptor, 2, session.timeout);
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final int getLimit() {
            return this.limit;
        }

        public final int getTimeout() {
            return this.timeout;
        }
    }
}
