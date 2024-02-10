package com.teragence.library;

import java.util.List;

public class v implements w {
    public u[] a(List<o5> list) {
        o5[] o5VarArr = new o5[list.size()];
        for (int i = 0; i < list.size(); i++) {
            o5VarArr[i] = list.get(i);
        }
        return a(o5VarArr);
    }

    public u[] a(o5... o5VarArr) {
        u[] uVarArr = new u[o5VarArr.length];
        for (int i = 0; i < o5VarArr.length; i++) {
            uVarArr[i] = new u(o5VarArr[i]);
        }
        return uVarArr;
    }
}
