package com.google.android.gms.internal.atv_ads_framework;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public abstract class zzaf extends zzy implements Set {
    @CheckForNull
    private transient zzab zza;

    zzaf() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzam.zza(this);
    }

    public zzab zzd() {
        zzab zzab = this.zza;
        if (zzab != null) {
            return zzab;
        }
        zzab zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* renamed from: zze */
    public abstract zzan iterator();

    /* access modifiers changed from: package-private */
    public zzab zzh() {
        return zzab.zzi(toArray());
    }
}
