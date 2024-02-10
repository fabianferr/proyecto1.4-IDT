package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzai.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzbm {
    public static zzbl builder() {
        return new zzag();
    }

    /* access modifiers changed from: package-private */
    public abstract boolean attached();

    /* access modifiers changed from: package-private */
    public abstract zzau bounds();

    /* access modifiers changed from: package-private */
    public abstract String detailedReason();

    /* access modifiers changed from: package-private */
    public abstract boolean hidden();

    /* access modifiers changed from: package-private */
    public abstract FriendlyObstructionPurpose purpose();

    /* access modifiers changed from: package-private */
    public abstract String type();
}
