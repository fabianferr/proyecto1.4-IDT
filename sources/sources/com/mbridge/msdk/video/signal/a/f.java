package com.mbridge.msdk.video.signal.a;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.video.signal.h;

/* compiled from: DefaultJSRewardVideoV1 */
public class f implements h {
    public String a() {
        aa.a("js", "getEndScreenInfo");
        return JsonUtils.EMPTY_JSON;
    }

    public void notifyCloseBtn(int i) {
        aa.a("js", "notifyCloseBtn,state=" + i);
    }

    public void toggleCloseBtn(int i) {
        aa.a("js", "toggleCloseBtn,state=" + i);
    }

    public void a(String str) {
        aa.a("js", "triggerCloseBtn,state=" + str);
    }

    public void b(String str) {
        aa.a("js", "setOrientation,landscape=" + str);
    }

    public void c(String str) {
        aa.a("js", "handlerPlayableException，msg=" + str);
    }
}
