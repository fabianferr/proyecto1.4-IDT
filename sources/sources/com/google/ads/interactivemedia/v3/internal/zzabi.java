package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.BitSet;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabi extends zzxi {
    zzabi() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        BitSet bitSet = new BitSet();
        zzacv.zzj();
        int zzt = zzacv.zzt();
        int i = 0;
        while (zzt != 2) {
            int i2 = zzt - 1;
            if (i2 == 5 || i2 == 6) {
                int zzc = zzacv.zzc();
                if (zzc == 0) {
                    continue;
                    i++;
                    zzt = zzacv.zzt();
                } else if (zzc != 1) {
                    throw new zzwz("Invalid bitset value " + zzc + ", expected 0 or 1; at path " + zzacv.zzf());
                }
            } else if (i2 != 7) {
                throw new zzwz("Invalid bitset value type: " + zzacw.zza(zzt) + "; at path " + zzacv.zze());
            } else if (!zzacv.zzs()) {
                i++;
                zzt = zzacv.zzt();
            }
            bitSet.set(i);
            i++;
            zzt = zzacv.zzt();
        }
        zzacv.zzl();
        return bitSet;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        zzacx.zza();
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            zzacx.zzh(bitSet.get(i) ? 1 : 0);
        }
        zzacx.zzc();
    }
}
