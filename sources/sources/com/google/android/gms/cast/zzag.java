package com.google.android.gms.cast;

import androidx.mediarouter.media.MediaRouter;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzag extends MediaRouter.Callback {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    zzag(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    public final void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        this.zza.zzv("onRouteUnselected");
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.zza;
        if (castRemoteDisplayLocalService.zzm == null) {
            castRemoteDisplayLocalService.zzv("onRouteUnselected, no device was selected");
            return;
        }
        CastDevice fromBundle = CastDevice.getFromBundle(routeInfo.getExtras());
        if (fromBundle == null || !fromBundle.getDeviceId().equals(this.zza.zzm.getDeviceId())) {
            this.zza.zzv("onRouteUnselected, device does not match");
        } else {
            CastRemoteDisplayLocalService.stopService();
        }
    }
}
