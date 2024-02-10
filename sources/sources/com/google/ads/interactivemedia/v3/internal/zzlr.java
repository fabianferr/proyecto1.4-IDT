package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzlr extends zzmh {
    private final zzkl zzi;

    public zzlr(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, zzkl zzkl) {
        super(zzkt, "arUAIOjzzWAni7xTOswaHQr3wtwyzPRaYoBef/ZyPO7309A9Cz1g/8S+xyESDVpo", "HeIaWctQk46NnQnOwQLKiY+3aHDGAM/VBIR1Ph30xLs=", zzaf, i, 94);
        this.zzi = zzkl;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int intValue = ((Integer) this.zzf.invoke((Object) null, new Object[]{this.zzi.zza()})).intValue();
        synchronized (this.zze) {
            this.zze.zzae(zzat.zza(intValue));
        }
    }
}
