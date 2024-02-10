package com.google.android.gms.internal.pal;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
final class zziu {
    static void zza(Object obj, Object obj2) {
        if (obj == null) {
            Objects.toString(obj2);
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }
}
