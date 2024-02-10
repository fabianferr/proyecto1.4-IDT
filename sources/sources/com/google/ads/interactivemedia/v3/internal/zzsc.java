package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzsc extends zzsg {
    zzsc(zzsh zzsh) {
        super(zzsh);
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int zzd = this.zzb.zzd(key, zzsi.zzc(key));
            if (zzd == -1 || !zzri.zza(this.zzb.zza[zzd], value)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean remove(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        int zzc = zzsi.zzc(key);
        int zzd = this.zzb.zzd(key, zzc);
        if (zzd == -1 || !zzri.zza(this.zzb.zza[zzd], value)) {
            return false;
        }
        this.zzb.zzm(zzd, zzc);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(int i) {
        return new zzrz(this.zzb, i);
    }
}
