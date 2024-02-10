package com.google.ads.interactivemedia.v3.internal;

import android.app.Application;
import android.content.Context;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzbs {
    private boolean zza;

    /* access modifiers changed from: package-private */
    public final void zza(Context context) {
        zzcp.zzb(context, "Application Context cannot be null");
        if (!this.zza) {
            this.zza = true;
            zzcd.zzb().zzc(context);
            zzby zza2 = zzby.zza();
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(zza2);
            }
            zzcn.zzd(context);
            zzca.zzb().zzc(context);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zza;
    }
}
