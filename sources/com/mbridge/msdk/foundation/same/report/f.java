package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.report.b;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: DefaultReport */
public final class f implements o {
    public final void a(Context context, b.C0142b bVar, b bVar2, d dVar) throws Exception {
        if (bVar2 != null && dVar != null) {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(context);
            if (bVar2.l() == null) {
                new com.mbridge.msdk.foundation.same.net.b();
            }
            if (bVar2.j()) {
                if (!k.a().c() || TextUtils.isEmpty(bVar2.p())) {
                    aVar.postFocusReport(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, dVar, new a(context, bVar, bVar2, dVar));
                } else {
                    k.a().a(bVar2.p());
                }
            } else if (!k.a().c() || TextUtils.isEmpty(bVar2.p())) {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, dVar, new a(context, bVar, bVar2, dVar));
            } else {
                k.a().a(bVar2.p());
            }
            if (MBridgeConstans.DEBUG) {
                aa.a("CommonReport", "report: key = " + bVar2.i() + " retry = " + bVar2.k() + " isFocusReport = " + bVar2.j() + " isTimer = " + bVar2.o() + "\ndata = " + bVar2.p());
            }
        } else if (MBridgeConstans.DEBUG) {
            aa.d("CommonReport", "reportEvent or params or reportEvent is null");
        }
    }

    /* compiled from: DefaultReport */
    private static final class a extends com.mbridge.msdk.foundation.same.report.d.b {
        private final Context a;
        private final b.C0142b b;
        private final b c;
        private final d d;
        private final boolean e;

        private a(Context context, b.C0142b bVar, b bVar2, d dVar) {
            this.a = context;
            this.b = bVar;
            this.c = bVar2;
            this.d = dVar;
            this.e = bVar2.k();
        }

        public final void onSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                aa.a("CommonReport", "report success: " + str);
            }
        }

        public final void onFailed(String str) {
            if (MBridgeConstans.DEBUG) {
                aa.d("CommonReport", "report failed: " + str + " and isRetry = " + this.e);
            }
            b bVar = this.c;
            if (bVar != null && this.e && this.a != null) {
                final String p = bVar.p();
                if (!TextUtils.isEmpty(p)) {
                    final long q = this.c.q();
                    if (q <= 0) {
                        q = System.currentTimeMillis();
                    }
                    final Context context = this.a;
                    this.c.c().execute(new Runnable() {
                        public final void run() {
                            if (!TextUtils.isEmpty(p) && context != null) {
                                try {
                                    l lVar = new l();
                                    lVar.c(p);
                                    lVar.a(q);
                                    lVar.a(0);
                                    lVar.b("POST");
                                    lVar.a(com.mbridge.msdk.foundation.same.net.g.d.a().a);
                                    n.a((g) h.a(context)).a(lVar);
                                } catch (Exception e) {
                                    if (MBridgeConstans.DEBUG) {
                                        aa.d("CommonReport", "createReportDataThread error: " + e.getMessage());
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
