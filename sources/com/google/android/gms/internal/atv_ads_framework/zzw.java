package com.google.android.gms.internal.atv_ads_framework;

import java.util.Objects;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zzw {
    static void zza(Object obj, Object obj2) {
        if (obj == null) {
            Objects.toString(obj2);
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }
}
