package com.bytedance.sdk.component.b.a.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.b;
import com.bytedance.sdk.component.b.a.d;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.b.a.l;

/* compiled from: NetClient */
public class c extends j {
    public d h = new d();

    public c(j.a aVar) {
        super(aVar);
    }

    public d a() {
        return this.h;
    }

    public b a(l lVar) {
        lVar.a(this);
        if (lVar == null || lVar.b() == null || lVar.b().a() == null || TextUtils.isEmpty(lVar.b().a().toString())) {
            return null;
        }
        a aVar = new a(lVar, this.h);
        this.h.c().add(aVar);
        return aVar;
    }
}
