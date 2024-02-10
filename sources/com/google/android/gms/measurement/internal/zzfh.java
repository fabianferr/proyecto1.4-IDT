package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcl;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzfh {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzfh(zza zza2) {
        Preconditions.checkNotNull(zza2);
        this.zza = zza2;
    }

    public final void zza(Context context, Intent intent) {
        zzfy zzp = zzfy.zzp(context, (zzcl) null, (Long) null);
        zzeo zzay = zzp.zzay();
        if (intent == null) {
            zzay.zzk().zza("Receiver called with null intent");
            return;
        }
        zzp.zzaw();
        String action = intent.getAction();
        zzay.zzj().zzb("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzay.zzj().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzay.zzk().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
