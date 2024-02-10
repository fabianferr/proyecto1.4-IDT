package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
abstract class zzgh {
    private final Handler zza = new Handler(Looper.getMainLooper());
    private final List zzb = new ArrayList(1);

    zzgh(long j) {
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        VideoProgressUpdate zza2 = zza();
        for (zzgg zza3 : this.zzb) {
            zza3.zza(zza2);
        }
        this.zza.postDelayed(new zzgf(this), 200);
    }

    /* access modifiers changed from: package-private */
    public abstract VideoProgressUpdate zza();

    /* access modifiers changed from: package-private */
    public final void zzc(zzgg zzgg) {
        this.zzb.add(zzgg);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzgg zzgg) {
        this.zzb.remove(zzgg);
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        this.zza.removeCallbacksAndMessages((Object) null);
        zzg();
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        this.zza.removeCallbacksAndMessages((Object) null);
    }
}
