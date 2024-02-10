package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzdi implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzdj zza;

    zzdi(zzdj zzdj) {
        this.zza = zzdj;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        zzdj zzdj = this.zza;
        if (zzdj.zze == activity) {
            zzdj.zze = null;
            this.zza.zzk();
        }
    }

    public final void onActivityPaused(Activity activity) {
        zzdj zzdj = this.zza;
        if (zzdj.zze == null || zzdj.zze == activity) {
            zzdj.zze = activity;
            this.zza.zza.zzp(new zzff(zzfd.activityMonitor, zzfe.appStateChanged, this.zza.zzb, this.zza.zzc("", "", "inactive")));
        }
    }

    public final void onActivityResumed(Activity activity) {
        zzdj zzdj = this.zza;
        if (zzdj.zze == activity) {
            this.zza.zza.zzp(new zzff(zzfd.activityMonitor, zzfe.appStateChanged, this.zza.zzb, zzdj.zzc("", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE)));
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
