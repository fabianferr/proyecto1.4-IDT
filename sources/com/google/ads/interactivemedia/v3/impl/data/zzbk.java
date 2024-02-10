package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzbk {
    public abstract zzbn build();

    public zzbk friendlyObstructions(Collection<FriendlyObstruction> collection) {
        ArrayList arrayList = new ArrayList();
        for (FriendlyObstruction next : collection) {
            zzbl view = zzbm.builder().view(next.getView());
            view.purpose(next.getPurpose());
            view.detailedReason(next.getDetailedReason());
            arrayList.add(view.build());
        }
        return obstructions(arrayList);
    }

    public abstract zzbk obstructions(List<zzbm> list);
}
