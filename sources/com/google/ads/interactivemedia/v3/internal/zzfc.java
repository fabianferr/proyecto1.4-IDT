package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import java.lang.reflect.Type;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzfc implements zzwy {
    zzfc() {
    }

    public final /* bridge */ /* synthetic */ zzwr zza(Object obj, Type type, zzwx zzwx) {
        CompanionAdSlot companionAdSlot = (CompanionAdSlot) obj;
        int width = companionAdSlot.getWidth();
        int height = companionAdSlot.getHeight();
        return new zzww(width + "x" + height);
    }
}
