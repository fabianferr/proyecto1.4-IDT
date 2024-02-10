package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzfv {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }
}
