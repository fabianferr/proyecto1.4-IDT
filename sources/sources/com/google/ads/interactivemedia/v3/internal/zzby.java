package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import com.google.ads.interactivemedia.omid.library.adsession.zze;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzby implements Application.ActivityLifecycleCallbacks {
    private static final zzby zza = new zzby();
    private boolean zzb;
    private boolean zzc;
    private zzcd zzd;

    private zzby() {
    }

    public static zzby zza() {
        return zza;
    }

    private final void zze() {
        boolean z = this.zzc;
        for (zze zzh : zzbx.zza().zzc()) {
            zzcj zzh2 = zzh.zzh();
            if (zzh2.zzk()) {
                zzcc.zza().zzb(zzh2.zza(), "setState", true != z ? "foregrounded" : "backgrounded");
            }
        }
    }

    private final void zzf(boolean z) {
        if (this.zzc != z) {
            this.zzc = z;
            if (this.zzb) {
                zze();
                if (this.zzd == null) {
                    return;
                }
                if (!z) {
                    zzcz.zzd().zzi();
                } else {
                    zzcz.zzd().zzh();
                }
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        zzf(false);
    }

    public final void onActivityStopped(Activity activity) {
        View zzg;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i = runningAppProcessInfo.importance;
        boolean z = true;
        boolean z2 = true;
        for (zze zze : zzbx.zza().zzb()) {
            if (zze.zzk() && (zzg = zze.zzg()) != null && zzg.hasWindowFocus()) {
                z2 = false;
            }
        }
        if (i == 100 || !z2) {
            z = false;
        }
        zzf(z);
    }

    public final void zzb() {
        this.zzb = true;
        this.zzc = false;
        zze();
    }

    public final void zzc() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = null;
    }

    public final void zzd(zzcd zzcd) {
        this.zzd = zzcd;
    }
}
