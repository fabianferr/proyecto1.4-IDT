package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zztv {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Object obj;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            obj = ((SortedSet) iterable).comparator();
            if (obj == null) {
                obj = zztf.zza;
            }
        } else if (!(iterable instanceof zztu)) {
            return false;
        } else {
            obj = ((zztu) iterable).comparator();
        }
        return comparator.equals(obj);
    }
}
