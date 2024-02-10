package com.google.android.gms.internal.cast;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzag {
    public static Map zza(Bundle bundle, String str) {
        Map map = (Map) bundle.getSerializable(str);
        if (map == null) {
            return zzfk.zzd();
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!(entry == null || entry.getKey() == null || entry.getValue() == null)) {
                hashMap.put((Integer) entry.getKey(), (Integer) entry.getValue());
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
