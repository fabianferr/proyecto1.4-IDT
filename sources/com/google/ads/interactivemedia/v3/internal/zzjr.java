package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzjr extends zzjq {
    protected zzjr(Context context, String str, boolean z) {
        super(context, str, z);
    }

    /* access modifiers changed from: protected */
    public final List zzo(zzkt zzkt, Context context, zzaf zzaf, zzy zzy) {
        if (zzkt.zzk() == null || !this.zzu) {
            return super.zzo(zzkt, context, zzaf, (zzy) null);
        }
        int zza = zzkt.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzo(zzkt, context, zzaf, (zzy) null));
        arrayList.add(new zzll(zzkt, "uJXK1isksbASyPiwtOvcbiJ9wKYHFm9MTmlJpAy0avewuNp1ihkySWK6uNDbUQhs", "WSMexOPcW8gihMBLWKRkvKiI89M8OtU49pyTbH1A0ec=", zzaf, zza, 24));
        return arrayList;
    }
}
