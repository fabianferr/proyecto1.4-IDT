package com.google.ads.interactivemedia.v3.internal;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzmj implements PackageManager.OnChecksumsReadyListener {
    public final /* synthetic */ zzvx zza;

    public /* synthetic */ zzmj(zzvx zzvx) {
        this.zza = zzvx;
    }

    public final void onChecksumsReady(List list) {
        zzvx zzvx = this.zza;
        if (list == null) {
            zzvx.zzc((Object) null);
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                if (apkChecksum.getType() == 8) {
                    zzvx.zzc(zzkw.zzb(apkChecksum.getValue()));
                    return;
                }
            }
            zzvx.zzc((Object) null);
        } catch (Throwable unused) {
            zzvx.zzc((Object) null);
        }
    }
}
