package com.mbridge.msdk.foundation.same.net.h;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: CampaignRequest */
public class a extends b {
    public a(Context context) {
        super(context);
    }

    public void addExtraParams(String str, d dVar) {
        try {
            int f = af.f();
            String g = af.g();
            if (dVar != null) {
                dVar.a("misk_spt", String.valueOf(f));
                if (!TextUtils.isEmpty(g)) {
                    dVar.a("misk_spt_det", g);
                }
            }
        } catch (Exception e) {
            aa.a("CampaignRequest", e.getMessage());
        } catch (Throwable th) {
            super.addExtraParams(str, dVar);
            throw th;
        }
        super.addExtraParams(str, dVar);
    }
}
