package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.1.1 */
final class zzea extends zzdt {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzed zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzea(zzed zzed, Activity activity) {
        super(zzed.zza, true);
        this.zzb = zzed;
        this.zza = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zza.zzj)).onActivityStopped(ObjectWrapper.wrap(this.zza), this.zzi);
    }
}
