package com.bytedance.sdk.component.e.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.a.a.a.a;
import com.bytedance.sdk.component.e.a.a.a.a.b;
import com.bytedance.sdk.component.e.a.a.a.a.d;
import com.bytedance.sdk.component.e.a.a.a.a.e;
import com.bytedance.sdk.component.e.a.a.a.a.f;
import com.bytedance.sdk.component.e.a.a.a.a.g;
import com.bytedance.sdk.component.e.a.i;
import java.util.Iterator;
import java.util.List;

/* compiled from: DBCacheStrategy */
public class c implements d {
    private d a;
    private a b;
    private b c;
    private g d;
    private f e;
    private e f;
    private com.bytedance.sdk.component.e.a.d.b.a g;
    private com.bytedance.sdk.component.e.a.d.b.a h;
    private com.bytedance.sdk.component.e.a.d.b.a i;
    private com.bytedance.sdk.component.e.a.d.b.a j;
    private com.bytedance.sdk.component.e.a.d.b.a k;
    private com.bytedance.sdk.component.e.a.d.b.a l;

    public c() {
        Context d2 = i.e().d();
        if (com.bytedance.sdk.component.e.a.b.a.a()) {
            com.bytedance.sdk.component.e.a.d.b.a i2 = i.e().i();
            this.g = i2;
            this.a = new d(d2, i2);
        }
        if (com.bytedance.sdk.component.e.a.b.a.e()) {
            com.bytedance.sdk.component.e.a.d.b.a j2 = i.e().j();
            this.i = j2;
            this.c = new b(d2, j2);
        }
        if (com.bytedance.sdk.component.e.a.b.a.b()) {
            com.bytedance.sdk.component.e.a.d.b.a j3 = i.e().j();
            this.h = j3;
            this.b = new a(d2, j3);
        }
        if (com.bytedance.sdk.component.e.a.b.a.c()) {
            com.bytedance.sdk.component.e.a.d.b.a j4 = i.e().j();
            this.j = j4;
            this.d = new g(d2, j4);
        }
        if (com.bytedance.sdk.component.e.a.b.a.d()) {
            com.bytedance.sdk.component.e.a.d.b.a k2 = i.e().k();
            this.k = k2;
            this.e = new f(d2, k2);
        }
        if (com.bytedance.sdk.component.e.a.b.a.f()) {
            com.bytedance.sdk.component.e.a.d.b.a l2 = i.e().l();
            this.l = l2;
            this.f = new e(d2, l2);
        }
    }

