package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.i;

/* compiled from: RetryInterceptor */
public abstract class k<IN, OUT> extends d<IN, OUT> {
    protected IN g;

    /* access modifiers changed from: protected */
    public abstract boolean a(Throwable th);

    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        this.g = in;
        try {
            return bVar.a(a());
        } catch (i.a e) {
            return a(bVar, e.getCause());
        } catch (Throwable th) {
            return a(bVar, th);
        }
    }

    private Object a(b<OUT> bVar, Throwable th) throws Throwable {
        while (a(th)) {
            try {
                return bVar.a(a());
            } catch (i.a e) {
                th = e.getCause();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public OUT a() {
        return this.g;
    }
}
