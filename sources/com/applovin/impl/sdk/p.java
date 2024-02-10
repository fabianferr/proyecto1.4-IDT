package com.applovin.impl.sdk;

import com.applovin.impl.sdk.utils.CollectionUtils;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class p {
    private final String a = UUID.randomUUID().toString();
    private final String b;
    private final Map<String, Object> c;
    private final long d;

    public p(String str, Map<String, String> map, Map<String, Object> map2) {
        this.b = str;
        Map<String, Object> map3 = CollectionUtils.map();
        this.c = map3;
        map3.putAll(map);
        map3.put("applovin_sdk_super_properties", map2);
        this.d = System.currentTimeMillis();
    }

    public String a() {
        return this.b;
    }

    public Map<String, Object> b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.d != pVar.d) {
            return false;
        }
        String str = this.b;
        if (str == null ? pVar.b != null : !str.equals(pVar.b)) {
            return false;
        }
        Map<String, Object> map = this.c;
        if (map == null ? pVar.c != null : !map.equals(pVar.c)) {
            return false;
        }
        String str2 = this.a;
        String str3 = pVar.a;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
    }

    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.c;
        int hashCode2 = map != null ? map.hashCode() : 0;
        long j = this.d;
        int i2 = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "Event{name='" + this.b + "', id='" + this.a + "', creationTimestampMillis=" + this.d + ", parameters=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
