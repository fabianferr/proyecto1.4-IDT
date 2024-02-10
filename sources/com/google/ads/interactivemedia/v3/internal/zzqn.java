package com.google.ads.interactivemedia.v3.internal;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzqn {
    final /* synthetic */ zzqo zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzqn(zzqo zzqo, byte[] bArr, zzqm zzqm) {
        this.zza = zzqo;
        this.zzb = bArr;
    }

    public final zzqn zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzqn zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzqo zzqo = this.zza;
            if (zzqo.zzb) {
                zzqo.zza.zzj(this.zzb);
                this.zza.zza.zzi(this.zzc);
                this.zza.zza.zzg(this.zzd);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }
}
