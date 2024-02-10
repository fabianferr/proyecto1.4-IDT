package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.StrictMode;
import android.webkit.WebView;
import androidx.preference.PreferenceManager;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.impl.data.JavaScriptMsgData;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.impl.data.zzaw;
import com.google.ads.interactivemedia.v3.impl.data.zzba;
import com.google.ads.interactivemedia.v3.impl.data.zzbc;
import com.google.ads.interactivemedia.v3.impl.data.zzbe;
import com.google.ads.interactivemedia.v3.impl.data.zzbf;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzec implements AdsLoader {
    zzmt zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private final zzvx zzc = zzvx.zzp();
    /* access modifiers changed from: private */
    public final zzfm zzd;
    private final zzfi zze = new zzea(this);
    /* access modifiers changed from: private */
    public final zzex zzf;
    private final List zzg = new ArrayList(1);
    /* access modifiers changed from: private */
    public final Map zzh = new HashMap();
    /* access modifiers changed from: private */
    public final Map zzi = new HashMap();
    /* access modifiers changed from: private */
    public final zzge zzj;
    private final ImaSdkSettings zzk;
    /* access modifiers changed from: private */
    public final BaseDisplayContainer zzl;
    private final zzhg zzm;
    private final zzhu zzn;
    private final Object zzo = new Object();
    private final zzvr zzp;
    /* access modifiers changed from: private */
    public final zzhc zzq;
    private final TestingConfiguration zzr;

    public zzec(Context context, Uri uri, ImaSdkSettings imaSdkSettings, BaseDisplayContainer baseDisplayContainer, ExecutorService executorService) {
        zzfm zzfm = new zzfm(new zzft(new Handler(Looper.getMainLooper()), new WebView(context), uri), context, uri, imaSdkSettings, executorService);
        this.zzd = zzfm;
        this.zzb = context;
        this.zzk = imaSdkSettings == null ? ImaSdkFactory.getInstance().createImaSdkSettings() : imaSdkSettings;
        this.zzl = baseDisplayContainer;
        zzvr zza2 = zzvw.zza(executorService);
        this.zzp = zza2;
        TestingConfiguration testingConfig = imaSdkSettings.getTestingConfig();
        this.zzr = testingConfig;
        zzge zzge = new zzge(zzfm, context);
        this.zzj = zzge;
        zzhc zzhc = new zzhc(zzfm);
        this.zzq = zzhc;
        this.zzf = new zzex(zzhc);
        zzfm.zzh(zzge);
        baseDisplayContainer.claim();
        this.zzm = new zzhg(context, zza2, zzhc, testingConfig);
        this.zzn = new zzhu(context, zza2, zzhc);
    }

    static /* bridge */ /* synthetic */ void zzm(zzec zzec, AdsManagerLoadedEvent adsManagerLoadedEvent) {
        for (AdsLoader.AdsLoadedListener onAdsManagerLoaded : zzec.zzg) {
            onAdsManagerLoaded.onAdsManagerLoaded(adsManagerLoadedEvent);
        }
    }

    static final Object zzr(Future future) {
        if (future == null) {
            return null;
        }
        try {
            return zzvd.zzc(future);
        } catch (Exception e) {
            zzhd.zzb("Error during initialization", e);
            return null;
        } catch (Throwable th) {
            zzhd.zzb("Error during initialization", new Exception(th));
            return null;
        }
    }

    private final zzeb zzs() {
        ActivityInfo activityInfo;
        PackageManager packageManager = this.zzb.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads.interactivemedia.v3")), 65536);
        if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            return zzeb.create(packageInfo.versionCode, activityInfo.packageName);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzaw zzt() {
        String str;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzb);
        if (defaultSharedPreferences == null) {
            return null;
        }
        try {
            int i = defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            if (defaultSharedPreferences.contains("IABTCF_gdprApplies")) {
                str = String.valueOf(i);
            } else {
                str = "";
            }
            return zzaw.create(str, defaultSharedPreferences.getString("IABTCF_TCString", ""), defaultSharedPreferences.getString("IABTCF_AddtlConsent", ""), defaultSharedPreferences.getString("IABUSPrivacy_String", ""));
        } catch (ClassCastException e) {
            zzhd.zzb("Failed to read TCF Consent settings from SharedPreferences.", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.ads.interactivemedia.v3.impl.data.zzbu zzu() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 0
            if (r0 >= r1) goto L_0x0009
        L_0x0007:
            r0 = r2
            goto L_0x0039
        L_0x0009:
            android.content.Context r0 = r3.zzb
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            int r0 = r0.checkCallingOrSelfPermission(r1)
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = "Host application doesn't have ACCESS_NETWORK_STATE permission"
            com.google.ads.interactivemedia.v3.internal.zzhd.zzd(r0)
            goto L_0x0007
        L_0x0019:
            android.content.Context r0 = r3.zzb
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            if (r0 != 0) goto L_0x0026
            goto L_0x0007
        L_0x0026:
            android.net.Network r1 = r0.getActiveNetwork()
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r1)
            if (r0 != 0) goto L_0x0031
            goto L_0x0007
        L_0x0031:
            int r0 = r0.getLinkDownstreamBandwidthKbps()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0039:
            if (r0 != 0) goto L_0x003c
            return r2
        L_0x003c:
            com.google.ads.interactivemedia.v3.impl.data.zzbu r0 = com.google.ads.interactivemedia.v3.impl.data.zzbu.create(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzec.zzu():com.google.ads.interactivemedia.v3.impl.data.zzbu");
    }

    private final String zzv() {
        TestingConfiguration testingConfiguration = this.zzr;
        if (testingConfiguration == null || !testingConfiguration.ignoreStrictModeFalsePositives()) {
            return UUID.randomUUID().toString();
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
        String uuid = UUID.randomUUID().toString();
        StrictMode.setThreadPolicy(threadPolicy);
        return uuid;
    }

    private final String zzw() {
        return String.format("android%s:%s:%s", new Object[]{Build.VERSION.RELEASE, "3.30.3", this.zzb.getPackageName()});
    }

    private final String zzx(Context context, boolean z) {
        synchronized (this.zzo) {
            if (this.zza == null) {
                int i = true != z ? 2 : 3;
                zzl zza2 = zzm.zza();
                zza2.zzd(i);
                zza2.zzc("a.3.30.3");
                zza2.zza(false);
                zza2.zzb(false);
                try {
                    this.zza = new zzmt(this.zzb, this.zzp, (zzm) zza2.zzak());
                } catch (RuntimeException unused) {
                    this.zza = null;
                }
            }
        }
        try {
            zzmt zzmt = this.zza;
            return zzmt != null ? zzmt.zza(context) : "";
        } catch (RemoteException unused2) {
            return "";
        }
    }

    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zzf.zza(adErrorListener);
    }

    public final void addAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.zzg.add(adsLoadedListener);
    }

    public final void contentComplete() {
        this.zzd.zzp(new zzff(zzfd.adsLoader, zzfe.contentComplete, "*", (Object) null));
    }

    public final ImaSdkSettings getSettings() {
        return this.zzk;
    }

    public final void release() {
        this.zzl.destroy();
        zzfm zzfm = this.zzd;
        if (zzfm != null) {
            zzfm.zzm();
        }
        this.zzh.clear();
        this.zzg.clear();
        this.zzf.zzb();
        this.zzi.clear();
    }

    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zzf.zzd(adErrorListener);
    }

    public final void removeAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.zzg.remove(adsLoadedListener);
    }

    public final void requestAds(AdsRequest adsRequest) {
        this.zzc.zzm(new zzdv(this, adsRequest), this.zzp);
    }

    public final String requestStream(StreamRequest streamRequest) {
        String zzv = zzv();
        this.zzc.zzm(new zzdu(this, streamRequest), this.zzp);
        return zzv;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzg(JavaScriptMsgData javaScriptMsgData) throws Exception {
        return zzx(this.zzb, javaScriptMsgData.useAndroidAdshieldV2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzh(JavaScriptMsgData javaScriptMsgData) throws Exception {
        return zzx(this.zzb, javaScriptMsgData.useAndroidAdshieldV2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzi(AdsRequest adsRequest, zzvq zzvq, AdDisplayContainer adDisplayContainer, zzvq zzvq2, zzvq zzvq3, zzvq zzvq4, String str) throws Exception {
        SecureSignals secureSignals = adsRequest.getSecureSignals();
        List list = (List) zzr(zzvq);
        zzhv.zza(secureSignals, list);
        zzbc zzbc = (zzbc) zzvd.zzc(zzvq2);
        Map map = (Map) zzr(zzvq4);
        zzaw zzt = zzt();
        AdsRequest adsRequest2 = adsRequest;
        zzff zzff = new zzff(zzfd.adsLoader, zzfe.requestAds, str, zzba.create(adsRequest2, zzw(), zzt, list, map, "android:0", zzu(), this.zzk, zzs(), zzgq.zzc(this.zzb, this.zzr), zzgq.zzb(this.zzb, this.zzr), (String) zzvd.zzc(zzvq3), zzbc, adDisplayContainer));
        this.zzd.zzj(zzbc);
        this.zzd.zzp(zzff);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzj(StreamRequest streamRequest, zzvq zzvq, zzvq zzvq2, zzvq zzvq3, zzvq zzvq4, String str) throws Exception {
        SecureSignals secureSignals = streamRequest.getSecureSignals();
        List list = (List) zzr(zzvq);
        zzhv.zza(secureSignals, list);
        zzbc zzbc = (zzbc) zzvd.zzc(zzvq2);
        String str2 = (String) zzvd.zzc(zzvq3);
        Map map = (Map) zzr(zzvq4);
        zzaw zzt = zzt();
        StreamRequest streamRequest2 = streamRequest;
        zzff zzff = new zzff(zzfd.adsLoader, zzfe.requestStream, str, zzba.createFromStreamRequest(streamRequest2, zzw(), zzt, list, map, "android:0", zzu(), this.zzk, zzs(), zzgq.zzc(this.zzb, this.zzr), zzgq.zzb(this.zzb, this.zzr), str2, zzbc, (StreamDisplayContainer) this.zzl));
        this.zzd.zzj(zzbc);
        this.zzd.zzp(zzff);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(Task task) {
        List<String> list;
        JavaScriptMsgData javaScriptMsgData = (JavaScriptMsgData) task.getResult();
        this.zzq.zzd(javaScriptMsgData.enableInstrumentation);
        Integer num = javaScriptMsgData.espAdapterTimeoutMs;
        if (!(num == null || (list = javaScriptMsgData.espAdapters) == null)) {
            this.zzn.zzc(list, num);
            this.zzn.zzb();
        }
        this.zzm.zzb(javaScriptMsgData.platformSignalCollectorTimeoutMs);
        this.zzc.zzc(javaScriptMsgData);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(AdsRequest adsRequest) {
        String zzv = zzv();
        JavaScriptMsgData javaScriptMsgData = (JavaScriptMsgData) zzr(this.zzc);
        if (adsRequest == null) {
            this.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsRequest cannot be null.")));
            return;
        }
        BaseDisplayContainer baseDisplayContainer = this.zzl;
        if (!(baseDisplayContainer instanceof AdDisplayContainer)) {
            this.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsLoader must be constructed with AdDisplayContainer.")));
        } else if (baseDisplayContainer.getAdContainer() == null) {
            this.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad display container must have a UI container.")));
        } else if (!zzro.zzc(adsRequest.getAdTagUrl()) || !zzro.zzc(adsRequest.getAdsResponse())) {
            AdDisplayContainer adDisplayContainer = (AdDisplayContainer) this.zzl;
            if (adDisplayContainer.getPlayer() == null) {
                this.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.ADS_PLAYER_NOT_PROVIDED, "VideoAdPlayer must be set on AdDisplayContainer before requesting ads."), new Object()));
                return;
            }
            this.zzh.put(zzv, adsRequest);
            this.zzd.zzf(this.zze, zzv);
            this.zzd.zze(adDisplayContainer, zzv);
            zzvq zza2 = this.zzp.zza(new zzdq(new zzgx(this.zzb, new zzgu(javaScriptMsgData), this.zzq), adsRequest));
            zzvq zza3 = this.zzp.zza(new zzdr(this, javaScriptMsgData));
            zzvr zzvr = this.zzp;
            zzhu zzhu = this.zzn;
            zzhu.getClass();
            zzvq zza4 = zzvr.zza(new zzds(zzhu));
            zzvq zza5 = zzqx.zza(this.zzm.zza());
            this.zzq.zzc(zzvd.zza(zza2, zza3, zza4, zza5).zza(new zzdt(this, adsRequest, zza4, adDisplayContainer, zza2, zza3, zza5, zzv), this.zzp), this.zzp, zzbe.ADS_LOADER, zzbf.REQUEST_ADS);
        } else {
            this.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad tag url must non-null and non empty.")));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(StreamRequest streamRequest) {
        String zzv = zzv();
        JavaScriptMsgData javaScriptMsgData = (JavaScriptMsgData) zzr(this.zzc);
        if (streamRequest == null) {
            this.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "StreamRequest cannot be null.")));
            return;
        }
        BaseDisplayContainer baseDisplayContainer = this.zzl;
        if (!(baseDisplayContainer instanceof StreamDisplayContainer)) {
            this.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsLoader must be constructed with StreamDisplayContainer.")));
        } else if (((StreamDisplayContainer) baseDisplayContainer).getVideoStreamPlayer() == null) {
            this.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Stream requests must specify a player.")));
        } else {
            this.zzi.put(zzv, streamRequest);
            this.zzd.zzf(this.zze, zzv);
            this.zzd.zze(this.zzl, zzv);
            zzvq zza2 = this.zzp.zza(new zzdw(new zzgx(this.zzb, new zzgu(javaScriptMsgData), this.zzq), streamRequest));
            zzvr zzvr = this.zzp;
            zzhu zzhu = this.zzn;
            zzhu.getClass();
            zzvq zza3 = zzvr.zza(new zzds(zzhu));
            zzvq zza4 = this.zzp.zza(new zzdx(this, javaScriptMsgData));
            zzvq zza5 = zzqx.zza(this.zzm.zza());
            this.zzq.zzc(zzvd.zza(zza2, zza3, zza4, zza5).zza(new zzdy(this, streamRequest, zza3, zza2, zza4, zza5, zzv), this.zzp), this.zzp, zzbe.ADS_LOADER, zzbf.REQUEST_STREAM);
        }
    }

    public final void zzq() {
        this.zzd.zzc().addOnCompleteListener((Executor) this.zzp, new zzdz(this));
    }
}
