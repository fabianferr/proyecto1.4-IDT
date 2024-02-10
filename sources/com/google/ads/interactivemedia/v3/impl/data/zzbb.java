package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzx.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzbb {
    public abstract String alternateText();

    public abstract String creativeType();

    public abstract int height();

    public abstract String imageUrl();

    public final String toString() {
        int width = width();
        int height = height();
        String imageUrl = imageUrl();
        String alternateText = alternateText();
        String creativeType = creativeType();
        return "IconClickFallbackImageMsgData [width=" + width + ", height=" + height + ", imageUrl=" + imageUrl + ", alternateText=" + alternateText + ", creativeType=" + creativeType + "]";
    }

    public abstract int width();
}
