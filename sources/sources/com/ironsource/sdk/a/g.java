package com.ironsource.sdk.a;

import com.ironsource.mediationsdk.model.c;
import com.ironsource.mediationsdk.model.r;
import com.ironsource.mediationsdk.utils.b;
import com.ironsource.mediationsdk.utils.i;
import com.ironsource.mediationsdk.utils.n;
import com.ironsource.sdk.f.a;
import com.ironsource.sdk.g.d;

public class g {
    private d a;
    private r b;
    private n c;
    private boolean d;
    private a e;
    private b f;
    private c g;
    private i h;
    private com.ironsource.mediationsdk.model.b i;

    public g() {
        this.a = new d();
    }

    public g(d dVar, r rVar, n nVar, boolean z, a aVar, b bVar, c cVar, i iVar, com.ironsource.mediationsdk.model.b bVar2) {
        this.a = dVar;
        this.b = rVar;
        this.c = nVar;
        this.d = z;
        this.e = aVar;
        this.f = bVar;
        this.g = cVar;
        this.h = iVar;
        this.i = bVar2;
    }

    public static d.e a(com.ironsource.sdk.g.c cVar, d.e eVar) {
        return (cVar == null || cVar.d == null || cVar.d.get("rewarded") == null) ? eVar : Boolean.parseBoolean(cVar.d.get("rewarded")) ? d.e.RewardedVideo : d.e.c;
    }

    public static boolean a(com.ironsource.sdk.g.c cVar) {
        if (cVar == null || cVar.d.get("inAppBidding") == null) {
            return false;
        }
        return Boolean.parseBoolean(cVar.d.get("inAppBidding"));
    }

    public d a() {
        return this.a;
    }

    public r b() {
        return this.b;
    }

    public n c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public a e() {
        return this.e;
    }

    public b f() {
        return this.f;
    }

    public c g() {
        return this.g;
    }

    public i h() {
        return this.h;
    }

    public com.ironsource.mediationsdk.model.b i() {
        return this.i;
    }
}
