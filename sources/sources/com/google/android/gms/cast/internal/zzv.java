package com.google.android.gms.cast.internal;

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.zzdy;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzv extends zzah {
    private final AtomicReference zza;
    private final Handler zzb;

    public zzv(zzw zzw) {
        this.zza = new AtomicReference(zzw);
        this.zzb = new zzdy(zzw.getLooper());
    }

    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zzh = applicationMetadata;
            zzw.zzy = applicationMetadata.getApplicationId();
            zzw.zzz = str2;
            zzw.zzo = str;
            synchronized (zzw.zzf) {
                if (zzw.zzC != null) {
                    zzw.zzC.setResult(new zzq(new Status(0), applicationMetadata, str, str2, z));
                    zzw.zzC = null;
                }
            }
        }
    }

    public final void zzc(int i) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zzR(i);
        }
    }

    public final void zzd(int i) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zzy = null;
            zzw.zzz = null;
            zzw.zzab(i);
            if (zzw.zzj != null) {
                this.zzb.post(new zzr(this, zzw, i));
            }
        }
    }

    public final void zze(int i) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zzab(i);
        }
    }

    public final void zzf(zza zza2) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zze.d("onApplicationStatusChanged", new Object[0]);
            this.zzb.post(new zzt(this, zzw, zza2));
        }
    }

    public final void zzg(int i) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zzab(i);
        }
    }

    public final void zzh(String str, byte[] bArr) {
        if (((zzw) this.zza.get()) != null) {
            zzw.zze.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }
    }

    public final void zzi(int i) {
    }

    public final void zzj(zzab zzab) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zze.d("onDeviceStatusChanged", new Object[0]);
            this.zzb.post(new zzs(this, zzw, zzab));
        }
    }

    public final void zzk(int i) {
        zzw zzq = zzq();
        if (zzq != null) {
            zzw.zze.d("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            if (i != 0) {
                zzq.triggerConnectionSuspended(2);
            }
        }
    }

    public final void zzl(String str, long j) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zzaa(j, 0);
        }
    }

    public final void zzm(String str, long j, int i) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zzaa(j, i);
        }
    }

    public final void zzn(String str, double d, boolean z) {
        zzw.zze.d("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    public final void zzo(int i) {
    }

    public final void zzp(String str, String str2) {
        zzw zzw = (zzw) this.zza.get();
        if (zzw != null) {
            zzw.zze.d("Receive (type=text, ns=%s) %s", str, str2);
            this.zzb.post(new zzu(this, zzw, str, str2));
        }
    }

    public final zzw zzq() {
        zzw zzw = (zzw) this.zza.getAndSet((Object) null);
        if (zzw == null) {
            return null;
        }
        zzw.zzY();
        return zzw;
    }

    public final boolean zzr() {
        return this.zza.get() == null;
    }
}
