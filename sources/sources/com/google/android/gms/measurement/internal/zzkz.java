package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zzow;
import com.google.android.gms.internal.measurement.zzoz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzkz implements zzgt {
    private static volatile zzkz zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zzik zzD;
    private String zzE;
    private final zzlg zzF = new zzku(this);
    long zza;
    private final zzfp zzc;
    private final zzeu zzd;
    private zzam zze;
    private zzew zzf;
    private zzkl zzg;
    private zzaa zzh;
    private final zzlb zzi;
    private zzii zzj;
    private zzju zzk;
    private final zzko zzl;
    private zzfg zzm;
    /* access modifiers changed from: private */
    public final zzfy zzn;
    private boolean zzo = false;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;

    zzkz(zzla zzla, zzfy zzfy) {
        Preconditions.checkNotNull(zzla);
        this.zzn = zzfy.zzp(zzla.zza, (zzcl) null, (Long) null);
        this.zzA = -1;
        this.zzl = new zzko(this);
        zzlb zzlb = new zzlb(this);
        zzlb.zzX();
        this.zzi = zzlb;
        zzeu zzeu = new zzeu(this);
        zzeu.zzX();
        this.zzd = zzeu;
        zzfp zzfp = new zzfp(this);
        zzfp.zzX();
        this.zzc = zzfp;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaz().zzp(new zzkp(this, zzla));
    }

    static final void zzaa(zzfr zzfr, int i, String str) {
        List zzp2 = zzfr.zzp();
        int i2 = 0;
        while (i2 < zzp2.size()) {
            if (!"_err".equals(((zzfw) zzp2.get(i2)).zzg())) {
                i2++;
            } else {
                return;
            }
        }
        zzfv zze2 = zzfw.zze();
        zze2.zzj("_err");
        zze2.zzi(Long.valueOf((long) i).longValue());
        zzfv zze3 = zzfw.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfr.zzf((zzfw) zze2.zzaE());
        zzfr.zzf((zzfw) zze3.zzaE());
    }

    static final void zzab(zzfr zzfr, String str) {
        List zzp2 = zzfr.zzp();
        for (int i = 0; i < zzp2.size(); i++) {
            if (str.equals(((zzfw) zzp2.get(i)).zzg())) {
                zzfr.zzh(i);
                return;
            }
        }
    }

    private final zzq zzac(String str) {
        String str2 = str;
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null || zzad.booleanValue()) {
            String zzy2 = zzj2.zzy();
            String zzw2 = zzj2.zzw();
            long zzb2 = zzj2.zzb();
            String zzv2 = zzj2.zzv();
            long zzm2 = zzj2.zzm();
            long zzj3 = zzj2.zzj();
            boolean zzai = zzj2.zzai();
            String zzx2 = zzj2.zzx();
            zzj2.zza();
            zzh zzh2 = zzj2;
            return new zzq(str, zzy2, zzw2, zzb2, zzv2, zzm2, zzj3, (String) null, zzai, false, zzx2, 0, 0, 0, zzh2.zzah(), false, zzh2.zzr(), zzh2.zzq(), zzh2.zzk(), zzh2.zzC(), (String) null, zzh(str).zzh(), "", (String) null);
        }
        zzay().zzd().zzb("App version does not match; dropping. appId", zzeo.zzn(str));
        return null;
    }

    private final Boolean zzad(zzh zzh2) {
        try {
            if (zzh2.zzb() != -2147483648L) {
                if (zzh2.zzb() == ((long) Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzh2.zzt(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzh2.zzt(), 0).versionName;
                String zzw2 = zzh2.zzw();
                if (zzw2 != null && zzw2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzae() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    private final void zzaf(zzgb zzgb, long j, boolean z) {
        zzle zzle;
        zzgb zzgb2 = zzgb;
        boolean z2 = z;
        String str = true != z2 ? "_lte" : "_se";
        zzam zzam = this.zze;
        zzal(zzam);
        zzle zzp2 = zzam.zzp(zzgb.zzap(), str);
        if (zzp2 == null || zzp2.zze == null) {
            zzle = new zzle(zzgb.zzap(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzle = new zzle(zzgb.zzap(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzp2.zze).longValue() + j));
        }
        zzgk zzd2 = zzgl.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzav().currentTimeMillis());
        zzd2.zze(((Long) zzle.zze).longValue());
        zzgl zzgl = (zzgl) zzd2.zzaE();
        int zza2 = zzlb.zza(zzgb2, str);
        if (zza2 >= 0) {
            zzgb2.zzam(zza2, zzgl);
        } else {
            zzgb2.zzm(zzgl);
        }
        if (j > 0) {
            zzam zzam2 = this.zze;
            zzal(zzam2);
            zzam2.zzL(zzle);
            zzay().zzj().zzc("Updated engagement user property. scope, value", true != z2 ? "lifetime" : "session-scoped", zzle.zze);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzfv r1 = r20.zzaz()
            r1.zzg()
            r20.zzB()
            long r1 = r0.zza
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004e
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.elapsedRealtime()
            long r5 = r0.zza
            long r1 = r1 - r5
            long r1 = java.lang.Math.abs(r1)
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzeo r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzj()
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r1.zzb(r2, r3)
            com.google.android.gms.measurement.internal.zzew r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkl r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzfy r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r20.zzai()
            if (r1 != 0) goto L_0x005e
            goto L_0x0255
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzea r5 = com.google.android.gms.measurement.internal.zzeb.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzH()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzG()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzag r5 = r20.zzg()
            java.lang.String r5 = r5.zzl()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzg()
            com.google.android.gms.measurement.internal.zzea r5 = com.google.android.gms.measurement.internal.zzeb.zzu
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzea r5 = com.google.android.gms.measurement.internal.zzeb.zzt
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzea r5 = com.google.android.gms.measurement.internal.zzeb.zzs
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzju r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzju r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            r17 = r10
            long r9 = r5.zzd()
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            r18 = r7
            long r6 = r5.zze()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r7 = r3
            goto L_0x018f
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x013c
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzlb r13 = r0.zzi
            zzal(r13)
            boolean r13 = r13.zzw(r1, r11)
            if (r13 != 0) goto L_0x0149
            long r7 = r1 + r11
        L_0x0149:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x018f
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x018f
            r1 = 0
        L_0x0152:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzea r2 = com.google.android.gms.measurement.internal.zzeb.zzB
            r5 = 0
            java.lang.Object r2 = r2.zza(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r6 = 0
            int r2 = java.lang.Math.max(r6, r2)
            r11 = 20
            int r2 = java.lang.Math.min(r11, r2)
            if (r1 >= r2) goto L_0x0114
            r20.zzg()
            com.google.android.gms.measurement.internal.zzea r2 = com.google.android.gms.measurement.internal.zzeb.zzA
            java.lang.Object r2 = r2.zza(r5)
            java.lang.Long r2 = (java.lang.Long) r2
            long r11 = r2.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            r13 = 1
            long r13 = r13 << r1
            long r11 = r11 * r13
            long r7 = r7 + r11
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x018f
            int r1 = r1 + 1
            goto L_0x0152
        L_0x018f:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0238
            com.google.android.gms.measurement.internal.zzeu r1 = r0.zzd
            zzal(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x021b
            com.google.android.gms.measurement.internal.zzju r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzea r5 = com.google.android.gms.measurement.internal.zzeb.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzlb r9 = r0.zzi
            zzal(r9)
            boolean r9 = r9.zzw(r1, r5)
            if (r9 != 0) goto L_0x01ca
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzew r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0201
            r20.zzg()
            com.google.android.gms.measurement.internal.zzea r1 = com.google.android.gms.measurement.internal.zzeb.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzju r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzav()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0201:
            com.google.android.gms.measurement.internal.zzeo r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzj()
            java.lang.String r2 = "Upload scheduled in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r1.zzb(r2, r3)
            com.google.android.gms.measurement.internal.zzkl r1 = r0.zzg
            zzal(r1)
            r1.zzd(r7)
            return
        L_0x021b:
            com.google.android.gms.measurement.internal.zzeo r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzj()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzew r1 = r20.zzm()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkl r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0238:
            com.google.android.gms.measurement.internal.zzeo r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzj()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzew r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkl r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.zzeo r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzj()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzew r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkl r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.zzag():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0b81, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzag.zzA() + r8)) goto L_0x0b83;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03a7 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x046b A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04c5 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x081f A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0868 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x088b A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0902 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0904 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x090c A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0938 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0b71 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0bf8 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0c14 A[Catch:{ SQLiteException -> 0x0c2c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x01e4=Splitter:B:69:0x01e4, B:420:0x0d08=Splitter:B:420:0x0d08} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzah(java.lang.String r42, long r43) {
        /*
            r41 = this;
            r1 = r41
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze
            zzal(r4)
            r4.zzw()
            com.google.android.gms.measurement.internal.zzkw r4 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x0d1a }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            r6 = 0
            long r9 = r1.zzA     // Catch:{ all -> 0x0d1a }
            r7 = r43
            r11 = r4
            r5.zzU(r6, r7, r9, r11)     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r4.zzc     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0d08
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x002e
            goto L_0x0d08
        L_0x002e:
            com.google.android.gms.internal.measurement.zzgc r5 = r4.zza     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzka r5 = r5.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgb r5 = (com.google.android.gms.internal.measurement.zzgb) r5     // Catch:{ all -> 0x0d1a }
            r5.zzr()     // Catch:{ all -> 0x0d1a }
            r10 = r12
            r13 = r10
            r8 = 0
            r9 = 0
            r11 = -1
            r14 = -1
            r15 = 0
        L_0x0040:
            java.util.List r12 = r4.zzc     // Catch:{ all -> 0x0d1a }
            int r12 = r12.size()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r15
            java.lang.String r15 = "_e"
            r17 = r2
            r18 = r3
            if (r8 >= r12) goto L_0x0543
            java.util.List r3 = r4.zzc     // Catch:{ all -> 0x0d1a }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzka r3 = r3.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfp r12 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r2 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            r20 = r9
            java.lang.String r9 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.zzr(r2, r9)     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "_err"
            if (r2 == 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.zzeo r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzgc r7 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeo.zzn(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfy r12 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzej r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r15 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzd(r15)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r6, r7, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzp(r6)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzs(r6)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00e8
        L_0x00c3:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzlh r21 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzlg r2 = r1.zzF     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r23 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            r24 = 11
            java.lang.String r25 = "_ev"
            java.lang.String r26 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            r27 = 0
            r22 = r2
            r21.zzN(r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0d1a }
        L_0x00e8:
            r7 = r8
            r23 = r10
            r15 = r16
            r9 = r20
            r10 = r5
            r5 = -1
            goto L_0x0538
        L_0x00f3:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = com.google.android.gms.measurement.internal.zzgv.zza(r18)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x016d
            r2 = r18
            r3.zzi(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r12 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            r18 = r2
            java.lang.String r2 = "Renaming ad_impression to _ai"
            r12.zza(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzq()     // Catch:{ all -> 0x0d1a }
            r12 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r12)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x016d
            r2 = 0
        L_0x0125:
            int r12 = r3.zza()     // Catch:{ all -> 0x0d1a }
            if (r2 >= r12) goto L_0x016d
            java.lang.String r12 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfw r21 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r22 = r8
            java.lang.String r8 = r21.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r12.equals(r8)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0168
            com.google.android.gms.internal.measurement.zzfw r8 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0d1a }
            if (r8 != 0) goto L_0x0168
            java.lang.String r8 = "admob"
            com.google.android.gms.internal.measurement.zzfw r12 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r8.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0168
            com.google.android.gms.measurement.internal.zzeo r8 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "AdMob ad impression logged from app. Potentially duplicative."
            r8.zza(r12)     // Catch:{ all -> 0x0d1a }
        L_0x0168:
            int r2 = r2 + 1
            r8 = r22
            goto L_0x0125
        L_0x016d:
            r22 = r8
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r8 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzq(r8, r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "_c"
            if (r2 != 0) goto L_0x01db
            com.google.android.gms.measurement.internal.zzlb r12 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x0d1a }
            r21 = r11
            int r11 = r12.hashCode()     // Catch:{ all -> 0x0d1a }
            r23 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r11 == r10) goto L_0x01be
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r11 == r10) goto L_0x01b4
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r11 == r10) goto L_0x01aa
            goto L_0x01c8
        L_0x01aa:
            java.lang.String r10 = "_ui"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 1
            goto L_0x01c9
        L_0x01b4:
            java.lang.String r10 = "_ug"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 2
            goto L_0x01c9
        L_0x01be:
            java.lang.String r10 = "_in"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 0
            goto L_0x01c9
        L_0x01c8:
            r10 = -1
        L_0x01c9:
            if (r10 == 0) goto L_0x01df
            r11 = 1
            if (r10 == r11) goto L_0x01df
            r11 = 2
            if (r10 == r11) goto L_0x01df
            r25 = r5
            r24 = r7
            r7 = r13
            r19 = r14
            r2 = 0
            goto L_0x03a5
        L_0x01db:
            r23 = r10
            r21 = r11
        L_0x01df:
            r24 = r7
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x01e4:
            int r7 = r3.zza()     // Catch:{ all -> 0x0d1a }
            r25 = r5
            java.lang.String r5 = "_r"
            if (r10 >= r7) goto L_0x024b
            com.google.android.gms.internal.measurement.zzfw r7 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x0219
            com.google.android.gms.internal.measurement.zzfw r5 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzka r5 = r5.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfv r5 = (com.google.android.gms.internal.measurement.zzfv) r5     // Catch:{ all -> 0x0d1a }
            r7 = r13
            r19 = r14
            r13 = 1
            r5.zzi(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r5 = r5.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r10, r5)     // Catch:{ all -> 0x0d1a }
            r11 = 1
            goto L_0x0243
        L_0x0219:
            r7 = r13
            r19 = r14
            com.google.android.gms.internal.measurement.zzfw r13 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0243
            com.google.android.gms.internal.measurement.zzfw r5 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzka r5 = r5.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfv r5 = (com.google.android.gms.internal.measurement.zzfv) r5     // Catch:{ all -> 0x0d1a }
            r12 = 1
            r5.zzi(r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r5 = r5.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r10, r5)     // Catch:{ all -> 0x0d1a }
            r12 = 1
        L_0x0243:
            int r10 = r10 + 1
            r13 = r7
            r14 = r19
            r5 = r25
            goto L_0x01e4
        L_0x024b:
            r7 = r13
            r19 = r14
            if (r11 != 0) goto L_0x027c
            if (r2 == 0) goto L_0x027c
            com.google.android.gms.measurement.internal.zzeo r10 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r10 = r10.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfy r13 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzej r13 = r13.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzd(r14)     // Catch:{ all -> 0x0d1a }
            r10.zzb(r11, r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfv r10 = com.google.android.gms.internal.measurement.zzfw.zze()     // Catch:{ all -> 0x0d1a }
            r10.zzj(r8)     // Catch:{ all -> 0x0d1a }
            r13 = 1
            r10.zzi(r13)     // Catch:{ all -> 0x0d1a }
            r3.zze(r10)     // Catch:{ all -> 0x0d1a }
        L_0x027c:
            if (r12 != 0) goto L_0x02a8
            com.google.android.gms.measurement.internal.zzeo r10 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r10 = r10.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfy r12 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzej r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzd(r13)     // Catch:{ all -> 0x0d1a }
            r10.zzb(r11, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfv r10 = com.google.android.gms.internal.measurement.zzfw.zze()     // Catch:{ all -> 0x0d1a }
            r10.zzj(r5)     // Catch:{ all -> 0x0d1a }
            r11 = 1
            r10.zzi(r11)     // Catch:{ all -> 0x0d1a }
            r3.zze(r10)     // Catch:{ all -> 0x0d1a }
        L_0x02a8:
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r10)     // Catch:{ all -> 0x0d1a }
            long r27 = r41.zza()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r29 = r11.zzx()     // Catch:{ all -> 0x0d1a }
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 1
            r26 = r10
            com.google.android.gms.measurement.internal.zzak r10 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0d1a }
            long r10 = r10.zze     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzag r12 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r13 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzea r14 = com.google.android.gms.measurement.internal.zzeb.zzn     // Catch:{ all -> 0x0d1a }
            int r12 = r12.zze(r13, r14)     // Catch:{ all -> 0x0d1a }
            long r12 = (long) r12     // Catch:{ all -> 0x0d1a }
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x02e2
            zzab(r3, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x02e4
        L_0x02e2:
            r16 = 1
        L_0x02e4:
            java.lang.String r5 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r5 = com.google.android.gms.measurement.internal.zzlh.zzai(r5)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x03a5
            if (r2 == 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            long r27 = r41.zza()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r10 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r29 = r10.zzx()     // Catch:{ all -> 0x0d1a }
            r30 = 0
            r31 = 0
            r32 = 1
            r33 = 0
            r34 = 0
            r26 = r5
            com.google.android.gms.measurement.internal.zzak r5 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0d1a }
            long r10 = r5.zzc     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzag r5 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r12 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzea r13 = com.google.android.gms.measurement.internal.zzeb.zzm     // Catch:{ all -> 0x0d1a }
            int r5 = r5.zze(r12, r13)     // Catch:{ all -> 0x0d1a }
            long r12 = (long) r5     // Catch:{ all -> 0x0d1a }
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.zzeo r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgc r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeo.zzn(r11)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r10, r11)     // Catch:{ all -> 0x0d1a }
            r5 = 0
            r10 = 0
            r11 = 0
            r12 = -1
        L_0x0341:
            int r13 = r3.zza()     // Catch:{ all -> 0x0d1a }
            if (r10 >= r13) goto L_0x036b
            com.google.android.gms.internal.measurement.zzfw r13 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r14 = r8.equals(r14)     // Catch:{ all -> 0x0d1a }
            if (r14 == 0) goto L_0x035d
            com.google.android.gms.internal.measurement.zzka r5 = r13.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfv r5 = (com.google.android.gms.internal.measurement.zzfv) r5     // Catch:{ all -> 0x0d1a }
            r12 = r10
            goto L_0x0368
        L_0x035d:
            java.lang.String r13 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r13 = r9.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0368
            r11 = 1
        L_0x0368:
            int r10 = r10 + 1
            goto L_0x0341
        L_0x036b:
            if (r11 == 0) goto L_0x0374
            if (r5 == 0) goto L_0x0373
            r3.zzh(r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x03a5
        L_0x0373:
            r5 = 0
        L_0x0374:
            if (r5 == 0) goto L_0x038e
            com.google.android.gms.internal.measurement.zzka r5 = r5.zzau()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfv r5 = (com.google.android.gms.internal.measurement.zzfv) r5     // Catch:{ all -> 0x0d1a }
            r5.zzj(r9)     // Catch:{ all -> 0x0d1a }
            r9 = 10
            r5.zzi(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r5 = r5.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r12, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x03a5
        L_0x038e:
            com.google.android.gms.measurement.internal.zzeo r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgc r10 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r9, r10)     // Catch:{ all -> 0x0d1a }
        L_0x03a5:
            if (r2 == 0) goto L_0x045e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r3.zzp()     // Catch:{ all -> 0x0d1a }
            r2.<init>(r5)     // Catch:{ all -> 0x0d1a }
            r5 = 0
            r9 = -1
            r10 = -1
        L_0x03b3:
            int r11 = r2.size()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "currency"
            java.lang.String r13 = "value"
            if (r5 >= r11) goto L_0x03e3
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r11 = r13.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x03cf
            r9 = r5
            goto L_0x03e0
        L_0x03cf:
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x03e0
            r10 = r5
        L_0x03e0:
            int r5 = r5 + 1
            goto L_0x03b3
        L_0x03e3:
            r5 = -1
            if (r9 != r5) goto L_0x03e8
            goto L_0x045f
        L_0x03e8:
            java.lang.Object r5 = r2.get(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0419
            java.lang.Object r5 = r2.get(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0419
            com.google.android.gms.measurement.internal.zzeo r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.zza(r5)     // Catch:{ all -> 0x0d1a }
            r3.zzh(r9)     // Catch:{ all -> 0x0d1a }
            zzab(r3, r8)     // Catch:{ all -> 0x0d1a }
            r2 = 18
            zzaa(r3, r2, r13)     // Catch:{ all -> 0x0d1a }
            goto L_0x045e
        L_0x0419:
            r5 = -1
            if (r10 != r5) goto L_0x041d
            goto L_0x0445
        L_0x041d:
            java.lang.Object r2 = r2.get(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r2 = (com.google.android.gms.internal.measurement.zzfw) r2     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            int r10 = r2.length()     // Catch:{ all -> 0x0d1a }
            r11 = 3
            if (r10 != r11) goto L_0x0445
            r10 = 0
        L_0x042f:
            int r11 = r2.length()     // Catch:{ all -> 0x0d1a }
            if (r10 >= r11) goto L_0x045f
            int r11 = r2.codePointAt(r10)     // Catch:{ all -> 0x0d1a }
            boolean r13 = java.lang.Character.isLetter(r11)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0445
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x0d1a }
            int r10 = r10 + r11
            goto L_0x042f
        L_0x0445:
            com.google.android.gms.measurement.internal.zzeo r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r10)     // Catch:{ all -> 0x0d1a }
            r3.zzh(r9)     // Catch:{ all -> 0x0d1a }
            zzab(r3, r8)     // Catch:{ all -> 0x0d1a }
            r2 = 19
            zzaa(r3, r2, r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x045f
        L_0x045e:
            r5 = -1
        L_0x045f:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r15.equals(r2)     // Catch:{ all -> 0x0d1a }
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04c5
            com.google.android.gms.measurement.internal.zzlb r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r2 = r3.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r2 = com.google.android.gms.measurement.internal.zzlb.zzB(r2, r6)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x04c0
            if (r7 == 0) goto L_0x04b4
            long r10 = r7.zzc()     // Catch:{ all -> 0x0d1a }
            long r12 = r3.zzc()     // Catch:{ all -> 0x0d1a }
            long r10 = r10 - r12
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0d1a }
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x04b4
            com.google.android.gms.internal.measurement.zzka r2 = r7.zzau()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r2 = (com.google.android.gms.internal.measurement.zzfr) r2     // Catch:{ all -> 0x0d1a }
            boolean r6 = r1.zzaj(r3, r2)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x04a7
            r6 = r19
            r10 = r25
            r10.zzS(r6, r2)     // Catch:{ all -> 0x0d1a }
            r11 = r21
            r2 = 0
            r13 = 0
            goto L_0x04af
        L_0x04a7:
            r6 = r19
            r10 = r25
            r2 = r3
            r13 = r7
            r11 = r20
        L_0x04af:
            r23 = r2
            r14 = r6
            goto L_0x0524
        L_0x04b4:
            r6 = r19
            r10 = r25
            r23 = r3
            r14 = r6
            r13 = r7
            r11 = r20
            goto L_0x0524
        L_0x04c0:
            r6 = r19
            r10 = r25
            goto L_0x051f
        L_0x04c5:
            r6 = r19
            r10 = r25
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x051f
            com.google.android.gms.measurement.internal.zzlb r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r2 = r3.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d1a }
            r11 = r24
            com.google.android.gms.internal.measurement.zzfw r2 = com.google.android.gms.measurement.internal.zzlb.zzB(r2, r11)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x051f
            if (r23 == 0) goto L_0x0518
            long r11 = r23.zzc()     // Catch:{ all -> 0x0d1a }
            long r13 = r3.zzc()     // Catch:{ all -> 0x0d1a }
            long r11 = r11 - r13
            long r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0d1a }
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0518
            com.google.android.gms.internal.measurement.zzka r2 = r23.zzau()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r2 = (com.google.android.gms.internal.measurement.zzfr) r2     // Catch:{ all -> 0x0d1a }
            boolean r7 = r1.zzaj(r2, r3)     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x0511
            r8 = r21
            r10.zzS(r8, r2)     // Catch:{ all -> 0x0d1a }
            r14 = r6
            r2 = 0
            r23 = 0
            goto L_0x0516
        L_0x0511:
            r8 = r21
            r2 = r3
            r14 = r20
        L_0x0516:
            r13 = r2
            goto L_0x0523
        L_0x0518:
            r8 = r21
            r13 = r3
            r11 = r8
            r14 = r20
            goto L_0x0524
        L_0x051f:
            r8 = r21
            r14 = r6
            r13 = r7
        L_0x0523:
            r11 = r8
        L_0x0524:
            java.util.List r2 = r4.zzc     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r6 = r3.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r6 = (com.google.android.gms.internal.measurement.zzfs) r6     // Catch:{ all -> 0x0d1a }
            r7 = r22
            r2.set(r7, r6)     // Catch:{ all -> 0x0d1a }
            int r9 = r20 + 1
            r10.zzk(r3)     // Catch:{ all -> 0x0d1a }
            r15 = r16
        L_0x0538:
            int r8 = r7 + 1
            r5 = r10
            r2 = r17
            r3 = r18
            r10 = r23
            goto L_0x0040
        L_0x0543:
            r10 = r5
            r11 = r7
            r20 = r9
            r2 = 0
            r7 = r2
            r5 = 0
        L_0x054b:
            if (r5 >= r9) goto L_0x059b
            com.google.android.gms.internal.measurement.zzfs r12 = r10.zze(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r12.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x056e
            com.google.android.gms.measurement.internal.zzlb r13 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r13 = com.google.android.gms.measurement.internal.zzlb.zzB(r12, r6)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x056e
            r10.zzA(r5)     // Catch:{ all -> 0x0d1a }
            int r9 = r9 + -1
            int r5 = r5 + -1
            goto L_0x0598
        L_0x056e:
            com.google.android.gms.measurement.internal.zzlb r13 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r12 = com.google.android.gms.measurement.internal.zzlb.zzB(r12, r11)     // Catch:{ all -> 0x0d1a }
            if (r12 == 0) goto L_0x0598
            boolean r13 = r12.zzw()     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0588
            long r12 = r12.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x0589
        L_0x0588:
            r12 = 0
        L_0x0589:
            if (r12 == 0) goto L_0x0598
            long r13 = r12.longValue()     // Catch:{ all -> 0x0d1a }
            int r18 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r18 <= 0) goto L_0x0598
            long r12 = r12.longValue()     // Catch:{ all -> 0x0d1a }
            long r7 = r7 + r12
        L_0x0598:
            r12 = 1
            int r5 = r5 + r12
            goto L_0x054b
        L_0x059b:
            r5 = 0
            r1.zzaf(r10, r7, r5)     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r10.zzas()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x05a7:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "_se"
            if (r6 == 0) goto L_0x05cd
            java.lang.String r6 = "_s"
            java.lang.Object r11 = r5.next()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x05a7
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r10.zzap()     // Catch:{ all -> 0x0d1a }
            r5.zzA(r6, r9)     // Catch:{ all -> 0x0d1a }
        L_0x05cd:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzlb.zza(r10, r5)     // Catch:{ all -> 0x0d1a }
            if (r5 < 0) goto L_0x05da
            r5 = 1
            r1.zzaf(r10, r7, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x05fa
        L_0x05da:
            int r5 = com.google.android.gms.measurement.internal.zzlb.zza(r10, r9)     // Catch:{ all -> 0x0d1a }
            if (r5 < 0) goto L_0x05fa
            r10.zzB(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzgc r7 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeo.zzn(r7)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d1a }
        L_0x05fa:
            com.google.android.gms.measurement.internal.zzlb r5 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfy r6 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r6.zza(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkz r6 = r5.zzf     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfp r6 = r6.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r10.zzap()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.zzn(r7)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzkz r6 = r5.zzf     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r6 = r6.zze     // Catch:{ all -> 0x0d1a }
            zzal(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r10.zzap()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzh r6 = r6.zzj(r7)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            boolean r6 = r6.zzah()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzfy r6 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.zze()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzfy r6 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzc()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Turning off ad personalization due to account type"
            r6.zza(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgk r6 = com.google.android.gms.internal.measurement.zzgl.zzd()     // Catch:{ all -> 0x0d1a }
            r7 = r17
            r6.zzf(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r5 = r5.zzg()     // Catch:{ all -> 0x0d1a }
            long r8 = r5.zza()     // Catch:{ all -> 0x0d1a }
            r6.zzg(r8)     // Catch:{ all -> 0x0d1a }
            r8 = 1
            r6.zze(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r5 = r6.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgl r5 = (com.google.android.gms.internal.measurement.zzgl) r5     // Catch:{ all -> 0x0d1a }
            r6 = 0
        L_0x0673:
            int r8 = r10.zzb()     // Catch:{ all -> 0x0d1a }
            if (r6 >= r8) goto L_0x068e
            com.google.android.gms.internal.measurement.zzgl r8 = r10.zzao(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzf()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x068b
            r10.zzam(r6, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x0691
        L_0x068b:
            int r6 = r6 + 1
            goto L_0x0673
        L_0x068e:
            r10.zzm(r5)     // Catch:{ all -> 0x0d1a }
        L_0x0691:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10.zzai(r5)     // Catch:{ all -> 0x0d1a }
            r5 = -9223372036854775808
            r10.zzQ(r5)     // Catch:{ all -> 0x0d1a }
            r5 = 0
        L_0x069f:
            int r6 = r10.zza()     // Catch:{ all -> 0x0d1a }
            if (r5 >= r6) goto L_0x06d2
            com.google.android.gms.internal.measurement.zzfs r6 = r10.zze(r5)     // Catch:{ all -> 0x0d1a }
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            long r11 = r10.zzd()     // Catch:{ all -> 0x0d1a }
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 >= 0) goto L_0x06bc
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            r10.zzai(r7)     // Catch:{ all -> 0x0d1a }
        L_0x06bc:
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            long r11 = r10.zzc()     // Catch:{ all -> 0x0d1a }
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x06cf
            long r6 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            r10.zzQ(r6)     // Catch:{ all -> 0x0d1a }
        L_0x06cf:
            int r5 = r5 + 1
            goto L_0x069f
        L_0x06d2:
            r10.zzz()     // Catch:{ all -> 0x0d1a }
            r10.zzo()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaa r5 = r1.zzh     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r21 = r10.zzap()     // Catch:{ all -> 0x0d1a }
            java.util.List r22 = r10.zzas()     // Catch:{ all -> 0x0d1a }
            java.util.List r23 = r10.zzat()     // Catch:{ all -> 0x0d1a }
            long r6 = r10.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r24 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d1a }
            long r6 = r10.zzc()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r25 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d1a }
            r20 = r5
            java.util.List r5 = r20.zza(r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0d1a }
            r10.zzf(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzag r5 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzw(r6)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0a54
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0d1a }
            r5.<init>()     // Catch:{ all -> 0x0d1a }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0d1a }
            r6.<init>()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzlh r7 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            java.security.SecureRandom r7 = r7.zzG()     // Catch:{ all -> 0x0d1a }
            r8 = 0
        L_0x0725:
            int r9 = r10.zza()     // Catch:{ all -> 0x0d1a }
            if (r8 >= r9) goto L_0x0a1a
            com.google.android.gms.internal.measurement.zzfs r9 = r10.zze(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzka r9 = r9.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r9 = (com.google.android.gms.internal.measurement.zzfr) r9     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_ep"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r11 == 0) goto L_0x07c8
            com.google.android.gms.measurement.internal.zzlb r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r11 = r9.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = "_en"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzlb.zzC(r11, r14)     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0d1a }
            java.lang.Object r14 = r5.get(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r14 = (com.google.android.gms.measurement.internal.zzas) r14     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x077c
            com.google.android.gms.measurement.internal.zzam r14 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r15 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r17 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x0d1a }
            r2 = r17
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r14 = r14.zzn(r15, r2)     // Catch:{ all -> 0x0d1a }
            if (r14 == 0) goto L_0x077c
            r5.put(r11, r14)     // Catch:{ all -> 0x0d1a }
        L_0x077c:
            if (r14 == 0) goto L_0x07bb
            java.lang.Long r2 = r14.zzi     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x07bb
            java.lang.Long r2 = r14.zzj     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x079a
            long r2 = r2.longValue()     // Catch:{ all -> 0x0d1a }
            r17 = 1
            int r11 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r11 <= 0) goto L_0x079a
            com.google.android.gms.measurement.internal.zzlb r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = r14.zzj     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzlb.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
        L_0x079a:
            java.lang.Boolean r2 = r14.zzk     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x07b2
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x07b2
            com.google.android.gms.measurement.internal.zzlb r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            r2 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzlb.zzz(r9, r12, r11)     // Catch:{ all -> 0x0d1a }
        L_0x07b2:
            com.google.android.gms.internal.measurement.zzke r2 = r9.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
        L_0x07bb:
            r10.zzS(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x07be:
            r24 = r4
            r22 = r7
            r2 = r10
            r7 = r5
            r4 = 1
            goto L_0x0a0e
        L_0x07c8:
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r3 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r11 = r2.zza(r3, r11)     // Catch:{ all -> 0x0d1a }
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x07f9
            long r2 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x07e4 }
            goto L_0x07fb
        L_0x07e4:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r14, r3, r11)     // Catch:{ all -> 0x0d1a }
        L_0x07f9:
            r2 = 0
        L_0x07fb:
            com.google.android.gms.measurement.internal.zzlh r11 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            long r14 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            long r14 = r11.zzr(r14, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r11 = r9.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d1a }
            r44 = r12
            r17 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0d1a }
            r17 = r2
            java.lang.String r2 = "_dbg"
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x0853
            java.util.List r3 = r11.zzi()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x0827:
            boolean r11 = r3.hasNext()     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x0853
            java.lang.Object r11 = r3.next()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11     // Catch:{ all -> 0x0d1a }
            r22 = r3
            java.lang.String r3 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r3 = r2.equals(r3)     // Catch:{ all -> 0x0d1a }
            if (r3 == 0) goto L_0x0850
            long r2 = r11.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.equals(r2)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x084e
            goto L_0x0853
        L_0x084e:
            r2 = 1
            goto L_0x0866
        L_0x0850:
            r3 = r22
            goto L_0x0827
        L_0x0853:
            com.google.android.gms.measurement.internal.zzfp r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r3 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            int r2 = r2.zzc(r3, r11)     // Catch:{ all -> 0x0d1a }
        L_0x0866:
            if (r2 > 0) goto L_0x088b
            com.google.android.gms.measurement.internal.zzeo r3 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            r3.zzc(r11, r12, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r2 = r9.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
            r10.zzS(r8, r9)     // Catch:{ all -> 0x0d1a }
            goto L_0x07be
        L_0x088b:
            java.lang.String r3 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r3 = (com.google.android.gms.measurement.internal.zzas) r3     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x08eb
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r3)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzn(r11, r12)     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x08eb
            com.google.android.gms.measurement.internal.zzeo r3 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgc r12 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0d1a }
            r22 = r14
            java.lang.String r14 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r3.zzc(r11, r12, r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r25 = r11.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r26 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r27 = 1
            r29 = 1
            r31 = 1
            long r33 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            r35 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r24 = r3
            r24.<init>(r25, r26, r27, r29, r31, r33, r35, r37, r38, r39, r40)     // Catch:{ all -> 0x0d1a }
            goto L_0x08ed
        L_0x08eb:
            r22 = r14
        L_0x08ed:
            com.google.android.gms.measurement.internal.zzlb r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r11 = r9.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_eid"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzlb.zzC(r11, r12)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x0904
            r12 = 1
            goto L_0x0905
        L_0x0904:
            r12 = 0
        L_0x0905:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0d1a }
            r14 = 1
            if (r2 != r14) goto L_0x0938
            com.google.android.gms.internal.measurement.zzke r2 = r9.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0933
            java.lang.Long r2 = r3.zzi     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x0927
            java.lang.Long r2 = r3.zzj     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x0927
            java.lang.Boolean r2 = r3.zzk     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0933
        L_0x0927:
            r2 = 0
            com.google.android.gms.measurement.internal.zzas r3 = r3.zza(r2, r2, r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r5.put(r2, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0933:
            r10.zzS(r8, r9)     // Catch:{ all -> 0x0d1a }
            goto L_0x07be
        L_0x0938:
            int r14 = r7.nextInt(r2)     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x097a
            com.google.android.gms.measurement.internal.zzlb r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r11)     // Catch:{ all -> 0x0d1a }
            long r14 = (long) r2     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzlb.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r11 = r9.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d1a }
            r6.add(r11)     // Catch:{ all -> 0x0d1a }
            boolean r11 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x095f
            r11 = 0
            com.google.android.gms.measurement.internal.zzas r3 = r3.zza(r11, r2, r11)     // Catch:{ all -> 0x0d1a }
        L_0x095f:
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            long r11 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            r14 = r22
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzb(r11, r14)     // Catch:{ all -> 0x0d1a }
            r5.put(r2, r3)     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r22 = r7
            r2 = r10
            r7 = r5
            r4 = 1
            goto L_0x0a0b
        L_0x097a:
            r14 = r22
            r22 = r7
            java.lang.Long r7 = r3.zzh     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x098f
            long r17 = r7.longValue()     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r26 = r5
            r25 = r10
            r23 = r11
            goto L_0x09a5
        L_0x098f:
            com.google.android.gms.measurement.internal.zzlh r7 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            r25 = r10
            r23 = r11
            long r10 = r9.zzb()     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r26 = r5
            r4 = r17
            long r17 = r7.zzr(r10, r4)     // Catch:{ all -> 0x0d1a }
        L_0x09a5:
            int r4 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x09f1
            com.google.android.gms.measurement.internal.zzlb r4 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r4)     // Catch:{ all -> 0x0d1a }
            r4 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0d1a }
            r10 = r44
            com.google.android.gms.measurement.internal.zzlb.zzz(r9, r10, r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzlb r7 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r7)     // Catch:{ all -> 0x0d1a }
            long r10 = (long) r2     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzlb.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r7 = r9.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r7 = (com.google.android.gms.internal.measurement.zzfs) r7     // Catch:{ all -> 0x0d1a }
            r6.add(r7)     // Catch:{ all -> 0x0d1a }
            boolean r7 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x09df
            r7 = 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0d1a }
            r7 = 0
            com.google.android.gms.measurement.internal.zzas r3 = r3.zza(r7, r2, r10)     // Catch:{ all -> 0x0d1a }
        L_0x09df:
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            long r10 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzb(r10, r14)     // Catch:{ all -> 0x0d1a }
            r7 = r26
            r7.put(r2, r3)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a09
        L_0x09f1:
            r7 = r26
            r4 = 1
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0a09
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r11 = r23
            r10 = 0
            com.google.android.gms.measurement.internal.zzas r3 = r3.zza(r11, r10, r10)     // Catch:{ all -> 0x0d1a }
            r7.put(r2, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0a09:
            r2 = r25
        L_0x0a0b:
            r2.zzS(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0a0e:
            int r8 = r8 + 1
            r10 = r2
            r5 = r7
            r7 = r22
            r4 = r24
            r2 = 0
            goto L_0x0725
        L_0x0a1a:
            r24 = r4
            r7 = r5
            r2 = r10
            int r3 = r6.size()     // Catch:{ all -> 0x0d1a }
            int r4 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r3 >= r4) goto L_0x0a2e
            r2.zzr()     // Catch:{ all -> 0x0d1a }
            r2.zzg(r6)     // Catch:{ all -> 0x0d1a }
        L_0x0a2e:
            java.util.Set r3 = r7.entrySet()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x0a36:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0d1a }
            if (r4 == 0) goto L_0x0a51
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0d1a }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r4 = (com.google.android.gms.measurement.internal.zzas) r4     // Catch:{ all -> 0x0d1a }
            r5.zzE(r4)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a36
        L_0x0a51:
            r3 = r24
            goto L_0x0a56
        L_0x0a54:
            r2 = r10
            r3 = r4
        L_0x0a56:
            com.google.android.gms.internal.measurement.zzgc r4 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzh r5 = r5.zzj(r4)     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0a7f
            com.google.android.gms.measurement.internal.zzeo r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgc r7 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeo.zzn(r7)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d1a }
            goto L_0x0adb
        L_0x0a7f:
            int r6 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r6 <= 0) goto L_0x0adb
            long r6 = r5.zzn()     // Catch:{ all -> 0x0d1a }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0a93
            r2.zzab(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a96
        L_0x0a93:
            r2.zzv()     // Catch:{ all -> 0x0d1a }
        L_0x0a96:
            long r8 = r5.zzp()     // Catch:{ all -> 0x0d1a }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0aa1
            goto L_0x0aa2
        L_0x0aa1:
            r6 = r8
        L_0x0aa2:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0aaa
            r2.zzac(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0aad
        L_0x0aaa:
            r2.zzw()     // Catch:{ all -> 0x0d1a }
        L_0x0aad:
            r5.zzE()     // Catch:{ all -> 0x0d1a }
            long r6 = r5.zzo()     // Catch:{ all -> 0x0d1a }
            int r7 = (int) r6     // Catch:{ all -> 0x0d1a }
            r2.zzI(r7)     // Catch:{ all -> 0x0d1a }
            long r6 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            r5.zzab(r6)     // Catch:{ all -> 0x0d1a }
            long r6 = r2.zzc()     // Catch:{ all -> 0x0d1a }
            r5.zzZ(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r5.zzs()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0ad0
            r2.zzW(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0ad3
        L_0x0ad0:
            r2.zzs()     // Catch:{ all -> 0x0d1a }
        L_0x0ad3:
            com.google.android.gms.measurement.internal.zzam r6 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r6)     // Catch:{ all -> 0x0d1a }
            r6.zzD(r5)     // Catch:{ all -> 0x0d1a }
        L_0x0adb:
            int r5 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r5 <= 0) goto L_0x0c5f
            com.google.android.gms.measurement.internal.zzfy r5 = r1.zzn     // Catch:{ all -> 0x0d1a }
            r5.zzaw()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfp r5 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r6 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfe r5 = r5.zze(r6)     // Catch:{ all -> 0x0d1a }
            r6 = -1
            if (r5 == 0) goto L_0x0b08
            boolean r8 = r5.zzs()     // Catch:{ all -> 0x0d1a }
            if (r8 != 0) goto L_0x0b00
            goto L_0x0b08
        L_0x0b00:
            long r8 = r5.zzc()     // Catch:{ all -> 0x0d1a }
            r2.zzK(r8)     // Catch:{ all -> 0x0d1a }
            goto L_0x0b2f
        L_0x0b08:
            com.google.android.gms.internal.measurement.zzgc r5 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = r5.zzF()     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0b18
            r2.zzK(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0b2f
        L_0x0b18:
            com.google.android.gms.measurement.internal.zzeo r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgc r9 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeo.zzn(r9)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0b2f:
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzke r2 = r2.zzaE()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r2 = (com.google.android.gms.internal.measurement.zzgc) r2     // Catch:{ all -> 0x0d1a }
            r5.zzg()     // Catch:{ all -> 0x0d1a }
            r5.zzW()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0d1a }
            boolean r8 = r2.zzbe()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkState(r8)     // Catch:{ all -> 0x0d1a }
            r5.zzz()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfy r8 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.util.Clock r8 = r8.zzav()     // Catch:{ all -> 0x0d1a }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0d1a }
            long r10 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfy r12 = r5.zzs     // Catch:{ all -> 0x0d1a }
            r12.zzf()     // Catch:{ all -> 0x0d1a }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0d1a }
            long r12 = r8 - r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0b83
            long r10 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfy r12 = r5.zzs     // Catch:{ all -> 0x0d1a }
            r12.zzf()     // Catch:{ all -> 0x0d1a }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0d1a }
            long r12 = r12 + r8
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0ba6
        L_0x0b83:
            com.google.android.gms.measurement.internal.zzfy r10 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r10 = r10.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r10 = r10.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeo.zzn(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0d1a }
            long r13 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0d1a }
            r10.zzd(r11, r12, r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0ba6:
            byte[] r8 = r2.zzbv()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkz r9 = r5.zzf     // Catch:{ IOException -> 0x0c46 }
            com.google.android.gms.measurement.internal.zzlb r9 = r9.zzi     // Catch:{ IOException -> 0x0c46 }
            zzal(r9)     // Catch:{ IOException -> 0x0c46 }
            byte[] r8 = r9.zzy(r8)     // Catch:{ IOException -> 0x0c46 }
            com.google.android.gms.measurement.internal.zzfy r9 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r9 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0d1a }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0d1a }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0d1a }
            r9.<init>()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0d1a }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0d1a }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d1a }
            boolean r8 = r2.zzbk()     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0c05
            java.lang.String r8 = "retry_count"
            int r10 = r2.zze()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0d1a }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d1a }
        L_0x0c05:
            android.database.sqlite.SQLiteDatabase r8 = r5.zzh()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0c2c }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x0c5f
            com.google.android.gms.measurement.internal.zzfy r6 = r5.zzs     // Catch:{ SQLiteException -> 0x0c2c }
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzay()     // Catch:{ SQLiteException -> 0x0c2c }
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r2.zzx()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeo.zzn(r8)     // Catch:{ SQLiteException -> 0x0c2c }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0c2c }
            goto L_0x0c5f
        L_0x0c2c:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeo.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r5.zzc(r7, r2, r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0c5f
        L_0x0c46:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeo.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r5.zzc(r7, r2, r6)     // Catch:{ all -> 0x0d1a }
        L_0x0c5f:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            java.util.List r3 = r3.zzb     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzg()     // Catch:{ all -> 0x0d1a }
            r2.zzW()     // Catch:{ all -> 0x0d1a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0d1a }
            r6 = 0
        L_0x0c77:
            int r7 = r3.size()     // Catch:{ all -> 0x0d1a }
            if (r6 >= r7) goto L_0x0c94
            if (r6 == 0) goto L_0x0c84
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0d1a }
        L_0x0c84:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0d1a }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0d1a }
            r5.append(r7)     // Catch:{ all -> 0x0d1a }
            int r6 = r6 + 1
            goto L_0x0c77
        L_0x0c94:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0d1a }
            android.database.sqlite.SQLiteDatabase r6 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0d1a }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0d1a }
            int r6 = r3.size()     // Catch:{ all -> 0x0d1a }
            if (r5 == r6) goto L_0x0cc9
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0d1a }
            int r3 = r3.size()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r6, r5, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0cc9:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0ce1 }
            r6 = 0
            r5[r6] = r4     // Catch:{ SQLiteException -> 0x0ce1 }
            r6 = 1
            r5[r6] = r4     // Catch:{ SQLiteException -> 0x0ce1 }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r3.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0ce1 }
            goto L_0x0cf6
        L_0x0ce1:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r4)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r5, r4, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0cf6:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            r2.zzC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r2 = 1
            return r2
        L_0x0d08:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            r2.zzC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r2 = 0
            return r2
        L_0x0d1a:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze
            zzal(r3)
            r3.zzx()
            goto L_0x0d26
        L_0x0d25:
            throw r2
        L_0x0d26:
            goto L_0x0d25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.zzah(java.lang.String, long):boolean");
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        zzam zzam = this.zze;
        zzal(zzam);
        if (zzam.zzF()) {
            return true;
        }
        zzam zzam2 = this.zze;
        zzal(zzam2);
        return !TextUtils.isEmpty(zzam2.zzr());
    }

    private final boolean zzaj(zzfr zzfr, zzfr zzfr2) {
        Preconditions.checkArgument("_e".equals(zzfr.zzo()));
        zzal(this.zzi);
        zzfw zzB2 = zzlb.zzB((zzfs) zzfr.zzaE(), "_sc");
        String str = null;
        String zzh2 = zzB2 == null ? null : zzB2.zzh();
        zzal(this.zzi);
        zzfw zzB3 = zzlb.zzB((zzfs) zzfr2.zzaE(), "_pc");
        if (zzB3 != null) {
            str = zzB3.zzh();
        }
        if (str == null || !str.equals(zzh2)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfr.zzo()));
        zzal(this.zzi);
        zzfw zzB4 = zzlb.zzB((zzfs) zzfr.zzaE(), "_et");
        if (zzB4 == null || !zzB4.zzw() || zzB4.zzd() <= 0) {
            return true;
        }
        long zzd2 = zzB4.zzd();
        zzal(this.zzi);
        zzfw zzB5 = zzlb.zzB((zzfs) zzfr2.zzaE(), "_et");
        if (zzB5 != null && zzB5.zzd() > 0) {
            zzd2 += zzB5.zzd();
        }
        zzal(this.zzi);
        zzlb.zzz(zzfr2, "_et", Long.valueOf(zzd2));
        zzal(this.zzi);
        zzlb.zzz(zzfr, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzq2) {
        return !TextUtils.isEmpty(zzq2.zzb) || !TextUtils.isEmpty(zzq2.zzq);
    }

    private static final zzkn zzal(zzkn zzkn) {
        if (zzkn == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzkn.zzY()) {
            return zzkn;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzkn.getClass()))));
        }
    }

    public static zzkz zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkz.class) {
                if (zzb == null) {
                    zzb = new zzkz((zzla) Preconditions.checkNotNull(new zzla(context)), (zzfy) null);
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzy(zzkz zzkz, zzla zzla) {
        zzkz.zzaz().zzg();
        zzkz.zzm = new zzfg(zzkz);
        zzam zzam = new zzam(zzkz);
        zzam.zzX();
        zzkz.zze = zzam;
        zzkz.zzg().zzq((zzaf) Preconditions.checkNotNull(zzkz.zzc));
        zzju zzju = new zzju(zzkz);
        zzju.zzX();
        zzkz.zzk = zzju;
        zzaa zzaa = new zzaa(zzkz);
        zzaa.zzX();
        zzkz.zzh = zzaa;
        zzii zzii = new zzii(zzkz);
        zzii.zzX();
        zzkz.zzj = zzii;
        zzkl zzkl = new zzkl(zzkz);
        zzkl.zzX();
        zzkz.zzg = zzkl;
        zzkz.zzf = new zzew(zzkz);
        if (zzkz.zzr != zzkz.zzs) {
            zzkz.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzkz.zzr), Integer.valueOf(zzkz.zzs));
        }
        zzkz.zzo = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzA() {
        zzaz().zzg();
        zzB();
        if (!this.zzp) {
            this.zzp = true;
            if (zzZ()) {
                FileChannel fileChannel = this.zzx;
                zzaz().zzg();
                int i = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i = allocate.getInt();
                        } else if (read != -1) {
                            zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e) {
                        zzay().zzd().zzb("Failed to read from channel", e);
                    }
                }
                int zzi2 = this.zzn.zzh().zzi();
                zzaz().zzg();
                if (i > zzi2) {
                    zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                } else if (i < zzi2) {
                    FileChannel fileChannel2 = this.zzx;
                    zzaz().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzay().zzd().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzi2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                            return;
                        } catch (IOException e2) {
                            zzay().zzd().zzb("Failed to write to channel", e2);
                        }
                    }
                    zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzC(String str, zzgb zzgb) {
        int zza2;
        int indexOf;
        zzow.zzc();
        if (zzg().zzs(str, zzeb.zzam)) {
            zzfp zzfp = this.zzc;
            zzal(zzfp);
            Set zzk2 = zzfp.zzk(str);
            if (zzk2 != null) {
                zzgb.zzi(zzk2);
            }
        }
        if (zzg().zzs(str, zzeb.zzao)) {
            zzfp zzfp2 = this.zzc;
            zzal(zzfp2);
            if (zzfp2.zzv(str)) {
                zzgb.zzp();
            }
            zzfp zzfp3 = this.zzc;
            zzal(zzfp3);
            if (zzfp3.zzy(str)) {
                if (zzg().zzs(str, zzeb.zzay)) {
                    String zzar = zzgb.zzar();
                    if (!TextUtils.isEmpty(zzar) && (indexOf = zzar.indexOf(".")) != -1) {
                        zzgb.zzY(zzar.substring(0, indexOf));
                    }
                } else {
                    zzgb.zzu();
                }
            }
        }
        if (zzg().zzs(str, zzeb.zzap)) {
            zzfp zzfp4 = this.zzc;
            zzal(zzfp4);
            if (zzfp4.zzz(str) && (zza2 = zzlb.zza(zzgb, "_id")) != -1) {
                zzgb.zzB(zza2);
            }
        }
        if (zzg().zzs(str, zzeb.zzaq)) {
            zzfp zzfp5 = this.zzc;
            zzal(zzfp5);
            if (zzfp5.zzx(str)) {
                zzgb.zzq();
            }
        }
        if (zzg().zzs(str, zzeb.zzat)) {
            zzfp zzfp6 = this.zzc;
            zzal(zzfp6);
            if (zzfp6.zzu(str)) {
                zzgb.zzn();
                if (zzg().zzs(str, zzeb.zzau)) {
                    zzky zzky = (zzky) this.zzC.get(str);
                    if (zzky == null || zzky.zzb + zzg().zzi(str, zzeb.zzR) < zzav().elapsedRealtime()) {
                        zzky = new zzky(this);
                        this.zzC.put(str, zzky);
                    }
                    zzgb.zzR(zzky.zza);
                }
            }
        }
        if (zzg().zzs(str, zzeb.zzav)) {
            zzfp zzfp7 = this.zzc;
            zzal(zzfp7);
            if (zzfp7.zzw(str)) {
                zzgb.zzy();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzD(zzh zzh2) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        zzaz().zzg();
        if (!TextUtils.isEmpty(zzh2.zzy()) || !TextUtils.isEmpty(zzh2.zzr())) {
            zzko zzko = this.zzl;
            Uri.Builder builder = new Uri.Builder();
            String zzy2 = zzh2.zzy();
            if (TextUtils.isEmpty(zzy2)) {
                zzy2 = zzh2.zzr();
            }
            ArrayMap arrayMap3 = null;
            Uri.Builder appendQueryParameter = builder.scheme((String) zzeb.zzd.zza((Object) null)).encodedAuthority((String) zzeb.zze.zza((Object) null)).path("config/app/".concat(String.valueOf(zzy2))).appendQueryParameter("platform", "android");
            zzko.zzs.zzf().zzh();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(73000)).appendQueryParameter("runtime_version", "0");
            zzow.zzc();
            if (!zzko.zzs.zzf().zzs(zzh2.zzt(), zzeb.zzak)) {
                builder.appendQueryParameter("app_instance_id", zzh2.zzu());
            }
            String uri = builder.build().toString();
            try {
                String str = (String) Preconditions.checkNotNull(zzh2.zzt());
                URL url = new URL(uri);
                zzay().zzj().zzb("Fetching remote configuration", str);
                zzfp zzfp = this.zzc;
                zzal(zzfp);
                zzfe zze2 = zzfp.zze(str);
                zzfp zzfp2 = this.zzc;
                zzal(zzfp2);
                String zzh3 = zzfp2.zzh(str);
                if (zze2 != null) {
                    if (!TextUtils.isEmpty(zzh3)) {
                        arrayMap2 = new ArrayMap();
                        arrayMap2.put("If-Modified-Since", zzh3);
                    } else {
                        arrayMap2 = null;
                    }
                    zzow.zzc();
                    if (zzg().zzs((String) null, zzeb.zzaw)) {
                        zzfp zzfp3 = this.zzc;
                        zzal(zzfp3);
                        String zzf2 = zzfp3.zzf(str);
                        if (!TextUtils.isEmpty(zzf2)) {
                            if (arrayMap2 == null) {
                                arrayMap2 = new ArrayMap();
                            }
                            arrayMap3 = arrayMap2;
                            arrayMap3.put("If-None-Match", zzf2);
                        }
                    }
                    arrayMap = arrayMap2;
                    this.zzt = true;
                    zzeu zzeu = this.zzd;
                    zzal(zzeu);
                    zzkr zzkr = new zzkr(this);
                    zzeu.zzg();
                    zzeu.zzW();
                    Preconditions.checkNotNull(url);
                    Preconditions.checkNotNull(zzkr);
                    zzeu.zzs.zzaz().zzo(new zzet(zzeu, str, url, (byte[]) null, arrayMap, zzkr));
                }
                arrayMap = arrayMap3;
                this.zzt = true;
                zzeu zzeu2 = this.zzd;
                zzal(zzeu2);
                zzkr zzkr2 = new zzkr(this);
                zzeu2.zzg();
                zzeu2.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzkr2);
                zzeu2.zzs.zzaz().zzo(new zzet(zzeu2, str, url, (byte[]) null, arrayMap, zzkr2));
            } catch (MalformedURLException unused) {
                zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeo.zzn(zzh2.zzt()), uri);
            }
        } else {
            zzI((String) Preconditions.checkNotNull(zzh2.zzt()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(zzaw zzaw, zzq zzq2) {
        zzaw zzaw2;
        List<zzac> list;
        List<zzac> list2;
        List<zzac> list3;
        String str;
        zzq zzq3 = zzq2;
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq3.zza);
        zzaz().zzg();
        zzB();
        String str2 = zzq3.zza;
        long j = zzaw.zzd;
        zzep zzb2 = zzep.zzb(zzaw);
        zzaz().zzg();
        zzik zzik = null;
        if (!(this.zzD == null || (str = this.zzE) == null || !str.equals(str2))) {
            zzik = this.zzD;
        }
        zzlh.zzK(zzik, zzb2.zzd, false);
        zzaw zza2 = zzb2.zza();
        zzal(this.zzi);
        if (zzlb.zzA(zza2, zzq3)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            List list4 = zzq3.zzt;
            if (list4 == null) {
                zzaw2 = zza2;
            } else if (list4.contains(zza2.zza)) {
                Bundle zzc2 = zza2.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzaw2 = new zzaw(zza2.zza, new zzau(zzc2), zza2.zzc, zza2.zzd);
            } else {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza2.zza, zza2.zzc);
                return;
            }
            zzam zzam = this.zze;
            zzal(zzam);
            zzam.zzw();
            try {
                zzam zzam2 = this.zze;
                zzal(zzam2);
                Preconditions.checkNotEmpty(str2);
                zzam2.zzg();
                zzam2.zzW();
                if (j < 0) {
                    zzam2.zzs.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzeo.zzn(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzam2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzac zzac : list) {
                    if (zzac != null) {
                        zzay().zzj().zzd("User property timed out", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb), zzac.zzc.zza());
                        zzaw zzaw3 = zzac.zzg;
                        if (zzaw3 != null) {
                            zzY(new zzaw(zzaw3, j), zzq3);
                        }
                        zzam zzam3 = this.zze;
                        zzal(zzam3);
                        zzam3.zza(str2, zzac.zzc.zzb);
                    }
                }
                zzam zzam4 = this.zze;
                zzal(zzam4);
                Preconditions.checkNotEmpty(str2);
                zzam4.zzg();
                zzam4.zzW();
                if (j < 0) {
                    zzam4.zzs.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzeo.zzn(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzam4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList<zzaw> arrayList = new ArrayList<>(list2.size());
                for (zzac zzac2 : list2) {
                    if (zzac2 != null) {
                        zzay().zzj().zzd("User property expired", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                        zzam zzam5 = this.zze;
                        zzal(zzam5);
                        zzam5.zzA(str2, zzac2.zzc.zzb);
                        zzaw zzaw4 = zzac2.zzk;
                        if (zzaw4 != null) {
                            arrayList.add(zzaw4);
                        }
                        zzam zzam6 = this.zze;
                        zzal(zzam6);
                        zzam6.zza(str2, zzac2.zzc.zzb);
                    }
                }
                for (zzaw zzaw5 : arrayList) {
                    zzY(new zzaw(zzaw5, j), zzq3);
                }
                zzam zzam7 = this.zze;
                zzal(zzam7);
                String str3 = zzaw2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzam7.zzg();
                zzam7.zzW();
                if (j < 0) {
                    zzam7.zzs.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzeo.zzn(str2), zzam7.zzs.zzj().zzd(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzam7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList<zzaw> arrayList2 = new ArrayList<>(list3.size());
                for (zzac zzac3 : list3) {
                    if (zzac3 != null) {
                        zzlc zzlc = zzac3.zzc;
                        zzle zzle = new zzle((String) Preconditions.checkNotNull(zzac3.zza), zzac3.zzb, zzlc.zzb, j, Preconditions.checkNotNull(zzlc.zza()));
                        zzam zzam8 = this.zze;
                        zzal(zzam8);
                        if (zzam8.zzL(zzle)) {
                            zzay().zzj().zzd("User property triggered", zzac3.zza, this.zzn.zzj().zzf(zzle.zzc), zzle.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzeo.zzn(zzac3.zza), this.zzn.zzj().zzf(zzle.zzc), zzle.zze);
                        }
                        zzaw zzaw6 = zzac3.zzi;
                        if (zzaw6 != null) {
                            arrayList2.add(zzaw6);
                        }
                        zzac3.zzc = new zzlc(zzle);
                        zzac3.zze = true;
                        zzam zzam9 = this.zze;
                        zzal(zzam9);
                        zzam9.zzK(zzac3);
                    }
                }
                zzY(zzaw2, zzq3);
                for (zzaw zzaw7 : arrayList2) {
                    zzY(new zzaw(zzaw7, j), zzq3);
                }
                zzam zzam10 = this.zze;
                zzal(zzam10);
                zzam10.zzC();
            } finally {
                zzam zzam11 = this.zze;
                zzal(zzam11);
                zzam11.zzx();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzF(zzaw zzaw, String str) {
        zzaw zzaw2 = zzaw;
        String str2 = str;
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null) {
            if (!"_ui".equals(zzaw2.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzeo.zzn(str));
            }
        } else if (!zzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzeo.zzn(str));
            return;
        }
        String zzy2 = zzj2.zzy();
        String zzw2 = zzj2.zzw();
        long zzb2 = zzj2.zzb();
        String zzv2 = zzj2.zzv();
        long zzm2 = zzj2.zzm();
        long zzj3 = zzj2.zzj();
        boolean zzai = zzj2.zzai();
        String zzx2 = zzj2.zzx();
        zzj2.zza();
        zzq zzq2 = r2;
        zzh zzh2 = zzj2;
        zzq zzq3 = new zzq(str, zzy2, zzw2, zzb2, zzv2, zzm2, zzj3, (String) null, zzai, false, zzx2, 0, 0, 0, zzh2.zzah(), false, zzh2.zzr(), zzh2.zzq(), zzh2.zzk(), zzh2.zzC(), (String) null, zzh(str2).zzh(), "", (String) null);
        zzG(zzaw2, zzq2);
    }

    /* access modifiers changed from: package-private */
    public final void zzG(zzaw zzaw, zzq zzq2) {
        Preconditions.checkNotEmpty(zzq2.zza);
        zzep zzb2 = zzep.zzb(zzaw);
        zzlh zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        zzam zzam = this.zze;
        zzal(zzam);
        zzv2.zzL(bundle, zzam.zzi(zzq2.zza));
        zzv().zzM(zzb2, zzg().zzd(zzq2.zza));
        zzaw zza2 = zzb2.zza();
        if ("_cmp".equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zzg("_cis"))) {
            String zzg2 = zza2.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg2)) {
                zzW(new zzlc("_lgclid", zza2.zzd, zzg2, "auto"), zzq2);
            }
        }
        zzE(zza2, zzq2);
    }

    /* access modifiers changed from: package-private */
    public final void zzH() {
        this.zzs++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[Catch:{ all -> 0x0197, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[Catch:{ all -> 0x0197, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0105 A[Catch:{ all -> 0x0197, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012c A[Catch:{ all -> 0x0197, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0152 A[Catch:{ all -> 0x0197, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0160 A[Catch:{ all -> 0x0197, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0182 A[Catch:{ all -> 0x0197, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0186 A[Catch:{ all -> 0x0197, all -> 0x01a1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzfv r0 = r8.zzaz()
            r0.zzg()
            r8.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            r0 = 0
            if (r12 != 0) goto L_0x0012
            byte[] r12 = new byte[r0]     // Catch:{ all -> 0x01a1 }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzeo r1 = r8.zzay()     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzj()     // Catch:{ all -> 0x01a1 }
            int r2 = r12.length     // Catch:{ all -> 0x01a1 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzam r1 = r8.zze     // Catch:{ all -> 0x01a1 }
            zzal(r1)     // Catch:{ all -> 0x01a1 }
            r1.zzw()     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzam r1 = r8.zze     // Catch:{ all -> 0x0197 }
            zzal(r1)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzh r1 = r1.zzj(r9)     // Catch:{ all -> 0x0197 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r10 == r3) goto L_0x0043
            r3 = 204(0xcc, float:2.86E-43)
            if (r10 == r3) goto L_0x0043
            if (r10 != r4) goto L_0x0047
            r10 = 304(0x130, float:4.26E-43)
        L_0x0043:
            if (r11 != 0) goto L_0x0047
            r3 = 1
            goto L_0x0048
        L_0x0047:
            r3 = 0
        L_0x0048:
            if (r1 != 0) goto L_0x005d
            com.google.android.gms.measurement.internal.zzeo r10 = r8.zzay()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzem r10 = r10.zzk()     // Catch:{ all -> 0x0197 }
            java.lang.String r11 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeo.zzn(r9)     // Catch:{ all -> 0x0197 }
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0197 }
            goto L_0x0189
        L_0x005d:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00bb
            if (r10 != r5) goto L_0x0064
            goto L_0x00bb
        L_0x0064:
            com.google.android.gms.common.util.Clock r12 = r8.zzav()     // Catch:{ all -> 0x0197 }
            long r12 = r12.currentTimeMillis()     // Catch:{ all -> 0x0197 }
            r1.zzU(r12)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzam r12 = r8.zze     // Catch:{ all -> 0x0197 }
            zzal(r12)     // Catch:{ all -> 0x0197 }
            r12.zzD(r1)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzeo r12 = r8.zzay()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzem r12 = r12.zzj()     // Catch:{ all -> 0x0197 }
            java.lang.String r13 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0197 }
            r12.zzc(r13, r1, r11)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzfp r11 = r8.zzc     // Catch:{ all -> 0x0197 }
            zzal(r11)     // Catch:{ all -> 0x0197 }
            r11.zzl(r9)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzju r9 = r8.zzk     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzez r9 = r9.zzd     // Catch:{ all -> 0x0197 }
            com.google.android.gms.common.util.Clock r11 = r8.zzav()     // Catch:{ all -> 0x0197 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0197 }
            r9.zzb(r11)     // Catch:{ all -> 0x0197 }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x00a7
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x00b6
        L_0x00a7:
            com.google.android.gms.measurement.internal.zzju r9 = r8.zzk     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzez r9 = r9.zzb     // Catch:{ all -> 0x0197 }
            com.google.android.gms.common.util.Clock r10 = r8.zzav()     // Catch:{ all -> 0x0197 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0197 }
            r9.zzb(r10)     // Catch:{ all -> 0x0197 }
        L_0x00b6:
            r8.zzag()     // Catch:{ all -> 0x0197 }
            goto L_0x0189
        L_0x00bb:
            r11 = 0
            if (r13 == 0) goto L_0x00c7
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r3 = r13.get(r3)     // Catch:{ all -> 0x0197 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0197 }
            goto L_0x00c8
        L_0x00c7:
            r3 = r11
        L_0x00c8:
            if (r3 == 0) goto L_0x00d7
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x0197 }
            if (r6 != 0) goto L_0x00d7
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0197 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0197 }
            goto L_0x00d8
        L_0x00d7:
            r3 = r11
        L_0x00d8:
            com.google.android.gms.internal.measurement.zzow.zzc()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzag r6 = r8.zzg()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzea r7 = com.google.android.gms.measurement.internal.zzeb.zzaw     // Catch:{ all -> 0x0197 }
            boolean r6 = r6.zzs(r11, r7)     // Catch:{ all -> 0x0197 }
            if (r6 == 0) goto L_0x0102
            if (r13 == 0) goto L_0x00f2
            java.lang.String r6 = "ETag"
            java.lang.Object r13 = r13.get(r6)     // Catch:{ all -> 0x0197 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0197 }
            goto L_0x00f3
        L_0x00f2:
            r13 = r11
        L_0x00f3:
            if (r13 == 0) goto L_0x0102
            boolean r6 = r13.isEmpty()     // Catch:{ all -> 0x0197 }
            if (r6 != 0) goto L_0x0102
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x0197 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0197 }
            goto L_0x0103
        L_0x0102:
            r13 = r11
        L_0x0103:
            if (r10 == r5) goto L_0x0121
            if (r10 != r4) goto L_0x0108
            goto L_0x0121
        L_0x0108:
            com.google.android.gms.measurement.internal.zzfp r11 = r8.zzc     // Catch:{ all -> 0x0197 }
            zzal(r11)     // Catch:{ all -> 0x0197 }
            boolean r11 = r11.zzt(r9, r12, r3, r13)     // Catch:{ all -> 0x0197 }
            if (r11 != 0) goto L_0x013d
            com.google.android.gms.measurement.internal.zzam r9 = r8.zze     // Catch:{ all -> 0x01a1 }
            zzal(r9)     // Catch:{ all -> 0x01a1 }
        L_0x0118:
            r9.zzx()     // Catch:{ all -> 0x01a1 }
            r8.zzt = r0
            r8.zzae()
            return
        L_0x0121:
            com.google.android.gms.measurement.internal.zzfp r12 = r8.zzc     // Catch:{ all -> 0x0197 }
            zzal(r12)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.internal.measurement.zzfe r12 = r12.zze(r9)     // Catch:{ all -> 0x0197 }
            if (r12 != 0) goto L_0x013d
            com.google.android.gms.measurement.internal.zzfp r12 = r8.zzc     // Catch:{ all -> 0x0197 }
            zzal(r12)     // Catch:{ all -> 0x0197 }
            boolean r11 = r12.zzt(r9, r11, r11, r11)     // Catch:{ all -> 0x0197 }
            if (r11 != 0) goto L_0x013d
            com.google.android.gms.measurement.internal.zzam r9 = r8.zze     // Catch:{ all -> 0x01a1 }
            zzal(r9)     // Catch:{ all -> 0x01a1 }
            goto L_0x0118
        L_0x013d:
            com.google.android.gms.common.util.Clock r11 = r8.zzav()     // Catch:{ all -> 0x0197 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0197 }
            r1.zzL(r11)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzam r11 = r8.zze     // Catch:{ all -> 0x0197 }
            zzal(r11)     // Catch:{ all -> 0x0197 }
            r11.zzD(r1)     // Catch:{ all -> 0x0197 }
            if (r10 != r5) goto L_0x0160
            com.google.android.gms.measurement.internal.zzeo r10 = r8.zzay()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzem r10 = r10.zzl()     // Catch:{ all -> 0x0197 }
            java.lang.String r11 = "Config not found. Using empty config. appId"
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0197 }
            goto L_0x0171
        L_0x0160:
            com.google.android.gms.measurement.internal.zzeo r9 = r8.zzay()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzj()     // Catch:{ all -> 0x0197 }
            java.lang.String r11 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0197 }
            r9.zzc(r11, r10, r2)     // Catch:{ all -> 0x0197 }
        L_0x0171:
            com.google.android.gms.measurement.internal.zzeu r9 = r8.zzd     // Catch:{ all -> 0x0197 }
            zzal(r9)     // Catch:{ all -> 0x0197 }
            boolean r9 = r9.zza()     // Catch:{ all -> 0x0197 }
            if (r9 == 0) goto L_0x0186
            boolean r9 = r8.zzai()     // Catch:{ all -> 0x0197 }
            if (r9 == 0) goto L_0x0186
            r8.zzX()     // Catch:{ all -> 0x0197 }
            goto L_0x0189
        L_0x0186:
            r8.zzag()     // Catch:{ all -> 0x0197 }
        L_0x0189:
            com.google.android.gms.measurement.internal.zzam r9 = r8.zze     // Catch:{ all -> 0x0197 }
            zzal(r9)     // Catch:{ all -> 0x0197 }
            r9.zzC()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzam r9 = r8.zze     // Catch:{ all -> 0x01a1 }
            zzal(r9)     // Catch:{ all -> 0x01a1 }
            goto L_0x0118
        L_0x0197:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzam r10 = r8.zze     // Catch:{ all -> 0x01a1 }
            zzal(r10)     // Catch:{ all -> 0x01a1 }
            r10.zzx()     // Catch:{ all -> 0x01a1 }
            throw r9     // Catch:{ all -> 0x01a1 }
        L_0x01a1:
            r9 = move-exception
            r8.zzt = r0
            r8.zzae()
            goto L_0x01a9
        L_0x01a8:
            throw r9
        L_0x01a9:
            goto L_0x01a8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.zzI(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(boolean z) {
        zzag();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zzK(int i, Throwable th, byte[] bArr, String str) {
        zzam zzam;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzae();
                throw th2;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i == 503 || i == 429) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzam zzam2 = this.zze;
            zzal(zzam2);
            zzam2.zzy(list);
            zzag();
            this.zzu = false;
            zzae();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzag();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzam zzam3 = this.zze;
                zzal(zzam3);
                zzam3.zzw();
                try {
                    for (Long l : list) {
                        try {
                            zzam = this.zze;
                            zzal(zzam);
                            long longValue = l.longValue();
                            zzam.zzg();
                            zzam.zzW();
                            if (zzam.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzam.zzs.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List list2 = this.zzz;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzam zzam4 = this.zze;
                    zzal(zzam4);
                    zzam4.zzC();
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzx();
                    this.zzz = null;
                    zzeu zzeu = this.zzd;
                    zzal(zzeu);
                    if (!zzeu.zza() || !zzai()) {
                        this.zzA = -1;
                        zzag();
                    } else {
                        zzX();
                    }
                    this.zza = 0;
                } catch (Throwable th3) {
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    zzam6.zzx();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzav().elapsedRealtime();
                zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzu = false;
            zzae();
        }
        zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        this.zzk.zzd.zzb(zzav().currentTimeMillis());
        this.zzk.zzb.zzb(zzav().currentTimeMillis());
        zzam zzam22 = this.zze;
        zzal(zzam22);
        zzam22.zzy(list);
        zzag();
        this.zzu = false;
        zzae();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x03ee A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x041a A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x042f A[SYNTHETIC, Splitter:B:133:0x042f] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04d7 A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x04f3 A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0553 A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0142 A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0202 A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0206 A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0260 A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x026f A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027f A[Catch:{ RuntimeException -> 0x0376, all -> 0x0581 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(com.google.android.gms.measurement.internal.zzq r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzfv r8 = r24.zzaz()
            r8.zzg()
            r24.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r8 = zzak(r25)
            if (r8 == 0) goto L_0x058b
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze
            zzal(r8)
            java.lang.String r9 = r2.zza
            com.google.android.gms.measurement.internal.zzh r8 = r8.zzj(r9)
            r9 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r11 = r8.zzy()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x005e
            java.lang.String r11 = r2.zzb
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x005e
            r8.zzL(r9)
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze
            zzal(r11)
            r11.zzD(r8)
            com.google.android.gms.measurement.internal.zzfp r8 = r1.zzc
            zzal(r8)
            java.lang.String r11 = r2.zza
            r8.zzm(r11)
        L_0x005e:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x0066
            r24.zzd(r25)
            return
        L_0x0066:
            long r11 = r2.zzm
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            com.google.android.gms.common.util.Clock r8 = r24.zzav()
            long r11 = r8.currentTimeMillis()
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfy r8 = r1.zzn
            com.google.android.gms.measurement.internal.zzaq r8 = r8.zzg()
            r8.zzd()
            int r8 = r2.zzn
            r15 = 1
            if (r8 == 0) goto L_0x009c
            if (r8 == r15) goto L_0x009c
            com.google.android.gms.measurement.internal.zzeo r13 = r24.zzay()
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzk()
            java.lang.String r14 = r2.zza
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeo.zzn(r14)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.zzc(r9, r14, r8)
            r8 = 0
        L_0x009c:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze
            zzal(r9)
            r9.zzw()
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0581 }
            zzal(r9)     // Catch:{ all -> 0x0581 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0581 }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.zzle r9 = r9.zzp(r10, r13)     // Catch:{ all -> 0x0581 }
            if (r9 == 0) goto L_0x00c5
            java.lang.String r10 = "auto"
            java.lang.String r13 = r9.zzb     // Catch:{ all -> 0x0581 }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x0581 }
            if (r10 == 0) goto L_0x00be
            goto L_0x00c5
        L_0x00be:
            r21 = r3
            r22 = r4
            r3 = 0
            r4 = 1
            goto L_0x0119
        L_0x00c5:
            java.lang.Boolean r10 = r2.zzr     // Catch:{ all -> 0x0581 }
            if (r10 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzlc r10 = new com.google.android.gms.measurement.internal.zzlc     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_npa"
            java.lang.Boolean r13 = r2.zzr     // Catch:{ all -> 0x0581 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0581 }
            if (r15 == r13) goto L_0x00d8
            r19 = 0
            goto L_0x00da
        L_0x00d8:
            r19 = 1
        L_0x00da:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0581 }
            java.lang.String r20 = "auto"
            r21 = r3
            r22 = r4
            r3 = 1
            r13 = r10
            r3 = 0
            r4 = 1
            r15 = r11
            r17 = r19
            r18 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0581 }
            if (r9 == 0) goto L_0x00fd
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0581 }
            java.lang.Long r13 = r10.zzd     // Catch:{ all -> 0x0581 }
            boolean r9 = r9.equals(r13)     // Catch:{ all -> 0x0581 }
            if (r9 != 0) goto L_0x0119
        L_0x00fd:
            r1.zzW(r10, r2)     // Catch:{ all -> 0x0581 }
            goto L_0x0119
        L_0x0101:
            r21 = r3
            r22 = r4
            r3 = 0
            r4 = 1
            if (r9 == 0) goto L_0x0119
            com.google.android.gms.measurement.internal.zzlc r9 = new com.google.android.gms.measurement.internal.zzlc     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_npa"
            r17 = 0
            java.lang.String r18 = "auto"
            r13 = r9
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0581 }
            r1.zzP(r9, r2)     // Catch:{ all -> 0x0581 }
        L_0x0119:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0581 }
            zzal(r9)     // Catch:{ all -> 0x0581 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0581 }
            java.lang.Object r10 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x0581 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)     // Catch:{ all -> 0x0581 }
            if (r9 == 0) goto L_0x0202
            com.google.android.gms.measurement.internal.zzlh r13 = r24.zzv()     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = r2.zzb     // Catch:{ all -> 0x0581 }
            java.lang.String r15 = r9.zzy()     // Catch:{ all -> 0x0581 }
            java.lang.String r10 = r2.zzq     // Catch:{ all -> 0x0581 }
            java.lang.String r3 = r9.zzr()     // Catch:{ all -> 0x0581 }
            boolean r3 = r13.zzam(r14, r15, r10, r3)     // Catch:{ all -> 0x0581 }
            if (r3 == 0) goto L_0x0202
            com.google.android.gms.measurement.internal.zzeo r3 = r24.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzk()     // Catch:{ all -> 0x0581 }
            java.lang.String r10 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r9.zzt()     // Catch:{ all -> 0x0581 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeo.zzn(r13)     // Catch:{ all -> 0x0581 }
            r3.zzb(r10, r13)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0581 }
            zzal(r3)     // Catch:{ all -> 0x0581 }
            java.lang.String r9 = r9.zzt()     // Catch:{ all -> 0x0581 }
            r3.zzW()     // Catch:{ all -> 0x0581 }
            r3.zzg()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ all -> 0x0581 }
            android.database.sqlite.SQLiteDatabase r10 = r3.zzh()     // Catch:{ SQLiteException -> 0x01ea }
            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x01ea }
            r14 = 0
            r13[r14] = r9     // Catch:{ SQLiteException -> 0x01ea }
            java.lang.String r14 = "events"
            int r14 = r10.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            java.lang.String r15 = "user_attributes"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            com.google.android.gms.internal.measurement.zzoh.zzc()     // Catch:{ SQLiteException -> 0x01ea }
            com.google.android.gms.measurement.internal.zzfy r15 = r3.zzs     // Catch:{ SQLiteException -> 0x01ea }
            com.google.android.gms.measurement.internal.zzag r15 = r15.zzf()     // Catch:{ SQLiteException -> 0x01ea }
            com.google.android.gms.measurement.internal.zzea r4 = com.google.android.gms.measurement.internal.zzeb.zzaB     // Catch:{ SQLiteException -> 0x01ea }
            r23 = r6
            r6 = 0
            boolean r4 = r15.zzs(r6, r4)     // Catch:{ SQLiteException -> 0x01e8 }
            if (r4 == 0) goto L_0x01d2
            java.lang.String r4 = "default_event_params"
            int r0 = r10.delete(r4, r0, r13)     // Catch:{ SQLiteException -> 0x01e8 }
            int r14 = r14 + r0
        L_0x01d2:
            if (r14 <= 0) goto L_0x0200
            com.google.android.gms.measurement.internal.zzfy r0 = r3.zzs     // Catch:{ SQLiteException -> 0x01e8 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x01e8 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x01e8 }
            java.lang.String r4 = "Deleted application data. app, records"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01e8 }
            r0.zzc(r4, r9, r6)     // Catch:{ SQLiteException -> 0x01e8 }
            goto L_0x0200
        L_0x01e8:
            r0 = move-exception
            goto L_0x01ed
        L_0x01ea:
            r0 = move-exception
            r23 = r6
        L_0x01ed:
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzs     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzd()     // Catch:{ all -> 0x0581 }
            java.lang.String r4 = "Error deleting application data. appId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeo.zzn(r9)     // Catch:{ all -> 0x0581 }
            r3.zzc(r4, r6, r0)     // Catch:{ all -> 0x0581 }
        L_0x0200:
            r9 = 0
            goto L_0x0204
        L_0x0202:
            r23 = r6
        L_0x0204:
            if (r9 == 0) goto L_0x025b
            long r3 = r9.zzb()     // Catch:{ all -> 0x0581 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x021d
            long r3 = r9.zzb()     // Catch:{ all -> 0x0581 }
            long r13 = r2.zzj     // Catch:{ all -> 0x0581 }
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x021d
            r0 = 1
            goto L_0x021e
        L_0x021d:
            r0 = 0
        L_0x021e:
            java.lang.String r3 = r9.zzw()     // Catch:{ all -> 0x0581 }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0581 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r4 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x0239
            if (r3 == 0) goto L_0x0239
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x0581 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0581 }
            if (r4 != 0) goto L_0x0239
            r15 = 1
            goto L_0x023a
        L_0x0239:
            r15 = 0
        L_0x023a:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x025b
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0581 }
            r0.<init>()     // Catch:{ all -> 0x0581 }
            java.lang.String r4 = "_pv"
            r0.putString(r4, r3)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0581 }
            r15.<init>(r0)     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_au"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x0581 }
            r1.zzE(r3, r2)     // Catch:{ all -> 0x0581 }
        L_0x025b:
            r24.zzd(r25)     // Catch:{ all -> 0x0581 }
            if (r8 != 0) goto L_0x026f
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0581 }
            zzal(r0)     // Catch:{ all -> 0x0581 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0581 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x0581 }
            r15 = 0
            goto L_0x027d
        L_0x026f:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0581 }
            zzal(r0)     // Catch:{ all -> 0x0581 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0581 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x0581 }
            r15 = 1
        L_0x027d:
            if (r0 != 0) goto L_0x0553
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r11 / r3
            r13 = 1
            long r8 = r8 + r13
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_et"
            java.lang.String r6 = "_r"
            java.lang.String r10 = "_c"
            if (r15 != 0) goto L_0x050b
            com.google.android.gms.measurement.internal.zzlc r0 = new com.google.android.gms.measurement.internal.zzlc     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0581 }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0581 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzfv r0 = r24.zzaz()     // Catch:{ all -> 0x0581 }
            r0.zzg()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzfg r0 = r1.zzm     // Catch:{ all -> 0x0581 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0581 }
            r8 = r0
            com.google.android.gms.measurement.internal.zzfg r8 = (com.google.android.gms.measurement.internal.zzfg) r8     // Catch:{ all -> 0x0581 }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x0581 }
            if (r0 == 0) goto L_0x03ab
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x0581 }
            if (r9 == 0) goto L_0x02c1
            goto L_0x03ab
        L_0x02c1:
            com.google.android.gms.measurement.internal.zzfy r9 = r8.zza     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzfv r9 = r9.zzaz()     // Catch:{ all -> 0x0581 }
            r9.zzg()     // Catch:{ all -> 0x0581 }
            boolean r9 = r8.zza()     // Catch:{ all -> 0x0581 }
            if (r9 != 0) goto L_0x02e1
            com.google.android.gms.measurement.internal.zzfy r0 = r8.zza     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzi()     // Catch:{ all -> 0x0581 }
            java.lang.String r5 = "Install Referrer Reporter is not available"
            r0.zza(r5)     // Catch:{ all -> 0x0581 }
            goto L_0x03ba
        L_0x02e1:
            com.google.android.gms.measurement.internal.zzff r9 = new com.google.android.gms.measurement.internal.zzff     // Catch:{ all -> 0x0581 }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzfy r0 = r8.zza     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzfv r0 = r0.zzaz()     // Catch:{ all -> 0x0581 }
            r0.zzg()     // Catch:{ all -> 0x0581 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0581 }
            java.lang.String r13 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r13)     // Catch:{ all -> 0x0581 }
            android.content.ComponentName r13 = new android.content.ComponentName     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r13.<init>(r5, r14)     // Catch:{ all -> 0x0581 }
            r0.setComponent(r13)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzfy r13 = r8.zza     // Catch:{ all -> 0x0581 }
            android.content.Context r13 = r13.zzau()     // Catch:{ all -> 0x0581 }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x0581 }
            if (r13 != 0) goto L_0x031d
            com.google.android.gms.measurement.internal.zzfy r0 = r8.zza     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzm()     // Catch:{ all -> 0x0581 }
            java.lang.String r5 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x0581 }
            goto L_0x03ba
        L_0x031d:
            r14 = 0
            java.util.List r13 = r13.queryIntentServices(r0, r14)     // Catch:{ all -> 0x0581 }
            if (r13 == 0) goto L_0x039b
            boolean r15 = r13.isEmpty()     // Catch:{ all -> 0x0581 }
            if (r15 != 0) goto L_0x039b
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x0581 }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x0581 }
            android.content.pm.ServiceInfo r14 = r13.serviceInfo     // Catch:{ all -> 0x0581 }
            if (r14 == 0) goto L_0x03ba
            android.content.pm.ServiceInfo r14 = r13.serviceInfo     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = r14.packageName     // Catch:{ all -> 0x0581 }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x0581 }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x0581 }
            if (r13 == 0) goto L_0x038b
            boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x0581 }
            if (r5 == 0) goto L_0x038b
            boolean r5 = r8.zza()     // Catch:{ all -> 0x0581 }
            if (r5 == 0) goto L_0x038b
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x0581 }
            r5.<init>(r0)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0376 }
            com.google.android.gms.measurement.internal.zzfy r13 = r8.zza     // Catch:{ RuntimeException -> 0x0376 }
            android.content.Context r13 = r13.zzau()     // Catch:{ RuntimeException -> 0x0376 }
            r14 = 1
            boolean r0 = r0.bindService(r13, r5, r9, r14)     // Catch:{ RuntimeException -> 0x0376 }
            com.google.android.gms.measurement.internal.zzfy r5 = r8.zza     // Catch:{ RuntimeException -> 0x0376 }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()     // Catch:{ RuntimeException -> 0x0376 }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzj()     // Catch:{ RuntimeException -> 0x0376 }
            java.lang.String r9 = "Install Referrer Service is"
            java.lang.String r13 = "available"
            java.lang.String r14 = "not available"
            r15 = 1
            if (r15 == r0) goto L_0x0372
            r13 = r14
        L_0x0372:
            r5.zzb(r9, r13)     // Catch:{ RuntimeException -> 0x0376 }
            goto L_0x03ba
        L_0x0376:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfy r5 = r8.zza     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzd()     // Catch:{ all -> 0x0581 }
            java.lang.String r8 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0581 }
            r5.zzb(r8, r0)     // Catch:{ all -> 0x0581 }
            goto L_0x03ba
        L_0x038b:
            com.google.android.gms.measurement.internal.zzfy r0 = r8.zza     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzk()     // Catch:{ all -> 0x0581 }
            java.lang.String r5 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x0581 }
            goto L_0x03ba
        L_0x039b:
            com.google.android.gms.measurement.internal.zzfy r0 = r8.zza     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzi()     // Catch:{ all -> 0x0581 }
            java.lang.String r5 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r5)     // Catch:{ all -> 0x0581 }
            goto L_0x03ba
        L_0x03ab:
            com.google.android.gms.measurement.internal.zzfy r0 = r8.zza     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzm()     // Catch:{ all -> 0x0581 }
            java.lang.String r5 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r5)     // Catch:{ all -> 0x0581 }
        L_0x03ba:
            com.google.android.gms.measurement.internal.zzfv r0 = r24.zzaz()     // Catch:{ all -> 0x0581 }
            r0.zzg()     // Catch:{ all -> 0x0581 }
            r24.zzB()     // Catch:{ all -> 0x0581 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x0581 }
            r5.<init>()     // Catch:{ all -> 0x0581 }
            r8 = 1
            r5.putLong(r10, r8)     // Catch:{ all -> 0x0581 }
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0581 }
            r8 = 0
            r5.putLong(r7, r8)     // Catch:{ all -> 0x0581 }
            r6 = r23
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0581 }
            r10 = r22
            r5.putLong(r10, r8)     // Catch:{ all -> 0x0581 }
            r15 = r21
            r5.putLong(r15, r8)     // Catch:{ all -> 0x0581 }
            r8 = 1
            r5.putLong(r4, r8)     // Catch:{ all -> 0x0581 }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x0581 }
            if (r0 == 0) goto L_0x03f1
            r5.putLong(r3, r8)     // Catch:{ all -> 0x0581 }
        L_0x03f1:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x0581 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0581 }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0581 }
            zzal(r0)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0581 }
            r0.zzg()     // Catch:{ all -> 0x0581 }
            r0.zzW()     // Catch:{ all -> 0x0581 }
            java.lang.String r4 = "first_open_count"
            long r8 = r0.zzc(r3, r4)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzfy r0 = r1.zzn     // Catch:{ all -> 0x0581 }
            android.content.Context r0 = r0.zzau()     // Catch:{ all -> 0x0581 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0581 }
            if (r0 != 0) goto L_0x042f
            com.google.android.gms.measurement.internal.zzeo r0 = r24.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzd()     // Catch:{ all -> 0x0581 }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ all -> 0x0581 }
            r0.zzb(r4, r3)     // Catch:{ all -> 0x0581 }
        L_0x042b:
            r3 = 0
            goto L_0x04ef
        L_0x042f:
            com.google.android.gms.measurement.internal.zzfy r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x043f }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x043f }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x043f }
            r4 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x043f }
            goto L_0x0452
        L_0x043f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeo r4 = r24.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzd()     // Catch:{ all -> 0x0581 }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ all -> 0x0581 }
            r4.zzc(r13, r14, r0)     // Catch:{ all -> 0x0581 }
            r0 = 0
        L_0x0452:
            if (r0 == 0) goto L_0x04a8
            long r13 = r0.firstInstallTime     // Catch:{ all -> 0x0581 }
            r16 = 0
            int r4 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x04a8
            long r13 = r0.firstInstallTime     // Catch:{ all -> 0x0581 }
            r21 = r3
            long r3 = r0.lastUpdateTime     // Catch:{ all -> 0x0581 }
            int r0 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x048a
            com.google.android.gms.measurement.internal.zzag r0 = r24.zzg()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzea r3 = com.google.android.gms.measurement.internal.zzeb.zzab     // Catch:{ all -> 0x0581 }
            r4 = 0
            boolean r0 = r0.zzs(r4, r3)     // Catch:{ all -> 0x0581 }
            if (r0 == 0) goto L_0x0484
            r13 = 0
            int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x0482
            r13 = 1
            r5.putLong(r7, r13)     // Catch:{ all -> 0x0581 }
            r0 = 0
            r8 = 0
            goto L_0x048c
        L_0x0482:
            r0 = 0
            goto L_0x048c
        L_0x0484:
            r13 = 1
            r5.putLong(r7, r13)     // Catch:{ all -> 0x0581 }
            goto L_0x0482
        L_0x048a:
            r4 = 0
            r0 = 1
        L_0x048c:
            com.google.android.gms.measurement.internal.zzlc r3 = new com.google.android.gms.measurement.internal.zzlc     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_fi"
            r7 = 1
            if (r7 == r0) goto L_0x0496
            r16 = 0
            goto L_0x0498
        L_0x0496:
            r16 = 1
        L_0x0498:
            java.lang.Long r17 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0581 }
            java.lang.String r18 = "auto"
            r13 = r3
            r7 = r15
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0581 }
            r1.zzW(r3, r2)     // Catch:{ all -> 0x0581 }
            goto L_0x04ac
        L_0x04a8:
            r21 = r3
            r7 = r15
            r4 = 0
        L_0x04ac:
            com.google.android.gms.measurement.internal.zzfy r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x04c0 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x04c0 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04c0 }
            r3 = r21
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r3, r13)     // Catch:{ NameNotFoundException -> 0x04be }
            goto L_0x04d5
        L_0x04be:
            r0 = move-exception
            goto L_0x04c3
        L_0x04c0:
            r0 = move-exception
            r3 = r21
        L_0x04c3:
            com.google.android.gms.measurement.internal.zzeo r13 = r24.zzay()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzd()     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ all -> 0x0581 }
            r13.zzc(r14, r3, r0)     // Catch:{ all -> 0x0581 }
            r0 = r4
        L_0x04d5:
            if (r0 == 0) goto L_0x042b
            int r3 = r0.flags     // Catch:{ all -> 0x0581 }
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x04e2
            r3 = 1
            r5.putLong(r10, r3)     // Catch:{ all -> 0x0581 }
        L_0x04e2:
            int r0 = r0.flags     // Catch:{ all -> 0x0581 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x042b
            r3 = 1
            r5.putLong(r7, r3)     // Catch:{ all -> 0x0581 }
            goto L_0x042b
        L_0x04ef:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04f6
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0581 }
        L_0x04f6:
            com.google.android.gms.measurement.internal.zzaw r0 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0581 }
            r15.<init>(r5)     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_f"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x0581 }
            r1.zzG(r0, r2)     // Catch:{ all -> 0x0581 }
            goto L_0x0570
        L_0x050b:
            com.google.android.gms.measurement.internal.zzlc r0 = new com.google.android.gms.measurement.internal.zzlc     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0581 }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0581 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzfv r0 = r24.zzaz()     // Catch:{ all -> 0x0581 }
            r0.zzg()     // Catch:{ all -> 0x0581 }
            r24.zzB()     // Catch:{ all -> 0x0581 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0581 }
            r0.<init>()     // Catch:{ all -> 0x0581 }
            r7 = 1
            r0.putLong(r10, r7)     // Catch:{ all -> 0x0581 }
            r0.putLong(r6, r7)     // Catch:{ all -> 0x0581 }
            r0.putLong(r4, r7)     // Catch:{ all -> 0x0581 }
            boolean r4 = r2.zzp     // Catch:{ all -> 0x0581 }
            if (r4 == 0) goto L_0x053e
            r0.putLong(r3, r7)     // Catch:{ all -> 0x0581 }
        L_0x053e:
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0581 }
            r15.<init>(r0)     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_v"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x0581 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x0581 }
            goto L_0x0570
        L_0x0553:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x0581 }
            if (r0 == 0) goto L_0x0570
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0581 }
            r0.<init>()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0581 }
            r15.<init>(r0)     // Catch:{ all -> 0x0581 }
            java.lang.String r14 = "_cd"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x0581 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x0581 }
        L_0x0570:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0581 }
            zzal(r0)     // Catch:{ all -> 0x0581 }
            r0.zzC()     // Catch:{ all -> 0x0581 }
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze
            zzal(r0)
            r0.zzx()
            return
        L_0x0581:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            throw r0
        L_0x058b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.zzL(com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzM() {
        this.zzr++;
    }

    /* access modifiers changed from: package-private */
    public final void zzN(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzO(zzac, zzac2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzO(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (zzq2.zzh) {
                zzam zzam = this.zze;
                zzal(zzam);
                zzam.zzw();
                try {
                    zzd(zzq2);
                    String str = (String) Preconditions.checkNotNull(zzac.zza);
                    zzam zzam2 = this.zze;
                    zzal(zzam2);
                    zzac zzk2 = zzam2.zzk(str, zzac.zzc.zzb);
                    if (zzk2 != null) {
                        zzay().zzc().zzc("Removing conditional user property", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb));
                        zzam zzam3 = this.zze;
                        zzal(zzam3);
                        zzam3.zza(str, zzac.zzc.zzb);
                        if (zzk2.zze) {
                            zzam zzam4 = this.zze;
                            zzal(zzam4);
                            zzam4.zzA(str, zzac.zzc.zzb);
                        }
                        zzaw zzaw = zzac.zzk;
                        if (zzaw != null) {
                            zzau zzau = zzaw.zzb;
                            zzY((zzaw) Preconditions.checkNotNull(zzv().zzz(str, ((zzaw) Preconditions.checkNotNull(zzac.zzk)).zza, zzau != null ? zzau.zzc() : null, zzk2.zzb, zzac.zzk.zzd, true, true)), zzq2);
                        }
                    } else {
                        zzay().zzk().zzc("Conditional user property doesn't exist", zzeo.zzn(zzac.zza), this.zzn.zzj().zzf(zzac.zzc.zzb));
                    }
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzC();
                } finally {
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    zzam6.zzx();
                }
            } else {
                zzd(zzq2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzP(zzlc zzlc, zzq zzq2) {
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
            } else if (!"_npa".equals(zzlc.zzb) || zzq2.zzr == null) {
                zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzlc.zzb));
                zzam zzam = this.zze;
                zzal(zzam);
                zzam.zzw();
                try {
                    zzd(zzq2);
                    if ("_id".equals(zzlc.zzb)) {
                        zzam zzam2 = this.zze;
                        zzal(zzam2);
                        zzam2.zzA((String) Preconditions.checkNotNull(zzq2.zza), "_lair");
                    }
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    zzam3.zzA((String) Preconditions.checkNotNull(zzq2.zza), zzlc.zzb);
                    zzam zzam4 = this.zze;
                    zzal(zzam4);
                    zzam4.zzC();
                    zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzlc.zzb));
                } finally {
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzx();
                }
            } else {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzW(new zzlc("_npa", zzav().currentTimeMillis(), Long.valueOf(true != zzq2.zzr.booleanValue() ? 0 : 1), "auto"), zzq2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzQ(zzq zzq2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzam zzam = this.zze;
        zzal(zzam);
        String str = (String) Preconditions.checkNotNull(zzq2.zza);
        Preconditions.checkNotEmpty(str);
        zzam.zzg();
        zzam.zzW();
        try {
            SQLiteDatabase zzh2 = zzam.zzh();
            String[] strArr = {str};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete("events", "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzam.zzs.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzam.zzs.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzeo.zzn(str), e);
        }
        if (zzq2.zzh) {
            zzL(zzq2);
        }
    }

    public final void zzR(String str, zzik zzik) {
        zzaz().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zzik != null) {
            this.zzE = str;
            this.zzD = zzik;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzS() {
        zzaz().zzg();
        zzam zzam = this.zze;
        zzal(zzam);
        zzam.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzag();
    }

    /* access modifiers changed from: package-private */
    public final void zzT(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzU(zzac, zzac2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzU(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzb);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
                return;
            }
            zzac zzac2 = new zzac(zzac);
            boolean z = false;
            zzac2.zze = false;
            zzam zzam = this.zze;
            zzal(zzam);
            zzam.zzw();
            try {
                zzam zzam2 = this.zze;
                zzal(zzam2);
                zzac zzk2 = zzam2.zzk((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzc.zzb);
                if (zzk2 != null && !zzk2.zzb.equals(zzac2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzb, zzk2.zzb);
                }
                if (zzk2 != null && zzk2.zze) {
                    zzac2.zzb = zzk2.zzb;
                    zzac2.zzd = zzk2.zzd;
                    zzac2.zzh = zzk2.zzh;
                    zzac2.zzf = zzk2.zzf;
                    zzac2.zzi = zzk2.zzi;
                    zzac2.zze = true;
                    zzlc zzlc = zzac2.zzc;
                    zzac2.zzc = new zzlc(zzlc.zzb, zzk2.zzc.zzc, zzlc.zza(), zzk2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzac2.zzf)) {
                    zzlc zzlc2 = zzac2.zzc;
                    zzac2.zzc = new zzlc(zzlc2.zzb, zzac2.zzd, zzlc2.zza(), zzac2.zzc.zzf);
                    zzac2.zze = true;
                    z = true;
                }
                if (zzac2.zze) {
                    zzlc zzlc3 = zzac2.zzc;
                    zzle zzle = new zzle((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzb, zzlc3.zzb, zzlc3.zzc, Preconditions.checkNotNull(zzlc3.zza()));
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    if (zzam3.zzL(zzle)) {
                        zzay().zzc().zzd("User property updated immediately", zzac2.zza, this.zzn.zzj().zzf(zzle.zzc), zzle.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzeo.zzn(zzac2.zza), this.zzn.zzj().zzf(zzle.zzc), zzle.zze);
                    }
                    if (z && zzac2.zzi != null) {
                        zzY(new zzaw(zzac2.zzi, zzac2.zzd), zzq2);
                    }
                }
                zzam zzam4 = this.zze;
                zzal(zzam4);
                if (zzam4.zzK(zzac2)) {
                    zzay().zzc().zzd("Conditional property added", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzeo.zzn(zzac2.zza), this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                }
                zzam zzam5 = this.zze;
                zzal(zzam5);
                zzam5.zzC();
            } finally {
                zzam zzam6 = this.zze;
                zzal(zzam6);
                zzam6.zzx();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzV(String str, zzai zzai) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzai);
        zzam zzam = this.zze;
        zzal(zzam);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzai);
        zzam.zzg();
        zzam.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzai.zzh());
        try {
            if (zzam.zzh().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                zzam.zzs.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeo.zzn(str));
            }
        } catch (SQLiteException e) {
            zzam.zzs.zzay().zzd().zzc("Error storing consent setting. appId, error", zzeo.zzn(str), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzW(zzlc zzlc, zzq zzq2) {
        long j;
        zzlc zzlc2 = zzlc;
        zzq zzq3 = zzq2;
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            int zzl2 = zzv().zzl(zzlc2.zzb);
            if (zzl2 != 0) {
                zzlh zzv2 = zzv();
                String str = zzlc2.zzb;
                zzg();
                String zzD2 = zzv2.zzD(str, 24, true);
                String str2 = zzlc2.zzb;
                zzv().zzN(this.zzF, zzq3.zza, zzl2, "_ev", zzD2, str2 != null ? str2.length() : 0);
                return;
            }
            int zzd2 = zzv().zzd(zzlc2.zzb, zzlc.zza());
            if (zzd2 != 0) {
                zzlh zzv3 = zzv();
                String str3 = zzlc2.zzb;
                zzg();
                String zzD3 = zzv3.zzD(str3, 24, true);
                Object zza2 = zzlc.zza();
                zzv().zzN(this.zzF, zzq3.zza, zzd2, "_ev", zzD3, (zza2 == null || (!(zza2 instanceof String) && !(zza2 instanceof CharSequence))) ? 0 : zza2.toString().length());
                return;
            }
            Object zzB2 = zzv().zzB(zzlc2.zzb, zzlc.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzlc2.zzb)) {
                    long j2 = zzlc2.zzc;
                    String str4 = zzlc2.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzq3.zza);
                    zzam zzam = this.zze;
                    zzal(zzam);
                    zzle zzp2 = zzam.zzp(str5, "_sno");
                    if (zzp2 != null) {
                        Object obj = zzp2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzW(new zzlc("_sno", j2, Long.valueOf(j + 1), str4), zzq3);
                        }
                    }
                    if (zzp2 != null) {
                        zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzp2.zze);
                    }
                    zzam zzam2 = this.zze;
                    zzal(zzam2);
                    zzas zzn2 = zzam2.zzn(str5, "_s");
                    if (zzn2 != null) {
                        j = zzn2.zzc;
                        zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                    zzW(new zzlc("_sno", j2, Long.valueOf(j + 1), str4), zzq3);
                }
                zzle zzle = new zzle((String) Preconditions.checkNotNull(zzq3.zza), (String) Preconditions.checkNotNull(zzlc2.zzf), zzlc2.zzb, zzlc2.zzc, zzB2);
                zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzle.zzc), zzB2);
                zzam zzam3 = this.zze;
                zzal(zzam3);
                zzam3.zzw();
                try {
                    if ("_id".equals(zzle.zzc)) {
                        zzam zzam4 = this.zze;
                        zzal(zzam4);
                        zzle zzp3 = zzam4.zzp(zzq3.zza, "_id");
                        if (zzp3 != null && !zzle.zze.equals(zzp3.zze)) {
                            zzam zzam5 = this.zze;
                            zzal(zzam5);
                            zzam5.zzA(zzq3.zza, "_lair");
                        }
                    }
                    zzd(zzq3);
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    boolean zzL = zzam6.zzL(zzle);
                    zzam zzam7 = this.zze;
                    zzal(zzam7);
                    zzam7.zzC();
                    if (!zzL) {
                        zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzle.zzc), zzle.zze);
                        zzv().zzN(this.zzF, zzq3.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzam zzam8 = this.zze;
                    zzal(zzam8);
                    zzam8.zzx();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:212|213) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0217, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0218, code lost:
        r8.zzs.zzay().zzd().zzc("Failed to merge queued bundle. appId", com.google.android.gms.measurement.internal.zzeo.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:?, code lost:
        zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzeo.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x054a, code lost:
        if (r11 != null) goto L_0x054c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0571, code lost:
        if (r11 != null) goto L_0x054c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0574, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0108, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0112, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012a, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r1.zzA = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:212:0x04ee */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029c A[SYNTHETIC, Splitter:B:146:0x029c] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02a5 A[Catch:{ all -> 0x0130, all -> 0x0596 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0505 A[Catch:{ all -> 0x0130, all -> 0x0596 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0592 A[SYNTHETIC, Splitter:B:254:0x0592] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0134 A[Catch:{ all -> 0x0130, all -> 0x0596 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:143:0x0283=Splitter:B:143:0x0283, B:244:0x0575=Splitter:B:244:0x0575, B:48:0x010a=Splitter:B:48:0x010a, B:57:0x011b=Splitter:B:57:0x011b, B:227:0x054c=Splitter:B:227:0x054c, B:60:0x012d=Splitter:B:60:0x012d, B:203:0x046f=Splitter:B:203:0x046f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzfv r0 = r22.zzaz()
            r0.zzg()
            r22.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzfy r0 = r1.zzn     // Catch:{ all -> 0x0596 }
            r0.zzaw()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzfy r0 = r1.zzn     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzjs r0 = r0.zzt()     // Catch:{ all -> 0x0596 }
            java.lang.Boolean r0 = r0.zzj()     // Catch:{ all -> 0x0596 }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzeo r0 = r22.zzay()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzk()     // Catch:{ all -> 0x0596 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x0596 }
            r1.zzv = r3
        L_0x0030:
            r22.zzae()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0596 }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzeo r0 = r22.zzay()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzd()     // Catch:{ all -> 0x0596 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x0596 }
            r1.zzv = r3
            goto L_0x0030
        L_0x004a:
            long r4 = r1.zza     // Catch:{ all -> 0x0596 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r22.zzag()     // Catch:{ all -> 0x0596 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0058:
            com.google.android.gms.measurement.internal.zzfv r0 = r22.zzaz()     // Catch:{ all -> 0x0596 }
            r0.zzg()     // Catch:{ all -> 0x0596 }
            java.util.List r0 = r1.zzy     // Catch:{ all -> 0x0596 }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzeo r0 = r22.zzay()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzj()     // Catch:{ all -> 0x0596 }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x0596 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0073:
            com.google.android.gms.measurement.internal.zzeu r0 = r1.zzd     // Catch:{ all -> 0x0596 }
            zzal(r0)     // Catch:{ all -> 0x0596 }
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0596 }
            if (r0 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzeo r0 = r22.zzay()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzj()     // Catch:{ all -> 0x0596 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x0596 }
            r22.zzag()     // Catch:{ all -> 0x0596 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0091:
            com.google.android.gms.common.util.Clock r0 = r22.zzav()     // Catch:{ all -> 0x0596 }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzea r8 = com.google.android.gms.measurement.internal.zzeb.zzP     // Catch:{ all -> 0x0596 }
            r9 = 0
            int r0 = r0.zze(r9, r8)     // Catch:{ all -> 0x0596 }
            r22.zzg()     // Catch:{ all -> 0x0596 }
            long r10 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0596 }
            long r10 = r4 - r10
            r8 = 0
        L_0x00ae:
            if (r8 >= r0) goto L_0x00b9
            boolean r12 = r1.zzah(r9, r10)     // Catch:{ all -> 0x0596 }
            if (r12 == 0) goto L_0x00b9
            int r8 = r8 + 1
            goto L_0x00ae
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzju r0 = r1.zzk     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzc     // Catch:{ all -> 0x0596 }
            long r10 = r0.zza()     // Catch:{ all -> 0x0596 }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzeo r0 = r22.zzay()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzc()     // Catch:{ all -> 0x0596 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0596 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0596 }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x0596 }
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0596 }
            zzal(r0)     // Catch:{ all -> 0x0596 }
            java.lang.String r6 = r0.zzr()     // Catch:{ all -> 0x0596 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0596 }
            r7 = -1
            if (r0 != 0) goto L_0x0509
            long r10 = r1.zzA     // Catch:{ all -> 0x0596 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0138
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0596 }
            zzal(r10)     // Catch:{ all -> 0x0596 }
            android.database.sqlite.SQLiteDatabase r0 = r10.zzh()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0115 }
            if (r0 != 0) goto L_0x010e
            if (r11 == 0) goto L_0x012d
        L_0x010a:
            r11.close()     // Catch:{ all -> 0x0596 }
            goto L_0x012d
        L_0x010e:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0115 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x0115:
            r0 = move-exception
            goto L_0x011b
        L_0x0117:
            r0 = move-exception
            goto L_0x0132
        L_0x0119:
            r0 = move-exception
            r11 = r9
        L_0x011b:
            com.google.android.gms.measurement.internal.zzfy r10 = r10.zzs     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzeo r10 = r10.zzay()     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzem r10 = r10.zzd()     // Catch:{ all -> 0x0130 }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x0130 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x012d:
            r1.zzA = r7     // Catch:{ all -> 0x0596 }
            goto L_0x0138
        L_0x0130:
            r0 = move-exception
            r9 = r11
        L_0x0132:
            if (r9 == 0) goto L_0x0137
            r9.close()     // Catch:{ all -> 0x0596 }
        L_0x0137:
            throw r0     // Catch:{ all -> 0x0596 }
        L_0x0138:
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzea r7 = com.google.android.gms.measurement.internal.zzeb.zzf     // Catch:{ all -> 0x0596 }
            int r0 = r0.zze(r6, r7)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzag r7 = r22.zzg()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzea r8 = com.google.android.gms.measurement.internal.zzeb.zzg     // Catch:{ all -> 0x0596 }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x0596 }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0596 }
            zzal(r8)     // Catch:{ all -> 0x0596 }
            r8.zzg()     // Catch:{ all -> 0x0596 }
            r8.zzW()     // Catch:{ all -> 0x0596 }
            if (r0 <= 0) goto L_0x015f
            r10 = 1
            goto L_0x0160
        L_0x015f:
            r10 = 0
        L_0x0160:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0596 }
            if (r7 <= 0) goto L_0x0167
            r10 = 1
            goto L_0x0168
        L_0x0167:
            r10 = 0
        L_0x0168:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x0596 }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String r12 = "rowid"
            java.lang.String r13 = "data"
            java.lang.String r14 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r12, r13, r14}     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 != 0) goto L_0x01a5
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0277 }
            if (r11 == 0) goto L_0x01a1
            r11.close()     // Catch:{ all -> 0x0596 }
        L_0x01a1:
            r20 = r4
            goto L_0x029f
        L_0x01a5:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0277 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0277 }
            r13 = 0
        L_0x01ab:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0277 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzkz r2 = r8.zzf     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzlb r2 = r2.zzi     // Catch:{ IOException -> 0x0248 }
            zzal(r2)     // Catch:{ IOException -> 0x0248 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0233 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x0233 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0233 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x0233 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0233 }
            r3.<init>()     // Catch:{ IOException -> 0x0233 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0233 }
            r20 = r4
        L_0x01cf:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x0231 }
            if (r4 > 0) goto L_0x022c
            r0.close()     // Catch:{ IOException -> 0x0231 }
            r9.close()     // Catch:{ IOException -> 0x0231 }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x0231 }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0275 }
            if (r2 != 0) goto L_0x01eb
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x0275 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01eb
            goto L_0x026e
        L_0x01eb:
            com.google.android.gms.internal.measurement.zzgb r2 = com.google.android.gms.internal.measurement.zzgc.zzt()     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzlk r2 = com.google.android.gms.measurement.internal.zzlb.zzl(r2, r0)     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzgb r2 = (com.google.android.gms.internal.measurement.zzgb) r2     // Catch:{ IOException -> 0x0217 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x0275 }
            if (r4 != 0) goto L_0x0203
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzaf(r4)     // Catch:{ SQLiteException -> 0x0275 }
        L_0x0203:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0275 }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzke r0 = r2.zzaE()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.internal.measurement.zzgc r0 = (com.google.android.gms.internal.measurement.zzgc) r0     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0275 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0275 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0275 }
            goto L_0x025e
        L_0x0217:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfy r2 = r8.zzs     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r6)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0275 }
            goto L_0x025e
        L_0x022c:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0231 }
            goto L_0x01cf
        L_0x0231:
            r0 = move-exception
            goto L_0x0236
        L_0x0233:
            r0 = move-exception
            r20 = r4
        L_0x0236:
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ IOException -> 0x0246 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0246 }
            throw r0     // Catch:{ IOException -> 0x0246 }
        L_0x0246:
            r0 = move-exception
            goto L_0x024b
        L_0x0248:
            r0 = move-exception
            r20 = r4
        L_0x024b:
            com.google.android.gms.measurement.internal.zzfy r2 = r8.zzs     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r6)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0275 }
        L_0x025e:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0275 }
            if (r0 == 0) goto L_0x026e
            if (r13 <= r7) goto L_0x0267
            goto L_0x026e
        L_0x0267:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01ab
        L_0x026e:
            if (r11 == 0) goto L_0x0273
            r11.close()     // Catch:{ all -> 0x0596 }
        L_0x0273:
            r0 = r12
            goto L_0x029f
        L_0x0275:
            r0 = move-exception
            goto L_0x0283
        L_0x0277:
            r0 = move-exception
            r20 = r4
            goto L_0x0283
        L_0x027b:
            r0 = move-exception
            r9 = 0
            goto L_0x0503
        L_0x027f:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x0283:
            com.google.android.gms.measurement.internal.zzfy r2 = r8.zzs     // Catch:{ all -> 0x0501 }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x0501 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0501 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r6)     // Catch:{ all -> 0x0501 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0501 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0501 }
            if (r11 == 0) goto L_0x029f
            r11.close()     // Catch:{ all -> 0x0596 }
        L_0x029f:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0596 }
            if (r2 != 0) goto L_0x0589
            com.google.android.gms.measurement.internal.zzai r2 = r1.zzh(r6)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzah r3 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0596 }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x0596 }
            if (r2 == 0) goto L_0x0306
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0596 }
        L_0x02b5:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0596 }
            if (r3 == 0) goto L_0x02d4
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0596 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0596 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzgc r3 = (com.google.android.gms.internal.measurement.zzgc) r3     // Catch:{ all -> 0x0596 }
            java.lang.String r4 = r3.zzJ()     // Catch:{ all -> 0x0596 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0596 }
            if (r4 != 0) goto L_0x02b5
            java.lang.String r2 = r3.zzJ()     // Catch:{ all -> 0x0596 }
            goto L_0x02d5
        L_0x02d4:
            r2 = 0
        L_0x02d5:
            if (r2 == 0) goto L_0x0306
            r3 = 0
        L_0x02d8:
            int r4 = r0.size()     // Catch:{ all -> 0x0596 }
            if (r3 >= r4) goto L_0x0306
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0596 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0596 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzgc r4 = (com.google.android.gms.internal.measurement.zzgc) r4     // Catch:{ all -> 0x0596 }
            java.lang.String r5 = r4.zzJ()     // Catch:{ all -> 0x0596 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0596 }
            if (r5 == 0) goto L_0x02f3
            goto L_0x0303
        L_0x02f3:
            java.lang.String r4 = r4.zzJ()     // Catch:{ all -> 0x0596 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0596 }
            if (r4 != 0) goto L_0x0303
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x0596 }
            goto L_0x0306
        L_0x0303:
            int r3 = r3 + 1
            goto L_0x02d8
        L_0x0306:
            com.google.android.gms.internal.measurement.zzfz r2 = com.google.android.gms.internal.measurement.zzga.zza()     // Catch:{ all -> 0x0596 }
            int r3 = r0.size()     // Catch:{ all -> 0x0596 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0596 }
            int r5 = r0.size()     // Catch:{ all -> 0x0596 }
            r4.<init>(r5)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzag r5 = r22.zzg()     // Catch:{ all -> 0x0596 }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x0596 }
            if (r5 == 0) goto L_0x032f
            com.google.android.gms.measurement.internal.zzai r5 = r1.zzh(r6)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzah r7 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0596 }
            boolean r5 = r5.zzi(r7)     // Catch:{ all -> 0x0596 }
            if (r5 == 0) goto L_0x032f
            r5 = 1
            goto L_0x0330
        L_0x032f:
            r5 = 0
        L_0x0330:
            com.google.android.gms.measurement.internal.zzai r7 = r1.zzh(r6)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzah r8 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0596 }
            boolean r7 = r7.zzi(r8)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r6)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x0596 }
            boolean r8 = r8.zzi(r9)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzoz.zzc()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzea r10 = com.google.android.gms.measurement.internal.zzeb.zzar     // Catch:{ all -> 0x0596 }
            r11 = 0
            boolean r9 = r9.zzs(r11, r10)     // Catch:{ all -> 0x0596 }
            r10 = 0
        L_0x0353:
            if (r10 >= r3) goto L_0x03d1
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x0596 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0596 }
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzka r11 = r11.zzby()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzgb r11 = (com.google.android.gms.internal.measurement.zzgb) r11     // Catch:{ all -> 0x0596 }
            java.lang.Object r12 = r0.get(r10)     // Catch:{ all -> 0x0596 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x0596 }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x0596 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0596 }
            r4.add(r12)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzag r12 = r22.zzg()     // Catch:{ all -> 0x0596 }
            r12.zzh()     // Catch:{ all -> 0x0596 }
            r12 = 73000(0x11d28, double:3.6067E-319)
            r11.zzal(r12)     // Catch:{ all -> 0x0596 }
            r12 = r20
            r11.zzak(r12)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzfy r14 = r1.zzn     // Catch:{ all -> 0x0596 }
            r14.zzaw()     // Catch:{ all -> 0x0596 }
            r14 = 0
            r11.zzag(r14)     // Catch:{ all -> 0x0596 }
            if (r5 != 0) goto L_0x0392
            r11.zzq()     // Catch:{ all -> 0x0596 }
        L_0x0392:
            if (r7 != 0) goto L_0x039a
            r11.zzx()     // Catch:{ all -> 0x0596 }
            r11.zzt()     // Catch:{ all -> 0x0596 }
        L_0x039a:
            if (r8 != 0) goto L_0x039f
            r11.zzn()     // Catch:{ all -> 0x0596 }
        L_0x039f:
            r1.zzC(r6, r11)     // Catch:{ all -> 0x0596 }
            if (r9 != 0) goto L_0x03a7
            r11.zzy()     // Catch:{ all -> 0x0596 }
        L_0x03a7:
            com.google.android.gms.measurement.internal.zzag r14 = r22.zzg()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzea r15 = com.google.android.gms.measurement.internal.zzeb.zzT     // Catch:{ all -> 0x0596 }
            boolean r14 = r14.zzs(r6, r15)     // Catch:{ all -> 0x0596 }
            if (r14 == 0) goto L_0x03c9
            com.google.android.gms.internal.measurement.zzke r14 = r11.zzaE()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzgc r14 = (com.google.android.gms.internal.measurement.zzgc) r14     // Catch:{ all -> 0x0596 }
            byte[] r14 = r14.zzbv()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzlb r15 = r1.zzi     // Catch:{ all -> 0x0596 }
            zzal(r15)     // Catch:{ all -> 0x0596 }
            long r14 = r15.zzd(r14)     // Catch:{ all -> 0x0596 }
            r11.zzJ(r14)     // Catch:{ all -> 0x0596 }
        L_0x03c9:
            r2.zza(r11)     // Catch:{ all -> 0x0596 }
            int r10 = r10 + 1
            r20 = r12
            goto L_0x0353
        L_0x03d1:
            r12 = r20
            com.google.android.gms.measurement.internal.zzeo r0 = r22.zzay()     // Catch:{ all -> 0x0596 }
            java.lang.String r0 = r0.zzq()     // Catch:{ all -> 0x0596 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0596 }
            if (r0 == 0) goto L_0x03f3
            com.google.android.gms.measurement.internal.zzlb r0 = r1.zzi     // Catch:{ all -> 0x0596 }
            zzal(r0)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzke r5 = r2.zzaE()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzga r5 = (com.google.android.gms.internal.measurement.zzga) r5     // Catch:{ all -> 0x0596 }
            java.lang.String r0 = r0.zzm(r5)     // Catch:{ all -> 0x0596 }
            r11 = r0
            goto L_0x03f4
        L_0x03f3:
            r11 = 0
        L_0x03f4:
            com.google.android.gms.measurement.internal.zzlb r0 = r1.zzi     // Catch:{ all -> 0x0596 }
            zzal(r0)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzke r0 = r2.zzaE()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzga r0 = (com.google.android.gms.internal.measurement.zzga) r0     // Catch:{ all -> 0x0596 }
            byte[] r14 = r0.zzbv()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzko r0 = r1.zzl     // Catch:{ all -> 0x0596 }
            com.google.android.gms.internal.measurement.zzow.zzc()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzfy r5 = r0.zzs     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzag r5 = r5.zzf()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzea r7 = com.google.android.gms.measurement.internal.zzeb.zzan     // Catch:{ all -> 0x0596 }
            boolean r5 = r5.zzs(r6, r7)     // Catch:{ all -> 0x0596 }
            if (r5 == 0) goto L_0x0466
            com.google.android.gms.measurement.internal.zzkz r0 = r0.zzf     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzfp r0 = r0.zzc     // Catch:{ all -> 0x0596 }
            zzal(r0)     // Catch:{ all -> 0x0596 }
            java.lang.String r0 = r0.zzi(r6)     // Catch:{ all -> 0x0596 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0596 }
            if (r5 != 0) goto L_0x045c
            com.google.android.gms.measurement.internal.zzea r5 = com.google.android.gms.measurement.internal.zzeb.zzp     // Catch:{ all -> 0x0596 }
            r7 = 0
            java.lang.Object r5 = r5.zza(r7)     // Catch:{ all -> 0x0596 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0596 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x0596 }
            android.net.Uri$Builder r7 = r5.buildUpon()     // Catch:{ all -> 0x0596 }
            java.lang.String r5 = r5.getAuthority()     // Catch:{ all -> 0x0596 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0596 }
            r8.<init>()     // Catch:{ all -> 0x0596 }
            r8.append(r0)     // Catch:{ all -> 0x0596 }
            java.lang.String r0 = "."
            r8.append(r0)     // Catch:{ all -> 0x0596 }
            r8.append(r5)     // Catch:{ all -> 0x0596 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0596 }
            r7.authority(r0)     // Catch:{ all -> 0x0596 }
            android.net.Uri r0 = r7.build()     // Catch:{ all -> 0x0596 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0596 }
            goto L_0x046f
        L_0x045c:
            com.google.android.gms.measurement.internal.zzea r0 = com.google.android.gms.measurement.internal.zzeb.zzp     // Catch:{ all -> 0x0596 }
            r5 = 0
            java.lang.Object r0 = r0.zza(r5)     // Catch:{ all -> 0x0596 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0596 }
            goto L_0x046f
        L_0x0466:
            com.google.android.gms.measurement.internal.zzea r0 = com.google.android.gms.measurement.internal.zzeb.zzp     // Catch:{ all -> 0x0596 }
            r5 = 0
            java.lang.Object r0 = r0.zza(r5)     // Catch:{ all -> 0x0596 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0596 }
        L_0x046f:
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x04ee }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x04ee }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x04ee }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ MalformedURLException -> 0x04ee }
            java.util.List r7 = r1.zzy     // Catch:{ MalformedURLException -> 0x04ee }
            if (r7 == 0) goto L_0x048f
            com.google.android.gms.measurement.internal.zzeo r4 = r22.zzay()     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x04ee }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.zza(r7)     // Catch:{ MalformedURLException -> 0x04ee }
            goto L_0x0496
        L_0x048f:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x04ee }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x04ee }
            r1.zzy = r7     // Catch:{ MalformedURLException -> 0x04ee }
        L_0x0496:
            com.google.android.gms.measurement.internal.zzju r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x04ee }
            r4.zzb(r12)     // Catch:{ MalformedURLException -> 0x04ee }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x04aa
            r3 = 0
            com.google.android.gms.internal.measurement.zzgc r2 = r2.zzb(r3)     // Catch:{ MalformedURLException -> 0x04ee }
            java.lang.String r4 = r2.zzx()     // Catch:{ MalformedURLException -> 0x04ee }
        L_0x04aa:
            com.google.android.gms.measurement.internal.zzeo r2 = r22.zzay()     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x04ee }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x04ee }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x04ee }
            r2.zzd(r3, r4, r7, r11)     // Catch:{ MalformedURLException -> 0x04ee }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.measurement.internal.zzeu r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x04ee }
            zzal(r11)     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.measurement.internal.zzkq r2 = new com.google.android.gms.measurement.internal.zzkq     // Catch:{ MalformedURLException -> 0x04ee }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x04ee }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x04ee }
            r11.zzW()     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.measurement.internal.zzfy r3 = r11.zzs     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.measurement.internal.zzfv r3 = r3.zzaz()     // Catch:{ MalformedURLException -> 0x04ee }
            com.google.android.gms.measurement.internal.zzet r4 = new com.google.android.gms.measurement.internal.zzet     // Catch:{ MalformedURLException -> 0x04ee }
            r15 = 0
            r10 = r4
            r12 = r6
            r13 = r5
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x04ee }
            r3.zzo(r4)     // Catch:{ MalformedURLException -> 0x04ee }
            goto L_0x0589
        L_0x04ee:
            com.google.android.gms.measurement.internal.zzeo r2 = r22.zzay()     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0596 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r6)     // Catch:{ all -> 0x0596 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0596 }
            goto L_0x0589
        L_0x0501:
            r0 = move-exception
            r9 = r11
        L_0x0503:
            if (r9 == 0) goto L_0x0508
            r9.close()     // Catch:{ all -> 0x0596 }
        L_0x0508:
            throw r0     // Catch:{ all -> 0x0596 }
        L_0x0509:
            r12 = r4
            r5 = r9
            r1.zzA = r7     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0596 }
            zzal(r2)     // Catch:{ all -> 0x0596 }
            r22.zzg()     // Catch:{ all -> 0x0596 }
            long r3 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0596 }
            long r3 = r12 - r3
            r2.zzg()     // Catch:{ all -> 0x0596 }
            r2.zzW()     // Catch:{ all -> 0x0596 }
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x0560, all -> 0x055d }
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0560, all -> 0x055d }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x0560, all -> 0x055d }
            r4 = 0
            r6[r4] = r3     // Catch:{ SQLiteException -> 0x0560, all -> 0x055d }
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r3, r6)     // Catch:{ SQLiteException -> 0x0560, all -> 0x055d }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x055b }
            if (r0 != 0) goto L_0x0550
            com.google.android.gms.measurement.internal.zzfy r0 = r2.zzs     // Catch:{ SQLiteException -> 0x055b }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x055b }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x055b }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r0.zza(r3)     // Catch:{ SQLiteException -> 0x055b }
            if (r11 == 0) goto L_0x0574
        L_0x054c:
            r11.close()     // Catch:{ all -> 0x0596 }
            goto L_0x0574
        L_0x0550:
            r3 = 0
            java.lang.String r9 = r11.getString(r3)     // Catch:{ SQLiteException -> 0x055b }
            if (r11 == 0) goto L_0x0575
            r11.close()     // Catch:{ all -> 0x0596 }
            goto L_0x0575
        L_0x055b:
            r0 = move-exception
            goto L_0x0562
        L_0x055d:
            r0 = move-exception
            r9 = r5
            goto L_0x0590
        L_0x0560:
            r0 = move-exception
            r11 = r5
        L_0x0562:
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch:{ all -> 0x058e }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x058e }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x058e }
            java.lang.String r3 = "Error selecting expired configs"
            r2.zzb(r3, r0)     // Catch:{ all -> 0x058e }
            if (r11 == 0) goto L_0x0574
            goto L_0x054c
        L_0x0574:
            r9 = r5
        L_0x0575:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0596 }
            if (r0 != 0) goto L_0x0589
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0596 }
            zzal(r0)     // Catch:{ all -> 0x0596 }
            com.google.android.gms.measurement.internal.zzh r0 = r0.zzj(r9)     // Catch:{ all -> 0x0596 }
            if (r0 == 0) goto L_0x0589
            r1.zzD(r0)     // Catch:{ all -> 0x0596 }
        L_0x0589:
            r2 = 0
            r1.zzv = r2
            goto L_0x0030
        L_0x058e:
            r0 = move-exception
            r9 = r11
        L_0x0590:
            if (r9 == 0) goto L_0x0595
            r9.close()     // Catch:{ all -> 0x0596 }
        L_0x0595:
            throw r0     // Catch:{ all -> 0x0596 }
        L_0x0596:
            r0 = move-exception
            r2 = 0
            r1.zzv = r2
            r22.zzae()
            goto L_0x059f
        L_0x059e:
            throw r0
        L_0x059f:
            goto L_0x059e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.zzX():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x073e, code lost:
        if (r14.isEmpty() != false) goto L_0x0740;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0935, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x030f A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0312 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0376 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0506 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0545 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x05be A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x060b A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0618 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0625 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x064f A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0660 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x06a1 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x06bc A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0743 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0789 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x07d3 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x07ec A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x087a A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0899 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x092b A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x09d6 A[Catch:{ SQLiteException -> 0x09f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x09ec  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0937 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0155 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016b A[SYNTHETIC, Splitter:B:46:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01e9 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02c5 A[Catch:{ NumberFormatException -> 0x0728, all -> 0x0a6d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(com.google.android.gms.measurement.internal.zzaw r35, com.google.android.gms.measurement.internal.zzq r36) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzfv r10 = r34.zzaz()
            r10.zzg()
            r34.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzlb r11 = r1.zzi
            zzal(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzlb.zzA(r35, r36)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0a78
            com.google.android.gms.measurement.internal.zzfp r11 = r1.zzc
            zzal(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzr(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzeo r3 = r34.zzay()
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)
            com.google.android.gms.measurement.internal.zzfy r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfp r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfp r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzs(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzlh r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzlg r12 = r1.zzF
            r14 = 11
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            com.google.android.gms.measurement.internal.zzh r2 = r2.zzj(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzl()
            long r5 = r2.zzc()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r34.zzav()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r34.zzg()
            com.google.android.gms.measurement.internal.zzea r5 = com.google.android.gms.measurement.internal.zzeb.zzy
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzeo r3 = r34.zzay()
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzD(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzep r2 = com.google.android.gms.measurement.internal.zzep.zzb(r35)
            com.google.android.gms.measurement.internal.zzlh r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzag r12 = r34.zzg()
            int r12 = r12.zzd(r10)
            r11.zzM(r2, r12)
            com.google.android.gms.measurement.internal.zzaw r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeo r11 = r34.zzay()
            java.lang.String r11 = r11.zzq()
            r13 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r13)
            if (r11 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzeo r11 = r34.zzay()
            com.google.android.gms.measurement.internal.zzem r11 = r11.zzj()
            com.google.android.gms.measurement.internal.zzfy r12 = r1.zzn
            com.google.android.gms.measurement.internal.zzej r12 = r12.zzj()
            java.lang.String r12 = r12.zzc(r2)
            java.lang.String r13 = "Logging event"
            r11.zzb(r13, r12)
        L_0x011c:
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze
            zzal(r11)
            r11.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x0a6d }
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0a6d }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0a6d }
            java.lang.String r12 = "refund"
            r28 = r8
            if (r11 != 0) goto L_0x014a
            java.lang.String r9 = "purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a6d }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a6d }
            if (r9 != 0) goto L_0x014a
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a6d }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a6d }
            if (r9 == 0) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r9 = 0
            goto L_0x014b
        L_0x014a:
            r9 = 1
        L_0x014b:
            java.lang.String r11 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0a6d }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0a6d }
            if (r11 != 0) goto L_0x015f
            if (r9 == 0) goto L_0x0159
            r9 = 1
            goto L_0x015f
        L_0x0159:
            r33 = r4
            r8 = r15
        L_0x015c:
            r4 = 2
            goto L_0x02fc
        L_0x015f:
            com.google.android.gms.measurement.internal.zzau r11 = r2.zzb     // Catch:{ all -> 0x0a6d }
            java.lang.String r13 = "currency"
            java.lang.String r11 = r11.zzg(r13)     // Catch:{ all -> 0x0a6d }
            java.lang.String r13 = "value"
            if (r9 == 0) goto L_0x01d7
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0a6d }
            java.lang.Double r9 = r9.zzd(r13)     // Catch:{ all -> 0x0a6d }
            double r17 = r9.doubleValue()     // Catch:{ all -> 0x0a6d }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r9 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x0195
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0a6d }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x0a6d }
            r21 = r15
            long r14 = r9.longValue()     // Catch:{ all -> 0x0a6d }
            double r13 = (double) r14
            java.lang.Double.isNaN(r13)
            double r17 = r13 * r19
            goto L_0x0197
        L_0x0195:
            r21 = r15
        L_0x0197:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x01b1
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x01b1
            long r13 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a6d }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a6d }
            if (r9 == 0) goto L_0x01e3
            long r13 = -r13
            goto L_0x01e3
        L_0x01b1:
            com.google.android.gms.measurement.internal.zzeo r2 = r34.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzk()     // Catch:{ all -> 0x0a6d }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.Double r5 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0a6d }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r2)     // Catch:{ all -> 0x0a6d }
            r2.zzC()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x01d7:
            r21 = r15
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0a6d }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x0a6d }
            long r13 = r9.longValue()     // Catch:{ all -> 0x0a6d }
        L_0x01e3:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0a6d }
            if (r9 != 0) goto L_0x02f6
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = r11.toUpperCase(r9)     // Catch:{ all -> 0x0a6d }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r9.matches(r11)     // Catch:{ all -> 0x0a6d }
            if (r11 == 0) goto L_0x02f6
            java.lang.String r11 = "_ltv_"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = r11.concat(r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r11)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzle r11 = r11.zzp(r10, r9)     // Catch:{ all -> 0x0a6d }
            if (r11 == 0) goto L_0x0241
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0a6d }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a6d }
            if (r12 != 0) goto L_0x0213
            goto L_0x0241
        L_0x0213:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0a6d }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzle r18 = new com.google.android.gms.measurement.internal.zzle     // Catch:{ all -> 0x0a6d }
            java.lang.String r15 = r2.zzc     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.util.Clock r17 = r34.zzav()     // Catch:{ all -> 0x0a6d }
            long r19 = r17.currentTimeMillis()     // Catch:{ all -> 0x0a6d }
            long r11 = r11 + r13
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a6d }
            r11 = r18
            r12 = r10
            r14 = 0
            r13 = r15
            r8 = 0
            r15 = 0
            r14 = r9
            r9 = r21
            r15 = r19
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a6d }
            r33 = r4
            r8 = r9
            r9 = r18
            r4 = 2
            goto L_0x02ba
        L_0x0241:
            r15 = r21
            r8 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r11)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzag r12 = r34.zzg()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzea r8 = com.google.android.gms.measurement.internal.zzeb.zzD     // Catch:{ all -> 0x0a6d }
            int r8 = r12.zze(r10, r8)     // Catch:{ all -> 0x0a6d }
            int r8 = r8 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a6d }
            r11.zzg()     // Catch:{ all -> 0x0a6d }
            r11.zzW()     // Catch:{ all -> 0x0a6d }
            android.database.sqlite.SQLiteDatabase r12 = r11.zzh()     // Catch:{ SQLiteException -> 0x0284 }
            r21 = r15
            r15 = 3
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0280 }
            r16 = 0
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x0280 }
            r16 = 1
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x0280 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0280 }
            r33 = r4
            r4 = 2
            r15[r4] = r8     // Catch:{ SQLiteException -> 0x027e }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r12.execSQL(r8, r15)     // Catch:{ SQLiteException -> 0x027e }
            goto L_0x029e
        L_0x027e:
            r0 = move-exception
            goto L_0x028a
        L_0x0280:
            r0 = move-exception
            r33 = r4
            goto L_0x0289
        L_0x0284:
            r0 = move-exception
            r33 = r4
            r21 = r15
        L_0x0289:
            r4 = 2
        L_0x028a:
            r8 = r0
            com.google.android.gms.measurement.internal.zzfy r11 = r11.zzs     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzeo r11 = r11.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r11 = r11.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r12 = "Error pruning currencies. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            r11.zzc(r12, r15, r8)     // Catch:{ all -> 0x0a6d }
        L_0x029e:
            com.google.android.gms.measurement.internal.zzle r18 = new com.google.android.gms.measurement.internal.zzle     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.util.Clock r11 = r34.zzav()     // Catch:{ all -> 0x0a6d }
            long r15 = r11.currentTimeMillis()     // Catch:{ all -> 0x0a6d }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0a6d }
            r11 = r18
            r12 = r10
            r13 = r8
            r14 = r9
            r8 = r21
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a6d }
            r9 = r18
        L_0x02ba:
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r11)     // Catch:{ all -> 0x0a6d }
            boolean r11 = r11.zzL(r9)     // Catch:{ all -> 0x0a6d }
            if (r11 != 0) goto L_0x02fc
            com.google.android.gms.measurement.internal.zzeo r11 = r34.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r11 = r11.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r14 = r1.zzn     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzej r14 = r14.zzj()     // Catch:{ all -> 0x0a6d }
            java.lang.String r15 = r9.zzc     // Catch:{ all -> 0x0a6d }
            java.lang.String r14 = r14.zzf(r15)     // Catch:{ all -> 0x0a6d }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0a6d }
            r11.zzd(r12, r13, r14, r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlh r11 = r34.zzv()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlg r12 = r1.zzF     // Catch:{ all -> 0x0a6d }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a6d }
            goto L_0x02fc
        L_0x02f6:
            r33 = r4
            r8 = r21
            goto L_0x015c
        L_0x02fc:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a6d }
            boolean r9 = com.google.android.gms.measurement.internal.zzlh.zzai(r9)     // Catch:{ all -> 0x0a6d }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a6d }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0a6d }
            r34.zzv()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzau r11 = r2.zzb     // Catch:{ all -> 0x0a6d }
            if (r11 != 0) goto L_0x0312
            r16 = 0
            goto L_0x0332
        L_0x0312:
            com.google.android.gms.measurement.internal.zzat r12 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x0a6d }
            r12.<init>(r11)     // Catch:{ all -> 0x0a6d }
            r16 = 0
        L_0x0319:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0a6d }
            if (r13 == 0) goto L_0x0332
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x0a6d }
            java.lang.Object r13 = r11.zzf(r13)     // Catch:{ all -> 0x0a6d }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0a6d }
            if (r14 == 0) goto L_0x0319
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0a6d }
            int r13 = r13.length     // Catch:{ all -> 0x0a6d }
            long r13 = (long) r13     // Catch:{ all -> 0x0a6d }
            long r16 = r16 + r13
            goto L_0x0319
        L_0x0332:
            r22 = 1
            long r16 = r16 + r22
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r11)     // Catch:{ all -> 0x0a6d }
            long r12 = r34.zza()     // Catch:{ all -> 0x0a6d }
            r20 = 1
            r21 = 0
            r24 = 0
            r30 = r5
            r4 = 0
            r14 = r10
            r15 = r16
            r17 = r20
            r18 = r9
            r19 = r21
            r20 = r8
            r21 = r24
            com.google.android.gms.measurement.internal.zzak r11 = r11.zzm(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0a6d }
            long r12 = r11.zzb     // Catch:{ all -> 0x0a6d }
            r34.zzg()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzea r14 = com.google.android.gms.measurement.internal.zzeb.zzj     // Catch:{ all -> 0x0a6d }
            r15 = 0
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x0a6d }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a6d }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a6d }
            long r4 = (long) r14     // Catch:{ all -> 0x0a6d }
            long r12 = r12 - r4
            r4 = 1000(0x3e8, double:4.94E-321)
            r16 = 0
            int r14 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x03a3
            long r12 = r12 % r4
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0392
            com.google.android.gms.measurement.internal.zzeo r2 = r34.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            long r5 = r11.zzb     // Catch:{ all -> 0x0a6d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a6d }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a6d }
        L_0x0392:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r2)     // Catch:{ all -> 0x0a6d }
            r2.zzC()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x03a3:
            if (r9 == 0) goto L_0x0401
            long r12 = r11.zza     // Catch:{ all -> 0x0a6d }
            r34.zzg()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzea r14 = com.google.android.gms.measurement.internal.zzeb.zzl     // Catch:{ all -> 0x0a6d }
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x0a6d }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a6d }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a6d }
            long r4 = (long) r14     // Catch:{ all -> 0x0a6d }
            long r12 = r12 - r4
            r4 = 0
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x0401
            r4 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 % r4
            int r3 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x03dc
            com.google.android.gms.measurement.internal.zzeo r3 = r34.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            long r6 = r11.zza     // Catch:{ all -> 0x0a6d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a6d }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0a6d }
        L_0x03dc:
            com.google.android.gms.measurement.internal.zzlh r11 = r34.zzv()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlg r12 = r1.zzF     // Catch:{ all -> 0x0a6d }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0a6d }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r2)     // Catch:{ all -> 0x0a6d }
            r2.zzC()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x0401:
            r4 = 1000000(0xf4240, float:1.401298E-39)
            if (r8 == 0) goto L_0x0451
            long r12 = r11.zzd     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzag r5 = r34.zzg()     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzea r14 = com.google.android.gms.measurement.internal.zzeb.zzk     // Catch:{ all -> 0x0a6d }
            int r5 = r5.zze(r8, r14)     // Catch:{ all -> 0x0a6d }
            int r5 = java.lang.Math.min(r4, r5)     // Catch:{ all -> 0x0a6d }
            r8 = 0
            int r5 = java.lang.Math.max(r8, r5)     // Catch:{ all -> 0x0a6d }
            long r4 = (long) r5     // Catch:{ all -> 0x0a6d }
            long r12 = r12 - r4
            r4 = 0
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x0451
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0440
            com.google.android.gms.measurement.internal.zzeo r2 = r34.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            long r5 = r11.zzd     // Catch:{ all -> 0x0a6d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a6d }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a6d }
        L_0x0440:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r2)     // Catch:{ all -> 0x0a6d }
            r2.zzC()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x0451:
            com.google.android.gms.measurement.internal.zzau r4 = r2.zzb     // Catch:{ all -> 0x0a6d }
            android.os.Bundle r4 = r4.zzc()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlh r5 = r34.zzv()     // Catch:{ all -> 0x0a6d }
            java.lang.String r11 = "_o"
            java.lang.String r12 = r2.zzc     // Catch:{ all -> 0x0a6d }
            r5.zzO(r4, r11, r12)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlh r5 = r34.zzv()     // Catch:{ all -> 0x0a6d }
            boolean r5 = r5.zzae(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.String r14 = "_r"
            if (r5 == 0) goto L_0x0482
            com.google.android.gms.measurement.internal.zzlh r5 = r34.zzv()     // Catch:{ all -> 0x0a6d }
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0a6d }
            java.lang.String r12 = "_dbg"
            r5.zzO(r4, r12, r11)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlh r5 = r34.zzv()     // Catch:{ all -> 0x0a6d }
            r5.zzO(r4, r14, r11)     // Catch:{ all -> 0x0a6d }
        L_0x0482:
            java.lang.String r5 = "_s"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a6d }
            boolean r5 = r5.equals(r11)     // Catch:{ all -> 0x0a6d }
            if (r5 == 0) goto L_0x04a8
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r5)     // Catch:{ all -> 0x0a6d }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzle r5 = r5.zzp(r11, r7)     // Catch:{ all -> 0x0a6d }
            if (r5 == 0) goto L_0x04a8
            java.lang.Object r11 = r5.zze     // Catch:{ all -> 0x0a6d }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a6d }
            if (r11 == 0) goto L_0x04a8
            com.google.android.gms.measurement.internal.zzlh r11 = r34.zzv()     // Catch:{ all -> 0x0a6d }
            java.lang.Object r5 = r5.zze     // Catch:{ all -> 0x0a6d }
            r11.zzO(r4, r7, r5)     // Catch:{ all -> 0x0a6d }
        L_0x04a8:
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r5)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a6d }
            r5.zzg()     // Catch:{ all -> 0x0a6d }
            r5.zzW()     // Catch:{ all -> 0x0a6d }
            android.database.sqlite.SQLiteDatabase r7 = r5.zzh()     // Catch:{ SQLiteException -> 0x04e8 }
            com.google.android.gms.measurement.internal.zzfy r11 = r5.zzs     // Catch:{ SQLiteException -> 0x04e8 }
            com.google.android.gms.measurement.internal.zzag r11 = r11.zzf()     // Catch:{ SQLiteException -> 0x04e8 }
            com.google.android.gms.measurement.internal.zzea r12 = com.google.android.gms.measurement.internal.zzeb.zzo     // Catch:{ SQLiteException -> 0x04e8 }
            int r11 = r11.zze(r10, r12)     // Catch:{ SQLiteException -> 0x04e8 }
            r8 = 1000000(0xf4240, float:1.401298E-39)
            int r8 = java.lang.Math.min(r8, r11)     // Catch:{ SQLiteException -> 0x04e8 }
            r13 = 0
            int r8 = java.lang.Math.max(r13, r8)     // Catch:{ SQLiteException -> 0x04e6 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x04e6 }
            r11 = 2
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x04e6 }
            r11[r13] = r10     // Catch:{ SQLiteException -> 0x04e6 }
            r12 = 1
            r11[r12] = r8     // Catch:{ SQLiteException -> 0x04e6 }
            java.lang.String r8 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            int r5 = r7.delete(r6, r8, r11)     // Catch:{ SQLiteException -> 0x04e6 }
            long r7 = (long) r5
            goto L_0x0500
        L_0x04e6:
            r0 = move-exception
            goto L_0x04ea
        L_0x04e8:
            r0 = move-exception
            r13 = 0
        L_0x04ea:
            r7 = r0
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzs     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = "Error deleting over the limit events. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            r5.zzc(r8, r11, r7)     // Catch:{ all -> 0x0a6d }
            r7 = 0
        L_0x0500:
            r11 = 0
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x051b
            com.google.android.gms.measurement.internal.zzeo r5 = r34.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzk()     // Catch:{ all -> 0x0a6d }
            java.lang.String r11 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0a6d }
            r5.zzc(r11, r12, r7)     // Catch:{ all -> 0x0a6d }
        L_0x051b:
            com.google.android.gms.measurement.internal.zzar r5 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r12 = r1.zzn     // Catch:{ all -> 0x0a6d }
            java.lang.String r7 = r2.zzc     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a6d }
            long r2 = r2.zzd     // Catch:{ all -> 0x0a6d }
            r18 = 0
            r11 = r5
            r31 = 0
            r13 = r7
            r7 = r14
            r14 = r10
            r32 = r6
            r6 = r15
            r15 = r8
            r16 = r2
            r20 = r4
            r11.<init>((com.google.android.gms.measurement.internal.zzfy) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r2)     // Catch:{ all -> 0x0a6d }
            java.lang.String r3 = r5.zzb     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzn(r10, r3)     // Catch:{ all -> 0x0a6d }
            if (r2 != 0) goto L_0x05be
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r2)     // Catch:{ all -> 0x0a6d }
            long r2 = r2.zzf(r10)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzag r4 = r34.zzg()     // Catch:{ all -> 0x0a6d }
            int r4 = r4.zzb(r10)     // Catch:{ all -> 0x0a6d }
            long r11 = (long) r4     // Catch:{ all -> 0x0a6d }
            int r4 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r4 < 0) goto L_0x05a0
            if (r9 == 0) goto L_0x05a0
            com.google.android.gms.measurement.internal.zzeo r2 = r34.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r10)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r6 = r1.zzn     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzej r6 = r6.zzj()     // Catch:{ all -> 0x0a6d }
            java.lang.String r5 = r5.zzb     // Catch:{ all -> 0x0a6d }
            java.lang.String r5 = r6.zzd(r5)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzag r6 = r34.zzg()     // Catch:{ all -> 0x0a6d }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0a6d }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlh r11 = r34.zzv()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlg r12 = r1.zzF     // Catch:{ all -> 0x0a6d }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x05a0:
            com.google.android.gms.measurement.internal.zzas r2 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0a6d }
            java.lang.String r13 = r5.zzb     // Catch:{ all -> 0x0a6d }
            long r3 = r5.zzd     // Catch:{ all -> 0x0a6d }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r2
            r12 = r10
            r20 = r3
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0a6d }
            goto L_0x05cc
        L_0x05be:
            com.google.android.gms.measurement.internal.zzfy r3 = r1.zzn     // Catch:{ all -> 0x0a6d }
            long r8 = r2.zzf     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzar r5 = r5.zza(r3, r8)     // Catch:{ all -> 0x0a6d }
            long r3 = r5.zzd     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzc(r3)     // Catch:{ all -> 0x0a6d }
        L_0x05cc:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r3)     // Catch:{ all -> 0x0a6d }
            r3.zzE(r2)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfv r2 = r34.zzaz()     // Catch:{ all -> 0x0a6d }
            r2.zzg()     // Catch:{ all -> 0x0a6d }
            r34.zzB()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)     // Catch:{ all -> 0x0a6d }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0a6d }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a6d }
            r3 = r36
            java.lang.String r4 = r3.zza     // Catch:{ all -> 0x0a6d }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.internal.measurement.zzgb r2 = com.google.android.gms.internal.measurement.zzgc.zzt()     // Catch:{ all -> 0x0a6d }
            r4 = 1
            r2.zzad(r4)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = "android"
            r2.zzZ(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a6d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a6d }
            if (r8 != 0) goto L_0x0610
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a6d }
            r2.zzD(r8)     // Catch:{ all -> 0x0a6d }
        L_0x0610:
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a6d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a6d }
            if (r8 != 0) goto L_0x061d
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a6d }
            r2.zzF(r8)     // Catch:{ all -> 0x0a6d }
        L_0x061d:
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a6d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a6d }
            if (r8 != 0) goto L_0x062a
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a6d }
            r2.zzG(r8)     // Catch:{ all -> 0x0a6d }
        L_0x062a:
            com.google.android.gms.internal.measurement.zzoz.zzc()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzag r8 = r34.zzg()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzea r9 = com.google.android.gms.measurement.internal.zzeb.zzar     // Catch:{ all -> 0x0a6d }
            boolean r8 = r8.zzs(r6, r9)     // Catch:{ all -> 0x0a6d }
            if (r8 == 0) goto L_0x0646
            java.lang.String r8 = r3.zzx     // Catch:{ all -> 0x0a6d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a6d }
            if (r8 != 0) goto L_0x0646
            java.lang.String r8 = r3.zzx     // Catch:{ all -> 0x0a6d }
            r2.zzah(r8)     // Catch:{ all -> 0x0a6d }
        L_0x0646:
            long r8 = r3.zzj     // Catch:{ all -> 0x0a6d }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0653
            int r9 = (int) r8     // Catch:{ all -> 0x0a6d }
            r2.zzH(r9)     // Catch:{ all -> 0x0a6d }
        L_0x0653:
            long r8 = r3.zze     // Catch:{ all -> 0x0a6d }
            r2.zzV(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a6d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a6d }
            if (r8 != 0) goto L_0x0665
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a6d }
            r2.zzU(r8)     // Catch:{ all -> 0x0a6d }
        L_0x0665:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a6d }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzai r9 = com.google.android.gms.measurement.internal.zzai.zzb(r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzc(r9)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = r8.zzh()     // Catch:{ all -> 0x0a6d }
            r2.zzL(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = r2.zzaq()     // Catch:{ all -> 0x0a6d }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0a6d }
            if (r8 == 0) goto L_0x0699
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0a6d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a6d }
            if (r8 != 0) goto L_0x0699
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0a6d }
            r2.zzC(r8)     // Catch:{ all -> 0x0a6d }
        L_0x0699:
            long r8 = r3.zzf     // Catch:{ all -> 0x0a6d }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x06a4
            r2.zzM(r8)     // Catch:{ all -> 0x0a6d }
        L_0x06a4:
            long r8 = r3.zzs     // Catch:{ all -> 0x0a6d }
            r2.zzP(r8)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlb r8 = r1.zzi     // Catch:{ all -> 0x0a6d }
            zzal(r8)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzkz r9 = r8.zzf     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzn     // Catch:{ all -> 0x0a6d }
            android.content.Context r9 = r9.zzau()     // Catch:{ all -> 0x0a6d }
            java.util.Map r9 = com.google.android.gms.measurement.internal.zzeb.zzc(r9)     // Catch:{ all -> 0x0a6d }
            if (r9 == 0) goto L_0x0740
            boolean r10 = r9.isEmpty()     // Catch:{ all -> 0x0a6d }
            if (r10 == 0) goto L_0x06c4
            goto L_0x0740
        L_0x06c4:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0a6d }
            r14.<init>()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzea r10 = com.google.android.gms.measurement.internal.zzeb.zzO     // Catch:{ all -> 0x0a6d }
            java.lang.Object r10 = r10.zza(r6)     // Catch:{ all -> 0x0a6d }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0a6d }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0a6d }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0a6d }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0a6d }
        L_0x06dd:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x0a6d }
            if (r11 == 0) goto L_0x073a
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x0a6d }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0a6d }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0a6d }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0a6d }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0a6d }
            if (r12 == 0) goto L_0x06dd
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x0728 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x0728 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0728 }
            if (r11 == 0) goto L_0x06dd
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x0728 }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x0728 }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x0728 }
            if (r11 < r10) goto L_0x06dd
            com.google.android.gms.measurement.internal.zzfy r11 = r8.zzs     // Catch:{ NumberFormatException -> 0x0728 }
            com.google.android.gms.measurement.internal.zzeo r11 = r11.zzay()     // Catch:{ NumberFormatException -> 0x0728 }
            com.google.android.gms.measurement.internal.zzem r11 = r11.zzk()     // Catch:{ NumberFormatException -> 0x0728 }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x0728 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x0728 }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x0728 }
            goto L_0x073a
        L_0x0728:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfy r12 = r8.zzs     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzeo r12 = r12.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r12 = r12.zzk()     // Catch:{ all -> 0x0a6d }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x0a6d }
            goto L_0x06dd
        L_0x073a:
            boolean r8 = r14.isEmpty()     // Catch:{ all -> 0x0a6d }
            if (r8 == 0) goto L_0x0741
        L_0x0740:
            r14 = r6
        L_0x0741:
            if (r14 == 0) goto L_0x0746
            r2.zzh(r14)     // Catch:{ all -> 0x0a6d }
        L_0x0746:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a6d }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzai r9 = com.google.android.gms.measurement.internal.zzai.zzb(r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzc(r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0a6d }
            boolean r9 = r8.zzi(r9)     // Catch:{ all -> 0x0a6d }
            if (r9 == 0) goto L_0x0794
            boolean r9 = r3.zzo     // Catch:{ all -> 0x0a6d }
            if (r9 == 0) goto L_0x0794
            com.google.android.gms.measurement.internal.zzju r9 = r1.zzk     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a6d }
            android.util.Pair r9 = r9.zzd(r10, r8)     // Catch:{ all -> 0x0a6d }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a6d }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0a6d }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a6d }
            if (r10 != 0) goto L_0x0794
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0a6d }
            if (r10 == 0) goto L_0x0794
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a6d }
            r2.zzae(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.Object r10 = r9.second     // Catch:{ all -> 0x0a6d }
            if (r10 == 0) goto L_0x0794
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0a6d }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0a6d }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0a6d }
            r2.zzX(r9)     // Catch:{ all -> 0x0a6d }
        L_0x0794:
            com.google.android.gms.measurement.internal.zzfy r9 = r1.zzn     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a6d }
            r9.zzu()     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0a6d }
            r2.zzN(r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r9 = r1.zzn     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a6d }
            r9.zzu()     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a6d }
            r2.zzY(r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r9 = r1.zzn     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a6d }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0a6d }
            int r10 = (int) r9     // Catch:{ all -> 0x0a6d }
            r2.zzaj(r10)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r9 = r1.zzn     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0a6d }
            r2.zzan(r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r9 = r1.zzn     // Catch:{ all -> 0x0a6d }
            boolean r9 = r9.zzJ()     // Catch:{ all -> 0x0a6d }
            if (r9 == 0) goto L_0x07df
            r2.zzap()     // Catch:{ all -> 0x0a6d }
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a6d }
            if (r9 != 0) goto L_0x07df
            r2.zzO(r6)     // Catch:{ all -> 0x0a6d }
        L_0x07df:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r9)     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)     // Catch:{ all -> 0x0a6d }
            if (r9 != 0) goto L_0x0851
            com.google.android.gms.measurement.internal.zzh r9 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzfy r10 = r1.zzn     // Catch:{ all -> 0x0a6d }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a6d }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = r1.zzw(r8)     // Catch:{ all -> 0x0a6d }
            r9.zzH(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0a6d }
            r9.zzV(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0a6d }
            r9.zzW(r10)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzah r10 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0a6d }
            boolean r10 = r8.zzi(r10)     // Catch:{ all -> 0x0a6d }
            if (r10 == 0) goto L_0x081b
            com.google.android.gms.measurement.internal.zzju r10 = r1.zzk     // Catch:{ all -> 0x0a6d }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a6d }
            boolean r12 = r3.zzo     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = r10.zzf(r11, r12)     // Catch:{ all -> 0x0a6d }
            r9.zzae(r10)     // Catch:{ all -> 0x0a6d }
        L_0x081b:
            r10 = 0
            r9.zzaa(r10)     // Catch:{ all -> 0x0a6d }
            r9.zzab(r10)     // Catch:{ all -> 0x0a6d }
            r9.zzZ(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = r3.zzc     // Catch:{ all -> 0x0a6d }
            r9.zzJ(r10)     // Catch:{ all -> 0x0a6d }
            long r10 = r3.zzj     // Catch:{ all -> 0x0a6d }
            r9.zzK(r10)     // Catch:{ all -> 0x0a6d }
            java.lang.String r10 = r3.zzd     // Catch:{ all -> 0x0a6d }
            r9.zzI(r10)     // Catch:{ all -> 0x0a6d }
            long r10 = r3.zze     // Catch:{ all -> 0x0a6d }
            r9.zzX(r10)     // Catch:{ all -> 0x0a6d }
            long r10 = r3.zzf     // Catch:{ all -> 0x0a6d }
            r9.zzS(r10)     // Catch:{ all -> 0x0a6d }
            boolean r10 = r3.zzh     // Catch:{ all -> 0x0a6d }
            r9.zzac(r10)     // Catch:{ all -> 0x0a6d }
            long r10 = r3.zzs     // Catch:{ all -> 0x0a6d }
            r9.zzT(r10)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r10)     // Catch:{ all -> 0x0a6d }
            r10.zzD(r9)     // Catch:{ all -> 0x0a6d }
        L_0x0851:
            com.google.android.gms.measurement.internal.zzah r10 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x0a6d }
            boolean r8 = r8.zzi(r10)     // Catch:{ all -> 0x0a6d }
            if (r8 == 0) goto L_0x0870
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0a6d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a6d }
            if (r8 != 0) goto L_0x0870
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0a6d }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a6d }
            r2.zzE(r8)     // Catch:{ all -> 0x0a6d }
        L_0x0870:
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0a6d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a6d }
            if (r8 != 0) goto L_0x0887
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0a6d }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a6d }
            r2.zzT(r8)     // Catch:{ all -> 0x0a6d }
        L_0x0887:
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0a6d }
            java.util.List r3 = r8.zzu(r3)     // Catch:{ all -> 0x0a6d }
            r13 = 0
        L_0x0893:
            int r8 = r3.size()     // Catch:{ all -> 0x0a6d }
            if (r13 >= r8) goto L_0x08c9
            com.google.android.gms.internal.measurement.zzgk r8 = com.google.android.gms.internal.measurement.zzgl.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzle r9 = (com.google.android.gms.measurement.internal.zzle) r9     // Catch:{ all -> 0x0a6d }
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x0a6d }
            r8.zzf(r9)     // Catch:{ all -> 0x0a6d }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzle r9 = (com.google.android.gms.measurement.internal.zzle) r9     // Catch:{ all -> 0x0a6d }
            long r9 = r9.zzd     // Catch:{ all -> 0x0a6d }
            r8.zzg(r9)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlb r9 = r1.zzi     // Catch:{ all -> 0x0a6d }
            zzal(r9)     // Catch:{ all -> 0x0a6d }
            java.lang.Object r10 = r3.get(r13)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzle r10 = (com.google.android.gms.measurement.internal.zzle) r10     // Catch:{ all -> 0x0a6d }
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x0a6d }
            r9.zzu(r8, r10)     // Catch:{ all -> 0x0a6d }
            r2.zzl(r8)     // Catch:{ all -> 0x0a6d }
            int r13 = r13 + 1
            goto L_0x0893
        L_0x08c9:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ IOException -> 0x0a23 }
            zzal(r3)     // Catch:{ IOException -> 0x0a23 }
            com.google.android.gms.internal.measurement.zzke r8 = r2.zzaE()     // Catch:{ IOException -> 0x0a23 }
            com.google.android.gms.internal.measurement.zzgc r8 = (com.google.android.gms.internal.measurement.zzgc) r8     // Catch:{ IOException -> 0x0a23 }
            r3.zzg()     // Catch:{ IOException -> 0x0a23 }
            r3.zzW()     // Catch:{ IOException -> 0x0a23 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IOException -> 0x0a23 }
            java.lang.String r9 = r8.zzx()     // Catch:{ IOException -> 0x0a23 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ IOException -> 0x0a23 }
            byte[] r9 = r8.zzbv()     // Catch:{ IOException -> 0x0a23 }
            com.google.android.gms.measurement.internal.zzkz r10 = r3.zzf     // Catch:{ IOException -> 0x0a23 }
            com.google.android.gms.measurement.internal.zzlb r10 = r10.zzi     // Catch:{ IOException -> 0x0a23 }
            zzal(r10)     // Catch:{ IOException -> 0x0a23 }
            long r10 = r10.zzd(r9)     // Catch:{ IOException -> 0x0a23 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x0a23 }
            r12.<init>()     // Catch:{ IOException -> 0x0a23 }
            java.lang.String r13 = r8.zzx()     // Catch:{ IOException -> 0x0a23 }
            r14 = r30
            r12.put(r14, r13)     // Catch:{ IOException -> 0x0a23 }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0a23 }
            r15 = r33
            r12.put(r15, r13)     // Catch:{ IOException -> 0x0a23 }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x0a23 }
            android.database.sqlite.SQLiteDatabase r9 = r3.zzh()     // Catch:{ SQLiteException -> 0x0a09 }
            java.lang.String r13 = "raw_events_metadata"
            r4 = 4
            r9.insertWithOnConflict(r13, r6, r12, r4)     // Catch:{ SQLiteException -> 0x0a09 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r2)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzau r3 = r5.zzf     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzat r4 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x0a6d }
            r4.<init>(r3)     // Catch:{ all -> 0x0a6d }
        L_0x0925:
            boolean r3 = r4.hasNext()     // Catch:{ all -> 0x0a6d }
            if (r3 == 0) goto L_0x0937
            java.lang.String r3 = r4.next()     // Catch:{ all -> 0x0a6d }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x0a6d }
            if (r3 == 0) goto L_0x0925
        L_0x0935:
            r13 = 1
            goto L_0x0978
        L_0x0937:
            com.google.android.gms.measurement.internal.zzfp r3 = r1.zzc     // Catch:{ all -> 0x0a6d }
            zzal(r3)     // Catch:{ all -> 0x0a6d }
            java.lang.String r4 = r5.zza     // Catch:{ all -> 0x0a6d }
            java.lang.String r7 = r5.zzb     // Catch:{ all -> 0x0a6d }
            boolean r3 = r3.zzq(r4, r7)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r4)     // Catch:{ all -> 0x0a6d }
            long r17 = r34.zza()     // Catch:{ all -> 0x0a6d }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a6d }
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r16 = r4
            r19 = r7
            com.google.android.gms.measurement.internal.zzak r4 = r16.zzl(r17, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0a6d }
            if (r3 == 0) goto L_0x0977
            long r3 = r4.zze     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzag r7 = r34.zzg()     // Catch:{ all -> 0x0a6d }
            java.lang.String r8 = r5.zza     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzea r9 = com.google.android.gms.measurement.internal.zzeb.zzn     // Catch:{ all -> 0x0a6d }
            int r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0a6d }
            long r7 = (long) r7     // Catch:{ all -> 0x0a6d }
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0977
            goto L_0x0935
        L_0x0977:
            r13 = 0
        L_0x0978:
            r2.zzg()     // Catch:{ all -> 0x0a6d }
            r2.zzW()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a6d }
            java.lang.String r3 = r5.zza     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzkz r3 = r2.zzf     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzlb r3 = r3.zzi     // Catch:{ all -> 0x0a6d }
            zzal(r3)     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.internal.measurement.zzfs r3 = r3.zzj(r5)     // Catch:{ all -> 0x0a6d }
            byte[] r3 = r3.zzbv()     // Catch:{ all -> 0x0a6d }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x0a6d }
            r4.<init>()     // Catch:{ all -> 0x0a6d }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a6d }
            r4.put(r14, r7)     // Catch:{ all -> 0x0a6d }
            java.lang.String r7 = "name"
            java.lang.String r8 = r5.zzb     // Catch:{ all -> 0x0a6d }
            r4.put(r7, r8)     // Catch:{ all -> 0x0a6d }
            java.lang.String r7 = "timestamp"
            long r8 = r5.zzd     // Catch:{ all -> 0x0a6d }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0a6d }
            r4.put(r7, r8)     // Catch:{ all -> 0x0a6d }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0a6d }
            r4.put(r15, r7)     // Catch:{ all -> 0x0a6d }
            java.lang.String r7 = "data"
            r4.put(r7, r3)     // Catch:{ all -> 0x0a6d }
            java.lang.String r3 = "realtime"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0a6d }
            r4.put(r3, r7)     // Catch:{ all -> 0x0a6d }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x09f1 }
            r7 = r32
            long r3 = r3.insert(r7, r6, r4)     // Catch:{ SQLiteException -> 0x09f1 }
            r6 = -1
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x09ec
            com.google.android.gms.measurement.internal.zzfy r3 = r2.zzs     // Catch:{ SQLiteException -> 0x09f1 }
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x09f1 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x09f1 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r6 = r5.zza     // Catch:{ SQLiteException -> 0x09f1 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeo.zzn(r6)     // Catch:{ SQLiteException -> 0x09f1 }
            r3.zzb(r4, r6)     // Catch:{ SQLiteException -> 0x09f1 }
            goto L_0x0a3a
        L_0x09ec:
            r3 = 0
            r1.zza = r3     // Catch:{ all -> 0x0a6d }
            goto L_0x0a3a
        L_0x09f1:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x0a6d }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeo.zzn(r5)     // Catch:{ all -> 0x0a6d }
            r2.zzc(r4, r5, r3)     // Catch:{ all -> 0x0a6d }
            goto L_0x0a3a
        L_0x0a09:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzs     // Catch:{ IOException -> 0x0a23 }
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzay()     // Catch:{ IOException -> 0x0a23 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzd()     // Catch:{ IOException -> 0x0a23 }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r8.zzx()     // Catch:{ IOException -> 0x0a23 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeo.zzn(r6)     // Catch:{ IOException -> 0x0a23 }
            r3.zzc(r5, r6, r4)     // Catch:{ IOException -> 0x0a23 }
            throw r4     // Catch:{ IOException -> 0x0a23 }
        L_0x0a23:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzeo r4 = r34.zzay()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzd()     // Catch:{ all -> 0x0a6d }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzap()     // Catch:{ all -> 0x0a6d }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeo.zzn(r2)     // Catch:{ all -> 0x0a6d }
            r4.zzc(r5, r2, r3)     // Catch:{ all -> 0x0a6d }
        L_0x0a3a:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a6d }
            zzal(r2)     // Catch:{ all -> 0x0a6d }
            r2.zzC()     // Catch:{ all -> 0x0a6d }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r34.zzag()
            com.google.android.gms.measurement.internal.zzeo r2 = r34.zzay()
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzj()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0a6d:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze
            zzal(r3)
            r3.zzx()
            throw r2
        L_0x0a78:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.zzY(com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzZ() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzs.zzf();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock tryLock = channel.tryLock();
                this.zzw = tryLock;
                if (tryLock != null) {
                    zzay().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzay().zzd().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzay().zzd().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzay().zzd().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzay().zzk().zzb("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        long currentTimeMillis = zzav().currentTimeMillis();
        zzju zzju = this.zzk;
        zzju.zzW();
        zzju.zzg();
        long zza2 = zzju.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzju.zzs.zzv().zzG().nextInt(86400000)) + 1;
            zzju.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final Context zzau() {
        return this.zzn.zzau();
    }

    public final Clock zzav() {
        return ((zzfy) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    public final zzab zzaw() {
        throw null;
    }

    public final zzeo zzay() {
        return ((zzfy) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    public final zzfv zzaz() {
        return ((zzfy) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    /* access modifiers changed from: package-private */
    public final zzh zzd(zzq zzq2) {
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq2.zza);
        zzow.zzc();
        if (zzg().zzs(zzq2.zza, zzeb.zzat) && !zzq2.zzw.isEmpty()) {
            this.zzC.put(zzq2.zza, new zzky(this, zzq2.zzw));
        }
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(zzq2.zza);
        zzai zzc2 = zzh(zzq2.zza).zzc(zzai.zzb(zzq2.zzv));
        String zzf2 = zzc2.zzi(zzah.AD_STORAGE) ? this.zzk.zzf(zzq2.zza, zzq2.zzo) : "";
        if (zzj2 == null) {
            zzj2 = new zzh(this.zzn, zzq2.zza);
            if (zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
                zzj2.zzH(zzw(zzc2));
            }
            if (zzc2.zzi(zzah.AD_STORAGE)) {
                zzj2.zzae(zzf2);
            }
        } else if (zzc2.zzi(zzah.AD_STORAGE) && zzf2 != null && !zzf2.equals(zzj2.zzA())) {
            zzj2.zzae(zzf2);
            if (zzq2.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzq2.zza, zzc2).first)) {
                zzj2.zzH(zzw(zzc2));
                zzam zzam2 = this.zze;
                zzal(zzam2);
                if (zzam2.zzp(zzq2.zza, "_id") != null) {
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    if (zzam3.zzp(zzq2.zza, "_lair") == null) {
                        zzle zzle = new zzle(zzq2.zza, "auto", "_lair", zzav().currentTimeMillis(), 1L);
                        zzam zzam4 = this.zze;
                        zzal(zzam4);
                        zzam4.zzL(zzle);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzj2.zzu()) && zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
            zzj2.zzH(zzw(zzc2));
        }
        zzj2.zzW(zzq2.zzb);
        zzj2.zzF(zzq2.zzq);
        if (!TextUtils.isEmpty(zzq2.zzk)) {
            zzj2.zzV(zzq2.zzk);
        }
        long j = zzq2.zze;
        if (j != 0) {
            zzj2.zzX(j);
        }
        if (!TextUtils.isEmpty(zzq2.zzc)) {
            zzj2.zzJ(zzq2.zzc);
        }
        zzj2.zzK(zzq2.zzj);
        String str = zzq2.zzd;
        if (str != null) {
            zzj2.zzI(str);
        }
        zzj2.zzS(zzq2.zzf);
        zzj2.zzac(zzq2.zzh);
        if (!TextUtils.isEmpty(zzq2.zzg)) {
            zzj2.zzY(zzq2.zzg);
        }
        zzj2.zzG(zzq2.zzo);
        zzj2.zzad(zzq2.zzr);
        zzj2.zzT(zzq2.zzs);
        zzoz.zzc();
        if (zzg().zzs((String) null, zzeb.zzar)) {
            zzj2.zzag(zzq2.zzx);
        }
        zzns.zzc();
        if (zzg().zzs((String) null, zzeb.zzaj)) {
            zzj2.zzaf(zzq2.zzt);
        } else {
            zzns.zzc();
            if (zzg().zzs((String) null, zzeb.zzai)) {
                zzj2.zzaf((List) null);
            }
        }
        if (zzj2.zzaj()) {
            zzam zzam5 = this.zze;
            zzal(zzam5);
            zzam5.zzD(zzj2);
        }
        return zzj2;
    }

    public final zzaa zzf() {
        zzaa zzaa = this.zzh;
        zzal(zzaa);
        return zzaa;
    }

    public final zzag zzg() {
        return ((zzfy) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    /* access modifiers changed from: package-private */
    public final zzai zzh(String str) {
        String str2;
        zzai zzai = zzai.zza;
        zzaz().zzg();
        zzB();
        zzai zzai2 = (zzai) this.zzB.get(str);
        if (zzai2 != null) {
            return zzai2;
        }
        zzam zzam = this.zze;
        zzal(zzam);
        Preconditions.checkNotNull(str);
        zzam.zzg();
        zzam.zzW();
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzam.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                str2 = "G1";
            }
            zzai zzb2 = zzai.zzb(str2);
            zzV(str, zzb2);
            return zzb2;
        } catch (SQLiteException e) {
            zzam.zzs.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzam zzi() {
        zzam zzam = this.zze;
        zzal(zzam);
        return zzam;
    }

    public final zzej zzj() {
        return this.zzn.zzj();
    }

    public final zzeu zzl() {
        zzeu zzeu = this.zzd;
        zzal(zzeu);
        return zzeu;
    }

    public final zzew zzm() {
        zzew zzew = this.zzf;
        if (zzew != null) {
            return zzew;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfp zzo() {
        zzfp zzfp = this.zzc;
        zzal(zzfp);
        return zzfp;
    }

    /* access modifiers changed from: package-private */
    public final zzfy zzq() {
        return this.zzn;
    }

    public final zzii zzr() {
        zzii zzii = this.zzj;
        zzal(zzii);
        return zzii;
    }

    public final zzju zzs() {
        return this.zzk;
    }

    public final zzlb zzu() {
        zzlb zzlb = this.zzi;
        zzal(zzlb);
        return zzlb;
    }

    public final zzlh zzv() {
        return ((zzfy) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    /* access modifiers changed from: package-private */
    public final String zzw(zzai zzai) {
        if (!zzai.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final String zzx(zzq zzq2) {
        try {
            return (String) zzaz().zzh(new zzks(this, zzq2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzeo.zzn(zzq2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
