package com.mbridge.msdk.dycreator.g;

import java.util.Map;

/* compiled from: ReportSubject */
public final class h extends a {
    public final void a(Object obj) {
        g gVar;
        if (this.a != null && this.a.size() > 0) {
            for (Map.Entry entry : this.a.entrySet()) {
                if (entry != null) {
                    try {
                        if (!(entry.getValue() == null || (gVar = (g) entry.getValue()) == null)) {
                            gVar.a(obj);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
