package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class r {
    public static final r a = new r();
    protected String b;
    protected final List<r> c;
    private final r d;
    private final String e;
    private final Map<String, String> f;

    private r() {
        this.d = null;
        this.e = "";
        this.f = Collections.emptyMap();
        this.b = "";
        this.c = Collections.emptyList();
    }

    public r(String str, Map<String, String> map, r rVar) {
        this.d = rVar;
        this.e = str;
        this.f = Collections.unmodifiableMap(map);
        this.c = new ArrayList();
    }

    public String a() {
        return this.e;
    }

    public List<r> a(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.c.size());
            for (r next : this.c) {
                if (str.equalsIgnoreCase(next.a())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    public r b(String str) {
        if (str != null) {
            for (r next : this.c) {
                if (str.equalsIgnoreCase(next.a())) {
                    return next;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    public Map<String, String> b() {
        return this.f;
    }

    public r c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        } else if (this.c.size() <= 0) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            while (!arrayList.isEmpty()) {
                r rVar = (r) arrayList.get(0);
                arrayList.remove(0);
                if (str.equalsIgnoreCase(rVar.a())) {
                    return rVar;
                }
                arrayList.addAll(rVar.d());
            }
            return null;
        }
    }

    public String c() {
        return this.b;
    }

    public List<r> d() {
        return Collections.unmodifiableList(this.c);
    }

    public String toString() {
        return "XmlNode{elementName='" + this.e + "', text='" + this.b + "', attributes=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
