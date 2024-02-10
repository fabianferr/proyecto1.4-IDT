package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjc extends zzap {
    final /* synthetic */ zzjs zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjc(zzjs zzjs, zzgt zzgt) {
        super(zzgt);
        this.zza = zzjs;
    }

    public final void zzc() {
        zzjs zzjs = this.zza;
        zzjs.zzg();
        if (zzjs.zzL()) {
            zzjs.zzs.zzay().zzj().zza("Inactivity, disconnecting from the service");
            zzjs.zzs();
        }
    }
}
