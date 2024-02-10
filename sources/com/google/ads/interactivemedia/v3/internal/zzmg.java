package com.google.ads.interactivemedia.v3.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzmg {
    protected static final String zza = "zzmg";
    private final zzkt zzb;
    private final String zzc;
    private final String zzd;
    private volatile Method zze = null;
    private final Class[] zzf;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzmg(zzkt zzkt, String str, String str2, Class... clsArr) {
        this.zzb = zzkt;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzkt.zzk().submit(new zzmf(this));
    }

    static /* bridge */ /* synthetic */ void zzb(zzmg zzmg) {
        CountDownLatch countDownLatch;
        try {
            zzkt zzkt = zzmg.zzb;
            Class loadClass = zzkt.zzi().loadClass(zzmg.zzc(zzkt.zzu(), zzmg.zzc));
            if (loadClass == null) {
                countDownLatch = zzmg.zzg;
            } else {
                zzmg.zze = loadClass.getMethod(zzmg.zzc(zzmg.zzb.zzu(), zzmg.zzd), zzmg.zzf);
                if (zzmg.zze == null) {
                    countDownLatch = zzmg.zzg;
                }
                countDownLatch = zzmg.zzg;
            }
        } catch (zzjx | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
        } catch (NullPointerException unused2) {
            countDownLatch = zzmg.zzg;
        } catch (Throwable th) {
            zzmg.zzg.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzjx, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
