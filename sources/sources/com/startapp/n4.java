package com.startapp;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Sta */
public class n4<T> {
    public volatile i2<Object> a;
    public volatile AtomicReference<Object> b;

    public n4(i2<T> i2Var) {
        this.a = i2Var;
    }

    public T a() {
        AtomicReference<Object> atomicReference = this.b;
        if (atomicReference == null) {
            synchronized (this) {
                atomicReference = this.b;
                if (atomicReference == null) {
                    i2<Object> i2Var = this.a;
                    Object obj = null;
                    this.a = null;
                    if (i2Var != null) {
                        obj = i2Var.a();
                    }
                    AtomicReference<Object> atomicReference2 = new AtomicReference<>(obj);
                    this.b = atomicReference2;
                    atomicReference = atomicReference2;
                }
            }
        }
        T t = atomicReference.get();
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }
}
