package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzwk extends zzxi {
    final /* synthetic */ zzxi zza;

    zzwk(zzxi zzxi) {
        this.zza = zzxi;
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        ArrayList arrayList = new ArrayList();
        zzacv.zzj();
        while (zzacv.zzq()) {
            arrayList.add(Long.valueOf(((Number) this.zza.read(zzacv)).longValue()));
        }
        zzacv.zzl();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i = 0; i < size; i++) {
            atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
        }
        return atomicLongArray;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        zzacx.zza();
        int length = atomicLongArray.length();
        for (int i = 0; i < length; i++) {
            this.zza.write(zzacx, Long.valueOf(atomicLongArray.get(i)));
        }
        zzacx.zzc();
    }
}
