package com.ironsource.mediationsdk.adunit.b;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

public final class g extends f {
    public g(d dVar) {
        super(dVar);
    }

    public final void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        a(b.INIT_ENDED, hashMap);
    }

    public final void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_EXT1, str + "|" + str2);
        a(b.INIT_STARTED, hashMap);
    }
}
