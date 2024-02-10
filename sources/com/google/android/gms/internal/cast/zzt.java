package com.google.android.gms.internal.cast;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzt implements View.OnClickListener {
    final /* synthetic */ zzy zza;

    zzt(zzy zzy) {
        this.zza = zzy;
    }

    public final void onClick(View view) {
        for (zzv zze : this.zza.zzj) {
            zze.zze();
        }
    }
}
