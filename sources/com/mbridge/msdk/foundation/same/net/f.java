package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.same.net.g.c;
import com.mbridge.msdk.foundation.same.report.a.a;
import com.mbridge.msdk.foundation.tools.aa;
import org.json.JSONObject;

/* compiled from: Listener */
public class f<T> implements e<T> {
    public int adType = 0;
    private a mRequestTime = null;
    public String placementId = "";
    private long startTime;
    public String unitId = "";

    public void onCancel() {
    }

    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
    }

    public void onFinish() {
    }

    public void onNetworking() {
    }

    public void onProgressChange(long j, long j2) {
    }

    public void onRetry() {
    }

    public void onPreExecute() {
        this.startTime = System.currentTimeMillis();
    }

    public void onSuccess(l<T> lVar) {
        try {
            String str = b.d().h() + "_" + this.placementId + "_" + this.unitId + "_" + this.adType;
            aa.d("Listener", lVar.a + " " + str);
            if (lVar.a instanceof JSONObject) {
                c.a().a(str, ((JSONObject) lVar.a).optInt("status"), ((JSONObject) lVar.a).toString(), System.currentTimeMillis());
            }
            if (lVar.a instanceof String) {
                c.a().a(str, new JSONObject((String) lVar.a).optInt("status"), (String) lVar.a, System.currentTimeMillis());
            }
        } catch (Exception e) {
            aa.d("Listener", e.getMessage());
        }
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void calcRequestTime(long j) {
        a aVar = new a(new h());
        this.mRequestTime = aVar;
        aVar.b(this.unitId);
        this.mRequestTime.a(1);
        a aVar2 = this.mRequestTime;
        aVar2.a((j - this.startTime) + "");
    }

    public void saveRequestTime(int i) {
        a aVar = this.mRequestTime;
        if (aVar != null) {
            aVar.b(i);
            this.mRequestTime.a();
        }
    }

    public void saveHbState(int i) {
        a aVar = this.mRequestTime;
        if (aVar != null) {
            aVar.c(i);
        }
    }
}
