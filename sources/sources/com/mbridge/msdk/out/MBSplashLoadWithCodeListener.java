package com.mbridge.msdk.out;

import com.mbridge.msdk.f.a;

public abstract class MBSplashLoadWithCodeListener implements MBSplashLoadListener {
    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i, String str, int i2);

    public void onLoadFailed(MBridgeIds mBridgeIds, String str, int i) {
        onLoadFailedWithCode(mBridgeIds, a.a(5000, str), str, i);
    }
}
