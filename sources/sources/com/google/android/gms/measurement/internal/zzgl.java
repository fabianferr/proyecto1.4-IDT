package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzoz;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzgl implements Callable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgq zzc;

    zzgl(zzgq zzgq, zzaw zzaw, String str) {
        this.zzc = zzgq;
        this.zza = zzaw;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzle zzle;
        zzfz zzfz;
        zzgb zzgb;
        Bundle bundle;
        String str;
        zzh zzh;
        long j;
        String str2;
        zzas zzas;
        byte[] bArr;
        zzkz zzkz;
        this.zzc.zza.zzA();
        zzii zzr = this.zzc.zza.zzr();
        zzaw zzaw = this.zza;
        String str3 = this.zzb;
        zzr.zzg();
        zzfy.zzO();
        Preconditions.checkNotNull(zzaw);
        Preconditions.checkNotEmpty(str3);
        if (!zzr.zzs.zzf().zzs(str3, zzeb.zzS)) {
            zzr.zzs.zzay().zzc().zzb("Generating ScionPayload disabled. packageName", str3);
            return new byte[0];
        } else if ("_iap".equals(zzaw.zza) || "_iapx".equals(zzaw.zza)) {
            zzfz zza2 = zzga.zza();
            zzr.zzf.zzi().zzw();
            zzh zzj = zzr.zzf.zzi().zzj(str3);
            if (zzj == null) {
                zzr.zzs.zzay().zzc().zzb("Log and bundle not available. package_name", str3);
                bArr = new byte[0];
                zzkz = zzr.zzf;
            } else if (!zzj.zzai()) {
                zzr.zzs.zzay().zzc().zzb("Log and bundle disabled. package_name", str3);
                bArr = new byte[0];
                zzkz = zzr.zzf;
            } else {
                zzgb zzt = zzgc.zzt();
                zzt.zzad(1);
                zzt.zzZ("android");
                if (!TextUtils.isEmpty(zzj.zzt())) {
                    zzt.zzD(zzj.zzt());
                }
                if (!TextUtils.isEmpty(zzj.zzv())) {
                    zzt.zzF((String) Preconditions.checkNotNull(zzj.zzv()));
                }
                if (!TextUtils.isEmpty(zzj.zzw())) {
                    zzt.zzG((String) Preconditions.checkNotNull(zzj.zzw()));
                }
                if (zzj.zzb() != -2147483648L) {
                    zzt.zzH((int) zzj.zzb());
                }
                zzt.zzV(zzj.zzm());
                zzt.zzP(zzj.zzk());
                String zzy = zzj.zzy();
                String zzr2 = zzj.zzr();
                if (!TextUtils.isEmpty(zzy)) {
                    zzt.zzU(zzy);
                } else if (!TextUtils.isEmpty(zzr2)) {
                    zzt.zzC(zzr2);
                }
                zzai zzh2 = zzr.zzf.zzh(str3);
                zzt.zzM(zzj.zzj());
                if (zzr.zzs.zzJ() && zzr.zzs.zzf().zzt(zzt.zzap()) && zzh2.zzi(zzah.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    zzt.zzO((String) null);
                }
                zzt.zzL(zzh2.zzh());
                if (zzh2.zzi(zzah.AD_STORAGE) && zzj.zzah()) {
                    Pair zzd = zzr.zzf.zzs().zzd(zzj.zzt(), zzh2);
                    if (zzj.zzah() && !TextUtils.isEmpty((CharSequence) zzd.first)) {
                        try {
                            zzt.zzae(zzii.zza((String) zzd.first, Long.toString(zzaw.zzd)));
                            if (zzd.second != null) {
                                zzt.zzX(((Boolean) zzd.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzr.zzs.zzay().zzc().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzkz = zzr.zzf;
                        } catch (Throwable th) {
                            zzr.zzf.zzi().zzx();
                            throw th;
                        }
                    }
                }
                zzr.zzs.zzg().zzu();
                zzt.zzN(Build.MODEL);
                zzr.zzs.zzg().zzu();
                zzt.zzY(Build.VERSION.RELEASE);
                zzt.zzaj((int) zzr.zzs.zzg().zzb());
                zzt.zzan(zzr.zzs.zzg().zzc());
                try {
                    if (zzh2.zzi(zzah.ANALYTICS_STORAGE) && zzj.zzu() != null) {
                        zzt.zzE(zzii.zza((String) Preconditions.checkNotNull(zzj.zzu()), Long.toString(zzaw.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzj.zzx())) {
                        zzt.zzT((String) Preconditions.checkNotNull(zzj.zzx()));
                    }
                    String zzt2 = zzj.zzt();
                    List zzu = zzr.zzf.zzi().zzu(zzt2);
                    Iterator it = zzu.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzle = null;
                            break;
                        }
                        zzle = (zzle) it.next();
                        if ("_lte".equals(zzle.zzc)) {
                            break;
                        }
                    }
                    if (zzle == null || zzle.zze == null) {
                        zzle zzle2 = new zzle(zzt2, "auto", "_lte", zzr.zzs.zzav().currentTimeMillis(), 0L);
                        zzu.add(zzle2);
                        zzr.zzf.zzi().zzL(zzle2);
                    }
                    zzlb zzu2 = zzr.zzf.zzu();
                    zzu2.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzu2.zzs.zzg().zze()) {
                        String zzt3 = zzj.zzt();
                        Preconditions.checkNotNull(zzt3);
                        if (zzj.zzah() && zzu2.zzf.zzo().zzn(zzt3)) {
                            zzu2.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                            Iterator it2 = zzu.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(((zzle) it2.next()).zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            zzu.add(new zzle(zzt3, "auto", "_npa", zzu2.zzs.zzav().currentTimeMillis(), 1L));
                        }
                    }
                    com.google.android.gms.internal.measurement.zzgl[] zzglArr = new com.google.android.gms.internal.measurement.zzgl[zzu.size()];
                    for (int i = 0; i < zzu.size(); i++) {
                        zzgk zzd2 = com.google.android.gms.internal.measurement.zzgl.zzd();
                        zzd2.zzf(((zzle) zzu.get(i)).zzc);
                        zzd2.zzg(((zzle) zzu.get(i)).zzd);
                        zzr.zzf.zzu().zzu(zzd2, ((zzle) zzu.get(i)).zze);
                        zzglArr[i] = (com.google.android.gms.internal.measurement.zzgl) zzd2.zzaE();
                    }
                    zzt.zzj(Arrays.asList(zzglArr));
                    zzep zzb2 = zzep.zzb(zzaw);
                    zzr.zzs.zzv().zzL(zzb2.zzd, zzr.zzf.zzi().zzi(str3));
                    zzr.zzs.zzv().zzM(zzb2, zzr.zzs.zzf().zzd(str3));
                    Bundle bundle2 = zzb2.zzd;
                    bundle2.putLong("_c", 1);
                    zzr.zzs.zzay().zzc().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    bundle2.putString("_o", zzaw.zzc);
                    if (zzr.zzs.zzv().zzae(zzt.zzap())) {
                        zzr.zzs.zzv().zzO(bundle2, "_dbg", 1L);
                        zzr.zzs.zzv().zzO(bundle2, "_r", 1L);
                    }
                    zzas zzn = zzr.zzf.zzi().zzn(str3, zzaw.zza);
                    if (zzn == null) {
                        zzgb = zzt;
                        zzh = zzj;
                        zzfz = zza2;
                        str = str3;
                        bundle = bundle2;
                        str2 = null;
                        zzas = new zzas(str3, zzaw.zza, 0, 0, 0, zzaw.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j = 0;
                    } else {
                        zzh = zzj;
                        zzfz = zza2;
                        str = str3;
                        bundle = bundle2;
                        zzgb = zzt;
                        str2 = null;
                        long j2 = zzn.zzf;
                        zzas = zzn.zzc(zzaw.zzd);
                        j = j2;
                    }
                    zzr.zzf.zzi().zzE(zzas);
                    zzar zzar = new zzar(zzr.zzs, zzaw.zzc, str, zzaw.zza, zzaw.zzd, j, bundle);
                    zzfr zze = zzfs.zze();
                    zze.zzm(zzar.zzd);
                    zze.zzi(zzar.zzb);
                    zze.zzl(zzar.zze);
                    zzat zzat = new zzat(zzar.zzf);
                    while (zzat.hasNext()) {
                        String zza3 = zzat.next();
                        zzfv zze2 = zzfw.zze();
                        zze2.zzj(zza3);
                        Object zzf = zzar.zzf.zzf(zza3);
                        if (zzf != null) {
                            zzr.zzf.zzu().zzt(zze2, zzf);
                            zze.zze(zze2);
                        }
                    }
                    zzgb zzgb2 = zzgb;
                    zzgb2.zzk(zze);
                    zzgd zza4 = zzgf.zza();
                    zzft zza5 = zzfu.zza();
                    zza5.zza(zzas.zzc);
                    zza5.zzb(zzaw.zza);
                    zza4.zza(zza5);
                    zzgb2.zzaa(zza4);
                    zzgb2.zzf(zzr.zzf.zzf().zza(zzh.zzt(), Collections.emptyList(), zzgb2.zzat(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                    if (zze.zzq()) {
                        zzgb2.zzai(zze.zzc());
                        zzgb2.zzQ(zze.zzc());
                    }
                    long zzn2 = zzh.zzn();
                    if (zzn2 != 0) {
                        zzgb2.zzab(zzn2);
                    }
                    long zzp = zzh.zzp();
                    if (zzp != 0) {
                        zzgb2.zzac(zzp);
                    } else if (zzn2 != 0) {
                        zzgb2.zzac(zzn2);
                    }
                    String zzB = zzh.zzB();
                    zzoz.zzc();
                    if (zzr.zzs.zzf().zzs(str2, zzeb.zzar) && zzB != null) {
                        zzgb2.zzah(zzB);
                    }
                    zzh.zzE();
                    zzgb2.zzI((int) zzh.zzo());
                    zzr.zzs.zzf().zzh();
                    zzgb2.zzal(73000);
                    zzgb2.zzak(zzr.zzs.zzav().currentTimeMillis());
                    Boolean bool = Boolean.TRUE;
                    zzgb2.zzag(true);
                    if (zzr.zzs.zzf().zzs(str2, zzeb.zzaz)) {
                        zzr.zzf.zzC(zzgb2.zzap(), zzgb2);
                    }
                    zzfz zzfz2 = zzfz;
                    zzfz2.zza(zzgb2);
                    zzh zzh3 = zzh;
                    zzh3.zzab(zzgb2.zzd());
                    zzh3.zzZ(zzgb2.zzc());
                    zzr.zzf.zzi().zzD(zzh3);
                    zzr.zzf.zzi().zzC();
                    zzr.zzf.zzi().zzx();
                    try {
                        return zzr.zzf.zzu().zzy(((zzga) zzfz2.zzaE()).zzbv());
                    } catch (IOException e2) {
                        zzr.zzs.zzay().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzeo.zzn(str), e2);
                        return str2;
                    }
                } catch (SecurityException e3) {
                    zzr.zzs.zzay().zzc().zzb("app instance id encryption failed", e3.getMessage());
                    byte[] bArr2 = new byte[0];
                    zzr.zzf.zzi().zzx();
                    return bArr2;
                }
            }
            zzkz.zzi().zzx();
            return bArr;
        } else {
            zzr.zzs.zzay().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str3, zzaw.zza);
            return null;
        }
    }
}
