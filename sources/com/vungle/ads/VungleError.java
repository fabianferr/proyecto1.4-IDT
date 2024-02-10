package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0001)BO\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\r\u0010!\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b&J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b'J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b(R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013\u0001 *+,-./0123456789:;<=>?@ABCDEFGHI¨\u0006J"}, d2 = {"Lcom/vungle/ads/VungleError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "loggableReason", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", "errorMessage", "", "placementId", "creativeId", "eventId", "(Ljava/lang/Integer;Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "code", "getCode", "()I", "getCreativeId", "()Ljava/lang/String;", "setCreativeId", "(Ljava/lang/String;)V", "getErrorMessage", "getEventId", "setEventId", "getLoggableReason", "()Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", "getPlacementId", "setPlacementId", "equals", "", "other", "", "getLocalizedMessage", "hashCode", "logError", "logError$vungle_ads_release", "logErrorNoReturnValue", "", "logErrorNoReturnValue$vungle_ads_release", "setCreativeId$vungle_ads_release", "setEventId$vungle_ads_release", "setPlacementId$vungle_ads_release", "Companion", "Lcom/vungle/ads/AdCantPlayWithoutWebView;", "Lcom/vungle/ads/AdExpiredError;", "Lcom/vungle/ads/AdExpiredOnPlayError;", "Lcom/vungle/ads/AdFailedToDownloadError;", "Lcom/vungle/ads/AdMarkupInvalidError;", "Lcom/vungle/ads/AdNotLoadedCantPlay;", "Lcom/vungle/ads/AdRetryActiveError;", "Lcom/vungle/ads/AdRetryError;", "Lcom/vungle/ads/AssetDownloadError;", "Lcom/vungle/ads/AssetFailedStatusCodeError;", "Lcom/vungle/ads/ConcurrentPlaybackUnsupported;", "Lcom/vungle/ads/ConfigurationError;", "Lcom/vungle/ads/ConfigurationResponseError;", "Lcom/vungle/ads/InternalError;", "Lcom/vungle/ads/InvalidAdStateError;", "Lcom/vungle/ads/InvalidAppId;", "Lcom/vungle/ads/InvalidWaterfallPlacementError;", "Lcom/vungle/ads/MraidJsError;", "Lcom/vungle/ads/NetworkPermissionsNotGranted;", "Lcom/vungle/ads/NetworkUnreachable;", "Lcom/vungle/ads/NoServeError;", "Lcom/vungle/ads/OutOfMemory;", "Lcom/vungle/ads/PlacementAdTypeMismatchError;", "Lcom/vungle/ads/PlacementNotFoundError;", "Lcom/vungle/ads/PrivacyUrlError;", "Lcom/vungle/ads/SdkAlreadyInitialized;", "Lcom/vungle/ads/SdkInitializationInProgress;", "Lcom/vungle/ads/SdkNotInitialized;", "Lcom/vungle/ads/SdkVersionTooLow;", "Lcom/vungle/ads/TpatRetryFailure;", "Lcom/vungle/ads/UnknownConfigurationError;", "Lcom/vungle/ads/UnknownExceptionCode;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleError.kt */
public abstract class VungleError extends Exception {
    public static final int AD_ALREADY_FAILED = 206;
    public static final int AD_ALREADY_LOADED = 204;
    public static final int AD_CLOSED_MISSING_HEARTBEAT = 318;
    public static final int AD_CLOSED_TEMPLATE_ERROR = 317;
    public static final int AD_CONSUMED = 202;
    public static final int AD_EXPIRED = 304;
    public static final int AD_EXPIRED_ON_PLAY = 307;
    public static final int AD_FAILED_TO_DOWNLOAD = 10011;
    public static final int AD_HTML_FAILED_TO_LOAD = 310;
    public static final int AD_IS_LOADING = 203;
    public static final int AD_IS_PLAYING = 205;
    public static final int AD_LOAD_FAIL_RETRY_AFTER = 221;
    public static final int AD_MARKUP_INVALID = 10040;
    public static final int AD_NOT_LOADED = 210;
    public static final int AD_RENDER_NETWORK_ERROR = 10038;
    public static final int AD_RESPONSE_EMPTY = 215;
    public static final int AD_RESPONSE_INVALID_TEMPLATE_TYPE = 216;
    public static final int AD_RESPONSE_RETRY_AFTER = 220;
    public static final int AD_RESPONSE_TIMED_OUT = 217;
    public static final int AD_UNABLE_TO_PLAY = 10010;
    public static final int AD_WIN_NOTIFICATION_ERROR = 308;
    public static final int ALREADY_INITIALIZED = 4;
    public static final int ALREADY_PLAYING_ANOTHER_AD = 10015;
    public static final int API_FAILED_STATUS_CODE = 104;
    public static final int API_REQUEST_ERROR = 101;
    public static final int API_RESPONSE_DATA_ERROR = 102;
    public static final int API_RESPONSE_DECODE_ERROR = 103;
    public static final int ASSET_DOWNLOAD_ERROR = 10024;
    public static final int ASSET_FAILED_INSUFFICIENT_SPACE = 126;
    public static final int ASSET_FAILED_MAX_SPACE_EXCEEDED = 127;
    public static final int ASSET_FAILED_STATUS_CODE = 117;
    public static final int ASSET_FAILED_TO_DELETE = 309;
    public static final int ASSET_REQUEST_ERROR = 112;
    public static final int ASSET_RESPONSE_DATA_ERROR = 113;
    public static final int ASSET_WRITE_ERROR = 114;
    public static final int BANNER_VIEW_INVALID_SIZE = 500;
    public static final int CONCURRENT_PLAYBACK_UNSUPPORTED = 400;
    public static final int CONFIGURATION_ERROR = 10003;
    public static final int CREATIVE_ERROR = 10041;
    public static final int CURRENTLY_INITIALIZING = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEEPLINK_OPEN_FAILED = 312;
    public static final int DEFAULT = 10000;
    public static final int EMPTY_TPAT_ERROR = 129;
    public static final int EVALUATE_JAVASCRIPT_FAILED = 313;
    /* access modifiers changed from: private */
    public static final Map<Integer, String> EXCEPTION_CODE_TO_MESSAGE_MAP;
    public static final int GENERATE_JSON_DATA_ERROR = 316;
    public static final int GZIP_ENCODE_ERROR = 116;
    public static final int HEARTBEAT_ERROR = 10043;
    public static final int INVALID_ADS_ENDPOINT = 122;
    public static final int INVALID_ADUNIT_BID_PAYLOAD = 213;
    public static final int INVALID_AD_STATE = 10042;
    public static final int INVALID_APP_ID = 2;
    public static final int INVALID_ASSET_URL = 111;
    public static final int INVALID_BID_PAYLOAD = 208;
    public static final int INVALID_CONFIG_RESPONSE = 135;
    public static final int INVALID_CTA_URL = 110;
    public static final int INVALID_EVENT_ID_ERROR = 200;
    public static final int INVALID_GZIP_BID_PAYLOAD = 214;
    public static final int INVALID_IFA_STATUS = 302;
    public static final int INVALID_INDEX_URL = 115;
    public static final int INVALID_JSON_BID_PAYLOAD = 209;
    public static final int INVALID_LOG_ERROR_ENDPOINT = 124;
    public static final int INVALID_METRICS_ENDPOINT = 125;
    public static final int INVALID_PLACEMENT_ID = 201;
    public static final int INVALID_REQUEST_BUILDER_ERROR = 106;
    public static final int INVALID_RI_ENDPOINT = 123;
    public static final int INVALID_SIZE = 10028;
    public static final int INVALID_TEMPLATE_URL = 105;
    public static final int INVALID_TPAT_KEY = 128;
    public static final int INVALID_WATERFALL_PLACEMENT = 222;
    public static final int JSON_ENCODE_ERROR = 119;
    public static final int JSON_PARAMS_ENCODE_ERROR = 315;
    public static final int LINK_COMMAND_OPEN_FAILED = 314;
    public static final int MRAID_BRIDGE_ERROR = 305;
    public static final int MRAID_DOWNLOAD_JS_ERROR = 130;
    public static final int MRAID_ERROR = 301;
    public static final int MRAID_JS_CALL_EMPTY = 311;
    public static final int MRAID_JS_COPY_FAILED = 219;
    public static final int MRAID_JS_DOES_NOT_EXIST = 218;
    public static final int MRAID_JS_WRITE_FAILED = 131;
    public static final int NATIVE_ASSET_ERROR = 600;
    public static final int NETWORK_ERROR = 10020;
    public static final int NETWORK_PERMISSIONS_NOT_GRANTED = 10034;
    public static final int NETWORK_TIMEOUT = 10047;
    public static final int NETWORK_UNREACHABLE = 10033;
    public static final int NO_SERVE = 10001;
    public static final int NO_SPACE_TO_DOWNLOAD_ASSETS = 10019;
    public static final int OMSDK_COPY_ERROR = 2003;
    public static final int OMSDK_DOWNLOAD_JS_ERROR = 132;
    public static final int OMSDK_JS_WRITE_FAILED = 133;
    public static final int OUT_OF_MEMORY = 3001;
    public static final int PLACEMENT_AD_TYPE_MISMATCH = 207;
    public static final int PLACEMENT_NOT_FOUND = 10013;
    public static final int PLACEMENT_SLEEP = 212;
    public static final int PRIVACY_URL_ERROR = 136;
    public static final int PROTOBUF_SERIALIZATION_ERROR = 118;
    public static final int REACHABILITY_INITIALIZATION_FAILED = 2005;
    public static final int SDK_NOT_INITIALIZED = 6;
    public static final int SDK_VERSION_BELOW_REQUIRED_VERSION = 10035;
    public static final int SERVER_RETRY_ERROR = 10014;
    public static final int STORE_KIT_LOAD_ERROR = 2002;
    public static final int STORE_OVERLAY_LOAD_ERROR = 2004;
    public static final int STORE_REGION_CODE_ERROR = 134;
    public static final int TEMPLATE_UNZIP_ERROR = 109;
    public static final int TPAT_ERROR = 121;
    public static final int TPAT_RETRY_FAILED = 137;
    public static final int UNKNOWN_ERROR = 0;
    public static final int UNKNOWN_EXCEPTION_CODE = 10048;
    public static final int UNKNOWN_RADIO_ACCESS_TECHNOLOGY = 2006;
    public static final int UNRECOGNIZED = -1;
    public static final int USER_AGENT_ERROR = 7;
    public static final int WEBVIEW_RENDER_UNRESPONSIVE = 10032;
    public static final int WEB_CRASH = 10031;
    public static final int WEB_VIEW_FAILED_NAVIGATION = 2001;
    public static final int WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE = 2000;
    private final int code;
    private String creativeId;
    private final String errorMessage;
    private String eventId;
    private final Sdk.SDKError.Reason loggableReason;
    private String placementId;

