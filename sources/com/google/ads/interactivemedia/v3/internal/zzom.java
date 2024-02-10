package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzom implements RemoteCall {
    public final /* synthetic */ zzor zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzom(zzor zzor, String str, int i, String str2) {
        this.zza = zzor;
        this.zzb = str;
        this.zzc = i;
        this.zzd = str2;
    }

    public final void accept(Object obj, Object obj2) {
        zzor zzor = this.zza;
        String str = this.zzb;
        int i = this.zzc;
        String str2 = this.zzd;
        ((zzof) ((zzos) obj).getService()).zze(new zzog(str, i, str2), new zzoq(zzor, (TaskCompletionSource) obj2));
    }
}
