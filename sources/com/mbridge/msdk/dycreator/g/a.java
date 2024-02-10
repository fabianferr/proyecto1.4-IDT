package com.mbridge.msdk.dycreator.g;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BaseAbstractSubject */
public abstract class a extends com.mbridge.msdk.dycreator.c.a {
    protected ConcurrentHashMap<Integer, Object> a = new ConcurrentHashMap<>();
    private List<Object> b = new ArrayList();

    public final synchronized void a(Object obj, int i) {
        if (obj != null) {
            ConcurrentHashMap<Integer, Object> concurrentHashMap = this.a;
            if (concurrentHashMap != null && !concurrentHashMap.containsValue(obj)) {
                this.a.put(Integer.valueOf(i), obj);
            }
        }
    }

    public final synchronized void a() {
        this.a.clear();
    }
}
