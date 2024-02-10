package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzkg implements zzkh {
    final /* synthetic */ Activity zza;

    zzkg(zzki zzki, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.zza);
    }
}
