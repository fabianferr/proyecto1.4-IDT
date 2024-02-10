package com.pgl.ssdk.ces.out;

import android.content.Context;
import android.text.TextUtils;
import com.pgl.ssdk.ces.a;
import com.pgl.ssdk.ces.d;
import com.pgl.ssdk.y;
import java.util.HashMap;
import java.util.Map;

public class PglSSManager {
    private static volatile PglSSManager c;
    private final d a;
    private volatile int b = 0;

    private PglSSManager(Context context, PglSSConfig pglSSConfig) {
        this.a = d.a(context, pglSSConfig.getAppId(), pglSSConfig.getOVRegionType());
    }

    public static PglSSManager getInstance() {
        return c;
    }

    public static PglSSManager init(Context context, PglSSConfig pglSSConfig) {
        if (context == null && pglSSConfig == null) {
            return null;
        }
        if (c == null) {
            synchronized (PglSSManager.class) {
                if (c == null) {
                    c = new PglSSManager(context, pglSSConfig);
                }
            }
        }
        return c;
    }

    public Map getFeatureHash(String str, byte[] bArr) {
        d dVar = this.a;
        dVar.getClass();
        HashMap hashMap = new HashMap();
        String str2 = (String) a.meta(224, dVar.b, new Object[]{str, bArr});
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("X-Armors", str2);
        }
        return hashMap;
    }

    public String getToken() {
        this.a.getClass();
        return y.b();
    }

    public void reportNow(String str) {
        if (this.b % 5 == 0) {
            this.a.a(str);
        }
        this.b++;
    }

    public void setCustomInfo(HashMap hashMap) {
        this.a.a(hashMap);
    }

    public void setDeviceId(String str) {
        this.a.b(str);
    }
}
