package com.google.ads.interactivemedia.v3.api;

import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class AdError extends Exception {
    private final AdErrorCode zza;
    private final AdErrorType zzb;

    /* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
    public enum AdErrorCode {
        INTERNAL_ERROR(-1),
        VAST_MALFORMED_RESPONSE(100),
        UNKNOWN_AD_RESPONSE(1010),
        VAST_TRAFFICKING_ERROR(200),
        VAST_LOAD_TIMEOUT(301),
        VAST_TOO_MANY_REDIRECTS(302),
        VIDEO_PLAY_ERROR(400),
        VAST_MEDIA_LOAD_TIMEOUT(402),
        VAST_LINEAR_ASSET_MISMATCH(403),
        OVERLAY_AD_PLAYING_FAILED(500),
        OVERLAY_AD_LOADING_FAILED(502),
        VAST_NONLINEAR_ASSET_MISMATCH(503),
        COMPANION_AD_LOADING_FAILED(603),
        UNKNOWN_ERROR(900),
        VAST_EMPTY_RESPONSE(1009),
        FAILED_TO_REQUEST_ADS(1005),
        VAST_ASSET_NOT_FOUND(1007),
        ADS_REQUEST_NETWORK_ERROR(1012),
        INVALID_ARGUMENTS(IronSourceConstants.RV_API_HAS_AVAILABILITY_TRUE),
        PLAYLIST_NO_CONTENT_TRACKING(IronSourceConstants.RV_INSTANCE_ENDED),
        UNEXPECTED_ADS_LOADED_EVENT(IronSourceConstants.RV_INSTANCE_VISIBLE),
        ADS_PLAYER_NOT_PROVIDED(IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE);
        
        private final int zzb;

        private AdErrorCode(int i) {
            this.zzb = i;
        }

        public static AdErrorCode getErrorCodeByNumber(int i) {
            for (AdErrorCode adErrorCode : values()) {
                if (adErrorCode.getErrorNumber() == i) {
                    return adErrorCode;
                }
            }
            return i == 1204 ? INTERNAL_ERROR : UNKNOWN_ERROR;
        }

        public int getErrorNumber() {
            return this.zzb;
        }

        public String toString() {
            String name = name();
            int i = this.zzb;
            return "AdErrorCode [name: " + name + ", number: " + i + "]";
        }
    }

    /* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
    public enum AdErrorType {
        LOAD,
        PLAY
    }

    public AdError(AdErrorType adErrorType, int i, String str) {
        this(adErrorType, AdErrorCode.getErrorCodeByNumber(i), str);
    }

    public AdErrorCode getErrorCode() {
        return this.zza;
    }

    public int getErrorCodeNumber() {
        return this.zza.getErrorNumber();
    }

    public AdErrorType getErrorType() {
        return this.zzb;
    }

    public String getMessage() {
        return super.getMessage();
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zza);
        String message = getMessage();
        return "AdError [errorType: " + valueOf + ", errorCode: " + valueOf2 + ", message: " + message + "]";
    }

    public AdError(AdErrorType adErrorType, AdErrorCode adErrorCode, String str) {
        super(str);
        this.zzb = adErrorType;
        this.zza = adErrorCode;
    }
}
