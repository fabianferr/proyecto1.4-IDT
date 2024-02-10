package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaan extends zzxi {
    zzaan() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        ArrayList arrayList = new ArrayList();
        zzacv.zzj();
        while (zzacv.zzq()) {
            try {
                arrayList.add(Integer.valueOf(zzacv.zzc()));
            } catch (NumberFormatException e) {
                throw new zzwz((Throwable) e);
            }
        }
        zzacv.zzl();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
        zzacx.zza();
        int length = atomicIntegerArray.length();
        for (int i = 0; i < length; i++) {
            zzacx.zzh((long) atomicIntegerArray.get(i));
        }
        zzacx.zzc();
    }
}
