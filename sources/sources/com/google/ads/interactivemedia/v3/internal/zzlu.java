package com.google.ads.interactivemedia.v3.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzlu extends zzmh {
    private static volatile String zzi;
    private static final Object zzj = new Object();

    public zzlu(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2) {
        super(zzkt, "QBqMoqZOjZFV4YW5/t2Hbr0v3w8hv3Wy4gQeBCCG/svvv/IrCLMfoAtJdbejm8Rb", "9iQ8bStDvC5YUevNAeLLiqH5g88BBvTFio+X4540C94=", zzaf, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzB(ExifInterface.LONGITUDE_EAST);
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (String) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzB(zzi);
        }
    }
}
