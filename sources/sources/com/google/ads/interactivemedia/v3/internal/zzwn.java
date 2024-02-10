package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzwn {
    private zzyn zza = zzyn.zza;
    private final zzwf zzb = zzwe.IDENTITY;
    private final Map zzc = new HashMap();
    private final List zzd = new ArrayList();
    private final List zze = new ArrayList();
    private final zzxg zzf;
    private final zzxg zzg;
    private final LinkedList zzh;

    public zzwn() {
        int i = zzwm.zzn;
        this.zzf = zzwm.zzb;
        this.zzg = zzwm.zzc;
        this.zzh = new LinkedList();
    }

    public final zzwm zza() {
        ArrayList arrayList = r1;
        ArrayList arrayList2 = new ArrayList(this.zzd.size() + this.zze.size() + 3);
        arrayList2.addAll(this.zzd);
        Collections.reverse(arrayList2);
        ArrayList arrayList3 = new ArrayList(this.zze);
        Collections.reverse(arrayList3);
        arrayList2.addAll(arrayList3);
        boolean z = zzacs.zza;
        zzyn zzyn = this.zza;
        zzwf zzwf = this.zzb;
        HashMap hashMap = r5;
        HashMap hashMap2 = new HashMap(this.zzc);
        ArrayList arrayList4 = r5;
        ArrayList arrayList5 = new ArrayList(this.zzd);
        ArrayList arrayList6 = r5;
        ArrayList arrayList7 = new ArrayList(this.zze);
        zzxg zzxg = this.zzf;
        zzxg zzxg2 = this.zzg;
        ArrayList arrayList8 = r5;
        ArrayList arrayList9 = new ArrayList(this.zzh);
        return new zzwm(zzyn, zzwf, hashMap, false, false, false, true, (zzwg) null, false, false, true, 1, (String) null, 2, 2, arrayList4, arrayList6, arrayList, zzxg, zzxg2, arrayList8);
    }

    public final zzwn zzb(Type type, Object obj) {
        boolean z = obj instanceof zzwy;
        boolean z2 = true;
        if (!z && !(obj instanceof zzwq) && !(obj instanceof zzwo) && !(obj instanceof zzxi)) {
            z2 = false;
        }
        zzxm.zza(z2);
        if (obj instanceof zzwo) {
            this.zzc.put(type, (zzwo) obj);
        }
        if (z || (obj instanceof zzwq)) {
            this.zzd.add(zzaal.zzb(zzact.zzb(type), obj));
        }
        if (obj instanceof zzxi) {
            this.zzd.add(zzaby.zza(zzact.zzb(type), (zzxi) obj));
        }
        return this;
    }

    public final zzwn zzc(zzxj zzxj) {
        this.zzd.add(zzxj);
        return this;
    }

    public final zzwn zzd(zzqz zzqz) {
        this.zza = this.zza.zze(zzqz, true, false);
        return this;
    }
}
