package com.applovin.impl.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;

public class c {
    private final List<b> a;

    private c(List<b> list) {
        this.a = list;
    }

    public static c a(r rVar, c cVar, e eVar, m mVar) {
        List list;
        if (cVar != null) {
            try {
                list = cVar.a();
            } catch (Throwable th) {
                if (!u.a()) {
                    return null;
                }
                mVar.A().b("VastAdVerifications", "Error occurred while initializing", th);
                return null;
            }
        } else {
            list = new ArrayList();
        }
        for (r a2 : rVar.a("Verification")) {
            b a3 = b.a(a2, eVar, mVar);
            if (a3 != null) {
                list.add(a3);
            }
        }
        return new c(list);
    }

    public List<b> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.a.equals(((c) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.a + "'}";
    }
}
