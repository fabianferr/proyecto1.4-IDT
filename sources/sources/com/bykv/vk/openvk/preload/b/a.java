package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.l;
import java.util.List;

/* compiled from: BranchInterceptor */
public abstract class a<IN, OUT> extends l<IN, OUT> {
    /* access modifiers changed from: protected */
    public abstract String a(IN in);

    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        new m(bVar);
        String a = a(in);
        l.a aVar = this.g.get(a);
        if (aVar != null) {
            List<h> list = aVar.a;
            Object a2 = c.a(list, ((i) bVar).a, this).a(in);
            if (!a(list)) {
                return a2;
            }
            return bVar.a(a2);
        }
        throw new IllegalArgumentException("can not found branch, branch name is：".concat(String.valueOf(a)));
    }
}
