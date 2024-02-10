package com.applovin.impl.mediation.debugger.ui.a;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.b.a.e;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

class b extends d {
    private final com.applovin.impl.mediation.debugger.b.a.a a;
    private final com.applovin.impl.mediation.debugger.b.a.b b;
    private final List<c> d = c();
    private final List<c> e = d();
    private final List<c> f = e();

    class a extends com.applovin.impl.mediation.debugger.ui.b.a.a {
        private final com.applovin.impl.mediation.debugger.b.a.b o;

        a(com.applovin.impl.mediation.debugger.b.a.b bVar, String str, boolean z) {
            super(bVar.a().c(), b.this.c);
            this.o = bVar;
            this.d = StringUtils.createSpannedString(bVar.a().b(), ViewCompat.MEASURED_STATE_MASK, 18, 1);
            this.e = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.c = z;
        }

        public com.applovin.impl.mediation.debugger.b.a.b a() {
            return this.o;
        }

        public boolean b() {
            return this.c;
        }

        public int c() {
            return -12303292;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$b  reason: collision with other inner class name */
    enum C0017b {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    b(com.applovin.impl.mediation.debugger.b.a.a aVar, com.applovin.impl.mediation.debugger.b.a.b bVar, Context context) {
        super(context);
        this.a = aVar;
        this.b = bVar;
        notifyDataSetChanged();
    }

    private List<c> c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(f());
        arrayList.add(g());
        if (this.b != null) {
            arrayList.add(h());
        }
        return arrayList;
    }

    private List<c> d() {
        com.applovin.impl.mediation.debugger.b.a.b bVar = this.b;
        if (bVar != null && !bVar.c()) {
            return new ArrayList();
        }
        List<com.applovin.impl.mediation.debugger.b.a.b> a2 = this.a.e().a();
        ArrayList arrayList = new ArrayList(a2.size());
        for (com.applovin.impl.mediation.debugger.b.a.b next : a2) {
            com.applovin.impl.mediation.debugger.b.a.b bVar2 = this.b;
            if (bVar2 == null || bVar2.a().a().equals(next.a().a())) {
                arrayList.add(new a(next, next.b() != null ? next.b().a() : "", this.b == null));
            }
        }
        return arrayList;
    }

    private List<c> e() {
        com.applovin.impl.mediation.debugger.b.a.b bVar = this.b;
        if (bVar != null && bVar.c()) {
            return new ArrayList();
        }
        List<com.applovin.impl.mediation.debugger.b.a.b> b2 = this.a.e().b();
        ArrayList arrayList = new ArrayList(b2.size());
        for (com.applovin.impl.mediation.debugger.b.a.b next : b2) {
            com.applovin.impl.mediation.debugger.b.a.b bVar2 = this.b;
            if (bVar2 == null || bVar2.a().a().equals(next.a().a())) {
                arrayList.add(new a(next, (String) null, this.b == null));
                for (e next2 : next.d()) {
                    arrayList.add(c.p().a(next2.a()).b(next2.b()).b(true).a());
                }
            }
        }
        return arrayList;
    }

    private c f() {
        return c.p().a("ID").b(this.a.a()).a();
    }

    private c g() {
        return c.p().a("Ad Format").b(this.a.c()).a();
    }

    private c h() {
        return c.p().a("Selected Network").b(this.b.a().b()).a();
    }

    /* access modifiers changed from: protected */
    public int a(int i) {
        return (i == C0017b.INFO.ordinal() ? this.d : i == C0017b.BIDDERS.ordinal() ? this.e : this.f).size();
    }

    public String a() {
        return this.a.b();
    }

    /* access modifiers changed from: protected */
    public int b() {
        return C0017b.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public c b(int i) {
        return i == C0017b.INFO.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("INFO") : i == C0017b.BIDDERS.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("BIDDERS") : new com.applovin.impl.mediation.debugger.ui.d.e("WATERFALL");
    }

    /* access modifiers changed from: protected */
    public List<c> c(int i) {
        return i == C0017b.INFO.ordinal() ? this.d : i == C0017b.BIDDERS.ordinal() ? this.e : this.f;
    }
}
