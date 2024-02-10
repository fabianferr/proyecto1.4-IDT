package com.mbridge.msdk.out;

import com.mbridge.msdk.f.a;

public abstract class BannerAdWithCodeListener implements BannerAdListener {
    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i, String str);

    public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
        onLoadFailedWithCode(mBridgeIds, a.a(2000, str), str);
    }
}
