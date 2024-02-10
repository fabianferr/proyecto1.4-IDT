package com.mbridge.msdk.out;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.system.NoProGuard;
import com.umlaut.crowd.internal.v3;
import java.util.concurrent.ConcurrentHashMap;

public class CustomInfoManager implements NoProGuard {
    private static CustomInfoManager INSTANCE = null;
    private static String TAG = "CustomInfoManager";
    public static final int TYPE_BID = 6;
    public static final int TYPE_BIDLOAD = 7;
    public static final int TYPE_LOAD = 8;
    private ConcurrentHashMap<String, String> infoMap = new ConcurrentHashMap<>();

    private CustomInfoManager() {
    }

    public static synchronized CustomInfoManager getInstance() {
        CustomInfoManager customInfoManager;
        synchronized (CustomInfoManager.class) {
            if (INSTANCE == null) {
                synchronized (CustomInfoManager.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new CustomInfoManager();
                    }
                }
            }
            customInfoManager = INSTANCE;
        }
        return customInfoManager;
    }

    public void setCustomInfo(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            String a = u.a(str2);
            if (i == 6) {
                ConcurrentHashMap<String, String> concurrentHashMap = this.infoMap;
                concurrentHashMap.put(str + "_bid", a);
            } else if (i == 7) {
                ConcurrentHashMap<String, String> concurrentHashMap2 = this.infoMap;
                concurrentHashMap2.put(str + "_bidload", a);
            } else if (i == 8) {
                this.infoMap.put(str, a);
            }
        }
    }

    private String getCustomInfoByUnitId(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 6) {
            ConcurrentHashMap<String, String> concurrentHashMap = this.infoMap;
            return concurrentHashMap.get(str + "_bid");
        } else if (i != 7) {
            return i != 8 ? "" : this.infoMap.get(str);
        } else {
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.infoMap;
            return concurrentHashMap2.get(str + "_bidload");
        }
    }

    public String getCustomInfoByUnitId(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                String host = parse.getHost();
                String path = parse.getPath();
                if (!TextUtils.isEmpty(host)) {
                    if (host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("bid")) {
                        return getCustomInfoByUnitId(str, 6);
                    }
                }
                if (!TextUtils.isEmpty(host) && host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("load")) {
                    return getCustomInfoByUnitId(str, 7);
                }
                if (!TextUtils.isEmpty(path) && path.contains(v3.i)) {
                    return getCustomInfoByUnitId(str, 8);
                }
            }
        } catch (Throwable th) {
            aa.b(TAG, "Exception", th);
        }
        return "";
    }
}
