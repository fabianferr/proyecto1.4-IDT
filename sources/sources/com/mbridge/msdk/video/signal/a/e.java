package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.f;

/* compiled from: DefaultJSNotifyProxy */
public class e implements f {
    public void a(int i) {
        aa.a("DefaultJSNotifyProxy", "onVideoStatusNotify:" + i);
    }

    public void a(int i, String str) {
        aa.a("DefaultJSNotifyProxy", "onClick:" + i + ",pt:" + str);
    }

    public void a(MBridgeVideoView.a aVar) {
        aa.a("DefaultJSNotifyProxy", "onProgressNotify:" + aVar.toString());
    }

    public void a(Object obj) {
        aa.a("DefaultJSNotifyProxy", "onWebviewShow:" + obj);
    }

    public void a(int i, int i2, int i3, int i4) {
        aa.a("DefaultJSNotifyProxy", "showDataInfo");
    }
}
