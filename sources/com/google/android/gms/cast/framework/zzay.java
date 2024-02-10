package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzay extends zzat {
    final /* synthetic */ Session zza;

    /* synthetic */ zzay(Session session, zzax zzax) {
        this.zza = session;
    }

    public final long zzb() {
        return this.zza.getSessionRemainingTimeMs();
    }

    public final IObjectWrapper zzc() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final void zzd(boolean z) {
        this.zza.end(z);
    }

    public final void zze(Bundle bundle) {
        this.zza.onResuming(bundle);
    }

    public final void zzf(Bundle bundle) {
        this.zza.onStarting(bundle);
    }

    public final void zzg(Bundle bundle) {
        this.zza.resume(bundle);
    }

    public final void zzh(Bundle bundle) {
        this.zza.start(bundle);
    }

    public final void zzi(Bundle bundle) {
        this.zza.zzi(bundle);
    }
}
