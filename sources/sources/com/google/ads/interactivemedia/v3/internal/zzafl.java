package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzafl extends zzafn {
    private zzafl() {
        super((zzafm) null);
    }

    /* synthetic */ zzafl(zzafk zzafk) {
        super((zzafm) null);
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j) {
        zzaez zzaez = (zzaez) zzaht.zzf(obj, j);
        if (zzaez.zzc()) {
            return zzaez;
        }
        int size = zzaez.size();
        zzaez zzd = zzaez.zzd(size == 0 ? 10 : size + size);
        zzaht.zzs(obj, j, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzaez) zzaht.zzf(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j) {
        zzaez zzaez = (zzaez) zzaht.zzf(obj, j);
        zzaez zzaez2 = (zzaez) zzaht.zzf(obj2, j);
        int size = zzaez.size();
        int size2 = zzaez2.size();
        if (size > 0 && size2 > 0) {
            if (!zzaez.zzc()) {
                zzaez = zzaez.zzd(size2 + size);
            }
            zzaez.addAll(zzaez2);
        }
        if (size > 0) {
            zzaez2 = zzaez;
        }
        zzaht.zzs(obj, j, zzaez2);
    }
}
