package com.google.android.gms.internal.cast;

import androidx.mediarouter.media.MediaRouter;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzw extends MediaRouter.Callback {
    final /* synthetic */ zzy zza;

    zzw(zzy zzy) {
        this.zza = zzy;
    }

    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        this.zza.zzf();
    }

    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        this.zza.zzf();
    }

    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        this.zza.zzf();
    }

    public final void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i) {
        this.zza.zzs = routeInfo;
        this.zza.dismiss();
    }
}
