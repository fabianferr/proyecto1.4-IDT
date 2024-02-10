package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.v3.impl.data.AdImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzfj {
    public final AdEvent.AdEventType zza;
    public final AdImpl zzb;
    public Map zzc;
    public List zzd = new ArrayList();
    AdProgressInfo zze;
    public List zzf;
    public double zzg;

    public zzfj(AdEvent.AdEventType adEventType, AdImpl adImpl) {
        this.zza = adEventType;
        this.zzb = adImpl;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return zzaie.zzf(this, obj, false, (Class) null, false, new String[0]);
    }

    public final int hashCode() {
        return zzaig.zza(this, new String[0]);
    }
}
