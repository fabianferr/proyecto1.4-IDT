package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzhr implements Continuation {
    public final /* synthetic */ zzhu zza;

    public /* synthetic */ zzhr(zzhu zzhu) {
        this.zza = zzhu;
    }

    public final Object then(Task task) {
        zzhu zzhu = this.zza;
        List<zzhk> list = (List) task.getResult();
        ArrayList arrayList = new ArrayList(list.size());
        for (zzhk zzhk : list) {
            Task zzc = zzhk.zzc();
            zzc.addOnFailureListener(new zzht(zzhu, zzhk));
            arrayList.add(zzc);
        }
        return arrayList;
    }
}
