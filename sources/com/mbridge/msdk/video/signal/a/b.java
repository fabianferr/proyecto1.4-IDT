package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: DefaultJSBTModule */
public class b implements com.mbridge.msdk.video.signal.b {
    private static final String a = "b";

    public void click(int i, String str) {
        aa.a(a, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
    }

    public void handlerH5Exception(int i, String str) {
        aa.a(a, "handlerH5Exception");
    }

    public void reactDeveloper(Object obj, String str) {
        aa.a(a, "reactDeveloper");
    }

    public void reportUrls(Object obj, String str) {
        aa.a(a, "reportUrls");
    }
}
