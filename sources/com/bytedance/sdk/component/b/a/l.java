package com.bytedance.sdk.component.b.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Request */
public abstract class l {
    public j a;

    public abstract Object a();

    public abstract g b();

    public abstract String c();

    public abstract Map<String, List<String>> d();

    public abstract a e();

    public m f() {
        return null;
    }

    public void a(j jVar) {
        this.a = jVar;
    }

    public a g() {
        return new a(this);
    }

    /* compiled from: Request */
    public static class a {
        a a;
        Map<String, List<String>> b;
        g c;
        String d;
        Object e;
        m f;

        public a() {
            this.b = new HashMap();
        }

        public a a(a aVar) {
            this.a = aVar;
            return this;
        }

        a(l lVar) {
            this.c = lVar.b();
            this.d = lVar.c();
            this.b = lVar.d();
            this.e = lVar.a();
            this.f = lVar.f();
            this.a = lVar.e();
        }

        public a a(Object obj) {
            this.e = obj;
            return this;
        }

        public a a(String str) {
            return a(g.c(str));
        }

        public a a(g gVar) {
            this.c = gVar;
            return this;
        }

        public a a(String str, String str2) {
            return b(str, str2);
        }

        public a b(String str, String str2) {
            if (!this.b.containsKey(str)) {
                this.b.put(str, new ArrayList());
            }
            this.b.get(str).add(str2);
            return this;
        }

        public a a() {
            return a("GET", (m) null);
        }

        private a a(String str, m mVar) {
            this.d = str;
            this.f = mVar;
            return this;
        }

        public a a(m mVar) {
            return a("POST", mVar);
        }

        public l b() {
            return new l() {
                public String toString() {
                    return "";
                }

                public Object a() {
                    return a.this.e;
                }

                public g b() {
                    return a.this.c;
                }

                public String c() {
                    return a.this.d;
                }

                public Map d() {
                    return a.this.b;
                }

                public a e() {
                    return a.this.a;
                }

                public m f() {
                    return a.this.f;
                }
            };
        }
    }
}
