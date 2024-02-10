package com.mbridge.msdk.out;

import com.mbridge.msdk.f.a;
import com.mbridge.msdk.out.NativeListener;

public abstract class NativeAdWithCodeListener implements NativeListener.NativeAdListener {
    public abstract void onAdLoadErrorWithCode(int i, String str);

    public void onAdLoadError(String str) {
        onAdLoadErrorWithCode(a.a(1000, str), str);
    }
}
