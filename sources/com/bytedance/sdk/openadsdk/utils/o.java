package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NetUtils */
public class o {
    public static void a(SSWebView sSWebView, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", TTAdConstant.REQUEST_HEAD_REFERER);
        sSWebView.a(str, (Map<String, String>) hashMap);
    }
}
