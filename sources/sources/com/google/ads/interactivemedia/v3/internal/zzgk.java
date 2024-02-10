package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzgk implements StreamRequest {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private Map zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private StreamRequest.StreamFormat zzs;
    private Boolean zzt;
    private SecureSignals zzu;
    private transient Object zzv;

    public final Map<String, String> getAdTagParameters() {
        return this.zzn;
    }

    public final String getAdTagUrl() {
        return this.zza;
    }

    public final String getApiKey() {
        return this.zzc;
    }

    public final String getAssetKey() {
        return this.zzb;
    }

    public final String getAuthToken() {
        return this.zzq;
    }

    public final String getContentSourceId() {
        return this.zzd;
    }

    public final String getContentSourceUrl() {
        return this.zze;
    }

    public final String getContentUrl() {
        return this.zzp;
    }

    public final String getCustomAssetKey() {
        return this.zzi;
    }

    public final boolean getEnableNonce() {
        return this.zzf;
    }

    public final StreamRequest.StreamFormat getFormat() {
        return this.zzs;
    }

    public final String getLiveStreamEventId() {
        return this.zzj;
    }

    public final String getManifestSuffix() {
        return this.zzo;
    }

    public final String getNetworkCode() {
        return this.zzh;
    }

    public final String getOAuthToken() {
        return this.zzm;
    }

    public final String getProjectNumber() {
        return this.zzl;
    }

    public final String getRegion() {
        return this.zzk;
    }

    public final SecureSignals getSecureSignals() {
        return this.zzu;
    }

    public final String getStreamActivityMonitorId() {
        return this.zzr;
    }

    public final Boolean getUseQAStreamBaseUrl() {
        return this.zzt;
    }

    public final Object getUserRequestContext() {
        return this.zzv;
    }

    public final String getVideoId() {
        return this.zzg;
    }

    public final void setAdTagParameters(Map<String, String> map) {
        this.zzn = map;
    }

    public final void setAuthToken(String str) {
        this.zzq = str;
    }

    public final void setContentUrl(String str) {
        this.zzp = str;
    }

    public final void setEnableNonce(boolean z) {
        this.zzf = z;
    }

    public final void setFormat(StreamRequest.StreamFormat streamFormat) {
        this.zzs = streamFormat;
    }

    public final void setManifestSuffix(String str) {
        this.zzo = str;
    }

    public final void setSecureSignals(SecureSignals secureSignals) {
        this.zzu = secureSignals;
    }

    public final void setStreamActivityMonitorId(String str) {
        this.zzr = str;
    }

    public final void setUseQAStreamBaseUrl(Boolean bool) {
        this.zzt = bool;
    }

    public final void setUserRequestContext(Object obj) {
        this.zzv = obj;
    }

    public final zzgv zza() {
        return new zzgw();
    }

    public final void zzb(String str) {
        this.zza = str;
    }

    public final void zzc(String str) {
        this.zzc = str;
    }

    public final void zzd(String str) {
        this.zzb = str;
    }

    public final void zze(String str) {
        this.zzd = str;
    }

    public final void zzf(String str) {
        this.zze = str;
    }

    public final void zzg(String str) {
        this.zzi = str;
    }

    public final void zzh(String str) {
        this.zzj = str;
    }

    public final void zzi(String str) {
        this.zzh = str;
    }

    public final void zzj(String str) {
        this.zzm = str;
    }

    public final void zzk(String str) {
        this.zzl = str;
    }

    public final void zzl(String str) {
        this.zzk = str;
    }

    public final void zzm(String str) {
        this.zzg = str;
    }
}
