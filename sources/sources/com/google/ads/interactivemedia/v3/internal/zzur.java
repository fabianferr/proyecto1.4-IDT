package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzur extends zzui {
    /* access modifiers changed from: private */
    @CheckForNull
    public zzuq zza;

    zzur(zzsk zzsk, boolean z, Executor executor, Callable callable) {
        super(zzsk, false, false);
        this.zza = new zzup(this, callable, executor);
        zzq();
    }

    /* access modifiers changed from: protected */
    public final void zzn() {
        zzuq zzuq = this.zza;
        if (zzuq != null) {
            zzuq.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        zzuq zzuq = this.zza;
        if (zzuq != null) {
            zzuq.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzr(int i) {
        super.zzr(i);
        if (i == 1) {
            this.zza = null;
        }
    }
}
