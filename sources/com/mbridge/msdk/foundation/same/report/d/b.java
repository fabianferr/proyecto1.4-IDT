package com.mbridge.msdk.foundation.same.report.d;

import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.l;

/* compiled from: ReportResponseHandler */
public abstract class b extends f<String> {
    private static final String TAG = "b";

    public abstract void onFailed(String str);

    public abstract void onSuccess(String str);

    public void onSuccess(l<String> lVar) {
        if (lVar != null) {
            onSuccess((String) lVar.a);
        }
    }

    public void onError(a aVar) {
        onFailed(com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
    }
}
