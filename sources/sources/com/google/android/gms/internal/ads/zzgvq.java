package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgvq extends zzgra implements zzgsp {
    private zzgvq() {
        super(zzgvs.zzb);
    }

    public final zzgvq zza(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgvs.zze((zzgvs) this.zza, zzgpw);
        return this;
    }

    public final zzgvq zzb(String str) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgvs.zzd((zzgvs) this.zza, MimeTypes.IMAGE_PNG);
        return this;
    }

    public final zzgvq zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgvs.zzf((zzgvs) this.zza, 2);
        return this;
    }

    /* synthetic */ zzgvq(zzguq zzguq) {
        super(zzgvs.zzb);
    }
}
