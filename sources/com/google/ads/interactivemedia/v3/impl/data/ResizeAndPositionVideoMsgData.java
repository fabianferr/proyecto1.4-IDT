package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzaj.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class ResizeAndPositionVideoMsgData {
    public static ResizeAndPositionVideoMsgData create(Integer num, Integer num2, Integer num3, Integer num4) {
        return new zzaj(num, num2, num3, num4);
    }

    public abstract Integer height();

    public final String toString() {
        Integer x = x();
        Integer y = y();
        Integer width = width();
        Integer height = height();
        return "ResizeAndPositionVideoMsgData [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
    }

    public abstract Integer width();

    public abstract Integer x();

    public abstract Integer y();
}
