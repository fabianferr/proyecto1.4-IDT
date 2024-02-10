package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.b.b.b;

public class d implements Comparable<d> {
    private final String a;
    private final String b;
    private final boolean c;
    private final b d;

    d(String str, String str2, boolean z, b bVar) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = bVar;
    }

    /* renamed from: a */
    public int compareTo(d dVar) {
        return this.b.compareToIgnoreCase(dVar.b);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public b c() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.a;
        if (str == null ? dVar.a != null : !str.equals(dVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? dVar.b == null : str2.equals(dVar.b)) {
            return this.c == dVar.c;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + (this.c ? 1 : 0);
    }
}
