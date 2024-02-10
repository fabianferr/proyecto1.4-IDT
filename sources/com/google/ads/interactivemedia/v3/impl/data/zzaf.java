package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzso;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaf extends zzbn {
    private final zzso<zzbm> obstructions;

    private zzaf(zzso<zzbm> zzso) {
        this.obstructions = zzso;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbn) {
            return this.obstructions.equals(((zzbn) obj).obstructions());
        }
        return false;
    }

    public int hashCode() {
        return this.obstructions.hashCode() ^ 1000003;
    }

    /* access modifiers changed from: package-private */
    public zzso<zzbm> obstructions() {
        return this.obstructions;
    }

    public String toString() {
        String valueOf = String.valueOf(this.obstructions);
        return "ObstructionListData{obstructions=" + valueOf + "}";
    }
}
