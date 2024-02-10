package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zztd {
    @CheckForNull
    static Object zza(@CheckForNull Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static HashMap zzb(int i) {
        int i2;
        if (i < 3) {
            zzrv.zza(i, "expectedSize");
            i2 = i + 1;
        } else if (i < 1073741824) {
            double d = (double) i;
            Double.isNaN(d);
            i2 = (int) Math.ceil(d / 0.75d);
        } else {
            i2 = Integer.MAX_VALUE;
        }
        return new HashMap(i2);
    }
}
