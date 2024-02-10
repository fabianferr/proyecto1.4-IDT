package com.bytedance.sdk.component.b.a.a.a;

import com.bytedance.sdk.component.b.a.h;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.n;
import java.io.IOException;
import java.util.List;

/* compiled from: NetChain */
public class b implements h.a {
    List<h> a;
    l b;
    int c = 0;

    b(List<h> list, l lVar) {
        this.a = list;
        this.b = lVar;
    }

    public l a() {
        return this.b;
    }

    public n a(l lVar) throws IOException {
        this.b = lVar;
        int i = this.c + 1;
        this.c = i;
        if (i >= this.a.size()) {
            return null;
        }
        return this.a.get(this.c).a(this);
    }
}
