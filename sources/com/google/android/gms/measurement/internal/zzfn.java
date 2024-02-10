package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzfn implements zzr {
    final /* synthetic */ zzfp zza;

    zzfn(zzfp zzfp) {
        this.zza = zzfp;
    }

    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzem zzem;
        int i2 = i - 1;
        if (i2 == 0) {
            zzem = this.zza.zzs.zzay().zzc();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzem = this.zza.zzs.zzay().zzj();
            } else if (i2 != 4) {
                zzem = this.zza.zzs.zzay().zzi();
            } else if (z) {
                zzem = this.zza.zzs.zzay().zzm();
            } else if (!z2) {
                zzem = this.zza.zzs.zzay().zzl();
            } else {
                zzem = this.zza.zzs.zzay().zzk();
            }
        } else if (z) {
            zzem = this.zza.zzs.zzay().zzh();
        } else if (!z2) {
            zzem = this.zza.zzs.zzay().zze();
        } else {
            zzem = this.zza.zzs.zzay().zzd();
        }
        int size = list.size();
        if (size == 1) {
            zzem.zzb(str, list.get(0));
        } else if (size == 2) {
            zzem.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzem.zza(str);
        } else {
            zzem.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
