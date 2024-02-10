package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Looper;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.framework.zzaw;
import com.google.android.gms.cast.internal.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzay extends MediaRouter.Callback {
    private static final Logger zzb = new Logger("MRDiscoveryCallback");
    public final zzaw zza = new zzaw(this);
    private final Set zzc = Collections.synchronizedSet(new LinkedHashSet());
    private final Map zzd = Collections.synchronizedMap(new HashMap());
    private final LinkedHashSet zze = new LinkedHashSet();
    private final zzax zzf;

    public zzay(Context context) {
        this.zzf = new zzax(context);
    }

    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        zzb.d("MediaRouterDiscoveryCallback.onRouteAdded.", new Object[0]);
        zzf(routeInfo, true);
    }

    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        zzb.d("MediaRouterDiscoveryCallback.onRouteChanged.", new Object[0]);
        zzf(routeInfo, true);
    }

    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        zzb.d("MediaRouterDiscoveryCallback.onRouteRemoved.", new Object[0]);
        zzf(routeInfo, false);
    }

    public final void zza(List list) {
        Logger logger = zzb;
        int size = list.size();
        logger.d("SetRouteDiscovery for " + size + " IDs", new Object[0]);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(zzen.zza((String) it.next()));
        }
        zzb.d("resetting routes. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(String.valueOf(this.zzd.keySet()))), new Object[0]);
        HashMap hashMap = new HashMap();
        synchronized (this.zzd) {
            for (String str : linkedHashSet) {
                zzav zzav = (zzav) this.zzd.get(zzen.zza(str));
                if (zzav != null) {
                    hashMap.put(str, zzav);
                }
            }
            this.zzd.clear();
            this.zzd.putAll(hashMap);
        }
        zzb.d("Routes reset. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(String.valueOf(this.zzd.keySet()))), new Object[0]);
        synchronized (this.zze) {
            this.zze.clear();
            this.zze.addAll(linkedHashSet);
        }
        zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        Logger logger = zzb;
        int size = this.zze.size();
        logger.d("Starting RouteDiscovery with " + size + " IDs", new Object[0]);
        logger.d("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(String.valueOf(this.zzd.keySet()))), new Object[0]);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzc();
        } else {
            new zzdy(Looper.getMainLooper()).post(new zzau(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzf.zzb(this);
        synchronized (this.zze) {
            Iterator it = this.zze.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MediaRouteSelector build = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(str)).build();
                if (((zzav) this.zzd.get(str)) == null) {
                    this.zzd.put(str, new zzav(build));
                }
                Logger logger = zzb;
                String categoryForCast = CastMediaControlIntent.categoryForCast(str);
                logger.d("Adding mediaRouter callback for control category " + categoryForCast, new Object[0]);
                this.zzf.zza().addCallback(build, this, 4);
            }
        }
        zzb.d("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(String.valueOf(this.zzd.keySet()))), new Object[0]);
    }

    public final void zzd() {
        zzb.d("Stopping RouteDiscovery.", new Object[0]);
        this.zzd.clear();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zzf.zzb(this);
        } else {
            new zzdy(Looper.getMainLooper()).post(new zzat(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        this.zzf.zzb(this);
    }

    public final void zzf(MediaRouter.RouteInfo routeInfo, boolean z) {
        boolean z2;
        zzfl zzfl;
        boolean z3;
        Logger logger = zzb;
        logger.d("MediaRouterDiscoveryCallback.updateRouteToAppIds (add=%b) route %s", Boolean.valueOf(z), routeInfo);
        synchronized (this.zzd) {
            String valueOf = String.valueOf(this.zzd.keySet());
            logger.d("appIdToRouteInfo has these appId route keys: " + valueOf, new Object[0]);
            z2 = false;
            for (Map.Entry entry : this.zzd.entrySet()) {
                String str = (String) entry.getKey();
                zzav zzav = (zzav) entry.getValue();
                if (routeInfo.matchesSelector(zzav.zzb)) {
                    if (z) {
                        Logger logger2 = zzb;
                        logger2.d("Adding/updating route for appId " + str, new Object[0]);
                        z3 = zzav.zza.add(routeInfo);
                        if (!z3) {
                            String valueOf2 = String.valueOf(routeInfo);
                            logger2.w("Route " + valueOf2 + " already exists for appId " + str, new Object[0]);
                        }
                    } else {
                        Logger logger3 = zzb;
                        logger3.d("Removing route for appId " + str, new Object[0]);
                        z3 = zzav.zza.remove(routeInfo);
                        if (!z3) {
                            String valueOf3 = String.valueOf(routeInfo);
                            logger3.w("Route " + valueOf3 + " already removed from appId " + str, new Object[0]);
                        }
                    }
                    z2 = z3;
                }
            }
        }
        if (z2) {
            zzb.d("Invoking callback.onRouteUpdated.", new Object[0]);
            synchronized (this.zzc) {
                HashMap hashMap = new HashMap();
                synchronized (this.zzd) {
                    for (String str2 : this.zzd.keySet()) {
                        zzav zzav2 = (zzav) this.zzd.get(zzen.zza(str2));
                        if (zzav2 == null) {
                            zzfl = zzfl.zzk();
                        } else {
                            zzfl = zzfl.zzj(zzav2.zza);
                        }
                        if (!zzfl.isEmpty()) {
                            hashMap.put(str2, zzfl);
                        }
                    }
                }
                zzfk.zzc(hashMap.entrySet());
                for (zzaw zza2 : this.zzc) {
                    zza2.zza();
                }
            }
        }
    }
}
