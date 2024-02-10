package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public abstract class zzbi<T> {
    private static final Object zza = new Object();
    @Nullable
    private static volatile zzbr zzb = null;
    private static volatile boolean zzc = false;
    private static final AtomicReference<Collection<zzbi<?>>> zzd = new AtomicReference<>();
    private static zzbs zze = new zzbs(zzbk.zza);
    private static final AtomicInteger zzi = new AtomicInteger();
    private final zzbo zzf;
    private final String zzg;
    private final T zzh;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;

    @Deprecated
    public static void zza(Context context) {
        synchronized (zza) {
            zzbr zzbr = zzb;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzbr == null || zzbr.zza() != context) {
                zzau.zzb();
                zzbq.zza();
                zzbd.zza();
                zzb = new zzav(context, zzdi.zza(new zzbl(context)));
                zzi.incrementAndGet();
            }
        }
    }

    static final /* synthetic */ boolean zzd() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    public static void zzb(Context context) {
        if (zzb == null) {
            synchronized (zza) {
                if (zzb == null) {
                    zza(context);
                }
            }
        }
    }

    static void zza() {
        zzi.incrementAndGet();
    }

    private zzbi(zzbo zzbo, String str, T t, boolean z) {
        this.zzj = -1;
        if (zzbo.zza == null && zzbo.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (zzbo.zza == null || zzbo.zzb == null) {
            this.zzf = zzbo;
            this.zzg = str;
            this.zzh = t;
            this.zzl = z;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzg);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzc() {
        /*
            r6 = this;
            boolean r0 = r6.zzl
            if (r0 != 0) goto L_0x0011
            com.google.android.gms.internal.vision.zzbs r0 = zze
            java.lang.String r1 = r6.zzg
            boolean r0 = r0.zza(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            com.google.android.gms.internal.vision.zzde.zzb((boolean) r0, (java.lang.Object) r1)
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = zzi
            int r0 = r0.get()
            int r1 = r6.zzj
            if (r1 >= r0) goto L_0x008a
            monitor-enter(r6)
            int r1 = r6.zzj     // Catch:{ all -> 0x0087 }
            if (r1 >= r0) goto L_0x0085
            com.google.android.gms.internal.vision.zzbr r1 = zzb     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0026
            r2 = 1
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            java.lang.String r3 = "Must call PhenotypeFlag.init() first"
            com.google.android.gms.internal.vision.zzde.zzb((boolean) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.vision.zzbo r2 = r6.zzf     // Catch:{ all -> 0x0087 }
            boolean r2 = r2.zzf     // Catch:{ all -> 0x0087 }
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r6.zzb((com.google.android.gms.internal.vision.zzbr) r1)     // Catch:{ all -> 0x0087 }
            if (r2 == 0) goto L_0x0039
            goto L_0x0050
        L_0x0039:
            java.lang.Object r2 = r6.zza((com.google.android.gms.internal.vision.zzbr) r1)     // Catch:{ all -> 0x0087 }
            if (r2 == 0) goto L_0x004e
            goto L_0x0050
        L_0x0040:
            java.lang.Object r2 = r6.zza((com.google.android.gms.internal.vision.zzbr) r1)     // Catch:{ all -> 0x0087 }
            if (r2 == 0) goto L_0x0047
            goto L_0x0050
        L_0x0047:
            java.lang.Object r2 = r6.zzb((com.google.android.gms.internal.vision.zzbr) r1)     // Catch:{ all -> 0x0087 }
            if (r2 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            T r2 = r6.zzh     // Catch:{ all -> 0x0087 }
        L_0x0050:
            com.google.android.gms.internal.vision.zzdf r1 = r1.zzb()     // Catch:{ all -> 0x0087 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.vision.zzcy r1 = (com.google.android.gms.internal.vision.zzcy) r1     // Catch:{ all -> 0x0087 }
            boolean r3 = r1.zza()     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0081
            java.lang.Object r1 = r1.zzb()     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.vision.zzbe r1 = (com.google.android.gms.internal.vision.zzbe) r1     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.vision.zzbo r2 = r6.zzf     // Catch:{ all -> 0x0087 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.vision.zzbo r3 = r6.zzf     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.vision.zzbo r4 = r6.zzf     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = r4.zzd     // Catch:{ all -> 0x0087 }
            java.lang.String r5 = r6.zzg     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r1.zza(r2, r3, r4, r5)     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x007d
            T r2 = r6.zzh     // Catch:{ all -> 0x0087 }
            goto L_0x0081
        L_0x007d:
            java.lang.Object r2 = r6.zza((java.lang.Object) r1)     // Catch:{ all -> 0x0087 }
        L_0x0081:
            r6.zzk = r2     // Catch:{ all -> 0x0087 }
            r6.zzj = r0     // Catch:{ all -> 0x0087 }
        L_0x0085:
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            goto L_0x008a
        L_0x0087:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            throw r0
        L_0x008a:
            T r0 = r6.zzk
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzbi.zzc():java.lang.Object");
    }

    @Nullable
    private final T zza(zzbr zzbr) {
        zzay zzay;
        Object zza2;
        boolean z = false;
        if (!this.zzf.zzg) {
            String str = (String) zzbd.zza(zzbr.zza()).zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
            if (str != null && zzaq.zzb.matcher(str).matches()) {
                z = true;
            }
        }
        if (!z) {
            if (this.zzf.zzb == null) {
                zzay = zzbq.zza(zzbr.zza(), this.zzf.zza);
            } else if (!zzbg.zza(zzbr.zza(), this.zzf.zzb)) {
                zzay = null;
            } else if (this.zzf.zzh) {
                ContentResolver contentResolver = zzbr.zza().getContentResolver();
                String lastPathSegment = this.zzf.zzb.getLastPathSegment();
                String packageName = zzbr.zza().getPackageName();
                StringBuilder sb = new StringBuilder(String.valueOf(lastPathSegment).length() + 1 + String.valueOf(packageName).length());
                sb.append(lastPathSegment);
                sb.append("#");
                sb.append(packageName);
                zzay = zzau.zza(contentResolver, zzbj.zza(sb.toString()));
            } else {
                zzay = zzau.zza(zzbr.zza().getContentResolver(), this.zzf.zzb);
            }
            if (!(zzay == null || (zza2 = zzay.zza(zzb())) == null)) {
                return zza(zza2);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String valueOf = String.valueOf(zzb());
            Log.d("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    @Nullable
    private final T zzb(zzbr zzbr) {
        if (!this.zzf.zze && (this.zzf.zzi == null || this.zzf.zzi.zza(zzbr.zza()).booleanValue())) {
            Object zza2 = zzbd.zza(zzbr.zza()).zza(this.zzf.zze ? null : zza(this.zzf.zzc));
            if (zza2 != null) {
                return zza(zza2);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static <T> zzbi<T> zzb(zzbo zzbo, String str, T t, zzbp<T> zzbp, boolean z) {
        return new zzbm(zzbo, str, t, true, zzbp);
    }

    static final /* synthetic */ zzcy zzc(Context context) {
        new zzbh();
        return zzbh.zza(context);
    }

    /* synthetic */ zzbi(zzbo zzbo, String str, Object obj, boolean z, zzbn zzbn) {
        this(zzbo, str, obj, z);
    }
}
