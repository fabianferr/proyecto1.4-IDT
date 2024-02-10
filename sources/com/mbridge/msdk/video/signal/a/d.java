package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.g;

/* compiled from: DefaultJSContainerModule */
public class d implements e, g {
    public void configurationChanged(int i, int i2, int i3) {
    }

    public void showVideoClickView(int i) {
        aa.a("js", "showVideoClickView:" + i);
    }

    public void showEndcard(int i) {
        aa.a("js", "showEndcard,type=" + i);
    }

    public void showVideoEndCover() {
        aa.a("js", "showVideoEndCover");
    }

    public boolean endCardShowing() {
        aa.a("js", "endCardShowing");
        return true;
    }

    public boolean miniCardShowing() {
        aa.a("js", "miniCardShowing");
        return false;
    }

    public void notifyCloseBtn(int i) {
        aa.a("js", "notifyCloseBtn:state = " + i);
    }

    public void toggleCloseBtn(int i) {
        aa.a("js", "toggleCloseBtn:state=" + i);
    }

    public void readyStatus(int i) {
        aa.a("js", "readyStatus:isReady=" + i);
    }

    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        aa.a("js", "showMiniCard top = " + i + " left = " + i2 + " width = " + i3 + " height = " + i4 + " radius = " + i5);
    }

    public void resizeMiniCard(int i, int i2, int i3) {
        aa.a("js", "showMiniCard width = " + i + " height = " + i2 + " radius = " + i3);
    }

    public boolean showAlertWebView() {
        aa.a("js", "showAlertWebView ,msg=");
        return false;
    }

    public void hideAlertWebview() {
        aa.a("js", "hideAlertWebview ,msg=");
    }

    public void ivRewardAdsWithoutVideo(String str) {
        aa.a("js", "ivRewardAdsWithoutVideo,params=");
    }
}
