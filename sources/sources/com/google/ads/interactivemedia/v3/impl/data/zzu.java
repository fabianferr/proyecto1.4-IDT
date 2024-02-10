package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.internal.zzeb;
import com.google.ads.interactivemedia.v3.internal.zzef;
import com.google.ads.interactivemedia.v3.internal.zzeg;
import com.google.ads.interactivemedia.v3.internal.zzeh;
import com.google.ads.interactivemedia.v3.internal.zzso;
import com.google.ads.interactivemedia.v3.internal.zzsr;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzu implements zzaz {
    private zzsr<String, String> adTagParameters;
    private String adTagUrl;
    private String adsResponse;
    private String apiKey;
    private String assetKey;
    private String authToken;
    private zzsr<String, String> companionSlots;
    private zzaw consentSettings;
    private Float contentDuration;
    private zzso<String> contentKeywords;
    private String contentSourceId;
    private String contentSourceUrl;
    private String contentTitle;
    private String contentUrl;
    private String customAssetKey;
    private Boolean enableNonce;
    private String env;
    private zzsr<String, String> extraParameters;
    private String format;
    private zzbc identifierInfo;
    private Boolean isAndroidTvAdsFramework;
    private Boolean isTv;
    private Integer linearAdSlotHeight;
    private Integer linearAdSlotWidth;
    private String liveStreamEventId;
    private Float liveStreamPrefetchSeconds;
    private zzeb marketAppInfo;
    private String msParameter;
    private String network;
    private String networkCode;
    private String oAuthToken;
    private Boolean omidAdSessionsOnStartedOnly;
    private zzsr<String, String> platformSignals;
    private String projectNumber;
    private String region;
    private zzso<zzbo> secureSignals;
    private ImaSdkSettings settings;
    private String streamActivityMonitorId;
    private Boolean supportsExternalNavigation;
    private Boolean supportsIconClickFallback;
    private Boolean supportsNativeNetworking;
    private Boolean supportsResizing;
    private Boolean useQAStreamBaseUrl;
    private Boolean usesCustomVideoPlayback;
    private Float vastLoadTimeout;
    private zzeg videoContinuousPlay;
    private zzbu videoEnvironment;
    private String videoId;
    private zzef videoPlayActivation;
    private zzeh videoPlayMuted;

    zzu() {
    }

    public zzaz adTagParameters(Map<String, String> map) {
        this.adTagParameters = map == null ? null : zzsr.zzc(map);
        return this;
    }

    public zzaz adTagUrl(String str) {
        this.adTagUrl = str;
        return this;
    }

    public zzaz adsResponse(String str) {
        this.adsResponse = str;
        return this;
    }

    public zzaz apiKey(String str) {
        this.apiKey = str;
        return this;
    }

    public zzaz assetKey(String str) {
        this.assetKey = str;
        return this;
    }

    public zzaz authToken(String str) {
        this.authToken = str;
        return this;
    }

    public zzba build() {
        return new zzw(this.adTagParameters, this.adTagUrl, this.adsResponse, this.apiKey, this.assetKey, this.authToken, this.companionSlots, this.contentDuration, this.contentKeywords, this.contentSourceUrl, this.contentTitle, this.contentUrl, this.contentSourceId, this.consentSettings, this.customAssetKey, this.enableNonce, this.env, this.secureSignals, this.extraParameters, this.format, this.identifierInfo, this.isTv, this.isAndroidTvAdsFramework, this.linearAdSlotWidth, this.linearAdSlotHeight, this.liveStreamEventId, this.liveStreamPrefetchSeconds, this.marketAppInfo, this.msParameter, this.network, this.videoEnvironment, this.networkCode, this.oAuthToken, this.omidAdSessionsOnStartedOnly, this.platformSignals, this.projectNumber, this.region, this.settings, this.supportsExternalNavigation, this.supportsIconClickFallback, this.supportsNativeNetworking, this.streamActivityMonitorId, this.supportsResizing, this.useQAStreamBaseUrl, this.usesCustomVideoPlayback, this.vastLoadTimeout, this.videoId, this.videoPlayActivation, this.videoContinuousPlay, this.videoPlayMuted);
    }

    public zzaz companionSlots(Map<String, String> map) {
        this.companionSlots = map == null ? null : zzsr.zzc(map);
        return this;
    }

    public zzaz consentSettings(zzaw zzaw) {
        this.consentSettings = zzaw;
        return this;
    }

    public zzaz contentDuration(Float f) {
        this.contentDuration = f;
        return this;
    }

    public zzaz contentKeywords(List<String> list) {
        this.contentKeywords = list == null ? null : zzso.zzk(list);
        return this;
    }

    public zzaz contentSourceId(String str) {
        this.contentSourceId = str;
        return this;
    }

    public zzaz contentSourceUrl(String str) {
        this.contentSourceUrl = str;
        return this;
    }

    public zzaz contentTitle(String str) {
        this.contentTitle = str;
        return this;
    }

    public zzaz contentUrl(String str) {
        this.contentUrl = str;
        return this;
    }

    public zzaz customAssetKey(String str) {
        this.customAssetKey = str;
        return this;
    }

    public zzaz enableNonce(Boolean bool) {
        this.enableNonce = bool;
        return this;
    }

    public zzaz env(String str) {
        this.env = str;
        return this;
    }

    public zzaz extraParameters(Map<String, String> map) {
        this.extraParameters = map == null ? null : zzsr.zzc(map);
        return this;
    }

    public zzaz format(String str) {
        this.format = str;
        return this;
    }

    public zzaz identifierInfo(zzbc zzbc) {
        this.identifierInfo = zzbc;
        return this;
    }

    public zzaz isAndroidTvAdsFramework(Boolean bool) {
        this.isAndroidTvAdsFramework = bool;
        return this;
    }

    public zzaz isTv(Boolean bool) {
        this.isTv = bool;
        return this;
    }

    public zzaz linearAdSlotHeight(Integer num) {
        this.linearAdSlotHeight = num;
        return this;
    }

    public zzaz linearAdSlotWidth(Integer num) {
        this.linearAdSlotWidth = num;
        return this;
    }

    public zzaz liveStreamEventId(String str) {
        this.liveStreamEventId = str;
        return this;
    }

    public zzaz liveStreamPrefetchSeconds(Float f) {
        this.liveStreamPrefetchSeconds = f;
        return this;
    }

    public zzaz marketAppInfo(zzeb zzeb) {
        this.marketAppInfo = zzeb;
        return this;
    }

    public zzaz msParameter(String str) {
        this.msParameter = str;
        return this;
    }

    public zzaz network(String str) {
        this.network = "android:0";
        return this;
    }

    public zzaz networkCode(String str) {
        this.networkCode = str;
        return this;
    }

    public zzaz oAuthToken(String str) {
        this.oAuthToken = str;
        return this;
    }

    public zzaz omidAdSessionsOnStartedOnly(Boolean bool) {
        this.omidAdSessionsOnStartedOnly = bool;
        return this;
    }

    public zzaz platformSignals(Map<String, String> map) {
        this.platformSignals = map == null ? null : zzsr.zzc(map);
        return this;
    }

    public zzaz projectNumber(String str) {
        this.projectNumber = str;
        return this;
    }

    public zzaz region(String str) {
        this.region = str;
        return this;
    }

    public zzaz secureSignals(List<zzbo> list) {
        this.secureSignals = list == null ? null : zzso.zzk(list);
        return this;
    }

    public zzaz settings(ImaSdkSettings imaSdkSettings) {
        this.settings = imaSdkSettings;
        return this;
    }

    public zzaz streamActivityMonitorId(String str) {
        this.streamActivityMonitorId = str;
        return this;
    }

    public zzaz supportsExternalNavigation(Boolean bool) {
        this.supportsExternalNavigation = bool;
        return this;
    }

    public zzaz supportsIconClickFallback(Boolean bool) {
        this.supportsIconClickFallback = bool;
        return this;
    }

    public zzaz supportsNativeNetworking(Boolean bool) {
        this.supportsNativeNetworking = bool;
        return this;
    }

    public zzaz supportsResizing(Boolean bool) {
        this.supportsResizing = bool;
        return this;
    }

    public zzaz useQAStreamBaseUrl(Boolean bool) {
        this.useQAStreamBaseUrl = bool;
        return this;
    }

    public zzaz usesCustomVideoPlayback(Boolean bool) {
        this.usesCustomVideoPlayback = bool;
        return this;
    }

    public zzaz vastLoadTimeout(Float f) {
        this.vastLoadTimeout = f;
        return this;
    }

    public zzaz videoContinuousPlay(zzeg zzeg) {
        this.videoContinuousPlay = zzeg;
        return this;
    }

    public zzaz videoEnvironment(zzbu zzbu) {
        this.videoEnvironment = zzbu;
        return this;
    }

    public zzaz videoId(String str) {
        this.videoId = str;
        return this;
    }

    public zzaz videoPlayActivation(zzef zzef) {
        this.videoPlayActivation = zzef;
        return this;
    }

    public zzaz videoPlayMuted(zzeh zzeh) {
        this.videoPlayMuted = zzeh;
        return this;
    }
}
