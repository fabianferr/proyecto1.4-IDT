package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.mbridge.msdk.c.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzpz implements zzpb {
    private final Object zza;
    private final zzqa zzb;
    private final zzql zzc;
    private final zzoy zzd;

    zzpz(Object obj, zzqa zzqa, zzql zzql, zzoy zzoy) {
        this.zza = obj;
        this.zzb = zzqa;
        this.zzc = zzql;
        this.zzd = zzoy;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzbo zza2 = zzbp.zza();
        zza2.zzc(5);
        zza2.zza(zzadr.zzs(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzbp) zza2.zzak()).zzav(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzd.zzc(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zza, new Object[]{null, map2});
    }

    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map zza2;
        zza2 = this.zzc.zza();
        zza2.put(f.a, "c");
        zza2.put("ctx", context);
        zza2.put("cs", str2);
        zza2.put("aid", (Object) null);
        zza2.put("view", view);
        zza2.put("act", activity);
        return zzi(zzj((Map) null, zza2));
    }

    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map zzc2;
        zzc2 = this.zzc.zzc();
        zzc2.put(f.a, "v");
        zzc2.put("ctx", context);
        zzc2.put("aid", (Object) null);
        zzc2.put("view", view);
        zzc2.put("act", activity);
        return zzi(zzj((Map) null, zzc2));
    }

    public final synchronized String zzc(Context context, String str) {
        Map zzb2;
        zzb2 = this.zzc.zzb();
        zzb2.put(f.a, "q");
        zzb2.put("ctx", context);
        zzb2.put("aid", (Object) null);
        return zzi(zzj((Map) null, zzb2));
    }

    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzqj {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zza, new Object[]{hashMap});
            this.zzd.zzd(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzqj(2005, (Throwable) e);
        }
    }

    public final synchronized int zze() throws zzqj {
        try {
        } catch (Exception e) {
            throw new zzqj(2006, (Throwable) e);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }

    /* access modifiers changed from: package-private */
    public final zzqa zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzqj {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzd(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzqj(2003, (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzh() throws zzqj {
        try {
        } catch (Exception e) {
            throw new zzqj(2001, (Throwable) e);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }
}
