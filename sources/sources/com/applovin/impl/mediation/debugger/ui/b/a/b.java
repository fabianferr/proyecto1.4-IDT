package com.applovin.impl.mediation.debugger.ui.b.a;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.sdk.j;

public class b extends c {
    private final j.a a;
    private final Context o;
    private final boolean p;

    public b(j.a aVar, boolean z, Context context) {
        super(c.b.RIGHT_DETAIL);
        this.a = aVar;
        this.o = context;
        this.d = new SpannedString(aVar.a());
        this.p = z;
    }

    public boolean b() {
        return true;
    }

    public SpannedString c_() {
        return new SpannedString(this.a.b(this.o));
    }

    public boolean d_() {
        Boolean a2 = this.a.a(this.o);
        if (a2 != null) {
            return a2.equals(Boolean.valueOf(this.p));
        }
        return false;
    }
}
