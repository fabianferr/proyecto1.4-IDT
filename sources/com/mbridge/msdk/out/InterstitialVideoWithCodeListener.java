package com.mbridge.msdk.out;

import com.mbridge.msdk.f.a;
import com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener;

public abstract class InterstitialVideoWithCodeListener implements InterstitialVideoListener {
    public abstract void onShowFailWithCode(MBridgeIds mBridgeIds, int i, String str);

    public abstract void onVideoLoadFailWithCode(MBridgeIds mBridgeIds, int i, String str);

    public void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        onVideoLoadFailWithCode(mBridgeIds, a.a(3000, str), str);
    }

    public void onShowFail(MBridgeIds mBridgeIds, String str) {
        onShowFailWithCode(mBridgeIds, 3900, str);
    }
}
