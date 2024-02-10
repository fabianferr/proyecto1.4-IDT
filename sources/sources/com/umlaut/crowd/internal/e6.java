package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.NetworkGenerations;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

class e6 implements Serializable, Cloneable {
    private static final long b = 6405495712876743661L;
    private ArrayList<d6> a = new ArrayList<>();

    /* access modifiers changed from: package-private */
    public d6[] a() {
        ArrayList<d6> arrayList = this.a;
        return (d6[]) arrayList.toArray(new d6[arrayList.size()]);
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        e6 e6Var = (e6) super.clone();
        e6Var.a = new ArrayList<>(this.a.size());
        Iterator<d6> it = this.a.iterator();
        while (it.hasNext()) {
            e6Var.a.add((d6) it.next().clone());
        }
        return e6Var;
    }

    public void a(String str, String str2, long j, long j2, NetworkGenerations networkGenerations, long j3, long j4, DRI dri, DWI dwi, q4 q4Var, ub ubVar, z zVar, n1 n1Var, e4 e4Var) {
        a(str, str2).a(j, j2, networkGenerations, j3, j4, dri, dwi, q4Var, ubVar, zVar, n1Var, e4Var);
    }

    private d6 a(String str, String str2) {
        for (int i = 0; i < this.a.size(); i++) {
            d6 d6Var = this.a.get(i);
            if (d6Var.a.equals(str) && d6Var.b.equals(str2)) {
                return d6Var;
            }
        }
        d6 d6Var2 = new d6();
        d6Var2.a = str;
        d6Var2.b = str2;
        this.a.add(d6Var2);
        return d6Var2;
    }
}
