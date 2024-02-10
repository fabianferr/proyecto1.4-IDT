package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzbl {
    public abstract zzbl attached(boolean z);

    public abstract zzbl bounds(zzau zzau);

    public abstract zzbm build();

    public abstract zzbl detailedReason(String str);

    public abstract zzbl hidden(boolean z);

    public abstract zzbl purpose(FriendlyObstructionPurpose friendlyObstructionPurpose);

    public abstract zzbl type(String str);

    /* access modifiers changed from: package-private */
    public zzbl view(View view) {
        zzau build = zzau.builder().locationOnScreenOfView(view).build();
        zzbl attached = attached(view.isAttachedToWindow());
        attached.bounds(build);
        attached.hidden(!view.isShown());
        attached.type(view.getClass().getCanonicalName());
        return attached;
    }
}
