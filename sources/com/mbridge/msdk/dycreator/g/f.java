package com.mbridge.msdk.dycreator.g;

import java.util.Map;

/* compiled from: EffectSubject */
public final class f extends a {
    public final void a(Object obj) {
        e eVar;
        if (this.a != null && this.a.size() > 0) {
            for (Map.Entry entry : this.a.entrySet()) {
                if (entry != null) {
                    try {
                        if (!(entry.getValue() == null || (eVar = (e) entry.getValue()) == null)) {
                            eVar.a(obj);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
