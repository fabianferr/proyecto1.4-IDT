package com.google.android.gms.internal.cast;

import android.hardware.display.VirtualDisplay;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

@Deprecated
/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzdm implements CastRemoteDisplayApi {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("CastRemoteDisplayApiImpl");
    /* access modifiers changed from: private */
    public final Api zzb;
    /* access modifiers changed from: private */
    public VirtualDisplay zzc;
    /* access modifiers changed from: private */
    public final zzdu zzd = new zzde(this);

    public zzdm(Api api) {
        this.zzb = api;
    }

    static /* bridge */ /* synthetic */ void zzf(zzdm zzdm) {
        VirtualDisplay virtualDisplay = zzdm.zzc;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                Logger logger = zza;
                int displayId = virtualDisplay.getDisplay().getDisplayId();
                logger.d("releasing virtual display: " + displayId, new Object[0]);
            }
            virtualDisplay.release();
        }
        zzdm.zzc = null;
    }

    public final PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient googleApiClient, String str) {
        zza.d("startRemoteDisplay", new Object[0]);
        return googleApiClient.execute(new zzdf(this, googleApiClient, str));
    }

    public final PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient googleApiClient) {
        zza.d("stopRemoteDisplay", new Object[0]);
        return googleApiClient.execute(new zzdg(this, googleApiClient));
    }
}
