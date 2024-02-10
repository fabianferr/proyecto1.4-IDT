package com.bykv.vk.openvk.preload.geckox.c;

import com.bykv.vk.openvk.preload.a.a;
import com.bykv.vk.openvk.preload.a.b.a.n;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.g;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/* compiled from: GsonUtil */
public final class b {
    private static b b = new b();
    public f a;

    private b() {
        a aVar;
        a aVar2;
        a aVar3;
        g gVar = new g();
        gVar.a(Boolean.class, new a());
        gVar.a(Boolean.TYPE, new a());
        ArrayList arrayList = new ArrayList(gVar.e.size() + gVar.f.size() + 3);
        arrayList.addAll(gVar.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(gVar.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        String str = gVar.h;
        int i = gVar.i;
        int i2 = gVar.j;
        if (str == null || "".equals(str.trim())) {
            if (!(i == 2 || i2 == 2)) {
                a aVar4 = new a(Date.class, i, i2);
                a aVar5 = new a(Timestamp.class, i, i2);
                a aVar6 = new a(java.sql.Date.class, i, i2);
                aVar3 = aVar4;
                aVar2 = aVar5;
                aVar = aVar6;
            }
            f fVar = r3;
            f fVar2 = new f(gVar.a, gVar.c, gVar.d, gVar.g, gVar.k, gVar.o, gVar.m, gVar.n, gVar.p, gVar.l, gVar.b, gVar.h, gVar.i, gVar.j, gVar.e, gVar.f, arrayList);
            this.a = fVar;
        }
        aVar3 = new a(Date.class, str);
        aVar2 = new a(Timestamp.class, str);
        aVar = new a(java.sql.Date.class, str);
        arrayList.add(n.a(Date.class, aVar3));
        arrayList.add(n.a(Timestamp.class, aVar2));
        arrayList.add(n.a(java.sql.Date.class, aVar));
        f fVar3 = fVar2;
        f fVar22 = new f(gVar.a, gVar.c, gVar.d, gVar.g, gVar.k, gVar.o, gVar.m, gVar.n, gVar.p, gVar.l, gVar.b, gVar.h, gVar.i, gVar.j, gVar.e, gVar.f, arrayList);
        this.a = fVar3;
    }

    public static b a() {
        return b;
    }
}
