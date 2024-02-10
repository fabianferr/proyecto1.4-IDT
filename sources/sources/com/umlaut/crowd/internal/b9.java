package com.umlaut.crowd.internal;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b9 implements AutoCloseable {
    private Selector a = Selector.open();
    private HashMap<SelectionKey, a9> b = new HashMap<>();
    private HashSet<a9> c = new HashSet<>();
    private Set<a9> d = new HashSet();

    private int l() throws IOException {
        this.c.clear();
        Iterator<SelectionKey> it = this.a.selectedKeys().iterator();
        while (it.hasNext()) {
            a9 a9Var = this.b.get(it.next());
            a9Var.m();
            if (a9Var.l()) {
                this.c.add(a9Var);
            }
            it.remove();
        }
        return this.c.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(long r7) throws java.io.IOException {
        /*
            r6 = this;
            java.nio.channels.Selector r0 = r6.a
            r0.selectNow()
            int r0 = r6.l()
            if (r0 != 0) goto L_0x003f
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 + r7
        L_0x0010:
            r2 = 0
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x001c
            java.nio.channels.Selector r2 = r6.a
            r2.selectNow()
            goto L_0x0030
        L_0x001c:
            if (r4 != 0) goto L_0x0029
            java.nio.channels.Selector r0 = r6.a
            r0.select()
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L_0x0030
        L_0x0029:
            if (r4 <= 0) goto L_0x0030
            java.nio.channels.Selector r2 = r6.a
            r2.select(r7)
        L_0x0030:
            int r2 = r6.l()
            if (r2 != 0) goto L_0x003e
            long r3 = java.lang.System.currentTimeMillis()
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0010
        L_0x003e:
            r0 = r2
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.b9.a(long):int");
    }

    public int b(long j) throws IOException {
        return a(j);
    }

    public void close() throws IOException {
        synchronized (this) {
            this.a.close();
            for (a9 a9Var : this.d) {
                a9Var.a.cancel();
            }
            this.d.clear();
            this.c.clear();
        }
    }

    public Selector g() {
        return this.a;
    }

    public Set<a9> h() {
        return Collections.unmodifiableSet(this.d);
    }

    public int i() throws IOException {
        return a(0);
    }

    public int j() throws IOException {
        return a(-1);
    }

    public Set<a9> k() {
        return this.c;
    }

    public Selector m() {
        return this.a.wakeup();
    }

    /* access modifiers changed from: package-private */
    public void b(a9 a9Var) {
        this.d.add(a9Var);
        this.b.put(a9Var.a, a9Var);
    }

    /* access modifiers changed from: package-private */
    public void a(a9 a9Var) {
        this.b.remove(a9Var.a);
        this.d.remove(a9Var);
    }
}
