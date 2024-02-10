package com.mbridge.msdk.foundation.same.report.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.tools.w;

/* compiled from: CampaignRequestTimeUtil */
public final class a {
    private h a;
    private com.mbridge.msdk.foundation.db.h b = null;
    private Context c;

    public a(h hVar) {
        Context context;
        this.a = hVar;
        Context g = b.d().g();
        this.c = g;
        this.b = com.mbridge.msdk.foundation.db.h.a(g);
        if (this.a != null && (context = this.c) != null) {
            int r = w.r(context);
            this.a.d(r);
            this.a.c(w.a(this.c, r));
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a(str);
        }
    }

    public final void a(int i) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.b(i);
        }
    }

    public final void b(int i) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.c(i);
        }
    }

    public final void a() {
        if (this.a != null) {
            l.a((g) this.b).a(this.a);
        }
    }

    public final void b(String str) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.b(str);
        }
    }

    public final void c(int i) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.a(i);
        }
    }
}
