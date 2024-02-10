package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final /* synthetic */ class zzhc implements Runnable {
    public final /* synthetic */ zzid zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzhc(zzid zzid, Bundle bundle, long j) {
        this.zza = zzid;
        this.zzb = bundle;
        this.zzc = j;
    }

    public final void run() {
        zzid zzid = this.zza;
        Bundle bundle = this.zzb;
        long j = this.zzc;
        if (TextUtils.isEmpty(zzid.zzs.zzh().zzm())) {
            zzid.zzR(bundle, 0, j);
        } else {
            zzid.zzs.zzay().zzl().zza("Using developer consent only; google app id found");
        }
    }
}
