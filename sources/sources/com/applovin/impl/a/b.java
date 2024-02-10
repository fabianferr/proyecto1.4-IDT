package com.applovin.impl.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {
    private final String a;
    private final List<g> b;
    private final String c;
    private final Set<j> d;

    private b(String str, List<g> list, String str2, Set<j> set) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = set;
    }

    public static b a(r rVar, e eVar, m mVar) {
        try {
            String str = rVar.b().get("vendor");
            r c2 = rVar.c("VerificationParameters");
            String c3 = c2 != null ? c2.c() : null;
            List<r> a2 = rVar.a("JavaScriptResource");
            ArrayList arrayList = new ArrayList(a2.size());
            for (r a3 : a2) {
                g a4 = g.a(a3, mVar);
                if (a4 != null) {
                    arrayList.add(a4);
                }
            }
            Map map = CollectionUtils.map();
            l.a(rVar, (Map<String, Set<j>>) map, eVar, mVar);
            return new b(str, arrayList, c3, (Set) map.get("verificationNotExecuted"));
        } catch (Throwable th) {
            if (u.a()) {
                mVar.A().b("VastAdVerification", "Error occurred while initializing", th);
            }
            return null;
        }
    }

    public String a() {
        return this.a;
    }

    public List<g> b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Set<j> d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.a;
        if (str == null ? bVar.a != null : !str.equals(bVar.a)) {
            return false;
        }
        List<g> list = this.b;
        if (list == null ? bVar.b != null : !list.equals(bVar.b)) {
            return false;
        }
        String str2 = this.c;
        if (str2 == null ? bVar.c != null : !str2.equals(bVar.c)) {
            return false;
        }
        Set<j> set = this.d;
        Set<j> set2 = bVar.d;
        return set != null ? set.equals(set2) : set2 == null;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<g> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<j> set = this.d;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.a + "'javascriptResources='" + this.b + "'verificationParameters='" + this.c + "'errorEventTrackers='" + this.d + "'}";
    }
}
