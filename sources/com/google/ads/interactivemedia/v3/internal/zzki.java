package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzki implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzki(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzka(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzkg(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzkd(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzkc(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzkf(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzkb(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzke(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkh zzkh) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzkh.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception unused) {
        }
    }
}
