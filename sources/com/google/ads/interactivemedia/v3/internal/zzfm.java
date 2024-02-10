package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.webkit.WebViewFeature;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.impl.data.AdImpl;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import com.google.ads.interactivemedia.v3.impl.data.CuePointData;
import com.google.ads.interactivemedia.v3.impl.data.JavaScriptMsgData;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.impl.data.zzbc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzfm implements zzfq, zzfr {
    private final Map zza = new HashMap();
    private final Set zzb = new HashSet();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final Map zze = new HashMap();
    private final Map zzf = new HashMap();
    private final Context zzg;
    private final String zzh;
    private final zzft zzi;
    private final Queue zzj = new ConcurrentLinkedQueue();
    private final float zzk;
    private final ExecutorService zzl;
    private final TestingConfiguration zzm;
    private final TaskCompletionSource zzn;
    private final TaskCompletionSource zzo;
    private zzgc zzp;
    private zzfl zzq;
    private long zzr;
    private boolean zzs;

    public zzfm(zzft zzft, Context context, Uri uri, ImaSdkSettings imaSdkSettings, ExecutorService executorService) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzn = taskCompletionSource;
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        this.zzo = taskCompletionSource2;
        this.zzs = false;
        this.zzg = context;
        this.zzk = context.getResources().getDisplayMetrics().density;
        boolean isFeatureSupported = WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER");
        Uri.Builder appendQueryParameter = uri.buildUpon().appendQueryParameter("sdk_version", "a.3.30.3").appendQueryParameter("hl", imaSdkSettings.getLanguage()).appendQueryParameter("omv", "1.3.37-google_20220829").appendQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_APP, context.getApplicationContext().getPackageName());
        appendQueryParameter.appendQueryParameter("mt", true != isFeatureSupported ? "0" : "4");
        if (imaSdkSettings.getTestingConfig() != null) {
            zzwn zzwn = new zzwn();
            zzwn.zzc(new zzra());
            zzwn.zzd(new zzqz());
            appendQueryParameter.appendQueryParameter("tcnfp", zzwn.zza().zzf(imaSdkSettings.getTestingConfig()));
        }
        this.zzh = appendQueryParameter.build().toString();
        this.zzm = imaSdkSettings.getTestingConfig();
        this.zzi = zzft;
        zzft.zzg(this);
        this.zzl = executorService;
        Tasks.whenAllComplete((Task<?>[]) new Task[]{taskCompletionSource2.getTask(), taskCompletionSource.getTask()}).addOnCompleteListener(new zzfg(this));
    }

    private static String zzq(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return str + " Caused by: " + str2;
    }

    private final void zzr(zzfd zzfd, zzfe zzfe, String str, JavaScriptMsgData javaScriptMsgData) {
        zzgn zzgn = (zzgn) this.zzf.get(str);
        if (zzgn == null) {
            String valueOf = String.valueOf(zzfd);
            String valueOf2 = String.valueOf(zzfe);
            zzhd.zzd("Received " + valueOf + " message: " + valueOf2 + " for invalid session id: " + str);
            return;
        }
        zzgn.zzf(zzfd, zzfe, javaScriptMsgData);
    }

    private static final void zzs(String str, zzfe zzfe) {
        String valueOf = String.valueOf(zzfe);
        zzhd.zzc("Illegal message type " + valueOf + " received for " + str + " channel");
    }

    public final WebView zza() {
        return this.zzi.zza();
    }

    /* access modifiers changed from: package-private */
    public final TestingConfiguration zzb() {
        return this.zzm;
    }

    /* access modifiers changed from: package-private */
    public final Task zzc() {
        this.zzr = SystemClock.elapsedRealtime();
        this.zzi.zze(this.zzh);
        return this.zzo.getTask();
    }

    public final void zzd(zzfh zzfh, String str) {
        this.zza.put(str, zzfh);
    }

    public final void zze(BaseDisplayContainer baseDisplayContainer, String str) {
        this.zzc.put(str, baseDisplayContainer);
    }

    public final void zzf(zzfi zzfi, String str) {
        this.zzd.put(str, zzfi);
    }

    public final void zzg(zzfk zzfk, String str) {
        this.zze.put(str, zzfk);
    }

    public final void zzh(zzfl zzfl) {
        this.zzq = zzfl;
    }

    public final void zzi(zzgn zzgn, String str) {
        this.zzf.put(str, zzgn);
    }

    /* access modifiers changed from: package-private */
    public final void zzj(zzbc zzbc) {
        this.zzn.trySetResult(zzbc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Task task) {
        zzga zzga;
        zzbc zzbc = (zzbc) this.zzn.getTask().getResult();
        Context context = this.zzg;
        boolean z = ((JavaScriptMsgData) this.zzo.getTask().getResult()).enableGks;
        ExecutorService executorService = this.zzl;
        if (z) {
            zzga = new zzgb(context, zzbc);
        } else {
            zzga = new zzfz((zzfy) null);
        }
        this.zzp = new zzgc(context, this, executorService, zzga);
    }

    public final void zzl(zzff zzff) {
        AdImpl adImpl;
        Map<String, CompanionData> map;
        String str;
        String str2;
        JavaScriptMsgData javaScriptMsgData = (JavaScriptMsgData) zzff.zze();
        String zzf2 = zzff.zzf();
        zzfe zzb2 = zzff.zzb();
        zzhd.zzc("Received js message: " + zzff.zza().name() + " [" + zzb2.name() + "]");
        switch (zzff.zza().ordinal()) {
            case 0:
                if (!this.zzb.contains(zzf2)) {
                    zzfh zzfh = (zzfh) this.zza.get(zzf2);
                    if (zzfh == null) {
                        zzhd.zzd("Received monitor message: " + String.valueOf(zzb2) + " for invalid session id: " + zzf2);
                        return;
                    } else if (javaScriptMsgData == null) {
                        zzhd.zzd("Received monitor message: " + String.valueOf(zzb2) + " for session id: " + zzf2 + " with no data");
                        return;
                    } else if (zzb2.ordinal() != 37) {
                        zzs(zzfd.activityMonitor.toString(), zzb2);
                        return;
                    } else {
                        zzfh.zzh(javaScriptMsgData.queryId, javaScriptMsgData.eventId);
                        return;
                    }
                } else {
                    return;
                }
            case 1:
                zzfi zzfi = (zzfi) this.zzd.get(zzf2);
                if (zzfi == null) {
                    zzhd.zza("Received request message: " + String.valueOf(zzb2) + " for invalid session id: " + zzf2);
                    return;
                }
                int ordinal = zzb2.ordinal();
                if (ordinal != 11) {
                    if (ordinal == 31) {
                        zzfi.zza(zzf2, AdError.AdErrorType.LOAD, javaScriptMsgData.errorCode, zzq(javaScriptMsgData.errorMessage, javaScriptMsgData.innerError));
                        return;
                    } else if (ordinal != 68) {
                        zzs(zzfd.adsLoader.toString(), zzb2);
                        return;
                    } else {
                        zzfi.zzd(zzf2, javaScriptMsgData.streamId, javaScriptMsgData.monitorAppLifecycle);
                        zzhd.zzc("Stream initialized with streamId: ".concat(String.valueOf(javaScriptMsgData.streamId)));
                        return;
                    }
                } else if (javaScriptMsgData == null) {
                    zzfi.zzb(zzf2, AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "adsLoaded message did not contain cue points.");
                    return;
                } else {
                    zzfi.zzc(zzf2, javaScriptMsgData.adCuePoints, javaScriptMsgData.internalCuePoints, javaScriptMsgData.monitorAppLifecycle);
                    return;
                }
            case 2:
                zzfk zzfk = (zzfk) this.zze.get(zzf2);
                if (zzfk == null) {
                    zzhd.zzd("Received manager message: " + String.valueOf(zzb2) + " for invalid session id: " + zzf2);
                    return;
                }
                if (javaScriptMsgData == null || (adImpl = javaScriptMsgData.adData) == null) {
                    adImpl = null;
                }
                int ordinal2 = zzb2.ordinal();
                if (ordinal2 == 12) {
                    zzfk.zzb(new zzfj(AdEvent.AdEventType.ALL_ADS_COMPLETED, (AdImpl) null));
                    return;
                } else if (ordinal2 == 16) {
                    zzfk.zzb(new zzfj(AdEvent.AdEventType.CLICKED, adImpl));
                    return;
                } else if (ordinal2 == 18) {
                    zzfk.zzb(new zzfj(AdEvent.AdEventType.COMPLETED, adImpl));
                    return;
                } else if (ordinal2 == 25) {
                    zzfj zzfj = new zzfj(AdEvent.AdEventType.CUEPOINTS_CHANGED, (AdImpl) null);
                    zzfj.zzd = new ArrayList();
                    for (CuePointData next : javaScriptMsgData.cuepoints) {
                        zzfj.zzd.add(new zzew(next.start(), next.end(), next.played()));
                    }
                    zzfk.zzb(zzfj);
                    return;
                } else if (ordinal2 != 44) {
                    if (ordinal2 == 52) {
                        zzfk.zzb(new zzfj(AdEvent.AdEventType.PAUSED, adImpl));
                        return;
                    } else if (ordinal2 == 61) {
                        zzfk.zzb(new zzfj(AdEvent.AdEventType.RESUMED, adImpl));
                        return;
                    } else if (ordinal2 == 69) {
                        zzfk.zzb(new zzfj(AdEvent.AdEventType.THIRD_QUARTILE, adImpl));
                        return;
                    } else if (ordinal2 == 77) {
                        return;
                    } else {
                        if (ordinal2 == 20) {
                            zzfk.zzb(new zzfj(AdEvent.AdEventType.CONTENT_PAUSE_REQUESTED, (AdImpl) null));
                            return;
                        } else if (ordinal2 == 21) {
                            zzfk.zzb(new zzfj(AdEvent.AdEventType.CONTENT_RESUME_REQUESTED, (AdImpl) null));
                            return;
                        } else if (ordinal2 == 31) {
                            zzfk.zzd(AdError.AdErrorType.PLAY, javaScriptMsgData.errorCode, zzq(javaScriptMsgData.errorMessage, javaScriptMsgData.innerError));
                            return;
                        } else if (ordinal2 == 32) {
                            zzfk.zzb(new zzfj(AdEvent.AdEventType.FIRST_QUARTILE, adImpl));
                            return;
                        } else if (ordinal2 == 39) {
                            zzfk.zzb(new zzfj(AdEvent.AdEventType.ICON_FALLBACK_IMAGE_CLOSED, (AdImpl) null));
                            return;
                        } else if (ordinal2 != 40) {
                            switch (ordinal2) {
                                case 1:
                                    zzfk.zzb(new zzfj(AdEvent.AdEventType.AD_BREAK_ENDED, adImpl));
                                    return;
                                case 2:
                                    zzfj zzfj2 = new zzfj(AdEvent.AdEventType.AD_BREAK_FETCH_ERROR, (AdImpl) null);
                                    zzfj2.zzc = zzsr.zzd("adBreakTime", javaScriptMsgData.adBreakTime);
                                    zzfk.zzb(zzfj2);
                                    return;
                                case 3:
                                    zzfj zzfj3 = new zzfj(AdEvent.AdEventType.AD_BREAK_READY, (AdImpl) null);
                                    zzfj3.zzc = zzsr.zzd("adBreakTime", javaScriptMsgData.adBreakTime);
                                    zzfk.zzb(zzfj3);
                                    return;
                                case 4:
                                    zzfk.zzb(new zzfj(AdEvent.AdEventType.AD_BREAK_STARTED, adImpl));
                                    return;
                                case 5:
                                    zzfk.zzb(new zzfj(AdEvent.AdEventType.AD_BUFFERING, (AdImpl) null));
                                    return;
                                case 6:
                                case 7:
                                    return;
                                case 8:
                                    zzfk.zzb(new zzfj(AdEvent.AdEventType.AD_PERIOD_ENDED, (AdImpl) null));
                                    return;
                                case 9:
                                    zzfk.zzb(new zzfj(AdEvent.AdEventType.AD_PERIOD_STARTED, (AdImpl) null));
                                    return;
                                case 10:
                                    zzfj zzfj4 = new zzfj(AdEvent.AdEventType.AD_PROGRESS, adImpl);
                                    zzfj4.zze = new zzdp(javaScriptMsgData.currentTime, javaScriptMsgData.duration, javaScriptMsgData.adPosition, javaScriptMsgData.totalAds, javaScriptMsgData.adBreakDuration, javaScriptMsgData.adPeriodDuration);
                                    zzfk.zzb(zzfj4);
                                    return;
                                default:
                                    switch (ordinal2) {
                                        case 46:
                                            zzfj zzfj5 = new zzfj(AdEvent.AdEventType.LOG, adImpl);
                                            zzfj5.zzc = javaScriptMsgData.logData.constructMap();
                                            zzfk.zzb(zzfj5);
                                            return;
                                        case 47:
                                            zzfk.zzb(new zzfj(AdEvent.AdEventType.MIDPOINT, adImpl));
                                            return;
                                        case 48:
                                            return;
                                        case 49:
                                            zzfk.zzh(javaScriptMsgData.url);
                                            return;
                                        default:
                                            switch (ordinal2) {
                                                case 63:
                                                    zzfj zzfj6 = new zzfj(AdEvent.AdEventType.SKIPPED, (AdImpl) null);
                                                    zzfj6.zzg = javaScriptMsgData.seekTime;
                                                    zzfk.zzb(zzfj6);
                                                    return;
                                                case 64:
                                                    zzfk.zzb(new zzfj(AdEvent.AdEventType.SKIPPABLE_STATE_CHANGED, adImpl));
                                                    return;
                                                case 65:
                                                    zzfk.zzb(new zzfj(AdEvent.AdEventType.STARTED, adImpl));
                                                    return;
                                                default:
                                                    switch (ordinal2) {
                                                        case 73:
                                                            return;
                                                        case 74:
                                                            zzfk.zzb(new zzfj(AdEvent.AdEventType.TAPPED, adImpl));
                                                            return;
                                                        case 75:
                                                            zzfj zzfj7 = new zzfj(AdEvent.AdEventType.ICON_TAPPED, (AdImpl) null);
                                                            if (javaScriptMsgData != null) {
                                                                zzfj7.zzf = javaScriptMsgData.iconClickFallbackImages;
                                                            }
                                                            zzfk.zzb(zzfj7);
                                                            return;
                                                        default:
                                                            zzs(zzfd.adsManager.toString(), zzb2);
                                                            return;
                                                    }
                                            }
                                    }
                            }
                        } else {
                            return;
                        }
                    }
                } else if (adImpl != null) {
                    zzfk.zzb(new zzfj(AdEvent.AdEventType.LOADED, adImpl));
                    return;
                } else {
                    zzhd.zza("Ad loaded message requires adData");
                    zzfk.zze(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Ad loaded message did not contain adData.");
                    return;
                }
            case 4:
                zzeo zzeo = (zzeo) this.zzc.get(zzf2);
                zzfk zzfk2 = (zzfk) this.zze.get(zzf2);
                zzgn zzgn = (zzgn) this.zzf.get(zzf2);
                if (zzeo == null || zzfk2 == null || zzgn == null) {
                    zzhd.zza("Received displayContainer message: " + String.valueOf(zzb2) + " for invalid session id: " + zzf2);
                    return;
                }
                int ordinal3 = zzb2.ordinal();
                if (ordinal3 != 28) {
                    if (ordinal3 != 38 && ordinal3 != 62) {
                        if (ordinal3 == 59) {
                            zzfk2.zzj(javaScriptMsgData.resizeAndPositionVideo);
                            return;
                        } else if (ordinal3 != 60) {
                            zzs(zzfd.displayContainer.toString(), zzb2);
                            return;
                        } else {
                            zzfk2.zzk();
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (javaScriptMsgData == null || (map = javaScriptMsgData.companions) == null) {
                    zzfk2.zze(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Display companions message requires companions in data.");
                    return;
                } else {
                    Set<String> keySet = map.keySet();
                    HashMap zzb3 = zztd.zzb(keySet.size());
                    for (String next2 : keySet) {
                        CompanionAdSlot companionAdSlot = (CompanionAdSlot) zzeo.zza().get(next2);
                        ViewGroup container = companionAdSlot != null ? companionAdSlot.getContainer() : null;
                        if (container != null) {
                            zzb3.put(next2, container);
                        } else {
                            zzfk2.zze(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Display requested for invalid companion slot.");
                        }
                    }
                    for (String str3 : zzb3.keySet()) {
                        zzfk2.zzi((ViewGroup) zzb3.get(str3), javaScriptMsgData.companions.get(str3), zzf2, (CompanionAdSlot) zzeo.zza().get(str3), this, new zzha(this.zzl, this.zzk));
                    }
                    return;
                }
            case 5:
            case 11:
                int ordinal4 = zzb2.ordinal();
                if (ordinal4 == 42) {
                    this.zzo.trySetResult(javaScriptMsgData);
                    this.zzs = true;
                    HashMap zzb4 = zztd.zzb(1);
                    zzb4.put("webViewLoadingTime", Long.valueOf(SystemClock.elapsedRealtime() - this.zzr));
                    zzp(new zzff(zzfd.webViewLoaded, zzfe.csi, zzf2, zzb4));
                    return;
                } else if (ordinal4 != 46) {
                    zzs("other", zzb2);
                    return;
                } else if (javaScriptMsgData.ln == null || (str = javaScriptMsgData.n) == null || (str2 = javaScriptMsgData.m) == null) {
                    zzhd.zza("Invalid logging message data: ".concat(String.valueOf(String.valueOf(javaScriptMsgData))));
                    return;
                } else {
                    String str4 = "JsMessage (" + str + "): " + str2;
                    char charAt = javaScriptMsgData.ln.charAt(0);
                    if (charAt != 'D') {
                        if (charAt != 'E') {
                            if (charAt != 'I') {
                                if (charAt != 'S') {
                                    if (charAt != 'V') {
                                        if (charAt != 'W') {
                                            zzhd.zzd("Unrecognized log level: ".concat(String.valueOf(javaScriptMsgData.ln)));
                                            zzhd.zzd(str4);
                                            return;
                                        }
                                        zzhd.zzd(str4);
                                        return;
                                    }
                                }
                            }
                        }
                        zzhd.zza(str4);
                        return;
                    }
                    zzhd.zzc(str4);
                    return;
                }
            case 6:
                zzgc zzgc = this.zzp;
                if (zzgc != null) {
                    zzgc.zzc(zzb2, zzf2, javaScriptMsgData.networkRequest);
                    return;
                } else {
                    zzhd.zza("Native network handler not initialized.");
                    return;
                }
            case 7:
                if (this.zzq == null) {
                    zzhd.zza("Null 'omidManagerListener': cannot send 'onOmidMessage'.");
                    return;
                }
                int ordinal5 = zzb2.ordinal();
                if (ordinal5 == 50) {
                    this.zzq.zza();
                    return;
                } else if (ordinal5 == 51) {
                    this.zzq.zzb();
                    return;
                } else {
                    return;
                }
            case 9:
                zzr(zzfd.videoDisplay1, zzb2, zzf2, javaScriptMsgData);
                return;
            case 10:
                zzr(zzfd.videoDisplay2, zzb2, zzf2, javaScriptMsgData);
                return;
            default:
                zzhd.zza("Unknown message channel: ".concat(String.valueOf(String.valueOf(zzff.zza()))));
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzm() {
        this.zzi.zzb();
    }

    public final void zzn(String str) {
        this.zza.remove(str);
        this.zzb.add(str);
    }

    public final void zzo(String str) {
        this.zzd.remove(str);
        this.zze.remove(str);
        this.zzc.remove(str);
        this.zzf.remove(str);
    }

    public final void zzp(zzff zzff) {
        String name = zzff.zza().name();
        String name2 = zzff.zzb().name();
        zzhd.zzc("Sending js message: " + name + " [" + name2 + "]");
        this.zzj.add(zzff);
        if (this.zzs) {
            zzff zzff2 = (zzff) this.zzj.poll();
            while (zzff2 != null) {
                this.zzi.zzh(zzff2);
                zzff2 = (zzff) this.zzj.poll();
            }
        }
    }
}
