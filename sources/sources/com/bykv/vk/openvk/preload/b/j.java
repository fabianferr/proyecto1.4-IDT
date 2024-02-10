package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.i;
import com.bykv.vk.openvk.preload.b.l;
import java.util.List;

/* compiled from: RetryBranchInterceptor */
public abstract class j<IN, OUT> extends l<IN, OUT> {
    private String h;

    /* access modifiers changed from: protected */
    public abstract String a(IN in);

    /* access modifiers changed from: protected */
    public abstract String a(IN in, Throwable th, String str);

    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        new m(bVar);
        this.h = a(in);
        l.a aVar = this.g.get(this.h);
        while (aVar != null) {
            List<h> list = aVar.a;
            try {
                Object a = c.a(list, ((i) bVar).a, this).a(in);
                if (!a(list)) {
                    return a;
                }
                return bVar.a(a);
            } catch (i.a e) {
                Throwable cause = e.getCause();
                new m(bVar);
                this.h = a(in, cause, this.h);
                aVar = this.g.get(this.h);
            } catch (Throwable th) {
                new m(bVar);
                this.h = a(in, th, this.h);
                aVar = this.g.get(this.h);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.h);
    }
}
