package com.google.ads.interactivemedia.v3.internal;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzda extends zzdb {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzda(zzct zzct, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzct);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
