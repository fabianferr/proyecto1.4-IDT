package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.internal.zzeb;
import com.google.ads.interactivemedia.v3.internal.zzef;
import com.google.ads.interactivemedia.v3.internal.zzeg;
import com.google.ads.interactivemedia.v3.internal.zzeh;
import com.google.ads.interactivemedia.v3.internal.zzso;
import com.google.ads.interactivemedia.v3.internal.zzsr;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzw extends zzba {
    private final zzsr<String, String> adTagParameters;
    private final String adTagUrl;
    private final String adsResponse;
    private final String apiKey;
    private final String assetKey;
    private final String authToken;
    private final zzsr<String, String> companionSlots;
    private final zzaw consentSettings;
    private final Float contentDuration;
    private final zzso<String> contentKeywords;
    private final String contentSourceId;
    private final String contentSourceUrl;
    private final String contentTitle;
    private final String contentUrl;
    private final String customAssetKey;
    private final Boolean enableNonce;
    private final String env;
    private final zzsr<String, String> extraParameters;
    private final String format;
    private final zzbc identifierInfo;
    private final Boolean isAndroidTvAdsFramework;
    private final Boolean isTv;
    private final Integer linearAdSlotHeight;
    private final Integer linearAdSlotWidth;
    private final String liveStreamEventId;
    private final Float liveStreamPrefetchSeconds;
    private final zzeb marketAppInfo;
    private final String msParameter;
    private final String network;
    private final String networkCode;
    private final String oAuthToken;
    private final Boolean omidAdSessionsOnStartedOnly;
    private final zzsr<String, String> platformSignals;
    private final String projectNumber;
    private final String region;
    private final zzso<zzbo> secureSignals;
    private final ImaSdkSettings settings;
    private final String streamActivityMonitorId;
    private final Boolean supportsExternalNavigation;
    private final Boolean supportsIconClickFallback;
    private final Boolean supportsNativeNetworking;
    private final Boolean supportsResizing;
    private final Boolean useQAStreamBaseUrl;
    private final Boolean usesCustomVideoPlayback;
    private final Float vastLoadTimeout;
    private final zzeg videoContinuousPlay;
    private final zzbu videoEnvironment;
    private final String videoId;
    private final zzef videoPlayActivation;
    private final zzeh videoPlayMuted;

    private zzw(zzsr<String, String> zzsr, String str, String str2, String str3, String str4, String str5, zzsr<String, String> zzsr2, Float f, zzso<String> zzso, String str6, String str7, String str8, String str9, zzaw zzaw, String str10, Boolean bool, String str11, zzso<zzbo> zzso2, zzsr<String, String> zzsr3, String str12, zzbc zzbc, Boolean bool2, Boolean bool3, Integer num, Integer num2, String str13, Float f2, zzeb zzeb, String str14, String str15, zzbu zzbu, String str16, String str17, Boolean bool4, zzsr<String, String> zzsr4, String str18, String str19, ImaSdkSettings imaSdkSettings, Boolean bool5, Boolean bool6, Boolean bool7, String str20, Boolean bool8, Boolean bool9, Boolean bool10, Float f3, String str21, zzef zzef, zzeg zzeg, zzeh zzeh) {
        this.adTagParameters = zzsr;
        this.adTagUrl = str;
        this.adsResponse = str2;
        this.apiKey = str3;
        this.assetKey = str4;
        this.authToken = str5;
        this.companionSlots = zzsr2;
        this.contentDuration = f;
        this.contentKeywords = zzso;
        this.contentSourceUrl = str6;
        this.contentTitle = str7;
        this.contentUrl = str8;
        this.contentSourceId = str9;
        this.consentSettings = zzaw;
        this.customAssetKey = str10;
        this.enableNonce = bool;
        this.env = str11;
        this.secureSignals = zzso2;
        this.extraParameters = zzsr3;
        this.format = str12;
        this.identifierInfo = zzbc;
        this.isTv = bool2;
        this.isAndroidTvAdsFramework = bool3;
        this.linearAdSlotWidth = num;
        this.linearAdSlotHeight = num2;
        this.liveStreamEventId = str13;
        this.liveStreamPrefetchSeconds = f2;
        this.marketAppInfo = zzeb;
        this.msParameter = str14;
        this.network = str15;
        this.videoEnvironment = zzbu;
        this.networkCode = str16;
        this.oAuthToken = str17;
        this.omidAdSessionsOnStartedOnly = bool4;
        this.platformSignals = zzsr4;
        this.projectNumber = str18;
        this.region = str19;
        this.settings = imaSdkSettings;
        this.supportsExternalNavigation = bool5;
        this.supportsIconClickFallback = bool6;
        this.supportsNativeNetworking = bool7;
        this.streamActivityMonitorId = str20;
        this.supportsResizing = bool8;
        this.useQAStreamBaseUrl = bool9;
        this.usesCustomVideoPlayback = bool10;
        this.vastLoadTimeout = f3;
        this.videoId = str21;
        this.videoPlayActivation = zzef;
        this.videoContinuousPlay = zzeg;
        this.videoPlayMuted = zzeh;
    }

    public zzsr<String, String> adTagParameters() {
        return this.adTagParameters;
    }

    public String adTagUrl() {
        return this.adTagUrl;
    }

    public String adsResponse() {
        return this.adsResponse;
    }

    public String apiKey() {
        return this.apiKey;
    }

    public String assetKey() {
        return this.assetKey;
    }

    public String authToken() {
        return this.authToken;
    }

    public zzsr<String, String> companionSlots() {
        return this.companionSlots;
    }

    public zzaw consentSettings() {
        return this.consentSettings;
    }

    public Float contentDuration() {
        return this.contentDuration;
    }

    public zzso<String> contentKeywords() {
        return this.contentKeywords;
    }

    public String contentSourceId() {
        return this.contentSourceId;
    }

    public String contentSourceUrl() {
        return this.contentSourceUrl;
    }

    public String contentTitle() {
        return this.contentTitle;
    }

    public String contentUrl() {
        return this.contentUrl;
    }

    /* access modifiers changed from: package-private */
    public String customAssetKey() {
        return this.customAssetKey;
    }

    public Boolean enableNonce() {
        return this.enableNonce;
    }

    public String env() {
        return this.env;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzba) {
            zzba zzba = (zzba) obj;
            zzsr<String, String> zzsr = this.adTagParameters;
            if (zzsr != null ? zzsr.equals(zzba.adTagParameters()) : zzba.adTagParameters() == null) {
                String str = this.adTagUrl;
                if (str != null ? str.equals(zzba.adTagUrl()) : zzba.adTagUrl() == null) {
                    String str2 = this.adsResponse;
                    if (str2 != null ? str2.equals(zzba.adsResponse()) : zzba.adsResponse() == null) {
                        String str3 = this.apiKey;
                        if (str3 != null ? str3.equals(zzba.apiKey()) : zzba.apiKey() == null) {
                            String str4 = this.assetKey;
                            if (str4 != null ? str4.equals(zzba.assetKey()) : zzba.assetKey() == null) {
                                String str5 = this.authToken;
                                if (str5 != null ? str5.equals(zzba.authToken()) : zzba.authToken() == null) {
                                    zzsr<String, String> zzsr2 = this.companionSlots;
                                    if (zzsr2 != null ? zzsr2.equals(zzba.companionSlots()) : zzba.companionSlots() == null) {
                                        Float f = this.contentDuration;
                                        if (f != null ? f.equals(zzba.contentDuration()) : zzba.contentDuration() == null) {
                                            zzso<String> zzso = this.contentKeywords;
                                            if (zzso != null ? zzso.equals(zzba.contentKeywords()) : zzba.contentKeywords() == null) {
                                                String str6 = this.contentSourceUrl;
                                                if (str6 != null ? str6.equals(zzba.contentSourceUrl()) : zzba.contentSourceUrl() == null) {
                                                    String str7 = this.contentTitle;
                                                    if (str7 != null ? str7.equals(zzba.contentTitle()) : zzba.contentTitle() == null) {
                                                        String str8 = this.contentUrl;
                                                        if (str8 != null ? str8.equals(zzba.contentUrl()) : zzba.contentUrl() == null) {
                                                            String str9 = this.contentSourceId;
                                                            if (str9 != null ? str9.equals(zzba.contentSourceId()) : zzba.contentSourceId() == null) {
                                                                zzaw zzaw = this.consentSettings;
                                                                if (zzaw != null ? zzaw.equals(zzba.consentSettings()) : zzba.consentSettings() == null) {
                                                                    String str10 = this.customAssetKey;
                                                                    if (str10 != null ? str10.equals(zzba.customAssetKey()) : zzba.customAssetKey() == null) {
                                                                        Boolean bool = this.enableNonce;
                                                                        if (bool != null ? bool.equals(zzba.enableNonce()) : zzba.enableNonce() == null) {
                                                                            String str11 = this.env;
                                                                            if (str11 != null ? str11.equals(zzba.env()) : zzba.env() == null) {
                                                                                zzso<zzbo> zzso2 = this.secureSignals;
                                                                                if (zzso2 != null ? zzso2.equals(zzba.secureSignals()) : zzba.secureSignals() == null) {
                                                                                    zzsr<String, String> zzsr3 = this.extraParameters;
                                                                                    if (zzsr3 != null ? zzsr3.equals(zzba.extraParameters()) : zzba.extraParameters() == null) {
                                                                                        String str12 = this.format;
                                                                                        if (str12 != null ? str12.equals(zzba.format()) : zzba.format() == null) {
                                                                                            zzbc zzbc = this.identifierInfo;
                                                                                            if (zzbc != null ? zzbc.equals(zzba.identifierInfo()) : zzba.identifierInfo() == null) {
                                                                                                Boolean bool2 = this.isTv;
                                                                                                if (bool2 != null ? bool2.equals(zzba.isTv()) : zzba.isTv() == null) {
                                                                                                    Boolean bool3 = this.isAndroidTvAdsFramework;
                                                                                                    if (bool3 != null ? bool3.equals(zzba.isAndroidTvAdsFramework()) : zzba.isAndroidTvAdsFramework() == null) {
                                                                                                        Integer num = this.linearAdSlotWidth;
                                                                                                        if (num != null ? num.equals(zzba.linearAdSlotWidth()) : zzba.linearAdSlotWidth() == null) {
                                                                                                            Integer num2 = this.linearAdSlotHeight;
                                                                                                            if (num2 != null ? num2.equals(zzba.linearAdSlotHeight()) : zzba.linearAdSlotHeight() == null) {
                                                                                                                String str13 = this.liveStreamEventId;
                                                                                                                if (str13 != null ? str13.equals(zzba.liveStreamEventId()) : zzba.liveStreamEventId() == null) {
                                                                                                                    Float f2 = this.liveStreamPrefetchSeconds;
                                                                                                                    if (f2 != null ? f2.equals(zzba.liveStreamPrefetchSeconds()) : zzba.liveStreamPrefetchSeconds() == null) {
                                                                                                                        zzeb zzeb = this.marketAppInfo;
                                                                                                                        if (zzeb != null ? zzeb.equals(zzba.marketAppInfo()) : zzba.marketAppInfo() == null) {
                                                                                                                            String str14 = this.msParameter;
                                                                                                                            if (str14 != null ? str14.equals(zzba.msParameter()) : zzba.msParameter() == null) {
                                                                                                                                String str15 = this.network;
                                                                                                                                if (str15 != null ? str15.equals(zzba.network()) : zzba.network() == null) {
                                                                                                                                    zzbu zzbu = this.videoEnvironment;
                                                                                                                                    if (zzbu != null ? zzbu.equals(zzba.videoEnvironment()) : zzba.videoEnvironment() == null) {
                                                                                                                                        String str16 = this.networkCode;
                                                                                                                                        if (str16 != null ? str16.equals(zzba.networkCode()) : zzba.networkCode() == null) {
                                                                                                                                            String str17 = this.oAuthToken;
                                                                                                                                            if (str17 != null ? str17.equals(zzba.oAuthToken()) : zzba.oAuthToken() == null) {
                                                                                                                                                Boolean bool4 = this.omidAdSessionsOnStartedOnly;
                                                                                                                                                if (bool4 != null ? bool4.equals(zzba.omidAdSessionsOnStartedOnly()) : zzba.omidAdSessionsOnStartedOnly() == null) {
                                                                                                                                                    zzsr<String, String> zzsr4 = this.platformSignals;
                                                                                                                                                    if (zzsr4 != null ? zzsr4.equals(zzba.platformSignals()) : zzba.platformSignals() == null) {
                                                                                                                                                        String str18 = this.projectNumber;
                                                                                                                                                        if (str18 != null ? str18.equals(zzba.projectNumber()) : zzba.projectNumber() == null) {
                                                                                                                                                            String str19 = this.region;
                                                                                                                                                            if (str19 != null ? str19.equals(zzba.region()) : zzba.region() == null) {
                                                                                                                                                                ImaSdkSettings imaSdkSettings = this.settings;
                                                                                                                                                                if (imaSdkSettings != null ? imaSdkSettings.equals(zzba.settings()) : zzba.settings() == null) {
                                                                                                                                                                    Boolean bool5 = this.supportsExternalNavigation;
                                                                                                                                                                    if (bool5 != null ? bool5.equals(zzba.supportsExternalNavigation()) : zzba.supportsExternalNavigation() == null) {
                                                                                                                                                                        Boolean bool6 = this.supportsIconClickFallback;
                                                                                                                                                                        if (bool6 != null ? bool6.equals(zzba.supportsIconClickFallback()) : zzba.supportsIconClickFallback() == null) {
                                                                                                                                                                            Boolean bool7 = this.supportsNativeNetworking;
                                                                                                                                                                            if (bool7 != null ? bool7.equals(zzba.supportsNativeNetworking()) : zzba.supportsNativeNetworking() == null) {
                                                                                                                                                                                String str20 = this.streamActivityMonitorId;
                                                                                                                                                                                if (str20 != null ? str20.equals(zzba.streamActivityMonitorId()) : zzba.streamActivityMonitorId() == null) {
                                                                                                                                                                                    Boolean bool8 = this.supportsResizing;
                                                                                                                                                                                    if (bool8 != null ? bool8.equals(zzba.supportsResizing()) : zzba.supportsResizing() == null) {
                                                                                                                                                                                        Boolean bool9 = this.useQAStreamBaseUrl;
                                                                                                                                                                                        if (bool9 != null ? bool9.equals(zzba.useQAStreamBaseUrl()) : zzba.useQAStreamBaseUrl() == null) {
                                                                                                                                                                                            Boolean bool10 = this.usesCustomVideoPlayback;
                                                                                                                                                                                            if (bool10 != null ? bool10.equals(zzba.usesCustomVideoPlayback()) : zzba.usesCustomVideoPlayback() == null) {
                                                                                                                                                                                                Float f3 = this.vastLoadTimeout;
                                                                                                                                                                                                if (f3 != null ? f3.equals(zzba.vastLoadTimeout()) : zzba.vastLoadTimeout() == null) {
                                                                                                                                                                                                    String str21 = this.videoId;
                                                                                                                                                                                                    if (str21 != null ? str21.equals(zzba.videoId()) : zzba.videoId() == null) {
                                                                                                                                                                                                        zzef zzef = this.videoPlayActivation;
                                                                                                                                                                                                        if (zzef != null ? zzef.equals(zzba.videoPlayActivation()) : zzba.videoPlayActivation() == null) {
                                                                                                                                                                                                            zzeg zzeg = this.videoContinuousPlay;
                                                                                                                                                                                                            if (zzeg != null ? zzeg.equals(zzba.videoContinuousPlay()) : zzba.videoContinuousPlay() == null) {
                                                                                                                                                                                                                zzeh zzeh = this.videoPlayMuted;
                                                                                                                                                                                                                if (zzeh != null ? zzeh.equals(zzba.videoPlayMuted()) : zzba.videoPlayMuted() == null) {
                                                                                                                                                                                                                    return true;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public zzsr<String, String> extraParameters() {
        return this.extraParameters;
    }

    public String format() {
        return this.format;
    }

    public zzbc identifierInfo() {
        return this.identifierInfo;
    }

    public Boolean isAndroidTvAdsFramework() {
        return this.isAndroidTvAdsFramework;
    }

    public Boolean isTv() {
        return this.isTv;
    }

    public Integer linearAdSlotHeight() {
        return this.linearAdSlotHeight;
    }

    public Integer linearAdSlotWidth() {
        return this.linearAdSlotWidth;
    }

    public String liveStreamEventId() {
        return this.liveStreamEventId;
    }

    public Float liveStreamPrefetchSeconds() {
        return this.liveStreamPrefetchSeconds;
    }

    public zzeb marketAppInfo() {
        return this.marketAppInfo;
    }

    public String msParameter() {
        return this.msParameter;
    }

    public String network() {
        return this.network;
    }

    public String networkCode() {
        return this.networkCode;
    }

    public String oAuthToken() {
        return this.oAuthToken;
    }

    public Boolean omidAdSessionsOnStartedOnly() {
        return this.omidAdSessionsOnStartedOnly;
    }

    public zzsr<String, String> platformSignals() {
        return this.platformSignals;
    }

    public String projectNumber() {
        return this.projectNumber;
    }

    public String region() {
        return this.region;
    }

    public zzso<zzbo> secureSignals() {
        return this.secureSignals;
    }

    public ImaSdkSettings settings() {
        return this.settings;
    }

    public String streamActivityMonitorId() {
        return this.streamActivityMonitorId;
    }

    public Boolean supportsExternalNavigation() {
        return this.supportsExternalNavigation;
    }

    public Boolean supportsIconClickFallback() {
        return this.supportsIconClickFallback;
    }

    public Boolean supportsNativeNetworking() {
        return this.supportsNativeNetworking;
    }

    public Boolean supportsResizing() {
        return this.supportsResizing;
    }

    public String toString() {
        String valueOf = String.valueOf(this.adTagParameters);
        String str = this.adTagUrl;
        String str2 = this.adsResponse;
        String str3 = this.apiKey;
        String str4 = this.assetKey;
        String str5 = this.authToken;
        String valueOf2 = String.valueOf(this.companionSlots);
        Float f = this.contentDuration;
        String valueOf3 = String.valueOf(this.contentKeywords);
        String str6 = this.contentSourceUrl;
        String str7 = this.contentTitle;
        String str8 = this.contentUrl;
        String str9 = this.contentSourceId;
        String valueOf4 = String.valueOf(this.consentSettings);
        String str10 = this.customAssetKey;
        Boolean bool = this.enableNonce;
        String str11 = this.env;
        String valueOf5 = String.valueOf(this.secureSignals);
        String valueOf6 = String.valueOf(this.extraParameters);
        String str12 = this.format;
        String valueOf7 = String.valueOf(this.identifierInfo);
        Boolean bool2 = this.isTv;
        Boolean bool3 = this.isAndroidTvAdsFramework;
        Integer num = this.linearAdSlotWidth;
        Integer num2 = this.linearAdSlotHeight;
        String str13 = this.liveStreamEventId;
        Float f2 = this.liveStreamPrefetchSeconds;
        String valueOf8 = String.valueOf(this.marketAppInfo);
        String str14 = this.msParameter;
        String str15 = this.network;
        String valueOf9 = String.valueOf(this.videoEnvironment);
        String str16 = this.networkCode;
        String str17 = this.oAuthToken;
        Boolean bool4 = this.omidAdSessionsOnStartedOnly;
        String valueOf10 = String.valueOf(this.platformSignals);
        String str18 = this.projectNumber;
        String str19 = this.region;
        String valueOf11 = String.valueOf(this.settings);
        Boolean bool5 = this.supportsExternalNavigation;
        Boolean bool6 = this.supportsIconClickFallback;
        Boolean bool7 = this.supportsNativeNetworking;
        String str20 = this.streamActivityMonitorId;
        Boolean bool8 = this.supportsResizing;
        Boolean bool9 = this.useQAStreamBaseUrl;
        Boolean bool10 = this.usesCustomVideoPlayback;
        Float f3 = this.vastLoadTimeout;
        String str21 = this.videoId;
        String valueOf12 = String.valueOf(this.videoPlayActivation);
        String valueOf13 = String.valueOf(this.videoContinuousPlay);
        return "GsonAdsRequest{adTagParameters=" + valueOf + ", adTagUrl=" + str + ", adsResponse=" + str2 + ", apiKey=" + str3 + ", assetKey=" + str4 + ", authToken=" + str5 + ", companionSlots=" + valueOf2 + ", contentDuration=" + f + ", contentKeywords=" + valueOf3 + ", contentSourceUrl=" + str6 + ", contentTitle=" + str7 + ", contentUrl=" + str8 + ", contentSourceId=" + str9 + ", consentSettings=" + valueOf4 + ", customAssetKey=" + str10 + ", enableNonce=" + bool + ", env=" + str11 + ", secureSignals=" + valueOf5 + ", extraParameters=" + valueOf6 + ", format=" + str12 + ", identifierInfo=" + valueOf7 + ", isTv=" + bool2 + ", isAndroidTvAdsFramework=" + bool3 + ", linearAdSlotWidth=" + num + ", linearAdSlotHeight=" + num2 + ", liveStreamEventId=" + str13 + ", liveStreamPrefetchSeconds=" + f2 + ", marketAppInfo=" + valueOf8 + ", msParameter=" + str14 + ", network=" + str15 + ", videoEnvironment=" + valueOf9 + ", networkCode=" + str16 + ", oAuthToken=" + str17 + ", omidAdSessionsOnStartedOnly=" + bool4 + ", platformSignals=" + valueOf10 + ", projectNumber=" + str18 + ", region=" + str19 + ", settings=" + valueOf11 + ", supportsExternalNavigation=" + bool5 + ", supportsIconClickFallback=" + bool6 + ", supportsNativeNetworking=" + bool7 + ", streamActivityMonitorId=" + str20 + ", supportsResizing=" + bool8 + ", useQAStreamBaseUrl=" + bool9 + ", usesCustomVideoPlayback=" + bool10 + ", vastLoadTimeout=" + f3 + ", videoId=" + str21 + ", videoPlayActivation=" + valueOf12 + ", videoContinuousPlay=" + valueOf13 + ", videoPlayMuted=" + String.valueOf(this.videoPlayMuted) + "}";
    }

    public Boolean useQAStreamBaseUrl() {
        return this.useQAStreamBaseUrl;
    }

    public Boolean usesCustomVideoPlayback() {
        return this.usesCustomVideoPlayback;
    }

    public Float vastLoadTimeout() {
        return this.vastLoadTimeout;
    }

    public zzeg videoContinuousPlay() {
        return this.videoContinuousPlay;
    }

    public zzbu videoEnvironment() {
        return this.videoEnvironment;
    }

    public String videoId() {
        return this.videoId;
    }

    public zzef videoPlayActivation() {
        return this.videoPlayActivation;
    }

    public zzeh videoPlayMuted() {
        return this.videoPlayMuted;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        zzsr<String, String> zzsr = this.adTagParameters;
        int i5 = 0;
        int hashCode = zzsr == null ? 0 : zzsr.hashCode();
        String str = this.adTagUrl;
        int hashCode2 = str == null ? 0 : str.hashCode();
        int i6 = hashCode ^ 1000003;
        String str2 = this.adsResponse;
        int hashCode3 = ((((i6 * 1000003) ^ hashCode2) * 1000003) ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.apiKey;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.assetKey;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.authToken;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        zzsr<String, String> zzsr2 = this.companionSlots;
        int hashCode7 = (hashCode6 ^ (zzsr2 == null ? 0 : zzsr2.hashCode())) * 1000003;
        Float f = this.contentDuration;
        int hashCode8 = (hashCode7 ^ (f == null ? 0 : f.hashCode())) * 1000003;
        zzso<String> zzso = this.contentKeywords;
        int hashCode9 = (hashCode8 ^ (zzso == null ? 0 : zzso.hashCode())) * 1000003;
        String str6 = this.contentSourceUrl;
        int hashCode10 = (hashCode9 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.contentTitle;
        int hashCode11 = (hashCode10 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.contentUrl;
        int hashCode12 = (hashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.contentSourceId;
        int hashCode13 = (hashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        zzaw zzaw = this.consentSettings;
        int hashCode14 = (hashCode13 ^ (zzaw == null ? 0 : zzaw.hashCode())) * 1000003;
        String str10 = this.customAssetKey;
        int hashCode15 = (hashCode14 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Boolean bool = this.enableNonce;
        int hashCode16 = (hashCode15 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str11 = this.env;
        int hashCode17 = (hashCode16 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        zzso<zzbo> zzso2 = this.secureSignals;
        int hashCode18 = (hashCode17 ^ (zzso2 == null ? 0 : zzso2.hashCode())) * 1000003;
        zzsr<String, String> zzsr3 = this.extraParameters;
        int hashCode19 = (hashCode18 ^ (zzsr3 == null ? 0 : zzsr3.hashCode())) * 1000003;
        String str12 = this.format;
        int hashCode20 = (hashCode19 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        zzbc zzbc = this.identifierInfo;
        int hashCode21 = (hashCode20 ^ (zzbc == null ? 0 : zzbc.hashCode())) * 1000003;
        Boolean bool2 = this.isTv;
        int hashCode22 = (hashCode21 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Boolean bool3 = this.isAndroidTvAdsFramework;
        int hashCode23 = (hashCode22 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        Integer num = this.linearAdSlotWidth;
        int hashCode24 = (hashCode23 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.linearAdSlotHeight;
        int hashCode25 = (hashCode24 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str13 = this.liveStreamEventId;
        int hashCode26 = (hashCode25 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        Float f2 = this.liveStreamPrefetchSeconds;
        int hashCode27 = (hashCode26 ^ (f2 == null ? 0 : f2.hashCode())) * 1000003;
        zzeb zzeb = this.marketAppInfo;
        int hashCode28 = (hashCode27 ^ (zzeb == null ? 0 : zzeb.hashCode())) * 1000003;
        String str14 = this.msParameter;
        int hashCode29 = (hashCode28 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.network;
        int hashCode30 = (hashCode29 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        zzbu zzbu = this.videoEnvironment;
        int hashCode31 = (hashCode30 ^ (zzbu == null ? 0 : zzbu.hashCode())) * 1000003;
        String str16 = this.networkCode;
        int hashCode32 = (hashCode31 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.oAuthToken;
        int hashCode33 = (hashCode32 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        Boolean bool4 = this.omidAdSessionsOnStartedOnly;
        int hashCode34 = (hashCode33 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
        zzsr<String, String> zzsr4 = this.platformSignals;
        int hashCode35 = (hashCode34 ^ (zzsr4 == null ? 0 : zzsr4.hashCode())) * 1000003;
        String str18 = this.projectNumber;
        int hashCode36 = (hashCode35 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.region;
        int hashCode37 = (hashCode36 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        ImaSdkSettings imaSdkSettings = this.settings;
        int hashCode38 = (hashCode37 ^ (imaSdkSettings == null ? 0 : imaSdkSettings.hashCode())) * 1000003;
        Boolean bool5 = this.supportsExternalNavigation;
        int hashCode39 = (hashCode38 ^ (bool5 == null ? 0 : bool5.hashCode())) * 1000003;
        Boolean bool6 = this.supportsIconClickFallback;
        int hashCode40 = (hashCode39 ^ (bool6 == null ? 0 : bool6.hashCode())) * 1000003;
        Boolean bool7 = this.supportsNativeNetworking;
        int hashCode41 = (hashCode40 ^ (bool7 == null ? 0 : bool7.hashCode())) * 1000003;
        String str20 = this.streamActivityMonitorId;
        int hashCode42 = (hashCode41 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        Boolean bool8 = this.supportsResizing;
        int hashCode43 = (hashCode42 ^ (bool8 == null ? 0 : bool8.hashCode())) * 1000003;
        Boolean bool9 = this.useQAStreamBaseUrl;
        int hashCode44 = (hashCode43 ^ (bool9 == null ? 0 : bool9.hashCode())) * 1000003;
        Boolean bool10 = this.usesCustomVideoPlayback;
        int hashCode45 = (hashCode44 ^ (bool10 == null ? 0 : bool10.hashCode())) * 1000003;
        Float f3 = this.vastLoadTimeout;
        if (f3 == null) {
            i = 0;
        } else {
            i = f3.hashCode();
        }
        int i7 = (hashCode45 ^ i) * 1000003;
        String str21 = this.videoId;
        if (str21 == null) {
            i2 = 0;
        } else {
            i2 = str21.hashCode();
        }
        int i8 = (i7 ^ i2) * 1000003;
        zzef zzef = this.videoPlayActivation;
        if (zzef == null) {
            i3 = 0;
        } else {
            i3 = zzef.hashCode();
        }
        int i9 = (i8 ^ i3) * 1000003;
        zzeg zzeg = this.videoContinuousPlay;
        if (zzeg == null) {
            i4 = 0;
        } else {
            i4 = zzeg.hashCode();
        }
        int i10 = (i9 ^ i4) * 1000003;
        zzeh zzeh = this.videoPlayMuted;
        if (zzeh != null) {
            i5 = zzeh.hashCode();
        }
        return i10 ^ i5;
    }
}
