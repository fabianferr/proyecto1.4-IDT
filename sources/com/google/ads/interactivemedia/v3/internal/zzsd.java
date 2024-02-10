package com.google.ads.interactivemedia.v3.internal;

import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzsd extends zzsg {
    final /* synthetic */ zzsh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzsd(zzsh zzsh) {
        super(zzsh);
        this.zza = zzsh;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    public final boolean remove(@CheckForNull Object obj) {
        int zzc = zzsi.zzc(obj);
        int zzc2 = this.zza.zzc(obj, zzc);
        if (zzc2 == -1) {
            return false;
        }
        this.zza.zzl(zzc2, zzc);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Object zza(int i) {
        return this.zza.zza[i];
    }
}
