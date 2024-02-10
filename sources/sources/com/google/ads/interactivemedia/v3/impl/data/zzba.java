package com.google.ads.interactivemedia.v3.impl.data;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.internal.zzdk;
import com.google.ads.interactivemedia.v3.internal.zzeb;
import com.google.ads.interactivemedia.v3.internal.zzef;
import com.google.ads.interactivemedia.v3.internal.zzeg;
import com.google.ads.interactivemedia.v3.internal.zzeh;
import com.google.ads.interactivemedia.v3.internal.zzei;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzgi;
import com.google.ads.interactivemedia.v3.internal.zzso;
import com.google.ads.interactivemedia.v3.internal.zzsq;
import com.google.ads.interactivemedia.v3.internal.zzsr;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzba {
    public static zzaz builder() {
        return new zzu();
    }

    public static zzba create(AdsRequest adsRequest, String str, zzaw zzaw, List<zzbo> list, Map<String, String> map, String str2, zzbu zzbu, ImaSdkSettings imaSdkSettings, zzeb zzeb, boolean z, boolean z2, String str3, zzbc zzbc, AdDisplayContainer adDisplayContainer) {
        String adTagUrl = adsRequest.getAdTagUrl();
        String adsResponse = adsRequest.getAdsResponse();
        Map<String, String> extraParameters = adsRequest.getExtraParameters();
        zzei zzei = (zzei) adsRequest;
        zzef zzb = zzei.zzb();
        zzeh zzd = zzei.zzd();
        zzeg zzc = zzei.zzc();
        Float zze = zzei.zze();
        List zzi = zzei.zzi();
        String zzh = zzei.zzh();
        String contentUrl = adsRequest.getContentUrl();
        Float zzg = zzei.zzg();
        Float zzf = zzei.zzf();
        Map<String, String> companionSlots = getCompanionSlots((zzdk) adDisplayContainer);
        ViewGroup adContainer = adDisplayContainer.getAdContainer();
        zzaz builder = builder();
        builder.adTagUrl(adTagUrl);
        builder.adsResponse(adsResponse);
        builder.companionSlots(companionSlots);
        builder.consentSettings(zzaw);
        builder.contentDuration(zze);
        builder.contentKeywords(zzi);
        builder.contentTitle(zzh);
        builder.contentUrl(contentUrl);
        builder.env(str);
        builder.secureSignals(list);
        builder.extraParameters(extraParameters);
        builder.identifierInfo(zzbc);
        Boolean valueOf = Boolean.valueOf(z);
        builder.isTv(valueOf);
        builder.isAndroidTvAdsFramework(Boolean.valueOf(z2));
        builder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        builder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        builder.liveStreamPrefetchSeconds(zzf);
        builder.marketAppInfo(zzeb);
        builder.msParameter(str3);
        builder.network("android:0");
        builder.videoEnvironment(zzbu);
        builder.omidAdSessionsOnStartedOnly(true);
        builder.platformSignals(map);
        builder.settings(imaSdkSettings);
        builder.supportsExternalNavigation(Boolean.valueOf(!z));
        builder.supportsIconClickFallback(valueOf);
        builder.supportsNativeNetworking(Boolean.valueOf(supportsNativeNetworkRequests()));
        builder.supportsResizing(Boolean.valueOf(adDisplayContainer.getPlayer() instanceof ResizablePlayer));
        builder.usesCustomVideoPlayback(true);
        builder.vastLoadTimeout(zzg);
        builder.videoContinuousPlay(zzc);
        builder.videoPlayActivation(zzb);
        builder.videoPlayMuted(zzd);
        return builder.build();
    }

    public static zzba createFromStreamRequest(StreamRequest streamRequest, String str, zzaw zzaw, List<zzbo> list, Map<String, String> map, String str2, zzbu zzbu, ImaSdkSettings imaSdkSettings, zzeb zzeb, boolean z, boolean z2, String str3, zzbc zzbc, StreamDisplayContainer streamDisplayContainer) {
        Map<String, String> companionSlots = getCompanionSlots((zzgi) streamDisplayContainer);
        ViewGroup adContainer = streamDisplayContainer.getAdContainer();
        StreamRequest.StreamFormat format = streamRequest.getFormat();
        StreamRequest.StreamFormat streamFormat = StreamRequest.StreamFormat.DASH;
        zzaz builder = builder();
        builder.adTagParameters(streamRequest.getAdTagParameters());
        builder.apiKey(streamRequest.getApiKey());
        builder.assetKey(streamRequest.getAssetKey());
        builder.authToken(streamRequest.getAuthToken());
        builder.companionSlots(companionSlots);
        zzaw zzaw2 = zzaw;
        builder.consentSettings(zzaw);
        builder.contentSourceId(streamRequest.getContentSourceId());
        builder.contentUrl(streamRequest.getContentUrl());
        builder.customAssetKey(streamRequest.getCustomAssetKey());
        builder.enableNonce(Boolean.valueOf(streamRequest.getEnableNonce()));
        String str4 = str;
        builder.env(str);
        List<zzbo> list2 = list;
        builder.secureSignals(list);
        builder.format(format == streamFormat ? "dash" : "hls");
        builder.identifierInfo(zzbc);
        Boolean valueOf = Boolean.valueOf(z);
        builder.isTv(valueOf);
        builder.isAndroidTvAdsFramework(Boolean.valueOf(z2));
        builder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        builder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        builder.liveStreamEventId(streamRequest.getLiveStreamEventId());
        zzeb zzeb2 = zzeb;
        builder.marketAppInfo(zzeb);
        builder.msParameter(str3);
        builder.network("android:0");
        zzbu zzbu2 = zzbu;
        builder.videoEnvironment(zzbu);
        builder.networkCode(streamRequest.getNetworkCode());
        builder.contentSourceUrl(streamRequest.getContentSourceUrl());
        builder.adTagUrl(streamRequest.getAdTagUrl());
        builder.oAuthToken(streamRequest.getOAuthToken());
        builder.omidAdSessionsOnStartedOnly(true);
        Map<String, String> map2 = map;
        builder.platformSignals(map);
        builder.projectNumber(streamRequest.getProjectNumber());
        builder.region(streamRequest.getRegion());
        ImaSdkSettings imaSdkSettings2 = imaSdkSettings;
        builder.settings(imaSdkSettings);
        builder.streamActivityMonitorId(streamRequest.getStreamActivityMonitorId());
        builder.supportsExternalNavigation(Boolean.valueOf(true ^ z));
        builder.supportsIconClickFallback(valueOf);
        builder.supportsNativeNetworking(Boolean.valueOf(supportsNativeNetworkRequests()));
        builder.supportsResizing(Boolean.valueOf(streamDisplayContainer.getVideoStreamPlayer() instanceof ResizablePlayer));
        builder.useQAStreamBaseUrl(streamRequest.getUseQAStreamBaseUrl());
        builder.videoId(streamRequest.getVideoId());
        return builder.build();
    }

    private static Map<String, String> getCompanionSlots(zzeo zzeo) {
        Map zza = zzeo.zza();
        if (zza == null || zza.isEmpty()) {
            return null;
        }
        zzsq zzsq = new zzsq();
        for (String str : zza.keySet()) {
            CompanionAdSlot companionAdSlot = (CompanionAdSlot) zza.get(str);
            int width = companionAdSlot.getWidth();
            int height = companionAdSlot.getHeight();
            zzsq.zza(str, width + "x" + height);
        }
        return zzsq.zzc();
    }

    private static boolean supportsNativeNetworkRequests() {
        return true;
    }

    public abstract zzsr<String, String> adTagParameters();

    public abstract String adTagUrl();

    public abstract String adsResponse();

    public abstract String apiKey();

    public abstract String assetKey();

    public abstract String authToken();

    public abstract zzsr<String, String> companionSlots();

    public abstract zzaw consentSettings();

    public abstract Float contentDuration();

    public abstract zzso<String> contentKeywords();

    public abstract String contentSourceId();

    public abstract String contentSourceUrl();

    public abstract String contentTitle();

    public abstract String contentUrl();

    /* access modifiers changed from: package-private */
    public abstract String customAssetKey();

    public abstract Boolean enableNonce();

    public abstract String env();

    public abstract zzsr<String, String> extraParameters();

    public abstract String format();

    public abstract zzbc identifierInfo();

    public abstract Boolean isAndroidTvAdsFramework();

    public abstract Boolean isTv();

    public abstract Integer linearAdSlotHeight();

    public abstract Integer linearAdSlotWidth();

    public abstract String liveStreamEventId();

    public abstract Float liveStreamPrefetchSeconds();

    public abstract zzeb marketAppInfo();

    public abstract String msParameter();

    public abstract String network();

    public abstract String networkCode();

    public abstract String oAuthToken();

    public abstract Boolean omidAdSessionsOnStartedOnly();

    public abstract zzsr<String, String> platformSignals();

    public abstract String projectNumber();

    public abstract String region();

    public abstract zzso<zzbo> secureSignals();

    public abstract ImaSdkSettings settings();

    public abstract String streamActivityMonitorId();

    public abstract Boolean supportsExternalNavigation();

    public abstract Boolean supportsIconClickFallback();

    public abstract Boolean supportsNativeNetworking();

    public abstract Boolean supportsResizing();

    public abstract Boolean useQAStreamBaseUrl();

    public abstract Boolean usesCustomVideoPlayback();

    public abstract Float vastLoadTimeout();

    public abstract zzeg videoContinuousPlay();

    public abstract zzbu videoEnvironment();

    public abstract String videoId();

    public abstract zzef videoPlayActivation();

    public abstract zzeh videoPlayMuted();
}
