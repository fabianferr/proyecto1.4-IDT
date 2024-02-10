package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import android.view.ViewParent;
import com.google.ads.interactivemedia.omid.library.adsession.zze;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import org.json.JSONObject;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzch implements zzcf {
    private final zzcf zza;

    public zzch(zzcf zzcf) {
        this.zza = zzcf;
    }

    public final JSONObject zza(View view) {
        throw null;
    }

    public final void zzb(View view, JSONObject jSONObject, zzce zzce, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        zzbx zza2 = zzbx.zza();
        if (zza2 != null) {
            Collection<zze> zzb = zza2.zzb();
            int size = zzb.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            for (zze zzg : zzb) {
                View zzg2 = zzg.zzg();
                if (zzg2 != null && zzg2.isAttachedToWindow() && zzg2.isShown()) {
                    View view2 = zzg2;
                    while (true) {
                        if (view2 != null) {
                            if (view2.getAlpha() == 0.0f) {
                                break;
                            }
                            ViewParent parent = view2.getParent();
                            view2 = parent instanceof View ? (View) parent : null;
                        } else {
                            View rootView = zzg2.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float zza3 = zzcq.zza(rootView);
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i = size2 - 1;
                                    if (zzcq.zza((View) arrayList.get(i)) <= zza3) {
                                        break;
                                    }
                                    size2 = i;
                                }
                                arrayList.add(size2, rootView);
                            }
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i2 = 0; i2 < size3; i2++) {
            zzce.zza((View) arrayList.get(i2), this.zza, jSONObject, z2);
        }
    }
}
