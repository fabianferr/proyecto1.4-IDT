package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzfm extends LruCache {
    final /* synthetic */ zzfp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfm(zzfp zzfp, int i) {
        super(20);
        this.zza = zzfp;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfp.zzd(this.zza, str);
    }
}
