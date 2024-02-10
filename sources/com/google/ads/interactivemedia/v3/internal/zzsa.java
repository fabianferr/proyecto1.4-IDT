package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzsa extends zzsg {
    final /* synthetic */ zzsh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzsa(zzsh zzsh) {
        super(zzsh);
        this.zza = zzsh;
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int zzc = this.zza.zzc(key, zzsi.zzc(key));
            if (zzc == -1 || !zzri.zza(value, this.zza.zzb[zzc])) {
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
        int zzc2 = this.zza.zzc(key, zzc);
        if (zzc2 == -1 || !zzri.zza(value, this.zza.zzb[zzc2])) {
            return false;
        }
        this.zza.zzl(zzc2, zzc);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(int i) {
        return new zzry(this.zza, i);
    }
}
