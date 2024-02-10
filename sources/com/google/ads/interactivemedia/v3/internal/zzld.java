package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzld extends zzmh {
    private final Activity zzi;
    private final View zzj;

    public zzld(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, View view, Activity activity) {
        super(zzkt, "mbu8cW3mmLF65+uxPszJ/yFca0Vqw1h2gL9KG1WetNQHGnUydLw9ClDsvXhGHRoh", "YeKWJBH3JO9OXf9XyJN3LZiVTB6AMAHxB+a33QL6FEY=", zzaf, i, 62);
        this.zzj = view;
        this.zzi = activity;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzj != null) {
            boolean booleanValue = ((Boolean) zznc.zzc().zzb(zznr.zzcl)).booleanValue();
            Object[] objArr = (Object[]) this.zzf.invoke((Object) null, new Object[]{this.zzj, this.zzi, Boolean.valueOf(booleanValue)});
            synchronized (this.zze) {
                this.zze.zzc(((Long) objArr[0]).longValue());
                this.zze.zze(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zze.zzd((String) objArr[2]);
                }
            }
        }
    }
}
