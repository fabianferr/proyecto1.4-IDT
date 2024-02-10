package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
abstract class zzui extends zzuo {
    private static final Logger zza = Logger.getLogger(zzui.class.getName());
    @CheckForNull
    private zzsk zzc;

    zzui(zzsk zzsk, boolean z, boolean z2) {
        super(zzsk.size());
        zzsk.getClass();
        this.zzc = zzsk;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzsk zzsk = this.zzc;
        if (zzsk != null) {
            return "futures=".concat(zzsk.toString());
        }
        return super.zza();
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzsk zzsk = this.zzc;
        boolean z = true;
        zzr(1);
        boolean isCancelled = isCancelled();
        if (zzsk == null) {
            z = false;
        }
        if (z && isCancelled) {
            boolean zzo = zzo();
            zztx zzn = ((zzso) zzsk).listIterator(0);
            while (zzn.hasNext()) {
                ((Future) zzn.next()).cancel(zzo);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zzp();

    /* access modifiers changed from: package-private */
    public final void zzq() {
        zzsk zzsk = this.zzc;
        zzsk.getClass();
        if (zzsk.isEmpty()) {
            zzp();
            return;
        }
        zzuh zzuh = new zzuh(this, (zzsk) null);
        zztx zzn = ((zzso) this.zzc).listIterator(0);
        while (zzn.hasNext()) {
            ((zzvq) zzn.next()).zzm(zzuh, zzus.INSTANCE);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzr(int i) {
        this.zzc = null;
    }
}
