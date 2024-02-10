package com.mbridge.msdk.out;

import com.mbridge.msdk.f.a;

public abstract class NativeAdvancedAdWithCodeListener implements NativeAdvancedAdListener {
    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i, String str);

    public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
        onLoadFailedWithCode(mBridgeIds, a.a(6000, str), str);
    }
}
