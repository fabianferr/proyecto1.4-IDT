package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzho implements Continuation {
    public final /* synthetic */ zzhu zza;

    public /* synthetic */ zzho(zzhu zzhu) {
        this.zza = zzhu;
    }

    public final Object then(Task task) {
        List<Task> list = (List) task.getResult();
        ArrayList arrayList = new ArrayList(list.size());
        for (Task task2 : list) {
            if (task2.isSuccessful()) {
                arrayList.add(task2.getResult());
            }
        }
        return arrayList;
    }
}
