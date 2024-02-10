package com.teragence.library;

import java.util.List;

public class j0 implements k0 {
    public i0[] a(List<v5> list) {
        v5[] v5VarArr = new v5[list.size()];
        for (int i = 0; i < list.size(); i++) {
            v5VarArr[i] = list.get(i);
        }
        return a(v5VarArr);
    }

    public i0[] a(v5... v5VarArr) {
        i0[] i0VarArr = new i0[v5VarArr.length];
        for (int i = 0; i < v5VarArr.length; i++) {
            i0VarArr[i] = new i0(v5VarArr[i]);
        }
        return i0VarArr;
    }
}
