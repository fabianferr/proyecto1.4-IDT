package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzqk {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzql zzc;
    private final zzoy zzd;
    private final zzot zze;
    private zzpz zzf;
    private final Object zzg = new Object();

    public zzqk(Context context, zzql zzql, zzoy zzoy, zzot zzot) {
        this.zzb = context;
        this.zzc = zzql;
        this.zzd = zzoy;
        this.zze = zzot;
    }

    private final synchronized Class zzd(zzqa zzqa) throws zzqj {
        String zzk = zzqa.zza().zzk();
        HashMap hashMap = zza;
        Class cls = (Class) hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzqa.zzc())) {
                File zzb2 = zzqa.zzb();
                if (!zzb2.exists()) {
                    zzb2.mkdirs();
                }
                Class loadClass = new DexClassLoader(zzqa.zzc().getAbsolutePath(), zzb2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                hashMap.put(zzk, loadClass);
                return loadClass;
            }
            throw new zzqj(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e) {
            throw new zzqj(2026, (Throwable) e);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
            throw new zzqj(2008, e2);
        }
    }

    public final zzpb zza() {
        zzpz zzpz;
        synchronized (this.zzg) {
            zzpz = this.zzf;
        }
        return zzpz;
    }

    public final zzqa zzb() {
        synchronized (this.zzg) {
            zzpz zzpz = this.zzf;
            if (zzpz == null) {
                return null;
            }
            zzqa zzf2 = zzpz.zzf();
            return zzf2;
        }
    }

    public final boolean zzc(zzqa zzqa) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class zzd2 = zzd(zzqa);
            zzpz zzpz = new zzpz(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzqa.zze(), null, new Bundle(), 2}), zzqa, this.zzc, this.zzd);
            if (zzpz.zzh()) {
                int zze2 = zzpz.zze();
                if (zze2 == 0) {
                    synchronized (this.zzg) {
                        zzpz zzpz2 = this.zzf;
                        if (zzpz2 != null) {
                            try {
                                zzpz2.zzg();
                            } catch (zzqj e) {
                                this.zzd.zzc(e.zza(), -1, e);
                            }
                        }
                        this.zzf = zzpz;
                    }
                    this.zzd.zzd(3000, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                throw new zzqj(4001, "ci: " + zze2);
            }
            throw new zzqj(4000, "init failed");
        } catch (Exception e2) {
            throw new zzqj(2004, (Throwable) e2);
        } catch (zzqj e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }
}
