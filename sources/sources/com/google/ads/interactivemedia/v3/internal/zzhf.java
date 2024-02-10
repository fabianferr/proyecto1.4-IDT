package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzhf implements OnFailureListener {
    public final /* synthetic */ zzhg zza;

    public /* synthetic */ zzhf(zzhg zzhg) {
        this.zza = zzhg;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzc(exc);
    }
}
