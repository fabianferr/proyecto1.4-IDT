package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcrs implements zzfbp {
    private final zzcpw zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    /* synthetic */ zzcrs(zzcpw zzcpw, zzcrr zzcrr) {
        this.zza = zzcpw;
    }

    public final /* synthetic */ zzfbp zza(zzq zzq) {
        zzq.getClass();
        this.zzd = zzq;
        return this;
    }

    public final /* synthetic */ zzfbp zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfbp zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfbq zzd() {
        zzgxq.zzc(this.zzb, Context.class);
        zzgxq.zzc(this.zzc, String.class);
        zzgxq.zzc(this.zzd, zzq.class);
        return new zzcru(this.zza, this.zzb, this.zzc, this.zzd, (zzcrt) null);
    }
}
