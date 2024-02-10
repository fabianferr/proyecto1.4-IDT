package com.google.ads.interactivemedia.v3.internal;

import kotlin.UByte$$ExternalSyntheticBackport0;
import sun.misc.Unsafe;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzue {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!UByte$$ExternalSyntheticBackport0.m(unsafe, obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
