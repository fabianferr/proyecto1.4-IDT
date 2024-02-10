package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzhq implements OnFailureListener {
    public final /* synthetic */ zzhu zza;
    public final /* synthetic */ zzhk zzb;

    public /* synthetic */ zzhq(zzhu zzhu, zzhk zzhk) {
        this.zza = zzhu;
        this.zzb = zzhk;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzg(this.zzb, exc);
    }
}