    public /* synthetic */ VungleError(Integer num, Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, reason, str, str2, str3, str4);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VungleError(java.lang.Integer r8, com.vungle.ads.internal.protos.Sdk.SDKError.Reason r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r3 = r14 & 4
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r10
        L_0x0016:
            r4 = r14 & 8
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r5 = r14 & 16
            if (r5 == 0) goto L_0x0023
            r5 = r1
            goto L_0x0024
        L_0x0023:
            r5 = r12
        L_0x0024:
            r6 = r14 & 32
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r13
        L_0x002a:
            r6 = 0
            r8 = r7
            r9 = r0
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r14 = r1
            r15 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.VungleError.<init>(java.lang.Integer, com.vungle.ads.internal.protos.Sdk$SDKError$Reason, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Sdk.SDKError.Reason getLoggableReason() {
        return this.loggableReason;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final void setPlacementId(String str) {
        this.placementId = str;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final void setCreativeId(String str) {
        this.creativeId = str;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private VungleError(java.lang.Integer r4, com.vungle.ads.internal.protos.Sdk.SDKError.Reason r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r3 = this;
            r0 = 10000(0x2710, float:1.4013E-41)
            if (r6 != 0) goto L_0x0014
            com.vungle.ads.VungleError$Companion r1 = Companion
            if (r4 == 0) goto L_0x000d
            int r2 = r4.intValue()
            goto L_0x000f
        L_0x000d:
            r2 = 10000(0x2710, float:1.4013E-41)
        L_0x000f:
            java.lang.String r1 = r1.getLocalizedMessage(r2)
            goto L_0x0015
        L_0x0014:
            r1 = r6
        L_0x0015:
            r3.<init>(r1)
            r3.loggableReason = r5
            r3.placementId = r7
            r3.creativeId = r8
            r3.eventId = r9
            if (r4 == 0) goto L_0x0027
            int r5 = r4.intValue()
            goto L_0x002e
        L_0x0027:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.getNumber()
        L_0x002e:
            r3.code = r5
            if (r6 != 0) goto L_0x003e
            com.vungle.ads.VungleError$Companion r5 = Companion
            if (r4 == 0) goto L_0x003a
            int r0 = r4.intValue()
        L_0x003a:
            java.lang.String r6 = r5.getLocalizedMessage(r0)
        L_0x003e:
            r3.errorMessage = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.VungleError.<init>(java.lang.Integer, com.vungle.ads.internal.protos.Sdk$SDKError$Reason, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public String getLocalizedMessage() {
        return this.errorMessage;
    }

    public final VungleError logError$vungle_ads_release() {
        logErrorNoReturnValue$vungle_ads_release();
        return this;
    }

    public final void logErrorNoReturnValue$vungle_ads_release() {
        if (this.loggableReason != null) {
            AnalyticsClient.INSTANCE.logError$vungle_ads_release(this.loggableReason, this.errorMessage, this.placementId, this.creativeId, this.eventId);
        }
    }

    public final VungleError setPlacementId$vungle_ads_release(String str) {
        this.placementId = str;
        return this;
    }

    public final VungleError setCreativeId$vungle_ads_release(String str) {
        this.creativeId = str;
        return this;
    }

    public final VungleError setEventId$vungle_ads_release(String str) {
        this.eventId = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.vungle.ads.VungleError");
        VungleError vungleError = (VungleError) obj;
        return this.code == vungleError.code && this.loggableReason == vungleError.loggableReason && Intrinsics.areEqual((Object) this.errorMessage, (Object) vungleError.errorMessage) && Intrinsics.areEqual((Object) this.placementId, (Object) vungleError.placementId) && Intrinsics.areEqual((Object) this.creativeId, (Object) vungleError.creativeId) && Intrinsics.areEqual((Object) this.eventId, (Object) vungleError.eventId);
    }

    public int hashCode() {
        int i = this.code * 31;
        Sdk.SDKError.Reason reason = this.loggableReason;
        int i2 = 0;
        int hashCode = (((i + (reason != null ? reason.hashCode() : 0)) * 31) + this.errorMessage.hashCode()) * 31;
        String str = this.placementId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.creativeId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.eventId;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u0004J\u000e\u0010|\u001a\u0002022\u0006\u0010}\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/vungle/ads/VungleError$Companion;", "", "()V", "AD_ALREADY_FAILED", "", "AD_ALREADY_LOADED", "AD_CLOSED_MISSING_HEARTBEAT", "AD_CLOSED_TEMPLATE_ERROR", "AD_CONSUMED", "AD_EXPIRED", "AD_EXPIRED_ON_PLAY", "AD_FAILED_TO_DOWNLOAD", "AD_HTML_FAILED_TO_LOAD", "AD_IS_LOADING", "AD_IS_PLAYING", "AD_LOAD_FAIL_RETRY_AFTER", "AD_MARKUP_INVALID", "AD_NOT_LOADED", "AD_RENDER_NETWORK_ERROR", "AD_RESPONSE_EMPTY", "AD_RESPONSE_INVALID_TEMPLATE_TYPE", "AD_RESPONSE_RETRY_AFTER", "AD_RESPONSE_TIMED_OUT", "AD_UNABLE_TO_PLAY", "AD_WIN_NOTIFICATION_ERROR", "ALREADY_INITIALIZED", "ALREADY_PLAYING_ANOTHER_AD", "API_FAILED_STATUS_CODE", "API_REQUEST_ERROR", "API_RESPONSE_DATA_ERROR", "API_RESPONSE_DECODE_ERROR", "ASSET_DOWNLOAD_ERROR", "ASSET_FAILED_INSUFFICIENT_SPACE", "ASSET_FAILED_MAX_SPACE_EXCEEDED", "ASSET_FAILED_STATUS_CODE", "ASSET_FAILED_TO_DELETE", "ASSET_REQUEST_ERROR", "ASSET_RESPONSE_DATA_ERROR", "ASSET_WRITE_ERROR", "BANNER_VIEW_INVALID_SIZE", "CONCURRENT_PLAYBACK_UNSUPPORTED", "CONFIGURATION_ERROR", "CREATIVE_ERROR", "CURRENTLY_INITIALIZING", "DEEPLINK_OPEN_FAILED", "DEFAULT", "EMPTY_TPAT_ERROR", "EVALUATE_JAVASCRIPT_FAILED", "EXCEPTION_CODE_TO_MESSAGE_MAP", "", "", "GENERATE_JSON_DATA_ERROR", "GZIP_ENCODE_ERROR", "HEARTBEAT_ERROR", "INVALID_ADS_ENDPOINT", "INVALID_ADUNIT_BID_PAYLOAD", "INVALID_AD_STATE", "INVALID_APP_ID", "INVALID_ASSET_URL", "INVALID_BID_PAYLOAD", "INVALID_CONFIG_RESPONSE", "INVALID_CTA_URL", "INVALID_EVENT_ID_ERROR", "INVALID_GZIP_BID_PAYLOAD", "INVALID_IFA_STATUS", "INVALID_INDEX_URL", "INVALID_JSON_BID_PAYLOAD", "INVALID_LOG_ERROR_ENDPOINT", "INVALID_METRICS_ENDPOINT", "INVALID_PLACEMENT_ID", "INVALID_REQUEST_BUILDER_ERROR", "INVALID_RI_ENDPOINT", "INVALID_SIZE", "INVALID_TEMPLATE_URL", "INVALID_TPAT_KEY", "INVALID_WATERFALL_PLACEMENT", "JSON_ENCODE_ERROR", "JSON_PARAMS_ENCODE_ERROR", "LINK_COMMAND_OPEN_FAILED", "MRAID_BRIDGE_ERROR", "MRAID_DOWNLOAD_JS_ERROR", "MRAID_ERROR", "MRAID_JS_CALL_EMPTY", "MRAID_JS_COPY_FAILED", "MRAID_JS_DOES_NOT_EXIST", "MRAID_JS_WRITE_FAILED", "NATIVE_ASSET_ERROR", "NETWORK_ERROR", "NETWORK_PERMISSIONS_NOT_GRANTED", "NETWORK_TIMEOUT", "NETWORK_UNREACHABLE", "NO_SERVE", "NO_SPACE_TO_DOWNLOAD_ASSETS", "OMSDK_COPY_ERROR", "OMSDK_DOWNLOAD_JS_ERROR", "OMSDK_JS_WRITE_FAILED", "OUT_OF_MEMORY", "PLACEMENT_AD_TYPE_MISMATCH", "PLACEMENT_NOT_FOUND", "PLACEMENT_SLEEP", "PRIVACY_URL_ERROR", "PROTOBUF_SERIALIZATION_ERROR", "REACHABILITY_INITIALIZATION_FAILED", "SDK_NOT_INITIALIZED", "SDK_VERSION_BELOW_REQUIRED_VERSION", "SERVER_RETRY_ERROR", "STORE_KIT_LOAD_ERROR", "STORE_OVERLAY_LOAD_ERROR", "STORE_REGION_CODE_ERROR", "TEMPLATE_UNZIP_ERROR", "TPAT_ERROR", "TPAT_RETRY_FAILED", "UNKNOWN_ERROR", "UNKNOWN_EXCEPTION_CODE", "UNKNOWN_RADIO_ACCESS_TECHNOLOGY", "UNRECOGNIZED", "USER_AGENT_ERROR", "WEBVIEW_RENDER_UNRESPONSIVE", "WEB_CRASH", "WEB_VIEW_FAILED_NAVIGATION", "WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE", "codeToLoggableReason", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", "errorCode", "getLocalizedMessage", "exceptionCode", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleError.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLocalizedMessage(int i) {
            String str = (String) VungleError.EXCEPTION_CODE_TO_MESSAGE_MAP.get(Integer.valueOf(i));
            if (str == null) {
                new UnknownExceptionCode("No adequate description for exceptionCode=" + i).logErrorNoReturnValue$vungle_ads_release();
            }
            return str == null ? "Unknown Exception Code" : str;
        }

        public final Sdk.SDKError.Reason codeToLoggableReason(int i) {
            Sdk.SDKError.Reason forNumber = Sdk.SDKError.Reason.forNumber(i);
            Intrinsics.checkNotNullExpressionValue(forNumber, "forNumber(errorCode)");
            return forNumber;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(10000, "");
        hashMap.put(Integer.valueOf(CONFIGURATION_ERROR), "Configuration Error Occurred. Please check your appID and placementIDs, and try again when network connectivity is available.");
        hashMap.put(10001, "No advertisements are available for your current bid. Please try again later.");
        hashMap.put(0, "Unknown Error Occurred.");
        hashMap.put(304, "The advertisement in the cache has expired and can no longer be played. Please load another ad");
        hashMap.put(3, "There is already an ongoing operation for the action you requested. Please wait until the operation finished before starting another.");
        hashMap.put(6, "Vungle is not initialized/no longer initialized. Please call Vungle.init() to reinitialize.");
        hashMap.put(Integer.valueOf(AD_UNABLE_TO_PLAY), "Unable to play advertisement");
        hashMap.put(Integer.valueOf(AD_FAILED_TO_DOWNLOAD), "Advertisement failed to download");
        hashMap.put(Integer.valueOf(PLACEMENT_NOT_FOUND), "Placement is not valid");
        hashMap.put(Integer.valueOf(SERVER_RETRY_ERROR), "Remote Server responded with http Retry-After, SDK will retry this request.");
        hashMap.put(Integer.valueOf(ALREADY_PLAYING_ANOTHER_AD), "Vungle is already playing different ad.");
        hashMap.put(Integer.valueOf(NO_SPACE_TO_DOWNLOAD_ASSETS), "There is not enough file system size on a device to download assets for an ad.");
        hashMap.put(Integer.valueOf(NETWORK_ERROR), "Network error. Try again later");
        hashMap.put(Integer.valueOf(ASSET_DOWNLOAD_ERROR), "Assets download failed.");
        hashMap.put(Integer.valueOf(INVALID_SIZE), "Ad size is invalid");
        hashMap.put(Integer.valueOf(WEB_CRASH), "Android web view has crashed");
        hashMap.put(Integer.valueOf(WEBVIEW_RENDER_UNRESPONSIVE), "Android web view render became unresponsive, please clean-up your Webview process if any");
        hashMap.put(Integer.valueOf(NETWORK_UNREACHABLE), "Network error. Please check if network is available and permission for network access is granted.");
        hashMap.put(Integer.valueOf(NETWORK_PERMISSIONS_NOT_GRANTED), "Network permissions not granted. Please check manifest for android.permission.INTERNET and android.permission.ACCESS_NETWORK_STATE");
        hashMap.put(Integer.valueOf(SDK_VERSION_BELOW_REQUIRED_VERSION), "The SDK minimum version should not be overridden. Will not work as expected.");
        hashMap.put(Integer.valueOf(AD_RENDER_NETWORK_ERROR), "Ad rendering failed due to network connectivity issue");
        hashMap.put(3001, "Out of memory");
        hashMap.put(Integer.valueOf(AD_MARKUP_INVALID), "Invalid ad markup");
        hashMap.put(Integer.valueOf(CREATIVE_ERROR), "Creative error occurred");
        hashMap.put(Integer.valueOf(INVALID_AD_STATE), "Invalid ad state ");
        hashMap.put(Integer.valueOf(HEARTBEAT_ERROR), "Heartbeat not received within a valid time window");
        hashMap.put(2, "App id is invalid.");
        hashMap.put(207, "Ad type does not match with placement type.");
        hashMap.put(400, "Concurrent playback not supported");
        hashMap.put(Integer.valueOf(NETWORK_TIMEOUT), "Request timeout.");
        hashMap.put(137, "Pinging Tpat did not succeed during all allowed reries.");
        hashMap.put(130, "Failed to download mraid js.");
        hashMap.put(113, "Server returned an unexpected response object or failed to load the downloaded data.");
        hashMap.put(222, "Placement header bidding type does not match with loadAd call.");
        hashMap.put(136, "Failed to open privacy url");
        EXCEPTION_CODE_TO_MESSAGE_MAP = hashMap;
    }
}