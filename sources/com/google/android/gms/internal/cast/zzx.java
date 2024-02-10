package com.google.android.gms.internal.cast;

import androidx.mediarouter.media.MediaRouter;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzx implements Comparator {
    public static final zzx zza = new zzx();

    zzx() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((MediaRouter.RouteInfo) obj).getName().compareToIgnoreCase(((MediaRouter.RouteInfo) obj2).getName());
    }
}
