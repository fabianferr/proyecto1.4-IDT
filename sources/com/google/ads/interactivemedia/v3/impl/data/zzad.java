package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzso;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzad extends zzbk {
    private zzso<zzbm> obstructions;

    zzad() {
    }

    public zzbn build() {
        zzso<zzbm> zzso = this.obstructions;
        if (zzso != null) {
            return new zzaf(zzso);
        }
        throw new IllegalStateException("Missing required properties: obstructions");
    }

    public zzbk obstructions(List<zzbm> list) {
        this.obstructions = zzso.zzk(list);
        return this;
    }
}
