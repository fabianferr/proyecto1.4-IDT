package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zznv;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzfy implements zzgt {
    private static volatile zzfy zzd;
    private zzef zzA;
    private boolean zzB = false;
    private Boolean zzC;
    private long zzD;
    private volatile Boolean zzE;
    private volatile boolean zzF;
    private int zzG;
    private final AtomicInteger zzH = new AtomicInteger(0);
    protected Boolean zza;
    protected Boolean zzb;
    final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzab zzj;
    private final zzag zzk;
    private final zzfd zzl;
    private final zzeo zzm;
    private final zzfv zzn;
    private final zzki zzo;
    private final zzlh zzp;
    private final zzej zzq;
    private final Clock zzr;
    private final zzis zzs;
    private final zzid zzt;
    private final zzd zzu;
    private final zzih zzv;
    private final String zzw;
    private zzeh zzx;
    private zzjs zzy;
    private zzaq zzz;

    zzfy(zzhb zzhb) {
        long j;
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zzhb);
        Context context = zzhb.zza;
        zzab zzab = new zzab(context);
        this.zzj = zzab;
        zzdy.zza = zzab;
        this.zze = context;
        this.zzf = zzhb.zzb;
        this.zzg = zzhb.zzc;
        this.zzh = zzhb.zzd;
        this.zzi = zzhb.zzh;
        this.zzE = zzhb.zze;
        this.zzw = zzhb.zzj;
        this.zzF = true;
        zzcl zzcl = zzhb.zzg;
        if (!(zzcl == null || (bundle = zzcl.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzcl.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        zzia.zze(context);
        Clock instance = DefaultClock.getInstance();
        this.zzr = instance;
        Long l = zzhb.zzi;
        if (l != null) {
            j = l.longValue();
        } else {
            j = instance.currentTimeMillis();
        }
        this.zzc = j;
        this.zzk = new zzag(this);
        zzfd zzfd = new zzfd(this);
        zzfd.zzv();
        this.zzl = zzfd;
        zzeo zzeo = new zzeo(this);
        zzeo.zzv();
        this.zzm = zzeo;
        zzlh zzlh = new zzlh(this);
        zzlh.zzv();
        this.zzp = zzlh;
        this.zzq = new zzej(new zzha(zzhb, this));
        this.zzu = new zzd(this);
        zzis zzis = new zzis(this);
        zzis.zzb();
        this.zzs = zzis;
        zzid zzid = new zzid(this);
        zzid.zzb();
        this.zzt = zzid;
        zzki zzki = new zzki(this);
        zzki.zzb();
        this.zzo = zzki;
        zzih zzih = new zzih(this);
        zzih.zzv();
        this.zzv = zzih;
        zzfv zzfv = new zzfv(this);
        zzfv.zzv();
        this.zzn = zzfv;
        zzcl zzcl2 = zzhb.zzg;
        z = (zzcl2 == null || zzcl2.zzb == 0) ? true : z;
        if (context.getApplicationContext() instanceof Application) {
            zzid zzq2 = zzq();
            if (zzq2.zzs.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzq2.zzs.zze.getApplicationContext();
                if (zzq2.zza == null) {
                    zzq2.zza = new zzic(zzq2, (zzib) null);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzq2.zza);
                    application.registerActivityLifecycleCallbacks(zzq2.zza);
                    zzq2.zzs.zzay().zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzay().zzk().zza("Application context is not an Application");
        }
        zzfv.zzp(new zzfx(this, zzhb));
    }

    static /* bridge */ /* synthetic */ void zzA(zzfy zzfy, zzhb zzhb) {
        zzfy.zzaz().zzg();
        zzfy.zzk.zzn();
        zzaq zzaq = new zzaq(zzfy);
        zzaq.zzv();
        zzfy.zzz = zzaq;
        zzef zzef = new zzef(zzfy, zzhb.zzf);
        zzef.zzb();
        zzfy.zzA = zzef;
        zzeh zzeh = new zzeh(zzfy);
        zzeh.zzb();
        zzfy.zzx = zzeh;
        zzjs zzjs = new zzjs(zzfy);
        zzjs.zzb();
        zzfy.zzy = zzjs;
        zzfy.zzp.zzw();
        zzfy.zzl.zzw();
        zzfy.zzA.zzc();
        zzem zzi2 = zzfy.zzay().zzi();
        zzfy.zzk.zzh();
        zzi2.zzb("App measurement initialized, version", 73000L);
        zzfy.zzay().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzl2 = zzef.zzl();
        if (TextUtils.isEmpty(zzfy.zzf)) {
            if (zzfy.zzv().zzae(zzl2)) {
                zzfy.zzay().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzfy.zzay().zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzl2)));
            }
        }
        zzfy.zzay().zzc().zza("Debug-level message logging enabled");
        if (zzfy.zzG != zzfy.zzH.get()) {
            zzfy.zzay().zzd().zzc("Not all components initialized", Integer.valueOf(zzfy.zzG), Integer.valueOf(zzfy.zzH.get()));
        }
        zzfy.zzB = true;
    }

    static final void zzO() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzP(zzgr zzgr) {
        if (zzgr == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzQ(zzf zzf2) {
        if (zzf2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzf2.zze()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzf2.getClass()))));
        }
    }

    private static final void zzR(zzgs zzgs) {
        if (zzgs == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgs.zzx()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzgs.getClass()))));
        }
    }

    public static zzfy zzp(Context context, zzcl zzcl, Long l) {
        Bundle bundle;
        if (zzcl != null && (zzcl.zze == null || zzcl.zzf == null)) {
            zzcl = new zzcl(zzcl.zza, zzcl.zzb, zzcl.zzc, zzcl.zzd, (String) null, (String) null, zzcl.zzg, (String) null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzfy.class) {
                if (zzd == null) {
                    zzd = new zzfy(new zzhb(context, zzcl, l));
                }
            }
        } else if (!(zzcl == null || (bundle = zzcl.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            Preconditions.checkNotNull(zzd);
            zzd.zzE = Boolean.valueOf(zzcl.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        this.zzH.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzC(String str, int i, Throwable th, byte[] bArr, Map map) {
        if (!(i == 200 || i == 204)) {
            if (i == 304) {
                i = 304;
            }
            zzay().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
        }
        if (th == null) {
            zzm().zzm.zza(true);
            if (bArr == null || bArr.length == 0) {
                zzay().zzc().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble(CampaignEx.JSON_KEY_TIMESTAMP, 0.0d);
                if (TextUtils.isEmpty(optString)) {
                    zzay().zzc().zza("Deferred Deep Link is empty.");
                    return;
                }
                zzlh zzv2 = zzv();
                zzfy zzfy = zzv2.zzs;
                if (!TextUtils.isEmpty(optString)) {
                    List<ResolveInfo> queryIntentActivities = zzv2.zzs.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.zzt.zzG("auto", "_cmp", bundle);
                        zzlh zzv3 = zzv();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = zzv3.zzs.zze.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong(CampaignEx.JSON_KEY_TIMESTAMP, Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    zzv3.zzs.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e) {
                                zzv3.zzs.zzay().zzd().zzb("Failed to persist Deferred Deep Link. exception", e);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                zzay().zzk().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e2) {
                zzay().zzd().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzay().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
    }

    /* access modifiers changed from: package-private */
    public final void zzD() {
        this.zzG++;
    }

    public final void zzE() {
        zzaz().zzg();
        zzR(zzr());
        String zzl2 = zzh().zzl();
        Pair zzb2 = zzm().zzb(zzl2);
        if (!this.zzk.zzr() || ((Boolean) zzb2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb2.first)) {
            zzay().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        zzih zzr2 = zzr();
        zzr2.zzu();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzr2.zzs.zze.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            zzay().zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzlh zzv2 = zzv();
        zzh().zzs.zzk.zzh();
        URL zzE2 = zzv2.zzE(73000, zzl2, (String) zzb2.first, zzm().zzn.zza() - 1);
        if (zzE2 != null) {
            zzih zzr3 = zzr();
            zzfw zzfw = new zzfw(this);
            zzr3.zzg();
            zzr3.zzu();
            Preconditions.checkNotNull(zzE2);
            Preconditions.checkNotNull(zzfw);
            zzr3.zzs.zzaz().zzo(new zzig(zzr3, zzl2, zzE2, (byte[]) null, (Map) null, zzfw, (byte[]) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzF(boolean z) {
        this.zzE = Boolean.valueOf(z);
    }

    public final void zzG(boolean z) {
        zzaz().zzg();
        this.zzF = z;
    }

    /* access modifiers changed from: protected */
    public final void zzH(zzcl zzcl) {
        zzai zzai;
        zzaz().zzg();
        zzai zzc2 = zzm().zzc();
        zzfd zzm2 = zzm();
        zzfy zzfy = zzm2.zzs;
        zzm2.zzg();
        int i = 100;
        int i2 = zzm2.zza().getInt("consent_source", 100);
        zzag zzag = this.zzk;
        zzfy zzfy2 = zzag.zzs;
        Boolean zzk2 = zzag.zzk("google_analytics_default_allow_ad_storage");
        zzag zzag2 = this.zzk;
        zzfy zzfy3 = zzag2.zzs;
        Boolean zzk3 = zzag2.zzk("google_analytics_default_allow_analytics_storage");
        if (!(zzk2 == null && zzk3 == null) && zzm().zzl(-10)) {
            zzai = new zzai(zzk2, zzk3);
            i = -10;
        } else {
            if (!TextUtils.isEmpty(zzh().zzm()) && (i2 == 0 || i2 == 30 || i2 == 10 || i2 == 30 || i2 == 30 || i2 == 40)) {
                zzq().zzS(zzai.zza, -10, this.zzc);
            } else if (TextUtils.isEmpty(zzh().zzm()) && zzcl != null && zzcl.zzg != null && zzm().zzl(30)) {
                zzai = zzai.zza(zzcl.zzg);
                if (!zzai.equals(zzai.zza)) {
                    i = 30;
                }
            }
            zzai = null;
        }
        if (zzai != null) {
            zzq().zzS(zzai, i, this.zzc);
            zzc2 = zzai;
        }
        zzq().zzV(zzc2);
        if (zzm().zzc.zza() == 0) {
            zzay().zzj().zzb("Persisting first open", Long.valueOf(this.zzc));
            zzm().zzc.zzb(this.zzc);
        }
        zzq().zzb.zzc();
        if (zzM()) {
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                zzlh zzv2 = zzv();
                String zzm3 = zzh().zzm();
                zzfd zzm4 = zzm();
                zzm4.zzg();
                String string = zzm4.zza().getString("gmp_app_id", (String) null);
                String zzk4 = zzh().zzk();
                zzfd zzm5 = zzm();
                zzm5.zzg();
                if (zzv2.zzam(zzm3, string, zzk4, zzm5.zza().getString("admob_app_id", (String) null))) {
                    zzay().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzfd zzm6 = zzm();
                    zzm6.zzg();
                    Boolean zzd2 = zzm6.zzd();
                    SharedPreferences.Editor edit = zzm6.zza().edit();
                    edit.clear();
                    edit.apply();
                    if (zzd2 != null) {
                        zzm6.zzh(zzd2);
                    }
                    zzi().zzj();
                    this.zzy.zzs();
                    this.zzy.zzr();
                    zzm().zzc.zzb(this.zzc);
                    zzm().zze.zzb((String) null);
                }
                zzfd zzm7 = zzm();
                String zzm8 = zzh().zzm();
                zzm7.zzg();
                SharedPreferences.Editor edit2 = zzm7.zza().edit();
                edit2.putString("gmp_app_id", zzm8);
                edit2.apply();
                zzfd zzm9 = zzm();
                String zzk5 = zzh().zzk();
                zzm9.zzg();
                SharedPreferences.Editor edit3 = zzm9.zza().edit();
                edit3.putString("admob_app_id", zzk5);
                edit3.apply();
            }
            if (!zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                zzm().zze.zzb((String) null);
            }
            zzq().zzO(zzm().zze.zza());
            zznv.zzc();
            if (this.zzk.zzs((String) null, zzeb.zzac)) {
                try {
                    zzv().zzs.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(zzm().zzo.zza())) {
                        zzay().zzk().zza("Remote config removed with active feature rollouts");
                        zzm().zzo.zzb((String) null);
                    }
                }
            }
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                boolean zzJ = zzJ();
                if (!zzm().zzj() && !this.zzk.zzv()) {
                    zzm().zzi(!zzJ);
                }
                if (zzJ) {
                    zzq().zzz();
                }
                zzu().zza.zza();
                zzt().zzu(new AtomicReference());
                zzt().zzH(zzm().zzr.zza());
            }
        } else if (zzJ()) {
            if (!zzv().zzad("android.permission.INTERNET")) {
                zzay().zzd().zza("App is missing INTERNET permission");
            }
            if (!zzv().zzad("android.permission.ACCESS_NETWORK_STATE")) {
                zzay().zzd().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzx()) {
                if (!zzlh.zzaj(this.zze)) {
                    zzay().zzd().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzlh.zzak(this.zze, false)) {
                    zzay().zzd().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzay().zzd().zza("Uploading is not possible. App measurement disabled");
        }
        zzm().zzi.zza(true);
    }

    public final boolean zzI() {
        return this.zzE != null && this.zzE.booleanValue();
    }

    public final boolean zzJ() {
        return zza() == 0;
    }

    public final boolean zzK() {
        zzaz().zzg();
        return this.zzF;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzf);
    }

    /* access modifiers changed from: protected */
    public final boolean zzM() {
        if (this.zzB) {
            zzaz().zzg();
            Boolean bool = this.zzC;
            if (bool == null || this.zzD == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzD) > 1000)) {
                this.zzD = this.zzr.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzv().zzad("android.permission.INTERNET") && zzv().zzad("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzx() || (zzlh.zzaj(this.zze) && zzlh.zzak(this.zze, false))));
                this.zzC = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzv().zzX(zzh().zzm(), zzh().zzk()) && TextUtils.isEmpty(zzh().zzk())) {
                        z = false;
                    }
                    this.zzC = Boolean.valueOf(z);
                }
            }
            return this.zzC.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean zzN() {
        return this.zzi;
    }

    public final int zza() {
        zzaz().zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzaz().zzg();
        if (!this.zzF) {
            return 8;
        }
        Boolean zzd2 = zzm().zzd();
        if (zzd2 == null) {
            zzag zzag = this.zzk;
            zzab zzab = zzag.zzs.zzj;
            Boolean zzk2 = zzag.zzk("firebase_analytics_collection_enabled");
            if (zzk2 == null) {
                Boolean bool2 = this.zza;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (this.zzE == null || this.zzE.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (zzk2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzd2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @Pure
    public final Context zzau() {
        return this.zze;
    }

    @Pure
    public final Clock zzav() {
        return this.zzr;
    }

    @Pure
    public final zzab zzaw() {
        return this.zzj;
    }

    @Pure
    public final zzeo zzay() {
        zzR(this.zzm);
        return this.zzm;
    }

    @Pure
    public final zzfv zzaz() {
        zzR(this.zzn);
        return this.zzn;
    }

    @Pure
    public final zzd zzd() {
        zzd zzd2 = this.zzu;
        if (zzd2 != null) {
            return zzd2;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzag zzf() {
        return this.zzk;
    }

    @Pure
    public final zzaq zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzef zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzeh zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzej zzj() {
        return this.zzq;
    }

    public final zzeo zzl() {
        zzeo zzeo = this.zzm;
        if (zzeo == null || !zzeo.zzx()) {
            return null;
        }
        return zzeo;
    }

    @Pure
    public final zzfd zzm() {
        zzP(this.zzl);
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    @SideEffectFree
    public final zzfv zzo() {
        return this.zzn;
    }

    @Pure
    public final zzid zzq() {
        zzQ(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzih zzr() {
        zzR(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzis zzs() {
        zzQ(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzjs zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzki zzu() {
        zzQ(this.zzo);
        return this.zzo;
    }

    @Pure
    public final zzlh zzv() {
        zzP(this.zzp);
        return this.zzp;
    }

    @Pure
    public final String zzw() {
        return this.zzf;
    }

    @Pure
    public final String zzx() {
        return this.zzg;
    }

    @Pure
    public final String zzy() {
        return this.zzh;
    }

    @Pure
    public final String zzz() {
        return this.zzw;
    }
}
