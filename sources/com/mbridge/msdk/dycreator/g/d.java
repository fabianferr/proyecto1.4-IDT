package com.mbridge.msdk.dycreator.g;

import java.util.Map;

/* compiled from: ConcreteSubject */
public final class d extends a {
    public final void a(Object obj) {
        i iVar;
        try {
            synchronized (this) {
                if (this.a != null && this.a.size() > 0) {
                    for (Map.Entry entry : this.a.entrySet()) {
                        if (!(entry == null || !(entry.getValue() instanceof i) || (iVar = (i) entry.getValue()) == null)) {
                            iVar.a(obj);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
