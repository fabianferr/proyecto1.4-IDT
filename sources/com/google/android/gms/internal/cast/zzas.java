package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import android.text.TextUtils;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzas extends MediaRouter.Callback {
    private static final Logger zza = new Logger("MediaRouterCallback");
    private final zzan zzb;

    public zzas(zzan zzan) {
        this.zzb = (zzan) Preconditions.checkNotNull(zzan);
    }

    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzf(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            Class<zzan> cls = zzan.class;
            zza.d(e, "Unable to call %s on %s.", "onRouteAdded", "zzan");
        }
    }

    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzg(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            Class<zzan> cls = zzan.class;
            zza.d(e, "Unable to call %s on %s.", "onRouteChanged", "zzan");
        }
    }

    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzh(routeInfo.getId(), routeInfo.getExtras());
        } catch (RemoteException e) {
            Class<zzan> cls = zzan.class;
            zza.d(e, "Unable to call %s on %s.", "onRouteRemoved", "zzan");
        }
    }

    public final void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i) {
        CastDevice fromBundle;
        zza.i("onRouteSelected with reason = %d, routeId = %s", Integer.valueOf(i), routeInfo.getId());
        if (routeInfo.getPlaybackType() == 1) {
            try {
                String id = routeInfo.getId();
                String id2 = routeInfo.getId();
                if (id2 != null) {
                    if (id2.endsWith("-groupRoute")) {
                        CastDevice fromBundle2 = CastDevice.getFromBundle(routeInfo.getExtras());
                        if (fromBundle2 != null) {
                            String deviceId = fromBundle2.getDeviceId();
                            Iterator<MediaRouter.RouteInfo> it = mediaRouter.getRoutes().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    MediaRouter.RouteInfo next = it.next();
                                    String id3 = next.getId();
                                    if (id3 != null && !id3.endsWith("-groupRoute") && (fromBundle = CastDevice.getFromBundle(next.getExtras())) != null && TextUtils.equals(fromBundle.getDeviceId(), deviceId)) {
                                        zza.d("routeId is changed from %s to %s", id2, next.getId());
                                        id2 = next.getId();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                if (this.zzb.zze() >= 220400000) {
                    this.zzb.zzj(id2, id, routeInfo.getExtras());
                } else {
                    this.zzb.zzi(id2, routeInfo.getExtras());
                }
            } catch (RemoteException e) {
                Class<zzan> cls = zzan.class;
                zza.d(e, "Unable to call %s on %s.", "onRouteSelected", "zzan");
            }
        }
    }

    public final void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i) {
        Logger logger = zza;
        logger.i("onRouteUnselected with reason = %d, routeId = %s", Integer.valueOf(i), routeInfo.getId());
        if (routeInfo.getPlaybackType() != 1) {
            logger.d("skip route unselection for non-cast route", new Object[0]);
            return;
        }
        try {
            this.zzb.zzk(routeInfo.getId(), routeInfo.getExtras(), i);
        } catch (RemoteException e) {
            Class<zzan> cls = zzan.class;
            zza.d(e, "Unable to call %s on %s.", "onRouteUnselected", "zzan");
        }
    }
}
