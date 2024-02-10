package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.impl.data.zzbo;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzhv {
    public static List zza(SecureSignals secureSignals, List list) {
        if (secureSignals != null) {
            list.add(zzbo.createBy1stPartyData(secureSignals));
        }
        return list;
    }
}
