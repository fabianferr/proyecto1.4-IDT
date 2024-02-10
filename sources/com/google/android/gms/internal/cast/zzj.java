package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.SessionTransferCallback;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzj extends SessionTransferCallback {
    final /* synthetic */ zzk zza;

    public zzj(zzk zzk) {
        this.zza = zzk;
    }

    public final void onTransferFailed(int i, int i2) {
        zzk.zza.d("onTransferFailed with type = %d and reason = %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.zza.zzu();
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzf(zzk.zzh, i, i2), 232);
        this.zza.zzk = false;
    }

    public final void onTransferred(int i, SessionState sessionState) {
        zzk.zza.d("onTransferred with type = %d", Integer.valueOf(i));
        this.zza.zzu();
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzg(zzk.zzh, i), 231);
        this.zza.zzk = false;
        this.zza.zzh = null;
    }

    public final void onTransferring(int i) {
        zzk.zza.d("onTransferring with type = %d", Integer.valueOf(i));
        this.zza.zzk = true;
        this.zza.zzu();
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzg(zzk.zzh, i), 230);
    }
}
