package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzki extends zzf {
    protected final zzkh zza = new zzkh(this);
    protected final zzkg zzb = new zzkg(this);
    protected final zzke zzc = new zzke(this);
    /* access modifiers changed from: private */
    public Handler zzd;

    zzki(zzfy zzfy) {
        super(zzfy);
    }

    static /* bridge */ /* synthetic */ void zzj(zzki zzki, long j) {
        zzki.zzg();
        zzki.zzm();
        zzki.zzs.zzay().zzj().zzb("Activity paused, time", Long.valueOf(j));
        zzki.zzc.zza(j);
        if (zzki.zzs.zzf().zzu()) {
            zzki.zzb.zzb(j);
        }
    }

    static /* bridge */ /* synthetic */ void zzl(zzki zzki, long j) {
        zzki.zzg();
        zzki.zzm();
        zzki.zzs.zzay().zzj().zzb("Activity resumed, time", Long.valueOf(j));
        if (zzki.zzs.zzf().zzu() || zzki.zzs.zzm().zzl.zzb()) {
            zzki.zzb.zzc(j);
        }
        zzki.zzc.zzb();
        zzkh zzkh = zzki.zza;
        zzkh.zza.zzg();
        if (zzkh.zza.zzs.zzJ()) {
            zzkh.zzb(zzkh.zza.zzs.zzav().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }
}
