package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzku implements zzlg {
    final /* synthetic */ zzkz zza;

    zzku(zzkz zzkz) {
        this.zza = zzkz;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            zzkz zzkz = this.zza;
            if (zzkz.zzn != null) {
                zzkz.zzn.zzay().zzd().zzb("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.zza.zzaz().zzp(new zzkt(this, str, "_err", bundle));
    }
}