    public void a(com.bytedance.sdk.component.e.a.d.a aVar, int i2) {
        if (aVar != null) {
            try {
                aVar.b(System.currentTimeMillis());
                if (aVar.d() == 0 && aVar.e() == 1) {
                    if (com.bytedance.sdk.component.e.a.b.a.a()) {
                        this.a.a(aVar);
                    }
                } else if (aVar.d() == 3 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.e()) {
                        this.c.a(aVar);
                    }
                } else if (aVar.d() == 0 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.b()) {
                        this.b.a(aVar);
                    }
                } else if (aVar.d() == 1 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.c()) {
                        this.d.a(aVar);
                    }
                } else if (aVar.d() == 1 && aVar.e() == 3) {
                    if (com.bytedance.sdk.component.e.a.b.a.d()) {
                        this.e.a(aVar);
                    }
                } else if (aVar.d() == 2 && aVar.e() == 3 && com.bytedance.sdk.component.e.a.b.a.f()) {
                    this.f.a(aVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.G(), 1);
            }
        }
    }

    public void a(int i2, List<com.bytedance.sdk.component.e.a.d.a> list) {
        com.bytedance.sdk.component.e.a.c.c.a("dbCache handleResult start");
        if (!(list == null || list.size() == 0 || list.get(0) == null)) {
            com.bytedance.sdk.component.e.a.d.a aVar = list.get(0);
            if (i2 == 200 || i2 == -1) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.X(), list.size());
                if (i2 != 200) {
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.Z(), list.size());
                }
                if (aVar.d() == 0 && aVar.e() == 1) {
                    if (com.bytedance.sdk.component.e.a.b.a.a()) {
                        this.a.b(list);
                    }
                } else if (aVar.d() == 3 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.e()) {
                        this.c.b(list);
                    }
                } else if (aVar.d() == 0 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.b()) {
                        this.b.b(list);
                    }
                } else if (aVar.d() == 1 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.c()) {
                        this.d.b(list);
                    }
                } else if (aVar.d() == 1 && aVar.e() == 3) {
                    if (com.bytedance.sdk.component.e.a.b.a.d()) {
                        this.e.b(list);
                    }
                } else if (aVar.d() == 2 && aVar.e() == 3 && com.bytedance.sdk.component.e.a.b.a.f()) {
                    this.f.b(list);
                }
            }
        }
        com.bytedance.sdk.component.e.a.c.c.a("dbCache handleResult end");
    }

    public List<com.bytedance.sdk.component.e.a.d.a> b(com.bytedance.sdk.component.e.a.d.a aVar, int i2) {
        if (aVar.d() != 0 || aVar.e() != 1 || !com.bytedance.sdk.component.e.a.b.a.a()) {
            if (aVar.d() == 3 && aVar.e() == 2 && com.bytedance.sdk.component.e.a.b.a.e()) {
                if (this.i.b() > i2) {
                    return this.c.a(this.i.b() - i2, "_id");
                }
            } else if (aVar.d() == 0 && aVar.e() == 2 && com.bytedance.sdk.component.e.a.b.a.b()) {
                if (this.h.b() > i2) {
                    List<com.bytedance.sdk.component.e.a.d.a> a2 = this.b.a(this.h.b() - i2, "_id");
                    if (!(a2 == null || a2.size() == 0)) {
                        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.B(), 1);
                    }
                    return a2;
                }
            } else if (aVar.d() == 1 && aVar.e() == 2 && com.bytedance.sdk.component.e.a.b.a.c()) {
                if (this.j.b() > i2) {
                    List<com.bytedance.sdk.component.e.a.d.a> a3 = this.d.a(this.j.b() - i2, "_id");
                    if (!(a3 == null || a3.size() == 0)) {
                        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.C(), 1);
                    }
                    return a3;
                }
            } else if (aVar.d() == 1 && aVar.e() == 3 && com.bytedance.sdk.component.e.a.b.a.d()) {
                if (this.k.b() > i2) {
                    List<com.bytedance.sdk.component.e.a.d.a> a4 = this.e.a(this.k.b() - i2, "_id");
                    if (!(a4 == null || a4.size() == 0)) {
                        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.D(), 1);
                    }
                    return a4;
                }
            } else if (aVar.d() == 2 && aVar.e() == 3 && com.bytedance.sdk.component.e.a.b.a.f() && this.l.b() > i2) {
                return this.f.a(this.l.b() - i2, "_id");
            }
            return null;
        } else if (this.g.b() <= i2) {
            return null;
        } else {
            List<com.bytedance.sdk.component.e.a.d.a> a5 = this.a.a(this.g.b() - i2, "_id");
            if (!(a5 == null || a5.size() == 0)) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.A(), 1);
            }
            return a5;
        }
    }

    public List<com.bytedance.sdk.component.e.a.d.a> a(int i2, int i3, List<String> list) {
        if (com.bytedance.sdk.component.e.a.b.a.a()) {
            List<com.bytedance.sdk.component.e.a.d.a> a2 = this.a.a("_id");
            if (a(a2, list)) {
                com.bytedance.sdk.component.e.a.c.c.a("high db get size:" + a2.size());
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.w(), 1);
                return a2;
            }
        }
        if (com.bytedance.sdk.component.e.a.b.a.e()) {
            List<com.bytedance.sdk.component.e.a.d.a> a3 = this.c.a("_id");
            if (a(a3, list)) {
                com.bytedance.sdk.component.e.a.c.c.a("v3ad db get :" + a3.size());
                return a3;
            }
        }
        if (com.bytedance.sdk.component.e.a.b.a.b()) {
            List<com.bytedance.sdk.component.e.a.d.a> a4 = this.b.a("_id");
            if (a(a4, list)) {
                com.bytedance.sdk.component.e.a.c.c.a("adevent db get :" + a4.size());
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.x(), 1);
                return a4;
            }
        }
        if (com.bytedance.sdk.component.e.a.b.a.c()) {
            List<com.bytedance.sdk.component.e.a.d.a> a5 = this.d.a("_id");
            if (a(a5, list)) {
                com.bytedance.sdk.component.e.a.c.c.a("real stats db get :" + a5.size());
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.y(), 1);
                return a5;
            }
        }
        if (com.bytedance.sdk.component.e.a.b.a.d()) {
            List<com.bytedance.sdk.component.e.a.d.a> a6 = this.e.a("_id");
            if (a(a6, list)) {
                com.bytedance.sdk.component.e.a.c.c.a("batch db get :" + a6.size());
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.z(), 1);
                return a6;
            }
        }
        if (!com.bytedance.sdk.component.e.a.b.a.f()) {
            return null;
        }
        List<com.bytedance.sdk.component.e.a.d.a> a7 = this.f.a("_id");
        if (!a(a7, list)) {
            return null;
        }
        com.bytedance.sdk.component.e.a.c.c.a("other db get :" + a7.size());
        return a7;
    }

    private boolean a(List<com.bytedance.sdk.component.e.a.d.a> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.e.a.d.a> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.e.a.d.a next = it.next();
                    if (next != null) {
                        String c2 = next.c();
                        if (!TextUtils.isEmpty(c2) && list2.contains(c2)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.e.a.c.c.b("DBCacheStrategy", "deleteMemList: " + th.getMessage());
            }
        }
        return list != null && !list.isEmpty();
    }

    public boolean a(int i2, boolean z) {
        e eVar;
        f fVar;
        g gVar;
        a aVar;
        b bVar;
        d dVar;
        if (com.bytedance.sdk.component.e.a.b.a.a() && (dVar = this.a) != null && dVar.a(i2)) {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.n(), 1);
            return true;
        } else if (com.bytedance.sdk.component.e.a.b.a.e() && (bVar = this.c) != null && bVar.a(i2)) {
            return true;
        } else {
            if (com.bytedance.sdk.component.e.a.b.a.b() && (aVar = this.b) != null && aVar.a(i2)) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.o(), 1);
                return true;
            } else if (com.bytedance.sdk.component.e.a.b.a.c() && (gVar = this.d) != null && gVar.a(i2)) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.p(), 1);
                return true;
            } else if (com.bytedance.sdk.component.e.a.b.a.d() && (fVar = this.e) != null && fVar.a(i2)) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.q(), 1);
                return true;
            } else if (!com.bytedance.sdk.component.e.a.b.a.f() || (eVar = this.f) == null || !eVar.a(i2)) {
                return false;
            } else {
                return true;
            }
        }
    }
}
