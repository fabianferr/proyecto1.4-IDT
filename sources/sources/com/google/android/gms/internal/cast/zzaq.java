package com.google.android.gms.internal.cast;

import android.app.Activity;
import com.google.android.gms.cast.framework.internal.featurehighlight.zzg;
import com.google.android.gms.cast.framework.internal.featurehighlight.zzh;
import com.google.android.gms.cast.framework.zzav;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzaq implements zzg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzh zzb;
    final /* synthetic */ zzar zzc;

    zzaq(zzar zzar, Activity activity, zzh zzh) {
        this.zzc = zzar;
        this.zza = activity;
        this.zzb = zzh;
    }

    public final void zza() {
        if (this.zzc.zzf) {
            zzav.zza(this.zza);
            this.zzb.zzh(new zzao(this, this.zza));
        }
    }

    public final void zzb() {
        if (this.zzc.zzf) {
            zzav.zza(this.zza);
            this.zzb.zzg(new zzap(this, this.zza));
        }
    }
}
