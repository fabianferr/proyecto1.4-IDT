package com.vungle.ads.internal.model;

import com.facebook.internal.AnalyticsEvents;
import com.vungle.ads.AdConfig;
import com.vungle.ads.BannerAdSize;
import com.vungle.ads.internal.util.FileUtility;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonTransformingSerializer;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 b2\u00020\u0001:\t_`abcdefgB_\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0016\b\u0001\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\b\u00106\u001a\u0004\u0018\u00010\u001dJ\b\u00107\u001a\u0004\u0018\u00010\tJ\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u0004\u0018\u00010\tJ\b\u0010;\u001a\u0004\u0018\u00010\tJ\u0006\u0010<\u001a\u00020\tJ\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0>J\u0006\u0010?\u001a\u00020\u0003J\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\b\u0010A\u001a\u0004\u0018\u00010\tJ\u0015\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010DJ\"\u0010E\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0006\u0010F\u001a\u00020\t2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\tJ\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005J\u0006\u0010I\u001a\u00020\fJ\u0006\u0010J\u001a\u00020\fJ\u0006\u0010K\u001a\u00020\fJ\u0006\u0010L\u001a\u00020\fJ\b\u0010M\u001a\u0004\u0018\u00010\tJ\u0006\u0010N\u001a\u00020OJ&\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\tJ\u001c\u0010U\u001a\u00020O2\u0006\u0010V\u001a\u00020(2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\t0\u0005J\b\u0010X\u001a\u0004\u0018\u00010\tJ!\u0010Y\u001a\u00020O2\u0006\u0010Z\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^HÇ\u0001R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R*\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010(8\u0006@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010,R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R0\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u0017\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload;", "", "seen1", "", "ads", "", "Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit;", "mraidFiles", "", "", "incentivizedTextSettings", "assetsFullyDownloaded", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/Map;Ljava/util/Map;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "ad", "getAd", "()Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit;", "adConfig", "Lcom/vungle/ads/AdConfig;", "getAdConfig$annotations", "()V", "getAdConfig", "()Lcom/vungle/ads/AdConfig;", "setAdConfig", "(Lcom/vungle/ads/AdConfig;)V", "adMarkup", "Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "getAdMarkup", "()Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "adSize", "Lcom/vungle/ads/BannerAdSize;", "getAdSize$annotations", "getAdSize", "()Lcom/vungle/ads/BannerAdSize;", "setAdSize", "(Lcom/vungle/ads/BannerAdSize;)V", "<set-?>", "Ljava/io/File;", "assetDirectory", "getAssetDirectory$annotations", "getAssetDirectory", "()Ljava/io/File;", "getAssetsFullyDownloaded", "()Z", "setAssetsFullyDownloaded", "(Z)V", "getIncentivizedTextSettings$annotations", "getIncentivizedTextSettings", "()Ljava/util/Map;", "setIncentivizedTextSettings", "(Ljava/util/Map;)V", "adUnit", "appId", "createMRAIDArgs", "Lkotlinx/serialization/json/JsonObject;", "eventId", "getAdType", "getCreativeId", "getDownloadableUrls", "", "getExpiry", "getMRAIDArgsInMap", "getMainVideoUrl", "getShowCloseDelay", "incentivized", "(Ljava/lang/Boolean;)I", "getTpatUrls", "event", "value", "getWinNotifications", "hasExpired", "isClickCoordinatesTrackingEnabled", "isNativeTemplateType", "omEnabled", "placementId", "setAssetFullyDownloaded", "", "setIncentivizedText", "title", "body", "keepWatching", "close", "setMraidAssetDir", "dir", "downloadedAssets", "templateType", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "AdUnit", "CacheableReplacement", "Companion", "PlacementAdUnit", "TemplateSettings", "TpatSerializer", "Viewability", "ViewabilityInfo", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: AdPayload.kt */
public final class AdPayload {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FILE_SCHEME = "file://";
    public static final String INCENTIVIZED_BODY_TEXT = "INCENTIVIZED_BODY_TEXT";
    public static final String INCENTIVIZED_CLOSE_TEXT = "INCENTIVIZED_CLOSE_TEXT";
    public static final String INCENTIVIZED_CONTINUE_TEXT = "INCENTIVIZED_CONTINUE_TEXT";
    public static final String INCENTIVIZED_TITLE_TEXT = "INCENTIVIZED_TITLE_TEXT";
    public static final String KEY_POSTROLL = "postroll";
    public static final String KEY_TEMPLATE = "template";
    public static final String TPAT_CLICK_COORDINATES_URLS = "video.clickCoordinates";
    public static final String TYPE_VUNGLE_MRAID = "vungle_mraid";
    private static final String UNKNOWN = "unknown";
    private AdConfig adConfig;
    private BannerAdSize adSize;
    private final List<PlacementAdUnit> ads;
    private File assetDirectory;
    private boolean assetsFullyDownloaded;
    private Map<String, String> incentivizedTextSettings;
    private Map<String, String> mraidFiles;

    public AdPayload() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    @Transient
    public static /* synthetic */ void getAdConfig$annotations() {
    }

    @Transient
    public static /* synthetic */ void getAdSize$annotations() {
    }

    @Transient
    public static /* synthetic */ void getAssetDirectory$annotations() {
    }

    public static /* synthetic */ void getIncentivizedTextSettings$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AdPayload(int i, List list, Map map, Map map2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, AdPayload$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.ads = null;
        } else {
            this.ads = list;
        }
        if ((i & 2) == 0) {
            this.mraidFiles = new HashMap();
        } else {
            this.mraidFiles = map;
        }
        if ((i & 4) == 0) {
            this.incentivizedTextSettings = new HashMap();
        } else {
            this.incentivizedTextSettings = map2;
        }
        if ((i & 8) == 0) {
            this.assetsFullyDownloaded = false;
        } else {
            this.assetsFullyDownloaded = z;
        }
        this.adConfig = null;
        this.adSize = null;
        this.assetDirectory = null;
    }

    public AdPayload(List<PlacementAdUnit> list) {
        this.ads = list;
        this.mraidFiles = new HashMap();
        this.incentivizedTextSettings = new HashMap();
    }

    @JvmStatic
    public static final void write$Self(AdPayload adPayload, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(adPayload, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z3 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || adPayload.ads != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, new ArrayListSerializer(AdPayload$PlacementAdUnit$$serializer.INSTANCE), adPayload.ads);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) && Intrinsics.areEqual((Object) adPayload.mraidFiles, (Object) new HashMap())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), adPayload.mraidFiles);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && Intrinsics.areEqual((Object) adPayload.incentivizedTextSettings, (Object) new HashMap())) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), adPayload.incentivizedTextSettings);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || adPayload.assetsFullyDownloaded) {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 3, adPayload.assetsFullyDownloaded);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdPayload(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$Companion;", "", "()V", "FILE_SCHEME", "", "INCENTIVIZED_BODY_TEXT", "INCENTIVIZED_CLOSE_TEXT", "INCENTIVIZED_CONTINUE_TEXT", "INCENTIVIZED_TITLE_TEXT", "KEY_POSTROLL", "KEY_TEMPLATE", "TPAT_CLICK_COORDINATES_URLS", "TYPE_VUNGLE_MRAID", "UNKNOWN", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdPayload.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdPayload> serializer() {
            return AdPayload$$serializer.INSTANCE;
        }
    }

    private final PlacementAdUnit getAd() {
        List<PlacementAdUnit> list = this.ads;
        if (list == null) {
            return null;
        }
        if (!list.isEmpty()) {
            return list.get(0);
        }
        PlacementAdUnit placementAdUnit = null;
        return null;
    }

    private final AdUnit getAdMarkup() {
        PlacementAdUnit ad = getAd();
        if (ad != null) {
            return ad.getAdMarkup();
        }
        return null;
    }

    public final String placementId() {
        PlacementAdUnit ad = getAd();
        if (ad != null) {
            return ad.getPlacementReferenceId();
        }
        return null;
    }

    public final String eventId() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getId();
        }
        return null;
    }

    public final String appId() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getAdvAppId();
        }
        return null;
    }

    public final AdUnit adUnit() {
        return getAdMarkup();
    }

    public final Map<String, String> getIncentivizedTextSettings() {
        return this.incentivizedTextSettings;
    }

    public final void setIncentivizedTextSettings(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.incentivizedTextSettings = map;
    }

    public final boolean getAssetsFullyDownloaded() {
        return this.assetsFullyDownloaded;
    }

    public final void setAssetsFullyDownloaded(boolean z) {
        this.assetsFullyDownloaded = z;
    }

    public final String getAdType() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getAdType();
        }
        return null;
    }

    public final AdConfig getAdConfig() {
        return this.adConfig;
    }

    public final void setAdConfig(AdConfig adConfig2) {
        this.adConfig = adConfig2;
    }

    public final BannerAdSize getAdSize() {
        return this.adSize;
    }

    public final void setAdSize(BannerAdSize bannerAdSize) {
        this.adSize = bannerAdSize;
    }

    public final File getAssetDirectory() {
        return this.assetDirectory;
    }

    public final boolean omEnabled() {
        Viewability viewability;
        ViewabilityInfo om;
        Boolean isEnabled;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (viewability = adMarkup.getViewability()) == null || (om = viewability.getOm()) == null || (isEnabled = om.isEnabled()) == null) {
            return false;
        }
        return isEnabled.booleanValue();
    }

    public final boolean isClickCoordinatesTrackingEnabled() {
        Boolean clickCoordinatesEnabled;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (clickCoordinatesEnabled = adMarkup.getClickCoordinatesEnabled()) == null) {
            return false;
        }
        return clickCoordinatesEnabled.booleanValue();
    }

    public final Map<String, String> getDownloadableUrls() {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        AdUnit adMarkup;
        String templateURL;
        HashMap hashMap = new HashMap();
        if (!isNativeTemplateType() && (adMarkup = getAdMarkup()) != null && (templateURL = adMarkup.getTemplateURL()) != null && FileUtility.INSTANCE.isValidUrl(templateURL)) {
            hashMap.put("template", templateURL);
        }
        AdUnit adMarkup2 = getAdMarkup();
        if (!(adMarkup2 == null || (templateSettings = adMarkup2.getTemplateSettings()) == null || (cacheableReplacements = templateSettings.getCacheableReplacements()) == null)) {
            for (Map.Entry next : cacheableReplacements.entrySet()) {
                String url = ((CacheableReplacement) next.getValue()).getUrl();
                if (url != null && FileUtility.INSTANCE.isValidUrl(url)) {
                    hashMap.put(FileUtility.INSTANCE.guessFileName(url, ((CacheableReplacement) next.getValue()).getExtension()), url);
                }
            }
        }
        return hashMap;
    }

    public final String getMainVideoUrl() {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        CacheableReplacement cacheableReplacement;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (templateSettings = adMarkup.getTemplateSettings()) == null || (cacheableReplacements = templateSettings.getCacheableReplacements()) == null || (cacheableReplacement = cacheableReplacements.get("MAIN_VIDEO")) == null) {
            return null;
        }
        String url = cacheableReplacement.getUrl();
        if (FileUtility.INSTANCE.isValidUrl(url)) {
            return url;
        }
        return null;
    }

    public static /* synthetic */ List getTpatUrls$default(AdPayload adPayload, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return adPayload.getTpatUrls(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = r0.getTpat();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> getTpatUrls(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.vungle.ads.internal.model.AdPayload$AdUnit r0 = r10.getAdMarkup()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            java.util.Map r0 = r0.getTpat()
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.containsKey(r11)
            if (r0 != 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r3 = 0
            if (r0 == 0) goto L_0x0041
            com.vungle.ads.AnalyticsClient r4 = com.vungle.ads.AnalyticsClient.INSTANCE
            r5 = 128(0x80, float:1.794E-43)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid tpat key: "
            r12.<init>(r0)
            r12.append(r11)
            java.lang.String r6 = r12.toString()
            java.lang.String r7 = r10.placementId()
            java.lang.String r8 = r10.getCreativeId()
            java.lang.String r9 = r10.eventId()
            r4.logError$vungle_ads_release((int) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)
            return r3
        L_0x0041:
            com.vungle.ads.internal.model.AdPayload$AdUnit r0 = r10.getAdMarkup()
            if (r0 == 0) goto L_0x0054
            java.util.Map r0 = r0.getTpat()
            if (r0 == 0) goto L_0x0054
            java.lang.Object r0 = r0.get(r11)
            java.util.List r0 = (java.util.List) r0
            goto L_0x0055
        L_0x0054:
            r0 = r3
        L_0x0055:
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x0060
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0061
        L_0x0060:
            r2 = 1
        L_0x0061:
            if (r2 == 0) goto L_0x0085
            com.vungle.ads.AnalyticsClient r4 = com.vungle.ads.AnalyticsClient.INSTANCE
            r5 = 129(0x81, float:1.81E-43)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Empty tpat key: "
            r12.<init>(r0)
            r12.append(r11)
            java.lang.String r6 = r12.toString()
            java.lang.String r7 = r10.placementId()
            java.lang.String r8 = r10.getCreativeId()
            java.lang.String r9 = r10.eventId()
            r4.logError$vungle_ads_release((int) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)
            return r3
        L_0x0085:
            java.lang.String r2 = "checkpoint.0"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x00c9
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r11 = (java.util.List) r11
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r12 = r0.iterator()
        L_0x009a:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x00c8
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "{{{remote_play}}}"
            java.lang.String r2 = java.util.regex.Pattern.quote(r2)
            java.lang.String r3 = "quote(REMOTE_PLAY_KEY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            kotlin.text.Regex r3 = new kotlin.text.Regex
            r3.<init>((java.lang.String) r2)
            boolean r2 = r10.assetsFullyDownloaded
            r2 = r2 ^ r1
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r3.replace((java.lang.CharSequence) r0, (java.lang.String) r2)
            r11.add(r0)
            goto L_0x009a
        L_0x00c8:
            return r11
        L_0x00c9:
            java.lang.String r1 = "deeplink.click"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r1)
            if (r11 == 0) goto L_0x010c
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r11 = (java.util.List) r11
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00de:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x010b
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "{{{is_success}}}"
            java.lang.String r2 = java.util.regex.Pattern.quote(r2)
            java.lang.String r3 = "quote(DEEPLINK_SUCCESS_KEY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            kotlin.text.Regex r3 = new kotlin.text.Regex
            r3.<init>((java.lang.String) r2)
            if (r12 != 0) goto L_0x0102
            java.lang.String r2 = ""
            goto L_0x0103
        L_0x0102:
            r2 = r12
        L_0x0103:
            java.lang.String r1 = r3.replace((java.lang.CharSequence) r1, (java.lang.String) r2)
            r11.add(r1)
            goto L_0x00de
        L_0x010b:
            return r11
        L_0x010c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload.getTpatUrls(java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean hasExpired() {
        Integer expiry;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (expiry = adMarkup.getExpiry()) == null) {
            return false;
        }
        if (((long) expiry.intValue()) < System.currentTimeMillis() / 1000) {
            return true;
        }
        return false;
    }

    public final List<String> getWinNotifications() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getNotification();
        }
        return null;
    }

    public final boolean isNativeTemplateType() {
        AdUnit adMarkup = getAdMarkup();
        return Intrinsics.areEqual((Object) AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, (Object) adMarkup != null ? adMarkup.getTemplateType() : null);
    }

    public final String templateType() {
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup != null) {
            return adMarkup.getTemplateType();
        }
        return null;
    }

    public final void setIncentivizedText(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "body");
        Intrinsics.checkNotNullParameter(str3, "keepWatching");
        Intrinsics.checkNotNullParameter(str4, "close");
        boolean z = true;
        if (str.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_TITLE_TEXT, str);
        }
        if (str2.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_BODY_TEXT, str2);
        }
        if (str3.length() > 0) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CONTINUE_TEXT, str3);
        }
        if (str4.length() <= 0) {
            z = false;
        }
        if (z) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CLOSE_TEXT, str4);
        }
    }

    public final void setMraidAssetDir(File file, List<String> list) {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        Intrinsics.checkNotNullParameter(file, "dir");
        Intrinsics.checkNotNullParameter(list, "downloadedAssets");
        AdUnit adMarkup = getAdMarkup();
        if ((adMarkup != null ? adMarkup.getTemplateSettings() : null) != null) {
            this.assetDirectory = file;
            AdUnit adMarkup2 = getAdMarkup();
            if (adMarkup2 != null && (templateSettings = adMarkup2.getTemplateSettings()) != null && (cacheableReplacements = templateSettings.getCacheableReplacements()) != null) {
                for (Map.Entry next : cacheableReplacements.entrySet()) {
                    String url = ((CacheableReplacement) next.getValue()).getUrl();
                    if (url != null && FileUtility.INSTANCE.isValidUrl(url)) {
                        File file2 = new File(file, FileUtility.INSTANCE.guessFileName(url, ((CacheableReplacement) next.getValue()).getExtension()));
                        if (file2.exists() && list.contains(file2.getAbsolutePath())) {
                            Map<String, String> map = this.mraidFiles;
                            Object key = next.getKey();
                            map.put(key, FILE_SCHEME + file2.getPath());
                        }
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!".toString());
    }

    public final void setAssetFullyDownloaded() {
        this.assetsFullyDownloaded = true;
    }

    public final Map<String, String> getMRAIDArgsInMap() {
        TemplateSettings templateSettings;
        Map<String, CacheableReplacement> cacheableReplacements;
        TemplateSettings templateSettings2;
        Map<String, String> normalReplacements;
        AdUnit adMarkup = getAdMarkup();
        if ((adMarkup != null ? adMarkup.getTemplateSettings() : null) != null) {
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
            AdUnit adMarkup2 = getAdMarkup();
            if (!(adMarkup2 == null || (templateSettings2 = adMarkup2.getTemplateSettings()) == null || (normalReplacements = templateSettings2.getNormalReplacements()) == null)) {
                linkedHashMap.putAll(normalReplacements);
            }
            AdUnit adMarkup3 = getAdMarkup();
            if (!(adMarkup3 == null || (templateSettings = adMarkup3.getTemplateSettings()) == null || (cacheableReplacements = templateSettings.getCacheableReplacements()) == null)) {
                for (Map.Entry next : cacheableReplacements.entrySet()) {
                    String url = ((CacheableReplacement) next.getValue()).getUrl();
                    if (url != null) {
                        linkedHashMap.put(next.getKey(), url);
                    }
                }
            }
            if (!this.mraidFiles.isEmpty()) {
                linkedHashMap.putAll(this.mraidFiles);
            }
            if (!this.incentivizedTextSettings.isEmpty()) {
                linkedHashMap.putAll(this.incentivizedTextSettings);
            }
            return linkedHashMap;
        }
        throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!".toString());
    }

    public final JsonObject createMRAIDArgs() {
        Map<String, String> mRAIDArgsInMap = getMRAIDArgsInMap();
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry next : mRAIDArgsInMap.entrySet()) {
            JsonElementBuildersKt.put(jsonObjectBuilder, (String) next.getKey(), (String) next.getValue());
        }
        return jsonObjectBuilder.build();
    }

    public final int getShowCloseDelay(Boolean bool) {
        Integer showClose;
        Integer showCloseIncentivized;
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            AdUnit adMarkup = getAdMarkup();
            if (adMarkup == null || (showCloseIncentivized = adMarkup.getShowCloseIncentivized()) == null) {
                return 0;
            }
            return showCloseIncentivized.intValue() * 1000;
        }
        AdUnit adMarkup2 = getAdMarkup();
        if (adMarkup2 == null || (showClose = adMarkup2.getShowClose()) == null) {
            return 0;
        }
        return showClose.intValue() * 1000;
    }

    public final String getCreativeId() {
        String campaign;
        AdUnit adMarkup = getAdMarkup();
        String str = null;
        if (!(adMarkup == null || (campaign = adMarkup.getCampaign()) == null)) {
            CharSequence charSequence = campaign;
            if (charSequence.length() > 0) {
                Object[] array = new Regex("\\|").split(charSequence, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (strArr.length >= 2) {
                    str = strArr[1];
                }
            }
        }
        return str == null ? "unknown" : str;
    }

    public final int getExpiry() {
        Integer expiry;
        AdUnit adMarkup = getAdMarkup();
        if (adMarkup == null || (expiry = adMarkup.getExpiry()) == null) {
            return 0;
        }
        return expiry.intValue();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit;", "", "seen1", "", "placementReferenceId", "", "adMarkup", "Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$AdUnit;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$AdUnit;)V", "getAdMarkup$annotations", "()V", "getAdMarkup", "()Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "getPlacementReferenceId$annotations", "getPlacementReferenceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: AdPayload.kt */
    public static final class PlacementAdUnit {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final AdUnit adMarkup;
        private final String placementReferenceId;

        public PlacementAdUnit() {
            this((String) null, (AdUnit) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PlacementAdUnit copy$default(PlacementAdUnit placementAdUnit, String str, AdUnit adUnit, int i, Object obj) {
            if ((i & 1) != 0) {
                str = placementAdUnit.placementReferenceId;
            }
            if ((i & 2) != 0) {
                adUnit = placementAdUnit.adMarkup;
            }
            return placementAdUnit.copy(str, adUnit);
        }

        @SerialName("ad_markup")
        public static /* synthetic */ void getAdMarkup$annotations() {
        }

        @SerialName("placement_reference_id")
        public static /* synthetic */ void getPlacementReferenceId$annotations() {
        }

        public final String component1() {
            return this.placementReferenceId;
        }

        public final AdUnit component2() {
            return this.adMarkup;
        }

        public final PlacementAdUnit copy(String str, AdUnit adUnit) {
            return new PlacementAdUnit(str, adUnit);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlacementAdUnit)) {
                return false;
            }
            PlacementAdUnit placementAdUnit = (PlacementAdUnit) obj;
            return Intrinsics.areEqual((Object) this.placementReferenceId, (Object) placementAdUnit.placementReferenceId) && Intrinsics.areEqual((Object) this.adMarkup, (Object) placementAdUnit.adMarkup);
        }

        public int hashCode() {
            String str = this.placementReferenceId;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            AdUnit adUnit = this.adMarkup;
            if (adUnit != null) {
                i = adUnit.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "PlacementAdUnit(placementReferenceId=" + this.placementReferenceId + ", adMarkup=" + this.adMarkup + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$PlacementAdUnit;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<PlacementAdUnit> serializer() {
                return AdPayload$PlacementAdUnit$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ PlacementAdUnit(int i, @SerialName("placement_reference_id") String str, @SerialName("ad_markup") AdUnit adUnit, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, AdPayload$PlacementAdUnit$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.placementReferenceId = null;
            } else {
                this.placementReferenceId = str;
            }
            if ((i & 2) == 0) {
                this.adMarkup = null;
            } else {
                this.adMarkup = adUnit;
            }
        }

        public PlacementAdUnit(String str, AdUnit adUnit) {
            this.placementReferenceId = str;
            this.adMarkup = adUnit;
        }

        @JvmStatic
        public static final void write$Self(PlacementAdUnit placementAdUnit, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(placementAdUnit, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || placementAdUnit.placementReferenceId != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, placementAdUnit.placementReferenceId);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || placementAdUnit.adMarkup != null) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, AdPayload$AdUnit$$serializer.INSTANCE, placementAdUnit.adMarkup);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PlacementAdUnit(String str, AdUnit adUnit, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : adUnit);
        }

        public final String getPlacementReferenceId() {
            return this.placementReferenceId;
        }

        public final AdUnit getAdMarkup() {
            return this.adMarkup;
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 |2\u00020\u0001:\u0002{|BË\u0002\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u001c\b\u0001\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0010\b\u0001\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&BÛ\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010'J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010U\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0018\u00010\u0010HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010<J\u000b\u0010^\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0011\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010<J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010<J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00107Jä\u0002\u0010n\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020\u000e2\b\u0010q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010r\u001a\u00020\u0003HÖ\u0001J\t\u0010s\u001a\u00020\u0005HÖ\u0001J!\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00002\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zHÇ\u0001R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010)R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010+\u001a\u0004\b0\u0010)R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010+\u001a\u0004\b2\u0010)R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\b5\u0010+\u001a\u0004\b6\u00107R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R \u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0010\n\u0002\u0010=\u0012\u0004\b:\u0010+\u001a\u0004\b;\u0010<R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010=\u001a\u0004\b>\u0010<R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010)R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010)R$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010+\u001a\u0004\bB\u0010CR\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bD\u0010CR\u0015\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010=\u001a\u0004\bE\u0010<R\u0015\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010=\u001a\u0004\bF\u0010<R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010=\u001a\u0004\bG\u0010<R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010+\u001a\u0004\bL\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010)R\u0015\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010=\u001a\u0004\bN\u0010<R0\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0018\u00010\u00108\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010+\u001a\u0004\bP\u0010QR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006}"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "", "seen1", "", "id", "", "adType", "adSource", "campaign", "expiry", "advAppId", "callToActionUrl", "deeplinkUrl", "clickCoordinatesEnabled", "", "tpat", "", "", "templateURL", "templateId", "templateType", "templateSettings", "Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;", "bidToken", "adMarketId", "info", "sleep", "viewability", "Lcom/vungle/ads/internal/model/AdPayload$Viewability;", "adExt", "notification", "loadAdUrls", "timestamp", "showCloseIncentivized", "showClose", "errorCode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/AdPayload$Viewability;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/AdPayload$Viewability;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAdExt", "()Ljava/lang/String;", "getAdMarketId$annotations", "()V", "getAdMarketId", "getAdSource", "getAdType", "getAdvAppId$annotations", "getAdvAppId", "getBidToken$annotations", "getBidToken", "getCallToActionUrl", "getCampaign", "getClickCoordinatesEnabled$annotations", "getClickCoordinatesEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDeeplinkUrl", "getErrorCode$annotations", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpiry", "getId", "getInfo", "getLoadAdUrls$annotations", "getLoadAdUrls", "()Ljava/util/List;", "getNotification", "getShowClose", "getShowCloseIncentivized", "getSleep", "getTemplateId", "getTemplateSettings", "()Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;", "getTemplateType$annotations", "getTemplateType", "getTemplateURL", "getTimestamp", "getTpat$annotations", "getTpat", "()Ljava/util/Map;", "getViewability", "()Lcom/vungle/ads/internal/model/AdPayload$Viewability;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/AdPayload$Viewability;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: AdPayload.kt */
    public static final class AdUnit {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String adExt;
        private final String adMarketId;
        private final String adSource;
        private final String adType;
        private final String advAppId;
        private final String bidToken;
        private final String callToActionUrl;
        private final String campaign;
        private final Boolean clickCoordinatesEnabled;
        private final String deeplinkUrl;
        private final Integer errorCode;
        private final Integer expiry;
        private final String id;
        private final String info;
        private final List<String> loadAdUrls;
        private final List<String> notification;
        private final Integer showClose;
        private final Integer showCloseIncentivized;
        private final Integer sleep;
        private final String templateId;
        private final TemplateSettings templateSettings;
        private final String templateType;
        private final String templateURL;
        private final Integer timestamp;
        private final Map<String, List<String>> tpat;
        private final Viewability viewability;

        public AdUnit() {
            this((String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Boolean) null, (Map) null, (String) null, (String) null, (String) null, (TemplateSettings) null, (String) null, (String) null, (String) null, (Integer) null, (Viewability) null, (String) null, (List) null, (List) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 67108863, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AdUnit copy$default(AdUnit adUnit, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Boolean bool, Map map, String str8, String str9, String str10, TemplateSettings templateSettings2, String str11, String str12, String str13, Integer num2, Viewability viewability2, String str14, List list, List list2, Integer num3, Integer num4, Integer num5, Integer num6, int i, Object obj) {
            AdUnit adUnit2 = adUnit;
            int i2 = i;
            return adUnit.copy((i2 & 1) != 0 ? adUnit2.id : str, (i2 & 2) != 0 ? adUnit2.adType : str2, (i2 & 4) != 0 ? adUnit2.adSource : str3, (i2 & 8) != 0 ? adUnit2.campaign : str4, (i2 & 16) != 0 ? adUnit2.expiry : num, (i2 & 32) != 0 ? adUnit2.advAppId : str5, (i2 & 64) != 0 ? adUnit2.callToActionUrl : str6, (i2 & 128) != 0 ? adUnit2.deeplinkUrl : str7, (i2 & 256) != 0 ? adUnit2.clickCoordinatesEnabled : bool, (i2 & 512) != 0 ? adUnit2.tpat : map, (i2 & 1024) != 0 ? adUnit2.templateURL : str8, (i2 & 2048) != 0 ? adUnit2.templateId : str9, (i2 & 4096) != 0 ? adUnit2.templateType : str10, (i2 & 8192) != 0 ? adUnit2.templateSettings : templateSettings2, (i2 & 16384) != 0 ? adUnit2.bidToken : str11, (i2 & 32768) != 0 ? adUnit2.adMarketId : str12, (i2 & 65536) != 0 ? adUnit2.info : str13, (i2 & 131072) != 0 ? adUnit2.sleep : num2, (i2 & 262144) != 0 ? adUnit2.viewability : viewability2, (i2 & 524288) != 0 ? adUnit2.adExt : str14, (i2 & 1048576) != 0 ? adUnit2.notification : list, (i2 & 2097152) != 0 ? adUnit2.loadAdUrls : list2, (i2 & 4194304) != 0 ? adUnit2.timestamp : num3, (i2 & 8388608) != 0 ? adUnit2.showCloseIncentivized : num4, (i2 & 16777216) != 0 ? adUnit2.showClose : num5, (i2 & 33554432) != 0 ? adUnit2.errorCode : num6);
        }

        @SerialName("ad_market_id")
        public static /* synthetic */ void getAdMarketId$annotations() {
        }

        @SerialName("app_id")
        public static /* synthetic */ void getAdvAppId$annotations() {
        }

        @SerialName("bid_token")
        public static /* synthetic */ void getBidToken$annotations() {
        }

        @SerialName("click_coordinates_enabled")
        public static /* synthetic */ void getClickCoordinatesEnabled$annotations() {
        }

        @SerialName("error_code")
        public static /* synthetic */ void getErrorCode$annotations() {
        }

        @SerialName("load_ad")
        public static /* synthetic */ void getLoadAdUrls$annotations() {
        }

        @SerialName("template_type")
        public static /* synthetic */ void getTemplateType$annotations() {
        }

        @Serializable(with = TpatSerializer.class)
        public static /* synthetic */ void getTpat$annotations() {
        }

        public final String component1() {
            return this.id;
        }

        public final Map<String, List<String>> component10() {
            return this.tpat;
        }

        public final String component11() {
            return this.templateURL;
        }

        public final String component12() {
            return this.templateId;
        }

        public final String component13() {
            return this.templateType;
        }

        public final TemplateSettings component14() {
            return this.templateSettings;
        }

        public final String component15() {
            return this.bidToken;
        }

        public final String component16() {
            return this.adMarketId;
        }

        public final String component17() {
            return this.info;
        }

        public final Integer component18() {
            return this.sleep;
        }

        public final Viewability component19() {
            return this.viewability;
        }

        public final String component2() {
            return this.adType;
        }

        public final String component20() {
            return this.adExt;
        }

        public final List<String> component21() {
            return this.notification;
        }

        public final List<String> component22() {
            return this.loadAdUrls;
        }

        public final Integer component23() {
            return this.timestamp;
        }

        public final Integer component24() {
            return this.showCloseIncentivized;
        }

        public final Integer component25() {
            return this.showClose;
        }

        public final Integer component26() {
            return this.errorCode;
        }

        public final String component3() {
            return this.adSource;
        }

        public final String component4() {
            return this.campaign;
        }

        public final Integer component5() {
            return this.expiry;
        }

        public final String component6() {
            return this.advAppId;
        }

        public final String component7() {
            return this.callToActionUrl;
        }

        public final String component8() {
            return this.deeplinkUrl;
        }

        public final Boolean component9() {
            return this.clickCoordinatesEnabled;
        }

        public final AdUnit copy(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Boolean bool, Map<String, ? extends List<String>> map, String str8, String str9, String str10, TemplateSettings templateSettings2, String str11, String str12, String str13, Integer num2, Viewability viewability2, String str14, List<String> list, List<String> list2, Integer num3, Integer num4, Integer num5, Integer num6) {
            return new AdUnit(str, str2, str3, str4, num, str5, str6, str7, bool, map, str8, str9, str10, templateSettings2, str11, str12, str13, num2, viewability2, str14, list, list2, num3, num4, num5, num6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdUnit)) {
                return false;
            }
            AdUnit adUnit = (AdUnit) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) adUnit.id) && Intrinsics.areEqual((Object) this.adType, (Object) adUnit.adType) && Intrinsics.areEqual((Object) this.adSource, (Object) adUnit.adSource) && Intrinsics.areEqual((Object) this.campaign, (Object) adUnit.campaign) && Intrinsics.areEqual((Object) this.expiry, (Object) adUnit.expiry) && Intrinsics.areEqual((Object) this.advAppId, (Object) adUnit.advAppId) && Intrinsics.areEqual((Object) this.callToActionUrl, (Object) adUnit.callToActionUrl) && Intrinsics.areEqual((Object) this.deeplinkUrl, (Object) adUnit.deeplinkUrl) && Intrinsics.areEqual((Object) this.clickCoordinatesEnabled, (Object) adUnit.clickCoordinatesEnabled) && Intrinsics.areEqual((Object) this.tpat, (Object) adUnit.tpat) && Intrinsics.areEqual((Object) this.templateURL, (Object) adUnit.templateURL) && Intrinsics.areEqual((Object) this.templateId, (Object) adUnit.templateId) && Intrinsics.areEqual((Object) this.templateType, (Object) adUnit.templateType) && Intrinsics.areEqual((Object) this.templateSettings, (Object) adUnit.templateSettings) && Intrinsics.areEqual((Object) this.bidToken, (Object) adUnit.bidToken) && Intrinsics.areEqual((Object) this.adMarketId, (Object) adUnit.adMarketId) && Intrinsics.areEqual((Object) this.info, (Object) adUnit.info) && Intrinsics.areEqual((Object) this.sleep, (Object) adUnit.sleep) && Intrinsics.areEqual((Object) this.viewability, (Object) adUnit.viewability) && Intrinsics.areEqual((Object) this.adExt, (Object) adUnit.adExt) && Intrinsics.areEqual((Object) this.notification, (Object) adUnit.notification) && Intrinsics.areEqual((Object) this.loadAdUrls, (Object) adUnit.loadAdUrls) && Intrinsics.areEqual((Object) this.timestamp, (Object) adUnit.timestamp) && Intrinsics.areEqual((Object) this.showCloseIncentivized, (Object) adUnit.showCloseIncentivized) && Intrinsics.areEqual((Object) this.showClose, (Object) adUnit.showClose) && Intrinsics.areEqual((Object) this.errorCode, (Object) adUnit.errorCode);
        }

        public int hashCode() {
            String str = this.id;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.adType;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.adSource;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.campaign;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num = this.expiry;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            String str5 = this.advAppId;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.callToActionUrl;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.deeplinkUrl;
            int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Boolean bool = this.clickCoordinatesEnabled;
            int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
            Map<String, List<String>> map = this.tpat;
            int hashCode10 = (hashCode9 + (map == null ? 0 : map.hashCode())) * 31;
            String str8 = this.templateURL;
            int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.templateId;
            int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.templateType;
            int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
            TemplateSettings templateSettings2 = this.templateSettings;
            int hashCode14 = (hashCode13 + (templateSettings2 == null ? 0 : templateSettings2.hashCode())) * 31;
            String str11 = this.bidToken;
            int hashCode15 = (hashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.adMarketId;
            int hashCode16 = (hashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
            String str13 = this.info;
            int hashCode17 = (hashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
            Integer num2 = this.sleep;
            int hashCode18 = (hashCode17 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Viewability viewability2 = this.viewability;
            int hashCode19 = (hashCode18 + (viewability2 == null ? 0 : viewability2.hashCode())) * 31;
            String str14 = this.adExt;
            int hashCode20 = (hashCode19 + (str14 == null ? 0 : str14.hashCode())) * 31;
            List<String> list = this.notification;
            int hashCode21 = (hashCode20 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.loadAdUrls;
            int hashCode22 = (hashCode21 + (list2 == null ? 0 : list2.hashCode())) * 31;
            Integer num3 = this.timestamp;
            int hashCode23 = (hashCode22 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.showCloseIncentivized;
            int hashCode24 = (hashCode23 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.showClose;
            int hashCode25 = (hashCode24 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.errorCode;
            if (num6 != null) {
                i = num6.hashCode();
            }
            return hashCode25 + i;
        }

        public String toString() {
            return "AdUnit(id=" + this.id + ", adType=" + this.adType + ", adSource=" + this.adSource + ", campaign=" + this.campaign + ", expiry=" + this.expiry + ", advAppId=" + this.advAppId + ", callToActionUrl=" + this.callToActionUrl + ", deeplinkUrl=" + this.deeplinkUrl + ", clickCoordinatesEnabled=" + this.clickCoordinatesEnabled + ", tpat=" + this.tpat + ", templateURL=" + this.templateURL + ", templateId=" + this.templateId + ", templateType=" + this.templateType + ", templateSettings=" + this.templateSettings + ", bidToken=" + this.bidToken + ", adMarketId=" + this.adMarketId + ", info=" + this.info + ", sleep=" + this.sleep + ", viewability=" + this.viewability + ", adExt=" + this.adExt + ", notification=" + this.notification + ", loadAdUrls=" + this.loadAdUrls + ", timestamp=" + this.timestamp + ", showCloseIncentivized=" + this.showCloseIncentivized + ", showClose=" + this.showClose + ", errorCode=" + this.errorCode + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$AdUnit$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AdUnit> serializer() {
                return AdPayload$AdUnit$$serializer.INSTANCE;
            }
        }

        public AdUnit(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Boolean bool, Map<String, ? extends List<String>> map, String str8, String str9, String str10, TemplateSettings templateSettings2, String str11, String str12, String str13, Integer num2, Viewability viewability2, String str14, List<String> list, List<String> list2, Integer num3, Integer num4, Integer num5, Integer num6) {
            this.id = str;
            this.adType = str2;
            this.adSource = str3;
            this.campaign = str4;
            this.expiry = num;
            this.advAppId = str5;
            this.callToActionUrl = str6;
            this.deeplinkUrl = str7;
            this.clickCoordinatesEnabled = bool;
            this.tpat = map;
            this.templateURL = str8;
            this.templateId = str9;
            this.templateType = str10;
            this.templateSettings = templateSettings2;
            this.bidToken = str11;
            this.adMarketId = str12;
            this.info = str13;
            this.sleep = num2;
            this.viewability = viewability2;
            this.adExt = str14;
            this.notification = list;
            this.loadAdUrls = list2;
            this.timestamp = num3;
            this.showCloseIncentivized = num4;
            this.showClose = num5;
            this.errorCode = num6;
        }

        @JvmStatic
        public static final void write$Self(AdUnit adUnit, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2;
            Integer num;
            Integer num2;
            Intrinsics.checkNotNullParameter(adUnit, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || adUnit.id != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, adUnit.id);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || adUnit.adType != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, adUnit.adType);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || adUnit.adSource != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, adUnit.adSource);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || adUnit.campaign != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, adUnit.campaign);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || adUnit.expiry != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, adUnit.expiry);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || adUnit.advAppId != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, adUnit.advAppId);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || adUnit.callToActionUrl != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, adUnit.callToActionUrl);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || adUnit.deeplinkUrl != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, adUnit.deeplinkUrl);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || adUnit.clickCoordinatesEnabled != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, adUnit.clickCoordinatesEnabled);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || adUnit.tpat != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, TpatSerializer.INSTANCE, adUnit.tpat);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) || adUnit.templateURL != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, adUnit.templateURL);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) || adUnit.templateId != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, adUnit.templateId);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 12) || adUnit.templateType != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, adUnit.templateType);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) || adUnit.templateSettings != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 13, AdPayload$TemplateSettings$$serializer.INSTANCE, adUnit.templateSettings);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 14) || adUnit.bidToken != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, adUnit.bidToken);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 15) || adUnit.adMarketId != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, adUnit.adMarketId);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 16) || adUnit.info != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, adUnit.info);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 17) || adUnit.sleep != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 17, IntSerializer.INSTANCE, adUnit.sleep);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 18) || adUnit.viewability != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 18, AdPayload$Viewability$$serializer.INSTANCE, adUnit.viewability);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 19) || adUnit.adExt != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, adUnit.adExt);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 20) || adUnit.notification != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 20, new ArrayListSerializer(StringSerializer.INSTANCE), adUnit.notification);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 21) || adUnit.loadAdUrls != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 21, new ArrayListSerializer(StringSerializer.INSTANCE), adUnit.loadAdUrls);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 22) || adUnit.timestamp != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 22, IntSerializer.INSTANCE, adUnit.timestamp);
            }
            if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 23) && (num2 = adUnit.showCloseIncentivized) != null && num2.intValue() == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 23, IntSerializer.INSTANCE, adUnit.showCloseIncentivized);
            }
            if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 24) && (num = adUnit.showClose) != null && num.intValue() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 24, IntSerializer.INSTANCE, adUnit.showClose);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 25) || adUnit.errorCode != null) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 25, IntSerializer.INSTANCE, adUnit.errorCode);
            }
        }

        public final String getId() {
            return this.id;
        }

        public final String getAdType() {
            return this.adType;
        }

        public final String getAdSource() {
            return this.adSource;
        }

        public final String getCampaign() {
            return this.campaign;
        }

        public final Integer getExpiry() {
            return this.expiry;
        }

        public final String getAdvAppId() {
            return this.advAppId;
        }

        public final String getCallToActionUrl() {
            return this.callToActionUrl;
        }

        public final String getDeeplinkUrl() {
            return this.deeplinkUrl;
        }

        public final Boolean getClickCoordinatesEnabled() {
            return this.clickCoordinatesEnabled;
        }

        public final Map<String, List<String>> getTpat() {
            return this.tpat;
        }

        public final String getTemplateURL() {
            return this.templateURL;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final String getTemplateType() {
            return this.templateType;
        }

        public final TemplateSettings getTemplateSettings() {
            return this.templateSettings;
        }

        public final String getBidToken() {
            return this.bidToken;
        }

        public final String getAdMarketId() {
            return this.adMarketId;
        }

        public final String getInfo() {
            return this.info;
        }

        public final Integer getSleep() {
            return this.sleep;
        }

        public final Viewability getViewability() {
            return this.viewability;
        }

        public final String getAdExt() {
            return this.adExt;
        }

        public final List<String> getNotification() {
            return this.notification;
        }

        public final List<String> getLoadAdUrls() {
            return this.loadAdUrls;
        }

        public final Integer getTimestamp() {
            return this.timestamp;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ AdUnit(int i, String str, String str2, String str3, String str4, Integer num, @SerialName("app_id") String str5, String str6, String str7, @SerialName("click_coordinates_enabled") Boolean bool, @Serializable(with = TpatSerializer.class) Map map, String str8, String str9, @SerialName("template_type") String str10, TemplateSettings templateSettings2, @SerialName("bid_token") String str11, @SerialName("ad_market_id") String str12, String str13, Integer num2, Viewability viewability2, String str14, List list, @SerialName("load_ad") List list2, Integer num3, Integer num4, Integer num5, @SerialName("error_code") Integer num6, SerializationConstructorMarker serializationConstructorMarker) {
            int i2 = i;
            if ((i2 & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, AdPayload$AdUnit$$serializer.INSTANCE.getDescriptor());
            }
            if ((i2 & 1) == 0) {
                this.id = null;
            } else {
                this.id = str;
            }
            if ((i2 & 2) == 0) {
                this.adType = null;
            } else {
                this.adType = str2;
            }
            if ((i2 & 4) == 0) {
                this.adSource = null;
            } else {
                this.adSource = str3;
            }
            if ((i2 & 8) == 0) {
                this.campaign = null;
            } else {
                this.campaign = str4;
            }
            if ((i2 & 16) == 0) {
                this.expiry = null;
            } else {
                this.expiry = num;
            }
            if ((i2 & 32) == 0) {
                this.advAppId = null;
            } else {
                this.advAppId = str5;
            }
            if ((i2 & 64) == 0) {
                this.callToActionUrl = null;
            } else {
                this.callToActionUrl = str6;
            }
            if ((i2 & 128) == 0) {
                this.deeplinkUrl = null;
            } else {
                this.deeplinkUrl = str7;
            }
            if ((i2 & 256) == 0) {
                this.clickCoordinatesEnabled = null;
            } else {
                this.clickCoordinatesEnabled = bool;
            }
            if ((i2 & 512) == 0) {
                this.tpat = null;
            } else {
                this.tpat = map;
            }
            if ((i2 & 1024) == 0) {
                this.templateURL = null;
            } else {
                this.templateURL = str8;
            }
            if ((i2 & 2048) == 0) {
                this.templateId = null;
            } else {
                this.templateId = str9;
            }
            if ((i2 & 4096) == 0) {
                this.templateType = null;
            } else {
                this.templateType = str10;
            }
            if ((i2 & 8192) == 0) {
                this.templateSettings = null;
            } else {
                this.templateSettings = templateSettings2;
            }
            if ((i2 & 16384) == 0) {
                this.bidToken = null;
            } else {
                this.bidToken = str11;
            }
            if ((32768 & i2) == 0) {
                this.adMarketId = null;
            } else {
                this.adMarketId = str12;
            }
            if ((65536 & i2) == 0) {
                this.info = null;
            } else {
                this.info = str13;
            }
            if ((131072 & i2) == 0) {
                this.sleep = null;
            } else {
                this.sleep = num2;
            }
            if ((262144 & i2) == 0) {
                this.viewability = null;
            } else {
                this.viewability = viewability2;
            }
            if ((524288 & i2) == 0) {
                this.adExt = null;
            } else {
                this.adExt = str14;
            }
            if ((1048576 & i2) == 0) {
                this.notification = null;
            } else {
                this.notification = list;
            }
            if ((2097152 & i2) == 0) {
                this.loadAdUrls = null;
            } else {
                this.loadAdUrls = list2;
            }
            if ((4194304 & i2) == 0) {
                this.timestamp = null;
            } else {
                this.timestamp = num3;
            }
            if ((8388608 & i2) == 0) {
                this.showCloseIncentivized = 0;
            } else {
                this.showCloseIncentivized = num4;
            }
            if ((16777216 & i2) == 0) {
                this.showClose = 0;
            } else {
                this.showClose = num5;
            }
            if ((i2 & 33554432) == 0) {
                this.errorCode = null;
            } else {
                this.errorCode = num6;
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ AdUnit(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.Integer r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.Boolean r36, java.util.Map r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, com.vungle.ads.internal.model.AdPayload.TemplateSettings r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.Integer r45, com.vungle.ads.internal.model.AdPayload.Viewability r46, java.lang.String r47, java.util.List r48, java.util.List r49, java.lang.Integer r50, java.lang.Integer r51, java.lang.Integer r52, java.lang.Integer r53, int r54, kotlin.jvm.internal.DefaultConstructorMarker r55) {
            /*
                r27 = this;
                r0 = r54
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0008
                r1 = 0
                goto L_0x000a
            L_0x0008:
                r1 = r28
            L_0x000a:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0010
                r3 = 0
                goto L_0x0012
            L_0x0010:
                r3 = r29
            L_0x0012:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0018
                r4 = 0
                goto L_0x001a
            L_0x0018:
                r4 = r30
            L_0x001a:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x0020
                r5 = 0
                goto L_0x0022
            L_0x0020:
                r5 = r31
            L_0x0022:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0028
                r6 = 0
                goto L_0x002a
            L_0x0028:
                r6 = r32
            L_0x002a:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x0030
                r7 = 0
                goto L_0x0032
            L_0x0030:
                r7 = r33
            L_0x0032:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0038
                r8 = 0
                goto L_0x003a
            L_0x0038:
                r8 = r34
            L_0x003a:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x0040
                r9 = 0
                goto L_0x0042
            L_0x0040:
                r9 = r35
            L_0x0042:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x0048
                r10 = 0
                goto L_0x004a
            L_0x0048:
                r10 = r36
            L_0x004a:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x0050
                r11 = 0
                goto L_0x0052
            L_0x0050:
                r11 = r37
            L_0x0052:
                r12 = r0 & 1024(0x400, float:1.435E-42)
                if (r12 == 0) goto L_0x0058
                r12 = 0
                goto L_0x005a
            L_0x0058:
                r12 = r38
            L_0x005a:
                r13 = r0 & 2048(0x800, float:2.87E-42)
                if (r13 == 0) goto L_0x0060
                r13 = 0
                goto L_0x0062
            L_0x0060:
                r13 = r39
            L_0x0062:
                r14 = r0 & 4096(0x1000, float:5.74E-42)
                if (r14 == 0) goto L_0x0068
                r14 = 0
                goto L_0x006a
            L_0x0068:
                r14 = r40
            L_0x006a:
                r15 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r15 == 0) goto L_0x0070
                r15 = 0
                goto L_0x0072
            L_0x0070:
                r15 = r41
            L_0x0072:
                r2 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r2 == 0) goto L_0x0078
                r2 = 0
                goto L_0x007a
            L_0x0078:
                r2 = r42
            L_0x007a:
                r16 = 32768(0x8000, float:4.5918E-41)
                r16 = r0 & r16
                if (r16 == 0) goto L_0x0084
                r16 = 0
                goto L_0x0086
            L_0x0084:
                r16 = r43
            L_0x0086:
                r17 = 65536(0x10000, float:9.18355E-41)
                r17 = r0 & r17
                if (r17 == 0) goto L_0x008f
                r17 = 0
                goto L_0x0091
            L_0x008f:
                r17 = r44
            L_0x0091:
                r18 = 131072(0x20000, float:1.83671E-40)
                r18 = r0 & r18
                if (r18 == 0) goto L_0x009a
                r18 = 0
                goto L_0x009c
            L_0x009a:
                r18 = r45
            L_0x009c:
                r19 = 262144(0x40000, float:3.67342E-40)
                r19 = r0 & r19
                if (r19 == 0) goto L_0x00a5
                r19 = 0
                goto L_0x00a7
            L_0x00a5:
                r19 = r46
            L_0x00a7:
                r20 = 524288(0x80000, float:7.34684E-40)
                r20 = r0 & r20
                if (r20 == 0) goto L_0x00b0
                r20 = 0
                goto L_0x00b2
            L_0x00b0:
                r20 = r47
            L_0x00b2:
                r21 = 1048576(0x100000, float:1.469368E-39)
                r21 = r0 & r21
                if (r21 == 0) goto L_0x00bb
                r21 = 0
                goto L_0x00bd
            L_0x00bb:
                r21 = r48
            L_0x00bd:
                r22 = 2097152(0x200000, float:2.938736E-39)
                r22 = r0 & r22
                if (r22 == 0) goto L_0x00c6
                r22 = 0
                goto L_0x00c8
            L_0x00c6:
                r22 = r49
            L_0x00c8:
                r23 = 4194304(0x400000, float:5.877472E-39)
                r23 = r0 & r23
                if (r23 == 0) goto L_0x00d1
                r23 = 0
                goto L_0x00d3
            L_0x00d1:
                r23 = r50
            L_0x00d3:
                r24 = 8388608(0x800000, float:1.17549435E-38)
                r24 = r0 & r24
                r25 = 0
                if (r24 == 0) goto L_0x00e0
                java.lang.Integer r24 = java.lang.Integer.valueOf(r25)
                goto L_0x00e2
            L_0x00e0:
                r24 = r51
            L_0x00e2:
                r26 = 16777216(0x1000000, float:2.3509887E-38)
                r26 = r0 & r26
                if (r26 == 0) goto L_0x00ed
                java.lang.Integer r25 = java.lang.Integer.valueOf(r25)
                goto L_0x00ef
            L_0x00ed:
                r25 = r52
            L_0x00ef:
                r26 = 33554432(0x2000000, float:9.403955E-38)
                r0 = r0 & r26
                if (r0 == 0) goto L_0x00f7
                r0 = 0
                goto L_0x00f9
            L_0x00f7:
                r0 = r53
            L_0x00f9:
                r28 = r27
                r29 = r1
                r30 = r3
                r31 = r4
                r32 = r5
                r33 = r6
                r34 = r7
                r35 = r8
                r36 = r9
                r37 = r10
                r38 = r11
                r39 = r12
                r40 = r13
                r41 = r14
                r42 = r15
                r43 = r2
                r44 = r16
                r45 = r17
                r46 = r18
                r47 = r19
                r48 = r20
                r49 = r21
                r50 = r22
                r51 = r23
                r52 = r24
                r53 = r25
                r54 = r0
                r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload.AdUnit.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.util.Map, java.lang.String, java.lang.String, java.lang.String, com.vungle.ads.internal.model.AdPayload$TemplateSettings, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, com.vungle.ads.internal.model.AdPayload$Viewability, java.lang.String, java.util.List, java.util.List, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final Integer getShowCloseIncentivized() {
            return this.showCloseIncentivized;
        }

        public final Integer getShowClose() {
            return this.showClose;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0014¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$TpatSerializer;", "Lkotlinx/serialization/json/JsonTransformingSerializer;", "", "", "", "()V", "transformDeserialize", "Lkotlinx/serialization/json/JsonElement;", "element", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdPayload.kt */
    public static final class TpatSerializer extends JsonTransformingSerializer<Map<String, ? extends List<? extends String>>> {
        public static final TpatSerializer INSTANCE = new TpatSerializer();

        private TpatSerializer() {
            super(BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE))));
        }

        /* access modifiers changed from: protected */
        public JsonElement transformDeserialize(JsonElement jsonElement) {
            Intrinsics.checkNotNullParameter(jsonElement, "element");
            Map linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : JsonElementKt.getJsonObject(jsonElement).entrySet()) {
                if (!Intrinsics.areEqual((Object) (String) entry.getKey(), (Object) "moat")) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return new JsonObject(linkedHashMap);
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0002\"#BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB5\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R*\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006$"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;", "", "seen1", "", "normalReplacements", "", "", "cacheableReplacements", "Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;)V", "getCacheableReplacements$annotations", "()V", "getCacheableReplacements", "()Ljava/util/Map;", "getNormalReplacements$annotations", "getNormalReplacements", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: AdPayload.kt */
    public static final class TemplateSettings {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Map<String, CacheableReplacement> cacheableReplacements;
        private final Map<String, String> normalReplacements;

        public TemplateSettings() {
            this((Map) null, (Map) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ TemplateSettings copy$default(TemplateSettings templateSettings, Map<String, String> map, Map<String, CacheableReplacement> map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = templateSettings.normalReplacements;
            }
            if ((i & 2) != 0) {
                map2 = templateSettings.cacheableReplacements;
            }
            return templateSettings.copy(map, map2);
        }

        @SerialName("cacheable_replacements")
        public static /* synthetic */ void getCacheableReplacements$annotations() {
        }

        @SerialName("normal_replacements")
        public static /* synthetic */ void getNormalReplacements$annotations() {
        }

        public final Map<String, String> component1() {
            return this.normalReplacements;
        }

        public final Map<String, CacheableReplacement> component2() {
            return this.cacheableReplacements;
        }

        public final TemplateSettings copy(Map<String, String> map, Map<String, CacheableReplacement> map2) {
            return new TemplateSettings(map, map2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TemplateSettings)) {
                return false;
            }
            TemplateSettings templateSettings = (TemplateSettings) obj;
            return Intrinsics.areEqual((Object) this.normalReplacements, (Object) templateSettings.normalReplacements) && Intrinsics.areEqual((Object) this.cacheableReplacements, (Object) templateSettings.cacheableReplacements);
        }

        public int hashCode() {
            Map<String, String> map = this.normalReplacements;
            int i = 0;
            int hashCode = (map == null ? 0 : map.hashCode()) * 31;
            Map<String, CacheableReplacement> map2 = this.cacheableReplacements;
            if (map2 != null) {
                i = map2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "TemplateSettings(normalReplacements=" + this.normalReplacements + ", cacheableReplacements=" + this.cacheableReplacements + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$TemplateSettings;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<TemplateSettings> serializer() {
                return AdPayload$TemplateSettings$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ TemplateSettings(int i, @SerialName("normal_replacements") Map map, @SerialName("cacheable_replacements") Map map2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, AdPayload$TemplateSettings$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.normalReplacements = null;
            } else {
                this.normalReplacements = map;
            }
            if ((i & 2) == 0) {
                this.cacheableReplacements = null;
            } else {
                this.cacheableReplacements = map2;
            }
        }

        public TemplateSettings(Map<String, String> map, Map<String, CacheableReplacement> map2) {
            this.normalReplacements = map;
            this.cacheableReplacements = map2;
        }

        @JvmStatic
        public static final void write$Self(TemplateSettings templateSettings, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(templateSettings, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || templateSettings.normalReplacements != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), templateSettings.normalReplacements);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || templateSettings.cacheableReplacements != null) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, AdPayload$CacheableReplacement$$serializer.INSTANCE), templateSettings.cacheableReplacements);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TemplateSettings(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2);
        }

        public final Map<String, String> getNormalReplacements() {
            return this.normalReplacements;
        }

        public final Map<String, CacheableReplacement> getCacheableReplacements() {
            return this.cacheableReplacements;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J!\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÇ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement;", "", "seen1", "", "url", "", "extension", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getExtension", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: AdPayload.kt */
    public static final class CacheableReplacement {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String extension;
        private final String url;

        public CacheableReplacement() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ CacheableReplacement copy$default(CacheableReplacement cacheableReplacement, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cacheableReplacement.url;
            }
            if ((i & 2) != 0) {
                str2 = cacheableReplacement.extension;
            }
            return cacheableReplacement.copy(str, str2);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.extension;
        }

        public final CacheableReplacement copy(String str, String str2) {
            return new CacheableReplacement(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheableReplacement)) {
                return false;
            }
            CacheableReplacement cacheableReplacement = (CacheableReplacement) obj;
            return Intrinsics.areEqual((Object) this.url, (Object) cacheableReplacement.url) && Intrinsics.areEqual((Object) this.extension, (Object) cacheableReplacement.extension);
        }

        public int hashCode() {
            String str = this.url;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.extension;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "CacheableReplacement(url=" + this.url + ", extension=" + this.extension + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$CacheableReplacement;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CacheableReplacement> serializer() {
                return AdPayload$CacheableReplacement$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CacheableReplacement(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, AdPayload$CacheableReplacement$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.url = null;
            } else {
                this.url = str;
            }
            if ((i & 2) == 0) {
                this.extension = null;
            } else {
                this.extension = str2;
            }
        }

        public CacheableReplacement(String str, String str2) {
            this.url = str;
            this.extension = str2;
        }

        @JvmStatic
        public static final void write$Self(CacheableReplacement cacheableReplacement, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(cacheableReplacement, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || cacheableReplacement.url != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, cacheableReplacement.url);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || cacheableReplacement.extension != null) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, cacheableReplacement.extension);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CacheableReplacement(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getExtension() {
            return this.extension;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÇ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$Viewability;", "", "seen1", "", "om", "Lcom/vungle/ads/internal/model/AdPayload$ViewabilityInfo;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/vungle/ads/internal/model/AdPayload$ViewabilityInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/vungle/ads/internal/model/AdPayload$ViewabilityInfo;)V", "getOm", "()Lcom/vungle/ads/internal/model/AdPayload$ViewabilityInfo;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: AdPayload.kt */
    public static final class Viewability {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ViewabilityInfo om;

        public Viewability() {
            this((ViewabilityInfo) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Viewability copy$default(Viewability viewability, ViewabilityInfo viewabilityInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                viewabilityInfo = viewability.om;
            }
            return viewability.copy(viewabilityInfo);
        }

        public final ViewabilityInfo component1() {
            return this.om;
        }

        public final Viewability copy(ViewabilityInfo viewabilityInfo) {
            return new Viewability(viewabilityInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Viewability) && Intrinsics.areEqual((Object) this.om, (Object) ((Viewability) obj).om);
        }

        public int hashCode() {
            ViewabilityInfo viewabilityInfo = this.om;
            if (viewabilityInfo == null) {
                return 0;
            }
            return viewabilityInfo.hashCode();
        }

        public String toString() {
            return "Viewability(om=" + this.om + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$Viewability$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$Viewability;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Viewability> serializer() {
                return AdPayload$Viewability$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Viewability(int i, ViewabilityInfo viewabilityInfo, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, AdPayload$Viewability$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.om = null;
            } else {
                this.om = viewabilityInfo;
            }
        }

        public Viewability(ViewabilityInfo viewabilityInfo) {
            this.om = viewabilityInfo;
        }

        @JvmStatic
        public static final void write$Self(Viewability viewability, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(viewability, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z = true;
            if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && viewability.om == null) {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, AdPayload$ViewabilityInfo$$serializer.INSTANCE, viewability.om);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Viewability(ViewabilityInfo viewabilityInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : viewabilityInfo);
        }

        public final ViewabilityInfo getOm() {
            return this.om;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J&\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0004\u0010\u0011¨\u0006$"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$ViewabilityInfo;", "", "seen1", "", "isEnabled", "", "extraVast", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getExtraVast$annotations", "()V", "getExtraVast", "()Ljava/lang/String;", "isEnabled$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/vungle/ads/internal/model/AdPayload$ViewabilityInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: AdPayload.kt */
    public static final class ViewabilityInfo {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String extraVast;
        private final Boolean isEnabled;

        public ViewabilityInfo() {
            this((Boolean) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ViewabilityInfo copy$default(ViewabilityInfo viewabilityInfo, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = viewabilityInfo.isEnabled;
            }
            if ((i & 2) != 0) {
                str = viewabilityInfo.extraVast;
            }
            return viewabilityInfo.copy(bool, str);
        }

        @SerialName("extra_vast")
        public static /* synthetic */ void getExtraVast$annotations() {
        }

        @SerialName("is_enabled")
        public static /* synthetic */ void isEnabled$annotations() {
        }

        public final Boolean component1() {
            return this.isEnabled;
        }

        public final String component2() {
            return this.extraVast;
        }

        public final ViewabilityInfo copy(Boolean bool, String str) {
            return new ViewabilityInfo(bool, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewabilityInfo)) {
                return false;
            }
            ViewabilityInfo viewabilityInfo = (ViewabilityInfo) obj;
            return Intrinsics.areEqual((Object) this.isEnabled, (Object) viewabilityInfo.isEnabled) && Intrinsics.areEqual((Object) this.extraVast, (Object) viewabilityInfo.extraVast);
        }

        public int hashCode() {
            Boolean bool = this.isEnabled;
            int i = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.extraVast;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ViewabilityInfo(isEnabled=" + this.isEnabled + ", extraVast=" + this.extraVast + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdPayload$ViewabilityInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$ViewabilityInfo;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdPayload.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ViewabilityInfo> serializer() {
                return AdPayload$ViewabilityInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ViewabilityInfo(int i, @SerialName("is_enabled") Boolean bool, @SerialName("extra_vast") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, AdPayload$ViewabilityInfo$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.isEnabled = null;
            } else {
                this.isEnabled = bool;
            }
            if ((i & 2) == 0) {
                this.extraVast = null;
            } else {
                this.extraVast = str;
            }
        }

        public ViewabilityInfo(Boolean bool, String str) {
            this.isEnabled = bool;
            this.extraVast = str;
        }

        @JvmStatic
        public static final void write$Self(ViewabilityInfo viewabilityInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(viewabilityInfo, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || viewabilityInfo.isEnabled != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, viewabilityInfo.isEnabled);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || viewabilityInfo.extraVast != null) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, viewabilityInfo.extraVast);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewabilityInfo(Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str);
        }

        public final Boolean isEnabled() {
            return this.isEnabled;
        }

        public final String getExtraVast() {
            return this.extraVast;
        }
    }
}
