package com.mbridge.msdk.foundation.same.f;

import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: ReportTask */
public final class a implements Runnable {
    private String a;
    private String b;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(b.d().g()).post(0, d.a().a, q.a(this.a, b.d().g(), this.b), new com.mbridge.msdk.foundation.same.report.d.b() {
                public final void onSuccess(String str) {
                    aa.d("ReportTask", str);
                }

                public final void onFailed(String str) {
                    aa.d("ReportTask", str);
                }
            });
        } catch (Throwable th) {
            aa.d("ReportTask", th.getMessage());
        }
    }
}
