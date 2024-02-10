package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.File;
import java.util.HashSet;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzqi {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzpr zze;
    private boolean zzf = false;

    public zzqi(Context context, int i, zzpr zzpr, boolean z) {
        this.zzb = context;
        this.zzd = Integer.toString(i - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzpr;
        this.zzf = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(zzmm zzmm) {
        zzmo zzd2 = zzmp.zzd();
        zzd2.zze(zzmm.zzc().zzk());
        zzd2.zza(zzmm.zzc().zzi());
        zzd2.zzb(zzmm.zzc().zza());
        zzd2.zzd(zzmm.zzc().zzc());
        zzd2.zzc(zzmm.zzc().zzb());
        return Hex.bytesToStringLowercase(((zzmp) zzd2.zzak()).zzav());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i, long j) {
        zzpr zzpr = this.zze;
        if (zzpr != null) {
            zzpr.zza(i, j);
        }
    }

    private final void zzj(int i, long j, String str) {
        zzpr zzpr = this.zze;
        if (zzpr != null) {
            zzpr.zzb(i, j, str);
        }
    }

    private final zzmp zzk(int i) {
        String str;
        zzaef zzaef;
        if (i == 1) {
            str = this.zzc.getString(zzh(), (String) null);
        } else {
            str = this.zzc.getString(zzg(), (String) null);
        }
        if (str == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            byte[] stringToBytes = Hex.stringToBytes(str);
            zzadr zzadr = zzadr.zzb;
            zzadr zzs = zzadr.zzs(stringToBytes, 0, stringToBytes.length);
            if (this.zzf) {
                zzaef = zzaef.zza();
            } else {
                zzaef = zzaef.zzb();
            }
            return zzmp.zzh(zzs, zzaef);
        } catch (zzafc unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, currentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, currentTimeMillis);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.ads.interactivemedia.v3.internal.zzmm r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = zza
            monitor-enter(r2)
            com.google.ads.interactivemedia.v3.internal.zzmp r3 = r7.zzc()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.zzk()     // Catch:{ all -> 0x0054 }
            java.io.File r3 = r6.zze(r3)     // Catch:{ all -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "pcbc"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0054 }
            com.google.ads.interactivemedia.v3.internal.zzadr r3 = r7.zzd()     // Catch:{ all -> 0x0054 }
            byte[] r3 = r3.zzx()     // Catch:{ all -> 0x0054 }
            boolean r3 = com.google.ads.interactivemedia.v3.internal.zzqc.zze(r4, r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0030
            r7 = 4020(0xfb4, float:5.633E-42)
            r6.zzi(r7, r0)     // Catch:{ all -> 0x0054 }
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            r7 = 0
            return r7
        L_0x0030:
            java.lang.String r7 = zzf(r7)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r6.zzc     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r6.zzh()     // Catch:{ all -> 0x0054 }
            r3.putString(r4, r7)     // Catch:{ all -> 0x0054 }
            boolean r7 = r3.commit()     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x004d
            r3 = 5015(0x1397, float:7.028E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x004d:
            r3 = 4021(0xfb5, float:5.635E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0054:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzqi.zza(com.google.ads.interactivemedia.v3.internal.zzmm):boolean");
    }

    public final boolean zzb(zzmm zzmm, zzqh zzqh) {
        zzqh zzqh2 = zzqh;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzmp zzk = zzk(1);
            String zzk2 = zzmm.zzc().zzk();
            if (zzk == null || !zzk.zzk().equals(zzk2)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File zze2 = zze(zzk2);
                if (zze2.exists()) {
                    String str = "1";
                    if (true != zze2.isDirectory()) {
                        str = "0";
                    }
                    String str2 = "1";
                    if (true != zze2.isFile()) {
                        str2 = "0";
                    }
                    zzj(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT, currentTimeMillis2, "d:" + str + ",f:" + str2);
                    zzi(4015, currentTimeMillis2);
                } else if (!zze2.mkdirs()) {
                    String str3 = "1";
                    if (true != zze2.canWrite()) {
                        str3 = "0";
                    }
                    zzj(4024, currentTimeMillis2, "cw:".concat(str3));
                    zzi(4015, currentTimeMillis2);
                    return false;
                }
                File zze3 = zze(zzk2);
                File file = new File(zze3, "pcam.jar");
                File file2 = new File(zze3, "pcbc");
                if (!zzqc.zze(file, zzmm.zze().zzx())) {
                    zzi(4016, currentTimeMillis);
                    return false;
                } else if (!zzqc.zze(file2, zzmm.zzd().zzx())) {
                    zzi(4017, currentTimeMillis);
                    return false;
                } else if (zzqh2 == null || zzqh2.zza(file)) {
                    String zzf2 = zzf(zzmm);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    String string = this.zzc.getString(zzh(), (String) null);
                    SharedPreferences.Editor edit = this.zzc.edit();
                    edit.putString(zzh(), zzf2);
                    if (string != null) {
                        edit.putString(zzg(), string);
                    }
                    if (!edit.commit()) {
                        zzi(4019, currentTimeMillis3);
                        return false;
                    }
                    HashSet hashSet = new HashSet();
                    zzmp zzk3 = zzk(1);
                    if (zzk3 != null) {
                        hashSet.add(zzk3.zzk());
                    }
                    zzmp zzk4 = zzk(2);
                    if (zzk4 != null) {
                        hashSet.add(zzk4.zzk());
                    }
                    for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                        if (!hashSet.contains(file3.getName())) {
                            zzqc.zzd(file3);
                        }
                    }
                    zzi(5014, currentTimeMillis);
                    return true;
                } else {
                    zzi(4018, currentTimeMillis);
                    zzqc.zzd(zze3);
                    return false;
                }
            } else {
                zzi(4014, currentTimeMillis);
                return false;
            }
        }
    }

    public final zzqa zzc(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzmp zzk = zzk(1);
            if (zzk == null) {
                zzi(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED, currentTimeMillis);
                return null;
            }
            File zze2 = zze(zzk.zzk());
            File file = new File(zze2, "pcam.jar");
            if (!file.exists()) {
                file = new File(zze2, "pcam");
            }
            File file2 = new File(zze2, "pcbc");
            File file3 = new File(zze2, "pcopt");
            zzi(5016, currentTimeMillis);
            zzqa zzqa = new zzqa(zzk, file, file2, file3);
            return zzqa;
        }
    }

    public final boolean zzd(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzmp zzk = zzk(1);
            if (zzk == null) {
                zzi(4025, currentTimeMillis);
                return false;
            }
            File zze2 = zze(zzk.zzk());
            if (!new File(zze2, "pcam.jar").exists()) {
                zzi(4026, currentTimeMillis);
                return false;
            } else if (!new File(zze2, "pcbc").exists()) {
                zzi(4027, currentTimeMillis);
                return false;
            } else {
                zzi(5019, currentTimeMillis);
                return true;
            }
        }
    }
}
