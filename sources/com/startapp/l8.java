package com.startapp;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sta */
public class l8 implements Iterator<Throwable> {
    public Throwable a;
    public Throwable[] b;
    public int c;
    public boolean d;

    public l8(Throwable th) {
        this.a = th;
        this.b = th.getSuppressed();
    }

    /* renamed from: a */
    public Throwable next() {
        int i;
        Throwable th = this.a;
        boolean z = false;
        this.d = false;
        if (th != null) {
            this.a = th.getCause();
        } else {
            Throwable[] thArr = this.b;
            if (thArr != null && (i = this.c) < thArr.length) {
                if (i == 0) {
                    z = true;
                }
                this.d = z;
                this.c = i + 1;
                th = thArr[i];
            }
        }
        if (th != null) {
            return th;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasNext() {
        /*
            r2 = this;
            java.lang.Throwable r0 = r2.a
            if (r0 != 0) goto L_0x0010
            java.lang.Throwable[] r0 = r2.b
            if (r0 == 0) goto L_0x000e
            int r1 = r2.c
            int r0 = r0.length
            if (r1 >= r0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.l8.hasNext():boolean");
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
