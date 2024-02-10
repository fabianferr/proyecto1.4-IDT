package com.google.android.gms.internal.ads;

import com.facebook.bolts.AppLinks;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbpv implements zzbpu {
    private final zzeak zza;

    public zzbpv(zzeak zzeak) {
        Preconditions.checkNotNull(zzeak, "The Inspector Manager must not be null");
        this.zza = zzeak;
    }

    public final void zza(Object obj, Map map) {
        if (map != null && map.containsKey(AppLinks.KEY_NAME_EXTRAS)) {
            long j = Long.MAX_VALUE;
            if (map.containsKey(ClientCookie.EXPIRES_ATTR)) {
                try {
                    j = Long.parseLong((String) map.get(ClientCookie.EXPIRES_ATTR));
                } catch (NumberFormatException unused) {
                }
            }
            this.zza.zzi((String) map.get(AppLinks.KEY_NAME_EXTRAS), j);
        }
    }
}
