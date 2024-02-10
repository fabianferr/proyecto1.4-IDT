package com.mbridge.msdk.newinterstitial.out;

import com.mbridge.msdk.f.a;
import com.mbridge.msdk.out.MBridgeIds;

public abstract class NewInterstitialWithCodeListener implements NewInterstitialListener {
    public abstract void onResourceLoadFailWithCode(MBridgeIds mBridgeIds, int i, String str);

    public abstract void onShowFailWithCode(MBridgeIds mBridgeIds, int i, String str);

    public void onResourceLoadFail(MBridgeIds mBridgeIds, String str) {
        onResourceLoadFailWithCode(mBridgeIds, a.a(3000, str), str);
    }

    public void onShowFail(MBridgeIds mBridgeIds, String str) {
        onShowFailWithCode(mBridgeIds, 3900, str);
    }
}
