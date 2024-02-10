package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SubBranchInterceptor */
public abstract class l<IN, OUT> extends d<IN, OUT> {
    Map<String, a> g;

    l() {
    }

    static boolean a(List<h> list) {
        if (!list.isEmpty() && list.get(list.size() - 1).a == f.class) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void a(Object... objArr) {
        Map<String, a> map;
        super.a(objArr);
        if (objArr == null || objArr.length != 1 || (map = objArr[0]) == null) {
            throw new IllegalStateException("args error");
        }
        try {
            this.g = map;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* compiled from: SubBranchInterceptor */
    public static final class b {
        private Map<String, a> a = new HashMap();
        private com.bykv.vk.openvk.preload.b.b.a b;

        public final a a(String str) {
            if (!this.a.containsKey(str)) {
                a aVar = new a();
                this.a.put(str, aVar);
                return aVar;
            }
            throw new IllegalArgumentException("duplicated branch name");
        }

        public final h a(Class<? extends l> cls) {
            h.a a2 = new h.a().a(cls);
            a2.c = new Object[]{this.a};
            a2.b = this.b;
            return a2.a();
        }
    }

    /* compiled from: SubBranchInterceptor */
    public static final class a {
        List<h> a = new ArrayList();

        public final a a(h hVar) {
            this.a.add(hVar);
            return this;
        }

        public final a a(List<h> list) {
            this.a.addAll(list);
            return this;
        }
    }
}
